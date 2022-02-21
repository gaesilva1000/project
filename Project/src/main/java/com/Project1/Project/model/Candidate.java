package com.Project1.Project.model;


import java.util.List;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long  id;
	private String name;
	@ElementCollection (targetClass = String.class)
	private List<String> skills ;

	
	
}
