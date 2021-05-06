package com.mathan.agr_acc_mgr_ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ViewExpensesUI   {
	private JFrame frame; 
	private Container con;
	private JLabel exp_date; 
	private JLabel exp_term; 
	private JLabel exp_year; 
	private JLabel empty;
	public ViewExpensesUI()
	{
		frame=new JFrame();
		frame.setTitle("View Expenses"); 
		frame.setBounds(120, 90, 900, 600);
		frame.setResizable(false); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String col_names[]= {"Count","Term","Year","Name","Amount","Category","Pay-Date","Pay-Reason","Added By","Added Date"}; 
        Panel panel1 = new Panel();
        panel1.setLayout(new BorderLayout());
        Panel panel2 = new Panel(); 
        panel2.setLayout(new BorderLayout());
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, panel2);
        splitPane.setDividerLocation(100);
        frame.add(splitPane);
     
        
        
        exp_date = new JLabel("Date :"); 
        exp_date.setFont(new Font("Arial", Font.PLAIN, 15)); 
        exp_date.setSize(80,15); 
        exp_date.setLocation(15,20);
        panel1.add(exp_date); 
        
        exp_year = new JLabel("Year :"); 
        exp_year.setFont(new Font("Arial", Font.PLAIN, 15)); 
        exp_year.setLocation(15,40);
        exp_year.setSize(80,15);
       
        panel1.add(exp_year);
        
        exp_term = new JLabel("Term :"); 
        exp_term.setFont(new Font("Arial", Font.PLAIN, 15)); 
        exp_term.setLocation(15,60);
        exp_term.setSize(80,15);
        panel1.add(exp_term);
        
        empty = new JLabel(""); 
        empty.setFont(new Font("Arial", Font.PLAIN, 15)); 
        empty.setLocation(15,80);
        empty.setSize(900,15);
        panel1.add(empty);
        
        
        String rows[][]= {{"1","One","2020","Mathan","1000","Direct","20-05-2020","Wage","Mathan","20-05-2020"}};
        JTable table = new JTable(rows,col_names);
        JScrollPane sp=new JScrollPane(table);
        panel2.add(sp);
        frame.setVisible(true); 
	}

}
