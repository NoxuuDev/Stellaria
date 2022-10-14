package fr.pitrouflette.stellariauhc.listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent ev){

        Player player = ev.getEntity().getPlayer();

        player.setGameMode(GameMode.SPECTATOR);

    }
}
