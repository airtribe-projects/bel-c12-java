package org.airtribe.LearnerManagementSystemBelC12.entity;

public class CohortDTO {
  private Long cohortId;


  private String cohortName;

  public CohortDTO(Long cohortId, String cohortName) {
    this.cohortId = cohortId;
    this.cohortName = cohortName;
  }

  public Long getCohortId() {
    return cohortId;
  }

  public void setCohortId(Long cohortId) {
    this.cohortId = cohortId;
  }

  public String getCohortName() {
    return cohortName;
  }

  public void setCohortName(String cohortName) {
    this.cohortName = cohortName;
  }
}
