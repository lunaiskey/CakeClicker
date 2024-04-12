package me.lunaiskey.cakeclicker.modules.inventory.inventories;

import me.lunaiskey.cakeclicker.CakeClicker;
import me.lunaiskey.cakeclicker.UpgradeType;
import me.lunaiskey.cakeclicker.modules.inventory.InventoryManager;
import me.lunaiskey.cakeclicker.modules.inventory.holders.LunixHolder;
import me.lunaiskey.cakeclicker.modules.player.LunixPlayer;
import me.lunaiskey.cakeclicker.modules.player.PlayerManager;
import me.lunaiskey.cakeclicker.utils.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class CakeClickerGUI implements LunixInventory {

    @Override
    public Inventory getInv(Player player) {
        Inventory inv = Bukkit.createInventory(new LunixHolder(InventoryID.CAKE_CLICKER), 45, "Cake Clicker");
        LunixPlayer lunixPlayer = PlayerManager.get().getLunixPlayer(player);
        inv.setItem(13, getClickMeGUIButton(player,lunixPlayer));
        inv.setItem(31,getUpgradesOpenGUIButton(player));
        return inv;
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();
        LunixPlayer lunixPlayer = PlayerManager.get().getLunixPlayer(player);
        switch (e.getRawSlot()) {
            case 13 -> {
                lunixPlayer.incrementClicks(1+lunixPlayer.getUpgradeLevel(UpgradeType.PER_CLICK));
                updateGUI(player,lunixPlayer);
            }
            case 31 -> {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        InventoryManager.get().getInv(InventoryID.CAKE_CLICKER_UPGRADES).open(player);
                    }
                }.runTask(CakeClicker.getInstance());

            }
        }
    }

    @Override
    public void onOpen(InventoryOpenEvent e) {

    }

    @Override
    public void onClose(InventoryCloseEvent e) {

    }

    public static ItemStack getClickMeGUIButton(Player player, LunixPlayer lunixPlayer) {
        List<String> lore = new ArrayList<>();
        lore.add("&7You have &f"+lunixPlayer.getClicks()+" &6Cakes&7.");
        lore.add("");
        lore.add("&eClick to Gain Cakes!");
        ItemStack itemstack = ItemCreator.createBase(
            "&aCLICK ME!",
                lore,
                Material.CAKE
        );
        return itemstack;
    }

    public static ItemStack getClickMeGUIButton(Player player) {
        return getClickMeGUIButton(player,PlayerManager.get().getLunixPlayer(player));
    }

    public static ItemStack getUpgradesOpenGUIButton(Player player) {
        List<String> lore = new ArrayList<>();
        lore.add("&7To view current upgrades.");
        lore.add("");
        lore.add("&eClick to open Upgrades!");
        ItemStack itemstack = ItemCreator.createBase(
            "&6Upgrades",
                lore,
                Material.BOOK
        );
        return itemstack;
    }

    public void updateGUI(Player player, LunixPlayer lunixPlayer) {
        player.getOpenInventory().getTopInventory().setItem(13,getClickMeGUIButton(player,lunixPlayer));
    }

    public void updateGUI(Player player) {
        updateGUI(player,PlayerManager.get().getLunixPlayer(player));
    }

}
