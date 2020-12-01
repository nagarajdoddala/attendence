package com.cg.ams.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ams.entity.SubjectEntity;
import com.cg.ams.repository.SubjectDAO;

@Service("service")
@Transactional
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectDAO dao;

	// saving a specific record by using the method save() of CrudRepository
	@Override
	public Long add(SubjectEntity entity) {
		dao.save(entity);
		return entity.getCourseId();
	}

	// updating a record
	@Override
	public void update(SubjectEntity entity) {
		dao.save(entity);

	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	@Override
	public void deleteBySubjectId(Long subjectId) {
		dao.deleteById(subjectId);
	}


	@Override
	public List<SubjectEntity> findAllsubjects() {
		List<SubjectEntity> subject = new ArrayList<SubjectEntity>();
		dao.findAll().forEach(subject1 -> subject.add((SubjectEntity) subject));
		return subject;
		
	}

	@Override
	public SubjectEntity findBySubjectId(Long subjectId) {
		return dao.findBySubjectId(subjectId);
	}

	

}