package com.final_project.staselko.servise.entiti;
import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.entiti.Comment;
import com.final_project.staselko.model.entiti.Ticket;

import java.util.List;


public interface CommentService {
    void saveCat(Comment comment);
    CommentDto getCommentById(Long id);
    void updateComment(Long id, Comment comment);

    List<CommentDto> getCommentsByTicket(Long ticketId);


}
