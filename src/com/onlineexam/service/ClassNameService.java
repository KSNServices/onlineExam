
package com.onlineexam.service;

import java.util.List;


import com.onlineexam.model.ClassName;

public interface ClassNameService {

	
	
	public List<ClassName> listClassName(int adminId ,int schoolId);

	public void saveClassName(ClassName className);

	public ClassName getClassNameById(Integer classNameId);

	public	ClassName listClassNamePresent(int adminId, int schoolId, String classPresent);

}
