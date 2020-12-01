package com.cg.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.entity.SubjectEntity;
import com.cg.ams.service.SubjectService;
/*
 * @author NagaRaj
 */
//mark class as Controller  
@RestController
@RequestMapping("/api/attendanceManagementSystem")
public class SubjectController {
	// autowire the SubjectService class
	@Autowired
	SubjectService service;

	@GetMapping("/hello-world")
	public String sayHello() {
		return "HelloWorld";
	}

	

	// creating post mapping that post the subject detail in the database
	@PostMapping("/insert")
	public String create(@RequestBody SubjectEntity subject) {
		service.add(subject);
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return subject.getSubjectCode();
	}

	// creating put mapping that updates the subject detail
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody SubjectEntity subject) {
		service.update(subject);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	// creating a delete mapping that deletes a specified subject
	@RequestMapping(value = "/delete/{SubjectId}", method = RequestMethod.DELETE)
	public String deletesubject(@PathVariable Long subjectId) {
		service.deleteBySubjectId(subjectId);
		return "Subject has been deleted successfully";
	}

	// creating a get mapping that retrieves the detail of a specific subject
	@GetMapping("/findSubject/{subjectId}")
	public ResponseEntity<SubjectEntity> getSubjectBySubjectId(@PathVariable("subjectId") Long subjectId) {
	SubjectEntity subject = service.findBySubjectId(subjectId);
	return new ResponseEntity<SubjectEntity>(subject, new HttpHeaders(), HttpStatus.OK);
	}

	
}
