package com.masai.service;

import com.masai.model.LogInDTO;
import com.masai.model.User;
import com.masai.model.UserDTO;

public interface UserService {

    public String register(UserDTO userDTO);

    public String verifyOTPRequest(String email, String otp);

    public String regenOTPProcess(String email);

    public String logIn(LogInDTO logInDTO);

    public User getUserByEmail(String name);
}
