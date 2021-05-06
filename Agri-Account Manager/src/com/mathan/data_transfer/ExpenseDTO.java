package com.mathan.data_transfer;

public class ExpenseDTO {
	
	private String name;
	private String amount;
	private String category;
	private String date_of_pay;
	private String pay_reason;
	private String expense_per_day;
	private String expense_per_term;
	private String term;
	private String year;
	private String current_date;
	private String calc_exp_type;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDate_of_pay() {
		return date_of_pay;
	}
	public void setDate_of_pay(String date_of_pay) {
		this.date_of_pay = date_of_pay;
	}
	public String getPay_reason() {
		return pay_reason;
	}
	public void setPay_reason(String pay_reason) {
		this.pay_reason = pay_reason;
	}
	public String getExpense_per_day() {
		return expense_per_day;
	}
	public void setExpense_per_day(String expense_per_day) {
		this.expense_per_day = expense_per_day;
	}
	public String getExpense_per_term() {
		return expense_per_term;
	}
	public void setExpense_per_term(String expense_per_term) {
		this.expense_per_term = expense_per_term;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getCurrent_date() {
		return current_date;
	}
	public void setCurrent_date(String current_date) {
		this.current_date = current_date;
	}
	public String getCalc_exp_type() {
		return calc_exp_type;
	}
	public void setCalc_exp_type(String calc_exp_type) {
		this.calc_exp_type = calc_exp_type;
	}

}
