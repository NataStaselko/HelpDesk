package com.final_project.staselko.controllers.client;

import com.final_project.staselko.servise.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Void> createTicketDraft(@RequestPart(required = false) String description,
                                                  @RequestPart(required = false) String desired_resolution_date,
                                                  @RequestPart(required = false) String name,
                                                  @RequestPart(required = false) String text,
                                                  @RequestPart(required = false) String urgency,
                                                  @RequestPart String state,
                                                  @RequestPart String category) throws InterruptedException {
        clientService.createTicket(description, desired_resolution_date, name, text, urgency, state, category);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
