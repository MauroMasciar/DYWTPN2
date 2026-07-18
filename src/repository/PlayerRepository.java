package repository;

import java.util.ArrayList;
import java.util.List;

import dao.PlayerDAO;
import model.Player;

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
