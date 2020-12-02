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

import com.cg.ams.Exception.RecordNotFoundException;
import com.cg.ams.entity.SubjectEntity;
import com.cg.ams.service.SubjectService;
/*
 * @author NagaRaj
 */
//mark class as Controller  
@RestController
@RequestMapping("/api/amsattendence")
public class SubjectController {
	// autowire the SubjectService class
	@Autowired
	private SubjectService subjectService;

	@GetMapping("/hello-world")
	public String sayHello() {
		return "HelloWorld";		
	}
	//creating a get mapping that retrieves all the subjects detail from the database
	@GetMapping("/list")
	public List<SubjectEntity> getAllSubject() throws RecordNotFoundException {
		return subjectService.findAllSubjects();// response entity
		
	}
	// creating post mapping that post the subject detail in the database
	@PostMapping("/insert")
	public Long create(@RequestBody SubjectEntity subject) {
		subjectService.add(subject);
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return subject.getCourseId();
	}

	// creating put mapping that updates the subject detail
	@PutMapping("/update")
	public ResponseEntity<Boolean> update(@RequestBody SubjectEntity subject) {
		subjectService.update(subject);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return responseEntity;
	}

	// creating a delete mapping that deletes a specified subject
	// creating a delete mapping that deletes a specified student
		@RequestMapping(value = "/delete/{subjectId}", method = RequestMethod.DELETE)
		public String deleteSubject(@PathVariable("subjectId") Long subjectId) throws RecordNotFoundException {
			subjectService.deleteBySubjectId(subjectId);
			return "subject has been deleted successfully";
		}

	// creating a get mapping that retrieves the detail of a specific subject
	@GetMapping("/findSubject/{subjectId}")
	public ResponseEntity<SubjectEntity> getSubjectBycourseId(@PathVariable("courseId") Long subjectId) throws RecordNotFoundException {
	SubjectEntity subject = subjectService.getSubjectById(subjectId);
	return new ResponseEntity<SubjectEntity>(new HttpHeaders(), HttpStatus.OK);
	}

	
}
