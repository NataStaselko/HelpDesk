package com.final_project.staselko.converter.dto.impl;

import com.final_project.staselko.converter.dto.TicketsForm;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class TicketsFormImpl implements TicketsForm {
    @Override
    public TicketDto toTicketsForm(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setName(ticket.getName());
        ticketDto.setDesired_resolution_date(ticket.getDesired_resolution_date()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        ticketDto.setUrgency(ticket.getUrgency_id().toString());
        ticketDto.setState(ticket.getState_id().toString());
        return ticketDto;
    }
}
