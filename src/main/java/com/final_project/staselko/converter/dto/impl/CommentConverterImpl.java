package com.final_project.staselko.converter.dto.impl;

import com.final_project.staselko.converter.dto.CommentConverter;
import com.final_project.staselko.converter.dto.UserConverter;
import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.entiti.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
@RequiredArgsConstructor
public class CommentConverterImpl implements CommentConverter {
    private final UserConverter userConverter;
    @Override
    public Comment toComment(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setTicket(commentDto.getTicket());
        return comment;
    }

    @Override
    public CommentDto toCommentDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setText(comment.getText());
        commentDto.setDate(comment.getData().format(DateTimeFormatter
                .ofPattern("MMM dd, yyyy HH:mm:ss").localizedBy(Locale.ENGLISH)));
        commentDto.setUserDto(userConverter.toUserDto(comment.getUser()));
        commentDto.setTicket(comment.getTicket());
        return commentDto;
    }
}
