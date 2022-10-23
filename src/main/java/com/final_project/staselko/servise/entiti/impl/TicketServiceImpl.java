package com.final_project.staselko.servise.entiti.impl;

import com.final_project.staselko.converter.dto.TicketConverter;
import com.final_project.staselko.dao.TicketDao;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.servise.entiti.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;
    private final TicketConverter ticketConverter;

    @Override
    @Transactional
    public Ticket saveTicket(TicketDto ticketDto) {
        Ticket ticket = ticketDao.saveTicket(ticketConverter.toTicket(ticketDto));
        return ticket;
    }

    @Override
    public TicketDto getTicketById(Long ticketId) {
        return ticketConverter.toTicketDto(ticketDao.getTicketById(ticketId)
                .orElseThrow(() -> new RuntimeException("ticket not found with id " + ticketId)));
    }

    @Override
    public void updateTicket(TicketDto ticketDto) {
        ticketDao.updateTicket(ticketConverter.toTicket(ticketDto));
    }
}
