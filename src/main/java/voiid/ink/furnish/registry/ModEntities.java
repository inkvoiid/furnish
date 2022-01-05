package voiid.ink.furnish.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import voiid.ink.furnish.Furnish;
import voiid.ink.furnish.entity.*;

public class ModEntities {
    // Block Entities
    public static BlockEntityType<MailboxEntity> MAILBOX_ENTITY;
    public static BlockEntityType<EggCartonEntity> EGG_CARTON_ENTITY;
    public static BlockEntityType<CeilingFanEntity> CEILING_FAN_ENTITY;
    public static BlockEntityType<ClockEntity> CLOCK_ENTITY;

    // Entities
    public static EntityType<SeatEntity> SEAT_ENTITY_TYPE = FabricEntityTypeBuilder.create(SpawnGroup.MISC, SeatEntity::new)
        .dimensions(EntityDimensions.fixed(0.001F, 0.225F))
        .disableSummon()
        .trackRangeChunks(10)
        .build();

    public static void registerEntities(){

        // Block Entities
        MAILBOX_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Furnish.MOD_ID, "white_mailbox"), FabricBlockEntityTypeBuilder.create(MailboxEntity::new, ModBlocks.WHITE_MAILBOX).build(null));
        EGG_CARTON_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Furnish.MOD_ID, "egg_carton"), FabricBlockEntityTypeBuilder.create(EggCartonEntity::new, ModBlocks.EGG_CARTON).build(null));
        CLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Furnish.MOD_ID, "clock_entity"), FabricBlockEntityTypeBuilder.create(ClockEntity::new, ModBlocks.ALARM_CLOCK).build(null));
        CEILING_FAN_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Furnish.MOD_ID, "ceiling_fan"), FabricBlockEntityTypeBuilder.create(CeilingFanEntity::new, ModBlocks.WOODEN_CEILING_FAN).build(null));

        // Entities
        SEAT_ENTITY_TYPE = Registry.register(Registry.ENTITY_TYPE, new Identifier(Furnish.MOD_ID, "sit"), SEAT_ENTITY_TYPE);
    }
}
