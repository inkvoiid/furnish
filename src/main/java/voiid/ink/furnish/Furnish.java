package voiid.ink.furnish;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import voiid.ink.furnish.entity.*;
import voiid.ink.furnish.registry.ModBlocks;
import voiid.ink.furnish.registry.ModEntities;
import voiid.ink.furnish.registry.ModItems;
import voiid.ink.furnish.registry.modcompat.BYGBlocks;
import voiid.ink.furnish.registry.modcompat.BYGItems;

public class Furnish implements ModInitializer{

    public static final String MOD_ID = "furnish";
    public static Logger LOGGER = LogManager.getLogger();

    public static final ItemGroup FURNISH_ITEMGROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "general"),() -> new ItemStack(ModBlocks.OAK_CHAIR));
    public static final ItemGroup BATHROOM_ITEMGROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "bathroom"),() -> new ItemStack(ModBlocks.TOILET));
    public static final ItemGroup DECORATIONS_ITEMGROUP = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "decorations"),() -> new ItemStack(ModItems.ROSE));

    public static final ScreenHandlerType<MailboxScreenHandler> MAILBOX_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(Furnish.MOD_ID, "white_mailbox"), MailboxScreenHandler::new);

    @Override
    public void onInitialize() {
        ModItems.registerItems();
        ModBlocks.registerBlocks();
        ModEntities.registerEntities();

        if(FabricLoader.getInstance().isModLoaded("byg"))
        {
            LOGGER.info("Furnish: BYG found! Adding furniture for BYG.");
            BYGItems.registerItems();
            BYGBlocks.registerBlocks();
        }
    }
}
