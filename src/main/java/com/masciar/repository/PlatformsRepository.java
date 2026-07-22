package com.masciar.repository;

import com.masciar.dao.PlatformDAO;
import com.masciar.model.Platforms;

import java.util.ArrayList;
import java.util.List;

public class PlatformsRepository {
    public List<Platforms> platforms_list = new ArrayList<>();

    public PlatformsRepository() {
        PlatformDAO platformDao = new PlatformDAO();
        platforms_list = platformDao.getAll();
    }

    public List<Platforms> getList() {
        return platforms_list;
    }
}
