package voiid.ink.furnish.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.BiomeKeys;
import voiid.ink.furnish.Furnish;
import voiid.ink.furnish.entity.*;
import voiid.ink.furnish.entity.renderer.CeilingFanEntityRenderer;
import voiid.ink.furnish.registry.ModBlocks;
import voiid.ink.furnish.registry.ModEntities;
import voiid.ink.furnish.registry.ModItems;

import static voiid.ink.furnish.registry.ModEntities.CEILING_FAN_ENTITY;

public class FurnishClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ALARM_CLOCK, RenderLayer.getTranslucent());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DUNGEON_CAGED_LANTERN, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DUNGEON_CAGED_SOUL_LANTERN, RenderLayer.getCutout());


        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xeddabe, ModBlocks.BEIGE_WOOL);
        ColorProviderRegistry.ITEM.register((state, tintIndex) -> 0xeddabe, ModItems.BEIGE_WOOL);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xeddabe, ModBlocks.BEIGE_CARPET);
        ColorProviderRegistry.ITEM.register((state, tintIndex) -> 0xeddabe, ModItems.BEIGE_CARPET);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BEIGE_RUG, RenderLayer.getCutout());
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0xeddabe, ModBlocks.BEIGE_RUG);
        ColorProviderRegistry.ITEM.register((state, tintIndex) -> 0xeddabe, ModItems.BEIGE_RUG);

        //Water in the sink color for both the block and the item
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BuiltinRegistries.BIOME.get(BiomeKeys.PLAINS).getWaterColor(), ModBlocks.WHITE_SINK);
        ColorProviderRegistry.ITEM.register((state, tintIndex) -> BuiltinRegistries.BIOME.get(BiomeKeys.PLAINS).getWaterColor(), ModItems.WHITE_SINK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BuiltinRegistries.BIOME.get(BiomeKeys.PLAINS).getWaterColor(), ModBlocks.GRAY_SINK);
        ColorProviderRegistry.ITEM.register((state, tintIndex) -> BuiltinRegistries.BIOME.get(BiomeKeys.PLAINS).getWaterColor(), ModItems.GRAY_SINK);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BuiltinRegistries.BIOME.get(BiomeKeys.PLAINS).getWaterColor(), ModBlocks.TOILET);
        ColorProviderRegistry.ITEM.register((state, tintIndex) -> BuiltinRegistries.BIOME.get(BiomeKeys.PLAINS).getWaterColor(), ModItems.TOILET);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BuiltinRegistries.BIOME.get(BiomeKeys.PLAINS).getWaterColor(), ModBlocks.GOLD_TOILET);
        ColorProviderRegistry.ITEM.register((state, tintIndex) -> BuiltinRegistries.BIOME.get(BiomeKeys.PLAINS).getWaterColor(), ModItems.GOLD_TOILET);

        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BuiltinRegistries.BIOME.get(BiomeKeys.PLAINS).getWaterColor() , ModBlocks.BATHTUB);
        ColorProviderRegistry.ITEM.register((state, tintIndex) -> BuiltinRegistries.BIOME.get(BiomeKeys.PLAINS).getWaterColor(), ModItems.BATHTUB);

        BlockEntityRendererRegistry.INSTANCE.register(CEILING_FAN_ENTITY, CeilingFanEntityRenderer::new);

        EntityRendererRegistry.INSTANCE.register(ModEntities.SEAT_ENTITY_TYPE, EmptySeatRenderer::new);

        //Makes the flower have a transparent background in the world
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CYAN_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_ROSE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CYAN_ROSE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BUCKET_SANDCASTLE, RenderLayer.getCutout());

        for(int i = 0; i < ModBlocks.rugs.length; i++) {
            BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.rugs[i], RenderLayer.getCutout());
        }

        ScreenRegistry.register(Furnish.MAILBOX_SCREEN_HANDLER, MailboxScreen::new);

    }

    private static class EmptySeatRenderer extends EntityRenderer<SeatEntity>

    {
        protected EmptySeatRenderer(EntityRendererFactory.Context ctx)
        {
            super(ctx);
        }

        @Override
        public boolean shouldRender(SeatEntity entity, Frustum frustum, double d, double e, double f)
        {
            return false;
        }

        @Override
        public Identifier getTexture(SeatEntity entity)
        {
            return null;
        }
    }
}