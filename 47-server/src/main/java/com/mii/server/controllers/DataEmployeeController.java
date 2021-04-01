/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.DataEmployeeDTO;
import com.mii.server.services.DataEmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fadel M Nasution
 */
@RestController
@RequestMapping("/employee")
public class DataEmployeeController {
    
    @Autowired
    DataEmployeeService dataEmployeeService;
    
    @GetMapping("get-data")
    public List<DataEmployeeDTO> showData() {
        return dataEmployeeService.getData();
    }
}
