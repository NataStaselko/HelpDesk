package com.final_project.staselko.servise.client;

import com.final_project.staselko.model.dto.TicketDto;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    void createTicket(String description,
                      String desired_resolution_date,
                      String name, String text,
                      String urgency, String state,
                      String category);

    ResponseEntity<TicketDto> showTicket(Long id);
}
