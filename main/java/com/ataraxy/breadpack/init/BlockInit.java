package com.ataraxy.breadpack.init;

import java.util.ArrayList;
import java.util.List;

import com.ataraxy.breadpack.objects.blocks.ContainerBase;

import net.minecraft.block.Block;


public class BlockInit 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//Blocks
	//public static final Block RUBY_BLOCK = new BlockBase("ruby_block", Material.IRON, 5.0f, 30.0f, 2, "pickaxe");
	public static final Block STOP = new ContainerBase("stop");
	public static final Block TRAFFICLIGHT = new ContainerBase("traffic_light");
}
