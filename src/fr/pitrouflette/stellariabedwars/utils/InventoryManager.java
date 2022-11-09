package fr.pitrouflette.stellariabedwars.utils;

import fr.pitrouflette.stellariabedwars.main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.File;

public class InventoryManager {

    ItemsManager itemsManager = new ItemsManager();

    File lang = new File(main.getInstance().getDataFolder(),"lang.yml");
    FileConfiguration langg = YamlConfiguration.loadConfiguration(lang);

    public void OpenTeamInv(Player player){
        Inventory inv = Bukkit.createInventory(null, 9*3 ,langg.getString("Inventory.team.name").replace("&", "§"));

        inv.setItem(0, itemsManager.getGUIBorder());
        inv.setItem(1, itemsManager.getGUIBorder());
        inv.setItem(2, itemsManager.getGUIBorder());
        inv.setItem(3, itemsManager.getGUIBorder());
        inv.setItem(4, itemsManager.getGUIBorder());
        inv.setItem(5, itemsManager.getGUIBorder());
        inv.setItem(6, itemsManager.getGUIBorder());
        inv.setItem(7, itemsManager.getGUIBorder());
        inv.setItem(8, itemsManager.getGUIBorder());
        inv.setItem(9, itemsManager.getGUIBorder());
        inv.setItem(10, itemsManager.getRed());
        inv.setItem(11, itemsManager.getGUIBorder());
        inv.setItem(12, itemsManager.getBlue());
        inv.setItem(13, itemsManager.getGUIBorder());
        inv.setItem(14, itemsManager.getGreen());
        inv.setItem(15, itemsManager.getGUIBorder());
        inv.setItem(16, itemsManager.getYellow());
        inv.setItem(15, itemsManager.getGUIBorder());
        inv.setItem(17, itemsManager.getGUIBorder());
        inv.setItem(18, itemsManager.getGUIBorder());
        inv.setItem(19, itemsManager.getGUIBorder());
        inv.setItem(21, itemsManager.getGUIBorder());
        inv.setItem(22, itemsManager.getGUIBorder());
        inv.setItem(23, itemsManager.getGUIBorder());
        inv.setItem(24, itemsManager.getGUIBorder());
        inv.setItem(25, itemsManager.getGUIBorder());
        inv.setItem(26, itemsManager.getGUIBorder());

        player.openInventory(inv);
    }
}
