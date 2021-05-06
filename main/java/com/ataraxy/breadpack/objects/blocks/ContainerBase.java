package com.ataraxy.breadpack.objects.blocks;

import java.util.Random;

import com.ataraxy.breadpack.Breadpack;
import com.ataraxy.breadpack.init.BlockInit;
import com.ataraxy.breadpack.util.Reference;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ContainerBase extends BlockBase
{
	//FIRST 2 LINES IS STOP SIGN SPECIFIC
	public static final AxisAlignedBB STOPAABB = new AxisAlignedBB(0, 0, 0.375, 1, 1, 0.625);
	public static final AxisAlignedBB STOPAABB2 = new AxisAlignedBB(0.375, 0, 0, 0.625, 1, 1);
	public static final PropertyDirection FACING = BlockHorizontal.FACING;
	public static final PropertyBool BURNING = PropertyBool.create("burning");
	
	public ContainerBase(String name) 
	{
		super(name, Material.IRON, 5.0f, 30.0f, 2, "pickaxe");
		setSoundType(SoundType.METAL);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH).withProperty(BURNING, Boolean.valueOf(false)));
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(BlockInit.STOP);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(BlockInit.STOP);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitx, float hity, float hitz)
	{
		if(!worldIn.isRemote) playerIn.openGui(Breadpack.instance, Reference.GUI_STOP, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
	
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		if(!worldIn.isRemote)
		{
			IBlockState north = worldIn.getBlockState(pos.north());
			IBlockState south = worldIn.getBlockState(pos.south());
			IBlockState east = worldIn.getBlockState(pos.east());
			IBlockState west = worldIn.getBlockState(pos.west());
			EnumFacing facing = (EnumFacing)state.getValue(FACING);
			if(facing == EnumFacing.NORTH && north.isFullBlock() && !south.isFullBlock()) facing = EnumFacing.SOUTH;
			else if(facing == EnumFacing.SOUTH && south.isFullBlock() && !north.isFullBlock()) facing = EnumFacing.NORTH;
			else if(facing == EnumFacing.EAST && east.isFullBlock() && !west.isFullBlock()) facing = EnumFacing.WEST;
			else if(facing == EnumFacing.WEST && west.isFullBlock() && !east.isFullBlock()) facing = EnumFacing.EAST;
			
			worldIn.setBlockState(pos, state.withProperty(FACING, facing).withProperty(BURNING, false));
		}
	}
	public static void setState(boolean active, BlockPos pos, World world)
	{
		IBlockState state = world.getBlockState(pos);
		TileEntity tileentity = world.getTileEntity(pos);
		
		world.setBlockState(pos, BlockInit.STOP.getDefaultState().withProperty(FACING, state.getValue(FACING)).withProperty(BURNING, Boolean.valueOf(active)), 3);
		
		if(tileentity != null)
		{
			tileentity.validate();
			world.setTileEntity(pos, tileentity);
		}
	}
	
	@Override
	public boolean hasTileEntity() 
	{
		return true;
	}
	
	/*@Override
	public TileEntity createTileEntity(World world, IBlockState state) 
	{
		return new TileEntityStop();
	}*/
	
	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY,
			float hitZ, int meta, EntityLivingBase placer, EnumHand hand) 
	{
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) 
	{
		worldIn.setBlockState(pos, this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) 
	{
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot) 
	{
		return state.withProperty(FACING, rot.rotate((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn) 
	{
		return state.withRotation(mirrorIn.toRotation((EnumFacing)state.getValue(FACING)));
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {BURNING, FACING});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		EnumFacing facing = EnumFacing.getFront(meta);
		if(facing.getAxis() == EnumFacing.Axis.Y) facing = EnumFacing.NORTH;
		return this.getDefaultState().withProperty(FACING, facing);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}
	
	//STOP SIGN SPECIFIC
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
	
	/*@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) 
	{
		if(EnumFacing.NORTH) return STOPAABB;
	}*/
}
