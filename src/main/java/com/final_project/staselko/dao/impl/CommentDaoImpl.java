package com.final_project.staselko.dao.impl;

import com.final_project.staselko.dao.CommentDao;
import com.final_project.staselko.dao.HibernateDao;
import com.final_project.staselko.model.entiti.Comment;
import com.final_project.staselko.model.entiti.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentDaoImpl extends HibernateDao<Comment> implements CommentDao {
    public CommentDaoImpl() {
        setModelClass(Comment.class);
    }

    @Override
    public void saveCat(Comment comment) {
        create(comment);
    }

    @Override
    public Optional<Comment> getCommentById(Long commentId) {
        return findById(commentId);
    }

    @Override
    public void updateComment(Comment comment) {
        update(comment);
    }

    @Override
    public List<Comment> getCommentsByTicket(Ticket ticket) {
        return getAllByParam("ticket", ticket);
    }

    @Override
    public void addCommentByTicket(Ticket ticket) {

    }
}
