/**
 * Automatically generated file, changes will be lost.
 */
package org.bukkit.craftbukkit.v1_19_R3.block.impl;

public final class CraftTorchflowerCrop extends org.bukkit.craftbukkit.v1_19_R3.block.data.CraftBlockData implements org.bukkit.block.data.Ageable {

    public CraftTorchflowerCrop() {
        super();
    }

    public CraftTorchflowerCrop(net.minecraft.world.level.block.state.BlockState state) {
        super(state);
    }

    // org.bukkit.craftbukkit.v1_19_R3.block.data.CraftAgeable

    private static final net.minecraft.world.level.block.state.properties.IntegerProperty AGE = getInteger(net.minecraft.world.level.block.TorchflowerCropBlock.class, "age");

    @Override
    public int getAge() {
        return get(CraftTorchflowerCrop.AGE);
    }

    @Override
    public void setAge(int age) {
        set(CraftTorchflowerCrop.AGE, age);
    }

    @Override
    public int getMaximumAge() {
        return getMax(CraftTorchflowerCrop.AGE);
    }
}
