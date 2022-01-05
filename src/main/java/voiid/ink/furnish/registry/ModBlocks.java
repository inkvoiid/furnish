package voiid.ink.furnish.registry;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import voiid.ink.furnish.Furnish;
import voiid.ink.furnish.block.*;

public class ModBlocks {

    public static final Block OAK_BOARDS = new Block(FabricBlockSettings.of(Material.WOOD).strength(5.0f, 25.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block DUNGEON_CAGED_LANTERN = new Block(FabricBlockSettings.of(Material.METAL).strength(2.0f, 10.0f).sounds(BlockSoundGroup.METAL).luminance(15).nonOpaque());
    public static final Block DUNGEON_CAGED_SOUL_LANTERN = new Block(FabricBlockSettings.of(Material.METAL).strength(2.0f, 10.0f).sounds(BlockSoundGroup.METAL).luminance(15).nonOpaque());
    public static final Clock ALARM_CLOCK = new Clock(FabricBlockSettings.of(Material.METAL).strength(2.0f, 10.0f).sounds(BlockSoundGroup.METAL));
    public static final WindowBox CLAY_WINDOW_BOX = new WindowBox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final CeilingFan WOODEN_CEILING_FAN = new CeilingFan(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS));

    public static final Sink WHITE_SINK = new Sink(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Sink GRAY_SINK = new Sink(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Toilet TOILET = new Toilet(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Toilet GOLD_TOILET = new Toilet(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.METAL));
    public static final Bathtub BATHTUB = new Bathtub(FabricBlockSettings.copyOf(Blocks.QUARTZ_BLOCK));

    public static final FlowerBlock ROSE = new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.of(Material.SOIL).breakInstantly().sounds(BlockSoundGroup.GRASS).collidable(false));
    public static final FlowerBlock CYAN_ROSE = new FlowerBlock(StatusEffects.REGENERATION, 5, FabricBlockSettings.of(Material.SOIL).breakInstantly().sounds(BlockSoundGroup.GRASS).collidable(false));
    public static final FlowerPotBlock POTTED_ROSE = new FlowerPotBlock(ROSE,FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final FlowerPotBlock POTTED_CYAN_ROSE = new FlowerPotBlock(CYAN_ROSE,FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));

    public static final Sandcastle BUCKET_SANDCASTLE = new Sandcastle(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).strength(2.0f, 25.0f).sounds(BlockSoundGroup.SAND));
    public static final EggCartonBlock EGG_CARTON = new EggCartonBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).strength(2.0f, 10.0f).sounds(BlockSoundGroup.SCAFFOLDING));

    public static final Block BEIGE_WOOL = new Block(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL));
    public static final CarpetBlock BEIGE_CARPET = new CarpetBlock(FabricBlockSettings.copyOf(Blocks.WHITE_WOOL));
    public static final Rug BEIGE_RUG = new Rug(DyeColor.WHITE,FabricBlockSettings.copyOf(Blocks.WHITE_WOOL));

    public static final Rug WHITE_RUG = new Rug(DyeColor.WHITE,FabricBlockSettings.copyOf(Blocks.WHITE_CARPET));
    public static final Rug ORANGE_RUG = new Rug(DyeColor.ORANGE,FabricBlockSettings.copyOf(Blocks.ORANGE_CARPET));
    public static final Rug MAGENTA_RUG = new Rug(DyeColor.MAGENTA,FabricBlockSettings.copyOf(Blocks.MAGENTA_CARPET));
    public static final Rug LIGHT_BLUE_RUG = new Rug(DyeColor.LIGHT_BLUE,FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CARPET));
    public static final Rug YELLOW_RUG = new Rug(DyeColor.YELLOW,FabricBlockSettings.copyOf(Blocks.YELLOW_CARPET));
    public static final Rug LIME_RUG = new Rug(DyeColor.LIME,FabricBlockSettings.copyOf(Blocks.LIME_CARPET));
    public static final Rug PINK_RUG = new Rug(DyeColor.PINK,FabricBlockSettings.copyOf(Blocks.PINK_CARPET));
    public static final Rug GRAY_RUG = new Rug(DyeColor.GRAY,FabricBlockSettings.copyOf(Blocks.GRAY_CARPET));
    public static final Rug LIGHT_GRAY_RUG = new Rug(DyeColor.LIGHT_GRAY,FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CARPET));
    public static final Rug CYAN_RUG = new Rug(DyeColor.CYAN,FabricBlockSettings.copyOf(Blocks.CYAN_CARPET));
    public static final Rug PURPLE_RUG = new Rug(DyeColor.PURPLE,FabricBlockSettings.copyOf(Blocks.PURPLE_CARPET));
    public static final Rug BLUE_RUG = new Rug(DyeColor.BLUE,FabricBlockSettings.copyOf(Blocks.BLUE_CARPET));
    public static final Rug BROWN_RUG = new Rug(DyeColor.BROWN,FabricBlockSettings.copyOf(Blocks.BROWN_CARPET));
    public static final Rug GREEN_RUG = new Rug(DyeColor.GREEN,FabricBlockSettings.copyOf(Blocks.GREEN_CARPET));
    public static final Rug RED_RUG = new Rug(DyeColor.RED,FabricBlockSettings.copyOf(Blocks.RED_CARPET));
    public static final Rug BLACK_RUG = new Rug(DyeColor.BLACK,FabricBlockSettings.copyOf(Blocks.BLACK_CARPET));

    public static final SlabBlock RED_PILLOW = new SlabBlock(FabricBlockSettings.copyOf(Blocks.RED_WOOL));
    //todo Red Concrete Door
    //todo Red Couch
    //todo Red Table and Chairs
    //todo add more windows and door

    //Initialize Mailboxes

    //Concrete
    public static final Mailbox WHITE_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox ORANGE_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox MAGENTA_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox LIGHT_BLUE_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox YELLOW_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox LIME_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox PINK_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox GRAY_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox LIGHT_GRAY_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox CYAN_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox PURPLE_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox BLUE_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox BROWN_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox GREEN_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox RED_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));
    public static final Mailbox BLACK_MAILBOX = new Mailbox(FabricBlockSettings.of(Material.STONE).strength(2.0f, 25.0f).sounds(BlockSoundGroup.STONE));


    //Initialize Chairs

    //Wooden
    public static final Chair OAK_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS));
    public static final Chair SPRUCE_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS));
    public static final Chair BIRCH_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS));
    public static final Chair JUNGLE_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS));
    public static final Chair ACACIA_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS));
    public static final Chair DARK_OAK_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS));
    public static final Chair CRIMSON_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS));
    public static final Chair WARPED_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS));

    //Stone
    public static final Chair STONE_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.STONE));
    public static final Chair STONE_BRICK_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS));
    public static final Chair GRANITE_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE));
    public static final Chair DIORITE_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE));
    public static final Chair ANDESITE_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE));
    public static final Chair POLISHED_BLACKSTONE_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE));
    public static final Chair POLISHED_BLACKSTONE_BRICK_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Chair GILDED_BLACKSTONE_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.GILDED_BLACKSTONE));

    //Misc
    public static final Chair NETHER_BRICK_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.NETHER_BRICKS));
    public static final Chair PURPUR_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.PURPUR_BLOCK).luminance(7));
    public static final Chair PRISMARINE_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICKS));
    public static final Chair DARK_PRISMARINE_CHAIR = new Chair(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICKS));

    //Initialize Tables

    //Wooden
    public static final Table OAK_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS));
    public static final Table SPRUCE_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS));
    public static final Table BIRCH_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS));
    public static final Table JUNGLE_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS));
    public static final Table ACACIA_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS));
    public static final Table DARK_OAK_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS));
    public static final Table CRIMSON_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS));
    public static final Table WARPED_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS));

    //Stone
    public static final Table STONE_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.STONE));
    public static final Table STONE_BRICK_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.STONE_BRICKS));
    public static final Table GRANITE_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.POLISHED_GRANITE));
    public static final Table DIORITE_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.POLISHED_DIORITE));
    public static final Table ANDESITE_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.POLISHED_ANDESITE));
    public static final Table POLISHED_BLACKSTONE_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE));
    public static final Table POLISHED_BLACKSTONE_BRICK_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.POLISHED_BLACKSTONE_BRICKS));
    public static final Table GILDED_BLACKSTONE_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.GILDED_BLACKSTONE));

    //Misc
    public static final Table NETHER_BRICK_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.NETHER_BRICKS));
    public static final Table PURPUR_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.PURPUR_BLOCK).luminance(15));
    public static final Table PRISMARINE_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICKS));
    public static final Table DARK_PRISMARINE_TABLE = new Table(FabricBlockSettings.copyOf(Blocks.PRISMARINE_BRICKS));

    public static final String[] woodTypes = {"oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "crimson", "warped"};
    public static final String[] stoneTypes = {"stone", "stone_brick", "granite", "diorite", "andesite", "polished_blackstone", "polished_blackstone_brick", "gilded_blackstone"};
    public static final String[] miscTypes = {"nether_brick", "purpur", "prismarine", "dark_prismarine"};


    public static final Chair[] woodenChairs = {OAK_CHAIR, SPRUCE_CHAIR, BIRCH_CHAIR, JUNGLE_CHAIR, ACACIA_CHAIR, DARK_OAK_CHAIR, CRIMSON_CHAIR, WARPED_CHAIR};
    public static final Table[] woodenTables = {OAK_TABLE, SPRUCE_TABLE, BIRCH_TABLE, JUNGLE_TABLE, ACACIA_TABLE, DARK_OAK_TABLE, CRIMSON_TABLE, WARPED_TABLE};
    public static final Chair[] stoneChairs = {STONE_CHAIR, STONE_BRICK_CHAIR, GRANITE_CHAIR, DIORITE_CHAIR, ANDESITE_CHAIR, POLISHED_BLACKSTONE_CHAIR, POLISHED_BLACKSTONE_BRICK_CHAIR, GILDED_BLACKSTONE_CHAIR};
    public static final Table[] stoneTables = {STONE_TABLE, STONE_BRICK_TABLE, GRANITE_TABLE, DIORITE_TABLE, ANDESITE_TABLE, POLISHED_BLACKSTONE_TABLE, POLISHED_BLACKSTONE_BRICK_TABLE, GILDED_BLACKSTONE_TABLE};
    public static final Chair[] miscChairs = {NETHER_BRICK_CHAIR, PURPUR_CHAIR, PRISMARINE_CHAIR, DARK_PRISMARINE_CHAIR};
    public static final Table[] miscTables = {NETHER_BRICK_TABLE, PURPUR_TABLE, PRISMARINE_TABLE, DARK_PRISMARINE_TABLE};

    public static final String[] colors = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};

    public static final Mailbox[] mailboxes = {WHITE_MAILBOX, ORANGE_MAILBOX, MAGENTA_MAILBOX, LIGHT_BLUE_MAILBOX, YELLOW_MAILBOX, LIME_MAILBOX, PINK_MAILBOX,
            GRAY_MAILBOX, LIGHT_GRAY_MAILBOX, CYAN_MAILBOX, PURPLE_MAILBOX, BLUE_MAILBOX, BROWN_MAILBOX, GREEN_MAILBOX, RED_MAILBOX, BLACK_MAILBOX};

    public static final Rug[] rugs = {WHITE_RUG, ORANGE_RUG, MAGENTA_RUG, LIGHT_BLUE_RUG, YELLOW_RUG, LIME_RUG, PINK_RUG,
            GRAY_RUG, LIGHT_GRAY_RUG, CYAN_RUG, PURPLE_RUG, BLUE_RUG, BROWN_RUG, GREEN_RUG, RED_RUG, BLACK_RUG};

    public static final String[] bathroomFurnitureIds = {"white_sink", "gray_sink", "toilet", "gold_toilet", "bathtub"};
    public static final Block[] bathroomFurniture = {WHITE_SINK, GRAY_SINK, TOILET, GOLD_TOILET, BATHTUB};

    public static void registerBlock(String path, Block block) {
        Registry.register(Registry.BLOCK, new Identifier(Furnish.MOD_ID, path), block);
    }

    public static void registerBlocks() {
        //Wooden Furniture
        for(int i = 0; i < woodTypes.length; i++) {
            registerBlock(woodTypes[i] + "_chair", woodenChairs[i]);
        }
        for(int i = 0; i < woodTypes.length; i++) {
            registerBlock(woodTypes[i] + "_table", woodenTables[i]);
        }
        //Stone Furniture
        for(int i = 0; i < stoneTypes.length; i++) {
            registerBlock(stoneTypes[i] + "_chair", stoneChairs[i]);
        }
        for(int i = 0; i < stoneTypes.length; i++) {
            registerBlock(stoneTypes[i] + "_table", stoneTables[i]);
        }
        //Misc Furniture
        for(int i = 0; i < miscTypes.length; i++) {
            registerBlock(miscTypes[i] + "_chair", miscChairs[i]);
        }
        for(int i = 0; i < miscTypes.length; i++) {
            registerBlock(miscTypes[i] + "_table", miscTables[i]);
        }
        //Colored Things
        for(int i = 0; i < colors.length; i++) {
            registerBlock(colors[i] + "_mailbox", mailboxes[i]);
        }
        for(int i = 0; i < colors.length; i++) {
            registerBlock(colors[i] + "_rug", rugs[i]);
        }
        registerBlock("beige_rug", BEIGE_RUG);
        //Bathroom Furniture
        for(int i = 0; i < bathroomFurnitureIds.length; i++) {
            registerBlock(bathroomFurnitureIds[i], bathroomFurniture[i]);
        }
        registerBlock("oak_boards", OAK_BOARDS);
        registerBlock("dungeon_caged_lantern", DUNGEON_CAGED_LANTERN);
        registerBlock("dungeon_caged_soul_lantern", DUNGEON_CAGED_SOUL_LANTERN);
        registerBlock("alarm_clock", ALARM_CLOCK);
        registerBlock("clay_window_box", CLAY_WINDOW_BOX);
        registerBlock("bucket_sandcastle", BUCKET_SANDCASTLE);
        registerBlock("rose", ROSE);
        registerBlock("cyan_rose", CYAN_ROSE);
        registerBlock("potted_rose", POTTED_ROSE);
        registerBlock("potted_cyan_rose", POTTED_CYAN_ROSE);
        registerBlock("egg_carton", EGG_CARTON);
        registerBlock("beige_wool", BEIGE_WOOL);
        registerBlock("beige_carpet", BEIGE_CARPET);
    }
}
