package service;

import dao.GamesDAO;

public class PlayerService {
    public int getTotalTimePlayed() {
        GamesDAO gamesDao = new GamesDAO();
        return gamesDao.getTotalTimePlayed();
    }
}
