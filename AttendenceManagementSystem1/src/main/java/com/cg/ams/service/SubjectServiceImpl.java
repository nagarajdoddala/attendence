package com.cg.ams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ams.Exception.RecordNotFoundException;
import com.cg.ams.entity.SubjectEntity;
import com.cg.ams.repository.SubjectDao;
import com.cg.ams.util.ErrorMessageUtil;

@Service("service")
@Transactional
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectDao subjectDao;

	// saving a specific record by using the method save() of CrudRepository
	@Override
	public Long add(SubjectEntity entity) {
		subjectDao.save(entity);
		return entity.getCourseId();	
		}

	// updating a record
	@Override
	public void update(SubjectEntity entity) {
		subjectDao.save(entity);
	}

	// deleting a specific record by using the method deleteById() of CrudRepository
	// deleting a specific record by using the method deleteById() of CrudRepository
		@Override
		public void deleteBySubjectId(Long subjectId) throws RecordNotFoundException {
			if (subjectDao.findById(subjectId) == null) {
				throw new RecordNotFoundException(ErrorMessageUtil.SUB_RECORD_NOT_FOUND);
			}
			subjectDao.deleteById(subjectId);
		}

	// getting a specific record by using the method findAll() of CrudRepository
	@Override
	public List<SubjectEntity> findAllSubjects() throws RecordNotFoundException {
		List<SubjectEntity> subject = new ArrayList<SubjectEntity>();
		subjectDao.findAll().forEach(subject1 -> subject.add( subject1));
		return subject;
		
	}

    // getting a specific record by using the method findAll() of CrudRepository
	public SubjectEntity getSubjectById(Long subjectId) throws RecordNotFoundException {
		Optional<SubjectEntity> subject = subjectDao.findById(subjectId);
		if (subject.isEmpty()) {
			throw new RecordNotFoundException(ErrorMessageUtil.SUB_RECORD_NOT_FOUND);
		}
		return subject.get();
	}

	
	


	


	

}