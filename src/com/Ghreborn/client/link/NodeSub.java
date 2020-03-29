package com.Ghreborn.client.link;

import com.Ghreborn.client.link.Node;

public class NodeSub extends Node {
   public int anInt1305;
   public NodeSub aClass30_Sub2_1303;
   NodeSub aClass30_Sub2_1304;

   public void unlinkSub() {
      if(this.aClass30_Sub2_1304 != null) {
         this.aClass30_Sub2_1304.aClass30_Sub2_1303 = this.aClass30_Sub2_1303;
         this.aClass30_Sub2_1303.aClass30_Sub2_1304 = this.aClass30_Sub2_1304;
         this.aClass30_Sub2_1303 = null;
         this.aClass30_Sub2_1304 = null;
      }

   }
}
