/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.DAOImpl;

import com.commuteeazy.commuteeazy.DAO.AbstractDAO;
import com.commuteeazy.commuteeazy.DAOHelper.MatatuOperatorDAO;
import com.commuteeazy.commuteeazy.Domain.MatatuOperator;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BilChege
 */

@Repository
public class MatatuOperatorDAOImpl extends AbstractDAO<MatatuOperator, Integer> implements MatatuOperatorDAO{
    
    public MatatuOperatorDAOImpl(){
        super(MatatuOperator.class);
    }
    
}