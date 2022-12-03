package fr.pitrouflette.stellariabedwars.listeners;

import fr.pitrouflette.stellariabedwars.main;
import fr.pitrouflette.stellariabedwars.manager.ItemsManager;
import fr.pitrouflette.stellariabedwars.manager.TimeManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnJoin implements Listener {

    ItemsManager ItemsManageur = new ItemsManager();

    FileConfiguration configs = main.getInstance().getConfigFile();
    FileConfiguration langg = main.getInstance().getLanguagesFile();

    public Location lobby = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.spawns.lobby.x") , configs.getInt("coordonnees.spawns.lobby.y") + 1, configs.getInt("coordonnees.spawns.lobby.z"), 400, 500);

    TimeManager timer = new TimeManager();

    @EventHandler
    public void OnQuit(PlayerQuitEvent ev){
        timer.updateScoreBoard();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent ev){

        ev.getPlayer().getInventory().setItem(8, ItemsManageur.getItemTeam());

        ev.getPlayer().teleport(lobby);

        ev.setJoinMessage(
                langg.getString("messages.join").replaceAll("&", "§") + "§7" + ev.getPlayer().getDisplayName() + "§7(" + main.getInstance().getServer().getOnlinePlayers().size() + "/ 16)"
        );

        timer.updateScoreBoard();
    }
}
