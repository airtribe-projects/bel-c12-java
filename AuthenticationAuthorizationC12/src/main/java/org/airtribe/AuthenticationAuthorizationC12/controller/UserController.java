package org.airtribe.AuthenticationAuthorizationC12.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import org.airtribe.AuthenticationAuthorizationC12.entity.User;
import org.airtribe.AuthenticationAuthorizationC12.entity.UserDTO;
import org.airtribe.AuthenticationAuthorizationC12.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

  @Autowired
  private AuthenticationService _authenticationService;

  @PostMapping("/register")
  public User registerUser(@RequestBody UserDTO userDTO) {
    User registeredUser = _authenticationService.registerUser(userDTO);
    String generatedToken = UUID.randomUUID().toString();
    String applicationUrl = "http://localhost:9200/verifyRegistration?token=" + generatedToken;
    System.out.println("Verify your identity by clicking on the following url: " + applicationUrl);
    _authenticationService.persistRegistrationToken(registeredUser, generatedToken);
    return registeredUser;
  }

  @PostMapping("/verifyRegistration")
  public String verifyRegistration(@RequestParam("token") String token) {
    boolean isTokenValid = _authenticationService.verifyRegistrationToken(token);
    if (isTokenValid) {
      _authenticationService.enableUser(token);
      return "Token verification successful, user enabled. Please login to proceed";
    } else {
      return "Token verification failed";
    }
  }

  @PostMapping("/signin")
  public String signin(@RequestParam("username") String username, @RequestParam("password") String password) {
    return _authenticationService.signinUser(username, password);
  }

  @PostMapping("/test")
  @PreAuthorize("hasRole('USER')")
  public String test() {
    Authentication auth = org.springframework.security.core.context.SecurityContextHolder.getContext().getAuthentication();
    String username = auth.getName();
    Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
    System.out.println("User authorities: " + authorities);
    System.out.println("Authenticated user: " + username);
    return "Test successful, authenticated user: " + username;

  }


  @GetMapping("/hello")
  public String hello() {
    return "Hello from auth";
  }
}
