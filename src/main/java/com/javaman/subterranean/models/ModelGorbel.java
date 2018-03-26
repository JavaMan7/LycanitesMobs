package com.javaman.subterranean.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGorbel extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer leftleg;
    ModelRenderer rightleg;
    ModelRenderer eyestokm;
    ModelRenderer eyem;
    ModelRenderer eyer;
    ModelRenderer eyestokr;
    ModelRenderer eyel;
    ModelRenderer eyestokl;
  
  public ModelGorbel()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      body = new ModelRenderer(this, 0, 0);
      body.addBox(-7.5F, -7.5F, -7.5F, 15, 15, 15);
      body.setRotationPoint(0F, 8F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 0);
      leftleg.addBox(-1.5F, 0F, -1.5F, 3, 6, 3);
      leftleg.setRotationPoint(-5F, 15F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 0);
      rightleg.addBox(-1.5F, 0F, -1.5F, 3, 6, 3);
      rightleg.setRotationPoint(5F, 15F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      eyestokm = new ModelRenderer(this, 0, 0);
      eyestokm.addBox(-1.5F, -6F, -1.5F, 3, 6, 3);
      eyestokm.setRotationPoint(0F, 1F, -5F);
      eyestokm.setTextureSize(64, 32);
      eyestokm.mirror = true;
      setRotation(eyestokm, 0F, 0F, 0F);
      eyem = new ModelRenderer(this, 47, 0);
      eyem.addBox(-2F, -2F, -2F, 4, 4, 4);
      eyem.setRotationPoint(0F, -7F, -5F);
      eyem.setTextureSize(64, 32);
      eyem.mirror = true;
      setRotation(eyem, 0F, 0F, 0F);
      eyer = new ModelRenderer(this, 47, 0);
      eyer.addBox(-2F, -2F, -2F, 4, 4, 4);
      eyer.setRotationPoint(7.7F, -6F, -5F);
      eyer.setTextureSize(64, 32);
      eyer.mirror = true;
      setRotation(eyer, 0F, 0F, 0.3490659F);
      eyestokr = new ModelRenderer(this, 0, 0);
      eyestokr.addBox(-1.5F, -6F, -1.5F, 3, 6, 3);
      eyestokr.setRotationPoint(5F, 1F, -5F);
      eyestokr.setTextureSize(64, 32);
      eyestokr.mirror = true;
      setRotation(eyestokr, 0F, 0F, 0.3665191F);
      eyel = new ModelRenderer(this, 47, 0);
      eyel.addBox(-2F, -2F, -2F, 4, 4, 4);
      eyel.setRotationPoint(-7.7F, -6F, -5F);
      eyel.setTextureSize(64, 32);
      eyel.mirror = true;
      setRotation(eyel, 0F, 0F, -0.3490659F);
      eyestokl = new ModelRenderer(this, 0, 0);
      eyestokl.addBox(-1.5F, -6F, -1.5F, 3, 6, 3);
      eyestokl.setRotationPoint(-5F, 1F, -5F);
      eyestokl.setTextureSize(64, 32);
      eyestokl.mirror = true;
      setRotation(eyestokl, 0F, 0F, -0.3490659F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    leftleg.render(f5);
    rightleg.render(f5);
    eyestokm.render(f5);
    eyem.render(f5);
    eyer.render(f5);
    eyestokr.render(f5);
    eyel.render(f5);
    eyestokl.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5,Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5,entity);
  }

}