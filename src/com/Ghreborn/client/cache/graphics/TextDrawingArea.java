package com.Ghreborn.client.cache.graphics;

import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.draw.DrawingArea;
import com.Ghreborn.client.io.Buffer;

import java.util.Random;

public final class TextDrawingArea extends DrawingArea {
   private boolean aBoolean1484 = false;
   private int anInt1485 = 445;
   private int anInt1486 = -471;
   private int anInt1487 = -471;
   private boolean aBoolean1488 = false;
   private int anInt1489 = 3;
   private boolean aBoolean1490 = false;
   byte[][] aByteArrayArray1491 = new byte[256][];
   int[] anIntArray1492 = new int[256];
   int[] anIntArray1493 = new int[256];
   int[] anIntArray1494 = new int[256];
   int[] anIntArray1495 = new int[256];
   public int[] anIntArray1496 = new int[256];
   Random aRandom1498 = new Random();
   boolean aBoolean1499 = false;
   public int anInt1497;

   public TextDrawingArea(boolean flag, String s, int i, StreamLoader class44) {
      Buffer class30_sub2_sub2 = new Buffer(class44.readFile(s + ".dat"), 891);
      Buffer class30_sub2_sub2_1 = new Buffer(class44.readFile("index.dat"), 891);
      boolean byte0 = true;
      if(i != 0) {
         this.aBoolean1490 = !this.aBoolean1490;
      }

      class30_sub2_sub2_1.currentOffset = class30_sub2_sub2.readUnsignedWord() + 4;
      int k = class30_sub2_sub2_1.readUnsignedByte();
      if(k > 0) {
         class30_sub2_sub2_1.currentOffset += 3 * (k - 1);
      }

      for(int l = 0; l < 256; ++l) {
         this.anIntArray1494[l] = class30_sub2_sub2_1.readUnsignedByte();
         this.anIntArray1495[l] = class30_sub2_sub2_1.readUnsignedByte();
         int i1 = this.anIntArray1492[l] = class30_sub2_sub2_1.readUnsignedWord();
         int j1 = this.anIntArray1493[l] = class30_sub2_sub2_1.readUnsignedWord();
         int k1 = class30_sub2_sub2_1.readUnsignedByte();
         int l1 = i1 * j1;
         this.aByteArrayArray1491[l] = new byte[l1];
         int k2;
         int j3;
         if(k1 == 0) {
            for(k2 = 0; k2 < l1; ++k2) {
               this.aByteArrayArray1491[l][k2] = class30_sub2_sub2.method409();
            }
         } else if(k1 == 1) {
            for(k2 = 0; k2 < i1; ++k2) {
               for(j3 = 0; j3 < j1; ++j3) {
                  this.aByteArrayArray1491[l][k2 + j3 * i1] = class30_sub2_sub2.method409();
               }
            }
         }

         if(j1 > this.anInt1497 && l < 128) {
            this.anInt1497 = j1;
         }

         this.anIntArray1494[l] = 1;
         this.anIntArray1496[l] = i1 + 2;
         k2 = 0;

         for(j3 = j1 / 7; j3 < j1; ++j3) {
            k2 += this.aByteArrayArray1491[l][j3 * i1];
         }

         if(k2 <= j1 / 7) {
            --this.anIntArray1496[l];
            this.anIntArray1494[l] = 0;
         }

         k2 = 0;

         for(j3 = j1 / 7; j3 < j1; ++j3) {
            k2 += this.aByteArrayArray1491[l][i1 - 1 + j3 * i1];
         }

         if(k2 <= j1 / 7) {
            --this.anIntArray1496[l];
         }
      }

      if(flag) {
         this.anIntArray1496[32] = this.anIntArray1496[73];
      } else {
         this.anIntArray1496[32] = this.anIntArray1496[105];
      }

   }

   public void method380(String s, int i, int j, int k) {
      this.method385(j, s, k, i - this.method384(s));

   }

   public void method381(int i, String s, int j, int k, int l) {
      if(j != 23693) {
         this.anInt1489 = 467;
      }

      this.method385(i, s, k, l - this.method384(s) / 2);
   }

   public void method382(int i, int j, String s, int l, boolean flag) {
      this.method389(flag, j - this.method383(this.anInt1485, s) / 2, i, s, l);
   }

   public int method383(int i, String s) {
      i = 75 / i;
      if(s == null) {
         return 0;
      } else {
         int j = 0;

         for(int k = 0; k < s.length(); ++k) {
            if(s.charAt(k) == 64 && k + 4 < s.length() && s.charAt(k + 4) == 64) {
               k += 4;
            } else {
               j += this.anIntArray1496[s.charAt(k)];
            }
         }

         return j;
      }
   }

   public int method384(String s) {
      if(s == null) {
         return 0;
      } else {
         int j = 0;

         for(int k = 0; k < s.length(); ++k) {
            j += this.anIntArray1496[s.charAt(k)];
         }

         return j;
      }
   }

   public void method385(int i, String s, int j, int l) {
      if(s != null) {
         j -= this.anInt1497;

         for(int i1 = 0; i1 < s.length(); ++i1) {
            char c = s.charAt(i1);
            if(c != 32) {
               this.method392(this.aByteArrayArray1491[c], l + this.anIntArray1494[c], j + this.anIntArray1495[c], this.anIntArray1492[c], this.anIntArray1493[c], i);
            }

            l += this.anIntArray1496[c];
         }
      }

   }

   public void method386(int i, boolean flag, String s, int j, int k, int l) {
      if(!flag) {
         this.aBoolean1490 = !this.aBoolean1490;
      }

      if(s != null) {
         j -= this.method384(s) / 2;
         l -= this.anInt1497;

         for(int i1 = 0; i1 < s.length(); ++i1) {
            char c = s.charAt(i1);
            if(c != 32) {
               this.method392(this.aByteArrayArray1491[c], j + this.anIntArray1494[c], l + this.anIntArray1495[c] + (int)(Math.sin((double)i1 / 2.0D + (double)k / 5.0D) * 5.0D), this.anIntArray1492[c], this.anIntArray1493[c], i);
            }

            j += this.anIntArray1496[c];
         }
      }

   }

   public void method387(int i, String s, int j, int k, byte byte0, int l) {
      if(s != null) {
         i -= this.method384(s) / 2;
         k -= this.anInt1497;
         if(byte0 == 5) {
            for(int i1 = 0; i1 < s.length(); ++i1) {
               char c = s.charAt(i1);
               if(c != 32) {
                  this.method392(this.aByteArrayArray1491[c], i + this.anIntArray1494[c] + (int)(Math.sin((double)i1 / 5.0D + (double)j / 5.0D) * 5.0D), k + this.anIntArray1495[c] + (int)(Math.sin((double)i1 / 3.0D + (double)j / 5.0D) * 5.0D), this.anIntArray1492[c], this.anIntArray1493[c], l);
               }

               i += this.anIntArray1496[c];
            }
         }
      }

   }

   public void method388(int i, String s, boolean flag, int j, int k, int l, int i1) {
      if(!flag) {
         for(int var121 = 1; var121 > 0; ++var121) {
         }
      }

      if(s != null) {
         double var12 = 7.0D - (double)i / 8.0D;
         if(var12 < 0.0D) {
            var12 = 0.0D;
         }

         l -= this.method384(s) / 2;
         k -= this.anInt1497;

         for(int k1 = 0; k1 < s.length(); ++k1) {
            char c = s.charAt(k1);
            if(c != 32) {
               this.method392(this.aByteArrayArray1491[c], l + this.anIntArray1494[c], k + this.anIntArray1495[c] + (int)(Math.sin((double)k1 / 1.5D + (double)j) * var12), this.anIntArray1492[c], this.anIntArray1493[c], i1);
            }

            l += this.anIntArray1496[c];
         }
      }

   }

   public void method389(boolean flag1, int i, int j, String s, int k) {
      this.aBoolean1499 = false;
      int l = i;
      if(s != null) {
         k -= this.anInt1497;

         for(int i1 = 0; i1 < s.length(); ++i1) {
            if(s.charAt(i1) == 64 && i1 + 4 < s.length() && s.charAt(i1 + 4) == 64) {
               int var9 = this.method391(s.substring(i1 + 1, i1 + 4));
               if(var9 != -1) {
                  j = var9;
               }

               i1 += 4;
            } else {
               char c = s.charAt(i1);
               if(c != 32) {
                  if(flag1) {
                     this.method392(this.aByteArrayArray1491[c], i + this.anIntArray1494[c] + 1, k + this.anIntArray1495[c] + 1, this.anIntArray1492[c], this.anIntArray1493[c], 0);
                  }

                  this.method392(this.aByteArrayArray1491[c], i + this.anIntArray1494[c], k + this.anIntArray1495[c], this.anIntArray1492[c], this.anIntArray1493[c], j);
               }

               i += this.anIntArray1496[c];
            }
         }

         if(this.aBoolean1499) {
            DrawingArea.method339(k + (int)((double)this.anInt1497 * 0.7D), 8388608, i - l, l);
         }
      }

   }

   public void method390(int i, int j, String s, int k, int i1) {
      if(s != null) {
         this.aRandom1498.setSeed((long)k);
         int j1 = 192 + (this.aRandom1498.nextInt() & 31);
         i1 -= this.anInt1497;

         for(int k1 = 0; k1 < s.length(); ++k1) {
            if(s.charAt(k1) == 64 && k1 + 4 < s.length() && s.charAt(k1 + 4) == 64) {
               int var9 = this.method391(s.substring(k1 + 1, k1 + 4));
               if(var9 != -1) {
                  j = var9;
               }

               k1 += 4;
            } else {
               char c = s.charAt(k1);
               if(c != 32) {
                  this.method394(192, i + this.anIntArray1494[c] + 1, this.aByteArrayArray1491[c], this.anIntArray1492[c], i1 + this.anIntArray1495[c] + 1, this.anIntArray1493[c], 0);
                  this.method394(j1, i + this.anIntArray1494[c], this.aByteArrayArray1491[c], this.anIntArray1492[c], i1 + this.anIntArray1495[c], this.anIntArray1493[c], j);
               }

               i += this.anIntArray1496[c];
               if((this.aRandom1498.nextInt() & 3) == 0) {
                  ++i;
               }
            }
         }
      }

   }

   public int method391(String s) {
      if(s.equals("red")) {
         return 16711680;
      } else if(s.equals("gre")) {
         return '\uff00';
      } else if(s.equals("blu")) {
         return 255;
      } else if(s.equals("yel")) {
         return 16776960;
      } else if(s.equals("cya")) {
         return '\uffff';
      } else if(s.equals("mag")) {
         return 16711935;
      } else if(s.equals("whi")) {
         return 16777215;
      } else if(s.equals("bla")) {
         return 0;
      } else if(s.equals("lre")) {
         return 16748608;
      } else if(s.equals("dre")) {
         return 8388608;
      } else if(s.equals("dbl")) {
         return 128;
      } else if(s.equals("or1")) {
         return 16756736;
      } else if(s.equals("or2")) {
         return 16740352;
      } else if(s.equals("or3")) {
         return 16723968;
      } else if(s.equals("gr1")) {
         return 12648192;
      } else if(s.equals("gr2")) {
         return 8453888;
      } else if(s.equals("gr3")) {
         return 4259584;
      } else if(s.equals("xxx")) {
         return 3394815;
      } else {
         if(s.equals("str")) {
            this.aBoolean1499 = true;
         }

         if(s.equals("end")) {
            this.aBoolean1499 = false;
         }

         return -1;
      }
   }

   private void method392(byte[] abyte0, int i, int j, int k, int l, int i1) {
      int j1 = i + j * DrawingArea.width;
      int k1 = DrawingArea.width - k;
      int l1 = 0;
      int i2 = 0;
      int l2;
      if(j < DrawingArea.topY) {
         l2 = DrawingArea.topY - j;
         l -= l2;
         j = DrawingArea.topY;
         i2 += l2 * k;
         j1 += l2 * DrawingArea.width;
      }

      if(j + l >= DrawingArea.bottomY) {
         l -= j + l - DrawingArea.bottomY + 1;
      }

      if(i < DrawingArea.leftX) {
         l2 = DrawingArea.leftX - i;
         k -= l2;
         i = DrawingArea.leftX;
         i2 += l2;
         j1 += l2;
         l1 += l2;
         k1 += l2;
      }

      if(i + k >= DrawingArea.bottomX) {
         l2 = i + k - DrawingArea.bottomX + 1;
         k -= l2;
         l1 += l2;
         k1 += l2;
      }

      if(k > 0 && l > 0) {
         this.method393(DrawingArea.pixels, abyte0, i1, i2, j1, k, l, k1, l1);
      }

   }

   private void method393(int[] ai, byte[] abyte0, int i, int j, int k, int l, int i1, int j1, int k1) {
      int l1 = -(l >> 2);
      l = -(l & 3);

      for(int i2 = -i1; i2 < 0; ++i2) {
         int k2;
         for(k2 = l1; k2 < 0; ++k2) {
            if(abyte0[j++] != 0) {
               ai[k++] = i;
            } else {
               ++k;
            }

            if(abyte0[j++] != 0) {
               ai[k++] = i;
            } else {
               ++k;
            }

            if(abyte0[j++] != 0) {
               ai[k++] = i;
            } else {
               ++k;
            }

            if(abyte0[j++] != 0) {
               ai[k++] = i;
            } else {
               ++k;
            }
         }

         for(k2 = l; k2 < 0; ++k2) {
            if(abyte0[j++] != 0) {
               ai[k++] = i;
            } else {
               ++k;
            }
         }

         k += j1;
         j += k1;
      }

   }

   private void method394(int i, int j, byte[] abyte0, int k, int l, int i1, int j1) {
      int k1 = j + l * width;
      int l1 = width - k;
      int i2 = 0;
      int j2 = 0;
      int i3;
      if(l < topY) {
         i3 = topY - l;
         i1 -= i3;
         l = topY;
         j2 += i3 * k;
         k1 += i3 * width;
      }

      if(l + i1 >= bottomY) {
         i1 -= l + i1 - bottomY;
      }

      if(j < leftX) {
         i3 = leftX - j;
         k -= i3;
         j = leftX;
         j2 += i3;
         k1 += i3;
         i2 += i3;
         l1 += i3;
      }

      if(j + k >= bottomX) {
         i3 = j + k - bottomX;
         k -= i3;
         i2 += i3;
         l1 += i3;
      }

      if(k > 0 && i1 > 0) {
         this.method395(abyte0, i1, k1, pixels, j2, k, i2, l1, j1, i);
      }

   }

   public int getTextWidth(String s) {
      if(s == null) {
         return 0;
      } else {
         int j = 0;

         for(int k = 0; k < s.length(); ++k) {
            if(s.charAt(k) == 64 && k + 4 < s.length() && s.charAt(k + 4) == 64) {
               k += 4;
            } else {
               j += this.anIntArray1496[s.charAt(k)];
            }
         }

         return j;
      }
   }

   private void method395(byte[] abyte0, int i, int j, int[] ai, int l, int i1, int j1, int k1, int l1, int i2) {
      l1 = ((l1 & 16711935) * i2 & -16711936) + ((l1 & '\uff00') * i2 & 16711680) >> 8;
      i2 = 256 - i2;

      for(int j2 = -i; j2 < 0; ++j2) {
         for(int k2 = -i1; k2 < 0; ++k2) {
            if(abyte0[l++] != 0) {
               int l2 = ai[j];
               ai[j++] = (((l2 & 16711935) * i2 & -16711936) + ((l2 & '\uff00') * i2 & 16711680) >> 8) + l1;
            } else {
               ++j;
            }
         }

         j += k1;
         l += j1;
      }

   }

   public void drawText(int i, String s, int k, int l) {
      this.method385(i, s, k, l - this.method384(s) / 2);
   }

   public void drawChatInput(int i, int j, String s, int l, boolean flag) {
      this.method389(flag, j, i, s, l);
   }

public void drawBasicString(int s2, int j11, String var40, int textColor, int i) {
	// TODO Auto-generated method stub
	
}
private int getColorByName(String s) {
	if(s.equals("369"))//color code, use as @###@
		return 0x336699;//hex code
	if(s.equals("mon"))
		return 0x00ff80;
	if(s.equals("red"))
		return 0xff0000;
	if(s.equals("gre"))
		return 65280;
	if(s.equals("blu"))
		return 255;
	if(s.equals("yel"))
		return 0xffff00;
	if(s.equals("aut"))
		return 0x0d9ddc;
	if(s.equals("cya"))
		return 65535;
	if(s.equals("mag"))
		return 0xff00ff;
	if(s.equals("whi"))
		return 0xffffff;
	if(s.equals("bla"))
		return 0;
	if(s.equals("lre"))
		return 0xff9040;
	if(s.equals("dre"))
		return 0x800000;
	if(s.equals("dbl"))
		return 128;
	if(s.equals("or1"))
		return 0xffb000;
	if(s.equals("or2"))
		return 0xff7000;
	if(s.equals("or3"))
		return 0xff3000;
	if(s.equals("gr1"))
		return 0xc0ff00;
	if(s.equals("gr2"))
		return 0x80ff00;
	if(s.equals("gr3"))
		return 0x40ff00;
	if(s.equals("str"))
		aBoolean1499 = true;
	if(s.equals("end"))
		aBoolean1499 = false;
	return -1;
}
	public void drawTextWithPotentialShadow(boolean flag1, int i, int j, String s, int k) {
		aBoolean1499 = false;
		int l = i;
		if(s == null)
			return;
		k -= anInt1497;
		for(int i1 = 0; i1 < s.length(); i1++)
			if(s.charAt(i1) == '@' && i1 + 4 < s.length() && s.charAt(i1 + 4) == '@') {
				int j1 = getColorByName(s.substring(i1 + 1, i1 + 4));
				if(j1 != -1)
					j = j1;
				i1 += 4;
			} else {
				char c = s.charAt(i1);
				if(c != ' ') {
					if(flag1)
					method392(aByteArrayArray1491[c], i + anIntArray1494[c] + 1, k + anIntArray1495[c] + 1, anIntArray1492[c], anIntArray1493[c], 0);
					method392(aByteArrayArray1491[c], i + anIntArray1494[c], k + anIntArray1495[c], anIntArray1492[c], anIntArray1493[c], j);
				}
				i += anIntArray1496[c];
			}
		if(aBoolean1499)
			DrawingArea.drawHorizontalLine(l, k + (int)((double)anInt1497 * 0.69999999999999996D), i - l, 0x800000);
	}
}
