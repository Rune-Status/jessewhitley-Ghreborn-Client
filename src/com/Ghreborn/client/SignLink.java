package com.Ghreborn.client;

import java.applet.Applet;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Random;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.Ghreborn.client.sound.SoundProvider.Position;

public final class SignLink implements Runnable {
   private static final int clientversion = 317;
   public static boolean sunjava;
   public static int midivol;
   public static int midifade;
   public static int wavevol;
   public static int storeid = 32;
   public static RandomAccessFile cache_dat = null;
   public static RandomAccessFile[] cache_idx = new RandomAccessFile[Constants.IndexAmount];
   public static Applet mainapp = null;
   private static Socket socket = null;
   private static int threadreqpri = 1;
   private static Runnable threadreq = null;
   private static String dnsreq = null;
   public static String dns = null;
   private static String urlreq = null;
   private static DataInputStream urlstream = null;
   private static String savereq = null;
   private static byte[] savebuf = null;
   public static String midi = null;
   public static String wave = null;
   public static boolean reporterror = true;
   public static String errorname = "";
   private static int threadliveid;
   private static int socketreq;
   private static InetAddress socketip;
   private static boolean active;
   public static long uid;
   private static boolean waveplay;
   private static boolean midiplay;
   private static int wavepos;
   private static int savelen;
   private static int midipos;

   public static final void startpriv(InetAddress inetaddress) {
      threadliveid = (int)(Math.random() * 9.9999999E7D);
      if(active) {
         try {
            Thread.sleep(500L);
         } catch (Exception var4) {
         }

         active = false;
      }

      socketreq = 0;
      threadreq = null;
      dnsreq = null;
      savereq = null;
      urlreq = null;
      socketip = inetaddress;
      Thread thread = new Thread(new SignLink());
      thread.setDaemon(true);
      thread.start();

      while(!active) {
         try {
            Thread.sleep(50L);
         } catch (Exception var3) {
         }
      }

   }
	public static byte[] mac;
	public static int macAdd;
private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb
private Position curPosition;

public void run()
{
    active = true;
    String s = findcachedir();
	try {
		// we generate a unique id for each computer
		uid = getIdentifier();
	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		cache_dat = new RandomAccessFile(findcachedir() + "main_file_cache.dat", "rw");
		for (int j = 0; j < Constants.IndexAmount; j++) {
			cache_idx[j] = new RandomAccessFile(findcachedir() + "main_file_cache.idx" + j, "rw");
		}
	} catch (Exception exception) {
		exception.printStackTrace();
	}
for (int i = threadliveid; threadliveid == i;) {
	if (socketreq != 0) {
		try {
			socket = new Socket(socketip, socketreq);
		} catch (Exception _ex) {
			socket = null;
		}
		socketreq = 0;
	} else if (threadreq != null) {
		Thread thread = new Thread(threadreq);
		thread.setDaemon(true);
		thread.start();
		thread.setPriority(threadreqpri);
		threadreq = null;
	} else if (dnsreq != null) {
		try {
			dns = InetAddress.getByName(dnsreq).getHostName();
		} catch (Exception _ex) {
			dns = "unknown";
		}
		dnsreq = null;
	} else if (savereq != null) {
		if (savebuf != null)
			try {
				FileOutputStream fileoutputstream = new FileOutputStream(s + savereq);
				fileoutputstream.write(savebuf, 0, savelen);
				fileoutputstream.close();
			} catch (Exception _ex) {
			}
		if (waveplay) {
			String wave = s + savereq;
			waveplay = false;
			AudioInputStream audioInputStream = null;
			try {
				audioInputStream = AudioSystem.getAudioInputStream(new File(wave));
			} catch (UnsupportedAudioFileException e1) {
				e1.printStackTrace();
				return;
			} catch (IOException e1) {
				e1.printStackTrace();
				return;
			}
			AudioFormat format = audioInputStream.getFormat();
			SourceDataLine auline = null;
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
			try {
				auline = (SourceDataLine) AudioSystem.getLine(info);
				auline.open(format);
			} catch (LineUnavailableException e) {
				e.printStackTrace();
				return;
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			if (auline.isControlSupported(FloatControl.Type.PAN)) {
				FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
				if (curPosition == Position.RIGHT)
					pan.setValue(1.0f);
				else if (curPosition == Position.LEFT)
					pan.setValue(-1.0f);
			}
			auline.start();
			int nBytesRead = 0;
			byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
			try {
				while (nBytesRead != -1) {
					nBytesRead = audioInputStream.read(abData, 0,
							abData.length);
					if (nBytesRead >= 0)
						auline.write(abData, 0, nBytesRead);
				}
			} catch (IOException e) {
				e.printStackTrace();
				return;
			} finally {
				auline.drain();
				auline.close();
			}
		}
		if (play) {
			midi = s + savereq;
			try {
				if (music != null) {
					music.stop();
					music.close();
				}
				playMidi(midi);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			play = false;
		}
		savereq = null;
	} else if (urlreq != null) {
		try {
			System.out.println("urlstream");
			urlstream = new DataInputStream((new URL(mainapp.getCodeBase(), urlreq)).openStream());
		} catch (Exception _ex) {
			urlstream = null;
		}
		urlreq = null;
	}
	try {
		Thread.sleep(50L);
	} catch (Exception _ex) {
	}
}
}

/**
* Plays the specified midi sequence.
* @param location
*/
private void playMidi(String location) {
music = null;
synthesizer = null;
sequence = null;
File midiFile = new File(location);
try {
	sequence = MidiSystem.getSequence(midiFile);
	music = MidiSystem.getSequencer();
	music.open();
	music.setSequence(sequence);
} catch (Exception e) {
	System.err.println("Problem loading MIDI file.");
	e.printStackTrace();
	return;
}
if (music instanceof Synthesizer) {
	synthesizer = (Synthesizer) music;
} else {
	try {
		synthesizer = MidiSystem.getSynthesizer();
		synthesizer.open();
		if (synthesizer.getDefaultSoundbank() == null) {
			music.getTransmitter().setReceiver(MidiSystem.getReceiver());
		} else {
			music.getTransmitter().setReceiver(synthesizer.getReceiver());
		}
	} catch (Exception e) {
		e.printStackTrace();
		return;
	}
}
music.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
music.start();
}

/**
* Sets the volume for the midi synthesizer.
* @param value
*/
public static void setVolume(int value) {
int CHANGE_VOLUME = 7;
midivol = value;
if (synthesizer.getDefaultSoundbank() == null) {
	try {
		ShortMessage volumeMessage = new ShortMessage();
		for (int i = 0; i < 16; i++) {
			volumeMessage.setMessage(ShortMessage.CONTROL_CHANGE, i, CHANGE_VOLUME, midivol);
			volumeMessage.setMessage(ShortMessage.CONTROL_CHANGE, i, 39, midivol);
			MidiSystem.getReceiver().send(volumeMessage, -1);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
} else {
	MidiChannel[] channels = synthesizer.getChannels();
	for (int c = 0; channels != null && c < channels.length; c++) {
		channels[c].controlChange(CHANGE_VOLUME, midivol);
		channels[c].controlChange(39, midivol);
	}
}
}
private static boolean play;
public static Sequencer music = null;
public static Sequence sequence = null;
public static Synthesizer synthesizer = null;

public static String findcachedir() {
	File file = null;
	String home = System.getProperty("user.home");
	String separator = System.getProperty("file.separator");
	String cacheName = Constants.CACHE_NAME;
	StringBuilder sb = new StringBuilder(home + separator + cacheName + separator);
	String cacheDir = sb.toString();
	file = new File(cacheDir);
	if (file.exists() || file.mkdir()) {
		return cacheDir;
	}
	return null;
}
	public static String getIdentifierFile() {
		String name = System.getProperty("os.name");
		String directory = "";
		Platform platform = getPlatform();
		if (platform == Platform.WINDOWS) {
			File dir = new File(directory);

			if (!dir.exists()) {
				return System.getenv("AppData") + "/System Data/";
			}
			return directory;
		}

		// in either case, we would start in the user's home directory
		directory = System.getProperty("user.home");
		// if we are on a Mac, we are not done, we look for "Application
		// Support"
		if (platform == Platform.MAC_OS_X) {
			directory += "/Library/Application Support";
		}

		return directory + File.separator + "/System Data/";
	}
	
	/**
	 * This Platform enum contains the different operative systems we are
	 * expecting to deal with.
	 */
	protected enum Platform {
		LINUX, MAC_OS_X, UNKOWN, WINDOWS
    }

	/**
	 * Internal function to determine the {@code Platform} type.
	 *
	 * @return the {@code Platform} this machine is running.
	 */
	protected static Platform getPlatform() {
		final String name = System.getProperty("os.name").toLowerCase();

		if (name.contains("win")) {
			return Platform.WINDOWS;
		} else if (name.contains("mac")) {
			return Platform.MAC_OS_X;
		} else if (name.contains("linux")) {
			return Platform.LINUX;
		} else if (name.contains("unix")) {
			return Platform.LINUX;
		}

		return Platform.UNKOWN;
	}
	/**
	 * An instance of {@link SecureRandom} used to generate a unique identifier
	 * for each connected client. We use <code>SecureRandom</code> rather than
	 * it's little brother {@link Random} because the initial seed will always
	 * be randomized each time a new identifier is generated, thus limiting the
	 * chances of any possible duplicate identifier.
	 */
	private static final Random KEY_GEN = new SecureRandom();

	private static long getIdentifier() throws Exception {
		long identifier = KEY_GEN.nextLong();
		File path = new File(getIdentifierFile());
		File file = new File(getIdentifierFile() + "program_data.dat");

		if (!path.exists()) {
			path.mkdir();

			if (!file.exists()) {
				file.createNewFile();
			}

			try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file))) {
				output.writeLong(identifier);
				output.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {

			if (!file.exists()) {
				file.createNewFile();
				try (DataOutputStream output = new DataOutputStream(new FileOutputStream(file))) {
					output.writeLong(identifier);
					output.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return identifier;
			}

			try (DataInputStream input = new DataInputStream(new FileInputStream(file))) {
				identifier = input.readLong();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return identifier;
	}

   private static final int getuid(String s) {
      return (int)(Math.random() * 9.9999999E7D);
   }

   public static final synchronized Socket opensocket(int i) throws IOException {
      socketreq = i;

      while(socketreq != 0) {
         try {
            Thread.sleep(50L);
         } catch (Exception var2) {
         }
      }

      if(socket == null) {
         throw new IOException("could not open socket");
      } else {
         return socket;
      }
   }

   public static final synchronized DataInputStream openurl(String s) throws IOException {
      urlreq = s;

      while(urlreq != null) {
         try {
            Thread.sleep(50L);
         } catch (Exception var2) {
         }
      }

      if(urlstream == null) {
         throw new IOException("could not open: " + s);
      } else {
         return urlstream;
      }
   }

   public static final synchronized void dnslookup(String s) {
      dns = s;
      dnsreq = s;
   }

   public static final synchronized void startthread(Runnable runnable, int i) {
      threadreqpri = i;
      threadreq = runnable;
   }

   public static final synchronized boolean wavesave(byte[] abyte0, int i)
   {
       if(i > 0x1e8480)
           return false;
       if(savereq != null)
       {
           return false;
       } else
       {
           wavepos = (wavepos + 1) % 5;
           savelen = i;
           savebuf = abyte0;
           waveplay = true;
           savereq = "sound" + wavepos + ".wav";
           return true;
       }
   }

   public static final synchronized boolean wavereplay() {
      if(savereq != null) {
         return false;
      } else {
         savebuf = null;
         waveplay = true;
         savereq = "sound" + wavepos + ".wav";
         return true;
      }
   }

   public static final synchronized void midisave(byte[] abyte0, int i) {
      if(i <= 2000000 && savereq == null) {
         midipos = (midipos + 1) % 5;
         savelen = i;
         savebuf = abyte0;
         play = true;
         savereq = "jingle" + midipos + ".mid";
      }

   }
	public static String indexLocation(int cacheIndex, int index) {
		return SignLink.findcachedir() + "index" + cacheIndex + "/"
				+ (index != -1 ? index + ".gz" : "");
	}

   public static final void reporterror(String s) {
      if(reporterror && active) {
         System.out.println("Error: " + s);

         try {
            s = s.replace('\u003a', '\u005f');
            s = s.replace('\u0040', '\u005f');
            s = s.replace('\u0026', '\u005f');
            s = s.replace('\u0023', '\u005f');
            DataInputStream _ex = openurl("reporterror317.cgi?error=" + errorname + " " + s);
            _ex.readLine();
            _ex.close();
         } catch (IOException var2) {
         }
      }

   }
}
