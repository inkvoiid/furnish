package voiid.ink.furnish.registry;

import net.minecraft.item.BlockItem;
import voiid.ink.furnish.Furnish;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import voiid.ink.furnish.item.EggCartonItem;

public class ModItems {

    //Items
    public static final Item IRON_ROD = new Item(new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    //Block Items
    public static final BlockItem OAK_BOARDS = new BlockItem(ModBlocks.OAK_BOARDS, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem DUNGEON_CAGED_LANTERN = new BlockItem(ModBlocks.DUNGEON_CAGED_LANTERN, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem DUNGEON_CAGED_SOUL_LANTERN = new BlockItem(ModBlocks.DUNGEON_CAGED_SOUL_LANTERN, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem ALARM_CLOCK = new BlockItem(ModBlocks.ALARM_CLOCK, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem CLAY_WINDOW_BOX = new BlockItem(ModBlocks.CLAY_WINDOW_BOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    public static final BlockItem WHITE_SINK = new BlockItem(ModBlocks.WHITE_SINK, new Item.Settings().group(Furnish.BATHROOM_ITEMGROUP));
    public static final BlockItem GRAY_SINK = new BlockItem(ModBlocks.GRAY_SINK, new Item.Settings().group(Furnish.BATHROOM_ITEMGROUP));
    public static final BlockItem TOILET = new BlockItem(ModBlocks.TOILET, new Item.Settings().group(Furnish.BATHROOM_ITEMGROUP));
    public static final BlockItem GOLD_TOILET = new BlockItem(ModBlocks.GOLD_TOILET, new Item.Settings().group(Furnish.BATHROOM_ITEMGROUP));
    public static final BlockItem BATHTUB = new BlockItem(ModBlocks.BATHTUB, new Item.Settings().group(Furnish.BATHROOM_ITEMGROUP));

    public static final BlockItem ROSE = new BlockItem(ModBlocks.ROSE, new Item.Settings().group(Furnish.DECORATIONS_ITEMGROUP));
    public static final BlockItem CYAN_ROSE = new BlockItem(ModBlocks.CYAN_ROSE, new Item.Settings().group(Furnish.DECORATIONS_ITEMGROUP));

    public static final BlockItem RED_SANDCASTLE_BUCKET = new BlockItem(ModBlocks.BUCKET_SANDCASTLE, new Item.Settings().group(Furnish.DECORATIONS_ITEMGROUP));
    public static final EggCartonItem EGG_CARTON = new EggCartonItem(ModBlocks.EGG_CARTON, new Item.Settings().group(Furnish.DECORATIONS_ITEMGROUP));

    public static final BlockItem BEIGE_WOOL = new BlockItem(ModBlocks.BEIGE_WOOL, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem BEIGE_CARPET = new BlockItem(ModBlocks.BEIGE_CARPET, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem BEIGE_RUG = new BlockItem(ModBlocks.BEIGE_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    public static final BlockItem WHITE_RUG = new BlockItem(ModBlocks.WHITE_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem ORANGE_RUG = new BlockItem(ModBlocks.ORANGE_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem MAGENTA_RUG = new BlockItem(ModBlocks.MAGENTA_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem LIGHT_BLUE_RUG = new BlockItem(ModBlocks.LIGHT_BLUE_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem YELLOW_RUG = new BlockItem(ModBlocks.YELLOW_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem LIME_RUG = new BlockItem(ModBlocks.LIME_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem PINK_RUG = new BlockItem(ModBlocks.PINK_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem GRAY_RUG = new BlockItem(ModBlocks.GRAY_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem LIGHT_GRAY_RUG = new BlockItem(ModBlocks.LIGHT_GRAY_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem CYAN_RUG = new BlockItem(ModBlocks.CYAN_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem PURPLE_RUG = new BlockItem(ModBlocks.PURPLE_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem BLUE_RUG = new BlockItem(ModBlocks.BLUE_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem BROWN_RUG = new BlockItem(ModBlocks.BROWN_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem GREEN_RUG = new BlockItem(ModBlocks.GREEN_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem RED_RUG = new BlockItem(ModBlocks.RED_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem BLACK_RUG = new BlockItem(ModBlocks.BLACK_RUG, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    //Mailboxes

    //Concrete
    public static final BlockItem WHITE_MAILBOX = new BlockItem(ModBlocks.WHITE_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem ORANGE_MAILBOX = new BlockItem(ModBlocks.ORANGE_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem MAGENTA_MAILBOX = new BlockItem(ModBlocks.MAGENTA_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem LIGHT_BLUE_MAILBOX = new BlockItem(ModBlocks.LIGHT_BLUE_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem YELLOW_MAILBOX = new BlockItem(ModBlocks.YELLOW_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem LIME_MAILBOX = new BlockItem(ModBlocks.LIME_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem PINK_MAILBOX = new BlockItem(ModBlocks.PINK_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem GRAY_MAILBOX = new BlockItem(ModBlocks.GRAY_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem LIGHT_GRAY_MAILBOX = new BlockItem(ModBlocks.LIGHT_GRAY_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem CYAN_MAILBOX = new BlockItem(ModBlocks.CYAN_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem PURPLE_MAILBOX = new BlockItem(ModBlocks.PURPLE_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem BLUE_MAILBOX = new BlockItem(ModBlocks.BLUE_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem BROWN_MAILBOX = new BlockItem(ModBlocks.BROWN_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem GREEN_MAILBOX = new BlockItem(ModBlocks.GREEN_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem RED_MAILBOX = new BlockItem(ModBlocks.RED_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem BLACK_MAILBOX = new BlockItem(ModBlocks.BLACK_MAILBOX, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    //Chairs

    //Wooden
    public static final BlockItem OAK_CHAIR = new BlockItem(ModBlocks.OAK_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem SPRUCE_CHAIR = new BlockItem(ModBlocks.SPRUCE_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem BIRCH_CHAIR = new BlockItem(ModBlocks.BIRCH_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem JUNGLE_CHAIR = new BlockItem(ModBlocks.JUNGLE_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem ACACIA_CHAIR = new BlockItem(ModBlocks.ACACIA_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem DARK_OAK_CHAIR = new BlockItem(ModBlocks.DARK_OAK_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem CRIMSON_CHAIR = new BlockItem(ModBlocks.CRIMSON_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem WARPED_CHAIR = new BlockItem(ModBlocks.WARPED_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    //Stone
    public static final BlockItem STONE_CHAIR = new BlockItem(ModBlocks.STONE_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem STONE_BRICK_CHAIR = new BlockItem(ModBlocks.STONE_BRICK_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem GRANITE_CHAIR = new BlockItem(ModBlocks.GRANITE_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem DIORITE_CHAIR = new BlockItem(ModBlocks.DIORITE_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem ANDESITE_CHAIR = new BlockItem(ModBlocks.ANDESITE_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem POLISHED_BLACKSTONE_CHAIR = new BlockItem(ModBlocks.POLISHED_BLACKSTONE_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem POLISHED_BLACKSTONE_BRICK_CHAIR = new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem GILDED_BLACKSTONE_CHAIR = new BlockItem(ModBlocks.GILDED_BLACKSTONE_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    //Misc
    public static final BlockItem NETHER_BRICK_CHAIR = new BlockItem(ModBlocks.NETHER_BRICK_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem PURPUR_CHAIR = new BlockItem(ModBlocks.PURPUR_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem PRISMARINE_CHAIR = new BlockItem(ModBlocks.PRISMARINE_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem DARK_PRISMARINE_CHAIR = new BlockItem(ModBlocks.DARK_PRISMARINE_CHAIR, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    //Tables

    //Wooden
    public static final BlockItem OAK_TABLE = new BlockItem(ModBlocks.OAK_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem SPRUCE_TABLE = new BlockItem(ModBlocks.SPRUCE_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem BIRCH_TABLE = new BlockItem(ModBlocks.BIRCH_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem JUNGLE_TABLE = new BlockItem(ModBlocks.JUNGLE_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem ACACIA_TABLE = new BlockItem(ModBlocks.ACACIA_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem DARK_OAK_TABLE = new BlockItem(ModBlocks.DARK_OAK_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem CRIMSON_TABLE = new BlockItem(ModBlocks.CRIMSON_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem WARPED_TABLE = new BlockItem(ModBlocks.WARPED_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    //Stone
    public static final BlockItem STONE_TABLE = new BlockItem(ModBlocks.STONE_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem STONE_BRICK_TABLE = new BlockItem(ModBlocks.STONE_BRICK_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem GRANITE_TABLE = new BlockItem(ModBlocks.GRANITE_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem DIORITE_TABLE = new BlockItem(ModBlocks.DIORITE_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem ANDESITE_TABLE = new BlockItem(ModBlocks.ANDESITE_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem POLISHED_BLACKSTONE_TABLE = new BlockItem(ModBlocks.POLISHED_BLACKSTONE_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem POLISHED_BLACKSTONE_BRICK_TABLE = new BlockItem(ModBlocks.POLISHED_BLACKSTONE_BRICK_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem GILDED_BLACKSTONE_TABLE = new BlockItem(ModBlocks.GILDED_BLACKSTONE_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    //Misc
    public static final BlockItem NETHER_BRICK_TABLE = new BlockItem(ModBlocks.NETHER_BRICK_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem PURPUR_TABLE = new BlockItem(ModBlocks.PURPUR_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem PRISMARINE_TABLE = new BlockItem(ModBlocks.PRISMARINE_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));
    public static final BlockItem DARK_PRISMARINE_TABLE = new BlockItem(ModBlocks.DARK_PRISMARINE_TABLE, new Item.Settings().group(Furnish.FURNISH_ITEMGROUP));

    public static final String[] woodTypes = {"oak", "spruce", "birch", "jungle", "acacia", "dark_oak", "crimson", "warped"};
    public static final String[] stoneTypes = {"stone", "stone_brick", "granite", "diorite", "andesite", "polished_blackstone", "polished_blackstone_brick", "gilded_blackstone"};
    public static final String[] miscTypes = {"nether_brick", "purpur", "prismarine", "dark_prismarine"};


    public static final BlockItem[] woodenChairs = {OAK_CHAIR, SPRUCE_CHAIR, BIRCH_CHAIR, JUNGLE_CHAIR, ACACIA_CHAIR, DARK_OAK_CHAIR, CRIMSON_CHAIR, WARPED_CHAIR};
    public static final BlockItem[] woodenTables = {OAK_TABLE, SPRUCE_TABLE, BIRCH_TABLE, JUNGLE_TABLE, ACACIA_TABLE, DARK_OAK_TABLE, CRIMSON_TABLE, WARPED_TABLE};
    public static final BlockItem[] stoneChairs = {STONE_CHAIR, STONE_BRICK_CHAIR, GRANITE_CHAIR, DIORITE_CHAIR, ANDESITE_CHAIR, POLISHED_BLACKSTONE_CHAIR, POLISHED_BLACKSTONE_BRICK_CHAIR, GILDED_BLACKSTONE_CHAIR};
    public static final BlockItem[] stoneTables = {STONE_TABLE, STONE_BRICK_TABLE, GRANITE_TABLE, DIORITE_TABLE, ANDESITE_TABLE, POLISHED_BLACKSTONE_TABLE, POLISHED_BLACKSTONE_BRICK_TABLE, GILDED_BLACKSTONE_TABLE};
    public static final BlockItem[] miscChairs = {NETHER_BRICK_CHAIR, PURPUR_CHAIR, PRISMARINE_CHAIR, DARK_PRISMARINE_CHAIR};
    public static final BlockItem[] miscTables = {NETHER_BRICK_TABLE, PURPUR_TABLE, PRISMARINE_TABLE, DARK_PRISMARINE_TABLE};

    public static final String[] colors = {"white", "orange", "magenta", "light_blue", "yellow", "lime", "pink", "gray", "light_gray", "cyan", "purple", "blue", "brown", "green", "red", "black"};

    public static final BlockItem[] mailboxes = {WHITE_MAILBOX, ORANGE_MAILBOX, MAGENTA_MAILBOX, LIGHT_BLUE_MAILBOX, YELLOW_MAILBOX, LIME_MAILBOX, PINK_MAILBOX,
            GRAY_MAILBOX, LIGHT_GRAY_MAILBOX, CYAN_MAILBOX, PURPLE_MAILBOX, BLUE_MAILBOX, BROWN_MAILBOX, GREEN_MAILBOX, RED_MAILBOX, BLACK_MAILBOX};

    public static final BlockItem[] rugs = {WHITE_RUG, ORANGE_RUG, MAGENTA_RUG, LIGHT_BLUE_RUG, YELLOW_RUG, LIME_RUG, PINK_RUG,
            GRAY_RUG, LIGHT_GRAY_RUG, CYAN_RUG, PURPLE_RUG, BLUE_RUG, BROWN_RUG, GREEN_RUG, RED_RUG, BLACK_RUG};

    public static final String[] bathroomFurnitureIds = {"white_sink", "gray_sink", "toilet", "gold_toilet", "bathtub"};
    public static final BlockItem[] bathroomFurniture = {WHITE_SINK, GRAY_SINK, TOILET, GOLD_TOILET, BATHTUB};


    public static void registerItem(String path, Item item) {
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, path), item);
    }

    public static void registerItems() {
        //Register Items
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "iron_rod"), IRON_ROD);

        //Register BlockItems

        //Wooden Furniture
        for(int i = 0; i < woodTypes.length; i++) {
            registerItem(woodTypes[i] + "_chair", woodenChairs[i]);
            registerItem(woodTypes[i] + "_table", woodenTables[i]);
        }
        //Stone Furniture
        for(int i = 0; i < stoneTypes.length; i++) {
            registerItem(stoneTypes[i] + "_chair", stoneChairs[i]);
            registerItem(stoneTypes[i] + "_table", stoneTables[i]);
        }
        //Misc Furniture
        for(int i = 0; i < miscTypes.length; i++) {
            registerItem(miscTypes[i] + "_chair", miscChairs[i]);
            registerItem(miscTypes[i] + "_table", miscTables[i]);
        }
        //Colored Things
        for(int i = 0; i < colors.length; i++) {
            registerItem(colors[i] + "_mailbox", mailboxes[i]);
        }
        for(int i = 0; i < colors.length; i++) {
            registerItem(colors[i] + "_rug", rugs[i]);
        }
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "beige_rug"), BEIGE_RUG);
        for(int i = 0; i < bathroomFurnitureIds.length; i++) {
            registerItem(bathroomFurnitureIds[i], bathroomFurniture[i]);
        }

        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "oak_boards"), OAK_BOARDS);
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "dungeon_caged_lantern"), DUNGEON_CAGED_LANTERN);
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "dungeon_caged_soul_lantern"), DUNGEON_CAGED_SOUL_LANTERN);
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "alarm_clock"), ALARM_CLOCK);
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "clay_window_box"), CLAY_WINDOW_BOX);

        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "rose"), ROSE);
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "cyan_rose"), CYAN_ROSE);

        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "red_sandcastle_bucket"), RED_SANDCASTLE_BUCKET);
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "egg_carton"), EGG_CARTON);
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "beige_wool"), BEIGE_WOOL);
        Registry.register(Registry.ITEM, new Identifier(Furnish.MOD_ID, "beige_carpet"), BEIGE_CARPET);
    }

}
