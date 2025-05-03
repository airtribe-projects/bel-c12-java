package org.example;

public class OfflineCourse extends Course {

  private String location;
  public OfflineCourse(String courseId, String courseName, String courseDescription, CourseLanguage courseLanguage, String location) {
    super(courseId, courseName, courseDescription, courseLanguage);
    this.location = location;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public void displayCourseDetails() {
    System.out.println("Course Id: " + courseId);
    System.out.println("Course Name: " + courseName);
    System.out.println("Course Description: " + courseDescription);
    System.out.println("Location: " + location);
  }
}
