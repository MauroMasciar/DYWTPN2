package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import app.Main;
import controller.HistoryController;
import model.History;

public class AddSessionService {
    public void AddSessionManually(String gameName, String time, String date_start, String hour_start) {
        GameService gameService = new GameService();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        int gameId = gameService.findIdByName(gameName);
        int libraryId = gameService.findLibraryById(gameId);
        int platformId = gameService.findPlatformById(gameId);
        LocalDateTime dateTimeStart = LocalDateTime.parse(date_start + " " + hour_start + ":00", formatter);
        LocalDateTime dateTimeEnd = dateTimeStart.plusSeconds(Integer.parseInt(time));
        String dateTimeStartString = dateTimeStart.toString();
        String dateTimeEndString = dateTimeEnd.toString();

        History history = new History(Main.achievementsRepository.getList().size() + 1, "NO",  gameId, gameName, libraryId, platformId, dateTimeStartString, dateTimeEndString, Integer.parseInt(time));
        Main.historyRepository.getList().add(history);

        HistoryController historyController = new HistoryController();
        historyController.add(history);
    }
}
