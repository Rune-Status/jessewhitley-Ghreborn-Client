package com.Ghreborn.client.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.Ghreborn.client.cache.bzip.BZip2Decompressor;
import com.Ghreborn.client.io.Buffer;

public final class StreamLoader {
   public byte[] buffer;
   private boolean extracted;
   public int entries;
   public int[] identifiers;
   public int[] extractedSizes;
   public int[] sizes;
   public int[] indices;


   public StreamLoader(byte[] data) {
      Buffer stream = new Buffer(data);
      
      int decompressedLength = stream.readTriByte();
      int compressedLength = stream.readTriByte();
      
      if(compressedLength != decompressedLength) {
          byte[] output = new byte[decompressedLength];
         BZip2Decompressor.decompress(output, decompressedLength, data, compressedLength, 6);
         buffer = output;
         stream = new Buffer(buffer);
         this.extracted = true;
      } else {
         this.buffer = data;
         this.extracted = false;
      }

      this.entries = stream.readUnsignedWord();
         this.identifiers = new int[this.entries];
         this.extractedSizes = new int[this.entries];
         this.sizes = new int[this.entries];
         this.indices = new int[this.entries];
         int var8 = stream.currentOffset + this.entries * 10;

         for(int file = 0; file < this.entries; ++file) {
            this.identifiers[file] = stream.readInt();
            this.extractedSizes[file] = stream.readTriByte();
            this.sizes[file] = stream.readTriByte();
            this.indices[file] = var8;
            var8 += this.sizes[file];
         
      }

   }

   public byte[] readFile(String name) {
      byte[] output = null;
      int hash = 0;
      name = name.toUpperCase();

      for(int index = 0; index < name.length(); ++index) {
         hash = hash * 61 + name.charAt(index) - 32;
      }

      for(int file = 0; file < this.entries; ++file) {
         if(this.identifiers[file] == hash) {
            if(output == null) {
            	output = new byte[this.extractedSizes[file]];
            }

            if(!this.extracted) {
               BZip2Decompressor.decompress(output, this.extractedSizes[file], this.buffer, this.sizes[file], this.indices[file]);
            } else {
               for(int l = 0; l < this.extractedSizes[file]; ++l) {
            	   output[l] = this.buffer[this.indices[file] + l];
               }
            }

            return output;
         }
      }

      return null;
   }

	public static byte[] getBytesFromFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length
				&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		if (offset < bytes.length) {
			is.close();
			throw new IOException("Could not completely read file "
					+ file.getName());
		}

		is.close();
		return bytes;
	}
}
