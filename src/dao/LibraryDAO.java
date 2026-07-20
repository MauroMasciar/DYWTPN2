package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.Main;
import model.Libraries;

public class LibraryDAO {
    private final String url = "jdbc:sqlite:database.db";
    
    public List<Libraries> getAll() {
        List<Libraries> libraries = new ArrayList<>();
        String query = "SELECT * FROM library ORDER BY id";

        try(Connection con = DriverManager.getConnection(url);
	        PreparedStatement ps = con.prepareStatement(query);
	        ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {
                Libraries library = new Libraries(rs.getInt("id"), rs.getString("name"), rs.getInt("time_played"), rs.getInt("total_sessions"));
                libraries.add(library);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return libraries;
    }

    public void add() {

    }

    public void update() {

    }

    public void update(int i) {
        String query = "UPDATE library SET time_played = ?, total_sessions = ? WHERE id = ?";
		try (Connection con = DriverManager.getConnection(url);
			 PreparedStatement ps = con.prepareStatement(query)) {

                ps.setInt(1, Main.librariesRepository.library_list.get(i).getTimePlayed());
                ps.setInt(2, Main.librariesRepository.library_list.get(i).getTotalSession());
                ps.setInt(3, i);
			    int rowsAffected = ps.executeUpdate();
			    if(rowsAffected != 0) System.out.println("Libreria actualizada");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    public void delete() {

    }
}
