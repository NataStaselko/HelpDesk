package com.final_project.staselko.servise.entiti;

import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;

public interface TicketService {
    Ticket saveTicket(TicketDto ticketDto);
    TicketDto getTicketById(Long ticketId);
    void updateTicket(TicketDto ticketDto);
}
