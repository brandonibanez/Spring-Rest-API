package com.example.demo.service.impl;

import com.example.demo.dao.CandidateDAO;
import com.example.demo.entity.Candidate;
import com.example.demo.service.VotingService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VotingServiceImplTest {

    @Mock
    CandidateDAO candidateDAO;

    @InjectMocks
    VotingServiceImpl votingServiceImpl;

    List<Candidate> list;

    @BeforeEach()
    public void setUp(){
        list = List.of(
                new Candidate(1, "John", "first"),
                new Candidate(2, "Jane", "second"),
                new Candidate(3, "Bob", "third")
        );
    }

    @Test
    public void shouldReturnAllCandidates() {
        when(votingServiceImpl.returnCandidates()).thenReturn(list);

        List<Candidate> result = votingServiceImpl.returnCandidates();

        assertThat(list).usingRecursiveComparison().isEqualTo(result);
    }

}