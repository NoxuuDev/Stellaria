package fr.pitrouflette.stellariabedwars.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class CooldonwManager {

    public static HashMap<UUID, Double> cooldowns = new HashMap<UUID, Double>();

    public static void setCooldown(Player player, int seconds){
        double delay = System.currentTimeMillis() + (seconds * 1000L);
        cooldowns.put(player.getUniqueId(), delay);
    }

    public static int getCooldown(Player player){
        return Math.toIntExact(Math.round((cooldowns.get(player.getUniqueId()) - System.currentTimeMillis()) / 1000));
    }

    public static boolean checkCooldown(Player player){
        if(!cooldowns.containsKey(player.getUniqueId()) || cooldowns.get(player.getUniqueId()) <= System.currentTimeMillis()){
            return true;
        }
        return false;
    }

}
