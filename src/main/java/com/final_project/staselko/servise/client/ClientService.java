package com.final_project.staselko.servise.client;

import com.final_project.staselko.controllers.server.CommentsController;
import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.dto.HistoryDto;
import com.final_project.staselko.model.dto.TicketDto;

import java.util.List;

public interface ClientService {
    void createTicket(String description,
                      String desired_resolution_date,
                      String name,
                      String text,
                      String urgency,
                      String state,
                      String category);

    TicketDto showTicket(final Long id);

    void editTicket(final Long id,
                    String description,
                    String desired_resolution_date,
                    String name,
                    String text,
                    String urgency,
                    String state,
                    String category);

    List<TicketDto> getAllTickets();

    List<TicketDto> getTicketsByUser();

    List<HistoryDto> getHistoryByTicket(Long ticket_id);

    List<CommentDto> getCommentsByTicket(Long ticket_id);



}
