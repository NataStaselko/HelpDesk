package com.final_project.staselko.controllers.server;

import com.final_project.staselko.model.dto.HistoryDto;
import com.final_project.staselko.model.entiti.History;
import com.final_project.staselko.servise.entiti.HistoryService;
import com.final_project.staselko.utils.entiti.ObjectList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/histories")
public class HistoryController {
    private final HistoryService historyService;

    @PostMapping
    public void createHistory(@RequestBody History history){
        historyService.saveHistory(history);
    }
    @GetMapping
    public ObjectList<HistoryDto> getHistoryByTicket(Long ticket_id){
        ObjectList<HistoryDto> objectList = new ObjectList<>();
        objectList.setTicketsDto(historyService.getHistoryByTicket(ticket_id));
        return objectList;
    }
}
