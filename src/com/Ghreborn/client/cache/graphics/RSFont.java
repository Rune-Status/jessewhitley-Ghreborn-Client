package com.Ghreborn.client.cache.graphics;

import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.cache.graphics.Sprite;
import com.Ghreborn.client.draw.DrawingArea;
import com.Ghreborn.client.draw.rsDrawingArea;
import com.Ghreborn.client.io.Buffer;

import java.awt.Color;

public class RSFont extends DrawingArea {
   public int contrast2;
   public int contrast4;
   public int[] iconWidths;
   public byte[] aByteArray4151;
   public static String aRSString_4135 = "nbsp";
   public static String startTransparency = "trans=";
   public static String startDefaultShadow = "shad";
   public static String endShadow = "/shad";
   public static String endEffect = "gt";
   public static String aRSString_4143 = Integer.toString(100);
   public static String endStrikethrough = "/str";
   public static String aRSString_4147 = "euro";
   public static String startColor = "col=";
   public static String lineBreak = "br";
   public static String startStrikethrough = "str=";
   public static String endColor = "/col";
   public static String startImage = "img=";
   public static String startClanImage = "clan=";
   public static String endUnderline = "/u";
   public static String defaultStrikethrough = "str";
   public static String startShadow = "shad=";
   public static String startEffect = "lt";
   public static String aRSString_4162 = "shy";
   public static String aRSString_4163 = "copy";
   public static String endTransparency = "/trans";
   public static String aRSString_4165 = "times";
   public static String startUnderline = "u=";
   public static String startDefaultUnderline = "u";
   public static String aRSString_4169 = "reg";
   public static String[] splitTextStrings = new String[100];
   public static int defaultColor = 0;
   public static int textShadowColor = -1;
   public static int strikethroughColor = -1;
   public static int defaultTransparency = 256;
   public static int anInt4175 = 0;
   public static int underlineColor = -1;
   public static int defaultShadow = -1;
   public static int anInt4178 = 0;
   public static int transparency = 256;
   public static int textColor = 0;
   public int baseCharacterHeight = 0;
   public int[] characterDrawYOffsets = new int[256];
   public int[] characterHeights = new int[256];
   public int[] characterDrawXOffsets = new int[256];
   public int[] characterWidths = new int[256];
   public byte[][] fontPixels = new byte[256][];
   public int[] characterScreenWidths = new int[256];
   public static Sprite[] chatImages;
	public static Sprite[] clanImages;

   public RSFont(boolean TypeFont, String s, StreamLoader archive) {
      Buffer stream = new Buffer(archive.readFile(s + ".dat"));
      Buffer stream_1 = new Buffer(archive.readFile("index.dat"));
      stream_1.currentOffset = stream.readUnsignedWord() + 4;
      int k = stream_1.readUnsignedByte();
      if(k > 0) {
         stream_1.currentOffset += 3 * (k - 1);
      }

      for(int l = 0; l < 256; ++l) {
         this.characterDrawXOffsets[l] = stream_1.readUnsignedByte();
         this.characterDrawYOffsets[l] = stream_1.readUnsignedByte();
         int i1 = this.characterWidths[l] = stream_1.readUnsignedWord();
         int j1 = this.characterHeights[l] = stream_1.readUnsignedWord();
         int k1 = stream_1.readUnsignedByte();
         int l1 = i1 * j1;
         this.fontPixels[l] = new byte[l1];
         int k2;
         int j3;
         if(k1 == 0) {
            for(k2 = 0; k2 < l1; ++k2) {
               this.fontPixels[l][k2] = stream.readSignedByte();
            }
         } else if(k1 == 1) {
            for(k2 = 0; k2 < i1; ++k2) {
               for(j3 = 0; j3 < j1; ++j3) {
                  this.fontPixels[l][k2 + j3 * i1] = stream.readSignedByte();
               }
            }
         }

         if(j1 > this.baseCharacterHeight && l < 128) {
            this.baseCharacterHeight = j1;
         }

         this.characterDrawXOffsets[l] = 1;
         this.characterScreenWidths[l] = i1 + 2;
         k2 = 0;

         for(j3 = j1 / 7; j3 < j1; ++j3) {
            k2 += this.fontPixels[l][j3 * i1];
         }

         if(k2 <= j1 / 7) {
            --this.characterScreenWidths[l];
            this.characterDrawXOffsets[l] = 0;
         }

         k2 = 0;

         for(j3 = j1 / 7; j3 < j1; ++j3) {
            k2 += this.fontPixels[l][i1 - 1 + j3 * i1];
         }

         if(k2 <= j1 / 7) {
            --this.characterScreenWidths[l];
         }
      }

      if(TypeFont) {
         this.characterScreenWidths[32] = this.characterScreenWidths[73];
      } else {
         this.characterScreenWidths[32] = this.characterScreenWidths[105];
      }

   }

   public void drawStringMoveY(String string, int drawX, int drawY, int color, int shadow, int randomMod, int randomMod2) {
      if(string != null) {
         this.setColorAndShadow(color, shadow);
         double d = 7.0D - (double)randomMod2 / 8.0D;
         if(d < 0.0D) {
            d = 0.0D;
         }

         int[] yOffset = new int[string.length()];

         for(int index = 0; index < string.length(); ++index) {
            yOffset[index] = (int)(Math.sin((double)index / 1.5D + (double)randomMod) * d);
         }

         this.drawBaseStringMoveXY(string, drawX - this.getTextWidth(string) / 2, drawY, null, yOffset);
      }

   }

   public int getCharacterWidth(int i) {
      return this.characterScreenWidths[i & 255];
   }

   public void setTrans(int i, int j, int k) {
      defaultShadow = i;
      textShadowColor = i;
      defaultColor = j;
      textColor = j;
      defaultTransparency = k;
      transparency = k;
   }

   public void drawCenteredString(String s, int i, int j) {
      if(s != null) {
         this.drawBasicString(s, i - this.getTextWidth(s) / 2, j);
      }

   }

   public void setDefaultTextEffectValues(int color, int shadow, int trans) {
      strikethroughColor = -1;
      underlineColor = -1;
      defaultShadow = shadow;
      textShadowColor = shadow;
      defaultColor = color;
      textColor = color;
      defaultTransparency = trans;
      transparency = trans;
      anInt4178 = 0;
      anInt4175 = 0;
   }

   public static int method1014(byte[][] is, byte[][] is_27_, int[] is_28_, int[] is_29_, int[] is_30_, int i, int i_31_) {
      int i_32_ = is_28_[i];
      int i_33_ = i_32_ + is_30_[i];
      int i_34_ = is_28_[i_31_];
      int i_35_ = i_34_ + is_30_[i_31_];
      int i_36_ = i_32_;
      if(i_34_ > i_32_) {
         i_36_ = i_34_;
      }

      int i_37_ = i_33_;
      if(i_35_ < i_33_) {
         i_37_ = i_35_;
      }

      int i_38_ = is_29_[i];
      if(is_29_[i_31_] < i_38_) {
         i_38_ = is_29_[i_31_];
      }

      byte[] is_39_ = is_27_[i];
      byte[] is_40_ = is[i_31_];
      int i_41_ = i_36_ - i_32_;
      int i_42_ = i_36_ - i_34_;

      for(int i_43_ = i_36_; i_43_ < i_37_; ++i_43_) {
         int i_44_ = is_39_[i_41_++] + is_40_[i_42_++];
         if(i_44_ < i_38_) {
            i_38_ = i_44_;
         }
      }

      return -i_38_;
   }

   public void drawCenteredStringMoveXY(String string, int drawX, int drawY, int color, int shadow, int randomMod) {
      if(string != null) {
         this.setColorAndShadow(color, shadow);
         int[] xMods = new int[string.length()];
         int[] yMods = new int[string.length()];

         for(int index = 0; index < string.length(); ++index) {
            xMods[index] = (int)(Math.sin((double)index / 5.0D + (double)randomMod / 5.0D) * 5.0D);
            yMods[index] = (int)(Math.sin((double)index / 3.0D + (double)randomMod / 5.0D) * 5.0D);
         }

         this.drawBaseStringMoveXY(string, drawX - this.getTextWidth(string) / 2, drawY, xMods, yMods);
      }

   }

   public void drawCenteredStringMoveY(String class100, int drawX, int drawY, int color, int shadow, int i_54_) {
      if(class100 != null) {
         this.setColorAndShadow(color, shadow);
         int[] yOffset = new int[class100.length()];

         for(int index = 0; index < class100.length(); ++index) {
            yOffset[index] = (int)(Math.sin((double)index / 2.0D + (double)i_54_ / 5.0D) * 5.0D);
         }

         this.drawBaseStringMoveXY(class100, drawX - this.getTextWidth(class100) / 2, drawY, null, yOffset);
      }

   }

   public void unpackChatImages(Sprite[] icons) {
      chatImages = icons;
   }

   public void drawBasicString(String string, int drawX, int drawY) {
      drawY -= this.baseCharacterHeight;
      int startIndex = -1;
      string = handleOldSyntax(string);
      for(int currentCharacter = 0; currentCharacter < string.length(); ++currentCharacter) {
         char character = string.charAt(currentCharacter);
         if(character > 255) {
            character = 32;
         }

         if(character == 60) {
            startIndex = currentCharacter;
         } else {
            int height;
            if(character == 62 && startIndex != -1) {
               String var121 = string.substring(startIndex + 1, currentCharacter);
               startIndex = -1;
               if(var121.equals(startEffect)) {
                  character = 60;
               } else if(var121.equals(endEffect)) {
                  character = 62;
               } else if(var121.equals(aRSString_4135)) {
                  character = 160;
               } else if(var121.equals(aRSString_4162)) {
                  character = 173;
               } else if(var121.equals(aRSString_4165)) {
                  character = 215;
               } else if(var121.equals(aRSString_4147)) {
                  character = 128;
               } else if(var121.equals(aRSString_4163)) {
                  character = 169;
               } else {
                  if(!var121.equals(aRSString_4169)) {
                     if(var121.startsWith(startImage)) {
                        try {
                           height = Integer.valueOf(var121.substring(4)).intValue();
                           Sprite var13 = chatImages[height];
                           int iconModY = var13.maxHeight;
                           var13.drawSprite(drawX, drawY + this.baseCharacterHeight - iconModY, transparency);
                           drawX += var13.maxWidth;
                        } catch (Exception var11) {
                        }
					} else if (var121.startsWith(startClanImage)) {
						try {
							int imageId = Integer.valueOf(var121.substring(5));
							Sprite icon = clanImages[imageId];
							icon.drawSprite(drawX, drawY + 2);
							drawX += 11;
						} catch (Exception exception) {
							/* empty */
						}
					} else {
                        this.setTextEffects(var121);
                     }
                     continue;
                  }

                  character = 174;
               }
            }

            if(startIndex == -1) {
               int var12 = this.characterWidths[character];
               height = this.characterHeights[character];
               if(character != 32) {
                  if(transparency == 256) {
                     if(textShadowColor != -1) {
                        this.drawCharacter(character, drawX + this.characterDrawXOffsets[character] + 1, drawY + this.characterDrawYOffsets[character] + 1, var12, height, textShadowColor, true);
                     }

                     this.drawCharacter(character, drawX + this.characterDrawXOffsets[character], drawY + this.characterDrawYOffsets[character], var12, height, textColor, false);
                  } else {
                     if(textShadowColor != -1) {
                        this.drawTransparentCharacter(character, drawX + this.characterDrawXOffsets[character] + 1, drawY + this.characterDrawYOffsets[character] + 1, var12, height, textShadowColor, transparency, true);
                     }

                     this.drawTransparentCharacter(character, drawX + this.characterDrawXOffsets[character], drawY + this.characterDrawYOffsets[character], var12, height, textColor, transparency, false);
                  }
               } else if(anInt4178 > 0) {
                  anInt4175 += anInt4178;
                  drawX += anInt4175 >> 8;
                  anInt4175 &= 255;
               }

               int lineWidth = this.characterScreenWidths[character];
               if(strikethroughColor != -1) {
                  rsDrawingArea.drawHorizontalLine(drawX, drawY + (int)((double)this.baseCharacterHeight * 0.7D), lineWidth, strikethroughColor);
               }

               if(underlineColor != -1) {
                  rsDrawingArea.drawHorizontalLine(drawX, drawY + this.baseCharacterHeight, lineWidth, underlineColor);
               }

               drawX += lineWidth;
            }
         }
      }

   }

   public void drawRAString(String string, int drawX, int drawY, int color, int shadow) {
      if(string != null) {
         this.setColorAndShadow(color, shadow);
         string = handleOldSyntax(string);
         this.drawBasicString(string, drawX - this.getTextWidth(string), drawY);
      }

   }

   public void drawBaseStringMoveXY(String string, int drawX, int drawY, int[] xModifier, int[] yModifier) {
      drawY -= this.baseCharacterHeight;
      int startIndex = -1;
      int modifierOffset = 0;

      for(int currentCharacter = 0; currentCharacter < string.length(); ++currentCharacter) {
         char character = string.charAt(currentCharacter);
         if(character == 60) {
            startIndex = currentCharacter;
         } else {
            int height;
            int xOff;
            int yOff;
            if(character == 62 && startIndex != -1) {
               String var171 = string.substring(startIndex + 1, currentCharacter);
               startIndex = -1;
               if(var171.equals(startEffect)) {
                  character = 60;
               } else if(var171.equals(endEffect)) {
                  character = 62;
               } else if(var171.equals(aRSString_4135)) {
                  character = 160;
               } else if(var171.equals(aRSString_4162)) {
                  character = 173;
               } else if(var171.equals(aRSString_4165)) {
                  character = 215;
               } else if(var171.equals(aRSString_4147)) {
                  character = 128;
               } else if(var171.equals(aRSString_4163)) {
                  character = 169;
               } else {
                  if(!var171.equals(aRSString_4169)) {
                     if(var171.startsWith(startImage)) {
                        try {
                           if(xModifier != null) {
                              height = xModifier[modifierOffset];
                           } else {
                              height = 0;
                           }

                           if(yModifier != null) {
                              xOff = yModifier[modifierOffset];
                           } else {
                              xOff = 0;
                           }

                           ++modifierOffset;
                           yOff = Integer.valueOf(var171.substring(4)).intValue();
                           Sprite var18 = chatImages[yOff];
                           int iconOffsetY = var18.maxHeight;
                           var18.drawSprite(drawX + height, drawY + this.baseCharacterHeight - iconOffsetY + xOff);
                           drawX += var18.maxWidth;
                        } catch (Exception var16) {
                        }
                     } else {
                        this.setTextEffects(var171);
                     }
                     continue;
                  }

                  character = 174;
               }
            }

            if(startIndex == -1) {
               int var17 = this.characterWidths[character];
               height = this.characterHeights[character];
               if(xModifier != null) {
                  xOff = xModifier[modifierOffset];
               } else {
                  xOff = 0;
               }

               if(yModifier != null) {
                  yOff = yModifier[modifierOffset];
               } else {
                  yOff = 0;
               }

               ++modifierOffset;
               if(character != 32) {
                  if(transparency == 256) {
                     if(textShadowColor != -1) {
                        this.drawCharacter(character, drawX + this.characterDrawXOffsets[character] + 1 + xOff, drawY + this.characterDrawYOffsets[character] + 1 + yOff, var17, height, textShadowColor, true);
                     }

                     this.drawCharacter(character, drawX + this.characterDrawXOffsets[character] + xOff, drawY + this.characterDrawYOffsets[character] + yOff, var17, height, textColor, false);
                  } else {
                     if(textShadowColor != -1) {
                        this.drawTransparentCharacter(character, drawX + this.characterDrawXOffsets[character] + 1 + xOff, drawY + this.characterDrawYOffsets[character] + 1 + yOff, var17, height, textShadowColor, transparency, true);
                     }

                     this.drawTransparentCharacter(character, drawX + this.characterDrawXOffsets[character] + xOff, drawY + this.characterDrawYOffsets[character] + yOff, var17, height, textColor, transparency, false);
                  }
               } else if(anInt4178 > 0) {
                  anInt4175 += anInt4178;
                  drawX += anInt4175 >> 8;
                  anInt4175 &= 255;
               }

               int i_109_ = this.characterScreenWidths[character];
               if(strikethroughColor != -1) {
                  drawHorizontalLine(drawX, drawY + (int)((double)this.baseCharacterHeight * 0.7D), i_109_, strikethroughColor);
               }

               if(underlineColor != -1) {
                  rsDrawingArea.drawHorizontalLine(drawX, drawY + this.baseCharacterHeight, i_109_, underlineColor);
               }

               drawX += i_109_;
            }
         }
      }

   }

   public void setTextEffects(String string) {
      try {
         String color;
         if(string.startsWith(startColor)) {
            color = string.substring(4);
            textColor = color.length() < 6?Color.decode(color).getRGB():Integer.parseInt(color, 16);
         } else if(string.equals(endColor)) {
            textColor = defaultColor;
         } else if(string.startsWith(startTransparency)) {
            transparency = Integer.valueOf(string.substring(6)).intValue();
         } else if(string.equals(endTransparency)) {
            transparency = defaultTransparency;
         } else if(string.startsWith(startStrikethrough)) {
            color = string.substring(4);
            strikethroughColor = color.length() < 6?Color.decode(color).getRGB():Integer.parseInt(color, 16);
         } else if(string.equals(defaultStrikethrough)) {
            strikethroughColor = 8388608;
         } else if(string.equals(endStrikethrough)) {
            strikethroughColor = -1;
         } else if(string.startsWith(startUnderline)) {
            color = string.substring(2);
            underlineColor = color.length() < 6?Color.decode(color).getRGB():Integer.parseInt(color, 16);
         } else if(string.equals(startDefaultUnderline)) {
            underlineColor = 0;
         } else if(string.equals(endUnderline)) {
            underlineColor = -1;
         } else if(string.startsWith(startShadow)) {
            color = string.substring(5);
            textShadowColor = color.length() < 6?Color.decode(color).getRGB():Integer.parseInt(color, 16);
         } else if(string.equals(startDefaultShadow)) {
            textShadowColor = 0;
         } else if(string.equals(endShadow)) {
            textShadowColor = defaultShadow;
         } else if(string.equals(lineBreak)) {
            this.setDefaultTextEffectValues(defaultColor, defaultShadow, defaultTransparency);
         }
      } catch (Exception var3) {
      }

   }

   public void setColorAndShadow(int color, int shadow) {
      strikethroughColor = -1;
      underlineColor = -1;
      defaultShadow = shadow;
      textShadowColor = shadow;
      defaultColor = color;
      textColor = color;
      defaultTransparency = 256;
      transparency = 256;
      anInt4178 = 0;
      anInt4175 = 0;
   }

   public int getTextWidth(String string) {
      if(string == null) {
         return 0;
      } else {
         int startIndex = -1;
         int finalWidth = 0;

         for(int currentCharacter = 0; currentCharacter < string.length(); ++currentCharacter) {
            char character = string.charAt(currentCharacter);
            if(character > 255) {
               character = 32;
            }

            if(character == 60) {
               startIndex = currentCharacter;
            } else {
               if(character == 62 && startIndex != -1) {
                  String effectString = string.substring(startIndex + 1, currentCharacter);
                  startIndex = -1;
                  if(effectString.equals(startEffect)) {
                     character = 60;
                  } else if(effectString.equals(endEffect)) {
                     character = 62;
                  } else if(effectString.equals(aRSString_4135)) {
                     character = 160;
                  } else if(effectString.equals(aRSString_4162)) {
                     character = 173;
                  } else if(effectString.equals(aRSString_4165)) {
                     character = 215;
                  } else if(effectString.equals(aRSString_4147)) {
                     character = 128;
                  } else if(effectString.equals(aRSString_4163)) {
                     character = 169;
                  } else {
                     if(!effectString.equals(aRSString_4169)) {
                        if(effectString.startsWith(startImage)) {
                           try {
                              int iconId = Integer.valueOf(effectString.substring(4)).intValue();
                              finalWidth += chatImages[iconId].maxWidth;
                           } catch (Exception var8) {
                           }
						} else if (effectString.startsWith(startClanImage)) {
							try {
								int iconId = Integer.valueOf(effectString.substring(5));
								finalWidth += clanImages[iconId].maxWidth;
							} catch (Exception exception) {
								/* empty */
							}
						}
                        continue;
                     }

                     character = 174;
                  }
               }

               if(startIndex == -1) {
                  finalWidth += this.characterScreenWidths[character];
               }
            }
         }

         return finalWidth;
      }
   }


   public void drawCenteredString(String string, int drawX, int drawY, int color, int shadow) {
      if(string != null) {
         this.setColorAndShadow(color, shadow);
         string = handleOldSyntax(string);
         this.drawBasicString(string, drawX - this.getTextWidth(string) / 2, drawY);
      }

   }
	public static String handleOldSyntax(String text) {
		text = text.replaceAll("@pur@", "<col=A10081>");
		text = text.replaceAll("@red@", "<col=ff0000>");
		text = text.replaceAll("@gre@", "<col=65280>");
		text = text.replaceAll("@blu@", "<col=255>");
		text = text.replaceAll("@yel@", "<col=ffff00>");
		text = text.replaceAll("@cya@", "<col=65535>");
		text = text.replaceAll("@mag@", "<col=ff00ff>");
		text = text.replaceAll("@whi@", "<col=ffffff>");
		text = text.replaceAll("@lre@", "<col=ff9040>");
		text = text.replaceAll("@dre@", "<col=800000>");
		text = text.replaceAll("@bla@", "<col=0>");
		text = text.replaceAll("@or0@", "<col=A67711>");
		text = text.replaceAll("@or1@", "<col=ffb000>");
		text = text.replaceAll("@or2@", "<col=ff7000>");
		text = text.replaceAll("@or3@", "<col=ff3000>");
		text = text.replaceAll("@gr0@", "<col=148200>");
		text = text.replaceAll("@gr1@", "<col=c0ff00>");
		text = text.replaceAll("@gr2@", "<col=80ff00>");
		text = text.replaceAll("@gr3@", "<col=40ff00>");
		text = text.replaceAll("@OR0", "<col=<A67711>");
		text = text.replaceAll("@PUR@", "<col=A10081>");
		text = text.replaceAll("@RED@", "<col=ffff00>");
		text = text.replaceAll("@GRE@", "<col=65280>");
		text = text.replaceAll("@BLU@", "<col=255>");
		text = text.replaceAll("@YEL@", "<col=ff0000>");
		text = text.replaceAll("@CYA@", "<col=65535>");
		text = text.replaceAll("@MAG@", "<col=ff00ff>");
		text = text.replaceAll("@WHI@", "<col=ffffff>");
		text = text.replaceAll("@LRE@", "<col=ff9040>");
		text = text.replaceAll("@DRE@", "<col=800000>");
		text = text.replaceAll("@BLA@", "<col=0>");
		text = text.replaceAll("@OR1@", "<col=ffb000>");
		text = text.replaceAll("@OR2@", "<col=ff7000>");
		text = text.replaceAll("@OR3@", "<col=ff3000>");
		text = text.replaceAll("@GR1@", "<col=c0ff00>");
		text = text.replaceAll("@GR2@", "<col=80ff00>");
		text = text.replaceAll("@GR3@", "<col=40ff00>");
		return text;
	}

   public static void nullLoader() {
      startEffect = null;
      endEffect = null;
      aRSString_4135 = null;
      aRSString_4162 = null;
      aRSString_4165 = null;
      aRSString_4147 = null;
      aRSString_4163 = null;
      aRSString_4169 = null;
      startImage = null;
      lineBreak = null;
      startColor = null;
      endColor = null;
      startTransparency = null;
      endTransparency = null;
      startUnderline = null;
      startDefaultUnderline = null;
      endUnderline = null;
      startShadow = null;
      startDefaultShadow = null;
      endShadow = null;
      startStrikethrough = null;
      defaultStrikethrough = null;
      endStrikethrough = null;
      aRSString_4143 = null;
      splitTextStrings = null;
   }

   public static void createTransparentCharacterPixels(int[] is, byte[] is_0_, int i, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_, int i_7_) {
      i = ((i & 16711935) * i_7_ & -16711936) + ((i & '\uff00') * i_7_ & 16711680) >> 8;
      i_7_ = 256 - i_7_;

      for(int i_8_ = -i_4_; i_8_ < 0; ++i_8_) {
         for(int i_9_ = -i_3_; i_9_ < 0; ++i_9_) {
            if(is_0_[i_1_++] != 0) {
               int i_10_ = is[i_2_];
               is[i_2_++] = (((i_10_ & 16711935) * i_7_ & -16711936) + ((i_10_ & '\uff00') * i_7_ & 16711680) >> 8) + i;
            } else {
               ++i_2_;
            }
         }

         i_2_ += i_5_;
         i_1_ += i_6_;
      }

   }

   public void drawTransparentCharacter(int i, int i_11_, int i_12_, int i_13_, int i_14_, int i_15_, int i_16_, boolean bool) {
      int i_17_ = i_11_ + i_12_ * DrawingArea.width;
      int i_18_ = DrawingArea.width - i_13_;
      int i_19_ = 0;
      int i_20_ = 0;
      int i_23_;
      if(i_12_ < DrawingArea.topY) {
         i_23_ = DrawingArea.topY - i_12_;
         i_14_ -= i_23_;
         i_12_ = DrawingArea.topY;
         i_20_ += i_23_ * i_13_;
         i_17_ += i_23_ * DrawingArea.width;
      }

      if(i_12_ + i_14_ > DrawingArea.bottomY) {
         i_14_ -= i_12_ + i_14_ - DrawingArea.bottomY;
      }

      if(i_11_ < DrawingArea.leftX) {
         i_23_ = DrawingArea.leftX - i_11_;
         i_13_ -= i_23_;
         i_11_ = DrawingArea.leftX;
         i_20_ += i_23_;
         i_17_ += i_23_;
         i_19_ += i_23_;
         i_18_ += i_23_;
      }

      if(i_11_ + i_13_ > DrawingArea.bottomX) {
         i_23_ = i_11_ + i_13_ - DrawingArea.bottomX;
         i_13_ -= i_23_;
         i_19_ += i_23_;
         i_18_ += i_23_;
      }

      if(i_13_ > 0 && i_14_ > 0) {
         createTransparentCharacterPixels(DrawingArea.pixels, this.fontPixels[i], i_15_, i_20_, i_17_, i_13_, i_14_, i_18_, i_19_, i_16_);
      }

   }

   public static void createCharacterPixels(int[] is, byte[] is_24_, int i, int i_25_, int i_26_, int i_27_, int i_28_, int i_29_, int i_30_) {
      int i_31_ = -(i_27_ >> 2);
      i_27_ = -(i_27_ & 3);

      for(int i_32_ = -i_28_; i_32_ < 0; ++i_32_) {
         int i_34_;
         for(i_34_ = i_31_; i_34_ < 0; ++i_34_) {
            if(is_24_[i_25_++] != 0) {
               is[i_26_++] = i;
            } else {
               ++i_26_;
            }

            if(is_24_[i_25_++] != 0) {
               is[i_26_++] = i;
            } else {
               ++i_26_;
            }

            if(is_24_[i_25_++] != 0) {
               is[i_26_++] = i;
            } else {
               ++i_26_;
            }

            if(is_24_[i_25_++] != 0) {
               is[i_26_++] = i;
            } else {
               ++i_26_;
            }
         }

         for(i_34_ = i_27_; i_34_ < 0; ++i_34_) {
            if(is_24_[i_25_++] != 0) {
               is[i_26_++] = i;
            } else {
               ++i_26_;
            }
         }

         i_26_ += i_29_;
         i_25_ += i_30_;
      }

   }

   public void drawCharacter(int character, int i_35_, int i_36_, int i_37_, int i_38_, int i_39_, boolean bool) {
      int i_40_ = i_35_ + i_36_ * DrawingArea.width;
      int i_41_ = DrawingArea.width - i_37_;
      int i_42_ = 0;
      int i_43_ = 0;
      int i_46_;
      if(i_36_ < DrawingArea.topY) {
         i_46_ = DrawingArea.topY - i_36_;
         i_38_ -= i_46_;
         i_36_ = DrawingArea.topY;
         i_43_ += i_46_ * i_37_;
         i_40_ += i_46_ * DrawingArea.width;
      }

      if(i_36_ + i_38_ > DrawingArea.bottomY) {
         i_38_ -= i_36_ + i_38_ - DrawingArea.bottomY;
      }

      if(i_35_ < DrawingArea.leftX) {
         i_46_ = DrawingArea.leftX - i_35_;
         i_37_ -= i_46_;
         i_35_ = DrawingArea.leftX;
         i_43_ += i_46_;
         i_40_ += i_46_;
         i_42_ += i_46_;
         i_41_ += i_46_;
      }

      if(i_35_ + i_37_ > DrawingArea.bottomX) {
         i_46_ = i_35_ + i_37_ - DrawingArea.bottomX;
         i_37_ -= i_46_;
         i_42_ += i_46_;
         i_41_ += i_46_;
      }

      if(i_37_ > 0 && i_38_ > 0) {
         createCharacterPixels(DrawingArea.pixels, this.fontPixels[character], i_39_, i_43_, i_40_, i_37_, i_38_, i_41_, i_42_);
      }

   }

   public void drawBasicString(String string, int drawX, int drawY, int color,
           int shadow) {
       if (string != null) {
           setColorAndShadow(color, shadow);
           string = handleOldSyntax(string);
           drawBasicString(string, drawX, drawY);
       }
   }

	public static void unpackImages(Sprite[] icons, Sprite[] clan) {
		chatImages = icons;
		clanImages = clan;
	}

	public void drawString(String string, int x, int y, int color, int shadow, int trans) {
		if (transparency < 0 || transparency > 256) {
			transparency = defaultTransparency;
		}
		setColorAndShadow(color, shadow);
		transparency = trans;
		drawBasicString(string, x, y);
	}



}
