package fr.pitrouflette.stellariauhc.commands;

import fr.pitrouflette.stellariauhc.main;
import fr.pitrouflette.stellariauhc.utils.TimeManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class uhcStartCommands implements CommandExecutor {


    public uhcStartCommands(main main) {}

    TimeManager timer = new TimeManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(main.getInstance().run){
            sender.sendMessage("§4La partie est déja lancée !!");
        }else{
            main.getInstance().run = true;
            sender.sendMessage("§aLa partie est lancée !!");
            timer.runTaskTimer(main.getInstance(), 0,20);
            timer.updateScoreBoard();
            for(Player online : Bukkit.getOnlinePlayers()){
                online.setGameMode(GameMode.SURVIVAL);
            }
        }

        return true;
    }
}
