/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_19_R3.block.impl;

public final class CraftTripwireHook extends org.bukkit.craftbukkit.v1_19_R3.block.data.CraftBlockData implements org.bukkit.block.data.type.TripwireHook, org.bukkit.block.data.Attachable, org.bukkit.block.data.Directional, org.bukkit.block.data.Powerable {

    public CraftTripwireHook() {
        super();
    }

    public CraftTripwireHook(net.minecraft.world.level.block.state.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.v1_19_R3.block.data.CraftAttachable

    private static final net.minecraft.world.level.block.state.properties.BooleanProperty ATTACHED = getBoolean(net.minecraft.world.level.block.TripWireHookBlock.class, "attached");

    @Override
    public boolean isAttached() {
        return get(CraftTripwireHook.ATTACHED);
    }

    @Override
    public void setAttached(boolean attached) {
        set(CraftTripwireHook.ATTACHED, attached);
    }

    // org.bukkit.craftbukkit.v1_19_R3.block.data.CraftDirectional

    private static final net.minecraft.world.level.block.state.properties.EnumProperty<?> FACING = getEnum(net.minecraft.world.level.block.TripWireHookBlock.class, "facing");

    @Override
    public org.bukkit.block.BlockFace getFacing() {
        return get(CraftTripwireHook.FACING, org.bukkit.block.BlockFace.class);
    }

    @Override
    public void setFacing(org.bukkit.block.BlockFace facing) {
        set(CraftTripwireHook.FACING, facing);
    }

    @Override
    public java.util.Set<org.bukkit.block.BlockFace> getFaces() {
        return getValues(CraftTripwireHook.FACING, org.bukkit.block.BlockFace.class);
    }

    // org.bukkit.craftbukkit.v1_19_R3.block.data.CraftPowerable

    private static final net.minecraft.world.level.block.state.properties.BooleanProperty POWERED = getBoolean(net.minecraft.world.level.block.TripWireHookBlock.class, "powered");

    @Override
    public boolean isPowered() {
        return get(CraftTripwireHook.POWERED);
    }

    @Override
    public void setPowered(boolean powered) {
        set(CraftTripwireHook.POWERED, powered);
    }
}
