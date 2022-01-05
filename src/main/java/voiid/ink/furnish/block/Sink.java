package voiid.ink.furnish.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BannerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Sink extends RotatableBlock {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public Sink(Settings settings) {
        super(settings);
    }

    private static final VoxelShape NORTH_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(1/16f, 0f, 1/16f, 15/16f, 1/16f, 14/16f),
            VoxelShapes.cuboid(1/16f, 1/16f, 1/16f, 15/16f, 5/16f, 2/16f),
            VoxelShapes.cuboid(1/16f, 1/16f, 2/16f, 2/16f, 5/16f, 13/16f),
            VoxelShapes.cuboid(14/16f, 1/16f, 2/16f, 15/16f, 5/16f, 13/16f),
            VoxelShapes.cuboid(1/16f, 1/16f, 12/16f, 15/16f, 5/16f, 14/16f),
            VoxelShapes.cuboid(7/16f, 5/16f, 12/16f, 9/16f, 9/16f, 14/16f),
            VoxelShapes.cuboid(7/16f, 7/16f, 8/16f, 9/16f, 9/16f, 12/16f));

    private static final VoxelShape SOUTH_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(1/16f, 0f, 2/16f, 15/16f, 1/16f, 15/16f),
            VoxelShapes.cuboid(1/16f, 1/16f, 14/16f, 15/16f, 5/16f, 15/16f),
            VoxelShapes.cuboid(14/16f, 1/16f, 4/16f, 15/16f, 5/16f, 15/16f),
            VoxelShapes.cuboid(1/16f, 1/16f, 4/16f, 15/16f, 5/16f, 14/16f),
            VoxelShapes.cuboid(1/16f, 1/16f, 2/16f, 15/16f, 5/16f, 4/16f),
            VoxelShapes.cuboid(7/16f, 5/16f, 2/16f, 9/16f, 9/16f, 4/16f),
            VoxelShapes.cuboid(7/16f, 7/16f, 4/16f, 9/16f, 9/16f, 8/16f));

    private static final VoxelShape EAST_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(2/16f, 0f, 1/16f, 15/16f, 1/16f, 15/16f),
            VoxelShapes.cuboid(14/16f, 1/16f, 1/16f, 15/16f, 5/16f, 15/16f),
            VoxelShapes.cuboid(4/16f, 1/16f, 14/16f, 15/16f, 5/16f, 15/16f),
            VoxelShapes.cuboid(4/16f, 1/16f, 1/16f, 14/16f, 5/16f, 15/16f),
            VoxelShapes.cuboid(2/16f, 1/16f, 1/16f, 4/16f, 5/16f, 15/16f),
            VoxelShapes.cuboid(2/16f, 5/16f, 7/16f, 4/16f, 9/16f, 9/16f),
            VoxelShapes.cuboid(4/16f, 7/16f, 7/16f, 8/16f, 9/16f, 9/16f));

    private static final VoxelShape WEST_STATE = VoxelShapes.union(
            VoxelShapes.cuboid(1/16f, 0f, 1/16f, 14/16f, 1/16f, 15/16f),
            VoxelShapes.cuboid(1/16f, 1/16f, 1/16f, 2/16f, 5/16f, 15/16f),
            VoxelShapes.cuboid(2/16f, 1/16f, 1/16f, 13/16f, 5/16f, 2/16f),
            VoxelShapes.cuboid(2/16f, 1/16f, 14/16f, 13/16f, 5/16f, 15/16f),
            VoxelShapes.cuboid(12/16f, 1/16f, 1/16f, 14/16f, 5/16f, 15/16f),
            VoxelShapes.cuboid(12/16f, 5/16f, 7/16f, 14/16f, 9/16f, 9/16f),
            VoxelShapes.cuboid(8/16f, 7/16f, 7/16f, 12/16f, 9/16f, 9/16f));

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

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.isEmpty()) {
            return ActionResult.PASS;
        }
        else {
            Item item = itemStack.getItem();
            if (item == Items.WATER_BUCKET) {
                if (!world.isClient) {
                    if (!player.getAbilities().creativeMode) {
                        player.setStackInHand(hand, new ItemStack(Items.BUCKET));
                    }

                    world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return ActionResult.success(world.isClient);
            }
            else if (item == Items.BUCKET) {
                if (!world.isClient) {
                    if (!player.getAbilities().creativeMode) {
                        itemStack.decrement(1);
                        if (itemStack.isEmpty()) {
                            player.setStackInHand(hand, new ItemStack(Items.WATER_BUCKET));
                        } else if (!player.getInventory().insertStack(new ItemStack(Items.WATER_BUCKET))) {
                            player.dropItem(new ItemStack(Items.WATER_BUCKET), false);
                        }
                    }

                    world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                }

                return ActionResult.success(world.isClient);
            }
            else {
                ItemStack itemStack4;
                if (item == Items.GLASS_BOTTLE) {
                    if (!world.isClient) {
                        if (!player.getAbilities().creativeMode) {
                            itemStack4 = PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.WATER);
                            itemStack.decrement(1);
                            if (itemStack.isEmpty()) {
                                player.setStackInHand(hand, itemStack4);
                            } else if (!player.getInventory().insertStack(itemStack4)) {
                                player.dropItem(itemStack4, false);
                            }
                        }

                        world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    }

                    return ActionResult.success(world.isClient);
                }
                else if (item == Items.POTION && PotionUtil.getPotion(itemStack) == Potions.WATER) {
                    if (!world.isClient) {
                        if (!player.getAbilities().creativeMode) {
                            itemStack4 = new ItemStack(Items.GLASS_BOTTLE);
                            player.incrementStat(Stats.USE_CAULDRON);
                            player.setStackInHand(hand, itemStack4);
                        }

                        world.playSound((PlayerEntity)null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    }

                    return ActionResult.success(world.isClient);
                }
                else {
                    if (item instanceof DyeableItem) {
                        DyeableItem dyeableItem = (DyeableItem)item;
                        if (dyeableItem.hasColor(itemStack) && !world.isClient) {
                            dyeableItem.removeColor(itemStack);
                            player.incrementStat(Stats.CLEAN_ARMOR);
                            return ActionResult.SUCCESS;
                        }
                    }

                    if (item instanceof BannerItem) {
                        if (BannerBlockEntity.getPatternCount(itemStack) > 0 && !world.isClient) {
                            itemStack4 = itemStack.copy();
                            itemStack4.setCount(1);
                            BannerBlockEntity.loadFromItemStack(itemStack4);
                            player.incrementStat(Stats.CLEAN_BANNER);
                            if (!player.getAbilities().creativeMode) {
                                itemStack.decrement(1);
                            }

                            if (itemStack.isEmpty()) {
                                player.setStackInHand(hand, itemStack4);
                            } else if (!player.getInventory().insertStack(itemStack4)) {
                                player.dropItem(itemStack4, false);
                            } //else if (player instanceof ServerPlayerEntity) {
                                //((ServerPlayerEntity)player).refreshScreenHandler(player.playerScreenHandler);
                            //}
                        }

                        return ActionResult.success(world.isClient);
                    }
                    else if (item instanceof BlockItem) {
                        Block block = ((BlockItem)item).getBlock();
                        if (block instanceof ShulkerBoxBlock && !world.isClient()) {
                            ItemStack itemStack5 = new ItemStack(Blocks.SHULKER_BOX, 1);
                            if (itemStack.hasNbt()) {
                                itemStack5.setNbt(itemStack.getNbt().copy());
                            }

                            player.setStackInHand(hand, itemStack5);
                            player.incrementStat(Stats.CLEAN_SHULKER_BOX);
                            return ActionResult.SUCCESS;
                        }
                        else {
                            return ActionResult.CONSUME;
                        }
                    }
                    else {
                        return ActionResult.PASS;
                    }
                }
            }
        }
    }
}
