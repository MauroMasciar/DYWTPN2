package model;

public class Player {
    private int id;
    private String name;
    private String lastGame;
    private String lastSessionTime;
    private int totalSessions;
    private int timePlayed;

    public Player(int id, String name, String lastGame, String lastSessionTime, int totalSessions, int timePlayed) {
        this.id = id;
        this.name = name;
        this.lastGame = lastGame;
        this.lastSessionTime = lastSessionTime;
        this.totalSessions = totalSessions;
        this.timePlayed = timePlayed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastGame() {
        return lastGame;
    }

    public void setTotalSessions(int totalSessions) {
        this.totalSessions = totalSessions;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setLastGame(String lastGame) {
        this.lastGame = lastGame;
    }

    public String getLastSessionTime() {
        return lastSessionTime;
    }

    public void setLastSessionTime(String lastSessionTime) {
        this.lastSessionTime = lastSessionTime;
    }
}
