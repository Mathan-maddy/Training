package com.mathan.storage_layer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mathan.data_transfer.ExpenseDTO;

public class AddExpenseDAO {
	
	private Connection con;
	private Statement stmt;
	private ExpenseDTO dto;
	
	public AddExpenseDAO(ExpenseDTO dto) throws ClassNotFoundException, SQLException
	{
		this.dto=dto;
		DBConnection db_con=new DBConnection();
		con=db_con.establishConnection();

	}


	public void viewExpense() throws SQLException
	{
        stmt = con.createStatement();
		String query="select * from Expenses";
		ResultSet rs  =stmt.executeQuery(query);
		while(rs.next())
		{
		//System.out.println(rs.getInt(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		//System.out.println(rs.getString(7));
		//System.out.println(rs.getString(8));	
		}
		
	}
	
	public int expSeqIncr() throws SQLException
	{
		 int exp_seq=0;
		 String query="select * from Expenses";
		 stmt = con.createStatement();
		 ResultSet rs  =stmt.executeQuery(query);
		 while (rs.next()) {
			    ++exp_seq; 
		 }
		 return exp_seq+1;
	}
/*		
	public void creatTable() throws SQLException
	{
	String crt_tbl="CREATE TABLE Expenses ("
		    +"exp_seq int,"
		    +"term varchar(255),"
		    +"term_yr varchar(255),"
		    +"name varchar(255),"
		    +"amount int,"
		    +"dop varchar(255),"
		    +"pay_rsn varchar(5535),"
		    +"created_dt varchar(255),"
		    +"created_by varchar(255))";
			stmt = con.createStatement();
			stmt.execute(crt_tbl);
	}
*/
	
	public void insertExpense() throws SQLException
	{
		String ins_rec="insert into Expenses (exp_seq,term,term_yr,name,amount,"
						+"dop,pay_rsn,created_dt,created_by)"
						+"values (?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStmt = con.prepareStatement(ins_rec);
		preparedStmt.setInt(1,this.expSeqIncr());
		preparedStmt.setString(2,dto.getTerm());
		preparedStmt.setString(3, dto.getYear());
		preparedStmt.setString(4, dto.getName());
		preparedStmt.setInt(5,Integer.parseInt(dto.getAmount()));
		preparedStmt.setString(6, dto.getDate_of_pay());
		preparedStmt.setString(7, dto.getPay_reason());
		preparedStmt.setString(8, dto.getCurrent_date());
		preparedStmt.setString(9, "Mathan");
		preparedStmt.execute();	    		
	}
	
	public int sumExpensePerDay() throws SQLException
	{
		int total=0;
		String Exp_per_day="select sum(amount) from Expenses where dop like"
							+"?";
		
		PreparedStatement preparedStmt = con.prepareStatement(Exp_per_day);
		preparedStmt.setString(1, dto.getDate_of_pay());
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		{
			total=rs.getInt(1);
			
		}
		return total;
	
	}
	
	public int sumExpensePerTerm() throws SQLException
	{
		int total=0;
		String Exp_per_term="select sum(amount) from Expenses where term like"
							+"?";
		
		PreparedStatement preparedStmt = con.prepareStatement(Exp_per_term);
		preparedStmt.setString(1, dto.getTerm());
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		{
			total=rs.getInt(1);
			
		}
		return total;
	}

}
