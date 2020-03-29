package com.Ghreborn.client.cache.def;

import com.Ghreborn.client.Varp;
import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.io.Buffer;

public class VarBit {
   private static int anInt644;
   public String aString647;
   public int anInt653;
   public static int anInt645;
   public static VarBit[] cache;
   public int configId;
   public int lsb;
   public int msb;
   public boolean aBoolean651 = false;
   public int anInt652 = -1;

   public static void method533(StreamLoader class44) {
      Buffer class30_sub2_sub2 = new Buffer(class44.readFile("varbit.dat"));
      anInt645 = class30_sub2_sub2.readUShort();
      if(cache == null) {
         cache = new VarBit[anInt645];
      }

      for(int j = 0; j < anInt645; ++j) {
         if(cache[j] == null) {
            cache[j] = new VarBit();
         }

         cache[j].decode(class30_sub2_sub2);
         if(cache[j].aBoolean651) {
            Varp.cache[cache[j].configId].aBoolean713 = true;
         }
      }

   }

	private void decode(Buffer buffer) {
		int opcode = buffer.readUnsignedByte();

		if (opcode == 0) {
			return;
		} else if (opcode == 1) {
			configId = buffer.readUShort();
			lsb = buffer.readUnsignedByte();
			msb = buffer.readUnsignedByte();
		} else {
			System.out.println(opcode);
		}
	}

   private VarBit() {
      this.aBoolean651 = false;
   }
}
