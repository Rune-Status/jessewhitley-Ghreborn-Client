package com.Ghreborn.client.entity;

import com.Ghreborn.client.cache.anim.Frame;
import com.Ghreborn.client.cache.def.Graphic;
import com.Ghreborn.client.entity.Animable;
import com.Ghreborn.client.entity.model.Model;

public final class Animable_Sub3 extends Animable {
   private boolean aBoolean1565 = true;
   private int anInt1566 = 9;
   public boolean aBoolean1567 = false;
   private Graphic aClass23_1568;
   public int anInt1560;
   public int anInt1561;
   public int anInt1562;
   public int anInt1563;
   public int anInt1564;
   private int anInt1570;
   private int anInt1569;

   public Animable_Sub3(int i, int j, int k, int l, int i1, int j1, int k1, int l1) {
      this.aClass23_1568 = Graphic.cache[i1];
      this.anInt1560 = i;
      this.anInt1561 = l1;
      this.anInt1562 = k1;
      this.anInt1563 = j1;
      this.anInt1564 = j + l;
      if(k != 6) {
         throw new NullPointerException();
      } else {
         this.aBoolean1567 = false;
      }
   }

   public final Model method444(int i) {
      if(i != 4016) {
         throw new NullPointerException();
      } else {
         Model Model = this.aClass23_1568.method266();
         if(Model == null) {
            return null;
         } else {
            int j = this.aClass23_1568.aAnimation_407.primary[this.anInt1569];
            Model Model_1 = new Model(true, Frame.method532(j), false, Model);
            if(!this.aBoolean1567) {
               Model_1.method469((byte)-71);
               Model_1.method470(j);
               Model_1.anIntArrayArray1658 = null;
               Model_1.anIntArrayArray1657 = null;
            }

            if(this.aClass23_1568.resizeX != 128 || this.aClass23_1568.resizeY != 128) {
               Model_1.method478(this.aClass23_1568.resizeX, this.aClass23_1568.resizeX, this.anInt1566, this.aClass23_1568.resizeY);
            }

            if(this.aClass23_1568.rotation != 0) {
               if(this.aClass23_1568.rotation == 90) {
                  Model_1.method473(360);
               }

               if(this.aClass23_1568.rotation == 180) {
                  Model_1.method473(360);
                  Model_1.method473(360);
               }

               if(this.aClass23_1568.rotation == 270) {
                  Model_1.method473(360);
                  Model_1.method473(360);
                  Model_1.method473(360);
               }
            }

            Model_1.method479(64 + this.aClass23_1568.ambience, 850 + this.aClass23_1568.contrast, -30, -50, -30, true);
            return Model_1;
         }
      }
   }

   public final void method454(int i, boolean flag) {
      if(!flag) {
         for(int j = 1; j > 0; ++j) {
         }
      }

      this.anInt1570 += i;

      while(true) {
         do {
            do {
               if(this.anInt1570 <= this.aClass23_1568.aAnimation_407.method258(this.anInt1569)) {
                  return;
               }

               this.anInt1570 -= this.aClass23_1568.aAnimation_407.method258(this.anInt1569) + 1;
               ++this.anInt1569;
            } while(this.anInt1569 < this.aClass23_1568.aAnimation_407.frameCount);
         } while(this.anInt1569 >= 0 && this.anInt1569 < this.aClass23_1568.aAnimation_407.frameCount);

         this.anInt1569 = 0;
         this.aBoolean1567 = true;
      }
   }
}
