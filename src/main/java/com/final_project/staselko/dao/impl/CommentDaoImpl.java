package com.final_project.staselko.dao.impl;

import com.final_project.staselko.dao.CommentDao;
import com.final_project.staselko.dao.HibernateDao;
import com.final_project.staselko.model.entiti.Comment;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CommentDaoImpl extends HibernateDao<Comment> implements CommentDao {
    public CommentDaoImpl() {
        setModelClass(Comment.class);
    }

    @Override
    public Comment saveCat(Comment comment) {
        create(comment);
        return comment;
    }

    @Override
    public Optional<Comment> getCommentById(Long commentId) {
        return findById(commentId);
    }
}
