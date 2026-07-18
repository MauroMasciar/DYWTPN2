package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Player;

public class PlayerDAO {
private final String url = "jdbc:sqlite:database.db";
    
    public List<Player> getAll() {
        List<Player> player_list = new ArrayList<>();
        String query = "SELECT * FROM players ORDER BY id";

        try(Connection con = DriverManager.getConnection(url);
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                Player player = new Player(rs.getInt("id"), rs.getString("name"), rs.getString("last_game"), rs.getString("last_session_time"));
                player_list.add(player);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return player_list;
    }

    public void add() {

    }

    public void update() {

    }

    public void delete() {

    }
}
