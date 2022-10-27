package com.final_project.staselko.servise.entiti;

import com.final_project.staselko.model.dto.HistoryDto;
import com.final_project.staselko.model.entiti.History;

import java.util.List;

public interface HistoryService {
    void saveHistory(History history);
    List<HistoryDto> getHistoryByTicket(Long ticketId);
}
