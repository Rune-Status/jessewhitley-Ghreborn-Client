package com.Ghreborn.client.sound;

import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.sound.Class29;
import com.Ghreborn.client.sound.Class39;

public class Class6 {
   private static int[] anIntArray118 = new int[5];
   private static int[] anIntArray119 = new int[5];
   private static int[] anIntArray120 = new int[5];
   private static int[] anIntArray121 = new int[5];
   private static int[] anIntArray122 = new int[5];
   private boolean aBoolean97 = true;
   private int[] anIntArray106 = new int[5];
   private int[] anIntArray107 = new int[5];
   private int[] anIntArray108 = new int[5];
   private int anInt110 = 100;
   int anInt113 = 500;
   private static int[] anIntArray116;
   private static int[] anIntArray117;
   private static int[] anIntArray115;
   private Class29 aClass29_98;
   private Class29 aClass29_99;
   private Class29 aClass29_100;
   private Class29 aClass29_101;
   private Class29 aClass29_102;
   private Class29 aClass29_103;
   private Class29 aClass29_104;
   private Class29 aClass29_105;
   private int anInt109;
   int anInt114;
   private Class39 aClass39_111;
   private Class29 aClass29_112;

   public static final void method166() {
      anIntArray116 = new int['\u8000'];

      int j;
      for(j = 0; j < '\u8000'; ++j) {
         if(Math.random() > 0.5D) {
            anIntArray116[j] = 1;
         } else {
            anIntArray116[j] = -1;
         }
      }

      anIntArray117 = new int['\u8000'];

      for(j = 0; j < '\u8000'; ++j) {
         anIntArray117[j] = (int)(Math.sin((double)j / 5215.1903D) * 16384.0D);
      }

      anIntArray115 = new int[220500];
   }

   public final int[] method167(int i, int j) {
      for(int var20 = 0; var20 < i; ++var20) {
         anIntArray115[var20] = 0;
      }

      if(j < 10) {
         return anIntArray115;
      } else {
         double var201 = (double)i / ((double)j + 0.0D);
         this.aClass29_98.method327((byte)8);
         this.aClass29_99.method327((byte)8);
         int l = 0;
         int i1 = 0;
         int j1 = 0;
         if(this.aClass29_100 != null) {
            this.aClass29_100.method327((byte)8);
            this.aClass29_101.method327((byte)8);
            l = (int)((double)(this.aClass29_100.anInt539 - this.aClass29_100.anInt538) * 32.768D / var201);
            i1 = (int)((double)this.aClass29_100.anInt538 * 32.768D / var201);
         }

         int k1 = 0;
         int l1 = 0;
         int i2 = 0;
         if(this.aClass29_102 != null) {
            this.aClass29_102.method327((byte)8);
            this.aClass29_103.method327((byte)8);
            k1 = (int)((double)(this.aClass29_102.anInt539 - this.aClass29_102.anInt538) * 32.768D / var201);
            l1 = (int)((double)this.aClass29_102.anInt538 * 32.768D / var201);
         }

         int i4;
         for(i4 = 0; i4 < 5; ++i4) {
            if(this.anIntArray106[i4] != 0) {
               anIntArray118[i4] = 0;
               anIntArray119[i4] = (int)((double)this.anIntArray108[i4] * var201);
               anIntArray120[i4] = (this.anIntArray106[i4] << 14) / 100;
               anIntArray121[i4] = (int)((double)(this.aClass29_98.anInt539 - this.aClass29_98.anInt538) * 32.768D * Math.pow(1.0057929410678534D, (double)this.anIntArray107[i4]) / var201);
               anIntArray122[i4] = (int)((double)this.aClass29_98.anInt538 * 32.768D / var201);
            }
         }

         int i5;
         int i6;
         int j7;
         int l7;
         for(i4 = 0; i4 < i; ++i4) {
            i5 = this.aClass29_98.method328(true, i);
            i6 = this.aClass29_99.method328(true, i);
            if(this.aClass29_100 != null) {
               j7 = this.aClass29_100.method328(true, i);
               l7 = this.aClass29_101.method328(true, i);
               i5 += this.method168(l7, 0, j1, this.aClass29_100.anInt540) >> 1;
               j1 += (j7 * l >> 16) + i1;
            }

            if(this.aClass29_102 != null) {
               j7 = this.aClass29_102.method328(true, i);
               l7 = this.aClass29_103.method328(true, i);
               i6 = i6 * ((this.method168(l7, 0, i2, this.aClass29_102.anInt540) >> 1) + '\u8000') >> 15;
               i2 += (j7 * k1 >> 16) + l1;
            }

            for(j7 = 0; j7 < 5; ++j7) {
               if(this.anIntArray106[j7] != 0) {
                  l7 = i4 + anIntArray119[j7];
                  if(l7 < i) {
                     anIntArray115[l7] += this.method168(i6 * anIntArray120[j7] >> 15, 0, anIntArray118[j7], this.aClass29_98.anInt540);
                     anIntArray118[j7] += (i5 * anIntArray121[j7] >> 16) + anIntArray122[j7];
                  }
               }
            }
         }

         int c;
         int i9;
         if(this.aClass29_104 != null) {
            this.aClass29_104.method327((byte)8);
            this.aClass29_105.method327((byte)8);
            i4 = 0;
            boolean var21 = false;
            boolean var221 = true;

            for(j7 = 0; j7 < i; ++j7) {
               l7 = this.aClass29_104.method328(true, i);
               c = this.aClass29_105.method328(true, i);
               if(var221) {
                  i9 = this.aClass29_104.anInt538 + ((this.aClass29_104.anInt539 - this.aClass29_104.anInt538) * l7 >> 8);
               } else {
                  i9 = this.aClass29_104.anInt538 + ((this.aClass29_104.anInt539 - this.aClass29_104.anInt538) * c >> 8);
               }

               i4 += 256;
               if(i4 >= i9) {
                  i4 = 0;
                  var221 = !var221;
               }

               if(var221) {
                  anIntArray115[j7] = 0;
               }
            }
         }

         if(this.anInt109 > 0 && this.anInt110 > 0) {
            i4 = (int)((double)this.anInt109 * var201);

            for(i5 = i4; i5 < i; ++i5) {
               anIntArray115[i5] += anIntArray115[i5 - i4] * this.anInt110 / 100;
            }
         }

         if(this.aClass39_111.anIntArray665[0] > 0 || this.aClass39_111.anIntArray665[1] > 0) {
            this.aClass29_112.method327((byte)8);
            i4 = this.aClass29_112.method328(true, i + 1);
            i5 = this.aClass39_111.method544(0, (float)i4 / 65536.0F, 201);
            i6 = this.aClass39_111.method544(1, (float)i4 / 65536.0F, 201);
            if(i >= i5 + i6) {
               j7 = 0;
               l7 = i6;
               if(i6 > i - i5) {
                  l7 = i - i5;
               }

               while(j7 < l7) {
                  c = (int)((long)anIntArray115[j7 + i5] * (long)Class39.anInt672 >> 16);

                  for(i9 = 0; i9 < i5; ++i9) {
                     c += (int)((long)anIntArray115[j7 + i5 - 1 - i9] * (long)Class39.anIntArrayArray670[0][i9] >> 16);
                  }

                  for(i9 = 0; i9 < j7; ++i9) {
                     c -= (int)((long)anIntArray115[j7 - 1 - i9] * (long)Class39.anIntArrayArray670[1][i9] >> 16);
                  }

                  anIntArray115[j7] = c;
                  i4 = this.aClass29_112.method328(true, i + 1);
                  ++j7;
               }

               short var211 = 128;
               l7 = var211;

               while(true) {
                  if(l7 > i - i5) {
                     l7 = i - i5;
                  }

                  int var22;
                  while(j7 < l7) {
                     i9 = (int)((long)anIntArray115[j7 + i5] * (long)Class39.anInt672 >> 16);

                     for(var22 = 0; var22 < i5; ++var22) {
                        i9 += (int)((long)anIntArray115[j7 + i5 - 1 - var22] * (long)Class39.anIntArrayArray670[0][var22] >> 16);
                     }

                     for(var22 = 0; var22 < i6; ++var22) {
                        i9 -= (int)((long)anIntArray115[j7 - 1 - var22] * (long)Class39.anIntArrayArray670[1][var22] >> 16);
                     }

                     anIntArray115[j7] = i9;
                     i4 = this.aClass29_112.method328(true, i + 1);
                     ++j7;
                  }

                  if(j7 >= i - i5) {
                     while(j7 < i) {
                        i9 = 0;

                        for(var22 = j7 + i5 - i; var22 < i5; ++var22) {
                           i9 += (int)((long)anIntArray115[j7 + i5 - 1 - var22] * (long)Class39.anIntArrayArray670[0][var22] >> 16);
                        }

                        for(var22 = 0; var22 < i6; ++var22) {
                           i9 -= (int)((long)anIntArray115[j7 - 1 - var22] * (long)Class39.anIntArrayArray670[1][var22] >> 16);
                        }

                        anIntArray115[j7] = i9;
                        this.aClass29_112.method328(true, i + 1);
                        ++j7;
                     }
                     break;
                  }

                  i5 = this.aClass39_111.method544(0, (float)i4 / 65536.0F, 201);
                  i6 = this.aClass39_111.method544(1, (float)i4 / 65536.0F, 201);
                  l7 += var211;
               }
            }
         }

         for(i4 = 0; i4 < i; ++i4) {
            if(anIntArray115[i4] < -32768) {
               anIntArray115[i4] = -32768;
            }

            if(anIntArray115[i4] > 32767) {
               anIntArray115[i4] = 32767;
            }
         }

         return anIntArray115;
      }
   }

   private final int method168(int i, int j, int k, int l) {
      if(j != 0) {
         this.aBoolean97 = !this.aBoolean97;
      }

      return l == 1?((k & 32767) < 16384?i:-i):(l == 2?anIntArray117[k & 32767] * i >> 14:(l == 3?((k & 32767) * i >> 14) - i:(l == 4?anIntArray116[k / 2607 & 32767] * i:0)));
   }

   public final void method169(boolean flag, Buffer class30_sub2_sub2) {
      this.aClass29_98 = new Class29();
      this.aClass29_98.method325(true, class30_sub2_sub2);
      this.aClass29_99 = new Class29();
      if(!flag) {
         throw new NullPointerException();
      } else {
         this.aClass29_99.method325(true, class30_sub2_sub2);
         int i = class30_sub2_sub2.readUnsignedByte();
         if(i != 0) {
            --class30_sub2_sub2.currentOffset;
            this.aClass29_100 = new Class29();
            this.aClass29_100.method325(true, class30_sub2_sub2);
            this.aClass29_101 = new Class29();
            this.aClass29_101.method325(true, class30_sub2_sub2);
         }

         i = class30_sub2_sub2.readUnsignedByte();
         if(i != 0) {
            --class30_sub2_sub2.currentOffset;
            this.aClass29_102 = new Class29();
            this.aClass29_102.method325(true, class30_sub2_sub2);
            this.aClass29_103 = new Class29();
            this.aClass29_103.method325(true, class30_sub2_sub2);
         }

         i = class30_sub2_sub2.readUnsignedByte();
         if(i != 0) {
            --class30_sub2_sub2.currentOffset;
            this.aClass29_104 = new Class29();
            this.aClass29_104.method325(true, class30_sub2_sub2);
            this.aClass29_105 = new Class29();
            this.aClass29_105.method325(true, class30_sub2_sub2);
         }

         for(int j = 0; j < 10; ++j) {
            int k = class30_sub2_sub2.method422();
            if(k == 0) {
               break;
            }

            this.anIntArray106[j] = k;
            this.anIntArray107[j] = class30_sub2_sub2.method421();
            this.anIntArray108[j] = class30_sub2_sub2.method422();
         }

         this.anInt109 = class30_sub2_sub2.method422();
         this.anInt110 = class30_sub2_sub2.method422();
         this.anInt113 = class30_sub2_sub2.readUnsignedWord();
         this.anInt114 = class30_sub2_sub2.readUnsignedWord();
         this.aClass39_111 = new Class39();
         this.aClass29_112 = new Class29();
         this.aClass39_111.method545(class30_sub2_sub2, false, this.aClass29_112);
      }
   }
}
