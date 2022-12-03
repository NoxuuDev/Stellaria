package fr.pitrouflette.stellariabedwars.commands;

import fr.pitrouflette.stellariabedwars.main;
import fr.pitrouflette.stellariabedwars.manager.ItemsManager;
import fr.pitrouflette.stellariabedwars.manager.StartManager;
import fr.pitrouflette.stellariabedwars.manager.TimeManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class sbwCommands implements CommandExecutor {
    public sbwCommands(main main) {}

    FileConfiguration langg = main.getInstance().getLanguagesFile();
    FileConfiguration configs = main.getInstance().getConfigFile();

    String prefix = langg.getString("prefix");

    TimeManager timer = new TimeManager();
    StartManager startManager = new StartManager();
    ItemsManager itemsManager = new ItemsManager();

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
                            timer.initTeam(online, main.getInstance().PlayerTeam.get(online.getUniqueId()));
                            online.getInventory().clear();
                            switch (main.getInstance().PlayerTeam.get(online.getUniqueId())) {
                                case "B" -> {
                                    online.getInventory().setBoots(itemsManager.createItemBlue(Material.LEATHER_BOOTS, langg.getString("Items.boots-name.leather")));
                                    online.getInventory().setLeggings(itemsManager.createItemBlue(Material.LEATHER_LEGGINGS, langg.getString("Items.leggins-name.leather")));
                                    online.getInventory().setChestplate(itemsManager.createItemBlue(Material.LEATHER_CHESTPLATE, langg.getString("Items.chestplate-name.leather")));
                                    online.getInventory().setHelmet(itemsManager.createItemBlue(Material.LEATHER_HELMET, langg.getString("Items.helmet-name.leather")));
                                    online.setCustomName("§1" + online.getDisplayName() + "§r");
                                    online.setCustomNameVisible(true);
                                    online.setPlayerListName(online.getCustomName());
                                    online.setDisplayName(online.getCustomName());
                                }
                                case "R" -> {
                                    online.getInventory().setBoots(itemsManager.createItemRed(Material.LEATHER_BOOTS, langg.getString("Items.boots-name.leather")));
                                    online.getInventory().setLeggings(itemsManager.createItemRed(Material.LEATHER_LEGGINGS, langg.getString("Items.leggins-name.leather")));
                                    online.getInventory().setChestplate(itemsManager.createItemRed(Material.LEATHER_CHESTPLATE, langg.getString("Items.chestplate-name.leather")));
                                    online.getInventory().setHelmet(itemsManager.createItemRed(Material.LEATHER_HELMET, langg.getString("Items.helmet-name.leather")));
                                    online.setCustomName("§4" + online.getDisplayName() + "§r");
                                    online.setCustomNameVisible(true);
                                    online.setPlayerListName(online.getCustomName());
                                    online.setDisplayName(online.getCustomName());
                                }
                                case "Y" -> {
                                    online.getInventory().setBoots(itemsManager.createItemYellow(Material.LEATHER_BOOTS, langg.getString("Items.boots-name.leather")));
                                    online.getInventory().setLeggings(itemsManager.createItemYellow(Material.LEATHER_LEGGINGS, langg.getString("Items.leggins-name.leather")));
                                    online.getInventory().setChestplate(itemsManager.createItemYellow(Material.LEATHER_CHESTPLATE, langg.getString("Items.chestplate-name.leather")));
                                    online.getInventory().setHelmet(itemsManager.createItemYellow(Material.LEATHER_HELMET, langg.getString("Items.helmet-name.leather")));
                                    online.setCustomName("§e" + online.getDisplayName() + "§r");
                                    online.setCustomNameVisible(true);
                                    online.setPlayerListName(online.getCustomName());
                                    online.setDisplayName(online.getCustomName());
                                }
                                case "G" -> {
                                    online.getInventory().setBoots(itemsManager.createItemGreen(Material.LEATHER_BOOTS, langg.getString("Items.boots-name.leather")));
                                    online.getInventory().setLeggings(itemsManager.createItemGreen(Material.LEATHER_LEGGINGS, langg.getString("Items.leggins-name.leather")));
                                    online.getInventory().setChestplate(itemsManager.createItemGreen(Material.LEATHER_CHESTPLATE, langg.getString("Items.chestplate-name.leather")));
                                    online.getInventory().setHelmet(itemsManager.createItemGreen(Material.LEATHER_HELMET, langg.getString("Items.helmet-name.leather")));
                                    online.setCustomName("§2" + online.getDisplayName() + "§r");
                                    online.setCustomNameVisible(true);
                                    online.setPlayerListName(online.getCustomName());
                                    online.setDisplayName(online.getCustomName());
                                }
                            }
                            startManager.tpPlayerBase(online);
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
                if(args[1].equals(configs.getString("maps.map1.name"))){
                    main.getInstance().map = args[1];
                    sender.sendMessage(args[1]);
                    return true;
                }else if(args[1].equals(configs.getString("maps.map2.name"))){
                    main.getInstance().map = args[1];
                    sender.sendMessage(args[1]);
                    return true;
                }else if(args[1].equals(configs.getString("maps.map3.name"))){
                    main.getInstance().map = args[1];
                    sender.sendMessage(args[1]);
                    return true;
                }else if(args[1].equals(configs.getString("maps.map4.name"))){
                    main.getInstance().map = args[1];
                    sender.sendMessage(args[1]);
                    return true;
                }
            }else if(args[0].equals("reload")){
                main.getInstance().reloadConfig();
                main.getInstance().updateFiles();
                sender.sendMessage(langg.getString("messages.reload").replace("&", "§"));
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