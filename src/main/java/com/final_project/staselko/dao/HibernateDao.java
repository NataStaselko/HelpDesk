package com.final_project.staselko.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
@RequiredArgsConstructor
public abstract class HibernateDao<T extends Serializable> {

    private Class<T> modelClass;

    private SessionFactory sessionFactory;

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

    public T getAll() {
        CriteriaQuery<T> cq = getBuilder().createQuery(modelClass);
        Root<T> root = cq.from(modelClass);
        cq.select(root);
        TypedQuery<T> query = entityManager.createQuery(cq);
        List<T> results = query.getResultList();
        return (T) results;
    }

    private final CriteriaBuilder getBuilder(){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        return  builder;
    }


    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}

