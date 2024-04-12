package me.lunaiskey.cakeclicker;

import me.lunaiskey.cakeclicker.listeners.PlayerListener;
import me.lunaiskey.cakeclicker.modules.inventory.InventoryManager;
import me.lunaiskey.cakeclicker.modules.inventory.commands.CommandCakeClicker;
import me.lunaiskey.cakeclicker.modules.inventory.holders.LunixHolder;
import me.lunaiskey.cakeclicker.modules.player.LunixPlayer;
import me.lunaiskey.cakeclicker.modules.player.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class CakeClicker extends JavaPlugin {

    private static CakeClicker instance;

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        instanceManagers(); //make managers generate their instance
        registerListeners();
        setupTasks();
        getCommand("cakeclicker").setExecutor(new CommandCakeClicker());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void instanceManagers() {
        PlayerManager.get();
        InventoryManager.get();
    }

    private void setupTasks() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    LunixPlayer lunixPlayer = PlayerManager.get().getLunixPlayer(player);
                    lunixPlayer.incrementClicks(lunixPlayer.getUpgradeLevel(UpgradeType.PER_SECOND)*2);
                    InventoryHolder holder = player.getOpenInventory().getTopInventory().getHolder();
                    if (holder instanceof LunixHolder lunixHolder) {
                        InventoryManager.get().getInv(lunixHolder.getID()).updateGUI(player);
                    }
                }
            }
        }.runTaskTimer(this,0,20);
    }

    public static CakeClicker getInstance() {
        return instance;
    }

    private void registerListeners() {
        registerListener(new PlayerListener());
    }

    private void registerListener(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener,this);
    }
}
