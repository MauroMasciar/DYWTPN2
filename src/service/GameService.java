package service;

import app.Main;
import model.Games;

public class GameService {
    public Games findById(int id) {
        for (Games game : Main.gameRepository.games_list) {
            if(game.getId() == id) return game;
        }
        return null;
    }

    public Games findByName(String name) {
        for (Games game : Main.gameRepository.games_list) {
            if(game.getName().equals(name)) return game;
        }
        return null;
    }
}
