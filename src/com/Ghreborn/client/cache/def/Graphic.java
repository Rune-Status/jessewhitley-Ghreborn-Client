package com.Ghreborn.client.cache.def;

import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.cache.def.Animation;
import com.Ghreborn.client.entity.model.Model;
import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.link.MRUNodes;

public class Graphic {
   private static boolean aBoolean401 = true;
   public static MRUNodes aClass12_415 = new MRUNodes(30);
   private int anInt400 = 9;
   public int animationId = -1;
   public int[] colorToFind = new int[6];
   public int[] colorToReplace = new int[6];
   public int resizeX = 128;
   public int resizeY = 128;
   public static int length;
   public static Graphic[] cache;
   public int anInt404;
   public int modelId;
   public Animation aAnimation_407;
   public int rotation;
   public int ambience;
   public int contrast;

   public static void unpackConfig(StreamLoader streamloader) {
      Buffer stream = new Buffer(streamloader.readFile("spotanim.dat"));
      length = stream.readUShort();
      System.out.println("Loaded: " + length + " Graphics");
      if(cache == null) {
         cache = new Graphic[length + 1];
      }

      for(int j = 0; j < length; ++j) {
         if(cache[j] == null) {
            cache[j] = new Graphic();
         }
            cache[j].anInt404 = j;
            cache[j].decode(stream);
         
      }
		if (stream.currentOffset != stream.buffer.length) {
			System.out.println("gfx mismatch! " + stream.currentOffset + " " + stream.buffer.length);
		}
      
   }

	private void decode(Buffer buffer) {
		while(true) {
			final int opcode = buffer.readUnsignedByte();

			if (opcode == 0) {
				return;
			} else if (opcode == 1) {
				modelId = buffer.readUShort();
			} else if (opcode == 2) {
				animationId = buffer.readUShort();

				if (Animation.anims != null) {
                    aAnimation_407 = Animation.anims[animationId];
                }
			} else if (opcode == 4) {
				resizeX = buffer.readUShort();
			} else if (opcode == 5) {
				resizeY = buffer.readUShort();
			} else if (opcode == 6) {
				rotation = buffer.readUShort();
			} else if (opcode == 7) {
				ambience = buffer.readUnsignedByte();
			} else if (opcode == 8) {
				contrast = buffer.readUnsignedByte();
			} else if (opcode == 40) {
				int len = buffer.readUnsignedByte();
				colorToFind = new int[len];
				colorToReplace = new int[len];
				for (int i = 0; i < len; i++) {
					colorToFind[i] = buffer.readUShort();
					colorToReplace[i] = buffer.readUShort();
				}
			} else if (opcode == 41) { // re-texture
				int len = buffer.readUnsignedByte();

				for (int i = 0; i < len; i++) {
					buffer.readUShort();
					buffer.readUShort();
				}
			} else {
				System.out.println("gfx invalid opcode: " + opcode);
			}
		}
	}
   public Model method266() {
      Model Model = (Model)aClass12_415.insertFromCache((long)this.anInt404);
      if(Model != null) {
         return Model;
      } else {
         Model = com.Ghreborn.client.entity.model.Model.getModel(this.modelId);
         if(Model == null) {
            return null;
         } else {
            for(int i = 0; i < 6; ++i) {
               if(this.colorToFind[0] != 0) {
                  Model.recolor(this.colorToFind[i], this.colorToReplace[i]);
               }
            }

            aClass12_415.removeFromCache(Model, (long)this.anInt404);
            return Model;
         }
      }
   }
}
