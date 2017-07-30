package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Library;

public interface LibarayDAO {
	

	public Integer getId();
	
		
		
		public void removeLibrary(Library library);

		
		public void updateLibrary(Library library);

	public	void saveLibrary(Library library);
}
