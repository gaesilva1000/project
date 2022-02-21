package com.Project1.Project.service;

import java.util.List;
import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project1.Project.model.Candidate;
import com.Project1.Project.repository.CandidateRepository;

@Service
@Log4j2
public class CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;

	public List<Candidate> findForSkill(List<String> result) {
		log.info("[Inicia] CandidateService - findForSkill");
		try {

			List<Candidate> lista = candidateRepository.findBySkillsIn(result);
			List<Candidate> listskill = lista.stream().filter(c -> {

				if (c.getSkills().size() == result.size()) {
					return true;

				}
				System.out.println("False");
				return false;
			}).toList(); 
			log.info("[End] CandidateService - findForSkill");
			return listskill;
		} catch (Exception e) {
			return null;
		}

	}

	public Candidate save(Candidate candidate) {
		log.info("[Inicia] CandidateService - save");
		this.candidateRepository.save(candidate);
		log.info("[End] CandidateService - save");
		return candidate;
	}
	
	
	


}
