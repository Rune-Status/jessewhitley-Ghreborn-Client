package com.Ghreborn.client.cache.graphics;

import com.Ghreborn.client.FileOperations;
import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.cache.StreamLoader;
import com.Ghreborn.client.cache.graphics.Background;
import com.Ghreborn.client.draw.DrawingArea;
import com.Ghreborn.client.io.Buffer;

import java.awt.Component;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public final class Sprite extends DrawingArea {
   public String location = SignLink.findcachedir() + "Sprites/";
   public int myWidth;
   public int myHeight;
   public int maxWidth;
   public int maxHeight;
   public int drawOffsetX;
   public int drawOffsetY;
   public int[] myPixels;
   private boolean aBoolean1428;
   private int anInt1429;
   private int anInt1431;
   private byte aByte1432;
   private boolean aBoolean1433;
   private int anInt1434;
   private boolean aBoolean1436;
   private boolean aBoolean1435;
   private boolean aBoolean1437;
   private boolean aBoolean1438;
   private int anInt1430;
	public int xPosition, yPosition;

   public static Image downScaleImage(Image image, int width, int height) {
      return width <= 765 && width <= 503?image:image.getScaledInstance(width, height, 4);
   }
   public void dumpImage(String directory, String name, Sprite sprite, boolean transparency) {       
       try {
           DirectColorModel model = new DirectColorModel(24, 0xFF0000, 0x00FF00, 0x0000FF);
           int[] bandmasks = new int[] { 
               model.getRedMask(), model.getGreenMask(), model.getBlueMask() 
           };
           int w = sprite.myWidth;
           int h = sprite.myHeight;
           int[] pix = sprite.myPixels;
           if (transparency)
               for (int i = 0; i < pix.length; i++)
                   if (pix[i] == 0)
                       pix[i] = 0xFFFFFF;
           DataBufferInt buffer = new DataBufferInt(pix, pix.length);
           WritableRaster raster = Raster.createPackedRaster(buffer, w, h, w, bandmasks, null);
           BufferedImage img = new BufferedImage(model, raster, true, new Hashtable<Object, Object>());
           ImageIO.write(img, "png", new File("./" + directory + name + ".png"));
       } catch (Throwable t) {
           t.printStackTrace();
       }
   }
   public Sprite(int width, int height, int offsetX, int offsetY, int[] pixels) {
      this.width = width;
      this.height = height;
      this.drawOffsetX = offsetX;
      this.drawOffsetY = offsetY;
      this.pixels = pixels;

      //Color color = Color.MAGENTA;
      setTransparency(255, 0, 255);
   }
   public void drawTransparentSprite(int i, int j, int opacity) {
      i += this.drawOffsetX;
      j += this.drawOffsetY;
      int i1 = i + j * DrawingArea.width;
      int j1 = 0;
      int k1 = this.myHeight;
      int l1 = this.myWidth;
      int i2 = DrawingArea.width - l1;
      int j2 = 0;
      int i3;
      if(j < DrawingArea.topY) {
         i3 = DrawingArea.topY - j;
         k1 -= i3;
         j = DrawingArea.topY;
         j1 += i3 * l1;
         i1 += i3 * DrawingArea.width;
      }

      if(j + k1 > DrawingArea.bottomY) {
         k1 -= j + k1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         i3 = DrawingArea.leftX - i;
         l1 -= i3;
         i = DrawingArea.leftX;
         j1 += i3;
         i1 += i3;
         j2 += i3;
         i2 += i3;
      }

      if(i + l1 > DrawingArea.bottomX) {
         i3 = i + l1 - DrawingArea.bottomX;
         l1 -= i3;
         j2 += i3;
         i2 += i3;
      }

      if(l1 > 0 && k1 > 0) {
         this.method351(j1, l1, DrawingArea.pixels, this.myPixels, j2, k1, i2, opacity, i1);
      }

   }

   public Sprite(String img) {
      try {
         Image _ex = Toolkit.getDefaultToolkit().getImage(this.location + img + ".png");
         ImageIcon sprite = new ImageIcon(_ex);
         this.myWidth = sprite.getIconWidth();
         this.myHeight = sprite.getIconHeight();
         this.maxWidth = this.myWidth;
         this.maxHeight = this.myHeight;
         this.drawOffsetX = 0;
         this.drawOffsetY = 0;
         this.myPixels = new int[this.myWidth * this.myHeight];
         PixelGrabber pixelgrabber = new PixelGrabber(_ex, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
         pixelgrabber.grabPixels();
         _ex = null;
         this.setTransparency(255, 255, 255);
         this.setTransparency(255, 0, 255);
      } catch (Exception var5) {
         System.out.println(var5);
      }

      this.setAlphaTransparency(0);
   }

   public void setAlphaTransparency(int a) {
      for(int pixel = 0; pixel < this.myPixels.length; ++pixel) {
         if((this.myPixels[pixel] >> 24 & 255) == a) {
            this.myPixels[pixel] = 0;
         }
      }

   }

   public Sprite(String s, int width, int height) {
      try {
         Image var61 = Toolkit.getDefaultToolkit().createImage(FileOperations.ReadFile(s));
         this.myWidth = width;
         this.myHeight = height;
         this.maxWidth = this.myWidth;
         this.maxHeight = this.myHeight;
         this.drawOffsetX = 0;
         this.drawOffsetY = 0;
         this.myPixels = new int[this.myWidth * this.myHeight];
         PixelGrabber pixelgrabber = new PixelGrabber(var61, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
         pixelgrabber.grabPixels();
      } catch (Exception var6) {
         var6.printStackTrace();
      }

   }

   public Sprite(int i, int j) {
      this.aBoolean1428 = false;
      this.anInt1429 = 24869;
      this.anInt1431 = -32357;
      this.aByte1432 = 3;
      this.aBoolean1433 = false;
      this.anInt1434 = -388;
      this.aBoolean1436 = true;
      this.aBoolean1435 = false;
      this.aBoolean1437 = true;
      this.aBoolean1438 = false;
      this.myPixels = new int[i * j];
      this.myWidth = this.maxWidth = i;
      this.myHeight = this.maxHeight = j;
      this.drawOffsetX = this.drawOffsetY = 0;
   }
	public Sprite(byte[] spriteData) {
		try {
			Image image = Toolkit.getDefaultToolkit().createImage(spriteData);
			ImageIcon sprite = new ImageIcon(image);
			myWidth = sprite.getIconWidth();
			myHeight = sprite.getIconHeight();
			maxHeight = myHeight;
			drawOffsetX = 0;
			drawOffsetY = 0;
			myPixels = new int[myWidth * myHeight];
			PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, myWidth,
					myHeight, myPixels, 0, myWidth);
			pixelgrabber.grabPixels();
			image = null;
			setTransparency(255, 0, 255);
		} catch (Exception _ex) {
			System.out.println(_ex);
		}
	}
   public Sprite(byte[] abyte0, Component component) {
      try {
         Image var7 = Toolkit.getDefaultToolkit().createImage(this.location + "Background.png");
         Image resize = downScaleImage(var7, 765, 503);
         MediaTracker mediatracker = new MediaTracker(component);
         mediatracker.addImage(resize, 0);
         mediatracker.waitForAll();
         this.myWidth = resize.getWidth(component);
         System.out.println("my width: " + this.myWidth);
         this.myHeight = resize.getHeight(component);
         System.out.println("my height: " + this.myHeight);
         this.maxWidth = this.myWidth;
         this.maxHeight = this.myHeight;
         this.drawOffsetX = 0;
         this.drawOffsetY = 0;
         this.myPixels = new int[this.myWidth * this.myHeight];
         PixelGrabber pixelgrabber = new PixelGrabber(resize, 0, 0, this.myWidth, this.myHeight, this.myPixels, 0, this.myWidth);
         pixelgrabber.grabPixels();
      } catch (Exception var71) {
         System.out.println("Error converting jpg");
      }

   }

   public void setTransparency(int transRed, int transGreen, int transBlue) {
      for(int index = 0; index < this.myPixels.length; ++index) {
         if((this.myPixels[index] >> 16 & 255) == transRed && (this.myPixels[index] >> 8 & 255) == transGreen && (this.myPixels[index] & 255) == transBlue) {
            this.myPixels[index] = 0;
         }
      }

   }

   public void drawAdvancedSprite(int posX, int posY) {
      posX += this.drawOffsetX;
      posY += this.drawOffsetY;
      int containerPixel = posX + posY * DrawingArea.width;
      int pixelOffset = 0;
      int height = this.myHeight;
      int width = this.myWidth;
      int containerScanSize = DrawingArea.width - width;
      int spriteScanSize = 0;
      int widthLeft;
      if(posY < DrawingArea.topY) {
         widthLeft = DrawingArea.topY - posY;
         height -= widthLeft;
         posY = DrawingArea.topY;
         pixelOffset += widthLeft * width;
         containerPixel += widthLeft * DrawingArea.width;
      }

      if(posY + height > DrawingArea.bottomY) {
         height -= posY + height - DrawingArea.bottomY;
      }

      if(posX < DrawingArea.leftX) {
         widthLeft = DrawingArea.leftX - posX;
         width -= widthLeft;
         posX = DrawingArea.leftX;
         pixelOffset += widthLeft;
         containerPixel += widthLeft;
         spriteScanSize += widthLeft;
         containerScanSize += widthLeft;
      }

      if(posX + width > DrawingArea.bottomX) {
         widthLeft = posX + width - DrawingArea.bottomX;
         width -= widthLeft;
         spriteScanSize += widthLeft;
         containerScanSize += widthLeft;
      }

      if(width > 0 && height > 0) {
         this.drawToContainer(width, height, pixelOffset, this.myPixels, spriteScanSize, containerPixel, DrawingArea.pixels, containerScanSize);
      }

   }

   private void drawToContainer(int width, int height, int spritePixel, int[] spriteData, int spriteScanSize, int containerPixel, int[] containerData, int containerScanSize) {
      for(int y = 0; y < height; ++y) {
         for(int x = 0; x < width; ++x) {
            int argb = spriteData[spritePixel++];
            if(argb != 0) {
               int alpha = argb >> 24 & 255;
               int transparency = 256 - alpha;
               int originalColor = containerData[containerPixel];
               containerData[containerPixel++] = ((argb & 16711935) * alpha + (originalColor & 16711935) * transparency & -16711936) + ((argb & '\uff00') * alpha + (originalColor & '\uff00') * transparency & 16711680) >> 8;
            } else {
               ++containerPixel;
            }
         }

         containerPixel += containerScanSize;
         spritePixel += spriteScanSize;
      }

   }

   public Sprite(StreamLoader class44, String s, int i) {
      this.aBoolean1428 = false;
      this.anInt1429 = 24869;
      this.anInt1431 = -32357;
      this.aByte1432 = 3;
      this.aBoolean1433 = false;
      this.anInt1434 = -388;
      this.aBoolean1435 = false;
      this.aBoolean1436 = true;
      this.aBoolean1437 = true;
      this.aBoolean1438 = false;
      Buffer class30_sub2_sub2 = new Buffer(class44.readFile(s + ".dat"));
      Buffer class30_sub2_sub2_1 = new Buffer(class44.readFile("index.dat"));
      class30_sub2_sub2_1.currentOffset = class30_sub2_sub2.readUnsignedShort();
      this.maxWidth = class30_sub2_sub2_1.readUnsignedShort();
      this.maxHeight = class30_sub2_sub2_1.readUnsignedShort();
      int j = class30_sub2_sub2_1.readUnsignedByte();
      int[] ai = new int[j];

      int i1;
      for(i1 = 0; i1 < j - 1; ++i1) {
         ai[i1 + 1] = class30_sub2_sub2_1.readTriByte();
         if(ai[i1 + 1] == 0) {
            ai[i1 + 1] = 1;
         }
      }

      for(i1 = 0; i1 < i; ++i1) {
         class30_sub2_sub2_1.currentOffset += 2;
         class30_sub2_sub2.currentOffset += class30_sub2_sub2_1.readUnsignedShort() * class30_sub2_sub2_1.readUnsignedShort();
         ++class30_sub2_sub2_1.currentOffset;
      }

      this.drawOffsetX = class30_sub2_sub2_1.readUnsignedByte();
      this.drawOffsetY = class30_sub2_sub2_1.readUnsignedByte();
      this.myWidth = class30_sub2_sub2_1.readUnsignedShort();
      this.myHeight = class30_sub2_sub2_1.readUnsignedShort();
      i1 = class30_sub2_sub2_1.readUnsignedByte();
      int j1 = this.myWidth * this.myHeight;
      this.myPixels = new int[j1];
         int var13;
         if(i1 == 0) {
            for(var13 = 0; var13 < j1; ++var13) {
               this.myPixels[var13] = ai[class30_sub2_sub2.readUnsignedByte()];
            }

            return;
         }

         if(i1 == 1) {
            for(var13 = 0; var13 < this.myWidth; ++var13) {
               for(int var14 = 0; var14 < this.myHeight; ++var14) {
                  this.myPixels[var13 + var14 * this.myWidth] = ai[class30_sub2_sub2.readUnsignedByte()];
               }
            }
         }

   }

   public static void writeTemp(String tempData, String tempFile) {
      try {
         BufferedWriter LV = new BufferedWriter(new FileWriter(tempFile, true));
         LV.write(tempData);
         LV.newLine();
         LV.flush();
      } catch (IOException var3) {
      }

   }

   public void method343(int i) {
      if(i != 0) {
         this.aBoolean1438 = !this.aBoolean1438;
      }

      DrawingArea.method331(this.myHeight, this.myWidth, this.myPixels, null);
   }

   public void method344(int i, int j, int k, int l) {
      if(l != 0) {
         this.anInt1430 = 314;
      }

      for(int i1 = 0; i1 < this.myPixels.length; ++i1) {
         int j1 = this.myPixels[i1];
         if(j1 != 0) {
            int k1 = j1 >> 16 & 255;
            k1 += i;
            if(k1 < 1) {
               k1 = 1;
            } else if(k1 > 255) {
               k1 = 255;
            }

            int l1 = j1 >> 8 & 255;
            l1 += j;
            if(l1 < 1) {
               l1 = 1;
            } else if(l1 > 255) {
               l1 = 255;
            }

            int i2 = j1 & 255;
            i2 += k;
            if(i2 < 1) {
               i2 = 1;
            } else if(i2 > 255) {
               i2 = 255;
            }

            this.myPixels[i1] = (k1 << 16) + (l1 << 8) + i2;
         }
      }

   }

   public void method345(int i) {
      int[] ai = new int[this.maxWidth * this.maxHeight];
      if(i != 5059) {
         this.anInt1429 = -247;
      }

      for(int j = 0; j < this.myHeight; ++j) {
         for(int k = 0; k < this.myWidth; ++k) {
            ai[(j + this.drawOffsetY) * this.maxWidth + k + this.drawOffsetX] = this.myPixels[j * this.myWidth + k];
         }
      }

      this.myPixels = ai;
      this.myWidth = this.maxWidth;
      this.myHeight = this.maxHeight;
      this.drawOffsetX = 0;
      this.drawOffsetY = 0;
   }

   public void method346(int i, int j) {
      i += this.drawOffsetX;
      j += this.drawOffsetY;
      int l = i + j * DrawingArea.width;
      int i1 = 0;
      int j1 = this.myHeight;
      int k1 = this.myWidth;
      int l1 = DrawingArea.width - k1;
      int i2 = 0;
      int l2;
      if(j < DrawingArea.topY) {
         l2 = DrawingArea.topY - j;
         j1 -= l2;
         j = DrawingArea.topY;
         i1 += l2 * k1;
         l += l2 * DrawingArea.width;
      }

      if(j + j1 > DrawingArea.bottomY) {
         j1 -= j + j1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         l2 = DrawingArea.leftX - i;
         k1 -= l2;
         i = DrawingArea.leftX;
         i1 += l2;
         l += l2;
         i2 += l2;
         l1 += l2;
      }

      if(i + k1 > DrawingArea.bottomX) {
         l2 = i + k1 - DrawingArea.bottomX;
         k1 -= l2;
         i2 += l2;
         l1 += l2;
      }

      if(k1 > 0 && j1 > 0) {
         this.method347(l, k1, j1, i2, i1, 28339, l1, this.myPixels, DrawingArea.pixels);
      }

   }

   private void method347(int i, int j, int k, int l, int i1, int j1, int k1, int[] ai, int[] ai1) {
      int l1 = -(j >> 2);
      j = -(j & 3);

      for(int i2 = -k; i2 < 0; ++i2) {
         int k2;
         for(k2 = l1; k2 < 0; ++k2) {
            ai1[i++] = ai[i1++];
            ai1[i++] = ai[i1++];
            ai1[i++] = ai[i1++];
            ai1[i++] = ai[i1++];
         }

         for(k2 = j; k2 < 0; ++k2) {
            ai1[i++] = ai[i1++];
         }

         i += k1;
         i1 += l;
      }

      if(j1 != 28339) {
         this.anInt1431 = 90;
      }

   }

   public void drawSprite1(int i, int j) {
      short k = 128;
      i += this.drawOffsetX;
      j += this.drawOffsetY;
      int i1 = i + j * DrawingArea.width;
      int j1 = 0;
      int k1 = this.myHeight;
      int l1 = this.myWidth;
      int i2 = DrawingArea.width - l1;
      int j2 = 0;
      int i3;
      if(j < DrawingArea.topY) {
         i3 = DrawingArea.topY - j;
         k1 -= i3;
         j = DrawingArea.topY;
         j1 += i3 * l1;
         i1 += i3 * DrawingArea.width;
      }

      if(j + k1 > DrawingArea.bottomY) {
         k1 -= j + k1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         i3 = DrawingArea.leftX - i;
         l1 -= i3;
         i = DrawingArea.leftX;
         j1 += i3;
         i1 += i3;
         j2 += i3;
         i2 += i3;
      }

      if(i + l1 > DrawingArea.bottomX) {
         i3 = i + l1 - DrawingArea.bottomX;
         l1 -= i3;
         j2 += i3;
         i2 += i3;
      }

      if(l1 > 0 && k1 > 0) {
         this.method351(j1, l1, DrawingArea.pixels, this.myPixels, j2, k1, i2, k, i1);
      }

   }

   public void drawSprite(int i, int k) {
      i += this.drawOffsetX;
      k += this.drawOffsetY;
      int l = i + k * DrawingArea.width;
      int i1 = 0;
      int j1 = this.myHeight;
      int k1 = this.myWidth;
      int l1 = DrawingArea.width - k1;
      int i2 = 0;
      int l2;
      if(k < DrawingArea.topY) {
         l2 = DrawingArea.topY - k;
         j1 -= l2;
         k = DrawingArea.topY;
         i1 += l2 * k1;
         l += l2 * DrawingArea.width;
      }

      if(k + j1 > DrawingArea.bottomY) {
         j1 -= k + j1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         l2 = DrawingArea.leftX - i;
         k1 -= l2;
         i = DrawingArea.leftX;
         i1 += l2;
         l += l2;
         i2 += l2;
         l1 += l2;
      }

      if(i + k1 > DrawingArea.bottomX) {
         l2 = i + k1 - DrawingArea.bottomX;
         k1 -= l2;
         i2 += l2;
         l1 += l2;
      }

      if(k1 > 0 && j1 > 0) {
         this.method349(DrawingArea.pixels, this.myPixels, i1, l, k1, j1, l1, i2);
      }

   }

   private void method349(int[] ai, int[] ai1, int j, int k, int l, int i1, int j1, int k1) {
      int l1 = -(l >> 2);
      l = -(l & 3);

      for(int i2 = -i1; i2 < 0; ++i2) {
         int i;
         int k2;
         for(k2 = l1; k2 < 0; ++k2) {
            i = ai1[j++];
            if(i != 0 && i != -1) {
               ai[k++] = i;
            } else {
               ++k;
            }

            i = ai1[j++];
            if(i != 0 && i != -1) {
               ai[k++] = i;
            } else {
               ++k;
            }

            i = ai1[j++];
            if(i != 0 && i != -1) {
               ai[k++] = i;
            } else {
               ++k;
            }

            i = ai1[j++];
            if(i != 0 && i != -1) {
               ai[k++] = i;
            } else {
               ++k;
            }
         }

         for(k2 = l; k2 < 0; ++k2) {
            i = ai1[j++];
            if(i != 0 && i != -1) {
               ai[k++] = i;
            } else {
               ++k;
            }
         }

         k += j1;
         j += k1;
      }

   }

   public void drawSprite2(int i, int j) {
      short k = 225;
      i += this.drawOffsetX;
      j += this.drawOffsetY;
      int i1 = i + j * DrawingArea.width;
      int j1 = 0;
      int k1 = this.myHeight;
      int l1 = this.myWidth;
      int i2 = DrawingArea.width - l1;
      int j2 = 0;
      int i3;
      if(j < DrawingArea.topY) {
         i3 = DrawingArea.topY - j;
         k1 -= i3;
         j = DrawingArea.topY;
         j1 += i3 * l1;
         i1 += i3 * DrawingArea.width;
      }

      if(j + k1 > DrawingArea.bottomY) {
         k1 -= j + k1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         i3 = DrawingArea.leftX - i;
         l1 -= i3;
         i = DrawingArea.leftX;
         j1 += i3;
         i1 += i3;
         j2 += i3;
         i2 += i3;
      }

      if(i + l1 > DrawingArea.bottomX) {
         i3 = i + l1 - DrawingArea.bottomX;
         l1 -= i3;
         j2 += i3;
         i2 += i3;
      }

      if(l1 > 0 && k1 > 0) {
         this.method351(j1, l1, DrawingArea.pixels, this.myPixels, j2, k1, i2, k, i1);
      }

   }

   private void method351(int i, int j, int[] ai, int[] ai1, int l, int i1, int j1, int k1, int l1) {
      int j2 = 256 - k1;

      for(int k2 = -i1; k2 < 0; ++k2) {
         for(int l2 = -j; l2 < 0; ++l2) {
            int k = ai1[i++];
            if(k != 0) {
               int i3 = ai[l1];
               ai[l1++] = ((k & 16711935) * k1 + (i3 & 16711935) * j2 & -16711936) + ((k & '\uff00') * k1 + (i3 & '\uff00') * j2 & 16711680) >> 8;
            } else {
               ++l1;
            }
         }

         l1 += j1;
         i += l;
      }

   }

   public void method352(int i, int j, int[] ai, int k, int[] ai1, int i1, int j1, int k1, int l1, int i2) {
      try {
         int _ex = -l1 / 2;
         int k2 = -i / 2;
         int l2 = (int)(Math.sin((double)j / 326.11D) * 65536.0D);
         int i3 = (int)(Math.cos((double)j / 326.11D) * 65536.0D);
         l2 = l2 * k >> 8;
         i3 = i3 * k >> 8;
         int j3 = (i2 << 16) + k2 * l2 + _ex * i3;
         int k3 = (i1 << 16) + (k2 * i3 - _ex * l2);
         int l3 = k1 + j1 * DrawingArea.width;

         for(j1 = 0; j1 < i; ++j1) {
            int i4 = ai1[j1];
            int j4 = l3 + i4;
            int k4 = j3 + i3 * i4;
            int l4 = k3 - l2 * i4;

            for(k1 = -ai[j1]; k1 < 0; ++k1) {
               DrawingArea.pixels[j4++] = this.myPixels[(k4 >> 16) + (l4 >> 16) * this.myWidth];
               k4 += i3;
               l4 -= l2;
            }

            j3 += l2;
            k3 += i3;
            l3 += DrawingArea.width;
         }
      } catch (Exception var23) {
      }

   }

   public void method353(int i, double d, int l1) {
      byte j = 15;
      byte k = 20;
      byte l = 15;
      short j1 = 256;
      byte k1 = 20;

      try {
         int i2 = -k / 2;
         int j2 = -k1 / 2;
         int k2 = (int)(Math.sin(d) * 65536.0D);
         int l2 = (int)(Math.cos(d) * 65536.0D);
         k2 = k2 * j1 >> 8;
         l2 = l2 * j1 >> 8;
         int i3 = (l << 16) + j2 * k2 + i2 * l2;
         int j3 = (j << 16) + (j2 * l2 - i2 * k2);
         int k3 = l1 + i * DrawingArea.width;

         for(i = 0; i < k1; ++i) {
            int l3 = k3;
            int i4 = i3;
            int j4 = j3;

            for(l1 = -k; l1 < 0; ++l1) {
               int k4 = this.myPixels[(i4 >> 16) + (j4 >> 16) * this.myWidth];
               if(k4 != 0) {
                  DrawingArea.pixels[l3++] = k4;
               } else {
                  ++l3;
               }

               i4 += l2;
               j4 -= k2;
            }

            i3 += k2;
            j3 += l2;
            k3 += DrawingArea.width;
         }
      } catch (Exception var21) {
      }

   }

   public void method354(Background Background, boolean flag, int i, int j) {
      j += this.drawOffsetX;
      i += this.drawOffsetY;
      int k = j + i * DrawingArea.width;
      int l = 0;
      if(flag) {
         this.anInt1429 = -364;
      }

      int i1 = this.myHeight;
      int j1 = this.myWidth;
      int k1 = DrawingArea.width - j1;
      int l1 = 0;
      int k2;
      if(i < DrawingArea.topY) {
         k2 = DrawingArea.topY - i;
         i1 -= k2;
         i = DrawingArea.topY;
         l += k2 * j1;
         k += k2 * DrawingArea.width;
      }

      if(i + i1 > DrawingArea.bottomY) {
         i1 -= i + i1 - DrawingArea.bottomY;
      }

      if(j < DrawingArea.leftX) {
         k2 = DrawingArea.leftX - j;
         j1 -= k2;
         j = DrawingArea.leftX;
         l += k2;
         k += k2;
         l1 += k2;
         k1 += k2;
      }

      if(j + j1 > DrawingArea.bottomX) {
         k2 = j + j1 - DrawingArea.bottomX;
         j1 -= k2;
         l1 += k2;
         k1 += k2;
      }

      if(j1 > 0 && i1 > 0) {
         this.method355(this.myPixels, j1, Background.aByteArray1450, i1, DrawingArea.pixels, 0, this.aBoolean1436, k1, k, l1, l);
      }

   }

   private void method355(int[] ai, int i, byte[] abyte0, int j, int[] ai1, int k, boolean flag, int l, int i1, int j1, int k1) {
      int l1 = -(i >> 2);
      int j2;
      if(!flag) {
         for(j2 = 1; j2 > 0; ++j2) {
         }
      }

      i = -(i & 3);

      for(j2 = -j; j2 < 0; ++j2) {
         int l2;
         for(l2 = l1; l2 < 0; ++l2) {
            k = ai[k1++];
            if(k != 0 && abyte0[i1] == 0) {
               ai1[i1++] = k;
            } else {
               ++i1;
            }

            k = ai[k1++];
            if(k != 0 && abyte0[i1] == 0) {
               ai1[i1++] = k;
            } else {
               ++i1;
            }

            k = ai[k1++];
            if(k != 0 && abyte0[i1] == 0) {
               ai1[i1++] = k;
            } else {
               ++i1;
            }

            k = ai[k1++];
            if(k != 0 && abyte0[i1] == 0) {
               ai1[i1++] = k;
            } else {
               ++i1;
            }
         }

         for(l2 = i; l2 < 0; ++l2) {
            k = ai[k1++];
            if(k != 0 && abyte0[i1] == 0) {
               ai1[i1++] = k;
            } else {
               ++i1;
            }
         }

         i1 += l;
         k1 += j1;
      }

   }

   public void drawARGBSprite(int xPos, int yPos) {
      this.drawARGBSprite(xPos, yPos, 256);
   }

   public void drawARGBSprite(int xPos, int yPos, int alpha) {
      xPos += this.drawOffsetX;
      yPos += this.drawOffsetY;
      int i1 = xPos + yPos * DrawingArea.width;
      int j1 = 0;
      int spriteHeight = this.myHeight;
      int spriteWidth = this.myWidth;
      int i2 = DrawingArea.width - spriteWidth;
      int j2 = 0;
      int i3;
      if(yPos < DrawingArea.topY) {
         i3 = DrawingArea.topY - yPos;
         spriteHeight -= i3;
         yPos = DrawingArea.topY;
         j1 += i3 * spriteWidth;
         i1 += i3 * DrawingArea.width;
      }

      if(yPos + spriteHeight > DrawingArea.bottomY) {
         spriteHeight -= yPos + spriteHeight - DrawingArea.bottomY;
      }

      if(xPos < DrawingArea.leftX) {
         i3 = DrawingArea.leftX - xPos;
         spriteWidth -= i3;
         xPos = DrawingArea.leftX;
         j1 += i3;
         i1 += i3;
         j2 += i3;
         i2 += i3;
      }

      if(xPos + spriteWidth > DrawingArea.bottomX) {
         i3 = xPos + spriteWidth - DrawingArea.bottomX;
         spriteWidth -= i3;
         j2 += i3;
         i2 += i3;
      }

      if(spriteWidth > 0 && spriteHeight > 0) {
         this.renderARGBPixels(spriteWidth, spriteHeight, this.myPixels, DrawingArea.pixels, i1, alpha, j1, j2, i2);
      }

   }

   private void renderARGBPixels(int spriteWidth, int spriteHeight, int[] spritePixels, int[] renderAreaPixels, int pixel, int alphaValue, int i, int l, int j1) {
      int alpha = alphaValue;

      for(int height = -spriteHeight; height < 0; ++height) {
         for(int width = -spriteWidth; width < 0; ++width) {
            alphaValue = this.myPixels[i] >> 24 & alpha - 1;
            int alphaLevel = 256 - alphaValue;
            if(alphaLevel > 256) {
               alphaValue = 0;
            }

            if(alpha == 0) {
               alphaLevel = 256;
               alphaValue = 0;
            }

            int pixelColor = spritePixels[i++];
            if(pixelColor != 0) {
               int pixelValue = renderAreaPixels[pixel];
               renderAreaPixels[pixel++] = ((pixelColor & 16711935) * alphaValue + (pixelValue & 16711935) * alphaLevel & -16711936) + ((pixelColor & '\uff00') * alphaValue + (pixelValue & '\uff00') * alphaLevel & 16711680) >> 8;
            } else {
               ++pixel;
            }
         }

         pixel += j1;
         i += l;
      }

   }

   public void drawSprite(int i, int k, int color) {
      int tempWidth = this.myWidth + 2;
      int tempHeight = this.myHeight + 2;
      int[] tempArray = new int[tempWidth * tempHeight];

      int l;
      int i1;
      for(l = 0; l < this.myWidth; ++l) {
         for(i1 = 0; i1 < this.myHeight; ++i1) {
            if(this.myPixels[l + i1 * this.myWidth] != 0) {
               tempArray[l + 1 + (i1 + 1) * tempWidth] = this.myPixels[l + i1 * this.myWidth];
            }
         }
      }

      for(l = 0; l < tempWidth; ++l) {
         for(i1 = 0; i1 < tempHeight; ++i1) {
            if(tempArray[l + i1 * tempWidth] == 0) {
               if(l < tempWidth - 1 && tempArray[l + 1 + i1 * tempWidth] > 0 && tempArray[l + 1 + i1 * tempWidth] != 16777215) {
                  tempArray[l + i1 * tempWidth] = color;
               }

               if(l > 0 && tempArray[l - 1 + i1 * tempWidth] > 0 && tempArray[l - 1 + i1 * tempWidth] != 16777215) {
                  tempArray[l + i1 * tempWidth] = color;
               }

               if(i1 < tempHeight - 1 && tempArray[l + (i1 + 1) * tempWidth] > 0 && tempArray[l + (i1 + 1) * tempWidth] != 16777215) {
                  tempArray[l + i1 * tempWidth] = color;
               }

               if(i1 > 0 && tempArray[l + (i1 - 1) * tempWidth] > 0 && tempArray[l + (i1 - 1) * tempWidth] != 16777215) {
                  tempArray[l + i1 * tempWidth] = color;
               }
            }
         }
      }

      --i;
      --k;
      i += this.drawOffsetX;
      k += this.drawOffsetY;
      l = i + k * DrawingArea.width;
      i1 = 0;
      int j1 = tempHeight;
      int k1 = tempWidth;
      int l1 = DrawingArea.width - tempWidth;
      int i2 = 0;
      int l2;
      if(k < DrawingArea.topY) {
         l2 = DrawingArea.topY - k;
         j1 = tempHeight - l2;
         k = DrawingArea.topY;
         i1 += l2 * tempWidth;
         l += l2 * DrawingArea.width;
      }

      if(k + j1 > DrawingArea.bottomY) {
         j1 -= k + j1 - DrawingArea.bottomY;
      }

      if(i < DrawingArea.leftX) {
         l2 = DrawingArea.leftX - i;
         k1 = tempWidth - l2;
         i = DrawingArea.leftX;
         i1 += l2;
         l += l2;
         i2 += l2;
         l1 += l2;
      }

      if(i + k1 > DrawingArea.bottomX) {
         l2 = i + k1 - DrawingArea.bottomX;
         k1 -= l2;
         i2 += l2;
         l1 += l2;
      }

      if(k1 > 0 && j1 > 0) {
         this.method349(DrawingArea.pixels, tempArray, i1, l, k1, j1, l1, i2);
      }

   }
	public void drawSpriteWithOpacity(int xPos, int yPos, int o) {
		this.drawOffsetX = xPos;
		this.drawOffsetY = yPos;
		int i1 = xPos + yPos * DrawingArea.width;
		int j1 = 0;
		int k1 = myHeight;
		int l1 = myWidth;
		int i2 = DrawingArea.width - l1;
		int j2 = 0;
		if (yPos < DrawingArea.topY) {
			int k2 = DrawingArea.topY - yPos;
			k1 -= k2;
			yPos = DrawingArea.topY;
			j1 += k2 * l1;
			i1 += k2 * DrawingArea.width;
		}
		if (yPos + k1 > DrawingArea.bottomY)
			k1 -= (yPos + k1) - DrawingArea.bottomY;
		if (xPos < DrawingArea.leftX) {
			int l2 = DrawingArea.leftX - xPos;
			l1 -= l2;
			xPos = DrawingArea.leftX;
			j1 += l2;
			i1 += l2;
			j2 += l2;
			i2 += l2;
		}
		if (xPos + l1 > DrawingArea.bottomX) {
			int i3 = (xPos + l1) - DrawingArea.bottomX;
			l1 -= i3;
			j2 += i3;
			i2 += i3;
		}
		if (!(l1 <= 0 || k1 <= 0)) {
			method351(j1, l1, DrawingArea.pixels, myPixels, j2, k1, i2, o, i1);
		}
	}
	public void drawCenteredSprite(int x, int y) {
		drawSprite(x - myWidth / 2, y - myHeight / 2);
	}
	public void drawAdvancedTransparentSprite(int i, int j, int opacity) {
		int k =  (int) (opacity * 2.56D);
		if (k > 256 || k < 0) {
			k = 256;
		}
		i += drawOffsetX;
		j += drawOffsetY;
		xPosition = i;
		yPosition = k;
		int i1 = i + j * DrawingArea.width;
		int j1 = 0;
		int k1 = myHeight;
		int l1 = myWidth;
		int i2 = DrawingArea.width - l1;
		int j2 = 0;
		if (j < DrawingArea.topY) {
			int k2 = DrawingArea.topY - j;
			k1 -= k2;
			j = DrawingArea.topY;
			j1 += k2 * l1;
			i1 += k2 * DrawingArea.width;
		}
		if (j + k1 > DrawingArea.bottomY)
			k1 -= (j + k1) - DrawingArea.bottomY;
		if (i < DrawingArea.leftX) {
			int l2 = DrawingArea.leftX - i;
			l1 -= l2;
			i = DrawingArea.leftX;
			j1 += l2;
			i1 += l2;
			j2 += l2;
			i2 += l2;
		}
		if (i + l1 > DrawingArea.bottomX) {
			int i3 = (i + l1) - DrawingArea.bottomX;
			l1 -= i3;
			j2 += i3;
			i2 += i3;
		}
		if (!(l1 <= 0 || k1 <= 0)) {
			drawAlphaSprite(j1, l1, DrawingArea.pixels, myPixels, j2, k1, i2, k, i1);
		}
	}
	private void drawAlphaSprite(int i, int j, int ai[], int ai1[], int l,
			int i1, int j1, int k1, int l1) {
		int k;
		int j2;
		int opacity = k1;
		for (int k2 = -i1; k2 < 0; k2++) {
			for (int l2 = -j; l2 < 0; l2++) {
				k1 = ((myPixels[i] >> 24) & 255);
				if (k1 > opacity) {
					k1 = opacity;
				}
				j2 = 256 - k1;
				k = ai1[i++];
				if (k != 0) {
					int i3 = ai[l1];
					ai[l1++] = ((k & 0xff00ff) * k1 + (i3 & 0xff00ff) * j2 & 0xff00ff00) + ((k & 0xff00) * k1 + (i3 & 0xff00) * j2 & 0xff0000) >> 8;
				} else {
					l1++;
				}
			}

			l1 += j1;
			i += l;
		}
	}
}
