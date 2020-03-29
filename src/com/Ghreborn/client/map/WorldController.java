//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.Ghreborn.client.map;

import com.Ghreborn.client.Constants;
import com.Ghreborn.client.draw.DrawingArea;
import com.Ghreborn.client.draw.Rasterizer;
import com.Ghreborn.client.entity.Animable;
import com.Ghreborn.client.entity.model.Model;
import com.Ghreborn.client.entity.model.VertexNormal;
import com.Ghreborn.client.link.NodeList;

public class WorldController {
   private int anInt430;
   private static int anInt431 = 360;
   private static int anInt432 = 1;
   private static int anInt433 = -460;
   public static int viewDistance = 9;
   public static boolean lowMem = true;
   static Object5[] aClass28Array462 = new Object5[100];
   static final int[] anIntArray463 = new int[]{53, -53, -53, 53};
   static final int[] anIntArray464 = new int[]{-53, -53, 53, 53};
   static final int[] anIntArray465 = new int[]{-45, 45, 45, -45};
   static final int[] anIntArray466 = new int[]{45, 45, -45, -45};
   public static int anInt470 = -1;
   public static int anInt471 = -1;
   private static final int TILE_DRAW_DISTANCE = 25;
   static int anInt472 = 4;
   static int[] anIntArray473;
   static Class47[][] aClass47ArrayArray474;
   static Class47[] aClass47Array476;
   static NodeList aClass19_477;
   static final int[] anIntArray478;
   static final int[] anIntArray479;
   static final int[] anIntArray480;
   static final int[] anIntArray481;
   static final int[] anIntArray482;
   static final int[] anIntArray483;
   static final int[] anIntArray484;
   static final int[] anIntArray485;
   static boolean[][][][] aBooleanArrayArrayArrayArray491;
   private boolean aBoolean429 = true;
   private boolean aBoolean434 = true;
   private boolean aBoolean435 = false;
   Object5[] aClass28Array444 = new Object5[5000];
   int[] anIntArray486 = new int[10000];
   int[] anIntArray487 = new int[10000];
   int[][] anIntArrayArray489 = new int[][]{new int[16], {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1}};
   int[][] anIntArrayArray490 = new int[][]{{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}, {12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 6, 2, 15, 11, 7, 3}, {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, {3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 9, 13, 0, 4, 8, 12}};
   int anInt437;
   int anInt438;
   int anInt439;
   Ground[][][] groundArray;
   int[][][] anIntArrayArrayArray445;
   int[][][] anIntArrayArrayArray440;
   static boolean[][] aBooleanArrayArray492;
   int anInt443;
   int anInt442;
   int anInt488;
   static int anInt495;
   static int anInt496;
   static int anInt497;
   static int anInt498;
   static int anInt493;
   static int anInt494;
   static int anInt458;
   static int anInt459;
   static int anInt460;
   static int anInt461;
   static boolean aBoolean467;
   static int anInt468;
   static int anInt469;
   static int anInt448;
   static int anInt455;
   static int cameraY;
   static int cameraZ;
   static int anInt453;
   static int anInt454;
   static int anInt447;
   static int anInt449;
   static int anInt451;
   static int anInt450;
   static int anInt452;
   static int anInt446;
   public static int anInt475;
   public static int focalLength = 512;

   static {
      focalLength = 512;
      anIntArray473 = new int[anInt472];
      aClass47ArrayArray474 = new Class47[anInt472][500];
      aClass47Array476 = new Class47[500];
      aClass19_477 = new NodeList(169);
      anIntArray478 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
      anIntArray479 = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
      anIntArray480 = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
      anIntArray481 = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
      anIntArray482 = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
      anIntArray483 = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
      anIntArray484 = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
      anIntArray485 = new int[]{41, 39248, 41, 4643, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 43086, 41, 41, 41, 41, 41, 41, 41, 8602, 41, 28992, 41, 41, 41, 41, 41, 5056, 41, 41, 41, 7079, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 3131, 41, 41, 41};
      aBooleanArrayArrayArrayArray491 = new boolean[8][32][51][51];
   }

   public WorldController(int i, int j, int[][][] pixels, int k) {
      this.anInt437 = k;
      this.anInt438 = j;
      this.anInt439 = i;
      this.groundArray = new Ground[k][j][i];
      this.anIntArrayArrayArray445 = new int[k][j + 1][i + 1];
      this.anIntArrayArrayArray440 = pixels;
      this.method274(619);
   }

   public static void method273(int i) {
      for(aClass28Array462 = null; i >= 0; anInt432 = -333) {
      }

      anIntArray473 = null;
      aClass47ArrayArray474 = null;
      aClass19_477 = null;
      aBooleanArrayArrayArrayArray491 = null;
      aBooleanArrayArray492 = null;
   }

   public void method274(int i) {
      int l1;
      int j1;
      for(l1 = 0; l1 < this.anInt437; ++l1) {
         for(j1 = 0; j1 < this.anInt438; ++j1) {
            for(int i1 = 0; i1 < this.anInt439; ++i1) {
               this.groundArray[l1][j1][i1] = null;
            }
         }
      }

      i = 37 / i;

      for(l1 = 0; l1 < anInt472; ++l1) {
         for(j1 = 0; j1 < anIntArray473[l1]; ++j1) {
            aClass47ArrayArray474[l1][j1] = null;
         }

         anIntArray473[l1] = 0;
      }

      for(l1 = 0; l1 < this.anInt443; ++l1) {
         this.aClass28Array444[l1] = null;
      }

      this.anInt443 = 0;

      for(l1 = 0; l1 < aClass28Array462.length; ++l1) {
         aClass28Array462[l1] = null;
      }

   }

   public void method275(int i, int j) {
      if (j == -34686) {
         this.anInt442 = i;

         for(int k = 0; k < this.anInt438; ++k) {
            for(int l = 0; l < this.anInt439; ++l) {
               if (this.groundArray[i][k][l] == null) {
                  this.groundArray[i][k][l] = new Ground(i, k, l);
               }
            }
         }
      }

   }

   public void method276(int i, int j) {
      Ground Ground = this.groundArray[0][j][i];

      for(int l = 0; l < 3; ++l) {
         Ground Class30_Sub1 = this.groundArray[l][j][i] = this.groundArray[l + 1][j][i];
         if (Class30_Sub1 != null) {
            --Class30_Sub1.anInt1307;

            for(int j1 = 0; j1 < Class30_Sub1.anInt1317; ++j1) {
               Object5 class28 = Class30_Sub1.obj5Array[j1];
               if ((class28.uid >> 29 & 3) == 2 && class28.anInt523 == j && class28.anInt525 == i) {
                  --class28.anInt517;
               }
            }
         }
      }

      if (this.groundArray[0][j][i] == null) {
         this.groundArray[0][j][i] = new Ground(0, j, i);
      }

      this.groundArray[0][j][i].aClass30_Sub1329 = Ground;
      this.groundArray[3][j][i] = null;
   }

   public static void method277(int i, int j, int k, int l, int i1, int j1, int l1, int i2) {
      Class47 class47 = new Class47();
      class47.anInt787 = j / 128;
      class47.anInt788 = l / 128;
      class47.anInt789 = l1 / 128;
      class47.anInt790 = i1 / 128;
      class47.anInt791 = i2;
      class47.anInt792 = j;
      class47.anInt793 = l;
      class47.anInt794 = l1;
      class47.anInt795 = i1;
      class47.anInt796 = j1;
      class47.anInt797 = k;
      aClass47ArrayArray474[i][anIntArray473[i]++] = class47;
   }

   public void method278(int i, int j, int k, int l) {
      Ground Ground = this.groundArray[i][j][k];
      if (Ground != null) {
         this.groundArray[i][j][k].anInt1321 = l;
      }

   }

   void method279(int i, int j, int k, int l, int i1, int overlaytex, int underlaytex, int k1, int l1, int i2, int j2, int k2, int l2, int i3, int j3, int k3, int l3, int i4, int j4, int k4, int l4, boolean tex) {
      Class43 class43_1;
      int j5;
      if (l == 0) {
         class43_1 = new Class43(k2, l2, i3, j3, underlaytex, k4, false, tex);

         for(j5 = i; j5 >= 0; --j5) {
            if (this.groundArray[j5][j][k] == null) {
               this.groundArray[j5][j][k] = new Ground(j5, j, k);
            }
         }

         this.groundArray[i][j][k].aClass43_1311 = class43_1;
      } else if (l != 1) {
         Class40 class40 = new Class40(k, k3, j3, i2, overlaytex, underlaytex, i4, i1, k2, k4, i3, j2, l1, k1, l, j4, l3, l2, j, l4, tex);

         for(j5 = i; j5 >= 0; --j5) {
            if (this.groundArray[j5][j][k] == null) {
               this.groundArray[j5][j][k] = new Ground(j5, j, k);
            }
         }

         this.groundArray[i][j][k].aClass40_1312 = class40;
      } else {
         class43_1 = new Class43(k3, l3, i4, j4, overlaytex, l4, k1 == l1 && k1 == i2 && k1 == j2, tex);

         for(j5 = i; j5 >= 0; --j5) {
            if (this.groundArray[j5][j][k] == null) {
               this.groundArray[j5][j][k] = new Ground(j5, j, k);
            }
         }

         this.groundArray[i][j][k].aClass43_1311 = class43_1;
      }
   }

   public void method280(int i, int j, int k, Animable class30_sub2_sub4, byte byte0, int i1, int j1, int var) {
      if (class30_sub2_sub4 != null) {
         Object3 class49 = new Object3();
         class49.aClass30_Sub2_Sub4_814 = class30_sub2_sub4;
         class49.anInt812 = j1 * 128 + 64;
         class49.anInt813 = k * 128 + 64;
         class49.anInt811 = j;
         class49.uid = i1;
         class49.aByte816 = byte0;
         class49.newuid = var;
         if (this.groundArray[i][j1][k] == null) {
            this.groundArray[i][j1][k] = new Ground(i, j1, k);
         }

         this.groundArray[i][j1][k].obj3 = class49;
      }

   }

   public void method281(byte byte0, int i, int j, Animable class30_sub2_sub4, int k, Animable class30_sub2_sub4_1, Animable class30_sub2_sub4_2, int l, int i1) {
      Object4 class3 = new Object4();
      class3.aClass30_Sub2_Sub4_48 = class30_sub2_sub4_2;
      class3.anInt46 = i * 128 + 64;
      class3.anInt47 = i1 * 128 + 64;
      if (byte0 == 7) {
         class3.anInt45 = k;
         class3.anInt51 = j;
         class3.aClass30_Sub2_Sub4_49 = class30_sub2_sub4;
         class3.aClass30_Sub2_Sub4_50 = class30_sub2_sub4_1;
         int j1 = 0;
         Ground Ground = this.groundArray[l][i][i1];
         if (Ground != null) {
            for(int k1 = 0; k1 < Ground.anInt1317; ++k1) {
               if (Ground.obj5Array[k1].aClass30_Sub2_Sub4_521 instanceof Model) {
                  int l1 = ((Model)Ground.obj5Array[k1].aClass30_Sub2_Sub4_521).anInt1654;
                  if (l1 > j1) {
                     j1 = l1;
                  }
               }
            }
         }

         class3.anInt52 = j1;
         if (this.groundArray[l][i][i1] == null) {
            this.groundArray[l][i][i1] = new Ground(l, i, i1);
         }

         this.groundArray[l][i][i1].aClass3_1316 = class3;
      }

   }

   public void method282(int i, Animable class30_sub2_sub4, int j, int k, byte byte0, int l, Animable class30_sub2_sub4_1, int i1, int j1, int k1, int var) {
      if (class30_sub2_sub4 != null || class30_sub2_sub4_1 != null) {
         Object1 class10 = new Object1();
         class10.uid = j;
         class10.aByte281 = byte0;
         class10.anInt274 = l * 128 + 64;
         class10.anInt275 = k * 128 + 64;
         class10.anInt273 = i1;
         class10.aClass30_Sub2_Sub4_278 = class30_sub2_sub4;
         class10.aClass30_Sub2_Sub4_279 = class30_sub2_sub4_1;
         class10.anInt276 = i;
         class10.anInt277 = j1;
         class10.newuid = var;

         for(int l1 = k1; l1 >= 0; --l1) {
            if (this.groundArray[l1][l][k] == null) {
               this.groundArray[l1][l][k] = new Ground(l1, l, k);
            }
         }

         this.groundArray[k1][l][k].obj1 = class10;
      }

   }

   public void method283(int i, int j, int k, int i1, int j1, int k1, Animable class30_sub2_sub4, int l1, byte byte0, int i2, int j2) {
      if (class30_sub2_sub4 != null) {
         Object2 class26 = new Object2();
         class26.uid = i;
         class26.aByte506 = byte0;
         class26.anInt500 = l1 * 128 + 64 + j1;
         class26.anInt501 = j * 128 + 64 + i2;
         class26.anInt499 = k1;
         class26.aClass30_Sub2_Sub4_504 = class30_sub2_sub4;
         class26.anInt502 = j2;
         class26.anInt503 = k;

         for(int k2 = i1; k2 >= 0; --k2) {
            if (this.groundArray[k2][l1][j] == null) {
               this.groundArray[k2][l1][j] = new Ground(k2, l1, j);
            }
         }

         this.groundArray[i1][l1][j].obj2 = class26;
      }

   }

   public boolean method284(int i, byte byte0, int j, int k, Animable class30_sub2_sub4, int l, int i1, int j1, int k1, int l1, int interactiveUID) {
      if (class30_sub2_sub4 == null) {
         return true;
      } else {
         int i2 = l1 * 128 + 64 * l;
         int j2 = k1 * 128 + 64 * k;
         return this.method287(i1, l1, k1, l, k, i2, j2, j, class30_sub2_sub4, j1, false, i, byte0, interactiveUID);
      }
   }

   public boolean method285(int i, int j, int k, int l, int i1, int j1, int k1, Animable class30_sub2_sub4, boolean flag) {
      if (class30_sub2_sub4 == null) {
         return true;
      } else {
         int l1 = k1 - j1;
         int i2 = i1 - j1;
         int j2 = k1 + j1;
         int k2 = i1 + j1;
         if (flag) {
            if (j > 640 && j < 1408) {
               k2 += 128;
            }

            if (j > 1152 && j < 1920) {
               j2 += 128;
            }

            if (j > 1664 || j < 384) {
               i2 -= 128;
            }

            if (j > 128 && j < 896) {
               l1 -= 128;
            }
         }

         l1 /= 128;
         i2 /= 128;
         j2 /= 128;
         k2 /= 128;
         return this.method287(i, l1, i2, j2 - l1 + 1, k2 - i2 + 1, k1, i1, k, class30_sub2_sub4, j, true, l, (byte)0, 0);
      }
   }

   public boolean method286(int j, int k, Animable class30_sub2_sub4, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2) {
      return class30_sub2_sub4 == null || this.method287(j, l1, k2, i2 - l1 + 1, i1 - k2 + 1, j1, k, k1, class30_sub2_sub4, l, true, j2, (byte)0, 0);
   }

   private boolean method287(int i, int j, int k, int l, int i1, int j1, int k1, int l1, Animable class30_sub2_sub4, int i2, boolean flag, int j2, byte byte0, int interactiveObjUID) {
      int i3;
      for(int var19 = j; var19 < j + l; ++var19) {
         for(i3 = k; i3 < k + i1; ++i3) {
            if (var19 < 0 || i3 < 0 || var19 >= this.anInt438 || i3 >= this.anInt439) {
               return false;
            }

            Ground var20 = this.groundArray[i][var19][i3];
            if (var20 != null && var20.anInt1317 >= 5) {
               return false;
            }
         }
      }

      Object5 var191 = new Object5();
      var191.uid = j2;
      var191.aByte530 = byte0;
      var191.anInt517 = i;
      var191.anInt519 = j1;
      var191.anInt520 = k1;
      var191.interactiveObjUID = interactiveObjUID;
      var191.anInt518 = l1;
      var191.aClass30_Sub2_Sub4_521 = class30_sub2_sub4;
      var191.anInt522 = i2;
      var191.anInt523 = j;
      var191.anInt525 = k;
      var191.anInt524 = j + l - 1;
      var191.anInt526 = k + i1 - 1;

      for(i3 = j; i3 < j + l; ++i3) {
         for(int var201 = k; var201 < k + i1; ++var201) {
            int k3 = 0;
            if (i3 > j) {
               ++k3;
            }

            if (i3 < j + l - 1) {
               k3 += 4;
            }

            if (var201 > k) {
               k3 += 8;
            }

            if (var201 < k + i1 - 1) {
               k3 += 2;
            }

            for(int var21 = i; var21 >= 0; --var21) {
               if (this.groundArray[var21][i3][var201] == null) {
                  this.groundArray[var21][i3][var201] = new Ground(var21, i3, var201);
               }
            }

            Ground var211 = this.groundArray[i][i3][var201];
            var211.obj5Array[var211.anInt1317] = var191;
            var211.anIntArray1319[var211.anInt1317] = k3;
            var211.anInt1320 |= k3;
            ++var211.anInt1317;
         }
      }

      if (flag) {
         this.aClass28Array444[this.anInt443++] = var191;
      }

      return true;
   }

   public void method288(byte byte0) {
      if (byte0 != 104) {
         this.aBoolean435 = !this.aBoolean435;
      }

      for(int i = 0; i < this.anInt443; ++i) {
         Object5 class28 = this.aClass28Array444[i];
         this.method289(-997, class28);
         this.aClass28Array444[i] = null;
      }

      this.anInt443 = 0;
   }

   private void method289(int i, Object5 class28) {
      if (i < 0) {
         for(int j = class28.anInt523; j <= class28.anInt524; ++j) {
            for(int k = class28.anInt525; k <= class28.anInt526; ++k) {
               Ground Ground = this.groundArray[class28.anInt517][j][k];
               if (Ground != null) {
                  int j1;
                  for(j1 = 0; j1 < Ground.anInt1317; ++j1) {
                     if (Ground.obj5Array[j1] == class28) {
                        --Ground.anInt1317;

                        for(int i1 = j1; i1 < Ground.anInt1317; ++i1) {
                           Ground.obj5Array[i1] = Ground.obj5Array[i1 + 1];
                           Ground.anIntArray1319[i1] = Ground.anIntArray1319[i1 + 1];
                        }

                        Ground.obj5Array[Ground.anInt1317] = null;
                        break;
                     }
                  }

                  Ground.anInt1320 = 0;

                  for(j1 = 0; j1 < Ground.anInt1317; ++j1) {
                     Ground.anInt1320 |= Ground.anIntArray1319[j1];
                  }
               }
            }
         }
      }

   }

   public void method290(int i, int k, int l, int i1) {
      Ground Ground = this.groundArray[i1][l][i];
      if (Ground != null) {
         Object2 class26 = Ground.obj2;
         if (class26 != null) {
            int j1 = l * 128 + 64;
            int k1 = i * 128 + 64;
            class26.anInt500 = j1 + (class26.anInt500 - j1) * k / 16;
            class26.anInt501 = k1 + (class26.anInt501 - k1) * k / 16;
         }
      }

   }

   public void method291(int i, int j, int k, byte byte0) {
      Ground Ground = this.groundArray[j][i][k];
      if (byte0 != -119) {
         this.aBoolean434 = !this.aBoolean434;
      }

      if (Ground != null) {
         Ground.obj1 = null;
      }

   }

   public void method292(int i, int j, int k, int l) {
      Ground Ground = this.groundArray[k][l][j];
      if (Ground != null) {
         Ground.obj2 = null;
      }

   }

   public void method293(int i, int j, int k, int l) {
      if (j >= 0) {
         for(int var8 = 1; var8 > 0; ++var8) {
         }
      }

      Ground var81 = this.groundArray[i][k][l];
      if (var81 != null) {
         for(int j1 = 0; j1 < var81.anInt1317; ++j1) {
            Object5 class28 = var81.obj5Array[j1];
            if ((class28.uid >> 29 & 3) == 2 && class28.anInt523 == k && class28.anInt525 == l) {
               this.method289(-997, class28);
               return;
            }
         }
      }

   }

   public void method294(byte byte0, int i, int j, int k) {
      Ground Ground = this.groundArray[i][k][j];
      if (Ground != null) {
         Ground.obj3 = null;
         if (byte0 == 9) {
            boolean var6 = false;
         }
      }

   }

   public void method295(int i, int j, int k) {
      Ground Ground = this.groundArray[i][j][k];
      if (Ground != null) {
         Ground.aClass3_1316 = null;
      }

   }

   public Object1 method296(int i, int j, int k, boolean flag) {
      if (flag) {
         anInt433 = -195;
      }

      Ground Ground = this.groundArray[i][j][k];
      return Ground == null ? null : Ground.obj1;
   }

   public Object2 method297(int i, int j, int k, int l) {
      if (j <= 0) {
         throw new NullPointerException();
      } else {
         Ground Ground = this.groundArray[l][i][k];
         return Ground == null ? null : Ground.obj2;
      }
   }

   public Object5 method298(int i, int j, byte byte0, int k) {
      Ground Ground = this.groundArray[k][i][j];
      if (Ground == null) {
         return null;
      } else {
         for(int l = 0; l < Ground.anInt1317; ++l) {
            Object5 class28 = Ground.obj5Array[l];
            if ((class28.uid >> 29 & 3) == 2 && class28.anInt523 == i && class28.anInt525 == j) {
               return class28;
            }
         }

         if (byte0 == 4) {
            boolean var8 = false;
         } else {
            anInt432 = -376;
         }

         return null;
      }
   }

   public Object3 method299(int i, int j, int k, int l) {
      Ground Ground = this.groundArray[k][j][i];
      if (l != 0) {
         for(int i1 = 1; i1 > 0; ++i1) {
         }
      }

      return Ground != null && Ground.obj3 != null ? Ground.obj3 : null;
   }

   public int method300(int i, int j, int k) {
      Ground tile = this.groundArray[i][j][k];
      return tile != null && tile.obj1 != null ? tile.obj1.uid : 0;
   }

   public int method301(int i, int j, int l) {
      Ground class30_sub3 = this.groundArray[i][j][l];
      return class30_sub3 != null && class30_sub3.obj2 != null ? class30_sub3.obj2.uid : 0;
   }

   public int fetchWallObjectNewUID(int i, int j, int k) {
      Ground tile = this.groundArray[i][j][k];
      return tile != null && tile.obj1 != null ? tile.obj1.newuid : 0;
   }

   public int method302(int i, int j, int k) {
      Ground class30_sub3 = this.groundArray[i][j][k];
      if (class30_sub3 == null) {
         return 0;
      } else {
         for(int l = 0; l < class30_sub3.anInt1317; ++l) {
            Object5 class28 = class30_sub3.obj5Array[l];
            if (class28.anInt523 == j && class28.anInt525 == k) {
               return class28.uid;
            }
         }

         return 0;
      }
   }

   public int fetchObjectMeshNewUID(int z, int x, int y) {
      Ground tile = this.groundArray[z][x][y];
      if (tile == null) {
         return 0;
      } else {
         for(int l = 0; l < tile.anInt1317; ++l) {
            Object5 interactableObject = tile.obj5Array[l];
            if (interactableObject.anInt523 == x && interactableObject.anInt525 == y) {
               return interactableObject.interactiveObjUID;
            }
         }

         return 0;
      }
   }

   public int method303(int i, int j, int k) {
      Ground tile = this.groundArray[i][j][k];
      return tile != null && tile.obj3 != null ? tile.obj3.uid : 0;
   }

   public int fetchGroundDecorationNewUID(int i, int j, int k) {
      Ground tile = this.groundArray[i][j][k];
      return tile != null && tile.obj3 != null ? tile.obj3.newuid : 0;
   }

   public int method304(int i, int j, int k, int l) {
      Ground class30_sub3 = this.groundArray[i][j][k];
      if (class30_sub3 == null) {
         return -1;
      } else if (class30_sub3.obj1 != null && class30_sub3.obj1.uid == l) {
         return class30_sub3.obj1.aByte281 & 255;
      } else if (class30_sub3.obj2 != null && class30_sub3.obj2.uid == l) {
         return class30_sub3.obj2.aByte506 & 255;
      } else if (class30_sub3.obj3 != null && class30_sub3.obj3.uid == l) {
         return class30_sub3.obj3.aByte816 & 255;
      } else {
         for(int i1 = 0; i1 < class30_sub3.anInt1317; ++i1) {
            if (class30_sub3.obj5Array[i1].uid == l) {
               return class30_sub3.obj5Array[i1].aByte530 & 255;
            }
         }

         return -1;
      }
   }

   public int fetchWallDecorationNewUID(int i, int j, int l) {
      Ground tile = this.groundArray[i][j][l];
      return tile != null && tile.obj2 != null ? tile.obj2.newuid : 0;
   }

   public void method305(int i, int k, int i1) {
      byte j = 100;
      short l = 5500;
      int j1 = (int)Math.sqrt((double)(k * k + i * i + i1 * i1));
      int k1 = l >> 4;

      for(int l1 = 0; l1 < this.anInt437; ++l1) {
         for(int i2 = 0; i2 < this.anInt438; ++i2) {
            for(int j2 = 0; j2 < this.anInt439; ++j2) {
               Ground Ground = this.groundArray[l1][i2][j2];
               if (Ground != null) {
                  Object1 class10 = Ground.obj1;
                  if (class10 != null && class10.aClass30_Sub2_Sub4_278 != null && class10.aClass30_Sub2_Sub4_278.aClass33Array1425 != null) {
                     this.method307(l1, 1, 1, i2, (byte)115, j2, (Model)class10.aClass30_Sub2_Sub4_278);
                     if (class10.aClass30_Sub2_Sub4_279 != null && class10.aClass30_Sub2_Sub4_279.aClass33Array1425 != null) {
                        this.method307(l1, 1, 1, i2, (byte)115, j2, (Model)class10.aClass30_Sub2_Sub4_279);
                        this.method308((Model)class10.aClass30_Sub2_Sub4_278, (Model)class10.aClass30_Sub2_Sub4_279, 0, 0, 0, false);
                        ((Model)class10.aClass30_Sub2_Sub4_279).method480(j, k1, k, i, i1);
                     }

                     ((Model)class10.aClass30_Sub2_Sub4_278).method480(j, k1, k, i, i1);
                  }

                  for(int var15 = 0; var15 < Ground.anInt1317; ++var15) {
                     Object5 class28 = Ground.obj5Array[var15];
                     if (class28 != null && class28.aClass30_Sub2_Sub4_521 != null && class28.aClass30_Sub2_Sub4_521.aClass33Array1425 != null) {
                        this.method307(l1, class28.anInt524 - class28.anInt523 + 1, class28.anInt526 - class28.anInt525 + 1, i2, (byte)115, j2, (Model)class28.aClass30_Sub2_Sub4_521);
                        ((Model)class28.aClass30_Sub2_Sub4_521).method480(j, k1, k, i, i1);
                     }
                  }

                  Object3 var151 = Ground.obj3;
                  if (var151 != null && var151.aClass30_Sub2_Sub4_814.aClass33Array1425 != null) {
                     this.method306(i2, l1, (Model)var151.aClass30_Sub2_Sub4_814, (byte)37, j2);
                     ((Model)var151.aClass30_Sub2_Sub4_814).method480(j, k1, k, i, i1);
                  }
               }
            }
         }
      }

   }

   private void method306(int i, int j, Model Model, byte byte0, int k) {
      if (byte0 != 37) {
         for(int var7 = 1; var7 > 0; ++var7) {
         }
      }

      Ground var71;
      if (i < this.anInt438) {
         var71 = this.groundArray[j][i + 1][k];
         if (var71 != null && var71.obj3 != null && var71.obj3.aClass30_Sub2_Sub4_814.aClass33Array1425 != null) {
            this.method308(Model, (Model)var71.obj3.aClass30_Sub2_Sub4_814, 128, 0, 0, true);
         }
      }

      if (k < this.anInt438) {
         var71 = this.groundArray[j][i][k + 1];
         if (var71 != null && var71.obj3 != null && var71.obj3.aClass30_Sub2_Sub4_814.aClass33Array1425 != null) {
            this.method308(Model, (Model)var71.obj3.aClass30_Sub2_Sub4_814, 0, 0, 128, true);
         }
      }

      if (i < this.anInt438 && k < this.anInt439) {
         var71 = this.groundArray[j][i + 1][k + 1];
         if (var71 != null && var71.obj3 != null && var71.obj3.aClass30_Sub2_Sub4_814.aClass33Array1425 != null) {
            this.method308(Model, (Model)var71.obj3.aClass30_Sub2_Sub4_814, 128, 0, 128, true);
         }
      }

      if (i < this.anInt438 && k > 0) {
         var71 = this.groundArray[j][i + 1][k - 1];
         if (var71 != null && var71.obj3 != null && var71.obj3.aClass30_Sub2_Sub4_814.aClass33Array1425 != null) {
            this.method308(Model, (Model)var71.obj3.aClass30_Sub2_Sub4_814, 128, 0, -128, true);
         }
      }

   }

   private void method307(int i, int j, int k, int l, byte byte0, int i1, Model Model) {
      boolean flag = true;
      if (byte0 != 115) {
         anInt431 = 350;
      }

      int j1 = l;
      int k1 = l + j;
      int l1 = i1 - 1;
      int i2 = i1 + k;

      for(int j2 = i; j2 <= i + 1; ++j2) {
         if (j2 != this.anInt437) {
            for(int k2 = j1; k2 <= k1; ++k2) {
               if (k2 >= 0 && k2 < this.anInt438) {
                  for(int l2 = l1; l2 <= i2; ++l2) {
                     if (l2 >= 0 && l2 < this.anInt439 && (!flag || k2 >= k1 || l2 >= i2 || l2 < i1 && k2 != l)) {
                        Ground Ground = this.groundArray[j2][k2][l2];
                        if (Ground != null) {
                           int i3 = (this.anIntArrayArrayArray440[j2][k2][l2] + this.anIntArrayArrayArray440[j2][k2 + 1][l2] + this.anIntArrayArrayArray440[j2][k2][l2 + 1] + this.anIntArrayArrayArray440[j2][k2 + 1][l2 + 1]) / 4 - (this.anIntArrayArrayArray440[i][l][i1] + this.anIntArrayArrayArray440[i][l + 1][i1] + this.anIntArrayArrayArray440[i][l][i1 + 1] + this.anIntArrayArrayArray440[i][l + 1][i1 + 1]) / 4;
                           Object1 class10 = Ground.obj1;
                           if (class10 != null && class10.aClass30_Sub2_Sub4_278 != null && class10.aClass30_Sub2_Sub4_278.aClass33Array1425 != null) {
                              this.method308(Model, (Model)class10.aClass30_Sub2_Sub4_278, (k2 - l) * 128 + (1 - j) * 64, i3, (l2 - i1) * 128 + (1 - k) * 64, flag);
                           }

                           if (class10 != null && class10.aClass30_Sub2_Sub4_279 != null && class10.aClass30_Sub2_Sub4_279.aClass33Array1425 != null) {
                              this.method308(Model, (Model)class10.aClass30_Sub2_Sub4_279, (k2 - l) * 128 + (1 - j) * 64, i3, (l2 - i1) * 128 + (1 - k) * 64, flag);
                           }

                           for(int j3 = 0; j3 < Ground.anInt1317; ++j3) {
                              Object5 class28 = Ground.obj5Array[j3];
                              if (class28 != null && class28.aClass30_Sub2_Sub4_521 != null && class28.aClass30_Sub2_Sub4_521.aClass33Array1425 != null) {
                                 int k3 = class28.anInt524 - class28.anInt523 + 1;
                                 int l3 = class28.anInt526 - class28.anInt525 + 1;
                                 this.method308(Model, (Model)class28.aClass30_Sub2_Sub4_521, (class28.anInt523 - l) * 128 + (k3 - j) * 64, i3, (class28.anInt525 - i1) * 128 + (l3 - k) * 64, flag);
                              }
                           }
                        }
                     }
                  }
               }
            }

            --j1;
            flag = false;
         }
      }

   }

   private void method308(Model Model, Model Model_1, int i, int j, int k, boolean flag) {
      ++this.anInt488;
      int l = 0;
      int[] pixels = Model_1.verticesXCoordinate;
      int i1 = Model_1.numberOfVerticeCoordinates;

      int l1;
      for(l1 = 0; l1 < Model.numberOfVerticeCoordinates; ++l1) {
         VertexNormal class33 = Model.aClass33Array1425[l1];
         VertexNormal class33_1 = Model.aClass33Array1660[l1];
         if (class33_1.anInt605 != 0) {
            int i2 = Model.verticesYCoordinate[l1] - j;
            if (i2 <= Model_1.anInt1651) {
               int j2 = Model.verticesXCoordinate[l1] - i;
               if (j2 >= Model_1.anInt1646 && j2 <= Model_1.anInt1647) {
                  int k2 = Model.verticesZCoordinate[l1] - k;
                  if (k2 >= Model_1.anInt1649 && k2 <= Model_1.anInt1648) {
                     for(int l2 = 0; l2 < i1; ++l2) {
                        VertexNormal class33_2 = Model_1.aClass33Array1425[l2];
                        VertexNormal class33_3 = Model_1.aClass33Array1660[l2];
                        if (j2 == pixels[l2] && k2 == Model_1.verticesZCoordinate[l2] && i2 == Model_1.verticesYCoordinate[l2] && class33_3.anInt605 != 0) {
                           class33.anInt602 += class33_3.anInt602;
                           class33.anInt603 += class33_3.anInt603;
                           class33.anInt604 += class33_3.anInt604;
                           class33.anInt605 += class33_3.anInt605;
                           class33_2.anInt602 += class33_1.anInt602;
                           class33_2.anInt603 += class33_1.anInt603;
                           class33_2.anInt604 += class33_1.anInt604;
                           class33_2.anInt605 += class33_1.anInt605;
                           ++l;
                           this.anIntArray486[l1] = this.anInt488;
                           this.anIntArray487[l2] = this.anInt488;
                        }
                     }
                  }
               }
            }
         }
      }

      if (l >= 3 && flag) {
         for(l1 = 0; l1 < Model.numberOfTriangleFaces; ++l1) {
            if (this.anIntArray486[Model.face_a[l1]] == this.anInt488 && this.anIntArray486[Model.face_b[l1]] == this.anInt488 && this.anIntArray486[Model.face_c[l1]] == this.anInt488) {
               Model.face_render_type[l1] = -1;
            }
         }

         for(l1 = 0; l1 < Model_1.numberOfTriangleFaces; ++l1) {
            if (this.anIntArray487[Model_1.face_a[l1]] == this.anInt488 && this.anIntArray487[Model_1.face_b[l1]] == this.anInt488 && this.anIntArray487[Model_1.face_c[l1]] == this.anInt488) {
               Model_1.face_render_type[l1] = -1;
            }
         }
      }

   }

   public void method309(int[] pixels, int pixelOffset, int z, int x, int y) {
      int j = 512;
      Ground Ground = this.groundArray[z][x][y];
      if (Ground != null) {
         Class43 class43 = Ground.aClass43_1311;
         int k1;
         if (class43 == null) {
            Class40 class40 = Ground.aClass40_1312;
            if (class40 != null) {
               k1 = class40.anInt684;
               int i2 = class40.anInt685;
               int j2 = class40.anInt686;
               int k2 = class40.anInt687;
               int[] ai1 = this.anIntArrayArray489[k1];
               int[] ai2 = this.anIntArrayArray490[i2];
               int l2 = 0;
               int j3;
               if (j2 != 0) {
                  for(j3 = 0; j3 < 4; ++j3) {
                     pixels[pixelOffset] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                     pixels[pixelOffset + 1] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                     pixels[pixelOffset + 2] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                     pixels[pixelOffset + 3] = ai1[ai2[l2++]] != 0 ? k2 : j2;
                     pixelOffset += j;
                  }

               } else {
                  for(j3 = 0; j3 < 4; ++j3) {
                     if (ai1[ai2[l2++]] != 0) {
                        pixels[pixelOffset] = k2;
                     }

                     if (ai1[ai2[l2++]] != 0) {
                        pixels[pixelOffset + 1] = k2;
                     }

                     if (ai1[ai2[l2++]] != 0) {
                        pixels[pixelOffset + 2] = k2;
                     }

                     if (ai1[ai2[l2++]] != 0) {
                        pixels[pixelOffset + 3] = k2;
                     }

                     pixelOffset += j;
                  }

               }
            }
         } else {
            int j1 = class43.anInt722;
            if (j1 != 0) {
               for(k1 = 0; k1 < 4; ++k1) {
                  pixels[pixelOffset] = j1;
                  pixels[pixelOffset + 1] = j1;
                  pixels[pixelOffset + 2] = j1;
                  pixels[pixelOffset + 3] = j1;
                  pixelOffset += j;
               }

            }
         }
      }
   }

   public static void method310(int i, int j, int k, int l, int[] pixels) {
      anInt495 = 0;
      anInt496 = 0;
      anInt497 = k;
      anInt498 = l;
      anInt493 = k / 2;
      anInt494 = l / 2;
      boolean[][][][] aflag = new boolean[9][32][53][53];

      int k1;
      int i2;
      int k2;
      int i3;
      int l3;
      int j4;
      for(k1 = 128; k1 <= 384; k1 += 32) {
         for(i2 = 0; i2 < 2048; i2 += 64) {
            anInt458 = Model.SINE[k1];
            anInt459 = Model.COSINE[k1];
            anInt460 = Model.SINE[i2];
            anInt461 = Model.COSINE[i2];
            k2 = (k1 - 128) / 32;
            i3 = i2 / 64;

            for(int var16 = -26; var16 <= 26; ++var16) {
               for(l3 = -26; l3 <= 26; ++l3) {
                  j4 = var16 * 128;
                  int i4 = l3 * 128;
                  boolean flag2 = false;

                  for(int k4 = -i; k4 <= j; k4 += 128) {
                     if (method311(pixels[k2] + k4, i4, j4)) {
                        flag2 = true;
                        break;
                     }
                  }

                  aflag[k2][i3][var16 + 25 + 1][l3 + 25 + 1] = flag2;
               }
            }
         }
      }

      for(k1 = 0; k1 < 8; ++k1) {
         for(i2 = 0; i2 < 32; ++i2) {
            for(k2 = -25; k2 < 25; ++k2) {
               for(i3 = -25; i3 < 25; ++i3) {
                  boolean var161 = false;

                  label76:
                  for(l3 = -1; l3 <= 1; ++l3) {
                     for(j4 = -1; j4 <= 1; ++j4) {
                        if (aflag[k1][i2][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1]) {
                           var161 = true;
                           break label76;
                        }

                        if (aflag[k1][(i2 + 1) % 31][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1]) {
                           var161 = true;
                           break label76;
                        }

                        if (aflag[k1 + 1][i2][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1]) {
                           var161 = true;
                           break label76;
                        }

                        if (aflag[k1 + 1][(i2 + 1) % 31][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1]) {
                           var161 = true;
                           break label76;
                        }
                     }
                  }

                  aBooleanArrayArrayArrayArray491[k1][i2][k2 + 25][i3 + 25] = var161;
               }
            }
         }
      }

   }

   private static boolean method311(int i, int j, int k) {
      int l = j * anInt460 + k * anInt461 >> 16;
      int i1 = j * anInt461 - k * anInt460 >> 16;
      int j1 = i * anInt458 + i1 * anInt459 >> 16;
      int k1 = i * anInt459 - i1 * anInt458 >> 16;
      if (j1 >= 50 && j1 <= 3500) {
         int l1 = anInt493 + (l << WorldController.focalLength) / j1;
         int i2 = anInt494 + (k1 << WorldController.focalLength) / j1;
         return l1 >= anInt495 && l1 <= anInt497 && i2 >= anInt496 && i2 <= anInt498;
      } else {
         return false;
      }
   }

   public void method312(int i, int j) {
      aBoolean467 = true;
      anInt468 = j;
      anInt469 = i;
      anInt470 = -1;
      anInt471 = -1;
   }

   public void method313(int i, int j, int k, int l, int i1, int j1) {
      if (i < 0) {
         i = 0;
      } else if (i >= this.anInt438 * 128) {
         i = this.anInt438 * 128 - 1;
      }

      if (j < 0) {
         j = 0;
      } else if (j >= this.anInt439 * 128) {
         j = this.anInt439 * 128 - 1;
      }

      ++anInt448;
      anInt458 = Model.SINE[j1];
      anInt459 = Model.COSINE[j1];
      anInt460 = Model.SINE[k];
      anInt461 = Model.COSINE[k];
      aBooleanArrayArray492 = aBooleanArrayArrayArrayArray491[(j1 - 128) / 32][k / 64];
      anInt455 = i;
      cameraY = l;
      cameraZ = j;
      anInt453 = i / 128;
      anInt454 = j / 128;
      anInt447 = i1;
      anInt449 = anInt453 - 25;
      if (anInt449 < 0) {
         anInt449 = 0;
      }

      anInt451 = anInt454 - 25;
      if (anInt451 < 0) {
         anInt451 = 0;
      }

      anInt450 = anInt453 + 25;
      if (anInt450 > this.anInt438) {
         anInt450 = this.anInt438;
      }

      anInt452 = anInt454 + 25;
      if (anInt452 > this.anInt439) {
         anInt452 = this.anInt439;
      }

      this.method319();
      anInt446 = 0;

      int k1;
      Ground[][] aGround_2;
      int i2;
      int l3;
      for(k1 = this.anInt442; k1 < this.anInt437; ++k1) {
         aGround_2 = this.groundArray[k1];

         for(i2 = anInt449; i2 < anInt450; ++i2) {
            for(l3 = anInt451; l3 < anInt452; ++l3) {
               Ground Ground = aGround_2[i2][l3];
               if (Ground != null) {
                  if (Ground.anInt1321 > i1 || !aBooleanArrayArray492[i2 - anInt453 + 25][l3 - anInt454 + 25] && this.anIntArrayArrayArray440[k1][i2][l3] - l < 2000) {
                     Ground.aBoolean1322 = false;
                     Ground.aBoolean1323 = false;
                     Ground.anInt1325 = 0;
                  } else {
                     Ground.aBoolean1322 = true;
                     Ground.aBoolean1323 = true;
                     Ground.aBoolean1324 = Ground.anInt1317 > 0;
                     ++anInt446;
                  }
               }
            }
         }
      }

      int l4;
      int j5;
      int k5;
      Ground Ground_8;
      int j4;
      for(k1 = this.anInt442; k1 < this.anInt437; ++k1) {
         aGround_2 = this.groundArray[k1];

         for(i2 = -25; i2 <= 0; ++i2) {
            l3 = anInt453 + i2;
            j4 = anInt453 - i2;
            if (l3 >= anInt449 || j4 < anInt450) {
               for(l4 = -25; l4 <= 0; ++l4) {
                  j5 = anInt454 + l4;
                  k5 = anInt454 - l4;
                  if (l3 >= anInt449) {
                     if (j5 >= anInt451) {
                        Ground_8 = aGround_2[l3][j5];
                        if (Ground_8 != null && Ground_8.aBoolean1322) {
                           this.method314(Ground_8, true);
                        }
                     }

                     if (k5 < anInt452) {
                        Ground_8 = aGround_2[l3][k5];
                        if (Ground_8 != null && Ground_8.aBoolean1322) {
                           this.method314(Ground_8, true);
                        }
                     }
                  }

                  if (j4 < anInt450) {
                     if (j5 >= anInt451) {
                        Ground_8 = aGround_2[j4][j5];
                        if (Ground_8 != null && Ground_8.aBoolean1322) {
                           this.method314(Ground_8, true);
                        }
                     }

                     if (k5 < anInt452) {
                        Ground_8 = aGround_2[j4][k5];
                        if (Ground_8 != null && Ground_8.aBoolean1322) {
                           this.method314(Ground_8, true);
                        }
                     }
                  }

                  if (anInt446 == 0) {
                     aBoolean467 = false;
                     return;
                  }
               }
            }
         }
      }

      for(k1 = this.anInt442; k1 < this.anInt437; ++k1) {
         aGround_2 = this.groundArray[k1];

         for(i2 = -25; i2 <= 0; ++i2) {
            l3 = anInt453 + i2;
            j4 = anInt453 - i2;
            if (l3 >= anInt449 || j4 < anInt450) {
               for(l4 = -25; l4 <= 0; ++l4) {
                  j5 = anInt454 + l4;
                  k5 = anInt454 - l4;
                  if (l3 >= anInt449) {
                     if (j5 >= anInt451) {
                        Ground_8 = aGround_2[l3][j5];
                        if (Ground_8 != null && Ground_8.aBoolean1322) {
                           this.method314(Ground_8, false);
                        }
                     }

                     if (k5 < anInt452) {
                        Ground_8 = aGround_2[l3][k5];
                        if (Ground_8 != null && Ground_8.aBoolean1322) {
                           this.method314(Ground_8, false);
                        }
                     }
                  }

                  if (j4 < anInt450) {
                     if (j5 >= anInt451) {
                        Ground_8 = aGround_2[j4][j5];
                        if (Ground_8 != null && Ground_8.aBoolean1322) {
                           this.method314(Ground_8, false);
                        }
                     }

                     if (k5 < anInt452) {
                        Ground_8 = aGround_2[j4][k5];
                        if (Ground_8 != null && Ground_8.aBoolean1322) {
                           this.method314(Ground_8, false);
                        }
                     }
                  }

                  if (anInt446 == 0) {
                     aBoolean467 = false;
                     return;
                  }
               }
            }
         }
      }

      aBoolean467 = false;
   }

   public void method314(Ground Ground, boolean flag) {
      aClass19_477.insertHead(Ground);

      while(true) {
         Ground Class30_Sub1;
         int i;
         int j;
         int k;
         int l;
         Ground[][] aGround;
         Ground class3;
         int class10_2;
         int k5;
         int j6;
         int l7;
         int j9;
         int j10;
         int var27;
         int var281;
         do {
            do {
               do {
                  do {
                     do {
                        do {
                           while(true) {
                              Object1 Class30_Sub16;
                              Object5 j3;
                              int var23;
                              boolean var24;
                              Ground var35;
                              int var31;
                              while(true) {
                                 do {
                                    Class30_Sub1 = (Ground)aClass19_477.popHead();
                                    if (Class30_Sub1 == null) {
                                       return;
                                    }
                                 } while(!Class30_Sub1.aBoolean1323);

                                 i = Class30_Sub1.anInt1308;
                                 j = Class30_Sub1.anInt1309;
                                 k = Class30_Sub1.anInt1307;
                                 l = Class30_Sub1.anInt1310;
                                 aGround = this.groundArray[k];
                                 if (!Class30_Sub1.aBoolean1322) {
                                    break;
                                 }

                                 if (flag) {
                                    if (k > 0) {
                                       class3 = this.groundArray[k - 1][i][j];
                                       if (class3 != null && class3.aBoolean1323) {
                                          continue;
                                       }
                                    }

                                    if (i <= anInt453 && i > anInt449) {
                                       class3 = aGround[i - 1][j];
                                       if (class3 != null && class3.aBoolean1323 && (class3.aBoolean1322 || (Class30_Sub1.anInt1320 & 1) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (i >= anInt453 && i < anInt450 - 1) {
                                       class3 = aGround[i + 1][j];
                                       if (class3 != null && class3.aBoolean1323 && (class3.aBoolean1322 || (Class30_Sub1.anInt1320 & 4) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (j <= anInt454 && j > anInt451) {
                                       class3 = aGround[i][j - 1];
                                       if (class3 != null && class3.aBoolean1323 && (class3.aBoolean1322 || (Class30_Sub1.anInt1320 & 8) == 0)) {
                                          continue;
                                       }
                                    }

                                    if (j >= anInt454 && j < anInt452 - 1) {
                                       class3 = aGround[i][j + 1];
                                       if (class3 != null && class3.aBoolean1323 && (class3.aBoolean1322 || (Class30_Sub1.anInt1320 & 2) == 0)) {
                                          continue;
                                       }
                                    }
                                 } else {
                                    flag = true;
                                 }

                                 Class30_Sub1.aBoolean1322 = false;
                                 if (Class30_Sub1.aClass30_Sub1329 != null) {
                                    class3 = Class30_Sub1.aClass30_Sub1329;
                                    if (class3.aClass43_1311 != null) {
                                       if (!this.method320(0, i, j)) {
                                          this.method315(class3.aClass43_1311, 0, anInt458, anInt459, anInt460, anInt461, i, j);
                                       }
                                    } else if (class3.aClass40_1312 != null && !this.method320(0, i, j)) {
                                       this.method316(i, anInt458, anInt460, class3.aClass40_1312, anInt459, j, anInt461);
                                    }

                                    Class30_Sub16 = class3.obj1;
                                    if (Class30_Sub16 != null) {
                                       Class30_Sub16.aClass30_Sub2_Sub4_278.method443(0, anInt458, anInt459, anInt460, anInt461, Class30_Sub16.anInt274 - anInt455, Class30_Sub16.anInt273 - cameraY, Class30_Sub16.anInt275 - cameraZ, Class30_Sub16.uid, Class30_Sub16.newuid);
                                    }

                                    for(class10_2 = 0; class10_2 < class3.anInt1317; ++class10_2) {
                                       j3 = class3.obj5Array[class10_2];
                                       if (j3 != null) {
                                          j3.aClass30_Sub2_Sub4_521.method443(j3.anInt522, anInt458, anInt459, anInt460, anInt461, j3.anInt519 - anInt455, j3.anInt518 - cameraY, j3.anInt520 - cameraZ, j3.uid, j3.interactiveObjUID);
                                       }
                                    }
                                 }

                                 var24 = false;
                                 if (Class30_Sub1.aClass43_1311 != null) {
                                    if (!this.method320(l, i, j)) {
                                       var24 = true;
                                       this.method315(Class30_Sub1.aClass43_1311, l, anInt458, anInt459, anInt460, anInt461, i, j);
                                    }
                                 } else if (Class30_Sub1.aClass40_1312 != null && !this.method320(l, i, j)) {
                                    var24 = true;
                                    this.method316(i, anInt458, anInt460, Class30_Sub1.aClass40_1312, anInt459, j, anInt461);
                                 }

                                 var23 = 0;
                                 class10_2 = 0;
                                 Object1 var26 = Class30_Sub1.obj1;
                                 Object2 var28 = Class30_Sub1.obj2;
                                 if (var26 != null || var28 != null) {
                                    if (anInt453 == i) {
                                       ++var23;
                                    } else if (anInt453 < i) {
                                       var23 += 2;
                                    }

                                    if (anInt454 == j) {
                                       var23 += 3;
                                    } else if (anInt454 > j) {
                                       var23 += 6;
                                    }

                                    class10_2 = anIntArray478[var23];
                                    Class30_Sub1.anInt1328 = anIntArray480[var23];
                                 }

                                 if (var26 != null) {
                                    if ((var26.anInt276 & anIntArray479[var23]) != 0) {
                                       if (var26.anInt276 == 16) {
                                          Class30_Sub1.anInt1325 = 3;
                                          Class30_Sub1.anInt1326 = anIntArray481[var23];
                                          Class30_Sub1.anInt1327 = 3 - Class30_Sub1.anInt1326;
                                       } else if (var26.anInt276 == 32) {
                                          Class30_Sub1.anInt1325 = 6;
                                          Class30_Sub1.anInt1326 = anIntArray482[var23];
                                          Class30_Sub1.anInt1327 = 6 - Class30_Sub1.anInt1326;
                                       } else if (var26.anInt276 == 64) {
                                          Class30_Sub1.anInt1325 = 12;
                                          Class30_Sub1.anInt1326 = anIntArray483[var23];
                                          Class30_Sub1.anInt1327 = 12 - Class30_Sub1.anInt1326;
                                       } else {
                                          Class30_Sub1.anInt1325 = 9;
                                          Class30_Sub1.anInt1326 = anIntArray484[var23];
                                          Class30_Sub1.anInt1327 = 9 - Class30_Sub1.anInt1326;
                                       }
                                    } else {
                                       Class30_Sub1.anInt1325 = 0;
                                    }

                                    if ((var26.anInt276 & class10_2) != 0 && !this.method321(l, i, j, var26.anInt276)) {
                                       var26.aClass30_Sub2_Sub4_278.method443(0, anInt458, anInt459, anInt460, anInt461, var26.anInt274 - anInt455, var26.anInt273 - cameraY, var26.anInt275 - cameraZ, var26.uid, var26.newuid);
                                    }

                                    if ((var26.anInt277 & class10_2) != 0 && !this.method321(l, i, j, var26.anInt277)) {
                                       var26.aClass30_Sub2_Sub4_279.method443(0, anInt458, anInt459, anInt460, anInt461, var26.anInt274 - anInt455, var26.anInt273 - cameraY, var26.anInt275 - cameraZ, var26.uid, var26.newuid);
                                    }
                                 }

                                 if (var28 != null && !this.method322(l, i, j, var28.aClass30_Sub2_Sub4_504.modelHeight)) {
                                    if ((var28.anInt502 & class10_2) != 0) {
                                       var28.aClass30_Sub2_Sub4_504.method443(var28.anInt503, anInt458, anInt459, anInt460, anInt461, var28.anInt500 - anInt455, var28.anInt499 - cameraY, var28.anInt501 - cameraZ, var28.uid, var28.newuid);
                                    } else if ((var28.anInt502 & 768) != 0) {
                                       k5 = var28.anInt500 - anInt455;
                                       j6 = var28.anInt499 - cameraY;
                                       l7 = var28.anInt501 - cameraZ;
                                       j9 = var28.anInt503;
                                       if (j9 != 1 && j9 != 2) {
                                          j10 = k5;
                                       } else {
                                          j10 = -k5;
                                       }

                                       if (j9 != 2 && j9 != 3) {
                                          var31 = l7;
                                       } else {
                                          var31 = -l7;
                                       }

                                       int var34;
                                       int var30;
                                       if ((var28.anInt502 & 256) != 0 && var31 < j10) {
                                          var34 = k5 + anIntArray463[j9];
                                          var30 = l7 + anIntArray464[j9];
                                          var28.aClass30_Sub2_Sub4_504.method443(j9 * 512 + 256, anInt458, anInt459, anInt460, anInt461, var34, j6, var30, var28.uid, var28.newuid);
                                       }

                                       if ((var28.anInt502 & 512) != 0 && var31 > j10) {
                                          var34 = k5 + anIntArray465[j9];
                                          var30 = l7 + anIntArray466[j9];
                                          var28.aClass30_Sub2_Sub4_504.method443(j9 * 512 + 1280 & 2047, anInt458, anInt459, anInt460, anInt461, var34, j6, var30, var28.uid, var28.newuid);
                                       }
                                    }
                                 }

                                 if (var24) {
                                    Object3 var29 = Class30_Sub1.obj3;
                                    if (var29 != null) {
                                       var29.aClass30_Sub2_Sub4_814.method443(0, anInt458, anInt459, anInt460, anInt461, var29.anInt812 - anInt455, var29.anInt811 - cameraY, var29.anInt813 - cameraZ, var29.uid, var29.newuid);
                                    }

                                    Object4 var301 = Class30_Sub1.aClass3_1316;
                                    if (var301 != null && var301.anInt52 == 0) {
                                       if (var301.aClass30_Sub2_Sub4_49 != null) {
                                          var301.aClass30_Sub2_Sub4_49.method443(0, anInt458, anInt459, anInt460, anInt461, var301.anInt46 - anInt455, var301.anInt45 - cameraY, var301.anInt47 - cameraZ, var301.anInt51, var301.newuid);
                                       }

                                       if (var301.aClass30_Sub2_Sub4_50 != null) {
                                          var301.aClass30_Sub2_Sub4_50.method443(0, anInt458, anInt459, anInt460, anInt461, var301.anInt46 - anInt455, var301.anInt45 - cameraY, var301.anInt47 - cameraZ, var301.anInt51, var301.newuid);
                                       }

                                       if (var301.aClass30_Sub2_Sub4_48 != null) {
                                          var301.aClass30_Sub2_Sub4_48.method443(0, anInt458, anInt459, anInt460, anInt461, var301.anInt46 - anInt455, var301.anInt45 - cameraY, var301.anInt47 - cameraZ, var301.anInt51, var301.newuid);
                                       }
                                    }
                                 }

                                 k5 = Class30_Sub1.anInt1320;
                                 if (k5 != 0) {
                                    if (i < anInt453 && (k5 & 4) != 0) {
                                       var35 = aGround[i + 1][j];
                                       if (var35 != null && var35.aBoolean1323) {
                                          aClass19_477.insertHead(var35);
                                       }
                                    }

                                    if (j < anInt454 && (k5 & 2) != 0) {
                                       var35 = aGround[i][j + 1];
                                       if (var35 != null && var35.aBoolean1323) {
                                          aClass19_477.insertHead(var35);
                                       }
                                    }

                                    if (i > anInt453 && (k5 & 1) != 0) {
                                       var35 = aGround[i - 1][j];
                                       if (var35 != null && var35.aBoolean1323) {
                                          aClass19_477.insertHead(var35);
                                       }
                                    }

                                    if (j > anInt454 && (k5 & 8) != 0) {
                                       var35 = aGround[i][j - 1];
                                       if (var35 != null && var35.aBoolean1323) {
                                          aClass19_477.insertHead(var35);
                                       }
                                    }
                                 }
                                 break;
                              }

                              if (Class30_Sub1.anInt1325 != 0) {
                                 var24 = true;

                                 for(var23 = 0; var23 < Class30_Sub1.anInt1317; ++var23) {
                                    if (Class30_Sub1.obj5Array[var23].anInt528 != anInt448 && (Class30_Sub1.anIntArray1319[var23] & Class30_Sub1.anInt1325) == Class30_Sub1.anInt1326) {
                                       var24 = false;
                                       break;
                                    }
                                 }

                                 if (var24) {
                                    Class30_Sub16 = Class30_Sub1.obj1;
                                    if (!this.method321(l, i, j, Class30_Sub16.anInt276)) {
                                       Class30_Sub16.aClass30_Sub2_Sub4_278.method443(0, anInt458, anInt459, anInt460, anInt461, Class30_Sub16.anInt274 - anInt455, Class30_Sub16.anInt273 - cameraY, Class30_Sub16.anInt275 - cameraZ, Class30_Sub16.uid, Class30_Sub16.newuid);
                                    }

                                    Class30_Sub1.anInt1325 = 0;
                                 }
                              }

                              if (!Class30_Sub1.aBoolean1324) {
                                 break;
                              }

                              try {
                                 var31 = Class30_Sub1.anInt1317;
                                 Class30_Sub1.aBoolean1324 = false;
                                 var23 = 0;

                                 label561:
                                 for(class10_2 = 0; class10_2 < var31; ++class10_2) {
                                    j3 = Class30_Sub1.obj5Array[class10_2];
                                    if (j3.anInt528 != anInt448) {
                                       for(var281 = j3.anInt523; var281 <= j3.anInt524; ++var281) {
                                          for(k5 = j3.anInt525; k5 <= j3.anInt526; ++k5) {
                                             var35 = aGround[var281][k5];
                                             if (var35.aBoolean1322) {
                                                Class30_Sub1.aBoolean1324 = true;
                                                continue label561;
                                             }

                                             if (var35.anInt1325 != 0) {
                                                l7 = 0;
                                                if (var281 > j3.anInt523) {
                                                   ++l7;
                                                }

                                                if (var281 < j3.anInt524) {
                                                   l7 += 4;
                                                }

                                                if (k5 > j3.anInt525) {
                                                   l7 += 8;
                                                }

                                                if (k5 < j3.anInt526) {
                                                   l7 += 2;
                                                }

                                                if ((l7 & var35.anInt1325) == Class30_Sub1.anInt1327) {
                                                   Class30_Sub1.aBoolean1324 = true;
                                                   continue label561;
                                                }
                                             }
                                          }
                                       }

                                       aClass28Array462[var23++] = j3;
                                       var281 = anInt453 - j3.anInt523;
                                       k5 = j3.anInt524 - anInt453;
                                       if (k5 > var281) {
                                          var281 = k5;
                                       }

                                       j6 = anInt454 - j3.anInt525;
                                       l7 = j3.anInt526 - anInt454;
                                       if (l7 > j6) {
                                          j3.anInt527 = var281 + l7;
                                       } else {
                                          j3.anInt527 = var281 + j6;
                                       }
                                    }
                                 }

                                 while(var23 > 0) {
                                    class10_2 = -50;
                                    var27 = -1;

                                    Object5 var311;
                                    for(var281 = 0; var281 < var23; ++var281) {
                                       var311 = aClass28Array462[var281];
                                       if (var311.anInt528 != anInt448) {
                                          if (var311.anInt527 > class10_2) {
                                             class10_2 = var311.anInt527;
                                             var27 = var281;
                                          } else if (var311.anInt527 == class10_2) {
                                             j6 = var311.anInt519 - anInt455;
                                             l7 = var311.anInt520 - cameraZ;
                                             j9 = aClass28Array462[var27].anInt519 - anInt455;
                                             j10 = aClass28Array462[var27].anInt520 - cameraZ;
                                             if (j6 * j6 + l7 * l7 > j9 * j9 + j10 * j10) {
                                                var27 = var281;
                                             }
                                          }
                                       }
                                    }

                                    if (var27 == -1) {
                                       break;
                                    }

                                    var311 = aClass28Array462[var27];
                                    var311.anInt528 = anInt448;
                                    if (!this.method323(l, var311.anInt523, var311.anInt524, var311.anInt525, var311.anInt526, var311.aClass30_Sub2_Sub4_521.modelHeight)) {
                                       var311.aClass30_Sub2_Sub4_521.method443(var311.anInt522, anInt458, anInt459, anInt460, anInt461, var311.anInt519 - anInt455, var311.anInt518 - cameraY, var311.anInt520 - cameraZ, var311.uid, var311.interactiveObjUID);
                                    }

                                    for(k5 = var311.anInt523; k5 <= var311.anInt524; ++k5) {
                                       for(j6 = var311.anInt525; j6 <= var311.anInt526; ++j6) {
                                          Ground var341 = aGround[k5][j6];
                                          if (var341.anInt1325 != 0) {
                                             aClass19_477.insertHead(var341);
                                          } else if ((k5 != i || j6 != j) && var341.aBoolean1323) {
                                             aClass19_477.insertHead(var341);
                                          }
                                       }
                                    }
                                 }

                                 if (!Class30_Sub1.aBoolean1324) {
                                    break;
                                 }
                              } catch (Exception var28) {
                                 Class30_Sub1.aBoolean1324 = false;
                                 break;
                              }
                           }
                        } while(!Class30_Sub1.aBoolean1323);
                     } while(Class30_Sub1.anInt1325 != 0);

                     if (i > anInt453 || i <= anInt449) {
                        break;
                     }

                     class3 = aGround[i - 1][j];
                  } while(class3 != null && class3.aBoolean1323);

                  if (i < anInt453 || i >= anInt450 - 1) {
                     break;
                  }

                  class3 = aGround[i + 1][j];
               } while(class3 != null && class3.aBoolean1323);

               if (j > anInt454 || j <= anInt451) {
                  break;
               }

               class3 = aGround[i][j - 1];
            } while(class3 != null && class3.aBoolean1323);

            if (j < anInt454 || j >= anInt452 - 1) {
               break;
            }

            class3 = aGround[i][j + 1];
         } while(class3 != null && class3.aBoolean1323);

         Class30_Sub1.aBoolean1323 = false;
         --anInt446;
         Object4 var32 = Class30_Sub1.aClass3_1316;
         if (var32 != null && var32.anInt52 != 0) {
            if (var32.aClass30_Sub2_Sub4_49 != null) {
               var32.aClass30_Sub2_Sub4_49.method443(0, anInt458, anInt459, anInt460, anInt461, var32.anInt46 - anInt455, var32.anInt45 - cameraY - var32.anInt52, var32.anInt47 - cameraZ, var32.anInt51, var32.newuid);
            }

            if (var32.aClass30_Sub2_Sub4_50 != null) {
               var32.aClass30_Sub2_Sub4_50.method443(0, anInt458, anInt459, anInt460, anInt461, var32.anInt46 - anInt455, var32.anInt45 - cameraY - var32.anInt52, var32.anInt47 - cameraZ, var32.anInt51, var32.newuid);
            }

            if (var32.aClass30_Sub2_Sub4_48 != null) {
               var32.aClass30_Sub2_Sub4_48.method443(0, anInt458, anInt459, anInt460, anInt461, var32.anInt46 - anInt455, var32.anInt45 - cameraY - var32.anInt52, var32.anInt47 - cameraZ, var32.anInt51, var32.newuid);
            }
         }

         if (Class30_Sub1.anInt1328 != 0) {
            Object2 var33 = Class30_Sub1.obj2;
            if (var33 != null && !this.method322(l, i, j, var33.aClass30_Sub2_Sub4_504.modelHeight)) {
               if ((var33.anInt502 & Class30_Sub1.anInt1328) != 0) {
                  var33.aClass30_Sub2_Sub4_504.method443(var33.anInt503, anInt458, anInt459, anInt460, anInt461, var33.anInt500 - anInt455, var33.anInt499 - cameraY, var33.anInt501 - cameraZ, var33.uid, var33.newuid);
               } else if ((var33.anInt502 & 768) != 0) {
                  class10_2 = var33.anInt500 - anInt455;
                  var27 = var33.anInt499 - cameraY;
                  var281 = var33.anInt501 - cameraZ;
                  k5 = var33.anInt503;
                  if (k5 != 1 && k5 != 2) {
                     j6 = class10_2;
                  } else {
                     j6 = -class10_2;
                  }

                  if (k5 != 2 && k5 != 3) {
                     l7 = var281;
                  } else {
                     l7 = -var281;
                  }

                  if ((var33.anInt502 & 256) != 0 && l7 >= j6) {
                     j9 = class10_2 + anIntArray463[k5];
                     j10 = var281 + anIntArray464[k5];
                     var33.aClass30_Sub2_Sub4_504.method443(k5 * 512 + 256, anInt458, anInt459, anInt460, anInt461, j9, var27, j10, var33.uid, var33.newuid);
                  }

                  if ((var33.anInt502 & 512) != 0 && l7 <= j6) {
                     j9 = class10_2 + anIntArray465[k5];
                     j10 = var281 + anIntArray466[k5];
                     var33.aClass30_Sub2_Sub4_504.method443(k5 * 512 + 1280 & 2047, anInt458, anInt459, anInt460, anInt461, j9, var27, j10, var33.uid, var33.newuid);
                  }
               }
            }

            Object1 var351 = Class30_Sub1.obj1;
            if (var351 != null) {
               if ((var351.anInt277 & Class30_Sub1.anInt1328) != 0 && !this.method321(l, i, j, var351.anInt277)) {
                  var351.aClass30_Sub2_Sub4_279.method443(0, anInt458, anInt459, anInt460, anInt461, var351.anInt274 - anInt455, var351.anInt273 - cameraY, var351.anInt275 - cameraZ, var351.uid, var351.newuid);
               }

               if ((var351.anInt276 & Class30_Sub1.anInt1328) != 0 && !this.method321(l, i, j, var351.anInt276)) {
                  var351.aClass30_Sub2_Sub4_278.method443(0, anInt458, anInt459, anInt460, anInt461, var351.anInt274 - anInt455, var351.anInt273 - cameraY, var351.anInt275 - cameraZ, var351.uid, var351.newuid);
               }
            }
         }

         Ground var36;
         if (k < this.anInt437 - 1) {
            var36 = this.groundArray[k + 1][i][j];
            if (var36 != null && var36.aBoolean1323) {
               aClass19_477.insertHead(var36);
            }
         }

         if (i < anInt453) {
            var36 = aGround[i + 1][j];
            if (var36 != null && var36.aBoolean1323) {
               aClass19_477.insertHead(var36);
            }
         }

         if (j < anInt454) {
            var36 = aGround[i][j + 1];
            if (var36 != null && var36.aBoolean1323) {
               aClass19_477.insertHead(var36);
            }
         }

         if (i > anInt453) {
            var36 = aGround[i - 1][j];
            if (var36 != null && var36.aBoolean1323) {
               aClass19_477.insertHead(var36);
            }
         }

         if (j > anInt454) {
            var36 = aGround[i][j - 1];
            if (var36 != null && var36.aBoolean1323) {
               aClass19_477.insertHead(var36);
            }
         }
      }
   }

   private void method315(Class43 class43, int i, int j, int k, int l, int i1, int j1, int k1) {
      int l1;
      int i2 = l1 = (j1 << 7) - anInt455;
      int z2;
      int z1 = z2 = (k1 << 7) - cameraZ;
      int l2;
      int i3 = l2 = i2 + 128;
      int z4;
      int z3 = z4 = z1 + 128;
      int l3 = this.anIntArrayArrayArray440[i][j1][k1] - cameraY;
      int i4 = this.anIntArrayArrayArray440[i][j1 + 1][k1] - cameraY;
      int j4 = this.anIntArrayArrayArray440[i][j1 + 1][k1 + 1] - cameraY;
      int k4 = this.anIntArrayArrayArray440[i][j1][k1 + 1] - cameraY;
      int l4 = z1 * l + i2 * i1 >> 16;
      z1 = z1 * i1 - i2 * l >> 16;
      i2 = l4;
      l4 = l3 * k - z1 * j >> 16;
      z1 = l3 * j + z1 * k >> 16;
      l3 = l4;
      if (z1 >= 50) {
         l4 = z2 * l + i3 * i1 >> 16;
         z2 = z2 * i1 - i3 * l >> 16;
         i3 = l4;
         l4 = i4 * k - z2 * j >> 16;
         z2 = i4 * j + z2 * k >> 16;
         i4 = l4;
         if (z2 >= 50) {
            l4 = z3 * l + l2 * i1 >> 16;
            z3 = z3 * i1 - l2 * l >> 16;
            l2 = l4;
            l4 = j4 * k - z3 * j >> 16;
            z3 = j4 * j + z3 * k >> 16;
            j4 = l4;
            if (z3 >= 50) {
               l4 = z4 * l + l1 * i1 >> 16;
               z4 = z4 * i1 - l1 * l >> 16;
               l1 = l4;
               l4 = k4 * k - z4 * j >> 16;
               z4 = k4 * j + z4 * k >> 16;
               if (z4 >= 50) {
                  int x1 = Rasterizer.centerX + (i2 << WorldController.focalLength) / z1;
                  int y1 = Rasterizer.centerY + (l3 << WorldController.focalLength) / z1;
                  int x2 = Rasterizer.centerX + (i3 << WorldController.focalLength) / z2;
                  int y2 = Rasterizer.centerY + (i4 << WorldController.focalLength) / z2;
                  int x3 = Rasterizer.centerX + (l2 << WorldController.focalLength) / z3;
                  int y3 = Rasterizer.centerY + (j4 << WorldController.focalLength) / z3;
                  int x4 = Rasterizer.centerX + (l1 << WorldController.focalLength) / z4;
                  int y4 = Rasterizer.centerY + (l4 << WorldController.focalLength) / z4;
                  Rasterizer.anInt1465 = 0;
                  int j7;
                  if ((x3 - x4) * (y2 - y4) - (y3 - y4) * (x2 - x4) > 0) {
                     Rasterizer.aBoolean1462 = x3 < 0 || x4 < 0 || x2 < 0 || x3 > DrawingArea.centerX || x4 > DrawingArea.centerX || x2 > DrawingArea.centerX;
                     if (aBoolean467 && this.method318(anInt468, anInt469, y3, y4, y2, x3, x4, x2)) {
                        anInt470 = j1;
                        anInt471 = k1;
                     }

                     if (class43.anInt720 != -1 && class43.anInt720 <= 50) {
                        if (!lowMem) {
                           if (class43.aBoolean721) {
                              Rasterizer.method378(y3, y4, y2, x3, x4, x2, class43.anInt718, class43.anInt719, class43.anInt717, i2, i3, l1, l3, i4, l4, z1, z2, z4, class43.anInt720);
                           } else {
                              Rasterizer.method378(y3, y4, y2, x3, x4, x2, class43.anInt718, class43.anInt719, class43.anInt717, l2, l1, i3, j4, l4, i4, z3, z4, z2, class43.anInt720);
                           }
                        } else {
                           j7 = anIntArray485[class43.anInt720];
                           Rasterizer.drawGouraudTriangle(y3, y4, y2, x3, x4, x2, this.method317(j7, class43.anInt718), this.method317(j7, class43.anInt719), this.method317(j7, class43.anInt717));
                        }
                     } else if (class43.anInt718 != 12345678) {
                        if (Constants.hdTexturing && class43.anInt720 != -1) {
                           if (class43.aBoolean721) {
                              Rasterizer.drawMaterializedTriangle(y3, y4, y2, x3, x4, x2, class43.anInt718, class43.anInt719, class43.anInt717, i2, i3, l1, l3, i4, l4, z1, z2, z4, class43.anInt720);
                           } else {
                              Rasterizer.drawMaterializedTriangle(y3, y4, y2, x3, x4, x2, class43.anInt718, class43.anInt719, class43.anInt717, l2, l1, i3, j4, l4, i4, z3, z4, z2, class43.anInt720);
                           }
                        } else {
                           Rasterizer.drawGouraudTriangle(y3, y4, y2, x3, x4, x2, class43.anInt718, class43.anInt719, class43.anInt717);
                        }
                     }

                     if (Constants.distanceFog) {
                        Rasterizer.drawFogTriangle(y3, y4, y2, x3, x4, x2, z3, z4, z2);
                     }
                  }

                  if ((x1 - x2) * (y4 - y2) - (y1 - y2) * (x4 - x2) > 0) {
                     Rasterizer.aBoolean1462 = x1 < 0 || x2 < 0 || x4 < 0 || x1 > DrawingArea.centerX || x2 > DrawingArea.centerX || x4 > DrawingArea.centerX;
                     if (aBoolean467 && this.method318(anInt468, anInt469, y1, y2, y4, x1, x2, x4)) {
                        anInt470 = j1;
                        anInt471 = k1;
                     }

                     if (class43.anInt720 != -1 && class43.anInt720 <= 50) {
                        if (!lowMem) {
                           Rasterizer.method378(y1, y2, y4, x1, x2, x4, class43.anInt716, class43.anInt717, class43.anInt719, i2, i3, l1, l3, i4, l4, z1, z2, z4, class43.anInt720);
                        } else {
                           j7 = anIntArray485[class43.anInt720];
                           Rasterizer.drawGouraudTriangle(y1, y2, y4, x1, x2, x4, this.method317(j7, class43.anInt716), this.method317(j7, class43.anInt717), this.method317(j7, class43.anInt719));
                        }
                     } else if (class43.anInt716 != 12345678) {
                        if (Constants.hdTexturing && class43.anInt720 != -1) {
                           Rasterizer.drawMaterializedTriangle(y1, y2, y4, x1, x2, x4, class43.anInt716, class43.anInt717, class43.anInt719, i2, i3, l1, l3, i4, l4, z1, z2, z4, class43.anInt720);
                        } else {
                           Rasterizer.drawGouraudTriangle(y1, y2, y4, x1, x2, x4, class43.anInt716, class43.anInt717, class43.anInt719);
                        }
                     }

                     if (Constants.distanceFog) {
                        Rasterizer.drawFogTriangle(y1, y2, y4, x1, x2, x4, z1, z2, z4);
                     }
                  }

               }
            }
         }
      }
   }

   private void method316(int i, int j, int k, Class40 class40, int l, int i1, int j1) {
      int k1 = class40.anIntArray673.length;

      int j2;
      int l2;
      int j3;
      int l3;
      int x1;
      for(j2 = 0; j2 < k1; ++j2) {
         l2 = class40.anIntArray673[j2] - anInt455;
         j3 = class40.anIntArray674[j2] - cameraY;
         l3 = class40.anIntArray675[j2] - cameraZ;
         x1 = l3 * k + l2 * j1 >> 16;
         l3 = l3 * j1 - l2 * k >> 16;
         l2 = x1;
         x1 = j3 * l - l3 * j >> 16;
         l3 = j3 * j + l3 * l >> 16;
         if (l3 < 50) {
            return;
         }

         if (!Constants.hdTexturing && class40.anIntArray682 == null) {
            if (Constants.distanceFog) {
               Class40.anIntArray692[j2] = l3;
            }
         } else {
            Class40.anIntArray690[j2] = l2;
            Class40.anIntArray691[j2] = x1;
            Class40.anIntArray692[j2] = l3;
         }

         Class40.anIntArray688[j2] = Rasterizer.centerX + (l2 << WorldController.focalLength) / l3;
         Class40.anIntArray689[j2] = Rasterizer.centerY + (x1 << WorldController.focalLength) / l3;
      }

      Rasterizer.anInt1465 = 0;
      k1 = class40.anIntArray679.length;

      for(j2 = 0; j2 < k1; ++j2) {
         l2 = class40.anIntArray679[j2];
         j3 = class40.anIntArray680[j2];
         l3 = class40.anIntArray681[j2];
         x1 = Class40.anIntArray688[l2];
         int x2 = Class40.anIntArray688[j3];
         int x3 = Class40.anIntArray688[l3];
         int y1 = Class40.anIntArray689[l2];
         int y2 = Class40.anIntArray689[j3];
         int y3 = Class40.anIntArray689[l3];
         if ((x1 - x2) * (y3 - y2) - (y1 - y2) * (x3 - x2) > 0) {
            Rasterizer.aBoolean1462 = x1 < 0 || x2 < 0 || x3 < 0 || x1 > DrawingArea.centerX || x2 > DrawingArea.centerX || x3 > DrawingArea.centerX;
            if (aBoolean467 && this.method318(anInt468, anInt469, y1, y2, y3, x1, x2, x3)) {
               anInt470 = i;
               anInt471 = i1;
            }

            if (class40.anIntArray682 != null && class40.anIntArray682[j2] != -1 && class40.anIntArray682[j2] <= 50) {
               if (!lowMem) {
                  if (class40.aBoolean683) {
                     Rasterizer.method378(y1, y2, y3, x1, x2, x3, class40.anIntArray676[j2], class40.anIntArray677[j2], class40.anIntArray678[j2], Class40.anIntArray690[0], Class40.anIntArray690[1], Class40.anIntArray690[3], Class40.anIntArray691[0], Class40.anIntArray691[1], Class40.anIntArray691[3], Class40.anIntArray692[0], Class40.anIntArray692[1], Class40.anIntArray692[3], class40.anIntArray682[j2]);
                  } else {
                     Rasterizer.method378(y1, y2, y3, x1, x2, x3, class40.anIntArray676[j2], class40.anIntArray677[j2], class40.anIntArray678[j2], Class40.anIntArray690[l2], Class40.anIntArray690[j3], Class40.anIntArray690[l3], Class40.anIntArray691[l2], Class40.anIntArray691[j3], Class40.anIntArray691[l3], Class40.anIntArray692[l2], Class40.anIntArray692[j3], Class40.anIntArray692[l3], class40.anIntArray682[j2]);
                  }
               } else {
                  int k5 = anIntArray485[class40.anIntArray682[j2]];
                  Rasterizer.drawGouraudTriangle(y1, y2, y3, x1, x2, x3, this.method317(k5, class40.anIntArray676[j2]), this.method317(k5, class40.anIntArray677[j2]), this.method317(k5, class40.anIntArray678[j2]));
               }
            } else if (class40.anIntArray676[j2] != 12345678) {
               if (Constants.hdTexturing && class40.anIntArray682 != null && class40.anIntArray682[j2] != -1) {
                  if (!class40.aBoolean683 && class40.anIntArray682[j2] != 505) {
                     Rasterizer.drawMaterializedTriangle(y1, y2, y3, x1, x2, x3, class40.anIntArray676[j2], class40.anIntArray677[j2], class40.anIntArray678[j2], Class40.anIntArray690[l2], Class40.anIntArray690[j3], Class40.anIntArray690[l3], Class40.anIntArray691[l2], Class40.anIntArray691[j3], Class40.anIntArray691[l3], Class40.anIntArray692[l2], Class40.anIntArray692[j3], Class40.anIntArray692[l3], class40.anIntArray682[j2]);
                  } else {
                     Rasterizer.drawMaterializedTriangle(y1, y2, y3, x1, x2, x3, class40.anIntArray676[j2], class40.anIntArray677[j2], class40.anIntArray678[j2], Class40.anIntArray690[0], Class40.anIntArray690[1], Class40.anIntArray690[3], Class40.anIntArray691[0], Class40.anIntArray691[1], Class40.anIntArray691[3], Class40.anIntArray692[0], Class40.anIntArray692[1], Class40.anIntArray692[3], class40.anIntArray682[j2]);
                  }
               } else {
                  Rasterizer.drawGouraudTriangle(y1, y2, y3, x1, x2, x3, class40.anIntArray676[j2], class40.anIntArray677[j2], class40.anIntArray678[j2]);
               }
            }

            if (Constants.distanceFog) {
               Rasterizer.drawFogTriangle(y1, y2, y3, x1, x2, x3, Class40.anIntArray692[l2], Class40.anIntArray692[j3], Class40.anIntArray692[l3]);
            }
         }
      }

   }

   private int method317(int j, int k) {
      k = 127 - k;
      k = k * (j & 127) / 160;
      if (k < 2) {
         k = 2;
      } else if (k > 126) {
         k = 126;
      }

      return (j & 'ﾀ') + k;
   }

   public boolean method318(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
      if (j < k && j < l && j < i1) {
         return false;
      } else if (j > k && j > l && j > i1) {
         return false;
      } else if (i < j1 && i < k1 && i < l1) {
         return false;
      } else if (i > j1 && i > k1 && i > l1) {
         return false;
      } else {
         int i2 = (j - k) * (k1 - j1) - (i - j1) * (l - k);
         int j2 = (j - i1) * (j1 - l1) - (i - l1) * (k - i1);
         int k2 = (j - l) * (l1 - k1) - (i - k1) * (i1 - l);
         return i2 * k2 > 0 && k2 * j2 > 0;
      }
   }

   private void method319() {
      int j = anIntArray473[anInt447];
      Class47[] aclass47 = aClass47ArrayArray474[anInt447];
      anInt475 = 0;

      for(int k = 0; k < j; ++k) {
         Class47 class47 = aclass47[k];
         int j1;
         int i2;
         int l2;
         int l3;
         boolean flag1;
         if (class47.anInt791 == 1) {
            j1 = class47.anInt787 - anInt453 + 25;
            if (j1 >= 0 && j1 <= 50) {
               i2 = class47.anInt789 - anInt454 + 25;
               if (i2 < 0) {
                  i2 = 0;
               }

               l2 = class47.anInt790 - anInt454 + 25;
               if (l2 > 50) {
                  l2 = 50;
               }

               flag1 = false;

               while(i2 <= l2) {
                  if (aBooleanArrayArray492[j1][i2++]) {
                     flag1 = true;
                     break;
                  }
               }

               if (flag1) {
                  l3 = anInt455 - class47.anInt792;
                  if (l3 > 32) {
                     class47.anInt798 = 1;
                  } else {
                     if (l3 >= -32) {
                        continue;
                     }

                     class47.anInt798 = 2;
                     l3 = -l3;
                  }

                  class47.anInt801 = (class47.anInt794 - cameraZ << 8) / l3;
                  class47.anInt802 = (class47.anInt795 - cameraZ << 8) / l3;
                  class47.anInt803 = (class47.anInt796 - cameraY << 8) / l3;
                  class47.anInt804 = (class47.anInt797 - cameraY << 8) / l3;
                  aClass47Array476[anInt475++] = class47;
               }
            }
         } else if (class47.anInt791 == 2) {
            j1 = class47.anInt789 - anInt454 + 25;
            if (j1 >= 0 && j1 <= 50) {
               i2 = class47.anInt787 - anInt453 + 25;
               if (i2 < 0) {
                  i2 = 0;
               }

               l2 = class47.anInt788 - anInt453 + 25;
               if (l2 > 50) {
                  l2 = 50;
               }

               flag1 = false;

               while(i2 <= l2) {
                  if (aBooleanArrayArray492[i2++][j1]) {
                     flag1 = true;
                     break;
                  }
               }

               if (flag1) {
                  l3 = cameraZ - class47.anInt794;
                  if (l3 > 32) {
                     class47.anInt798 = 3;
                  } else {
                     if (l3 >= -32) {
                        continue;
                     }

                     class47.anInt798 = 4;
                     l3 = -l3;
                  }

                  class47.anInt799 = (class47.anInt792 - anInt455 << 8) / l3;
                  class47.anInt800 = (class47.anInt793 - anInt455 << 8) / l3;
                  class47.anInt803 = (class47.anInt796 - cameraY << 8) / l3;
                  class47.anInt804 = (class47.anInt797 - cameraY << 8) / l3;
                  aClass47Array476[anInt475++] = class47;
               }
            }
         } else if (class47.anInt791 == 4) {
            j1 = class47.anInt796 - cameraY;
            if (j1 > 128) {
               i2 = class47.anInt789 - anInt454 + 25;
               if (i2 < 0) {
                  i2 = 0;
               }

               l2 = class47.anInt790 - anInt454 + 25;
               if (l2 > 50) {
                  l2 = 50;
               }

               if (i2 <= l2) {
                  int i3 = class47.anInt787 - anInt453 + 25;
                  if (i3 < 0) {
                     i3 = 0;
                  }

                  l3 = class47.anInt788 - anInt453 + 25;
                  if (l3 > 50) {
                     l3 = 50;
                  }

                  boolean flag2 = false;

                  label147:
                  for(int i4 = i3; i4 <= l3; ++i4) {
                     for(int j4 = i2; j4 <= l2; ++j4) {
                        if (aBooleanArrayArray492[i4][j4]) {
                           flag2 = true;
                           break label147;
                        }
                     }
                  }

                  if (flag2) {
                     class47.anInt798 = 5;
                     class47.anInt799 = (class47.anInt792 - anInt455 << 8) / j1;
                     class47.anInt800 = (class47.anInt793 - anInt455 << 8) / j1;
                     class47.anInt801 = (class47.anInt794 - cameraZ << 8) / j1;
                     class47.anInt802 = (class47.anInt795 - cameraZ << 8) / j1;
                     aClass47Array476[anInt475++] = class47;
                  }
               }
            }
         }
      }

   }

   private boolean method320(int i, int j, int k) {
      int l = this.anIntArrayArrayArray445[i][j][k];
      if (l == -anInt448) {
         return false;
      } else if (l == anInt448) {
         return true;
      } else {
         int i1 = j << 7;
         int j1 = k << 7;
         if (this.method324(i1 + 1, this.anIntArrayArrayArray440[i][j][k], j1 + 1) && this.method324(i1 + 128 - 1, this.anIntArrayArrayArray440[i][j + 1][k], j1 + 1) && this.method324(i1 + 128 - 1, this.anIntArrayArrayArray440[i][j + 1][k + 1], j1 + 128 - 1) && this.method324(i1 + 1, this.anIntArrayArrayArray440[i][j][k + 1], j1 + 128 - 1)) {
            this.anIntArrayArrayArray445[i][j][k] = anInt448;
            return true;
         } else {
            this.anIntArrayArrayArray445[i][j][k] = -anInt448;
            return false;
         }
      }
   }

   private boolean method321(int i, int j, int k, int l) {
      if (!this.method320(i, j, k)) {
         return false;
      } else {
         int i1 = j << 7;
         int j1 = k << 7;
         int k1 = this.anIntArrayArrayArray440[i][j][k] - 1;
         int l1 = k1 - 120;
         int i2 = k1 - 230;
         int j2 = k1 - 238;
         if (l < 16) {
            if (l == 1) {
               if (i1 > anInt455) {
                  if (!this.method324(i1, k1, j1)) {
                     return false;
                  }

                  if (!this.method324(i1, k1, j1 + 128)) {
                     return false;
                  }
               }

               if (i > 0) {
                  if (!this.method324(i1, l1, j1)) {
                     return false;
                  }

                  if (!this.method324(i1, l1, j1 + 128)) {
                     return false;
                  }
               }

               if (!this.method324(i1, i2, j1)) {
                  return false;
               }

               return this.method324(i1, i2, j1 + 128);
            }

            if (l == 2) {
               if (j1 < cameraZ) {
                  if (!this.method324(i1, k1, j1 + 128)) {
                     return false;
                  }

                  if (!this.method324(i1 + 128, k1, j1 + 128)) {
                     return false;
                  }
               }

               if (i > 0) {
                  if (!this.method324(i1, l1, j1 + 128)) {
                     return false;
                  }

                  if (!this.method324(i1 + 128, l1, j1 + 128)) {
                     return false;
                  }
               }

               if (!this.method324(i1, i2, j1 + 128)) {
                  return false;
               }

               return this.method324(i1 + 128, i2, j1 + 128);
            }

            if (l == 4) {
               if (i1 < anInt455) {
                  if (!this.method324(i1 + 128, k1, j1)) {
                     return false;
                  }

                  if (!this.method324(i1 + 128, k1, j1 + 128)) {
                     return false;
                  }
               }

               if (i > 0) {
                  if (!this.method324(i1 + 128, l1, j1)) {
                     return false;
                  }

                  if (!this.method324(i1 + 128, l1, j1 + 128)) {
                     return false;
                  }
               }

               if (!this.method324(i1 + 128, i2, j1)) {
                  return false;
               }

               return this.method324(i1 + 128, i2, j1 + 128);
            }

            if (l == 8) {
               if (j1 > cameraZ) {
                  if (!this.method324(i1, k1, j1)) {
                     return false;
                  }

                  if (!this.method324(i1 + 128, k1, j1)) {
                     return false;
                  }
               }

               if (i > 0) {
                  if (!this.method324(i1, l1, j1)) {
                     return false;
                  }

                  if (!this.method324(i1 + 128, l1, j1)) {
                     return false;
                  }
               }

               if (!this.method324(i1, i2, j1)) {
                  return false;
               }

               return this.method324(i1 + 128, i2, j1);
            }
         }

         if (!this.method324(i1 + 64, j2, j1 + 64)) {
            return false;
         } else if (l == 16) {
            return this.method324(i1, i2, j1 + 128);
         } else if (l == 32) {
            return this.method324(i1 + 128, i2, j1 + 128);
         } else if (l == 64) {
            return this.method324(i1 + 128, i2, j1);
         } else if (l == 128) {
            return this.method324(i1, i2, j1);
         } else {
            System.out.println("Warning unsupported wall type");
            return true;
         }
      }
   }

   private boolean method322(int i, int j, int k, int l) {
      if (!this.method320(i, j, k)) {
         return false;
      } else {
         int i1 = j << 7;
         int j1 = k << 7;
         return this.method324(i1 + 1, this.anIntArrayArrayArray440[i][j][k] - l, j1 + 1) && this.method324(i1 + 128 - 1, this.anIntArrayArrayArray440[i][j + 1][k] - l, j1 + 1) && this.method324(i1 + 128 - 1, this.anIntArrayArrayArray440[i][j + 1][k + 1] - l, j1 + 128 - 1) && this.method324(i1 + 1, this.anIntArrayArrayArray440[i][j][k + 1] - l, j1 + 128 - 1);
      }
   }

   private boolean method323(int i, int j, int k, int l, int i1, int j1) {
      int k2;
      int l2;
      if (j == k && l == i1) {
         if (!this.method320(i, j, l)) {
            return false;
         } else {
            k2 = j << 7;
            l2 = l << 7;
            return this.method324(k2 + 1, this.anIntArrayArrayArray440[i][j][l] - j1, l2 + 1) && this.method324(k2 + 128 - 1, this.anIntArrayArrayArray440[i][j + 1][l] - j1, l2 + 1) && this.method324(k2 + 128 - 1, this.anIntArrayArrayArray440[i][j + 1][l + 1] - j1, l2 + 128 - 1) && this.method324(k2 + 1, this.anIntArrayArrayArray440[i][j][l + 1] - j1, l2 + 128 - 1);
         }
      } else {
         for(k2 = j; k2 <= k; ++k2) {
            for(l2 = l; l2 <= i1; ++l2) {
               if (this.anIntArrayArrayArray445[i][k2][l2] == -anInt448) {
                  return false;
               }
            }
         }

         k2 = (j << 7) + 1;
         l2 = (l << 7) + 2;
         int i3 = this.anIntArrayArrayArray440[i][j][l] - j1;
         if (!this.method324(k2, i3, l2)) {
            return false;
         } else {
            int j3 = (k << 7) - 1;
            if (!this.method324(j3, i3, l2)) {
               return false;
            } else {
               int k3 = (i1 << 7) - 1;
               if (!this.method324(k2, i3, k3)) {
                  return false;
               } else {
                  return this.method324(j3, i3, k3);
               }
            }
         }
      }
   }

   private boolean method324(int i, int j, int k) {
      for(int l = 0; l < anInt475; ++l) {
         Class47 class47 = aClass47Array476[l];
         int i2;
         int j3;
         int k4;
         int l5;
         int i7;
         if (class47.anInt798 == 1) {
            i2 = class47.anInt792 - i;
            if (i2 > 0) {
               j3 = class47.anInt794 + (class47.anInt801 * i2 >> 8);
               k4 = class47.anInt795 + (class47.anInt802 * i2 >> 8);
               l5 = class47.anInt796 + (class47.anInt803 * i2 >> 8);
               i7 = class47.anInt797 + (class47.anInt804 * i2 >> 8);
               if (k >= j3 && k <= k4 && j >= l5 && j <= i7) {
                  return true;
               }
            }
         } else if (class47.anInt798 == 2) {
            i2 = i - class47.anInt792;
            if (i2 > 0) {
               j3 = class47.anInt794 + (class47.anInt801 * i2 >> 8);
               k4 = class47.anInt795 + (class47.anInt802 * i2 >> 8);
               l5 = class47.anInt796 + (class47.anInt803 * i2 >> 8);
               i7 = class47.anInt797 + (class47.anInt804 * i2 >> 8);
               if (k >= j3 && k <= k4 && j >= l5 && j <= i7) {
                  return true;
               }
            }
         } else if (class47.anInt798 == 3) {
            i2 = class47.anInt794 - k;
            if (i2 > 0) {
               j3 = class47.anInt792 + (class47.anInt799 * i2 >> 8);
               k4 = class47.anInt793 + (class47.anInt800 * i2 >> 8);
               l5 = class47.anInt796 + (class47.anInt803 * i2 >> 8);
               i7 = class47.anInt797 + (class47.anInt804 * i2 >> 8);
               if (i >= j3 && i <= k4 && j >= l5 && j <= i7) {
                  return true;
               }
            }
         } else if (class47.anInt798 == 4) {
            i2 = k - class47.anInt794;
            if (i2 > 0) {
               j3 = class47.anInt792 + (class47.anInt799 * i2 >> 8);
               k4 = class47.anInt793 + (class47.anInt800 * i2 >> 8);
               l5 = class47.anInt796 + (class47.anInt803 * i2 >> 8);
               i7 = class47.anInt797 + (class47.anInt804 * i2 >> 8);
               if (i >= j3 && i <= k4 && j >= l5 && j <= i7) {
                  return true;
               }
            }
         } else if (class47.anInt798 == 5) {
            i2 = j - class47.anInt796;
            if (i2 > 0) {
               j3 = class47.anInt792 + (class47.anInt799 * i2 >> 8);
               k4 = class47.anInt793 + (class47.anInt800 * i2 >> 8);
               l5 = class47.anInt794 + (class47.anInt801 * i2 >> 8);
               i7 = class47.anInt795 + (class47.anInt802 * i2 >> 8);
               if (i >= j3 && i <= k4 && k >= l5 && k <= i7) {
                  return true;
               }
            }
         }
      }

      return false;
   }
}
