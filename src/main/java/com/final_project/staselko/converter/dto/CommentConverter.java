package com.final_project.staselko.converter.dto;

import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.entiti.Comment;

public interface CommentConverter {

    Comment toComment(CommentDto commentDto);

    CommentDto toCommentDto(Comment comment);
}
