package com.final_project.staselko.controllers.server;

import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.servise.entiti.TicketService;
import com.final_project.staselko.utils.param.ParamCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;
    private final ParamCreator paramCreator;

    @PostMapping
    public Ticket createTicket(@Valid @RequestBody TicketDto ticketDto){
        return ticketService.saveTicket(ticketDto);
    }

    @GetMapping("/{id}")
    public TicketDto getTicketById(@PathVariable(value = "id") Long id){
        return ticketService.getTicketById(id);
    }

}
