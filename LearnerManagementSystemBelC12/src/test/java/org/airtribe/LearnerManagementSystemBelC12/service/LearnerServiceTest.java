package org.airtribe.LearnerManagementSystemBelC12.service;

import java.util.Optional;
import org.airtribe.LearnerManagementSystemBelC12.Exception.LearnerNotFoundException;
import org.airtribe.LearnerManagementSystemBelC12.entity.Learner;
import org.airtribe.LearnerManagementSystemBelC12.repository.CohortRepository;
import org.airtribe.LearnerManagementSystemBelC12.repository.LearnerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.*;


@SpringBootTest
public class LearnerServiceTest {


  @InjectMocks
  private LearnerService _learnerService;

  @Mock
  private LearnerRepository _learnerRepository;


  @Test
  public void testLearnerSavedSuccessfully() {
    Learner learner = new Learner("test", "test", "test");
    when(_learnerRepository.save(learner)).thenReturn(learner);

    Learner createdLearner = _learnerService.createLearner(learner);
    Assertions.assertEquals("test", createdLearner.getEmail());
    Assertions.assertEquals("test", createdLearner.getName());
    Assertions.assertEquals("test", createdLearner.getPhoneNumber());
  }

  @Test
  public void testFindLearnerById_successfully() throws LearnerNotFoundException {
    Learner learner = new Learner("test", "test", "test");
    when(_learnerRepository.findById(1L)).thenReturn(java.util.Optional.of(learner));
    Learner learner1  = _learnerService.getLearnerById(1L);
    Assertions.assertEquals("test2", learner1.getEmail());
    Assertions.assertEquals("test", learner1.getName());
    Assertions.assertEquals("test", learner1.getPhoneNumber());

  }


  @Test
  public void testFindLearnerById_unhappyCase() throws LearnerNotFoundException {
    when(_learnerRepository.findById(1L)).thenReturn(Optional.empty());
    Learner learner = _learnerService.getLearnerById(1L);
    Assertions.assertNull(learner);
  }

}
