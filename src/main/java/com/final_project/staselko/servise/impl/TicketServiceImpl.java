package com.final_project.staselko.servise.impl;

import com.final_project.staselko.converter.dto.TicketConverter;
import com.final_project.staselko.dao.TicketDao;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.model.entiti.User;
import com.final_project.staselko.servise.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;
    private final TicketConverter ticketConverter;


    @Override
    public void saveTicketEmpty(User user) {
        Ticket ticket = new Ticket();
        ticket.setOwner(user);
        ticketDao.saveTicket(ticket);
    }
}
