/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.DAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author BilChege
 * @param <T>
 * @param <I>
 */
public abstract class AbstractDAO<T,I extends Serializable> implements GenericDAO<T, I>{
    
    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> clazz;

    public AbstractDAO(Class<T> clazz) {
        this.clazz = clazz;
    }
    
    @Override
    public T save(T t) {
        I id = (I) sessionFactory.getCurrentSession().save(t);
        return findById(id);
    }

    @Override
    public void persist(T t) {
        sessionFactory.getCurrentSession().persist(t);
    }

    @Override
    public T merge(T t) {
        return (T) sessionFactory.getCurrentSession().merge(t);
    }

    @Override
    public T findById(I i) {
        return sessionFactory.getCurrentSession().load(clazz, i);
    }

    @Override
    public Collection<T> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM "+clazz.getSimpleName()).list();
    }

    @Override
    public Collection<T> findByQuery(String s) {
        return sessionFactory.getCurrentSession().createQuery(s).list();
    }

    @Override
    public List<T> findbySqlQuery(String s) {
        SQLQuery sQLQuery = sessionFactory.getCurrentSession().createSQLQuery(s).addEntity(clazz);
        return sQLQuery.list();
    }

    @Override
    public List<T> findBySqlQueryWithParams(String q, Object... params) {
        SQLQuery sQLQuery = sessionFactory.getCurrentSession().createSQLQuery(q).addEntity(clazz);
        int indx = 0;
        for (Object param : params){
            sQLQuery.setParameter(indx, param);
            indx += 1;
        }
        return sQLQuery.list();
    }

    @Override
    public List<T> findBySqlQueryWithNamedParams(String q, Map<String, ? extends Object> params) {
        SQLQuery sQLQuery = sessionFactory.getCurrentSession().createSQLQuery(q).addEntity(clazz);
        for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            sQLQuery.setParameter(key, value);
        }
        return sQLQuery.list();
    }

    @Override
    public List<T> findByNamedQuery(String name, Object... params) {
        SQLQuery sQLQuery = sessionFactory.getCurrentSession().createSQLQuery(name).addEntity(clazz);
        int indx = 0;
        for (Object param : params){
            sQLQuery.setParameter(indx, param);
            indx += 1;
        }
        return sQLQuery.list();
    }

    @Override
    public List<T> findByNamedQueryAndNamedParams(String name, Map<String, ? extends Object> params) {
        SQLQuery sQLQuery = sessionFactory.getCurrentSession().createSQLQuery(name).addEntity(clazz);
        for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            sQLQuery.setParameter(key, value);
        }
        return sQLQuery.list();
    }

    @Override
    public List<T> findByCriterion(Criterion... criterion) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
        for (Criterion criterion1 : criterion){
            criteria.add(criterion1);
        }
        return criteria.list();
    }

    @Override
    public List<T> findByCriterion(Order order, Criterion... criterions) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
        criteria.addOrder(order);
        for (Criterion criterion : criterions){
            criteria.add(criterion);
        }
        return criteria.list();
    }

    @Override
    public void delete(T t) {
        sessionFactory.getCurrentSession().delete(t);
    }
    
}
