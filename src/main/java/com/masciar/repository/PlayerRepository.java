package com.masciar.repository;

import java.util.ArrayList;
import java.util.List;

import com.masciar.dao.PlayerDAO;
import com.masciar.model.Player;

public class PlayerRepository {
public List<Player> players_list = new ArrayList<>();

    public PlayerRepository() {
        PlayerDAO playerDao = new PlayerDAO();
        players_list = playerDao.getAll();
    }

    public List<Player> getList() {
        return players_list;
    }
}
