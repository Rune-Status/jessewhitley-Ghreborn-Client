package com.Ghreborn.client.net;

import com.Ghreborn.client.Constants;
import com.Ghreborn.client.Main;
import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.io.jaggrab.JagGrabConstants;
import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.link.NodeList;
import com.Ghreborn.client.link.NodeSubList;
import com.Ghreborn.client.net.OnDemandData;
import com.Ghreborn.client.net.OnDemandFetcherParent;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.zip.CRC32;
import java.util.zip.GZIPInputStream;

public class OnDemandFetcher extends OnDemandFetcherParent implements Runnable {
	
/*   private final boolean method549(int i, byte byte0, int j, byte[] abyte0) {
      if(abyte0 != null && abyte0.length >= 2) {
         int k = abyte0.length - 2;
         int l = ((abyte0[k] & 255) << 8) + (abyte0[k + 1] & 255);
         if(byte0 != 3) {
            running = !running;
         }

         aCRC32_1338.reset();
         aCRC32_1338.update(abyte0, 0, k);
         int i1 = (int)aCRC32_1338.getValue();
         return l != i?true:i1 == j;
      } else {
         return false;
      }
   }*/

   public int getAnimCount() {
      return anIntArray1360.length;
   }
	public String currentDownload = "";
	private String forId(int type) {
		switch(type) {
		case 1:
			return "Model";
		case 2:
			return "Animation";
		case 3:
			return "Sound";
		case 4: 
			return "Map";
		}
		return "";
	}
   private void readData() {
      try {
         int available = inputStream.available();
         if(expectedSize == 0 && available >= 10) {
            waiting = true;
            for(int skip = 0; skip < 10; skip += inputStream.read(payload, skip, 10 - skip))
               ;
			int type = payload[0] & 0xff;
			int file = ((payload[1] & 0xff) << 16) + ((payload[2] & 0xff) << 8) + (payload[3] & 0xff);
			int length = ((payload[4] & 0xff) << 32) + ((payload[5] & 0xff) << 16) + ((payload[6] & 0xff) << 8) + (payload[7] & 0xff);
			int sector = ((payload[8] & 0xff) << 8) + (payload[9] & 0xff);

            current = null;
            
            for(OnDemandData onDemandData = (OnDemandData)requested.reverseGetFirst(); onDemandData != null; onDemandData = (OnDemandData)requested.reverseGetNext()) {
               if(onDemandData.dataType == type && onDemandData.ID == file) 
                  current = onDemandData;
               if(current != null) 
            	   onDemandData.loopCycle = 0;
            }

            if(current != null) {
            	currentDownload = "Downloading "+forId(current.dataType + 1)+" "+current.ID+"";
               loopCycle = 0;
               if(length == 0) {
                  SignLink.reporterror("Rej: " + type + "," + file);
                  current.buffer = null;
                  if(current.incomplete) 
                     synchronized(aClass19_1358) {
                    	 aClass19_1358.insertHead(current);
                     }
                   else 
                     current.unlink();
                  current = null;
               } else {
                  if(current.buffer == null && sector == 0)
                     current.buffer = new byte[length];
                  if(current.buffer == null && sector != 0)
                     throw new IOException("missing start of file");
               }
            }

            completedSize = sector * JagGrabConstants.MAX_ONDEMAND_CHUNK_LENGTH_BYTES;
            expectedSize = JagGrabConstants.MAX_ONDEMAND_CHUNK_LENGTH_BYTES;
            if(expectedSize > length - sector * JagGrabConstants.MAX_ONDEMAND_CHUNK_LENGTH_BYTES)
               expectedSize = length - sector * JagGrabConstants.MAX_ONDEMAND_CHUNK_LENGTH_BYTES;
         }
         if(expectedSize > 0 && available >= expectedSize) {
            waiting = true;
            byte[] abyte0111 = payload;
            int i1 = 0;
            if(current != null) {
               abyte0111 = current.buffer;
               i1 = completedSize;
            }

            for(int k1 = 0; k1 < expectedSize; k1 += inputStream.read(abyte0111, k1 + i1, expectedSize - k1));
            if(expectedSize + completedSize >= abyte0111.length && current != null) {
               if(clientInstance.Indexes[0] != null)
                  clientInstance.Indexes[current.dataType + 1].method234(abyte0111.length, abyte0111, i1);
               if(!current.incomplete && current.dataType == 3) {
                  current.incomplete = true;
                  current.dataType = 93;
               }
               if(current.incomplete) 
                  synchronized(aClass19_1358) {
                	  aClass19_1358.insertHead(current);
                  }
                else 
                  current.unlink();
            }
            expectedSize = 0;
         }
      } catch (IOException ioexception) {
         try {
            socket.close();
         } catch (Exception _ex) {
        	 _ex.printStackTrace();
         }
         socket = null;
         inputStream = null;
         outputStream = null;
         expectedSize = 0;
      }

   }

   public void crcPack(int index, int index_length) {
      try {
         DataOutputStream var101 = new DataOutputStream(new FileOutputStream("./crc/" + index + "_crc"));
         DataOutputStream version_output = new DataOutputStream(new FileOutputStream("./crc/" + index + "_version"));

         for(int j = 0; j < index_length; ++j) {
            byte[] abyte0 = clientInstance.Indexes[index].decompress(j);
            if(abyte0 != null) {
               int k = abyte0.length - 2;
               int version = ((abyte0[k] & 255) << 8) + (abyte0[k + 1] & 255);
               aCRC32_1338.reset();
               aCRC32_1338.update(abyte0, 0, k);
               int crc = (int)aCRC32_1338.getValue();
               writeDWord(var101, crc);
               version_output.writeShort(version);
            } else {
               writeDWord(var101, 0);
               version_output.writeShort(0);
            }
         }
      } catch (Exception var10) {
         var10.printStackTrace();
      }

   }
   static int regionMax;
   public static void writeDWord(DataOutputStream dos, int i) {
      try {
         dos.writeByte((byte)(i >> 24));
         dos.writeByte((byte)(i >> 16));
         dos.writeByte((byte)(i >> 8));
         dos.writeByte((byte)i);
      } catch (IOException var3) {
      }

   }
   public static void updateMapIndex() throws IOException {
      try {
         DataOutputStream var2 = new DataOutputStream(new FileOutputStream("./map_index"));
         var2.writeShort(regionMax);

         for(int id = 0; id < regionMax; ++id) {
            var2.writeShort(mapIndices1[id]);
            var2.writeShort(mapIndices2[id]);
            var2.writeShort(mapIndices3[id]);
         }
         System.out.println("Packed Mapindex "+regionMax);
         var2.close();
      } catch (Exception var21) {
         var21.printStackTrace();
      }

   }
   public void start(StreamLoader class44, Main client1) {
	      byte[] abyte2 = class44.readFile("map_index");
	      Buffer stream2 = new Buffer(abyte2);
	      int j1 = stream2.readUnsignedWord();
	      mapIndices1 = new int[j1];
	      mapIndices2 = new int[j1];
	      mapIndices3 = new int[j1];

	      int k2;
	      for(k2 = 0; k2 < j1; ++k2) {
	         mapIndices1[k2] = stream2.readUnsignedWord();
	         mapIndices2[k2] = stream2.readUnsignedWord();
	         mapIndices3[k2] = stream2.readUnsignedWord();
	         //loadmaps();
	        // System.out.println(+k2+" RegionId: " + mapIndices1[k2] + " GroundId: "+  mapIndices2[k2]+" ObjectId: "+  mapIndices3[k2]);
	         //System.out.println(mapIndices1[k2] + " " + mapIndices2[k2] + " " + mapIndices3[k2]);
	         ++mapAmount;
	         //System.out.println(+j1+"RegionId: " + mapIndices2[j1] + "GroundId:"+  mapIndices3[j1]);
	      }
	     

	      System.out.println("Map Amount: " + mapAmount);
	       abyte2 = class44.readFile("midi_index");
	       stream2 = new Buffer(abyte2);
	       j1 = abyte2.length;
	      anIntArray1348 = new int[j1];

	      for(k2 = 0; k2 < j1; ++k2) {
	         anIntArray1348[k2] = stream2.readUnsignedByte();
	      }

	      clientInstance = client1;
	      running = true;
	      clientInstance.method12(this, 2);
	}
	public int[] file_amounts = new int[4];
    private final String[] crcNames = {"model_crc.dat", "anim_crc.dat", "midi_crc.dat", "map_crc.dat"};
	private final int[][] crcs = new int[crcNames.length][];
	
/*   public void start(StreamLoader class44, Main client1) {
		for(int i = 0; i < crcNames.length; i++) {
			byte[] crc_file = class44.readFile(crcNames[i]);
			int length = 0;

			if(crc_file != null) {
				length = crc_file.length / 4;
				Buffer crcStream = new Buffer(crc_file);
				crcs[i] = new int[length];
				fileStatus[i] = new byte[length];
				for(int ptr = 0; ptr < length; ptr++) {
					crcs[i][ptr] = crcStream.readInt();
				}
			} 
		}
   	String fileName = SignLink.findcachedir() + "map_index_custom.txt";
   	BufferedReader br;
   	try {
	    	FileInputStream fs = new FileInputStream(fileName);
	    	br = new BufferedReader(new InputStreamReader(fs));
	    	regionMax = countLines(fileName);
	    	mapIndices1 = new int[regionMax];
	    	mapIndices2 = new int[regionMax];
	    	mapIndices3 = new int[regionMax];
			file_amounts[3] = regionMax;
	    	for(int i2 = 0; i2 < regionMax; i2++) {
	    		String[] splitStr = br.readLine().split("\\s+");
	    		mapIndices1[i2] = Integer.parseInt(splitStr[0]);
	    		mapIndices2[i2] = Integer.parseInt(splitStr[1]);
	    		mapIndices3[i2] = Integer.parseInt(splitStr[2]);
	    		//System.out.println(mapIndices1[i2] + " " + mapIndices2[i2] + " " + mapIndices3[i2]);
	    	}
	    	//updateMapIndex();
      System.out.println("Map Amount: " + file_amounts[3] + "");
      byte[] abyte2 = class44.readFile("midi_index");
      Buffer stream2 = new Buffer(abyte2);
      int j1 = abyte2.length;
      file_amounts[2] = j1;
      anIntArray1348 = new int[j1];

      for(int k2 = 0; k2 < j1; ++k2) {
         anIntArray1348[k2] = stream2.readUnsignedByte();
      }
		System.out.println("Sounds Amount: " + file_amounts[2] + "");
		

		//For some reason, model_index = anim_index and vice versa
		abyte2 = class44.readFile("model_index");
		file_amounts[1] = abyte2.length;
		
		abyte2 = class44.readFile("anim_index");
		file_amounts[0] = abyte2.length;
		System.out.println("Model amount: "+file_amounts[0]);

		clientInstance = client1;
      running = true;
      clientInstance.method12(this, 2);
	} catch (Exception e) {
    	e.printStackTrace();
    }
}*/
   public int countLines(String fileName) throws IOException {
	    LineNumberReader reader = null;
	    try {
	        reader = new LineNumberReader(new FileReader(fileName));
	        while ((reader.readLine()) != null);
	        return reader.getLineNumber();
	    } catch (Exception ex) {
	        return -1;
	    } finally { 
	        if(reader != null) 
	            reader.close();
	    }
	}

   public int getNodeCount() {
      synchronized(nodeSubList) {
         return nodeSubList.getNodeCount();
      }
   }

   public void disable() {
      running = false;
   }

   public void method554(boolean flag) {
      int j = mapIndices1.length;
      for(int k = 0; k < j; ++k) {
         if(flag || anIntArray1356[k] != 0) {
        	 requestExtra((byte)2, 3, mapIndices3[k]);
        	 requestExtra((byte)2, 3, mapIndices2[k]);
         }
      }

   }

   public int getVersionCount(int j) {
      return 65565;
   }
   
   private  void closeRequest(OnDemandData onDemandData) {
      try {
         if(socket == null || !socket.isConnected()) {
            socket = Main.instance.openSocket(JagGrabConstants.FILE_SERVER_PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
         }

         payload[0] = JagGrabConstants.ONDEMAND_REQUEST_OPCODE;
			//Store data type as byte
         payload[1] = (byte) onDemandData.dataType;
			
			//Store file id as int
         payload[2] = (byte) (onDemandData.ID >> 24);
         payload[3] = (byte) (onDemandData.ID >> 16);
         payload[4] = (byte) (onDemandData.ID >> 8);
         payload[5] = (byte) onDemandData.ID;
         outputStream.write(payload, 0, 6);
         writeLoopCycle = 0;
         anInt1349 = -10000;
      } catch (IOException var7) {
      }
         try {
            socket.close();
         } catch (Exception var6) {
         }
         socket = null;
         inputStream = null;
         outputStream = null;
         expectedSize = 0;
         ++anInt1349;
      

   }
   public void method558(int i, int j) {
      synchronized(nodeSubList) {
         OnDemandData class30_sub2_sub3_1;
         for(class30_sub2_sub3_1 = (OnDemandData)nodeSubList.method152(); class30_sub2_sub3_1 != null; class30_sub2_sub3_1 = (OnDemandData)nodeSubList.method153(false)) {
            if(class30_sub2_sub3_1.dataType == i && class30_sub2_sub3_1.ID == j) {
               return;
            }
         }

         class30_sub2_sub3_1 = new OnDemandData();
         class30_sub2_sub3_1.dataType = i;
         class30_sub2_sub3_1.ID = j;
         class30_sub2_sub3_1.incomplete = true;
         synchronized(aClass19_1370) {
            aClass19_1370.insertHead(class30_sub2_sub3_1);
         }

         nodeSubList.method150(class30_sub2_sub3_1);
      }
   }

   public int getModelCount() {
      return 129191;
   }

   public int getModelIndex(int i) {
      return 38000;
   }
   public void run() {
               try {
            	   while (running) {
                  ++onDemandCycle;
                  int var81 = 20;
                  if(anInt1332 == 0 && clientInstance.Indexes[0] != null)
                     var81 = 50;
                  try {
                     Thread.sleep(var81);
                  } catch (Exception var6) {
                  }
                  waiting = true;
                  for(int var9 = 0; var9 < 100 && waiting; ++var9) {
  					if (!waiting)
						break;
  					checkReceived();
                     handleFailed();
                     if(uncompletedCount == 0 && var9 >= 5) {
                        break;
                     }

                     method568();
                     if(inputStream != null) {
                        readData();
                     }
                  }

                  boolean var91 = false;

                  OnDemandData _ex;
                  for(_ex = (OnDemandData)requested.reverseGetFirst(); _ex != null; _ex = (OnDemandData)requested.reverseGetNext()) {
                     if(_ex.incomplete) {
                        var91 = true;
                        ++_ex.loopCycle;
                        if(_ex.loopCycle > 50) {
                           _ex.loopCycle = 0;
                           closeRequest(_ex);
                        }
                     }
                  }

                  if(!var91) {
                     for(_ex = (OnDemandData)requested.reverseGetFirst(); _ex != null; _ex = (OnDemandData)requested.reverseGetNext()) {
                        var91 = true;
                        ++_ex.loopCycle;
                        if(_ex.loopCycle > 50) {
                           _ex.loopCycle = 0;
                           closeRequest(_ex);
                        }
                     }
                  }

                  if(var91) {
                     ++loopCycle;
                     if(loopCycle > 750) {
                        try {
                           socket.close();
                        } catch (Exception var5) {
                        }

                        socket = null;
                        inputStream = null;
                        outputStream = null;
                        expectedSize = 0;
                     }
                  } else {
                     loopCycle = 0;
                     aString1333 = "";
                  }

            	   }
               } catch (Exception var8) {
            	   var8.printStackTrace();
                  SignLink.reporterror("od_ex " + var8.getMessage());
               }
           

            return;
         
      
   }

   public void method560(int i, int j) {
      if(clientInstance.Indexes[0] == null)
    	  return;      
      	if(anInt1332 == 0)
    	  return;
         OnDemandData onDemandData = new OnDemandData();
         onDemandData.dataType = j;
         onDemandData.ID = i;
         onDemandData.incomplete = false;
         synchronized(aClass19_1344) {
            aClass19_1344.insertHead(onDemandData);
         }
      }

   

	public OnDemandData getNextNode() {
		OnDemandData onDemandData;
		synchronized (aClass19_1358) {
			onDemandData = (OnDemandData) aClass19_1358.popHead();
		}
		if (onDemandData == null)
			return null;
		synchronized (aClass19_1358) {
			onDemandData.unlinkSub();
		}
		if (onDemandData.buffer == null)
			return onDemandData;
		int i = 0;
		try {
			GZIPInputStream gzipinputstream = new GZIPInputStream(new ByteArrayInputStream(onDemandData.buffer));
			do {
				if (i == gzipInputBuffer.length)
					throw new RuntimeException("buffer overflow!");
				int k = gzipinputstream.read(gzipInputBuffer, i, gzipInputBuffer.length - i);
				if (k == -1)
					break;
				i += k;
			} while (true);
		} catch (IOException _ex) {
			// RuntimeException("error unzipping");
			//System.out.println("Failed to unzip model [" + onDemandData.ID + "] type = " + onDemandData.dataType);
			_ex.printStackTrace();
			return null;
		}
		onDemandData.buffer = new byte[i];
		System.arraycopy(gzipInputBuffer, 0, onDemandData.buffer, 0, i);

		return onDemandData;
	}

   public int method562(int i, int k, int l)
   {
       int i1 = (l << 8) + k;
       for(int j1 = 0; j1 < mapIndices1.length; j1++)
           if(mapIndices1[j1] == i1)
               if(i == 0)
                   return mapIndices2[j1];
               else
                   return mapIndices3[j1];

       return -1;
   }
   
	@Override
   public void method548(int i) {
      method558(0, i);
   }

	public void requestExtra(byte priority, int type, int file) {
		if (clientInstance.Indexes[0] == null)
			return;
		byte[] data = clientInstance.Indexes[type + 1].decompress(file);
		if(crcMatches(crcs[type][file], data))
			return;
		fileStatus[type][file] = priority;
		if (priority > anInt1332)
			anInt1332 = priority;
		totalFiles++;
	}


   public final boolean method564(int i) {
         for(int k = 0; k < mapIndices1.length; ++k) {
            if(mapIndices3[k] == i) {
               return true;
            }
         }

         return false;
      }
   

   private void handleFailed() {
      uncompletedCount = 0;
      completedCount = 0;

      OnDemandData class30_sub2_sub3_1;
      for(class30_sub2_sub3_1 = (OnDemandData)requested.reverseGetFirst(); class30_sub2_sub3_1 != null; class30_sub2_sub3_1 = (OnDemandData)requested.reverseGetNext())
			if (class30_sub2_sub3_1.incomplete) {
				uncompletedCount++;
				if(!Constants.JAGCACHED_ENABLED) {
					System.out.println("Error: model is incomplete or missing  [ type = " + class30_sub2_sub3_1.dataType + "]  [id = " + class30_sub2_sub3_1.ID + "]");
				}
			} else
				completedCount++;

      while(uncompletedCount < 10) {
            class30_sub2_sub3_1 = (OnDemandData)aClass19_1368.popHead();
            if(class30_sub2_sub3_1 == null) {
               break;
            }
            try {
            if(fileStatus[class30_sub2_sub3_1.dataType][class30_sub2_sub3_1.ID] != 0) {
               ++anInt1351;
            }

            fileStatus[class30_sub2_sub3_1.dataType][class30_sub2_sub3_1.ID] = 0;
            requested.insertHead(class30_sub2_sub3_1);
            ++uncompletedCount;
            closeRequest(class30_sub2_sub3_1);
            waiting = true;
            //System.out.println("Error: file is missing  [ type = " + class30_sub2_sub3_1.dataType + "]  [id = " + class30_sub2_sub3_1.ID + "]");
         } catch (Exception ex) {
        	 ex.printStackTrace();
           // System.out.println("missing: type: " + class30_sub2_sub3_1.dataType + " ID" + class30_sub2_sub3_1.ID);
         }
      }

   }

   public final void method566() {
      synchronized(aClass19_1344) {
         aClass19_1344.method256();
      }
   }

   private final void checkReceived() {
         OnDemandData class30_sub2_sub3;
         synchronized(aClass19_1370) {
            class30_sub2_sub3 = (OnDemandData)aClass19_1370.popHead();
         }
         while(class30_sub2_sub3 != null) {
            waiting = true;
            byte[] abyte0111 = null;
            if(clientInstance.Indexes[0] != null) 
               abyte0111 = clientInstance.Indexes[class30_sub2_sub3.dataType + 1].decompress(class30_sub2_sub3.ID);

			//CRC MATCHING
			if(Constants.JAGCACHED_ENABLED) {
				if(!crcMatches(crcs[class30_sub2_sub3.dataType][class30_sub2_sub3.ID], abyte0111)) {
					abyte0111 = null;
				}
			}
            synchronized(aClass19_1370) {
               if(abyte0111 == null) {
                  aClass19_1368.insertHead(class30_sub2_sub3);
               } else {
                  class30_sub2_sub3.buffer = abyte0111;
                  synchronized(aClass19_1358) {
                	  aClass19_1358.insertHead(class30_sub2_sub3);
                  }
               }
               class30_sub2_sub3 = (OnDemandData)aClass19_1370.popHead();
            }
         }
   }
	private boolean crcMatches(int expectedValue, byte[] crcData)
	{
		if(crcData == null || crcData.length < 2)
			return false;
		int length = crcData.length - 2;
		aCRC32_1338.reset();
		aCRC32_1338.update(crcData, 0, length);
		int crcValue = (int) aCRC32_1338.getValue();
		return crcValue == expectedValue;
	}
	public int getChecksum(int type, int id) {
		int crc = -1;
		byte[] data = clientInstance.Indexes[type + 1].decompress(id);
		if (data != null) {
			int length = data.length - 2;
			aCRC32_1338.reset();
			aCRC32_1338.update(data, 0, length);
			crc = (int) aCRC32_1338.getValue();
		}
		return crc;
	}
   private final void method568() {

		while (uncompletedCount == 0 && completedCount < 10) {
			if (anInt1332 == 0)
				break;
         OnDemandData var10;
         synchronized(aClass19_1344) {
            var10 = (OnDemandData)aClass19_1344.popHead();
         }

         while(var10 != null) {
            if(fileStatus[var10.dataType][var10.ID] != 0) {
               fileStatus[var10.dataType][var10.ID] = 0;
               requested.insertHead(var10);
               closeRequest(var10);
               waiting = true;
               if(anInt1351 < totalFiles) 
                  ++anInt1351;            
               aString1333 = "Loading extra files - " + anInt1351 * 100 / totalFiles + "%";
               ++completedCount;
               if(completedCount == 10) 
                  return;
               
            }
            synchronized(aClass19_1344) {
               var10 = (OnDemandData)aClass19_1344.popHead();
            }
         }

         for(int var13 = 0; var13 < 4; ++var13) {
            byte[] abyte0 = fileStatus[var13];
            int k = abyte0.length;
            for(int l = 0; l < k; ++l) {
               if(abyte0[l] == anInt1332) {
                  abyte0[l] = 0;
                  OnDemandData class30_sub2_sub3_1 = new OnDemandData();
                  class30_sub2_sub3_1.dataType = var13;
                  class30_sub2_sub3_1.ID = l;
                  class30_sub2_sub3_1.incomplete = false;
                  requested.insertHead(class30_sub2_sub3_1);
                  closeRequest(class30_sub2_sub3_1);
                  waiting = true;
                  if(anInt1351 < totalFiles)
                     ++anInt1351;
                  aString1333 = "Loading extra files - " + anInt1351 * 100 / totalFiles + "%";
                  ++completedCount;
                  if(completedCount == 10) 
                     return;
               }
            }
         }

         --anInt1332;
      }

   }
/*	public void writeAll() {
		for(int i = 0; i < crcs.length; i++) {
			writeChecksumList(i);
			writeVersionList(i);
		}
	}*/
	public int getVersion(int type, int id) {
		int version = -1;
		byte[] data = clientInstance.Indexes[type + 1].decompress(id);
		if (data != null) {
			int length = data.length - 2;
			version = ((data[length] & 0xff) << 8) + (data[length + 1] & 0xff);
		}
		return version;
	}
/*	public void writeChecksumList(int type) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(SignLink.findcachedir() + type + "_crc.dat"));
			int total = 0;
			for (int index = 0; index < clientInstance.Indexes[type + 1].getFileCount(); index++) {
				out.writeInt(getChecksum(type, index));
				total++;
			}
			System.out.println(type+"-"+total);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeVersionList(int type) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(SignLink.findcachedir() + type + "_version.dat"));
			for (int index = 0; index < clientInstance.Indexes[type + 1].getFileCount(); index++) {
				out.writeShort(getVersion(type, index));
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
   public final boolean method569(int i) {
      return anIntArray1348[i] == 1;
   }

   public OnDemandFetcher() {
      nodeSubList = new NodeSubList(anInt1345);
      versions = new int[4][];
      //crcs = new int[4][];
      aClass19_1368 = new NodeList(169);
      aClass19_1370 = new NodeList(169);
   }
   private int[] anIntArray1356;
   private int[] anIntArray1360;
   private byte[] aByteArray1372;
   public static int mapAmount = 0;
   private boolean running = true;
   private boolean waiting = false;
   private Socket socket;
   private InputStream inputStream;
   private OutputStream outputStream;
   private int expectedSize;
   private OnDemandData current;
   private int loopCycle;
   private int completedSize;
   private static int[] mapIndices1;
   private static int[] mapIndices2;
   private static int[] mapIndices3;
   private int[] anIntArray1348;
   private Main clientInstance;
   private static int anInt1345;
   private int anInt1352 = 13603;
   private long aLong1335;
   private int writeLoopCycle;
   public int anInt1349;
   public int onDemandCycle;
   public String aString1333 = "";
   private int anInt1340 = 923;
   private int anInt1332;
   private int totalFiles;
   private int uncompletedCount;
   private int completedCount;
   private int anInt1351;
   private NodeList requested = new NodeList(169);
   private CRC32 aCRC32_1338 = new CRC32();
   private byte[] payload = new byte[JagGrabConstants.MAX_ONDEMAND_CHUNK_LENGTH_BYTES];
   private byte[][] fileStatus = new byte[4][];
   private NodeList aClass19_1344 = new NodeList(169);
   private boolean aBoolean1355 = false;
   private NodeList aClass19_1358 = new NodeList(169);
   private byte[] gzipInputBuffer = new byte[0x71868];
   private NodeSubList nodeSubList;
   private int[][] versions;
   private NodeList aClass19_1368;
   private NodeList aClass19_1370;

}
