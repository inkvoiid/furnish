package voiid.ink.furnish.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class WindowBox extends Block {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public WindowBox(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {

        Direction dir = state.get(FACING);
        switch(dir) {
            case NORTH:
                return VoxelShapes.union(
                        VoxelShapes.cuboid(1/16f, 8/16f, 8/16f, 16/16f, 16/16f, 16/16f));
            case SOUTH:
                return VoxelShapes.union(
                        VoxelShapes.cuboid(1/16f, 8/16f, 8/16f, 16/16f, 16/16f, 16/16f));
            case EAST:
                return VoxelShapes.union(
                        VoxelShapes.cuboid(1/16f, 8/16f, 8/16f, 16/16f, 16/16f, 16/16f));
            case WEST:
                return VoxelShapes.union(
                        VoxelShapes.cuboid(1/16f, 8/16f, 8/16f, 16/16f, 16/16f, 16/16f));
            default:
                return VoxelShapes.fullCube();
        }
    }
}
