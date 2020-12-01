package com.cg.ams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author NagaRaj
 *
 */

@Entity
@Table(name="ASSIGN_SUBJECT1")
public class subjectEntity{

	
	@Id
	@Column(name="SUBJECT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="COURSE_ID")
	private Long courseId;
	@Column(name="COURSE_NAME")
	private String courseName;
	@Column(name="NAME")
	private String name;
	@Column(name="SUBJECTCODE")
	private String subjectCode;
	@Column(name="SEMESTER")
	private String semester;
	@Column(name="DESCRIPTION")
	private String description;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
		return "SubjectEntity [id=" + id + ", courseId=" + courseId + ", courseName=" + courseName + ", name=" + name
				+ ", subjectCode=" + subjectCode + ", semester=" + semester + ", description=" + description + "]";
	}
	public void setDescription(String string) {
		
		
	}
	
	
	
}
