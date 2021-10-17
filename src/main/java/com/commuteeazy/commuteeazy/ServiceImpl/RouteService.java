/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.ServiceImpl;

import com.commuteeazy.commuteeazy.DAOHelper.RouteDAO;
import com.commuteeazy.commuteeazy.Domain.Route;
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
@Service("routeService")
public class RouteService implements GenericService<Route>{
    
    @Autowired
    private RouteDAO routeDAO;

    @Override
    public Route save(Route t) {
        return routeDAO.save(t);
    }

    @Override
    public void persist(Route t) {
        routeDAO.persist(t);
    }

    @Override
    public Route findbyId(int id) {
        return routeDAO.findById(id);
    }

    @Override
    public Collection<Route> findAll() {
        return routeDAO.findAll();
    }

    @Override
    public Collection<Route> findByQuery(String q) {
        return routeDAO.findByQuery(q);
    }

    @Override
    public Route merge(Route t) {
        return routeDAO.merge(t);
    }

    @Override
    public List<Route> findbySqlQuery(String s) {
        return routeDAO.findbySqlQuery(s);
    }

    @Override
    public List<Route> findBySqlQueryWithParams(String q, Object... params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Route> findBySqlQueryWithNamedParams(String q, Map<String, ? extends Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Route> findByNamedQuery(String name, Object... params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Route> findByNamedQueryAndNamedParams(String name, Map<String, ? extends Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Route> findByCriterion(Criterion... criterion) {
        return routeDAO.findByCriterion(criterion);
    }

    @Override
    public List<Route> findByCriterion(Order order, Criterion... criterions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Route t) {
        routeDAO.delete(t);
    }
    
}
