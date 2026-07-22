package com.masciar.repository;

import com.masciar.dao.LibraryDAO;
import com.masciar.model.Libraries;

import java.util.ArrayList;
import java.util.List;

public class LibraryRepository {
public List<Libraries> library_list = new ArrayList<>();

    public LibraryRepository() {
        LibraryDAO libraryDao = new LibraryDAO();
        library_list = libraryDao.getAll();
    }

    public List<Libraries> getList() {
        return library_list;
    }
}
