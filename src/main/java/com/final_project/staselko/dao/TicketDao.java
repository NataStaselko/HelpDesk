package com.final_project.staselko.dao;

import com.final_project.staselko.model.entiti.Ticket;

import java.util.Optional;

public interface TicketDao {
    Ticket saveTicket(Ticket ticket);
     Optional <Ticket> getTicketById(Long ticketId);
     void updateTicket(Ticket ticket);
}
