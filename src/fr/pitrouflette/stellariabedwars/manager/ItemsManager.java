package fr.pitrouflette.stellariabedwars.manager;

import fr.pitrouflette.stellariabedwars.main;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class ItemsManager {


    FileConfiguration langg = main.getInstance().getLanguagesFile();

                                                                    //-----------GUI----------//

    public ItemStack getGUIBorder(){

        ItemStack GuiBorder = new ItemStack(Material.STAINED_GLASS_PANE);
        ItemMeta GuiBorderM = GuiBorder.getItemMeta();
        GuiBorderM.setDisplayName(langg.getString("Items.GUI.border.name.defaultName").replace("&", "§"));
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
        teamM.setDisplayName(langg.getString("Items.team.name.defaultName").replace("&", "§"));
        teamM.setLore(langg.getStringList("Items.team.lore"));
        teamM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamItem.setItemMeta(teamM);

        return teamItem;
    }

    public ItemStack getRed(){

        ItemStack teamRed = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta teamRedM = teamRed.getItemMeta();
        teamRedM.setDisplayName(langg.getString("Items.red.name.defaultName").replace("&", "§"));
        teamRedM.setLore(langg.getStringList("Items.red.lore"));
        teamRedM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamRedM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamRed.setItemMeta(teamRedM);

        return teamRed;
    }

    public ItemStack getGreen(){

        ItemStack teamGreen = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta teamGreenM = teamGreen.getItemMeta();
        teamGreenM.setDisplayName(langg.getString("Items.green.name.defaultName").replace("&", "§"));
        teamGreenM.setLore(langg.getStringList("Items.green.lore"));
        teamGreenM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamGreenM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamGreen.setItemMeta(teamGreenM);

        return teamGreen;
    }

    public ItemStack getBlue(){

        ItemStack teamBlue = new ItemStack(Material.LAPIS_BLOCK);
        ItemMeta teamBlueM = teamBlue.getItemMeta();
        teamBlueM.setDisplayName(langg.getString("Items.blue.name.defaultName").replace("&", "§"));
        teamBlueM.setLore(langg.getStringList("Items.blue.lore"));
        teamBlueM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamBlueM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamBlue.setItemMeta(teamBlueM);

        return teamBlue;
    }

    public ItemStack getYellow(){

        ItemStack teamYellow = new ItemStack(Material.GLOWSTONE);
        ItemMeta teamYellowM = teamYellow.getItemMeta();
        teamYellowM.setDisplayName(langg.getString("Items.yellow.name.defaultName").replace("&", "§"));
        teamYellowM.setLore(langg.getStringList("Items.yellow.lore"));
        teamYellowM.addEnchant(Enchantment.DURABILITY, 1, true);
        teamYellowM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        teamYellow.setItemMeta(teamYellowM);

        return teamYellow;
    }
                                                        //-----------TEAM----------//

    public ItemStack createItemBlue(Material leatherPiece, String displayName) {
        ItemStack item = new ItemStack(leatherPiece);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setColor(Color.BLUE);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack createItemGreen(Material leatherPiece, String displayName) {
        ItemStack item = new ItemStack(leatherPiece);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setColor(Color.GREEN);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack createItemRed(Material leatherPiece, String displayName) {
        ItemStack item = new ItemStack(leatherPiece);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setColor(Color.RED);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack createItemYellow(Material leatherPiece, String displayName) {
        ItemStack item = new ItemStack(leatherPiece);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setDisplayName(displayName);
        meta.setColor(Color.YELLOW);
        item.setItemMeta(meta);
        return item;
    }

}
