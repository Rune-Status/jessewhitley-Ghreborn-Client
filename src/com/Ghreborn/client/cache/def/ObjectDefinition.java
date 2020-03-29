//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.Ghreborn.client.cache.def;

import com.Ghreborn.client.Main;
import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.cache.anim.Frame;
import com.Ghreborn.client.entity.model.Model;
import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.link.MRUNodes;
import com.Ghreborn.client.net.OnDemandFetcher;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public final class ObjectDefinition {
	public static boolean lowMem;
	public static Buffer stream2;
	public static int[] streamIndices2;
	public static Main clientInstance;
	public int dummy;
	public int anInt770;
	public int anInt743;
	public static final Model[] aModelArray741 = new Model[4];
	public static MRUNodes aClass12_780 = new MRUNodes(30);
	public static MRUNodes aClass12_785 = new MRUNodes(500);
	public int type = -1;
	public static int cacheIndex;
	public int[] modelIds;
	public int[] modelTypes;
	public String name;
	public byte[] description;
	public int[] modifiedModelColors;
	short[] originalTexture;
	short[] modifiedTexture;
	public int[] originalModelColors;
	public int clipType = 2;
	public int width;
	public int length;
	public boolean solid;
	public boolean impenetrable;
	public int interactive;
	public boolean contouredGround;
	public boolean nonFlatShading;
	public boolean modelClipped;
	public int animation;
	public int decorDisplacement;
	public byte ambientLighting;
	public int contrast;
	public String[] actions;
	public int mapIcon;
	public int mapscene;
	public boolean inverted;
	public boolean castsShadow;
	public int scaleX;
	public int scaleY;
	public int scaleZ;
	public int surroundings;
	public int translateX;
	public int translateY;
	public int translateZ;
	public boolean obstructsGround;
	public boolean removeClipping;
	public int supportItems;
	public int varbit;
	public int varp;
	public int[] morphisms;
	public static int[] streamIndices;
	public static ObjectDefinition[] cache;
	public static Buffer stream;
	private static boolean rev562;
	private static int totalObjects;
	public int[] textureFind;
	public int[] textureReplace;
	private int currentcolors;

	public static ObjectDefinition forID(int i) {
		if (i > streamIndices.length) {
			i = streamIndices.length - 2;
		}

		if (i == 25913 || i == 25916 || i == 25917) {
			i = 15552;
		}

		for(int var2 = 0; var2 < 20; ++var2) {
			if (cache[var2].type == i) {
				return cache[var2];
			}
		}

		cacheIndex = (cacheIndex + 1) % 20;
		ObjectDefinition objectDef = cache[cacheIndex];
		stream.currentOffset = streamIndices[i];
		objectDef.type = i;
		objectDef.setDefaults();
		objectDef.decode(stream);
		if (i >= 26281 && i <= 26290) {
			objectDef.actions = new String[]{"Choose", null, null, null, null};
		}

		if (i == 26502) {
			objectDef.actions = new String[]{"Open", "Peek", "Start Instance", null, null};
		}

		if (i == 26503) {
			objectDef.actions = new String[]{"Open", "Peek", "Start Instance", null, null};
		}

		if (i == 26504) {
			objectDef.actions = new String[]{"Open", "Peek", "Start Instance", null, null};
		}

		if (i == 26505) {
			objectDef.actions = new String[]{"Open", "Peek", "Start Instance", null, null};
		}

		if (i == 37437) {
			objectDef.modelIds = new int[]{41208};
			objectDef.modelTypes = new int[]{10};
			objectDef.name = "Slot machine";
			objectDef.width = 1;
			objectDef.length = 1;
			objectDef.solid = true;
			objectDef.impenetrable = false;
			objectDef.contouredGround = false;
			objectDef.nonFlatShading = false;
			objectDef.modelClipped = false;
			objectDef.animation = -1;
			objectDef.decorDisplacement = 16;
			objectDef.ambientLighting = 0;
			objectDef.contrast = 0;
			objectDef.actions = new String[]{null, "Spin", null, null, null};
			objectDef.mapIcon = -1;
			objectDef.mapscene = -1;
			objectDef.inverted = false;
			objectDef.castsShadow = true;
			objectDef.scaleX = 128;
			objectDef.scaleY = 128;
			objectDef.scaleZ = 128;
			objectDef.surroundings = 0;
			objectDef.translateX = 0;
			objectDef.translateY = 0;
			objectDef.translateZ = 0;
			objectDef.obstructsGround = false;
			objectDef.removeClipping = false;
			objectDef.supportItems = 1;
			objectDef.varbit = -1;
			objectDef.varp = -1;
			objectDef.removeClipping = false;
			objectDef.morphisms = null;
		}

		if (i == 37434) {
			objectDef.modelIds = new int[]{1390};
			objectDef.modelTypes = new int[]{10};
			objectDef.name = "Rocks";
			objectDef.modifiedModelColors = new int[1];
			objectDef.originalModelColors = new int[1];
			objectDef.modifiedModelColors[0] = 24;
			objectDef.originalModelColors[0] = 924;
			objectDef.width = 1;
			objectDef.length = 1;
			objectDef.solid = true;
			objectDef.impenetrable = false;
			objectDef.contouredGround = true;
			objectDef.nonFlatShading = false;
			objectDef.modelClipped = false;
			objectDef.animation = -1;
			objectDef.decorDisplacement = 16;
			objectDef.ambientLighting = 0;
			objectDef.contrast = 0;
			objectDef.actions = new String[]{"Mine", "Prospect", null, null, null, null, null, null, null, null};
			objectDef.mapIcon = -1;
			objectDef.mapscene = 12;
			objectDef.inverted = false;
			objectDef.castsShadow = true;
			objectDef.scaleX = 128;
			objectDef.scaleY = 128;
			objectDef.scaleZ = 128;
			objectDef.surroundings = 0;
			objectDef.translateX = 0;
			objectDef.translateY = 0;
			objectDef.translateZ = 0;
			objectDef.obstructsGround = false;
			objectDef.removeClipping = false;
			objectDef.supportItems = 1;
			objectDef.varbit = -1;
			objectDef.varp = -1;
			objectDef.removeClipping = false;
			objectDef.morphisms = null;
		}

		if (i == 37435) {
			objectDef.modelIds = new int[]{1390};
			objectDef.modelTypes = new int[]{10};
			objectDef.name = "Rocks";
			objectDef.modifiedModelColors = new int[1];
			objectDef.originalModelColors = new int[1];
			objectDef.modifiedModelColors[0] = 24;
			objectDef.originalModelColors[0] = 126;
			objectDef.width = 1;
			objectDef.length = 1;
			objectDef.solid = true;
			objectDef.impenetrable = false;
			objectDef.contouredGround = true;
			objectDef.nonFlatShading = false;
			objectDef.modelClipped = false;
			objectDef.animation = -1;
			objectDef.decorDisplacement = 16;
			objectDef.ambientLighting = 0;
			objectDef.contrast = 0;
			objectDef.actions = new String[]{"Mine", "Prospect", null, null, null, null, null, null, null, null};
			objectDef.mapIcon = -1;
			objectDef.mapscene = 12;
			objectDef.inverted = false;
			objectDef.castsShadow = true;
			objectDef.scaleX = 128;
			objectDef.scaleY = 128;
			objectDef.scaleZ = 128;
			objectDef.surroundings = 0;
			objectDef.translateX = 0;
			objectDef.translateY = 0;
			objectDef.translateZ = 0;
			objectDef.obstructsGround = false;
			objectDef.removeClipping = false;
			objectDef.supportItems = 1;
			objectDef.varbit = -1;
			objectDef.varp = -1;
			objectDef.removeClipping = false;
			objectDef.morphisms = null;
		}

		if (i == 37436) {
			objectDef.modelIds = new int[]{1390};
			objectDef.modelTypes = new int[]{10};
			objectDef.name = "Rocks";
			objectDef.modifiedModelColors = new int[1];
			objectDef.originalModelColors = new int[1];
			objectDef.modifiedModelColors[0] = 24;
			objectDef.originalModelColors[0] = 0;
			objectDef.width = 1;
			objectDef.length = 1;
			objectDef.solid = true;
			objectDef.impenetrable = false;
			objectDef.contouredGround = true;
			objectDef.nonFlatShading = false;
			objectDef.modelClipped = false;
			objectDef.animation = -1;
			objectDef.decorDisplacement = 16;
			objectDef.ambientLighting = 0;
			objectDef.contrast = 0;
			objectDef.actions = new String[]{"Mine", "Prospect", null, null, null, null, null, null, null, null};
			objectDef.mapIcon = -1;
			objectDef.mapscene = 12;
			objectDef.inverted = false;
			objectDef.castsShadow = true;
			objectDef.scaleX = 128;
			objectDef.scaleY = 128;
			objectDef.scaleZ = 128;
			objectDef.surroundings = 0;
			objectDef.translateX = 0;
			objectDef.translateY = 0;
			objectDef.translateZ = 0;
			objectDef.obstructsGround = false;
			objectDef.removeClipping = false;
			objectDef.supportItems = 1;
			objectDef.varbit = -1;
			objectDef.varp = -1;
			objectDef.removeClipping = false;
			objectDef.morphisms = null;
		}


		switch(i) {
			case 7235:
				objectDef.name = "Wall safe";
				objectDef.interactive = 1;
				objectDef.actions = new String[]{"Crack", null, null, null, null};
				break;
			case 16891:
				objectDef.name = "Ckey/Rare Key Chest";
				objectDef.actions = new String[]{"Search", null, null, null, null};
				break;
			case 25382:
				objectDef.name = "Portal";
				objectDef.interactive = 1;
				objectDef.actions = new String[]{"Teleport", null, null, null, null};
				break;
			case 33153:
				objectDef.mapIcon = 91;
				break;
			case 33154:
				objectDef.mapIcon = 92;
				break;
			case 33155:
				objectDef.mapIcon = 93;
				break;
			case 33156:
				objectDef.mapIcon = 94;
				break;
			case 33157:
				objectDef.mapIcon = 95;
				break;
			case 33158:
				objectDef.mapIcon = 96;
				break;
			case 33159:
				objectDef.mapIcon = 97;
				break;
			case 33160:
				objectDef.mapIcon = 98;
				break;
			case 33161:
				objectDef.mapIcon = 99;
				break;
			case 33162:
				objectDef.mapIcon = 100;
				break;
			case 33163:
				objectDef.mapIcon = 101;
				break;
			case 33164:
				objectDef.mapIcon = 102;
				break;
			case 33165:
				objectDef.mapIcon = 103;
		}

		return objectDef;
	}

	public static void dumpObjectList() {
		for(int i = 0; i < totalObjects; ++i) {
			ObjectDefinition objectDef = forID(i);
			BufferedWriter bw = null;

			try {
				bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/177ObjectList.txt", true));
				bw.write("ID: " + i + "\t\tName: " + objectDef.name);
				bw.newLine();
				bw.write("Mapicon" + objectDef.mapIcon);
				bw.newLine();
				bw.flush();
				bw.close();
			} catch (IOException var4) {
			}
		}

	}

	public static void dumpobjects2() {
		for(int i = 0; i < totalObjects; ++i) {
			ObjectDefinition objectDef = forID(i);
			BufferedWriter bw = null;

			try {
				objectDef.currentcolors = 0;
				bw = new BufferedWriter(new FileWriter(SignLink.findcachedir() + "/dumps/objectdump177.txt", true));
				bw.newLine();
				bw.write("\tif(i == " + i + ") //ID");
				bw.newLine();
				bw.write("\t\t{");
				bw.newLine();
				bw.write("\t\t\tobjectDef.modelIds = new int[] {" + Arrays.toString(objectDef.modelIds) + "};");
				bw.newLine();
				bw.write("\t\t\tobjectDef.modelTypes = new int[] {" + Arrays.toString(objectDef.modelTypes) + "};");
				bw.newLine();
				bw.write("\t\t\tobjectDef.name = \"" + objectDef.name + "\"; //Name");
				bw.newLine();
				bw.write("\t\t\tobjectDef.description = \"Its an " + objectDef.name + "\"; //Description");
				bw.newLine();
				int i2;
				if (objectDef.modifiedModelColors != null) {
					for(i2 = 0; i2 < objectDef.modifiedModelColors.length; ++i2) {
						if (i2 != objectDef.modifiedModelColors.length - 1) {
							++objectDef.currentcolors;
						} else {
							++objectDef.currentcolors;
							if (objectDef.currentcolors != 0) {
								bw.write("\t\t\tobjectDef.modifiedModelColors = new int[" + objectDef.currentcolors + "];");
								bw.newLine();
								bw.write("\t\t\tobjectDef.originalModelColors = new int[" + objectDef.currentcolors + "];");
								bw.newLine();
							}

							objectDef.currentcolors = 0;
						}
					}
				}

				if (objectDef.modifiedModelColors != null) {
					for(i2 = 0; i2 < objectDef.modifiedModelColors.length; ++i2) {
						if (i2 != objectDef.modifiedModelColors.length - 1) {
							bw.write("\t\t\tobjectDef.modifiedModelColors[" + objectDef.currentcolors + "] = " + objectDef.modifiedModelColors[i2] + ";");
							++objectDef.currentcolors;
							bw.newLine();
						} else {
							bw.write("\t\t\tobjectDef.modifiedModelColors[" + objectDef.currentcolors + "] = " + objectDef.modifiedModelColors[i2] + ";");
							objectDef.currentcolors = 0;
							bw.newLine();
						}
					}
				}

				if (objectDef.originalModelColors != null) {
					for(i2 = 0; i2 < objectDef.originalModelColors.length; ++i2) {
						if (i2 != objectDef.originalModelColors.length - 1) {
							bw.write("\t\t\tobjectDef.originalModelColors[" + objectDef.currentcolors + "] = " + objectDef.originalModelColors[i2] + ";");
							++objectDef.currentcolors;
							bw.newLine();
						} else {
							bw.write("\t\t\tobjectDef.originalModelColors[" + objectDef.currentcolors + "] = " + objectDef.originalModelColors[i2] + ";");
							objectDef.currentcolors = 0;
							bw.newLine();
						}
					}

					bw.write("\t\t\tobjectDef.width = " + objectDef.width + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.length = " + objectDef.length + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.solid = " + objectDef.solid + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.impenetrable = " + objectDef.impenetrable + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.interactive = " + objectDef.interactive + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.contouredGround = " + objectDef.contouredGround + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.nonFlatShading = " + objectDef.nonFlatShading + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.modelClipped = " + objectDef.modelClipped + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.animation = " + objectDef.animation + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.decorDisplacement = " + objectDef.decorDisplacement + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.ambientLighting = " + objectDef.ambientLighting + ";");
					bw.newLine();
					bw.write("\t\t\tobjectDef.contrast = " + objectDef.contrast + ";");
					bw.newLine();
					if (objectDef.originalTexture != null) {
						for(i2 = 0; i2 < objectDef.originalTexture.length; ++i2) {
							if (i2 != objectDef.originalTexture.length - 1) {
								++objectDef.currentcolors;
							} else {
								++objectDef.currentcolors;
								if (objectDef.currentcolors != 0) {
									bw.write("\t\t\tobjectDef.originalTexture  = new int[" + objectDef.currentcolors + "];");
									bw.newLine();
									bw.write("\t\t\tobjectDef.modifiedTexture  = new int[" + objectDef.currentcolors + "];");
									bw.newLine();
								}

								objectDef.currentcolors = 0;
							}
						}
					}

					if (objectDef.originalTexture != null) {
						for(i2 = 0; i2 < objectDef.originalTexture.length; ++i2) {
							if (i2 != objectDef.originalTexture.length - 1) {
								bw.write("\t\t\tobjectDef.originalTexture [" + objectDef.currentcolors + "] = " + objectDef.originalTexture[i2] + ";");
								++objectDef.currentcolors;
								bw.newLine();
							} else {
								bw.write("\t\t\tobjectDef.modifiedTexture [" + objectDef.currentcolors + "] = " + objectDef.originalTexture[i2] + ";");
								objectDef.currentcolors = 0;
								bw.newLine();
							}
						}
					}

					if (objectDef.modifiedTexture != null) {
						for(i2 = 0; i2 < objectDef.modifiedTexture.length; ++i2) {
							if (i2 != objectDef.modifiedTexture.length - 1) {
								bw.write("\t\t\tobjectDef.modifiedTexture [" + objectDef.currentcolors + "] = " + objectDef.modifiedTexture[i2] + ";");
								++objectDef.currentcolors;
								bw.newLine();
							} else {
								bw.write("\t\t\tobjectDef.modifiedTexture[" + objectDef.currentcolors + "] = " + objectDef.modifiedTexture[i2] + ";");
								objectDef.currentcolors = 0;
								bw.newLine();
							}
						}
					}
				}

				bw.write("\t\t\tobjectDef.actions = new String[] {" + Arrays.toString(objectDef.actions) + "};");
				bw.newLine();
				bw.write("\t\t\tobjectDef.mapIcon = " + objectDef.mapIcon + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.mapscene = " + objectDef.mapscene + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.inverted = " + objectDef.inverted + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.castsShadow = " + objectDef.castsShadow + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.scaleX = " + objectDef.scaleX + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.scaleY = " + objectDef.scaleY + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.scaleZ = " + objectDef.scaleZ + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.surroundings = " + objectDef.surroundings + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.translateX = " + objectDef.translateX + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.translateY = " + objectDef.translateY + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.translateZ = " + objectDef.translateZ + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.obstructsGround = " + objectDef.obstructsGround + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.removeClipping = " + objectDef.removeClipping + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.supportItems = " + objectDef.supportItems + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.varbit = " + objectDef.varbit + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.varp = " + objectDef.varp + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.removeClipping = " + objectDef.removeClipping + ";");
				bw.newLine();
				bw.write("\t\t\tobjectDef.morphisms = new int[] {" + Arrays.toString(objectDef.morphisms) + "};");
				bw.newLine();
				bw.write("\t\t}");
				bw.newLine();
				bw.newLine();
				bw.flush();
			} catch (IOException var12) {
				var12.printStackTrace();
			} finally {
				if (bw != null) {
					try {
						bw.close();
					} catch (IOException var11) {
					}
				}

			}
		}

	}

	public void setDefaults() {
		this.modelIds = null;
		this.modelTypes = null;
		this.description = null;
		this.modifiedModelColors = null;
		this.originalModelColors = null;
		this.originalTexture = null;
		this.modifiedTexture = null;
		this.width = 1;
		this.length = 1;
		this.solid = true;
		this.impenetrable = true;
		this.interactive = -1;
		this.contouredGround = false;
		this.nonFlatShading = false;
		this.modelClipped = false;
		this.animation = -1;
		this.decorDisplacement = 16;
		this.ambientLighting = 0;
		this.contrast = 0;
		this.actions = new String[5];
		this.mapIcon = -1;
		this.mapscene = -1;
		this.inverted = false;
		this.castsShadow = true;
		this.scaleX = 128;
		this.scaleY = 128;
		this.scaleZ = 128;
		this.surroundings = 0;
		this.translateX = 0;
		this.translateY = 0;
		this.translateZ = 0;
		this.obstructsGround = false;
		this.removeClipping = false;
		this.supportItems = -1;
		this.varbit = -1;
		this.varp = -1;
		this.morphisms = null;
	}

	public void method574(OnDemandFetcher class42_sub1) {
		if (this.modelIds != null) {
			for(int j = 0; j < this.modelIds.length; ++j) {
				class42_sub1.method560(this.modelIds[j] & '\uffff', 0);
			}
		}

	}

	public static void method575(int i) {
		aClass12_785 = null;
		aClass12_780 = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}

	public static void method576(StreamLoader streamLoader) {
		ObjectDefinition.stream = new Buffer(streamLoader.readFile("loc.dat"));
		Buffer stream = new Buffer(streamLoader.readFile("loc.idx"));
		totalObjects = stream.readUnsignedWord();
		System.out.println("osrs 177 Object Amount: " + totalObjects);
		streamIndices = new int[totalObjects + 100];
		int i = 2;

		int k;
		for(k = 0; k < totalObjects; ++k) {
			streamIndices[k] = i;
			i += stream.readUnsignedShort();
		}

		cache = new ObjectDefinition[20];

		for(k = 0; k < 20; ++k) {
			cache[k] = new ObjectDefinition();
		}

	}

	public boolean method577(int i) {
		if (this.modelTypes == null) {
			if (this.modelIds == null) {
				return true;
			} else if (i != 10) {
				return true;
			} else {
				boolean var4 = true;

				for(int k = 0; k < this.modelIds.length; ++k) {
					var4 &= Model.isCached(this.modelIds[k] & '\uffff');
				}

				return var4;
			}
		} else {
			for(int j = 0; j < this.modelTypes.length; ++j) {
				if (this.modelTypes[j] == i) {
					return Model.isCached(this.modelIds[j] & '\uffff');
				}
			}

			return true;
		}
	}

	public Model method578(int i, int j, int k, int l, int i1, int j1, int k1) {
		Model model = this.method581(i, k1, j);
		if (model == null) {
			return null;
		} else {
			if (this.contouredGround || this.nonFlatShading) {
				model = new Model(this.contouredGround, this.nonFlatShading, model);
			}

			if (this.contouredGround) {
				int l1 = (k + l + i1 + j1) / 4;

				for(int i2 = 0; i2 < model.numberOfVerticeCoordinates; ++i2) {
					int j2 = model.verticesXCoordinate[i2];
					int k2 = model.verticesZCoordinate[i2];
					int l2 = k + (l - k) * (j2 + 64) / 128;
					int i3 = j1 + (i1 - j1) * (j2 + 64) / 128;
					int j3 = l2 + (i3 - l2) * (k2 + 64) / 128;
					int[] var10000 = model.verticesYCoordinate;
					var10000[i2] += j3 - l1;
				}

				model.method467(false);
			}

			return model;
		}
	}

	public boolean method579() {
		if (this.modelIds == null) {
			return true;
		} else {
			boolean flag1 = true;

			for(int i = 0; i < this.modelIds.length; ++i) {
				flag1 &= Model.isCached(this.modelIds[i] & '\uffff');
			}

			return flag1;
		}
	}

	public ObjectDefinition morph() {
		int morphismIndex = -1;
		if (this.varbit != -1) {
			VarBit bits = VarBit.cache[this.varbit];
			int variable = bits.configId;
			int low = bits.lsb;
			int high = bits.msb;
			int mask = Main.BIT_MASKS[high - low];
			morphismIndex = clientInstance.settings[variable] >> low & mask;
		} else if (this.varp != -1) {
			morphismIndex = clientInstance.settings[this.varp];
		}

		int var;
		if (morphismIndex >= 0 && morphismIndex < this.morphisms.length) {
			var = this.morphisms[morphismIndex];
		} else {
			var = this.morphisms[this.morphisms.length - 1];
		}

		return var != -1 ? forID(var) : null;
	}

	public Model method581(int j, int k, int l) {
		Model model = null;
		long l1;
		boolean flag2;
		int model_3;
		int index;
		if (this.modelTypes == null) {
			if (j != 10) {
				return null;
			}

			l1 = (long)((this.type << 6) + l) + ((long)(k + 1) << 32);
			Model var15 = (Model)aClass12_780.insertFromCache(l1);
			if (var15 != null) {
				return var15;
			}

			if (this.modelIds == null) {
				return null;
			}

			flag2 = this.inverted ^ l > 3;
			model_3 = this.modelIds.length;

			for(index = 0; index < model_3; ++index) {
				int var17 = this.modelIds[index];
				if (flag2) {
					var17 += 65536;
				}

				model = (Model)aClass12_785.insertFromCache((long)var17);
				if (model == null) {
					model = Model.getModel(var17 & '\uffff');
					if (model == null) {
						return null;
					}

					if (flag2) {
						model.method477(0);
					}

					aClass12_785.removeFromCache(model, (long)var17);
				}

				if (model_3 > 1) {
					aModelArray741[index] = model;
				}
			}

			if (model_3 > 1) {
				model = new Model(model_3, aModelArray741);
			}
		} else {
			int var14 = -1;

			for(int var17 = 0; var17 < this.modelTypes.length; ++var17) {
				if (this.modelTypes[var17] == j) {
					var14 = var17;
					break;
				}
			}

			if (var14 == -1) {
				return null;
			}

			l1 = (long)((this.type << 8) + (var14 << 3) + l) + ((long)(k + 1) << 32);
			Model var16 = (Model)aClass12_780.insertFromCache(l1);
			if (var16 != null) {
				return var16;
			}

			model_3 = this.modelIds[var14];
			boolean var18 = this.inverted ^ l > 3;
			if (var18) {
				model_3 += 65536;
			}

			model = (Model)aClass12_785.insertFromCache((long)model_3);
			if (model == null) {
				model = Model.getModel(model_3 & '\uffff');
				if (model == null) {
					return null;
				}

				if (var18) {
					model.method477(0);
				}

				aClass12_785.removeFromCache(model, (long)model_3);
			}
		}

		boolean var151 = this.scaleX != 128 || this.scaleY != 128 || this.scaleZ != 128;
		flag2 = this.translateX != 0 || this.translateY != 0 || this.translateZ != 0;
		Model var16 = new Model(this.modifiedModelColors == null, Frame.method532(k), l == 0 && k == -1 && !var151 && !flag2, model);
		if (k != -1) {
			var16.method469((byte)-71);
			var16.method470(k);
			var16.anIntArrayArray1658 = null;
			var16.anIntArrayArray1657 = null;
		}

		while(l-- > 0) {
			var16.method473(360);
		}

		if (this.modifiedModelColors != null) {
			for(index = 0; index < this.modifiedModelColors.length; ++index) {
				var16.recolor(this.modifiedModelColors[index], this.originalModelColors[index]);
			}
		}

		if (this.originalTexture != null) {
			for(index = 0; index < this.originalTexture.length; ++index) {
				var16.retexture(this.originalTexture[index], this.modifiedTexture[index]);
			}
		}

		if (var151) {
			var16.method478(this.scaleX, this.scaleZ, this.anInt743, this.scaleY);
		}

		if (flag2) {
			var16.method475(this.translateX, this.translateY, 16384, this.translateZ);
		}

		var16.method479(64 + this.ambientLighting, 768 + this.contrast * 5, -50, -10, -50, !this.nonFlatShading);
		if (this.supportItems == 1) {
			var16.anInt1654 = var16.modelHeight;
		}

		aClass12_780.removeFromCache(var16, l1);
		return var16;
	}

	public void decode(Buffer buffer) {
		while(true) {
			int opcode = buffer.readUnsignedByte();
			if (opcode == 0) {
				if (this.interactive == -1) {
					this.interactive = 0;
					if (this.modelIds != null && (this.modelTypes == null || this.modelTypes[0] == 10)) {
						this.interactive = 1;
					}

					for(opcode = 0; opcode < 5; ++opcode) {
						if (this.actions[opcode] != null) {
							this.interactive = 1;
						}
					}
				}

				if (this.removeClipping) {
					this.solid = false;
					this.impenetrable = false;
				}

				if (this.supportItems == -1) {
					this.supportItems = this.solid ? 1 : 0;
				}

				return;
			}

			int value;
			int len;
			if (opcode == 1) {
				value = buffer.readUnsignedByte();
				if (value > 0) {
					if (this.modelIds == null) {
						this.modelTypes = new int[value];
						this.modelIds = new int[value];

						for(len = 0; len < value; ++len) {
							this.modelIds[len] = buffer.readUShort();
							this.modelTypes[len] = buffer.readUnsignedByte();
						}
					} else {
						buffer.currentOffset += value * 3;
					}
				}
			} else if (opcode == 2) {
				this.name = buffer.readString();
			} else if (opcode == 5) {
				value = buffer.readUnsignedByte();
				if (value > 0) {
					if (this.modelIds == null) {
						this.modelTypes = null;
						this.modelIds = new int[value];

						for(len = 0; len < value; ++len) {
							this.modelIds[len] = buffer.readUShort();
						}
					} else {
						buffer.currentOffset += value * 2;
					}
				}
			} else if (opcode == 14) {
				this.width = buffer.readUnsignedByte();
			} else if (opcode == 15) {
				this.length = buffer.readUnsignedByte();
			} else if (opcode == 17) {
				this.clipType = 0;
				this.impenetrable = false;
			} else if (opcode == 18) {
				this.impenetrable = false;
			} else if (opcode == 19) {
				this.interactive = buffer.readUnsignedByte();
			} else if (opcode == 21) {
				this.contouredGround = true;
			} else if (opcode == 22) {
				this.nonFlatShading = true;
			} else if (opcode == 23) {
				this.modelClipped = true;
			} else if (opcode == 24) {
				this.animation = buffer.readUShort();
				if (this.animation == 65535) {
					this.animation = -1;
				}
			} else if (opcode == 27) {
				this.clipType = 1;
			} else if (opcode == 28) {
				this.decorDisplacement = buffer.readUnsignedByte();
			} else if (opcode == 29) {
				this.ambientLighting = buffer.readSignedByte();
			} else if (opcode == 39) {
				this.contrast = buffer.readSignedByte() * 25;
			} else if (opcode >= 30 && opcode < 35) {
				if (this.actions == null) {
					this.actions = new String[5];
				}

				this.actions[opcode - 30] = buffer.readString();
				if (this.actions[opcode - 30].equalsIgnoreCase("Hidden")) {
					this.actions[opcode - 30] = null;
				}
			} else if (opcode == 40) {
				value = buffer.readUnsignedByte();
				this.modifiedModelColors = new int[value];
				this.originalModelColors = new int[value];

				for(len = 0; len < value; ++len) {
					this.modifiedModelColors[len] = buffer.readUShort();
					this.originalModelColors[len] = buffer.readUShort();
				}
			} else if (opcode == 41) {
				value = buffer.readUnsignedByte();
				this.originalTexture = new short[value];
				this.modifiedTexture = new short[value];

				for(len = 0; len < value; ++len) {
					this.originalTexture[len] = (short)buffer.readUShort();
					this.modifiedTexture[len] = (short)buffer.readUShort();
				}
			} else if (opcode == 62) {
				this.inverted = true;
			} else if (opcode == 64) {
				this.castsShadow = false;
			} else if (opcode == 65) {
				this.scaleX = buffer.readUShort();
			} else if (opcode == 66) {
				this.scaleY = buffer.readUShort();
			} else if (opcode == 67) {
				this.scaleZ = buffer.readUShort();
			} else if (opcode == 68) {
				this.mapscene = buffer.readUShort();
			} else if (opcode == 69) {
				this.surroundings = buffer.readUnsignedByte();
			} else if (opcode == 70) {
				this.translateX = buffer.readUShort();
			} else if (opcode == 71) {
				this.translateY = buffer.readUShort();
			} else if (opcode == 72) {
				this.translateZ = buffer.readUShort();
			} else if (opcode == 73) {
				this.obstructsGround = true;
			} else if (opcode == 74) {
				this.removeClipping = true;
			} else if (opcode == 75) {
				this.supportItems = buffer.readUnsignedByte();
			} else if (opcode == 78) {
				buffer.readUShort();
				buffer.readUnsignedByte();
			} else if (opcode == 79) {
				buffer.readUShort();
				buffer.readUShort();
				buffer.readUnsignedByte();
				value = buffer.readUnsignedByte();

				for(len = 0; len < value; ++len) {
					buffer.readUShort();
				}
			} else if (opcode == 81) {
				buffer.readUnsignedByte();
			} else if (opcode == 82) {
				this.mapIcon = buffer.readUShort();
				if (this.mapIcon == 65535) {
					this.mapIcon = -1;
				}
			} else if (opcode != 77 && opcode != 92) {
				System.out.println("invalid opcode: " + opcode);
			} else {
				this.varbit = buffer.readUShort();
				if (this.varp == 65535) {
					this.varp = -1;
				}

				this.varp = buffer.readUShort();
				if (this.varbit == 65535) {
					this.varbit = -1;
				}

				value = -1;
				if (opcode == 92) {
					value = buffer.readUShort();
					if (value == 65535) {
						value = -1;
					}
				}

				len = buffer.readUnsignedByte();
				this.morphisms = new int[len + 2];

				for(int i = 0; i <= len; ++i) {
					this.morphisms[i] = buffer.readUShort();
					if (this.morphisms[i] == 65535) {
						this.morphisms[i] = -1;
					}
				}

				this.morphisms[len + 1] = value;
			}
		}
	}

	public ObjectDefinition() {
		this.type = -1;
	}
}
