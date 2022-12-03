package fr.pitrouflette.stellariabedwars.listeners;

import fr.pitrouflette.stellariabedwars.main;
import fr.pitrouflette.stellariabedwars.manager.InventoryManager;
import fr.pitrouflette.stellariabedwars.manager.ItemsManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class OnClickInventory implements Listener {

    FileConfiguration langg = main.getInstance().getLanguagesFile();

    InventoryManager invManager = new InventoryManager();
    ItemsManager itemsManager = new ItemsManager();

    @EventHandler
    public void PlayerInteract(PlayerInteractEvent ev){
        if(!(ev.getPlayer().getItemInHand().hasItemMeta())){return;}
        if(ev.getAction().equals(Action.RIGHT_CLICK_AIR) && ev.getPlayer().getItemInHand().equals(itemsManager.getItemTeam())){
            invManager.OpenTeamInv(ev.getPlayer());
        }else if(ev.getAction().equals(Action.RIGHT_CLICK_BLOCK) && ev.getPlayer().getItemInHand().equals(itemsManager.getItemTeam())) {
            invManager.OpenTeamInv(ev.getPlayer());
        }
    }

    @EventHandler
    public void OnPlayerClickInventory(InventoryClickEvent ev){

        if(ev.getView().getTitle().equals(langg.getString("Inventory.team.name"))){
            ev.setCancelled(true);
            if(ev.getCurrentItem().equals(itemsManager.getBlue())){
                main.getInstance().PlayerTeam.put(ev.getWhoClicked().getUniqueId(), "B");
                ((Player) ev.getWhoClicked()).sendMessage(langg.getString("prefix") + langg.getString("messages.team.team-bleu-join"));
            }
            if(ev.getCurrentItem().equals(itemsManager.getRed())){
                main.getInstance().PlayerTeam.put(ev.getWhoClicked().getUniqueId(), "R");
                ((Player) ev.getWhoClicked()).sendMessage(langg.getString("prefix") + langg.getString("messages.team.team-red-join"));
            }
            if(ev.getCurrentItem().equals(itemsManager.getGreen())){
                main.getInstance().PlayerTeam.put(ev.getWhoClicked().getUniqueId(), "G");
                ((Player) ev.getWhoClicked()).sendMessage(langg.getString("prefix") + langg.getString("messages.team.team-green-join"));
            }
            if(ev.getCurrentItem().equals(itemsManager.getYellow())){
                main.getInstance().PlayerTeam.put(ev.getWhoClicked().getUniqueId(), "Y");
                ((Player) ev.getWhoClicked()).sendMessage(langg.getString("prefix") + langg.getString("messages.team.team-yellow-join"));
            }
        }
    }
}
