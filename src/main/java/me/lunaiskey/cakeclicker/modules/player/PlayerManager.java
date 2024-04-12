package me.lunaiskey.cakeclicker.modules.player;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerManager {

    private static PlayerManager instance;
    private Map<UUID,LunixPlayer> playerMap;

    private PlayerManager() {
        playerMap = new HashMap<>();
    }

    public static PlayerManager get() {
        if (instance == null) instance = new PlayerManager();
        return instance;
    }

    public LunixPlayer getLunixPlayer(UUID playerUUID) {
        LunixPlayer player = playerMap.get(playerUUID);
        if (player == null) {
            player = new LunixPlayer();
            playerMap.put(playerUUID,player);
        }
        return player;
    }

    public LunixPlayer getLunixPlayer(Player player) {
        return getLunixPlayer(player.getUniqueId());
    }
}
