package com.Ghreborn.client.entity;

import com.Ghreborn.client.Main;
import com.Ghreborn.client.cache.def.Animation;
import com.Ghreborn.client.entity.Animable;
import java.util.Random;

public class Entity extends Animable {
   public String aString1506;
   public int turnDirection;
   public int anInt1513;
   public int anInt1518;
   public int anInt1519;
   public int anInt1521;
   public int anInt1522;
   public int anInt1523;
   public int anInt1524;
   public int anInt1527;
   public int anInt1528;
   public int anInt1529;
   public int anInt1530;
   public int anInt1531;
   public int maxHealth;
   public int currentHealth;
   public int anInt1537;
   public int anInt1538;
   public int anInt1539;
   public int anInt1543;
   public int anInt1544;
   public int anInt1545;
   public int anInt1546;
   public int anInt1547;
   public int anInt1548;
   public int anInt1549;
   public int anInt1552;
   public int nextAnimationFrame;
   public int nextGraphicsAnimationFrame;
   public int nextIdleAnimationFrame;
   public int[] smallX = new int[10];
   public int[] smallY = new int[10];
   public int interactingEntity = -1;
   public int anInt1504 = 32;
   public int anInt1505 = -1;
   public int anInt1507 = 200;
   private boolean aBoolean1508 = false;
   private int anInt1509 = -35698;
   public int anInt1511 = -1;
   public int anInt1512 = -1;
   public int[] anIntArray1514 = new int[4];
   public int[] anIntArray1515 = new int[4];
   public int[] anIntArray1516 = new int[4];
   public int anInt1517 = -1;
   public int anInt1520 = -1;
   public int anim = -1;
   public int anInt1532 = -1000;
   public int textCycle = 100;
   private int anInt1536 = -895;
   public int anInt1540 = 1;
   public boolean aBoolean1541 = false;
   public boolean[] aBooleanArray1553 = new boolean[10];
   public int anInt1554 = -1;
   public int anInt1555 = -1;
   public int anInt1556 = -1;
   public int anInt1557 = -1;
   public int smallXYIndex;
   public int anInt1542;
   public int anInt1503;
   public int x;
   public int y;
   public int heightLevel;

   public final void method445(int i, int j, boolean flag, boolean flag1) {
      if(this.anim != -1 && Animation.anims[this.anim].walkingPrecedence == 1) {
         this.anim = -1;
      }

      if(!flag) {
         int k = i - this.smallX[0];
         int l = j - this.smallY[0];
         if(k >= -8 && k <= 8 && l >= -8 && l <= 8) {
            if(this.smallXYIndex < 9) {
               ++this.smallXYIndex;
            }

            for(int i1 = this.smallXYIndex; i1 > 0; --i1) {
               this.smallX[i1] = this.smallX[i1 - 1];
               this.smallY[i1] = this.smallY[i1 - 1];
               this.aBooleanArray1553[i1] = this.aBooleanArray1553[i1 - 1];
            }

            this.smallX[0] = i;
            this.smallY[0] = j;
            this.aBooleanArray1553[0] = false;
            return;
         }
      }

      this.smallXYIndex = 0;
      this.anInt1542 = 0;
      this.anInt1503 = 0;
      this.smallX[0] = i;
      this.smallY[0] = j;
      this.x = this.smallX[0] * 128 + this.anInt1540 * 64;
      if(flag1) {
         this.anInt1536 = 42;
      }

      this.y = this.smallY[0] * 128 + this.anInt1540 * 64;
   }

   public final void method446() {
      this.smallXYIndex = 0;
      this.anInt1542 = 0;
   }

   public final void method447(int j, int k, int l) {
      for(int i1 = 0; i1 < 4; ++i1) {
         if(this.anIntArray1516[i1] <= l) {
            this.anIntArray1514[i1] = k;
            this.anIntArray1515[i1] = j;
            this.anIntArray1516[i1] = l + 70;
            return;
         }
      }
   }

   public final void method448(boolean flag, byte byte0, int i) {
      int j = this.smallX[0];
      int k = this.smallY[0];
      if(i == 0) {
         --j;
         ++k;
      }

      if(i == 1) {
         ++k;
      }

      if(i == 2) {
         ++j;
         ++k;
      }

      if(i == 3) {
         --j;
      }

      if(i == 4) {
         ++j;
      }

      if(i == 5) {
         --j;
         --k;
      }

      if(i == 6) {
         --k;
      }

      if(i == 7) {
         ++j;
         --k;
      }

      if(this.anim != -1 && Animation.anims[this.anim].walkingPrecedence == 1) {
         this.anim = -1;
      }

      if(this.smallXYIndex < 9) {
         ++this.smallXYIndex;
      }

      for(int l = this.smallXYIndex; l > 0; --l) {
         this.smallX[l] = this.smallX[l - 1];
         this.smallY[l] = this.smallY[l - 1];
         this.aBooleanArray1553[l] = this.aBooleanArray1553[l - 1];
      }

      if(byte0 == 20) {
         this.smallX[0] = j;
         this.smallY[0] = k;
         this.aBooleanArray1553[0] = flag;
      }

   }

   public boolean isVisible() {
      return false;
   }
}
