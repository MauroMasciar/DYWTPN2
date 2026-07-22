package com.masciar.repository;

import com.masciar.model.Achievements;
import com.masciar.dao.AchievementDAO;

import java.util.ArrayList;
import java.util.List;



public class AchievementRepository {
    public List<Achievements> achievementsList = new ArrayList<>();

    public AchievementRepository() {
        AchievementDAO achievementsDao = new AchievementDAO();
        achievementsDao.getAll();
    }

    public List<Achievements> getList() {
        return achievementsList;
    }
}
