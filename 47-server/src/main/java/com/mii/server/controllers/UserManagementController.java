/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.dto.UsernameAuthoritiesDto;
import com.mii.server.dto.UsernamePasswordDto;
import com.mii.server.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
public class UserManagementController {
    
    @Autowired
    MyUserDetailsService myUserDetailsService;
    
    @GetMapping("/login")
    public void testLogin(){
        System.out.println("test");
    }
    
    
    @PostMapping("login")
    public UsernameAuthoritiesDto login(@RequestBody UsernamePasswordDto upd){
        return myUserDetailsService.login(upd);
    }
}
