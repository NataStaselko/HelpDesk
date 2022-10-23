package com.final_project.staselko.servise.client;

import com.final_project.staselko.model.dto.TicketDto;

public interface ClientService {
    void createTicket(String description,
                      String desired_resolution_date,
                      String name, String text,
                      String urgency, String state,
                      String category);
}
