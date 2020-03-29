package com.Ghreborn.client.net;

public final class ISAACRandomGen {
   private int anInt332 = -436;
   private int anInt333 = -431;
   private int[] anIntArray335 = new int[256];
   private int[] anIntArray336 = new int[256];
   private int anInt334;
   private int anInt339;
   private int anInt338;
   private int anInt337;

   public ISAACRandomGen(int i, int[] ai) {
      for(int j = 0; j < ai.length; ++j) {
         this.anIntArray335[j] = ai[j];
      }

      if(i >= 0) {
         this.anInt333 = -242;
      }

      this.method248();
   }

   public final int method246() {
      if(this.anInt334-- == 0) {
         this.method247();
         this.anInt334 = 255;
      }

      return this.anIntArray335[this.anInt334];
   }

   private final void method247() {
      this.anInt338 += ++this.anInt339;

      for(int i = 0; i < 256; ++i) {
         int j = this.anIntArray336[i];
         if((i & 3) == 0) {
            this.anInt337 ^= this.anInt337 << 13;
         } else if((i & 3) == 1) {
            this.anInt337 ^= this.anInt337 >>> 6;
         } else if((i & 3) == 2) {
            this.anInt337 ^= this.anInt337 << 2;
         } else if((i & 3) == 3) {
            this.anInt337 ^= this.anInt337 >>> 16;
         }

         this.anInt337 += this.anIntArray336[i + 128 & 255];
         int k;
         this.anIntArray336[i] = k = this.anIntArray336[(j & 1020) >> 2] + this.anInt337 + this.anInt338;
         this.anIntArray335[i] = this.anInt338 = this.anIntArray336[(k >> 8 & 1020) >> 2] + j;
      }

   }

   private final void method248() {
      int k2 = -1640531527;
      int j2 = -1640531527;
      int i2 = -1640531527;
      int l1 = -1640531527;
      int k1 = -1640531527;
      int j1 = -1640531527;
      int i1 = -1640531527;
      int l = -1640531527;

      int k;
      for(k = 0; k < 4; ++k) {
         l ^= i1 << 11;
         k1 += l;
         i1 += j1;
         i1 ^= j1 >>> 2;
         l1 += i1;
         j1 += k1;
         j1 ^= k1 << 8;
         i2 += j1;
         k1 += l1;
         k1 ^= l1 >>> 16;
         j2 += k1;
         l1 += i2;
         l1 ^= i2 << 10;
         k2 += l1;
         i2 += j2;
         i2 ^= j2 >>> 4;
         l += i2;
         j2 += k2;
         j2 ^= k2 << 8;
         i1 += j2;
         k2 += l;
         k2 ^= l >>> 9;
         j1 += k2;
         l += i1;
      }

      for(k = 0; k < 256; k += 8) {
         l += this.anIntArray335[k];
         i1 += this.anIntArray335[k + 1];
         j1 += this.anIntArray335[k + 2];
         k1 += this.anIntArray335[k + 3];
         l1 += this.anIntArray335[k + 4];
         i2 += this.anIntArray335[k + 5];
         j2 += this.anIntArray335[k + 6];
         k2 += this.anIntArray335[k + 7];
         l ^= i1 << 11;
         k1 += l;
         i1 += j1;
         i1 ^= j1 >>> 2;
         l1 += i1;
         j1 += k1;
         j1 ^= k1 << 8;
         i2 += j1;
         k1 += l1;
         k1 ^= l1 >>> 16;
         j2 += k1;
         l1 += i2;
         l1 ^= i2 << 10;
         k2 += l1;
         i2 += j2;
         i2 ^= j2 >>> 4;
         l += i2;
         j2 += k2;
         j2 ^= k2 << 8;
         i1 += j2;
         k2 += l;
         k2 ^= l >>> 9;
         j1 += k2;
         l += i1;
         this.anIntArray336[k] = l;
         this.anIntArray336[k + 1] = i1;
         this.anIntArray336[k + 2] = j1;
         this.anIntArray336[k + 3] = k1;
         this.anIntArray336[k + 4] = l1;
         this.anIntArray336[k + 5] = i2;
         this.anIntArray336[k + 6] = j2;
         this.anIntArray336[k + 7] = k2;
      }

      for(k = 0; k < 256; k += 8) {
         l += this.anIntArray336[k];
         i1 += this.anIntArray336[k + 1];
         j1 += this.anIntArray336[k + 2];
         k1 += this.anIntArray336[k + 3];
         l1 += this.anIntArray336[k + 4];
         i2 += this.anIntArray336[k + 5];
         j2 += this.anIntArray336[k + 6];
         k2 += this.anIntArray336[k + 7];
         l ^= i1 << 11;
         k1 += l;
         i1 += j1;
         i1 ^= j1 >>> 2;
         l1 += i1;
         j1 += k1;
         j1 ^= k1 << 8;
         i2 += j1;
         k1 += l1;
         k1 ^= l1 >>> 16;
         j2 += k1;
         l1 += i2;
         l1 ^= i2 << 10;
         k2 += l1;
         i2 += j2;
         i2 ^= j2 >>> 4;
         l += i2;
         j2 += k2;
         j2 ^= k2 << 8;
         i1 += j2;
         k2 += l;
         k2 ^= l >>> 9;
         j1 += k2;
         l += i1;
         this.anIntArray336[k] = l;
         this.anIntArray336[k + 1] = i1;
         this.anIntArray336[k + 2] = j1;
         this.anIntArray336[k + 3] = k1;
         this.anIntArray336[k + 4] = l1;
         this.anIntArray336[k + 5] = i2;
         this.anIntArray336[k + 6] = j2;
         this.anIntArray336[k + 7] = k2;
      }

      this.method247();
      this.anInt334 = 256;
   }
}
