package fr.pitrouflette.stellariabedwars.utils;

import fr.pitrouflette.stellariabedwars.main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;

public class ItemsManager {

    File lang = new File(main.getInstance().getDataFolder(),"lang.yml");
    FileConfiguration langg = YamlConfiguration.loadConfiguration(lang);

    //-----------TEAM----------//
    public ItemStack getItemTeam(){

        ItemStack teamItem = new ItemStack(Material.BANNER);
        ItemMeta teamM = teamItem.getItemMeta();
        teamM.setDisplayName(langg.getString("Items.team.name.defaultName"));
        teamM.setLore(langg.getStringList("Items.team.lore"));
        teamM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamItem.setItemMeta(teamM);

        return teamItem;
    }
}
