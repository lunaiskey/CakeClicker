package me.lunaiskey.cakeclicker.modules.inventory.commands;


import me.lunaiskey.cakeclicker.modules.inventory.InventoryManager;
import me.lunaiskey.cakeclicker.modules.inventory.inventories.InventoryID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandCakeClicker implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        InventoryManager.get().getInv(InventoryID.CAKE_CLICKER).open(player);
        player.sendMessage(Component.text("Opening Cake Clicker.").color(NamedTextColor.GREEN));
        return true;
    }
}
