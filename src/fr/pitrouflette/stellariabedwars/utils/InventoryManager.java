package fr.pitrouflette.stellariabedwars.utils;

import fr.pitrouflette.stellariabedwars.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.File;

public class InventoryManager {

    File lang = new File(main.getInstance().getDataFolder(),"lang.yml");
    FileConfiguration langg = YamlConfiguration.loadConfiguration(lang);

    public void OpenTeamInv(Player player){
        Inventory inv = Bukkit.createInventory(null, 9*3 ,langg.getString("Inventory.team.name"));

        player.openInventory(inv);
    }
}
