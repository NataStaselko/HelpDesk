package com.final_project.staselko.dao;

import com.final_project.staselko.model.entiti.History;
import com.final_project.staselko.model.entiti.Ticket;

import java.util.List;
import java.util.Optional;

public interface HistoryDao {
    void createHistory(History history);

    List<History> getHistoryByTicket(Ticket ticket);
}
