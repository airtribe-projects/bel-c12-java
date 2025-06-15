package org.airtribe.LearnerManagementSystemBelC12.controller;

import java.util.List;
import org.airtribe.LearnerManagementSystemBelC12.Exception.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC12.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC12.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC12.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CohortController {

  @Autowired
  private LearnerService _learnerService;

  @PostMapping("/cohorts")
  public Cohort createCohort(@RequestBody Cohort cohort) {
    return _learnerService.createCohort(cohort);
  }

  @PostMapping("/assignLearners")
  public Cohort assignLearnerToCohort(@RequestParam("cohortId") Long cohortId,
      @RequestParam("learnerId") Long learnerId) throws LearnerNotFoundException {
    return _learnerService.assignLearnerToCohort(cohortId, learnerId);
  }

  @GetMapping("/cohorts")
  public List<Cohort> getAllCohorts() {
    return _learnerService.getAllCohorts();
  }

  @PostMapping("/cohorts/{cohortId}/learners")
  public Cohort assignAndCreateLearnersToCohorts(@RequestBody List<Learner> learners,
      @PathVariable("cohortId") Long cohortId) throws LearnerNotFoundException {
    return _learnerService.assignLearnersToCohort(learners, cohortId);
  }
}

////Parent Child Relationship - Api Endpoints
//
//POST - /cohorts/1/learners
//POST - /cohorts/1/instructors
//POST - /learners/1/cohort