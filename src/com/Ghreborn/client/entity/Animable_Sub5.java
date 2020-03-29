package com.Ghreborn.client.entity;

import com.Ghreborn.client.Main;
import com.Ghreborn.client.cache.def.Animation;
import com.Ghreborn.client.cache.def.ObjectDefinition;
import com.Ghreborn.client.cache.def.VarBit;
import com.Ghreborn.client.entity.Animable;
import com.Ghreborn.client.entity.model.Model;

public class Animable_Sub5 extends Animable {
   public static Main aClient1609;
   private int anInt1613;
   private int anInt1608;
   private int anInt1599;
   private Animation aClass20_1607;
   private byte aByte1598 = 7;
   private int anInt1610;
   private int anInt1611;
   private int anInt1612;
   private int anInt1603;
   private int anInt1604;
   private int anInt1605;
   private int anInt1606;
   int anInt1601;
   int anInt1602;
   int[] anIntArray1600;

   public final Model getRotatedModel() {
      int j = -1;
      if(this.aClass20_1607 != null) {
         int var41 = Main.loopCycle - this.anInt1608;
         if(var41 > 100 && this.aClass20_1607.loopOffset > 0) {
            var41 = 100;
         }

         label41: {
            do {
               do {
                  if(var41 <= this.aClass20_1607.method258(this.anInt1599)) {
                     break label41;
                  }

                  var41 -= this.aClass20_1607.method258(this.anInt1599);
                  ++this.anInt1599;
               } while(this.anInt1599 < this.aClass20_1607.frameCount);

               this.anInt1599 -= this.aClass20_1607.loopOffset;
            } while(this.anInt1599 >= 0 && this.anInt1599 < this.aClass20_1607.frameCount);

            this.aClass20_1607 = null;
         }

         this.anInt1608 = Main.loopCycle - var41;
         if(this.aClass20_1607 != null) {
            j = this.aClass20_1607.primary[this.anInt1599];
         }
      }

      ObjectDefinition var4;
      if(this.anIntArray1600 != null) {
         var4 = this.method457();
      } else {
         var4 = ObjectDefinition.forID(this.anInt1610);
      }

      if(var4 == null) {
         return null;
      } else {
         Model Model = var4.method578(this.anInt1611, this.anInt1612, this.anInt1603, this.anInt1604, this.anInt1605, this.anInt1606, j);
         return Model;
      }
   }

   private ObjectDefinition method457() {
      int i = -1;
      if(this.anInt1601 != -1) {
         try {
            VarBit class37 = VarBit.cache[this.anInt1601];
            int k = class37.configId;
            int l = class37.lsb;
            int i1 = class37.msb;
            int j1 = Main.BIT_MASKS[i1 - l];
            i = aClient1609.settings[k] >> l & j1;
         } catch (Exception var7) {
         }
      } else if(this.anInt1602 != - 1&& anInt1602 < Main.BIT_MASKS.length) {
         i = aClient1609.settings[this.anInt1602];
      }

      return i >= 0 && i < this.anIntArray1600.length && this.anIntArray1600[i] != -1?ObjectDefinition.forID(this.anIntArray1600[i]):null;
   }

   public Animable_Sub5(int i, int j, int k, int l,  int i1, int j1, int k1, int l1, boolean flag) {

      this.anInt1610 = i;
      this.anInt1611 = k;
      this.anInt1612 = j;
      this.anInt1603 = j1;
      this.anInt1604 = l;
      this.anInt1605 = i1;
      this.anInt1606 = k1;
      if(l1 != -1) {
         this.aClass20_1607 = Animation.anims[l1];
         this.anInt1599 = 0;
         this.anInt1608 = Main.loopCycle;
         if(flag && this.aClass20_1607.loopOffset != -1) {
            this.anInt1599 = (int)(Math.random() * (double)this.aClass20_1607.frameCount);
            this.anInt1608 -= (int)(Math.random() * (double)this.aClass20_1607.method258(this.anInt1599));
         }
      }

      ObjectDefinition var12 = ObjectDefinition.forID(this.anInt1610);
      this.anInt1601 = var12.varbit;
      this.anInt1602 = var12.varp;
      this.anIntArray1600 = var12.morphisms;
   }
}
