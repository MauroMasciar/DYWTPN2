package controller;

import app.Main;
import model.Games;
import service.AddSessionService;
import ui.AddSessionManually;
import ui.Window;

import java.util.Comparator;

public class AddSessionManuallyController {
    AddSessionService addSessionService;
    AddSessionManually view;

    public AddSessionManuallyController(Window window) {
        view = new AddSessionManually(window, true);
        addSessionService = new AddSessionService();
        
        view.setBtnAddListener(e -> addSessionService.AddSessionManually(view.getGameSelectedString(), view.getTimeString(), view.getDateString(), view.getHourString()));

        fillComboBoxGames();
        view.setVisible(true);
    }

    public void fillComboBoxGames() {
        Main.gameRepository.games_list.sort(Comparator.comparing(Games::getName, String.CASE_INSENSITIVE_ORDER));
		for(Games game : Main.gameRepository.games_list) { 
			view.cbGameAddItem(game.getName());
		}
    }
}
