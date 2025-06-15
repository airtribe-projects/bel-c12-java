package org.airtribe.LearnerManagementSystemBelC12.controller;

import org.airtribe.LearnerManagementSystemBelC12.entity.Course;
import org.airtribe.LearnerManagementSystemBelC12.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {

  @Autowired
  private LearnerService _learnerService;

  @PostMapping("/courses")
  public Course createCourse(@RequestBody Course course) {
    return _learnerService.createCourse(course);
  }
}
