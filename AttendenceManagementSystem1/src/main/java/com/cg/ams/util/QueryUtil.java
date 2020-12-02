package com.cg.ams.util;

public class QueryUtil {
	private QueryUtil () {
		
	}
	public static final String VIEW_SUB_BY_ID = "SELECT  s FROM SubjectEntity s where  s.subjectId like ?1";
	public static final String DEL_SUB_BY_ID = "DELETE from SubjectEntity a where a.subjectId like ?1";

}
