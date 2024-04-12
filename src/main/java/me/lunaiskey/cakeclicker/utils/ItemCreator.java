package me.lunaiskey.cakeclicker.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItemCreator {

    private ItemCreator() {

    }

    public static ItemStack createBase(String name, List<String> lore, Material material) {
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(color(name));
        for (int i = 0; i<lore.size();i++) {
            lore.set(i,color(lore.get(i)));
        }
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }

    private static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&',text);
    }
}
