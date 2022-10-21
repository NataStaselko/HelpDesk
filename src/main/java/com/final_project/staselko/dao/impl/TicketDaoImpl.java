package com.final_project.staselko.dao.impl;

import com.final_project.staselko.dao.HibernateDao;
import com.final_project.staselko.dao.TicketDao;
import com.final_project.staselko.model.entiti.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends HibernateDao<Ticket> implements TicketDao {

    public TicketDaoImpl() {
        setModelClass(Ticket.class);
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        create(ticket);
        return ticket;
    }
}
