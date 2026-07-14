package app;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Conectado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}