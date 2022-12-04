package fr.pitrouflette.stellariabedwars.manager;

import fr.pitrouflette.stellariabedwars.main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TimeManager extends BukkitRunnable {

    public FileConfiguration langg = main.getInstance().languages;
    public FileConfiguration configs = main.getInstance().getConfigFile();

    StartManager startManager = new StartManager();

    ScoreboardManager manager = Bukkit.getScoreboardManager();

    public int seconds = 0;
    public int minutes = 0;
    public int hours = 0;

    public Map<UUID, Integer> PlayerDethCuntDown = new HashMap<UUID, Integer>();

    Scoreboard board = manager.getNewScoreboard();

    Team bleu = board.registerNewTeam("bleu");
    Team green = board.registerNewTeam("green");
    Team yellow = board.registerNewTeam("yellow");
    Team red = board.registerNewTeam("red");

    @SuppressWarnings("deprecation")
    public void initTeam(Player player, String str){

        switch (str) {
            case "B" -> bleu.addPlayer(player);
            case "R" -> red.addPlayer(player);
            case "G" -> green.addPlayer(player);
            case "Y" -> yellow.addPlayer(player);
        }

        bleu.setAllowFriendlyFire(false);
        bleu.setPrefix("§1");
        bleu.setSuffix("§r");
        bleu.setCanSeeFriendlyInvisibles(true);
        bleu.setAllowFriendlyFire(false);

        green.setAllowFriendlyFire(false);
        green.setPrefix("§2");
        green.setSuffix("§r");
        green.setCanSeeFriendlyInvisibles(true);
        green.setAllowFriendlyFire(false);

        yellow.setAllowFriendlyFire(false);
        yellow.setPrefix("§e");
        yellow.setSuffix("§r");
        yellow.setCanSeeFriendlyInvisibles(true);
        yellow.setAllowFriendlyFire(false);

        red.setAllowFriendlyFire(false);
        red.setPrefix("§4");
        red.setSuffix("§r");
        red.setCanSeeFriendlyInvisibles(true);
        red.setAllowFriendlyFire(false);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void run(){

        if(minutes > 180){
            main.getInstance().run = false;
            Bukkit.broadcastMessage("§aLa partie a été stopée car elle a duré plus de 3 heures... ");
            cancel();
        }

        seconds++;
        if (seconds == 60) {

            seconds = 0;
            minutes++;
        }

        if(minutes == 60){
            hours ++;
            seconds = 0;
            minutes = 0;
        }


        for(Player online : Bukkit.getOnlinePlayers()){
            if(online.getGameMode().equals(GameMode.SPECTATOR)){
                if(!PlayerDethCuntDown.containsKey(online.getUniqueId())){
                    PlayerDethCuntDown.put(online.getUniqueId(), 5);
                }else{
                    PlayerDethCuntDown.put(online.getUniqueId(), PlayerDethCuntDown.get(online.getUniqueId()) - 1);
                }

            }
        }
        for(Player online : Bukkit.getOnlinePlayers()){
            if(PlayerDethCuntDown.containsKey(online.getUniqueId())){
                if(PlayerDethCuntDown.get(online.getUniqueId()) > 0){
                    online.resetTitle();
                    online.sendTitle( PlayerDethCuntDown.get(online.getUniqueId()) + "s", "before respawning");
                }
                if(PlayerDethCuntDown.get(online.getUniqueId()) == 0){
                    PlayerDethCuntDown.remove(online.getUniqueId());
                    online.setGameMode(GameMode.SURVIVAL);
                    startManager.tpPlayerBase(online);
                    online.resetTitle();
                }
            }
        }
        updateScoreBoard();
    }

    public void updateScoreBoard(){

        for(Player online : Bukkit.getOnlinePlayers()){

            if(main.getInstance().run){

                assert manager != null;
                Scoreboard board = manager.getNewScoreboard();
                Objective objective = board.registerNewObjective("title", "sfdg");
                objective.setDisplayName("§6Stellaria §eBedWars");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);

                Score barre = objective.getScore("§6>§f§l§m                          §6<");
                barre.setScore(999);

                Score blueTrue = objective.getScore("§1Bleu : §2✔");
                Score blueFalse = objective.getScore("§1Bleu : §7❌");
                if(main.getInstance().blueBed){blueTrue.setScore(90);}
                if(!(main.getInstance().blueBed)){blueFalse.setScore(90);}

                Score YellowTrue = objective.getScore("§eJaune: §2✔");
                Score YellowFalse = objective.getScore("§eJaune : §7❌");
                if(main.getInstance().yellowBed){YellowTrue.setScore(89);}
                if(!(main.getInstance().yellowBed)){YellowFalse.setScore(89);}

                Score RedTrue = objective.getScore("§4Red: §2✔");
                Score RedFalse = objective.getScore("§4Red : §7❌");
                if(main.getInstance().redBed){RedTrue.setScore(87);}
                if(!(main.getInstance().redBed)){RedFalse.setScore(87);}

                Score GreenTrue = objective.getScore("§2Green: §2✔");
                Score GreenFalse = objective.getScore("§2Green : §7❌");
                if(main.getInstance().greenBed){GreenTrue.setScore(87);}
                if(!(main.getInstance().greenBed)){GreenFalse.setScore(87);}

                Score troue2 = objective.getScore("       ");
                troue2.setScore(80);

                Score kill = objective.getScore("§6kills : " + main.getInstance().PlayerKill.get(online.getUniqueId()));
                kill.setScore(75);

                Score time = objective.getScore("§6temps : " + hours + "h" + minutes + "m " + seconds +"s");
                time.setScore(70);

                Score adresse = objective.getScore("§6adresse : §f" + Bukkit.getServer().getIp());
                adresse.setScore(60);

                Score blank1 = objective.getScore("§6>§f§l§m                         §6<");
                blank1.setScore(50);

                Score credits = objective.getScore("§8by Stellaria");
                credits.setScore(1);

                online.setScoreboard(board);

            }else{

                assert manager != null;
                Scoreboard waitBoard = manager.getNewScoreboard();
                Objective objective = waitBoard.registerNewObjective("title", "null");
                objective.setDisplayName("§6Stellaria §eBedWars");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);

                Score barre = objective.getScore("§6>§f§l§m                  §6<");
                barre.setScore(10);

                Score score = objective.getScore("§6joueurs : " + Bukkit.getOnlinePlayers().size());
                score.setScore(9);

                Score troue2 = objective.getScore("       ");
                troue2.setScore(8);

                Score dev = objective.getScore("§6dev : §fPitrouflette");
                dev.setScore(7);

                Score adresse = objective.getScore("§6adresse : §f play.stellaria.fr");
                adresse.setScore(6);

                Score blank1 = objective.getScore("§6>§f§l§m                   §6<");
                blank1.setScore(5);

                Score credits = objective.getScore("§8by Stellaria");
                credits.setScore(4);

                online.setScoreboard(waitBoard);

            }
        }
    }

    public int getMinutes(){return minutes;}

    public int getSeconds(){return seconds;}

}

