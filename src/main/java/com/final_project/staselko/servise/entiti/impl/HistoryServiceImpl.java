package com.final_project.staselko.servise.entiti.impl;

import com.final_project.staselko.dao.impl.HistoryDao;
import com.final_project.staselko.model.entiti.History;
import com.final_project.staselko.servise.entiti.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class HistoryServiceImpl implements HistoryService {

    private final HistoryDao historyDao;

    @Override
    @Transactional
    public void saveHistory(History history) {
        historyDao.createHistory(history);
    }
}
