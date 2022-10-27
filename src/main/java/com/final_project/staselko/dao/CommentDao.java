package com.final_project.staselko.dao;

import com.final_project.staselko.model.entiti.Comment;
import com.final_project.staselko.model.entiti.Ticket;

import java.util.List;
import java.util.Optional;

public interface CommentDao {
    void saveCat(Comment comment);
    Optional <Comment> getCommentById (Long commentId);
    void updateComment(Comment comment);

    List<Comment> getCommentsByTicket(Ticket ticket);
    void addCommentByTicket(Ticket ticket);
}
