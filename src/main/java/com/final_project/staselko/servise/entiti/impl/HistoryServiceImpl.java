package com.final_project.staselko.servise.entiti.impl;
import com.final_project.staselko.converter.dto.HistoryConverter;
import com.final_project.staselko.dao.HistoryDao;
import com.final_project.staselko.dao.TicketDao;
import com.final_project.staselko.model.dto.HistoryDto;
import com.final_project.staselko.model.entiti.History;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.servise.entiti.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryDao historyDao;
    private final TicketDao ticketDao;
    private final HistoryConverter historyConverter;

    @Override
    @Transactional
    public void saveHistory(History history) {
        historyDao.createHistory(history);
    }

    @Override
    @Transactional
    public List<HistoryDto> getHistoryByTicket(Long ticketId) {
        Ticket ticket = ticketDao.getTicketById(ticketId)
                .orElseThrow(() -> new RuntimeException("ticket not found with id " + ticketId));
        return historyDao.getHistoryByTicket(ticket).stream()
                .map(historyConverter::toHistoryDto)
                .sorted(Comparator.comparing(HistoryDto::getDate).reversed())
                .collect(Collectors.toList());
    }
}
