package com.final_project.staselko.converter.dto;

import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;

public interface TicketsForm {
    TicketDto toTicketsForm(Ticket ticket);
}
