package service;

import dao.GamesSessionBackupDAO;

public class PlayingService {
    public void saveBackup(int id, String dateTimeString, int seconds) {
        GamesSessionBackupDAO gamesSessionBackup = new GamesSessionBackupDAO();
        gamesSessionBackup.saveBackup(id, dateTimeString, seconds);
    }
}
