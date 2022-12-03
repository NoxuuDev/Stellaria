package fr.pitrouflette.stellariabedwars.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

public class BedCasserManager {

    TimeManager timeManager = new TimeManager();
    Team blue = timeManager.bleu;
    Team red = timeManager.red;
    Team yellow = timeManager.yellow;
    Team green = timeManager.green;


    @SuppressWarnings("deprecation")
    public void PreventBedBreaking(Team team){
        if(team.equals(blue)){
            for(Player online : Bukkit.getOnlinePlayers()){
                if(blue.getPlayers().contains(online)){
                    online.sendTitle("pu de li", "pe pu repsawn");
                }else if(red.getPlayers().contains(online)){
                    online.sendTitle("pu de li", "pe pu repsawn");
                }else if(yellow.getPlayers().contains(online)){
                    online.sendTitle("pu de li", "pe pu repsawn");
                }else if(green.getPlayers().contains(online)){
                    online.sendTitle("pu de li", "pe pu repsawn");
                }
            }
        }
    }

    public void setBed(){

    }

    public void bedBrokMain(String bed){
        if(bed.contains("red")){
            PreventBedBreaking(red);
        }else if(bed.contains("blue")){
            PreventBedBreaking(blue);
        }else if(bed.contains("yellow")){
            PreventBedBreaking(yellow);
        }else if(bed.contains("green")){
            PreventBedBreaking(green);
        }
    }
}
