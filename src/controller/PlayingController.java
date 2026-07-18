package controller;

import service.ChronometerListener;
import service.ChronometerService;
import service.Toast;
import service.AchievementService;
import model.Games;
import ui.Chronometer;
import util.Utils;
import dao.GamesDAO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JDesktopPane;
import javax.swing.Timer;

public class PlayingController implements ChronometerListener {
    private Games game;
    private Chronometer view;
    private ChronometerService chronometerService;
    private AchievementService achievementService;
    private boolean game_init = false;
    private LocalDateTime startTime = LocalDateTime.now();
    private DateTimeFormatter format_time = DateTimeFormatter.ofPattern("HH:mm");
    private int playedSeconds;
    private Timer timerStrobe;
    private JDesktopPane desktopPane;

    public PlayingController(Games game, JDesktopPane desktopPane) {
        this.game = game;
        this.desktopPane = desktopPane;
        
        // Iniciamos vista
        view = new Chronometer(this);
        desktopPane.add(view);

        // Iniciamos listener del cronometro
        chronometerService = new ChronometerService();
        chronometerService.setListener(this);
        chronometerService.start();

        // Instanciamos services
        achievementService = new AchievementService(game);

        // Cargamos datos a la vista
        view.setGameName(game.getName());
        view.setPlayCount(String.valueOf(game.getPlayCount()));
        view.setTotalPlayed(Utils.getTotalHoursFromSeconds(game.getTimePlayed(), true));
        view.setTotalPlayedAfterSession(Utils.getTotalHoursFromSeconds(game.getTimePlayed(), false));
        view.setAgeSession("Iniciado a las " + startTime.format(format_time) + " hace " + Utils.getTotalHoursFromSeconds(0, false));
        try {
            view.setAvgTimePlayed(Utils.getTotalHoursFromSeconds(game.getTimePlayed() / game.getPlayCount(), false));
        } catch (Exception ex) {
            view.setAvgTimePlayed("00h 00m");
        }
        
        timerStrobe = new Timer(500, e -> view.strobe(chronometerService.isPaused()));

        // Asignamos listener a los componentes
        view.setBtnPauseListener(e -> pauseSession());
        view.setBtnStopListener(e -> endSession());

        Toast.showToast(desktopPane, "Juego lanzado");
    }

    private void saveGame() {
        GamesDAO gameDao = new GamesDAO();
        gameDao.update(game);
    }

    public void pauseSession() {
        if(chronometerService.isPaused()) {
            chronometerService.setPaused(false);
            view.btnPauseText("Pausar");
            Toast.showToast(desktopPane, "Cronómetro corriendo");
            timerStrobe.stop();
        } else {
            chronometerService.setPaused(true);
            view.setPauseCount(String.valueOf(chronometerService.getPauseCount()));
            view.btnPauseText("Reanudar");
            Toast.showToast(desktopPane, "Cronómetro en pausa");
            timerStrobe.start();
        }
        view.strobe(chronometerService.isPaused());
    }

    public void endSession() {
        chronometerService.stop();
        timerStrobe.stop();
        game.setTimePlayed(game.getTimePlayed() + playedSeconds);
        if(playedSeconds > 300) saveGame();
        view.dispose();
    }

    @Override
    public void timeUpdate(int playedSeconds, int pausedSeconds) {
        this.playedSeconds = playedSeconds;
        view.setTime(Utils.getTotalHoursFromSeconds(playedSeconds, true));
        view.setTimePaused(Utils.getTotalHoursFromSeconds(pausedSeconds, true));
        view.setTimeTotal(Utils.getTotalHoursFromSeconds(pausedSeconds + playedSeconds, true));
        if(!game_init & playedSeconds == 300) {
            game_init = true;
            game.setPlayCount(game.getPlayCount() + 1);
            saveGame();
        }
        achievementService.checkInGame(playedSeconds);
    }

    @Override
    public void notifyMinuteElapsed(int seconds) {
        view.setTotalFutureTime(Utils.getTotalHoursFromSeconds(game.getTimePlayed() + seconds, false));
        view.setAgeSession("Iniciado a las " + startTime.format(format_time) + " hace " + Utils.getTotalHoursFromSeconds(seconds, false));
    }
}
