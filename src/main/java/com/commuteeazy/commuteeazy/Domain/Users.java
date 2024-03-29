package com.commuteeazy.commuteeazy.Domain;
// Generated Feb 19, 2022 9:01:51 PM by Hibernate Tools 4.3.1


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="users"
    ,schema="public"
)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users  implements java.io.Serializable {


     private int id;
     private String username;
     private String emailAddress;
     private String phone;
     private String accountpassword;

    public Users() {
    }

	
    public Users(int id) {
        this.id = id;
    }
    public Users(int id, String username, String emailAddress, String phone, String accountpassword) {
       this.id = id;
       this.username = username;
       this.emailAddress = emailAddress;
       this.phone = phone;
       this.accountpassword = accountpassword;
    }
   
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    
    @Column(name="username", length=50)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="email_address", length=100)
    public String getEmailAddress() {
        return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    
    @Column(name="phone", length=50)
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    @Column(name="accountpassword", length=100)
    public String getAccountpassword() {
        return this.accountpassword;
    }
    
    public void setAccountpassword(String accountpassword) {
        this.accountpassword = accountpassword;
    }




}


