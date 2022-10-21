package com.final_project.staselko.servise;
import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.entiti.Comment;


public interface CommentService {
    Comment saveCat(Comment comment);
    CommentDto getCommentById(Long comment_id);
}
