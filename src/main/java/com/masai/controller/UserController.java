package com.masai.controller;

import com.masai.model.LogInDTO;
import com.masai.model.User;
import com.masai.model.UserDTO;
import com.masai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> responseRegisterUser(@RequestBody UserDTO userDTO){
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return new ResponseEntity<>(userService.register(userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/verify-OTP")
    public ResponseEntity<String> responseVerifyOTPRequest(@RequestParam String email,@RequestParam String otp){

        return new ResponseEntity<>(userService.verifyOTPRequest(email,otp),HttpStatus.ACCEPTED);

    }

    @PutMapping("/regenOTP")
    public ResponseEntity<String> responseRegenOTPProcess(@RequestParam String email){
        return new ResponseEntity<>(userService.regenOTPProcess(email),HttpStatus.CREATED);
    }

    @PutMapping("/logIn")
    public ResponseEntity<String> responseUserLogIn(@RequestBody LogInDTO logInDTO){
        return new ResponseEntity<>(userService.logIn(logInDTO),HttpStatus.OK);
    }

    @GetMapping("/signIn")
    public ResponseEntity<String> getLoggedInCustomerDetailsHandler(Authentication auth){

        System.out.println(auth);

        User customer = userService.getUserByEmail(auth.getName());

        return new ResponseEntity<>(customer+"Logged In Successfully", HttpStatus.ACCEPTED);
    }



}
