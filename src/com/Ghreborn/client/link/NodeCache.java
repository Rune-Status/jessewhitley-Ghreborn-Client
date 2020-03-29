package com.Ghreborn.client.link;

import com.Ghreborn.client.SignLink;
import com.Ghreborn.client.link.Node;

public final class NodeCache {
   private boolean aBoolean37 = false;
   private int anInt38 = -373;
   private int anInt39;
   private Node[] aClass30Array40;

   public NodeCache(int i, int j) {
      if(i >= 0) {
         throw new NullPointerException();
      } else {
         this.anInt39 = j;
         this.aClass30Array40 = new Node[j];

         for(int k = 0; k < j; ++k) {
            Node class30 = this.aClass30Array40[k] = new Node();
            class30.prev = class30;
            class30.next = class30;
         }

      }
   }

   public Node method148(long l) {
      Node class30 = this.aClass30Array40[(int)(l & (long)(this.anInt39 - 1))];

      for(Node class30_1 = class30.prev; class30_1 != class30; class30_1 = class30_1.prev) {
         if(class30_1.id == l) {
            return class30_1;
         }
      }

      return null;
   }

   public void method149(Node class30, long l, byte byte0) {
      try {
         if(class30.next != null) {
            class30.unlink();
         }

         Node var61 = this.aClass30Array40[(int)(l & (long)(this.anInt39 - 1))];
         if(byte0 == 7) {
            class30.next = var61.next;
            class30.prev = var61;
            class30.next.prev = class30;
            class30.prev.next = class30;
            class30.id = l;
         }

      } catch (RuntimeException var6) {
         SignLink.reporterror("91499, " + class30 + ", " + l + ", " + byte0 + ", " + var6.toString());
         throw new RuntimeException();
      }
   }
}
