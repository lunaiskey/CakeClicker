package me.lunaiskey.cakeclicker.modules.inventory.inventories;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

public interface LunixInventory {

    default void open(Player player) {
        player.openInventory(getInv(player));
    }

    Inventory getInv(Player player);

    void updateGUI(Player player);

    void onClick(InventoryClickEvent e);

    default void onDrag(InventoryDragEvent e) {
        e.setCancelled(true);
    }

    void onOpen(InventoryOpenEvent e);

    void onClose(InventoryCloseEvent e);
}
