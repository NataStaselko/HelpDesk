package com.final_project.staselko.dao;

import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.model.entiti.User;
import com.final_project.staselko.model.enums.State;

import java.util.List;
import java.util.Optional;

public interface TicketDao {
    Ticket saveTicket(Ticket ticket);

    Optional<Ticket> getTicketById(Long ticketId);

    Ticket updateTicket(Ticket ticket);

    List<Ticket> findAllTicketsByState(State state);

    List<Ticket> findAllTicketsByEmployee (User user);
    List<Ticket> findAllTicketsByManager (User user);
    List<Ticket> findAllTicketsByEngineer (User user);

}
