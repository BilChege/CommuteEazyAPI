/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.Controller;

import com.commuteeazy.commuteeazy.Service.VerificationServices;
import java.io.IOException;
import java.net.URLDecoder;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BilChege
 */

@RestController
public class VerificationController {
    
    @Autowired
//    @Qualifier("verificationServices")
    private VerificationServices verificationServices;
    
    @RequestMapping(path = "/verifyphone",method = RequestMethod.GET)
    public @ResponseBody String verifyPhone(@RequestParam("phoneNumber") String phoneNumber) throws IOException{
        String value = URLDecoder.decode(phoneNumber);
        System.out.println(value);
        return verificationServices.verifyPhone(value);
    }
    
    @RequestMapping(path = "/sendEmail",method = RequestMethod.GET)
    public @ResponseBody String sendEmail(@RequestParam("userName") String userName,@RequestParam("email") String email) throws MessagingException{
        String emailVal = URLDecoder.decode(email);
        String userNameVal = URLDecoder.decode(userName);
        return verificationServices.sendEmail(userNameVal, emailVal);
    }
    
}
