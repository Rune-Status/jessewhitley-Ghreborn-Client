//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.Ghreborn.client.map;

import com.Ghreborn.client.Constants;
import com.Ghreborn.client.Main;
import com.Ghreborn.client.cache.def.FloorDefinition;
import com.Ghreborn.client.cache.def.ObjectDefinition;
import com.Ghreborn.client.draw.Rasterizer;
import com.Ghreborn.client.entity.Animable;
import com.Ghreborn.client.entity.Animable_Sub5;
import com.Ghreborn.client.entity.model.Model;
import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.net.OnDemandFetcher;
import java.util.ArrayList;

public final class ObjectManager {
	public static Main clientInstance;
	public static int anInt131;
	private static int anInt123 = (int)(Math.random() * 17.0D) - 8;
	private static int anInt133 = (int)(Math.random() * 33.0D) - 16;
	private static final int[] anIntArray137 = new int[]{1, 0, -1, 0};
	private static final int[] anIntArray140 = new int[]{16, 32, 64, 128};
	private static final int[] anIntArray144 = new int[]{0, -1, 0, 1};
	public static int maximumPlane = 99;
	public static boolean lowMem = true;
	private static final int[] anIntArray152 = new int[]{1, 2, 4, 8};
	public ArrayList colors = new ArrayList();
	private final int regionSizeX;
	private final int regionSizeY;
	private final int[][][] tileHeights;
	private final byte[][][] tileFlags;
	private final byte[][][] underlays;
	private final byte[][][] overlays;
	private final byte[][][] overlayTypes;
	private final byte[][][] overlayOrientations;
	private final int[][][] anIntArrayArrayArray135;
	private final byte[][][] shading;
	private final int[][] tileLighting;
	private final int[] hues;
	private final int[] saturations;
	private final int[] luminances;
	private final int[] chromas;
	private final int[] anIntArray128;
	public static final int BRIDGE_TILE = 2;
	private static final int FORCE_LOWEST_PLANE = 8;

	private int encode(int hue, int saturation, int luminance) {
		if (luminance > 179) {
			saturation /= 2;
		}

		if (luminance > 192) {
			saturation /= 2;
		}

		if (luminance > 217) {
			saturation /= 2;
		}

		if (luminance > 243) {
			saturation /= 2;
		}

		return (hue / 4 << 10) + (saturation / 32 << 7) + luminance / 2;
	}

	private int getCollisionPlane(int y, int z, int x) {
		if ((this.tileFlags[z][x][y] & 8) != 0) {
			return 0;
		} else {
			return z > 0 && (this.tileFlags[1][x][y] & 2) != 0 ? z - 1 : z;
		}
	}

	public ObjectManager(byte[][][] abyte0, int[][][] ai) {
		maximumPlane = 99;
		this.regionSizeX = 104;
		this.regionSizeY = 104;
		this.tileHeights = ai;
		this.tileFlags = abyte0;
		this.underlays = new byte[4][this.regionSizeX][this.regionSizeY];
		this.overlays = new byte[4][this.regionSizeX][this.regionSizeY];
		this.overlayTypes = new byte[4][this.regionSizeX][this.regionSizeY];
		this.overlayOrientations = new byte[4][this.regionSizeX][this.regionSizeY];
		this.anIntArrayArrayArray135 = new int[4][this.regionSizeX + 1][this.regionSizeY + 1];
		this.shading = new byte[4][this.regionSizeX + 1][this.regionSizeY + 1];
		this.tileLighting = new int[this.regionSizeX + 1][this.regionSizeY + 1];
		this.hues = new int[this.regionSizeY];
		this.saturations = new int[this.regionSizeY];
		this.luminances = new int[this.regionSizeY];
		this.chromas = new int[this.regionSizeY];
		this.anIntArray128 = new int[this.regionSizeY];
	}

	private static int method170(int i, int j) {
		int plane = i + j * 57;
		plane ^= plane << 13;
		int regionX = plane * (plane * plane * 15731 + 789221) + 1376312589 & 2147483647;
		return regionX >> 19 & 255;
	}

	public final void createRegionScene(CollisionMap[] aclass11, WorldController worldController) {
		int l;
		int j2;
		int k2;
		int l2;
		for(l = 0; l < 4; ++l) {
			for(j2 = 0; j2 < 104; ++j2) {
				for(k2 = 0; k2 < 104; ++k2) {
					if ((this.tileFlags[l][j2][k2] & 1) == 1) {
						l2 = l;
						if ((this.tileFlags[1][j2][k2] & 2) == 2) {
							l2 = l - 1;
						}

						if (l2 >= 0) {
							aclass11[l2].method213(k2, j2);
						}
					}
				}
			}
		}

		int i5;
		int j6;
		int k7;
		int x;
		int i12;
		int z;
		int i15;
		int[] var10000;
		int i16;
		int i17;
		int i18;
		for(l = 0; l < 4; ++l) {
			byte[][] abyte0 = this.shading[l];
			byte byte0 = 96;
			char c = 768;
			byte byte1 = -50;
			byte byte2 = -10;
			byte byte3 = -50;
			i5 = (int)Math.sqrt((double)(byte1 * byte1 + byte2 * byte2 + byte3 * byte3));
			j6 = c * i5 >> 8;

			int underlayD;
			int overlayA;
			for(k7 = 1; k7 < this.regionSizeY - 1; ++k7) {
				for(x = 1; x < this.regionSizeX - 1; ++x) {
					i12 = this.tileHeights[l][x + 1][k7] - this.tileHeights[l][x - 1][k7];
					z = this.tileHeights[l][x][k7 + 1] - this.tileHeights[l][x][k7 - 1];
					i15 = (int)Math.sqrt((double)(i12 * i12 + 65536 + z * z));
					i16 = (i12 << 8) / i15;
					i17 = 65536 / i15;
					i18 = (z << 8) / i15;
					underlayD = byte0 + (byte1 * i16 + byte2 * i17 + byte3 * i18) / j6;
					overlayA = (abyte0[x - 1][k7] >> 2) + (abyte0[x + 1][k7] >> 3) + (abyte0[x][k7 - 1] >> 2) + (abyte0[x][k7 + 1] >> 3) + (abyte0[x][k7] >> 1);
					this.tileLighting[x][k7] = underlayD - overlayA;
				}
			}

			int[][] paletteIndices = new int[this.regionSizeX][this.regionSizeY];

			for(x = 0; x < this.regionSizeY; ++x) {
				this.hues[x] = 0;
				this.saturations[x] = 0;
				this.luminances[x] = 0;
				this.chromas[x] = 0;
				this.anIntArray128[x] = 0;
			}

			int tileHeightA;
			int tileHeightB;
			int tileHeightC;
			for(x = -5; x < this.regionSizeX; ++x) {
				for(i12 = 0; i12 < this.regionSizeY; ++i12) {
					z = x + 5;
					int var10002;
					if (z < this.regionSizeX) {
						i15 = this.underlays[l][z][i12] & 255;
						if (i15 > 0) {
							FloorDefinition flo = FloorDefinition.underlays[i15 - 1];
							var10000 = this.hues;
							var10000[i12] += flo.blendHue;
							var10000 = this.saturations;
							var10000[i12] += flo.saturation;
							var10000 = this.luminances;
							var10000[i12] += flo.lumiance;
							var10000 = this.chromas;
							var10000[i12] += flo.blendHueMultiplier;
							var10002 = this.anIntArray128[i12]++;
						}
					}

					i15 = x - 5;
					if (i15 >= 0) {
						i16 = this.underlays[l][i15][i12] & 255;
						if (i16 > 0) {
							FloorDefinition flo_1 = FloorDefinition.underlays[i16 - 1];
							var10000 = this.hues;
							var10000[i12] -= flo_1.blendHue;
							var10000 = this.saturations;
							var10000[i12] -= flo_1.saturation;
							var10000 = this.luminances;
							var10000[i12] -= flo_1.lumiance;
							var10000 = this.chromas;
							var10000[i12] -= flo_1.blendHueMultiplier;
							var10002 = this.anIntArray128[i12]--;
						}
					}
				}

				if (x >= 0) {
					i12 = 0;
					z = 0;
					i15 = 0;
					i16 = 0;
					i17 = 0;

					for(i18 = -5; i18 < this.regionSizeY; ++i18) {
						underlayD = i18 + 5;
						if (underlayD < this.regionSizeY) {
							i12 += this.hues[underlayD];
							z += this.saturations[underlayD];
							i15 += this.luminances[underlayD];
							i16 += this.chromas[underlayD];
							i17 += this.anIntArray128[underlayD];
						}

						overlayA = i18 - 5;
						if (overlayA >= 0) {
							i12 -= this.hues[overlayA];
							z -= this.saturations[overlayA];
							i15 -= this.luminances[overlayA];
							i16 -= this.chromas[overlayA];
							i17 -= this.anIntArray128[overlayA];
						}

						if (i18 >= 0 && i16 > 0 && i17 > 0) {
							tileHeightA = i12 * 256 / i16;
							tileHeightB = z / i17;
							tileHeightC = i15 / i17;
							paletteIndices[x][i18] = FloorDefinition.hsl24to16(tileHeightA, tileHeightB, tileHeightC);
						}
					}
				}
			}

			for(x = 0; x < this.regionSizeX; ++x) {
				i12 = x >= this.regionSizeX - 1 ? x : x + 1;

				for(z = 0; z < this.regionSizeY; ++z) {
					i15 = z >= this.regionSizeY - 1 ? z : z + 1;
					if (!lowMem || (this.tileFlags[0][x][z] & 2) != 0 || (this.tileFlags[l][x][z] & 16) == 0 && this.getCollisionPlane(z, l, x) == anInt131) {
						if (l < maximumPlane) {
							maximumPlane = l;
						}

						i16 = this.underlays[l][x][z] & 255;
						i17 = this.underlays[l][i12][z] & 255;
						i18 = this.underlays[l][i12][i15] & 255;
						underlayD = this.underlays[l][x][i15] & 255;
						overlayA = this.overlays[l][x][z] & 255;
						if (i16 > 0 || overlayA > 0) {
							tileHeightA = this.tileHeights[l][x][z];
							tileHeightB = this.tileHeights[l][x + 1][z];
							tileHeightC = this.tileHeights[l][x + 1][z + 1];
							int tileHeightD = this.tileHeights[l][x][z + 1];
							int tileShadowA = this.tileLighting[x][z];
							int tileShadowB = this.tileLighting[x + 1][z];
							int tileShadowC = this.tileLighting[x + 1][z + 1];
							int tileShadowD = this.tileLighting[x][z + 1];
							int paletteIndexA = -1;
							int paletteIndexB = -1;
							int paletteIndexC = -1;
							int paletteIndexD = -1;
							if (i16 > 0) {
								paletteIndexA = paletteIndices[x][z];
								if (i17 > 0) {
									paletteIndexB = paletteIndices[i12][z];
								}

								if (i18 > 0) {
									paletteIndexC = paletteIndices[i12][i15];
								}

								if (underlayD > 0) {
									paletteIndexD = paletteIndices[x][i15];
								}

								if (paletteIndexB == -1) {
									paletteIndexB = paletteIndexA;
								}

								if (paletteIndexC == -1) {
									paletteIndexC = paletteIndexA;
								}

								if (paletteIndexD == -1) {
									paletteIndexD = paletteIndexA;
								}
							}

							if (l > 0) {
								boolean occlude = true;
								if (i16 == 0 && this.overlayTypes[l][x][z] != 0) {
									occlude = false;
								}

								if (overlayA > 0 && !FloorDefinition.overlays[overlayA - 1].occlude) {
									occlude = false;
								}

								if (occlude && tileHeightA == tileHeightB && tileHeightA == tileHeightC && tileHeightA == tileHeightD) {
									var10000 = this.anIntArrayArrayArray135[l][x];
									var10000[z] |= 2340;
								}
							}

							int minimapRgb = 0;
							boolean check = !Constants.enableTileBlending || !Constants.enableSmoothShading;
							if (paletteIndexA != -1) {
								minimapRgb = Rasterizer.anIntArray1482[method187(paletteIndexA, 96)];
							}

							if (overlayA == 0) {
								worldController.method279(l, x, z, 0, 0, -1, 154, tileHeightA, tileHeightB, tileHeightC, tileHeightD, method187(paletteIndexA, tileShadowA), method187(check ? paletteIndexA : paletteIndexB, tileShadowB), method187(check ? paletteIndexA : paletteIndexC, tileShadowC), method187(check ? paletteIndexA : paletteIndexD, tileShadowD), 0, 0, 0, 0, minimapRgb, 0, false);
							} else {
								int shape = this.overlayTypes[l][x][z] + 1;
								byte angle = this.overlayOrientations[l][x][z];
								if (overlayA - 1 > FloorDefinition.overlays.length) {
									overlayA = FloorDefinition.overlays.length;
								}

								FloorDefinition def_over = FloorDefinition.overlays[overlayA - 1];
								int textureId = def_over.texture;
								if (textureId == 51) {
									textureId = 3;
								}

								if (textureId == 43) {
									textureId = 42;
								}

								if (textureId > 50) {
									textureId = -1;
								}

								int floorId;
								int minimapColor;
								if (textureId >= 0) {
									minimapColor = Rasterizer.method369(textureId);
									floorId = -1;
								} else if (def_over.rgb == 16711935) {
									minimapColor = 0;
									floorId = -2;
								} else if (def_over.rgb == 3355443) {
									minimapColor = Rasterizer.anIntArray1482[this.method185(def_over.hsl16, 96)];
									floorId = -2;
								} else {
									floorId = this.method177(def_over.hue, def_over.saturation, def_over.lumiance);
									minimapColor = Rasterizer.anIntArray1482[this.method185(def_over.hsl16, 96)];
								}

								if (minimapColor == 0 && def_over.anotherRgb != -1) {
									int newMinimapColor = this.method177(def_over.hue, def_over.saturation, def_over.lumiance);
									minimapColor = Rasterizer.anIntArray1482[swag(newMinimapColor, 96)];
								}

								worldController.method279(l, x, z, shape, angle, 154, textureId, tileHeightA, tileHeightB, tileHeightC, tileHeightD, method187(paletteIndexA, tileShadowA), method187(paletteIndexA, tileShadowB), method187(paletteIndexA, tileShadowC), method187(paletteIndexA, tileShadowD), this.checkedLight(floorId, tileShadowA), this.checkedLight(floorId, tileShadowB), this.checkedLight(floorId, tileShadowC), this.checkedLight(floorId, tileShadowD), minimapRgb, minimapColor, textureId >= 0 && textureId <= 50);
							}
						}
					}
				}
			}

			for(x = 1; x < this.regionSizeY - 1; ++x) {
				for(i12 = 1; i12 < this.regionSizeX - 1; ++i12) {
					worldController.method278(l, i12, x, this.method182(x, l, i12));
				}
			}
		}

		worldController.method305(-10, -50, -50);

		for(l = 0; l < this.regionSizeX; ++l) {
			for(j2 = 0; j2 < this.regionSizeY; ++j2) {
				if ((this.tileFlags[1][l][j2] & 2) == 2) {
					worldController.method276(j2, l);
				}
			}
		}

		l = 1;
		j2 = 2;
		k2 = 4;

		for(l2 = 0; l2 < 4; ++l2) {
			if (l2 > 0) {
				l <<= 3;
				j2 <<= 3;
				k2 <<= 3;
			}

			for(int i3 = 0; i3 <= l2; ++i3) {
				for(int k3 = 0; k3 <= this.regionSizeY; ++k3) {
					for(int i4 = 0; i4 <= this.regionSizeX; ++i4) {
						short c2;
						if ((this.anIntArrayArrayArray135[i3][i4][k3] & l) != 0) {
							i5 = k3;
							j6 = k3;
							k7 = i3;

							for(x = i3; i5 > 0 && (this.anIntArrayArrayArray135[i3][i4][i5 - 1] & l) != 0; --i5) {
							}

							while(j6 < this.regionSizeY && (this.anIntArrayArrayArray135[i3][i4][j6 + 1] & l) != 0) {
								++j6;
							}

							label374:
							while(k7 > 0) {
								for(i12 = i5; i12 <= j6; ++i12) {
									if ((this.anIntArrayArrayArray135[k7 - 1][i4][i12] & l) == 0) {
										break label374;
									}
								}

								--k7;
							}

							label363:
							while(x < l2) {
								for(i12 = i5; i12 <= j6; ++i12) {
									if ((this.anIntArrayArrayArray135[x + 1][i4][i12] & l) == 0) {
										break label363;
									}
								}

								++x;
							}

							i12 = (x + 1 - k7) * (j6 - i5 + 1);
							if (i12 >= 8) {
								c2 = 240;
								i15 = this.tileHeights[x][i4][i5] - c2;
								i16 = this.tileHeights[k7][i4][i5];
								WorldController.method277(l2, i4 * 128, i16, i4 * 128, j6 * 128 + 128, i15, i5 * 128, 1);

								for(i17 = k7; i17 <= x; ++i17) {
									for(i18 = i5; i18 <= j6; ++i18) {
										var10000 = this.anIntArrayArrayArray135[i17][i4];
										var10000[i18] &= ~l;
									}
								}
							}
						}

						if ((this.anIntArrayArrayArray135[i3][i4][k3] & j2) != 0) {
							i5 = i4;
							j6 = i4;
							k7 = i3;

							for(x = i3; i5 > 0 && (this.anIntArrayArrayArray135[i3][i5 - 1][k3] & j2) != 0; --i5) {
							}

							while(j6 < this.regionSizeX && (this.anIntArrayArrayArray135[i3][j6 + 1][k3] & j2) != 0) {
								++j6;
							}

							label427:
							while(k7 > 0) {
								for(i12 = i5; i12 <= j6; ++i12) {
									if ((this.anIntArrayArrayArray135[k7 - 1][i12][k3] & j2) == 0) {
										break label427;
									}
								}

								--k7;
							}

							label416:
							while(x < l2) {
								for(i12 = i5; i12 <= j6; ++i12) {
									if ((this.anIntArrayArrayArray135[x + 1][i12][k3] & j2) == 0) {
										break label416;
									}
								}

								++x;
							}

							i12 = (x + 1 - k7) * (j6 - i5 + 1);
							if (i12 >= 8) {
								c2 = 240;
								i15 = this.tileHeights[x][i5][k3] - c2;
								i16 = this.tileHeights[k7][i5][k3];
								WorldController.method277(l2, i5 * 128, i16, j6 * 128 + 128, k3 * 128, i15, k3 * 128, 2);

								for(i17 = k7; i17 <= x; ++i17) {
									for(i18 = i5; i18 <= j6; ++i18) {
										var10000 = this.anIntArrayArrayArray135[i17][i18];
										var10000[k3] &= ~j2;
									}
								}
							}
						}

						if ((this.anIntArrayArrayArray135[i3][i4][k3] & k2) != 0) {
							i5 = i4;
							j6 = i4;
							k7 = k3;

							for(x = k3; k7 > 0 && (this.anIntArrayArrayArray135[i3][i4][k7 - 1] & k2) != 0; --k7) {
							}

							while(x < this.regionSizeY && (this.anIntArrayArrayArray135[i3][i4][x + 1] & k2) != 0) {
								++x;
							}

							label480:
							while(i5 > 0) {
								for(i12 = k7; i12 <= x; ++i12) {
									if ((this.anIntArrayArrayArray135[i3][i5 - 1][i12] & k2) == 0) {
										break label480;
									}
								}

								--i5;
							}

							label469:
							while(j6 < this.regionSizeX) {
								for(i12 = k7; i12 <= x; ++i12) {
									if ((this.anIntArrayArrayArray135[i3][j6 + 1][i12] & k2) == 0) {
										break label469;
									}
								}

								++j6;
							}

							if ((j6 - i5 + 1) * (x - k7 + 1) >= 4) {
								i12 = this.tileHeights[i3][i5][k7];
								WorldController.method277(l2, i5 * 128, i12, j6 * 128 + 128, x * 128 + 128, i12, k7 * 128, 4);

								for(z = i5; z <= j6; ++z) {
									for(i15 = k7; i15 <= x; ++i15) {
										var10000 = this.anIntArrayArrayArray135[i3][z];
										var10000[i15] &= ~k2;
									}
								}
							}
						}
					}
				}
			}
		}

	}

	private int checkedLight(int color, int light) {
		if (color == -2) {
			return 12345678;
		} else if (color == -1) {
			if (light < 0) {
				light = 0;
			} else if (light > 127) {
				light = 127;
			}

			light = 127 - light;
			return light;
		} else {
			light = light * (color & 127) / 128;
			if (light < 2) {
				light = 2;
			} else if (light > 126) {
				light = 126;
			}

			return (color & 'ﾀ') + light;
		}
	}

	private static int calculateVertexHeight(int i, int j) {
		int mapHeight = interpolatedNoise(i + '넵', j + 91923, 4) - 128 + (interpolatedNoise(i + 10294, j + '鎽', 2) - 128 >> 1) + (interpolatedNoise(i, j, 1) - 128 >> 2);
		mapHeight = (int)((double)mapHeight * 0.3D) + 35;
		if (mapHeight < 10) {
			mapHeight = 10;
		} else if (mapHeight > 60) {
			mapHeight = 60;
		}

		return mapHeight;
	}

	private static int interpolatedNoise(int i, int j, int k) {
		int l = i / k;
		int i1 = i & k - 1;
		int j1 = j / k;
		int k1 = j & k - 1;
		int l1 = method186(l, j1);
		int i2 = method186(l + 1, j1);
		int j2 = method186(l, j1 + 1);
		int k2 = method186(l + 1, j1 + 1);
		int l2 = method184(l1, i2, i1, k);
		int i3 = method184(j2, k2, i1, k);
		return method184(l2, i3, k1, k);
	}

	public final void method171(CollisionMap[] aclass11, WorldController worldController) {
		int i2;
		int j2;
		int k2;
		int l2;
		for(i2 = 0; i2 < 4; ++i2) {
			for(j2 = 0; j2 < 104; ++j2) {
				for(k2 = 0; k2 < 104; ++k2) {
					if ((this.tileFlags[i2][j2][k2] & 1) == 1) {
						l2 = i2;
						if ((this.tileFlags[1][j2][k2] & 2) == 2) {
							l2 = i2 - 1;
						}

						if (l2 >= 0) {
							aclass11[l2].method213(k2, j2);
						}
					}
				}
			}
		}

		int i5;
		int j6;
		int k7;
		int i9;
		int j12;
		int k13;
		int i15;
		int i16;
		int i17;
		int i18;
		int[] var10000;
		for(i2 = 0; i2 < 4; ++i2) {
			byte[][] var41 = this.shading[i2];
			byte var42 = 96;
			short var43 = 768;
			byte i3 = -50;
			byte k3 = -10;
			byte i4 = -50;
			i5 = (int)Math.sqrt((double)(i3 * i3 + k3 * k3 + i4 * i4));
			j6 = var43 * i5 >> 8;

			int k18;
			int l18;
			for(k7 = 1; k7 < this.regionSizeY - 1; ++k7) {
				for(i9 = 1; i9 < this.regionSizeX - 1; ++i9) {
					j12 = this.tileHeights[i2][i9 + 1][k7] - this.tileHeights[i2][i9 - 1][k7];
					k13 = this.tileHeights[i2][i9][k7 + 1] - this.tileHeights[i2][i9][k7 - 1];
					i15 = (int)Math.sqrt((double)(j12 * j12 + 65536 + k13 * k13));
					i16 = (j12 << 8) / i15;
					i17 = 65536 / i15;
					i18 = (k13 << 8) / i15;
					k18 = var42 + (i3 * i16 + k3 * i17 + i4 * i18) / j6;
					l18 = (var41[i9 - 1][k7] >> 2) + (var41[i9 + 1][k7] >> 3) + (var41[i9][k7 - 1] >> 2) + (var41[i9][k7 + 1] >> 3) + (var41[i9][k7] >> 1);
					this.tileLighting[i9][k7] = k18 - l18;
				}
			}

			for(k7 = 0; k7 < this.regionSizeY; ++k7) {
				this.hues[k7] = 0;
				this.saturations[k7] = 0;
				this.luminances[k7] = 0;
				this.chromas[k7] = 0;
				this.anIntArray128[k7] = 0;
			}

			for(k7 = -5; k7 < this.regionSizeX + 5; ++k7) {
				for(i9 = 0; i9 < this.regionSizeY; ++i9) {
					j12 = k7 + 5;
					int var10002;
					FloorDefinition var48;
					if (j12 >= 0 && j12 < this.regionSizeX) {
						k13 = this.underlays[i2][j12][i9] & 255;
						if (k13 > 0) {
							if (k13 > FloorDefinition.underlays.length) {
								k13 = FloorDefinition.underlays.length;
							}

							var48 = FloorDefinition.underlays[k13 - 1];
							var10000 = this.hues;
							var10000[i9] += var48.blendHue;
							var10000 = this.saturations;
							var10000[i9] += var48.saturation;
							var10000 = this.luminances;
							var10000[i9] += var48.lumiance;
							var10000 = this.chromas;
							var10000[i9] += var48.blendHueMultiplier;
							var10002 = this.anIntArray128[i9]++;
						}
					}

					k13 = k7 - 5;
					if (k13 >= 0 && k13 < this.regionSizeX) {
						i15 = this.underlays[i2][k13][i9] & 255;
						if (i15 > 0) {
							var48 = FloorDefinition.underlays[i15 - 1];
							var10000 = this.hues;
							var10000[i9] -= var48.blendHue;
							var10000 = this.saturations;
							var10000[i9] -= var48.saturation;
							var10000 = this.luminances;
							var10000[i9] -= var48.lumiance;
							var10000 = this.chromas;
							var10000[i9] -= var48.blendHueMultiplier;
							var10002 = this.anIntArray128[i9]--;
						}
					}
				}

				if (k7 >= 1 && k7 < this.regionSizeX - 1) {
					i9 = 0;
					j12 = 0;
					k13 = 0;
					i15 = 0;
					i16 = 0;

					for(i17 = -5; i17 < this.regionSizeY + 5; ++i17) {
						i18 = i17 + 5;
						if (i18 >= 0 && i18 < this.regionSizeY) {
							i9 += this.hues[i18];
							j12 += this.saturations[i18];
							k13 += this.luminances[i18];
							i15 += this.chromas[i18];
							i16 += this.anIntArray128[i18];
						}

						k18 = i17 - 5;
						if (k18 >= 0 && k18 < this.regionSizeY) {
							i9 -= this.hues[k18];
							j12 -= this.saturations[k18];
							k13 -= this.luminances[k18];
							i15 -= this.chromas[k18];
							i16 -= this.anIntArray128[k18];
						}

						if (i17 >= 1 && i17 < this.regionSizeY - 1 && (!lowMem || (this.tileFlags[0][k7][i17] & 2) != 0 || (this.tileFlags[i2][k7][i17] & 16) == 0 && this.method182(i17, i2, k7) == anInt131)) {
							if (i2 < maximumPlane) {
								maximumPlane = i2;
							}

							l18 = this.underlays[i2][k7][i17] & 255;
							int i19 = this.overlays[i2][k7][i17] & 255;
							if (l18 > 0 || i19 > 0) {
								int j19 = this.tileHeights[i2][k7][i17];
								int k19 = this.tileHeights[i2][k7 + 1][i17];
								int l19 = this.tileHeights[i2][k7 + 1][i17 + 1];
								int i20 = this.tileHeights[i2][k7][i17 + 1];
								int j20 = this.tileLighting[k7][i17];
								int k20 = this.tileLighting[k7 + 1][i17];
								int l20 = this.tileLighting[k7 + 1][i17 + 1];
								int i21 = this.tileLighting[k7][i17 + 1];
								int j21 = -1;
								int k21 = -1;
								int i22;
								int k22;
								if (l18 > 0) {
									i22 = i9 * 256 / i15;
									k22 = j12 / i16;
									int byte4 = k13 / i16;
									j21 = this.method177(i22, k22, byte4);
									if (byte4 < 0) {
										byte4 = 0;
									} else if (byte4 > 255) {
										byte4 = 255;
									}

									k21 = this.method177(i22, k22, byte4);
								}

								if (i2 > 0) {
									boolean var50 = true;
									if (l18 == 0 && this.overlayTypes[i2][k7][i17] != 0) {
										var50 = false;
									}

									if (i19 > 0 && !FloorDefinition.overlays[i19 - 1].occlude) {
										var50 = false;
									}

									if (var50 && j19 == k19 && j19 == l19 && j19 == i20) {
										var10000 = this.anIntArrayArrayArray135[i2][k7];
										var10000[i17] |= 2340;
									}
								}

								i22 = 0;
								if (j21 != -1) {
									i22 = Rasterizer.anIntArray1482[method187(k21, 96)];
								}

								if (i19 == 0) {
									worldController.method279(i2, k7, i17, 0, 0, -1, 154, j19, k19, l19, i20, method187(j21, j20), method187(j21, k20), method187(j21, l20), method187(j21, i21), 0, 0, 0, 0, i22, 0, false);
								} else {
									k22 = this.overlayTypes[i2][k7][i17] + 1;
									byte var51 = this.overlayOrientations[i2][k7][i17];
									if (i19 - 1 > FloorDefinition.overlays.length) {
										i19 = FloorDefinition.overlays.length;
									}

									FloorDefinition overlay_flo = FloorDefinition.overlays[i19 - 1];
									int textureId = overlay_flo.texture;
									if (textureId == 51) {
										textureId = 3;
									}

									if (textureId == 43) {
										textureId = 42;
									}

									if (textureId > 50) {
										textureId = -1;
									}

									int j23;
									int k23;
									if (textureId >= 0) {
										k23 = Rasterizer.method369(textureId);
										j23 = -1;
									} else if (overlay_flo.rgb == 16711935) {
										k23 = 0;
										j23 = -2;
									} else if (overlay_flo.rgb == 3355443) {
										k23 = Rasterizer.anIntArray1482[this.method185(overlay_flo.hsl16, 96)];
										j23 = -2;
									} else {
										j23 = this.method177(overlay_flo.hue, overlay_flo.saturation, overlay_flo.lumiance);
										k23 = Rasterizer.anIntArray1482[this.method185(overlay_flo.hsl16, 96)];
									}

									if (k23 == 0 && overlay_flo.anotherRgb != -1) {
										int temporaryMinimapColor = hslToRgb(overlay_flo.anotherHue, overlay_flo.anotherSaturation, overlay_flo.anotherLuminance);
										k23 = Rasterizer.anIntArray1482[swag(temporaryMinimapColor, 96)];
									}

									this.colors.add(k23);
									if (textureId == -1) {
										textureId = 154;
									}

									worldController.method279(i2, k7, i17, k22, var51, textureId, 154, j19, k19, l19, i20, method187(j21, j20), method187(j21, k20), method187(j21, l20), method187(j21, i21), this.method185(j23, j20), this.method185(j23, k20), this.method185(j23, l20), this.method185(j23, i21), i22, k23, textureId >= 0 && textureId <= 50);
								}
							}
						}
					}
				}
			}

			for(k7 = 1; k7 < this.regionSizeY - 1; ++k7) {
				for(i9 = 1; i9 < this.regionSizeX - 1; ++i9) {
					worldController.method278(i2, i9, k7, this.method182(k7, i2, i9));
				}
			}
		}

		worldController.method305(-10, -50, -50);

		for(i2 = 0; i2 < this.regionSizeX; ++i2) {
			for(j2 = 0; j2 < this.regionSizeY; ++j2) {
				if ((this.tileFlags[1][i2][j2] & 2) == 2) {
					worldController.method276(j2, i2);
				}
			}
		}

		i2 = 1;
		j2 = 2;
		k2 = 4;

		for(l2 = 0; l2 < 4; ++l2) {
			if (l2 > 0) {
				i2 <<= 3;
				j2 <<= 3;
				k2 <<= 3;
			}

			for(int var44 = 0; var44 <= l2; ++var44) {
				for(int var45 = 0; var45 <= this.regionSizeY; ++var45) {
					for(int var46 = 0; var46 <= this.regionSizeX; ++var46) {
						short var49;
						if ((this.anIntArrayArrayArray135[var44][var46][var45] & i2) != 0) {
							i5 = var45;
							j6 = var45;
							k7 = var44;

							for(i9 = var44; i5 > 0 && (this.anIntArrayArrayArray135[var44][var46][i5 - 1] & i2) != 0; --i5) {
							}

							while(j6 < this.regionSizeY && (this.anIntArrayArrayArray135[var44][var46][j6 + 1] & i2) != 0) {
								++j6;
							}

							label330:
							while(k7 > 0) {
								for(j12 = i5; j12 <= j6; ++j12) {
									if ((this.anIntArrayArrayArray135[k7 - 1][var46][j12] & i2) == 0) {
										break label330;
									}
								}

								--k7;
							}

							label319:
							while(i9 < l2) {
								for(j12 = i5; j12 <= j6; ++j12) {
									if ((this.anIntArrayArrayArray135[i9 + 1][var46][j12] & i2) == 0) {
										break label319;
									}
								}

								++i9;
							}

							j12 = (i9 + 1 - k7) * (j6 - i5 + 1);
							if (j12 >= 8) {
								var49 = 240;
								i15 = this.tileHeights[i9][var46][i5] - var49;
								i16 = this.tileHeights[k7][var46][i5];
								WorldController.method277(l2, var46 * 128, i16, var46 * 128, j6 * 128 + 128, i15, i5 * 128, 1);

								for(i17 = k7; i17 <= i9; ++i17) {
									for(i18 = i5; i18 <= j6; ++i18) {
										var10000 = this.anIntArrayArrayArray135[i17][var46];
										var10000[i18] &= ~i2;
									}
								}
							}
						}

						if ((this.anIntArrayArrayArray135[var44][var46][var45] & j2) != 0) {
							i5 = var46;
							j6 = var46;
							k7 = var44;

							for(i9 = var44; i5 > 0 && (this.anIntArrayArrayArray135[var44][i5 - 1][var45] & j2) != 0; --i5) {
							}

							while(j6 < this.regionSizeX && (this.anIntArrayArrayArray135[var44][j6 + 1][var45] & j2) != 0) {
								++j6;
							}

							label383:
							while(k7 > 0) {
								for(j12 = i5; j12 <= j6; ++j12) {
									if ((this.anIntArrayArrayArray135[k7 - 1][j12][var45] & j2) == 0) {
										break label383;
									}
								}

								--k7;
							}

							label372:
							while(i9 < l2) {
								for(j12 = i5; j12 <= j6; ++j12) {
									if ((this.anIntArrayArrayArray135[i9 + 1][j12][var45] & j2) == 0) {
										break label372;
									}
								}

								++i9;
							}

							j12 = (i9 + 1 - k7) * (j6 - i5 + 1);
							if (j12 >= 8) {
								var49 = 240;
								i15 = this.tileHeights[i9][i5][var45] - var49;
								i16 = this.tileHeights[k7][i5][var45];
								WorldController.method277(l2, i5 * 128, i16, j6 * 128 + 128, var45 * 128, i15, var45 * 128, 2);

								for(i17 = k7; i17 <= i9; ++i17) {
									for(i18 = i5; i18 <= j6; ++i18) {
										var10000 = this.anIntArrayArrayArray135[i17][i18];
										var10000[var45] &= ~j2;
									}
								}
							}
						}

						if ((this.anIntArrayArrayArray135[var44][var46][var45] & k2) != 0) {
							i5 = var46;
							j6 = var46;
							k7 = var45;

							for(i9 = var45; k7 > 0 && (this.anIntArrayArrayArray135[var44][var46][k7 - 1] & k2) != 0; --k7) {
							}

							while(i9 < this.regionSizeY && (this.anIntArrayArrayArray135[var44][var46][i9 + 1] & k2) != 0) {
								++i9;
							}

							label436:
							while(i5 > 0) {
								for(j12 = k7; j12 <= i9; ++j12) {
									if ((this.anIntArrayArrayArray135[var44][i5 - 1][j12] & k2) == 0) {
										break label436;
									}
								}

								--i5;
							}

							label425:
							while(j6 < this.regionSizeX) {
								for(j12 = k7; j12 <= i9; ++j12) {
									if ((this.anIntArrayArrayArray135[var44][j6 + 1][j12] & k2) == 0) {
										break label425;
									}
								}

								++j6;
							}

							if ((j6 - i5 + 1) * (i9 - k7 + 1) >= 4) {
								j12 = this.tileHeights[var44][i5][k7];
								WorldController.method277(l2, i5 * 128, j12, j6 * 128 + 128, i9 * 128 + 128, j12, k7 * 128, 4);

								for(k13 = i5; k13 <= j6; ++k13) {
									for(i15 = k7; i15 <= i9; ++i15) {
										var10000 = this.anIntArrayArrayArray135[var44][k13];
										var10000[i15] &= ~k2;
									}
								}
							}
						}
					}
				}
			}
		}

	}

	static final int hslToRgb(int var0, int var1, int var2) {
		if (var2 > 179) {
			var1 /= 2;
		}

		if (var2 > 192) {
			var1 /= 2;
		}

		if (var2 > 217) {
			var1 /= 2;
		}

		if (var2 > 243) {
			var1 /= 2;
		}

		int var3 = var2 / 2 + (var0 / 4 << 10) + (var1 / 32 << 7);
		return var3;
	}

	static final int swag(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = var1 * (var0 & 127) / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1 + (var0 & 'ﾀ');
		}
	}

	private static int method172(int i, int j) {
		int plane = method176(i + '넵', j + 91923, 4) - 128 + (method176(i + 10294, j + '鎽', 2) - 128 >> 1) + (method176(i, j, 1) - 128 >> 2);
		plane = (int)((double)plane * 0.3D) + 35;
		if (plane < 10) {
			plane = 10;
		} else if (plane > 60) {
			plane = 60;
		}

		return plane;
	}

	public static void method173(Buffer stream, OnDemandFetcher class42_sub1) {
		int i = -1;

		while(true) {
			int j = stream.method422();
			if (j == 0) {
				return;
			}

			i += j;
			ObjectDefinition class46 = ObjectDefinition.forID(i);
			class46.method574(class42_sub1);

			while(true) {
				int plane = stream.method422();
				if (plane == 0) {
					break;
				}

				stream.readUnsignedByte();
			}
		}
	}

	public final void method174(int i, int j, int regionX, int i1) {
		for(int j1 = i; j1 <= i + j; ++j1) {
			for(int k1 = i1; k1 <= i1 + regionX; ++k1) {
				if (k1 >= 0 && k1 < this.regionSizeX && j1 >= 0 && j1 < this.regionSizeY) {
					this.shading[0][k1][j1] = 127;
					if (k1 == i1 && k1 > 0) {
						this.tileHeights[0][k1][j1] = this.tileHeights[0][k1 - 1][j1];
					}

					if (k1 == i1 + regionX && k1 < this.regionSizeX - 1) {
						this.tileHeights[0][k1][j1] = this.tileHeights[0][k1 + 1][j1];
					}

					if (j1 == i && j1 > 0) {
						this.tileHeights[0][k1][j1] = this.tileHeights[0][k1][j1 - 1];
					}

					if (j1 == i + j && j1 < this.regionSizeY - 1) {
						this.tileHeights[0][k1][j1] = this.tileHeights[0][k1][j1 + 1];
					}
				}
			}
		}

	}

	private void method175(int regionY, WorldController worldController, CollisionMap class11, int type, int plane, int regionX, int objId, int j1) {
		if (lowMem && (this.tileFlags[0][regionX][regionY] & 2) == 0) {
			if ((this.tileFlags[plane][regionX][regionY] & 16) != 0) {
				return;
			}

			if (this.method182(regionY, plane, regionX) != anInt131) {
				return;
			}
		}

		if (plane < maximumPlane) {
			maximumPlane = plane;
		}

		ObjectDefinition class46 = ObjectDefinition.forID(objId);
		int size1;
		int size2;
		if (j1 != 1 && j1 != 3) {
			size1 = class46.width;
			size2 = class46.length;
		} else {
			size1 = class46.length;
			size2 = class46.width;
		}

		int modX;
		int modX1;
		if (104 >= size1 + regionX) {
			modX1 = regionX + (size1 + 1 >> 1);
			modX = regionX + (size1 >> 1);
		} else {
			modX = regionX;
			modX1 = regionX + 1;
		}

		int modY;
		int modY1;
		if (104 >= size2 + regionY) {
			modY1 = regionY + (size2 + 1 >> 1);
			modY = (size2 >> 1) + regionY;
		} else {
			modY = regionY;
			modY1 = 1 + regionY;
		}

		int a_y = this.tileHeights[plane][modX][modY];
		int b_y = this.tileHeights[plane][modX1][modY];
		int d_y = this.tileHeights[plane][modX1][modY1];
		int c_y = this.tileHeights[plane][modX][modY1];
		int k2 = a_y + b_y + d_y + c_y >> 2;
		int l2 = regionX + (regionY << 7) + ((objId > 32767 ? objId & 32767 : objId) << 14) + 1073741824;
		if (class46.interactive == 0) {
			l2 += -2147483648;
		}

		byte byte0 = (byte)((j1 << 6) + type);
		Object obj10;
		if (type == 22) {
			if (!lowMem || class46.interactive != 0 || class46.obstructsGround) {
				if (class46.animation == -1 && class46.morphisms == null) {
					obj10 = class46.method578(22, j1, a_y, b_y, d_y, c_y, -1);
				} else {
					obj10 = new Animable_Sub5(objId, j1, 22, b_y, d_y, a_y, c_y, class46.animation, true);
				}

				worldController.method280(plane, k2, regionY, (Animable)obj10, byte0, l2, regionX, objId);
				if (class46.solid && class46.interactive != 0 && class11 != null) {
					class11.method213(regionY, regionX);
				}
			}
		} else {
			int k4;
			int var31;
			if (type == 10 || type == 11) {
				if (class46.animation == -1 && class46.morphisms == null) {
					obj10 = class46.method578(10, j1, a_y, b_y, d_y, c_y, -1);
				} else {
					obj10 = new Animable_Sub5(objId, j1, 10, b_y, d_y, a_y, c_y, class46.animation, true);
				}

				if (obj10 != null) {
					k4 = 0;
					if (type == 11) {
						k4 += 256;
					}

					int l4;
					if (j1 != 1 && j1 != 3) {
						var31 = class46.width;
						l4 = class46.length;
					} else {
						var31 = class46.length;
						l4 = class46.width;
					}

					if (worldController.method284(l2, byte0, k2, l4, (Animable)obj10, var31, plane, k4, regionY, regionX, objId) && class46.castsShadow) {
						Model model;
						if (obj10 instanceof Model) {
							model = (Model)obj10;
						} else {
							model = class46.method578(10, j1, a_y, b_y, d_y, c_y, -1);
						}

						if (model != null) {
							for(int j5 = 0; j5 <= var31; ++j5) {
								for(int k5 = 0; k5 <= l4; ++k5) {
									int l5 = model.anInt1650 / 4;
									if (l5 > 30) {
										l5 = 30;
									}

									if (l5 > this.shading[plane][regionX + j5][regionY + k5]) {
										this.shading[plane][regionX + j5][regionY + k5] = (byte)l5;
									}
								}
							}
						}
					}
				}

				if (class46.solid && class11 != null) {
					class11.method212(class46.impenetrable, class46.width, class46.length, regionX, regionY, j1);
				}

				return;
			}

			int[] var10000;
			if (type >= 12) {
				if (class46.animation == -1 && class46.morphisms == null) {
					obj10 = class46.method578(type, j1, a_y, b_y, d_y, c_y, -1);
				} else {
					obj10 = new Animable_Sub5(objId, j1, type, b_y, d_y, a_y, c_y, class46.animation, true);
				}

				worldController.method284(l2, byte0, k2, 1, (Animable)obj10, 1, plane, 0, regionY, regionX, objId);
				if (type >= 12 && type <= 17 && type != 13 && plane > 0) {
					var10000 = this.anIntArrayArrayArray135[plane][regionX];
					var10000[regionY] |= 2340;
				}

				if (class46.solid && class11 != null) {
					class11.method212(class46.impenetrable, class46.width, class46.length, regionX, regionY, j1);
				}
			} else if (type == 0) {
				if (class46.animation == -1 && class46.morphisms == null) {
					obj10 = class46.method578(0, j1, a_y, b_y, d_y, c_y, -1);
				} else {
					obj10 = new Animable_Sub5(objId, j1, 0, b_y, d_y, a_y, c_y, class46.animation, true);
				}

				worldController.method282(anIntArray152[j1], (Animable)obj10, l2, regionY, byte0, regionX, (Animable)null, k2, 0, plane, objId);
				if (j1 == 0) {
					if (class46.castsShadow) {
						this.shading[plane][regionX][regionY] = 50;
						this.shading[plane][regionX][regionY + 1] = 50;
					}

					if (class46.modelClipped) {
						var10000 = this.anIntArrayArrayArray135[plane][regionX];
						var10000[regionY] |= 585;
					}
				} else if (j1 == 1) {
					if (class46.castsShadow) {
						this.shading[plane][regionX][regionY + 1] = 50;
						this.shading[plane][regionX + 1][regionY + 1] = 50;
					}

					if (class46.modelClipped) {
						var10000 = this.anIntArrayArrayArray135[plane][regionX];
						var10000[regionY + 1] |= 1170;
					}
				} else if (j1 == 2) {
					if (class46.castsShadow) {
						this.shading[plane][regionX + 1][regionY] = 50;
						this.shading[plane][regionX + 1][regionY + 1] = 50;
					}

					if (class46.modelClipped) {
						var10000 = this.anIntArrayArrayArray135[plane][regionX + 1];
						var10000[regionY] |= 585;
					}
				} else if (j1 == 3) {
					if (class46.castsShadow) {
						this.shading[plane][regionX][regionY] = 50;
						this.shading[plane][regionX + 1][regionY] = 50;
					}

					if (class46.modelClipped) {
						var10000 = this.anIntArrayArrayArray135[plane][regionX];
						var10000[regionY] |= 1170;
					}
				}

				if (class46.solid && class11 != null) {
					class11.method211(regionY, j1, regionX, type, class46.impenetrable);
				}

				if (class46.decorDisplacement != 16) {
					worldController.method290(regionY, class46.decorDisplacement, regionX, plane);
				}
			} else if (type == 1) {
				if (class46.animation == -1 && class46.morphisms == null) {
					obj10 = class46.method578(1, j1, a_y, b_y, d_y, c_y, -1);
				} else {
					obj10 = new Animable_Sub5(objId, j1, 1, b_y, d_y, a_y, c_y, class46.animation, true);
				}

				worldController.method282(anIntArray140[j1], (Animable)obj10, l2, regionY, byte0, regionX, (Animable)null, k2, 0, plane, objId);
				if (class46.castsShadow) {
					if (j1 == 0) {
						this.shading[plane][regionX][regionY + 1] = 50;
					} else if (j1 == 1) {
						this.shading[plane][regionX + 1][regionY + 1] = 50;
					} else if (j1 == 2) {
						this.shading[plane][regionX + 1][regionY] = 50;
					} else if (j1 == 3) {
						this.shading[plane][regionX][regionY] = 50;
					}
				}

				if (class46.solid && class11 != null) {
					class11.method211(regionY, j1, regionX, type, class46.impenetrable);
				}
			} else {
				Object var33;
				if (type == 2) {
					var31 = j1 + 1 & 3;
					Object var32;
					if (class46.animation == -1 && class46.morphisms == null) {
						var32 = class46.method578(2, 4 + j1, a_y, b_y, d_y, c_y, -1);
						var33 = class46.method578(2, var31, a_y, b_y, d_y, c_y, -1);
					} else {
						var32 = new Animable_Sub5(objId, 4 + j1, 2, b_y, d_y, a_y, c_y, class46.animation, true);
						var33 = new Animable_Sub5(objId, var31, 2, b_y, d_y, a_y, c_y, class46.animation, true);
					}

					worldController.method282(anIntArray152[j1], (Animable)var32, l2, regionY, byte0, regionX, (Animable)var33, k2, anIntArray152[var31], plane, objId);
					if (class46.modelClipped) {
						if (j1 == 0) {
							var10000 = this.anIntArrayArrayArray135[plane][regionX];
							var10000[regionY] |= 585;
							var10000 = this.anIntArrayArrayArray135[plane][regionX];
							var10000[regionY + 1] |= 1170;
						} else if (j1 == 1) {
							var10000 = this.anIntArrayArrayArray135[plane][regionX];
							var10000[regionY + 1] |= 1170;
							var10000 = this.anIntArrayArrayArray135[plane][regionX + 1];
							var10000[regionY] |= 585;
						} else if (j1 == 2) {
							var10000 = this.anIntArrayArrayArray135[plane][regionX + 1];
							var10000[regionY] |= 585;
							var10000 = this.anIntArrayArrayArray135[plane][regionX];
							var10000[regionY] |= 1170;
						} else if (j1 == 3) {
							var10000 = this.anIntArrayArrayArray135[plane][regionX];
							var10000[regionY] |= 1170;
							var10000 = this.anIntArrayArrayArray135[plane][regionX];
							var10000[regionY] |= 585;
						}
					}

					if (class46.solid && class11 != null) {
						class11.method211(regionY, j1, regionX, type, class46.impenetrable);
					}

					if (class46.decorDisplacement != 16) {
						worldController.method290(regionY, class46.decorDisplacement, regionX, plane);
					}
				} else if (type == 3) {
					if (class46.animation == -1 && class46.morphisms == null) {
						obj10 = class46.method578(3, j1, a_y, b_y, d_y, c_y, -1);
					} else {
						obj10 = new Animable_Sub5(objId, j1, 3, b_y, d_y, a_y, c_y, class46.animation, true);
					}

					worldController.method282(anIntArray140[j1], (Animable)obj10, l2, regionY, byte0, regionX, (Animable)null, k2, 0, plane, objId);
					if (class46.castsShadow) {
						if (j1 == 0) {
							this.shading[plane][regionX][regionY + 1] = 50;
						} else if (j1 == 1) {
							this.shading[plane][regionX + 1][regionY + 1] = 50;
						} else if (j1 == 2) {
							this.shading[plane][regionX + 1][regionY] = 50;
						} else if (j1 == 3) {
							this.shading[plane][regionX][regionY] = 50;
						}
					}

					if (class46.solid && class11 != null) {
						class11.method211(regionY, j1, regionX, type, class46.impenetrable);
					}
				} else if (type == 9) {
					if (class46.animation == -1 && class46.morphisms == null) {
						obj10 = class46.method578(type, j1, a_y, b_y, d_y, c_y, -1);
					} else {
						obj10 = new Animable_Sub5(objId, j1, type, b_y, d_y, a_y, c_y, class46.animation, true);
					}

					worldController.method284(l2, byte0, k2, 1, (Animable)obj10, 1, plane, 0, regionY, regionX, objId);
					if (class46.solid && class11 != null) {
						class11.method212(class46.impenetrable, class46.width, class46.length, regionX, regionY, j1);
					}
				} else {
					if (class46.contouredGround) {
						if (j1 == 1) {
							var31 = c_y;
							c_y = d_y;
							d_y = b_y;
							b_y = a_y;
							a_y = var31;
						} else if (j1 == 2) {
							var31 = c_y;
							c_y = b_y;
							b_y = var31;
							var31 = d_y;
							d_y = a_y;
							a_y = var31;
						} else if (j1 == 3) {
							var31 = c_y;
							c_y = a_y;
							a_y = b_y;
							b_y = d_y;
							d_y = var31;
						}
					}

					if (type == 4) {
						if (class46.animation == -1 && class46.morphisms == null) {
							obj10 = class46.method578(4, 0, a_y, b_y, d_y, c_y, -1);
						} else {
							obj10 = new Animable_Sub5(objId, 0, 4, b_y, d_y, a_y, c_y, class46.animation, true);
						}

						worldController.method283(l2, regionY, j1 * 512, plane, 0, k2, (Animable)obj10, regionX, byte0, 0, anIntArray152[j1]);
					} else if (type == 5) {
						var31 = 16;
						k4 = worldController.method300(plane, regionX, regionY);
						if (k4 > 0) {
							var31 = ObjectDefinition.forID(k4 >> 14 & 32767).decorDisplacement;
						}

						if (class46.animation == -1 && class46.morphisms == null) {
							var33 = class46.method578(4, 0, a_y, b_y, d_y, c_y, -1);
						} else {
							var33 = new Animable_Sub5(objId, 0, 4, b_y, d_y, a_y, c_y, class46.animation, true);
						}

						worldController.method283(l2, regionY, j1 * 512, plane, anIntArray137[j1] * var31, k2, (Animable)var33, regionX, byte0, anIntArray144[j1] * var31, anIntArray152[j1]);
					} else if (type == 6) {
						if (class46.animation == -1 && class46.morphisms == null) {
							obj10 = class46.method578(4, 0, a_y, b_y, d_y, c_y, -1);
						} else {
							obj10 = new Animable_Sub5(objId, 0, 4, b_y, d_y, a_y, c_y, class46.animation, true);
						}

						worldController.method283(l2, regionY, j1, plane, 0, k2, (Animable)obj10, regionX, byte0, 0, 256);
					} else if (type == 7) {
						if (class46.animation == -1 && class46.morphisms == null) {
							obj10 = class46.method578(4, 0, a_y, b_y, d_y, c_y, -1);
						} else {
							obj10 = new Animable_Sub5(objId, 0, 4, b_y, d_y, a_y, c_y, class46.animation, true);
						}

						worldController.method283(l2, regionY, j1, plane, 0, k2, (Animable)obj10, regionX, byte0, 0, 512);
					} else if (type == 8) {
						if (class46.animation == -1 && class46.morphisms == null) {
							obj10 = class46.method578(4, 0, a_y, b_y, d_y, c_y, -1);
						} else {
							obj10 = new Animable_Sub5(objId, 0, 4, b_y, d_y, a_y, c_y, class46.animation, true);
						}

						worldController.method283(l2, regionY, j1, plane, 0, k2, (Animable)obj10, regionX, byte0, 0, 768);
					}
				}
			}
		}

	}

	private static int method176(int i, int j, int plane) {
		int regionX = i / plane;
		int i1 = i & plane - 1;
		int j1 = j / plane;
		int k1 = j & plane - 1;
		int l1 = method186(regionX, j1);
		int i2 = method186(regionX + 1, j1);
		int j2 = method186(regionX, j1 + 1);
		int k2 = method186(regionX + 1, j1 + 1);
		int l2 = method184(l1, i2, i1, plane);
		int i3 = method184(j2, k2, i1, plane);
		return method184(l2, i3, k1, plane);
	}

	private int method177(int i, int j, int plane) {
		if (plane > 179) {
			j /= 2;
		}

		if (plane > 192) {
			j /= 2;
		}

		if (plane > 217) {
			j /= 2;
		}

		if (plane > 243) {
			j /= 2;
		}

		return (i / 4 << 10) + (j / 32 << 7) + plane / 2;
	}

	public static boolean method178(int i, int j) {
		ObjectDefinition class46 = ObjectDefinition.forID(i);
		if (j == 11) {
			j = 10;
		}

		if (j >= 5 && j <= 8) {
			j = 4;
		}

		return class46.method577(j);
	}

	public final void method179(int i, int j, CollisionMap[] aclass11, int regionX, int i1, byte[] abyte0, int j1, int k1, int l1) {
		int l2;
		for(int stream = 0; stream < 8; ++stream) {
			for(l2 = 0; l2 < 8; ++l2) {
				if (regionX + stream > 0 && regionX + stream < 103 && l1 + l2 > 0 && l1 + l2 < 103) {
					int[] var10000 = aclass11[k1].anIntArrayArray294[regionX + stream];
					var10000[l1 + l2] &= -16777217;
				}
			}
		}

		Buffer var14 = new Buffer(abyte0);

		for(l2 = 0; l2 < 4; ++l2) {
			for(int i3 = 0; i3 < 64; ++i3) {
				for(int j3 = 0; j3 < 64; ++j3) {
					if (l2 == i && i3 >= i1 && i3 < i1 + 8 && j3 >= j1 && j3 < j1 + 8) {
						this.method181(l1 + Class4.method156(j3 & 7, j, i3 & 7), 0, var14, regionX + Class4.method155(j, j3 & 7, i3 & 7), k1, j, 0);
					} else {
						this.method181(-1, 0, var14, -1, 0, 0, 0);
					}
				}
			}
		}

	}

	public final void method180(byte[] abyte0, int i, int j, int plane, int regionX, CollisionMap[] aclass11) {
		int l1;
		int i2;
		for(int stream = 0; stream < 4; ++stream) {
			for(l1 = 0; l1 < 64; ++l1) {
				for(i2 = 0; i2 < 64; ++i2) {
					if (j + l1 > 0 && j + l1 < 103 && i + i2 > 0 && i + i2 < 103) {
						int[] var10000 = aclass11[stream].anIntArrayArray294[j + l1];
						var10000[i + i2] &= -16777217;
					}
				}
			}
		}

		Buffer var11 = new Buffer(abyte0);

		for(l1 = 0; l1 < 4; ++l1) {
			for(i2 = 0; i2 < 64; ++i2) {
				for(int j2 = 0; j2 < 64; ++j2) {
					this.method181(j2 + i, regionX, var11, i2 + j, l1, 0, plane);
				}
			}
		}

	}

	private void method181(int i, int j, Buffer stream, int plane, int regionX, int i1, int k1) {
		int i2;
		if (plane >= 0 && plane < 104 && i >= 0 && i < 104) {
			this.tileFlags[regionX][plane][i] = 0;

			while(true) {
				i2 = stream.readUnsignedByte();
				if (i2 == 0) {
					if (regionX == 0) {
						this.tileHeights[0][plane][i] = -method172(932731 + plane + k1, 556238 + i + j) * 8;
						return;
					} else {
						this.tileHeights[regionX][plane][i] = this.tileHeights[regionX - 1][plane][i] - 240;
						return;
					}
				}

				if (i2 == 1) {
					int j2 = stream.readUnsignedByte();
					if (j2 == 1) {
						j2 = 0;
					}

					if (regionX == 0) {
						this.tileHeights[0][plane][i] = -j2 * 8;
						return;
					}

					this.tileHeights[regionX][plane][i] = this.tileHeights[regionX - 1][plane][i] - j2 * 8;
					return;
				}

				if (i2 <= 49) {
					this.overlays[regionX][plane][i] = stream.readSignedByte();
					this.overlayTypes[regionX][plane][i] = (byte)((i2 - 2) / 4);
					this.overlayOrientations[regionX][plane][i] = (byte)(i2 - 2 + i1 & 3);
				} else if (i2 <= 81) {
					this.tileFlags[regionX][plane][i] = (byte)(i2 - 49);
				} else {
					this.underlays[regionX][plane][i] = (byte)(i2 - 81);
				}
			}
		} else {
			while(true) {
				i2 = stream.readUnsignedByte();
				if (i2 == 0) {
					return;
				}

				if (i2 == 1) {
					stream.readUnsignedByte();
					return;
				}

				if (i2 <= 49) {
					stream.readUnsignedByte();
				}
			}
		}
	}

	private int method182(int i, int j, int plane) {
		return (this.tileFlags[j][plane][i] & 8) != 0 ? 0 : (j > 0 && (this.tileFlags[1][plane][i] & 2) != 0 ? j - 1 : j);
	}

	public final void method183(CollisionMap[] aclass11, WorldController worldController, int i, int j, int plane, int regionX, byte[] abyte0, int i1, int j1, int k1) {
		Buffer stream = new Buffer(abyte0);
		int l1 = -1;

		while(true) {
			int i2 = stream.method422();
			if (i2 == 0) {
				return;
			}

			l1 += i2;
			int j2 = 0;

			while(true) {
				int k2 = stream.method422();
				if (k2 == 0) {
					break;
				}

				j2 += k2 - 1;
				int l2 = j2 & 63;
				int i3 = j2 >> 6 & 63;
				int j3 = j2 >> 12;
				int k3 = stream.readUnsignedByte();
				int l3 = k3 >> 2;
				int i4 = k3 & 3;
				if (j3 == i && i3 >= i1 && i3 < i1 + 8 && l2 >= plane && l2 < plane + 8) {
					ObjectDefinition class46 = ObjectDefinition.forID(l1);
					int j4 = j + Class4.method157(j1, class46.length, i3 & 7, l2 & 7, class46.width);
					int k4 = k1 + Class4.method158(l2 & 7, class46.length, j1, class46.width, i3 & 7);
					if (j4 > 0 && k4 > 0 && j4 < 103 && k4 < 103) {
						int l4 = j3;
						if ((this.tileFlags[1][j4][k4] & 2) == 2) {
							l4 = j3 - 1;
						}

						CollisionMap class11 = null;
						if (l4 >= 0) {
							class11 = aclass11[l4];
						}

						this.method175(k4, worldController, class11, l3, regionX, j4, l1, i4 + j1 & 3);
					}
				}
			}
		}
	}

	private static int method184(int i, int j, int plane, int regionX) {
		int i1 = 65536 - Rasterizer.anIntArray1471[plane * 1024 / regionX] >> 1;
		return (i * (65536 - i1) >> 16) + (j * i1 >> 16);
	}

	private int method185(int i, int j) {
		if (i == -2) {
			return 12345678;
		} else if (i == -1) {
			if (j < 0) {
				j = 0;
			} else if (j > 127) {
				j = 127;
			}

			j = 127 - j;
			return j;
		} else {
			j = j * (i & 127) / 128;
			if (j < 2) {
				j = 2;
			} else if (j > 126) {
				j = 126;
			}

			return (i & 'ﾀ') + j;
		}
	}

	private static int method186(int i, int j) {
		int plane = method170(i - 1, j - 1) + method170(i + 1, j - 1) + method170(i - 1, j + 1) + method170(i + 1, j + 1);
		int regionX = method170(i - 1, j) + method170(i + 1, j) + method170(i, j - 1) + method170(i, j + 1);
		int i1 = method170(i, j);
		return plane / 16 + regionX / 8 + i1 / 4;
	}

	private static int method187(int i, int j) {
		if (i == -1) {
			return 12345678;
		} else {
			j = j * (i & 127) / 128;
			if (j < 2) {
				j = 2;
			} else if (j > 126) {
				j = 126;
			}

			return (i & 'ﾀ') + j;
		}
	}

	public static void method188(WorldController worldController, int i, int j, int plane, int regionX, CollisionMap class11, int[][][] ai, int i1, int j1, int k1) {
		int l1 = ai[regionX][i1][j];
		int i2 = ai[regionX][i1 + 1][j];
		int j2 = ai[regionX][i1 + 1][j + 1];
		int k2 = ai[regionX][i1][j + 1];
		int l2 = l1 + i2 + j2 + k2 >> 2;
		ObjectDefinition class46 = ObjectDefinition.forID(j1);
		int i3 = i1 + (j << 7) + (j1 << 14 & 32767) + 1073741824;
		if (class46.interactive == 0) {
			i3 += -2147483648;
		}

		byte byte1 = (byte)((i << 6) + plane);
		Object obj10;
		if (plane == 22) {
			if (class46.animation == -1 && class46.morphisms == null) {
				obj10 = class46.method578(22, i, l1, i2, j2, k2, -1);
			} else {
				obj10 = new Animable_Sub5(j1, i, 22, i2, j2, l1, k2, class46.animation, true);
			}

			worldController.method280(k1, l2, j, (Animable)obj10, byte1, i3, i1, j1);
			if (class46.solid && class46.interactive != 0) {
				class11.method213(j, i1);
			}
		} else {
			int l4;
			int obj101;
			if (plane != 10 && plane != 11) {
				if (plane >= 12) {
					if (class46.animation == -1 && class46.morphisms == null) {
						obj10 = class46.method578(plane, i, l1, i2, j2, k2, -1);
					} else {
						obj10 = new Animable_Sub5(j1, i, plane, i2, j2, l1, k2, class46.animation, true);
					}

					worldController.method284(i3, byte1, l2, 1, (Animable)obj10, 1, k1, 0, j, i1, j1);
					if (class46.solid) {
						class11.method212(class46.impenetrable, class46.width, class46.length, i1, j, i);
					}
				} else if (plane == 0) {
					if (class46.animation == -1 && class46.morphisms == null) {
						obj10 = class46.method578(0, i, l1, i2, j2, k2, -1);
					} else {
						obj10 = new Animable_Sub5(j1, i, 0, i2, j2, l1, k2, class46.animation, true);
					}

					worldController.method282(anIntArray152[i], (Animable)obj10, i3, j, byte1, i1, (Animable)null, l2, 0, k1, j1);
					if (class46.solid) {
						class11.method211(j, i, i1, plane, class46.impenetrable);
					}
				} else if (plane == 1) {
					if (class46.animation == -1 && class46.morphisms == null) {
						obj10 = class46.method578(1, i, l1, i2, j2, k2, -1);
					} else {
						obj10 = new Animable_Sub5(j1, i, 1, i2, j2, l1, k2, class46.animation, true);
					}

					worldController.method282(anIntArray140[i], (Animable)obj10, i3, j, byte1, i1, (Animable)null, l2, 0, k1, j1);
					if (class46.solid) {
						class11.method211(j, i, i1, plane, class46.impenetrable);
					}
				} else {
					Object obj131;
					if (plane == 2) {
						obj101 = i + 1 & 3;
						Object l41;
						if (class46.animation == -1 && class46.morphisms == null) {
							l41 = class46.method578(2, 4 + i, l1, i2, j2, k2, -1);
							obj131 = class46.method578(2, obj101, l1, i2, j2, k2, -1);
						} else {
							l41 = new Animable_Sub5(j1, 4 + i, 2, i2, j2, l1, k2, class46.animation, true);
							obj131 = new Animable_Sub5(j1, obj101, 2, i2, j2, l1, k2, class46.animation, true);
						}

						worldController.method282(anIntArray152[i], (Animable)l41, i3, j, byte1, i1, (Animable)obj131, l2, anIntArray152[obj101], k1, j1);
						if (class46.solid) {
							class11.method211(j, i, i1, plane, class46.impenetrable);
						}
					} else if (plane == 3) {
						if (class46.animation == -1 && class46.morphisms == null) {
							obj10 = class46.method578(3, i, l1, i2, j2, k2, -1);
						} else {
							obj10 = new Animable_Sub5(j1, i, 3, i2, j2, l1, k2, class46.animation, true);
						}

						worldController.method282(anIntArray140[i], (Animable)obj10, i3, j, byte1, i1, (Animable)null, l2, 0, k1, j1);
						if (class46.solid) {
							class11.method211(j, i, i1, plane, class46.impenetrable);
						}
					} else if (plane == 9) {
						if (class46.animation == -1 && class46.morphisms == null) {
							obj10 = class46.method578(plane, i, l1, i2, j2, k2, -1);
						} else {
							obj10 = new Animable_Sub5(j1, i, plane, i2, j2, l1, k2, class46.animation, true);
						}

						worldController.method284(i3, byte1, l2, 1, (Animable)obj10, 1, k1, 0, j, i1, j1);
						if (class46.solid) {
							class11.method212(class46.impenetrable, class46.width, class46.length, i1, j, i);
						}
					} else {
						if (class46.contouredGround) {
							if (i == 1) {
								obj101 = k2;
								k2 = j2;
								j2 = i2;
								i2 = l1;
								l1 = obj101;
							} else if (i == 2) {
								obj101 = k2;
								k2 = i2;
								i2 = obj101;
								obj101 = j2;
								j2 = l1;
								l1 = obj101;
							} else if (i == 3) {
								obj101 = k2;
								k2 = l1;
								l1 = i2;
								i2 = j2;
								j2 = obj101;
							}
						}

						if (plane == 4) {
							if (class46.animation == -1 && class46.morphisms == null) {
								obj10 = class46.method578(4, 0, l1, i2, j2, k2, -1);
							} else {
								obj10 = new Animable_Sub5(j1, 0, 4, i2, j2, l1, k2, class46.animation, true);
							}

							worldController.method283(i3, j, i * 512, k1, 0, l2, (Animable)obj10, i1, byte1, 0, anIntArray152[i]);
						} else if (plane == 5) {
							obj101 = 16;
							l4 = worldController.method300(k1, i1, j);
							if (l4 > 0) {
								obj101 = ObjectDefinition.forID(l4 >> 14 & 32767).decorDisplacement;
							}

							if (class46.animation == -1 && class46.morphisms == null) {
								obj131 = class46.method578(4, 0, l1, i2, j2, k2, -1);
							} else {
								obj131 = new Animable_Sub5(j1, 0, 4, i2, j2, l1, k2, class46.animation, true);
							}

							worldController.method283(i3, j, i * 512, k1, anIntArray137[i] * obj101, l2, (Animable)obj131, i1, byte1, anIntArray144[i] * obj101, anIntArray152[i]);
						} else if (plane == 6) {
							if (class46.animation == -1 && class46.morphisms == null) {
								obj10 = class46.method578(4, 0, l1, i2, j2, k2, -1);
							} else {
								obj10 = new Animable_Sub5(j1, 0, 4, i2, j2, l1, k2, class46.animation, true);
							}

							worldController.method283(i3, j, i, k1, 0, l2, (Animable)obj10, i1, byte1, 0, 256);
						} else if (plane == 7) {
							if (class46.animation == -1 && class46.morphisms == null) {
								obj10 = class46.method578(4, 0, l1, i2, j2, k2, -1);
							} else {
								obj10 = new Animable_Sub5(j1, 0, 4, i2, j2, l1, k2, class46.animation, true);
							}

							worldController.method283(i3, j, i, k1, 0, l2, (Animable)obj10, i1, byte1, 0, 512);
						} else if (plane == 8) {
							if (class46.animation == -1 && class46.morphisms == null) {
								obj10 = class46.method578(4, 0, l1, i2, j2, k2, -1);
							} else {
								obj10 = new Animable_Sub5(j1, 0, 4, i2, j2, l1, k2, class46.animation, true);
							}

							worldController.method283(i3, j, i, k1, 0, l2, (Animable)obj10, i1, byte1, 0, 768);
						}
					}
				}
			} else {
				if (class46.animation == -1 && class46.morphisms == null) {
					obj10 = class46.method578(10, i, l1, i2, j2, k2, -1);
				} else {
					obj10 = new Animable_Sub5(j1, i, 10, i2, j2, l1, k2, class46.animation, true);
				}

				if (obj10 != null) {
					l4 = 0;
					if (plane == 11) {
						l4 += 256;
					}

					int i5;
					if (i != 1 && i != 3) {
						obj101 = class46.width;
						i5 = class46.length;
					} else {
						obj101 = class46.length;
						i5 = class46.width;
					}

					worldController.method284(i3, byte1, l2, i5, (Animable)obj10, obj101, k1, l4, j, i1, j1);
				}

				if (class46.solid) {
					class11.method212(class46.impenetrable, class46.width, class46.length, i1, j, i);
				}
			}
		}

	}

	public static boolean method189(int i, byte[] is, int i_250_) {
		boolean bool = true;
		Buffer stream = new Buffer(is);
		int i_252_ = -1;

		label52:
		while(true) {
			int i_253_ = stream.method422();
			if (i_253_ == 0) {
				return bool;
			}

			i_252_ += i_253_;
			int i_254_ = 0;
			boolean bool_255_ = false;

			while(true) {
				int i_257_;
				while(!bool_255_) {
					i_257_ = stream.method422();
					if (i_257_ == 0) {
						continue label52;
					}

					i_254_ += i_257_ - 1;
					int i_258_ = i_254_ & 63;
					int i_259_ = i_254_ >> 6 & 63;
					int i_260_ = stream.readUnsignedByte() >> 2;
					int i_261_ = i_259_ + i;
					int i_262_ = i_258_ + i_250_;
					if (i_261_ > 0 && i_262_ > 0 && i_261_ < 103 && i_262_ < 103) {
						ObjectDefinition class46 = ObjectDefinition.forID(i_252_);
						if (i_260_ != 22 || !lowMem || class46.interactive != 0 || class46.solid || class46.obstructsGround) {
							bool &= class46.method579();
							bool_255_ = true;
						}
					}
				}

				i_257_ = stream.method422();
				if (i_257_ == 0) {
					break;
				}

				stream.readUnsignedByte();
			}
		}
	}

	public final void method190(int i, CollisionMap[] aclass11, int j, WorldController worldController, byte[] abyte0) {
		Buffer stream = new Buffer(abyte0);
		int regionX = -1;

		while(true) {
			int i1 = stream.method422();
			if (i1 == 0) {
				return;
			}

			regionX += i1;
			int j1 = 0;

			while(true) {
				int k1 = stream.method422();
				if (k1 == 0) {
					break;
				}

				j1 += k1 - 1;
				int l1 = j1 & 63;
				int i2 = j1 >> 6 & 63;
				int j2 = j1 >> 12;
				int k2 = stream.readUnsignedByte();
				int l2 = k2 >> 2;
				int i3 = k2 & 3;
				int j3 = i2 + i;
				int k3 = l1 + j;
				if (j3 > 0 && k3 > 0 && j3 < 103 && k3 < 103 && j2 >= 0 && j2 < 4) {
					int l3 = j2;
					if ((this.tileFlags[1][j3][k3] & 2) == 2) {
						l3 = j2 - 1;
					}

					CollisionMap class11 = null;
					if (l3 >= 0) {
						class11 = aclass11[l3];
					}

					try {
						this.method175(k3, worldController, class11, l2, j2, j3, regionX, i3);
					} catch (Exception var22) {
						var22.printStackTrace();
					}
				}
			}
		}
	}
}
