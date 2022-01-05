package voiid.ink.furnish.entity;

import io.netty.buffer.Unpooled;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.network.PacketContext;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import voiid.ink.furnish.Furnish;

import java.util.UUID;

public class S2CEntitySpawnPacket {

    public static final Identifier ID = new Identifier(Furnish.MOD_ID, "spawn_entity");

    public static Packet<?> createPacket(Entity entity) {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeVarInt(Registry.ENTITY_TYPE.getRawId(entity.getType()));
        buf.writeUuid(entity.getUuid());
        buf.writeVarInt(entity.getId());
        buf.writeDouble(entity.getX());
        buf.writeDouble(entity.getY());
        buf.writeDouble(entity.getZ());
        buf.writeByte(MathHelper.floor(entity.getPitch() * 256.0F / 360.0F));
        buf.writeByte(MathHelper.floor(entity.getYaw() * 256.0F / 360.0F));
        buf.writeFloat(entity.getPitch());
        buf.writeFloat(entity.getYaw());
        return ServerSidePacketRegistry.INSTANCE.toPacket(ID, buf);
    }

    @Environment(EnvType.CLIENT)
    public static void onPacket(PacketContext context, PacketByteBuf byteBuf) {
        EntityType<?> type = Registry.ENTITY_TYPE.get(byteBuf.readVarInt());
        UUID entityUUID = byteBuf.readUuid();
        int entityID = byteBuf.readVarInt();
        double x = byteBuf.readDouble();
        double y = byteBuf.readDouble();
        double z = byteBuf.readDouble();
        float pitch = (byteBuf.readByte() * 360) / 256.0F;
        float yaw = (byteBuf.readByte() * 360) / 256.0F;
        context.getTaskQueue().execute(() -> {
            ClientWorld world = MinecraftClient.getInstance().world;
            Entity entity = type.create(world);
            if(entity != null) {
                entity.updatePosition(x, y, z);
                entity.updateTrackedPosition(x, y, z);
                entity.setPitch(pitch);
                entity.setYaw(yaw);
                entity.setId(entityID);
                entity.setUuid(entityUUID);
                //entity.setVelocity(velocityX, velocityY, velocityZ);
                world.addEntity(entityID, entity);
            }
        });
    }
}
