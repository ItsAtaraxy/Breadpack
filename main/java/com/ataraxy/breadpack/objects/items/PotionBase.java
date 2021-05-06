package com.ataraxy.breadpack.objects.items;

import com.ataraxy.breadpack.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class PotionBase extends Potion 
{
	public PotionBase(String name, boolean isBadPotion, int color, int IconIndexX, int IconIndexY) 
	{
		super(isBadPotion, color);
		setPotionName("effect." + name);
		setIconIndex(IconIndexX, IconIndexY);
		setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + name));
	}
	@Override
	public boolean hasStatusIcon() 
	{
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + "textures/gui/potioneffects.png"));
		return true;
	}
}
