package org.airtribe.AuthenticationAuthorizationC12.repository;

import org.airtribe.AuthenticationAuthorizationC12.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
  VerificationToken findByToken(String token);
}
