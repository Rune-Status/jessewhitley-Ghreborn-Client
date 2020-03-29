package com.Ghreborn.client.sound;

import com.Ghreborn.client.io.Buffer;

public class Class29 {
   public static int anInt546;
   private boolean aBoolean531 = false;
   private byte aByte532 = -112;
   private boolean aBoolean533 = false;
   private boolean aBoolean534 = true;
   int anInt540;
   int anInt538;
   int anInt539;
   private int anInt535;
   private int[] anIntArray536;
   private int[] anIntArray537;
   private int anInt541;
   private int anInt542;
   private int anInt543;
   private int anInt544;
   private int anInt545;

   public final void method325(boolean flag, Buffer class30_sub2_sub2) {
      this.anInt540 = class30_sub2_sub2.readUnsignedByte();
      if(!flag) {
         throw new NullPointerException();
      } else {
         this.anInt538 = class30_sub2_sub2.readInt();
         this.anInt539 = class30_sub2_sub2.readInt();
         this.method326((byte)-112, class30_sub2_sub2);
      }
   }

   public final void method326(byte byte0, Buffer class30_sub2_sub2) {
      if(byte0 != this.aByte532) {
         this.aBoolean533 = !this.aBoolean533;
      }

      this.anInt535 = class30_sub2_sub2.readUnsignedByte();
      this.anIntArray536 = new int[this.anInt535];
      this.anIntArray537 = new int[this.anInt535];

      for(int i = 0; i < this.anInt535; ++i) {
         this.anIntArray536[i] = class30_sub2_sub2.readUnsignedWord();
         this.anIntArray537[i] = class30_sub2_sub2.readUnsignedWord();
      }

   }

   final void method327(byte byte0) {
      this.anInt541 = 0;
      if(byte0 == 8) {
         boolean var2 = false;
      } else {
         this.aBoolean534 = !this.aBoolean534;
      }

      this.anInt542 = 0;
      this.anInt543 = 0;
      this.anInt544 = 0;
      this.anInt545 = 0;
   }

   final int method328(boolean flag, int i) {
      if(!flag) {
         this.aBoolean531 = !this.aBoolean531;
      }

      if(this.anInt545 >= this.anInt541) {
         this.anInt544 = this.anIntArray537[this.anInt542++] << 15;
         if(this.anInt542 >= this.anInt535) {
            this.anInt542 = this.anInt535 - 1;
         }

         this.anInt541 = (int)((double)this.anIntArray536[this.anInt542] / 65536.0D * (double)i);
         if(this.anInt541 > this.anInt545) {
            this.anInt543 = ((this.anIntArray537[this.anInt542] << 15) - this.anInt544) / (this.anInt541 - this.anInt545);
         }
      }

      this.anInt544 += this.anInt543;
      ++this.anInt545;
      return this.anInt544 - this.anInt543 >> 15;
   }
}
