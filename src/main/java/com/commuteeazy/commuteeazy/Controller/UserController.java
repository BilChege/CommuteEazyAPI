/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.Controller;

import com.commuteeazy.commuteeazy.Domain.Users;
import com.commuteeazy.commuteeazy.Service.GenericService;
import java.util.List;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BilChege
 */

@RestController
public class UserController {
    
    @Autowired
    @Qualifier("usersService")
    private GenericService usersService;
    
    @RequestMapping(path = "/saveuser",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Users addUser(@RequestBody Users user){
        return (Users) usersService.save(user);
    }
    
    @RequestMapping(path = "/login",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Users loginUser(@RequestParam("username") String username,@RequestParam("password")String password){
        return (Users) usersService.findByCriterion(Restrictions.eq("username", username),Restrictions.eq("accountpassword", password)).get(0);
    }
    
    @RequestMapping(path = "/allusers",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getUsers(){
        return (List<Users>) usersService.findAll();
    }
    
}
