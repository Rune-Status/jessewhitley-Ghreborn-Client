package com.Ghreborn.client.entity;

import java.awt.Color;

import com.Ghreborn.client.Main;
import com.Ghreborn.client.TextClass;
import com.Ghreborn.client.cache.anim.Frame;
import com.Ghreborn.client.cache.def.ItemDefinition;
import com.Ghreborn.client.cache.def.NpcDefinition;
import com.Ghreborn.client.cache.def.Animation;
import com.Ghreborn.client.cache.def.Graphic;
import com.Ghreborn.client.cache.def.IdentityKit;
import com.Ghreborn.client.entity.Entity;
import com.Ghreborn.client.entity.model.Model;
import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.link.MRUNodes;

public final class Player extends Entity {
   public int anInt1707;
   public int anInt1708;
   public int anInt1709;
   public int anInt1711;
   public int anInt1712;
   public int anInt1713;
   public int anInt1719;
   public int anInt1720;
   public int anInt1721;
   public int anInt1722;
   public int skill;
   public static MRUNodes aClass12_1704 = new MRUNodes(260);
   long aLong1697 = -1L;
   public boolean aBoolean1699 = false;
   public int[] anIntArray1700 = new int[5];
   public boolean visible;
   private int anInt1715 = 9;
   private boolean aBoolean1716 = true;
   public int[] equipment = new int[12];
   boolean isNpc = false;
   public Model aModel_1714;
   public int gender;
   public int headIcon;
   public int skullIcon;
   public NpcDefinition aClass5_1698;
   public int anInt1701;
   public String name;
   public int combatLevel;
   public int title;
   long appearanceOffset;
   public int hintIcon;

   public final Model getRotatedModel() {
      if(!this.visible) {
         return null;
      } else {
         Model Model = this.method452(0);
         if(Model == null) {
            return null;
         } else {
            super.anInt1507 = Model.modelHeight;
            Model.aBoolean1659 = true;
            if(this.aBoolean1699) {
               return Model;
            } else {
               if(super.anInt1520 != -1 && super.anInt1521 != -1) {
                  Graphic Model_111 = Graphic.cache[super.anInt1520];
                  Model aModel11 = Model_111.method266();
                  if(aModel11 != null) {
                     Model Model_3 = new Model(true, Frame.method532(super.anInt1521), false, aModel11);
                     Model_3.method475(0, -super.anInt1524, 16384, 0);
                     Model_3.method469((byte)-71);
                     Model_3.method470(Model_111.aAnimation_407.primary[super.anInt1521]);
                     Model_3.anIntArrayArray1658 = null;
                     Model_3.anIntArrayArray1657 = null;
                     if(Model_111.resizeX != 128 || Model_111.resizeY != 128) {
                        Model_3.method478(Model_111.resizeX, Model_111.resizeX, this.anInt1715, Model_111.resizeY);
                     }

                     Model_3.method479(64 + Model_111.ambience, 850 + Model_111.contrast, -30, -50, -30, true);
                     Model[] aModel_1 = new Model[]{Model, Model_3};
                     Model = new Model(aModel_1);
                  }
               }

               if(this.aModel_1714 != null) {
                  if(Main.loopCycle >= this.anInt1708) {
                     this.aModel_1714 = null;
                  }

                  if(Main.loopCycle >= this.anInt1707 && Main.loopCycle < this.anInt1708) {
                     Model Model_1111 = this.aModel_1714;
                     Model_1111.method475(this.anInt1711 - super.x, this.anInt1712 - this.anInt1709, 16384, this.anInt1713 - super.y);
                     if(super.turnDirection == 512) {
                        Model_1111.method473(360);
                        Model_1111.method473(360);
                        Model_1111.method473(360);
                     } else if(super.turnDirection == 1024) {
                        Model_1111.method473(360);
                        Model_1111.method473(360);
                     } else if(super.turnDirection == 1536) {
                        Model_1111.method473(360);
                     }

                     Model[] aModel111 = new Model[]{Model, Model_1111};
                     Model = new Model(aModel111);
                     if(super.turnDirection == 512) {
                        Model_1111.method473(360);
                     } else if(super.turnDirection == 1024) {
                        Model_1111.method473(360);
                        Model_1111.method473(360);
                     } else if(super.turnDirection == 1536) {
                        Model_1111.method473(360);
                        Model_1111.method473(360);
                        Model_1111.method473(360);
                     }

                     Model_1111.method475(super.x - this.anInt1711, this.anInt1709 - this.anInt1712, 16384, super.y - this.anInt1713);
                  }
               }

               Model.aBoolean1659 = true;
               return Model;
            }
         }
      }
   }

   public final void method451(Buffer stream) {
      stream.currentOffset = 0;
      this.gender = stream.readUnsignedByte();
      this.headIcon = stream.readUnsignedByte();
      this.skullIcon = stream.readUnsignedByte();
      this.aClass5_1698 = null;
      this.anInt1701 = 0;

      int visibleInt;
      int i2;
      for(visibleInt = 0; visibleInt < 12; ++visibleInt) {
         i2 = stream.readUnsignedByte();
         if(i2 == 0) {
            this.equipment[visibleInt] = 0;
         } else {
            int i1 = stream.readUnsignedByte();
            this.equipment[visibleInt] = (i2 << 8) + i1;
            int l1;
            if(visibleInt == 0 && this.equipment[0] == '\uffff') {
               l1 = stream.readUnsignedWord();
               this.aClass5_1698 = NpcDefinition.lookup(l1);
               break;
            }

            if(visibleInt == 0 && this.equipment[0] == '\uffff') {
               this.aClass5_1698 = NpcDefinition.lookup(stream.readUnsignedWord());
               break;
            }

            if(this.equipment[visibleInt] >= 512 && this.equipment[visibleInt] - 512 < ItemDefinition.totalItems) {
               l1 = ItemDefinition.lookup(this.equipment[visibleInt] - 512).team;
               if(l1 != 0) {
                  this.anInt1701 = l1;
               }
            }
         }
      }

      for(visibleInt = 0; visibleInt < 5; ++visibleInt) {
         i2 = stream.readUnsignedByte();
         if(!(visibleInt == 4 && (i2 == 30 || i2 == 40)) && i2 < 0 || i2 >= Main.PLAYER_BODY_RECOLOURS[visibleInt].length) {
            i2 = 0;
         }

         this.anIntArray1700[visibleInt] = i2;
      }

         super.anInt1511 = stream.readUnsignedWord();
         if(super.anInt1511 == '\uffff') {
            super.anInt1511 = -1;
         }

         super.anInt1512 = stream.readUnsignedWord();
         if(super.anInt1512 == '\uffff') {
            super.anInt1512 = -1;
         }

         super.anInt1554 = stream.readUnsignedWord();
         if(super.anInt1554 == '\uffff') {
            super.anInt1554 = -1;
         }

         super.anInt1555 = stream.readUnsignedWord();
         if(super.anInt1555 == '\uffff') {
            super.anInt1555 = -1;
         }

         super.anInt1556 = stream.readUnsignedWord();
         if(super.anInt1556 == '\uffff') {
            super.anInt1556 = -1;
         }

         super.anInt1557 = stream.readUnsignedWord();
         if(super.anInt1557 == '\uffff') {
            super.anInt1557 = -1;
         }

         super.anInt1505 = stream.readUnsignedWord();
         if(super.anInt1505 == '\uffff') {
            super.anInt1505 = -1;
      }

      this.name = TextClass.fixName(TextClass.nameForLong(stream.method414(-35089)));
      this.combatLevel = stream.readUnsignedByte();
      this.title = stream.readUShort();
		visible = stream.readUnsignedByte() == 0;

      this.appearanceOffset = 0L;

      for(i2 = 0; i2 < 12; ++i2) {
         this.appearanceOffset <<= 4;
         if(this.equipment[i2] >= 256) {
            this.appearanceOffset += (long)(this.equipment[i2] - 256);
         }
      }

      if(this.equipment[0] >= 256) {
         this.appearanceOffset += (long)(this.equipment[0] - 256 >> 4);
      }

      if(this.equipment[1] >= 256) {
         this.appearanceOffset += (long)(this.equipment[1] - 256 >> 8);
      }

      for(i2 = 0; i2 < 5; ++i2) {
         this.appearanceOffset <<= 3;
         this.appearanceOffset += (long)this.anIntArray1700[i2];
      }

      this.appearanceOffset <<= 1;
      this.appearanceOffset += (long)this.gender;
   }

   public final Model method452(int i) {
      if(this.aClass5_1698 != null) {
         int var14 = -1;
         if(super.anim >= 0 && super.anInt1529 == 0) {
            var14 = Animation.anims[super.anim].primary[super.anInt1527];
         } else if(super.anInt1517 >= 0) {
            var14 = Animation.anims[super.anInt1517].primary[super.anInt1518];
         }

         Model Model = this.aClass5_1698.method164(0, -1, var14, null);
         return Model;
      } else {
         long l = this.appearanceOffset;
         int k = -1;
         int i1 = -1;
         int j1 = -1;
         int k1 = -1;
         if(super.anim >= 0 && super.anInt1529 == 0) {
            Animation var151 = Animation.anims[super.anim];
            k = var151.primary[super.anInt1527];
            if(super.anInt1517 >= 0 && super.anInt1517 != super.anInt1511) {
               i1 = Animation.anims[super.anInt1517].primary[super.anInt1518];
            }

            if(var151.playerOffhand >= 0) {
               j1 = var151.playerOffhand;
               l += (long)(j1 - this.equipment[5] << 40);
            }

            if(var151.playerMainhand >= 0) {
               k1 = var151.playerMainhand;
               l += (long)(k1 - this.equipment[3] << 48);
            }
         } else if(super.anInt1517 >= 0) {
            k = Animation.anims[super.anInt1517].primary[super.anInt1518];
         }

         Model var15 = (Model)aClass12_1704.insertFromCache(l);
         int j2;
         if(i != 0) {
            for(j2 = 1; j2 > 0; ++j2) {
            }
         }

         int j3;
         if(var15 == null) {
            boolean var17 = false;

            for(j2 = 0; j2 < 12; ++j2) {
               j3 = this.equipment[j2];
               if(k1 >= 0 && j2 == 3) {
                  j3 = k1;
               }

               if(j1 >= 0 && j2 == 5) {
                  j3 = j1;
               }

               if(j3 >= 256 && j3 < 512 && !IdentityKit.kits[j3 - 256].method537()) {
                  var17 = true;
               }

               if(j3 >= 512 && !ItemDefinition.lookup(j3 - 512).method195(this.gender)) {
                  var17 = true;
               }
            }

            if(var17) {
               if(this.aLong1697 != -1L) {
                  var15 = (Model)aClass12_1704.insertFromCache(this.aLong1697);
               }

               if(var15 == null) {
                  return null;
               }
            }
         }

         if(var15 == null) {
            Model[] var16 = new Model[12];
            j2 = 0;

            for(j3 = 0; j3 < 12; ++j3) {
               int i3 = this.equipment[j3];
               if(k1 >= 0 && j3 == 3) {
                  i3 = k1;
               }

               if(j1 >= 0 && j3 == 5) {
                  i3 = j1;
               }

               Model Model_4;
               if(i3 >= 256 && i3 < 512) {
                  Model_4 = IdentityKit.kits[i3 - 256].method538();
                  if(Model_4 != null) {
                     var16[j2++] = Model_4;
                  }
               }

               if(i3 >= 512) {
                  Model_4 = ItemDefinition.lookup(i3 - 512).method196(this.gender);
                  if(Model_4 != null) {
                     var16[j2++] = Model_4;
                  }
               }
            }

            var15 = new Model(j2, var16);

            for(j3 = 0; j3 < 5; ++j3) {
               if(this.anIntArray1700[j3] != 0) {
                  var15.recolor(Main.PLAYER_BODY_RECOLOURS[j3][0], Main.PLAYER_BODY_RECOLOURS[j3][this.anIntArray1700[j3]]);
                  if(j3 == 1) {
                     var15.recolor(Main.anIntArray1204[0], Main.anIntArray1204[this.anIntArray1700[j3]]);
                  }
               }
            }

            var15.method469((byte)-71);
            var15.method479(64, 850, -30, -50, -30, true);
            aClass12_1704.removeFromCache(var15, l);
            this.aLong1697 = l;
         }

         if(this.aBoolean1699) {
            return var15;
         } else {
            Model var171 = Model.aModel_1621;
            var171.method464(7, var15, Frame.method532(k) & Frame.method532(i1));
            if(k != -1 && i1 != -1) {
               var171.method471(-20491, Animation.anims[super.anim].interleaveOrder, i1, k);
            } else if(k != -1) {
               var171.method470(k);
            }

            var171.method466();
            var171.anIntArrayArray1658 = null;
            var171.anIntArrayArray1657 = null;
            return var171;
         }
      }
   }

	public Player()
	{
		aLong1697 = -1L;
		aBoolean1699 = false;
		anIntArray1700 = new int[5];
		visible = false;
		equipment = new int[12];
	}
   public final boolean isVisible() {
         return this.visible;
   }

   public final Model method453() {
      if(!this.visible)
         return null;
       if(this.aClass5_1698 != null)
         return this.aClass5_1698.method160(true);
         boolean flag = false;

         for(int var81 = 0; var81 < 12; ++var81) {
            int k = this.equipment[var81];
            if(k >= 256 && k < 512 && !IdentityKit.kits[k - 256].headLoaded())
               flag = true;
            if(k >= 512 && !ItemDefinition.lookup(k - 512).method192(this.gender))
               flag = true;
         }

         if(flag) {
            return null;
         } else {
            Model[] var8 = new Model[12];
            int k = 0;

            int j1;
            for(int var91 = 0; var91 < 12; ++var91) {
               j1 = this.equipment[var91];
               Model Model_2;
               if(j1 >= 256 && j1 < 512) {
                  Model_2 = IdentityKit.kits[j1 - 256].headModel();
                  if(Model_2 != null) {
                     var8[k++] = Model_2;
                  }
               }

               if(j1 >= 512) {
                  Model_2 = ItemDefinition.lookup(j1 - 512).method194(this.gender);
                  if(Model_2 != null) {
                     var8[k++] = Model_2;
                  }
               }
            }

            Model var9 = new Model(k, var8);

            for(j1 = 0; j1 < 5; ++j1) {
            	int index = anIntArray1700[j1];
               if(index != 0) {
            	   int colour = j1 == 4 ? skin(index) : Main.PLAYER_BODY_RECOLOURS[j1][anIntArray1700[j1]];
                  var9.recolor(Main.PLAYER_BODY_RECOLOURS[j1][0], colour);
                  if(j1 == 1) {
                     var9.recolor(Main.anIntArray1204[0], Main.anIntArray1204[this.anIntArray1700[j1]]);
                  }
               }
            }

            return var9;
         }
   }
   private int skin(int index) {

		switch(index) {
			case 30:
				return RGB_to_RS2HSB(55, 75, 30);

			case 40:
				return RGB_to_RS2HSB(0, 100, 100);

			default:
				return Main.PLAYER_BODY_RECOLOURS[4][index];
		}
	}
	public static int RGB_to_RS2HSB(int red, int green, int blue) {
		float[] HSB = Color.RGBtoHSB(red, green, blue, null);
		float hue = (HSB[0]);
		float saturation = (HSB[1]);
		float brightness = (HSB[2]);
		int encode_hue = (int) (hue * 63);			//to 6-bits
		int encode_saturation = (int) (saturation * 7);		//to 3-bits
		int encode_brightness = (int) (brightness * 127); 	//to 7-bits
		return (encode_hue << 10) + (encode_saturation << 7) + (encode_brightness);
	}
}
