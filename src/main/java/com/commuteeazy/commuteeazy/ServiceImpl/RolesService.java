/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.ServiceImpl;

import com.commuteeazy.commuteeazy.DAOHelper.RolesDAO;
import com.commuteeazy.commuteeazy.Domain.Roles;
import com.commuteeazy.commuteeazy.Service.GenericService;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author BilChege
 */

@Service
public class RolesService implements GenericService<Roles>{
    
    @Autowired
    private RolesDAO rolesDAO;

    @Override
    public Roles save(Roles t) {
        return rolesDAO.save(t);
    }

    @Override
    public void persist(Roles t) {
        rolesDAO.persist(t);
    }

    @Override
    public Roles findbyId(int id) {
        return rolesDAO.findById(id);
    }

    @Override
    public Collection<Roles> findAll() {
        return rolesDAO.findAll();
    }

    @Override
    public Collection<Roles> findByQuery(String q) {
        return rolesDAO.findByQuery(q);
    }

    @Override
    public Roles merge(Roles t) {
        return rolesDAO.merge(t);
    }

    @Override
    public List<Roles> findbySqlQuery(String s) {
        return rolesDAO.findbySqlQuery(s);
    }

    @Override
    public List<Roles> findBySqlQueryWithParams(String q, Object... params) {
        return rolesDAO.findBySqlQueryWithParams(q, params);
    }

    @Override
    public List<Roles> findBySqlQueryWithNamedParams(String q, Map<String, ? extends Object> params) {
        return rolesDAO.findBySqlQueryWithNamedParams(q, params);
    }

    @Override
    public List<Roles> findByNamedQuery(String name, Object... params) {
        return rolesDAO.findByNamedQuery(name, params);
    }

    @Override
    public List<Roles> findByNamedQueryAndNamedParams(String name, Map<String, ? extends Object> params) {
        return rolesDAO.findByNamedQueryAndNamedParams(name, params);
    }

    @Override
    public List<Roles> findByCriterion(Criterion... criterion) {
        return rolesDAO.findByCriterion(criterion);
    }

    @Override
    public List<Roles> findByCriterion(Order order, Criterion... criterions) {
        return rolesDAO.findByCriterion(order, criterions);
    }

    @Override
    public void delete(Roles t) {
        rolesDAO.delete(t);
    }
    
}