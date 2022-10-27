package com.final_project.staselko.converter.dto.impl;


import com.final_project.staselko.converter.dto.CommentConverter;
import com.final_project.staselko.converter.dto.TicketConverter;
import com.final_project.staselko.converter.dto.UserConverter;
import com.final_project.staselko.converter.enums.StateConverter;
import com.final_project.staselko.converter.enums.UngencyConverter;
import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Comment;
import com.final_project.staselko.model.entiti.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TicketConverterImpl implements TicketConverter {

    private final UngencyConverter ungencyConverter;
    private final StateConverter stateConverter;
    private final UserConverter userConverter;
    private final CommentConverter commentConverter;


    @Override
    public Ticket toTicket(TicketDto ticketDto) {
        Ticket ticket = new Ticket();
        ticket.setId(ticketDto.getId());
        ticket.setName(ticketDto.getName());
        ticket.setDescription(ticketDto.getDescription());
        ticket.setDesired_resolution_date(LocalDate.
                parse(ticketDto.getDesired_resolution_date(),
                        DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        ticket.setOwner(userConverter.toUser(ticketDto.getOwner()));
        ticket.setCategory(ticketDto.getCategory());
        ticket.setUrgency_id(ungencyConverter.convertToEntityAttribute(Integer.parseInt(ticketDto.getUrgency())));
        ticket.setState_id(stateConverter.convertToEntityAttribute(Integer.parseInt(ticketDto.getState())));
        if (ticket.getState_id().getCode() >= 1) {
            List<Comment> comments = ticketDto.getComment()
                    .stream().map(commentConverter::toComment)
                    .collect(Collectors.toList());
            ticket.setComments(comments);
        }
        return ticket;
    }

    @Override
    public TicketDto toTicketDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setName(ticket.getName());
        ticketDto.setDesired_resolution_date(ticket.getDesired_resolution_date()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        ticketDto.setCreated_on(ticket.getCreated_on()
                .format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss").localizedBy(Locale.ENGLISH)));
        ticketDto.setDescription(ticket.getDescription());
        ticketDto.setCategory(ticket.getCategory());
        ticketDto.setUrgency(ticket.getUrgency_id().toString());
        ticketDto.setState(ticket.getState_id().toString());
        ticketDto.setOwner(userConverter.toUserDto(ticket.getOwner()));
        if (ticketDto.getState().equals("DRAFT") || ticketDto.getState().equals("NEW")) {
            List<CommentDto> commentsDto = ticket.getComments()
                    .stream().map(commentConverter::toCommentDto)
                    .collect(Collectors.toList());
            ticketDto.setComment(commentsDto);
        }
        return ticketDto;
    }
}
