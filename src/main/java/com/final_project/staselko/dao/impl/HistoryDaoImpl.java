package com.final_project.staselko.dao.impl;

import com.final_project.staselko.dao.HibernateDao;
import com.final_project.staselko.dao.HistoryDao;
import com.final_project.staselko.model.entiti.History;
import com.final_project.staselko.model.entiti.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoryDaoImpl extends HibernateDao<History> implements HistoryDao {
    public HistoryDaoImpl() {
        setModelClass(History.class);
    }

    @Override
    public void createHistory(History history) {
        create(history);
    }

    @Override
    public List<History> getHistoryByTicket(Ticket ticket) {
        return getAllByParam("ticket", ticket);
    }
}
