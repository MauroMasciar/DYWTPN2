package controller;

import dao.HistoryDAO;
import model.History;

public class HistoryController {
    public void add(History history) {
        HistoryDAO historyDao = new HistoryDAO();
        historyDao.add(history);
    }
}
