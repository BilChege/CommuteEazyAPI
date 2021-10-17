/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.ServiceImpl;

import com.commuteeazy.commuteeazy.DAOHelper.UsersDAO;
import com.commuteeazy.commuteeazy.Domain.Users;
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

@Service("usersService")
@Transactional
public class UsersService implements GenericService<Users>{
    
    @Autowired
    private UsersDAO usersDAO;

    @Override
    public Users save(Users t) {
        return usersDAO.save(t);
    }

    @Override
    public void persist(Users t) {
        usersDAO.persist(t);
    }

    @Override
    public Users findbyId(int id) {
        return usersDAO.findById(id);
    }

    @Override
    public Collection<Users> findAll() {
        return usersDAO.findAll();
    }

    @Override
    public Collection<Users> findByQuery(String q) {
        return usersDAO.findByQuery(q);
    }

    @Override
    public Users merge(Users t) {
        return usersDAO.merge(t);
    }

    @Override
    public List<Users> findbySqlQuery(String s) {
        return usersDAO.findbySqlQuery(s);
    }

    @Override
    public List<Users> findBySqlQueryWithParams(String q, Object... params) {
        return usersDAO.findBySqlQueryWithParams(q, params);
    }

    @Override
    public List<Users> findBySqlQueryWithNamedParams(String q, Map<String, ? extends Object> params) {
        return usersDAO.findBySqlQueryWithNamedParams(q, params);
    }

    @Override
    public List<Users> findByNamedQuery(String name, Object... params) {
        return usersDAO.findByNamedQuery(name, params);
    }

    @Override
    public List<Users> findByNamedQueryAndNamedParams(String name, Map<String, ? extends Object> params) {
        return usersDAO.findByNamedQueryAndNamedParams(name, params);
    }

    @Override
    public List<Users> findByCriterion(Criterion... criterion) {
        return usersDAO.findByCriterion(criterion);
    }

    @Override
    public List<Users> findByCriterion(Order order, Criterion... criterions) {
        return usersDAO.findByCriterion(order, criterions);
    }

    @Override
    public void delete(Users t) {
        usersDAO.delete(t);
    }
    
}
