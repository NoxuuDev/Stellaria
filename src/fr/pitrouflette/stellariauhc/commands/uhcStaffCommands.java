package fr.pitrouflette.stellariauhc.commands;

import fr.pitrouflette.stellariauhc.main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.File;

public class uhcStaffCommands implements CommandExecutor {
    public uhcStaffCommands(main main) {}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        File filees = new File(main.instance.getDataFolder(), "config.yml");
        FileConfiguration configaa = new YamlConfiguration().loadConfiguration(filees);

        if(args.length == 0){
            sender.sendMessage("§4----------------------------------------");
            sender.sendMessage("§4Utilisation de /uhc-staff:");
            sender.sendMessage("§4/uhc-staff + [{invsee} / {ecsee} / {info} / {freez} / {de-freez}] + [player]");
            sender.sendMessage("§4----------------------------------------");
        }

        if(sender instanceof Player){

            if(!sender.hasPermission(configaa.getString("staff-command-permission"))){sender.sendMessage("§4Vous n'avez pas la permission !!"); return true;}

            Player player = (Player) sender;
            if(args[0].equals("invsee") && args.length == 2){

                Player playerInspect = Bukkit.getPlayer(args[1]);
                Inventory ecContent = playerInspect.getInventory();
                Inventory inv = Bukkit.createInventory(null, 9*4, "§6UHC§8>> §1" + playerInspect.getDisplayName() + "§4's §1Inventory");
                inv.setContents(ecContent.getContents());

                player.openInventory(inv);

            }else if(args[0].equals("ecsee") && args.length == 2){

                Player playerInspect = Bukkit.getPlayer(args[1]);
                Inventory ecContent = playerInspect.getEnderChest();
                Inventory inv = Bukkit.createInventory(null, 9*3, "§6UHC§8>> §1" + playerInspect.getDisplayName() + "§4's §1EnderChest");
                inv.setContents(ecContent.getContents());

                player.openInventory(inv);

            }else if(args[0].equals("info") && args.length == 2){

                Player playerInspect = Bukkit.getPlayer(args[1]);

                player.sendMessage("§6----------------------------------------");
                player.sendMessage("");
                player.sendMessage("§1Infomation sur §b" + playerInspect.getName());
                player.sendMessage("§1Pseudo: §b" + playerInspect.getName());
                player.sendMessage("§1UUID: §b" + playerInspect.getUniqueId());
                player.sendMessage("§1IP: §b" + playerInspect.getAddress());
                player.sendMessage("");
                player.sendMessage("§1Vie: §b" + playerInspect.getHealth());
                player.sendMessage("§1Nourriture: §b" + playerInspect.getFoodLevel());
                player.sendMessage("§1XP: §b" + playerInspect.getLevel());
                player.sendMessage(" ");
                player.sendMessage("§6Position: " );
                player.sendMessage("§1Monde: §b" + playerInspect.getWorld().getName());
                player.sendMessage("§1X: §b" + playerInspect.getLocation().getX());
                player.sendMessage("§1Y: §b" + playerInspect.getLocation().getY());
                player.sendMessage("§1Z: §b" + playerInspect.getLocation().getZ());
                player.sendMessage("§1Yaw: §b" + playerInspect.getLocation().getYaw());
                player.sendMessage("§1Pitch: §b" + playerInspect.getLocation().getPitch());
                player.sendMessage("");
                player.sendMessage("§6----------------------------------------");

            }else if (args[0].equals("freez") && args.length == 2){

                Player playerInspect = Bukkit.getPlayer(args[1]);

                if(main.freezed_player.contains(playerInspect.getUniqueId().toString())){

                    player.sendMessage("§4Ce joueur est déja freez !!");

                    return true;

                }

                main.freezed_player.add(playerInspect.getUniqueId().toString());

                if(playerInspect.hasPermission(configaa.getString("staff-command-permission"))){sender.sendMessage("§4Vous ne pouvez pas freez ce joueur !!"); return true;}

                player.sendMessage("§2Vous avez freez " + playerInspect.getDisplayName());

            }else if (args[0].equals("de-freez") && args.length == 2){

                Player playerInspect = Bukkit.getPlayer(args[1]);

                if(main.freezed_player.contains(playerInspect.getUniqueId().toString())){

                    main.freezed_player.remove(playerInspect.getUniqueId().toString());

                    player.sendMessage("§2Vous avez de-freez " + playerInspect.getDisplayName());

                }else{

                    player.sendMessage("§4Ce joueur n'est pas freez, par conséquant, vous ne pouvez pas le de-freez !");

                }

            }else{

                player.sendMessage("§4----------------------------------------");
                player.sendMessage("§4Utilisation de /uhc-staff:");
                player.sendMessage("§4/uhc-staff + [{invsee} / {ecsee} / {info} / {freez} / {de-freez}] + [player]");
                player.sendMessage("§4----------------------------------------");

            }

        }else{

            sender.sendMessage("§4Cette command ne peut etre exécuté par la console !!");

        }

        return true;

    }
}
