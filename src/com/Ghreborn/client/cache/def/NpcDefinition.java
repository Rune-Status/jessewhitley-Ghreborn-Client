package com.Ghreborn.client.cache.def;

import com.Ghreborn.client.Main;
import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.cache.anim.Frame;
import com.Ghreborn.client.entity.model.Model;
import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.link.MRUNodes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public final class NpcDefinition {

	   private static int totalNpcs;
	public static final NpcDefinition lookup(int i) {
	      for(int l = 0; l < 20; ++l) {
	         if(cache[l].aLong78 == (long)i) {
	            return cache[l];
	         }
	      }

	      anInt56 = (anInt56 + 1) % 20;
	      NpcDefinition npcdef = cache[anInt56] = new NpcDefinition();
	      dataBuf.currentOffset = offsets[i];
	      npcdef.aLong78 = (long)i;
	      npcdef.readValues(dataBuf);
	      if(i == 8508) {
	    	  npcdef.actions = new String[] {null, "Attack", null, null, null};
	    	  npcdef.name = "Winter demon";
	    	  npcdef.combatLevel = 5000;
	    	  npcdef.standingAnimation = 66;
	    	  npcdef.walkingAnimation = 63;
	    	  npcdef.halfTurnAnimation = 63;
	    	  npcdef.quarterAnticlockwiseTurnAnimation = 63;
	    	  npcdef.quarterClockwiseTurnAnimation = 63;
	    	  npcdef.spaceOccupied = 5;
	    	  npcdef.npcModels = new int[] {17375, 17391, 17384, 17399, 17390};
	    	  npcdef.originalModelColors = new int[] {910, 912, 1938, 1814, 1690, 0};
	    	  npcdef.changedModelColors = new int[] {53315, 31803, 35905, 61, 71, 76};
	    	  npcdef.npcSize = 256;
	    	  npcdef.npcHeight = 256;
	    	  npcdef.aBoolean93 = true;
	    	  npcdef.aBoolean87 = true;
	    	  npcdef.lightModifier = 0;
	    	  npcdef.shadowModifier = 0;
	    	  npcdef.headIcon = -1;
	    	  npcdef.rotation = 32;
	    	  }
	      if(i == 8809) {//Npc ID
	    	  npcdef.name = "Evil Chicken Boss";//Npc Name
	    	  npcdef.actions = new String[]{null, "Attack", null, null, null};
	    	  npcdef.combatLevel = 450;//Npc Combat
	    	  npcdef.standingAnimation = 2298;//Stand Animation  (Default = 808)
	    	  npcdef.walkingAnimation = 2297;//Walk Forward Animation (Default = 819
	    	  npcdef.halfTurnAnimation = -1;//Walk Backwards Animation (Retreat) (Default = 820)
	    	  npcdef.quarterAnticlockwiseTurnAnimation = -1;//Walk Right (Default = 822)
	    	  npcdef.quarterClockwiseTurnAnimation = -1;//Walk Left (Default = 821)
	    	  npcdef.spaceOccupied = 3;
	  		npcdef.npcSize = 200;
	  		npcdef.npcHeight = 200;
	    	  npcdef.npcModels = new int[1];
	    	  npcdef.npcModels[0] = 7728;//Npc Model/Models. 
	    	  }
	      if(i == 527){
	    	  npcdef.name = "Skillcape Shop";
	      }
	      if(i == 3247){
	    	  npcdef.name = "Magical Supplies";
	      }
	      if(i == 1172){
	    	  npcdef.name = "Crafting Supplies";
	      }
	      if(i == 508){
	    	  npcdef.name = "Armour Shop";
	      }
	      if(i == 1045){
	    	  npcdef.name = "Fishing Shop";
	      }
	      if(i == 1044){
	    	  npcdef.name = "Range Shop";
	      }
	      if(i == 505){
	    	  npcdef.name = "Skilling Shop";
	      }
	      if(i == 1023){
	    	  npcdef.name = "Fency Shop";
	      }
	      if(i == 8347) {//Npc ID
	    	  npcdef.name = "Dark Corporeal";//Npc Name
	    	  npcdef.actions = new String[]{null, "Attack", null, null, null};
	    	  npcdef.combatLevel = 985;//Npc Combat
	    	  npcdef.standingAnimation = 1678;//Stand Animation  (Default = 808)
	    	  npcdef.walkingAnimation = 1684;//Walk Forward Animation (Default = 819
	    	  npcdef.halfTurnAnimation = -1;//Walk Backwards Animation (Retreat) (Default = 820)
	    	  npcdef.quarterAnticlockwiseTurnAnimation = -1;//Walk Right (Default = 822)
	    	  npcdef.quarterClockwiseTurnAnimation = -1;//Walk Left (Default = 821)
	    	  npcdef.spaceOccupied = 5;
	  		npcdef.npcSize = 400;
	  		npcdef.npcHeight = 400;
	    	  npcdef.npcModels = new int[1];
	    	  npcdef.npcModels[0] = 91056;//Npc Model/Models. 
	    	  }
	      if(i == 7108) {//Npc ID
	    	  npcdef.actions = new String[]{null, "Attack", null, null, null};
	    	  }
	      if(i == 8349) {//Npc ID
	    	  npcdef.name = "Tormented demon";//Npc Name
	    	  npcdef.actions = new String[]{null, "Attack", null, null, null};
	    	  npcdef.combatLevel = 450;//Npc Combat
	    	  npcdef.standingAnimation = 10921;//Stand Animation  (Default = 808)
	    	  npcdef.walkingAnimation = 10920;//Walk Forward Animation (Default = 819
	    	  npcdef.halfTurnAnimation = -1;//Walk Backwards Animation (Retreat) (Default = 820)
	    	  npcdef.quarterAnticlockwiseTurnAnimation = -1;//Walk Right (Default = 822)
	    	  npcdef.quarterClockwiseTurnAnimation = -1;//Walk Left (Default = 821)
	    	  npcdef.spaceOccupied = 3;
	  		npcdef.npcSize = 25;
	  		npcdef.npcHeight = 125;
	  		npcdef.headIcon = 0;
	    	  npcdef.npcModels = new int[1];
	    	  npcdef.npcModels[0] = 44733;//Npc Model/Models. 
	    	  }
	      if(i == 8640) {
	    	  npcdef.actions = new String[] {"Talk-to", null, "Pick-up", null, null};
	    	  npcdef.name = "Pet Lava dragon";
	    	  npcdef.combatLevel = 0;
	    	  npcdef.standingAnimation = 90;
	    	  npcdef.walkingAnimation = 79;
	    	  npcdef.halfTurnAnimation = 79;
	    	  npcdef.quarterAnticlockwiseTurnAnimation = 79;
	    	  npcdef.quarterClockwiseTurnAnimation = 79;
	    	  npcdef.npcModels = new int[] {28300, 28301, 28302, 17423};
	    	  npcdef.npcSize = 50;
	    	  npcdef.npcHeight = 50;
	    	  npcdef.lightModifier = 0;
	    	  npcdef.shadowModifier = 0;
	    	  npcdef.headIcon = -1;
	    	  npcdef.rotation = 32;
	    	  npcdef.aBoolean87 = false;
	    	  npcdef.aBoolean93 = false;
	    	  npcdef.lightModifier = 0;
	    	  npcdef.shadowModifier = 0;
	    	  npcdef.spaceOccupied = 1;
	    	  }
	      if(i == 9298) {//Npc ID
	    	  npcdef.name = "Kitten";//Npc Name
	    	  npcdef.actions = new String[]{"Pick-up", null, "Talk-to", "Chase", "Interact"};
	    	  npcdef.combatLevel = 0;//Npc Combat
	    	  npcdef.standingAnimation = 9158;//Stand Animation  (Default = 808)
	    	  npcdef.walkingAnimation = 2662;//Walk Forward Animation (Default = 819
	    	  npcdef.halfTurnAnimation = -1;//Walk Backwards Animation (Retreat) (Default = 820)
	    	  npcdef.quarterAnticlockwiseTurnAnimation = -1;//Walk Right (Default = 822)
	    	  npcdef.quarterClockwiseTurnAnimation = -1;//Walk Left (Default = 821)
	    	  npcdef.spaceOccupied = 1;
	  		npcdef.npcSize = 64;
	  		npcdef.npcHeight = 64;
	    	  npcdef.npcModels = new int[1];
	    	  npcdef.npcModels[0] = 42681;//Npc Model/Models. 
	    	  npcdef.aBoolean93 = true;
	    	  npcdef.aBoolean87 = false;
	    	  npcdef.lightModifier = 0;
	    	  npcdef.shadowModifier = 0;
	    	  npcdef.headIcon = -1;
	    	  npcdef.rotation = 32;
	    	  }
switch(i)
{
case 7707:
	//npcdef.anInt2156 = 0;
	npcdef.name = "Ancestral Glyph";
	npcdef.npcModels = new int[] { 33036 };
	npcdef.standingAnimation = 7567;
	npcdef.spaceOccupied = 3;
	npcdef.walkingAnimation = 7567;
	//npcdef.aBool2170 = false;
	npcdef.aBoolean93 = false;
	npcdef.combatLevel = 0;
break;
case 1909:
	npcdef.name = "Vote Master";
	npcdef.actions = new String[]{"Vote", null, "Open Shops", "Check", null};
	npcdef.description = "Talk to me to vote.".getBytes();
	break;
case 13447:
	npcdef.name = "Nex";
	npcdef.npcModels = new int[]{62717};
	npcdef.spaceOccupied = 3;
	npcdef.standingAnimation = 6320;
	npcdef.walkingAnimation = 6319;
	npcdef.actions = new String[]{null, "Attack", null, null, null};
	npcdef.combatLevel = 1001;
	npcdef.aBoolean93 = true;
	npcdef.lightModifier = 10;
	npcdef.shadowModifier = 50;
break;
}
	      return npcdef;
	   }

		public static void dumpNpcConfig() {
	for(int i = 0; i < 7620; i++) {
	NpcDefinition class5 = lookup(i);
	BufferedWriter bw = null;
	try {
	bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/npc.cfg", true));
	if(class5.name!= null) {
	bw.write("npc = "+i+"\t"+class5.name.replace(" ","_")+"\t"+class5.combatLevel+"\t0\t"+class5.spaceOccupied);
	bw.newLine();
	bw.flush();
	bw.close();
	}
	} catch (IOException ioe2) {
	}
	}
	}
	   public final Model method160(boolean flag)
	   {
	       if(morphisms != null)
	       {
	           NpcDefinition class5 = method161();
	           if(class5 == null)
	               return null;
	           else
	               return class5.method160(true);
	       }
	       if(additionalModels == null)
	           return null;
	       boolean flag1 = false;
	       if(!flag)
	           anInt64 = 303;
	       for(int i = 0; i < additionalModels.length; i++)
	           if(!Model.isCached(additionalModels[i]))
	               flag1 = true;

	       if(flag1)
	           return null;
		   Model[] aModel = new Model[additionalModels.length];
	       for(int j = 0; j < additionalModels.length; j++)
	           aModel[j] = Model.getModel(additionalModels[j]);

	       Model Model;
	       if(aModel.length == 1)
	           Model = aModel[0];
	       else
	           Model = new Model(aModel.length, aModel);
	       if(originalModelColors != null)
	       {
	           for(int k = 0; k < originalModelColors.length; k++)
	               Model.recolor(originalModelColors[k], changedModelColors[k]);

	       }
	       return Model;
	   }

	   public final NpcDefinition method161() {
	        int j = -1;
	        if (varbit != -1) {
	            VarBit varBit = VarBit.cache[varbit];
	            int k = varBit.configId;
	            int l = varBit.lsb;
	            int i1 = varBit.msb;
	            int j1 = Main.BIT_MASKS[i1 - l];
	            j = clientInstance.settings[k] >> l & j1;
	        } else if (varp != -1)
	            j = clientInstance.settings[varp];
	        if (j < 0 || j >= morphisms.length || morphisms[j] == -1)
	            return null;
	        else
	            return lookup(morphisms[j]);
	    }

	   public static final void method162(StreamLoader class44) {
	      dataBuf = new Buffer(class44.readFile("npc.dat"));
	      Buffer idxBuf = new Buffer(class44.readFile("npc.idx"));

	      totalNpcs = idxBuf.readUShort();

	      offsets = new int[totalNpcs + 10000];

	      int offset = 2;

	        for (int count = 0; count < totalNpcs; count++) {
	            offsets[count] = offset;
	            offset += idxBuf.readUShort();
	        }
	        
	      cache = new NpcDefinition[20];

	      for(int k = 0; k < 20; ++k) {
	         cache[k] = new NpcDefinition();
	      }
	     // dumpNpc();

	   }

	   public static void dumpNpcList() {
	      for(int i = 0; i < anInt62; ++i) {
	         NpcDefinition class5 = lookup(i);
	         BufferedWriter bw = null;

	         try {
	            bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/167Npclist.txt", true));
	            if(class5.name != null) {
	               bw.write("ID: " + i + "\t\tName: " + class5.name);
	               bw.newLine();
	               bw.flush();
	               bw.close();
	            }
	         } catch (IOException var4) {
			 }
	      }

	   }

	   public static void dumpNpc() {
	      for(int i = 0; i < totalNpcs; ++i) {
	         NpcDefinition NpcDefinition = lookup(i);
	         BufferedWriter bw = null;

	         try {
	            bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/Npcdump177.txt", true));
	            if(NpcDefinition.name != null) {
	               bw.newLine();
	               bw.write("if(i == " + i + ") {");
	               bw.newLine();
	             	 bw.write("npcdef.actions = new String[] {"+Arrays.toString(NpcDefinition.actions)+"};");
	               	 bw.newLine();
	               bw.write("npcdef.name = \"" + NpcDefinition.name + "\";");
	               bw.newLine();
	               bw.write("npcdef.combatLevel = " + NpcDefinition.combatLevel + ";");
	               bw.newLine();
	               bw.write("npcdef.standingAnimation = " + NpcDefinition.standingAnimation + ";");
	               bw.newLine();
	               bw.write("npcdef.walkingAnimation = " + NpcDefinition.walkingAnimation + ";");
	               bw.newLine();
	               bw.write("npcdef.halfTurnAnimation = " + NpcDefinition.halfTurnAnimation + ";");
	               bw.newLine();
	               bw.write("npcdef.quarterAnticlockwiseTurnAnimation = " + NpcDefinition.quarterAnticlockwiseTurnAnimation + ";");
	               bw.newLine();
	               bw.write("npcdef.quarterClockwiseTurnAnimation = " + NpcDefinition.quarterClockwiseTurnAnimation + ";");
	               bw.newLine();
		             	 bw.write("npcdef.npcModels = new int[] {"+Arrays.toString(NpcDefinition.npcModels)+"};");
		               	 bw.newLine();
		               	if(NpcDefinition.additionalModels != null){
		             	 bw.write("npcdef.additionalModels = new int[] {"+Arrays.toString(NpcDefinition.additionalModels)+"};");
		               	 bw.newLine();
		               	}
		               	 if(NpcDefinition.originalModelColors != null){
		             	 bw.write("npcdef.originalModelColors = new Short[] {"+Arrays.toString(NpcDefinition.originalModelColors)+"};");
		               	 bw.newLine();
		               	 }
		               	 if(NpcDefinition.changedModelColors != null){
		             	 bw.write("npcdef.changedModelColors = new Short[] {"+Arrays.toString(NpcDefinition.changedModelColors)+"};");
		               	 bw.newLine();
		               	 }
							bw.write("npcdef.npcSize = " + NpcDefinition.npcSize + ";");
							bw.newLine();
							bw.write("npcdef.npcHeight = " + NpcDefinition.npcHeight + ";");
							bw.newLine();
							bw.write("npcdef.lightModifier = " + NpcDefinition.lightModifier + ";");
							bw.newLine();
							bw.write("npcdef.shadowModifier = " + NpcDefinition.shadowModifier + ";");
							bw.newLine();
							bw.write("npcdef.headIcon = " + NpcDefinition.headIcon + ";");
			               bw.newLine();
						   bw.write("npcdef.rotation = " + NpcDefinition.rotation + ";");
			               bw.newLine();
						   bw.write("npcdef.aBoolean93 = " + NpcDefinition.aBoolean93 + ";");
			               bw.newLine();
						    bw.write("npcdef.lightModifier = " + NpcDefinition.lightModifier + ";");
			               bw.newLine();
						   bw.write("npcdef.shadowModifier = " + NpcDefinition.shadowModifier + ";");
			               bw.newLine();
						bw.write("npcdef.spaceOccupied = " + NpcDefinition.spaceOccupied + ";");
			               bw.newLine();
					

	               bw.write("}");
	               bw.newLine();
	               bw.flush();
	               bw.close();
	            }
	         } catch (IOException var4) {
			 }
	      }

	   }

	   public static void dumpNpccfg() {
	      for(int i = 0; i < 9200; ++i) {
	         NpcDefinition class5 = lookup(i);
	         BufferedWriter bw = null;

	         try {
	            bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/npc.txt", true));
	            if(class5.name != null) {
	               bw.write("Id : " + i + " Name: " + class5.name + "\t" + class5.combatLevel + "\t0");
	               bw.newLine();
	               bw.flush();
	               bw.close();
	            }
	         } catch (IOException var4) {
			 }
	      }

	   }

	   public static final void method163(int i) {
	      aClass12_95 = null;
	      offsets = null;
	      if(i >= 0) {
	         anInt74 = 60;
	      }

	      cache = null;
	      dataBuf = null;
	   }

	   public final Model method164(int i, int j, int k, int[] ai) {
	      if(this.morphisms != null) {
	         NpcDefinition var10 = this.method161();
	         return var10 == null?null:var10.method164(0, j, k, ai);
	      } else {
	         Model Model = (Model)aClass12_95.insertFromCache(this.aLong78);
	         if(i != 0) {
	            for(int Model_1 = 1; Model_1 > 0; ++Model_1) {
				}
	         }

	         if(Model == null) {
	            boolean var9 = false;

	            for(int aModel = 0; aModel < this.npcModels.length; ++aModel) {
	               if(!com.Ghreborn.client.entity.model.Model.isCached(this.npcModels[aModel])) {
	                  var9 = true;
	               }
	            }

	            if(var9) {
	               return null;
	            }

	            Model[] var12 = new Model[this.npcModels.length];

	            int k1;
	            for(k1 = 0; k1 < this.npcModels.length; ++k1) {
	               var12[k1] = com.Ghreborn.client.entity.model.Model.getModel(this.npcModels[k1]);
	            }

	            if(var12.length == 1) {
	               Model = var12[0];
	            } else {
	               Model = new Model(var12.length, var12);
	            }

	            if(this.originalModelColors != null) {
	               for(k1 = 0; k1 < this.originalModelColors.length; ++k1) {
	                  Model.recolor(this.originalModelColors[k1], this.changedModelColors[k1]);
	               }
	            }

	            Model.method469((byte)-71);
	            Model.method479(64 + this.lightModifier, 850 + this.shadowModifier, -30, -50, -30, true);
	            aClass12_95.removeFromCache(Model, this.aLong78);
	         }

	         Model var11 = com.Ghreborn.client.entity.model.Model.aModel_1621;
	         var11.method464(7, Model, Frame.method532(k) & Frame.method532(j));
	         if(k != -1 && j != -1) {
	            var11.method471(-20491, ai, j, k);
	         } else if(k != -1) {
	            var11.method470(k);
	         }

	         if(this.npcSize != 128 || this.npcHeight != 128) {
	            var11.method478(this.npcSize, this.npcSize, this.anInt63, this.npcHeight);//TODO CHECK HERE
	         }

	         var11.method466();
	         var11.anIntArrayArray1658 = null;
	         var11.anIntArrayArray1657 = null;
	         if(this.spaceOccupied == 1) {
	            var11.aBoolean1659 = true;
	         }

	         return var11;
	      }
	   }

		public void readValues(Buffer stream) {
	        while(true) {
				int i = stream.readUnsignedByte();
				if (i == 0)
					return;
				if (i == 1) {
					int j = stream.readUnsignedByte();
					npcModels = new int[j];
					for (int j1 = 0; j1 < j; j1++)
						npcModels[j1] = stream.readUShort();

				} else if (i == 2)
					name = stream.readString();
				else if (i == 3)
					description = stream.readBytes();
				else if (i == 12)
					spaceOccupied = stream.readSignedByte();
				else if (i == 13)
					standingAnimation = stream.readUShort();
				else if (i == 14)
					walkingAnimation = stream.readUShort();
				else if (i == 15) 
					stream.readUShort();
				else if (i == 16) 
					stream.readUShort();
				else if (i == 17) {
					walkingAnimation = stream.readUShort();
					halfTurnAnimation = stream.readUShort();
					quarterClockwiseTurnAnimation = stream.readUShort();
					quarterAnticlockwiseTurnAnimation = stream.readUShort();
	                if (halfTurnAnimation == 65535) {
	                	halfTurnAnimation = walkingAnimation;
	                }
	                if (quarterClockwiseTurnAnimation == 65535) {
	                	quarterClockwiseTurnAnimation = walkingAnimation;
	                }
	                if (quarterAnticlockwiseTurnAnimation == 65535) {
	                	quarterAnticlockwiseTurnAnimation = walkingAnimation;
	                }
				} else if (i >= 30 && i < 35) {
					if (actions == null)
						actions = new String[5];
					actions[i - 30] = stream.readString();
					if (actions[i - 30].equalsIgnoreCase("hidden"))
						actions[i - 30] = null;
				} else if (i == 40) {
					int k = stream.readUnsignedByte();
					originalModelColors = new int[k];
					changedModelColors = new int[k];
					for (int k1 = 0; k1 < k; k1++) {
						originalModelColors[k1] = stream.readUShort();
						changedModelColors[k1] = stream.readUShort();
					}
	            } else if (i == 41) {
	                int len = stream.readUnsignedByte();

	                for (int i1 = 0; i1 < len; i1++) {
	                    stream.readUShort(); // textures
	                    stream.readUShort();
	                }
				} else if (i == 60) {
					int l = stream.readUnsignedByte();
					additionalModels = new int[l];
					for (int l1 = 0; l1 < l; l1++)
						additionalModels[l1] = stream.readUShort();

				} else if (i == 90)
					stream.readUShort();
				else if (i == 91)
					stream.readUShort();
				else if (i == 92)
					stream.readUShort();
				else if (i == 93)
					aBoolean87 = false;
				else if (i == 95)
					combatLevel = stream.readUShort();
				else if (i == 97)
					npcSize = stream.readUShort();
				else if (i == 98)
					npcHeight = stream.readUShort();
				else if (i == 99)
					aBoolean93 = true;
				else if (i == 100)
					lightModifier = stream.readSignedByte();
				else if (i == 101)
					shadowModifier = stream.readSignedByte();
				else if (i == 102)
					headIcon = stream.readUShort();
				else if (i == 103)
					rotation = stream.readUShort();
				else if (i == 106 || i == 118) {
					varbit = stream.readUShort();
					
					if (varbit == 65535){
						varbit = -1;
					}
					
					varp = stream.readUShort();
					
					if (varp == 65535){
						varp = -1;
				}
	                int value = -1;

	                if (i == 118) {
	                    value = stream.readUShort();
	                }

					int i1 = stream.readUnsignedByte();
					morphisms = new int[i1 + 2];
					for (int i2 = 0; i2 <= i1; i2++) {
						morphisms[i2] = stream.readUShort();
						if (morphisms[i2] == 65535)
							morphisms[i2] = -1;
					}
					 morphisms[i1 + 1] = value;
	            } else if (i == 109) {
	                aBoolean84 = false;
	            } else if (i == 107 || i == 111){

	            } else {
	                System.out.println(String.format("npc def invalid opcode: %d", i));
	            }
			}
	    }
		public NpcDefinition() {
			quarterAnticlockwiseTurnAnimation = -1;
			varbit = -1;
			halfTurnAnimation = -1;
			varp = -1;
			combatLevel = -1;
			anInt64 = 1834;
			walkingAnimation = -1;
			spaceOccupied = 1;
			headIcon = -1;
			standingAnimation = -1;
			aLong78 = -1L;
			rotation = 32;
			quarterClockwiseTurnAnimation = -1;
			aBoolean84 = true;
			npcHeight = 128;
			aBoolean87 = true;
			npcSize = 128;
			aBoolean93 = false;
		}
		   public int quarterAnticlockwiseTurnAnimation;
		   private static int anInt56;
		   public int varbit;
		   public int halfTurnAnimation;
		   public int varp;
		   private static Buffer dataBuf;
		   public int combatLevel;
		   public static int anInt62;
		   private int anInt63;
		   private int anInt64;
		   public String name;
		   public String[] actions;
		   public int walkingAnimation;
		   public byte spaceOccupied;
		   private int anInt69;
		   private int[] changedModelColors;
		   public int anInt71;
		   private static int[] offsets;
		   private int[] additionalModels;
		   private static int anInt74;
		   public int headIcon;
		   private int[] originalModelColors;
		   public int standingAnimation;
		   public long aLong78;
		   public int rotation;
		   private static NpcDefinition[] cache;
		   private boolean aBoolean81 = false;
		   public static Main clientInstance;
		   public int quarterClockwiseTurnAnimation;
		   public boolean aBoolean84 = true;
		   private int lightModifier;
		   private int npcHeight;
		   public boolean aBoolean87 = true;
		   public int[] morphisms;
		   public byte[] description;
		   public int anInt90;
		   private int npcSize;
		   private int shadowModifier;
		   public boolean aBoolean93 = false;
		   private int[] npcModels;
		   public static MRUNodes aClass12_95 = new MRUNodes(30);
		   public int anInt96 = -1;

	}
