package fr.napotwiixe.stellariauhc.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.napotwiixe.stellariauhc.main;
import fr.napotwiixe.stellariauhc.utils.TimeManager;

public class suhcCommands implements CommandExecutor{

    public suhcCommands(main main){}

    TimeManager timer = new TimeManager();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(args.length >= 1){
            if(args[0].equals("start")){
                if(main.getInstance().run) {
                    sender.sendMessage("§aLa partie est lancée");
                }else{
                    try {
                        main.getInstance().run = true;
                        sender.sendMessage("§aLa partie est lancée");
                        timer.runTaskTimer(main.getInstance(), 0,20);
                        timer.updateScoreBoard();
                        for (Player online : Bukkit.getOnlinePlayers()) {
                            online.setGameMode(GameMode.SURVIVAL);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }else if(args[0].equals("stop")){
                if(!main.getInstance().run){
                    sender.sendMessage("§4La partie n'est pas en cours");
                }else{
                    main.getInstance().run = false;
                    sender.sendMessage("§aLa partie a été stoppée !");
                    timer.cancel();
                    timer.updateScoreBoard();
                }
            }
        }else{
            sender.sendMessage("§6>§f§l§m                                                              §6<");
            sender.sendMessage("UHC\'s definition and rules explanations");
            sender.sendMessage("§6>§f§l§m                                                              §6<");
        }

        return false;
    }
}
