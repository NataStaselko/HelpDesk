package com.final_project.staselko.converter.dto.impl;

import com.final_project.staselko.converter.dto.CommentConverter;
import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.entiti.Comment;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CommentConverterImpl implements CommentConverter {
    @Override
    public Comment toComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        return comment;
    }

    @Override
    public CommentDto toCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setText(comment.getText());
        commentDto.setDate(comment.getData().format(DateTimeFormatter
                .ofPattern("MMM dd, yyyy HH:mm:ss").localizedBy(Locale.ENGLISH)));
        return commentDto;
    }
}
