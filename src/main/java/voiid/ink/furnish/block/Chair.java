package voiid.ink.furnish.block;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import voiid.ink.furnish.entity.SeatEntity;
import voiid.ink.furnish.registry.ModEntities;


public class Chair extends HorizontalFacingBlock implements Waterloggable {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final BooleanProperty OCCUPIED;

    public Chair(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, false).with(OCCUPIED, false));
    }

    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult blockHitResult) {
        if (!blockState.get(OCCUPIED))
        {
            SeatEntity seat = ModEntities.SEAT_ENTITY_TYPE.create(world);
            Vec3d pos = new Vec3d(blockHitResult.getBlockPos().getX() + 0.5D, blockHitResult.getBlockPos().getY() + 0.25D, blockHitResult.getBlockPos().getZ() + 0.5D);

            world.setBlockState(blockPos, blockState.with(OCCUPIED, true));
            seat.updatePosition(pos.getX(), pos.getY(), pos.getZ());

            world.spawnEntity(seat);
            playerEntity.startRiding(seat);
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED, OCCUPIED);
    }

    private static final VoxelShape NORTH_STATE = VoxelShapes.union(
            //Legs
            VoxelShapes.cuboid(1/16f, 0/16f, 1/16f, 5/16f, 6/16f, 5/16f),
            VoxelShapes.cuboid(11/16f, 0/16f, 1/16f, 15/16f, 6/16f, 5/16f),
            VoxelShapes.cuboid(1/16f, 0/16f, 11/16f, 5/16f, 6/16f, 15/16f),
            VoxelShapes.cuboid(11/16f, 0/16f, 11/16f, 15/16f, 6/16f, 15/16f),
            //Seat
            VoxelShapes.cuboid(1/16f, 6/16f, 1/16f, 15/16f, 10/16f, 15/16f),
            //Back
            VoxelShapes.cuboid(1/16f, 6/16f, 11/16f, 15/16f, 21/16f, 15/16f));

    private static final VoxelShape SOUTH_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(1/16f, 0/16f, 1/16f, 5/16f, 6/16f, 5/16f),
            VoxelShapes.cuboid(11/16f, 0/16f, 1/16f, 15/16f, 6/16f, 5/16f),
            VoxelShapes.cuboid(1/16f, 0/16f, 11/16f, 5/16f, 6/16f, 15/16f),
            VoxelShapes.cuboid(11/16f, 0/16f, 11/16f, 15/16f, 6/16f, 15/16f),
            //Seat
            VoxelShapes.cuboid(1/16f, 6/16f, 1/16f, 15/16f, 10/16f, 15/16f),
            //Back
            VoxelShapes.cuboid(1/16f, 6/16f, 1/16f, 15/16f, 21/16f, 5/16f));

    private static final VoxelShape EAST_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(1/16f, 0/16f, 1/16f, 5/16f, 6/16f, 5/16f),
            VoxelShapes.cuboid(11/16f, 0/16f, 1/16f, 15/16f, 6/16f, 5/16f),
            VoxelShapes.cuboid(1/16f, 0/16f, 11/16f, 5/16f, 6/16f, 15/16f),
            VoxelShapes.cuboid(11/16f, 0/16f, 11/16f, 15/16f, 6/16f, 15/16f),
            //Seat
            VoxelShapes.cuboid(1/16f, 6/16f, 1/16f, 15/16f, 10/16f, 15/16f),
            //Back
            VoxelShapes.cuboid(1/16f, 6/16f, 1/16f, 5/16f, 21/16f, 15/16f));

    private static final VoxelShape WEST_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(1/16f, 0/16f, 1/16f, 5/16f, 6/16f, 5/16f),
            VoxelShapes.cuboid(11/16f, 0/16f, 1/16f, 15/16f, 6/16f, 5/16f),
            VoxelShapes.cuboid(1/16f, 0/16f, 11/16f, 5/16f, 6/16f, 15/16f),
            VoxelShapes.cuboid(11/16f, 0/16f, 11/16f, 15/16f, 6/16f, 15/16f),
            //Seat
            VoxelShapes.cuboid(1/16f, 6/16f, 1/16f, 15/16f, 10/16f, 15/16f),
            //Back
            VoxelShapes.cuboid(11/16f, 6/16f, 1/16f, 15/16f, 21/16f, 15/16f));


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {

        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                return NORTH_STATE;
            case SOUTH:
                return SOUTH_STATE;
            case EAST:
                return EAST_STATE;
            case WEST:
                return WEST_STATE;
            default:
                return VoxelShapes.fullCube();
        }
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    static {
        OCCUPIED = Properties.OCCUPIED;
    }
}