package com.Ghreborn.client;

import com.Ghreborn.client.SignLink;

public final class TextClass {
   private static final char[] validChars = new char[]{'\u005f', '\u0061', '\u0062', '\u0063', '\u0064', '\u0065', '\u0066', '\u0067', '\u0068', '\u0069', '\u006a', '\u006b', '\u006c', '\u006d', '\u006e', '\u006f', '\u0070', '\u0071', '\u0072', '\u0073', '\u0074', '\u0075', '\u0076', '\u0077', '\u0078', '\u0079', '\u007a', '\u0030', '\u0031', '\u0032', '\u0033', '\u0034', '\u0035', '\u0036', '\u0037', '\u0038', '\u0039', '\u002f'};

   public static long longForName(String s) {
      long l = 0L;

      for(int i = 0; i < s.length() && i < 12; ++i) {
         char c = s.charAt(i);
         l *= 37L;
         if(c >= 65 && c <= 90) {
            l += (long)(1 + c - 65);
         } else if(c >= 97 && c <= 122) {
            l += (long)(1 + c - 97);
         } else if(c >= 48 && c <= 57) {
            l += (long)(27 + c - 48);
         }
      }

      while(l % 37L == 0L && l != 0L) {
         l /= 37L;
      }

      return l;
   }

   public static String nameForLong(long l) {
      try {
         if(l > 0L && l < 6582952005840035281L) {
            if(l % 37L == 0L) {
               return "invalid_name";
            } else {
               int var61 = 0;

               char[] ac;
               long l1;
               for(ac = new char[12]; l != 0L; ac[11 - var61++] = validChars[(int)(l1 - l * 37L)]) {
                  l1 = l;
                  l /= 37L;
               }

               return new String(ac, 12 - var61, var61);
            }
         } else {
            return "invalid_name";
         }
      } catch (RuntimeException var6) {
         SignLink.reporterror("81570, " + l + ", " + -99 + ", " + var6.toString());
         throw new RuntimeException();
      }
   }

   public static long method585(String s) {
      s = s.toUpperCase();
      long l = 0L;

      for(int i = 0; i < s.length(); ++i) {
         l = l * 61L + (long)s.charAt(i) - 32L;
         l = l + (l >> 56) & 72057594037927935L;
      }

      return l;
   }

   public static String method586(int i) {
      return (i >> 24 & 255) + "." + (i >> 16 & 255) + "." + (i >> 8 & 255) + "." + (i & 255);
   }

   public static String fixName(String s) {
      if(s.length() > 0) {
         char[] ac = s.toCharArray();

         for(int j = 0; j < ac.length; ++j) {
            if(ac[j] == 95) {
               ac[j] = 32;
               if(j + 1 < ac.length && ac[j + 1] >= 97 && ac[j + 1] <= 122) {
                  ac[j + 1] = (char)(ac[j + 1] + 65 - 97);
               }
            }
         }

         if(ac[0] >= 97 && ac[0] <= 122) {
            ac[0] = (char)(ac[0] + 65 - 97);
         }

         return new String(ac);
      } else {
         return s;
      }
   }

   public static String passwordAsterisks(String s) {
      StringBuffer stringbuffer = new StringBuffer();

      for(int j = 0; j < s.length(); ++j) {
         stringbuffer.append("*");
      }

      return stringbuffer.toString();
   }
}
