package com.ataraxy.breadpack.objects.items;

import com.ataraxy.breadpack.Breadpack;
import com.ataraxy.breadpack.init.ItemInit;

import net.minecraft.item.ItemFood;

public class FoodBase extends ItemFood 
{
	public FoodBase(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(Breadpack.BREADPACKTAB);
		
		ItemInit.ITEMS.add(this);
	}
}
