package com.final_project.staselko.servise.entiti.impl;

import com.final_project.staselko.converter.dto.CommentConverter;
import com.final_project.staselko.dao.CommentDao;
import com.final_project.staselko.dao.TicketDao;
import com.final_project.staselko.model.dto.CommentDto;
import com.final_project.staselko.model.entiti.Comment;
import com.final_project.staselko.model.entiti.Ticket;
import com.final_project.staselko.servise.entiti.CommentService;
import com.final_project.staselko.servise.entiti.TicketService;
import com.final_project.staselko.utils.entiti.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentDao;
    private final CommentConverter commentConverter;
    private final TicketDao ticketDao;

    @Override
    @Transactional
    public void saveCat(Comment comment) {
        commentDao.saveCat(comment);
    }

    @Override
    @Transactional
    public CommentDto getCommentById(Long id) {
        return commentConverter.toCommentDto(commentDao.getCommentById(id)
                .orElseThrow(() -> new RuntimeException("ticket not found with id " + id)));
    }

    @Override
    public void updateComment(Long id, Comment comment) {
        Comment commentEdit = commentConverter.toComment(commentConverter.toCommentDto(commentDao.getCommentById(id)
                .orElseThrow(() -> new RuntimeException("ticket not found with id " + id))));
        commentEdit.setText(comment.getText());
        commentDao.updateComment(commentEdit);
    }

    @Override
    public List<CommentDto> getCommentsByTicket(Long ticketId) {
        Ticket ticket = ticketDao.getTicketById(ticketId)
                .orElseThrow(() -> new RuntimeException("ticket not found with id " + ticketId));
        return commentDao.getCommentsByTicket(ticket).stream()
                .map(commentConverter::toCommentDto)
                .sorted(Comparator.comparing(CommentDto::getDate).reversed())
                .collect(Collectors.toList());
    }
}
