/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.ServiceImpl;

import com.commuteeazy.commuteeazy.DAOHelper.PlaceDAO;
import com.commuteeazy.commuteeazy.Domain.Place;
import com.commuteeazy.commuteeazy.Service.GenericService;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author BilChege
 */
@Transactional
@Service("placeService")
public class PlaceService implements GenericService<Place> {
    
    @Autowired
    private PlaceDAO placeDAO;

    @Override
    public Place save(Place t) {
        return placeDAO.save(t);
    }

    @Override
    public void persist(Place t) {
        placeDAO.persist(t);
    }

    @Override
    public Place findbyId(int id) {
        return placeDAO.findById(id);
    }

    @Override
    public Collection<Place> findAll() {
        return placeDAO.findAll();
    }

    @Override
    public Collection<Place> findByQuery(String q) {
        return placeDAO.findByQuery(q);
    }

    @Override
    public Place merge(Place t) {
        return placeDAO.merge(t);
    }

    @Override
    public List<Place> findbySqlQuery(String s) {
        return placeDAO.findbySqlQuery(s);
    }

    @Override
    public List<Place> findBySqlQueryWithParams(String q, Object... params) {
        return placeDAO.findBySqlQueryWithParams(q, params);
    }

    @Override
    public List<Place> findBySqlQueryWithNamedParams(String q, Map<String, ? extends Object> params) {
        return placeDAO.findBySqlQueryWithNamedParams(q, params);
    }

    @Override
    public List<Place> findByNamedQuery(String name, Object... params) {
        return placeDAO.findByNamedQuery(name, params);
    }

    @Override
    public List<Place> findByNamedQueryAndNamedParams(String name, Map<String, ? extends Object> params) {
        return placeDAO.findByNamedQueryAndNamedParams(name, params);
    }

    @Override
    public List<Place> findByCriterion(Criterion... criterion) {
        return placeDAO.findByCriterion(criterion);
    }

    @Override
    public List<Place> findByCriterion(Order order, Criterion... criterions) {
        return placeDAO.findByCriterion(order, criterions);
    }

    @Override
    public void delete(Place t) {
        placeDAO.delete(t);
    }
    
}
