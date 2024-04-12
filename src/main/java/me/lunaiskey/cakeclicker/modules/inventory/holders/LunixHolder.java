package me.lunaiskey.cakeclicker.modules.inventory.holders;

import me.lunaiskey.cakeclicker.modules.inventory.inventories.InventoryID;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class LunixHolder implements InventoryHolder {

    public LunixHolder(InventoryID id) {
        this.ID = id;
    }

    private final InventoryID ID;

    public InventoryID getID() {
        return ID;
    }

    @Override
    public @NotNull Inventory getInventory() {
        return null;
    }
}
