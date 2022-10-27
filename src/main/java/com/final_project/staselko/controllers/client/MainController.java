package com.final_project.staselko.controllers.client;

import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.dto.HistoryDto;
import com.final_project.staselko.model.dto.TicketDto;
import com.final_project.staselko.model.entiti.Comment;
import com.final_project.staselko.servise.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final ClientService clientService;

    @PostMapping("/create_ticket")
    public ResponseEntity<Void> createTicketDraft(@RequestPart(required = false) String description,
                                                  @RequestPart(required = false) String desired_resolution_date,
                                                  @RequestPart(required = false) String name,
                                                  @RequestPart(required = false) String text,
                                                  @RequestPart String urgency,
                                                  @RequestPart String state,
                                                  @RequestPart String category) throws InterruptedException {
        clientService.createTicket(description, desired_resolution_date, name, text, urgency, state, category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/show_ticket/{id}")
    public ResponseEntity<TicketDto> showTicket(@PathVariable final Long id) {
        TicketDto ticketDto = clientService.showTicket(id);
        return ResponseEntity.status(HttpStatus.OK).body(ticketDto);
    }

    @PutMapping("/edit_ticket/{id}")
    public ResponseEntity<Void> updateTicket(@PathVariable final Long id,
                                             @RequestPart(required = false) String description,
                                             @RequestPart(required = false) String desired_resolution_date,
                                             @RequestPart(required = false) String name,
                                             @RequestPart(required = false) String text,
                                             @RequestPart String urgency,
                                             @RequestPart String state,
                                             @RequestPart String category) throws InterruptedException {
        clientService.editTicket(id, description, desired_resolution_date, name, text, urgency, state, category);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all_tickets")
    public ResponseEntity<List<TicketDto>> getAllTickets() {
        List<TicketDto> ticketDtoList = clientService.getAllTickets();
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoList);
    }

    @GetMapping("/my_tickets")
    public ResponseEntity<List<TicketDto>> getTicketsByUser() {
        List<TicketDto> ticketDtoList = clientService.getTicketsByUser();
        return ResponseEntity.status(HttpStatus.OK).body(ticketDtoList);
    }

    @GetMapping("/show_histories")
    public ResponseEntity<List<HistoryDto>> getHistoryByTickets(@RequestParam final Long ticket_id){
        List<HistoryDto> historyDtoList = clientService.getHistoryByTicket(ticket_id);
        return ResponseEntity.status(HttpStatus.OK).body(historyDtoList);
    }
    @GetMapping("/show_comments")
    public ResponseEntity<List<CommentDto>> getCommentsByTickets(@RequestParam final Long ticket_id){
        List<CommentDto> commentDtoDtoList = clientService.getCommentsByTicket(ticket_id);
        return ResponseEntity.status(HttpStatus.OK).body(commentDtoDtoList);
    }


















}
