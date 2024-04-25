package com.phuong.livestreamapi.controller;


import com.phuong.livestreamapi.model.AppUser;
import com.phuong.livestreamapi.repository.IAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IAppUserRepository appUserRepository;

    @GetMapping("info")
    public ResponseEntity<?> getUserInfo(Principal principal) {
        return new ResponseEntity<>(this.appUserRepository.getAppUserByUsername(principal.getName()), HttpStatus.OK);
    }
}
