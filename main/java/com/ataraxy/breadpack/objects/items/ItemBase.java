package com.ataraxy.breadpack.objects.items;

import com.ataraxy.breadpack.Breadpack;
import com.ataraxy.breadpack.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item 
{
	public ItemBase(String name) 
	{
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(Breadpack.BREADPACKTAB);
		
		ItemInit.ITEMS.add(this);
	}
}
