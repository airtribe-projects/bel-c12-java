package org.airtribe.LearnerManagementSystemBelC12.entity;

import java.util.List;


public class LearnerDTO {
  private Long learnerId;

  private String name;

  private String email;

  private String phone;

  private List<CohortDTO> cohorts;

  public LearnerDTO(Long learnerId, String name, String email, String phone, List<CohortDTO> cohorts) {
    this.learnerId = learnerId;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.cohorts = cohorts;
  }

  public Long getLearnerId() {
    return learnerId;
  }

  public void setLearnerId(Long learnerId) {
    this.learnerId = learnerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public List<CohortDTO> getCohorts() {
    return cohorts;
  }

  public void setCohorts(List<CohortDTO> cohorts) {
    this.cohorts = cohorts;
  }
}
