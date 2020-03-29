package com.Ghreborn.client.draw;

import com.Ghreborn.client.link.NodeSub;

public class DrawingArea extends NodeSub {
   public static boolean aBoolean1388;
   public static int[] pixels;
   public static int width;
   public static int height;
   public static int leftX;
   public static int topY;
   public static int bottomX;
   public static int bottomY;
   public static int centerX;
   public static int centerY;
	public static float[] depthBuffer;
   public static int anInt1387;

   public static void method331(int i, int j, int[] ai, float[] depth) {
      pixels = ai;
      depthBuffer = depth;
      width = j;
      height = i;
      method333(i, 0, j, 0);
   }
   /**
    * Draws a 1 pixel thick transparent box outline in a certain colour.
    * @param leftX The left edge X-Coordinate
    * @param topY The top edge Y-Coordinate.
    * @param width The width.
    * @param height The height.
    * @param rgbColour The RGB-Colour.
    * @param opacity The opacity value ranging from 0 to 256.
    */
	public static void drawTransparentBoxOutline(int leftX, int topY, int width, int height, int rgbColour, int opacity) {
		drawTransparentHorizontalLine(leftX, topY, width, rgbColour, opacity);
		drawTransparentHorizontalLine(leftX, topY + height - 1, width, rgbColour, opacity);
		if(height >= 3) {
			drawTransparentVerticalLine(leftX, topY + 1, height - 2, rgbColour, opacity);
			drawTransparentVerticalLine(leftX + width - 1, topY + 1, height - 2, rgbColour, opacity);
		}
	}

   /**
    * Draws a transparent coloured horizontal line in the drawingArea.
    * @param xPosition The start X-Position of the line.
    * @param yPosition The Y-Position of the line.
    * @param width The width of the line.
    * @param rgbColour The colour of the line.
    * @param opacity The opacity value ranging from 0 to 256.
    */
	public static void drawTransparentHorizontalLine(int xPosition, int yPosition, int width, int rgbColour, int opacity) {
		if(yPosition < DrawingArea.topY || yPosition >= DrawingArea.bottomY) {
			return;
		}
		if(xPosition < DrawingArea.leftX) {
           width -= DrawingArea.leftX - xPosition;
			xPosition = DrawingArea.leftX;
		}
		if(xPosition + width > DrawingArea.bottomX) {
			width = DrawingArea.bottomX - xPosition;
		}
		final int transparency = 256 - opacity;
		final int red = (rgbColour >> 16 & 0xff) * opacity;
		final int green = (rgbColour >> 8 & 0xff) * opacity;
		final int blue = (rgbColour & 0xff) * opacity;
		int pixelIndex = xPosition + yPosition * DrawingArea.width;
		for(int i = 0; i < width; i++) {
			final int otherRed = (DrawingArea.pixels[pixelIndex] >> 16 & 0xff) * transparency;
			final int otherGreen = (DrawingArea.pixels[pixelIndex] >> 8 & 0xff) * transparency;
			final int otherBlue = (DrawingArea.pixels[pixelIndex] & 0xff) * transparency;
			final int transparentColour = (red + otherRed >> 8 << 16) + (green + otherGreen >> 8 << 8) + (blue + otherBlue >> 8);
			DrawingArea.pixels[pixelIndex++] = transparentColour;
		}
	}

   /**
    * Draws a transparent coloured vertical line in the drawingArea.
    * @param xPosition The X-Position of the line.
    * @param yPosition The start Y-Position of the line.
    * @param height The height of the line.
    * @param rgbColour The colour of the line.
    * @param opacity The opacity value ranging from 0 to 256.
    */
	public static void drawTransparentVerticalLine(int xPosition, int yPosition, int height, int rgbColour, int opacity) {
		if(xPosition < DrawingArea.leftX || xPosition >= DrawingArea.bottomX) {
			return;
		}
		if(yPosition < DrawingArea.topY) {
			height -= DrawingArea.topY - yPosition;
			yPosition = DrawingArea.topY;
		}
		if(yPosition + height > DrawingArea.bottomY) {
			height = DrawingArea.bottomY - yPosition;
		}
		final int transparency = 256 - opacity;
		final int red = (rgbColour >> 16 & 0xff) * opacity;
		final int green = (rgbColour >> 8 & 0xff) * opacity;
		final int blue = (rgbColour & 0xff) * opacity;
		int pixelIndex = xPosition + yPosition * DrawingArea.width;
		for(int i = 0; i < height; i++) {
			final int otherRed = (DrawingArea.pixels[pixelIndex] >> 16 & 0xff) * transparency;
			final int otherGreen = (DrawingArea.pixels[pixelIndex] >> 8 & 0xff) * transparency;
			final int otherBlue = (DrawingArea.pixels[pixelIndex] & 0xff) * transparency;
			final int transparentColour = (red + otherRed >> 8 << 16) + (green + otherGreen >> 8 << 8) + (blue + otherBlue >> 8);
			DrawingArea.pixels[pixelIndex] = transparentColour;
			pixelIndex += DrawingArea.width;
		}
	}
   /**
    * Draws a 1 pixel thick box outline in a certain colour.
    * @param leftX The left edge X-Coordinate.
    * @param topY The top edge Y-Coordinate.
    * @param width The width.
    * @param height The height.
    * @param rgbColour The RGB-Colour.
    */
	public static void drawBoxOutline(int leftX, int topY, int width, int height, int rgbColour){
		drawHorizontalLine(leftX, topY, width, rgbColour);
		drawHorizontalLine(leftX, (topY + height) - 1, width, rgbColour);
		drawVerticalLine(leftX, topY, height, rgbColour);
		drawVerticalLine((leftX + width) - 1, topY, height, rgbColour);
	}
   public static void method332(int i) {
      if(i >= 4 && i <= 4) {
         leftX = 0;
         topY = 0;
         bottomX = width;
         bottomY = height;
         centerX = bottomX - 1;
         centerY = bottomX / 2;
      }

   }
   /**
    * Draws a coloured vertical line in the drawingArea.
    * @param xPosition The X-Position of the line.
    * @param yPosition The start Y-Position of the line.
    * @param height The height of the line.
    * @param rgbColour The colour of the line.
    */
	public static void drawVerticalLine(int xPosition, int yPosition, int height, int rgbColour){
		if(xPosition < leftX || xPosition >= bottomX)
			return;
		if(yPosition < topY){
			height -= topY - yPosition;
			yPosition = topY;
		}
		if(yPosition + height > bottomY)
			height = bottomY - yPosition;
		int pixelIndex = xPosition + yPosition * width;
		for(int rowIndex = 0; rowIndex < height; rowIndex++)
			pixels[pixelIndex + rowIndex * width] = rgbColour;
	}
    /**
     * Draws a transparent box.
     * @param leftX The left edge X-Coordinate of the box.
     * @param topY The top edge Y-Coordinate of the box.
     * @param width The box width.
     * @param height The box height.
     * @param rgbColour The box colour.
     * @param opacity The opacity value ranging from 0 to 256.
     */
	public static void drawTransparentBox(int leftX, int topY, int width, int height, int rgbColour, int opacity){
		if(leftX < DrawingArea.leftX){
            width -= DrawingArea.leftX - leftX;
			leftX = DrawingArea.leftX;
		}
		if(topY < DrawingArea.topY){
            height -= DrawingArea.topY - topY;
            topY = DrawingArea.topY;
		}
		if(leftX + width > bottomX)
			width = bottomX - leftX;
		if(topY + height > bottomY)
			height = bottomY - topY;
		int transparency = 256 - opacity;
		int red = (rgbColour >> 16 & 0xff) * opacity;
		int green = (rgbColour >> 8 & 0xff) * opacity;
		int blue = (rgbColour & 0xff) * opacity;
		int leftOver = DrawingArea.width - width;
		int pixelIndex = leftX + topY * DrawingArea.width;
		for(int rowIndex = 0; rowIndex < height; rowIndex++){
			for(int columnIndex = 0; columnIndex < width; columnIndex++){
				int otherRed = (pixels[pixelIndex] >> 16 & 0xff) * transparency;
				int otherGreen = (pixels[pixelIndex] >> 8 & 0xff) * transparency;
				int otherBlue = (pixels[pixelIndex] & 0xff) * transparency;
				int transparentColour = ((red + otherRed >> 8) << 16) + ((green + otherGreen >> 8) << 8) + (blue + otherBlue >> 8);
				pixels[pixelIndex++] = transparentColour;
			}
			pixelIndex += leftOver;
		}
	}
   public static void method333(int i, int j, int k, int l) {
      if(j < 0) {
         j = 0;
      }

      if(l < 0) {
         l = 0;
      }

      if(k > width) {
         k = width;
      }

      if(i > height) {
         i = height;
      }

      leftX = j;
      topY = l;
      bottomX = k;
      bottomY = i;
      centerX = bottomX - 1;
      centerY = bottomX / 2;
      anInt1387 = bottomY / 2;
   }

   public static void setDrawingArea(int i, int j, int k, int l) {
      if(j < 0) {
         j = 0;
      }

      if(l < 0) {
         l = 0;
      }

      if(k > width) {
         k = width;
      }

      if(i > height) {
         i = height;
      }

      leftX = j;
      topY = l;
      bottomX = k;
      bottomY = i;
      centerX = bottomX;
      centerY = bottomX / 2;
      anInt1387 = bottomY / 2;
   }

   public static void setAllPixelsToZero() 
   {
	   
      int i = width * height;
		for(int j = 0; j < i; j++) {
			pixels[j] = 0;
			//depthBuffer[j] = Float.MAX_VALUE;
		}

   }

   public static void drawAlphaGradient(int x, int y, int gradientWidth, int gradientHeight, int startColor, int endColor, int alpha) {
      int k1 = 0;
      int l1 = 65536 / gradientHeight;
      if(x < leftX) {
         gradientWidth -= leftX - x;
         x = leftX;
      }

      if(y < topY) {
         k1 += (topY - y) * l1;
         gradientHeight -= topY - y;
         y = topY;
      }

      if(x + gradientWidth > bottomX) {
         gradientWidth = bottomX - x;
      }

      if(y + gradientHeight > bottomY) {
         gradientHeight = bottomY - y;
      }

      int i2 = width - gradientWidth;
      int result_alpha = 256 - alpha;
      int total_pixels = x + y * width;

      for(int k2 = -gradientHeight; k2 < 0; ++k2) {
         int gradient1 = 65536 - k1 >> 8;
         int gradient2 = k1 >> 8;
         int gradient_color = ((startColor & 16711935) * gradient1 + (endColor & 16711935) * gradient2 & -16711936) + ((startColor & '\uff00') * gradient1 + (endColor & '\uff00') * gradient2 & 16711680) >>> 8;
         int color = ((gradient_color & 16711935) * alpha >> 8 & 16711935) + ((gradient_color & '\uff00') * alpha >> 8 & '\uff00');

         for(int k3 = -gradientWidth; k3 < 0; ++k3) {
            int colored_pixel = pixels[total_pixels];
            colored_pixel = ((colored_pixel & 16711935) * result_alpha >> 8 & 16711935) + ((colored_pixel & '\uff00') * result_alpha >> 8 & '\uff00');
            pixels[total_pixels++] = color + colored_pixel;
         }

         total_pixels += i2;
         k1 += l1;
      }

   }

   public static void method335(int i, int j, int k, int l, int i1, int k1) {
      if(k1 < leftX) {
         k -= leftX - k1;
         k1 = leftX;
      }

      if(j < topY) {
         l -= topY - j;
         j = topY;
      }

      if(k1 + k > bottomX) {
         k = bottomX - k1;
      }

      if(j + l > bottomY) {
         l = bottomY - j;
      }

      int l1 = 256 - i1;
      int i2 = (i >> 16 & 255) * i1;
      int j2 = (i >> 8 & 255) * i1;
      int k2 = (i & 255) * i1;
      int k3 = width - k;
      int l3 = k1 + j * width;

      for(int i4 = 0; i4 < l; ++i4) {
         for(int j4 = -k; j4 < 0; ++j4) {
            int l2 = (pixels[l3] >> 16 & 255) * l1;
            int i3 = (pixels[l3] >> 8 & 255) * l1;
            int j3 = (pixels[l3] & 255) * l1;
            int k4 = (i2 + l2 >> 8 << 16) + (j2 + i3 >> 8 << 8) + (k2 + j3 >> 8);
            pixels[l3++] = k4;
         }

         l3 += k3;
      }

   }

   public static void drawPixels(int i, int j, int k, int l, int i1) {
      if(k < leftX) {
         i1 -= leftX - k;
         k = leftX;
      }

      if(j < topY) {
         i -= topY - j;
         j = topY;
      }

      if(k + i1 > bottomX) {
         i1 = bottomX - k;
      }

      if(j + i > bottomY) {
         i = bottomY - j;
      }

      int k1 = width - i1;
      int l1 = k + j * width;

      for(int i2 = -i; i2 < 0; ++i2) {
         for(int j2 = -i1; j2 < 0; ++j2) {
            pixels[l1++] = l;
         }

         l1 += k1;
      }

   }

   public static void fillPixels(int i, int j, int k, int l, int i1) {
      method339(i1, l, j, i);
      method339(i1 + k - 1, l, j, i);
      method341(i1, l, k, i);
      method341(i1, l, k, i + j - 1);
   }
   public static void drawRectangle(int var0, int var1, int var2, int var3, int var4) {
	      method5098(var0, var1, var2, var4);
	      method5098(var0, var3 + var1 - 1, var2, var4);
	      method5100(var0, var1, var3, var4);
	      method5100(var0 + var2 - 1, var1, var3, var4);
	   }
   public static void method5100(int var0, int var1, int var2, int var3) {
	      if(var0 >= leftX && var0 < bottomY) {
	         if(var1 < topY) {
	            var2 -= topY - var1;
	            var1 = topY;
	         }

	         if(var2 + var1 > bottomX) {
	            var2 = bottomX - var1;
	         }

	         int var4 = var0 + width * var1;

	         for(int var5 = 0; var5 < var2; ++var5) {
	            pixels[var4 + var5 * width] = var3;
	         }

	      }
	   }
   public static void method5098(int var0, int var1, int var2, int var3) {
	      if(var1 >= leftX && var1 < bottomY) {
	         if(var0 < leftX) {
	            var2 -= leftX - var0;
	            var0 = leftX;
	         }

	         if(var0 + var2 > bottomX) {
	            var2 = bottomX - var0;
	         }

	         int var4 = var0 + width * var1;

	         for(int var5 = 0; var5 < var2; ++var5) {
	            pixels[var4 + var5] = var3;
	         }

	      }
	   }
   public static void method338(int i, int j, int k, int l, int i1, int j1, int k1) {
      method340(l, i1, i, k, j1);
      if(k1 != -17319) {
         for(int l1 = 1; l1 > 0; ++l1) {
         }
      }

      method340(l, i1, i + j - 1, k, j1);
      if(j >= 3) {
         method342(l, j1, k, i + 1, (byte)3, j - 2);
         method342(l, j1 + i1 - 1, k, i + 1, (byte)3, j - 2);
      }

   }

   public static void method339(int i, int j, int k, int l) {
      if(i >= topY && i < bottomY) {
         if(l < leftX) {
            k -= leftX - l;
            l = leftX;
         }

         if(l + k > bottomX) {
            k = bottomX - l;
         }

         int i1 = l + i * width;

         for(int j1 = 0; j1 < k; ++j1) {
            pixels[i1 + j1] = j;
         }
      }

   }

   public static void method340(int i, int j, int k, int l, int i1) {
      if(k >= topY && k < bottomY) {
         if(i1 < leftX) {
            j -= leftX - i1;
            i1 = leftX;
         }

         if(i1 + j > bottomX) {
            j = bottomX - i1;
         }

         int j1 = 256 - l;
         int k1 = (i >> 16 & 255) * l;
         int l1 = (i >> 8 & 255) * l;
         int i2 = (i & 255) * l;
         int i3 = i1 + k * width;

         for(int j3 = 0; j3 < j; ++j3) {
            int j2 = (pixels[i3] >> 16 & 255) * j1;
            int k2 = (pixels[i3] >> 8 & 255) * j1;
            int l2 = (pixels[i3] & 255) * j1;
            int k3 = (k1 + j2 >> 8 << 16) + (l1 + k2 >> 8 << 8) + (i2 + l2 >> 8);
            pixels[i3++] = k3;
         }
      }

   }

   public static void method341(int i, int j, int k, int l) {
      if(l >= leftX && l < bottomX) {
         if(i < topY) {
            k -= topY - i;
            i = topY;
         }

         if(i + k > bottomY) {
            k = bottomY - i;
         }

         int j1 = l + i * width;

         for(int k1 = 0; k1 < k; ++k1) {
            pixels[j1 + k1 * width] = j;
         }
      }

   }

   public static void method342(int i, int j, int k, int l, byte byte0, int i1) {
      if(j >= leftX && j < bottomX) {
         if(l < topY) {
            i1 -= topY - l;
            l = topY;
         }

         if(l + i1 > bottomY) {
            i1 = bottomY - l;
         }

         int j1 = 256 - k;
         int k1 = (i >> 16 & 255) * k;
         int l1 = (i >> 8 & 255) * k;
         int i2 = (i & 255) * k;
         if(byte0 == 3) {
            int i3 = j + l * width;

            for(int j3 = 0; j3 < i1; ++j3) {
               int j2 = (pixels[i3] >> 16 & 255) * j1;
               int k2 = (pixels[i3] >> 8 & 255) * j1;
               int l2 = (pixels[i3] & 255) * j1;
               int k3 = (k1 + j2 >> 8 << 16) + (l1 + k2 >> 8 << 8) + (i2 + l2 >> 8);
               pixels[i3] = k3;
               i3 += width;
            }
         }
      }

   }

   public static void drawAlphaPixels(int x, int y, int w, int h, int color, int alpha) {
      if(x < leftX) {
         w -= leftX - x;
         x = leftX;
      }

      if(y < topY) {
         h -= topY - y;
         y = topY;
      }

      if(x + w > bottomY) {
         w = bottomY - x;
      }

      if(y + h > bottomY) {
         h = bottomY - y;
      }

      int l1 = 256 - alpha;
      int i2 = (color >> 16 & 255) * alpha;
      int j2 = (color >> 8 & 255) * alpha;
      int k2 = (color & 255) * alpha;
      int k3 = width - w;
      int l3 = x + y * width;

      for(int i4 = 0; i4 < h; ++i4) {
         for(int j4 = -w; j4 < 0; ++j4) {
            int l2 = (pixels[l3] >> 16 & 255) * l1;
            int i3 = (pixels[l3] >> 8 & 255) * l1;
            int j3 = (pixels[l3] & 255) * l1;
            int k4 = (i2 + l2 >> 8 << 16) + (j2 + i3 >> 8 << 8) + (k2 + j3 >> 8);
            pixels[l3++] = k4;
         }

         l3 += k3;
      }

   }

   public static void drawRectangle(int x, int y, int width, int height, int color, int alpha) {
      drawHorizontalLine(x, y, width, color, alpha);
      drawHorizontalLine(x, y + height - 1, width, color, alpha);
      if(height >= 3) {
         drawVerticalLine(x, y + 1, height - 2, color, alpha);
         drawVerticalLine(x + width - 1, y + 1, height - 2, color, alpha);
      }

   }
   public static void Rasterizer2D_fillRectangle(int var0, int var1, int var2, int var3, int var4) {
	      if(var0 < leftX) {
	         var2 -= leftX - var0;
	         var0 = leftX;
	      }

	      if(var1 < topY) {
	         var3 -= topY - var1;
	         var1 = topY;
	      }

	      if(var0 + var2 > bottomX) {
	         var2 = bottomX - var0;
	      }

	      if(var3 + var1 > bottomY) {
	         var3 = bottomY - var1;
	      }

	      int var5 = width - var2;
	      int var6 = var0 + width * var1;

	      for(int var7 = -var3; var7 < 0; ++var7) {
	         for(int var8 = -var2; var8 < 0; ++var8) {
	        	 pixels[var6++] = var4;
	         }

	         var6 += var5;
	      }

	   }

   public static void fillRectangle(int x, int y, int width, int height, int color, int alpha) {
      if(x < leftX) {
         width -= leftX - x;
         x = leftX;
      }

      if(y < topY) {
         height -= topY - y;
         y = topY;
      }

      if(x + width > bottomX) {
         width = bottomX - x;
      }

      if(y + height > bottomY) {
         height = bottomY - y;
      }

      int l1 = 256 - alpha;
      int i2 = (color >> 16 & 255) * alpha;
      int j2 = (color >> 8 & 255) * alpha;
      int k2 = (color & 255) * alpha;
      int k3 = width - width;
      int l3 = x + y * width;

      for(int i4 = 0; i4 < height; ++i4) {
         for(int j4 = -width; j4 < 0; ++j4) {
            int l2 = (pixels[l3] >> 16 & 255) * l1;
            int i3 = (pixels[l3] >> 8 & 255) * l1;
            int j3 = (pixels[l3] & 255) * l1;
            int k4 = (i2 + l2 >> 8 << 16) + (j2 + i3 >> 8 << 8) + (k2 + j3 >> 8);
            pixels[l3++] = k4;
         }

         l3 += k3;
      }

   }

   public static void drawHorizontalLine(int x, int y, int length, int color, int alpha) {
      if(y >= topY && y < bottomY) {
         if(x < leftX) {
            length -= leftX - x;
            x = leftX;
         }

         if(x + length > bottomX) {
            length = bottomX - x;
         }

         int j1 = 256 - alpha;
         int k1 = (color >> 16 & 255) * alpha;
         int l1 = (color >> 8 & 255) * alpha;
         int i2 = (color & 255) * alpha;
         int i3 = x + y * width;

         for(int j3 = 0; j3 < length; ++j3) {
            int j2 = (pixels[i3] >> 16 & 255) * j1;
            int k2 = (pixels[i3] >> 8 & 255) * j1;
            int l2 = (pixels[i3] & 255) * j1;
            int k3 = (k1 + j2 >> 8 << 16) + (l1 + k2 >> 8 << 8) + (i2 + l2 >> 8);
            pixels[i3++] = k3;
         }
      }

   }

   public static void drawVerticalLine(int x, int y, int length, int color, int alpha) {
      if(x >= leftX && x < bottomX) {
         if(y < topY) {
            length -= topY - y;
            y = topY;
         }

         if(y + length > bottomY) {
            length = bottomY - y;
         }

         int j1 = 256 - alpha;
         int k1 = (color >> 16 & 255) * alpha;
         int l1 = (color >> 8 & 255) * alpha;
         int i2 = (color & 255) * alpha;
         int i3 = x + y * width;

         for(int j3 = 0; j3 < length; ++j3) {
            int j2 = (pixels[i3] >> 16 & 255) * j1;
            int k2 = (pixels[i3] >> 8 & 255) * j1;
            int l2 = (pixels[i3] & 255) * j1;
            int k3 = (k1 + j2 >> 8 << 16) + (l1 + k2 >> 8 << 8) + (i2 + l2 >> 8);
            pixels[i3] = k3;
            i3 += width;
         }
      }

   }

   public static void drawHorizontalLine(int drawX, int drawY, int lineWidth, int i_62_) {
      if(drawY >= topY && drawY < bottomY) {
         if(drawX < leftX) {
            lineWidth -= leftX - drawX;
            drawX = leftX;
         }

         if(drawX + lineWidth > bottomX) {
            lineWidth = bottomX - drawX;
         }

         int i_63_ = drawX + drawY * width;

         for(int i_64_ = 0; i_64_ < lineWidth; ++i_64_) {
            pixels[i_63_ + i_64_] = i_62_;
         }
      }

   }

   public static void defaultDrawingAreaSize() {
      leftX = 0;
      topY = 0;
      bottomX = width;
      bottomY = height;
      centerX = bottomX;
      centerY = bottomX / 2;
   }

   public static void drawAlphaFilledPixels(int xPos, int yPos, int pixelWidth, int pixelHeight, int color, int alpha) {
      if(xPos < leftX) {
         pixelWidth -= leftX - xPos;
         xPos = leftX;
      }

      if(yPos < topY) {
         pixelHeight -= topY - yPos;
         yPos = topY;
      }

      if(xPos + pixelWidth > bottomX) {
         pixelWidth = bottomX - xPos;
      }

      if(yPos + pixelHeight > bottomY) {
         pixelHeight = bottomY - yPos;
      }

      color = ((color & 16711935) * alpha >> 8 & 16711935) + ((color & '\uff00') * alpha >> 8 & '\uff00');
      int k1 = 256 - alpha;
      int l1 = width - pixelWidth;
      int i2 = xPos + yPos * width;

      for(int j2 = 0; j2 < pixelHeight; ++j2) {
         for(int k2 = -pixelWidth; k2 < 0; ++k2) {
            int l2 = pixels[i2];
            l2 = ((l2 & 16711935) * k1 >> 8 & 16711935) + ((l2 & '\uff00') * k1 >> 8 & '\uff00');
            pixels[i2++] = color + l2;
         }

         i2 += l1;
      }

   }

   public static void drawAlphaBox(int x, int y, int lineWidth, int lineHeight, int color, int alpha) {
      if(y < topY) {
         if(y <= topY - lineHeight) {
            return;
         }

         lineHeight -= topY - y;
         y += topY - y;
      }

      if(y + lineHeight > bottomY) {
         lineHeight -= y + lineHeight - bottomY;
      }

      if(x < leftX) {
         lineWidth -= leftX - x;
         x = leftX;
      }

      if(x + lineWidth > bottomX) {
         lineWidth = bottomX - x;
      }

      for(int yOff = 0; yOff < lineHeight; ++yOff) {
         int i3 = x + (y + yOff) * width;

         for(int j3 = 0; j3 < lineWidth; ++j3) {
            int j1 = 256 - alpha;
            int k1 = (color >> 16 & 255) * alpha;
            int l1 = (color >> 8 & 255) * alpha;
            int i2 = (color & 255) * alpha;
            int j2 = (pixels[i3] >> 16 & 255) * j1;
            int k2 = (pixels[i3] >> 8 & 255) * j1;
            int l2 = (pixels[i3] & 255) * j1;
            int k3 = (k1 + j2 >> 8 << 16) + (l1 + k2 >> 8 << 8) + (i2 + l2 >> 8);
            pixels[i3++] = k3;
         }
      }

   }
	private static void method342(int i, int j, int k, int l, int i1)
	{
		if(j < leftX || j >= bottomX)
			return;
		if(l < topY)
		{
			i1 -= topY - l;
			l = topY;
		}
		if(l + i1 > bottomY)
			i1 = bottomY - l;
		int j1 = 256 - k;
		int k1 = (i >> 16 & 0xff) * k;
		int l1 = (i >> 8 & 0xff) * k;
		int i2 = (i & 0xff) * k;
		int i3 = j + l * width;
		for(int j3 = 0; j3 < i1; j3++)
		{
			int j2 = (pixels[i3] >> 16 & 0xff) * j1;
			int k2 = (pixels[i3] >> 8 & 0xff) * j1;
			int l2 = (pixels[i3] & 0xff) * j1;
			int k3 = ((k1 + j2 >> 8) << 16) + ((l1 + k2 >> 8) << 8) + (i2 + l2 >> 8);
			pixels[i3] = k3;
			i3 += width;
		}

	}

	public static void method338(int i, int j, int k, int l, int i1, int j1)
	{
		method340(l, i1, i, k, j1);
		method340(l, i1, (i + j) - 1, k, j1);
		if(j >= 3)
		{
			method342(l, j1, k, i + 1, j - 2);
			method342(l, (j1 + i1) - 1, k, i + 1, j - 2);
		}
	}

	public static void method336(int i, int j, int k, int l, int i1)
	{
		if(k < leftX)
		{
			i1 -= leftX - k;
			k = leftX;
		}
		if(j < topY)
		{
			i -= topY - j;
			j = topY;
		}
		if(k + i1 > bottomX)
			i1 = bottomX - k;
		if(j + i > bottomY)
			i = bottomY - j;
		int k1 = width - i1;
		int l1 = k + j * width;
		for(int i2 = -i; i2 < 0; i2++)
		{
			for(int j2 = -i1; j2 < 0; j2++)
				pixels[l1++] = l;

			l1 += k1;
		}

	}
	public static void drawBox(int leftX, int topY, int width, int height, int rgbColour) {
		if (leftX < DrawingArea.leftX) {
            width -= DrawingArea.leftX - leftX;
			leftX = DrawingArea.leftX;
		}
		if (topY < DrawingArea.topY) {
            height -= DrawingArea.topY - topY;
			topY = DrawingArea.topY;
		}
		if (leftX + width > bottomX)
			width = bottomX - leftX;
		if (topY + height > bottomY)
			height = bottomY - topY;
		int leftOver = DrawingArea.width - width;
		int pixelIndex = leftX + topY * DrawingArea.width;
		for (int rowIndex = 0; rowIndex < height; rowIndex++) {
			for (int columnIndex = 0; columnIndex < width; columnIndex++)
				pixels[pixelIndex++] = rgbColour;
			pixelIndex += leftOver;
		}
	}

}
