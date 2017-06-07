package com.cjm721.simpletractor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class EntityTractor extends EntityLiving {

    public EntityTractor(@Nonnull World world) {
        super(world);
        setSize(3,3);
    }

    public EntityTractor(@Nonnull World worldIn, double xCoord, double yCoord, double zCoord) {
        this(worldIn);

        this.posX = xCoord;
        this.posY = yCoord;
        this.posZ = zCoord;
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    @Override
    public double getMountedYOffset() {
        return 1.0D;
    }

    @Nullable
    @Override
    public Entity getControllingPassenger()
    {
        return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
    }

    @Override
    protected boolean canBeRidden(Entity entityIn) {
        return true;
    }

    @Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack) {
        if(player != null && this.canBeRidden(player) && !this.isBeingRidden()) {
            player.startRiding(this);
            return true;
        }
        return false;
    }
}