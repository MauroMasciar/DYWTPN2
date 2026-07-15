package controller;

import service.ChronometerListener;
import service.ChronometerService;
import model.Game;
import ui.Chronometer;
import util.Utils;
import dao.GameDAO;

import javax.swing.JDesktopPane;

public class PlayingController implements ChronometerListener {
    private final Game game;
    private Chronometer view;
    ChronometerService ch;
    private boolean game_init = false;

    public PlayingController(Game game, JDesktopPane desktopPane) {
        this.game = game;
        
        // Iniciamos vista
        view = new Chronometer(this);
        desktopPane.add(view);

        // Iniciamos listener del cronometro
        ch = new ChronometerService();
        ch.setListener(this);
        ch.start();

        // Cargamos datos a la vista
        view.setGameName(game.getName());
        view.setPlayCount(String.valueOf(game.getPlayCount()));
        view.setTotalPlayed(Utils.getTotalHoursFromSeconds(game.getTimePlayed(), true));
        view.setTotalPlayedAfterSession(Utils.getTotalHoursFromSeconds(game.getTimePlayed(), false));
    }

    private void saveGame() {
        GameDAO dao = new GameDAO();
        dao.updateGame(game);
    }

    public void pauseSession() {
        if(ch.isPaused()) {
            ch.setPaused(false);
            view.btnPauseText("Pausar");
        } else {
            ch.setPaused(true);
            view.setPauseCount(String.valueOf(ch.getPauseCount()));
            view.btnPauseText("Reanudar");
        }
    }

    public void endSession() {
        ch.stop();
        saveGame();
    }

    @Override
    public void timeUpdate(int secondsPlayed, int secondsPaused) {
        view.setTime(Utils.getTotalHoursFromSeconds(secondsPlayed, true));
        view.setTimePaused(Utils.getTotalHoursFromSeconds(secondsPaused, true));
        view.setTimeTotal(Utils.getTotalHoursFromSeconds(secondsPaused + secondsPlayed, true));
        if(!game_init & secondsPlayed == 300) {
            game_init = true;
            game.setPlayCount(game.getPlayCount() + 1);
        }
    }

    @Override
    public void notifyMinuteElapsed(int seconds) {
        game.setTimePlayed(60 + game.getTimePlayed());
        view.setTotalFutureTime(Utils.getTotalHoursFromSeconds(game.getTimePlayed(), false));
        saveGame();
    }
}
