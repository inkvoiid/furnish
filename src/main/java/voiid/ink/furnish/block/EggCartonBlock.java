package voiid.ink.furnish.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.CampfireBlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
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
import voiid.ink.furnish.entity.EggCartonEntity;

import java.util.List;
import java.util.function.Consumer;

public class EggCartonBlock extends RotatableBlock{
    public static final IntProperty EGGS;
    public EggCartonBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(FACING, Direction.NORTH).with(EGGS, 0));
    }

    @Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("block.furnish.egg_carton.tooltip"));
    }

    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return (Integer)state.get(EGGS);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if(blockEntity instanceof EggCartonEntity){
            EggCartonEntity eggCartonEntity = (EggCartonEntity)blockEntity;
            ItemStack itemStack = player.getStackInHand(hand);
                if (itemStack.getItem() == Items.EGG) {
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                    itemStack.decrement(1);
                    eggCartonEntity.addItem(itemStack);
                    return ActionResult.success(world.isClient);
                }
                else {
                    world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                    dropStack(world, pos, new ItemStack(Items.EGG, 1));
                    return ActionResult.success(world.isClient);
                }
        }
        return ActionResult.PASS;
    }

    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.isOf(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof EggCartonEntity) {
                ItemScatterer.spawn(world, pos, ((EggCartonEntity)blockEntity).getItems());
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    private static final VoxelShape WEST_STATE = VoxelShapes.cuboid(4/16f, 0/16f, 0/16f, 13/16f, 5/16f, 16/16f);

    private static final VoxelShape EAST_STATE = VoxelShapes.cuboid(3/16f, 0/16f, 0/16f, 12/16f, 5/16f, 16/16f);

    private static final VoxelShape SOUTH_STATE = VoxelShapes.cuboid(0/16f, 0/16f, 3/16f, 16/16f, 5/16f, 12/16f);

    private static final VoxelShape NORTH_STATE = VoxelShapes.cuboid(0/16f, 0/16f, 4/16f, 16/16f, 5/16f, 13/16f);

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
@Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, EGGS);
    }

    static {
        EGGS = IntProperty.of("eggs",0,12);
    }
}
