package org.airtribe.AuthenticationAuthorizationC12.service;

import org.airtribe.AuthenticationAuthorizationC12.entity.User;
import org.airtribe.AuthenticationAuthorizationC12.entity.UserDTO;
import org.airtribe.AuthenticationAuthorizationC12.entity.VerificationToken;
import org.airtribe.AuthenticationAuthorizationC12.repository.UserRepository;
import org.airtribe.AuthenticationAuthorizationC12.repository.VerificationTokenRepository;
import org.airtribe.AuthenticationAuthorizationC12.util.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService implements UserDetailsService {

  @Autowired
  private UserRepository _userRepository;

  @Autowired
  private PasswordEncoder _passwordEncoder;

  @Autowired
  private VerificationTokenRepository _verificationTokenRepository;

  public User registerUser(UserDTO userDTO) {
    User user = new User();
    user.setUsername(userDTO.getUsername());
    user.setPassword(_passwordEncoder.encode(userDTO.getPassword()));
    user.setEnabled(false);
    user.setRole("ADMIN");
    return _userRepository.save(user);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = _userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
        java.util.Collections.emptyList());
  }

  public void persistRegistrationToken(User registeredUser, String generatedToken) {
    VerificationToken verificationToken = new VerificationToken();
    verificationToken.setToken(generatedToken);
    verificationToken.setUser(registeredUser);
    verificationToken.setExpiryDate(new java.util.Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24));
    _verificationTokenRepository.save(verificationToken);
  }

  public boolean verifyRegistrationToken(String token) {
    VerificationToken verificationToken = _verificationTokenRepository.findByToken(token);
    if (verificationToken == null) {
      return false;
    }
    long registeredExpiryDate = verificationToken.getExpiryDate().getTime();
    if (registeredExpiryDate < System.currentTimeMillis()) {
      return false;
    }

    return true;
  }

  public void enableUser(String token) {
    VerificationToken verificationToken = _verificationTokenRepository.findByToken(token);
    if (verificationToken == null) {
      return;
    }

    User user = verificationToken.getUser();
    user.setEnabled(true);
    _userRepository.save(user);
    _verificationTokenRepository.delete(verificationToken);
  }

  public String signinUser(String username, String password) {
    User registeredUser = _userRepository.findByUsername(username);
    if(registeredUser == null) {
      return "User not found";
    }

    if (!registeredUser.isEnabled()) {
      return "User is not enabled, please verify your registration";
    }

    boolean isPasswordMatch = _passwordEncoder.matches(password, registeredUser.getPassword());

    if (!isPasswordMatch) {
      return "Invalid credentials";
    }

    return JwtUtility.generateToken(username, registeredUser.getRole());

  }
}
