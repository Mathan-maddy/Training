package com.mathan.business_layer;

import java.sql.SQLException;

import com.mathan.data_transfer.ExpenseDTO;
import com.mathan.storage_layer.AddExpenseDAO;
import com.mathan.storage_layer.DBConnection;

public class ExpenseBuinessLayer {
	
	private String exp_type;
	private AddExpenseDAO dao;
	
	public ExpenseBuinessLayer (ExpenseDTO exp_dto) throws Exception {
		dao=new AddExpenseDAO(exp_dto);	
	}
	
	public int calculateExpensePerDay() throws SQLException
	{
		return dao.sumExpensePerDay();
	}
	
	public int calculateExpensePerTerm() throws SQLException
	{
		return dao.sumExpensePerTerm();
	}

}
