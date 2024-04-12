package me.lunaiskey.cakeclicker.listeners;

import me.lunaiskey.cakeclicker.modules.inventory.InventoryManager;
import me.lunaiskey.cakeclicker.modules.inventory.holders.LunixHolder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class PlayerListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        InventoryHolder holder = inv.getHolder();
        if (holder instanceof LunixHolder) {
            LunixHolder lunixHolder = (LunixHolder) holder;
            InventoryManager.get().getInv(lunixHolder.getID()).onClick(e);
        }
    }

    @EventHandler
    public void onDrag(InventoryDragEvent e) {
        Inventory inv = e.getInventory();
        InventoryHolder holder = inv.getHolder();
        if (holder instanceof LunixHolder) {
            LunixHolder lunixHolder = (LunixHolder) holder;
            InventoryManager.get().getInv(lunixHolder.getID()).onDrag(e);
        }
    }

    @EventHandler
    public void onOpen(InventoryOpenEvent e) {
        Inventory inv = e.getInventory();
        InventoryHolder holder = inv.getHolder();
        if (holder instanceof LunixHolder) {
            LunixHolder lunixHolder = (LunixHolder) holder;
            InventoryManager.get().getInv(lunixHolder.getID()).onOpen(e);
        }
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        Inventory inv = e.getInventory();
        InventoryHolder holder = inv.getHolder();
        if (holder instanceof LunixHolder) {
            LunixHolder lunixHolder = (LunixHolder) holder;
            InventoryManager.get().getInv(lunixHolder.getID()).onClose(e);
        }
    }


}
