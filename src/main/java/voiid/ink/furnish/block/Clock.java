package voiid.ink.furnish.block;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import voiid.ink.furnish.entity.ClockEntity;

public class Clock extends RotatableWaterloggableBlock implements BlockEntityProvider {
    public Clock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ClockEntity(pos, state);
    }

    private static final VoxelShape NORTH_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(0.125f, 0f, 0.25f, 0.875f, 0.375f, 0.75f),
            VoxelShapes.cuboid(0.1875f, 0.0625f, 0.1875f, 0.8125f, 0.3125f, 0.25f),
            VoxelShapes.cuboid(0.25f, 0.375f, 0.375f, 0.75f, 0.4375f, 0.625f));

    private static final VoxelShape SOUTH_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(0.125f, 0f, 0.25f, 0.875f, 0.375f, 0.75f),
            VoxelShapes.cuboid(0.1875f, 0.0625f, 0.75f, 0.8125f, 0.3125f, 0.8125f),
            VoxelShapes.cuboid(0.25f, 0.375f, 0.375f, 0.75f, 0.4375f, 0.625f));

    private static final VoxelShape EAST_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(0.25f, 0f, 0.125f, 0.75f, 0.375f, 0.875f),
            VoxelShapes.cuboid(0.75f, 0.0625f, 0.1875f, 0.8125f, 0.3125f, 0.8125f),
            VoxelShapes.cuboid(0.375f, 0.375f, 0.25f, 0.625f, 0.4375f, 0.75f));

    private static final VoxelShape WEST_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(0.25f, 0f, 0.125f, 0.75f, 0.375f, 0.875f),
            VoxelShapes.cuboid(0.1875f, 0.0625f, 0.1875f, 0.25f, 0.3125f, 0.8125f),
            VoxelShapes.cuboid(0.375f, 0.375f, 0.25f, 0.625f, 0.4375f, 0.75f));

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
}