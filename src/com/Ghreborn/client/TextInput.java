package com.Ghreborn.client;

import com.Ghreborn.client.io.Buffer;

public final class TextInput {
   public static String anArea435 = "y";
   private static boolean aBoolean630 = true;
   public static char[] aCharArray631 = new char[100];
   private static Buffer aClass30_Sub2_Sub2_632 = new Buffer(new byte[100], 891);
   private static char[] aCharArray633 = new char[]{'\u0020', '\u0065', '\u0074', '\u0061', '\u006f', '\u0069', '\u0068', '\u006e', '\u0073', '\u0072', '\u0064', '\u006c', '\u0075', '\u006d', '\u0077', '\u0063', '\u0079', '\u0066', '\u0067', '\u0070', '\u0062', '\u0076', '\u006b', '\u0078', '\u006a', '\u0071', '\u007a', '\u0030', '\u0031', '\u0032', '\u0033', '\u0034', '\u0035', '\u0036', '\u0037', '\u0038', '\u0039', '\u0020', '\u0021', '\u003f', '\u002e', '\u002c', '\u003a', '\u003b', '\u0028', '\u0029', '\u002d', '\u0026', '\u002a', '\\', '\'', '\u0040', '\u0023', '\u002b', '\u003d', '\u00a3', '\u0024', '\u0025', '\"', '\u005b', '\u005d', '\u002f'};
   private static int anInt628;
   private static boolean aBoolean629;

   public static String method525(int i, boolean flag, Buffer class30_sub2_sub2) {
      int j = 0;
      int k = -1;

      int k1;
      for(int var81 = 0; var81 < i; ++var81) {
         k1 = class30_sub2_sub2.readUnsignedByte();
         int var91 = k1 >> 4 & 15;
         if(k == -1) {
            if(var91 < 13) {
               aCharArray631[j++] = aCharArray633[var91];
            } else {
               k = var91;
            }
         } else {
            aCharArray631[j++] = aCharArray633[(k << 4) + var91 - 195];
            k = -1;
         }

         var91 = k1 & 15;
         if(k == -1) {
            if(var91 < 13) {
               aCharArray631[j++] = aCharArray633[var91];
            } else {
               k = var91;
            }
         } else {
            aCharArray631[j++] = aCharArray633[(k << 4) + var91 - 195];
            k = -1;
         }
      }

      boolean var8 = true;

      for(k1 = 0; k1 < j; ++k1) {
         char var9 = aCharArray631[k1];
         if(var8 && var9 >= 97 && var9 <= 122) {
            aCharArray631[k1] += '\uffe0';
            var8 = false;
         }

         if(var9 == 46 || var9 == 33 || var9 == 63) {
            var8 = true;
         }
      }

      if(!flag) {
         anInt628 = 466;
      }

      return new String(aCharArray631, 0, j);
   }

   public static void method526(String s, Buffer class30_sub2_sub2) {
      if(s.length() > 80) {
         s = s.substring(0, 80);
      }

      s = s.toLowerCase();
      int i = -1;

      for(int j = 0; j < s.length(); ++j) {
         char c = s.charAt(j);
         int k = 0;

         for(int l = 0; l < aCharArray633.length; ++l) {
            if(c == aCharArray633[l]) {
               k = l;
               break;
            }
         }

         if(k > 12) {
            k += 195;
         }

         if(i == -1) {
            if(k < 13) {
               i = k;
            } else {
               class30_sub2_sub2.writeByte(k);
            }
         } else if(k < 13) {
            class30_sub2_sub2.writeByte((i << 4) + k);
            i = -1;
         } else {
            class30_sub2_sub2.writeByte((i << 4) + (k >> 4));
            i = k & 15;
         }
      }

      if(i != -1) {
         class30_sub2_sub2.writeByte(i << 4);
      }

   }

   public static String processText(String s) {
      aClass30_Sub2_Sub2_632.currentOffset = 0;
      method526(s, aClass30_Sub2_Sub2_632);
      int j = aClass30_Sub2_Sub2_632.currentOffset;
      aClass30_Sub2_Sub2_632.currentOffset = 0;
      String s1 = method525(j, true, aClass30_Sub2_Sub2_632);
      return s1;
   }
}
