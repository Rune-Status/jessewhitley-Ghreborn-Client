package com.Ghreborn.client.link;

import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.link.NodeCache;
import com.Ghreborn.client.link.NodeSub;
import com.Ghreborn.client.link.NodeSubList;

public final class MRUNodes {
   private boolean aBoolean295 = false;
   private boolean aBoolean297 = false;
   private NodeSub aClass30_Sub2_300 = new NodeSub();
   private NodeSubList nodeSubList;
   private int anInt301;
   private int anInt302;
   private NodeCache aClass1_303;
   private static int anInt296;
   private int anInt298;
   private int anInt299;

   public MRUNodes(int i) {
      this.nodeSubList = new NodeSubList(anInt296);
      this.anInt301 = i;
      this.anInt302 = i;
      this.aClass1_303 = new NodeCache(-877, 1024);

   }

   public NodeSub insertFromCache(long l) {
      NodeSub class30_sub2 = (NodeSub)this.aClass1_303.method148(l);
      if(class30_sub2 != null) {
         this.nodeSubList.method150(class30_sub2);
         ++this.anInt299;
      } else {
         ++this.anInt298;
      }

      return class30_sub2;
   }

   public void removeFromCache(NodeSub class30_sub2, long l) {
      try {
         if(this.anInt302 == 0) {
            NodeSub var71 = this.nodeSubList.popTail();
            var71.unlink();
            var71.unlinkSub();
            if(var71 == this.aClass30_Sub2_300) {
               NodeSub class30_sub2_2 = this.nodeSubList.popTail();
               class30_sub2_2.unlink();
               class30_sub2_2.unlinkSub();
            }
         } else {
            --this.anInt302;
         }

         this.aClass1_303.method149(class30_sub2, l, (byte)7);
         this.nodeSubList.method150(class30_sub2);
      } catch (RuntimeException var6) {
         SignLink.reporterror("47547, " + class30_sub2 + ", " + l + ", " + 2 + ", " + var6.toString());
         throw new RuntimeException();
      }
   }

   public void method224() {
      while(true) {
         NodeSub class30_sub2 = this.nodeSubList.popTail();
         if(class30_sub2 == null) {
            this.anInt302 = this.anInt301;
            return;
         }

         class30_sub2.unlink();
         class30_sub2.unlinkSub();
      }
   }
}
