package com.Ghreborn.client;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOperations {
   public static int TotalRead = 0;
   public static int TotalWrite = 0;
   public static int CompleteWrite = 0;

   public static final byte[] ReadFile(String s) {
      try {
         File var51 = new File(s);
         int i = (int)var51.length();
         byte[] abyte0 = new byte[i];
         DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new FileInputStream(s)));
         datainputstream.readFully(abyte0, 0, i);
         datainputstream.close();
         ++TotalRead;
         return abyte0;
      } catch (Exception var5) {
         System.out.println("Read Error: " + s);
         return null;
      }
   }

   public static final void WriteFile(String s, byte[] abyte0) {
      try {
         (new File((new File(s)).getParent())).mkdirs();
         FileOutputStream var31 = new FileOutputStream(s);
         var31.write(abyte0, 0, abyte0.length);
         var31.close();
         ++TotalWrite;
         ++CompleteWrite;
      } catch (Throwable var3) {
         System.out.println("Write Error: " + s);
      }

   }

   public static boolean FileExists(String file) {
      File f = new File(file);
      return f.exists();
   }
}
