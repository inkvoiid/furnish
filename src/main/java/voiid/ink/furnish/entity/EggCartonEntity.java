package voiid.ink.furnish.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import voiid.ink.furnish.registry.ModEntities;

public class EggCartonEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(12, ItemStack.EMPTY);


    public EggCartonEntity(BlockPos pos, BlockState state) {
        super(ModEntities.EGG_CARTON_ENTITY, pos, state);
    }

    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public void addItem(ItemStack itemStack){
        for (int i = 0; i < size(); i++) {
            ItemStack slot = getStack(i);
            if (!slot.isEmpty()) {
                slot.setCount(1);
            }
            else
            {
                inventory.add(itemStack);
            }
        }
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

}
