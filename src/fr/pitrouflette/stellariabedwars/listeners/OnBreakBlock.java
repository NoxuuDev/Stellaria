package fr.pitrouflette.stellariabedwars.listeners;

import fr.pitrouflette.stellariabedwars.main;
import net.minecraft.server.v1_8_R3.Block;
import net.minecraft.server.v1_8_R3.Blocks;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.ArrayList;
import java.util.List;

public class OnBreakBlock implements Listener {

    FileConfiguration configs = main.getInstance().getConfigFile();

    List<Block> breakableBlocks = new ArrayList<Block>();

    public List<Block> getBreakableBlocks() {
        return breakableBlocks;
    }

    Location red1 = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.bed.map1.x") , 10, configs.getInt("coordonnees.bed.map1.z"), 400, 500);
    Location blue1 = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.bed.map1.x") , 10, configs.getInt("coordonnees.bed.map1.z"), 400, 500);
    Location yellow1 = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.bed.map1.x") , 10, configs.getInt("coordonnees.bed.map1.z"), 400, 500);
    Location green1 = new Location(Bukkit.getWorld("world"), configs.getInt("coordonnees.bed.map1.x") , 10, configs.getInt("coordonnees.bed.map1.z"), 400, 500);

    Location red2 = new Location(Bukkit.getWorld("maps.map2.name"), configs.getInt("coordonnees.bed.map2.x") , 10, configs.getInt("coordonnees.bed.map2.z"), 400, 500);
    Location blue2 = new Location(Bukkit.getWorld("maps.map2.name"), configs.getInt("coordonnees.bed.map2.x") , 10, configs.getInt("coordonnees.bed.map2.z"), 400, 500);
    Location yellow2 = new Location(Bukkit.getWorld("maps.map2.name"), configs.getInt("coordonnees.bed.map2.x") , 10, configs.getInt("coordonnees.bed.map2.z"), 400, 500);
    Location green2 = new Location(Bukkit.getWorld("maps.map2.name"), configs.getInt("coordonnees.bed.map2.x") , 10, configs.getInt("coordonnees.bed.map2.z"), 400, 500);

    Location red3 = new Location(Bukkit.getWorld("maps.map3.name"), configs.getInt("coordonnees.bed.map3.x") , 10, configs.getInt("coordonnees.bed.map3.z"), 400, 500);
    Location blue3 = new Location(Bukkit.getWorld("maps.map3.name"), configs.getInt("coordonnees.bed.map3.x") , 10, configs.getInt("coordonnees.bed.map3.z"), 400, 500);
    Location yellow3 = new Location(Bukkit.getWorld("maps.map3.name"), configs.getInt("coordonnees.bed.map3.x") , 10, configs.getInt("coordonnees.bed.map3.z"), 400, 500);
    Location green3 = new Location(Bukkit.getWorld("maps.map3.name"), configs.getInt("coordonnees.bed.map3.x") , 10, configs.getInt("coordonnees.bed.map3.z"), 400, 500);

    Location red4 = new Location(Bukkit.getWorld("maps.map4.name"), configs.getInt("coordonnees.bed.map4.x") , 10, configs.getInt("coordonnees.bed.map4.z"), 400, 500);
    Location blue4 = new Location(Bukkit.getWorld("maps.map4.name"), configs.getInt("coordonnees.bed.map4.x") , 10, configs.getInt("coordonnees.bed.map4.z"), 400, 500);
    Location yellow4 = new Location(Bukkit.getWorld("maps.map4.name"), configs.getInt("coordonnees.bed.map4.x") , 10, configs.getInt("coordonnees.bed.map4.z"), 400, 500);
    Location green4 = new Location(Bukkit.getWorld("maps.map4.name"), configs.getInt("coordonnees.bed.map4.x") , 10, configs.getInt("coordonnees.bed.map4.z"), 400, 500);

    @EventHandler
    public boolean PlayerBreakBlockEvent(BlockBreakEvent ev){
        breakableBlocks.add(Blocks.END_STONE);
        breakableBlocks.add(Blocks.WOOL);
        breakableBlocks.add(Blocks.PLANKS);
        breakableBlocks.add(Blocks.CLAY);
        breakableBlocks.add(Blocks.GLASS);
        Player player = ev.getPlayer();
        if(breakableBlocks.contains(ev.getBlock())){
            return true;
        }else if(ev.getBlock().equals(Blocks.BED)){
            if(main.getInstance().map.equals("world")){
                if(ev.getBlock().getLocation().equals(red1)){
                    main.getInstance().redBed = false;
                }else if(ev.getBlock().getLocation().equals(blue1)){
                    main.getInstance().blueBed = false;
                }else if(ev.getBlock().getLocation().equals(yellow1)){
                    main.getInstance().yellowBed = false;
                }else if(ev.getBlock().getLocation().equals(green1)){
                    main.getInstance().greenBed = false;
                }
            }
            if(main.getInstance().map.equals("map2")){
                if(ev.getBlock().getLocation().equals(red2)){
                    main.getInstance().redBed = false;
                }else if(ev.getBlock().getLocation().equals(blue2)){
                    main.getInstance().blueBed = false;
                }else if(ev.getBlock().getLocation().equals(yellow2)){
                    main.getInstance().yellowBed = false;
                }else if(ev.getBlock().getLocation().equals(green2)){
                    main.getInstance().greenBed = false;
                }
            }
            if(main.getInstance().map.equals("map3")){
                if(ev.getBlock().getLocation().equals(red3)){
                    main.getInstance().redBed = false;
                }else if(ev.getBlock().getLocation().equals(blue3)){
                    main.getInstance().blueBed = false;
                }else if(ev.getBlock().getLocation().equals(yellow3)){
                    main.getInstance().yellowBed = false;
                }else if(ev.getBlock().getLocation().equals(green3)){
                    main.getInstance().greenBed = false;
                }
            }
            if(main.getInstance().map.equals("map4")){
                if(ev.getBlock().getLocation().equals(red4)){
                    main.getInstance().redBed = false;
                }else if(ev.getBlock().getLocation().equals(blue4)){
                    main.getInstance().blueBed = false;
                }else if(ev.getBlock().getLocation().equals(yellow4)){
                    main.getInstance().yellowBed = false;
                }else if(ev.getBlock().getLocation().equals(green4)){
                    main.getInstance().greenBed = false;
                }
            }
        }else{
            ev.setCancelled(true);
            ev.getPlayer().sendMessage("§4You are not able to break this block :(");
        }

        return true;
    }
}

