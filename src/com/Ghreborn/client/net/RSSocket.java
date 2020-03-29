package com.Ghreborn.client.net;

import com.Ghreborn.client.Applet_Sub1;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class RSSocket implements Runnable {
   private int anInt416 = -53;
   private boolean aBoolean417 = true;
   private int anInt418 = 519;
   private boolean aBoolean422 = false;
   private boolean aBoolean427 = false;
   private boolean aBoolean428;
   Applet_Sub1 anApplet_Sub1_423;
   private Socket aSocket421;
   private InputStream anInputStream419;
   private OutputStream anOutputStream420;
   private byte[] aByteArray424;
   private int anInt426;
   private int anInt425;

   public RSSocket(Applet_Sub1 applet_sub1, int i, Socket socket) throws IOException {
      for(this.aBoolean428 = false; i >= 0; this.aBoolean417 = !this.aBoolean417) {
      }

      this.anApplet_Sub1_423 = applet_sub1;
      this.aSocket421 = socket;
      this.aSocket421.setSoTimeout(30000);
      this.aSocket421.setTcpNoDelay(true);
      this.anInputStream419 = this.aSocket421.getInputStream();
      this.anOutputStream420 = this.aSocket421.getOutputStream();
   }

   public void method267() {
      this.aBoolean422 = true;

      try {
         if(this.anInputStream419 != null) {
            this.anInputStream419.close();
         }

         if(this.anOutputStream420 != null) {
            this.anOutputStream420.close();
         }

         if(this.aSocket421 != null) {
            this.aSocket421.close();
         }
      } catch (IOException var3) {
         System.out.println("Error closing stream");
      }

      this.aBoolean427 = false;
      synchronized(this) {
         this.notify();
      }

      this.aByteArray424 = null;
   }

   public int method268() throws IOException {
      return this.aBoolean422?0:this.anInputStream419.read();
   }

   public int method269() throws IOException {
      return this.aBoolean422?0:this.anInputStream419.available();
   }

   public void method270(byte[] abyte0, int i, int j) throws IOException {
      if(!this.aBoolean422) {
         while(j > 0) {
            int k = this.anInputStream419.read(abyte0, i, j);
            if(k <= 0) {
               throw new IOException("EOF");
            }

            i += k;
            j -= k;
         }
      }

   }

   public void method271(int i, byte[] abyte0) throws IOException {
      if(!this.aBoolean422) {
         if(this.aBoolean428) {
            this.aBoolean428 = false;
            throw new IOException("Error in writer thread");
         }

         if(this.aByteArray424 == null) {
            this.aByteArray424 = new byte[5000];
         }

         synchronized(this) {
            for(int l = 0; l < i; ++l) {
               this.aByteArray424[this.anInt426] = abyte0[l];
               this.anInt426 = (this.anInt426 + 1) % 5000;
               if(this.anInt426 == (this.anInt425 + 4900) % 5000) {
                  throw new IOException("buffer overflow");
               }
            }

            if(!this.aBoolean427) {
               this.aBoolean427 = true;
               this.anApplet_Sub1_423.method12(this, 3);
            }

            this.notify();
         }
}

   }

   public void run() {
      while(this.aBoolean427) {
         int i;
         int j;
         synchronized(this) {
            if(this.anInt426 == this.anInt425) {
               try {
                  this.wait();
               } catch (InterruptedException var7) {
               }
            }

            if(!this.aBoolean427) {
               return;
            }

            j = this.anInt425;
            if(this.anInt426 >= this.anInt425) {
               i = this.anInt426 - this.anInt425;
            } else {
               i = 5000 - this.anInt425;
            }
         }

         if(i > 0) {
            try {
               this.anOutputStream420.write(this.aByteArray424, j, i);
            } catch (IOException var6) {
               this.aBoolean428 = true;
            }

            this.anInt425 = (this.anInt425 + i) % 5000;

            try {
               if(this.anInt426 == this.anInt425) {
                  this.anOutputStream420.flush();
               }
            } catch (IOException var5) {
               this.aBoolean428 = true;
            }
         }
      }

   }

   public void method272(byte byte0) {
      if(byte0 != 1) {
         this.anInt416 = 457;
      }

      System.out.println("dummy:" + this.aBoolean422);
      System.out.println("tcycl:" + this.anInt425);
      System.out.println("tnum:" + this.anInt426);
      System.out.println("writer:" + this.aBoolean427);
      System.out.println("ioerror:" + this.aBoolean428);

      try {
         System.out.println("available:" + this.method269());
      } catch (IOException var3) {
      }

   }
}
