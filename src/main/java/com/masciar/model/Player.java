package com.masciar.model;

public class Player {
    private int id;
    private String gameName;
    private int lastGameSessionTime;
    private int totalTime;
    private int totalSessions;
    private int totalStarted;
    private int completed;

    public Player(int id, String gameName, int lastGameSessionTime, int totalTime, int totalSessions, int totalStarted, int completed) {
        this.id = id;
        this.gameName = gameName;
        this.lastGameSessionTime = lastGameSessionTime;
        this.totalTime = totalTime;
        this.totalSessions = totalSessions;
        this.totalStarted = totalStarted;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getLastGameSessionTime() {
        return lastGameSessionTime;
    }

    public void setLastGameSessionTime(int lastGameSessionTime) {
        this.lastGameSessionTime = lastGameSessionTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(int totalSessions) {
        this.totalSessions = totalSessions;
    }

    public int getTotalStarted() {
        return totalStarted;
    }

    public void setTotalStarted(int totalStarted) {
        this.totalStarted = totalStarted;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }
}
