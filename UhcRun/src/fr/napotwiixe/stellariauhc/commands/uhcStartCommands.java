package fr.napotwiixe.stellariauhc.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.napotwiixe.stellariauhc.main;
import fr.napotwiixe.stellariauhc.utils.TimeManager;

public class uhcStartCommands implements CommandExecutor{

    public uhcStartCommands(main main) {}

    TimeManager timer = new TimeManager();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(main.getInstance().run){
            sender.sendMessage("§4La Partie est déjà lancée !!");
        }else {
            main.getInstance().run = true;
            sender.sendMessage("4La Partie est lancée !");
            timer.runTaskTimer(main.getInstance(), 0,20);
            timer.updateScoreBoard();
            for(Player online : Bukkit.getOnlinePlayers()){
                online.setGameMode(GameMode.SURVIVAL);
            }
        }

        return true;
    }
    
}