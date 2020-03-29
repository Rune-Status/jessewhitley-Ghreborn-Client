package com.Ghreborn.client.cache.def;

import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.cache.anim.Frame;
import com.Ghreborn.client.io.Buffer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Animation {
	
	public static void setAnimBase(int j){
		anims[j].frameCount = anims[808].frameCount;
		anims[j].primary = anims[808].primary;
		anims[j].secondary = anims[808].secondary;
		anims[j].duration = anims[808].duration;
		anims[j].loopOffset = anims[808].loopOffset;
		anims[j].interleaveOrder = anims[808].interleaveOrder;
		anims[j].forcedwalkingPrecedence = anims[808].forcedwalkingPrecedence;
		anims[j].playerOffhand = anims[808].playerOffhand;
		anims[j].playerMainhand = anims[808].playerMainhand;
		anims[j].maxLoops = anims[808].maxLoops;
		anims[j].animatingPrecedence = anims[808].animatingPrecedence;
		anims[j].walkingPrecedence = anims[808].walkingPrecedence;
		anims[j].replayMode = anims[808].replayMode;
		anims[j].anInt366 = anims[808].anInt366;
		anims[j].frameCount = anims[808].frameCount;
		}
   public int anInt366;
   public static int anInt367;
   private int anInt348 = 9;
   private boolean aBoolean349 = false;
   public int loopOffset = -1;
   public boolean stretches = false;
   public int forcedwalkingPrecedence = 5;
   public int playerOffhand = -1;
   public static int length;
   public int playerMainhand = -1;
   public int maxLoops = 99;
   public int animatingPrecedence = -1;
   public int walkingPrecedence = -1;
   public int replayMode = 2;
   public static Animation[] anims;
   public int frameCount;
   public int[] primary;
   public int[] secondary;
   int[] duration;
   public int[] interleaveOrder;
	public int[] anIntArray107;
    public static int[] FrameStart = new int[10000];
	int[] anIntArray106;

   public static void method257(int i, StreamLoader class44) {
      Buffer stream = new Buffer(class44.readFile("seq.dat"));
       length = stream.readUShort();
      if(anims == null) {
         anims = new Animation[length + 10000];
      }

      for(int j = 0; j < length; ++j) {
         if(anims[j] == null) {
            anims[j] = new Animation();
            if(j < length) {
                anims[j].decodeOSRS(stream);
            } else if(j >= 8523) 
                   anims[j].decode(stream);
            
            if(j == 10917){ //Tormented demon dieing  animation
      				int file = 2682;
      				Frame.load_647(file);
      				int[] frames = {175767656, 175767819, 175767590, 175767684, 175767593, 175767773, 175767583, 175767625, 175767587, 175767696, 175767783, 175767745, 175767799, 175767623, 175767849, 175767759, 175767672, 175767870, 175767904, 175767577, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910, 175767624, 175767910};
      				int[] duration = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
      				anims[j].frameCount = frames.length-11;
      				anims[j].primary = new int[frames.length-1];
      				anims[j].secondary = new int[frames.length-1];
      				anims[j].duration = new int[frames.length+1];
      				for(int i2 = 0; i2 < frames.length-1; i2++){
      					anims[j].primary[i2] = frames[i2]+FrameStart[file];
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
            if(j == 9158){ //whip attack
      				int file = 3260;
      				if(FrameStart[file] < 1)
      				Frame.methodCustomAnimations(file);
      				int[] frames = {148111670, 148111864, 148111550, 148111492, 148111676, 148111543, 148111506, 148111774};
      				int[] duration = {5, 5, 5, 5, 5, 5, 5, 5};
      				anims[j].frameCount = 8;
      				anims[j].primary = new int[frames.length-1];
      				anims[j].secondary = new int[frames.length-1];
      				anims[j].duration = new int[frames.length-1];
      				for(int i2 = 0; i2 < frames.length-1; i2++){
      					anims[j].primary[i2] = frames[i2]+FrameStart[file];
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
            if(j == 13156){ //Forst dragon stand
      				int file = 3141;
      				if(FrameStart[file] < 1)
      				Frame.load_647(file);
      				int[] frames = {205848638, 205848650, 205848653, 205848769, 205848693, 205848593, 205848586, 205848685, 205848732, 205848625, 205848577, 205848620, 205848679, 205848725, 205848753, 205848605, 205848638, 205848650, 205848653, 205848769, 205848693, 205848593, 205848586, 205848685, 205848732, 205848625, 205848577, 205848620, 205848679, 205848725, 205848753, 205848605, 205848638, 205848643, 205848717, 205848641, 205848587, 205848742, 205848607, 205848634, 205848764, 205848772, 205848665, 205848609, 205848774, 205848668, 205848638, 205848650, 205848653, 205848769, 205848693, 205848593, 205848586, 205848685, 205848732, 205848625, 205848577, 205848620, 205848679, 205848725, 205848753, 205848605, 205848638, 205848650, 205848653, 205848769, 205848693, 205848593, 205848586, 205848685, 205848732, 205848625, 205848577, 205848620, 205848679, 205848725, 205848753, 205848605, 205848638, 205848650, 205848653, 205848769, 205848693, 205848593, 205848586, 205848685, 205848732, 205848625, 205848577, 205848620, 205848679, 205848725, 205848753, 205848605, 205848608, 205848734, 205848710, 205848765, 205848730, 205848615, 205848667, 205848747, 205848713, 205848770, 205848702, 205848728, 205848654, 205848633, 205848759, 205848663, 205848696, 205848629, 205848760, 205848773, 205848692, 205848636, 205848689, 205848644, 205848736, 205848750, 205848626, 205848704};
      				int[] duration = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 5, 4, 5, 4, 4, 4, 4, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5};
      				anims[j].frameCount = frames.length-1;
      				anims[j].primary = new int[frames.length-1];
      				anims[j].secondary = new int[frames.length-1];
      				anims[j].duration = new int[frames.length-1];
      				for(int i2 = 0; i2 < frames.length-1; i2++){
      					anims[j].primary[i2] = frames[i2]+FrameStart[file];
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
            if(j == 11968){ //whip attack
      				int file = 3300;
      				if(FrameStart[file] < 1)
      				Frame.load_647(file);
      				int[] frames = {19661078, 19661123, 19661086, 19661102, 19661114, 19661129, 19661088, 19661105, 19661118, 19661137, 19661110, 19661079, 19661104, 19661119, 19661125, 19661120, 19661107, 19661078};
      				int[] duration = {2, 2, 2, 2, 2, 2, 5, 2, 2, 1, 1, 5, 5, 2, 1, 1, 1, 2};
      				anims[j].frameCount = frames.length-1;
      				anims[j].primary = new int[frames.length-1];
      				anims[j].secondary = new int[frames.length-1];
      				anims[j].duration = new int[frames.length-1];
      				for(int i2 = 0; i2 < frames.length-1; i2++){
      					anims[j].primary[i2] = frames[i2]+FrameStart[file];
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
            if(j == 11969){ //whip attack
      				int file = 3300;
      				if(FrameStart[file] < 1)
      				Frame.load_647(file);
      				int[] frames = {19661078, 19661123, 19661086, 19661102, 19661114, 19661129, 19661088, 19661105, 19661118, 19661137, 19661110, 19661079, 19661104, 19661119, 19661125, 19661120, 19661107, 19661078};
      				int[] frames2 = {1, 2, 9, 11, 13, 15, 17, 19, 45, 57, 70, 71, 73, 157, 159, 160, 162, 164, 166, 168, 169, 171, 173, 187, 189, 213, 215, 216, 218, 220, 224, 226, 227, 229, 230, 231, 236, 237, 238, 9999999};
      				int[] duration = {2, 2, 2, 2, 2, 2, 5, 2, 2, 1, 1, 5, 5, 2, 1, 1, 1, 2};
      				anims[j].frameCount = frames.length-1;
      				anims[j].primary = new int[frames.length-1];
      				anims[j].secondary = new int[frames2.length-1];
      				anims[j].duration = new int[frames.length-1];
      				for(int i2 = 0; i2 < frames.length-1; i2++){
      					anims[j].primary[i2] = frames[i2]+FrameStart[file];
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
            if(j == 13155){ //Forst dragon attack
      				int file = 3141;
      				if(FrameStart[file] < 1)
      				Frame.load_647(file);
      				int[] frames = {205848705, 205848714, 205848740, 205848580, 205848684, 205848698, 205848699, 205848660, 205848763, 205848645, 205848657, 205848670, 205848613, 205848722, 205848701, 205848767, 205848631, 205848707, 205848751, 205848746, 205848604, 205848762, 205848632, 205848687, 205848585, 205848695, 205848594};
      				int[] duration = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 3, 3, 3, 3, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3};
      				anims[j].frameCount = frames.length-1;
      				anims[j].primary = new int[frames.length-1];
      				anims[j].secondary = new int[frames.length-1];
      				anims[j].duration = new int[frames.length-1];
      				for(int i2 = 0; i2 < frames.length-1; i2++){
      					anims[j].primary[i2] = frames[i2]+FrameStart[file];
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
            if(j == 13154){ //Forst dragon Block
      				int file = 3141;
      				if(FrameStart[file] < 1)
      				Frame.load_647(file);
      				int[] frames = {205848576, 205848606, 205848614, 205848709, 205848628, 205848697, 205848691, 205848755, 205848721, 205848583, 205848648, 205848766, 205848639, 205848598, 205848694};
      				int[] duration = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
      				anims[j].frameCount = frames.length-1;
      				anims[j].primary = new int[frames.length-1];
      				anims[j].secondary = new int[frames.length-1];
      				anims[j].duration = new int[frames.length-1];
      				for(int i2 = 0; i2 < frames.length-1; i2++){
      					anims[j].primary[i2] = frames[i2]+FrameStart[file];
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
           if(j == 13153){ //Forst dragon death
      				int file = 3141;
      				if(FrameStart[file] < 1)
      				Frame.load_647(file);
      				int[] frames = {205848623, 205848612, 205848602, 205848595, 205848716, 205848672, 205848673, 205848578, 205848675, 205848715, 205848778, 205848661, 205848616, 205848662, 205848780, 205848731, 205848738, 205848681, 205848664, 205848674, 205848669, 205848603, 205848706, 205848618, 205848719, 205848737};
      				int[] duration = {5, 5, 5, 5, 5, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3, 5, 5, 3, 3, 9, 25, 11};
      				anims[j].frameCount = frames.length-1;
      				anims[j].primary = new int[frames.length-1];
      				anims[j].secondary = new int[frames.length-1];
      				anims[j].duration = new int[frames.length-1];
      				for(int i2 = 0; i2 < frames.length-1; i2++){
      					anims[j].primary[i2] = frames[i2]+FrameStart[file];
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
            if(j == 13157){ //Forst dragon walk
      				int file = 3141;
      				if(FrameStart[file] < 1)
      				Frame.load_647(file);
      				int[] frames = {205848610, 205848756, 205848622, 205848743, 205848741, 205848637, 205848651, 205848640, 205848655, 205848727, 205848682, 205848777, 205848611, 205848690, 205848621, 205848646};
      				int[] duration = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
      				anims[j].frameCount = frames.length-1;
      				anims[j].primary = new int[frames.length-1];
      				anims[j].secondary = new int[frames.length-1];
      				anims[j].duration = new int[frames.length-1];
      				for(int i2 = 0; i2 < frames.length-1; i2++){
      					anims[j].primary[i2] = frames[i2]+FrameStart[file];
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
            if(j == 10918){ //Tormented demon magic attack animation
      				int file = 2682;
     		         if(Frame.frames.get(Integer.valueOf(file)) == null) {
       		            Frame.customGhettoAnimations(false, file);
       		         }
      				int[] frames = {175767584, 175767678, 175767911, 175767705, 175767667, 175767728, 175767558, 175767871, 175767674, 175767877, 175767884, 175767766, 175767584};
      				int[] duration = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
      				anims[j].frameCount = frames.length;
      				anims[j].primary = new int[frames.length];
      				anims[j].secondary = new int[frames.length];
      				anims[j].duration = new int[frames.length];
      				for(int i2 = 0; i2 < frames.length; i2++){
      					anims[j].primary[i2] = frames[i2] + (file << 16);
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
            if(j == 10919){ //Tormented demon range attack animation
      				int file = 3682;
     		         if(Frame.frames.get(Integer.valueOf(file)) == null) {
       		            Frame.customGhettoAnimations(false, file);
       		         }
      				int[] frames = {175767864, 175767639, 175767750, 175767659, 175767751, 175767716, 175767839, 175767880, 175767675, 175767900, 175767573, 175767592, 175767760, 175767863, 175767671, 175767643, 175767858, 175767563, 175767702, 175767790, 175767850, 175767620, 175767888, 175767560, 175767695, 175767569, 175767736, 175767604};
      				int[] duration = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
      				anims[j].frameCount = frames.length;
      				anims[j].primary = new int[frames.length];
      				anims[j].secondary = new int[frames.length];
      				anims[j].duration = new int[frames.length];
      				for(int i2 = 0; i2 < frames.length; i2++){
      					anims[j].primary[i2] = frames[i2] + (file << 16);
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
            if(j == 10920){ //Tormented demon wilk animation
      				int file = 3682;
      		         if(Frame.frames.get(Integer.valueOf(file)) == null) {
      		            Frame.customGhettoAnimations(false, file);
      		         }

      				int[] frames = {175767889, 175767621, 175767724, 175767788, 175767787, 175767682, 175767677, 175767605, 175767795, 175767706, 175767738, 175767891, 175767622, 175767833, 175767893, 175767777, 175767554, 175767895, 175767669, 175767883, 175767565, 175767804, 175767798, 175767649, 175767841, 175767641, 175767807, 175767868, 175767756, 175767830, 175767794, 175767664};
      				int[] duration = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
      				anims[j].frameCount = frames.length-1;
      				anims[j].primary = new int[frames.length-1];
      				anims[j].secondary = new int[frames.length-1];
      				anims[j].duration = new int[frames.length-1];
      				for(int i2 = 0; i2 < frames.length-1; i2++){
      					anims[j].primary[i2] = frames[i2]+FrameStart[file];
      					anims[j].secondary[i2] = -1;
      					anims[j].duration[i2] = duration[i2];
      				}
      			}
      if(j == 10921){ //Tormented demon Stand animation
				int file = 3682;
 		         if(Frame.frames.get(Integer.valueOf(file)) == null) {
   		            Frame.customGhettoAnimations(false, file);
   		         }
				int[] frames = {175767610, 175767660, 175767903, 175767601, 175767816, 175767901, 175767838, 175767578, 175767596, 175767616, 175767774, 175767808, 175767715, 175767782, 175767600, 175767679, 175767610, 175767660, 175767903, 175767601, 175767816, 175767901, 175767838, 175767595, 175767608, 175767612, 175767609, 175767808, 175767715, 175767782, 175767600, 175767679};
				int[] duration = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
  				anims[j].frameCount = frames.length;
  				anims[j].primary = new int[frames.length];
  				anims[j].secondary = new int[frames.length];
  				anims[j].duration = new int[frames.length];
  				for(int i2 = 0; i2 < frames.length; i2++){
  					anims[j].primary[i2] = frames[i2] + (file << 16);
  					anims[j].secondary[i2] = -1;
  					anims[j].duration[i2] = duration[i2];
  				}
			}
      if(j == 10922){ //Tormented demon Melee Attack - Slash  animation
				int file = 3682;
 		         if(Frame.frames.get(Integer.valueOf(file)) == null) {
   		            Frame.customGhettoAnimations(false, file);
   		         }
				int[] frames = {175767831, 175767806, 175767786, 175767597, 175767579, 175767809, 175767741, 175767822, 175767765, 175767762, 175767775, 175767810, 175767647, 175767779, 175767714, 175767831};
				int[] duration = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 5, 3, 3, 3, 3, 3};
				anims[j].frameCount = frames.length-1;
				anims[j].primary = new int[frames.length-1];
				anims[j].secondary = new int[frames.length-1];
				anims[j].duration = new int[frames.length-1];
				for(int i2 = 0; i2 < frames.length-1; i2++){
					anims[j].primary[i2] = frames[i2]+FrameStart[file];
					anims[j].secondary[i2] = -1;
					anims[j].duration[i2] = duration[i2];
				}
			}
      if(j == 10923){ //Tormented demon Block  animation
				int file = 3682;
 		         if(Frame.frames.get(Integer.valueOf(file)) == null) {
   		            Frame.customGhettoAnimations(false, file);
   		         }
				int[] frames = {175767690, 175767847, 175767908, 175767668, 175767855, 175767570, 175767657, 175767692, 175767637, 175767615, 175767588, 175767851, 175767752, 175767853, 175767571, 175767614, 175767732, 175767553, 175767557, 175767898, 175767720, 175767740, 175767648, 175767866, 175767661, 175767645, 175767691, 175767626, 175767690, 175767748};
				int[] duration = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
  				anims[j].frameCount = frames.length;
  				anims[j].primary = new int[frames.length];
  				anims[j].secondary = new int[frames.length];
  				anims[j].duration = new int[frames.length];
  				for(int i2 = 0; i2 < frames.length; i2++){
  					anims[j].primary[i2] = frames[i2] + (file << 16);
  					anims[j].secondary[i2] = -1;
  					anims[j].duration[i2] = duration[i2];
  				}
			}
      if(j == 10924){ //Tormented demon death  animation
				int file = 3682;
 		         if(Frame.frames.get(Integer.valueOf(file)) == null) {
   		            Frame.customGhettoAnimations(false, file);
   		         }
				int[] frames = {175767656, 175767819, 175767590, 175767684, 175767593, 175767773, 175767583, 175767625, 175767587, 175767696, 175767783, 175767745, 175767799, 175767623, 175767849, 175767759, 175767672, 175767870, 175767904, 175767577, 175767624, 175767910, 175767611, 175767832, 175767886, 175767651, 175767730, 175767856, 175767785, 175767721, 175767627, 175767694, 175767701, 175767652, 175767683, 175767869, 175767896, 175767662, 175767812, 175767820, 175767638, 175767905, 175767905, 175767905};
				int[] duration = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 40, 40, 40, 24};
				anims[j].frameCount = frames.length-1;
				anims[j].primary = new int[frames.length-1];
				anims[j].secondary = new int[frames.length-1];
				anims[j].duration = new int[frames.length-1];
				for(int i2 = 0; i2 < frames.length-1; i2++){
					anims[j].primary[i2] = frames[i2]+FrameStart[file];
					anims[j].secondary[i2] = -1;
					anims[j].duration[i2] = duration[i2];
				}
			}
      if(j == 10926){
    	  anims[j].frameCount = 0;
      }
      if(j == 10928){ //Tormented demon gfx anim 2 animation
				int file = 3646;
 		         if(Frame.frames.get(Integer.valueOf(file)) == null) {
   		            Frame.customGhettoAnimations(false, file);
   		         }
				int[] frames = {173408267, 173408259, 173408260, 173408265, 173408256, 173408263, 173408264, 173408262, 173408258, 173408257, 173408266, 173408261};
				int[] duration = {30, 5, 3, 3, 2, 2, 2, 2, 2, 2, 2, 2};
  				anims[j].frameCount = frames.length;
  				anims[j].primary = new int[frames.length];
  				anims[j].secondary = new int[frames.length];
  				anims[j].duration = new int[frames.length];
  				for(int i2 = 0; i2 < frames.length; i2++){
  					anims[j].primary[i2] = frames[i2] + (file << 16);
  					anims[j].secondary[i2] = -1;
  					anims[j].duration[i2] = duration[i2];
  				}
			}
      if(j == 10927){ //Tormented demon gfx anim 1 animation
				int file = 3653;
 		         if(Frame.frames.get(Integer.valueOf(file)) == null) {
   		            Frame.customGhettoAnimations(false, file);
   		         }
				int[] frames = {173867056, 173867040, 173867067, 173867061, 173867035, 173867063, 173867030, 173867049, 173867023, 173867066, 173867038, 173867025, 173867008, 173867009, 173867010, 173867054, 173867057, 173867043, 173867052, 173867062, 173867012, 173867070, 173867029, 173867041, 173867036, 173867042, 173867018, 173867026, 173867028, 173867027, 173867050, 173867031, 173867065, 173867064, 173867021, 173867022, 173867055, 173867045, 173867044, 173867060, 173867059, 173867046, 173867048, 173867034, 173867068, 173867032, 173867069};
				int[] duration = {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
  				anims[j].frameCount = frames.length;
  				anims[j].primary = new int[frames.length];
  				anims[j].secondary = new int[frames.length];
  				anims[j].duration = new int[frames.length];
  				for(int i2 = 0; i2 < frames.length; i2++){
  					anims[j].primary[i2] = frames[i2] + (file << 16);
  					anims[j].secondary[i2] = -1;
  					anims[j].duration[i2] = duration[i2];
  				}
			}
            
         }
      }
  
         
     // dumpValues(length);
      System.out.println("Loaded: " + length + " Animations");
   }

   public int method258(int i) {
      int j = this.duration[i];
      if(j == 0) {
         Frame var5 = Frame.method531(this.primary[i]);
         if(var5 != null)
            j = this.duration[i] = var5.stepCounter;
      }

      if(j == 0) 
         j = 1;

      return j;
   }

   public static void dumpValues(int length) {
      System.out.println("Dumping Animations..");
      String[] variablesNames = new String[]{"frameCount", "primary", "secondary", "duration", "loopOffset", "interleaveOrder", "stretches", "forcedwalkingPrecedence", "playerOffhand", "playerMainhand", "maxLoops", "animatingPrecedence", "walkingPrecedence", "replayMode"};
      File f = new File(SignLink.findcachedir() + "/dumps/anims.txt");

      try {
         f.createNewFile();
         BufferedWriter var21 = new BufferedWriter(new FileWriter(f));

         for(int j = 0; j < length; ++j) {
            String frameCount = String.valueOf(anims[j].frameCount);
            String primary = Arrays.toString(anims[j].primary);
            String secondary = Arrays.toString(anims[j].secondary);
            String duration = Arrays.toString(anims[j].duration);
            String loopOffset = String.valueOf(anims[j].loopOffset);
            String interleaveOrder = Arrays.toString(anims[j].interleaveOrder);
            String stretches = String.valueOf(anims[j].stretches);
            String forcedwalkingPrecedence = String.valueOf(anims[j].forcedwalkingPrecedence);
            String playerOffhand = String.valueOf(anims[j].playerOffhand);
            String playerMainhand = String.valueOf(anims[j].playerMainhand);
            String maxLoops = String.valueOf(anims[j].maxLoops);
            String animatingPrecedence = String.valueOf(anims[j].animatingPrecedence);
            String walkingPrecedence = String.valueOf(anims[j].walkingPrecedence);
            String replayMode = String.valueOf(anims[j].replayMode);
            String[] variables = new String[]{frameCount, primary, secondary, duration, loopOffset, interleaveOrder, stretches, forcedwalkingPrecedence, playerOffhand, playerMainhand, maxLoops, animatingPrecedence, walkingPrecedence, replayMode};
            var21.write("if (j == " + j + ") {\n");

            for(int k = 0; k < variables.length; ++k) {
               var21.write("anims[" + j + "]." + variablesNames[k] + " = " + variables[k] + ";\n");
            }

            var21.write("}\n\n");
         }

         var21.close();
      } catch (IOException var211) {
         var211.printStackTrace();
      }

      System.out.println("Dumping Complete!");
   }

	private void decodeOSRS(Buffer buffer) {
		while(true) {
			final int opcode = buffer.readUnsignedByte();

			if (opcode == 0) {
				break;
			} else if (opcode == 1) {
				frameCount = buffer.readUShort();
				primary = new int[frameCount];
				secondary = new int[frameCount];
				duration = new int[frameCount];

				for (int i = 0; i < frameCount; i++) {
					duration[i] = buffer.readUShort();
				}

				for (int i = 0; i < frameCount; i++) {
					primary[i] = buffer.readUShort();
					secondary[i] = -1;
				}

				for (int i = 0; i < frameCount; i++) {
					primary[i] += buffer.readUShort() << 16;
				}

//				for (int i = 0; i < frameCount; i++) { // walking works but godswords break
//					primaryFrames[i] = buffer.readInt();
//					secondaryFrames[i] = -1;
//				}

//                for (int i = 0; i < frameCount; i++) { // walking breaks godswords work
//                    primaryFrames[i] = buffer.readUShort();
//                    secondaryFrames[i] = -1;
//                }
//
//                for (int i = 0; i < frameCount; i++) {
//                    primaryFrames[i] =+ buffer.readUShort() << 16;
//                }




			} else if (opcode == 2) {
				loopOffset = buffer.readUShort();
			} else if (opcode == 3) {
				int len = buffer.readUnsignedByte();
				interleaveOrder = new int[len + 1];
				for (int i = 0; i < len; i++) {
					interleaveOrder[i] = buffer.readUnsignedByte();
				}
				interleaveOrder[len] = 9999999;
			} else if (opcode == 4) {
				stretches = true;
			} else if (opcode == 5) {
				forcedwalkingPrecedence = buffer.readUnsignedByte();
			} else if (opcode == 6) {
				playerOffhand = buffer.readUShort();
			} else if (opcode == 7) {
				playerMainhand = buffer.readUShort();
			} else if (opcode == 8) {
				maxLoops = buffer.readUnsignedByte();
			} else if (opcode == 9) {
				animatingPrecedence = buffer.readUnsignedByte();
			} else if (opcode == 10) {
				walkingPrecedence = buffer.readUnsignedByte();
			} else if (opcode == 11) {
				replayMode = buffer.readUnsignedByte();
			} else if (opcode == 12) {
				int len = buffer.readUnsignedByte();

				for (int i = 0; i < len; i++) {
					buffer.readUShort();
				}

				for (int i = 0; i < len; i++) {
					buffer.readUShort();
				}
			} else if (opcode == 13) {
				int len = buffer.readUnsignedByte();

				for (int i = 0; i < len; i++) {
					buffer.read24BitInt();
				}
			}
		}


      if(this.frameCount == 0) {
         this.frameCount = 1;
         this.primary = new int[1];
         this.primary[0] = -1;
         this.secondary = new int[1];
         this.secondary[0] = -1;
         this.duration = new int[1];
         this.duration[0] = -1;
      }

		if (animatingPrecedence == -1) {
			animatingPrecedence = (interleaveOrder == null) ? 0 : 2;
		}

		if (walkingPrecedence == -1) {
			walkingPrecedence = (interleaveOrder == null) ? 0 : 2;
		}

   }
	private void decode(Buffer buffer) {
		while(true) {
			final int opcode = buffer.readUnsignedByte();

			if (opcode == 0) {
				break;
			} else if (opcode == 1) {
				frameCount = buffer.readUnsignedWord();
				primary = new int[frameCount];
				secondary = new int[frameCount];
				duration = new int[frameCount];
				for (int i = 0; i < frameCount; i++) {
					primary[i] = buffer.readDWord();
					secondary[i] = -1;
				}

				for (int i = 0; i < frameCount; i++) {
					duration[i] = buffer.readUnsignedByte();
				}

			} else if (opcode == 2) {
				loopOffset = buffer.readUShort();
			} else if (opcode == 3) {
				int len = buffer.readUnsignedByte();
				interleaveOrder = new int[len + 1];
				for (int i = 0; i < len; i++) {
					interleaveOrder[i] = buffer.readUnsignedByte();
				}
				interleaveOrder[len] = 9999999;
			} else if (opcode == 4) {
				stretches = true;
			} else if (opcode == 5) {
				forcedwalkingPrecedence = buffer.readUnsignedByte();
			} else if (opcode == 6) {
				playerOffhand = buffer.readUShort();
			} else if (opcode == 7) {
				playerMainhand = buffer.readUShort();
			} else if (opcode == 8) {
				maxLoops = buffer.readUnsignedByte();
			} else if (opcode == 9) {
				animatingPrecedence = buffer.readUnsignedByte();
			} else if (opcode == 10) {
				walkingPrecedence = buffer.readUnsignedByte();
			} else if (opcode == 11) {
				replayMode = buffer.readUnsignedByte();
            } else {
                System.out.println("Unrecognized seq.dat config code: " + opcode);
             }
		}
      if(this.frameCount == 0) {
         this.frameCount = 1;
         this.primary = new int[1];
         this.primary[0] = -1;
         this.secondary = new int[1];
         this.secondary[0] = -1;
         this.duration = new int[1];
         this.duration[0] = -1;
      }

		if (animatingPrecedence == -1) {
			animatingPrecedence = (interleaveOrder == null) ? 0 : 2;
		}

		if (walkingPrecedence == -1) {
			walkingPrecedence = (interleaveOrder == null) ? 0 : 2;
		}

   }
	private Animation() {
		animatingPrecedence = -1; //Stops character from moving
		walkingPrecedence = -1;
		replayMode = 1;
	}
}
