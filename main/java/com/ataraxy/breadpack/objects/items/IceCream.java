package com.ataraxy.breadpack.objects.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class IceCream extends FoodBase 
{
	public IceCream(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(name, amount, saturation, isWolfFood);
		setAlwaysEdible();	
	}
	
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) 
	{
		entityLiving.addPotionEffect(new PotionEffect(MobEffects.SPEED, 600, 0, true, false));
		
		return super.onItemUseFinish(stack, worldIn, entityLiving);
	}
	
	@Override
	public boolean hasEffect(ItemStack stack) 
	{
		return false;
	}
}
