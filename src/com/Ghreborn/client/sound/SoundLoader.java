package com.Ghreborn.client.sound;

import java.io.File;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.Ghreborn.client.Main;
import com.Ghreborn.client.SignLink;

/**
 * Custom Sound System
 * @author Invision
 * @version 1.00
 **/
public class SoundLoader {

	/*
	 * Directory of your sound files
	 * format is WAV
	 */
	private static final String DIRECTORY = SignLink.findcachedir()+"/sounds/";

	/*
	 * Current volume state
	 * 36 chosen for default 50% volume state
	 */
	public static float settingModifier = 36f;
	
	/*
	 * Current volume state
	 */
	public static boolean isMuted;

	/*
	 * Clips
	 */
	private static Clip[] clipIndex = null;

	/*
	 * Get number of files in directory
	 */
	private static final int getDirectoryLength() {
		return new File(DIRECTORY).list().length;
	}

	/**
	 * Loads the sound clips into memory
	 * during startup to prevent lag if loading
	 * them during runtime.
	 **/
	public static void preloadSounds() {
		clipIndex = new Clip[getDirectoryLength()];
		int counter = 0;
		for (int i = 0; i < clipIndex.length; i++) {
			try {
				File f = new File(DIRECTORY+""+i+".wav");
				AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(f);
				clipIndex[i] = AudioSystem.getClip();
				clipIndex[i].open(audioInputStream);	
				counter++;
			} catch (MalformedURLException e) {
				System.out.println("Sound effect not found: "+i);
				e.printStackTrace();
				return;
			} catch (UnsupportedAudioFileException e) {
				System.out.println("Unsupported format for sound: "+i);
				return;
			} catch (LineUnavailableException e) {
				e.printStackTrace();
				return;
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}	
		}
		System.out.println("Succesfully loaded: "+counter+" custom sound clips.");
	}

	/**
	 * Plays a sound
	 * @param soundID - The ID of the sound
	 * @param loop - How many times to loop this sound
	 * @param distanceFromSource - The distance from the source in tiles
	 */
	public static void playSound(final int soundID, int loop, int distanceFromSource) {	

		try {
			if (!isMuted) {
			clipIndex[soundID].setFramePosition(0);
			applyVolumeSetting(clipIndex[soundID], getDistanceModifier(distanceFromSource)*settingModifier);
			clipIndex[soundID].start();	
			/* shows how to close line when clip is finished playing
			clipIndex[soundID].addLineListener(new LineListener() {
				public void update(LineEvent myLineEvent) {
					if (myLineEvent.getType() == LineEvent.Type.STOP)
						clipIndex[soundID].close();
				}
			});
			*/
			}
		} catch (Exception e) {
			System.out.println("Error please report: ");
			e.printStackTrace();
		}
	}

	/**
	 * Applies volume setting to the clip
	 * @param line - the Clip to adjust volume setting for
	 * @param volume - the volume percentage (0-100)
	 * @return - the volume with applied setting
	 */
	public static float applyVolumeSetting(Clip line, double volume) {
		System.out.println("Modifying volume to "+volume);
		if (volume > 100.0) volume = 100.0;
		if (volume >= 0.0) {
			FloatControl ctrl = null;
			try {
				ctrl = (FloatControl)(line.getControl(FloatControl.Type.MASTER_GAIN));
			} catch (IllegalArgumentException iax1) {
				try {
					ctrl = (FloatControl)(line.getControl(FloatControl.Type.VOLUME));
				} catch (IllegalArgumentException iax2) {
					System.out.println("Controls.setVolume() not supported.");
					return -1;
				}
			}
			float minimum = ctrl.getMinimum();
			float maximum = ctrl.getMaximum();
			float newValue = (float)(minimum + volume * (maximum - minimum) / 100.0F);
			//System.out.println("System min: " + minimum);
			//System.out.println("System max: " + maximum);			
			if (newValue <= ctrl.getMinimum())
				newValue = ctrl.getMinimum();
			if (newValue >= ctrl.getMaximum())
				newValue = ctrl.getMaximum();			

			ctrl.setValue(newValue);
			//System.out.println("Setting modifier = " + volume);
			//System.out.println("New value = " + newValue);
			return newValue;
		}
		return -1;
	}

	/**
	 * Calculates tile distance modifier
	 * @param tileDistance - distance in tiles from source
	 * @return - the distance modifier
	 */
	public static float getDistanceModifier(int tileDistance) {
		if (tileDistance <= 0) {
			tileDistance = 0;
		}
		if (tileDistance >= 10) {
			tileDistance = 10;
		}
		float distanceModifier = 0;
		if (tileDistance == 10)
			distanceModifier = 0.40f;
		if (tileDistance == 9)
			distanceModifier = 0.55f;
		if (tileDistance == 8)
			distanceModifier = 0.60f;
		if (tileDistance == 7)
			distanceModifier = 0.65f;
		if (tileDistance == 6)
			distanceModifier = 0.70f;
		if (tileDistance == 5)
			distanceModifier = 0.75f;
		if (tileDistance == 4)
			distanceModifier = 0.80f;
		if (tileDistance == 3)
			distanceModifier = 0.85f;
		if (tileDistance == 2)
			distanceModifier = 0.90f;
		if (tileDistance == 1)
			distanceModifier = 0.95f;
		if (tileDistance == 0)
			distanceModifier = 1.00f;

		return distanceModifier;
	}

}