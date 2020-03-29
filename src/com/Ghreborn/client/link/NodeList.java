package com.Ghreborn.client.link;

import com.Ghreborn.client.link.Node;

public final class NodeList {
   private boolean aBoolean344 = false;
   private int anInt345 = -77;
   public Node aClass30_346 = new Node();
   private Node aClass30_347;

   public NodeList(int i) {
      if(i <= 0) {
         this.aBoolean344 = !this.aBoolean344;
      }

      this.aClass30_346.prev = this.aClass30_346;
      this.aClass30_346.next = this.aClass30_346;
   }

   public void insertHead(Node class30) {
      if(class30.next != null) {
         class30.unlink();
      }

      class30.next = this.aClass30_346.next;
      class30.prev = this.aClass30_346;
      class30.next.prev = class30;
      class30.prev.next = class30;
   }

   public void method250(int i, Node class30) {
      if(class30.next != null) {
         class30.unlink();
      }

      class30.next = this.aClass30_346;

      for(class30.prev = this.aClass30_346.prev; i >= 0; this.aBoolean344 = !this.aBoolean344) {
      }

      class30.next.prev = class30;
      class30.prev.next = class30;
   }

   public Node popHead() {
      Node class30 = this.aClass30_346.prev;
      if(class30 == this.aClass30_346) {
         return null;
      } else {
         class30.unlink();
         return class30;
      }
   }

   public Node reverseGetFirst() {
      Node class30 = this.aClass30_346.prev;
      if(class30 == this.aClass30_346) {
         this.aClass30_347 = null;
         return null;
      } else {
         this.aClass30_347 = class30.prev;
         return class30;
      }
   }

   public Node method253(int i) {
      if(i >= 5 && i <= 5) {
         Node class30 = this.aClass30_346.next;
         if(class30 == this.aClass30_346) {
            this.aClass30_347 = null;
            return null;
         } else {
            this.aClass30_347 = class30.next;
            return class30;
         }
      } else {
         throw new NullPointerException();
      }
   }

   public Node reverseGetNext() {
      Node class30 = this.aClass30_347;

      if(class30 == this.aClass30_346) {
         this.aClass30_347 = null;
         return null;
      } else {
         this.aClass30_347 = class30.prev;
         return class30;
      }
   }

   public Node method255(int i) {
      Node class30 = this.aClass30_347;
      if(class30 == this.aClass30_346) {
         this.aClass30_347 = null;
         return null;
      } else {
         this.aClass30_347 = class30.next;
         if(i != 8) {
            throw new NullPointerException();
         } else {
            return class30;
         }
      }
   }

   public void method256() {
      if(this.aClass30_346.prev != this.aClass30_346) {
         while(true) {
            Node class30 = this.aClass30_346.prev;
            if(class30 == this.aClass30_346) {
               return;
            }

            class30.unlink();
         }
      }
   }
}
