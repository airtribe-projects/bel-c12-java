package org.airtribe.AuthenticationAuthorizationC12.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableMethodSecurity
public class AuthConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder(11);
  }

  @Bean
  public SecurityFilterChain securityFilterChainAuth(HttpSecurity httpSecurity) throws Exception {

    httpSecurity.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            authorizeRequests -> authorizeRequests.requestMatchers("/register", "/verifyRegistration", "/signin", "/test")
                .permitAll()
                .anyRequest()
                .authenticated())
        .formLogin(formLogin -> formLogin.defaultSuccessUrl("/hello", true).permitAll())
        .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    return httpSecurity.build();
  }
}
