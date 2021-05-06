package com.mathan.agr_acc_mgr_ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXDatePicker;

import com.mathan.business_layer.ExpenseBuinessLayer;
import com.mathan.data_transfer.ExpenseDTO;
import com.mathan.storage_layer.AddExpenseDAO;
import com.plugin.awesomejava.UIApp.CheckWeather;
import com.plugin.awesomejava.UIApp.MainWeatherFrame;

import java.awt.*; 
import java.awt.event.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AccountManagerUI extends JFrame 
implements ActionListener
{
	private Container c; 
    private JLabel title; 
    private JLabel expense_sheet;
    private JLabel invld_exp_sht;
    private JLabel invld_pay_rsn;
    private JLabel name; 
    private JLabel invalid_name; 
    private JLabel current_date; 
    private JTextField tname; 
    private JTextField calc_exp;
    private JLabel mno; 
    private JLabel invalid_amount; 
    private JTextField tmno; 
    private JLabel Category; 
    private JRadioButton Direct; 
    private JRadioButton Overhead; 
    private JRadioButton perday;
    private JRadioButton perterm;
    private ButtonGroup gengp;
    private ButtonGroup expense_grp;
    private JComboBox term_year;
    private JComboBox term;
    private JLabel DOP; 
    private JLabel invld_DOP; 
    private JComboBox date; 
    private JComboBox month; 
    private JComboBox year; 
    private JLabel add; 
    private JComboBox reason; 
    private JLabel If_Not_Listed; 
    private JTextArea tadd; 
    private JCheckBox promise; 
    private JButton sub; 
    private JButton weather; 
    private JButton reset; 
    private JButton view_exp; 
    private JButton calculate_expense; 
    private JLabel sub_window; 
    private JLabel debt_window; 
    private JTextArea tout; 
    private JTextArea debt_details;
    private JLabel res; 
    private JTextArea resadd; 
    private String submit_window="*******Sumbit Window********";
  
    private String dates[] 
        = { "-Date-","1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "-Month-","Jan", "feb", "Mar", "Apr", 
            "May", "Jun", "July", "Aug", 
            "Sep", "Oct", "Nov", "Dec" }; 
    private String years[] 
        = { "-Year-","2020","2021","2022"}; 
    
    private String reasons []
    		= {"-NOT LISTED-","Wage","Fertilizer","Weed Removal","Transport","Tea & Snacks","Seed Purchase"
    				,"Rented Machinery","Fuel & Electricity"};
    private String terms []
    		= {"-Term-","One","Two","Three","Four"};
  
    // constructor, to initialize the components 
    // with default values. 
    public AccountManagerUI() 
    { 
        setTitle("Agriculture Account Manager-Elathur"); 
        setBounds(50, 90, 1200, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        Calendar cal=Calendar.getInstance();
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("PADDY ACCOUNT-ELATHUR"); 
        title.setFont(new Font("Arial", Font.BOLD, 25)); 
        title.setSize(600, 25); 
        title.setLocation(400, 30); 
        c.add(title);    
        
        current_date = new JLabel(cal.getTime().toString()); 
        current_date.setFont(new Font("Arial", Font.PLAIN, 15)); 
        current_date.setSize(300, 15); 
        current_date.setLocation(10, 10); 
        c.add(current_date); 
        
        expense_sheet = new JLabel("Expense Sheet :"); 
        expense_sheet.setFont(new Font("Arial", Font.BOLD, 20)); 
        expense_sheet.setSize(300, 20); 
        expense_sheet.setLocation(40,60); 
        c.add(expense_sheet); //invld_exp_sht
        
        invld_exp_sht = new JLabel(); 
        invld_exp_sht.setFont(new Font("Arial", Font.BOLD, 15));
        invld_exp_sht.setForeground(Color.red);
        invld_exp_sht.setSize(300, 15); 
        invld_exp_sht.setLocation(380,60); 
        c.add(invld_exp_sht);
        
        term_year = new JComboBox(years); 
        term_year.setFont(new Font("Arial", Font.PLAIN, 15)); 
        term_year.setSize(80, 20); 
        term_year.setLocation(200, 60); 
        
        c.add(term_year);
        
        term = new JComboBox(terms); 
        term.setFont(new Font("Arial", Font.PLAIN, 15)); 
        term.setSize(80, 20); 
        term.setLocation(290, 60); 
        c.add(term);
  
        name = new JLabel("Name"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(80,20); 
        name.setLocation(80,100); 
        c.add(name); 
        
        invalid_name = new JLabel(); 
        invalid_name.setFont(new Font("Arial", Font.BOLD, 15)); 
        invalid_name.setForeground(Color.RED);
        invalid_name.setSize(100,15); 
        invalid_name.setLocation(330,100); 
        c.add(invalid_name); 
        
        invalid_amount = new JLabel(); 
        invalid_amount.setFont(new Font("Arial", Font.BOLD, 15)); 
        invalid_amount.setForeground(Color.RED);
        invalid_amount.setSize(150,15); 
        invalid_amount.setLocation(330,130); 
        c.add(invalid_amount); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(150, 20); 
        tname.setLocation(170, 100); 
        c.add(tname); 
  
        mno = new JLabel("Amount"); 
        mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mno.setSize(80, 20); 
        mno.setLocation(80, 130); 
        c.add(mno); 
  
        tmno = new JTextField(); 
        tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmno.setSize(150, 20); 
        tmno.setLocation(170, 130); 
        c.add(tmno); 
  
        Category = new JLabel("Category"); 
        Category.setFont(new Font("Arial", Font.PLAIN, 20)); 
        Category.setSize(100, 20); 
        Category.setLocation(80, 160); 
        c.add(Category); 
  
        Direct = new JRadioButton("Direct"); 
        Direct.setFont(new Font("Arial", Font.PLAIN, 15)); 
        Direct.setSelected(true); 
        Direct.setSize(80, 20); 
        Direct.setLocation(170, 160); 
        c.add(Direct); 
  
        Overhead = new JRadioButton("Overhead"); 
        Overhead.setFont(new Font("Arial", Font.PLAIN, 15)); 
        Overhead.setSelected(false); 
        Overhead.setSize(100, 20); 
        Overhead.setLocation(250, 160); 
        c.add(Overhead); 
  
        gengp = new ButtonGroup(); 
        gengp.add(Direct); 
        gengp.add(Overhead); 
  
        DOP = new JLabel("DOP"); 
        DOP.setFont(new Font("Arial", Font.PLAIN, 20)); 
        DOP.setSize(80, 20); 
        DOP.setLocation(80, 190); 
        c.add(DOP); 
  
        date = new JComboBox(dates); 
        date.setFont(new Font("Arial", Font.PLAIN, 15)); 
        date.setSize(70, 20); 
        date.setLocation(170, 190); 
        c.add(date); 
  
        month = new JComboBox(months); 
        month.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month.setSize(80, 20); 
        month.setLocation(240, 190); 
        c.add(month); 
  
        year = new JComboBox(years); 
        year.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year.setSize(70, 20); 
        year.setLocation(320, 190);
        c.add(year); 
        
        invld_DOP = new JLabel(); 
        invld_DOP.setFont(new Font("Arial", Font.BOLD, 15)); 
        invld_DOP.setForeground(Color.RED);
        invld_DOP.setSize(100,15); 
        invld_DOP.setLocation(400,190); 
        c.add(invld_DOP); 
  
        add = new JLabel("Pay-Reason"); 
        add.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add.setSize(150, 20); 
        add.setLocation(80, 220); 
        c.add(add); 
        
        reason = new JComboBox(reasons); 
        reason.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reason.setSize(150, 20); 
        reason.setLocation(200, 220); 
        c.add(reason);
        
        If_Not_Listed = new JLabel("If not listed,Add below :"); 
        If_Not_Listed.setForeground(Color.blue);
        If_Not_Listed.setFont(new Font("Arial", Font.ITALIC, 15)); 
        If_Not_Listed.setSize(150, 20); 
        If_Not_Listed.setLocation(80, 250); 
        c.add(If_Not_Listed); 
        
        invld_pay_rsn = new JLabel(); 
        invld_pay_rsn.setFont(new Font("Arial", Font.BOLD, 15)); 
        invld_pay_rsn.setForeground(Color.RED);
        invld_pay_rsn.setSize(250,15); 
        invld_pay_rsn.setLocation(230,250); 
        c.add(invld_pay_rsn); 
  
        tadd = new JTextArea(); 
        tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd.setSize(250, 50); 
        tadd.setLocation(80, 280); 
        tadd.setLineWrap(true); 
        c.add(tadd); 
  
        promise = new JCheckBox("Promise on your family"); 
        promise.setFont(new Font("Arial", Font.PLAIN, 20)); 
        promise.setSize(250, 20); 
        promise.setLocation(110, 350); 
        c.add(promise); 
  
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 10)); 
        sub.setSize(100, 20); 
        sub.setLocation(80, 390); 
        sub.addActionListener(this); 
        c.add(sub); 
        
        weather = new JButton("Check Weather"); 
        weather.setFont(new Font("Arial", Font.PLAIN, 20)); 
        weather.setSize(190, 40); 
        weather.setLocation(950, 30); 
        weather.addActionListener(this); 
        c.add(weather); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 10)); 
        reset.setSize(100, 20); 
        reset.setLocation(200, 390); 
        reset.addActionListener(this); 
        c.add(reset); 
        
        view_exp = new JButton("View Expenses"); 
        view_exp.setFont(new Font("Arial", Font.PLAIN, 10)); 
        view_exp.setSize(120, 20); 
        view_exp.setLocation(320, 390); 
        view_exp.addActionListener(this); 
        c.add(view_exp); 
        
        calculate_expense = new JButton("Calculate Expense"); 
        calculate_expense.setFont(new Font("Arial", Font.PLAIN, 10)); 
        calculate_expense.setSize(150, 20); 
        calculate_expense.setLocation(80, 450); 
        calculate_expense.addActionListener(this); 
        c.add(calculate_expense); 
        
        perday = new JRadioButton("Per Day"); 
        perday.setFont(new Font("Arial", Font.PLAIN, 15)); 
        perday.setSelected(true); 
        perday.setSize(80, 20); 
        perday.setLocation(240, 450);
        c.add(perday);
        
        perterm = new JRadioButton("Per Term"); 
        perterm.setFont(new Font("Arial", Font.PLAIN, 15)); 
        perterm.setSelected(false); 
        perterm.setSize(100, 20); 
        perterm.setLocation(330, 450);
        c.add(perterm);
        
        expense_grp =new ButtonGroup();
        expense_grp.add(perday);
        expense_grp.add(perterm);
        
        calc_exp = new JTextField(); 
        calc_exp.setFont(new Font("Arial", Font.PLAIN, 15)); 
        calc_exp.setSize(100, 20); 
        calc_exp.setLocation(440, 450); 
        calc_exp.setEditable(false);
        c.add(calc_exp);
        
        sub_window = new JLabel("Submit Window"); 
        sub_window.setFont(new Font("Arial", Font.PLAIN, 20));
        sub_window.setForeground(Color.BLUE);
        sub_window.setSize(150,20); 
        sub_window.setLocation(540,75); 
        c.add(sub_window); 
        
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setBackground(Color.LIGHT_GRAY);
        
        tout.setSize(200,200); 
        tout.setLocation(500, 100); 
        tout.setLineWrap(true); 
        tout.setEditable(false); 
        c.add(tout);
        
        debt_window = new JLabel("Debt Window"); 
        debt_window.setFont(new Font("Arial", Font.PLAIN, 20)); 
        debt_window.setForeground(Color.blue);
        debt_window.setSize(150,20); 
        debt_window.setLocation(540,315); 
        c.add(debt_window); 
        
        debt_details = new JTextArea(); 
        debt_details.setFont(new Font("Arial", Font.PLAIN, 15)); 
        debt_details.setBackground(Color.LIGHT_GRAY);
        debt_details.setSize(200,100); 
        debt_details.setLocation(500, 340); 
        debt_details.setLineWrap(true); 
        debt_details.setEditable(false); 
        c.add(debt_details); 
  
        res = new JLabel("Be Cost Effective"); 
        res.setFont(new Font("Arial", Font.BOLD, 25));
        res.setForeground(Color.green);
        res.setSize(500, 25); 
        res.setLocation(25, 510); 
        c.add(res); 
        
        setVisible(true); 
    } 
    
 
    
    public void actionPerformed(ActionEvent e) 
    { 
    	if(e.getSource()==sub) {
    	invalid_name.setText("");
    	invalid_amount.setText("");
    	invld_exp_sht.setText("");
    	invld_DOP.setText("");
    	invld_pay_rsn.setText("");
    	if(tname.getText().isEmpty())
    	{
    		invalid_name.setText("Empty Field !");
             e.setSource(null);
    	}
    	
    	if (tmno.getText().isEmpty())
    	{
    		invalid_amount.setText("Empty Field !");
            e.setSource(null);
    	}
    	
    	if (!(tmno.getText().isEmpty()))
    	{
    		String amnt=(String)tmno.getText();
    		char[] amt_arr=amnt.toCharArray();
    		for (char c:amt_arr) {
    			if(!(Character.isDigit(c)))
    			{
    				invalid_amount.setText("Only Number !");
    				e.setSource(null);
    			}
    		}
    	}
    	
    	if(term_year.getSelectedItem()=="-Year-")
    	{
    		if((term_year.getSelectedItem()=="-Year-") &&(term.getSelectedItem()=="-Term-"))
        		invld_exp_sht.setText("Ivalid Term and Year !");
        	else
        		invld_exp_sht.setText("Ivalid Year !");
    		e.setSource(null);
    	}
    	
    	if(term.getSelectedItem()=="-Term-")
    	{
    		if((term_year.getSelectedItem()=="-Year-") &&(term.getSelectedItem()=="-Term-"))
        		invld_exp_sht.setText("Ivalid Term and Year !");
        	else
        		invld_exp_sht.setText("Ivalid Term !");
    		e.setSource(null);
    	}
    	
    	if((date.getSelectedItem()=="-Date-")||(month.getSelectedItem()=="-Month-")||(year.getSelectedItem()=="-Year-"))
    	{
    		invld_DOP.setText("Invalid DOP !");
    		e.setSource(null);
    	}
    	
    	if(!((date.getSelectedItem()=="-Date-")||(month.getSelectedItem()=="-Month-")||(year.getSelectedItem()=="-Year-")))
    	{
    		if(term_year.getSelectedItem()!=year.getSelectedItem())
    		{
    			invld_DOP.setText("Wrong Year");
    			e.setSource(null);
    		}
    	} 
    	
    	if((reason.getSelectedItem()=="-NOT LISTED-") && tadd.getText().isEmpty())
    	{
    		invld_pay_rsn.setText("Select valid reason or add below !");
    	}
    }
    	ExpenseDTO exp_dto =new ExpenseDTO();
        if (e.getSource() == sub) { 
            if (promise.isSelected()) {            	
            	String pay_date;
            	pay_date=(String)date.getSelectedItem()+"/"+(String)month.getSelectedItem()+"/"+(String)year.getSelectedItem();
            	exp_dto.setTerm(term.getSelectedItem().toString());
            	exp_dto.setYear(term_year.getSelectedItem().toString());
            	exp_dto.setName(tname.getText());
            	exp_dto.setAmount(tmno.getText());
            	exp_dto.setDate_of_pay(pay_date);
            	exp_dto.setCurrent_date((String)current_date.getText());
            	
                String data1;
                
                String data 
                    = " Name : "
                      + tname.getText() + "\n"
                      + " Amount Paid : "
                      + tmno.getText() + "\n"; 
                if (Direct.isSelected()) {
                    data1 = " Category : Direct"
                            + "\n"; 
                    exp_dto.setCategory("Direct");
                }
                else {
                    data1 = " Category : Overhead"
                            + "\n"; 
                    exp_dto.setCategory("Overhead");
                }
                String data2 
                    = " DOP : "
                      + (String)date.getSelectedItem() 
                      + "/" + (String)month.getSelectedItem() 
                      + "/" + (String)year.getSelectedItem() 
                      + "\n"; 
                
                String data3=" Pay-Reason : " +reason.getSelectedItem().toString();
                exp_dto.setPay_reason((String)reason.getSelectedItem());
                if(reason.getSelectedItem()=="-NOT LISTED-")
                {
                	 data3 = " Pay-Reason : " + tadd.getText();
                	 exp_dto.setPay_reason(tadd.getText());
                }
                String data4=" Year :"+term_year.getSelectedItem().toString()+"         "+"Term: "+term.getSelectedItem().toString() +"\n \n";
                String s1="\n \n*********SUBMITTED*********";
                //Calling DAO to add the data to DB
               try {
				AddExpenseDAO exp_dao=new AddExpenseDAO(exp_dto);
				exp_dao.insertExpense();
				exp_dao.viewExpense();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
                tout.setText("\n" +data4 +data + data1 + data2 + data3+s1); 
                
                tout.setEditable(true); 
                res.setText("Cost Added Successfully !");            
            } 
            else { 
                tout.setText(submit_window); 
                
                res.setText("Please accept the Promise"); 
                
            } 
        } 
  
        else if (e.getSource() == reset) { 
            String def = ""; 
            tname.setText(def); 
            tadd.setText(def); 
            tmno.setText(def); 
            res.setText(def); 
            tout.setText(def); 
            promise.setSelected(false); 
            date.setSelectedIndex(0); 
            month.setSelectedIndex(0); 
            year.setSelectedIndex(0); 
            term.setSelectedIndex(0); 
            term_year.setSelectedIndex(0);
            reason.setSelectedIndex(0);
            
    } 
        else if (e.getSource() == calculate_expense) {
        	invld_exp_sht.setText("");
        	invld_DOP.setText("");
        	try {
        	int total=0; 
        	if(perday.isSelected())
        	{
        		if((date.getSelectedItem()=="-Date-")||(month.getSelectedItem()=="-Month-")||(year.getSelectedItem()=="-Year-"))
            	{
            		invld_DOP.setText("Pick the day !");
            		e.setSource(null);
            	}else {
        	exp_dto.setCalc_exp_type("perday");
        	exp_dto.setDate_of_pay((String)date.getSelectedItem()+"/"+(String)month.getSelectedItem()+"/"+(String)year.getSelectedItem());
        	ExpenseBuinessLayer exp_business= new ExpenseBuinessLayer(exp_dto);
        	total=exp_business.calculateExpensePerDay();
            	}
        	}
        	else
        	{
        		if(term.getSelectedItem()=="-Term-")
            	{
            		if((term_year.getSelectedItem()=="-Year-") &&(term.getSelectedItem()=="-Term-"))
                		invld_exp_sht.setText("Pick the Term and Year !");
                	else
                		invld_exp_sht.setText("Pick the  Term !");
            		e.setSource(null);
            	}
        		else {
        	exp_dto.setCalc_exp_type("perterm");
        	exp_dto.setTerm(term.getSelectedItem().toString());
        	ExpenseBuinessLayer exp_business= new ExpenseBuinessLayer(exp_dto);
        	total=exp_business.calculateExpensePerTerm();
        		}
        	}
        	calc_exp.setText(Integer.toString(total));
        	} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 	
        }
        else if (e.getSource() == view_exp) 
        {	
        	ViewExpensesUI vw_exp=new ViewExpensesUI();
        }
        
        else if (e.getSource()== weather)
        {
        	CheckWeather wthr_frm= new CheckWeather();
        	
        }
        }
}
    
