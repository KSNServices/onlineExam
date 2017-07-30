package com.onlineexam.dao;

import java.util.List;

import com.onlineexam.model.Budget;

public interface BudgetDAO {
	
		
	public Integer getId();
		
		public void saveBudget(Budget budget);
		
		
		public void removeBudget(Budget budget);

		
		public void updateBudjet(Budget budget);
}
