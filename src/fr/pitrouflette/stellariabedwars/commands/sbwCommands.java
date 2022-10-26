package fr.pitrouflette.stellariabedwars.commands;

import fr.pitrouflette.stellariabedwars.main;
import fr.pitrouflette.stellariabedwars.utils.TimeManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class sbwCommands implements CommandExecutor {
    public sbwCommands(main main) {}

    TimeManager timer = new TimeManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(args.length >= 1){
            if(args[0].equals("start")){
                if(main.getInstance().run){
                    sender.sendMessage("§4La partie est déja lancée !!");
                }else{
                    try{
                        main.getInstance().run = true;
                        sender.sendMessage("§aLa partie est lancée !!");
                        timer.runTaskTimer(main.getInstance(), 0,20);
                        timer.updateScoreBoard();
                        for(Player online : Bukkit.getOnlinePlayers()){
                            online.setGameMode(GameMode.SURVIVAL);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }else if(args[0].equals("stop")){
                if(!main.getInstance().run){
                    sender.sendMessage("§4La partie n'est pas en cours");
                }else{
                    main.getInstance().run = false;
                    sender.sendMessage("§aLa partie a été stopée!");
                    timer.cancel();
                    timer.updateScoreBoard();
                }
            }
        }else{
            sender.sendMessage("§6>§f§l§m                                                              §6<");
            sender.sendMessage("UHC s definition and rules explanation");
            sender.sendMessage("§6>§f§l§m                                                              §6<");
        }

        return true;
    }

}
