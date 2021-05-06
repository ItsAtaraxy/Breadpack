package com.ataraxy.breadpack.objects.blocks;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockStop extends BlockBase 
{
	public static final AxisAlignedBB STOPAABB = new AxisAlignedBB(0, 0, 0.375, 1, 1, 0.625);
	
	//NOT MY CODE
//	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	
	public BlockStop(String name) 
	{
		super(name, Material.IRON, 5.0f, 30.0f, 2, "pickaxe");
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		return STOPAABB;
	}
	
	//NO LONGER MY CODE
	
//	@Override
//    public BlockStateContainer createBlockState() {
//        return new BlockStateContainer(this, FACING);
//    }
//	
//	@Override
//    public int getMetaFromState(IBlockState state) {
//        return 0;
//    }
//
//    @Override
//    public IBlockState getStateFromMeta(int meta) {
//        return getDefaultState();
//    }
//    
//    @Override
//    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack) {
//        EnumFacing entityFacing = entity.getHorizontalFacing();
//
//        if(!world.isRemote) {
//            if(entityFacing == EnumFacing.NORTH) {
//                entityFacing = EnumFacing.SOUTH;
//            } else if(entityFacing == EnumFacing.EAST) {
//                entityFacing = EnumFacing.WEST;
//            } else if(entityFacing == EnumFacing.SOUTH) {
//                entityFacing = EnumFacing.NORTH;
//            } else if(entityFacing == EnumFacing.WEST) {
//                entityFacing = EnumFacing.EAST;
//            }
//
//            world.setBlockState(pos, state.withProperty(FACING, entityFacing), 2);
//        }
    }
	
//}
