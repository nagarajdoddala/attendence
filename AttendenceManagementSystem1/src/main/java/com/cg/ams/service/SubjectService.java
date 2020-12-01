package com.cg.ams.service;

import java.util.List;

import com.cg.ams.entity.SubjectEntity;
/*
 * @author NagaRaj
 */
public interface SubjectService {

	public Long add(SubjectEntity entity);

	public void update(SubjectEntity entity);

	public List<SubjectEntity> findAllsubjects();

	public void deleteBySubjectId(Long subjectId);

	public SubjectEntity findBySubjectId(Long subjectId);

	

}
