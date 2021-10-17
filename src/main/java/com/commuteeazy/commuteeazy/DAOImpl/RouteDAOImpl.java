/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.DAOImpl;

import com.commuteeazy.commuteeazy.DAO.AbstractDAO;
import com.commuteeazy.commuteeazy.DAOHelper.RouteDAO;
import com.commuteeazy.commuteeazy.Domain.Route;
import org.springframework.stereotype.Repository;

/**
 *
 * @author BilChege
 */

@Repository
public class RouteDAOImpl extends AbstractDAO<Route, Integer> implements RouteDAO{

    public RouteDAOImpl() {
        super(Route.class);
    }
    
}
