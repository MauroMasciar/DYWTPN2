package repository;

import dao.HistoryDAO;
import model.History;

import java.util.ArrayList;
import java.util.List;

public class HistoryRepository {
    public List<History> history_list = new ArrayList<>();

    public HistoryRepository() {
        HistoryDAO historyDAO = new HistoryDAO();
        history_list = historyDAO.getAll();
    }
	
	public List<History> getList() {
		return history_list;
	}
}
