package voiid.ink.furnish.block;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import voiid.ink.furnish.entity.MailboxEntity;

public class Mailbox extends RotatableWaterloggableBlockWithEntity{
    public Mailbox(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MailboxEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        //With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need to change that!
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient) {
            //This will call the createScreenHandlerFactory method from BlockWithEntity, which will return our blockEntity casted to
            //a namedScreenHandlerFactory. If your block class does not extend BlockWithEntity, it needs to implement createScreenHandlerFactory.
            NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

            if (screenHandlerFactory != null) {
                //With this call the server will request the client to open the appropriate Screenhandler
                player.openHandledScreen(screenHandlerFactory);
            }
        }
        return ActionResult.SUCCESS;
    }

    //This method will drop all items onto the ground when the block is broken
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof MailboxEntity) {
                ItemScatterer.spawn(world, pos, (MailboxEntity)blockEntity);
                // update comparators
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    private static final VoxelShape NORTH_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(3 / 16f, 0f, 2 / 16f, 13 / 16f, 9 / 16f, 14 / 16f));

    private static final VoxelShape SOUTH_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(3 / 16f, 0f, 2 / 16f, 13 / 16f, 9 / 16f, 14 / 16f));

    private static final VoxelShape EAST_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(2 / 16f, 0f, 3 / 16f, 14 / 16f, 9 / 16f, 13 / 16f));

    private static final VoxelShape WEST_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(2 / 16f, 0f, 3 / 16f, 14 / 16f, 9 / 16f, 13 / 16f));

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
