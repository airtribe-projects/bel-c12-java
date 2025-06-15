package org.airtribe.LearnerManagementSystemBelC12.controller;

import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import org.airtribe.LearnerManagementSystemBelC12.Exception.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC12.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC12.entity.CohortDTO;
import org.airtribe.LearnerManagementSystemBelC12.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC12.entity.LearnerDTO;
import org.airtribe.LearnerManagementSystemBelC12.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LearnerController {

  @Autowired
  private LearnerService _learnerService;

  @PostMapping("/learners")
  public Learner createLearner(@RequestBody Learner learner) {
    return _learnerService.createLearner(learner);
  }

  @GetMapping("/learners")
  public List<Learner> findLearners(
      @RequestParam(value = "learnerName", required = false) String learnerName,
      @RequestParam(value = "learnerId", required = false) Long learnerId) throws LearnerNotFoundException {
    if (learnerId == null && learnerName == null) {

      return  _learnerService.getAllLearners();
//      List<LearnerDTO> learnerDTOs = new ArrayList<>();
//      for (Learner learner : learnerList) {
//        List<Cohort> cohorts = learner.getCohorts();
//        List<CohortDTO> cohortDTOs = new ArrayList<>();
//        for (Cohort coho : cohorts) {
//          CohortDTO cohortDTO = new CohortDTO(coho.getCohortId(), coho.getCohortName());
//          cohortDTOs.add(cohortDTO);
//        }
//        learnerDTOs.add(new LearnerDTO(learner.getLearnerId(), learner.getName(), learner.getEmail(),
//            learner.getPhoneNumber(), cohortDTOs));
//      }
    }

    List<Learner> learnerList = new ArrayList<>();
    if (learnerName == null && learnerId != null) {
      learnerList.add(_learnerService.getLearnerById(learnerId));
      return learnerList;
    }

    learnerList.add(_learnerService.getLearnerByName(learnerName));
    return learnerList;
  }

  @ExceptionHandler(LearnerNotFoundException.class)
  public ResponseEntity handleLearnerNotFoundException(LearnerNotFoundException e) {
    return ResponseEntity.status(404).body(e.getMessage());
  }
}
