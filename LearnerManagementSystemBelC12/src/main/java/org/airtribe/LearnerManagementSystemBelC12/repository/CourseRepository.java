package org.airtribe.LearnerManagementSystemBelC12.repository;

import org.airtribe.LearnerManagementSystemBelC12.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
