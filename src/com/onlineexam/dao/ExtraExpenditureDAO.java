package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.ExtraExpenditure;

public interface ExtraExpenditureDAO {
	
public Integer getId();
	
	public void saveExtraExpenditure(ExtraExpenditure extra_expenditure);
	
	
	public void removeExtraExpenditure(ExtraExpenditure extra_expenditure);
	
	public void updateExtraExpenditure(ExtraExpenditure extra_expenditure);

}
