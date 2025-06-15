package org.example;

import java.util.ArrayList;
import java.util.List;


public abstract class Course {
  public String courseId;

  public String courseName;

  public String courseDescription;

  public CourseLanguage courseLanguage;

  public List<Cohort> cohortList;

  public Course(String courseId, String courseName, String courseDescription, CourseLanguage courseLanguage) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseDescription = courseDescription;
    this.courseLanguage = courseLanguage;
    cohortList = new ArrayList<>();
  }

  public String getCourseId() {
    return courseId;
  }

  public void setCourseId(String courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseDescription() {
    return courseDescription;
  }

  public void setCourseDescription(String courseDescription) {
    this.courseDescription = courseDescription;
  }

  public CourseLanguage getCourseLanguage() {
    return courseLanguage;
  }

  public void setCourseLanguage(CourseLanguage courseLanguage) {
    this.courseLanguage = courseLanguage;
  }

  public void addCohortToCourse(Cohort cohort) {
    cohortList.add(cohort);
  }

  public List<Cohort> getCohortList() {
    return cohortList;
  }

  public void removeCohortFromCourse(Cohort cohort) {
    cohortList.remove(cohort);
  }

  public abstract void displayCourseDetails();
}

