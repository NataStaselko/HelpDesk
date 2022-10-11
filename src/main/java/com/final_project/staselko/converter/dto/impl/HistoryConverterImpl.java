package com.final_project.staselko.converter.dto.impl;

import com.final_project.staselko.converter.dto.HistoryConverter;
import com.final_project.staselko.model.dto.HistoryDto;
import com.final_project.staselko.model.entiti.History;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HistoryConverterImpl implements HistoryConverter {

    @Override
    public HistoryDto toHistoryDto(History history) {
        HistoryDto historyDto = new HistoryDto();
        historyDto.setDate(history.getDate().format(DateTimeFormatter
                .ofPattern("MMM dd, yyyy HH:mm:ss").localizedBy(Locale.ENGLISH)));
        historyDto.setAction(history.getAction());
        historyDto.setDescription(history.getDescription());
        return historyDto;
    }
}
