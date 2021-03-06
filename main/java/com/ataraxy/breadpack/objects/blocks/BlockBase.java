package com.ataraxy.breadpack.objects.blocks;

import com.ataraxy.breadpack.Breadpack;
import com.ataraxy.breadpack.init.BlockInit;
import com.ataraxy.breadpack.init.ItemInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block
{
	public BlockBase(String name, Material material, float hardness, float resistance, int miningLevel, String tool) 
	{
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setHardness(hardness);
		setResistance(resistance);
		setHarvestLevel(tool, miningLevel);
		setCreativeTab(Breadpack.BREADPACKTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
}
