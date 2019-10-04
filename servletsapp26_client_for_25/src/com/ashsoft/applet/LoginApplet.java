package com.ashsoft.applet;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@SuppressWarnings("serial")
public class LoginApplet extends Applet implements ActionListener {
	
	Label l1,l2;
	TextField tf1,tf2;
	Button b;
	String response="";
	
	@Override
	public void init() {
	  this.setBackground(Color.pink);
	  this.setVisible(true);
	  this.setSize(500,500);
	  this.setLayout(new FlowLayout());
	  
	  l1=new Label("Username");
	  l2=new Label("Password");
	  b=new Button("Login");
	  
	  tf1=new TextField(20);
	  tf2=new TextField(20);
	  tf2.setEchoChar('*');
	  b.addActionListener(this);
	  
	  Font f=new Font("consolas",Font.BOLD,20);
	  l1.setFont(f);
	  l2.setFont(f);
	  tf1.setFont(f);
	  tf2.setFont(f);
	  b.setFont(f);
	  
	  this.add(l1); this.add(tf1);
	  this.add(l2); this.add(tf2);
	  this.add(b);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
	try {
		String uname=tf1.getText();  //getting form data from GUI components
		String upwd=tf2.getText();
		
		String url="http://localhost:5050/servletsapp25/login?uname="+uname+"&upwd="+upwd;
		
		URL u= new URL(url);      //creating URL object
		URLConnection uc=u.openConnection(); //creating URLConnection object
		
		uc.setDoInput(true);  // Enabling submit request for connection
		uc.setDoOutput(true); //Enabling receive response for connection
		
		InputStream is=uc.getInputStream(); //reading data[response] into inputstream
		BufferedReader br=new BufferedReader(new InputStreamReader(is));  //Reading data into BufferedReader
		
		response=br.readLine();  //reading data into String object
		repaint();               //calling repaint method to display response on frame
	} catch (Exception e) {
		e.printStackTrace();
	}				
	}
	@Override
	public void paint(Graphics g) {
		Font f= new Font("arial",Font.BOLD, 20);
		g.setFont(f);                                 //output is displayed on Frame
		g.drawString("Login Status:"+response, 50, 250);
	}
}
