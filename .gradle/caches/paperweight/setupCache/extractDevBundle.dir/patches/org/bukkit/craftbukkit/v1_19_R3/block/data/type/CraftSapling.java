package org.bukkit.craftbukkit.v1_19_R3.block.data.type;

import org.bukkit.block.data.type.Sapling;
import org.bukkit.craftbukkit.v1_19_R3.block.data.CraftBlockData;

public abstract class CraftSapling extends CraftBlockData implements Sapling {

    private static final net.minecraft.world.level.block.state.properties.IntegerProperty STAGE = getInteger("stage");

    @Override
    public int getStage() {
        return get(CraftSapling.STAGE);
    }

    @Override
    public void setStage(int stage) {
        set(CraftSapling.STAGE, stage);
    }

    @Override
    public int getMaximumStage() {
        return getMax(CraftSapling.STAGE);
    }
}