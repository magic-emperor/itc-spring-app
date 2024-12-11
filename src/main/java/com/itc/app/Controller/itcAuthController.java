package com.itc.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itc.app.Dto.itcAuthRequest;
import com.itc.app.Dto.itcAuthResponse;
import com.itc.app.Dto.userDto;
import com.itc.app.Security.itcJwtUtil;
import com.itc.app.productServiceImplemets.userServiceImplemets;

@RestController
@RequestMapping("/api/itc/authenticate")
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
@CrossOrigin(origins = "http://localhost:3000")
public class itcAuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private itcJwtUtil ItcJwtUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private userServiceImplemets UserServiceImplemetnts;
    
    @PostMapping
    @CrossOrigin({"http://localhost:3000", "**"})
    public ResponseEntity<?> authenticate(@RequestBody itcAuthRequest itcAuthRequest) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(itcAuthRequest.getUserPhone(),itcAuthRequest.getUserPassword())
            );
            final userDto user = UserServiceImplemetnts.getUserById(UserServiceImplemetnts.getAllUsers().stream()
                    .filter(u -> u.getUserPhone().equals(itcAuthRequest.getUserPhone()))
                    .findFirst()
                    .orElseThrow(() -> new UsernameNotFoundException("User not found")).getUserId());
            final long userId = user.getUserId();
            final String userRole = user.getUserRole();
            final String jwt = ItcJwtUtil.generateToken(itcAuthRequest.getUserPhone(), userId, userRole);
            return ResponseEntity.ok(new itcAuthResponse(jwt));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Authentication error: " + e.getMessage());
        }
    }

}
