package com.Ghreborn.client.entity;

import com.Ghreborn.client.cache.anim.Frame;
import com.Ghreborn.client.cache.def.Graphic;
import com.Ghreborn.client.entity.Animable;
import com.Ghreborn.client.entity.model.Model;

public final class Animable_Sub4 extends Animable {
   public double aDouble1585;
   public double aDouble1586;
   public double aDouble1587;
   private double aDouble1574;
   private double aDouble1575;
   private double aDouble1576;
   private double aDouble1577;
   private double aDouble1578;
   private int anInt1573 = 9;
   public boolean aBoolean1579 = false;
   private boolean aBoolean1591 = true;
   private Graphic aClass23_1592;
   public int anInt1597;
   public int anInt1580;
   public int anInt1581;
   public int anInt1582;
   public int anInt1571;
   public int anInt1572;
   public int anInt1588;
   public int anInt1589;
   public int anInt1590;
   public int anInt1583;
   private int anInt1584;
   public int anInt1595;
   public int anInt1596;
   private int anInt1594;
   private int anInt1593;

   public final void method455(int i, int j, int k, int l, byte byte0) {
      double d1;
      if(!this.aBoolean1579) {
         d1 = (double)(l - this.anInt1580);
         double d2 = (double)(j - this.anInt1581);
         double d3 = Math.sqrt(d1 * d1 + d2 * d2);
         this.aDouble1585 = (double)this.anInt1580 + d1 * (double)this.anInt1589 / d3;
         this.aDouble1586 = (double)this.anInt1581 + d2 * (double)this.anInt1589 / d3;
         this.aDouble1587 = (double)this.anInt1582;
      }

      d1 = (double)(this.anInt1572 + 1 - i);
      this.aDouble1574 = ((double)l - this.aDouble1585) / d1;
      if(byte0 == -83) {
         this.aDouble1575 = ((double)j - this.aDouble1586) / d1;
         this.aDouble1576 = Math.sqrt(this.aDouble1574 * this.aDouble1574 + this.aDouble1575 * this.aDouble1575);
         if(!this.aBoolean1579) {
            this.aDouble1577 = -this.aDouble1576 * Math.tan((double)this.anInt1588 * 0.02454369D);
         }

         this.aDouble1578 = 2.0D * ((double)k - this.aDouble1587 - this.aDouble1577 * d1) / (d1 * d1);
      }

   }

   public final Model method444(int i) {
      Model Model = this.aClass23_1592.method266();
      if(Model == null) {
         return null;
      } else {
         int j = -1;
         if(this.aClass23_1592.aAnimation_407 != null) {
            j = this.aClass23_1592.aAnimation_407.primary[this.anInt1593];
         }

         Model Model_1 = new Model(true, Frame.method532(j), false, Model);
         if(j != -1) {
            Model_1.method469((byte)-71);
            Model_1.method470(j);
            Model_1.anIntArrayArray1658 = null;
            Model_1.anIntArrayArray1657 = null;
         }

         if(this.aClass23_1592.resizeX != 128 || this.aClass23_1592.resizeY != 128) {
            Model_1.method478(this.aClass23_1592.resizeX, this.aClass23_1592.resizeX, this.anInt1573, this.aClass23_1592.resizeY);
         }

         Model_1.method474(this.anInt1596, 1);
         Model_1.method479(64 + this.aClass23_1592.ambience, 850 + this.aClass23_1592.contrast, -30, -50, -30, true);
         if(i != 4016) {
            throw new NullPointerException();
         } else {
            return Model_1;
         }
      }
   }

   public Animable_Sub4(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2) {
      this.aClass23_1592 = Graphic.cache[l2];
      if(k != '\ub723') {
         this.aBoolean1591 = !this.aBoolean1591;
      }

      this.anInt1597 = k1;
      this.anInt1580 = j2;
      this.anInt1581 = i2;
      this.anInt1582 = l1;
      this.anInt1571 = l;
      this.anInt1572 = i1;
      this.anInt1588 = i;
      this.anInt1589 = j1;
      this.anInt1590 = k2;
      this.anInt1583 = j;
      this.aBoolean1579 = false;
   }

   public final void method456(int i, int j) {
      this.aBoolean1579 = true;
      this.aDouble1585 += this.aDouble1574 * (double)i;
      this.aDouble1586 += this.aDouble1575 * (double)i;
      this.aDouble1587 += this.aDouble1577 * (double)i + 0.5D * this.aDouble1578 * (double)i * (double)i;
      this.aDouble1577 += this.aDouble1578 * (double)i;
      if(j != 0) {
         this.anInt1584 = 16;
      }

      this.anInt1595 = (int)(Math.atan2(this.aDouble1574, this.aDouble1575) * 325.949D) + 1024 & 2047;
      this.anInt1596 = (int)(Math.atan2(this.aDouble1577, this.aDouble1576) * 325.949D) & 2047;
      if(this.aClass23_1592.aAnimation_407 != null) {
         this.anInt1594 += i;

         while(this.anInt1594 > this.aClass23_1592.aAnimation_407.method258(this.anInt1593)) {
            this.anInt1594 -= this.aClass23_1592.aAnimation_407.method258(this.anInt1593) + 1;
            ++this.anInt1593;
            if(this.anInt1593 >= this.aClass23_1592.aAnimation_407.frameCount) {
               this.anInt1593 = 0;
            }
         }
      }

   }
}
