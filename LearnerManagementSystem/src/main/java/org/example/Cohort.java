package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Cohort {
    private String cohortId;
    private String cohortName;
    private String cohortDescription;

    private Date startDate;

    private Date endDate;

    private List<Learner> learnerList;

    private List<Instructor> instructorList;

    public Cohort(String cohortId, String cohortName, String cohortDescription, Date startDate, Date endDate) {
        this.cohortId = cohortId;
        this.cohortName = cohortName;
        this.cohortDescription = cohortDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.learnerList = new ArrayList<>();
        this.instructorList = new ArrayList<>();
    }

  public String getCohortId() {
    return cohortId;
  }

  public void setCohortId(String cohortId) {
    this.cohortId = cohortId;
  }

  public String getCohortName() {
    return cohortName;
  }

  public void setCohortName(String cohortName) {
    this.cohortName = cohortName;
  }

  public String getCohortDescription() {
    return cohortDescription;
  }

  public void setCohortDescription(String cohortDescription) {
    this.cohortDescription = cohortDescription;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public void addLearnerToCohort(Learner learner) {
    learnerList.add(learner);
  }

  public void addInstructorToCohort(Instructor instructor) {
    instructorList.add(instructor);
  }

  public List<Learner> getLearnerList() {
      return learnerList;
  }

  public List<Instructor> getInstructorList() {
      return instructorList;
  }

  public void displayCohortDetails() {
    System.out.println("Cohort Id: " + cohortId);
    System.out.println("Cohort Name: " + cohortName);
    System.out.println("Cohort Description: " + cohortDescription);
    System.out.println("Start Date: " + startDate);
    System.out.println("End Date: " + endDate);

    for (Learner learner : learnerList) {
      learner.displayLearnerDetails();
    }

    for (Instructor instructor : instructorList) {
      instructor.displayInstructorDetails();
    }
  }
}
