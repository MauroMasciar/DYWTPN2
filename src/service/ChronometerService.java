package service;

import javax.swing.Timer;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ChronometerService {
    private ChronometerListener listener;
    private int totalSecondsPlaying;
    private int totalSecondsPaused;
    private int pauseCount;
    private boolean active = true;
    private boolean pause = false;
    private Timer t;
    private LocalDateTime playStart;
    private LocalDateTime pauseStart;

    public void start() {
        playStart = LocalDateTime.now();
        t = new Timer(1000, e -> run());
    	t.start();
    }

    public void run() {
        if(active) {
            if(!pause) {
                int currentPlaying = (int) ChronoUnit.SECONDS.between(playStart, LocalDateTime.now());
                int totalPlaying = totalSecondsPlaying + currentPlaying;

                notifyTime(totalPlaying, totalSecondsPaused);
            } else {
                int currentPaused = (int) ChronoUnit.SECONDS.between(pauseStart, LocalDateTime.now());
                int totalPaused = totalSecondsPaused + currentPaused;

                notifyTime(totalSecondsPlaying, totalPaused);
            }
        }
    }

    public void notifyTime(int playing_time, int pause_time) {
        if(listener != null) {
            listener.timeUpdate(playing_time, pause_time);
            if(playing_time % 60 == 0 && playing_time != 0 && !pause) listener.notifyMinuteElapsed(playing_time);
        }
    }

    public void setListener(ChronometerListener listener) {
        this.listener = listener;
    }

    public void stop() {
        active = false;
        t.stop();
    }

    public boolean isPaused() {
        return pause;
    }

    public void setPaused(boolean p) {
        pause = p;
        if(pause) {
            pauseStart = LocalDateTime.now();
            totalSecondsPlaying += ChronoUnit.SECONDS.between(playStart, LocalDateTime.now());
            pauseCount++;
        } else {
            playStart = LocalDateTime.now();
            totalSecondsPaused += ChronoUnit.SECONDS.between(pauseStart, LocalDateTime.now());
        }
    }

    public int getTotalSecondsPlaying() {
        return totalSecondsPlaying;
    }

    public int getTotalSecondsPaused() {
        return totalSecondsPaused;
    }

    public int getPauseCount() {
        return pauseCount;
    }
}
