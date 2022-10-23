package com.final_project.staselko.dao;

import com.final_project.staselko.model.entiti.Comment;

import java.util.Optional;

public interface CommentDao {
    Comment saveCat(Comment comment);
    Optional <Comment> getCommentById (Long commentId);

}
