package model;

public class Platforms {
    private int id;
    private int timePlayed;
    private int totalSessions;
    public Platforms() {
    }

    public Platforms(int id, int timePlayed, int totalSessions) {
        this.id = id;
        this.timePlayed = timePlayed;
        this.totalSessions = totalSessions;
    }

    public int getId() {
        return id;
    }

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(int totalSessions) {
        this.totalSessions = totalSessions;
    }
}
