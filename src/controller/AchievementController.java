package controller;

import app.Main;
import dao.AchievementDAO;
import model.Achievements;

public class AchievementController {
    public void add(String name, int gameId, String description, String date) {
        AchievementDAO achievementDAO = new AchievementDAO();
        Achievements achievement = new Achievements(Main.achievementsRepository.getList().size() + 1, name, gameId, description, date);
        Main.achievementsRepository.getList().add(achievement);
        achievementDAO.add(achievement);
    }
}
