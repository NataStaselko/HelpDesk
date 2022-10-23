package com.final_project.staselko.servise.entiti.impl;

import com.final_project.staselko.converter.dto.CommentConverter;
import com.final_project.staselko.dao.CommentDao;
import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.entiti.Comment;
import com.final_project.staselko.servise.entiti.CommentService;
import com.final_project.staselko.utils.entiti.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;
    private final CommentConverter commentConverter;


    @Override
    @Transactional
    public Comment saveCat(Comment comment) {
        return commentDao.saveCat(comment);

    }

    @Override
    @Transactional
    public CommentDto getCommentById(Long commentId) {
        return commentConverter.toCommentDto(commentDao.getCommentById(commentId)
                .orElseThrow(() -> new RuntimeException("ticket not found with id " + commentId)));
    }
}
