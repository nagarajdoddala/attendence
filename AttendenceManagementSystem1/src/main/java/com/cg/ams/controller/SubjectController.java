package com.cg.ams.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ams.entity.SubjectEntity;
import com.cg.ams.exception.RecordNotFoundException;
import com.cg.ams.service.SubjectService;

/*
 * @author NagaRaj
 */
//mark class as Controller  
@RestController

public class SubjectController {
	// autowire the SubjectService class
	@Autowired
	private SubjectService subjectService;
	public static final Logger log = Logger.getLogger(SubjectController.class.getName());

	@GetMapping("/hello-world")
	public String sayHello() {
		return "HelloWorld";
	}

	// creating a get mapping that retrieves all the subjects detail from the
	// database
	@GetMapping("/list-student")
	public List<SubjectEntity> getAllSubject() throws RecordNotFoundException {
		log.info("Started Viewing all Subject Details ");
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		return subjectService.findAllSubjects();

	}

	// creating post mapping that post the subject detail in the database
	@PostMapping("/insert-student")
	public Long create(@RequestBody SubjectEntity subject) {
		log.info("Started Viewing  Subject Details ");
		subjectService.add(subject);
		@SuppressWarnings({ "unused", "unchecked", "rawtypes" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		log.info("Completed creating Subject Details Viewed");
		return subject.getCourseId();
	}

	// creating put mapping that updates the subject detail
	@PutMapping("/update-student")
	public ResponseEntity<Boolean> update(@RequestBody SubjectEntity subject) {
		log.info("Started updating  Subject Details ");
		subjectService.update(subject);
		@SuppressWarnings({ "rawtypes", "unchecked" })
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		log.info("Completed updating  Subject Details ");
		return responseEntity;
	}

	// creating a delete mapping that deletes a specified subject
	@DeleteMapping(value = "/delete-student/{subjectId}")
	public String deleteSubject(@PathVariable("subjectId") Long subjectId) throws RecordNotFoundException {
		log.info("Started deleting  Subject Details ");
		subjectService.deleteBySubjectId(subjectId);
		log.info("Completed deleting  Subject Details ");
		return "subject has been deleted successfully";
	}

	// creating a get mapping that retrieves the detail of a specific subject
	@GetMapping("/find-Subject/{subjectId}")
	public ResponseEntity<SubjectEntity> getSubjectById(@PathVariable("subjectId") Long subjectId)
			throws RecordNotFoundException {
		log.info("Started finding subject Details By subject Id  ");
		SubjectEntity subject = subjectService.getSubjectById(subjectId);
		log.info("completed finding subject Details By subject Id  ");
		return new ResponseEntity<SubjectEntity>(subject, new HttpHeaders(), HttpStatus.OK);
	}

}
