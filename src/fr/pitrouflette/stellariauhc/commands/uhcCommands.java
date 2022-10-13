package fr.pitrouflette.stellariauhc.commands;

import fr.pitrouflette.stellariauhc.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class uhcCommands implements CommandExecutor {

    public uhcCommands(main main) {}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player p)){return false;}

        p.sendMessage("§6>§f§l§m                                                              §6<");
        p.sendMessage("UHC s definition and rules explanation");
        p.sendMessage("§6>§f§l§m                                                              §6<");

        return true;
    }


}
