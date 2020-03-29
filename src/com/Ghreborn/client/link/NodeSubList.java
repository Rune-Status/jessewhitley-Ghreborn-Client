package com.Ghreborn.client.link;

import com.Ghreborn.client.link.NodeSub;

public final class NodeSubList {
   private boolean aBoolean41 = false;
   private int anInt42 = -589;
   public NodeSub aClass30_Sub2_43 = new NodeSub();
   private NodeSub aClass30_Sub2_44;

   public NodeSubList(int i) {
      if(i != 0) {
         this.anInt42 = -25;
      }

      this.aClass30_Sub2_43.aClass30_Sub2_1303 = this.aClass30_Sub2_43;
      this.aClass30_Sub2_43.aClass30_Sub2_1304 = this.aClass30_Sub2_43;
   }

   public void method150(NodeSub class30_sub2) {
      if(class30_sub2.aClass30_Sub2_1304 != null) {
         class30_sub2.unlinkSub();
      }

      class30_sub2.aClass30_Sub2_1304 = this.aClass30_Sub2_43.aClass30_Sub2_1304;
      class30_sub2.aClass30_Sub2_1303 = this.aClass30_Sub2_43;
      class30_sub2.aClass30_Sub2_1304.aClass30_Sub2_1303 = class30_sub2;
      class30_sub2.aClass30_Sub2_1303.aClass30_Sub2_1304 = class30_sub2;
   }

   public NodeSub popTail() {
      NodeSub class30_sub2 = this.aClass30_Sub2_43.aClass30_Sub2_1303;
      if(class30_sub2 == this.aClass30_Sub2_43) {
         return null;
      } else {
         class30_sub2.unlinkSub();
         return class30_sub2;
      }
   }

   public NodeSub method152() {
      NodeSub class30_sub2 = this.aClass30_Sub2_43.aClass30_Sub2_1303;
      if(class30_sub2 == this.aClass30_Sub2_43) {
         this.aClass30_Sub2_44 = null;
         return null;
      } else {
         this.aClass30_Sub2_44 = class30_sub2.aClass30_Sub2_1303;
         return class30_sub2;
      }
   }

   public NodeSub method153(boolean flag) {
      if(flag) {
         throw new NullPointerException();
      } else {
         NodeSub class30_sub2 = this.aClass30_Sub2_44;
         if(class30_sub2 == this.aClass30_Sub2_43) {
            this.aClass30_Sub2_44 = null;
            return null;
         } else {
            this.aClass30_Sub2_44 = class30_sub2.aClass30_Sub2_1303;
            return class30_sub2;
         }
      }
   }

   public int getNodeCount() {
      int i = 0;

      for(NodeSub class30_sub2 = this.aClass30_Sub2_43.aClass30_Sub2_1303; class30_sub2 != this.aClass30_Sub2_43; class30_sub2 = class30_sub2.aClass30_Sub2_1303) {
         ++i;
      }

      return i;
   }
}
