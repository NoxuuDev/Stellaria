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

                                                                    //-----------GUI----------//

    public ItemStack getGUIBorder(){

        ItemStack GuiBorder = new ItemStack(Material.WOOL);
        ItemMeta GuiBorderM = GuiBorder.getItemMeta();
        GuiBorderM.setDisplayName(langg.getString("Items.GUI.border.name.defaultName"));
        GuiBorderM.setLore(langg.getStringList("Items.GUI.border.lore"));
        GuiBorderM.addEnchant(Enchantment.DURABILITY, 1, true);
        GuiBorderM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        GuiBorder.setItemMeta(GuiBorderM);

        return GuiBorder;
    }

                                                                    //-----------TEAM----------//

    public ItemStack getItemTeam(){

        ItemStack teamItem = new ItemStack(Material.WOOL);
        ItemMeta teamM = teamItem.getItemMeta();
        teamM.setDisplayName(langg.getString("Items.team.name.defaultName"));
        teamM.setLore(langg.getStringList("Items.team.lore"));
        teamM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamItem.setItemMeta(teamM);

        return teamItem;
    }

    public ItemStack getRed(){

        ItemStack teamRed = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta teamRedM = teamRed.getItemMeta();
        teamRedM.setDisplayName(langg.getString("Items.red.name.defaultName"));
        teamRedM.setLore(langg.getStringList("Items.red.lore"));
        teamRedM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamRedM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamRed.setItemMeta(teamRedM);

        return teamRed;
    }

    public ItemStack getGreen(){

        ItemStack teamGreen = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta teamGreenM = teamGreen.getItemMeta();
        teamGreenM.setDisplayName(langg.getString("Items.green.name.defaultName"));
        teamGreenM.setLore(langg.getStringList("Items.green.lore"));
        teamGreenM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamGreenM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamGreen.setItemMeta(teamGreenM);

        return teamGreen;
    }

    public ItemStack getBlue(){

        ItemStack teamBlue = new ItemStack(Material.LAPIS_BLOCK);
        ItemMeta teamBlueM = teamBlue.getItemMeta();
        teamBlueM.setDisplayName(langg.getString("Items.blue.name.defaultName"));
        teamBlueM.setLore(langg.getStringList("Items.blue.lore"));
        teamBlueM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamBlueM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamBlue.setItemMeta(teamBlueM);

        return teamBlue;
    }

    public ItemStack getYellow(){

        ItemStack teamYellow = new ItemStack(Material.GLOWSTONE);
        ItemMeta teamYellowM = teamYellow.getItemMeta();
        teamYellowM.setDisplayName(langg.getString("Items.yellow.name.defaultName"));
        teamYellowM.setLore(langg.getStringList("Items.yellow.lore"));
        teamYellowM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamYellowM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamYellow.setItemMeta(teamYellowM);

        return teamYellow;
    }
}
