package fr.pitrouflette.stellariabedwars.listeners;

import fr.pitrouflette.stellariabedwars.main;
import fr.pitrouflette.stellariabedwars.utils.InventoryManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.File;

public class OnClickInventory implements Listener {

    File lang = new File(main.getInstance().getDataFolder(),"lang.yml");
    FileConfiguration langg = YamlConfiguration.loadConfiguration(lang);

    InventoryManager invManager = new InventoryManager();

    @EventHandler
    public void PlayerInteract(PlayerInteractEvent ev){
        if(ev.getAction().equals(Action.RIGHT_CLICK_AIR)){
            invManager.OpenTeamInv(ev.getPlayer());
        }
        if(ev.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            invManager.OpenTeamInv(ev.getPlayer());
        }
    }

    @EventHandler
    public void OnPlayerClickInventory(InventoryClickEvent ev){
        Player player = (Player) ev.getWhoClicked();

        if(ev.getView().getTitle().equals(langg.getString("Inventory.team.name"))){
            ev.setCancelled(true);
        }
    }
}
