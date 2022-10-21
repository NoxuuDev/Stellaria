package fr.pitrouflette.stellariauhc.commands;

import fr.pitrouflette.stellariauhc.main;
import fr.pitrouflette.stellariauhc.utils.TimeManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class uhcStopCommands implements CommandExecutor {

    public uhcStopCommands(main main) {}

    TimeManager timer = new TimeManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!main.getInstance().run){
            sender.sendMessage("§4La partie n'est pas en cours");
        }else{
            main.getInstance().run = false;
            sender.sendMessage("§aLa partie a été stopée!");
        }
        return true;
    }
}
