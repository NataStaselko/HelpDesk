package com.final_project.staselko.servise.entiti.impl;

import com.final_project.staselko.converter.dto.TicketConverter;
import com.final_project.staselko.converter.dto.TicketsForm;
import com.final_project.staselko.converter.enums.StateConverter;
import com.final_project.staselko.dao.TicketDao;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.model.entiti.User;
import com.final_project.staselko.servise.entiti.TicketService;
import com.final_project.staselko.servise.entiti.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;
    private final TicketConverter ticketConverter;
    private final UserService userService;
    private final StateConverter stateConverter;
    private final TicketsForm ticketsForm;

    @Override
    @Transactional
    public Ticket saveTicket(TicketDto ticketDto) {
        Ticket ticket = ticketDao.saveTicket(ticketConverter.toTicket(ticketDto));
        return ticket;
    }

    @Override
    @Transactional
    public TicketDto getTicketById(Long ticketId) {
        return ticketConverter.toTicketDto(ticketDao.getTicketById(ticketId)
                .orElseThrow(() -> new RuntimeException("ticket not found with id " + ticketId)));
    }

    @Override
    @Transactional
    public Ticket updateTicket(Long id, TicketDto ticketDto) {
        TicketDto ticketDtoEdit = ticketConverter.toTicketDto(ticketDao.getTicketById(id)
                .orElseThrow(() -> new RuntimeException("ticket not found with id " + id)));
        if (ticketDtoEdit.getState().equals("DRAFT")) {
            ticketDtoEdit.setName(ticketDto.getName());
            ticketDtoEdit.setDescription(ticketDto.getDescription());
            ticketDtoEdit.setDesired_resolution_date(ticketDto.getDesired_resolution_date());
            ticketDtoEdit.setCategory(ticketDto.getCategory());
            ticketDtoEdit.setUrgency(ticketDto.getUrgency());
            ticketDtoEdit.setState(ticketDto.getState());
            return ticketDao.updateTicket(ticketConverter.toTicket(ticketDtoEdit));
        }
        return null;
    }

    @Override
    @Transactional
    public List<TicketDto> getAllTickets(long userId) {
        User user = userService.getUserById(userId);
        List<Ticket> list = new ArrayList<>();
        List<Ticket> list1 = new ArrayList<>();
        if (user.getRole_id().getCode() == 0) {
            list = ticketDao.findAllTicketsByEmployee(user);
        }
        if (user.getRole_id().getCode() == 1) {
            list = ticketDao.findAllTicketsByState(stateConverter.convertToEntityAttribute(1));
            list1 = ticketDao.findAllTicketsByManager(user);
        }
        if (user.getRole_id().getCode() == 2) {
            list = ticketDao.findAllTicketsByState(stateConverter.convertToEntityAttribute(2));
            list1 = ticketDao.findAllTicketsByEngineer(user);
        }
        list.addAll(list1);
        List<TicketDto> ticketsDto = list.stream()
                .distinct()
                .sorted(Comparator.comparing(Ticket::getUrgency_id)
                        .thenComparing(Ticket::getDesired_resolution_date))
                .map(ticketsForm::toTicketsForm)
                .collect(Collectors.toList());
        return ticketsDto;
    }

    @Override
    @Transactional
    public List<TicketDto> getTicketsByUser(long userId) {
        User user = userService.getUserById(userId);
        List<Ticket> list = new ArrayList<>();
        if (user.getRole_id().getCode() == 0) {
            list = ticketDao.findAllTicketsByEmployee(user);
        }
        if (user.getRole_id().getCode() == 1) {
            list = ticketDao.findAllTicketsByManager(user);
        }
        if (user.getRole_id().getCode() == 2) {
            list = ticketDao.findAllTicketsByEngineer(user);
        }
        List<TicketDto> ticketsDto = list.stream()
                .sorted(Comparator.comparing(Ticket::getUrgency_id)
                        .thenComparing(Ticket::getDesired_resolution_date))
                .map(ticketsForm::toTicketsForm)
                .collect(Collectors.toList());
        return ticketsDto;
    }
}
