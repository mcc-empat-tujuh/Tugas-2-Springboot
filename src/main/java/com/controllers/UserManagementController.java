/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.dto.UserLoginDto;
import com.dto.UserSessionDto;
import com.services.NotificationService;
import com.services.UserService;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jakab
 */
@RestController
@RequestMapping("/api/management")
public class UserManagementController {
    
    @Autowired
    NotificationService notificationService;
    
    @Autowired
    UserService userService;
    
    @PostMapping("/email-sender")
    public ResponseEntity<?> sendEmailConfirm (Integer employeeId) throws MessagingException{
        if (employeeId==null) {
            return new ResponseEntity<>("insert employee id first", HttpStatus.NOT_ACCEPTABLE);
        }
        notificationService.sendEmail(employeeId);
        return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
    }
    
    @PostMapping("/user-token")
    public UserSessionDto userNameLogin(@RequestBody UserLoginDto userLoginDto)throws Exception{
        return userService.loginUserByUserPassword(userLoginDto);
    }
    
}
