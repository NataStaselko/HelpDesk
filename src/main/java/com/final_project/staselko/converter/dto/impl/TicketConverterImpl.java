package com.final_project.staselko.converter.dto.impl;

import com.final_project.staselko.converter.dto.TicketConverter;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TicketConverterImpl implements TicketConverter {
    @Override
    public Ticket toTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setDescription(ticketDto.getDescription());
        ticket.setDesired_resolution_date(LocalDate.
                parse(ticketDto.getDesired_resolution_date(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        ticket.setCategory(ticketDto.getCategory());
        ticket.setUrgency_id(ticketDto.getUrgency_id());
        return ticket;
    }

    @Override
    public TicketDto toTicketDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setName(ticket.getName());
        ticketDto.setCreated_on(ticket.getCreated_on()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        ticketDto.setDesired_resolution_date(ticket.getDesired_resolution_date()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        ticketDto.setCategory(ticket.getCategory());
        ticketDto.setUrgency_id(ticket.getUrgency_id());
        return ticketDto;
    }
}
