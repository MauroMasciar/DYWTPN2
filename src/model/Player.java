package model;

public class Player {
    private int id;
    private String name;
    private int timePlayed;

    public Player(int id, String name, int timePlayed) {
        this.id = id;
        this.name = name;
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

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }
}
