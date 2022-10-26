package fr.pitrouflette.stellariabedwars.utils;

import fr.pitrouflette.stellariabedwars.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

public class TimeManager extends BukkitRunnable {

    public int seconds = 0;
    public int minutes = 0;
    public int hours = 0;

    @Override
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

        updateScoreBoard();

    }

    public void updateScoreBoard(){

        for(Player online : Bukkit.getOnlinePlayers()){

            if(main.getInstance().run){
                ScoreboardManager manager = Bukkit.getScoreboardManager();
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

                ScoreboardManager manager = Bukkit.getScoreboardManager();
                assert manager != null;
                Scoreboard board = manager.getNewScoreboard();
                Objective objective = board.registerNewObjective("title", "null");
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

                Score adresse = objective.getScore("§6adresse : §f" + Bukkit.getServer().getIp());
                adresse.setScore(6);

                Score blank1 = objective.getScore("§6>§f§l§m                   §6<");
                blank1.setScore(5);

                Score credits = objective.getScore("§8by Stellaria");
                credits.setScore(4);

                online.setScoreboard(board);

            }
        }
    }

    public int getMinutes(){return minutes;}

    public int getSeconds(){return seconds;}

}

