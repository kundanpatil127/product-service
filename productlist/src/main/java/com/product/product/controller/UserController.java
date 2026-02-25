package com.product.product.controller;
import com.product.product.dto.UserDto;
import com.product.product.entity.User;
import com.product.product.security.JwtUtil;
import com.product.product.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
     private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserService myUserService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return myUserService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto){
       Authentication authentication =  authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(userDto.getUsername(),userDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).toList();

        UserDetails userDetails = myUserService.loadUserByUsername(userDto.getUsername());
         return jwtUtil.generateToken(userDetails.getUsername(),roles);

    }
}
