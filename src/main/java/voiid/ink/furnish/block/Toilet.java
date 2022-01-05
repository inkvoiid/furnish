package voiid.ink.furnish.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
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

import static voiid.ink.furnish.registry.ModEntities.SEAT_ENTITY_TYPE;

public class Toilet extends HorizontalFacingBlock {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty OCCUPIED;

    public Toilet(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(OCCUPIED, false));
    }

    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity playerEntity, Hand hand, BlockHitResult blockHitResult) {
        if (!blockState.get(OCCUPIED))
        {
            SeatEntity seat = SEAT_ENTITY_TYPE.create(world);
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
        builder.add(FACING, OCCUPIED);
    }

    private static final VoxelShape NORTH_STATE = VoxelShapes.union(
            //Platform
            VoxelShapes.cuboid(2/16f, 0f, 0/16f, 13/16f, 2/16f, 13/16f),
            VoxelShapes.cuboid(4/16f, 2/16f, 2/16f, 12/16f, 7/16f, 11/16f),
            //Seat
            VoxelShapes.cuboid(2/16f, 7/16f, 0/16f, 14/16f, 10/16f, 3/16f),
            VoxelShapes.cuboid(2/16f, 7/16f, 0/16f, 5/16f, 10/16f, 9/16f),
            VoxelShapes.cuboid(11/16f, 7/16f, 0/16f, 14/16f, 10/16f, 9/16f),
            VoxelShapes.cuboid(2/16f, 7/16f, 9/16f, 14/16f, 10/16f, 12/16f),
            //Pipe
            VoxelShapes.cuboid(7/16f, 5/16f, 10/16f, 9/16f, 7/16f, 14/16f),
            VoxelShapes.cuboid(7/16f, 7/16f, 12/16f, 9/16f, 11/16f, 14/16f),
            //Box
            VoxelShapes.cuboid(2/16f, 11/16f, 11/16f, 14/16f, 19/16f, 15/16f),
            VoxelShapes.cuboid(1/16f, 19/16f, 10/16f, 15/16f, 22/16f, 16/16f));

    private static final VoxelShape SOUTH_STATE = VoxelShapes.union(
            //Platform
            VoxelShapes.cuboid(2/16f, 0f, 3/16f, 14/16f, 2/16f, 16/16f),
            //Trunk
            VoxelShapes.cuboid(4/16f, 2/16f, 5/16f, 12/16f, 7/16f, 14/16f),
            //Seat
            VoxelShapes.cuboid(2/16f, 7/16f, 13/16f, 14/16f, 10/16f, 16/16f),
            VoxelShapes.cuboid(2/16f, 7/16f, 7/16f, 5/16f, 10/16f, 14/16f),
            VoxelShapes.cuboid(11/16f, 7/16f, 7/16f, 14/16f, 10/16f, 14/16f),
            VoxelShapes.cuboid(2/16f, 7/16f, 4/16f, 14/16f, 10/16f, 7/16f),
            //Pipe
            VoxelShapes.cuboid(7/16f, 5/16f, 2/16f, 9/16f, 7/16f, 5/16f),
            VoxelShapes.cuboid(7/16f, 7/16f, 2/16f, 9/16f, 11/16f, 4/16f),
            //Box
            VoxelShapes.cuboid(2/16f, 11/16f, 1/16f, 14/16f, 19/16f, 5/16f),
            VoxelShapes.cuboid(1/16f, 19/16f, 0/16f, 15/16f, 22/16f, 6/16f));

    private static final VoxelShape EAST_STATE = VoxelShapes.union(
            //Platform
            VoxelShapes.cuboid(3/16f, 0f, 2/16f, 16/16f, 2/16f, 14/16f),
            //Trunk
            VoxelShapes.cuboid(5/16f, 2/16f, 4/16f, 14/16f, 7/16f, 12/16f),
            //Seat
            VoxelShapes.cuboid(13/16f, 7/16f, 2/16f, 16/16f, 10/16f, 14/16f),
            VoxelShapes.cuboid(7/16f, 7/16f, 2/16f, 14/16f, 10/16f, 5/16f),
            VoxelShapes.cuboid(7/16f, 7/16f, 11/16f, 14/16f, 10/16f, 14/16f),
            VoxelShapes.cuboid(4/16f, 7/16f, 2/16f, 7/16f, 10/16f, 14/16f),
            //Pipe
            VoxelShapes.cuboid(2/16f, 5/16f, 7/16f, 5/16f, 7/16f, 9/16f),
            VoxelShapes.cuboid(2/16f, 7/16f, 7/16f, 4/16f, 11/16f, 9/16f),
            //Box
            VoxelShapes.cuboid(1/16f, 11/16f, 2/16f, 5/16f, 19/16f, 14/16f),
            VoxelShapes.cuboid(0/16f, 19/16f, 1/16f, 6/16f, 22/16f, 15/16f));

    private static final VoxelShape WEST_STATE = VoxelShapes.union(
            //Platform
            VoxelShapes.cuboid(0/16f, 0f, 3/16f, 13/16f, 2/16f, 14/16f),
            VoxelShapes.cuboid(2/16f, 2/16f, 4/16f, 11/16f, 7/16f, 12/16f),
            //Seat
            VoxelShapes.cuboid(0/16f, 7/16f, 2/16f, 2/16f, 10/16f, 14/16f),
            VoxelShapes.cuboid(0/16f, 7/16f, 2/16f, 9/16f, 10/16f, 5/16f),
            VoxelShapes.cuboid(0/16f, 7/16f, 11/16f, 9/16f, 10/16f, 14/16f),
            VoxelShapes.cuboid(9/16f, 7/16f, 2/16f, 12/16f, 10/16f, 14/16f),
            //Pipe
            VoxelShapes.cuboid(10/16f, 5/16f, 7/16f, 14/16f, 7/16f, 9/16f),
            VoxelShapes.cuboid(12/16f, 7/16f, 7/16f, 14/16f, 11/16f, 9/16f),
            //Box
            VoxelShapes.cuboid(11/16f, 11/16f, 2/16f, 15/16f, 19/16f, 14/16f),
            VoxelShapes.cuboid(10/16f, 19/16f, 1/16f, 16/16f, 22/16f, 15/16f));

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction dir = state.get(FACING);
        return switch (dir) {
            case NORTH -> NORTH_STATE;
            case SOUTH -> SOUTH_STATE;
            case EAST -> EAST_STATE;
            case WEST -> WEST_STATE;
            default -> VoxelShapes.fullCube();
        };
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    static {
        OCCUPIED = Properties.OCCUPIED;
    }
}
