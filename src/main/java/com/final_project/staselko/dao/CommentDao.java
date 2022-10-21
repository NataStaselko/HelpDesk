package com.final_project.staselko.dao;

import com.final_project.staselko.model.entiti.Comment;

public interface CommentDao {
    Comment saveCat(Comment comment);
    Comment getCommentById (Long comment_id);

   // List<CommentDto> getAllCommentsByUser(Role role);
}
