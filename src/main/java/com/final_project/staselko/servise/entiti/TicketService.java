package com.final_project.staselko.servise.entiti;

import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.model.entiti.User;
import com.final_project.staselko.model.enums.State;

import java.util.List;

public interface TicketService {
    Ticket saveTicket(TicketDto ticketDto);

    TicketDto getTicketById(Long ticketId);

    Ticket updateTicket(Long id, TicketDto ticketDto);

    List<TicketDto> getAllTickets(long userId);
    List<TicketDto> getTicketsByUser(long userId);


}
