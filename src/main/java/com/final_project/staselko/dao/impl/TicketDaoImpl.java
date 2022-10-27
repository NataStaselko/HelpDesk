package com.final_project.staselko.dao.impl;

import com.final_project.staselko.dao.HibernateDao;
import com.final_project.staselko.dao.TicketDao;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.model.entiti.User;
import com.final_project.staselko.model.enums.State;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Ticket> getTicketById(Long ticketId) {
        return findById(ticketId);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) {
        return update(ticket);
    }

    @Override
    public List<Ticket> findAllTicketsByState(State state) {
        return getAllByParam("state_id", state);
    }

    @Override
    public List<Ticket> findAllTicketsByEmployee(User user) {
        return getAllByParam("owner", user);
    }

    @Override
    public List<Ticket> findAllTicketsByManager(User user) {
        return getAllByParams("owner", "manager", user);
    }

    @Override
    public List<Ticket> findAllTicketsByEngineer(User user) {
        return getAllByParam("engineer", user);
    }
}
