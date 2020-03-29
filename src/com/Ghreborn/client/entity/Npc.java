package com.Ghreborn.client.entity;

import com.Ghreborn.client.cache.anim.Frame;
import com.Ghreborn.client.cache.def.Animation;
import com.Ghreborn.client.cache.def.Graphic;
import com.Ghreborn.client.cache.def.NpcDefinition;
import com.Ghreborn.client.entity.Entity;
import com.Ghreborn.client.entity.model.Model;

public final class Npc extends Entity {
   private int anInt1693;
   public NpcDefinition desc;
   private boolean aBoolean1694 = false;
   private int anInt1695 = 9;

   final Model method450(int i) {
      int l;
      if(i != 0) {
         for(l = 1; l > 0; ++l) {
         }
      }

      if(super.anim >= 0 && super.anInt1529 == 0) {
         l = Animation.anims[super.anim].primary[super.anInt1527];
         int i1 = -1;
         if(super.anInt1517 >= 0 && super.anInt1517 != super.anInt1511) {
            i1 = Animation.anims[super.anInt1517].primary[super.anInt1518];
         }

         return this.desc.method164(0, i1, l, Animation.anims[super.anim].interleaveOrder);
      } else {
         l = -1;
         if(super.anInt1517 >= 0) {
            l = Animation.anims[super.anInt1517].primary[super.anInt1518];
         }

         return this.desc.method164(0, -1, l, null);
      }
   }

   public final Model getRotatedModel() {
      if(this.desc == null) {
         return null;
      } else {
         Model Model = this.method450(0);
         if(Model == null) {
            return null;
         } else {
            super.anInt1507 = Model.modelHeight;
            if(super.anInt1520 != -1 && super.anInt1521 != -1) {
               Graphic class23 = Graphic.cache[super.anInt1520];
               Model Model_1 = class23.method266();
               if(Model_1 != null) {
                  int j = class23.aAnimation_407.primary[super.anInt1521];
                  Model Model_2 = new Model( true, Frame.method532(j), false, Model_1);
                  Model_2.method475(0, -super.anInt1524, 16384, 0);
                  Model_2.method469((byte)-71);
                  Model_2.method470(j);
                  Model_2.anIntArrayArray1658 = null;
                  Model_2.anIntArrayArray1657 = null;
                  if(class23.resizeX != 128 || class23.resizeY != 128) {
                     Model_2.method478(class23.resizeX, class23.resizeX, this.anInt1695, class23.resizeY);
                  }

                  Model_2.method479(64 + class23.ambience, 850 + class23.contrast, -30, -50, -30, true);
                  Model[] aModel = new Model[]{Model, Model_2};
                  Model = new Model(aModel);
               }
            }

            if(this.desc.spaceOccupied == 1) {
               Model.aBoolean1659 = true;
            }

            return Model;
         }
      }
   }

   public final boolean isVisible() {
      return this.desc != null;
   }
}
