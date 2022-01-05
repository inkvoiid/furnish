package voiid.ink.furnish.entity.renderer;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import voiid.ink.furnish.entity.CeilingFanEntity;

public class CeilingFanEntityRenderer implements BlockEntityRenderer<CeilingFanEntity> {

    public CeilingFanEntityRenderer(BlockEntityRendererFactory.Context ctx)
    {

    }

    @Override
    public void render(CeilingFanEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

    }
}
