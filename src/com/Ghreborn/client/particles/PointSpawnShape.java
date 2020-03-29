package com.Ghreborn.client.particles;

import com.Ghreborn.client.particles.SpawnShape;
import com.Ghreborn.client.particles.Vector;
import java.util.Random;

public class PointSpawnShape implements SpawnShape {
   private Vector point;

   public PointSpawnShape(Vector point) {
      this.point = point;
   }

   public Vector getPoint(Random r) {
      return this.point.clone();
   }
}
