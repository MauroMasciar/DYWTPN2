package com.masciar.service;

public interface ChronometerListener {
    void timeUpdate(int secondsPlayed, int secondsPaused);
    void notifyMinuteElapsed(int seconds);
}
