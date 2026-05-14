package com.example.demo.controller;

import com.example.demo.entity.Candidate;
import com.example.demo.service.VotingService;
import com.example.external.service.ShowService;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/candidates")
public class VotingController {

    private final VotingService votingService;
    private final ShowService showService;
    private final MessageSource ms;

    public VotingController(VotingService myService, ShowService showService, MessageSource ms) {
        this.votingService = myService;
        this.showService = showService;
        this.ms = ms;
    }

    @GetMapping(path = {"/welcome","/login"}, produces = "application/json", headers = {"test", "test2"})
    public String welcome(@RequestParam(required = false) String id) {
        switch(id) {
            case "test":
                System.out.println("I am the Test! ID: " + id);
                break;
            case "bandon":
                System.out.println("I am the Bandon! ID: " + id);
                break;
            default:
                System.out.println("LMAO LMFAO! ID: " + id);
        }
        return ms.getMessage("greeting", new Object[]{"John"}, Locale.FRANCE);
    }

    @GetMapping("/show")
    public ResponseEntity<String> hello() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Location", "test")
                .body(showService.show());
//        return showService.show();
    }

    @GetMapping("")
    public ResponseEntity<List<Candidate>> candidates() {
        List<Candidate> list = votingService.returnCandidates();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> candidate(@PathVariable Long id) {
        Candidate fetchedCandidate = votingService.fetchCandidate(id);
        return ResponseEntity.ok(fetchedCandidate);
    }

    @GetMapping("/frontrunner")
    public ResponseEntity<Candidate> returnFrontrunner() {
        Candidate fetchedCandidate = votingService.frontRunner();
        return ResponseEntity.ok(fetchedCandidate);
    }

    @PostMapping("")
    public ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate) {
        System.out.println("Post");
        Candidate savedCandidate = votingService.createCandidate(candidate);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCandidate.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedCandidate);
    }

}
