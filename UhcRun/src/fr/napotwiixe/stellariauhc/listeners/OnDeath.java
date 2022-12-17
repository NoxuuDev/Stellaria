package fr.napotwiixe.stellariauhc.listeners;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import fr.napotwiixe.stellariauhc.main;
import fr.napotwiixe.stellariauhc.utils.TimeManager;

public class OnDeath implements Listener {

    public int remaining_players = 0;
    public UUID winer;

    TimeManager timer = new TimeManager();


    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();

        player.setGameMode(GameMode.SPECTATOR);

        for (Player online : Bukkit.getOnlinePlayers()) {
            if (online.getGameMode().equals(GameMode.SURVIVAL)) {
                remaining_players++;
            }
        }
        if (remaining_players == 1) {
            for (Player online : Bukkit.getOnlinePlayers()) {
                if (online.getGameMode().equals(GameMode.SURVIVAL)) {
                    winer = online.getUniqueId();
                }
            }
            main.getInstance().run = false;
            timer.cancel();
            timer.updateScoreBoard();
            Bukkit.broadcastMessage("fin " + Bukkit.getPlayer(winer) + " a gagné");
            
        }
    }

}
