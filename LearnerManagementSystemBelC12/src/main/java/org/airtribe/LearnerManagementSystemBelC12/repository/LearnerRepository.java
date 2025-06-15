package org.airtribe.LearnerManagementSystemBelC12.repository;

import org.airtribe.LearnerManagementSystemBelC12.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface LearnerRepository extends JpaRepository<Learner, Long> {
  Learner findByName(String learnerName);
}
