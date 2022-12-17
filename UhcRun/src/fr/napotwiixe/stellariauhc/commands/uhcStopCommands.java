package fr.napotwiixe.stellariauhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.napotwiixe.stellariauhc.main;
import fr.napotwiixe.stellariauhc.utils.TimeManager;

public class uhcStopCommands implements CommandExecutor {

    public uhcStopCommands(main main) {}

    TimeManager timer = new TimeManager();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if(!main.getInstance().run){
            sender.sendMessage("§4La partie n'est pas en cours");
        }else{
            main.getInstance().run = false;
            sender.sendMessage("§4La Partie a été stoppée !");
        }
        
        return true;
    }

}