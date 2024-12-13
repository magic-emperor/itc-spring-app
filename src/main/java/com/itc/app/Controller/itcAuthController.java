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
import org.springframework.security.core.Authentication;

import com.itc.app.Dto.itcAuthRequest;
import com.itc.app.Dto.itcAuthResponse;
import com.itc.app.Dto.userDto;
import com.itc.app.Security.itcJwtUtil;
import com.itc.app.productServiceImplemets.userServiceImplemets;

@RestController
@RequestMapping("/api/itc/authenticate")
// @CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*",
// allowCredentials = "true")
@CrossOrigin(origins = "https://itc-order-app.onrender.com")
public class itcAuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private itcJwtUtil ItcJwtUtil;
    @SuppressWarnings("unused")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private userServiceImplemets UserServiceImplemetnts;

    @SuppressWarnings("unused")
    @PostMapping
    @CrossOrigin({ "https://itc-order-app.onrender.com", "**" })
    public ResponseEntity<?> authenticate(@RequestBody itcAuthRequest itcAuthRequest) {
        try {
            // Log authentication attempt
            System.out.println("Authentication attempt for phone: " + itcAuthRequest.getUserPhone());

            // Validate input
            if (itcAuthRequest.getUserPhone() == null || itcAuthRequest.getUserPassword() == null) {
                return ResponseEntity.badRequest().body("Phone and password are required");
            }

            // Attempt authentication
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            itcAuthRequest.getUserPhone(),
                            itcAuthRequest.getUserPassword()));

            // Find user
            userDto user = UserServiceImplemetnts.getAllUsers().stream()
                    .filter(u -> u.getUserPhone().equals(itcAuthRequest.getUserPhone()))
                    .findFirst()
                    .orElseThrow(() -> new UsernameNotFoundException(
                            "User not found with phone: " + itcAuthRequest.getUserPhone()));

            // Extract user details
            final long userId = user.getUserId();
            final String userRole = user.getUserRole();

            // Generate JWT
            final String jwt = ItcJwtUtil.generateToken(
                    itcAuthRequest.getUserPhone(),
                    userId,
                    userRole);

            // Log successful authentication
            System.out.println("Authentication successful for user: " + user.getUserName());

            return ResponseEntity.ok(new itcAuthResponse(jwt));

        } catch (BadCredentialsException e) {
            System.err.println("Bad credentials for phone: " + itcAuthRequest.getUserPhone());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Incorrect username or password");

        } catch (UsernameNotFoundException e) {
            System.err.println("User not found: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());

        } catch (Exception e) {
            // Log the full stack trace
            System.err.println("Authentication error:");
            e.printStackTrace();

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error: " + e.getMessage());
        }
    }

}
