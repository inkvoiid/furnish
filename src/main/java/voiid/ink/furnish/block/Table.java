package voiid.ink.furnish.block;

import net.minecraft.block.*;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class Table extends Block implements Waterloggable {

    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    public static final Map<Direction, BooleanProperty> propertyMap;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    static {
        NORTH = Properties.NORTH;
        EAST = Properties.EAST;
        SOUTH = Properties.SOUTH;
        WEST = Properties.WEST;
        propertyMap = new HashMap<>();
        propertyMap.put(Direction.NORTH, Properties.NORTH);
        propertyMap.put(Direction.SOUTH, Properties.SOUTH);
        propertyMap.put(Direction.EAST, Properties.EAST);
        propertyMap.put(Direction.WEST, Properties.WEST);
    }

    public Table(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(NORTH, false).with(EAST, false).with(SOUTH, false).with(WEST, false).with(WATERLOGGED, false));
    }

    protected boolean canConnect(WorldAccess world, BlockPos neighborPos) {
        return world.getBlockState(neighborPos).getBlock().equals(this);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos pos = ctx.getBlockPos();

        return getDefaultState()
                .with(NORTH, canConnect(world, pos.north()))
                .with(SOUTH, canConnect(world, pos.south()))
                .with(EAST, canConnect(world, pos.east()))
                .with(WEST, canConnect(world, pos.west()));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH, EAST, WEST, SOUTH, WATERLOGGED);
    }
    private static final VoxelShape NORTH_STATE = VoxelShapes.union(
            //Legs
            VoxelShapes.cuboid(0f, 0f, 0.75f, 0.25f, 0.75f, 1.0f),
            VoxelShapes.cuboid(0.75f, 0f, 0.75f, 1.0f, 0.75f, 1.0f),
            //Seat
            VoxelShapes.cuboid(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f));

    private static final VoxelShape SOUTH_STATE = VoxelShapes.union(
            //Legs
            VoxelShapes.cuboid(0f, 0f, 0f, 0.25f, 0.75f, 0.25f),
            VoxelShapes.cuboid(0.75f, 0f, 0f, 1.0f, 0.75f, 0.25f),
            //Seat
            VoxelShapes.cuboid(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f));

    private static final VoxelShape EAST_STATE = VoxelShapes.union(
            //Legs
            VoxelShapes.cuboid(0f, 0f, 0f, 0.25f, 0.75f, 0.25f),
            VoxelShapes.cuboid(0f, 0f, 0.75f, 0.25f, 0.75f, 1.0f),
            //Seat
            VoxelShapes.cuboid(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f));

    private static final VoxelShape WEST_STATE = VoxelShapes.union(
            //Legs
            VoxelShapes.cuboid(0.75f, 0f, 0f, 1.0f, 0.75f, 0.25f),
            VoxelShapes.cuboid(0.75f, 0f, 0.75f, 1.0f, 0.75f, 1.0f),
            //Seat
            VoxelShapes.cuboid(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f));

    private static final VoxelShape NORTH_EAST_STATE = VoxelShapes.union(
            //Legs
            VoxelShapes.cuboid(0f, 0f, 0.75f, 0.25f, 0.75f, 1.0f),
            //Seat
            VoxelShapes.cuboid(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f));

    private static final VoxelShape NORTH_WEST_STATE = VoxelShapes.union(
            //Legs
            VoxelShapes.cuboid(0.75f, 0f, 0.75f, 1.0f, 0.75f, 1.0f),
            //Seat
            VoxelShapes.cuboid(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f));

    private static final VoxelShape SOUTH_EAST_STATE = VoxelShapes.union(
            //Legs
            VoxelShapes.cuboid(0f, 0f, 0f, 0.25f, 0.75f, 0.25f),
            //Seat
            VoxelShapes.cuboid(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f));

    private static final VoxelShape SOUTH_WEST_STATE = VoxelShapes.union(
            //Legs
            VoxelShapes.cuboid(0.75f, 0f, 0f, 1.0f, 0.75f, 0.25f),
            //Seat
            VoxelShapes.cuboid(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f));

    private static final VoxelShape DEFAULT_STATE = VoxelShapes.union(
            //Legs
            VoxelShapes.cuboid(0f, 0f, 0f, 0.25f, 0.75f, 0.25f),
            VoxelShapes.cuboid(0.75f, 0f, 0f, 1.0f, 0.75f, 0.25f),
            VoxelShapes.cuboid(0f, 0f, 0.75f, 0.25f, 0.75f, 1.0f),
            VoxelShapes.cuboid(0.75f, 0f, 0.75f, 1.0f, 0.75f, 1.0f),
            //Seat
            VoxelShapes.cuboid(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f));

    private static final VoxelShape NO_LEG_STATE = VoxelShapes.cuboid(0f, 0.75f, 0f, 1.0f, 1.0f, 1.0f);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {


        if (state.get(NORTH) & !state.get(SOUTH) & !state.get(EAST) & !state.get(WEST)) {
            return NORTH_STATE;
        }
        else if (state.get(SOUTH) & !state.get(NORTH) & !state.get(EAST) & !state.get(WEST)) {
            return SOUTH_STATE;
        }
        if (state.get(EAST) & !state.get(NORTH) & !state.get(SOUTH)& !state.get(WEST)) {
            return EAST_STATE;
        }
        else if (state.get(WEST) & !state.get(NORTH) & !state.get(SOUTH) & !state.get(EAST)) {
            return WEST_STATE;
        }
        else if (state.get(NORTH) & !state.get(SOUTH) & state.get(EAST) & !state.get(WEST)) {
            return NORTH_EAST_STATE;
        }
        else if (state.get(NORTH) & !state.get(SOUTH) & !state.get(EAST) & state.get(WEST)) {
            return NORTH_WEST_STATE;
        }
        else if (state.get(SOUTH) & !state.get(NORTH) & state.get(EAST) & !state.get(WEST)) {
            return SOUTH_EAST_STATE;
        }
        else if (state.get(SOUTH) & !state.get(NORTH) & !state.get(EAST) & state.get(WEST)) {
            return SOUTH_WEST_STATE;
        }
        else if (!state.get(NORTH) & !state.get(SOUTH) & !state.get(EAST) & !state.get(WEST)){
            return DEFAULT_STATE;
        }
        else {
            return NO_LEG_STATE;
        }

    }



    public BlockState getStateForNeighborUpdate(
            BlockState state,
            Direction facing,
            BlockState neighborState,
            WorldAccess world,
            BlockPos pos,
            BlockPos neighborPos
    ) {
        BooleanProperty direction = propertyMap.get(facing);
        if (!state.canPlaceAt(world, pos)) return Blocks.AIR.getDefaultState();
        return direction == null ? state : state.with(direction, canConnect(world, neighborPos));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }
}
