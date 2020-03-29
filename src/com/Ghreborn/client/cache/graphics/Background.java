package com.Ghreborn.client.cache.graphics;

import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.draw.DrawingArea;
import com.Ghreborn.client.io.Buffer;

public final class Background extends DrawingArea {
   private boolean aBoolean1447 = false;
   private int anInt1448 = 360;
   private byte aByte1449 = 3;
   public int anInt1456;
   public int anInt1457;
   public int[] anIntArray1451;
   public int anInt1454;
   public int anInt1455;
   public int anInt1452;
   public int anInt1453;
   public byte[] aByteArray1450;
   private int anInt1446;

   public Background(StreamLoader class44, String s, int i) {
      Buffer class30_sub2_sub2 = new Buffer(class44.readFile(s + ".dat"), 891);
      Buffer class30_sub2_sub2_1 = new Buffer(class44.readFile("index.dat"), 891);
      class30_sub2_sub2_1.currentOffset = class30_sub2_sub2.readUnsignedWord();
      this.anInt1456 = class30_sub2_sub2_1.readUnsignedWord();
      this.anInt1457 = class30_sub2_sub2_1.readUnsignedWord();
      int j = class30_sub2_sub2_1.readUnsignedByte();
      this.anIntArray1451 = new int[j];

      int i1;
      for(i1 = 0; i1 < j - 1; ++i1) {
         this.anIntArray1451[i1 + 1] = class30_sub2_sub2_1.readTriByte();
      }

      for(i1 = 0; i1 < i; ++i1) {
         class30_sub2_sub2_1.currentOffset += 2;
         class30_sub2_sub2.currentOffset += class30_sub2_sub2_1.readUnsignedWord() * class30_sub2_sub2_1.readUnsignedWord();
         ++class30_sub2_sub2_1.currentOffset;
      }

      this.anInt1454 = class30_sub2_sub2_1.readUnsignedByte();
      this.anInt1455 = class30_sub2_sub2_1.readUnsignedByte();
      this.anInt1452 = class30_sub2_sub2_1.readUnsignedWord();
      this.anInt1453 = class30_sub2_sub2_1.readUnsignedWord();
      i1 = class30_sub2_sub2_1.readUnsignedByte();
      int j1 = this.anInt1452 * this.anInt1453;
      this.aByteArray1450 = new byte[j1];
      int l1;
      if(i1 == 0) {
         for(l1 = 0; l1 < j1; ++l1) {
            this.aByteArray1450[l1] = class30_sub2_sub2.method409();
         }
      } else if(i1 == 1) {
         for(l1 = 0; l1 < this.anInt1452; ++l1) {
            for(int i2 = 0; i2 < this.anInt1453; ++i2) {
               this.aByteArray1450[l1 + i2 * this.anInt1452] = class30_sub2_sub2.method409();
            }
         }
      }

   }

   public void method356() {
      this.anInt1456 /= 2;
      this.anInt1457 /= 2;
      byte[] abyte0 = new byte[this.anInt1456 * this.anInt1457];
      int i = 0;

      for(int j = 0; j < this.anInt1453; ++j) {
         for(int k = 0; k < this.anInt1452; ++k) {
            abyte0[(k + this.anInt1454 >> 1) + (j + this.anInt1455 >> 1) * this.anInt1456] = this.aByteArray1450[i++];
         }
      }

      this.aByteArray1450 = abyte0;
      this.anInt1452 = this.anInt1456;
      this.anInt1453 = this.anInt1457;
      this.anInt1454 = 0;
      this.anInt1455 = 0;
   }

   public void method357() {
      if(this.anInt1452 != this.anInt1456 || this.anInt1453 != this.anInt1457) {
         byte[] abyte0 = new byte[this.anInt1456 * this.anInt1457];
         int i = 0;

         for(int j = 0; j < this.anInt1453; ++j) {
            for(int k = 0; k < this.anInt1452; ++k) {
               abyte0[k + this.anInt1454 + (j + this.anInt1455) * this.anInt1456] = this.aByteArray1450[i++];
            }
         }

         this.aByteArray1450 = abyte0;
         this.anInt1452 = this.anInt1456;
         this.anInt1453 = this.anInt1457;
         this.anInt1454 = 0;
         this.anInt1455 = 0;
      }

   }

   public void method358(int i) {
      if(i == 0) {
         byte[] abyte0 = new byte[this.anInt1452 * this.anInt1453];
         int j = 0;

         for(int k = 0; k < this.anInt1453; ++k) {
            for(int l = this.anInt1452 - 1; l >= 0; --l) {
               abyte0[j++] = this.aByteArray1450[l + k * this.anInt1452];
            }
         }

         this.aByteArray1450 = abyte0;
         this.anInt1454 = this.anInt1456 - this.anInt1452 - this.anInt1454;
      }

   }

   public void method359(boolean flag) {
      byte[] abyte0 = new byte[this.anInt1452 * this.anInt1453];
      int i = 0;

      for(int j = this.anInt1453 - 1; j >= 0; --j) {
         for(int k = 0; k < this.anInt1452; ++k) {
            abyte0[i++] = this.aByteArray1450[k + j * this.anInt1452];
         }
      }

      this.aByteArray1450 = abyte0;
      if(!flag) {
         this.anInt1446 = -48;
      }

      this.anInt1455 = this.anInt1457 - this.anInt1453 - this.anInt1455;
   }

   public void method360(int i, int j, int k, int l) {
      for(int i1 = 0; i1 < this.anIntArray1451.length; ++i1) {
         int j1 = this.anIntArray1451[i1] >> 16 & 255;
         j1 += i;
         if(j1 < 0) {
            j1 = 0;
         } else if(j1 > 255) {
            j1 = 255;
         }

         int k1 = this.anIntArray1451[i1] >> 8 & 255;
         k1 += j;
         if(k1 < 0) {
            k1 = 0;
         } else if(k1 > 255) {
            k1 = 255;
         }

         int l1 = this.anIntArray1451[i1] & 255;
         l1 += k;
         if(l1 < 0) {
            l1 = 0;
         } else if(l1 > 255) {
            l1 = 255;
         }

         this.anIntArray1451[i1] = (j1 << 16) + (k1 << 8) + l1;
      }

      if(l != 0) {
         this.anInt1446 = 69;
      }

   }

   public void drawBackground(int i, int k) {
      i += this.anInt1454;
      k += this.anInt1455;
      int l = i + k * DrawingArea.width;
      int i1 = 0;
      int j1 = this.anInt1453;
      int k1 = this.anInt1452;
      int l1 = DrawingArea.width - k1;
      int i2 = 0;
      int l2;
      if(k < DrawingArea.topY) {
         l2 = DrawingArea.topY - k;
         j1 -= l2;
         k = DrawingArea.topY;
         i1 += l2 * k1;
         l += l2 * DrawingArea.width;
      }

      if(k + j1 > DrawingArea.bottomY) {
         j1 -= k + j1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         l2 = DrawingArea.leftX - i;
         k1 -= l2;
         i = DrawingArea.leftX;
         i1 += l2;
         l += l2;
         i2 += l2;
         l1 += l2;
      }

      if(i + k1 > DrawingArea.bottomX) {
         l2 = i + k1 - DrawingArea.bottomX;
         k1 -= l2;
         i2 += l2;
         l1 += l2;
      }

      if(k1 > 0 && j1 > 0) {
         this.method362(j1, (byte)9, DrawingArea.pixels, this.aByteArray1450, l1, l, k1, i1, this.anIntArray1451, i2);
      }

   }

   private void method362(int i, byte byte0, int[] ai, byte[] abyte0, int j, int k, int l, int i1, int[] ai1, int j1) {
      if(byte0 != 9) {
         this.aBoolean1447 = !this.aBoolean1447;
      }

      int k1 = -(l >> 2);
      l = -(l & 3);

      for(int l1 = -i; l1 < 0; ++l1) {
         int j2;
         byte byte2;
         for(j2 = k1; j2 < 0; ++j2) {
            byte2 = abyte0[i1++];
            if(byte2 != 0) {
               ai[k++] = ai1[byte2 & 255];
            } else {
               ++k;
            }

            byte2 = abyte0[i1++];
            if(byte2 != 0) {
               ai[k++] = ai1[byte2 & 255];
            } else {
               ++k;
            }

            byte2 = abyte0[i1++];
            if(byte2 != 0) {
               ai[k++] = ai1[byte2 & 255];
            } else {
               ++k;
            }

            byte2 = abyte0[i1++];
            if(byte2 != 0) {
               ai[k++] = ai1[byte2 & 255];
            } else {
               ++k;
            }
         }

         for(j2 = l; j2 < 0; ++j2) {
            byte2 = abyte0[i1++];
            if(byte2 != 0) {
               ai[k++] = ai1[byte2 & 255];
            } else {
               ++k;
            }
         }

         k += j;
         i1 += j1;
      }

   }
}
