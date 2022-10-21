package com.final_project.staselko.servise.impl;

import com.final_project.staselko.converter.dto.TicketConverter;
import com.final_project.staselko.dao.TicketDao;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.servise.TicketService;
import com.final_project.staselko.utils.entiti.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;
    private final TicketConverter ticketConverter;
    private final UserProvider userProvider;



    @Override
    @Transactional
    public Ticket saveTicket(TicketDto ticketDto) {
        Ticket ticket = ticketDao.saveTicket(ticketConverter.toTicket(ticketDto));
        ticket.setOwner(userProvider.getCurrentUser());
        return ticket;
    }
}
