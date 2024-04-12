package me.lunaiskey.cakeclicker.modules.player;

import me.lunaiskey.cakeclicker.UpgradeType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LunixPlayer {
    private long clicks;
    private Map<UpgradeType,Integer> upgradeLevels;

    public LunixPlayer() {
        this.clicks = 0;
        this.upgradeLevels = new HashMap<>();
    }

    public long getClicks() {
        return clicks;
    }

    public Integer getUpgradeLevel(UpgradeType upgrade) {
        int level = Objects.requireNonNullElse(upgradeLevels.get(upgrade), 0);
        return level;
    }

    public void incrementClicks(int amount) {
        this.clicks = this.clicks + amount;
        if (this.clicks < 0) {
            this.clicks = 0;
        }
    }

    public void decrementClicks(int amount) {
        incrementClicks(-amount);
    }

    public void incrementUpgradeLevel(UpgradeType upgrade, int amount) {
        if (amount == 0) {
            return;
        }
        Integer level0 = upgradeLevels.get(upgrade);
        int level;
        level = Objects.requireNonNullElse(level0, 0);
        level = level + amount;
        if (level < 0) {
            level = 0;
        }
        upgradeLevels.put(upgrade,level);
    }

    public void decrementUpgradeLevel(UpgradeType upgrade, int amount) {
        incrementUpgradeLevel(upgrade,-amount);
    }
}
