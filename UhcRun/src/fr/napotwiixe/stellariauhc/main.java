package fr.napotwiixe.stellariauhc;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

import fr.napotwiixe.stellariauhc.commands.*;
import fr.napotwiixe.stellariauhc.listeners.OnDeath;
import fr.napotwiixe.stellariauhc.listeners.OnJoin;
import fr.napotwiixe.stellariauhc.utils.ConfigUtils;
public class main extends JavaPlugin{
    
    public static ArrayList<String> freezed_player = new ArrayList<>();

    public Map<UUID, Integer> PlayerKill = new HashMap<UUID, Integer>();
    public Map<UUID, Location> PlayerDeathLoc = new HashMap<UUID, Location>();

    public static main instance;

    @Override
    public void onEnable() {
        instance = this;

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerul naturalRegeneration false");

        for (Player online : Bukkit.getOnlinePlayers()) {
            PlayerKill.put(online.getUniqueId(), 0);
        }

        getCommand("suhc").setExecutor(new suhcCommands());

        Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
        Bukkit.getPluginManager().registerEvents(new OnDeath(), this);

        if(!ConfigUtils.configFileExist(this.getDataFolder(), "config.yml")){
            ConfigUtils.createConfigFile("config.yml");
        }
        File lang = new File(this.getDataFolder(),"languages.yml");
        FileConfiguration languages = YamlConfiguration.loadConfiguration(getFile());
        languages.set("prefix", "&8[&6Setllaria&eUHC&8]");
        languages.set("join", "&7[&a+&7]&r");
        languages.set("start-message", "");
        languages.set("already-running-message", "");
        languages.set("stop-message", "");
        languages.set("already-stop-message", "");
        languages.set("#SCOREBOARD", "");
        try{
            languages.save(lang);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static main getInstance() {
        return instance;
    }

}
