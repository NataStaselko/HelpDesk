package com.final_project.staselko.servise;

import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Category;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.model.entiti.User;
import com.final_project.staselko.model.enums.Urgency;

public interface TicketService {
    Ticket saveTicket(TicketDto ticketDto);
}
