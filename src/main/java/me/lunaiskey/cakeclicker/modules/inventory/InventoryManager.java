package me.lunaiskey.cakeclicker.modules.inventory;

import me.lunaiskey.cakeclicker.UpgradeType;
import me.lunaiskey.cakeclicker.modules.inventory.inventories.CakeClickerGUI;
import me.lunaiskey.cakeclicker.modules.inventory.inventories.CakeClickerUpgradesGUI;
import me.lunaiskey.cakeclicker.modules.inventory.inventories.InventoryID;
import me.lunaiskey.cakeclicker.modules.inventory.inventories.LunixInventory;

import java.util.HashMap;
import java.util.Map;

public class InventoryManager {

    private static InventoryManager instance;
    private Map<InventoryID, LunixInventory> map;

    private InventoryManager() {
        map = new HashMap<>();
        populateMap();
    }

    private void populateMap() {
        map.put(InventoryID.CAKE_CLICKER, new CakeClickerGUI());
        map.put(InventoryID.CAKE_CLICKER_UPGRADES, new CakeClickerUpgradesGUI());
    }

    public static InventoryManager get() {
        if (instance == null) instance = new InventoryManager();
        return instance;
    }

    public LunixInventory getInv(InventoryID id) {
        return map.get(id);
    }
}
