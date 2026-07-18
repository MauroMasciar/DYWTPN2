package service;

import controller.AchievementController;
import model.Games;
import util.Utils;

public class AchievementService {
    private AchievementController achievementController;
    private PlayerService playerService;
    private Games game;

    public AchievementService(Games game) {
        this.game = game;
        playerService = new PlayerService();
        achievementController = new AchievementController();
    }

    public void checkInGame(int playedSeconds) {
        String achievement = "";

        if(game.getTimePlayed() + playedSeconds == 240) {
            achievement = "Has jugado a " + game.getName() + " por primera vez";
            achievementController.add(game.getName(), game.getId(), achievement, Utils.getFormattedDateTime());
        }

        achievement = "";
        
        if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR) achievement = "Has alcanzado tu primera hora de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 5) achievement = "Has alcanzado 5 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 10) achievement = "Has alcanzado 10 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 25) achievement = "Has alcanzado 25 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 50) achievement = "Has alcanzado 50 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 100) achievement = "Has alcanzado 100 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 250) achievement = "Has alcanzado 250 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 500) achievement = "Has alcanzado 500 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 1000) achievement = "Has alcanzado 1000 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 2000) achievement = "Has alcanzado 2000 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 5000) achievement = "Has alcanzado 5000 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 7500) achievement = "Has alcanzado 7500 horas de juego en " + game.getName();
        else if(game.getTimePlayed() + playedSeconds == Utils.SECONDS_PER_HOUR * 10000) achievement = "Has alcanzado 10000 horas de juego en " + game.getName();

        if(!achievement.isEmpty()) {
            achievementController.add(game.getName(), game.getId(), achievement, Utils.getFormattedDateTime());
        }

        achievement = "";

        int totalSecondsPlayed = (playedSeconds + playerService.getTotalTimePlayed());

        if(totalSecondsPlayed % 60 == 0) {
            if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR) achievement = "Has alcanzado tu primera hora de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 5) achievement = "Has alcanzado 5 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 10) achievement = "Has alcanzado 10 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 25) achievement = "Has alcanzado 25 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 50) achievement = "Has alcanzado 50 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 100) achievement = "Has alcanzado 100 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 250) achievement = "Has alcanzado 250 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 500) achievement = "Has alcanzado 500 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 1000) achievement = "Has alcanzado 1000 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 2000) achievement = "Has alcanzado 2000 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 5000) achievement = "Has alcanzado 5000 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 7500) achievement = "Has alcanzado 7500 horas de juego en total";
            else if(totalSecondsPlayed == Utils.SECONDS_PER_HOUR * 10000) achievement = "Has alcanzado 10000 horas de juego en total";

            if(!achievement.isEmpty()) {
                achievementController.add(game.getName(), game.getId(), achievement, Utils.getFormattedDateTime());
            }
        }
    }
}
