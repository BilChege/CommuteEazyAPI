/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.commuteeazy.commuteeazy.Controller;

import com.commuteeazy.commuteeazy.CustomObjects.CustomOperator;
import com.commuteeazy.commuteeazy.Domain.MatatuOperator;
import com.commuteeazy.commuteeazy.Service.GenericService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author BilChege
 */

@RestController
public class OperatorController {
    
    @Autowired
    @Qualifier("matatuOperatorService")
    private GenericService matatuOperatorService;
    
    @GetMapping(path = "/operators",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomOperator> fetchOperators(){
        List<CustomOperator> response = new ArrayList<>();
        List<MatatuOperator> matatuOperators = (List<MatatuOperator>) matatuOperatorService.findAll();
        if (!matatuOperators.isEmpty()){
            for (MatatuOperator matatuOperator : matatuOperators){
                CustomOperator customOperator = new CustomOperator();
                customOperator.setId(matatuOperator.getId());
                customOperator.setOperatorName(matatuOperator.getOperatorName());
                customOperator.setEmail(matatuOperator.getEmailAddress());
                customOperator.setPhone(matatuOperator.getPhone());
                response.add(customOperator);
            }
        }
        return response;
    }
    
}
