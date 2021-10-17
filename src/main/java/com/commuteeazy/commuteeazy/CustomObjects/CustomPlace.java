/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.CustomObjects;

/**
 *
 * @author BilChege
 */
public class CustomPlace {
    
    private int id;
    private String placeName;
    private String placeId;
    private double lat;
    private double lon;

    public CustomPlace(int id, String placeName, String placeId, double lat, double lon) {
        this.id = id;
        this.placeName = placeName;
        this.placeId = placeId;
        this.lat = lat;
        this.lon = lon;
    }

    public CustomPlace() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
    
    
    
}
