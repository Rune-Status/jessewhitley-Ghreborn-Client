package com.Ghreborn.client.entity;

import com.Ghreborn.client.cache.def.ItemDefinition;
import com.Ghreborn.client.entity.Animable;
import com.Ghreborn.client.entity.model.Model;

public final class Item extends Animable {
   public int anInt1558;
   public int anInt1559;

   public final Model getRotatedModel() {
      ItemDefinition class8 = ItemDefinition.lookup(this.anInt1558);
      return class8.method201(this.anInt1559);
   }
}
