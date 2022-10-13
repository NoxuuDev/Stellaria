package fr.pitrouflette.stellariauhc;

import fr.pitrouflette.stellariauhc.utils.ConfigUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class main extends JavaPlugin {

    public static main instance;

    File files = new File(this.getDataFolder(),"config.yml");
    FileConfiguration configs = new YamlConfiguration().loadConfiguration(files);

    @Override
    public void onEnable(){

        File dossier = new File(String.valueOf(this.getDataFolder()));
        if(!dossier.exists()) dossier.mkdir();

        instance = this;

        if(!ConfigUtils.configFileExist(this.getDataFolder(), "config.yml")){
            ConfigUtils.createConfigFile("config.yml");
        }

        File file = new File(this.getDataFolder(),"config.yml");
        FileConfiguration config = new YamlConfiguration().loadConfiguration(file);
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

}
