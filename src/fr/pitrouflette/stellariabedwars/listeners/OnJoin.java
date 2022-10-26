package fr.pitrouflette.stellariabedwars.listeners;

import fr.pitrouflette.stellariabedwars.main;
import fr.pitrouflette.stellariabedwars.utils.ItemsManager;
import fr.pitrouflette.stellariabedwars.utils.TimeManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;

public class OnJoin implements Listener {

    ItemsManager ItemsManageur = new ItemsManager();

    File files = new File(main.instance.getDataFolder(),"config.yml");
    FileConfiguration configs = YamlConfiguration.loadConfiguration(files);

    TimeManager timer = new TimeManager();

    @EventHandler
    public void OnQuit(PlayerQuitEvent ev){
        timer.updateScoreBoard();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent ev){

        ev.getPlayer().getInventory().setItem(0, ItemsManageur.getItemTeam());

        ev.setJoinMessage(
                configs.getString("join").replaceAll("&", "§") + "§7" + ev.getPlayer().getDisplayName() + "§7(" + main.getInstance().getServer().getOnlinePlayers().size() + "/" + configs.getString("rules.max-player") + ")"
        );

        timer.updateScoreBoard();
    }

}
