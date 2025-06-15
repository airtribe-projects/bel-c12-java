package org.example;

public class JavaLearner extends Learner {
  private int numberOfYearsJavaExperience;

  public JavaLearner(String learnerId, String learnerName, String learnerEmail, int numberOfYearsJavaExperience) {
    super(learnerId, learnerName, learnerEmail);
    this.numberOfYearsJavaExperience = numberOfYearsJavaExperience;
  }

  public int getNumberOfYearsJavaExperience() {
    return numberOfYearsJavaExperience;
  }

  public void setNumberOfYearsJavaExperience(int numberOfYearsJavaExperience) {
    this.numberOfYearsJavaExperience = numberOfYearsJavaExperience;
  }

  @Override
  public void displayLearnerDetails() {
    System.out.println("Learner Id: " + getLearnerId());
    System.out.println("Learner Name: " + getLearnerName());
    System.out.println("Learner Email: " + getLearnerEmail());
    System.out.println("Number of Years Java Experience: " + numberOfYearsJavaExperience);
  }
}
