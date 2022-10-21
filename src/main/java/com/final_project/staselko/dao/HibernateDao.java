package com.final_project.staselko.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public abstract class HibernateDao<T extends Serializable> {

    private Class<T> modelClass;

    @Autowired
    protected SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;


    public final void setModelClass(final Class<T> modelToSet) {
        this.modelClass = modelToSet;
    }

    public T findById(final long id) {
        return (T) getCurrentSession().get(modelClass, id);
    }

    public List<T> findAll() {
        return getCurrentSession().createQuery("from " + modelClass.getName())
                .list();
    }

    public long create(final T entity) {
        return (long) getCurrentSession().save(entity);
    }

    public T update(final T entity) {
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        getCurrentSession().delete(entity);
    }

    public T getByStringParam(String parameter, String value) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(modelClass);
        Root<T> root = cq.from(modelClass);
        ParameterExpression<String> p = builder.parameter(String.class);
        cq.select(root).where(builder.equal(root.get(parameter), p));
        TypedQuery<T> query = entityManager.createQuery(cq);
        query.setParameter(p, value);
        return query.getResultStream().findFirst().orElse(null);
    }

    public List<T> getAllByParam(String parameter, String value){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = builder.createQuery(modelClass);
        Root<T> root = cq.from(modelClass);
        ParameterExpression<String> p = builder.parameter(String.class);
        cq.select(root).where(builder.equal(root.get(parameter), p));
        TypedQuery<T> query = entityManager.createQuery(cq);
        query.setParameter(p, value);
        return query.getResultList();
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }














}

