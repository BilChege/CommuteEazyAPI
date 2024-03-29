package com.commuteeazy.commuteeazy.Domain;
// Generated Feb 19, 2022 9:01:51 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Place generated by hbm2java
 */
@Entity
@Table(name="place"
    ,schema="public"
)
public class Place  implements java.io.Serializable {


     private int id;
     private Route route;
     private String placename;
     private String placeid;
     private Double lat;
     private Double lon;

    public Place() {
    }

	
    public Place(int id) {
        this.id = id;
    }
    public Place(int id, Route route, String placename, String placeid, Double lat, Double lon) {
       this.id = id;
       this.route = route;
       this.placename = placename;
       this.placeid = placeid;
       this.lat = lat;
       this.lon = lon;
    }
   
     @Id 

    
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="route")
    public Route getRoute() {
        return this.route;
    }
    
    public void setRoute(Route route) {
        this.route = route;
    }

    
    @Column(name="placename", length=100)
    public String getPlacename() {
        return this.placename;
    }
    
    public void setPlacename(String placename) {
        this.placename = placename;
    }

    
    @Column(name="placeid", length=100)
    public String getPlaceid() {
        return this.placeid;
    }
    
    public void setPlaceid(String placeid) {
        this.placeid = placeid;
    }

    
    @Column(name="lat", precision=17, scale=17)
    public Double getLat() {
        return this.lat;
    }
    
    public void setLat(Double lat) {
        this.lat = lat;
    }

    
    @Column(name="lon", precision=17, scale=17)
    public Double getLon() {
        return this.lon;
    }
    
    public void setLon(Double lon) {
        this.lon = lon;
    }




}


