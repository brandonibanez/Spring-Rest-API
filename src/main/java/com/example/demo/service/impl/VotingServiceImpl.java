package com.example.demo.service.impl;

import com.example.demo.dao.CandidateDAO;
import com.example.demo.entity.Candidate;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VotingServiceImpl implements VotingService {

    private CandidateDAO candidateDAO;

    List<Candidate> candidates = List.of(
            new Candidate(1, "John", "first"),
            new Candidate(2, "Jane", "second"),
            new Candidate(3, "Bob", "third")
    );

    public VotingServiceImpl(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
        System.out.println("VotingServiceImpl constructor called");
    }

    @Override
    public List<Candidate> returnCandidates() {
//        candidateDAO.findAll();
//        return candidates;
        return candidateDAO.findAll();
    }

    @Override
    public Candidate frontRunner() {
//        return candidates.stream().filter(a -> Objects.equals(a.getRank(), "first")).toList().getFirst();
        List<Candidate> list = candidateDAO.findAll();
        return list.stream().filter(a -> Objects.equals(a.getRanks(), "first")).toList().getFirst();
    }

    @Override
    public Candidate fetchCandidate(String id) {
        return candidateDAO.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id", id));
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
        return candidateDAO.save(candidate);
    }
}
