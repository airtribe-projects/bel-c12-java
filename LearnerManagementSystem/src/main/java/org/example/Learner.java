package org.example;

public abstract class Learner {
  private String learnerId;

  private String learnerName;

  private String learnerEmail;

  public Learner(String learnerId, String learnerName, String learnerEmail) {
    this.learnerId = learnerId;
    this.learnerName = learnerName;
    this.learnerEmail = learnerEmail;
  }

  public String getLearnerId() {
    return learnerId;
  }

  public void setLearnerId(String learnerId) {
    this.learnerId = learnerId;
  }

  public String getLearnerName() {
    return learnerName;
  }

  public void setLearnerName(String learnerName) {
    this.learnerName = learnerName;
  }

  public String getLearnerEmail() {
    return learnerEmail;
  }

  public void setLearnerEmail(String learnerEmail) {
    this.learnerEmail = learnerEmail;
  }

  public abstract void displayLearnerDetails();
}
