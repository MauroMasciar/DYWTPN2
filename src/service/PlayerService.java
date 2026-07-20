package service;

import app.Main;

public class PlayerService {
    /*public int getTotalTimePlayed() {
        GamesDAO gamesDao = new GamesDAO();
        return gamesDao.getTotalTimePlayed();
    }*/

    public int getTotalTimePlayed() {
        return Main.playerRepository.players_list.get(0).getTotalTime();
    }

    public int getTotalSessions() {
        return Main.playerRepository.players_list.get(0).getTotalSessions();
    }

    public int getTotalCompleted() {
        return Main.playerRepository.players_list.get(0).getCompleted();
    }

    public int getTotalStartedGames() {
        return Main.playerRepository.players_list.get(0).getTotalStarted();
    }

}
