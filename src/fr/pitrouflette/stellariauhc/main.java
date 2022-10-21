package fr.pitrouflette.stellariauhc;

import fr.pitrouflette.stellariauhc.commands.suhcCommands;
import fr.pitrouflette.stellariauhc.listeners.OnDeath;
import fr.pitrouflette.stellariauhc.listeners.OnJoin;
import fr.pitrouflette.stellariauhc.utils.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class main extends JavaPlugin {

    public static ArrayList<String> freezed_player = new ArrayList<>();

    public Map<UUID, Integer> PlayerKill = new HashMap<UUID, Integer>();
    public Map<UUID, Location> PlayerDeathLoc = new HashMap<UUID, Location>();

    public static main instance;

    public boolean run = false;

    @Override
    public void onEnable(){

        instance = this;

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule naturalRegeneration false");

        for(Player online : Bukkit.getOnlinePlayers()){
            PlayerKill.put(online.getUniqueId(), 0);
        }

        getCommand("suhc").setExecutor(new suhcCommands(this));

        Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
        Bukkit.getPluginManager().registerEvents(new OnDeath(), this);


        if(!ConfigUtils.configFileExist(this.getDataFolder(), "config.yml")){
            ConfigUtils.createConfigFile("config.yml");
        }

        File file = new File(this.getDataFolder(),"config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("prefix", "&8[&6Setllaria&eUHC&8]");
        config.set("join", "&7[&a+&7]&r");
        config.set("spawnX", 0);
        config.set("spawnY", 0);
        config.set("spawnZ", 0);
        config.set("rules.max-player", 25);
        config.set("rules.max-online", 30);
        config.set("Timer.time", 0);
        try{
            config.save(file);
        }catch (IOException e){
            e.printStackTrace();
        }

        if(!ConfigUtils.configFileExist(this.getDataFolder(), "languages.yml")){
            ConfigUtils.createConfigFile("languages.yml");
        }
        File lang = new File(this.getDataFolder(),"languages.yml");
        FileConfiguration languages = YamlConfiguration.loadConfiguration(file);
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