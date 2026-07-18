package service;

import app.Main;

public class GameService {
    public int findIdByName(String name) {
        for(int i=0; i<Main.gameRepository.games_list.size(); i++) {
            if(Main.gameRepository.games_list.get(i).getName().equals(name)) return Main.gameRepository.games_list.get(i).getId();
        }
        return 0;
    }
        
    public String findNameById(int id) {
        for(int i=0; i<Main.gameRepository.games_list.size(); i++) {
            if(Main.gameRepository.games_list.get(i).getId() == id) return Main.gameRepository.games_list.get(i).getName();
        }
        return "ERROR";
    }

    public int findPlatformById(int id) {
        for(int i=0; i<Main.gameRepository.games_list.size(); i++) {
            if(Main.gameRepository.games_list.get(i).getId() == id) return Main.gameRepository.games_list.get(i).getPlatform();
        }
        return 0;
    }

    public int findLibraryById(int id) {
        for(int i=0; i<Main.gameRepository.games_list.size(); i++) {
            if(Main.gameRepository.games_list.get(i).getId() == id) return Main.gameRepository.games_list.get(i).getLibrary();
        }
        return 0;
    }

    /*public Games searchGame() {
        for(int i=0; i<Main.gameRepository.)
        return games;
    }*/
}
