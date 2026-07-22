package com.masciar.model;

public class Wishlist {
    private int id;
    private String gameName;

    public Wishlist(int id, String gameName) {
        this.id = id;
        this.gameName = gameName;
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
}
