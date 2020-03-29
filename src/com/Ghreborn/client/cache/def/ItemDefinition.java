package com.Ghreborn.client.cache.def;

import com.Ghreborn.client.Main;
import com.Ghreborn.client.Constants;
import com.Ghreborn.client.FileOperations;
import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.cache.def.items.*;
import com.Ghreborn.client.cache.graphics.Sprite;
import com.Ghreborn.client.draw.DrawingArea;
import com.Ghreborn.client.draw.Rasterizer;
import com.Ghreborn.client.draw.Texture;
import com.Ghreborn.client.entity.model.Model;
import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.link.MRUNodes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;


public final class ItemDefinition {
   private boolean stockmarket;
   private int[] retextureDst;
	private static BufferedWriter writer;
   private int[] retextureSrc;
   public static MRUNodes aClass12_158 = new MRUNodes(100);
   public static MRUNodes aClass12_159 = new MRUNodes(50);
   public static boolean aBoolean182 = true;
   public int id = -1;
   private int anInt171 = 9;
   private int anInt177 = 9;
   private boolean aBoolean186 = false;
   private boolean aBoolean206 = false;
   private static int[] offsets;
   private static ItemDefinition[] cache;
   public boolean searchableItem;
   private int shiftClickIndex = -2;
   private static Buffer astream_183;
   private static boolean aBoolean187;
   public static int totalItems;
   //@Export("textureToReplace")
   public short[] textureToReplace;
  // @ObfuscatedName("v")
  // @Export("textToReplaceWith")
   public short[] textToReplaceWith;
   public int modelId;
   public String name;
   public String description;
   public int[] modifiedModelColors;
   public int[] originalModelColors;
   public int spriteScale;
   public int spritePitch;
   public int spriteCameraRoll;
   public int spriteCameraYaw;
   public int spriteTranslateX;
   public int spriteTranslateY;
   public int unnotedId = -1;
   public int notedId = -1;
   public boolean stackable;
   public int value;
   public boolean membersObject;
   public String[] groundActions;
    public String[] equipActions;
   public String[] itemActions;
   public int primaryMaleModel;
   public int secondaryMaleModel;
   private byte maleTranslation;
   public int primaryFemaleModel;
   public int secondaryFemaleModel;
   private byte femaleTranslation;
   public int tertiaryMaleEquipmentModel;
   public int tertiaryFemaleEquipmentModel;
   public int primaryMaleHeadPiece;
   public int secondaryMaleHeadPiece;
   public int primaryFemaleHeadPiece;
   public int secondaryFemaleHeadPiece;
   public int[] stackIds;
   public int[] stackAmounts;
   public int certID;
   public int certTemplateID;
   private int groundScaleX;
   private int groundScaleY;
   private int groundScaleZ;
   private int ambience;
   private int diffusion;
   public int team;
   private static int anInt180;
	public int placeholderId;
	public int placeholderTemplateId;

   public static final void nullLoader() {
      aClass12_159 = null;
      aClass12_158 = null;
      offsets = null;
      cache = null;
      astream_183 = null;
   }
	public static void dumpBonus() {
		final int[] wikiBonuses = new int[18];
		int bonus = 0;
		int amount = 0;
		System.out.println("Starting to dump item bonuses...");
		for (int i = 20000; i < totalItems; i++) {
			ItemDefinition item = ItemDefinition.lookup(i);
			try {
				try {
					try {
						final URL url = new URL(
								"https://oldschoolrunescape.fandom.com/wiki/" + item.name.replaceAll(" ", "_"));
						URLConnection con = url.openConnection();
						BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
						String line;
						writer = new BufferedWriter(new FileWriter("item.cfg", true));
						while ((line = in.readLine()) != null) {
							try {
								if (line.contains("<td style=\"text-align: center; width: 35px;\">")) {
									line = line.replace("</td>", "").replace("%", "").replace("?", "")
											.replace("\"\"", "")
											.replace("<td style=\"text-align: center; width: 35px;\">", "");
									wikiBonuses[bonus] = Integer.parseInt(line);
									bonus++;
								} else if (line.contains("<td style=\"text-align: center; width: 30px;\">")) {
									line = line.replace("</td>", "").replace("%", "").replace("?", "").replace("%", "")
											.replace("<td style=\"text-align: center; width: 30px;\">", "");
									wikiBonuses[bonus] = Integer.parseInt(line);
									bonus++;
								}
							} catch (NumberFormatException e) {
								e.printStackTrace();
							}
							in.close();
							writer.write("item = " + i + "	" + item.name.replace(" ", "_") + "	"
									+ item.description.replace(" ", "_") + "	" + item.value + "	" + item.value
									+ "	" + item.value + "	" + wikiBonuses[0] + "	" + wikiBonuses[1] + "	"
									+ wikiBonuses[2] + "	" + wikiBonuses[3] + "	" + wikiBonuses[4] + "	"
									+ wikiBonuses[5] + "	" + wikiBonuses[6] + "	" + wikiBonuses[7] + "	"
									+ wikiBonuses[8] + "	" + wikiBonuses[9] + "	" + wikiBonuses[10] + "	"
									+ wikiBonuses[13]);
							amount++;
							wikiBonuses[0] = wikiBonuses[1] = wikiBonuses[2] = wikiBonuses[3] = wikiBonuses[4] = wikiBonuses[5] = wikiBonuses[6] = wikiBonuses[7] = wikiBonuses[8] = wikiBonuses[9] = wikiBonuses[10] = wikiBonuses[11] = wikiBonuses[13] = 0;
							writer.newLine();
							writer.close();
						}
					} catch (NullPointerException e) {
						e.printStackTrace();
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Done dumping " + amount + " item bonuses!");
		}
	}
   public static void dumpCfg() {
      boolean delete = (new File(SignLink.findcachedir() + "/dumps/item_config.cfg")).delete();

      for(int i = 0; i < totalItems; ++i) {
         ItemDefinition class8 = lookup(i);
         Object bw = null;
         String des = "";
         if(class8.description != null) {
            des = class8.description;
         } else {
            des = "Its a " + class8.name;
         }

         try {
            BufferedWriter bufferedwriter = null;
            bufferedwriter = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/item_config.cfg", true));
            //bufferedwriter.write("item = " + i + "\t" + class8.name + "\t" + des + "\t" + class8.value + "\t" + class8.value + "\t" + class8.value + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0" + "\t" + "0");
			  bufferedwriter.write("item = " + i + "\t" + class8.name.replace(" ", "_") + "\t" + des.replace(" ", "_") + "\t" + class8.value + "\t" + class8.value + "\t" + class8.value);
			 
            bufferedwriter.newLine();
            bufferedwriter.flush();
         } catch (Exception var6) {
         }
      }

   }
   public static void dumpItemsList() {
      for(int i = 0; i < 30000; ++i) {
         ItemDefinition class8 = lookup(i);
         BufferedWriter bw = null;

         try {
            bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/181ItemList.txt", true));
            if(class8.name != null) {
               bw.write("ID: " + i + "\t\tName: " + class8.name);
               bw.newLine();
               bw.flush();
               bw.close();
            }
         } catch (IOException var4) {
         }
      }

   }
   
   public static void dumpItemsListtest() {
	      for(int i = 0; i < 25000; ++i) {
	         ItemDefinition class8 = lookup(i);
	         BufferedWriter bw = null;

	         try {
	            bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/ItemListtest.txt", true));
	            if(class8.name != null) {
	               bw.write("" + i + ", ");
	               bw.flush();
	               bw.close();
	            }
	         } catch (IOException var4) {
             }
	      }

	   }

   public static void dumpNewItems() {
      for(int i = 0; i < 30000; ++i) {
         ItemDefinition class8 = lookup(i);
         BufferedWriter bw = null;

         try {
            bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/Item Dump.txt", true));
            if(class8.name != null) {
               bw.write("<item members=\'true\'  name=\'" + class8.name + "\'  type=\'" + i + "\'> </item>");
               bw.newLine();
               bw.flush();
               bw.close();
            }
         } catch (IOException var4) {
         }
      }

   }

   public final boolean method192(int j) {
      int k = this.primaryMaleHeadPiece;
      int l = this.secondaryMaleHeadPiece;
      if(j == 1) {
         k = this.primaryFemaleHeadPiece;
         l = this.secondaryFemaleHeadPiece;
      }

      if(k == -1) 
         return true;
         boolean flag = true;
         if(!Model.isCached(k)) 
            flag = false;
         if(l != -1 && !Model.isCached(l)) 
            flag = false;
         return flag;
      }
   private int currentcolors;
   //Start item dump
   public static void dumpItems2() {
   for(int i = 0; i < totalItems; i++) {
   ItemDefinition class8 = lookup(i);
         BufferedWriter bw = null;

         try {
   	 class8.currentcolors = 0;
            bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/itemdump181.txt", true));

   	 bw.newLine();
   	 bw.write("	if(i == "+i+") //ID");
   	 bw.newLine();
   	 bw.write("		{");
   	 bw.newLine();
   	 bw.write("			class8.itemActions = new String[] {"+Arrays.toString(class8.itemActions)+"};");
   	 bw.newLine();
   	 bw.write("			class8.groundActions = new String[] {"+Arrays.toString(class8.groundActions)+"};");
   	 bw.newLine();
   	 bw.write("			class8.name = \""+class8.name+"\"; //Name");
   	 bw.newLine();
   	 bw.write("			class8.description = \"Its an "+class8.name+"\"; //Description");
   	 bw.newLine();
                    if(class8.modifiedModelColors != null) {
                        for(int i2 = 0; i2 < class8.modifiedModelColors.length; i2++) {
                            if(i2 == 0) {
                            }
                            if(i2 != class8.modifiedModelColors.length - 1) {                 
   		             class8.currentcolors += 1;
                            } else {   
   		             class8.currentcolors += 1;                         									if(class8.currentcolors != 0)
   	{
                    bw.write("			class8.modifiedModelColors = new int["+class8.currentcolors+"];");
                    bw.newLine();
                    bw.write("			class8.originalModelColors = new int["+class8.currentcolors+"];");
                    bw.newLine();
   	}				
   		             class8.currentcolors = 0;
                            }
                        }
                    }
                    if(class8.modifiedModelColors != null) {
                        for(int i2 = 0; i2 < class8.modifiedModelColors.length; i2++) {
                            if(i2 == 0) {
                            }
                            if(i2 != class8.modifiedModelColors.length - 1) {                             	bw.write("			class8.modifiedModelColors["+class8.currentcolors+"] = " +class8.modifiedModelColors[i2]+";");
   		             class8.currentcolors += 1;
                                bw.newLine();
                            } else {                            						bw.write("			class8.modifiedModelColors["+class8.currentcolors+"] = " +class8.modifiedModelColors[i2]+";");
   		             class8.currentcolors = 0;
                                bw.newLine();
                            }
                        }
                    }
                    if(class8.originalModelColors != null) {
                        for(int i2 = 0; i2 < class8.originalModelColors.length; i2++) {
                            if(i2 == 0) {
                            }
                            if(i2 != class8.originalModelColors.length - 1) {                             	bw.write("			class8.originalModelColors["+class8.currentcolors+"] = " +class8.originalModelColors[i2]+";");
   		             class8.currentcolors += 1;
                                bw.newLine();
                            } else {                            						bw.write("			class8.originalModelColors["+class8.currentcolors+"] = " +class8.originalModelColors[i2]+";");
   		             class8.currentcolors = 0;
                                bw.newLine();
                            }
                        }
                        if(class8.stackAmounts != null) {
                            for(int i2 = 0; i2 < class8.stackAmounts.length; i2++) {
                                if(i2 == 0) {
                                }
                                if(i2 != class8.stackAmounts.length - 1) {                 
       		             class8.currentcolors += 1;
                                } else {   
       		             class8.currentcolors += 1;                         									if(class8.currentcolors != 0)
       	{
                        bw.write("			class8.stackAmounts = new int["+class8.currentcolors+"];");
                        bw.newLine();
                        bw.write("			class8.stackIds = new int["+class8.currentcolors+"];");
                        bw.newLine();
       	}				
       		             class8.currentcolors = 0;
                                }
                            }
                        }
                        if(class8.stackAmounts != null) {
                            for(int i2 = 0; i2 < class8.stackAmounts.length; i2++) {
                                if(i2 == 0) {
                                }
                                if(i2 != class8.stackAmounts.length - 1) {                             	bw.write("			class8.stackAmounts["+class8.currentcolors+"] = " +class8.stackAmounts[i2]+";");
       		             class8.currentcolors += 1;
                                    bw.newLine();
                                } else {                            						bw.write("			class8.stackAmounts["+class8.currentcolors+"] = " +class8.stackAmounts[i2]+";");
       		             class8.currentcolors = 0;
                                    bw.newLine();
                                }
                            }
                        }
                        if(class8.stackIds != null) {
                            for(int i2 = 0; i2 < class8.stackIds.length; i2++) {
                                if(i2 == 0) {
                                }
                                if(i2 != class8.stackIds.length - 1) {                             	bw.write("			class8.stackIds["+class8.currentcolors+"] = " +class8.stackIds[i2]+";");
       		             class8.currentcolors += 1;
                                    bw.newLine();
                                } else {                            						bw.write("			class8.stackIds["+class8.currentcolors+"] = " +class8.stackIds[i2]+";");
       		             class8.currentcolors = 0;
                                    bw.newLine();
                                }
                            }
                        }
                    }
                    bw.write("			class8.modelId = "+class8.modelId+";");
                    bw.newLine();
                    bw.write("			class8.spriteScale = "+class8.spriteScale+";");
                    bw.newLine();
                    bw.write("			class8.spritePitch = "+class8.spritePitch+";");
                    bw.newLine();
                    bw.write("			class8.spriteCameraRoll = "+class8.spriteCameraRoll+";");
                    bw.newLine();
                    bw.write("			class8.spriteCameraYaw = "+class8.spriteCameraYaw+";");
                    bw.newLine();
                    bw.write("			class8.spriteTranslateX = "+class8.spriteTranslateX+";");
                    bw.newLine();
                    bw.write("			class8.spriteTranslateY = "+class8.spriteTranslateY+";");
                    bw.newLine();
                    bw.write("			class8.primaryMaleModel = "+class8.primaryMaleModel+";");
                    bw.newLine();
                    bw.write("			class8.primaryFemaleModel = "+class8.primaryFemaleModel+";");
                    bw.newLine();
                    bw.write("			class8.secondaryMaleModel = "+class8.secondaryMaleModel+";");
                    bw.newLine();
                    bw.write("			class8.secondaryFemaleModel = "+class8.secondaryFemaleModel+";");
                    bw.newLine();
                    bw.write("			class8.primaryMaleHeadPiece = "+class8.primaryMaleHeadPiece+";");
                    bw.newLine();
                    bw.write("			class8.primaryFemaleHeadPiece = "+class8.primaryFemaleHeadPiece+";");
                    bw.newLine();
                    bw.write("			class8.value = "+class8.value+";");
                    bw.newLine();
                    bw.write("			class8.unnotedId = " + class8.unnotedId + ";");
                    bw.newLine();
        			 bw.write("			class8.notedId = " + class8.notedId + ";");
                    bw.newLine();
        			bw.write("			class8.placeholderId = " + class8.placeholderId + ";");
                    bw.newLine();
        			bw.write("			class8.placeholderTemplateId = " + class8.placeholderTemplateId + ";");
                    bw.newLine();
                    bw.write("		}");
                    bw.newLine();
                    bw.newLine();
   	 bw.flush();
         } catch (IOException ioe) {
   	 ioe.printStackTrace();
         } finally {
   	 if (bw != null) try {
   	    bw.close();
   	 } catch (IOException ioe2) {
   	 }
         }
   }
   }
   public static void dumpItems() {
      for(int i = 0; i < totalItems; ++i) {
         ItemDefinition class8 = lookup(i);
         BufferedWriter bw = null;

         try {
            bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/itemdump.cfg", true));
            bw.write("====================");
            bw.newLine();
            bw.write("Item Name: " + class8.name);
            bw.newLine();
            bw.write("Item ID: " + i);
            bw.newLine();
            int var121;
            if(class8.modifiedModelColors != null) {
               for(var121 = 0; var121 < class8.modifiedModelColors.length; ++var121) {
                  if(var121 == 0) {
                     bw.write("Original model colors: ");
                  }

                  if(var121 != class8.modifiedModelColors.length - 1) {
                     bw.write(class8.modifiedModelColors[var121] + ", ");
                  } else {
                     bw.write("" + class8.modifiedModelColors[var121]);
                     bw.newLine();
                  }
               }
            }

            if(class8.originalModelColors != null) {
               for(var121 = 0; var121 < class8.originalModelColors.length; ++var121) {
                  if(var121 == 0) {
                     bw.write("Changed model colors: ");
                  }

                  if(var121 != class8.originalModelColors.length - 1) {
                     bw.write(class8.originalModelColors[var121] + ", ");
                  } else {
                     bw.write("" + class8.originalModelColors[var121]);
                     bw.newLine();
                  }
               }
            }

            bw.write("class8.modelId = " + class8.modelId + ";");
            bw.newLine();
            bw.write("class8.spriteScale = " + class8.spriteScale + ";");
            bw.newLine();
            bw.write("class8.spritePitch = " + class8.spritePitch + ";");
            bw.newLine();
            bw.write("class8.spriteCameraRoll = " + class8.spriteCameraRoll + ";");
            bw.newLine();
            bw.write("class8.spriteCameraYaw = " + class8.spriteCameraYaw + ";");
            bw.newLine();
            bw.write("class8.spriteTranslateX = " + class8.spriteTranslateX + ";");
            bw.newLine();
            bw.write("class8.spriteTranslateY = " + class8.spriteTranslateY + ";");
            bw.newLine();
            bw.write("class8.primaryMaleModel = " + class8.primaryMaleModel + ";");
            bw.newLine();
            bw.write("class8.primaryFemaleModel = " + class8.primaryFemaleModel + ";");
            bw.newLine();
            bw.write("class8.secondaryMaleModel = " + class8.secondaryMaleModel + ";");
            bw.newLine();
            bw.write("class8.secondaryFemaleModel = " + class8.secondaryFemaleModel + ";");
            bw.newLine();
            bw.write("class8.primaryMaleHeadPiece = " + class8.primaryMaleHeadPiece + ";");
            bw.newLine();
            bw.write("class8.primaryFemaleHeadPiece = " + class8.primaryFemaleHeadPiece + ";");
            bw.newLine();
            bw.write("class8.unnotedId = " + class8.unnotedId + ";");
            bw.newLine();
			 bw.write("class8.notedId = " + class8.notedId + ";");
            bw.newLine();
			bw.write("class8.placeholderId = " + class8.placeholderId + ";");
            bw.newLine();
			bw.write("class8.placeholderTemplateId = " + class8.placeholderTemplateId + ";");
            bw.newLine();
            bw.flush();
         } catch (IOException var12) {
            var12.printStackTrace();
         } finally {
            if(bw != null) {
               try {
                  bw.close();
               } catch (IOException var11) {
               }
            }

         }
      }

   }
	public static void dumpStackableList() {
		try {
			File file = new File(SignLink.findcachedir() + "/dumps/stackables.dat");
			
			if (!file.exists()) {
				file.createNewFile();
			}
			
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalItems; i++) {
					ItemDefinition definition = lookup(i);
					if (definition != null) {
						writer.write(definition.id + "\t" + definition.stackable);
						writer.newLine();
					} else {
						writer.write(i + "\tfalse");
						writer.newLine();
					}
				}
			}
			
			System.out.println("Finished dumping noted items definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int[] unNoteable = {995};
	
	public static void dumpNotes() {
		try {
			FileOutputStream out = new FileOutputStream(new File(SignLink.findcachedir() + "/dumps/notes.dat"));
			for (int j = 0; j < totalItems; j++) {
				ItemDefinition item = ItemDefinition.lookup(j);
				for (int i = 0; i < totalItems; i++)
						out.write(item.certTemplateID != -1 ? 0 : 1);
			}
			out.write(-1);
			out.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		}
	
    public static void dumpStackable() {
		try {
			FileOutputStream out = new FileOutputStream(new File(SignLink.findcachedir() + "/dumps/stackable.dat"));
			for (int j = 0; j < totalItems; j++) {
				ItemDefinition item = ItemDefinition.lookup(j);
				out.write(item.stackable ? 1 : 0);
			}
			out.write(-1);
			out.close();
		} catch (IOException ioe) {ioe.printStackTrace();}	
	}
	
	public static void dumpNotableList() {
		try {
			File file = new File(SignLink.findcachedir() + "/dumps/note_ids.dat");
			
			if (!file.exists()) {
				file.createNewFile();
			}

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
				for (int i = 0; i < totalItems; i++) {
					ItemDefinition definition = ItemDefinition.lookup(i);
					if (definition != null) {
						if (definition.certTemplateID == -1 && definition.certID != -1) {
							writer.write(definition.id + "\t" + definition.certID);
							writer.newLine();
						}
					} else {
						writer.write(i + "\t-1");
						writer.newLine();
					}
				}
			}
			
			System.out.println("Finished dumping noted items definitions.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
   public static final void init(StreamLoader class44) throws IOException{
      astream_183 = new Buffer(class44.readFile("obj.dat"));
      Buffer stream = new Buffer(class44.readFile("obj.idx"));
      totalItems = stream.readUShort();
      offsets = new int[totalItems + 90000];
      int offset = 2;
      for(int k = 0; k < totalItems; ++k) {
         offsets[k] = offset;
         offset += stream.readUShort();
      }

      cache = new ItemDefinition[10];

      for(int k = 0; k < 10; ++k) {
         cache[k] = new ItemDefinition();
      }
      //dumpBonus();
     // dumpItemsList();
      //dumpItems2();
      //dumpNotableList();
     // dumpStackableList();
     // dumpStackable();
     // dumpNotes();
     // dumpCfg();
   }

   public static void applyTexturing(Model model, int id) {
	      switch(id) {
	      case 23909:
	         model.setTexture(115, 40);
	         break;
	    	  
	      }

	   }
   public final Model method194(int j) {
      int k = this.primaryMaleHeadPiece;
      int l = this.secondaryMaleHeadPiece;
      if(j == 1) {
         k = this.primaryFemaleHeadPiece;
         l = this.secondaryFemaleHeadPiece;
      }

      if(k == -1) 
         return null;
         Model model = Model.getModel(k);
         if(l != -1) {
            Model var81 = Model.getModel(l);
            Model[] aModel = new Model[]{model, var81};
            model = new Model(2, aModel);
         }

         if(this.modifiedModelColors != null) {
            for(int var8 = 0; var8 < this.modifiedModelColors.length; ++var8) 
       
            	model.recolor(this.modifiedModelColors[var8], this.originalModelColors[var8]);
            
         }
			if (textureToReplace != null)
			{
				for (int int_3 = 0; int_3 < textureToReplace.length; int_3++)
				{
					model.retexture(textureToReplace[int_3], textToReplaceWith[int_3]);
				}
			}

         return model;      
   }

   public final boolean method195(int j) {
      int k = this.primaryMaleModel;
      int l = this.secondaryMaleModel;
      int i1 = this.tertiaryMaleEquipmentModel;
      if(j == 1) {
         k = this.primaryFemaleModel;
         l = this.secondaryFemaleModel;
         i1 = this.tertiaryFemaleEquipmentModel;
      }
      if(k == -1) 
         return true;
         boolean flag = true;
         if(!Model.isCached(k)) 
            flag = false;
         if(l != -1 && !Model.isCached(l)) 
            flag = false;    
         if(i1 != -1 && !Model.isCached(i1)) 
            flag = false;      
         return flag; 
   }

   public Model method196(int i) {
       int j = primaryMaleModel;
       int k = secondaryMaleModel;
       int l = tertiaryMaleEquipmentModel;
       if (i == 1) {
           j = primaryFemaleModel;
           k = secondaryFemaleModel;
           l = tertiaryFemaleEquipmentModel;
       }
       if (j == -1)
           return null;
       Model model = Model.getModel(j);
       if (k != -1)
           if (l != -1) {
               Model model_1 = Model.getModel(k);
               Model model_3 = Model.getModel(l);
               Model[] aclass30_sub2_sub4_sub6_1s = {model, model_1, model_3};
               model = new Model(3, aclass30_sub2_sub4_sub6_1s);
           } else {
               Model model_2 = Model.getModel(k);
               Model[] aclass30_sub2_sub4_sub6s = {model, model_2};
               model = new Model(2, aclass30_sub2_sub4_sub6s);
           }
       if (i == 0 && maleTranslation != 0)
           model.method475(0, maleTranslation, 0);
       if (i == 1 && femaleTranslation != 0)
           model.method475(0, femaleTranslation, 0);
       if (modifiedModelColors != null) {
           for (int i1 = 0; i1 < modifiedModelColors.length; i1++)
               model.recolor(modifiedModelColors[i1], originalModelColors[i1]);

       }
		if (textureToReplace != null)
		{
			for (int int_3 = 0; int_3 < textureToReplace.length; int_3++)
			{
				model.retexture(textureToReplace[int_3], textToReplaceWith[int_3]);
			}
		}
       return model;
   }

   public final void setDefaults() {
      this.modelId = 0;
      this.name = "null";
      this.description = null;
      this.modifiedModelColors = null;
      this.originalModelColors = null;
      this.textToReplaceWith = null;
      this.textureToReplace = null;
      this.spriteScale = 2000;
      this.spritePitch = 0;
      this.spriteCameraRoll = 0;
      this.spriteCameraYaw = 0;
      this.spriteTranslateX = 0;
      this.spriteTranslateY = 0;
      this.stackable = false;
      this.value = 1;
      this.membersObject = false;
      equipActions = new String[] { "Remove", null, "Operate", null, null };
      this.groundActions = new String[]{null, null, "Take", null, null};
       this.itemActions = new String[]{null, null, null, null, "Drop"};
      this.primaryMaleModel = -1;
      this.secondaryMaleModel = -1;
      this.maleTranslation = 0;
      this.primaryFemaleModel = -1;
      this.secondaryFemaleModel = -1;
      this.femaleTranslation = 0;
      this.tertiaryMaleEquipmentModel = -1;
      this.tertiaryFemaleEquipmentModel = -1;
      this.primaryMaleHeadPiece = -1;
      this.secondaryMaleHeadPiece = -1;
      this.primaryFemaleHeadPiece = -1;
      this.secondaryFemaleHeadPiece = -1;
      this.stackIds = null;
      this.stackAmounts = null;
      this.certID = -1;
      this.certTemplateID = -1;
		unnotedId = -1;
		notedId = -1;
      this.groundScaleX = 128;
      this.groundScaleY = 128;
      this.groundScaleZ = 128;
      this.ambience = 0;
      this.diffusion = 0;
      this.team = 0;
		placeholderId = -1;
		placeholderTemplateId = -1;
		searchableItem = false;
   }

   public static ItemDefinition lookup(int i) {
      for(int class8 = 0; class8 < 10; ++class8) {
         if(cache[class8].id == i) {
            return cache[class8];
         }
      }
		if (i == -1)
			i = 0;
		if (i > offsets.length)
			i = 0;

      anInt180 = (anInt180 + 1) % 10;
     final ItemDefinition itemDef = cache[anInt180];
      astream_183.currentOffset = offsets[i];
      itemDef.id = i;
      itemDef.setDefaults();
      itemDef.decode(astream_183);
      
		if (itemDef.certTemplateID != -1)
		{
			itemDef.updateNote(lookup(itemDef.certTemplateID), lookup(itemDef.certID));
		}

		if (itemDef.notedId != -1)
		{
			itemDef.method5110(lookup(itemDef.notedId),
			        lookup(itemDef.unnotedId));
		}

		if (itemDef.placeholderTemplateId != -1)
		{
			itemDef.method5091(lookup(itemDef.placeholderTemplateId),lookup(itemDef.placeholderId));
		}
       ItemDefinition_Sub1.itemDef(i, itemDef);
      ItemDefinition_Sub2.itemDef(i, itemDef);
       ItemDefinition_Sub3.itemDef(i, itemDef);
       ItemDefinition_Sub4.itemDef(i, itemDef);
    	 switch(i) {
     case 2552:
		case 2554:
		case 2556:
		case 2558:
		case 2560:
		case 2562:
		case 2564:
		case 2566: //Ring of duelling
			itemDef.equipActions[3] = "Duel Arena";
			itemDef.equipActions[2] = "Castle Wars";
			itemDef.equipActions[1] = "Clan wars";
			break;
		case 1712:
		case 1710:
		case 1708:
		case 1706:
			itemDef.equipActions[1] = "Edgeville";
			itemDef.equipActions[2] = "Karamja";
			itemDef.equipActions[3] = "Draynor";
			itemDef.equipActions[4] = "Al-Kharid";
			break;
		case 13660:
			itemDef.equipActions[1] = "Check Charges";
			itemDef.equipActions[2] = "Teleport";
		break;
		case 19476:
			itemDef.equipActions[1] = "Teleport";
			itemDef.equipActions[2] = "Trim";
		break;
     }
      return itemDef;
   }
	void method5110(final ItemDefinition itemcomposition_1, final ItemDefinition itemcomposition_2)
	{
		modelId = itemcomposition_1.modelId;
		spriteScale = itemcomposition_1.spriteScale;
		spritePitch = itemcomposition_1.spritePitch;
		spriteCameraRoll = itemcomposition_1.spriteCameraRoll;
		spriteCameraYaw = itemcomposition_1.spriteCameraYaw;
		spriteTranslateX = itemcomposition_1.spriteTranslateX;
		spriteTranslateY = itemcomposition_1.spriteTranslateY;
		modifiedModelColors = itemcomposition_2.modifiedModelColors;
		originalModelColors = itemcomposition_2.originalModelColors;
		//textureToReplace = itemcomposition_2.textureToReplace;
		//textToReplaceWith = itemcomposition_2.textToReplaceWith;
		name = itemcomposition_2.name;
		membersObject = itemcomposition_2.membersObject;
		value = itemcomposition_2.value;
		stackable = itemcomposition_2.stackable;
		primaryMaleModel = itemcomposition_2.primaryMaleModel;
		secondaryMaleModel = itemcomposition_2.secondaryMaleModel;
		tertiaryMaleEquipmentModel = itemcomposition_2.tertiaryMaleEquipmentModel;
		primaryFemaleModel = itemcomposition_2.primaryFemaleModel;
		secondaryFemaleModel = itemcomposition_2.secondaryFemaleModel;
		tertiaryFemaleEquipmentModel = itemcomposition_2.tertiaryFemaleEquipmentModel;
		primaryMaleHeadPiece = itemcomposition_2.primaryMaleHeadPiece;
		secondaryMaleHeadPiece = itemcomposition_2.secondaryMaleHeadPiece;
		primaryFemaleHeadPiece = itemcomposition_2.primaryFemaleHeadPiece;
		secondaryFemaleHeadPiece = itemcomposition_2.secondaryFemaleHeadPiece;
		team = itemcomposition_2.team;
		groundActions = itemcomposition_2.groundActions;
		itemActions = new String[5];
		equipActions = new String[5];
		if (itemcomposition_2.itemActions != null)
		{
			for (int int_0 = 0; int_0 < 4; int_0++)
			{
				itemActions[int_0] = itemcomposition_2.itemActions[int_0];
			}
		}

		itemActions[4] = "Discard";
		value = 0;
	}
	void updateNote(ItemDefinition itemcomposition_1, ItemDefinition itemcomposition_2)
	{
		modelId = itemcomposition_1.modelId;
		spriteScale = itemcomposition_1.spriteScale;
		spritePitch = itemcomposition_1.spritePitch;
		spriteCameraRoll = itemcomposition_1.spriteCameraRoll;
		spriteCameraYaw = itemcomposition_1.spriteCameraYaw;
		spriteTranslateX = itemcomposition_1.spriteTranslateX;
		spriteTranslateY = itemcomposition_1.spriteTranslateY;
		modifiedModelColors = itemcomposition_1.modifiedModelColors;
		originalModelColors = itemcomposition_1.originalModelColors;
		//textureToReplace = itemcomposition_1.textureToReplace;
		//textToReplaceWith = itemcomposition_1.textToReplaceWith;
		name = itemcomposition_2.name;
		membersObject = itemcomposition_2.membersObject;
		value = itemcomposition_2.value;
		description = ("Swap this note at any bank for a " + itemcomposition_2.name + ".");
		stackable = true;
	}
	void method5091(final ItemDefinition itemcomposition_1, final ItemDefinition itemcomposition_2)
	{
		modelId = itemcomposition_1.modelId;
		spriteScale = itemcomposition_1.spriteScale;
		spritePitch = itemcomposition_1.spritePitch;
		spriteCameraRoll = itemcomposition_1.spriteCameraRoll;
		spriteCameraYaw = itemcomposition_1.spriteCameraYaw;
		spriteTranslateX = itemcomposition_1.spriteTranslateX;
		spriteTranslateY = itemcomposition_1.spriteTranslateY;
		modifiedModelColors = itemcomposition_1.modifiedModelColors;
		originalModelColors = itemcomposition_1.originalModelColors;
		textureToReplace = itemcomposition_1.textureToReplace;
		textToReplaceWith = itemcomposition_1.textToReplaceWith;
		stackable = itemcomposition_1.stackable;
		name = itemcomposition_2.name;
		value = 0;
		membersObject = false;
		searchableItem = false;
	}
    public static Sprite getSmallSprite(int itemId) {
        ItemDefinition itemDef = lookup(itemId);
        Model model = itemDef.method201(1);
        if (model == null) {
            return null;
        }
        Sprite sprite1 = null;
        if (itemDef.certTemplateID != -1) {
            sprite1 = getSprite(itemDef.certID, 10, -1);
            if (sprite1 == null) {
                return null;
            }
        }
        Sprite enabledSprite = new Sprite(18, 18);
        int k1 = Rasterizer.centerX;
        int l1 = Rasterizer.centerY;
        int ai[] = Rasterizer.lineOffsets;
        int ai1[] = DrawingArea.pixels;
        int i2 = DrawingArea.width;
        int j2 = DrawingArea.height;
        int k2 = DrawingArea.leftX;
        int l2 = DrawingArea.bottomX;
        int i3 = DrawingArea.topY;
        int j3 = DrawingArea.bottomY;
        Rasterizer.aBoolean1464 = false;
        DrawingArea.method331(18, 18, enabledSprite.myPixels, new float[1024]);
        DrawingArea.method336(18, 0, 0, 0, 18);
        Rasterizer.method364();
        int k3 = (int) (itemDef.spriteScale * 1.6D);
        int l3 = Rasterizer.anIntArray1470[itemDef.spritePitch] * k3 >> 16;
        int i4 = Rasterizer.anIntArray1471[itemDef.spritePitch] * k3 >> 16;
        model.method482(itemDef.spriteCameraRoll, itemDef.spriteCameraYaw, itemDef.spritePitch, itemDef.spriteTranslateX, l3 + model.modelHeight / 2 + itemDef.spriteTranslateY, i4 + itemDef.spriteTranslateY);
        if (itemDef.certTemplateID != -1) {
            int l5 = sprite1.maxWidth;
            int j6 = sprite1.maxHeight;
            sprite1.maxWidth = 18;
            sprite1.maxHeight = 18;
            sprite1.drawSprite(0, 0);
            sprite1.maxWidth = l5;
            sprite1.maxHeight = j6;
        }
        DrawingArea.method331(j2, i2, ai1, new float[1024]);
        DrawingArea.setDrawingArea(j3, k2, l2, i3);
        Rasterizer.centerX = k1;
        Rasterizer.centerY = l1;
        Rasterizer.lineOffsets = ai;
        Rasterizer.aBoolean1464 = true;

        enabledSprite.maxWidth = 18;
        enabledSprite.maxHeight = 18;

        return enabledSprite;
    }
	public static Sprite getSprite(int i, int j, int k, int scale, int wh) {
		/*if(k == 0 && !forceDraw) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(i);
			if(sprite != null && sprite.anInt1445 != j && sprite.anInt1445 != -1) {
				sprite.unlink();
				sprite = null;
			}
			if(sprite != null)
				return sprite;
		}*/
		ItemDefinition itemDef = lookup(i);
		if(itemDef.stackIds == null)
			j = -1;
		if(j > 1) {
			int i1 = -1;
			for(int j1 = 0; j1 < 10; j1++)
				if(j >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0)
					i1 = itemDef.stackIds[j1];
			if(i1 != -1)
				itemDef = lookup(i1);
		}
		Model model = itemDef.method201(1);
		if(model == null)
			return null;
		Sprite sprite = null;
		if(itemDef.certTemplateID != -1) {
			sprite = getSprite(itemDef.certID, 10, -1, scale, wh);
			if(sprite == null)
				return null;
		}
		Sprite sprite2 = new Sprite(wh, wh);
        int k1 = Rasterizer.centerX;
        int l1 = Rasterizer.centerY;
		int ai[] = Rasterizer.lineOffsets;
		int ai1[] = DrawingArea.pixels;
		 float[] ai2 = DrawingArea.depthBuffer;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.leftX;
		int l2 = DrawingArea.bottomX;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.bottomY;
        Rasterizer.aBoolean1464 = false;
		DrawingArea.method331(wh, wh, sprite2.myPixels, new float[32*32]);
		DrawingArea.drawPixels(wh, 0, 0, 0, wh);
		DrawingArea.method336(wh, 0, 0, 0, wh);
        Rasterizer.method364();
		int k3 = itemDef.spriteScale / scale;
		if(k == -1)
			k3 = (int)((double)k3 * 1.5D);
		if(k > 0)
			k3 = (int)((double)k3 * 1.04D);
		int l3 = Rasterizer.anIntArray1470[itemDef.spritePitch] * k3 >> 16;
		int i4 = Rasterizer.anIntArray1471[itemDef.spritePitch] * k3 >> 16;
            model.method482( itemDef.spriteCameraRoll, itemDef.spriteCameraYaw, itemDef.spritePitch, itemDef.spriteTranslateX, l3 + model.modelHeight / 2 + itemDef.spriteTranslateY, i4 + itemDef.spriteTranslateY);
		for(int i5 = wh - 1; i5 >= 0; i5--) {
			for(int j4 = wh - 1; j4 >= 0; j4--)
				if(sprite2.myPixels[i5 + j4 * wh] == 0)
					if(i5 > 0 && sprite2.myPixels[(i5 - 1) + j4 * wh] > 1)
						sprite2.myPixels[i5 + j4 * wh] = 1;
					else if(j4 > 0 && sprite2.myPixels[i5 + (j4 - 1) * wh] > 1)
						sprite2.myPixels[i5 + j4 * wh] = 1;
					else if(i5 < 31 && sprite2.myPixels[i5 + 1 + j4 * wh] > 1)
						sprite2.myPixels[i5 + j4 * wh] = 1;
					else if(j4 < 31 && sprite2.myPixels[i5 + (j4 + 1) * wh] > 1)
						sprite2.myPixels[i5 + j4 * wh] = 1;
		}
		if(k > 0) {
			for(int j5 = wh - 1; j5 >= 0; j5--) {
				for(int k4 = wh - 1; k4 >= 0; k4--)
					if(sprite2.myPixels[j5 + k4 * wh] == 0)
						if(j5 > 0 && sprite2.myPixels[(j5 - 1) + k4 * wh] == 1)
							sprite2.myPixels[j5 + k4 * wh] = k;
						else if(k4 > 0 && sprite2.myPixels[j5 + (k4 - 1) * wh] == 1)
							sprite2.myPixels[j5 + k4 * wh] = k;
						else if(j5 < 31 && sprite2.myPixels[j5 + 1 + k4 * wh] == 1)
							sprite2.myPixels[j5 + k4 * wh] = k;
						else if(k4 < 31 && sprite2.myPixels[j5 + (k4 + 1) * wh] == 1)
							sprite2.myPixels[j5 + k4 * wh] = k;
			}
		} else if(k == 0) {
			for(int k5 = wh - 1; k5 >= 0; k5--) {
				for(int l4 = wh - 1; l4 >= 0; l4--)
					if(sprite2.myPixels[k5 + l4 * wh] == 0 && k5 > 0 && l4 > 0 && sprite2.myPixels[(k5 - 1) + (l4 - 1) * wh] > 0)
						sprite2.myPixels[k5 + l4 * wh] = 0x302020;
			}
		}
		if(itemDef.certTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = wh;
			sprite.maxHeight = wh;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if(k == 0)
			aClass12_158.removeFromCache(sprite2, i);
		DrawingArea.method331(j2, i2, ai1, ai2);
		DrawingArea.setDrawingArea(j3, k2, l2, i3);
        Rasterizer.centerX = k1;
        Rasterizer.centerY = l1;
        Rasterizer.lineOffsets = ai;
        Rasterizer.aBoolean1464 = true;
		if(itemDef.stackable)
			sprite2.maxWidth = wh + 1;
		else
			sprite2.maxWidth = wh;
		sprite2.maxHeight = j;
		return sprite2;
	}
    public static Sprite getSprite(int item, int amount, int k) {
        if (k == 0) {
            Sprite sprite = (Sprite) aClass12_158.insertFromCache(item);
            if (sprite != null && sprite.maxHeight != amount && sprite.maxHeight != -1) {

                sprite.unlink();
                sprite = null;
            }
            if (sprite != null)
                return sprite;
        }
        ItemDefinition itemDef = lookup(item);
        if (itemDef.stackIds == null)
            amount = -1;
        if (amount > 1) {
            int i1 = -1;
            for (int j1 = 0; j1 < 10; j1++)
                if (amount >= itemDef.stackAmounts[j1] && itemDef.stackAmounts[j1] != 0)
                    i1 = itemDef.stackIds[j1];

            if (i1 != -1)
                itemDef = lookup(i1);
        }
        Model model = itemDef.method201(1);
        if (model == null)
            return null;
        Sprite sprite = null;
        if (itemDef.certTemplateID != -1) {
            sprite = getSprite(itemDef.certID, 10, -1);
            if (sprite == null)
                return null;
        } else if (itemDef.notedId != -1) {
            sprite = getSprite(itemDef.unnotedId, amount, -1);
            if (sprite == null)
                return null;
        } else if (itemDef.placeholderTemplateId != -1) {
            sprite = getSprite(itemDef.placeholderId, amount, -1);
            if (sprite == null)
                return null;
        }
        Sprite enabledSprite = new Sprite(32, 32);
        int k1 = Rasterizer.centerX;
        int l1 = Rasterizer.centerY;
        int ai[] = Rasterizer.lineOffsets;
        int ai1[] = DrawingArea.pixels;
        float[] ai2 = DrawingArea.depthBuffer;
        int i2 = DrawingArea.width;
        int j2 = DrawingArea.height;
        int k2 = DrawingArea.leftX;
        int l2 = DrawingArea.bottomX;
        int i3 = DrawingArea.topY;
        int j3 = DrawingArea.bottomY;
        Rasterizer.aBoolean1464 = false;
        DrawingArea.method331(32, 32, enabledSprite.myPixels, new float[32*32]);
        DrawingArea.drawPixels(32, 0, 0, 0, 32);
        Rasterizer.method364();
        if (itemDef.placeholderTemplateId != -1) {
            int l5 = sprite.maxWidth;
            int j6 = sprite.maxHeight;
            sprite.maxWidth = 32;
            sprite.maxHeight = 32;
            sprite.drawSprite(0, 0);
            sprite.maxWidth = l5;
            sprite.maxHeight = j6;
        }
        int k3 = itemDef.spriteScale;
        if (k == -1)
            k3 = (int) ((double) k3 * 1.5D);
        if (k > 0)
            k3 = (int) ((double) k3 * 1.04D);
        int l3 = Rasterizer.anIntArray1470[itemDef.spritePitch] * k3 >> 16;
        int i4 = Rasterizer.anIntArray1471[itemDef.spritePitch] * k3 >> 16;
        model.method482(itemDef.spriteCameraRoll, itemDef.spriteCameraYaw, itemDef.spritePitch, itemDef.spriteTranslateX,
                l3 + model.modelHeight / 2 + itemDef.spriteTranslateY, i4 + itemDef.spriteTranslateY);
        if (itemDef.notedId != -1) {
            int l5 = sprite.maxWidth;
            int j6 = sprite.maxHeight;
            sprite.maxWidth = 32;
            sprite.maxHeight = 32;
            sprite.drawSprite(0, 0);
            sprite.maxWidth = l5;
            sprite.maxHeight = j6;
        }
        for (int i5 = 31; i5 >= 0; i5--) {
            for (int j4 = 31; j4 >= 0; j4--)
                if (enabledSprite.myPixels[i5 + j4 * 32] == 0)
                    if (i5 > 0 && enabledSprite.myPixels[(i5 - 1) + j4 * 32] > 1)
                        enabledSprite.myPixels[i5 + j4 * 32] = 1;
                    else if (j4 > 0 && enabledSprite.myPixels[i5 + (j4 - 1) * 32] > 1)
                        enabledSprite.myPixels[i5 + j4 * 32] = 1;
                    else if (i5 < 31 && enabledSprite.myPixels[i5 + 1 + j4 * 32] > 1)
                        enabledSprite.myPixels[i5 + j4 * 32] = 1;
                    else if (j4 < 31 && enabledSprite.myPixels[i5 + (j4 + 1) * 32] > 1)
                        enabledSprite.myPixels[i5 + j4 * 32] = 1;

        }

        if (k > 0) {
            for (int j5 = 31; j5 >= 0; j5--) {
                for (int k4 = 31; k4 >= 0; k4--)
                    if (enabledSprite.myPixels[j5 + k4 * 32] == 0)
                        if (j5 > 0 && enabledSprite.myPixels[(j5 - 1) + k4 * 32] == 1)
                            enabledSprite.myPixels[j5 + k4 * 32] = k;
                        else if (k4 > 0 && enabledSprite.myPixels[j5 + (k4 - 1) * 32] == 1)
                            enabledSprite.myPixels[j5 + k4 * 32] = k;
                        else if (j5 < 31 && enabledSprite.myPixels[j5 + 1 + k4 * 32] == 1)
                            enabledSprite.myPixels[j5 + k4 * 32] = k;
                        else if (k4 < 31 && enabledSprite.myPixels[j5 + (k4 + 1) * 32] == 1)
                            enabledSprite.myPixels[j5 + k4 * 32] = k;

            }

        } else if (k == 0) {
            for (int k5 = 31; k5 >= 0; k5--) {
                for (int l4 = 31; l4 >= 0; l4--)
                    if (enabledSprite.myPixels[k5 + l4 * 32] == 0 && k5 > 0 && l4 > 0 && enabledSprite.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0)
                        enabledSprite.myPixels[k5 + l4 * 32] = 0x302020;

            }

        }
        if (itemDef.certTemplateID != -1) {
            int l5 = sprite.maxWidth;
            int j6 = sprite.maxHeight;
            sprite.maxWidth = 32;
            sprite.maxHeight = 32;
            sprite.drawSprite(0, 0);
            sprite.maxWidth = l5;
            sprite.maxHeight = j6;
        }
        if (k == 0)
            aClass12_158.removeFromCache(enabledSprite, item);
        DrawingArea.method331(j2, i2, ai1, ai2);
        DrawingArea.setDrawingArea(k2, i3, l2, j3);
        Rasterizer.centerX = k1;
        Rasterizer.centerY = l1;
        Rasterizer.lineOffsets = ai;
        Rasterizer.aBoolean1464 = true;
        if (itemDef.stackable)
            enabledSprite.maxWidth = 33;
        else
            enabledSprite.maxWidth = 32;
        enabledSprite.maxHeight = amount;
        return enabledSprite;
    }


   public final Model method201(int i) {
      int l;
      if(this.stackIds != null && i > 1) {
         int var41 = -1;

         for(l = 0; l < 10; ++l) {
            if(i >= this.stackAmounts[l] && this.stackAmounts[l] != 0) {
               var41 = this.stackIds[l];
            }
         }

         if(var41 != -1) {
            return lookup(var41).method201(1);
         }
      }

      Model var4 = (Model)aClass12_159.insertFromCache((long)this.id);
      if(var4 != null) {
         return var4;
      } else {
         var4 = Model.getModel(this.modelId);
         if(var4 == null) {
            return null;
         } else {
            if(this.groundScaleX != 128 || this.groundScaleY != 128 || this.groundScaleZ != 128) {
               var4.method478(this.groundScaleX, this.groundScaleZ, this.anInt177, this.groundScaleY);
            }

            if(this.modifiedModelColors != null) {
               for(l = 0; l < this.modifiedModelColors.length; ++l) {
                  var4.recolor(this.modifiedModelColors[l], this.originalModelColors[l]);
               }
            }
            if(this.textureToReplace != null) {
                for(l = 0; l < this.textureToReplace.length; ++l) {
                   var4.retexture(this.textureToReplace[l], this.textToReplaceWith[l]);
                }
             }
            var4.method479(64 + this.ambience, 768 + this.diffusion, -500, -500, -140, true);
            var4.aBoolean1659 = true;
            aClass12_159.removeFromCache(var4, (long)this.id);
            return var4;
         }
      }
   }

   public final Model method202(int i, boolean flag) {
      int l;
      if(this.stackIds != null && i > 1) {
         int var51 = -1;

         for(l = 0; l < 10; ++l) {
            if(i >= this.stackAmounts[l] && this.stackAmounts[l] != 0) {
               var51 = this.stackIds[l];
            }
         }

         if(var51 != -1) {
            return lookup(var51).method202(1, true);
         }
      }

      Model var5 = Model.getModel(this.modelId);
      if(!flag) {
         throw new NullPointerException();
      } else if(var5 == null) {
         return null;
      } else {
         if(this.modifiedModelColors != null) {
            for(l = 0; l < this.modifiedModelColors.length; ++l) {
               var5.recolor(this.modifiedModelColors[l], this.originalModelColors[l]);
            }
         }
			if (textureToReplace != null)
			{
				for (int int_3 = 0; int_3 < textureToReplace.length; int_3++)
				{
					var5.retexture(textureToReplace[int_3], textToReplaceWith[int_3]);
				}
			}
         return var5;
      }
   }

   public final void decode(Buffer stream) {
         while(true) {
            while(true) {
               int i = stream.readUnsignedByte();
               if(i == 0) {
                  return;
               }

               if(i == 1) {
                  this.modelId = stream.readUShort();
               } else if(i == 2) {
                  this.name = stream.readString();
               } else if(i == 3) {
                  this.description = stream.readString();
               } else if(i == 4) {
                  this.spriteScale = stream.readUShort();
               } else if(i == 5) {
                  this.spritePitch = stream.readUShort();
               } else if(i == 6) {
                  this.spriteCameraRoll = stream.readUShort();
               } else if(i == 7) {
                  this.spriteTranslateX = stream.readUShort();
                  if(this.spriteTranslateX > 32767) {
                     this.spriteTranslateX -= 65536;
                  }
               } else if(i == 8) {
                  this.spriteTranslateY = stream.readUShort();
                  if(this.spriteTranslateY > 32767) {
                     this.spriteTranslateY -= 65536;
                  }
               } else if(i == 11) {
                  this.stackable = true;
               } else if(i == 12) {
                  this.value = stream.readInt();
               } else if(i == 16) {
                  this.membersObject = true;
               } else if(i == 23) {
                  this.primaryMaleModel = stream.readUShort();
                  this.maleTranslation = stream.readSignedByte();
               } else if(i == 24) {
                  this.secondaryMaleModel = stream.readUShort();
               } else if(i == 25) {
                  this.primaryFemaleModel = stream.readUShort();
                  this.femaleTranslation = stream.readSignedByte();
               } else if(i == 26) {
                  this.secondaryFemaleModel = stream.readUShort();
               } else if(i >= 30 && i < 35) {
                   if (groundActions == null) {
                       groundActions = new String[5];
                   }
                   groundActions[i - 30] = stream.readString();
                   if (groundActions[i - 30].equalsIgnoreCase("Hidden")) {
                       groundActions[i - 30] = null;
                   }
               } else if(i >= 35 && i < 40) {
                  if(this.itemActions == null) {
                     this.itemActions = new String[5];
                  }

                  this.itemActions[i - 35] = stream.method415();
               } else if(i == 40) {
                  int j = stream.readUnsignedByte();
                  this.modifiedModelColors = new int[j];
                  this.originalModelColors = new int[j];

                  for(int k = 0; k < j; ++k) {
                     this.originalModelColors[k] = (short)stream.readUShort();
                     this.modifiedModelColors[k] = (short)stream.readUShort();
                  }
               } else if(i == 41) {
                   int var3 = stream.readUnsignedByte();
                   this.textureToReplace = new short[var3];
                   this.textToReplaceWith = new short[var3];

                   for(int var4 = 0; var4 < var3; ++var4) {
                      this.textureToReplace[var4] = (short)stream.readUnsignedShort();
                      this.textToReplaceWith[var4] = (short)stream.readUnsignedShort();
                   }
               } else if (i == 42) {
                   shiftClickIndex = stream.readUnsignedByte();
   			} else if (i == 65) {
				searchableItem = true;
               } else if(i == 78) {
                  this.tertiaryMaleEquipmentModel = stream.readUShort();
               } else if(i == 79) {
                  this.tertiaryFemaleEquipmentModel = stream.readUShort();
               } else if(i == 90) {
                  this.primaryMaleHeadPiece = stream.readUShort();
               } else if(i == 91) {
                  this.primaryFemaleHeadPiece = stream.readUShort();
               } else if(i == 92) {
                  this.secondaryMaleHeadPiece = stream.readUShort();
               } else if(i == 93) {
                  this.secondaryFemaleHeadPiece = stream.readUShort();
               } else if(i == 95) {
                  this.spriteCameraYaw = stream.readUShort();
               } else if(i == 97) {
                  this.certID = stream.readUShort();
               } else if(i == 98) {
                  this.certTemplateID = stream.readUShort();
               } else if(i >= 100 && i < 110) {
                  if(this.stackIds == null) {
                     this.stackIds = new int[10];
                     this.stackAmounts = new int[10];
                  }

                  this.stackIds[i - 100] = stream.readUShort();
                  this.stackAmounts[i - 100] = stream.readUShort();
               } else if(i == 110) {
                  this.groundScaleX = stream.readUShort();
               } else if(i == 111) {
                  this.groundScaleY = stream.readUShort();
               } else if(i == 112) {
                  this.groundScaleZ = stream.readUShort();
               } else if(i == 113) {
                  this.ambience = stream.readSignedByte();
               } else if(i == 114) {
                  this.diffusion = stream.readSignedByte();
               } else if(i == 115) {
                  this.team = stream.readUnsignedByte();
               } else if (i == 139) {
                   unnotedId = stream.readUShort(); // un-noted id
               } else if (i == 140) {
                   notedId = stream.readUShort(); // noted id
               } else if (i == 148) {
            	   placeholderId = stream.readUShort(); // placeholder id
               } else if (i == 149) {
            	   placeholderTemplateId = stream.readUShort(); // placeholder template
               
               }
            }
         }
      }
   public static void Models(int i, int j, int k) {
	      ItemDefinition class8 = cache[anInt180];
	      class8.modelId = i;
	      class8.primaryMaleModel = j;
	      class8.primaryFemaleModel = k;
	   }

	   public static void NewColor(int i, int j, int k) {
	      ItemDefinition class8 = cache[anInt180];
	      class8.modifiedModelColors[k] = i;
	      class8.originalModelColors[k] = j;
	   }

	   public static void NEO(String s, String s1, String s2) {
	      ItemDefinition class8 = cache[anInt180];
	      class8.itemActions = new String[5];
	      class8.itemActions[1] = s2;
	      class8.name = s;
	      class8.description = s1;
	   }

	   public static void Zoom(int i, int j, int k, int l, int i1, boolean flag) {
	      ItemDefinition class8 = cache[anInt180];
	      class8.spriteScale = i;
	      class8.spritePitch = l;
	      class8.spriteCameraRoll = i1;
	      class8.spriteTranslateX = k;
	      class8.spriteTranslateY = j;
	      class8.stackable = flag;
	   }

	   public static void Jukkycolors(int i, int j, int k) {
	      ItemDefinition class8 = cache[anInt180];
	      class8.modifiedModelColors[k] = i;
	      class8.originalModelColors[k] = j;
	   }

	   public static void Jukkyzoom(int i, int j, int k, int l, int i1, int j1, int k1, int l1, boolean flag) {
	      ItemDefinition class8 = cache[anInt180];
	      class8.spriteScale = i;
	      class8.spritePitch = j;
	      class8.spriteCameraRoll = k;
	      class8.spriteCameraYaw = l;
	      class8.spriteTranslateX = i1;
	      class8.spriteTranslateY = j1;
	      class8.stackable = flag;
	      class8.primaryMaleHeadPiece = k1;
	      class8.primaryFemaleHeadPiece = l1;
	   }

	   public static void Jukkyname(String s, String s1) {
	      ItemDefinition class8 = cache[anInt180];
	      class8.itemActions = new String[5];
	      class8.itemActions[1] = "Wear";
	      class8.name = s;
	      class8.description = s1;
	   }

	   public static void JukkyModels(int male, int malearms, int female, int femalearms, int dropmdl) {
	      ItemDefinition class8 = cache[anInt180];
	      class8.primaryMaleModel = male;
	      class8.secondaryMaleModel = malearms;
	      class8.primaryFemaleModel = female;
	      class8.secondaryFemaleModel = femalearms;
	      class8.modelId = dropmdl;
	   }
}
