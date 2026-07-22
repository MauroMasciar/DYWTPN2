package com.masciar.controller;

import com.masciar.dao.HistoryDAO;
import com.masciar.model.History;

public class HistoryController {
    public void add(History history) {
        HistoryDAO historyDao = new HistoryDAO();
        historyDao.add(history);
    }
}
