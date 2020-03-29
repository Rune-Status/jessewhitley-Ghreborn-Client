package com.Ghreborn.client.particles;

import com.Ghreborn.client.particles.SpawnShape;
import com.Ghreborn.client.particles.Vector;
import java.util.Random;

public class BoxSpawnShape implements SpawnShape {
   private Vector center;
   private Vector radius;

   public BoxSpawnShape(Vector center, Vector radius) {
      this.center = center;
      this.radius = radius;
   }

   public Vector getPoint(Random r) {
      return this.center.mix(this.radius, (r.nextFloat() - 0.5F) * 2.0F, (r.nextFloat() - 0.5F) * 2.0F, (r.nextFloat() - 0.5F) * 2.0F);
   }
}
