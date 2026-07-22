package com.masciar.repository;

import com.masciar.model.Games;
import com.masciar.dao.GamesDAO;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {
    public List<Games> games_list = new ArrayList<>();

    public GameRepository() {
        GamesDAO gameDao = new GamesDAO();
        games_list = gameDao.getAll();
    }
	
	public List<Games> getList() {
		return games_list;
	}
}
