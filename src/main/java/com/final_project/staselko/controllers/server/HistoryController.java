package com.final_project.staselko.controllers.server;

import com.final_project.staselko.model.entiti.History;
import com.final_project.staselko.servise.entiti.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/histories")
public class HistoryController {
    private final HistoryService historyService;

    @PostMapping
    public void createHistory(@RequestBody History history){
        historyService.saveHistory(history);
    }
}
