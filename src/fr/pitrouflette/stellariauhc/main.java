package fr.pitrouflette.stellariauhc;

import fr.pitrouflette.stellariauhc.commands.uhcCommands;
import fr.pitrouflette.stellariauhc.commands.uhcStaffCommands;
import fr.pitrouflette.stellariauhc.commands.uhcStartCommands;
import fr.pitrouflette.stellariauhc.commands.uhcStopCommands;
import fr.pitrouflette.stellariauhc.listeners.OnDeath;
import fr.pitrouflette.stellariauhc.listeners.OnJoin;
import fr.pitrouflette.stellariauhc.utils.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameRule;
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


    File files = new File(this.getDataFolder(),"config.yml");
    FileConfiguration configs = YamlConfiguration.loadConfiguration(files);

    @Override
    public void onEnable(){

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule naturalRegeneration false");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule forgiveDeadPlayers true");

        for(Player online : Bukkit.getOnlinePlayers()){
            PlayerKill.put(online.getUniqueId(), 0);
        }

        instance = this;

        getCommand("uhc").setExecutor(new uhcCommands(this));
        getCommand("uhc-start").setExecutor(new uhcStartCommands(this));
        getCommand("uhc-stop").setExecutor(new uhcStopCommands(this));
        //getCommand("uhc-staff").setExecutor(new uhcStaffCommands(this));

        Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
        Bukkit.getPluginManager().registerEvents(new OnDeath(), this);

        File dossier = new File(String.valueOf(this.getDataFolder()));
        if(!dossier.exists()) dossier.mkdir();

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
    }
    public static main getInstance() {
        return instance;
    }
}
