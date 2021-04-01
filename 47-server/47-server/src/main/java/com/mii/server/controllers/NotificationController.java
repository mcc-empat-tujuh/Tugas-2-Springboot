/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mii.server.controllers;

import com.mii.server.services.NotificationService;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@RestController

public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @RequestMapping(value = "/send/{employeeId}")
    public ResponseEntity<?> notificationEmail(@PathVariable Integer employeeId) throws MessagingException {
        if (employeeId == null) {
            return new ResponseEntity("Please insert employee Id", HttpStatus.ACCEPTED);
        }
        notificationService.sendEmail(employeeId);
        return new ResponseEntity<>("sukses", HttpStatus.ACCEPTED);
    }
}
