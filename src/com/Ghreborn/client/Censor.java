package com.Ghreborn.client;

import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.io.Buffer;

public final class Censor {
   private static int anInt611;
   public static boolean aBoolean627;
   private static int anInt606 = 9;
   private static int anInt608 = 748;
   private static int anInt609 = 201;
   private static boolean aBoolean610 = true;
   private static byte aByte612 = -117;
   private static int anInt613 = -575;
   private static boolean aBoolean614 = true;
   private static int anInt615 = -720;
   private static int anInt616 = -511;
   private static byte aByte617 = 4;
   private static int anInt618 = 8801;
   private static boolean aBoolean619 = true;
   private static final String[] aStringArray626 = new String[]{"cook", "cook\'s", "cooks", "seeks", "sheet", "woop", "woops", "faq", "noob", "noobs"};
   private static char[][] aCharArrayArray624;
   private static int[] anIntArray625;
   private static char[][] aCharArrayArray621;
   private static byte[][][] aByteArrayArrayArray622;
   private static char[][] aCharArrayArray623;
   private static int[] anIntArray620;
   private static boolean aBoolean607;

   public static final void method487(StreamLoader class44) {
      Buffer class30_sub2_sub2 = new Buffer(class44.readFile("fragmentsenc.txt"), 891);
      Buffer class30_sub2_sub2_1 = new Buffer(class44.readFile("badenc.txt"), 891);
      Buffer class30_sub2_sub2_2 = new Buffer(class44.readFile("domainenc.txt"), 891);
      Buffer class30_sub2_sub2_3 = new Buffer(class44.readFile("tldlist.txt"), 891);
      method488(class30_sub2_sub2, class30_sub2_sub2_1, class30_sub2_sub2_2, class30_sub2_sub2_3);
   }

   private static final void method488(Buffer class30_sub2_sub2, Buffer class30_sub2_sub2_1, Buffer class30_sub2_sub2_2, Buffer class30_sub2_sub2_3) {
      method490(9121, class30_sub2_sub2_1);
      method491(class30_sub2_sub2_2, (byte)-28);
      method492(class30_sub2_sub2, true);
      method489((byte)2, class30_sub2_sub2_3);
   }

   private static final void method489(byte byte0, Buffer class30_sub2_sub2) {
      int i = class30_sub2_sub2.readInt();
      aCharArrayArray624 = new char[i][];
      anIntArray625 = new int[i];
      if(byte0 == 2) {
         for(int j = 0; j < i; ++j) {
            anIntArray625[j] = class30_sub2_sub2.readUnsignedByte();
            char[] ac = new char[class30_sub2_sub2.readUnsignedByte()];

            for(int k = 0; k < ac.length; ++k) {
               ac[k] = (char)class30_sub2_sub2.readUnsignedByte();
            }

            aCharArrayArray624[j] = ac;
         }
      }

   }

   private static final void method490(int i, Buffer class30_sub2_sub2) {
      if(i != 9121) {
         aBoolean619 = !aBoolean619;
      }

      int j = class30_sub2_sub2.readInt();
      aCharArrayArray621 = new char[j][];
      aByteArrayArrayArray622 = new byte[j][][];
      method493(class30_sub2_sub2, aCharArrayArray621, true, aByteArrayArrayArray622);
   }

   private static final void method491(Buffer class30_sub2_sub2, byte byte0) {
      int i = class30_sub2_sub2.readInt();
      aCharArrayArray623 = new char[i][];
      if(byte0 == -28) {
         method494(aCharArrayArray623, class30_sub2_sub2, -490);
      }

   }

   private static final void method492(Buffer class30_sub2_sub2, boolean flag) {
      anIntArray620 = new int[class30_sub2_sub2.readInt()];

      for(int i = 0; i < anIntArray620.length; ++i) {
         anIntArray620[i] = class30_sub2_sub2.readUnsignedWord();
      }

      if(!flag) {
         anInt609 = 167;
      }

   }

   private static final void method493(Buffer class30_sub2_sub2, char[][] ac, boolean flag, byte[][][] abyte0) {
      int j;
      if(!flag) {
         for(j = 1; j > 0; ++j) {
         }
      }

      for(j = 0; j < ac.length; ++j) {
         char[] ac1 = new char[class30_sub2_sub2.readUnsignedByte()];

         for(int var81 = 0; var81 < ac1.length; ++var81) {
            ac1[var81] = (char)class30_sub2_sub2.readUnsignedByte();
         }

         ac[j] = ac1;
         byte[][] var8 = new byte[class30_sub2_sub2.readUnsignedByte()][2];

         for(int l = 0; l < var8.length; ++l) {
            var8[l][0] = (byte)class30_sub2_sub2.readUnsignedByte();
            var8[l][1] = (byte)class30_sub2_sub2.readUnsignedByte();
         }

         if(var8.length > 0) {
            abyte0[j] = var8;
         }
      }

   }

   private static final void method494(char[][] ac, Buffer class30_sub2_sub2, int i) {
      if(i < 0) {
         for(int j = 0; j < ac.length; ++j) {
            char[] ac1 = new char[class30_sub2_sub2.readUnsignedByte()];

            for(int k = 0; k < ac1.length; ++k) {
               ac1[k] = (char)class30_sub2_sub2.readUnsignedByte();
            }

            ac[j] = ac1;
         }
      }

   }

   private static final void method495(boolean flag, char[] ac) {
      int i = 0;

      int k;
      for(k = 0; k < ac.length; ++k) {
         if(method496(ac[k], anInt611)) {
            ac[i] = ac[k];
         } else {
            ac[i] = 32;
         }

         if(i == 0 || ac[i] != 32 || ac[i - 1] != 32) {
            ++i;
         }
      }

      if(!flag) {
         for(k = i; k < ac.length; ++k) {
            ac[k] = 32;
         }
      }

   }

   private static final boolean method496(char c, int i) {
      if(i != 0) {
         throw new NullPointerException();
      } else {
         return c >= 32 && c <= 127 || c == 32 || c == 10 || c == 9 || c == 163 || c == 8364;
      }
   }

   public static final String method497(String s, int i) {
      long l = System.currentTimeMillis();
      char[] ac = s.toCharArray();
      method495(false, ac);
      String s1 = (new String(ac)).trim();
      ac = s1.toLowerCase().toCharArray();
      String s2 = s1.toLowerCase();
      method505(false, ac);
      method500(ac, true);
      if(i != 0) {
         throw new NullPointerException();
      } else {
         method501((byte)0, ac);
         method514(ac, -511);

         for(int var111 = 0; var111 < aStringArray626.length; ++var111) {
            int k = -1;

            while((k = s2.indexOf(aStringArray626[var111], k + 1)) != -1) {
               char[] ac1 = aStringArray626[var111].toCharArray();

               for(int i1 = 0; i1 < ac1.length; ++i1) {
                  ac[i1 + k] = ac1[i1];
               }
            }
         }

         method498(s1.toCharArray(), 2, ac);
         method499(0, ac);
         long var11 = System.currentTimeMillis();
         return s;
      }
   }

   private static final void method498(char[] ac, int i, char[] ac1) {
      for(int j = 0; j < ac.length; ++j) {
         if(ac1[j] != 42 && method522(true, ac[j])) {
            ac1[j] = ac[j];
         }
      }

      if(i == 2) {
      }

   }

   private static final void method499(int i, char[] ac) {
      boolean flag = true;

      for(int j = 0; j < ac.length; ++j) {
         char c = ac[j];
         if(method519(c, -46837)) {
            if(flag) {
               if(method521(c, 1)) {
                  flag = false;
               }
            } else if(method522(true, c)) {
               ac[j] = (char)(c + 97 - 65);
            }
         } else {
            flag = true;
         }
      }

      if(i == 0) {
      }

   }

   private static final void method500(char[] ac, boolean flag) {
      if(flag) {
         for(int i = 0; i < 2; ++i) {
            for(int j = aCharArrayArray621.length - 1; j >= 0; --j) {
               method509(aByteArrayArrayArray622[j], ac, anInt613, aCharArrayArray621[j]);
            }
         }
      }

   }

   private static final void method501(byte byte0, char[] ac) {
      char[] ac1 = ac.clone();
      char[] ac2 = new char[]{'\u0028', '\u0061', '\u0029'};
      method509(null, ac1, anInt613, ac2);
      char[] ac3 = ac.clone();
      char[] ac4 = new char[]{'\u0064', '\u006f', '\u0074'};
      method509(null, ac3, anInt613, ac4);

      for(int i = aCharArrayArray623.length - 1; i >= 0; --i) {
         method502(29200, ac, aCharArrayArray623[i], ac3, ac1);
      }

      if(byte0 == 0) {
      }

   }

   private static final void method502(int i, char[] ac, char[] ac1, char[] ac2, char[] ac3) {
      if(i == 29200 && ac1.length <= ac.length) {
         boolean flag = true;

         int j;
         for(int k = 0; k <= ac.length - ac1.length; k += j) {
            int l = k;
            int i1 = 0;
            j = 1;

            boolean flag1;
            int i2;
            label57:
            while(true) {
               while(true) {
                  if(l >= ac.length) {
                     break label57;
                  }

                  flag1 = false;
                  char var14 = ac[l];
                  char var151 = 0;
                  if(l + 1 < ac.length) {
                     var151 = ac[l + 1];
                  }

                  if(i1 < ac1.length && (i2 = method511(43, var14, ac1[i1], var151)) > 0) {
                     l += i2;
                     ++i1;
                  } else {
                     if(i1 == 0) {
                        break label57;
                     }

                     if((i2 = method511(43, var14, ac1[i1 - 1], var151)) > 0) {
                        l += i2;
                        if(i1 == 1) {
                           ++j;
                        }
                     } else {
                        if(i1 >= ac1.length || !method517(-12789, var14)) {
                           break label57;
                        }

                        ++l;
                     }
                  }
               }
            }

            if(i1 >= ac1.length) {
               flag1 = false;
               int var141 = method503(ac, 4, ac3, k);
               int var15 = method504(aByte612, ac2, l - 1, ac);
               if(var141 > 2 || var15 > 2) {
                  flag1 = true;
               }

               if(flag1) {
                  for(i2 = k; i2 < l; ++i2) {
                     ac[i2] = 42;
                  }
               }
            }
         }
      }

   }

   private static final int method503(char[] ac, int i, char[] ac1, int j) {
      if(i >= 4 && i <= 4) {
         if(j == 0) {
            return 2;
         } else {
            int l;
            for(l = j - 1; l >= 0 && method517(-12789, ac[l]); --l) {
               if(ac[l] == 64) {
                  return 3;
               }
            }

            l = 0;

            for(int i1 = j - 1; i1 >= 0 && method517(-12789, ac1[i1]); --i1) {
               if(ac1[i1] == 42) {
                  ++l;
               }
            }

            return l >= 3?4:(!method517(-12789, ac[j - 1])?0:1);
         }
      } else {
         return 2;
      }
   }

   private static final int method504(byte byte0, char[] ac, int i, char[] ac1) {
      if(i + 1 == ac1.length) {
         return 2;
      } else {
         int k = i + 1;

         while(true) {
            if(k < ac1.length && method517(-12789, ac1[k])) {
               if(ac1[k] != 46 && ac1[k] != 44) {
                  ++k;
                  continue;
               }

               return 3;
            }

            if(byte0 != -117) {
               return anInt613;
            }

            k = 0;

            for(int l = i + 1; l < ac1.length && method517(-12789, ac[l]); ++l) {
               if(ac[l] == 42) {
                  ++k;
               }
            }

            if(k >= 3) {
               return 4;
            }

            return !method517(-12789, ac1[i + 1])?0:1;
         }
      }
   }

   private static final void method505(boolean flag, char[] ac) {
      char[] ac1 = ac.clone();
      char[] ac2 = new char[]{'\u0064', '\u006f', '\u0074'};
      if(!flag) {
         method509(null, ac1, anInt613, ac2);
         char[] ac3 = ac.clone();
         char[] ac4 = new char[]{'\u0073', '\u006c', '\u0061', '\u0073', '\u0068'};
         method509(null, ac3, anInt613, ac4);

         for(int i = 0; i < aCharArrayArray624.length; ++i) {
            method506(ac3, aCharArrayArray624[i], anIntArray625[i], (byte)51, ac1, ac);
         }
      }

   }

   private static final void method506(char[] ac, char[] ac1, int i, byte byte0, char[] ac2, char[] ac3) {
      if(ac1.length <= ac3.length) {
         boolean flag = true;

         int j;
         for(int k = 0; k <= ac3.length - ac1.length; k += j) {
            int l = k;
            int i1 = 0;
            j = 1;

            boolean flag1;
            label130:
            while(true) {
               while(true) {
                  if(l >= ac3.length) {
                     break label130;
                  }

                  flag1 = false;
                  char var201 = ac3[l];
                  char var211 = 0;
                  if(l + 1 < ac3.length) {
                     var211 = ac3[l + 1];
                  }

                  int var221;
                  if(i1 < ac1.length && (var221 = method511(43, var201, ac1[i1], var211)) > 0) {
                     l += var221;
                     ++i1;
                  } else {
                     if(i1 == 0) {
                        break label130;
                     }

                     if((var221 = method511(43, var201, ac1[i1 - 1], var211)) > 0) {
                        l += var221;
                        if(i1 == 1) {
                           ++j;
                        }
                     } else {
                        if(i1 >= ac1.length || !method517(-12789, var201)) {
                           break label130;
                        }

                        ++l;
                     }
                  }
               }
            }

            if(i1 >= ac1.length) {
               flag1 = false;
               int var20 = method507('\u8d71', ac3, k, ac2);
               int var21 = method508(false, ac3, ac, l - 1);
               if(i == 1 && var20 > 0 && var21 > 0) {
                  flag1 = true;
               }

               if(i == 2 && (var20 > 2 && var21 > 0 || var20 > 0 && var21 > 2)) {
                  flag1 = true;
               }

               if(i == 3 && var20 > 0 && var21 > 2) {
                  flag1 = true;
               }

               boolean var221;
               var221 = i == 3 && var20 > 2 && var21 > 0;

               if(flag1) {
                  int i2 = k;
                  int j2 = l - 1;
                  boolean k2;
                  int k3;
                  if(var20 > 2) {
                     if(var20 == 4) {
                        k2 = false;

                        for(k3 = k - 1; k3 >= 0; --k3) {
                           if(k2) {
                              if(ac2[k3] != 42) {
                                 break;
                              }

                              i2 = k3;
                           } else if(ac2[k3] == 42) {
                              i2 = k3;
                              k2 = true;
                           }
                        }
                     }

                     k2 = false;

                     for(k3 = i2 - 1; k3 >= 0; --k3) {
                        if(k2) {
                           if(method517(-12789, ac3[k3])) {
                              break;
                           }

                           i2 = k3;
                        } else if(!method517(-12789, ac3[k3])) {
                           k2 = true;
                           i2 = k3;
                        }
                     }
                  }

                  if(var21 > 2) {
                     if(var21 == 4) {
                        k2 = false;

                        for(k3 = j2 + 1; k3 < ac3.length; ++k3) {
                           if(k2) {
                              if(ac[k3] != 42) {
                                 break;
                              }

                              j2 = k3;
                           } else if(ac[k3] == 42) {
                              j2 = k3;
                              k2 = true;
                           }
                        }
                     }

                     k2 = false;

                     for(k3 = j2 + 1; k3 < ac3.length; ++k3) {
                        if(k2) {
                           if(method517(-12789, ac3[k3])) {
                              break;
                           }

                           j2 = k3;
                        } else if(!method517(-12789, ac3[k3])) {
                           k2 = true;
                           j2 = k3;
                        }
                     }
                  }

                  for(int var22 = i2; var22 <= j2; ++var22) {
                     ac3[var22] = 42;
                  }
               }
            }
         }

         if(byte0 != 51) {
            aBoolean619 = !aBoolean619;
         }
      }

   }

   private static final int method507(int i, char[] ac, int j, char[] ac1) {
      if(j == 0) {
         return 2;
      } else {
         int l = j - 1;

         while(true) {
            if(l >= 0 && method517(-12789, ac[l])) {
               if(ac[l] != 44 && ac[l] != 46) {
                  --l;
                  continue;
               }

               return 3;
            }

            l = 0;

            for(int i1 = j - 1; i1 >= 0 && method517(-12789, ac1[i1]); --i1) {
               if(ac1[i1] == 42) {
                  ++l;
               }
            }

            if(i != '\u8d71') {
               aBoolean619 = !aBoolean619;
            }

            if(l >= 3) {
               return 4;
            }

            return !method517(-12789, ac[j - 1])?0:1;
         }
      }
   }

   private static final int method508(boolean flag, char[] ac, char[] ac1, int i) {
      if(flag) {
         anInt608 = 391;
      }

      if(i + 1 == ac.length) {
         return 2;
      } else {
         int k = i + 1;

         while(true) {
            if(k < ac.length && method517(-12789, ac[k])) {
               if(ac[k] != 92 && ac[k] != 47) {
                  ++k;
                  continue;
               }

               return 3;
            }

            k = 0;

            for(int l = i + 1; l < ac.length && method517(-12789, ac1[l]); ++l) {
               if(ac1[l] == 42) {
                  ++k;
               }
            }

            if(k >= 5) {
               return 4;
            }

            return !method517(-12789, ac[i + 1])?0:1;
         }
      }
   }

   public static final void method509(byte[][] abyte0, char[] ac, int i, char[] ac1) {
      if(i < 0 && ac1.length <= ac.length) {
         boolean flag = true;

         int j;
         for(int k = 0; k <= ac.length - ac1.length; k += j) {
            int l = k;
            int i1 = 0;
            int j1 = 0;
            j = 1;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;

            boolean flag4;
            char l1;
            char i2;
            int var27;
            label162:
            while(true) {
               while(true) {
                  if(l >= ac.length || flag2 && flag3) {
                     break label162;
                  }

                  flag4 = false;
                  l1 = ac[l];
                  i2 = 0;
                  if(l + 1 < ac.length) {
                     i2 = ac[l + 1];
                  }

                  if(i1 < ac1.length && (var27 = method512(i2, l1, aBoolean614, ac1[i1])) > 0) {
                     if(var27 == 1 && method520(l1, -976)) {
                        flag2 = true;
                     }

                     if(var27 == 2 && (method520(l1, -976) || method520(i2, -976))) {
                        flag2 = true;
                     }

                     l += var27;
                     ++i1;
                  } else {
                     if(i1 == 0) {
                        break label162;
                     }

                     if((var27 = method512(i2, l1, aBoolean614, ac1[i1 - 1])) > 0) {
                        l += var27;
                        if(i1 == 1) {
                           ++j;
                        }
                     } else {
                        if(i1 >= ac1.length || !method518(false, l1)) {
                           break label162;
                        }

                        if(method517(-12789, l1) && l1 != 39) {
                           flag1 = true;
                        }

                        if(method520(l1, -976)) {
                           flag3 = true;
                        }

                        ++l;
                        ++j1;
                        if(j1 * 100 / (l - k) > 90) {
                           break label162;
                        }
                     }
                  }
               }
            }

            if(i1 >= ac1.length && (!flag2 || !flag3)) {
               flag4 = true;
               if(!flag1) {
                  l1 = 32;
                  if(k - 1 >= 0) {
                     l1 = ac[k - 1];
                  }

                  i2 = 32;
                  if(l < ac.length) {
                     i2 = ac[l];
                  }

                  byte var251 = method513(l1, anInt615);
                  byte var26 = method513(i2, anInt615);
                  if(abyte0 != null && method510(var251, (byte)8, abyte0, var26)) {
                     flag4 = false;
                  }
               } else {
                  boolean var23 = false;
                  boolean var24 = false;
                  if(k - 1 < 0 || method517(-12789, ac[k - 1]) && ac[k - 1] != 39) {
                     var23 = true;
                  }

                  if(l >= ac.length || method517(-12789, ac[l]) && ac[l] != 39) {
                     var24 = true;
                  }

                  if(!var23 || !var24) {
                     boolean var271 = false;
                     var27 = k - 2;
                     if(var23) {
                        var27 = k;
                     }

                     for(; !var271 && var27 < l; ++var27) {
                        if(var27 >= 0 && (!method517(-12789, ac[var27]) || ac[var27] == 39)) {
                           char[] ac2 = new char[3];

                           int j3;
                           for(j3 = 0; j3 < 3 && var27 + j3 < ac.length && (!method517(-12789, ac[var27 + j3]) || ac[var27 + j3] == 39); ++j3) {
                              ac2[j3] = ac[var27 + j3];
                           }

                           boolean flag8 = true;
                           if(j3 == 0) {
                              flag8 = false;
                           }

                           if(j3 < 3 && var27 - 1 >= 0 && (!method517(-12789, ac[var27 - 1]) || ac[var27 - 1] == 39)) {
                              flag8 = false;
                           }

                           if(flag8 && !method523(ac2, (byte)4)) {
                              var271 = true;
                           }
                        }
                     }

                     if(!var271) {
                        flag4 = false;
                     }
                  }
               }

               if(flag4) {
                  int var25 = 0;
                  int var261 = 0;
                  int var271 = -1;

                  for(var27 = k; var27 < l; ++var27) {
                     if(method520(ac[var27], -976)) {
                        ++var25;
                     } else if(method519(ac[var27], -46837)) {
                        ++var261;
                        var271 = var27;
                     }
                  }

                  if(var271 > -1) {
                     var25 -= l - 1 - var271;
                  }

                  if(var25 <= var261) {
                     for(var27 = k; var27 < l; ++var27) {
                        ac[var27] = 42;
                     }
                  } else {
                     j = 1;
                  }
               }
            }
         }
      }

   }

   private static final boolean method510(byte byte0, byte byte1, byte[][] abyte0, byte byte2) {
      int i = 0;
      if(byte1 != 8) {
         anInt613 = 308;
      }

      if(abyte0[i][0] == byte0 && abyte0[i][1] == byte2) {
         return true;
      } else {
         int j = abyte0.length - 1;
         if(abyte0[j][0] == byte0 && abyte0[j][1] == byte2) {
            return true;
         } else {
            do {
               int k = (i + j) / 2;
               if(abyte0[k][0] == byte0 && abyte0[k][1] == byte2) {
                  return true;
               }

               if(byte0 >= abyte0[k][0] && (byte0 != abyte0[k][0] || byte2 >= abyte0[k][1])) {
                  i = k;
               } else {
                  j = k;
               }
            } while(i != j && i + 1 != j);

            return false;
         }
      }
   }

   private static final int method511(int i, char c, char c1, char c2) {
      return i <= 0?anInt608:(c1 == c?1:(c1 == 111 && c == 48?1:(c1 == 111 && c == 40 && c2 == 41?2:(c1 != 99 || c != 40 && c != 60 && c != 91?(c1 == 101 && c == 8364?1:(c1 == 115 && c == 36?1:(c1 == 108 && c == 105?1:0))):1))));
   }

   private static final int method512(char c, char c1, boolean flag, char c2) {
      if(!flag) {
         anInt613 = -260;
      }

      if(c2 == c1) {
         return 1;
      } else {
         if(c2 >= 97 && c2 <= 109) {
            if(c2 == 97) {
               if(c1 != 52 && c1 != 64 && c1 != 94) {
                  return c1 == 47 && c == 92?2:0;
               }

               return 1;
            }

            if(c2 == 98) {
               if(c1 != 54 && c1 != 56) {
                  return (c1 != 49 || c != 51) && (c1 != 105 || c != 51)?0:2;
               }

               return 1;
            }

            if(c2 == 99) {
               return c1 != 40 && c1 != 60 && c1 != 123 && c1 != 91?0:1;
            }

            if(c2 == 100) {
               return (c1 != 91 || c != 41) && (c1 != 105 || c != 41)?0:2;
            }

            if(c2 == 101) {
               return c1 != 51 && c1 != 8364?0:1;
            }

            if(c2 == 102) {
               if(c1 == 112 && c == 104) {
                  return 2;
               }

               return c1 != 163?0:1;
            }

            if(c2 == 103) {
               return c1 != 57 && c1 != 54 && c1 != 113?0:1;
            }

            if(c2 == 104) {
               return c1 != 35?0:1;
            }

            if(c2 == 105) {
               return c1 != 121 && c1 != 108 && c1 != 106 && c1 != 49 && c1 != 33 && c1 != 58 && c1 != 59 && c1 != 124?0:1;
            }

            if(c2 == 106) {
               return 0;
            }

            if(c2 == 107) {
               return 0;
            }

            if(c2 == 108) {
               return c1 != 49 && c1 != 124 && c1 != 105?0:1;
            }

            if(c2 == 109) {
               return 0;
            }
         }

         if(c2 >= 110 && c2 <= 122) {
            if(c2 == 110) {
               return 0;
            }

            if(c2 == 111) {
               if(c1 != 48 && c1 != 42) {
                  return (c1 != 40 || c != 41) && (c1 != 91 || c != 93) && (c1 != 123 || c != 125) && (c1 != 60 || c != 62)?0:2;
               }

               return 1;
            }

            if(c2 == 112) {
               return 0;
            }

            if(c2 == 113) {
               return 0;
            }

            if(c2 == 114) {
               return 0;
            }

            if(c2 == 115) {
               return c1 != 53 && c1 != 122 && c1 != 36 && c1 != 50?0:1;
            }

            if(c2 == 116) {
               return c1 != 55 && c1 != 43?0:1;
            }

            if(c2 == 117) {
               if(c1 == 118) {
                  return 1;
               }

               return (c1 != 92 || c != 47) && (c1 != 92 || c != 124) && (c1 != 124 || c != 47)?0:2;
            }

            if(c2 == 118) {
               return (c1 != 92 || c != 47) && (c1 != 92 || c != 124) && (c1 != 124 || c != 47)?0:2;
            }

            if(c2 == 119) {
               return c1 == 118 && c == 118?2:0;
            }

            if(c2 == 120) {
               return (c1 != 41 || c != 40) && (c1 != 125 || c != 123) && (c1 != 93 || c != 91) && (c1 != 62 || c != 60)?0:2;
            }

            if(c2 == 121) {
               return 0;
            }

            if(c2 == 122) {
               return 0;
            }
         }

         return c2 >= 48 && c2 <= 57?(c2 != 48?(c2 == 49?(c1 != 108?0:1):0):(c1 != 111 && c1 != 79?((c1 != 40 || c != 41) && (c1 != 123 || c != 125) && (c1 != 91 || c != 93)?0:2):1)):(c2 == 44?(c1 != 46?0:1):(c2 == 46?(c1 != 44?0:1):(c2 == 33?(c1 != 105?0:1):0)));
      }
   }

   private static final byte method513(char c, int i) {
      while(i >= 0) {
         anInt606 = -93;
      }

      if(c >= 97 && c <= 122) {
         return (byte)(c - 97 + 1);
      } else if(c == 39) {
         return (byte)28;
      } else if(c >= 48 && c <= 57) {
         return (byte)(c - 48 + 29);
      } else {
         return (byte)27;
      }
   }

   private static final void method514(char[] ac, int i) {
      boolean j = false;
      int k = 0;
      int l = 0;
      int i1 = 0;
      if(i >= 0) {
         aBoolean607 = !aBoolean607;
      }

      while(true) {
         int i2;
         do {
            int var9;
            if((var9 = method515(ac, k, 319)) == -1) {
               return;
            }

            boolean flag = false;

            int k1;
            for(k1 = k; k1 >= 0 && k1 < var9 && !flag; ++k1) {
               if(!method517(-12789, ac[k1]) && !method518(false, ac[k1])) {
                  flag = true;
               }
            }

            if(flag) {
               l = 0;
            }

            if(l == 0) {
               i1 = var9;
            }

            k = method516(ac, 0, var9);
            k1 = 0;

            for(i2 = var9; i2 < k; ++i2) {
               k1 = k1 * 10 + ac[i2] - 48;
            }

            if(k1 <= 255 && k - var9 <= 8) {
               ++l;
            } else {
               l = 0;
            }
         } while(l != 4);

         for(i2 = i1; i2 < k; ++i2) {
            ac[i2] = 42;
         }

         l = 0;
      }
   }

   private static final int method515(char[] ac, int i, int j) {
      j = 23 / j;

      for(int k = i; k < ac.length && k >= 0; ++k) {
         if(ac[k] >= 48 && ac[k] <= 57) {
            return k;
         }
      }

      return -1;
   }

   private static final int method516(char[] ac, int i, int j) {
      int k = j;

      while(true) {
         if(k < ac.length && k >= 0) {
            if(ac[k] >= 48 && ac[k] <= 57) {
               ++k;
               continue;
            }

            return k;
         }

         if(i != 0) {
            return 3;
         }

         return ac.length;
      }
   }

   private static final boolean method517(int i, char c) {
      if(i != -12789) {
         throw new NullPointerException();
      } else {
         return !method519(c, -46837) && !method520(c, -976);
      }
   }

   private static final boolean method518(boolean flag, char c) {
      if(flag) {
         anInt615 = -233;
      }

      return c < 97 || c > 122 || (c == 118 || c == 120 || c == 106 || c == 113 || c == 122);
   }

   private static final boolean method519(char c, int i) {
      if(i != -46837) {
         for(int j = 1; j > 0; ++j) {
         }
      }

      return c >= 97 && c <= 122 || c >= 65 && c <= 90;
   }

   private static final boolean method520(char c, int i) {
      if(i >= 0) {
         anInt615 = 254;
      }

      return c >= 48 && c <= 57;
   }

   private static final boolean method521(char c, int i) {
      if(i != 1) {
         for(int j = 1; j > 0; ++j) {
         }
      }

      return c >= 97 && c <= 122;
   }

   private static final boolean method522(boolean flag, char c) {
      if(!flag) {
         throw new NullPointerException();
      } else {
         return c >= 65 && c <= 90;
      }
   }

   private static final boolean method523(char[] ac, byte byte0) {
      if(byte0 != aByte617) {
         throw new NullPointerException();
      } else {
         boolean var7 = false;
         boolean flag = true;

         int j;
         for(j = 0; j < ac.length; ++j) {
            if(!method520(ac[j], -976) && ac[j] != 0) {
               flag = false;
            }
         }

         if(flag) {
            return true;
         } else {
            j = method524(ac, 8801);
            int k = 0;
            int l = anIntArray620.length - 1;
            if(j != anIntArray620[k] && j != anIntArray620[l]) {
               do {
                  int i1 = (k + l) / 2;
                  if(j == anIntArray620[i1]) {
                     return true;
                  }

                  if(j < anIntArray620[i1]) {
                     l = i1;
                  } else {
                     k = i1;
                  }
               } while(k != l && k + 1 != l);

               return false;
            } else {
               return true;
            }
         }
      }
   }

   public static final int method524(char[] ac, int i) {
      int k;
      if(i != anInt618) {
         for(k = 1; k > 0; ++k) {
         }
      }

      if(ac.length > 6) {
         return 0;
      } else {
         k = 0;

         for(int l = 0; l < ac.length; ++l) {
            char c = ac[ac.length - l - 1];
            if(c >= 97 && c <= 122) {
               k = k * 38 + c - 97 + 1;
            } else if(c == 39) {
               k = k * 38 + 27;
            } else if(c >= 48 && c <= 57) {
               k = k * 38 + c - 48 + 28;
            } else if(c != 0) {
               return 0;
            }
         }

         return k;
      }
   }
}
