package model;

public class Player {
    private int id;
    private String name;
    private String lastGame;
    private String lastSessionTime;

    public Player(int id, String name, String lastGame, String lastSessionTime) {
        this.id = id;
        this.name = name;
        this.lastGame = lastGame;
        this.lastSessionTime = lastSessionTime;
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
