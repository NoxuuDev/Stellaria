package fr.pitrouflette.stellariabedwars.listeners;

import fr.pitrouflette.stellariabedwars.main;
import fr.pitrouflette.stellariabedwars.manager.TimeManager;
import fr.pitrouflette.stellariabedwars.utils.CooldonwManager;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {

    FileConfiguration configs = main.getInstance().getConfigFile();
    FileConfiguration langg = main.getInstance().getLanguagesFile();

    public Location lobby = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.spawns.lobby.x") , configs.getInt("coordonnees.spawns.lobby.y") + 1, configs.getInt("coordonnees.spawns.lobby.z"), 400, 500);


    TimeManager timeManager = new TimeManager();

    @EventHandler
    public void OnDiePlayer(PlayerDeathEvent ev){

        Player player = ev.getEntity();

        ((CraftPlayer)player).getHandle().playerConnection.a(new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN));

        if(ev.getEntity().getKiller() != null){
            main.getInstance().PlayerKill.put(ev.getEntity().getKiller().getUniqueId(), main.getInstance().PlayerKill.get(ev.getEntity().getKiller().getUniqueId()) + 1);
        }

        timeManager.updateScoreBoard();

        ev.setDeathMessage(langg.getString("messages.diedM").replace("{PlayerName}", ev.getEntity().getDisplayName()));

        ev.getEntity().setGameMode(GameMode.SPECTATOR);
        CooldonwManager.setCooldown(ev.getEntity(), 5);
        ev.getEntity().teleport(lobby);
    }
}
