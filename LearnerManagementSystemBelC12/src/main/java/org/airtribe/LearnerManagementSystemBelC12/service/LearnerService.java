package org.airtribe.LearnerManagementSystemBelC12.service;

import java.util.List;
import java.util.Optional;
import org.airtribe.LearnerManagementSystemBelC12.Exception.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC12.entity.Cohort;
import org.airtribe.LearnerManagementSystemBelC12.entity.Course;
import org.airtribe.LearnerManagementSystemBelC12.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC12.repository.CohortRepository;
import org.airtribe.LearnerManagementSystemBelC12.repository.CourseRepository;
import org.airtribe.LearnerManagementSystemBelC12.repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LearnerService {

  @Autowired
  private LearnerRepository _learnerRepository;

  @Autowired
  private CohortRepository _cohortRepository;

  @Autowired
  private CourseRepository _courseRepository;

  public Learner createLearner(Learner learner) {
    return _learnerRepository.save(learner);
  }

  public List<Learner> getAllLearners() {
    List<Learner> learners = _learnerRepository.findAll();
    return learners;
  }

  public Learner getLearnerById(Long learnerId) throws LearnerNotFoundException {
    Optional<Learner> learnerOptional = _learnerRepository.findById(learnerId);
    if (learnerOptional.isPresent()) {
      return learnerOptional.get();
    }

    throw new LearnerNotFoundException("Learner not found with ID: " + learnerId);
  }

  public Learner getLearnerByName(String learnerName) {
    return _learnerRepository.findByName(learnerName);
  }

  public Cohort createCohort(Cohort cohort) {
    return _cohortRepository.save(cohort);
  }

  public Cohort assignLearnerToCohort(Long cohortId, Long learnerId) throws LearnerNotFoundException {
    Cohort cohort = _cohortRepository.findById(cohortId)
        .orElseThrow(() -> new RuntimeException("Cohort not found with ID: " + cohortId));
    Learner learner = _learnerRepository.findById(learnerId)
        .orElseThrow(() -> new LearnerNotFoundException("Learner not found with ID: " + learnerId));

    cohort.getLearners().add(learner);
    return _cohortRepository.save(cohort);

  }

  public List<Cohort> getAllCohorts() {
    return _cohortRepository.findAll();
  }

  public Course createCourse(Course course) {
    return _courseRepository.save(course);
  }

  public Cohort assignLearnersToCohort(List<Learner> learners, Long cohortId) throws LearnerNotFoundException {
    Optional<Cohort> cohortOptional = _cohortRepository.findById(cohortId);
    if (cohortOptional.isPresent()) {
      Cohort cohort = cohortOptional.get();
      cohort.getLearners().addAll(learners);
      //_learnerRepository.saveAll(learners);
      return _cohortRepository.save(cohort);

    } else {
      throw new LearnerNotFoundException("Cohort not found with ID: " + cohortId);
    }
  }
}
