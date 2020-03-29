package com.Ghreborn.client.io;

import com.Ghreborn.client.Constants;
import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.link.NodeList;
import com.Ghreborn.client.link.NodeSub;
import com.Ghreborn.client.net.ISAACRandomGen;

import java.math.BigInteger;

public final class Buffer extends NodeSub {
   public ISAACRandomGen encryption;
   public static boolean aBoolean1418;
   private static final BigInteger RSA_MODULUS = new BigInteger("94115332353715345698191988596471158114540151806419009688208482582760341392058423175372475925221292787433629176510514170832242694305986052903268134526743745172087636873978660752027566449482009762545793713302975510339373947179850180846432962347281891677099361714090229834619251117651955800637990588235706735411");

   private static final BigInteger RSA_EXPONENT = new BigInteger("65537");

   private static int[] anIntArray1408 = new int[256];
   private static final int[] anIntArray1409 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   private static NodeList aClass19_1414 = new NodeList(169);
   private static NodeList aClass19_1415 = new NodeList(169);
   private static NodeList aClass19_1416 = new NodeList(169);
   private static char[] aCharArray1417 = new char[]{'\u0041', '\u0042', '\u0043', '\u0044', '\u0045', '\u0046', '\u0047', '\u0048', '\u0049', '\u004a', '\u004b', '\u004c', '\u004d', '\u004e', '\u004f', '\u0050', '\u0051', '\u0052', '\u0053', '\u0054', '\u0055', '\u0056', '\u0057', '\u0058', '\u0059', '\u005a', '\u0061', '\u0062', '\u0063', '\u0064', '\u0065', '\u0066', '\u0067', '\u0068', '\u0069', '\u006a', '\u006b', '\u006c', '\u006d', '\u006e', '\u006f', '\u0070', '\u0071', '\u0072', '\u0073', '\u0074', '\u0075', '\u0076', '\u0077', '\u0078', '\u0079', '\u007a', '\u0030', '\u0031', '\u0032', '\u0033', '\u0034', '\u0035', '\u0036', '\u0037', '\u0038', '\u0039', '\u002b', '\u002f'};
   public byte[] buffer;
   public int currentOffset;
   private static int anInt1411;
   private static int anInt1412;
   private static int anInt1413;
   private int anInt1389;
   private int anInt1390;
   private byte aByte1391;
   private int anInt1392;
   private int anInt1393;
   private byte aByte1394;
   private int anInt1395;
   private boolean aBoolean1396;
   private int anInt1397;
   private byte aByte1398;
   private byte aByte1399;
   private byte aByte1400;
   private boolean aBoolean1401;
   private int anInt1402;
   private boolean aBoolean1403;
   private boolean aBoolean1404;
   public int anInt1407;

   static {
      for(int j = 0; j < 256; ++j) {
         int i = j;

         for(int k = 0; k < 8; ++k) {
            if((i & 1) == 1) {
               i = i >>> 1 ^ -306674912;
            } else {
               i >>>= 1;
            }
         }

         anIntArray1408[j] = i;
      }

   }

   public Buffer(byte[] abyte0) {
      this.buffer = abyte0;
      this.currentOffset = 0;
   }


   private Buffer(boolean flag) {
      this.anInt1389 = 891;
      this.anInt1390 = 9;
      this.aByte1391 = 14;
      this.anInt1392 = -29508;
      this.anInt1393 = 881;
      this.aByte1394 = 8;
      this.anInt1395 = 657;
      this.aBoolean1396 = false;
      this.anInt1397 = -715;
      this.aByte1398 = -57;
      this.aByte1399 = 108;
      this.aByte1400 = 3;
      this.aBoolean1401 = false;
      this.anInt1402 = -373;
      this.aBoolean1403 = false;
      this.aBoolean1404 = true;
      if(flag) {
         throw new NullPointerException();
      }
   }

   public Buffer(byte[] abyte0, int i) {
      this.anInt1389 = 891;
      this.anInt1390 = 9;
      this.aByte1391 = 14;
      this.anInt1392 = -29508;
      this.anInt1393 = 881;
      this.aByte1394 = 8;
      this.anInt1395 = 657;
      this.aBoolean1396 = false;
      this.anInt1397 = -715;
      this.aByte1398 = -57;
      this.aByte1399 = 108;
      this.aByte1400 = 3;
      this.aBoolean1401 = false;
      this.anInt1402 = -373;
      this.aBoolean1403 = false;
      this.aBoolean1404 = true;
      if(i <= 0) {
         throw new NullPointerException();
      } else {
         this.buffer = abyte0;
         this.currentOffset = 0;
      }
   }

   public void writeByte(int i) {
      this.buffer[this.currentOffset++] = (byte)i;
   }

   public void method399(int i) {
      this.buffer[this.currentOffset++] = (byte)(i >> 8);
      this.buffer[this.currentOffset++] = (byte)i;
   }

   public void method400(boolean flag, int i) {
      this.buffer[this.currentOffset++] = (byte)i;
      this.buffer[this.currentOffset++] = (byte)(i >> 8);
      if(!flag) {
         this.anInt1389 = -142;
      }

   }

   public int readShort2() {
      this.currentOffset += 2;
      int i = ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
      if(i > 32767) {
         i -= 65537;
      }

      return i;
   }
   public int readShortSmart() {
	      int var1 = this.buffer[this.currentOffset] & 255;
	      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - 49152;
	   }
   public int getUByte() {
      return this.buffer[this.currentOffset++] & 255;
   }

   public int getInt() {
      return (this.getUByte() << 24) + (this.getUByte() << 16) + (this.getUByte() << 8) + this.getUByte();
   }

   public int g2() {
      this.currentOffset += 2;
      return ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
   }

   public int g4() {
      this.currentOffset += 4;
      return ((this.buffer[this.currentOffset - 4] & 255) << 24) + ((this.buffer[this.currentOffset - 3] & 255) << 16) + ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
   }

   public final int v(int i) {
      this.currentOffset += 3;
      return (255 & this.buffer[this.currentOffset - 3] << 16) + (255 & this.buffer[this.currentOffset - 2] << 8) + (255 & this.buffer[this.currentOffset - 1]);
   }

   public void createFrame(int i) {
      this.buffer[this.currentOffset++] = (byte)(i + this.encryption.method246());
   }

   public void writeWordBigEndian(int i) {
      this.buffer[this.currentOffset++] = (byte)i;
   }

   public String readNewString() {
      int i = this.currentOffset;

      while(this.buffer[this.currentOffset++] != 0) {
      }

      return new String(this.buffer, i, this.currentOffset - i - 1);
   }

   public int readUSmart2() {
      int baseVal = 0;

      int lastVal1;
      for(boolean lastVal = false; (lastVal1 = this.method422()) == 32767; baseVal += 32767) {
      }

      return baseVal + lastVal1;
   }

   public void writeWord(int i) {
      this.buffer[this.currentOffset++] = (byte)(i >> 8);
      this.buffer[this.currentOffset++] = (byte)i;
   }

   public void method400(int i) {
      this.buffer[this.currentOffset++] = (byte)i;
      this.buffer[this.currentOffset++] = (byte)(i >> 8);
   }

   public void writeDWordBigEndian(int i) {
      this.buffer[this.currentOffset++] = (byte)(i >> 16);
      this.buffer[this.currentOffset++] = (byte)(i >> 8);
      this.buffer[this.currentOffset++] = (byte)i;
   }

   public void writeDWord(int i) {
      this.buffer[this.currentOffset++] = (byte)(i >> 24);
      this.buffer[this.currentOffset++] = (byte)(i >> 16);
      this.buffer[this.currentOffset++] = (byte)(i >> 8);
      this.buffer[this.currentOffset++] = (byte)i;
   }

   public void method403(int j) {
      this.buffer[this.currentOffset++] = (byte)j;
      this.buffer[this.currentOffset++] = (byte)(j >> 8);
      this.buffer[this.currentOffset++] = (byte)(j >> 16);
      this.buffer[this.currentOffset++] = (byte)(j >> 24);
   }

   public void writeQWord(long l) {
      try {
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 56));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 48));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 40));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 32));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 24));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 16));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 8));
         this.buffer[this.currentOffset++] = (byte)((int)l);
      } catch (RuntimeException var4) {
         SignLink.reporterror("14395, 5, " + l + ", " + var4.toString());
         throw new RuntimeException();
      }
   }

   public void writeString(String s) {
      System.arraycopy(s.getBytes(), 0, this.buffer, this.currentOffset, s.length());
      this.currentOffset += s.length();
      this.buffer[this.currentOffset++] = 10;
   }

   public void writeBytes(byte[] abyte0, int i, int j) {
      for(int k = j; k < j + i; ++k) {
         this.buffer[this.currentOffset++] = abyte0[k];
      }

   }

   public void writeBytes(int i) {
      this.buffer[this.currentOffset - i - 1] = (byte)i;
   }

   public int readUnsignedByte() {
      return this.buffer[this.currentOffset++] & 255;
   }

   public byte readSignedByte() {
      return this.buffer[this.currentOffset++];
   }
   public byte readByte() {
	      return this.buffer[++this.currentOffset - 1];
	   }

   public int readUnsignedWord() {
      this.currentOffset += 2;
      return ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
   }

   public int readSignedWord() {
      this.currentOffset += 2;
      int i = ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
      if(i > 32767) {
         i -= 65536;
      }

      return i;
   }

   public int read3Bytes() {
      this.currentOffset += 3;
      return ((this.buffer[this.currentOffset - 3] & 255) << 16) + ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
   }

   public int readDWord() {
      this.currentOffset += 4;
      return ((this.buffer[this.currentOffset - 4] & 255) << 24) + ((this.buffer[this.currentOffset - 3] & 255) << 16) + ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
   }

   public long readQWord() {
      long l = (long)this.readDWord() & 4294967295L;
      long l1 = (long)this.readDWord() & 4294967295L;
      return (l << 32) + l1;
   }

   public byte[] readBytes() {
      int i = this.currentOffset;

      while(this.buffer[this.currentOffset++] != 10) {
      }

      byte[] abyte0 = new byte[this.currentOffset - i - 1];
      System.arraycopy(this.buffer, i, abyte0, i - i, this.currentOffset - 1 - i);
      return abyte0;
   }

   public void readBytes(int i, int j, byte[] abyte0) {
      for(int l = j; l < j + i; ++l) {
         abyte0[l] = this.buffer[this.currentOffset++];
      }

   }

   public void initBitAccess() {
      this.anInt1407 = this.currentOffset * 8;
   }

   public int readBits(int i) {
      int k = this.anInt1407 >> 3;
      int l = 8 - (this.anInt1407 & 7);
      int i1 = 0;

      for(this.anInt1407 += i; i > l; l = 8) {
         i1 += (this.buffer[k++] & anIntArray1409[l]) << i - l;
         i -= l;
      }

      if(i == l) {
         i1 += this.buffer[k] & anIntArray1409[l];
      } else {
         i1 += this.buffer[k] >> l - i & anIntArray1409[i];
      }

      return i1;
   }

   public void finishBitAccess() {
      this.currentOffset = (this.anInt1407 + 7) / 8;
   }

   public void method401(int i) {
      this.buffer[this.currentOffset++] = (byte)(i >> 16);
      this.buffer[this.currentOffset++] = (byte)(i >> 8);
      this.buffer[this.currentOffset++] = (byte)i;
   }

   public void method402(int i) {
      this.buffer[this.currentOffset++] = (byte)(i >> 24);
      this.buffer[this.currentOffset++] = (byte)(i >> 16);
      this.buffer[this.currentOffset++] = (byte)(i >> 8);
      this.buffer[this.currentOffset++] = (byte)i;
   }

   public void method403(int i, int j) {
      this.buffer[this.currentOffset++] = (byte)j;
      this.buffer[this.currentOffset++] = (byte)(j >> 8);
      if(i == 0) {
         this.buffer[this.currentOffset++] = (byte)(j >> 16);
         this.buffer[this.currentOffset++] = (byte)(j >> 24);
      }

   }

   public void method404(int i, long l) {
      try {
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 56));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 48));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 40));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 32));
         if(i < 5 || i > 5) {
            this.anInt1402 = 409;
         }

         this.buffer[this.currentOffset++] = (byte)((int)(l >> 24));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 16));
         this.buffer[this.currentOffset++] = (byte)((int)(l >> 8));
         this.buffer[this.currentOffset++] = (byte)((int)l);
      } catch (RuntimeException var5) {
         SignLink.reporterror("14395, " + i + ", " + l + ", " + var5.toString());
         throw new RuntimeException();
      }
   }

   public void method405(String s) {
      s.getBytes(0, s.length(), this.buffer, this.currentOffset);
      this.currentOffset += s.length();
      this.buffer[this.currentOffset++] = 10;
   }


   public void method407(int i, byte byte0) {
      this.buffer[this.currentOffset - i - 1] = (byte)i;
      if(byte0 == 0) {
         boolean var3 = false;
      }

   }

   public byte method409() {
      return this.buffer[this.currentOffset++];
   }



   public int method411() {
      this.currentOffset += 2;
      int i = ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
      if(i > 32767) {
         i -= 65536;
      }

      return i;
   }

   public int readTriByte() {
      this.currentOffset += 3;
      return ((this.buffer[this.currentOffset - 3] & 255) << 16) + ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
   }

   public String readString() {
      int i = this.currentOffset;

      while(this.buffer[this.currentOffset++] != 10) {
      }

      return new String(this.buffer, i, this.currentOffset - i - 1);
   }


   public long method414(int i) {
      long l = (long)this.readInt() & 4294967295L;
      if(i != -35089) {
         this.aBoolean1403 = !this.aBoolean1403;
      }

      long l1 = (long)this.readInt() & 4294967295L;
      return (l << 32) + l1;
   }

   public String method415() {
      int i = this.currentOffset;

      while(this.buffer[this.currentOffset++] != 10) {
      }

      return new String(this.buffer, i, this.currentOffset - i - 1);
   }

   public byte[] method416(byte byte0) {
      int i = this.currentOffset;

      while(this.buffer[this.currentOffset++] != 10) {
      }

      byte[] abyte0 = new byte[this.currentOffset - i - 1];
      if(byte0 != 30) {
         this.aBoolean1404 = !this.aBoolean1404;
      }

      for(int j = i; j < this.currentOffset - 1; ++j) {
         abyte0[j - i] = this.buffer[j];
      }

      return abyte0;
   }

   public void readBytes(int i, byte byte0, int j, byte[] abyte0) {
      int l;
      if(byte0 != 14) {
         for(l = 1; l > 0; ++l) {
         }
      }

      for(l = j; l < j + i; ++l) {
         abyte0[l] = this.buffer[this.currentOffset++];
      }

   }

   public void method418(int i) {
      this.anInt1407 = this.currentOffset * 8;
      if(i != this.anInt1392) {
         for(int j = 1; j > 0; ++j) {
         }
      }

   }

   public int method419(int i, int j) {
      int k = this.anInt1407 >> 3;
      int l = 8 - (this.anInt1407 & 7);
      int i1 = 0;
      if(j != 0) {
         this.aBoolean1403 = !this.aBoolean1403;
      }

      for(this.anInt1407 += i; i > l; l = 8) {
         i1 += (this.buffer[k++] & anIntArray1409[l]) << i - l;
         i -= l;
      }

      if(i == l) {
         i1 += this.buffer[k] & anIntArray1409[l];
      } else {
         i1 += this.buffer[k] >> l - i & anIntArray1409[i];
      }

      return i1;
   }

   public void method420(boolean flag) {
      this.currentOffset = (this.anInt1407 + 7) / 8;
      if(!flag) {
         for(int i = 1; i > 0; ++i) {
         }
      }

   }

   public int method421() {
      int i = this.buffer[this.currentOffset] & 255;
      return i < 128?this.readUnsignedByte() - 64:this.readUnsignedWord() - '\uc000';
   }

   public int method422() {
      int i = this.buffer[this.currentOffset] & 255;
      return i < 128?this.readUnsignedByte():this.readUnsignedWord() - '\u8000';
   }

   public void encodeRSA(BigInteger biginteger, BigInteger biginteger1) {
      int i = this.currentOffset;
      this.currentOffset = 0;
      byte[] abyte0 = new byte[i];
      this.readBytes(i, this.aByte1391, 0, abyte0);
      BigInteger biginteger2 = new BigInteger(abyte0);

      BigInteger biginteger3 = biginteger2.modPow(RSA_EXPONENT, RSA_MODULUS);
      byte[] abyte1 = biginteger3.toByteArray();
      this.currentOffset = 0;
      this.writeByte(abyte1.length);
      this.writeBytes(abyte1, abyte1.length, 0);
   }

   public void method424(int i, int j) {
      this.buffer[this.currentOffset++] = (byte)(-i);
      if(j != 0) {
         for(int k = 1; k > 0; ++k) {
         }
      }

   }

   public void method425(int i, int j) {
      this.buffer[this.currentOffset++] = (byte)(128 - j);
      i = 90 / i;
   }

   public int method426(int i) {
      return i != 0?this.anInt1395:this.buffer[this.currentOffset++] - 128 & 255;
   }

   public int method427() {
      return -this.buffer[this.currentOffset++] & 255;
   }

   public int method428(){
      return 128 - this.buffer[this.currentOffset++] & 255;
   }

   public byte method429(byte byte0) {
      if(byte0 != this.aByte1398) {
         throw new NullPointerException();
      } else {
         return (byte)(-this.buffer[this.currentOffset++]);
      }
   }

   public byte method430(int i) {
      if(i != 0) {
         for(int j = 1; j > 0; ++j) {
         }
      }

      return (byte)(128 - this.buffer[this.currentOffset++]);
   }

   public void method431(int i) {
      this.buffer[this.currentOffset++] = (byte)i;
      this.buffer[this.currentOffset++] = (byte)(i >> 8);

   }

	public void method432(int j) {
		buffer[currentOffset++] = (byte) (j >> 8);
		buffer[currentOffset++] = (byte) (j + 128);
	}


   public void method433(int j) {
      this.buffer[this.currentOffset++] = (byte)(j + 128);
      this.buffer[this.currentOffset++] = (byte)(j >> 8);
   }

	public int method434() {
		currentOffset += 2;
		return ((buffer[currentOffset - 1] & 0xff) << 8)
		+ (buffer[currentOffset - 2] & 0xff);
	}


   public int method435() {
      this.currentOffset += 2;
      return ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] - 128 & 255);
   }

   public int method436() {
      this.currentOffset += 2;
      return ((this.buffer[this.currentOffset - 1] & 255) << 8) + (this.buffer[this.currentOffset - 2] - 128 & 255);
   }

   public int method437(int i) {
      this.currentOffset += 2;
      if(i >= 0) {
         return 2;
      } else {
         int j = ((this.buffer[this.currentOffset - 1] & 255) << 8) + (this.buffer[this.currentOffset - 2] & 255);
         if(j > 32767) {
            j -= 65536;
         }

         return j;
      }
   }

   public int method438(boolean flag) {
      int j;
      if(flag) {
         for(j = 1; j > 0; ++j) {
         }
      }

      this.currentOffset += 2;
      j = ((this.buffer[this.currentOffset - 1] & 255) << 8) + (this.buffer[this.currentOffset - 2] - 128 & 255);
      if(j > 32767) {
         j -= 65536;
      }

      return j;
   }

	public int method439() {
		currentOffset += 4;
		return ((buffer[currentOffset - 2] & 0xff) << 24) + ((buffer[currentOffset - 1] & 0xff) << 16) + ((buffer[currentOffset - 4] & 0xff) << 8) + (buffer[currentOffset - 3] & 0xff);
	}

	public int readInt() {
		currentOffset += 4;
		return ((buffer[currentOffset - 4] & 0xff) << 24)
				+ ((buffer[currentOffset - 3] & 0xff) << 16)
				+ ((buffer[currentOffset - 2] & 0xff) << 8)
				+ (buffer[currentOffset - 1] & 0xff);
	}



   public int method440() {
      this.currentOffset += 4;
      return ((this.buffer[this.currentOffset - 3] & 255) << 24) + ((this.buffer[this.currentOffset - 4] & 255) << 16) + ((this.buffer[this.currentOffset - 1] & 255) << 8) + (this.buffer[this.currentOffset - 2] & 255);
   }

   public void method441(int i, byte byte0, byte[] abyte0, int j) {
      if(byte0 != 6) {
         this.aBoolean1396 = !this.aBoolean1396;
      }

      for(int k = i + j - 1; k >= i; --k) {
         this.buffer[this.currentOffset++] = (byte)(abyte0[k] + 128);
      }

   }

   public void method442(int i, int j, boolean flag, byte[] abyte0) {
      if(!flag) {
         this.aBoolean1396 = !this.aBoolean1396;
      }

      for(int k = j + i - 1; k >= j; --k) {
         abyte0[k] = this.buffer[this.currentOffset++];
      }

   }

   public int getShort() {
      this.currentOffset += 2;
      return ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
   }

   public int getTribyte() {
      this.currentOffset += 3;
      return ((this.buffer[this.currentOffset - 3] & 255) << 16) + ((this.buffer[this.currentOffset - 2] & 255) << 8) + (this.buffer[this.currentOffset - 1] & 255);
   }

	public void putShort(final int int_0) {
		buffer[currentOffset++] = (byte) (int_0 >> 8);
		buffer[currentOffset++] = (byte) int_0;
	}

    public int readUShort() {
        currentOffset += 2;
        return ((buffer[currentOffset - 2] & 0xff) << 8)
                + (buffer[currentOffset - 1] & 0xff);
    }

	public int read24BitInt() {
		currentOffset += 3;
		return ((buffer[currentOffset - 3] & 0xFF) << 16) + (buffer[currentOffset - 1] & 0xFF)
				+ ((buffer[currentOffset - 2] & 0xFF) << 8);
	}

	public int readUnsignedShort() {
		currentOffset += 2;
		return (buffer[currentOffset - 1] & 0xFF) + ((buffer[currentOffset - 2] & 0xFF) << 8);
	}

	public void writeLEShortA(int j) {
		buffer[currentOffset++] = (byte) (j + 128);
		buffer[currentOffset++] = (byte) (j >> 8);
	}
	public void writeLEShort(int i) {
		buffer[currentOffset++] = (byte) i;
		buffer[currentOffset++] = (byte) (i >> 8);
	}

	public void writeNegatedByte(int i) {
		buffer[currentOffset++] = (byte) (-i);
	}
	public static Buffer create() {
		synchronized (aClass19_1415) {
			Buffer stream = null;
			if (anInt1412 > 0) {
				anInt1412--;
				stream = (Buffer) aClass19_1415.popHead();
			}
			if (stream != null) {
				stream.currentOffset = 0;
				return stream;
			}
		}
		Buffer stream_1 = new Buffer(false);
		stream_1.currentOffset = 0;
		stream_1.buffer = new byte[5000];
		return stream_1;
	}

	   public int readShort() {
		      this.currentOffset += 2;
		      int var1 = (this.buffer[this.currentOffset - 1] & 255) + ((this.buffer[this.currentOffset - 2] & 255) << 8);
		      if(var1 > 32767) {
		         var1 -= 65536;
		      }

		      return var1;
		   }


}
