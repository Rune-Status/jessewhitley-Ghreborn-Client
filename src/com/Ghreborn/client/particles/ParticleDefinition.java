package com.Ghreborn.client.particles;

import com.Ghreborn.client.cache.graphics.Sprite;
import com.Ghreborn.client.particles.PointSpawnShape;
import com.Ghreborn.client.particles.SpawnShape;
import com.Ghreborn.client.particles.Vector;
import java.util.Random;

public class ParticleDefinition {
   public static final Random RANDOM = new Random(System.currentTimeMillis());
   public static ParticleDefinition[] cache = new ParticleDefinition[]{new ParticleDefinition() {
      {
         this.setStartVelocity(new Vector(0, -1, 0));
         this.setEndVelocity(new Vector(0, -1, 0));
         this.setGravity(new Vector(0, 0, 0));
         this.setLifespan(19);
         this.setStartAlpha(0.5F);
         this.setSpawnRate(3);
         this.setSprite(new Sprite("particle 1"));
         this.updateSteps();
      }
   }, new ParticleDefinition() {
      {
         this.setStartVelocity(new Vector(0, -3, 0));
         this.setEndVelocity(new Vector(0, -3, 0));
         this.setGravity(new Vector(0, 0, 0));
         this.setLifespan(19);
         this.setStartColor(16713728);
         this.setSpawnRate(1);
         this.setStartSize(1.0F);
         this.setEndSize(0.0F);
         this.setStartAlpha(0.075F);
         this.updateSteps();
         this.setColorStep(2304);
      }
   }, new ParticleDefinition() {
      {
         this.setStartVelocity(new Vector(0, -1, 0));
         this.setEndVelocity(new Vector(0, -1, 0));
         this.setGravity(new Vector(0, 0, 0));
         this.setLifespan(19);
         this.setStartColor(0);
         this.setSpawnRate(3);
         this.setStartSize(1.0F);
         this.setEndSize(0.05F);
         this.setStartAlpha(0.015F);
         this.updateSteps();
         this.setColorStep(0);
      }
   }, new ParticleDefinition() {
      {
         this.setStartVelocity(new Vector(0, -3, 0));
         this.setEndVelocity(new Vector(0, -3, 0));
         this.setGravity(new Vector(0, 0, 0));
         this.setLifespan(19);
         this.setStartColor(16777215);
         this.setSpawnRate(4);
         this.setStartSize(0.75F);
         this.setEndSize(0.0F);
         this.setStartAlpha(0.035F);
         this.updateSteps();
         this.setColorStep(0);
      }
   }, new ParticleDefinition() {
      {
         this.setStartVelocity(new Vector(0, 2, 0));
         this.setEndVelocity(new Vector(0, 2, 0));
         this.setGravity(new Vector(0, 16, 0));
         this.setLifespan(19);
         this.setStartColor(0);
         this.setSpawnRate(3);
         this.setStartSize(0.7F);
         this.setEndSize(0.5F);
         this.setStartAlpha(0.0F);
         this.setEndAlpha(0.035F);
         this.updateSteps();
         this.setColorStep(0);
      }
   }, new ParticleDefinition() {
      {
         this.setStartVelocity(new Vector(0, 2, 0));
         this.setEndVelocity(new Vector(0, 2, 0));
         this.setGravity(new Vector(0, 1, 0));
         this.setLifespan(19);
         this.setStartColor(16713728);
         this.setSpawnRate(4);
         this.setStartSize(2.0F);
         this.setEndSize(0.5F);
         this.setStartAlpha(0.0F);
         this.setEndAlpha(0.045F);
         this.updateSteps();
         this.setColorStep(2304);
      }
   }};
   private static int maxParticles = 10000;
   private float startSize = 1.0F;
   private float endSize = 1.0F;
   private int startColor = -1;
   private int endColor = -1;
   private Vector startVelocity;
   private Vector endVelocity;
   private int lifespan;
   private int spawnRate;
   private float startAlpha;
   private float endAlpha;
   private SpawnShape spawnShape;
   private Vector gravity;
   private int zBuffer;
   private float alphaStep;
   private Sprite sprite;
   private Vector velocityStep;
   private int colorStep;
   private float sizeStep;

   public ParticleDefinition() {
      this.startVelocity = Vector.ZERO;
      this.endVelocity = Vector.ZERO;
      this.lifespan = 1;
      this.spawnRate = 1;
      this.startAlpha = 1.0F;
      this.endAlpha = 0.05F;
      this.spawnShape = new PointSpawnShape(Vector.ZERO);
   }

   public Vector getGravity() {
      return this.gravity;
   }

   public void setGravity(Vector gravity) {
      this.gravity = gravity;
   }

   public int getzBuffer() {
      return this.zBuffer;
   }

   public void setzBuffer(int zBuffer) {
      this.zBuffer = zBuffer;
   }

   public float getStartAlpha() {
      return this.startAlpha;
   }

   public void setStartAlpha(float startAlpha) {
      this.startAlpha = startAlpha;
   }

   public float getEndAlpha() {
      return this.endAlpha;
   }

   public void setEndAlpha(float endAlpha) {
      this.endAlpha = endAlpha;
   }

   public float getAlphaStep() {
      return this.alphaStep;
   }

   public void setAlphaStep(float alphaStep) {
      this.alphaStep = alphaStep;
   }

   public Sprite getSprite() {
      return this.sprite;
   }

   public void setSprite(Sprite sprite) {
      this.sprite = sprite;
   }

   public SpawnShape getSpawnShape() {
      return this.spawnShape;
   }

   public void setSpawnShape(SpawnShape spawnShape) {
      this.spawnShape = spawnShape;
   }

   public int randomWithRange(int min, int max) {
      int range = max - min + 1;
      return (int)(Math.random() * (double)range) + min;
   }

   public int getSpawnRate() {
      return this.spawnRate;
   }

   public void setSpawnRate(int spawnRate) {
      this.spawnRate = spawnRate;
   }

   public static int getMaxParticles() {
      return maxParticles;
   }

   public void setMaxParticles(int maxParticles) {
      ParticleDefinition.maxParticles = maxParticles;
   }

   public float getStartSize() {
      return this.startSize;
   }

   public void setStartSize(float startSize) {
      this.startSize = startSize;
   }

   public float getEndSize() {
      return this.endSize;
   }

   public void setEndSize(float endSize) {
      this.endSize = endSize;
   }

   public int getStartColor() {
      return this.startColor;
   }

   public void setStartColor(int startColor) {
      this.startColor = startColor;
   }

   public int getEndColor() {
      return this.endColor;
   }

   public void setEndColor(int endColor) {
      this.endColor = endColor;
   }

   public Vector getStartVelocity(int id) {
      switch(id) {
      case 2:
         return new Vector(this.startVelocity.getX() + this.randomWithRange(-1, 1), this.startVelocity.getY(), this.startVelocity.getZ() + this.randomWithRange(-1, 1));
      case 3:
         return new Vector(this.startVelocity.getX() + this.randomWithRange(-1, 1), this.startVelocity.getY() + this.randomWithRange(0, 3), this.startVelocity.getZ() + this.randomWithRange(-1, 1));
      case 4:
      case 5:
         return new Vector(this.startVelocity.getX() + this.randomWithRange(-3, 3), this.startVelocity.getY() + this.randomWithRange(0, 9), this.startVelocity.getZ() + this.randomWithRange(-3, 3));
      default:
         return this.startVelocity;
      }
   }

   public void setStartVelocity(Vector startVelocity) {
      this.startVelocity = startVelocity;
   }

   public Vector getEndVelocity() {
      return this.endVelocity;
   }

   public void setEndVelocity(Vector endVelocity) {
      this.endVelocity = endVelocity;
   }

   public int getLifespan() {
      return this.lifespan;
   }

   public void setLifespan(int lifespan) {
      this.lifespan = lifespan;
   }

   public void setVelocityStep(Vector velocityStep) {
      this.velocityStep = velocityStep;
   }

   public void setColorStep(int colorStep) {
      this.colorStep = colorStep;
   }

   public void setSizeStep(float sizeStep) {
      this.sizeStep = sizeStep;
   }

   public float getSizeStep() {
      return this.sizeStep;
   }

   public Vector getVelocityStep() {
      return this.velocityStep;
   }

   public int getColorStep() {
      return this.colorStep;
   }

   public void updateSteps() {
      this.sizeStep = (this.endSize - this.startSize) / ((float)this.lifespan * 1.0F);
      this.colorStep = (this.endColor - this.startColor) / this.lifespan;
      this.velocityStep = this.endVelocity.subtract(this.startVelocity).divide((float)this.lifespan);
      this.alphaStep = (this.endAlpha - this.startAlpha) / (float)this.lifespan;
   }

   public void updateStepsNoAlpha() {
      this.sizeStep = (this.endSize - this.startSize) / ((float)this.lifespan * 1.0F);
      this.colorStep = (this.endColor - this.startColor) / this.lifespan;
      this.velocityStep = this.endVelocity.subtract(this.startVelocity).divide((float)this.lifespan);
   }
}
