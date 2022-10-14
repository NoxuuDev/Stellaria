package fr.pitrouflette.stellariauhc.listeners;

import fr.pitrouflette.stellariauhc.main;
import fr.pitrouflette.stellariauhc.utils.TimeManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;

public class OnJoin implements Listener {

    File files = new File(main.instance.getDataFolder(),"config.yml");
    FileConfiguration configs = YamlConfiguration.loadConfiguration(files);

    TimeManager timer = new TimeManager();

    @EventHandler
    public void OnQuit(PlayerQuitEvent ev){
        timer.updateScoreBoard();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent ev){

        ev.setJoinMessage(
                configs.getString("join").replaceAll("&", "§") + "§7" + ev.getPlayer().getDisplayName() + "§7(" + main.getInstance().getServer().getOnlinePlayers().size() + "/" + configs.getString("rules.max-player") + ")"
        );

        timer.updateScoreBoard();
    }
}
