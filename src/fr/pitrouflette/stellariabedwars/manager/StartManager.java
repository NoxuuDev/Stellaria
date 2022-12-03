package fr.pitrouflette.stellariabedwars.manager;

import fr.pitrouflette.stellariabedwars.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class StartManager {

    FileConfiguration configs = main.getInstance().getConfigFile();
    FileConfiguration langg = main.getInstance().getLanguagesFile();

    Location red = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.spawns.map1.x") , configs.getInt("coordonnees.spawns.lobby.y"), configs.getInt("coordonnees.spawns.lobby.z"), 400, 500);
    Location blue = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.spawns.map1.x") , configs.getInt("coordonnees.spawns.lobby.y"), configs.getInt("coordonnees.spawns.lobby.z"), 400, 500);
    Location yellow = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.spawns.map1.x") , configs.getInt("coordonnees.spawns.lobby.y"), configs.getInt("coordonnees.spawns.lobby.z"), 400, 500);
    Location green = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.spawns.map1.x") , configs.getInt("coordonnees.spawns.lobby.y"), configs.getInt("coordonnees.spawns.lobby.z"), 400, 500);

    public void tpPlayerBase(Player player){

        if(main.getInstance().map.equals(configs.getString("maps.map1.name"))){
            Bukkit.broadcastMessage("world");
            red = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.bed.map1.x") , 10, configs.getInt("coordonnees.bed.map1.z"), 400, 500);
            blue = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.bed.map1.x") , 10, configs.getInt("coordonnees.bed.map1.z"), 400, 500);
            yellow = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.bed.map1.x") , 10, configs.getInt("coordonnees.bed.map1.z"), 400, 500);
            green = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.bed.map1.x") , 10, configs.getInt("coordonnees.bed.map1.z"), 400, 500);
        }else if(main.getInstance().map.equals(configs.getString("maps.map2.name"))){
            red = new Location(Bukkit.getWorld("maps.map2.name"), configs.getInt("coordonnees.bed.map2.x") , 10, configs.getInt("coordonnees.bed.map2.z"), 400, 500);
            blue = new Location(Bukkit.getWorld("maps.map2.name"), configs.getInt("coordonnees.bed.map2.x") , 10, configs.getInt("coordonnees.bed.map2.z"), 400, 500);
            yellow = new Location(Bukkit.getWorld("maps.map2.name"), configs.getInt("coordonnees.bed.map2.x") , 10, configs.getInt("coordonnees.bed.map2.z"), 400, 500);
            green = new Location(Bukkit.getWorld("maps.map2.name"), configs.getInt("coordonnees.bed.map2.x") , 10, configs.getInt("coordonnees.bed.map2.z"), 400, 500);
        }else if(main.getInstance().map.equals(configs.getString("maps.map3.name"))){
            red = new Location(Bukkit.getWorld("maps.map3.name"), configs.getInt("coordonnees.bed.map3.x") , 10, configs.getInt("coordonnees.bed.map3.z"), 400, 500);
            blue = new Location(Bukkit.getWorld("maps.map3.name"), configs.getInt("coordonnees.bed.map3.x") , 10, configs.getInt("coordonnees.bed.map3.z"), 400, 500);
            yellow = new Location(Bukkit.getWorld("maps.map3.name"), configs.getInt("coordonnees.bed.map3.x") , 10, configs.getInt("coordonnees.bed.map3.z"), 400, 500);
            green = new Location(Bukkit.getWorld("maps.map3.name"), configs.getInt("coordonnees.bed.map3.x") , 10, configs.getInt("coordonnees.bed.map3.z"), 400, 500);
        }else if(main.getInstance().map.equals(configs.getString("maps.map4.name"))){
            red = new Location(Bukkit.getWorld("maps.map4.name"), configs.getInt("coordonnees.bed.map4.x") , 10, configs.getInt("coordonnees.bed.map4.z"), 400, 500);
            blue = new Location(Bukkit.getWorld("maps.map4.name"), configs.getInt("coordonnees.bed.map4.x") , 10, configs.getInt("coordonnees.bed.map4.z"), 400, 500);
            yellow = new Location(Bukkit.getWorld("maps.map4.name"), configs.getInt("coordonnees.bed.map4.x") , 10, configs.getInt("coordonnees.bed.map4.z"), 400, 500);
            green = new Location(Bukkit.getWorld("maps.map4.name"), configs.getInt("coordonnees.bed.map4.x") , 10, configs.getInt("coordonnees.bed.map4.z"), 400, 500);
        }

        switch (main.getInstance().PlayerTeam.get(player.getUniqueId())) {
            case "R" -> {
                player.teleport(red);
                player.setHealth(player.getMaxHealth());
                player.sendMessage(red.toString());
                player.sendMessage(langg.getString("prefix") + langg.getString("messages.tp-to-base"));
            }
            case "B" -> {
                player.teleport(blue);
                player.setHealth(player.getMaxHealth());
                player.sendMessage(red.toString());
                player.sendMessage(langg.getString("prefix") + langg.getString("messages.tp-to-base"));
            }
            case "Y" -> {
                player.teleport(yellow);
                player.setHealth(player.getMaxHealth());
                player.sendMessage(red.toString());
                player.sendMessage(langg.getString("prefix") + langg.getString("messages.tp-to-base"));
            }
            case "G" -> {
                player.teleport(green);
                player.setHealth(player.getMaxHealth());
                player.sendMessage(red.toString());
                player.sendMessage(langg.getString("prefix") + langg.getString("messages.tp-to-base"));
            }
        }
    }
}