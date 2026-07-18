package dao;

import model.Achievements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AchievementDAO {
    private final String url = "jdbc:sqlite:database.db";
    
    public List<Achievements> getAll() {
        List<Achievements> achievementsList = new ArrayList<>();
        String query = "SELECT * FROM achievements ORDER BY id";

        try(Connection con = DriverManager.getConnection(url);
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                Achievements a = new Achievements(rs.getInt("id"), rs.getString("game_name"), rs.getInt("game_id"), rs.getString("description"), rs.getString("date"));
                achievementsList.add(a);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return achievementsList;
    }

    public void add(Achievements achievements) {
        String query = "INSERT INTO achievements (id, game_name, game_id, description, date) VALUES (?, ?, ?, ?, ?)";
		try (Connection con = DriverManager.getConnection(url);
			 PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, achievements.getId());
            ps.setString(2, achievements.getGameName());
            ps.setInt(3, achievements.getGameId());
            ps.setString(4, achievements.getDescription());
            ps.setString(5, achievements.getDate());

			int rowsAffected = ps.executeUpdate();
			if(rowsAffected != 0) System.out.println("Logro añadido");
            else System.out.println("Error al añadir logro");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void delete() {

    }
}
