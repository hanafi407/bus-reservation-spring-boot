package com.example.reservationbus.controller;

import com.example.reservationbus.entities.AppUser;
import com.example.reservationbus.model.AuthResponseModel;
import com.example.reservationbus.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Value("${app.jwt.expiration-token}")
    private Long expiration;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseModel> login(@RequestBody AppUser user){
        final AuthResponseModel authResponseModel;
        final Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                user.getUserName(),user.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenProvider.generateToken(authentication);

        System.out.println(token);

        authResponseModel=new AuthResponseModel(
                HttpStatus.OK.value(),
                "Authentication success",
                token,
                System.currentTimeMillis(),
                expiration);
        return ResponseEntity.ok(authResponseModel);
    }

}
