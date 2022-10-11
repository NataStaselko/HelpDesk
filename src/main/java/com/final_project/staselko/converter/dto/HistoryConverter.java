package com.final_project.staselko.converter.dto;

import com.final_project.staselko.model.dto.HistoryDto;
import com.final_project.staselko.model.entiti.History;

public interface HistoryConverter {
    HistoryDto toHistoryDto(History history);
}
