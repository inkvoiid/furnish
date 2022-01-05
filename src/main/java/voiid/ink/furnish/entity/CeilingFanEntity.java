package voiid.ink.furnish.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import voiid.ink.furnish.Furnish;
import voiid.ink.furnish.registry.ModEntities;

public class CeilingFanEntity extends BlockEntity {
    public CeilingFanEntity(BlockPos pos, BlockState state) {
        super(ModEntities.CEILING_FAN_ENTITY, pos ,state);
    }
}
