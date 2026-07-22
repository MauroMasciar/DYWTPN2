package com.masciar.controller;

import com.masciar.ui.GeneralSummary;
import com.masciar.ui.Window;
import com.masciar.util.Utils;
import com.masciar.service.PlayerService;

public class GeneralSummaryController {
    Window window;
    GeneralSummary view;
    PlayerService playerService;

    public GeneralSummaryController(Window window) {
        this.window = window;
        view = new GeneralSummary();
        playerService = new PlayerService();
        window.add(view);

        loadData();
    }

    private void loadData() {
        view.setLblTotalTimeHoursValue(Utils.getTotalHoursFromSeconds(playerService.getTotalTimePlayed(), false));
        view.setlblTotalTimeDaysValue(Utils.getTotalDaysFromSeconds(playerService.getTotalTimePlayed()));
        view.lblTotalGamesStartedValue(String.valueOf(playerService.getTotalStartedGames()));
        view.lblCompletedValue(String.valueOf(playerService.getTotalCompleted()));
        view.lblSessionsValue(String.valueOf(playerService.getTotalSessions()));
    }    
}
