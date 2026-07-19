package service;

import app.Main;
import controller.HistoryController;
import dao.GamesDAO;
import model.Games;
import model.History;
import ui.SessionsHistory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddSessionService {
    public void AddSessionManually(String gameName, String time, String date_start, String hour_start) {
        GameService gameService = new GameService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Games game = gameService.findByName(gameName);

        int seconds = Integer.parseInt(time);
        LocalDateTime dateTimeStart = LocalDateTime.parse(date_start + " " + hour_start + ":00", formatter);
        LocalDateTime dateTimeEnd = dateTimeStart.plusSeconds(Integer.parseInt(time));
        History history = new History(Main.achievementsRepository.getList().size() + 1, "NO",  game.getId(), gameName, game.getLibrary(), game.getPlatform(), dateTimeStart.toString(), dateTimeEnd.toString(), seconds);
        saveHistory(history);
        saveGameTime(game, seconds);
    }

    public void addSession(Games game, LocalDateTime dateTimeStart, int seconds) {
        LocalDateTime dateTimeEnd = dateTimeStart.plusSeconds(seconds);
        History history = new History(Main.achievementsRepository.getList().size() + 1, "NO",  game.getId(), game.getName(), game.getLibrary(), game.getPlatform(), dateTimeStart.toString(), dateTimeEnd.toString(), seconds);
        saveHistory(history);
        saveGameTime(game, seconds);
    }

    private void saveGameTime(Games game, int seconds) {
        game.setTimePlayed(game.getTimePlayed() + seconds);
        game.setPlayCount(game.getPlayCount() + 1);
        GamesDAO gamesDao = new GamesDAO();
        gamesDao.update(game);
    }

    private void saveHistory(History history) {
        Main.historyRepository.getList().add(history);
        HistoryController historyController = new HistoryController();
        historyController.add(history);
        SessionsHistory.updateTableModel();
    }
}
