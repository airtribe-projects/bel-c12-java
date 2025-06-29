package org.airtribe.AuthenticationAuthorizationC12.repository;

import org.airtribe.AuthenticationAuthorizationC12.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  public User findByUsername(String username);
}
