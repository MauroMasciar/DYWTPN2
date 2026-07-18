package repository;

import dao.CategoryDAO;
import model.Categories;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    public List<Categories> categories_list = new ArrayList<>();

    public CategoryRepository() {
        CategoryDAO categoryDao = new CategoryDAO();
        categories_list = categoryDao.getAll();
    }

    public List<Categories> getList() {
        return categories_list;
    }
}
