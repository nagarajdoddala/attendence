package com.cg.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.ams.entity.SubjectEntity;

/*
 * @author NagaRaju
 */
public interface SubjectDAO extends JpaRepository<SubjectEntity, Long> {

	
	// Query to delete record of subject by name
	@Query("DELETE from SubjectEntity a where a.subjectId like ?1")
	public SubjectEntity deleteBySubjectId(Long subjectId);
	

	
	// Query to findbyId record of subject by id
	@Query("SELECT s FROM SubjectEntity s WHERE s.subjectId like ?1")
	public SubjectEntity findBySubjectId(Long subjectId);
	
	

}