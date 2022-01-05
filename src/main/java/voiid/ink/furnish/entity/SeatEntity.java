package voiid.ink.furnish.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.world.World;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import voiid.ink.furnish.block.Chair;
import voiid.ink.furnish.block.Toilet;

public class SeatEntity extends Entity
{
    public SeatEntity(EntityType<? extends SeatEntity> type, World world)
    {
        super(type, world);
        noClip = true;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {

    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    public void tick()
    {
        super.tick();

        if(!hasPassengers()||world.getBlockState(getBlockPos()).isAir())
        {
            Block block = world.getBlockState(getBlockPos()).getBlock();

            if (block instanceof Chair) {
                Chair cb = (Chair) block;
                Direction facing = world.getBlockState(getBlockPos()).get(Chair.FACING);
                Boolean waterlogged = world.getBlockState(getBlockPos()).get(Chair.WATERLOGGED);
                world.setBlockState(getBlockPos(), cb.getDefaultState().with(Chair.OCCUPIED, false).with(Chair.FACING, facing).with(Chair.WATERLOGGED, waterlogged));
            }
            else if (block instanceof Toilet) {
                Toilet tb = (Toilet) block;
                Direction facing = world.getBlockState(getBlockPos()).get(Toilet.FACING);
                world.setBlockState(getBlockPos(), tb.getDefaultState().with(Toilet.OCCUPIED, false).with(Toilet.FACING, facing));
            }

            remove(RemovalReason.DISCARDED);
        }
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    protected void removePassenger(Entity passenger) {
        BlockPos pos = this.getBlockPos();
        BlockState state = this.world.getBlockState(pos);
        if(state.getBlock() instanceof Chair) {
            Direction d = state.get(Chair.FACING);
            passenger.updatePosition(pos.getX() + d.getOffsetX() + 0.5D, pos.getY(), pos.getZ() + d.getOffsetZ() + 0.5D);
        }
        super.removePassenger(passenger);
    }

    @Override
    protected void addPassenger(Entity passenger) {
        BlockPos pos = this.getBlockPos();
        BlockState state = this.world.getBlockState(pos);
        if(state.getBlock() instanceof Chair) {
            Direction d = state.get(Chair.FACING);
            passenger.setYaw(d.getHorizontal() * 90F);
        }
        super.addPassenger(passenger);
    }

    @Override
    public Packet<?> createSpawnPacket()
    {
        return new EntitySpawnS2CPacket(this);
    }

}