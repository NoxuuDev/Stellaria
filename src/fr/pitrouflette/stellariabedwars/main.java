package fr.pitrouflette.stellariabedwars;

import fr.pitrouflette.stellariabedwars.commands.sbwCommands;
import fr.pitrouflette.stellariabedwars.listeners.OnBreakBlock;
import fr.pitrouflette.stellariabedwars.listeners.OnClickInventory;
import fr.pitrouflette.stellariabedwars.listeners.OnDeath;
import fr.pitrouflette.stellariabedwars.listeners.OnJoin;
import fr.pitrouflette.stellariabedwars.utils.ConfigUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class main extends JavaPlugin {

    public Map<UUID, Integer> PlayerKill = new HashMap<UUID, Integer>();
    public Map<UUID, String> PlayerTeam = new HashMap<UUID, String>();

    public String map = "";

    public boolean blueBed = true;
    public boolean yellowBed = true;
    public boolean redBed = true;
    public boolean greenBed = true;

    public boolean run = false;

    public static main instance;

    public File file = new File(this.getDataFolder(),"config.yml");
    public FileConfiguration config = YamlConfiguration.loadConfiguration(file);

    public File lang = new File(this.getDataFolder(),"lang.yml");
    public FileConfiguration languages = YamlConfiguration.loadConfiguration(lang);

    @Override
    public void onEnable(){

        Bukkit.broadcastMessage("Bonjour les gns du serveur le pl est fonctionelle");

        for(Player online : Bukkit.getOnlinePlayers()){
            PlayerKill.put(online.getUniqueId(), 0);
        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "gamerule keepInventory true");

        instance = this;

        //-----------------------Commands-----------------------\\

        getCommand("sbw").setExecutor(new sbwCommands(this));

        // -----------------------Listeners-----------------------\\

        Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
        Bukkit.getPluginManager().registerEvents(new OnDeath(), this);
        Bukkit.getPluginManager().registerEvents(new OnClickInventory(), this);
        Bukkit.getPluginManager().registerEvents(new OnBreakBlock(), this);

        //-----------------------Config Files-----------------------\\

        updateFiles();


    }

    public void updateFiles(){
        if(!ConfigUtils.configFileExist(this.getDataFolder(), "config.yml")){
            ConfigUtils.createConfigFile("config.yml");
        }

        try{
            config.save(file);
        }catch (IOException e){
            e.printStackTrace();
        }

        if(!ConfigUtils.configFileExist(this.getDataFolder(), "lang.yml")){
            ConfigUtils.createConfigFile("lang.yml");
        }

        try{
            languages.save(lang);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration getLanguagesFile(){ return languages; }
    public FileConfiguration getConfigFile(){ return config; }

    public static main getInstance() {
        return instance;
    }
}
