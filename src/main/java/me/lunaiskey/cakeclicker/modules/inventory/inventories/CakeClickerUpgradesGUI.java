package me.lunaiskey.cakeclicker.modules.inventory.inventories;

import me.lunaiskey.cakeclicker.CakeClicker;
import me.lunaiskey.cakeclicker.UpgradeType;
import me.lunaiskey.cakeclicker.modules.inventory.InventoryManager;
import me.lunaiskey.cakeclicker.modules.inventory.holders.LunixHolder;
import me.lunaiskey.cakeclicker.modules.player.LunixPlayer;
import me.lunaiskey.cakeclicker.modules.player.PlayerManager;
import me.lunaiskey.cakeclicker.utils.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

public class CakeClickerUpgradesGUI implements LunixInventory {

    @Override
    public Inventory getInv(Player player) {
        Inventory inv = Bukkit.createInventory(new LunixHolder(InventoryID.CAKE_CLICKER_UPGRADES),27, "Upgrades");
        LunixPlayer lunixPlayer = PlayerManager.get().getLunixPlayer(player);
        inv.setItem(11,getPerClicksUpgradeButton(player,lunixPlayer));
        inv.setItem(15,getPerSecondUpgradeButton(player,lunixPlayer));
        inv.setItem(18,getGoBackButton());
        return inv;
    }

    @Override
    public void updateGUI(Player player) {
        LunixPlayer lunixPlayer = PlayerManager.get().getLunixPlayer(player);
        player.getOpenInventory().setItem(11,getPerClicksUpgradeButton(player,lunixPlayer));
        player.getOpenInventory().setItem(15,getPerSecondUpgradeButton(player,lunixPlayer));
    }

    @Override
    public void onClick(InventoryClickEvent e) {
        e.setCancelled(true);
        Inventory inv = e.getInventory();
        Player player = (Player) e.getWhoClicked();
        LunixPlayer lunixPlayer = PlayerManager.get().getLunixPlayer(player);
        switch (e.getRawSlot()) {
            case 11,15 -> {
                long cost;
                UpgradeType upgrade = null;
                switch (e.getRawSlot()) {
                    case 11 -> {
                        upgrade = UpgradeType.PER_CLICK;
                    }
                    case 15 -> {
                        upgrade = UpgradeType.PER_SECOND;
                    }
                }
                cost = getCost(upgrade,lunixPlayer.getUpgradeLevel(upgrade)+1);
                if (cost == -1) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cYou've Already maxed this upgrade."));
                    return;
                }
                long clicks = lunixPlayer.getClicks();
                int level = lunixPlayer.getUpgradeLevel(upgrade);
                if (clicks >= cost) {
                    lunixPlayer.decrementClicks((int) cost);
                    lunixPlayer.incrementUpgradeLevel(upgrade,1);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&aUpgraded to level "+(level+1)+" !"));
                    updateGUI(player);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cYou can't afford this upgrade."));
                }
            }
            case 18 -> {
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        InventoryManager.get().getInv(InventoryID.CAKE_CLICKER).open(player);
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

    public long getCost(UpgradeType upgrade, int level) {
        return switch (upgrade) {
            case PER_CLICK -> switch (level) {
                case 1 -> 100;
                case 2 -> 1000;
                default -> -1;
            };
            case PER_SECOND -> switch (level) {
                case 1 -> 1000;
                case 2 -> 10000;
                default -> -1;
            };
        };
    }

    public ItemStack getPerClicksUpgradeButton(Player player, LunixPlayer lunixPlayer) {
        UpgradeType upgrade = UpgradeType.PER_CLICK;
        int nextLevel = lunixPlayer.getUpgradeLevel(upgrade)+1;
        long cost = getCost(upgrade, nextLevel);
        List<String> lore = new ArrayList<>();
        lore.add("&7Increases Cakes/Click amount.");
        if (cost == -1) {
            lore.add("");
            lore.add("&a&lMAXED OUT");
        } else {
            lore.add("&7Cost: &a"+cost+" Cakes");
            lore.add("");
            if (cost <= lunixPlayer.getClicks()) {
                lore.add("&eClick to upgrade!");
            } else {
                lore.add("&cCannot afford!");
            }
        }
        ItemStack itemStack = ItemCreator.createBase("&6Per Click ["+lunixPlayer.getUpgradeLevel(upgrade)+"]",lore,Material.TRIPWIRE_HOOK);
        return itemStack;
    }

    public ItemStack getPerSecondUpgradeButton(Player player, LunixPlayer lunixPlayer) {
        UpgradeType upgrade = UpgradeType.PER_SECOND;
        int nextLevel = lunixPlayer.getUpgradeLevel(upgrade)+1;
        long cost = getCost(upgrade, nextLevel);
        List<String> lore = new ArrayList<>();
        lore.add("&7Increases Cake/sec amount.");
        if (cost == -1) {
            lore.add("");
            lore.add("&a&lMAXED OUT");
        } else {
            lore.add("&7Cost: &a"+cost+" Cakes");
            lore.add("");
            if (cost <= lunixPlayer.getClicks()) {
                lore.add("&eClick to upgrade!");
            } else {
                lore.add("&cCannot afford!");
            }
        }
        ItemStack itemStack = ItemCreator.createBase("&6Per Second ["+lunixPlayer.getUpgradeLevel(upgrade)+"]",lore,Material.CLOCK);
        return itemStack;
    }

    public ItemStack getGoBackButton() {
        List<String> lore = new ArrayList<>();
        lore.add("&7Click to return.");
        ItemStack itemstack = ItemCreator.createBase("&cGo Back",lore, Material.ARROW);
        return itemstack;
    }
}
