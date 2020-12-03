package com.cg.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.ams.entity.SubjectEntity;
import com.cg.ams.util.QueryUtil;

/*
 * @author NagaRaju
 */
public interface SubjectDao extends JpaRepository<SubjectEntity, Long> {

	// Query to find record of subject by id
	@Query(QueryUtil.VIEW_SUB_BY_ID)
	public List<SubjectEntity> findBySubjectId(Long subjectId);

}