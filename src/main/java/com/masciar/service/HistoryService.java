package com.masciar.service;

import com.masciar.dao.HistoryDAO;

public class HistoryService {
    public String getLastSessionFromGame(int gameId) {
        HistoryDAO historyDAO = new HistoryDAO();
        return historyDAO.getLastSessionFromGame(gameId);
    }

    public int getLastSessionTimeFromGame(int gameId) {
        HistoryDAO historyDAO = new HistoryDAO();
        return historyDAO.getLastSessionTimeFromGame(gameId);
    }

    
}
