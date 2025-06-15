package org.example;

import java.util.Date;


public class Main {
  public static void main(String[] args) {

    Course javaOfflineCourse = new OfflineCourse("1", "Java Programming", "Learn Java from scratch", CourseLanguage.JAVA, "bangalore");
    Course javaOnlineCourse = new OnlineCourse("2", "Java Programming", "Learn Java from scratch", CourseLanguage.JAVA, "https://zoom.us/123");

    Course nodeOfflineCourse = new OfflineCourse("3", "Node.js Programming", "Learn Node.js from scratch", CourseLanguage.NODE, "mumbai");
    Course nodeOnlineCourse = new OnlineCourse("4", "Node.js Programming", "Learn Node.js from scratch", CourseLanguage.NODE, "https://zoom.us/456");


    Cohort c1 = new Cohort("1", "Cohort 1", "Cohort 1 Description", new Date(), new Date());
    Cohort c2 = new Cohort("2", "Cohort 2", "Cohort 2 Description", new Date(), new Date());
    Cohort c3 = new Cohort("3", "Cohort 3", "Cohort 3 Description", new Date(), new Date());
    Cohort c4 = new Cohort("4", "Cohort 4", "Cohort 4 Description", new Date(), new Date());

    javaOnlineCourse.addCohortToCourse(c1);
    javaOnlineCourse.addCohortToCourse(c2);

    javaOfflineCourse.addCohortToCourse(c3);
    nodeOnlineCourse.addCohortToCourse(c4);


    Learner javaLearner1 = new JavaLearner("1", "Java Learne 1", "test", 1);
    Learner javaLearner2 = new JavaLearner("2", "Java Learne 2", "test", 1);
    Learner nodeLearner1 = new NodeLearner("3", "Node Learne 1", "test", 1);
    Learner nodeLearner2 = new NodeLearner("4", "Node Learne 2", "test", 1);

    Instructor instructor1 = new Instructor("1", "Instructor 1", "test", "test", "test");

    c1.addLearnerToCohort(javaLearner1);
    c1.addLearnerToCohort(nodeLearner1);
    c1.addInstructorToCohort(instructor1);

    javaOnlineCourse.displayCourseDetails();

  }
}