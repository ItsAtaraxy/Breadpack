package com.ataraxy.breadpack.tabs;

import com.ataraxy.breadpack.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class BreadpackTab extends CreativeTabs
{
	public BreadpackTab(String label) 
	{
		super("BreadpackTab");
		this.setBackgroundImageName("breadpack.png");
	}
	
	@Override
	public ItemStack getTabIconItem() 
	{
		return new ItemStack(ItemInit.TOAST);
	} 
}
