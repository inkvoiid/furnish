package voiid.ink.furnish.block;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.enums.BedPart;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

public class Bathtub extends Block{

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public static final EnumProperty<BedPart> PART = Properties.BED_PART;

    public Bathtub(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(PART, BedPart.FOOT));
    }

    public BlockState getStateForNeighborUpdate(
            BlockState state, 
            Direction facing, 
            BlockState neighborState, 
            WorldAccess world, 
            BlockPos pos, 
            BlockPos neighborPos) {
        if (facing == getDirectionTowardsOtherPart((BedPart)state.get(PART), (Direction)state.get(FACING))) {
            return neighborState.isOf(this) && neighborState.get(PART) != state.get(PART) ? (BlockState)state : Blocks.AIR.getDefaultState();
        } else {
            return super.getStateForNeighborUpdate(state, facing, neighborState, world, pos, neighborPos);
        }
    }

    private static Direction getDirectionTowardsOtherPart(BedPart part, Direction direction) {
        return part == BedPart.FOOT ? direction : direction.getOpposite();
    }

    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && player.isCreative()) {
            BedPart bedPart = (BedPart)state.get(PART);
            if (bedPart == BedPart.FOOT) {
                BlockPos blockPos = pos.offset(getDirectionTowardsOtherPart(bedPart, (Direction)state.get(FACING)));
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.getBlock() == this && blockState.get(PART) == BedPart.HEAD) {
                    world.setBlockState(blockPos, Blocks.AIR.getDefaultState(), 35);
                    world.syncWorldEvent(player, 2001, blockPos, Block.getRawIdFromState(blockState));
                }
            }
        }

        super.onBreak(world, pos, state, player);
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction direction = ctx.getPlayerFacing();
        BlockPos blockPos = ctx.getBlockPos();
        BlockPos blockPos2 = blockPos.offset(direction);
        return ctx.getWorld().getBlockState(blockPos2).canReplace(ctx) ? (BlockState)this.getDefaultState().with(FACING, direction) : null;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, PART);
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!world.isClient) {
            BlockPos blockPos = pos.offset((Direction)state.get(FACING));
            world.setBlockState(blockPos, (BlockState)state.with(PART, BedPart.HEAD), 3);
            world.updateNeighbors(pos, Blocks.AIR);
            state.updateNeighbors(world, pos, 3);
        }
    }

    private static final VoxelShape HEAD_NORTH_STATE = VoxelShapes.union(
            //Bathtub
            VoxelShapes.cuboid(0/16f, 2/16f, 0/16f, 16/16f, 14/16f, 16/16f));

    private static final VoxelShape HEAD_SOUTH_STATE = VoxelShapes.union(
            //Bathtub
            VoxelShapes.cuboid(0/16f, 2/16f, 0/16f, 16/16f, 14/16f, 16/16f));

    private static final VoxelShape HEAD_EAST_STATE = VoxelShapes.union(
            //Bathtub
            VoxelShapes.cuboid(0/16f, 2/16f, 0/16f, 16/16f, 14/16f, 16/16f));

    private static final VoxelShape HEAD_WEST_STATE = VoxelShapes.union(
            //base
            VoxelShapes.cuboid(0/16f, 2/16f, 0/16f, 16/16f, 3/16f, 16/16f),
            //top wall
            VoxelShapes.cuboid(0/16f, 2/16f, 0/16f, 2/16f, 14/16f, 16/16f),
            //left wall
            VoxelShapes.cuboid(2/16f, 2/16f, 0/16f, 16/16f, 14/16f, 2/16f),
            //right wall
            VoxelShapes.cuboid(2/16f, 2/16f, 14/16f, 16/16f, 14/16f, 16/16f));

    private static final VoxelShape FOOT_NORTH_STATE = VoxelShapes.union(
            //Bathtub
            VoxelShapes.cuboid(0/16f, 2/16f, 0/16f, 16/16f, 14/16f, 16/16f));

    private static final VoxelShape FOOT_SOUTH_STATE = VoxelShapes.union(
            //Bathtub
            VoxelShapes.cuboid(0/16f, 2/16f, 0/16f, 16/16f, 14/16f, 16/16f));

    private static final VoxelShape FOOT_EAST_STATE = VoxelShapes.union(
            //Bathtub
            VoxelShapes.cuboid(0/16f, 2/16f, 0/16f, 16/16f, 14/16f, 16/16f));

    private static final VoxelShape FOOT_WEST_STATE = VoxelShapes.union(
            //base
            VoxelShapes.cuboid(0/16f, 2/16f, 0/16f, 16/16f, 3/16f, 16/16f),
            //bottom wall
            VoxelShapes.cuboid(14/16f, 2/16f, 0/16f, 16/16f, 14/16f, 16/16f),
            //left wall
            VoxelShapes.cuboid(0/16f, 2/16f, 0/16f, 14/16f, 14/16f, 2/16f),
            //right wall
            VoxelShapes.cuboid(0/16f, 2/16f, 14/16f, 14/16f, 14/16f, 16/16f));

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {

        Direction dir = state.get(FACING);
        BedPart part = state.get(PART);
        if (part==BedPart.HEAD)
        {
            return switch (dir) {
                case NORTH -> HEAD_NORTH_STATE;
                case SOUTH -> HEAD_SOUTH_STATE;
                case EAST -> HEAD_EAST_STATE;
                case WEST -> HEAD_WEST_STATE;
                default -> VoxelShapes.fullCube();
            };
        }
        else if (part==BedPart.FOOT)
        {
            return switch (dir) {
                case NORTH -> FOOT_NORTH_STATE;
                case SOUTH -> FOOT_SOUTH_STATE;
                case EAST -> FOOT_EAST_STATE;
                case WEST -> FOOT_WEST_STATE;
                default -> VoxelShapes.fullCube();
            };
        }
        else
        {
            return VoxelShapes.fullCube();
        }
    }
}
