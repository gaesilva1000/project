package com.Project1.Project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project1.Project.model.Candidate;


@Repository
public interface CandidateRepository extends JpaRepository <Candidate,Long> {

	List<Candidate> findBySkillsIn( List <String> skill );
	
	List<Candidate> findByNameLike(String name);
	
	List<Candidate> findByName(String name);
}