package com.final_project.staselko.converter.dto.impl;

import com.final_project.staselko.converter.dto.TicketConverter;
import com.final_project.staselko.converter.enums.UngencyConverter;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class TicketConverterImpl implements TicketConverter {

    private final UngencyConverter ungencyConverter;

    @Override
    public Ticket toTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setName(ticketDto.getName());
        ticket.setDescription(ticketDto.getDescription());
        ticket.setDesired_resolution_date(LocalDate.
                parse(ticketDto.getDesired_resolution_date(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")));
       // ticket.setCategory(ticketDto.getCategory());
        //ticket.setUrgency_id(ungencyConverter.convertToEntityAttribute(Integer.parseInt(ticketDto.getUrgency())));
        return ticket;
    }

    @Override
    public TicketDto toTicketDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setName(ticket.getName());
        ticketDto.setDesired_resolution_date(ticket.getDesired_resolution_date()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        ticketDto.setCreated_on(ticket.getCreated_on()
                .format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss").localizedBy(Locale.ENGLISH)));
        ticketDto.setDescription(ticket.getDescription());
       // ticketDto.setCategory(ticket.getCategory());
       // ticketDto.setUrgency(ticket.getUrgency_id().toString());
        ticketDto.setOwner(ticket.getOwner());
        return ticketDto;
    }
}
