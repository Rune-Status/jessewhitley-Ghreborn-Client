package com.Ghreborn.client.cache.bzip;

import com.Ghreborn.client.cache.bzip.BZip2DecompressionState;

public final class BZip2Decompressor {

   public static int decompress(byte[] output, int length, byte[] compressed, int decompressedLength, int minLen) {
      synchronized(state) {
         state.compressed = compressed;
         state.nextIn = minLen;
         state.decompressed = output;
         state.nextOut = 0;
         state.decompressedLength = decompressedLength;
         state.length = length;
         state.bsLive = 0;
         state.bsBuff = 0;
         state.totalInLo32 = 0;
         state.totalInHi32 = 0;
         state.totalOutLo32 = 0;
         state.totalOutHigh32 = 0;
         state.currentBlock = 0;
         decompress(state);
         length -= state.length;
         return length;
      }
   }

   private static void method226(BZip2DecompressionState state) {
      byte byte4 = state.aByte573;
      int i = state.anInt574;
      int j = state.anInt584;
      int k = state.anInt582;
      int[] ai = BZip2DecompressionState.anIntArray587;
      int l = state.anInt581;
      byte[] abyte0 = state.decompressed;
      int i1 = state.nextOut;
      int j1 = state.length;
      int l1 = state.anInt601 + 1;

      label67:
      while(true) {
         if(i > 0) {
            while(true) {
               if(j1 == 0) {
                  break label67;
               }

               if(i == 1) {
                  if(j1 == 0) {
                     i = 1;
                     break label67;
                  }

                  abyte0[i1] = byte4;
                  ++i1;
                  --j1;
                  break;
               }

               abyte0[i1] = byte4;
               --i;
               ++i1;
               --j1;
            }
         }

         boolean var16 = true;

         byte byte1;
         while(var16) {
            var16 = false;
            if(j == l1) {
               i = 0;
               break label67;
            }

            byte4 = (byte)k;
            l = ai[l];
            byte1 = (byte)(l & 255);
            l >>= 8;
            ++j;
            if(byte1 != k) {
               k = byte1;
               if(j1 == 0) {
                  i = 1;
                  break label67;
               }

               abyte0[i1] = byte4;
               ++i1;
               --j1;
               var16 = true;
            } else if(j == l1) {
               if(j1 == 0) {
                  i = 1;
                  break label67;
               }

               abyte0[i1] = byte4;
               ++i1;
               --j1;
               var16 = true;
            }
         }

         i = 2;
         l = ai[l];
         byte1 = (byte)(l & 255);
         l >>= 8;
         ++j;
         if(j != l1) {
            if(byte1 != k) {
               k = byte1;
            } else {
               i = 3;
               l = ai[l];
               byte byte2 = (byte)(l & 255);
               l >>= 8;
               ++j;
               if(j != l1) {
                  if(byte2 != k) {
                     k = byte2;
                  } else {
                     l = ai[l];
                     byte byte3 = (byte)(l & 255);
                     l >>= 8;
                     ++j;
                     i = (byte3 & 255) + 4;
                     l = ai[l];
                     k = (byte)(l & 255);
                     l >>= 8;
                     ++j;
                  }
               }
            }
         }
      }

      int var15 = state.totalOutLo32;
      state.totalOutLo32 += j1 - j1;
      if(state.totalOutLo32 < var15) {
         ++state.totalOutHigh32;
      }

      state.aByte573 = byte4;
      state.anInt574 = i;
      state.anInt584 = j;
      state.anInt582 = k;
      BZip2DecompressionState.anIntArray587 = ai;
      state.anInt581 = l;
      state.decompressed = abyte0;
      state.nextOut = i1;
      state.length = j1;
   }

   private static void decompress(BZip2DecompressionState state) {
      int gMinLen = 0;
      int[] gLimit = null;
      int[] gBase = null;
      int[] gPerm = null;
      state.anInt578 = 1;
      if(BZip2DecompressionState.anIntArray587 == null) {
         BZip2DecompressionState.anIntArray587 = new int[state.anInt578 * 0x186a0];
      }

      boolean flag19 = true;

      while(true) {
         while(flag19) {
            byte uc = getUnsignedChar(state);
            if(uc == 23) 
               return;
            uc = getUnsignedChar(state);
            uc = getUnsignedChar(state);
            uc = getUnsignedChar(state);
            uc = getUnsignedChar(state);
            uc = getUnsignedChar(state);
            ++state.currentBlock;
            uc = getUnsignedChar(state);
            uc = getUnsignedChar(state);
            uc = getUnsignedChar(state);
            uc = getUnsignedChar(state);
            uc = getBit(state);
			state.aBoolean575 = uc != 0; 
            state.randomised = 0;
            uc = getUnsignedChar(state);
            state.randomised = state.randomised << 8 | uc & 255;
            uc = getUnsignedChar(state);
            state.randomised = state.randomised << 8 | uc & 255;
            uc = getUnsignedChar(state);
            state.randomised = state.randomised << 8 | uc & 255;

            for(int j = 0; j < 16; ++j) {
               byte bit = getBit(state);
               state.inUse16[j] = bit == 1;
            }

            for(int k = 0; k < 256; ++k) {
               state.inUse[k] = false;
            }

            for(int l = 0; l < 16; ++l) {
               if(state.inUse16[l]) {
                  for(int i3 = 0; i3 < 16; ++i3) {
                     byte byte2 = getBit(state);
                     if(byte2 == 1) {
                        state.inUse[l * 16 + i3] = true;
                     }
                  }
               }
            }

            makeMaps(state);
            int alphabetSize = state.nInUse + 2;
			/*
			 * number of different Huffman tables in use
			 */
            int huffmanTableCount = getBits(3, state);
			/*
			 * number of times that the Huffman tables are swapped (each 50 bytes)
			 */
            int swapCount = getBits(15, state);

            for(int il = 0; il < swapCount; ++il) {
               int count = 0;

               while(true) {
                 byte l5 = getBit(state);
                  if(l5 == 0) {
                     state.selectorMtf[il] = (byte)count;
                     break;
                  }

                  ++count;
               }
            }

             byte[] pos = new byte[6];

        	for (byte v = 0; v < huffmanTableCount; v++)
				pos[v] = v;
        	
            for(int l4 = 0; l4 < swapCount; ++l4) {
               byte v = state.selectorMtf[l4];
       		byte tmp = pos[v];
       		
    		for (; v > 0; v--)
				pos[v] = pos[v - 1];

               pos[0] = tmp;
               state.selector[l4] = tmp;
            }

            for(int l4 = 0; l4 < huffmanTableCount; ++l4) {
               int var52 = getBits(5, state);

               for(int var53 = 0; var53 < alphabetSize; ++var53) {
                  while(true) {
                     byte var54 = getBit(state);
                     if(var54 == 0) {
                        state.aByteArrayArray596[l4][var53] = (byte)var52;
                        break;
                     }

                     var54 = getBit(state);
                     if(var54 == 0) {
                        ++var52;
                     } else {
                        --var52;
                     }
                  }
               }
            }

            int var56;
            for(int l4 = 0; l4 < huffmanTableCount; ++l4) {
                byte l5 = 32;
               int i5 = 0;

               for(var56 = 0; var56 < alphabetSize; ++var56) {
                  if(state.aByteArrayArray596[l4][var56] > i5) {
                     i5 = state.aByteArrayArray596[l4][var56];
                  }

                  if(state.aByteArrayArray596[l4][var56] < l5) {
                     l5 = state.aByteArrayArray596[l4][var56];
                  }
               }

               method232(state.limit[l4], state.base[l4], state.perm[l4], state.aByteArrayArray596[l4], l5, i5, alphabetSize);
               state.minLens[l4] = l5;
            }

            int l4 = state.nInUse + 1;

            int var53 = -1;
            int var55 = 0;

            for(int i2 = 0; i2 <= 255; ++i2) 
               state.unzftab[i2] = 0;
            

           int j9 = 4095;

            for(int i6 = 15; i6 >= 0; --i6) {
               for(int i7 = 15; i7 >= 0; --i7) {
                  state.mtfa[j9] = (byte)(i6 * 16 + i7);
                  --j9;
               }

               state.mtfbase[i6] = j9 + 1;
            }

            int i6 = 0;
            if(var55 == 0) {
               ++var53;
               var55 = 50;
               byte l7 = state.selector[var53];
               gMinLen = state.minLens[l7];
               gLimit = state.limit[l7];
               gPerm = state.perm[l7];
               gBase = state.base[l7];
            }

            var55--;
            int i7 = gMinLen;

            byte byte9;
            int var57;
            for(var57 = getBits(gMinLen, state); var57 > gLimit[i7]; var57 = var57 << 1 | byte9) {
               ++i7;
               byte9 = getBit(state);
            }

            int l2 = gPerm[var57 - gBase[i7]];

            while(true) {
               while(l2 != l4) {
                  int var59;
                  byte k7;
                  int j8;
                  byte byte11;
                  int var58;
                  if(l2 != 0 && l2 != 1) {
                     var59 = l2 - 1;
                     byte var591;
                     if(var59 < 16) {
                        var58 = state.mtfbase[0];

                        for(var591 = state.mtfa[var58 + var59]; var59 > 3; var59 -= 4) {
                           j8 = var58 + var59;
                           state.mtfa[j8] = state.mtfa[j8 - 1];
                           state.mtfa[j8 - 1] = state.mtfa[j8 - 2];
                           state.mtfa[j8 - 2] = state.mtfa[j8 - 3];
                           state.mtfa[j8 - 3] = state.mtfa[j8 - 4];
                        }

                        while(var59 > 0) {
                           state.mtfa[var58 + var59] = state.mtfa[var58 + var59 - 1];
                           --var59;
                        }

                        state.mtfa[var58] = var591;
                     } else {
                        var58 = var59 / 16;
                        j8 = var59 % 16;
                        int var60 = state.mtfbase[var58] + j8;

                        for(var591 = state.mtfa[var60]; var60 > state.mtfbase[var58]; --var60) {
                           state.mtfa[var60] = state.mtfa[var60 - 1];
                        }

                        ++state.mtfbase[var58];

                        while(var58 > 0) {
                           --state.mtfbase[var58];
                           state.mtfa[state.mtfbase[var58]] = state.mtfa[state.mtfbase[var58 - 1] + 16 - 1];
                           --var58;
                        }

                        --state.mtfbase[0];
                        state.mtfa[state.mtfbase[0]] = var591;
                        if(state.mtfbase[0] == 0) {
                           int i10 = 4095;

                           for(int k9 = 15; k9 >= 0; --k9) {
                              for(int l9 = 15; l9 >= 0; --l9) {
                                 state.mtfa[i10] = state.mtfa[state.mtfbase[k9] + l9];
                                 --i10;
                              }

                              state.mtfbase[k9] = i10 + 1;
                           }
                        }
                     }

                     ++state.unzftab[state.aByteArray591[var591 & 255] & 255];
                     BZip2DecompressionState.anIntArray587[i6] = state.aByteArray591[var591 & 255] & 255;
                     ++i6;
                     if(var55 == 0) {
                        ++var53;
                        var55 = 50;
                        k7 = state.selector[var53];
                        gMinLen = state.minLens[k7];
                        gLimit = state.limit[k7];
                        gPerm = state.perm[k7];
                        gBase = state.base[k7];
                     }

                     --var55;
                     var58 = gMinLen;

                     for(j8 = getBits(gMinLen, state); j8 > gLimit[var58]; j8 = j8 << 1 | byte11) {
                        ++var58;
                        byte11 = getBit(state);
                     }

                     l2 = gPerm[j8 - gBase[var58]];
                  } else {
                     var59 = -1;
                     int byte6 = 1;

                     do {
                        if(l2 == 0) {
                           var59 += byte6;
                        } else if(l2 == 1) {
                           var59 += 2 * byte6;
                        }

                        byte6 *= 2;
                        if(var55 == 0) {
                           ++var53;
                           var55 = 50;
                           k7 = state.selector[var53];
                           gMinLen = state.minLens[k7];
                           gLimit = state.limit[k7];
                           gPerm = state.perm[k7];
                           gBase = state.base[k7];
                        }

                        --var55;
                        var58 = gMinLen;

                        for(j8 = getBits(gMinLen, state); j8 > gLimit[var58]; j8 = j8 << 1 | byte11) {
                           ++var58;
                           byte11 = getBit(state);
                        }

                        l2 = gPerm[j8 - gBase[var58]];
                     } while(l2 == 0 || l2 == 1);

                     ++var59;
                     k7 = state.aByteArray591[state.mtfa[state.mtfbase[0]] & 255];

                     for(state.unzftab[k7 & 255] += var59; var59 > 0; --var59) {
                        BZip2DecompressionState.anIntArray587[i6] = k7 & 255;
                        ++i6;
                     }
                  }
               }

               state.anInt574 = 0;
               state.aByte573 = 0;
               state.anIntArray585[0] = 0;

               for(l2 = 1; l2 <= 256; ++l2) {
                  state.anIntArray585[l2] = state.unzftab[l2 - 1];
               }

               for(l2 = 1; l2 <= 256; ++l2) {
                  state.anIntArray585[l2] += state.anIntArray585[l2 - 1];
               }

               for(l2 = 0; l2 < i6; ++l2) {
                  byte var581 = (byte)(BZip2DecompressionState.anIntArray587[l2] & 255);
                  BZip2DecompressionState.anIntArray587[state.anIntArray585[var581 & 255]] |= l2 << 8;
                  ++state.anIntArray585[var581 & 255];
               }

               state.anInt581 = BZip2DecompressionState.anIntArray587[state.randomised] >> 8;
               state.anInt584 = 0;
               state.anInt581 = BZip2DecompressionState.anIntArray587[state.anInt581];
               state.anInt582 = (byte)(state.anInt581 & 255);
               state.anInt581 >>= 8;
               ++state.anInt584;
               state.anInt601 = i6;
               method226(state);
               if(state.anInt584 == state.anInt601 + 1 && state.anInt574 == 0) {
                  flag19 = true;
                  break;
               }

               flag19 = false;
               break;
            }
         }

         return;
      }
   }

   private static byte getUnsignedChar(BZip2DecompressionState state) {
      return (byte)getBits(8, state);
   }

   private static byte getBit(BZip2DecompressionState state) {
      return (byte)getBits(1, state);
   }

   private static int getBits(int i, BZip2DecompressionState state) {
      while(state.bsLive < i) {
         state.bsBuff = state.bsBuff << 8 | state.compressed[state.nextIn] & 255;
         state.bsLive += 8;
         ++state.nextIn;
         --state.decompressedLength;
         ++state.totalInLo32;
         if(state.totalInLo32 == 0) {
            ++state.totalInHi32;
         }
      }

      int k = state.bsBuff >> state.bsLive - i & (1 << i) - 1;
      state.bsLive -= i;
      return k;
   }

   private static void makeMaps(BZip2DecompressionState state) {
      state.nInUse = 0;

      for(int i = 0; i < 256; ++i) {
         if(state.inUse[i]) {
            state.aByteArray591[state.nInUse] = (byte)i;
            ++state.nInUse;
         }
      }

   }

   private static void method232(int[] ai, int[] ai1, int[] ai2, byte[] abyte0, int i, int j, int k) {
      int l = 0;

      int i3;
      int k2;
      for(i3 = i; i3 <= j; ++i3) {
         for(k2 = 0; k2 < k; ++k2) {
            if(abyte0[k2] == i3) {
               ai2[l] = k2;
               ++l;
            }
         }
      }

      for(i3 = 0; i3 < 23; ++i3) {
         ai1[i3] = 0;
      }

      for(i3 = 0; i3 < k; ++i3) {
         ++ai1[abyte0[i3] + 1];
      }

      for(i3 = 1; i3 < 23; ++i3) {
         ai1[i3] += ai1[i3 - 1];
      }

      for(i3 = 0; i3 < 23; ++i3) {
         ai[i3] = 0;
      }

      i3 = 0;

      for(k2 = i; k2 <= j; ++k2) {
         i3 += ai1[k2 + 1] - ai1[k2];
         ai[k2] = i3 - 1;
         i3 <<= 1;
      }

      for(k2 = i + 1; k2 <= j; ++k2) {
         ai1[k2] = (ai[k2 - 1] + 1 << 1) - ai1[k2];
      }

   }
   private static BZip2DecompressionState state = new BZip2DecompressionState();
}
