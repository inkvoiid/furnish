package voiid.ink.furnish.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import voiid.ink.furnish.Furnish;
import voiid.ink.furnish.registry.ModEntities;

public class ClockEntity extends BlockEntity {
    public ClockEntity(BlockPos pos, BlockState state) {
        super(ModEntities.CLOCK_ENTITY, pos, state);
    }
}
