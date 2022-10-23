package com.final_project.staselko.dao.impl;

import com.final_project.staselko.dao.HibernateDao;
import com.final_project.staselko.model.entiti.History;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryDaoImpl extends HibernateDao<History> implements HistoryDao {
    public HistoryDaoImpl() {
        setModelClass(History.class);
    }

    @Override
    public void createHistory(History history) {
        create(history);
    }
}
