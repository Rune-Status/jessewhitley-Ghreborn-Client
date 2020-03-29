package com.Ghreborn.client.entity;

import com.Ghreborn.client.entity.model.Model;
import com.Ghreborn.client.entity.model.VertexNormal;
import com.Ghreborn.client.link.NodeSub;

public class Animable extends NodeSub {
   public VertexNormal[] aClass33Array1425;
   public static boolean aBoolean1427;
   private int anInt1424 = 923;
   public int modelHeight = 1000;

   public void method443(int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int newuid) {
      Model Model = this.getRotatedModel();
      if(Model != null) {
         this.modelHeight = Model.modelHeight;
         Model.method443(i, j, k, l, i1, j1, k1, l1, i2, newuid);
      }

   }

   public Model getRotatedModel() {
      return null;
   }
}
