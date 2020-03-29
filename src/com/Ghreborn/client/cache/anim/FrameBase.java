package com.Ghreborn.client.cache.anim;

import com.Ghreborn.client.io.Buffer;

public class FrameBase {
    private int anInt340;
   public int[] transformationType;
   public int[][] skinlist;

   public FrameBase(Buffer stream) {
      int count = stream.readUShort();
      this.transformationType = new int[count];
      this.skinlist = new int[count][];
      for(int j = 0; j < count; ++j) {
         this.transformationType[j] = stream.readUShort();
      }

      for(int j = 0; j < count; ++j) {
         this.skinlist[j] = new int[stream.readUShort()];
      }

      for(int j = 0; j < count; ++j) {
         for(int l = 0; l < this.skinlist[j].length; ++l) {
            this.skinlist[j][l] = stream.readUShort();
         }
      }

   }
}
