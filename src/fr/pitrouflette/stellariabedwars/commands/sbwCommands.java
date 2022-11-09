package fr.pitrouflette.stellariabedwars.commands;

import fr.pitrouflette.stellariabedwars.main;
import fr.pitrouflette.stellariabedwars.utils.TimeManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class sbwCommands implements CommandExecutor {
    public sbwCommands(main main) {}


    File lang = new File(main.getInstance().getDataFolder(),"lang.yml");
    FileConfiguration langg = YamlConfiguration.loadConfiguration(lang);

    String prefix = langg.getString("prefix");

    TimeManager timer = new TimeManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(args.length >= 1){
            if(args[0].equals("start")){
                if(main.getInstance().run){
                    sender.sendMessage(prefix + langg.getString("messages.game-already-started-messages").replace("&", "§"));
                }else{
                    try{
                        main.getInstance().run = true;
                        sender.sendMessage(prefix + langg.getString("messages.game-started-messages").replace("&", "§"));
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
                    sender.sendMessage(prefix + langg.getString("messages.game-already-stopped-message").replace("&", "§"));
                }else{
                    main.getInstance().run = false;
                    sender.sendMessage(prefix + langg.getString("messages.game-stopped-message").replace("&", "§"));
                    timer.cancel();
                    timer.updateScoreBoard();
                }
            }else if(args[0].equals("join")){
                if(args[1].equals("map1")){
                    return true;
                }
                if(args[1].equals("map2")){
                    return true;
                }
                if(args[1].equals("map3")){
                    return true;
                }



            }else{
                sender.sendMessage(langg.getString("messages.argument-incorrect"));
            }
        }else{
            sender.sendMessage("§6>§f§l§m                                                              §6<");
            sender.sendMessage("Bedwars definition and rules explanation");
            sender.sendMessage("§6>§f§l§m                                                              §6<");
        }

        return true;
    }

}
