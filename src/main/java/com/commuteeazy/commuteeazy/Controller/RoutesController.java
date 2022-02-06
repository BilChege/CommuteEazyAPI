/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.Controller;

import com.commuteeazy.commuteeazy.CustomObjects.CustomPlace;
import com.commuteeazy.commuteeazy.CustomObjects.CustomRoute;
import com.commuteeazy.commuteeazy.Domain.MatatuOperator;
import com.commuteeazy.commuteeazy.Domain.Place;
import com.commuteeazy.commuteeazy.Domain.Route;
import com.commuteeazy.commuteeazy.Service.GenericService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BilChege
 */

@RestController
public class RoutesController {
    
    @Autowired
    @Qualifier("routeService")
    private GenericService routeService;
    
    @Autowired
    @Qualifier("placeService")
    private GenericService placeService;
    
    @Autowired
    @Qualifier("matatuOperatorService")
    private GenericService matatuOperatorService;
    
    @GetMapping(path = "/routes/{operatorid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomRoute> getRoutes(@PathVariable("operatorid") int operatorId){
        List<CustomRoute> response = new ArrayList<>();
        List<Route> routes;
        if (operatorId > 0){
            MatatuOperator matatuOperator = (MatatuOperator) matatuOperatorService.findbyId(operatorId);
            routes = routeService.findByCriterion(Restrictions.eq("matatuOperator", matatuOperator));
        } else {
            routes = (List<Route>) routeService.findAll();
        }
        if (!routes.isEmpty()){
            for (Route route : routes){
                CustomRoute customRoute = new CustomRoute();
                customRoute.setId(route.getId());
                customRoute.setDescription(route.getDescription());
                response.add(customRoute);
            }
        }
        return response;
    }  
    
    
    @GetMapping(path = "/place/{routeid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomPlace> getPlacesInRoute(@PathVariable("routeid") int id){
        List<CustomPlace> response = new ArrayList<>();
        Route route = (Route) routeService.findbyId(id);
        Set<Place> places = route.getPlaces();
        if (!places.isEmpty()){
            for (Place place : places){
                CustomPlace customPlace = new CustomPlace();
                customPlace.setId(place.getId());
                customPlace.setPlaceName(place.getPlacename());
                customPlace.setPlaceId(place.getPlaceid());
                customPlace.setLon(place.getLon());
                customPlace.setLat(place.getLat());
                response.add(customPlace);
            }
        }
        return response;
    }
}
