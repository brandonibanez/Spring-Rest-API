package com.example.demo.service;

import com.example.demo.entity.Candidate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;


public interface VotingService {

    List<Candidate> returnCandidates();

    Candidate frontRunner();

    Candidate fetchCandidate(String id);

    Candidate createCandidate(Candidate candidate);

}
