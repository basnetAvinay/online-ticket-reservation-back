package com.avinay.onlineTicketReservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class MiscController {

    @RequestMapping(value = "/test-token", method = RequestMethod.GET)
    public ResponseEntity<Object> testToken() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/user")
//    public String getCurrentUsername(Principal principal) {
//        return principal.getName();
//    }
}