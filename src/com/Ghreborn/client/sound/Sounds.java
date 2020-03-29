package com.Ghreborn.client.sound;

import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.sound.Class6;

public class Sounds {
   private static boolean aBoolean323 = true;
   private static Sounds[] aClass16Array325 = new Sounds[5000];
   public static int[] anIntArray326 = new int[5000];
   private boolean aBoolean321 = true;
   private Class6[] aClass6Array329 = new Class6[10];
   private int anInt324;
   private static byte[] aByteArray327;
   private static Buffer aClass30_Sub2_Sub2_328;
   private static boolean aBoolean322;
   private int anInt330;
   private int anInt331;

   private Sounds(int i) {
      if(i < 8 || i > 8) {
         this.anInt324 = 477;
      }

   }

   public static final void method240(int i, Buffer class30_sub2_sub2) {
      aByteArray327 = new byte[441000];
      aClass30_Sub2_Sub2_328 = new Buffer(aByteArray327, 891);
      if(i != 0) {
         aBoolean322 = !aBoolean322;
      }

      Class6.method166();

      while(true) {
         int j = class30_sub2_sub2.readUnsignedWord();
         if(j == '\uffff') {
            return;
         }

         aClass16Array325[j] = new Sounds(8);
         aClass16Array325[j].method242(true, class30_sub2_sub2);
         anIntArray326[j] = aClass16Array325[j].method243(0);
      }
   }

   public static final Buffer method241(int i, int j) {

      if(aClass16Array325[j] != null) {
         Sounds class16 = aClass16Array325[j];
         return class16.method244(i, 6);
      } else {
         return null;
      }
   }

   private final void method242(boolean flag, Buffer class30_sub2_sub2) {
      for(int i = 0; i < 10; ++i) {
         int j = class30_sub2_sub2.readUnsignedByte();
         if(j != 0) {
            --class30_sub2_sub2.currentOffset;
            this.aClass6Array329[i] = new Class6();
            this.aClass6Array329[i].method169(true, class30_sub2_sub2);
         }
      }

      if(!flag) {
         this.anInt324 = 58;
      }

      this.anInt330 = class30_sub2_sub2.readUnsignedWord();
      this.anInt331 = class30_sub2_sub2.readUnsignedWord();
   }

   private final int method243(int i) {
      int j = 9999999;
      if(i != 0) {
         this.anInt324 = -52;
      }

      int l;
      for(l = 0; l < 10; ++l) {
         if(this.aClass6Array329[l] != null && this.aClass6Array329[l].anInt114 / 20 < j) {
            j = this.aClass6Array329[l].anInt114 / 20;
         }
      }

      if(this.anInt330 < this.anInt331 && this.anInt330 / 20 < j) {
         j = this.anInt330 / 20;
      }

      if(j != 9999999 && j != 0) {
         for(l = 0; l < 10; ++l) {
            if(this.aClass6Array329[l] != null) {
               this.aClass6Array329[l].anInt114 -= j * 20;
            }
         }

         if(this.anInt330 < this.anInt331) {
            this.anInt330 -= j * 20;
            this.anInt331 -= j * 20;
         }

         return j;
      } else {
         return 0;
      }
   }

   private final Buffer method244(int i, int j) {
      int k = this.method245(i);
      aClass30_Sub2_Sub2_328.currentOffset = 0;
      aClass30_Sub2_Sub2_328.method402(1380533830);
      aClass30_Sub2_Sub2_328.method403(0, 36 + k);
      aClass30_Sub2_Sub2_328.method402(1463899717);
      aClass30_Sub2_Sub2_328.method402(1718449184);
      aClass30_Sub2_Sub2_328.method403(0, 16);
      aClass30_Sub2_Sub2_328.method400(true, 1);
      if(j < 6 || j > 6) {
         for(int l = 1; l > 0; ++l) {
         }
      }

      aClass30_Sub2_Sub2_328.method400(true, 1);
      aClass30_Sub2_Sub2_328.method403(0, 22050);
      aClass30_Sub2_Sub2_328.method403(0, 22050);
      aClass30_Sub2_Sub2_328.method400(true, 1);
      aClass30_Sub2_Sub2_328.method400(true, 8);
      aClass30_Sub2_Sub2_328.method402(1684108385);
      aClass30_Sub2_Sub2_328.method403(0, k);
      aClass30_Sub2_Sub2_328.currentOffset += k;
      return aClass30_Sub2_Sub2_328;
   }

   private final int method245(int i) {
      int j = 0;

      int l;
      for(l = 0; l < 10; ++l) {
         if(this.aClass6Array329[l] != null && this.aClass6Array329[l].anInt113 + this.aClass6Array329[l].anInt114 > j) {
            j = this.aClass6Array329[l].anInt113 + this.aClass6Array329[l].anInt114;
         }
      }

      if(j == 0) {
         return 0;
      } else {
         l = 22050 * j / 1000;
         int i1 = 22050 * this.anInt330 / 1000;
         int j1 = 22050 * this.anInt331 / 1000;
         if(i1 < 0 || i1 > l || j1 < 0 || j1 > l || i1 >= j1) {
            i = 0;
         }

         int k1 = l + (j1 - i1) * (i - 1);

         int k2;
         for(k2 = 44; k2 < k1 + 44; ++k2) {
            aByteArray327[k2] = -128;
         }

         int k3;
         int l2;
         for(k2 = 0; k2 < 10; ++k2) {
            if(this.aClass6Array329[k2] != null) {
               k3 = this.aClass6Array329[k2].anInt113 * 22050 / 1000;
               l2 = this.aClass6Array329[k2].anInt114 * 22050 / 1000;
               int[] var121 = this.aClass6Array329[k2].method167(k3, this.aClass6Array329[k2].anInt113);

               for(int l3 = 0; l3 < k3; ++l3) {
                  aByteArray327[l3 + l2 + 44] += (byte)(var121[l3] >> 8);
               }
            }
         }

         if(i > 1) {
            i1 += 44;
            j1 += 44;
            l += 44;
            k1 += 44;
            k2 = k1 - l;

            for(k3 = l - 1; k3 >= j1; --k3) {
               aByteArray327[k3 + k2] = aByteArray327[k3];
            }

            for(k3 = 1; k3 < i; ++k3) {
               l2 = (j1 - i1) * k3;

               for(int var12 = i1; var12 < j1; ++var12) {
                  aByteArray327[var12 + l2] = aByteArray327[var12];
               }
            }

            k1 -= 44;
         }

         return k1;
      }
   }
}
