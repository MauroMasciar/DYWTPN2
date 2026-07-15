package service;

import javax.swing.Timer;

public class ChronometerService {
    private ChronometerListener listener;
    private int playedSeconds;
    private int pausedSeconds;
    private int pauseCount;
    private boolean active = true;
    private boolean pause = false;
    private Timer t;

    public void start() {
        t = new Timer(1000, e -> run());
    	t.start();
    }

    public void run() {
        if(active) {
            if(!pause) {
                notifyTime(String.valueOf(playedSeconds));
                playedSeconds++;
            } else {
                notifyTime(String.valueOf(pausedSeconds));
                pausedSeconds++;
            }
        }
    }

    public void stop() {
        active = false;
        t.stop();
    }

    public void notifyTime(String time) {
        if(listener != null) {
            listener.timeUpdate(playedSeconds, pausedSeconds);
            if(playedSeconds % 60 == 0 && playedSeconds != 0) listener.notifyMinuteElapsed(playedSeconds);
        }
    }

    public void setListener(ChronometerListener listener) {
        this.listener = listener;
    }

    public boolean isPaused() {
        return pause;
    }

    public void setPaused(boolean p) {
        pause = p;
        if(pause) pauseCount++;
    }

    public int getPlayedSeconds() {
        return playedSeconds;
    }

    public int getPausedSeconds() {
        return pausedSeconds;
    }

    public int getPauseCount() {
        return pauseCount;
    }
}
