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
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @RequestMapping(path = "/saveuser/{mode}",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Users addUser(@RequestBody Users user,@PathVariable("mode") int mode){
        System.out.println("User ID: "+user.getId());
        Users response;
        if(mode == 0){
            System.out.println("Mode: save");
            response = (Users) usersService.save(user);
        } else {
            System.out.println("Mode: merge");
            Users saved = (Users) usersService.findbyId(user.getId());
            saved.setUsername(user.getUsername());
            saved.setEmailAddress(user.getEmailAddress());
            saved.setPhone(user.getPhone());
            saved.setAccountpassword(user.getAccountpassword());
            response = (Users) usersService.merge(saved);
        }
        return response;
    }
    
    @RequestMapping(path = "/login",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Users loginUser(@RequestParam("username") String username,@RequestParam("password")String password){
        Users user = new Users();
        List<Users> users = usersService.findByCriterion(Restrictions.eq("username", username),Restrictions.eq("accountpassword", password));
        if (users.size() > 0) {
            user = users.get(0);
        } else {
            user.setId(-1);
        }
        return user;
    }
    
    @RequestMapping(path = "/allusers",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getUsers(){
        return (List<Users>) usersService.findAll();
    }
    
}
