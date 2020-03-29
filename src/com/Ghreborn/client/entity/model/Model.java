package com.Ghreborn.client.entity.model;

import com.Ghreborn.client.Constants;
import com.Ghreborn.client.Main;
import com.Ghreborn.client.cache.anim.Frame;
import com.Ghreborn.client.cache.anim.FrameBase;
import com.Ghreborn.client.draw.DrawingArea;
import com.Ghreborn.client.draw.Rasterizer;
import com.Ghreborn.client.entity.Animable;
import com.Ghreborn.client.io.Buffer;
import com.Ghreborn.client.map.WorldController;
import com.Ghreborn.client.net.OnDemandFetcherParent;
import com.Ghreborn.client.particles.Particle;
import com.Ghreborn.client.particles.ParticleAttachment;
import com.Ghreborn.client.particles.ParticleDefinition;
import com.Ghreborn.client.particles.Vector;

public class Model extends Animable {

	public static void nullLoader() {
		aClass21Array1661 = null;
		aBooleanArray1663 = null;
		aBooleanArray1664 = null;
		anIntArray1666 = null;
		anIntArray1667 = null;
		anIntArray1668 = null;
		anIntArray1669 = null;
		anIntArray1670 = null;
		anIntArray1671 = null;
		anIntArrayArray1672 = null;
		anIntArray1673 = null;
		anIntArrayArray1674 = null;
		anIntArray1675 = null;
		anIntArray1676 = null;
		anIntArray1677 = null;
		SINE = null;
		COSINE = null;
		modelIntArray3 = null;
		modelIntArray4 = null;
	}

	public void readOldModel(byte[] data, int modelId) {
		boolean has_face_type = false;
		boolean has_texture_type = false;
		Buffer stream = new Buffer(data);
		Buffer stream1 = new Buffer(data);
		Buffer stream2 = new Buffer(data);
		Buffer stream3 = new Buffer(data);
		Buffer stream4 = new Buffer(data);
		stream.currentOffset = data.length - 18;
		numberOfVerticeCoordinates = stream.readUnsignedShort();
		numberOfTriangleFaces = stream.readUnsignedShort();
		anInt1642 = stream.readUnsignedByte();
		int type_opcode = stream.readUnsignedByte();
		int walkingPrecedence_opcode = stream.readUnsignedByte();
		int alpha_opcode = stream.readUnsignedByte();
		int tSkin_opcode = stream.readUnsignedByte();
		int vSkin_opcode = stream.readUnsignedByte();
		int i_254_ = stream.readUnsignedShort();
		int i_255_ = stream.readUnsignedShort();
		int i_256_ = stream.readUnsignedShort();
		int i_257_ = stream.readUnsignedShort();
		int i_258_ = 0;

		int i_259_ = i_258_;
		i_258_ += numberOfVerticeCoordinates;

		int i_260_ = i_258_;
		i_258_ += numberOfTriangleFaces;

		int i_261_ = i_258_;
		if (walkingPrecedence_opcode == 255)
			i_258_ += numberOfTriangleFaces;

		int i_262_ = i_258_;
		if (tSkin_opcode == 1)
			i_258_ += numberOfTriangleFaces;

		int i_263_ = i_258_;
		if (type_opcode == 1)
			i_258_ += numberOfTriangleFaces;

		int i_264_ = i_258_;
		if (vSkin_opcode == 1)
			i_258_ += numberOfVerticeCoordinates;

		int i_265_ = i_258_;
		if (alpha_opcode == 1)
			i_258_ += numberOfTriangleFaces;

		int i_266_ = i_258_;
		i_258_ += i_257_;

		int i_267_ = i_258_;
		i_258_ += numberOfTriangleFaces * 2;

		int i_268_ = i_258_;
		i_258_ += anInt1642 * 6;

		int i_269_ = i_258_;
		i_258_ += i_254_;

		int i_270_ = i_258_;
		i_258_ += i_255_;

		int i_271_ = i_258_;
		i_258_ += i_256_;
		verticesParticle = new int[numberOfVerticeCoordinates];
		verticesXCoordinate = new int[numberOfVerticeCoordinates];
		verticesYCoordinate = new int[numberOfVerticeCoordinates];
		verticesZCoordinate = new int[numberOfVerticeCoordinates];
		face_a = new int[numberOfTriangleFaces];
		face_b = new int[numberOfTriangleFaces];
		face_c = new int[numberOfTriangleFaces];
		if (anInt1642 > 0) {
			texture_type = new byte[anInt1642];
			anIntArray1643 = new int[anInt1642];
			anIntArray1644 = new int[anInt1642];
			anIntArray1645 = new int[anInt1642];
		}

		if (vSkin_opcode == 1)
			anIntArray1655 = new int[numberOfVerticeCoordinates];

		if (type_opcode == 1) {
			face_render_type = new int[numberOfTriangleFaces];
			texture_coordinates = new byte[numberOfTriangleFaces];
			texture = new short[numberOfTriangleFaces];
		}

		if (walkingPrecedence_opcode == 255)
			render_priorities = new byte[numberOfTriangleFaces];
		else
			priority = (byte) walkingPrecedence_opcode;

		if (alpha_opcode == 1)
			anIntArray1639 = new int[numberOfTriangleFaces];

		if (tSkin_opcode == 1)
			anIntArray1656 = new int[numberOfTriangleFaces];

		anIntArray1640 = new short[numberOfTriangleFaces];
		stream.currentOffset = i_259_;
		stream1.currentOffset = i_269_;
		stream2.currentOffset = i_270_;
		stream3.currentOffset = i_271_;
		stream4.currentOffset = i_264_;
		int start_x = 0;
		int start_y = 0;
		int start_z = 0;
		for (int point = 0; point < numberOfVerticeCoordinates; point++) {
			int flag = stream.readUnsignedByte();
			int x = 0;
			if ((flag & 0x1) != 0)
				x = stream1.method421();
			int y = 0;
			if ((flag & 0x2) != 0)
				y = stream2.method421();
			int z = 0;
			if ((flag & 0x4) != 0)
				z = stream3.method421();

			verticesXCoordinate[point] = start_x + x;
			verticesYCoordinate[point] = start_y + y;
			verticesZCoordinate[point] = start_z + z;
			start_x = verticesXCoordinate[point];
			start_y = verticesYCoordinate[point];
			start_z = verticesZCoordinate[point];
			if (vSkin_opcode == 1)
				anIntArray1655[point] = stream4.readUnsignedByte();

		}
		stream.currentOffset = i_267_;
		stream1.currentOffset = i_263_;
		stream2.currentOffset = i_261_;
		stream3.currentOffset = i_265_;
		stream4.currentOffset = i_262_;
		for (int face = 0; face < numberOfTriangleFaces; face++) {
			anIntArray1640[face] = (short) stream.readUnsignedShort();
			if (type_opcode == 1) {
				int flag = stream1.readUnsignedByte();
				if ((flag & 0x1) == 1) {
					face_render_type[face] = 1;
					has_face_type = true;
				} else {
					face_render_type[face] = 0;
				}

				if ((flag & 0x2) != 0) {
					texture_coordinates[face] = (byte) (flag >> 2);
					texture[face] = anIntArray1640[face];
					anIntArray1640[face] = 127;
					if (texture[face] != -1)
						has_texture_type = true;

					/*if(texture[face] == 53) //frozen whip 
						texture[face] = 1;
					else
					if(texture[face] == 56) //lava dragon 
						texture[face] = 41;
					else
						if(texture[face] == 59) //infernal cape 
							texture[face] = 52;*/
				} else {
					texture_coordinates[face] = -1;
					texture[face] =  -1;
				}
			}
			if (walkingPrecedence_opcode == 255)
				render_priorities[face] = stream2.readSignedByte();

			if (alpha_opcode == 1) {
				anIntArray1639[face] = stream3.readSignedByte();
				if (anIntArray1639[face] < 0)
					anIntArray1639[face] = (256 + anIntArray1639[face]);

			}
			if (tSkin_opcode == 1)
				anIntArray1656[face] = stream4.readUnsignedByte();

		}
		stream.currentOffset = i_266_;
		stream1.currentOffset = i_260_;
		int coordinate_a = 0;
		int coordinate_b = 0;
		int coordinate_c = 0;
		int offset = 0;
		int coordinate;
		for (int face = 0; face < numberOfTriangleFaces; face++) {
			int opcode = stream1.readUnsignedByte();
			if (opcode == 1) {
				coordinate_a = (stream.method421() + offset);
				offset = coordinate_a;
				coordinate_b = (stream.method421() + offset);
				offset = coordinate_b;
				coordinate_c = (stream.method421() + offset);
				offset = coordinate_c;
				face_a[face] = coordinate_a;
				face_b[face] = coordinate_b;
				face_c[face] = coordinate_c;
			}
			if (opcode == 2) {
				coordinate_b = coordinate_c;
				coordinate_c = (stream.method421() + offset);
				offset = coordinate_c;
				face_a[face] = coordinate_a;
				face_b[face] = coordinate_b;
				face_c[face] = coordinate_c;
			}
			if (opcode == 3) {
				coordinate_a = coordinate_c;
				coordinate_c = (stream.method421() + offset);
				offset = coordinate_c;
				face_a[face] = coordinate_a;
				face_b[face] = coordinate_b;
				face_c[face] = coordinate_c;
			}
			if (opcode == 4) {
				coordinate = coordinate_a;
				coordinate_a = coordinate_b;
				coordinate_b = coordinate;
				coordinate_c = (stream.method421() + offset);
				offset = coordinate_c;
				face_a[face] = coordinate_a;
				face_b[face] = coordinate_b;
				face_c[face] = coordinate_c;
			}
		}
		stream.currentOffset = i_268_;
		for (int face = 0; face < anInt1642; face++) {
			texture_type[face] = 0;
			anIntArray1643[face] = (short) stream.readUnsignedShort();
			anIntArray1644[face] = (short) stream.readUnsignedShort();
			anIntArray1645[face] = (short) stream.readUnsignedShort();
		}
		if (texture_coordinates != null) {
			boolean textured = false;
			for (int face = 0; face < numberOfTriangleFaces; face++) {
				coordinate = texture_coordinates[face] & 0xff;
				if (coordinate != 255) {
					if (((anIntArray1643[coordinate] & 0xffff) == face_a[face]) && ((anIntArray1644[coordinate] & 0xffff)  == face_b[face]) && ((anIntArray1645[coordinate] & 0xffff) == face_c[face])) {
						texture_coordinates[face] = -1;
					} else {
						textured = true;
					}
				}
			}
			if (!textured)
				texture_coordinates = null;
		}
		if (!has_texture_type)
			texture = null;

		if (!has_face_type)
			face_render_type = null;

	}

	public void readNewModel(byte[] data, int modelId) {
		Buffer nc1 = new Buffer(data);
		Buffer nc2 = new Buffer(data);
		Buffer nc3 = new Buffer(data);
		Buffer nc4 = new Buffer(data);
		Buffer nc5 = new Buffer(data);
		Buffer nc6 = new Buffer(data);
		Buffer nc7 = new Buffer(data);
		nc1.currentOffset = data.length - 23;
		numberOfVerticeCoordinates = nc1.readUnsignedShort();
		numberOfTriangleFaces = nc1.readUnsignedShort();
		anInt1642 = nc1.readUnsignedByte();
		int flags = nc1.readUnsignedByte();
		int walkingPrecedence_opcode = nc1.readUnsignedByte();
		int alpha_opcode = nc1.readUnsignedByte();
		int tSkin_opcode = nc1.readUnsignedByte();
		int texture_opcode = nc1.readUnsignedByte();
		int vSkin_opcode = nc1.readUnsignedByte();
		int j3 = nc1.readUnsignedShort();
		int k3 = nc1.readUnsignedShort();
		int l3 = nc1.readUnsignedShort();
		int i4 = nc1.readUnsignedShort();
		int j4 = nc1.readUnsignedShort();
		int texture_id = 0;
		int texture_ = 0;
		int texture__ = 0;
		int face;
		anIntArray1640 = new short[numberOfTriangleFaces];
		if (anInt1642 > 0) {
			texture_type = new byte[anInt1642];
			nc1.currentOffset = 0;
			for (face = 0; face < anInt1642; face++) {
				byte opcode = texture_type[face] = nc1.readSignedByte();
				if (opcode == 0) {
					texture_id++;
				}

				if (opcode >= 1 && opcode <= 3) {
					texture_++;
				}
				if (opcode == 2) {
					texture__++;
				}
			}
		}
		int pos;
		pos = anInt1642;
		int vertexMod_offset = pos;
		pos += numberOfVerticeCoordinates;

		int drawTypeBasePos = pos;
		if (flags == 1)
			pos += numberOfTriangleFaces;

		int faceMeshLink_offset = pos;
		pos += numberOfTriangleFaces;

		int facewalkingPrecedenceBasePos = pos;
		if (walkingPrecedence_opcode == 255)
			pos += numberOfTriangleFaces;

		int tSkinBasePos = pos;
		if (tSkin_opcode == 1)
			pos += numberOfTriangleFaces;

		int vSkinBasePos = pos;
		if (vSkin_opcode == 1)
			pos += numberOfVerticeCoordinates;

		int alphaBasePos = pos;
		if (alpha_opcode == 1)
			pos += numberOfTriangleFaces;

		int faceVPoint_offset = pos;
		pos += i4;

		int textureIdBasePos = pos;
		if (texture_opcode == 1)
			pos += numberOfTriangleFaces * 2;

		int textureBasePos = pos;
		pos += j4;

		int color_offset = pos;
		pos += numberOfTriangleFaces * 2;

		int vertexX_offset = pos;
		pos += j3;

		int vertexY_offset = pos;
		pos += k3;

		int vertexZ_offset = pos;
		pos += l3;

		int mainStream_offset = pos;
		pos += texture_id * 6;

		int firstStream_offset = pos;
		pos += texture_ * 6;

		int secondStream_offset = pos;
		pos += texture_ * 6;

		int thirdStream_offset = pos;
		pos += texture_ * 2;

		int fourthStream_offset = pos;
		pos += texture_;

		int fifthStream_offset = pos;
		pos += texture_ * 2 + texture__ * 2;
		verticesParticle = new int[numberOfVerticeCoordinates];
		verticesXCoordinate = new int[numberOfVerticeCoordinates];
		verticesYCoordinate = new int[numberOfVerticeCoordinates];
		verticesZCoordinate = new int[numberOfVerticeCoordinates];
		face_a = new int[numberOfTriangleFaces];
		face_b = new int[numberOfTriangleFaces];
		face_c = new int[numberOfTriangleFaces];
		if (vSkin_opcode == 1)
			anIntArray1655 = new int[numberOfVerticeCoordinates];

		if (flags == 1)
			face_render_type = new int[numberOfTriangleFaces];

		if (walkingPrecedence_opcode == 255)
			render_priorities = new byte[numberOfTriangleFaces];
		else 
			priority = (byte) walkingPrecedence_opcode;

		if (alpha_opcode == 1)
			anIntArray1639 = new int[numberOfTriangleFaces];

		if (tSkin_opcode == 1)
			anIntArray1656 = new int[numberOfTriangleFaces];

		if (texture_opcode == 1)
			texture = new short[numberOfTriangleFaces];

		if (texture_opcode == 1 && anInt1642 > 0)
			texture_coordinates = new byte[numberOfTriangleFaces];

		if (anInt1642 > 0) {
			anIntArray1643 = new int[anInt1642];
			anIntArray1644 = new int[anInt1642];
			anIntArray1645 = new int[anInt1642];
		}
		nc1.currentOffset = vertexMod_offset;
		nc2.currentOffset = vertexX_offset;
		nc3.currentOffset = vertexY_offset;
		nc4.currentOffset = vertexZ_offset;
		nc5.currentOffset = vSkinBasePos;
		int start_x = 0;
		int start_y = 0;
		int start_z = 0;
		for (int point = 0; point < numberOfVerticeCoordinates; point++) {
			int flag = nc1.readUnsignedByte();
			int x = 0;
			if ((flag & 1) != 0) {
				x = nc2.method421();
			}
			int y = 0;
			if ((flag & 2) != 0) {
				y = nc3.method421();

			}
			int z = 0;
			if ((flag & 4) != 0) {
				z = nc4.method421();
			}
			verticesXCoordinate[point] = start_x + x;
			verticesYCoordinate[point] = start_y + y;
			verticesZCoordinate[point] = start_z + z;
			start_x = verticesXCoordinate[point];
			start_y = verticesYCoordinate[point];
			start_z = verticesZCoordinate[point];
			if (anIntArray1655 != null)
				anIntArray1655[point] = nc5.readUnsignedByte();

		}
		nc1.currentOffset = color_offset;
		nc2.currentOffset = drawTypeBasePos;
		nc3.currentOffset = facewalkingPrecedenceBasePos;
		nc4.currentOffset = alphaBasePos;
		nc5.currentOffset = tSkinBasePos;
		nc6.currentOffset = textureIdBasePos;
		nc7.currentOffset = textureBasePos;
		for (face = 0; face < numberOfTriangleFaces; face++) {
			anIntArray1640[face] = (short) nc1.readUnsignedShort();
			if (flags == 1) {
				face_render_type[face] = nc2.readSignedByte();
			}
			if (walkingPrecedence_opcode == 255) {
				render_priorities[face] = nc3.readSignedByte();
			}
			if (alpha_opcode == 1) {
				anIntArray1639[face] = nc4.readSignedByte();
				if (anIntArray1639[face] < 0)
					anIntArray1639[face] = (256 + anIntArray1639[face]);

			}
			if (tSkin_opcode == 1)
				anIntArray1656[face] = nc5.readUnsignedByte();

			if (texture_opcode == 1) {
				texture[face] = (short) (nc6.getShort() - 1);
				if(texture[face] >= 0) {
					if(face_render_type != null) {
						if(face_render_type[face] < 2 && anIntArray1640[face] != 127 && anIntArray1640[face] != -27075) {
							texture[face] = -1;
						}
					}
				}
				if(texture[face] != -1)
					anIntArray1640[face] = 127;
			}
			if (texture_coordinates != null && texture[face] != -1) {
				texture_coordinates[face] = (byte) (nc7.readUnsignedByte() - 1);
			}
		}
		nc1.currentOffset = faceVPoint_offset;
		nc2.currentOffset = faceMeshLink_offset;
		int coordinate_a = 0;
		int coordinate_b = 0;
		int coordinate_c = 0;
		int last_coordinate = 0;
		for (face = 0; face < numberOfTriangleFaces; face++) {
			int opcode = nc2.readUnsignedByte();
			if (opcode == 1) {
				coordinate_a = nc1.method421() + last_coordinate;
				last_coordinate = coordinate_a;
				coordinate_b = nc1.method421() + last_coordinate;
				last_coordinate = coordinate_b;
				coordinate_c = nc1.method421() + last_coordinate;
				last_coordinate = coordinate_c;
				face_a[face] = coordinate_a;
				face_b[face] = coordinate_b;
				face_c[face] = coordinate_c;
			}
			if (opcode == 2) {
				coordinate_b = coordinate_c;
				coordinate_c = nc1.method421() + last_coordinate;
				last_coordinate = coordinate_c;
				face_a[face] = coordinate_a;
				face_b[face] = coordinate_b;
				face_c[face] = coordinate_c;
			}
			if (opcode == 3) {
				coordinate_a = coordinate_c;
				coordinate_c = nc1.method421() + last_coordinate;
				last_coordinate = coordinate_c;
				face_a[face] = coordinate_a;
				face_b[face] = coordinate_b;
				face_c[face] = coordinate_c;
			}
			if (opcode == 4) {
				int l14 = coordinate_a;
				coordinate_a = coordinate_b;
				coordinate_b = l14;
				coordinate_c = nc1.method421() + last_coordinate;
				last_coordinate = coordinate_c;
				face_a[face] = coordinate_a;
				face_b[face] = coordinate_b;
				face_c[face] = coordinate_c;
			}
		}
		nc1.currentOffset = mainStream_offset;
		nc2.currentOffset = firstStream_offset;
		nc3.currentOffset = secondStream_offset;
		nc4.currentOffset = thirdStream_offset;
		nc5.currentOffset = fourthStream_offset;
		nc6.currentOffset = fifthStream_offset;
		for (face = 0; face < anInt1642; face++) {
			int opcode = texture_type[face] & 0xff;
			if (opcode == 0) {
				anIntArray1643[face] = (short) nc1.readUnsignedShort();
				anIntArray1644[face] = (short) nc1.readUnsignedShort();
				anIntArray1645[face] = (short) nc1.readUnsignedShort();
			}
			if (opcode == 1) {
				anIntArray1643[face] = (short) nc2.readUnsignedShort();
				anIntArray1644[face] = (short) nc2.readUnsignedShort();
				anIntArray1645[face] = (short) nc2.readUnsignedShort();
			}
			if (opcode == 2) {
				anIntArray1643[face] = (short) nc2.readUnsignedShort();
				anIntArray1644[face] = (short) nc2.readUnsignedShort();
				anIntArray1645[face] = (short) nc2.readUnsignedShort();
			}
			if (opcode == 3) {
				anIntArray1643[face] = (short) nc2.readUnsignedShort();
				anIntArray1644[face] = (short) nc2.readUnsignedShort();
				anIntArray1645[face] = (short) nc2.readUnsignedShort();
			}
		}
		nc1.currentOffset = pos;
		face = nc1.readUnsignedByte();
	}

	public Model(int modelId) {
		byte[] data = aClass21Array1661[modelId].modelData;
		if (data[data.length - 1] == -1 && data[data.length - 2] == -1)
			read622Model(data, modelId);
		 else 
			readOldModel(data, modelId);
	      if(newmodel[modelId]) {
	          this.scale2(4);
	          method475(0, 6, 0);
	       }
		int[][] attachments = ParticleAttachment.getAttachments(modelId);
		if (attachments != null) {
			for (int n = 0; n < attachments.length; n++) {
				int[] attach = attachments[n];
				if (attach[0] == -1) {
					for (int z = 0; z < face_a.length; z++)
						verticesParticle[face_a[z]] = attach[1] + 1;
				} else if (attach[0] == -2) {
					for (int z = 0; z < face_b.length; z++)
						verticesParticle[face_b[z]] = attach[1] + 1;
				} else if (attach[0] == -3) {
					for (int z = 0; z < face_c.length; z++)
						verticesParticle[face_c[z]] = attach[1] + 1;
				} else if (attach[0] == -4) {
					for (int z = 0; z < face_a.length; z++)
						verticesParticle[face_a[z]] = attach[1] + 1;
					for (int z = 0; z < face_b.length; z++)
						verticesParticle[face_b[z]] = attach[1] + 1;
					for (int z = 0; z < face_c.length; z++)
						verticesParticle[face_c[z]] = attach[1] + 1;
				} else {
					verticesParticle[attach[0]] = attach[1] + 1;
				}
			}
		}
	}
	   public void scale2(int i) {
		      int j;
		      for(j = 0; j < this.numberOfVerticeCoordinates; ++j) {
		         this.verticesXCoordinate[j] /= i;
		         this.verticesYCoordinate[j] /= i;
		         this.verticesZCoordinate[j] /= i;
		      }

/*		      if(this.render_priorities != null) {
		         for(j = 0; j < this.render_priorities.length; ++j) {
		            this.render_priorities[j] = 10;
		         }
		      }*/

		   }
	   public void filterTriangles() {
		      for(int triangleId = 0; triangleId < this.numberOfTriangleFaces; ++triangleId) {
		         int l = this.face_a[triangleId];
		         int k1 = this.face_b[triangleId];
		         int j2_ = this.face_c[triangleId];
		         boolean b = true;

		         for(int triId = 0; triId < this.numberOfTriangleFaces; ++triId) {
		            if(triId != triangleId) {
		               if(this.face_a[triId] == l) {
		                  b = false;
		                  break;
		               }

		               if(this.face_b[triId] == k1) {
		                  b = false;
		                  break;
		               }

		               if(this.face_c[triId] == j2_) {
		                  b = false;
		                  break;
		               }
		            }
		         }

		         if(b && this.face_render_type != null) {
		            this.anIntArray1639[triangleId] = 255;
		         }
		      }

		   }
	   public void setTexture(int fromColor, int tex) {
		      int foundAmt = 0;
		      int set2 = 0;

		      int assigned;
		      for(assigned = 0; assigned < this.anIntArray1640.length; ++assigned) {
		         if(fromColor == this.anIntArray1640[assigned]) {
		            ++foundAmt;
		         }
		      }

		      this.anInt1642 = foundAmt;
		      if(this.face_render_type == null) {
		         this.face_render_type = new int[foundAmt];
		      }

		      if(this.anIntArray1640 == null) {
		         this.anIntArray1640 = new short[foundAmt];
		      }

		      this.anIntArray1643 = new int[foundAmt];
		      this.anIntArray1644 = new int[foundAmt];
		      this.anIntArray1645 = new int[foundAmt];
		      assigned = 0;

		      for(int i = 0; i < this.numberOfTriangleFaces; ++i) {
		         if(fromColor == this.anIntArray1640[i]) {
		            this.anIntArray1640[i] = (short) tex;
		            this.face_render_type[i] = 3 + set2;
		            set2 += 4;
		            this.anIntArray1643[assigned] = this.face_a[i];
		            this.anIntArray1644[assigned] = this.face_b[i];
		            this.anIntArray1645[assigned] =  this.face_c[i];
		            ++assigned;
		         }
		      }

		   }

		   public void setTexture(int tex) {
		      this.anInt1642 = this.numberOfTriangleFaces;
		      int set2 = 0;
		      if(this.face_render_type == null) {
		         this.face_render_type = new int[this.numberOfTriangleFaces];
		      }

		      if(this.anIntArray1640 == null) {
		         this.anIntArray1640 = new short[this.numberOfTriangleFaces];
		      }

		      this.anIntArray1643 = new int[this.numberOfTriangleFaces];
		      this.anIntArray1644 = new int[this.numberOfTriangleFaces];
		      this.anIntArray1645 = new int[this.numberOfTriangleFaces];

		      for(int i = 0; i < this.numberOfTriangleFaces; ++i) {
		         this.anIntArray1640[i] = (short) tex;
		         this.face_render_type[i] = 3 + set2;
		         set2 += 4;
		         this.anIntArray1643[i] = (short) this.face_a[i];
		         this.anIntArray1644[i] = (short) this.face_b[i];
		         this.anIntArray1645[i] = (short) this.face_c[i];
		      }

		   }
	   public void read622Model(byte[] abyte0, int modelID) {
		      Buffer nc1 = new Buffer(abyte0);
		      Buffer nc2 = new Buffer(abyte0);
		      Buffer nc3 = new Buffer(abyte0);
		      Buffer nc4 = new Buffer(abyte0);
		      Buffer nc5 = new Buffer(abyte0);
		      Buffer nc6 = new Buffer(abyte0);
		      Buffer nc7 = new Buffer(abyte0);
		      nc1.currentOffset = abyte0.length - 23;
		      int numVertices = nc1.readUnsignedWord();
		      numberOfTriangleFaces = nc1.readUnsignedWord();
		      int numTexTriangles = nc1.readUnsignedByte();
		      Class21 ModelDef_1 = aClass21Array1661[modelID] = new Class21();
		      ModelDef_1.modelData = abyte0;
		      ModelDef_1.verticeCount = numVertices;
		      ModelDef_1.triangleCount = numberOfTriangleFaces;
		      ModelDef_1.texturedTriangleCount = numTexTriangles;
		      int l1 = nc1.readUnsignedByte();
		      boolean bool = ~(1 & l1) == -2;
		      boolean bool_78_ = ~(l1 & 2) == -3;
		      boolean bool_25_ = (4 & l1) == 4;
		      boolean bool_26_ = (8 & l1) == 8;
		      if(!bool_26_) {
		         this.readNewModel(abyte0, modelID);
		      } else {
		         int newformat = 0;
		         if(bool_26_) {
		            nc1.currentOffset -= 7;
		            newformat = nc1.readUnsignedByte();
		            nc1.currentOffset += 6;
		         }

		         if(newformat == 15) {
		            newmodel[modelID] = true;
		         }

		         int walkingPrecedence_opcode = nc1.readUnsignedByte();
		         int alpha_opcode = nc1.readUnsignedByte();
		         int k2 = nc1.readUnsignedByte();
		         int l2 = nc1.readUnsignedByte();
		         int i3 = nc1.readUnsignedByte();
		         int j3 = nc1.readUnsignedWord();
		         int k3 = nc1.readUnsignedWord();
		         int l3 = nc1.readUnsignedWord();
		         int i4 = nc1.readUnsignedWord();
		         int j4 = nc1.readUnsignedWord();
		         int k4 = 0;
		         int l4 = 0;
		         int i5 = 0;
		         boolean v = false;
		         boolean hb = false;
		         boolean P = false;
		         byte G = 0;
		         byte[] x = null;
		         byte[] O = null;
		         byte[] J = null;
		         byte[] F = null;
		         byte[] cb = null;
		         byte[] gb = null;
		         byte[] lb = null;
		         Object ab = null;
		         int[] kb = null;
		         int[] y = null;
		         int[] N = null;
		         short[] D = null;
		         short[] triangleColours2 = new short[numberOfTriangleFaces];
		         int k5;
		         if(numTexTriangles > 0) {
		            O = new byte[numTexTriangles];
		            nc1.currentOffset = 0;

		            for(k5 = 0; k5 < numTexTriangles; ++k5) {
		               byte i6 = O[k5] = nc1.method409();
		               if(i6 == 0) {
		                  ++k4;
		               }

		               if(i6 >= 1 && i6 <= 3) {
		                  ++l4;
		               }

		               if(i6 == 2) {
		                  ++i5;
		               }
		            }
		         }

		         k5 = numTexTriangles + numVertices;
		         int var90 = k5;
		         if(bool) {
		            k5 += numberOfTriangleFaces;
		         }

		         if(l1 == 1) {
		            k5 += numberOfTriangleFaces;
		         }

		         int j6 = k5;
		         k5 += numberOfTriangleFaces;
		         int k6 = k5;
		         if(walkingPrecedence_opcode == 255) {
		            k5 += numberOfTriangleFaces;
		         }

		         int l6 = k5;
		         if(k2 == 1) {
		            k5 += numberOfTriangleFaces;
		         }

		         int i7 = k5;
		         if(i3 == 1) {
		            k5 += numVertices;
		         }

		         int j7 = k5;
		         if(alpha_opcode == 1) {
		            k5 += numberOfTriangleFaces;
		         }

		         int k7 = k5;
		         k5 += i4;
		         int l7 = k5;
		         if(l2 == 1) {
		            k5 += numberOfTriangleFaces * 2;
		         }

		         int i8 = k5;
		         k5 += j4;
		         int j8 = k5;
		         k5 += numberOfTriangleFaces * 2;
		         int k8 = k5;
		         k5 += j3;
		         int l8 = k5;
		         k5 += k3;
		         int i9 = k5;
		         k5 += l3;
		         int j9 = k5;
		         k5 += k4 * 6;
		         int k9 = k5;
		         k5 += l4 * 6;
		         byte i_59_ = 6;
		         if(newformat != 14) {
		            if(newformat >= 15) {
		               i_59_ = 9;
		            }
		         } else {
		            i_59_ = 7;
		         }

		         int l9 = k5;
		         k5 += i_59_ * l4;
		         int i10 = k5;
		         k5 += l4;
		         int j10 = k5;
		         k5 += l4;
		         int var10000 = k5 + l4 + i5 * 2;
		         this.verticesParticle = new int[numVertices];
		         int[] vertexX = new int[numVertices];
		         int[] vertexY = new int[numVertices];
		         int[] vertexZ = new int[numVertices];
		         int[] facePoint1 = new int[numberOfTriangleFaces];
		         int[] facePoint2 = new int[numberOfTriangleFaces];
		         int[] facePoint3 = new int[numberOfTriangleFaces];
		         this.anIntArray1655 = new int[numVertices];
		         this.face_render_type = new int[numberOfTriangleFaces];
		         this.render_priorities = new byte[numberOfTriangleFaces];
		         this.anIntArray1639 = new int[numberOfTriangleFaces];
		         this.anIntArray1656 = new int[numberOfTriangleFaces];
		         if(i3 == 1) {
		            this.anIntArray1655 = new int[numVertices];
		         }

		         if(bool) {
		            this.face_render_type = new int[numberOfTriangleFaces];
		         }

		         if(walkingPrecedence_opcode == 255) {
		            this.render_priorities = new byte[numberOfTriangleFaces];
		         } else {
		        	 priority = (byte) walkingPrecedence_opcode;
		         }

		         if(alpha_opcode == 1) {
		            this.anIntArray1639 = new int[numberOfTriangleFaces];
		         }

		         if(k2 == 1) {
		            this.anIntArray1656 = new int[numberOfTriangleFaces];
		         }

		         if(l2 == 1) {
		            D = new short[numberOfTriangleFaces];
		         }

		         if(l2 == 1 && numTexTriangles > 0) {
		            x = new byte[numberOfTriangleFaces];
		         }

		         triangleColours2 = new short[numberOfTriangleFaces];
		         int[] var91 = null;
		         int[] texTrianglesPoint2 = null;
		         int[] texTrianglesPoint3 = null;
		         if(numTexTriangles > 0) {
		            var91 = new int[numTexTriangles];
		            texTrianglesPoint2 = new int[numTexTriangles];
		            texTrianglesPoint3 = new int[numTexTriangles];
		            if(l4 > 0) {
		               kb = new int[l4];
		               N = new int[l4];
		               y = new int[l4];
		               gb = new byte[l4];
		               lb = new byte[l4];
		               F = new byte[l4];
		            }

		            if(i5 > 0) {
		               cb = new byte[i5];
		               J = new byte[i5];
		            }
		         }

		         nc1.currentOffset = numTexTriangles;
		         nc2.currentOffset = k8;
		         nc3.currentOffset = l8;
		         nc4.currentOffset = i9;
		         nc5.currentOffset = i7;
		         int l10 = 0;
		         int i11 = 0;
		         int j11 = 0;

		         int k12;
		         int i13;
		         int k13;
		         int l13;
		         int i12;
		         for(k12 = 0; k12 < numVertices; ++k12) {
		            i13 = nc1.readUnsignedByte();
		            k13 = 0;
		            if((i13 & 1) != 0) {
		               k13 = nc2.method421();
		            }

		            l13 = 0;
		            if((i13 & 2) != 0) {
		               l13 = nc3.method421();
		            }

		            i12 = 0;
		            if((i13 & 4) != 0) {
		               i12 = nc4.method421();
		            }

		            vertexX[k12] = l10 + k13;
		            vertexY[k12] = i11 + l13;
		            vertexZ[k12] = j11 + i12;
		            l10 = vertexX[k12];
		            i11 = vertexY[k12];
		            j11 = vertexZ[k12];
		            if(this.anIntArray1655 != null) {
		               this.anIntArray1655[k12] = nc5.readUnsignedByte();
		            }
		         }

		         nc1.currentOffset = j8;
		         nc2.currentOffset = var90;
		         nc3.currentOffset = k6;
		         nc4.currentOffset = j7;
		         nc5.currentOffset = l6;
		         nc6.currentOffset = l7;
		         nc7.currentOffset = i8;

		         for(k12 = 0; k12 < numberOfTriangleFaces; ++k12) {
		            triangleColours2[k12] = (short) nc1.readUnsignedWord();
		            if(l1 == 1) {
		               this.face_render_type[k12] = nc2.method409();
		               if(this.face_render_type[k12] == 2) {
		                  triangleColours2[k12] = (short) '\uffff';
		               }

		               this.face_render_type[k12] = 0;
		            }

		            if(walkingPrecedence_opcode == 255) {
		               this.render_priorities[k12] = nc3.method409();
		            }

		            if(alpha_opcode == 1) {
		               this.anIntArray1639[k12] = nc4.method409();
		               if(this.anIntArray1639[k12] < 0) {
		                  this.anIntArray1639[k12] += 256;
		               }
		            }

		            if(k2 == 1) {
		               this.anIntArray1656[k12] = nc5.readUnsignedByte();
		            }

		            if(l2 == 1) {
		               D[k12] = (short)(nc6.readUnsignedWord() - 1);
		            }

		            if(x != null) {
		               if(D[k12] != -1) {
		                  x[k12] = (byte)(nc7.readUnsignedByte() - 1);
		               } else {
		                  x[k12] = -1;
		               }
		            }
		         }

		         nc1.currentOffset = k7;
		         nc2.currentOffset = j6;
		         k12 = 0;
		         i13 = 0;
		         k13 = 0;
		         l13 = 0;

		         int i15;
		         for(i12 = 0; i12 < numberOfTriangleFaces; ++i12) {
		            i15 = nc2.readUnsignedByte();
		            if(i15 == 1) {
		               k12 = nc1.method421() + l13;
		               i13 = nc1.method421() + k12;
		               k13 = nc1.method421() + i13;
		               l13 = k13;
		               facePoint1[i12] = k12;
		               facePoint2[i12] = i13;
		               facePoint3[i12] = k13;
		            }

		            if(i15 == 2) {
		               i13 = k13;
		               k13 = nc1.method421() + l13;
		               l13 = k13;
		               facePoint1[i12] = k12;
		               facePoint2[i12] = i13;
		               facePoint3[i12] = k13;
		            }

		            if(i15 == 3) {
		               k12 = k13;
		               k13 = nc1.method421() + l13;
		               l13 = k13;
		               facePoint1[i12] = k12;
		               facePoint2[i12] = i13;
		               facePoint3[i12] = k13;
		            }

		            if(i15 == 4) {
		               int l14 = k12;
		               k12 = i13;
		               i13 = l14;
		               k13 = nc1.method421() + l13;
		               l13 = k13;
		               facePoint1[i12] = k12;
		               facePoint2[i12] = l14;
		               facePoint3[i12] = k13;
		            }
		         }

		         nc1.currentOffset = j9;
		         nc2.currentOffset = k9;
		         nc3.currentOffset = l9;
		         nc4.currentOffset = i10;
		         nc5.currentOffset = j10;
		         nc6.currentOffset = k5;

		         for(i12 = 0; i12 < numTexTriangles; ++i12) {
		            i15 = O[i12] & 255;
		            if(i15 == 0) {
		               var91[i12] = nc1.readUnsignedWord();
		               texTrianglesPoint2[i12] = nc1.readUnsignedWord();
		               texTrianglesPoint3[i12] = nc1.readUnsignedWord();
		            }

		            if(i15 == 1) {
		               var91[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint2[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint3[i12] = nc2.readUnsignedWord();
		               if(newformat < 15) {
		                  kb[i12] = nc3.readUnsignedWord();
		                  if(newformat >= 14) {
		                     N[i12] = nc3.v(-1);
		                  } else {
		                     N[i12] = nc3.readUnsignedWord();
		                  }

		                  y[i12] = nc3.readUnsignedWord();
		               } else {
		                  kb[i12] = nc3.v(-1);
		                  N[i12] = nc3.v(-1);
		                  y[i12] = nc3.v(-1);
		               }

		               gb[i12] = nc4.method409();
		               lb[i12] = nc5.method409();
		               F[i12] = nc6.method409();
		            }

		            if(i15 == 2) {
		               var91[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint2[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint3[i12] = nc2.readUnsignedWord();
		               if(newformat >= 15) {
		                  kb[i12] = nc3.v(-1);
		                  N[i12] = nc3.v(-1);
		                  y[i12] = nc3.v(-1);
		               } else {
		                  kb[i12] = nc3.readUnsignedWord();
		                  if(newformat < 14) {
		                     N[i12] = nc3.readUnsignedWord();
		                  } else {
		                     N[i12] = nc3.v(-1);
		                  }

		                  y[i12] = nc3.readUnsignedWord();
		               }

		               gb[i12] = nc4.method409();
		               lb[i12] = nc5.method409();
		               F[i12] = nc6.method409();
		               cb[i12] = nc6.method409();
		               J[i12] = nc6.method409();
		            }

		            if(i15 == 3) {
		               var91[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint2[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint3[i12] = nc2.readUnsignedWord();
		               if(newformat < 15) {
		                  kb[i12] = nc3.readUnsignedWord();
		                  if(newformat < 14) {
		                     N[i12] = nc3.readUnsignedWord();
		                  } else {
		                     N[i12] = nc3.v(-1);
		                  }

		                  y[i12] = nc3.readUnsignedWord();
		               } else {
		                  kb[i12] = nc3.v(-1);
		                  N[i12] = nc3.v(-1);
		                  y[i12] = nc3.v(-1);
		               }

		               gb[i12] = nc4.method409();
		               lb[i12] = nc5.method409();
		               F[i12] = nc6.method409();
		            }
		         }

		         if(walkingPrecedence_opcode != 255) {
		            for(i12 = 0; i12 < numberOfTriangleFaces; ++i12) {
		               this.render_priorities[i12] = (byte) walkingPrecedence_opcode;
		            }
		         }

		         this.anIntArray1640 = triangleColours2;
		         this.numberOfVerticeCoordinates = numVertices;
		         this.numberOfTriangleFaces = numberOfTriangleFaces;
		         this.verticesXCoordinate = vertexX;
		         this.verticesYCoordinate = vertexY;
		         this.verticesZCoordinate = vertexZ;
		         this.face_a = facePoint1;
		         this.face_b = facePoint2;
		         this.face_c = facePoint3;
		         //this.convertTexturesTo317(D, var91, texTrianglesPoint2, texTrianglesPoint3, false);
		         this.filterTriangles();
		      }

		   }
	   public void read700Model(byte[] abyte0, int modelID) {
		      Buffer nc1 = new Buffer(abyte0);
		      Buffer nc2 = new Buffer(abyte0);
		      Buffer nc3 = new Buffer(abyte0);
		      Buffer nc4 = new Buffer(abyte0);
		      Buffer nc5 = new Buffer(abyte0);
		      Buffer nc6 = new Buffer(abyte0);
		      Buffer nc7 = new Buffer(abyte0);
		      nc1.currentOffset = abyte0.length - 23;
		      int numVertices = nc1.readUnsignedWord();
		      int numTriangles = nc1.readUnsignedWord();
		      int numTexTriangles = nc1.readUnsignedByte();
		      Class21 ModelDef_1 = aClass21Array1661[modelID] = new Class21();
		      ModelDef_1.modelData = abyte0;
		      ModelDef_1.verticeCount = numVertices;
		      ModelDef_1.triangleCount = numTriangles;
		      ModelDef_1.texturedTriangleCount = numTexTriangles;
		      int l1 = nc1.readUnsignedByte();
		      boolean bool = ~(1 & l1) == -2;
		      boolean bool_78_ = ~(l1 & 2) == -3;
		      boolean bool_25_ = (4 & l1) == 4;
		      boolean bool_26_ = (8 & l1) == 8;
		      if(!bool_26_) {
		         this.read622Model(abyte0, modelID);
		      } else {
		         int newformat = 0;
		         if(bool_26_) {
		            nc1.currentOffset -= 7;
		            newformat = nc1.readUnsignedByte();
		            nc1.currentOffset += 6;
		         }

		         if(newformat == 15) {
		            newmodel[modelID] = true;
		         }

		         int i2 = nc1.readUnsignedByte();
		         int j2 = nc1.readUnsignedByte();
		         int k2 = nc1.readUnsignedByte();
		         int l2 = nc1.readUnsignedByte();
		         int i3 = nc1.readUnsignedByte();
		         int j3 = nc1.readUnsignedWord();
		         int k3 = nc1.readUnsignedWord();
		         int l3 = nc1.readUnsignedWord();
		         int i4 = nc1.readUnsignedWord();
		         int j4 = nc1.readUnsignedWord();
		         int k4 = 0;
		         int l4 = 0;
		         int i5 = 0;
		         boolean v = false;
		         boolean hb = false;
		         boolean P = false;
		         boolean G = false;
		         byte[] x = null;
		         byte[] O = null;
		         byte[] J = null;
		         byte[] F = null;
		         byte[] cb = null;
		         byte[] gb = null;
		         byte[] lb = null;
		         Object ab = null;
		         int[] kb = null;
		         int[] y = null;
		         int[] N = null;
		         short[] D = null;
		         short[] triangleColours2 = new short[numTriangles];
		         int k5;
		         if(numTexTriangles > 0) {
		        	 O = new byte[numTexTriangles];
		            nc1.currentOffset = 0;

		            for(k5 = 0; k5 < numTexTriangles; ++k5) {
		               byte l5 = O[k5] = nc1.readSignedByte();
		               if(l5 == 0) {
		                  ++k4;
		               }

		               if(l5 >= 1 && l5 <= 3) {
		                  ++l4;
		               }

		               if(l5 == 2) {
		                  ++i5;
		               }
		            }
		         }

		         k5 = numTexTriangles + numVertices;
		         int i6 = k5;
		         if(bool) {
		            k5 += numTriangles;
		         }

		         if(l1 == 1) {
		            k5 += numTriangles;
		         }

		         int j6 = k5;
		         k5 += numTriangles;
		         int k6 = k5;
		         if(i2 == 255) {
		            k5 += numTriangles;
		         }

		         int l6 = k5;
		         if(k2 == 1) {
		            k5 += numTriangles;
		         }

		         int i7 = k5;
		         if(i3 == 1) {
		            k5 += numVertices;
		         }

		         int j7 = k5;
		         if(j2 == 1) {
		            k5 += numTriangles;
		         }

		         int k7 = k5;
		         k5 += i4;
		         int l7 = k5;
		         if(l2 == 1) {
		            k5 += numTriangles * 2;
		         }

		         int i8 = k5;
		         k5 += j4;
		         int j8 = k5;
		         k5 += numTriangles * 2;
		         int k8 = k5;
		         k5 += j3;
		         int l8 = k5;
		         k5 += k3;
		         int i9 = k5;
		         k5 += l3;
		         int j9 = k5;
		         k5 += k4 * 6;
		         int k9 = k5;
		         k5 += l4 * 6;
		         byte i_59_ = 6;
		         if(newformat != 14) {
		            if(newformat >= 15) {
		               i_59_ = 9;
		            }
		         } else {
		            i_59_ = 7;
		         }

		         int l9 = k5;
		         k5 += i_59_ * l4;
		         int i10 = k5;
		         k5 += l4;
		         int j10 = k5;
		         k5 += l4;
		         int k10 = k5;
		         k5 += l4 + i5 * 2;
		        // this.verticesParticle = new int[numVertices];
		         int[] vertexX = new int[numVertices];
		         int[] vertexY = new int[numVertices];
		         int[] vertexZ = new int[numVertices];
		         int[] facePoint1 = new int[numTriangles];
		         int[] facePoint2 = new int[numTriangles];
		         int[] facePoint3 = new int[numTriangles];
		         this.anIntArray1655 = new int[numVertices];
		         this.face_render_type = new int[numTriangles];
		         this.render_priorities = new byte[numTriangles];
		         this.anIntArray1639 = new int[numTriangles];
		         this.anIntArray1656 = new int[numTriangles];
		         if(i3 == 1) {
		            this.anIntArray1655 = new int[numVertices];
		         }

		         if(bool) {
		            this.face_render_type = new int[numTriangles];
		         }

		         if(i2 == 255) {
		            this.render_priorities = new byte[numTriangles];
		         } else {
		            byte var92 = (byte)i2;
		         }

		         if(j2 == 1) {
		            this.anIntArray1639 = new int[numTriangles];
		         }

		         if(k2 == 1) {
		            this.anIntArray1656 = new int[numTriangles];
		         }

		         if(l2 == 1) {
		        	 D = new short[numTriangles];
		         }

		         if(l2 == 1 && numTexTriangles > 0) {
		            x = new byte[numTriangles];
		         }

		         triangleColours2 = new short[numTriangles];
		         int[] texTrianglesPoint1 = null;
		         int[] texTrianglesPoint2 = null;
		         int[] texTrianglesPoint3 = null;
		         if(numTexTriangles > 0) {
		            texTrianglesPoint1 = new int[numTexTriangles];
		            texTrianglesPoint2 = new int[numTexTriangles];
		            texTrianglesPoint3 = new int[numTexTriangles];
		            if(l4 > 0) {
		               kb = new int[l4];
		               N = new int[l4];
		               y = new int[l4];
		               gb = new byte[l4];
		               lb = new byte[l4];
		               F = new byte[l4];
		            }

		            if(i5 > 0) {
		               cb = new byte[i5];
		               J = new byte[i5];
		            }
		         }

		         nc1.currentOffset = numTexTriangles;
		         nc2.currentOffset = k8;
		         nc3.currentOffset = l8;
		         nc4.currentOffset = i9;
		         nc5.currentOffset = i7;
		         int l10 = 0;
		         int i11 = 0;
		         int j11 = 0;

		         int k12;
		         int i13;
		         int k13;
		         int l13;
		         int i12;
		         for(k12 = 0; k12 < numVertices; ++k12) {
		            i13 = nc1.readUnsignedByte();
		            k13 = 0;
		            if((i13 & 1) != 0) {
		               k13 = nc2.method421();
		            }

		            l13 = 0;
		            if((i13 & 2) != 0) {
		               l13 = nc3.method421();
		            }

		            i12 = 0;
		            if((i13 & 4) != 0) {
		               i12 = nc4.method421();
		            }

		            vertexX[k12] = l10 + k13;
		            vertexY[k12] = i11 + l13;
		            vertexZ[k12] = j11 + i12;
		            l10 = vertexX[k12];
		            i11 = vertexY[k12];
		            j11 = vertexZ[k12];
		            if(this.anIntArray1655 != null) {
		               this.anIntArray1655[k12] = nc5.readUnsignedByte();
		            }
		         }

		         nc1.currentOffset = j8;
		         nc2.currentOffset = i6;
		         nc3.currentOffset = k6;
		         nc4.currentOffset = j7;
		         nc5.currentOffset = l6;
		         nc6.currentOffset = l7;
		         nc7.currentOffset = i8;

		         for(k12 = 0; k12 < numTriangles; ++k12) {
		            triangleColours2[k12] = (short) nc1.readUnsignedWord();
		            if(l1 == 1) {
		               this.face_render_type[k12] = nc2.readSignedByte();
		               if(this.face_render_type[k12] == 2) {
		                  triangleColours2[k12] = (short) '\uffff';
		               }

		               this.face_render_type[k12] = 0;
		            }

		            if(i2 == 255) {
		               this.render_priorities[k12] = nc3.readSignedByte();
		            }

		            if(j2 == 1) {
		               this.anIntArray1639[k12] = nc4.readSignedByte();
		               if(this.anIntArray1639[k12] < 0) {
		                  this.anIntArray1639[k12] += 256;
		               }
		            }

		            if(k2 == 1) {
		               this.anIntArray1656[k12] = nc5.readUnsignedByte();
		            }

		            if(l2 == 1) {
		            	D[k12] = (short)(nc6.readUnsignedWord() - 1);
		            }

		            if(x != null) {
		               if(D[k12] != -1) {
		                  x[k12] = (byte)(nc7.readUnsignedByte() - 1);
		               } else {
		                  x[k12] = -1;
		               }
		            }
		         }

		         nc1.currentOffset = k7;
		         nc2.currentOffset = j6;
		         k12 = 0;
		         i13 = 0;
		         k13 = 0;
		         l13 = 0;

		         int i15;
		         for(i12 = 0; i12 < numTriangles; ++i12) {
		            i15 = nc2.readUnsignedByte();
		            if(i15 == 1) {
		               k12 = nc1.method421() + l13;
		               i13 = nc1.method421() + k12;
		               k13 = nc1.method421() + i13;
		               l13 = k13;
		               facePoint1[i12] = k12;
		               facePoint2[i12] = i13;
		               facePoint3[i12] = k13;
		            }

		            if(i15 == 2) {
		               i13 = k13;
		               k13 = nc1.method421() + l13;
		               l13 = k13;
		               facePoint1[i12] = k12;
		               facePoint2[i12] = i13;
		               facePoint3[i12] = k13;
		            }

		            if(i15 == 3) {
		               k12 = k13;
		               k13 = nc1.method421() + l13;
		               l13 = k13;
		               facePoint1[i12] = k12;
		               facePoint2[i12] = i13;
		               facePoint3[i12] = k13;
		            }

		            if(i15 == 4) {
		               int l14 = k12;
		               k12 = i13;
		               i13 = l14;
		               k13 = nc1.method421() + l13;
		               l13 = k13;
		               facePoint1[i12] = k12;
		               facePoint2[i12] = l14;
		               facePoint3[i12] = k13;
		            }
		         }

		         nc1.currentOffset = j9;
		         nc2.currentOffset = k9;
		         nc3.currentOffset = l9;
		         nc4.currentOffset = i10;
		         nc5.currentOffset = j10;
		         nc6.currentOffset = k10;

		         for(i12 = 0; i12 < numTexTriangles; ++i12) {
		            i15 = O[i12] & 255;
		            if(i15 == 0) {
		               texTrianglesPoint1[i12] = nc1.readUnsignedWord();
		               texTrianglesPoint2[i12] = nc1.readUnsignedWord();
		               texTrianglesPoint3[i12] = nc1.readUnsignedWord();
		            }

		            if(i15 == 1) {
		               texTrianglesPoint1[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint2[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint3[i12] = nc2.readUnsignedWord();
		               if(newformat < 15) {
		                  kb[i12] = nc3.readUnsignedWord();
		                  if(newformat >= 14) {
		                     N[i12] = nc3.v(-1);
		                  } else {
		                     N[i12] = nc3.readUnsignedWord();
		                  }

		                  y[i12] = nc3.readUnsignedWord();
		               } else {
		                  kb[i12] = nc3.v(-1);
		                  N[i12] = nc3.v(-1);
		                  y[i12] = nc3.v(-1);
		               }

		               gb[i12] = nc4.readSignedByte();
		               lb[i12] = nc5.readSignedByte();
		               F[i12] = nc6.readSignedByte();
		            }

		            if(i15 == 2) {
		               texTrianglesPoint1[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint2[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint3[i12] = nc2.readUnsignedWord();
		               if(newformat >= 15) {
		                  kb[i12] = nc3.v(-1);
		                  N[i12] = nc3.v(-1);
		                  y[i12] = nc3.v(-1);
		               } else {
		                  kb[i12] = nc3.readUnsignedWord();
		                  if(newformat < 14) {
		                     N[i12] = nc3.readUnsignedWord();
		                  } else {
		                     N[i12] = nc3.v(-1);
		                  }

		                  y[i12] = nc3.readUnsignedWord();
		               }

		               gb[i12] = nc4.readSignedByte();
		               lb[i12] = nc5.readSignedByte();
		               F[i12] = nc6.readSignedByte();
		               cb[i12] = nc6.readSignedByte();
		               J[i12] = nc6.readSignedByte();
		            }

		            if(i15 == 3) {
		               texTrianglesPoint1[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint2[i12] = nc2.readUnsignedWord();
		               texTrianglesPoint3[i12] = nc2.readUnsignedWord();
		               if(newformat < 15) {
		                  kb[i12] = nc3.readUnsignedWord();
		                  if(newformat < 14) {
		                     N[i12] = nc3.readUnsignedWord();
		                  } else {
		                     N[i12] = nc3.v(-1);
		                  }

		                  y[i12] = nc3.readUnsignedWord();
		               } else {
		                  kb[i12] = nc3.v(-1);
		                  N[i12] = nc3.v(-1);
		                  y[i12] = nc3.v(-1);
		               }

		               gb[i12] = nc4.readSignedByte();
		               lb[i12] = nc5.readSignedByte();
		               F[i12] = nc6.readSignedByte();
		            }
		         }

		         if(i2 != 255) {
		            for(i12 = 0; i12 < numTriangles; ++i12) {
		               this.render_priorities[i12] = (byte)i2;
		            }
		         }

		         this.anIntArray1640 = triangleColours2;
		         this.numberOfVerticeCoordinates = numVertices;
		         this.numberOfTriangleFaces = numTriangles;
		         this.verticesXCoordinate = vertexX;
		         this.verticesYCoordinate = vertexY;
		         this.verticesZCoordinate = vertexZ;
		         this.face_a = facePoint1;
		         this.face_b = facePoint2;
		         this.face_c = facePoint3;
		        // this.convertTexturesTo317(D, texTrianglesPoint1, texTrianglesPoint2, texTrianglesPoint3, false);
		         this.filterTriangles();
		      }
		   }


	public static void method460(byte[] abyte0, int j) {
		try {
			if (abyte0 == null) {
				Class21 class21 = aClass21Array1661[j] = new Class21();
				class21.verticeCount = 0;
				class21.triangleCount = 0;
				class21.texturedTriangleCount = 0;
				return;
			}
			Buffer stream = new Buffer(abyte0);
			stream.currentOffset = abyte0.length - 18;
			Class21 class21_1 = aClass21Array1661[j] = new Class21();
			class21_1.modelData = abyte0;
			class21_1.verticeCount = stream.readUnsignedShort();
			class21_1.triangleCount = stream.readUnsignedShort();
			class21_1.texturedTriangleCount = stream.readUnsignedByte();
			int k = stream.readUnsignedByte();
			int l = stream.readUnsignedByte();
			int i1 = stream.readUnsignedByte();
			int j1 = stream.readUnsignedByte();
			int k1 = stream.readUnsignedByte();
			int l1 = stream.readUnsignedShort();
			int i2 = stream.readUnsignedShort();
			int j2 = stream.readUnsignedShort();
			int k2 = stream.readUnsignedShort();
			int l2 = 0;
			class21_1.anInt372 = l2;
			l2 += class21_1.verticeCount;
			class21_1.anInt378 = l2;
			l2 += class21_1.triangleCount;
			class21_1.anInt381 = l2;
			if (l == 255)
				l2 += class21_1.triangleCount;
			else
				class21_1.anInt381 = -l - 1;
			class21_1.anInt383 = l2;
			if (j1 == 1)
				l2 += class21_1.triangleCount;
			else
				class21_1.anInt383 = -1;
			class21_1.anInt380 = l2;
			if (k == 1)
				l2 += class21_1.triangleCount;
			else
				class21_1.anInt380 = -1;
			class21_1.anInt376 = l2;
			if (k1 == 1)
				l2 += class21_1.verticeCount;
			else
				class21_1.anInt376 = -1;
			class21_1.anInt382 = l2;
			if (i1 == 1)
				l2 += class21_1.triangleCount;
			else
				class21_1.anInt382 = -1;
			class21_1.anInt377 = l2;
			l2 += k2;
			class21_1.anInt379 = l2;
			l2 += class21_1.triangleCount * 2;
			class21_1.anInt384 = l2;
			l2 += class21_1.texturedTriangleCount * 6;
			class21_1.anInt373 = l2;
			l2 += l1;
			class21_1.anInt374 = l2;
			l2 += i2;
			class21_1.anInt375 = l2;
			l2 += j2;
		} catch (Exception _ex) {
		}
	}

	public static void method459(int id, OnDemandFetcherParent onDemandFetcherParent) {
		aClass21Array1661 = new Class21[id+200000];
	      newmodel = new boolean[id+200000];
		aOnDemandFetcherParent_1662 = onDemandFetcherParent;
	}

	public static void method461(int file, int j) {//TODO CHECK THIS
		aClass21Array1661[j] = null;
	}

	   public static Model getModel(int j) {
		      if(aClass21Array1661 == null) {
		         return null;
		      } else {
		         Class21 class21 = aClass21Array1661[j];
		         if(class21 == null) {
		            aOnDemandFetcherParent_1662.method548(j);
		            return null;
		         } else {
		            return new Model(j);
		         }
		      }
		   }

	public static boolean isCached(int file) {
		if (aClass21Array1661 == null)
			return false;

		Class21 class21 = aClass21Array1661[file];
		if (class21 == null) {
			aOnDemandFetcherParent_1662.method548(file);
			return false;
		} else {
			return true;
		}
	}

	private Model(boolean flag) {
		aBoolean1618 = true;
		aBoolean1659 = false;
		if (!flag)
			aBoolean1618 = !aBoolean1618;
	}

	public Model(int length, Model[] model_segments) {
		try {
			aBoolean1618 = true;
			aBoolean1659 = false;
			anInt1620++;
			boolean type_flag = false;
			boolean walkingPrecedence_flag = false;
			boolean alpha_flag = false;
			boolean tSkin_flag = false;
			boolean color_flag = false;
			boolean texture_flag = false;
			boolean coordinate_flag = false;
			numberOfVerticeCoordinates = 0;
			numberOfTriangleFaces = 0;
			anInt1642 = 0;
			priority = -1;
			Model build;
			for (int segment_index = 0; segment_index < length; segment_index++) {
				build = model_segments[segment_index];
				if (build != null) {
					numberOfVerticeCoordinates += build.numberOfVerticeCoordinates;
					numberOfTriangleFaces += build.numberOfTriangleFaces;
					anInt1642 += build.anInt1642;
					type_flag |= build.face_render_type != null;
					alpha_flag |= build.anIntArray1639 != null;
					if (build.render_priorities != null) {
						walkingPrecedence_flag = true;
					} else {
						if (priority == -1)
							priority = build.priority;

						if (priority != build.priority)
							walkingPrecedence_flag = true;
					}
					tSkin_flag |= build.anIntArray1656 != null;
					color_flag |= build.anIntArray1640 != null;
					texture_flag |= build.texture != null;
					coordinate_flag |= build.texture_coordinates != null;
				}
			}
			verticesParticle = new int[numberOfVerticeCoordinates];
			verticesXCoordinate = new int[numberOfVerticeCoordinates];
			verticesYCoordinate = new int[numberOfVerticeCoordinates];
			verticesZCoordinate = new int[numberOfVerticeCoordinates];
			anIntArray1655 = new int[numberOfVerticeCoordinates];
			face_a = new int[numberOfTriangleFaces];
			face_b = new int[numberOfTriangleFaces];
			face_c = new int[numberOfTriangleFaces];
			if(color_flag)
				anIntArray1640 = new short[numberOfTriangleFaces];

			if (type_flag)
				face_render_type = new int[numberOfTriangleFaces];

			if (walkingPrecedence_flag)
				render_priorities = new byte[numberOfTriangleFaces];

			if (alpha_flag)
				anIntArray1639 = new int[numberOfTriangleFaces];

			if (tSkin_flag)
				anIntArray1656 = new int[numberOfTriangleFaces];

			if(texture_flag)
				texture = new short[numberOfTriangleFaces];

			if (coordinate_flag)
				texture_coordinates = new byte[numberOfTriangleFaces];

			if(anInt1642 > 0) {
				texture_type = new byte[anInt1642];
				anIntArray1643 = new int[anInt1642];
				anIntArray1644 = new int[anInt1642];
				anIntArray1645 = new int[anInt1642];
			}
			numberOfVerticeCoordinates = 0;
			numberOfTriangleFaces = 0;
			anInt1642 = 0;
			int texture_face = 0;
			for (int segment_index = 0; segment_index < length; segment_index++) {
				build = model_segments[segment_index];
				if (build != null) {
					for (int face = 0; face < build.numberOfTriangleFaces; face++) {
						if(type_flag && build.face_render_type != null)
							face_render_type[numberOfTriangleFaces] = build.face_render_type[face];

						if (walkingPrecedence_flag)
							if (build.render_priorities == null)
								render_priorities[numberOfTriangleFaces] = build.priority;
							else
								render_priorities[numberOfTriangleFaces] = build.render_priorities[face];

						if (alpha_flag && build.anIntArray1639 != null)
							anIntArray1639[numberOfTriangleFaces] = build.anIntArray1639[face];

						if (tSkin_flag && build.anIntArray1656 != null)
							anIntArray1656[numberOfTriangleFaces] = build.anIntArray1656[face];

						if(texture_flag) {
							if(build.texture != null) 
								texture[numberOfTriangleFaces] = build.texture[face];
							else
								texture[numberOfTriangleFaces] = -1;
						}
						if(coordinate_flag) {
							if(build.texture_coordinates != null && build.texture_coordinates[face] != -1) {
								texture_coordinates[numberOfTriangleFaces] = (byte) (build.texture_coordinates[face] + texture_face);
							} else {
								texture_coordinates[numberOfTriangleFaces] = -1;
							}
						}
						anIntArray1640[numberOfTriangleFaces] = build.anIntArray1640[face];
						face_a[numberOfTriangleFaces] = method465(build, build.face_a[face]);
						face_b[numberOfTriangleFaces] = method465(build, build.face_b[face]);
						face_c[numberOfTriangleFaces] = method465(build, build.face_c[face]);
						numberOfTriangleFaces++;
					}
					for (int texture_edge = 0; texture_edge < build.anInt1642; texture_edge++) {
						anIntArray1643[anInt1642] = method465(build, build.anIntArray1643[texture_edge]);
						anIntArray1644[anInt1642] = method465(build, build.anIntArray1644[texture_edge]);
						anIntArray1645[anInt1642] = method465(build, build.anIntArray1645[texture_edge]);
						anInt1642++;
					}
					texture_face += build.anInt1642;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Model(Model[] amodel) {
		int i = 2;
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		boolean flag1 = false;
		boolean flag2 = false;
		boolean flag3 = false;
		boolean flag4 = false;
		boolean texture_flag = false;
		boolean coordinate_flag = false;
		numberOfVerticeCoordinates = 0;
		numberOfTriangleFaces = 0;
		anInt1642 = 0;
		priority = -1;
		for (int k = 0; k < i; k++) {
			Model model = amodel[k];
			if (model != null) {
				numberOfVerticeCoordinates += model.numberOfVerticeCoordinates;
				numberOfTriangleFaces += model.numberOfTriangleFaces;
				anInt1642 += model.anInt1642;
				flag1 |= model.face_render_type != null;
				if (model.render_priorities != null) {
					flag2 = true;
				} else {
					if (priority == -1)
						priority = model.priority;
					if (priority != model.priority)
						flag2 = true;
				}
				flag3 |= model.anIntArray1639 != null;
				flag4 |= model.anIntArray1640 != null;
				texture_flag |= model.texture != null;
				coordinate_flag |= model.texture_coordinates != null;
			}
		}
		verticesParticle = new int[numberOfVerticeCoordinates];
		verticesXCoordinate = new int[numberOfVerticeCoordinates];
		verticesYCoordinate = new int[numberOfVerticeCoordinates];
		verticesZCoordinate = new int[numberOfVerticeCoordinates];
		face_a = new int[numberOfTriangleFaces];
		face_b = new int[numberOfTriangleFaces];
		face_c = new int[numberOfTriangleFaces];
		anIntArray1634 = new int[numberOfTriangleFaces];
		anIntArray1635 = new int[numberOfTriangleFaces];
		anIntArray1636 = new int[numberOfTriangleFaces];
		anIntArray1643 = new int[anInt1642];
		anIntArray1644 = new int[anInt1642];
		anIntArray1645 = new int[anInt1642];
		if (flag1)
			face_render_type = new int[numberOfTriangleFaces];
		if (flag2)
			render_priorities = new byte[numberOfTriangleFaces];
		if (flag3)
			anIntArray1639 = new int[numberOfTriangleFaces];
		if (flag4)
			anIntArray1640 = new short[numberOfTriangleFaces];
		if (texture_flag)
			texture = new short[numberOfTriangleFaces];

		if (coordinate_flag)
			texture_coordinates = new byte[numberOfTriangleFaces];
		numberOfVerticeCoordinates = 0;
		numberOfTriangleFaces = 0;
		anInt1642 = 0;
		int i1 = 0;
		for (int j1 = 0; j1 < i; j1++) {
			Model model_1 = amodel[j1];
			if (model_1 != null) {
				int k1 = numberOfVerticeCoordinates;
				for (int l1 = 0; l1 < model_1.numberOfVerticeCoordinates; l1++) {
					int x = model_1.verticesXCoordinate[l1];
					int y = model_1.verticesYCoordinate[l1];
					int z = model_1.verticesZCoordinate[l1];
					verticesParticle[numberOfVerticeCoordinates] = model_1.verticesParticle[l1];
					verticesXCoordinate[numberOfVerticeCoordinates] = x;
					verticesYCoordinate[numberOfVerticeCoordinates] = y;
					verticesZCoordinate[numberOfVerticeCoordinates] = z;
					++numberOfVerticeCoordinates;
				}

				for (int i2 = 0; i2 < model_1.numberOfTriangleFaces; i2++) {
					face_a[numberOfTriangleFaces] = model_1.face_a[i2] + k1;
					face_b[numberOfTriangleFaces] = model_1.face_b[i2] + k1;
					face_c[numberOfTriangleFaces] = model_1.face_c[i2] + k1;
					anIntArray1634[numberOfTriangleFaces] = model_1.anIntArray1634[i2];
					anIntArray1635[numberOfTriangleFaces] = model_1.anIntArray1635[i2];
					anIntArray1636[numberOfTriangleFaces] = model_1.anIntArray1636[i2];
					if (flag1)
						if (model_1.face_render_type == null) {
							face_render_type[numberOfTriangleFaces] = 0;
						} else {
							int j2 = model_1.face_render_type[i2];
							if ((j2 & 2) == 2)
								j2 += i1 << 2;
							face_render_type[numberOfTriangleFaces] = j2;
						}
					if (flag2)
						if (model_1.render_priorities == null)
							render_priorities[numberOfTriangleFaces] = model_1.priority;
						else
							render_priorities[numberOfTriangleFaces] = model_1.render_priorities[i2];
					if (flag3)
						if (model_1.anIntArray1639 == null)
							anIntArray1639[numberOfTriangleFaces] = 0;
						else
							anIntArray1639[numberOfTriangleFaces] = model_1.anIntArray1639[i2];
					if (flag4 && model_1.anIntArray1640 != null)
						anIntArray1640[numberOfTriangleFaces] = model_1.anIntArray1640[i2];

					if (texture_flag) {
						if (model_1.texture != null) {
							texture[numberOfTriangleFaces] = model_1.texture[numberOfTriangleFaces];
						} else {
							texture[numberOfTriangleFaces] = -1;
						}
					}

					if (coordinate_flag) {
						if (model_1.texture_coordinates != null && model_1.texture_coordinates[numberOfTriangleFaces] != -1)
							texture_coordinates[numberOfTriangleFaces] = (byte)(model_1.texture_coordinates[numberOfTriangleFaces] + anInt1642);
						else
							texture_coordinates[numberOfTriangleFaces] = -1;

					}

					numberOfTriangleFaces++;
				}

				for (int k2 = 0; k2 < model_1.anInt1642; k2++) {
					anIntArray1643[anInt1642] = (short) (model_1.anIntArray1643[k2] + k1);
					anIntArray1644[anInt1642] = (short) (model_1.anIntArray1644[k2] + k1);
					anIntArray1645[anInt1642] = (short) (model_1.anIntArray1645[k2] + k1);
					anInt1642++;
				}

				i1 += model_1.anInt1642;
			}
		}

		method466();
	}

	public Model(boolean color_flag, boolean alpha_flag, boolean animated, Model model) {
		this(color_flag, alpha_flag, animated, false, model);
	}

	public Model(boolean color_flag, boolean alpha_flag, boolean animated, boolean texture_flag, Model model) {
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		numberOfVerticeCoordinates = model.numberOfVerticeCoordinates;
		numberOfTriangleFaces = model.numberOfTriangleFaces;
		anInt1642 = model.anInt1642;
		if (animated) {
			verticesParticle = model.verticesParticle;
			verticesXCoordinate = model.verticesXCoordinate;
			verticesYCoordinate = model.verticesYCoordinate;
			verticesZCoordinate = model.verticesZCoordinate;
		} else {
			verticesParticle = model.verticesParticle;
			verticesXCoordinate = new int[numberOfVerticeCoordinates];
			verticesYCoordinate = new int[numberOfVerticeCoordinates];
			verticesZCoordinate = new int[numberOfVerticeCoordinates];
			for (int point = 0; point < numberOfVerticeCoordinates; point++) {
				verticesParticle[point] = model.verticesParticle[point];
				verticesXCoordinate[point] = model.verticesXCoordinate[point];
				verticesYCoordinate[point] = model.verticesYCoordinate[point];
				verticesZCoordinate[point] = model.verticesZCoordinate[point];
			}

		}

		if (color_flag) {
			anIntArray1640 = model.anIntArray1640;
		} else {
			anIntArray1640 = new short[numberOfTriangleFaces];
			for (int face = 0; face < numberOfTriangleFaces; face++)
				anIntArray1640[face] = model.anIntArray1640[face];

		}

		if(!texture_flag && model.texture != null) {
			texture = new short[numberOfTriangleFaces];
			for(int face = 0; face < numberOfTriangleFaces; face++) {
				texture[face] = model.texture[face];
			}
		} else {
			texture = model.texture;
		}

		if (alpha_flag) {
			anIntArray1639 = model.anIntArray1639;
		} else {
			anIntArray1639 = new int[numberOfTriangleFaces];
			if (model.anIntArray1639 == null) {
				for (int l = 0; l < numberOfTriangleFaces; l++)
					anIntArray1639[l] = 0;

			} else {
				for (int i1 = 0; i1 < numberOfTriangleFaces; i1++)
					anIntArray1639[i1] = model.anIntArray1639[i1];

			}
		}
		anIntArray1655 = model.anIntArray1655;
		anIntArray1656 = model.anIntArray1656;
		face_render_type = model.face_render_type;
		face_a = model.face_a;
		face_b = model.face_b;
		face_c = model.face_c;
		render_priorities = model.render_priorities;
		texture_coordinates = model.texture_coordinates;
		texture_type = model.texture_type;
		priority = model.priority;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
	}

	public Model(boolean adjust_elevation, boolean gouraud_shading, Model model) {
		aBoolean1618 = true;
		aBoolean1659 = false;
		anInt1620++;
		numberOfVerticeCoordinates = model.numberOfVerticeCoordinates;
		numberOfTriangleFaces = model.numberOfTriangleFaces;
		anInt1642 = model.anInt1642;
		if (adjust_elevation) {
			verticesYCoordinate = new int[numberOfVerticeCoordinates];
			for (int point = 0; point < numberOfVerticeCoordinates; point++)
				verticesYCoordinate[point] = model.verticesYCoordinate[point];

		} else {
			verticesYCoordinate = model.verticesYCoordinate;
		}
		if (gouraud_shading) {
			anIntArray1634 = new int[numberOfTriangleFaces];
			anIntArray1635 = new int[numberOfTriangleFaces];
			anIntArray1636 = new int[numberOfTriangleFaces];
			for (int face = 0; face < numberOfTriangleFaces; face++) {
				anIntArray1634[face] = model.anIntArray1634[face];
				anIntArray1635[face] = model.anIntArray1635[face];
				anIntArray1636[face] = model.anIntArray1636[face];
			}

			face_render_type = new int[numberOfTriangleFaces];
			if (model.face_render_type == null) {
				for (int face = 0; face < numberOfTriangleFaces; face++)
					face_render_type[face] = 0;

			} else {
				for (int face = 0; face < numberOfTriangleFaces; face++)
					face_render_type[face] = model.face_render_type[face];

			}
			super.aClass33Array1425 = new VertexNormal[numberOfVerticeCoordinates];
			for (int point = 0; point < numberOfVerticeCoordinates; point++) {
				VertexNormal class33 = super.aClass33Array1425[point] = new VertexNormal();
				VertexNormal class33_1 = model.aClass33Array1425[point];
				class33.anInt602 = class33_1.anInt602;
				class33.anInt603 = class33_1.anInt603;
				class33.anInt604 = class33_1.anInt604;
				class33.anInt605 = class33_1.anInt605;
			}
			aClass33Array1660 = model.aClass33Array1660;

		} else {
			anIntArray1634 = model.anIntArray1634;
			anIntArray1635 = model.anIntArray1635;
			anIntArray1636 = model.anIntArray1636;
			face_render_type = model.face_render_type;
		}
		verticesParticle = model.verticesParticle;
		verticesXCoordinate = model.verticesXCoordinate;
		verticesZCoordinate = model.verticesZCoordinate;
		face_a = model.face_a;
		face_b = model.face_b;
		face_c = model.face_c;
		render_priorities = model.render_priorities;
		anIntArray1639 = model.anIntArray1639;
		texture_coordinates = model.texture_coordinates;
		anIntArray1640 = model.anIntArray1640;
		texture = model.texture;
		priority = model.priority;
		texture_type = model.texture_type;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
		super.modelHeight = model.modelHeight;
		anInt1650 = model.anInt1650;
		anInt1653 = model.anInt1653;
		anInt1652 = model.anInt1652;
		anInt1646 = model.anInt1646;
		anInt1648 = model.anInt1648;
		anInt1649 = model.anInt1649;
		anInt1647 = model.anInt1647;
	}

	public void method464(int i, Model model, boolean alpha_flag) {//TODO CHECK THIS
		numberOfVerticeCoordinates = model.numberOfVerticeCoordinates;
		numberOfTriangleFaces = model.numberOfTriangleFaces;
		anInt1642 = model.anInt1642;
		if (anIntArray1622.length < numberOfVerticeCoordinates) {
			anIntArray1622 = new int[numberOfVerticeCoordinates + 10000];
			anIntArray1623 = new int[numberOfVerticeCoordinates + 10000];
			anIntArray1624 = new int[numberOfVerticeCoordinates + 10000];
		}
		verticesParticle = new int[numberOfVerticeCoordinates];
		verticesXCoordinate = anIntArray1622;
		verticesYCoordinate = anIntArray1623;
		verticesZCoordinate = anIntArray1624;
		for (int point = 0; point < numberOfVerticeCoordinates; point++) {
			verticesParticle[point] = model.verticesParticle[point];
			verticesXCoordinate[point] = model.verticesXCoordinate[point];
			verticesYCoordinate[point] = model.verticesYCoordinate[point];
			verticesZCoordinate[point] = model.verticesZCoordinate[point];
		}
		if (alpha_flag) {
			anIntArray1639 = model.anIntArray1639;
		} else {
			if (anIntArray1625.length < numberOfTriangleFaces)
				anIntArray1625 = new int[numberOfTriangleFaces + 100];

			anIntArray1639 = anIntArray1625;
			if (model.anIntArray1639 == null) {
				for (int face = 0; face < numberOfTriangleFaces; face++)
					anIntArray1639[face] = 0;

			} else {
				for (int face = 0; face < numberOfTriangleFaces; face++)
					anIntArray1639[face] = model.anIntArray1639[face];

			}
		}
		face_render_type = model.face_render_type;
		anIntArray1640 = model.anIntArray1640;
		render_priorities = model.render_priorities;
		priority = model.priority;
		anIntArrayArray1658 = model.anIntArrayArray1658;
		anIntArrayArray1657 = model.anIntArrayArray1657;
		face_a = model.face_a;
		face_b = model.face_b;
		face_c = model.face_c;
		anIntArray1634 = model.anIntArray1634;
		anIntArray1635 = model.anIntArray1635;
		anIntArray1636 = model.anIntArray1636;
		anIntArray1643 = model.anIntArray1643;
		anIntArray1644 = model.anIntArray1644;
		anIntArray1645 = model.anIntArray1645;
		texture_coordinates = model.texture_coordinates;
		texture_type = model.texture_type;
		texture = model.texture;
	}

	private final int method465(Model model, int face) {
		int vertex = -1;
		int p = model.verticesParticle[face];
		int x = model.verticesXCoordinate[face];
		int y = model.verticesYCoordinate[face];
		int z = model.verticesZCoordinate[face];
		for (int index = 0; index < numberOfVerticeCoordinates; index++) {
			if (x != verticesXCoordinate[index] || y != verticesYCoordinate[index] || z != verticesZCoordinate[index])
				continue;
			vertex = index;
			break;
		}
		if (vertex == -1) {
			verticesParticle[numberOfVerticeCoordinates] = p;
			verticesXCoordinate[numberOfVerticeCoordinates] = x;
			verticesYCoordinate[numberOfVerticeCoordinates] = y;
			verticesZCoordinate[numberOfVerticeCoordinates] = z;
			if (model.anIntArray1655 != null)
				anIntArray1655[numberOfVerticeCoordinates] = model.anIntArray1655[face];

			vertex = numberOfVerticeCoordinates++;
		}
		return vertex;
	}

	public void method466() {
		super.modelHeight = 0;
		anInt1650 = 0;
		anInt1651 = 0;
		for (int i = 0; i < numberOfVerticeCoordinates; i++) {
			int j = verticesXCoordinate[i];
			int k = verticesYCoordinate[i];
			int l = verticesZCoordinate[i];
			if (-k > super.modelHeight)
				super.modelHeight = -k;
			if (k > anInt1651)
				anInt1651 = k;
			int i1 = j * j + l * l;
			if (i1 > anInt1650)
				anInt1650 = i1;
		}
		anInt1650 = (int) (Math.sqrt(anInt1650) + 0.98999999999999999D);
		anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight
				* super.modelHeight) + 0.98999999999999999D);
		anInt1652 = anInt1653
				+ (int) (Math.sqrt(anInt1650 * anInt1650 + anInt1651
						* anInt1651) + 0.98999999999999999D);
	}

	public void method467(boolean flag) {//TODO CHECK THIS
		super.modelHeight = 0;
		anInt1651 = 0;
		for (int i = 0; i < numberOfVerticeCoordinates; i++) {
			int j = verticesYCoordinate[i];
			if (-j > super.modelHeight)
				super.modelHeight = -j;
			if (j > anInt1651)
				anInt1651 = j;
		}

		anInt1653 = (int) (Math.sqrt(anInt1650 * anInt1650 + super.modelHeight
				* super.modelHeight) + 0.98999999999999999D);
		anInt1652 = anInt1653
				+ (int) (Math.sqrt(anInt1650 * anInt1650 + anInt1651
						* anInt1651) + 0.98999999999999999D);
	}

	public void method468(int i) {
		super.modelHeight = 0;
		anInt1650 = 0;
		anInt1651 = 0;
		anInt1646 = 0xf423f;
		anInt1647 = 0xfff0bdc1;
		anInt1648 = 0xfffe7961;
		anInt1649 = 0x1869f;
		for (int j = 0; j < numberOfVerticeCoordinates; j++) {
			int x = verticesXCoordinate[j];
			int y = verticesYCoordinate[j];
			int z = verticesZCoordinate[j];
			if (x < anInt1646)
				anInt1646 = x;
			if (x > anInt1647)
				anInt1647 = x;
			if (z < anInt1649)
				anInt1649 = z;
			if (z > anInt1648)
				anInt1648 = z;
			if (-y > super.modelHeight)
				super.modelHeight = -y;
			if (y > anInt1651)
				anInt1651 = y;
			int j1 = x * x + z * z;
			if (j1 > anInt1650)
				anInt1650 = j1;
		}
		anInt1650 = (int) Math.sqrt(anInt1650);
		anInt1653 = (int) Math.sqrt(anInt1650 * anInt1650 + super.modelHeight * super.modelHeight);
		if (i != 21073) {
			return;
		} else {
			anInt1652 = anInt1653 + (int) Math.sqrt(anInt1650 * anInt1650 + anInt1651 * anInt1651);
			return;
		}
	}

	public void method469(byte byte0) {
		if (anIntArray1655 != null) {
            int[] ai = new int[256];
			int j = 0;
			for (int l = 0; l < numberOfVerticeCoordinates; l++) {
				int j1 = anIntArray1655[l];
				ai[j1]++;
				if (j1 > j)
					j = j1;
			}
			anIntArrayArray1657 = new int[j + 1][];
			for (int k1 = 0; k1 <= j; k1++) {
				anIntArrayArray1657[k1] = new int[ai[k1]];
				ai[k1] = 0;
			}
			for (int j2 = 0; j2 < numberOfVerticeCoordinates; j2++) {
				int l2 = anIntArray1655[j2];
				anIntArrayArray1657[l2][ai[l2]++] = j2;
			}
			anIntArray1655 = null;
		}
		if (anIntArray1656 != null) {
            int[] ai1 = new int[256];
			int k = 0;
			for (int i1 = 0; i1 < numberOfTriangleFaces; i1++) {
				int l1 = anIntArray1656[i1];
				ai1[l1]++;
				if (l1 > k)
					k = l1;
			}
			anIntArrayArray1658 = new int[k + 1][];
			for (int i2 = 0; i2 <= k; i2++) {
				anIntArrayArray1658[i2] = new int[ai1[i2]];
				ai1[i2] = 0;
			}
			for (int k2 = 0; k2 < numberOfTriangleFaces; k2++) {
				int i3 = anIntArray1656[k2];
				anIntArrayArray1658[i3][ai1[i3]++] = k2;
			}
			anIntArray1656 = null;
		}
	}

	public void method470(int i) {
		if(this.anIntArrayArray1657 != null && i != -1) {
			Frame frame = Frame.method531(i);
			if(frame != null) {
				FrameBase FrameBase = frame.aClass18_637;
				anInt1681 = 0;
				anInt1682 = 0;
				anInt1683 = 0;

				for(int k = 0; k < frame.stepCounter; ++k) {
					int l = frame.opcodeLinkTable[k];
					this.method472(FrameBase.transformationType[l], FrameBase.skinlist[l], frame.modifier1[k], frame.modifier2[k], frame.modifier3[k]);
				}
			}
		}

	}

	public void method471(int i, int[] ai, int j, int k) {
		if(k != -1) {
			if(ai != null && j != -1) {
				Frame frame = Frame.method531(k);
				if(frame != null) {
					Frame class36_1 = Frame.method531(k);
					if(class36_1 == null) {
						this.method470(k);
					} else {
						FrameBase FrameBase = frame.aClass18_637;
						anInt1681 = 0;
						anInt1682 = 0;
						anInt1683 = 0;
						byte l = 0;
						int var12 = l + 1;
						int i1 = ai[l];

						int l1;
						int i2;
						for(l1 = 0; l1 < frame.stepCounter; ++l1) {
							for(i2 = frame.opcodeLinkTable[l1]; i2 > i1; i1 = ai[var12++]) {
                            }

							if(i2 != i1 || FrameBase.transformationType[i2] == 0) {
								this.method472(FrameBase.transformationType[i2], FrameBase.skinlist[i2], frame.modifier1[l1], frame.modifier2[l1], frame.modifier3[l1]);
							}
						}

						anInt1681 = 0;
						anInt1682 = 0;
						anInt1683 = 0;
						l = 0;
						var12 = l + 1;
						i1 = ai[l];

						for(l1 = 0; l1 < class36_1.stepCounter; ++l1) {
							for(i2 = class36_1.opcodeLinkTable[l1]; i2 > i1; i1 = ai[var12++]) {
                            }

							if(i2 == i1 || FrameBase.transformationType[i2] == 0) {
								this.method472(FrameBase.transformationType[i2], FrameBase.skinlist[i2], class36_1.modifier1[l1], class36_1.modifier2[l1], class36_1.modifier3[l1]);
							}
						}
					}
				}
			} else {
				this.method470(k);
			}
		}

	}

	private void method472(int i, int[] ai, int j, int k, int l) {

		int i1 = ai.length;
		if (i == 0) {
			int j1 = 0;
			anInt1681 = 0;
			anInt1682 = 0;
			anInt1683 = 0;
			for (int k2 = 0; k2 < i1; k2++) {
				int l3 = ai[k2];
				if (l3 < anIntArrayArray1657.length) {
                    int[] ai5 = anIntArrayArray1657[l3];
					for (int i5 = 0; i5 < ai5.length; i5++) {
						int j6 = ai5[i5];
						anInt1681 += verticesXCoordinate[j6];
						anInt1682 += verticesYCoordinate[j6];
						anInt1683 += verticesZCoordinate[j6];
						j1++;
					}

				}
			}

			if (j1 > 0) {
				anInt1681 = anInt1681 / j1 + j;
				anInt1682 = anInt1682 / j1 + k;
				anInt1683 = anInt1683 / j1 + l;
				return;
			} else {
				anInt1681 = j;
				anInt1682 = k;
				anInt1683 = l;
				return;
			}
		}
		if (i == 1) {
			for (int k1 = 0; k1 < i1; k1++) {
				int l2 = ai[k1];
				if (l2 < anIntArrayArray1657.length) {
                    int[] ai1 = anIntArrayArray1657[l2];
					for (int i4 = 0; i4 < ai1.length; i4++) {
						int j5 = ai1[i4];
						verticesXCoordinate[j5] += j;
						verticesYCoordinate[j5] += k;
						verticesZCoordinate[j5] += l;
					}

				}
			}

			return;
		}
		if (i == 2) {
			for (int l1 = 0; l1 < i1; l1++) {
				int i3 = ai[l1];
				if (i3 < anIntArrayArray1657.length) {
                    int[] ai2 = anIntArrayArray1657[i3];
					for (int j4 = 0; j4 < ai2.length; j4++) {
						int k5 = ai2[j4];
						verticesXCoordinate[k5] -= anInt1681;
						verticesYCoordinate[k5] -= anInt1682;
						verticesZCoordinate[k5] -= anInt1683;
						int k6 = (j & 0xff) * 8;
						int l6 = (k & 0xff) * 8;
						int i7 = (l & 0xff) * 8;
						if (i7 != 0) {
							int j7 = SINE[i7];
							int i8 = COSINE[i7];
							int l8 = verticesYCoordinate[k5] * j7 + verticesXCoordinate[k5] * i8 >> 16;
					verticesYCoordinate[k5] = verticesYCoordinate[k5] * i8
							- verticesXCoordinate[k5] * j7 >> 16;
			verticesXCoordinate[k5] = l8;
						}
						if (k6 != 0) {
							int k7 = SINE[k6];
							int j8 = COSINE[k6];
							int i9 = verticesYCoordinate[k5] * j8 - verticesZCoordinate[k5] * k7 >> 16;
				verticesZCoordinate[k5] = verticesYCoordinate[k5] * k7 + verticesZCoordinate[k5] * j8 >> 16;
				verticesYCoordinate[k5] = i9;
						}
						if (l6 != 0) {
							int l7 = SINE[l6];
							int k8 = COSINE[l6];
							int j9 = verticesZCoordinate[k5] * l7 + verticesXCoordinate[k5] * k8 >> 16;
							verticesZCoordinate[k5] = verticesZCoordinate[k5] * k8 - verticesXCoordinate[k5] * l7 >> 16;
							verticesXCoordinate[k5] = j9;
						}
						verticesXCoordinate[k5] += anInt1681;
						verticesYCoordinate[k5] += anInt1682;
						verticesZCoordinate[k5] += anInt1683;
					}

				}
			}
			return;
		}
		if (i == 3) {
			for (int i2 = 0; i2 < i1; i2++) {
				int j3 = ai[i2];
				if (j3 < anIntArrayArray1657.length) {
                    int[] ai3 = anIntArrayArray1657[j3];
					for (int k4 = 0; k4 < ai3.length; k4++) {
						int l5 = ai3[k4];
						verticesXCoordinate[l5] -= anInt1681;
						verticesYCoordinate[l5] -= anInt1682;
						verticesZCoordinate[l5] -= anInt1683;
						verticesXCoordinate[l5] = (verticesXCoordinate[l5] * j) / 128;
						verticesYCoordinate[l5] = (verticesYCoordinate[l5] * k) / 128;
						verticesZCoordinate[l5] = (verticesZCoordinate[l5] * l) / 128;
						verticesXCoordinate[l5] += anInt1681;
						verticesYCoordinate[l5] += anInt1682;
						verticesZCoordinate[l5] += anInt1683;
					}
				}
			}
			return;
		}
		if (i == 5 && anIntArrayArray1658 != null && anIntArray1639 != null) {
			for (int j2 = 0; j2 < i1; j2++) {
				int k3 = ai[j2];
				if (k3 < anIntArrayArray1658.length) {
                    int[] ai4 = anIntArrayArray1658[k3];
					for (int l4 = 0; l4 < ai4.length; l4++) {
						int i6 = ai4[l4];
						anIntArray1639[i6] += j * 8;
						if (anIntArray1639[i6] < 0)
							anIntArray1639[i6] = 0;
						if (anIntArray1639[i6] > 255)
							anIntArray1639[i6] = 255;
					}
				}
			}
		}
	}

	public void method473(int i) {
		for (int point = 0; point < numberOfVerticeCoordinates; point++) {
			int k = verticesXCoordinate[point];
			verticesXCoordinate[point] = verticesZCoordinate[point];
			verticesZCoordinate[point] = -k;
		}
	}

	public void method474(int i) {
		int k = SINE[i];
		int l = COSINE[i];
		for (int point = 0; point < numberOfVerticeCoordinates; point++) {
			int j1 = verticesYCoordinate[point] * l - verticesZCoordinate[point] * k >> 16;
		verticesZCoordinate[point] = verticesYCoordinate[point] * k + verticesZCoordinate[point] * l >> 16;
					verticesYCoordinate[point] = j1;
		}
	}
	
	public void method474(int i, int j) {
	      int k = SINE[i];
	      int l = COSINE[i];

	      for(int i1 = 0; i1 < this.numberOfVerticeCoordinates; ++i1) {
	         int j1 = this.verticesYCoordinate[i1] * l - this.verticesZCoordinate[i1] * k >> 16;
	         this.verticesZCoordinate[i1] = this.verticesYCoordinate[i1] * k + this.verticesZCoordinate[i1] * l >> 16;
	         this.verticesYCoordinate[i1] = j1;
	      }

	   }

	public void method475(int x, int y, int z) {
		for (int point = 0; point < numberOfVerticeCoordinates; point++) {
			verticesXCoordinate[point] += x;
			verticesYCoordinate[point] += y;
			verticesZCoordinate[point] += z;
		}
	}
	
	public void method475(int i, int j, int k, int l) {
		for(int i1 = 0; i1 < this.numberOfVerticeCoordinates; ++i1) {
			this.verticesXCoordinate[i1] += i;
			this.verticesYCoordinate[i1] += j;
			this.verticesZCoordinate[i1] += l;
		}

	}

	public void recolor(int found, int replace) {
		if(anIntArray1640 != null)
			for (int face = 0; face < numberOfTriangleFaces; face++)
				if (anIntArray1640[face] == (short) found)
					anIntArray1640[face] = (short) replace;
	}

	public void retexture(short found, short replace) {
		if(texture != null)
			for (int face = 0; face < numberOfTriangleFaces; face++)
				if (texture[face] == found)
					texture[face] = replace;
	}

	public void method477(int i) {//TODO CHECK THIS
		for (int index = 0; index < numberOfVerticeCoordinates; index++)
			verticesZCoordinate[index] = -verticesZCoordinate[index];

		for (int face = 0; face < numberOfTriangleFaces; face++) {
			int l = face_a[face];
			face_a[face] = face_c[face];
			face_c[face] = l;
		}
	}

	public void method478(int i, int j, int l) {
		for (int index = 0; index < numberOfVerticeCoordinates; index++) {
			verticesXCoordinate[index] = (verticesXCoordinate[index] * i) / 128;
			verticesYCoordinate[index] = (verticesYCoordinate[index] * l) / 128;
			verticesZCoordinate[index] = (verticesZCoordinate[index] * j) / 128;
		}
	}
	
	public void method478(int i, int j, int k, int l) {//TODO CHECK THIS
		for(int i1 = 0; i1 < this.numberOfVerticeCoordinates; ++i1) {
			this.verticesXCoordinate[i1] = this.verticesXCoordinate[i1] * i / 128;
			this.verticesYCoordinate[i1] = this.verticesYCoordinate[i1] * l / 128;
			this.verticesZCoordinate[i1] = this.verticesZCoordinate[i1] * j / 128;
		}

	}

	public void method479(int i, int j, int k, int l, int i1, boolean flag) {
		method479(i, j, k, l, i1, flag, false);
	}

	public void method479(int i, int j, int k, int l, int i1, boolean flag, boolean player) {
		int j1 = (int) Math.sqrt(k * k + l * l + i1 * i1);
		int k1 = j * j1 >> 8;
		anIntArray1634 = new int[numberOfTriangleFaces];
		anIntArray1635 = new int[numberOfTriangleFaces];
		anIntArray1636 = new int[numberOfTriangleFaces];
		if (super.aClass33Array1425 == null) {
			super.aClass33Array1425 = new VertexNormal[numberOfVerticeCoordinates];
			for (int index = 0; index < numberOfVerticeCoordinates; index++)
				super.aClass33Array1425[index] = new VertexNormal();

		}
		for (int face = 0; face < numberOfTriangleFaces; face++) {
			int j2 = face_a[face];
			int l2 = face_b[face];
			int i3 = face_c[face];
			int j3 = verticesXCoordinate[l2] - verticesXCoordinate[j2];
			int k3 = verticesYCoordinate[l2] - verticesYCoordinate[j2];
			int l3 = verticesZCoordinate[l2] - verticesZCoordinate[j2];
			int i4 = verticesXCoordinate[i3] - verticesXCoordinate[j2];
			int j4 = verticesYCoordinate[i3] - verticesYCoordinate[j2];
			int k4 = verticesZCoordinate[i3] - verticesZCoordinate[j2];
			int l4 = k3 * k4 - j4 * l3;
			int i5 = l3 * i4 - k4 * j3;
			int j5;
			for (j5 = j3 * j4 - i4 * k3; l4 > 8192 || i5 > 8192 || j5 > 8192 || l4 < -8192 || i5 < -8192 || j5 < -8192; j5 >>= 1) {
				l4 >>= 1;
			i5 >>= 1;
			}
			int k5 = (int) Math.sqrt(l4 * l4 + i5 * i5 + j5 * j5);
			if (k5 <= 0)
				k5 = 1;

			l4 = (l4 * 256) / k5;
			i5 = (i5 * 256) / k5;
			j5 = (j5 * 256) / k5;

			short texture_id;
			int type;
			if(face_render_type != null)
				type = face_render_type[face];
			else
				type = 0;

			if(texture == null) {
				texture_id = -1;
			} else {
				texture_id = texture[face];
			}

			if (face_render_type == null || (face_render_type[face] & 1) == 0) {
				VertexNormal class33_2 = super.aClass33Array1425[j2];
                class33_2.anInt602 += l4;
                class33_2.anInt603 += i5;
                class33_2.anInt604 += j5;
                class33_2.anInt605++;
                class33_2 = super.aClass33Array1425[l2];
                class33_2.anInt602 += l4;
                class33_2.anInt603 += i5;
                class33_2.anInt604 += j5;
                class33_2.anInt605++;
                class33_2 = super.aClass33Array1425[i3];
                class33_2.anInt602 += l4;
                class33_2.anInt603 += i5;
                class33_2.anInt604 += j5;
                class33_2.anInt605++;
			} else {
				if(texture_id != -1) {
					type = 2;
				}
				int light = i + (k * l4 + l * i5 + i1 * j5) / (k1 + k1 / 2);
				anIntArray1634[face] = method481(anIntArray1640[face], light, type);
			}
		}
		if (flag) {
			method480(i, k1, k, l, i1, player);
			method466();
		} else {
			aClass33Array1660 = new VertexNormal[numberOfVerticeCoordinates];
			for (int point = 0; point < numberOfVerticeCoordinates; point++) {
				VertexNormal class33 = super.aClass33Array1425[point];
				VertexNormal class33_1 = aClass33Array1660[point] = new VertexNormal();
				class33_1.anInt602 = class33.anInt602;
                class33_1.anInt603 = class33.anInt603;
                class33_1.anInt604 = class33.anInt604;
                class33_1.anInt605 = class33.anInt605;
			}
			method468(21073);
		}
	}

	public final void method480(int i, int j, int k, int l, int i1) {
		method480(i, j, k, l, i1, false);
	}

	public final void method480(int i, int j, int k, int l, int i1, boolean player) {
		for (int j1 = 0; j1 < numberOfTriangleFaces; j1++) {
			int k1 = face_a[j1];
			int i2 = face_b[j1];
			int j2 = face_c[j1];
			short texture_id;
			if(texture == null) {
				texture_id = -1;
			} else {
				texture_id = texture[j1];
				if (player) {
					if(anIntArray1639 != null && anIntArray1640 != null) {
						if(anIntArray1640[j1] == 0 && render_priorities[j1] == 0) {
							if(face_render_type[j1] == 2 && texture[j1] == -1) {
								anIntArray1639[j1] = 255;
							}
						}
					} else if(anIntArray1639 == null) {
						if(anIntArray1640[j1] == 0 && render_priorities[j1] == 0) {
							if(texture[j1] == -1) {
								anIntArray1639 = new int[numberOfTriangleFaces];
								if(face_render_type[j1] == 2) {
									anIntArray1639[j1] = 255;
								}
							}
						}
					}
				}
			}

			if (face_render_type == null) {
				int type;
				if(texture_id != -1) {
					type = 2;
				} else {
					type = 1;
				}
				int hsl = anIntArray1640[j1] & 0xffff;
				VertexNormal vertex = super.aClass33Array1425[k1];
				int light = i + (k * vertex.anInt602 + l * vertex.anInt603 + i1 * vertex.anInt604) / (j * vertex.anInt605);
				anIntArray1634[j1] = method481(hsl, light, type);
				vertex = super.aClass33Array1425[i2];
				light = i + (k * vertex.anInt602 + l * vertex.anInt603 + i1 * vertex.anInt604) / (j * vertex.anInt605);
				anIntArray1635[j1] = method481(hsl, light, type);
				vertex = super.aClass33Array1425[j2];
				light = i + (k * vertex.anInt602 + l * vertex.anInt603 + i1 * vertex.anInt604) / (j * vertex.anInt605);
				anIntArray1636[j1] = method481(hsl, light, type);
			} else if ((face_render_type[j1] & 1) == 0) {
				int type = face_render_type[j1];
				if(texture_id != -1) {
					type = 2;
				}
				int hsl = anIntArray1640[j1] & 0xffff;
				VertexNormal vertex = super.aClass33Array1425[k1];
				int light = i + (k * vertex.anInt602 + l * vertex.anInt603 + i1 * vertex.anInt604) / (j * vertex.anInt605);
				anIntArray1634[j1] = method481(hsl, light, type);
				vertex = super.aClass33Array1425[i2];
				light = i + (k * vertex.anInt602 + l * vertex.anInt603 + i1 * vertex.anInt604) / (j * vertex.anInt605);
				anIntArray1635[j1] = method481(hsl, light, type);
				vertex = super.aClass33Array1425[j2];
				light = i + (k * vertex.anInt602 + l * vertex.anInt603 + i1 * vertex.anInt604) / (j * vertex.anInt605);
				anIntArray1636[j1] = method481(hsl, light, type);
			}
		}

		super.aClass33Array1425 = null;
		aClass33Array1660 = null;
		anIntArray1655 = null;
		anIntArray1656 = null;
		anIntArray1640 = null;
	}

	public static final int method481(int i, int j, int k) {
		if (i == 65535)
			return 0;

		if ((k & 2) == 2) {
			if (j < 0)
				j = 0;
			else if (j > 127)
				j = 127;

			j = 127 - j;
			return j;
		}

		j = j * (i & 0x7f) >> 7;
		if (j < 2)
			j = 2;
		else if (j > 126)
			j = 126;

		return (i & 0xff80) + j;
	}

	public final void method482(int j, int k, int l, int i1, int j1, int k1) {
		int i = 0;
		int l1 = Rasterizer.centerX;
		int i2 = Rasterizer.centerY;
		int j2 = SINE[i];
		int k2 = COSINE[i];
		int l2 = SINE[j];
		int i3 = COSINE[j];
		int j3 = SINE[k];
		int k3 = COSINE[k];
		int l3 = SINE[l];
		int i4 = COSINE[l];
		int j4 = j1 * l3 + k1 * i4 >> 16;

		for(int k4 = 0; k4 < this.numberOfVerticeCoordinates; ++k4) {
			int l4 = this.verticesXCoordinate[k4];
			int i5 = this.verticesYCoordinate[k4];
			int j5 = this.verticesZCoordinate[k4];
			int j6;
			if (k != 0) {
				j6 = i5 * j3 + l4 * k3 >> 16;
				i5 = i5 * k3 - l4 * j3 >> 16;
				l4 = j6;
			}

			if (i != 0) {
				j6 = i5 * k2 - j5 * j2 >> 16;
				j5 = i5 * j2 + j5 * k2 >> 16;
				i5 = j6;
			}

			if (j != 0) {
				j6 = j5 * l2 + l4 * i3 >> 16;
				j5 = j5 * i3 - l4 * l2 >> 16;
				l4 = j6;
			}

			l4 += i1;
			i5 += j1;
			j5 += k1;
			j6 = i5 * i4 - j5 * l3 >> 16;
			j5 = i5 * l3 + j5 * i4 >> 16;
			anIntArray1667[k4] = j5 - j4;
			anIntArray1665[k4] = l1 + (l4 << 9) / j5;
			anIntArray1666[k4] = i2 + (j6 << 9) / j5;
			if (this.anInt1642 > 0) {
				anIntArray1668[k4] = l4;
				anIntArray1669[k4] = j6;
				anIntArray1670[k4] = j5;
			}
		}

		try {
			this.method483(false, false, 0, 0);
		} catch (Exception var25) {
		}
	}

	public final void method443(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int var) {
		int j2 = l1 * i1 - j1 * l >> 16;
				int k2 = k1 * j + j2 * k >> 16;
				int l2 = anInt1650 * k >> 16;
			int i3 = k2 + l2;
			if (i3 <= 50 || k2 >= MODEL_DRAW_DISTANCE)
				return;

			int j3 = l1 * l + j1 * i1 >> 16;
				int k3 = j3 - anInt1650<< WorldController.viewDistance;
				if (k3 / i3 >= DrawingArea.centerY)//TODO COULD BE X
					return;

				int l3 = j3 + anInt1650<< WorldController.viewDistance;
				if (l3 / i3 <= -DrawingArea.centerY)//TODO COULD BE X
					return;

				int i4 = k1 * k - j2 * j >> 16;
				int j4 = anInt1650 * j >> 16;
				int k4 = i4 + j4<< WorldController.viewDistance;
				if (k4 / i3 <= -DrawingArea.anInt1387)//TODO COULD BE Y
					return;

				int l4 = j4 + (super.modelHeight * k >> 16);
				int i5 = i4 - l4<< WorldController.viewDistance;
				if (i5 / i3 >= DrawingArea.anInt1387)//TODO COULD BE Y
					return;

				int j5 = l2 + (super.modelHeight * j >> 16);
				boolean flag = false;
				if (k2 - j5 <= 50)
					flag = true;

				boolean flag1 = false;
				if (i2 > 0 && aBoolean1684) {
					int k5 = k2 - l2;
					if (k5 <= 50)
						k5 = 50;
					if (j3 > 0) {
						k3 /= i3;
						l3 /= k5;
					} else {
						l3 /= i3;
						k3 /= k5;
					}
					if (i4 > 0) {
						i5 /= i3;
						k4 /= k5;
					} else {
						k4 /= i3;
						i5 /= k5;
					}
					int i6 = anInt1685 - Rasterizer.centerX;
					int k6 = anInt1686 - Rasterizer.centerY;
					if (i6 > k3 && i6 < l3 && k6 > i5 && k6 < k4)
						if (aBoolean1659){
							mapObjIds[anInt1687] = var;
							anIntArray1688[anInt1687++] = i2;
						} else{
							flag1 = true;
						}
				}
				int l5 = Rasterizer.centerX;
				int j6 = Rasterizer.centerY;
				int l6 = 0;
				int i7 = 0;
				if (i != 0) {
					l6 = SINE[i];
					i7 = COSINE[i];
				}
				for (int j7 = 0; j7 < numberOfVerticeCoordinates; j7++) {
					int k7 = verticesXCoordinate[j7];
					int l7 = verticesYCoordinate[j7];
					int i8 = verticesZCoordinate[j7];
					if (i != 0) {
						int j8 = i8 * l6 + k7 * i7 >> 16;
				i8 = i8 * i7 - k7 * l6 >> 16;
				k7 = j8;
					}
					k7 += j1;
					l7 += k1;
					i8 += l1;
					int position = i8 * l + k7 * i1 >> 16;
		i8 = i8 * i1 - k7 * l >> 16;
					k7 = position;

					position = l7 * k - i8 * j >> 16;
		i8 = l7 * j + i8 * k >> 16;
						l7 = position;

						anIntArray1667[j7] = i8 - k2;
						if (i8 >= 50) {
							anIntArray1665[j7] = l5 + (k7<< WorldController.viewDistance) / i8;
							anIntArray1666[j7] = j6 + (l7<< WorldController.viewDistance) / i8;
							//vertexPerspectiveDepth[j7] = i8;
						} else {
							anIntArray1665[j7] = -5000;
							//vertexPerspectiveDepth[j7] = 0;
							flag = true;
						}
						if (flag || anInt1642 > 0) {
							if(Constants.distanceFog) {
								anIntArray1670[j7] = i8;
	                        }
							anIntArray1668[j7] = k7;
							anIntArray1669[j7] = l7;
							anIntArray1670[j7] = i8;
						}
				}
				try {
					method483(flag, flag1, i2, var);
					return;
				} catch (Exception _ex) {
					return;
				}
	}
	
	public int offX = 0, offY = 0, offZ = 0, lrr = 0;
	private final void method483(boolean flag, boolean flag1, int i, int id) {
		for (int j = 0; j < anInt1652; j++)
			anIntArray1671[j] = 0;

		for (int face = 0; face < numberOfTriangleFaces; face++) {
			if (face_render_type == null || face_render_type[face] != -1) {
				int a = face_a[face];
				int b = face_b[face];
				int c = face_c[face];
				int x_a = anIntArray1665[a];
				int x_b = anIntArray1665[b];
				int x_c = anIntArray1665[c];
				if (flag && (x_a == -5000 || x_b == -5000 || x_c == -5000)) {
					aBooleanArray1664[face] = true;
					int j5 = (anIntArray1667[a] + anIntArray1667[b] + anIntArray1667[c]) / 3 + anInt1653;
					anIntArrayArray1672[j5][anIntArray1671[j5]++] = face;
				} else {
					if (flag1 && method486(anInt1685, anInt1686, anIntArray1666[a], anIntArray1666[b], anIntArray1666[c], x_a, x_b, x_c)) {
						mapObjIds[anInt1687] = id;
						anIntArray1688[anInt1687++] = i;
						flag1 = false;
					}
					if ((x_a - x_b) * (anIntArray1666[c] - anIntArray1666[b]) - (anIntArray1666[a] - anIntArray1666[b]) * (x_c - x_b) > 0) {
						aBooleanArray1664[face] = false;
                        //TODO COULD BE SOMETHING ELSE
                        aBooleanArray1663[face] = x_a < 0 || x_b < 0 || x_c < 0 || x_a > DrawingArea.centerX || x_b > DrawingArea.centerX || x_c > DrawingArea.centerX;

						int k5 = (anIntArray1667[a] + anIntArray1667[b] + anIntArray1667[c]) / 3 + anInt1653;
						anIntArrayArray1672[k5][anIntArray1671[k5]++] = face;
					}
				}
			}
		}
		if (render_priorities == null) {
			for (int i1 = anInt1652 - 1; i1 >= 0; i1--) {
				int l1 = anIntArray1671[i1];
				if (l1 > 0) {
                    int[] ai = anIntArrayArray1672[i1];
					for (int j3 = 0; j3 < l1; j3++)
						method484(ai[j3]);

				}
			}
			return;
		}
		for (int j1 = 0; j1 < 12; j1++) {
			anIntArray1673[j1] = 0;
			anIntArray1677[j1] = 0;
		}
		for (int i2 = anInt1652 - 1; i2 >= 0; i2--) {
			int k2 = anIntArray1671[i2];
			if (k2 > 0) {
                int[] ai1 = anIntArrayArray1672[i2];
				for (int i4 = 0; i4 < k2; i4++) {
					int l4 = ai1[i4];
					byte l5 = render_priorities[l4];
					int j6 = anIntArray1673[l5]++;
					anIntArrayArray1674[l5][j6] = l4;
					if (l5 < 10)
						anIntArray1677[l5] += i2;
					else if (l5 == 10)
						anIntArray1675[j6] = i2;
					else
						anIntArray1676[j6] = i2;
				}

			}
		}

		int l2 = 0;
		if (anIntArray1673[1] > 0 || anIntArray1673[2] > 0)
			l2 = (anIntArray1677[1] + anIntArray1677[2]) / (anIntArray1673[1] + anIntArray1673[2]);
		int k3 = 0;
		if (anIntArray1673[3] > 0 || anIntArray1673[4] > 0)
			k3 = (anIntArray1677[3] + anIntArray1677[4]) / (anIntArray1673[3] + anIntArray1673[4]);
		int j4 = 0;
		if (anIntArray1673[6] > 0 || anIntArray1673[8] > 0)
			j4 = (anIntArray1677[6] + anIntArray1677[8]) / (anIntArray1673[6] + anIntArray1673[8]);

		int i6 = 0;
		int k6 = anIntArray1673[10];
        int[] ai2 = anIntArrayArray1674[10];
        int[] ai3 = anIntArray1675;
		if (i6 == k6) {
			i6 = 0;
			k6 = anIntArray1673[11];
			ai2 = anIntArrayArray1674[11];
			ai3 = anIntArray1676;
		}
		int i5;
		if (i6 < k6)
			i5 = ai3[i6];
		else
			i5 = -1000;

		for (int l6 = 0; l6 < 10; l6++) {
			while (l6 == 0 && i5 > l2) {
				method484(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6)
					i5 = ai3[i6];
				else
					i5 = -1000;
			}
			while (l6 == 3 && i5 > k3) {
				method484(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6)
					i5 = ai3[i6];
				else
					i5 = -1000;
			}
			while (l6 == 5 && i5 > j4) {
				method484(ai2[i6++]);
				if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
					i6 = 0;
					k6 = anIntArray1673[11];
					ai2 = anIntArrayArray1674[11];
					ai3 = anIntArray1676;
				}
				if (i6 < k6)
					i5 = ai3[i6];
				else
					i5 = -1000;
			}
			int i7 = anIntArray1673[l6];
            int[] ai4 = anIntArrayArray1674[l6];
			for (int j7 = 0; j7 < i7; j7++)
				method484(ai4[j7]);

		}
		while (i5 != -1000) {
			method484(ai2[i6++]);
			if (i6 == k6 && ai2 != anIntArrayArray1674[11]) {
				i6 = 0;
				ai2 = anIntArrayArray1674[11];
				k6 = anIntArray1673[11];
				ai3 = anIntArray1676;
			}
			if (i6 < k6)
				i5 = ai3[i6];
			else
				i5 = -1000;
		}
		for (int vertex = 0; vertex < numberOfVerticeCoordinates; vertex++) {
			int pid = verticesParticle[vertex] - 1;

			if (pid >= 0) {
				ParticleDefinition def = ParticleDefinition.cache[pid];

				int particleX = verticesXCoordinate[vertex];
				int particleY = verticesYCoordinate[vertex];
				int particleZ = verticesZCoordinate[vertex];
				int particleDepth; //= vertexPerspectiveDepth[vertex];
				if (lrr != 0) {
					int sine = Model.SINE[lrr];
					int cosine = Model.COSINE[lrr];
					int rotatedX = particleZ * sine + particleX * cosine >> 16;
					particleZ = particleZ * cosine - particleX * sine >> 16;
					particleX = rotatedX;
				}

				particleX += offX;
				particleZ += offZ;

				Vector basePos = new Vector(particleX, -particleY, particleZ);
				for (int p = 0; p < def.getSpawnRate(); p++) {
					Particle particle = new Particle(def, basePos, 255, pid);
					Main.instance.addParticle(particle);
				}
			}
		}
	}

	private final void method484(int i) {
		if (aBooleanArray1664[i]) {
			method485(i);
			return;
		}
		int j = face_a[i];
		int k = face_b[i];
		int l = face_c[i];
		Rasterizer.aBoolean1462 = aBooleanArray1663[i];
		if (anIntArray1639 == null)
			Rasterizer.anInt1465 = 0;
		else
			Rasterizer.anInt1465 = anIntArray1639[i] & 0xff;

		int type;
		if (face_render_type == null)
			type = 0;
		else
			type = face_render_type[i] & 3;

		if(texture != null && texture[i] != -1) {
			int texture_a = j;
			int texture_b = k;
			int texture_c = l;
			if(texture_coordinates != null && texture_coordinates[i] != -1) {
				int coordinate = texture_coordinates[i] & 0xff;
				texture_a = anIntArray1643[coordinate];
				texture_b = anIntArray1644[coordinate];
				texture_c = anIntArray1645[coordinate];
			}
			if(anIntArray1636[i] == -1 || type == 3) {
				Rasterizer.method378(
						anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], 
						anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], 
						anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], 
						anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c],
						anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], 
						anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c],
						texture[i]);
				if(Constants.distanceFog) {
		               Rasterizer.drawTexturedFogTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], 
								anIntArray1665[j], anIntArray1665[k],anIntArray1665[l], 
								anIntArray1634[i], anIntArray1635[i], anIntArray1636[i], 
								anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c],
								anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], 
								anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c],
								texture[i]);
		            }
			} else {
				Rasterizer.method378(
						anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], 
						anIntArray1665[j], anIntArray1665[k],anIntArray1665[l], 
						anIntArray1634[i], anIntArray1635[i], anIntArray1636[i], 
						anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c],
						anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], 
						anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c],
						texture[i]);
				if(Constants.distanceFog) {
		               Rasterizer.drawTexturedFogTriangle(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], 
								anIntArray1665[j], anIntArray1665[k],anIntArray1665[l], 
								anIntArray1634[i], anIntArray1635[i], anIntArray1636[i], 
								anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c],
								anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], 
								anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c],
								texture[i]);
		            }
			} 
		} else {
			if (type == 0) {
				Rasterizer.drawGouraudTriangle(anIntArray1666[j], anIntArray1666[k],
						anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
						anIntArray1665[l], anIntArray1634[i], anIntArray1635[i],
						anIntArray1636[i]);//TODO CHECK THIS
				if(Constants.distanceFog) {
		               Rasterizer.drawFogTriangle(anIntArray1666[j], anIntArray1666[k],
								anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
								anIntArray1665[l], anIntArray1634[i], anIntArray1635[i],
								anIntArray1636[i]);
		            }
				return;
			}
			if (type == 1) {
				Rasterizer.method376(anIntArray1666[j], anIntArray1666[k], anIntArray1666[l], anIntArray1665[j], anIntArray1665[k], anIntArray1665[l], modelIntArray3[anIntArray1634[i]]);
				if(Constants.distanceFog) {
		               Rasterizer.drawFogTriangle(anIntArray1666[j], anIntArray1666[k],
								anIntArray1666[l], anIntArray1665[j], anIntArray1665[k],
								anIntArray1665[l], anIntArray1634[i], anIntArray1635[i],
								anIntArray1636[i]);
		            }
				return;
			}
		}
	}

	private final void method485(int i) {
		int j = Rasterizer.centerX;
		int k = Rasterizer.centerY;
		int l = 0;
		int i1 = face_a[i];
		int j1 = face_b[i];
		int k1 = face_c[i];
		int l1 = anIntArray1670[i1];
		int i2 = anIntArray1670[j1];
		int j2 = anIntArray1670[k1];
		if (l1 >= 50) {
			anIntArray1678[l] = anIntArray1665[i1];
			anIntArray1679[l] = anIntArray1666[i1];
			anIntArray1680[l++] = anIntArray1634[i];
		} else {
			int k2 = anIntArray1668[i1];
			int k3 = anIntArray1669[i1];
			int k4 = anIntArray1634[i];
			if (j2 >= 50) {
				int k5 = (50 - l1) * modelIntArray4[j2 - l1];
				anIntArray1678[l] = j + (k2 + ((anIntArray1668[k1] - k2) * k5 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1679[l] = k + (k3 + ((anIntArray1669[k1] - k3) * k5 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1680[l++] = k4 + ((anIntArray1636[i] - k4) * k5 >> 16);
			}
			if (i2 >= 50) {
				int l5 = (50 - l1) * modelIntArray4[i2 - l1];
				anIntArray1678[l] = j + (k2 + ((anIntArray1668[j1] - k2) * l5 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1679[l] = k + (k3 + ((anIntArray1669[j1] - k3) * l5 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1680[l++] = k4 + ((anIntArray1635[i] - k4) * l5 >> 16);
			}
		}
		if (i2 >= 50) {
			anIntArray1678[l] = anIntArray1665[j1];
			anIntArray1679[l] = anIntArray1666[j1];
			anIntArray1680[l++] = anIntArray1635[i];
		} else {
			int l2 = anIntArray1668[j1];
			int l3 = anIntArray1669[j1];
			int l4 = anIntArray1635[i];
			if (l1 >= 50) {
				int i6 = (50 - i2) * modelIntArray4[l1 - i2];
				anIntArray1678[l] = j + (l2 + ((anIntArray1668[i1] - l2) * i6 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1679[l] = k + (l3 + ((anIntArray1669[i1] - l3) * i6 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1680[l++] = l4 + ((anIntArray1634[i] - l4) * i6 >> 16);
			}
			if (j2 >= 50) {
				int j6 = (50 - i2) * modelIntArray4[j2 - i2];
				anIntArray1678[l] = j + (l2 + ((anIntArray1668[k1] - l2) * j6 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1679[l] = k + (l3 + ((anIntArray1669[k1] - l3) * j6 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1680[l++] = l4 + ((anIntArray1636[i] - l4) * j6 >> 16);
			}
		}
		if (j2 >= 50) {
			anIntArray1678[l] = anIntArray1665[k1];
			anIntArray1679[l] = anIntArray1666[k1];
			anIntArray1680[l++] = anIntArray1636[i];
		} else {
			int i3 = anIntArray1668[k1];
			int i4 = anIntArray1669[k1];
			int i5 = anIntArray1636[i];
			if (i2 >= 50) {
				int k6 = (50 - j2) * modelIntArray4[i2 - j2];
				anIntArray1678[l] = j + (i3 + ((anIntArray1668[j1] - i3) * k6 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1679[l] = k + (i4 + ((anIntArray1669[j1] - i4) * k6 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1680[l++] = i5 + ((anIntArray1635[i] - i5) * k6 >> 16);
			}
			if (l1 >= 50) {
				int l6 = (50 - j2) * modelIntArray4[l1 - j2];
				anIntArray1678[l] = j + (i3 + ((anIntArray1668[i1] - i3) * l6 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1679[l] = k + (i4 + ((anIntArray1669[i1] - i4) * l6 >> 16)<< WorldController.viewDistance) / 50;
				anIntArray1680[l++] = i5 + ((anIntArray1634[i] - i5) * l6 >> 16);
			}
		}
		int j3 = anIntArray1678[0];
		int j4 = anIntArray1678[1];
		int j5 = anIntArray1678[2];
		int i7 = anIntArray1679[0];
		int j7 = anIntArray1679[1];
		int k7 = anIntArray1679[2];
		if ((j3 - j4) * (k7 - j7) - (i7 - j7) * (j5 - j4) > 0) {
			Rasterizer.aBoolean1462 = false;
			int texture_a = i1;
			int texture_b = j1;
			int texture_c = k1;
			if (l == 3) {
				if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.centerX || j4 > DrawingArea.centerX || j5 > DrawingArea.centerX)//TODO COULD BE SOMETHING ELSE
					Rasterizer.aBoolean1462 = true;

				int l7;
				if (face_render_type == null)
					l7 = 0;
				else
					l7 = face_render_type[i] & 3;

				if(texture != null && texture[i] != -1) {
					if(texture_coordinates != null && texture_coordinates[i] != -1) {
						int coordinate = texture_coordinates[i] & 0xff;
						texture_a = anIntArray1643[coordinate];
						texture_b = anIntArray1644[coordinate];
						texture_c = anIntArray1645[coordinate];
					}
					if(anIntArray1636[i] == -1) {
						Rasterizer.method378(
								i7, j7, k7, 
								j3, j4, j5,
								anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], 
								anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c],
								anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], 
								anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c],
								texture[i]);
					} else {
						Rasterizer.method378(
								i7, j7, k7, 
								j3, j4, j5,
								anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], 
								anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c],
								anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], 
								anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], 
								texture[i]);
					}
				} else {
					if (l7 == 0)
						Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2]); //TODO CHECK THIS
					else if (l7 == 1)
						Rasterizer.method376(i7, j7, k7, j3, j4, j5, modelIntArray3[anIntArray1634[i]]);
				}
			}
			if (l == 4) {
				if (j3 < 0 || j4 < 0 || j5 < 0 || j3 > DrawingArea.centerX || j4 > DrawingArea.centerX || j5 > DrawingArea.centerX || anIntArray1678[3] < 0 || anIntArray1678[3] > DrawingArea.centerX) //TODO COULD BE SOMETHING ELSE
					Rasterizer.aBoolean1462 = true;
				int type;
				if (face_render_type == null)
					type = 0;
				else
					type = face_render_type[i] & 3;

				if(texture != null && texture[i] != -1) {
					if(texture_coordinates != null && texture_coordinates[i] != -1) {
						int coordinate = texture_coordinates[i] & 0xff;
						texture_a = anIntArray1643[coordinate];
						texture_b = anIntArray1644[coordinate];
						texture_c = anIntArray1645[coordinate];
					}
					if(anIntArray1636[i] == -1) {
						Rasterizer.method378(
								i7, j7, k7, 
								j3, j4, j5,
								anIntArray1634[i], anIntArray1634[i], anIntArray1634[i], 
								anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c],
								anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c], 
								anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c],
								texture[i]);
						Rasterizer.method378(
								i7, k7, anIntArray1679[3], 
								j3, j5, anIntArray1678[3], 
								anIntArray1634[i], anIntArray1634[i], anIntArray1634[i],
								anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c], 
								anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c],
								anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], 
								texture[i]);
					} else {
						Rasterizer.method378(
								i7, j7, k7, 
								j3, j4, j5,
								anIntArray1680[0], anIntArray1680[1], anIntArray1680[2], 
								anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c],
								anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c],
								anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c],
								texture[i]);
						Rasterizer.method378(
								i7, k7, anIntArray1679[3],
								j3, j5, anIntArray1678[3], 
								anIntArray1680[0], anIntArray1680[2], anIntArray1680[3],
								anIntArray1668[texture_a], anIntArray1668[texture_b], anIntArray1668[texture_c], 
								anIntArray1669[texture_a], anIntArray1669[texture_b], anIntArray1669[texture_c],
								anIntArray1670[texture_a], anIntArray1670[texture_b], anIntArray1670[texture_c], 
								texture[i]);
						return;
					}
				} else {
					if (type == 0) {
						Rasterizer.drawGouraudTriangle(i7, j7, k7, j3, j4, j5, anIntArray1680[0], anIntArray1680[1], anIntArray1680[2]); //TODO CHECK THESE 2
						Rasterizer.drawGouraudTriangle(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], anIntArray1680[0], anIntArray1680[2], anIntArray1680[3]);
						return;
					}
					if (type == 1) {
						int l8 = modelIntArray3[anIntArray1634[i]];
						Rasterizer.method376(i7, j7, k7, j3, j4, j5, l8);
						Rasterizer.method376(i7, k7, anIntArray1679[3], j3, j5, anIntArray1678[3], l8);
						return;
					}
				}
			}
		}
	}

	private final boolean method486(int i, int j, int k, int l, int i1, int x_a, int x_b, int x_c) {
		if (j < k && j < l && j < i1)
			return false;
		if (j > k && j > l && j > i1)
			return false;
		if (i < x_a && i < x_b && i < x_c)
			return false;
		return i <= x_a || i <= x_b || i <= x_c;
	}

	public short[] texture;
	public byte[] texture_coordinates;
	public byte[] texture_type;
	private boolean aBoolean1618;
	public static int anInt1620;
	public static Model aModel_1621 = new Model(true);
    private static int[] anIntArray1622 = new int[65564];
    private static int[] anIntArray1623 = new int[65564];
    private static int[] anIntArray1624 = new int[65564];
    private static int[] anIntArray1625 = new int[65564];
	public int numberOfVerticeCoordinates;
    public int[] verticesXCoordinate;
    public int[] verticesYCoordinate;
    public int[] verticesZCoordinate;
	public int[] verticesParticle;
	private final int MODEL_DRAW_DISTANCE = 30000;
	public int numberOfTriangleFaces;
    public int[] face_a;
    public int[] face_b;
    public int[] face_c;
    public int[] anIntArray1634;
    public int[] anIntArray1635;
    public int[] anIntArray1636;
    public int[] face_render_type;
    public byte[] render_priorities;
    public int[] anIntArray1639;
    public short[] anIntArray1640;
	public byte priority = 0;
	public int anInt1642;
    public int[] anIntArray1643;
    public int[] anIntArray1644;
    public int[] anIntArray1645;
	public int anInt1646;
	public int anInt1647;
	public int anInt1648;
	public int anInt1649;
	public int anInt1650;
	public int anInt1651;
	public int anInt1652;
	public int anInt1653;
	public int anInt1654;
    public int[] anIntArray1655;
    public int[] anIntArray1656;
    public int[][] anIntArrayArray1657;
    public int[][] anIntArrayArray1658;
	public boolean aBoolean1659;
    public VertexNormal[] aClass33Array1660;
    static Class21[] aClass21Array1661;
	static OnDemandFetcherParent aOnDemandFetcherParent_1662;
    static boolean[] aBooleanArray1663 = new boolean[65564];
    static boolean[] aBooleanArray1664 = new boolean[65564];
    static int[] anIntArray1665 = new int[65564];
    static int[] anIntArray1666 = new int[65564];
    static int[] anIntArray1667 = new int[65564];
    static int[] anIntArray1668 = new int[65564];
    static int[] anIntArray1669 = new int[65564];
    static int[] anIntArray1670 = new int[65564];
    static int[] anIntArray1671 = new int[65564];
    static int[][] anIntArrayArray1672 = new int[65564][512];
    static int[] anIntArray1673 = new int[12];
    static int[][] anIntArrayArray1674 = new int[12][65564];
    static int[] anIntArray1675 = new int[65564];
    static int[] anIntArray1676 = new int[65564];
    static int[] anIntArray1677 = new int[12];
    static int[] anIntArray1678 = new int[10];
    static int[] anIntArray1679 = new int[10];
    static int[] anIntArray1680 = new int[10];
	static int anInt1681;
	static int anInt1682;
	static int anInt1683;
	public static boolean aBoolean1684;
	public static int anInt1685;
	public static int anInt1686;
	public static boolean[] newmodel;
	public static int anInt1687;
    public static int[] anIntArray1688 = new int[1000];
    public static int[] mapObjIds = new int[1000];
    public static int[] SINE;
    public static int[] COSINE;
    static int[] modelIntArray3;
    static int[] modelIntArray4;

	static {
		SINE = Rasterizer.anIntArray1470;
		COSINE = Rasterizer.anIntArray1471;
		modelIntArray3 = Rasterizer.anIntArray1482;
		modelIntArray4 = Rasterizer.anIntArray1469;
	}

	public void setTexture(short tex) {
		anInt1642 = numberOfTriangleFaces;
		int set2 = 0;
		if (face_render_type == null)
			face_render_type = new int[numberOfTriangleFaces];
		if (anIntArray1640 == null)
			anIntArray1640 = new short[numberOfTriangleFaces];
		verticesXCoordinate = new int[numberOfTriangleFaces];
		verticesYCoordinate = new int[numberOfTriangleFaces];
		verticesZCoordinate = new int[numberOfTriangleFaces];

		for (int i = 0; i < numberOfTriangleFaces; i++) {
			anIntArray1640[i] = tex;
			face_render_type[i] = 3 + set2;
			set2 += 4;
			verticesXCoordinate[i] = face_a[i];
			verticesYCoordinate[i] = face_b[i];
			verticesZCoordinate[i] = face_c[i];
		}
	}

}