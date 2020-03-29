package com.Ghreborn.client.cache.anim;

import com.Ghreborn.client.Main;

import java.util.Arrays;
import java.util.Map;

import com.Ghreborn.client.FileOperations;
import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.cache.anim.FrameBase;
import com.Ghreborn.client.io.Buffer;

public final class Frame {
   public static byte[][] frameData = null;
   public static byte[][] skinData = null;
   public FrameBase aClass18_637;
   public int stepCounter;
   public static Map frames;
   private static boolean[] aBooleanArray643;
   public int[] opcodeLinkTable;
   public int[] modifier1;
   public int[] modifier2;
	static boolean showing;
   public int[] modifier3;
   public byte[] settings;
   public int cycles;
   public static Frame[][] animationlist;
   public static Frame[] animationlist2;
   
   public static void load(int file, byte[] fileData) {
		try {
         Buffer stream = new Buffer(fileData);
         FrameBase FrameBase = new FrameBase(stream);
         int k1 = stream.readUnsignedWord();
         animationlist[file] = new Frame[k1 * 3];
         int[] ai = new int[500];
         int[] ai1 = new int[500];
         int[] ai2 = new int[500];
         int[] ai3 = new int[500];

         for(int l1 = 0; l1 < k1; ++l1) {
            int i2 = stream.readUnsignedWord();
            Frame Frame = animationlist[file][i2] = new Frame();
            Frame.aClass18_637 = FrameBase;
            int j2 = stream.readUnsignedByte();
            int l2 = 0;
            int k2 = -1;

            int k3;
            for(k3 = 0; k3 < j2; ++k3) {
               int j3 = stream.readUnsignedByte();
               if(j3 > 0) {
                  if(FrameBase.transformationType[k3] != 0) {
                     for(int var19 = k3 - 1; var19 > k2; --var19) {
                        if(FrameBase.transformationType[var19] == 0) {
                           ai[l2] = var19;
                           ai1[l2] = 0;
                           ai2[l2] = 0;
                           ai3[l2] = 0;
                           ++l2;
                           break;
                        }
                     }
                  }

                  ai[l2] = k3;
                  short var191 = 0;
                  if(FrameBase.transformationType[k3] == 3) {
                     var191 = 128;
                  }

                  if((j3 & 1) != 0) {
                     ai1[l2] = (short)stream.readShort2();
                  } else {
                     ai1[l2] = var191;
                  }

                  if((j3 & 2) != 0) {
                     ai2[l2] = stream.readShort2();
                  } else {
                     ai2[l2] = var191;
                  }

                  if((j3 & 4) != 0) {
                     ai3[l2] = stream.readShort2();
                  } else {
                     ai3[l2] = var191;
                  }
                  k2 = k3;
                  ++l2;
               }
            }
            Frame.stepCounter = l2;
            Frame.opcodeLinkTable = new int[l2];
            Frame.modifier1 = new int[l2];
            Frame.modifier2 = new int[l2];
            Frame.modifier3 = new int[l2];

            for(k3 = 0; k3 < l2; ++k3) {
               Frame.opcodeLinkTable[k3] = ai[k3];
               Frame.modifier1[k3] = ai1[k3];
               Frame.modifier2[k3] = ai2[k3];
               Frame.modifier3[k3] = ai3[k3];
			}
		}
	} catch(Exception exception) { }
}
   public static void load_647(int var0) {
	      try {
	         Buffer var1 = new Buffer((FileOperations.ReadFile(SignLink.findcachedir()+"anims/"+var0+".dat")));
	         FrameBase var2 = new FrameBase(var1);
	         int var3 = var1.readUnsignedWord();
	         animationlist[var0] = new Frame[(int)((double)var3 * 1.5D)];
	         int[] var4 = new int[500];
	         int[] var5 = new int[500];
	         int[] var6 = new int[500];
	         int[] var7 = new int[500];

	         for(int var8 = 0; var8 < var3; ++var8) {
	            int var9 = var1.readUnsignedWord();
	            Frame var10 = animationlist[var0][var9] = new Frame();
	            var10.aClass18_637 = var2;
	            int var11 = var1.readUnsignedByte();
	            int var12 = 0;
	            int var13 = -1;

	            int var14;
	            for(var14 = 0; var14 < var11; ++var14) {
	               int var15 = var1.readUnsignedByte();
	               if(var15 > 0) {
	                  if(var2.transformationType[var14] != 0) {
	                     for(int var16 = var14 - 1; var16 > var13; --var16) {
	                        if(var2.transformationType[var16] == 0) {
	                           var4[var12] = var16;
	                           var5[var12] = 0;
	                           var6[var12] = 0;
	                           var7[var12] = 0;
	                           ++var12;
	                           break;
	                        }
	                     }
	                  }

	                  var4[var12] = var14;
	                  short var18 = 0;
	                  if(var2.transformationType[var14] == 3) {
	                     var18 = 128;
	                  }

	                  if((var15 & 1) != 0) {
	                     var5[var12] = (short)var1.readShort2();
	                  } else {
	                     var5[var12] = var18;
	                  }

	                  if((var15 & 2) != 0) {
	                     var6[var12] = var1.readShort2();
	                  } else {
	                     var6[var12] = var18;
	                  }

	                  if((var15 & 4) != 0) {
	                     var7[var12] = var1.readShort2();
	                  } else {
	                     var7[var12] = var18;
	                  }

	                  var13 = var14;
	                  ++var12;
	               }
	            }

	            var10.stepCounter = var12;
	            var10.opcodeLinkTable = new int[var12];
	            var10.modifier1 = new int[var12];
	            var10.modifier2 = new int[var12];
	            var10.modifier3 = new int[var12];

	            for(var14 = 0; var14 < var12; ++var14) {
	               var10.opcodeLinkTable[var14] = var4[var14];
	               var10.modifier1[var14] = var5[var14];
	               var10.modifier2[var14] = var6[var14];
	               var10.modifier3[var14] = var7[var14];
	            }
	         }
	      } catch (Exception var17) {
          }

	   }
   public static void nullLoader() {
      animationlist = null;
   }

   public static Frame method531(int i) {
      try {
         int var3 = i >> 16;
         int k = i & '\uffff';
         if(animationlist[var3].length == 0) {
            Main.onDemandFetcher.method558(1, var3);
            return null;
         } else {
            return animationlist[var3][k];
         }
      } catch (Exception var31) {
         var31.printStackTrace();
         return null;
      }
   }
   public static boolean method532(int i) {
      return i == -1;
   }

public static int offset = 33600;

public static void customGhettoAnimations(boolean flag, int file) {
    try {
       byte[] e = FileOperations.ReadFile(SignLink.findcachedir()+"anims/"+file+".dat");
       if(e == null) {
          System.out.println("This animation is non existent: " + file);
          return;
       }

       Buffer stream = new Buffer(e);
       stream.currentOffset = e.length - 8;
       int attributesOffset = stream.readUnsignedShort();
       int translationsOffset = stream.readUnsignedShort();
       int durationsOffset = stream.readUnsignedShort();
       int baseOffset = stream.readUnsignedShort();
       byte offset = 0;
       Buffer head = new Buffer(e);
       head.currentOffset = offset;
       int var32 = offset + attributesOffset + 2;
       Buffer attributes = new Buffer(e);
       attributes.currentOffset = var32;
       var32 += translationsOffset;
       Buffer translations = new Buffer(e);
       translations.currentOffset = var32;
       var32 += durationsOffset;
       Buffer durations = new Buffer(e);
       durations.currentOffset = var32;
       var32 += baseOffset;
       Buffer bases = new Buffer(e);
       bases.currentOffset = var32;
       FrameBase base = new FrameBase(bases);
       int k1 = head.readUnsignedShort();
       Frame[] frames = new Frame[(int)((double)k1 * 1.5D)];
       int[] indices = new int[500];
       int[] ai1 = new int[500];
       int[] ai2 = new int[500];
       int[] ai3 = new int[500];
       int last = 0;

       for(int l1 = 0; l1 < k1; ++l1) {
          int frameFile = head.readUnsignedShort();
          last = Math.max(last, frameFile);
          if(frameFile >= frames.length) {
             frames = (Frame[])Arrays.copyOf(frames, frameFile + 100);
          }

          Frame frame = frames[frameFile] = new Frame();
          frame.cycles = durations.readUnsignedByte();
          frame.aClass18_637 = base;
          int count = head.readUnsignedByte();
          int i = 0;
          int k2 = -1;

          int k3;
          for(k3 = 0; k3 < count; ++k3) {
             int settings = attributes.readUnsignedByte();
             if(settings > 0) {
                if(base.transformationType[k3] != 0) {
                   for(int c = k3 - 1; c > k2; --c) {
                      if(base.transformationType[c] == 0) {
                         indices[i] = c;
                         ai1[i] = 0;
                         ai2[i] = 0;
                         ai3[i] = 0;
                         ++i;
                         break;
                      }
                   }
                }

                indices[i] = k3;
                short var33 = 0;
                if(base.transformationType[k3] == 3) {
                   var33 = 128;
                }

                if((settings & 1) != 0) {
                   ai1[i] = (short)translations.readShort2();
                } else {
                   ai1[i] = var33;
                }

                if((settings & 2) != 0) {
                   ai2[i] = translations.readShort2();
                } else {
                   ai2[i] = var33;
                }

                if((settings & 4) != 0) {
                   ai3[i] = translations.readShort2();
                } else {
                   ai3[i] = var33;
                }

                k2 = k3;
                ++i;
             }
          }

          frame.stepCounter = i;
          frame.opcodeLinkTable = new int[i];
          frame.modifier1 = new int[i];
          frame.modifier2 = new int[i];
          frame.modifier3 = new int[i];
          frame.settings = new byte[i];
          
          for(k3 = 0; k3 < i; ++k3) {
             frame.opcodeLinkTable[k3] = indices[k3];
             frame.modifier1[k3] = ai1[k3];
             frame.modifier2[k3] = ai2[k3];
             frame.modifier3[k3] = ai3[k3];
          }
       }
       frames = (Frame[])Arrays.copyOf(frames, last + 1);
       Frame.frames.put(Integer.valueOf(file), frames);
    } catch (Throwable var31) {
       var31.printStackTrace();
    }

 }

public static void methodCustomAnimations(int file) {
    Buffer stream = new Buffer(FileOperations.ReadFile(SignLink.findcachedir()+"anims/"+file+".dat"));
    FrameBase FrameBase = new FrameBase(stream);
    int k1 = stream.readUnsignedWord();
    animationlist[file] = new Frame[k1 * 3];
    int[] ai = new int[500];
    int[] ai1 = new int[500];
    int[] ai2 = new int[500];
    int[] ai3 = new int[500];

    for(int l1 = 0; l1 < k1; ++l1) {
       int i2 = stream.readUnsignedWord();
       Frame Frame = animationlist[file][i2] = new Frame();
       Frame.aClass18_637 = FrameBase;
       int j2 = stream.readUnsignedByte();
       int l2 = 0;
       int k2 = -1;

       int k3;
       for(k3 = 0; k3 < j2; ++k3) {
          int j3 = stream.readUnsignedByte();
          if(j3 > 0) {
             if(FrameBase.transformationType[k3] != 0) {
                for(int var19 = k3 - 1; var19 > k2; --var19) {
                   if(FrameBase.transformationType[var19] == 0) {
                      ai[l2] = var19;
                      ai1[l2] = 0;
                      ai2[l2] = 0;
                      ai3[l2] = 0;
                      ++l2;
                      break;
                   }
                }
             }

             ai[l2] = k3;
             short var191 = 0;
             if(FrameBase.transformationType[k3] == 3) {
                var191 = 128;
             }

             if((j3 & 1) != 0) {
                ai1[l2] = (short)stream.readShort2();
             } else {
                ai1[l2] = var191;
             }

             if((j3 & 2) != 0) {
                ai2[l2] = stream.readShort2();
             } else {
                ai2[l2] = var191;
             }

             if((j3 & 4) != 0) {
                ai3[l2] = stream.readShort2();
             } else {
                ai3[l2] = var191;
             }

             k2 = k3;
             ++l2;
          }
       }
       Frame.stepCounter = l2;
       Frame.opcodeLinkTable = new int[l2];
       Frame.modifier1 = new int[l2];
       Frame.modifier2 = new int[l2];
       Frame.modifier3 = new int[l2];

       for(k3 = 0; k3 < l2; ++k3) {
          Frame.opcodeLinkTable[k3] = ai[k3];
          Frame.modifier1[k3] = ai1[k3];
          Frame.modifier2[k3] = ai2[k3];
          Frame.modifier3[k3] = ai3[k3];
       }
    }
    

 
    }
}
