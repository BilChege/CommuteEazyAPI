/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.ServiceImpl;

import com.commuteeazy.commuteeazy.DAOHelper.MatatuOperatorDAO;
import com.commuteeazy.commuteeazy.Domain.MatatuOperator;
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

@Service("matatuOperatorService")
@Transactional
public class MatatuOperatorService implements GenericService<MatatuOperator>{
    
    @Autowired
    private MatatuOperatorDAO matatuOperatorDAO;

    @Override
    public MatatuOperator save(MatatuOperator t) {
        return matatuOperatorDAO.save(t);
    }

    @Override
    public void persist(MatatuOperator t) {
        matatuOperatorDAO.persist(t);
    }

    @Override
    public MatatuOperator findbyId(int id) {
        return matatuOperatorDAO.findById(id);
    }

    @Override
    public Collection<MatatuOperator> findAll() {
        return matatuOperatorDAO.findAll();
    }

    @Override
    public Collection<MatatuOperator> findByQuery(String q) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MatatuOperator merge(MatatuOperator t) {
        return matatuOperatorDAO.merge(t);
    }

    @Override
    public List<MatatuOperator> findbySqlQuery(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MatatuOperator> findBySqlQueryWithParams(String q, Object... params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MatatuOperator> findBySqlQueryWithNamedParams(String q, Map<String, ? extends Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MatatuOperator> findByNamedQuery(String name, Object... params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MatatuOperator> findByNamedQueryAndNamedParams(String name, Map<String, ? extends Object> params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MatatuOperator> findByCriterion(Criterion... criterion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MatatuOperator> findByCriterion(Order order, Criterion... criterions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(MatatuOperator t) {
        matatuOperatorDAO.delete(t);
    }
    
}
