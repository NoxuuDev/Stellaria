package fr.pitrouflette.stellariauhc.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import fr.pitrouflette.stellariauhc.main;

public class TimeManager extends BukkitRunnable {

    public int seconds = 0;
    public int minutes = 0;
    public int episode = 0;

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

        if(minutes == 20 && seconds == 0){
            episode ++;
            seconds = 0;
            minutes = 0;
            Bukkit.broadcastMessage("§6>§f§l§m                  §6<");
            Bukkit.broadcastMessage("§6 Début de l'épisode §e" + episode);
            Bukkit.broadcastMessage("§6>§f§l§m                  §6<");
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
                objective.setDisplayName("§6Stellaria §eUHC");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);

                Score barre = objective.getScore("§6>§f§l§m                  §6<");
                barre.setScore(15);

                Score kill = objective.getScore("§6kills : " + main.getInstance().PlayerKill.get(online.getUniqueId()));
                kill.setScore(14);

                Score score = objective.getScore("§6players : " + Bukkit.getOnlinePlayers().size());
                score.setScore(13);

                Score troue2 = objective.getScore("       ");
                troue2.setScore(12);

                Score time = objective.getScore("§6timer : " + minutes + "m " + seconds +"s");
                time.setScore(11);

                Score episodeS = objective.getScore("§6épisode : " + episode);
                episodeS.setScore(10);

                Score adresse = objective.getScore("§6adresse : §f" + Bukkit.getServer().getIp());
                adresse.setScore(9);

                Score blank1 = objective.getScore("§6>§f§l§m                   §6<");
                blank1.setScore(8);

                Score credits = objective.getScore("§8by Pitrouflette");
                credits.setScore(1);

                online.setScoreboard(board);

            }else{

                ScoreboardManager manager = Bukkit.getScoreboardManager();
                assert manager != null;
                Scoreboard board = manager.getNewScoreboard();
                Objective objective = board.registerNewObjective("title", "null");
                objective.setDisplayName("§6Stellaria §eUHC");
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

                Score credits = objective.getScore("§8.gg/pitrouflette");
                credits.setScore(4);

                online.setScoreboard(board);

            }
        }
    }

    public int getMinutes(){return minutes;}

    public int getSeconds(){return seconds;}

}
