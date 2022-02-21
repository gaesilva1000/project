package com.Project1.Project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.Project1.Project.model.Candidate;

import com.Project1.Project.repository.CandidateRepository;
import com.Project1.Project.service.CandidateService;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api")
public class CandidateController {

	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private CandidateService candidateService;

	@GetMapping("/candidate/search")
	public List<Candidate> getAll() {
		// Candidate result = candidadteService.findForSkill(bookTitle);
		return candidateRepository.findAll();
	}

	@GetMapping("/candidate/search/skill")
	public ResponseEntity<List<Candidate>> getforSkill(@RequestParam("skill") List<String> skill,
			HttpServletRequest request, HttpServletResponse response) {

		List<Candidate> result = candidateService.findForSkill(skill);
		if (result.isEmpty()) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
	}

	@GetMapping("/candidate/search/find")
	public List<Candidate> getforName(@RequestParam("find") String skill) {
		// Candidate result = candidadteService.findForSkill(bookTitle);
		return candidateRepository.findByNameLike(skill);
	}

	@PostMapping("/candidate/save")
	public ResponseEntity<Candidate> create(@RequestBody Candidate candidate) {
		Candidate candidato = candidateService.save(candidate);
		return ResponseEntity.status(HttpStatus.CREATED).body(candidato);
	}

}
