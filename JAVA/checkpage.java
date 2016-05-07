package reserve;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class checkpage extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private String Fname;
	private String Lname;
	private String roomType;
	private int amount;
	private String  location;
	private String checkIn;
	private String checkOut;
	private String phone;
	private String email;
	private String comments;
	private int amount1;
	private int amount2;
	private int amount3;
	private int amount4;
	private String roomType1;
	private String roomType2;
	private String roomType3;
	private String roomType4;
	private int days;
	
	ImageIcon bg =new ImageIcon("spbackground.jpg");
			
	resultpage rp = new resultpage(Fname, Lname, roomType, amount, location,
			checkIn, checkOut, phone, email, comments, days, amount1, amount2, amount3, amount4, roomType1, roomType2, roomType3, roomType4);
	

	public checkpage(String location, String checkIn, String checkOut ,String roomType, int amount, int days, int amount1, int amount2, int amount3, int amount4, 
			String roomType1, String roomType2, String roomType3, String roomType4) {
		this.location=location;
		this.checkIn= checkIn;
		this.checkOut=checkOut;
		this.roomType=roomType;
		this.amount= amount;
		this.days = days;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.amount3 = amount3;
		this.amount4 = amount4;
		this.roomType1 = roomType1;
		this.roomType2 = roomType2;
		this.roomType3 = roomType3;
		this.roomType4 = roomType4;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		System.out.println(roomType);
		
		
		bg.setImage(bg.getImage().getScaledInstance(800,530,Image.SCALE_DEFAULT));
		JLabel l=new JLabel(bg);
		l.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		getLayeredPane().add(l,new Integer(Integer.MIN_VALUE));
		contentPane.setOpaque(false);
		setResizable(false);
		
		
		JPanel panel_2 = new JPanel();
	    panel_2.setOpaque(false);
		panel_2.setBounds(0, 27, 632, 479);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("First name");
		label.setBounds(53, 0, 138, 29);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setText("First name");
		textField.setColumns(10);
		textField.setBounds(317, 0, 190, 29);
		panel_2.add(textField);
		
		JLabel label_1 = new JLabel("Last name");
		label_1.setBounds(53, 29, 119, 29);
		panel_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setText("Last name");
		textField_1.setColumns(10);
		textField_1.setBounds(317, 29, 190, 29);
		
		panel_2.add(textField_1);
		
		JLabel label_2 = new JLabel("ROOM TYPE");
		label_2.setBounds(53, 58, 174, 29);
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setForeground(Color.LIGHT_GRAY);
		//textField_2.setText("ROOME TPYE");
		textField_2.setText(roomType);
		textField_2.setColumns(10);
		textField_2.setBounds(317, 58, 190, 29);
		panel_2.add(textField_2);
		
		JLabel label_3 = new JLabel("AMOUNT");
		label_3.setBounds(53, 87, 147, 29);
		panel_2.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setForeground(Color.LIGHT_GRAY);
		//textField_3.setText("AMOUNT");
		textField_3.setText(String.valueOf(amount));
		textField_3.setColumns(10);
		textField_3.setBounds(317, 87, 190, 29);
		panel_2.add(textField_3);
		
		JLabel label_4 = new JLabel("CHECK IN TIME");
		label_4.setBounds(53, 116, 147, 29);
		panel_2.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setForeground(Color.LIGHT_GRAY);
		//textField_4.setText("MM/DD/YY");
		textField_4.setText(checkIn);
		textField_4.setColumns(10);
		textField_4.setBounds(317, 116, 190, 29);
		panel_2.add(textField_4);
		
		JLabel label_5 = new JLabel("CHECK OUT TIME");
		label_5.setBounds(53, 145, 174, 29);
		panel_2.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setForeground(Color.LIGHT_GRAY);
		//textField_5.setText("MM/DD/YY");
		textField_5.setText(checkOut);
		textField_5.setColumns(10);
		textField_5.setBounds(317, 145, 190, 29);
		panel_2.add(textField_5);
		
		JLabel label_6 = new JLabel("CONTACT INFORMATION");
		label_6.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		label_6.setBounds(181, 186, 234, 39);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("PHONE NUMBER:");
		label_7.setBounds(52, 237, 131, 16);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("E-mail:");
		label_8.setBounds(53, 265, 61, 16);
		panel_2.add(label_8);
		
		textField_6 = new JTextField();
		textField_6.setForeground(Color.LIGHT_GRAY);
		textField_6.setText("PHONE NUMBER");
		textField_6.setColumns(10);
		textField_6.setBounds(315, 232, 192, 26);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setForeground(Color.LIGHT_GRAY);
		textField_7.setText("E-MAIL");
		textField_7.setColumns(10);
		textField_7.setBounds(315, 260, 192, 26);
		panel_2.add(textField_7);
		
		JLabel lblComments = new JLabel("COMMENTS£º");
		lblComments.setBounds(53, 312, 100, 16);
		panel_2.add(lblComments);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(317, 312, 190, 81);
		panel_2.add(textArea);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(150, 432, 117, 29);
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
			}
		});
		panel_2.add(btnBack);
		
		
		
		JButton btnComfirm = new JButton("comfirm");
		btnComfirm.setBounds(400, 432, 117, 29);
		btnComfirm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				Fname = textField.getText();
				Lname = textField_1.getText();
				//roomType = textField_2.getText();
				//amount = Integer.parseInt(textField_3.getText());
				//checkIn = textField_4.getText();
				//checkOut = textField_5.getText();
				phone = textField_6.getText();
				email = textField_7.getText();
				comments = textArea.getText();
				resultpage rp = new resultpage(Fname, Lname, roomType, amount, location,
						checkIn, checkOut, phone, email, comments, days, amount1, amount2, amount3, amount4, roomType1, roomType2, roomType3, roomType4);
				rp.setVisible(true);
				System.out.println(email);
			}
		});
		panel_2.add(btnComfirm);
				
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(0, -4, 632, 32);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_9 = new JLabel("CHECK OUT PAGE");
		label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 21));
		label_9.setBounds(208, 6, 189, 26);
		panel.add(label_9);
	}
	
	
	
	
	//set information part:
	public void setFname(String Fname){
		this.Fname=Fname;	
	}
	
	public void setLname(String Lname){
		this.Lname=Lname;
	}


	public void setRoomeType(String roomeTpye){
	this.roomType = roomType;
	
}

	public void setAmount(int amount){
	this.amount = amount;
}

	public void setPhone(String phone){
	this.phone= phone;
}
	
	public void setEmail(String email){
		this.email=email;
}
	
	public void setCheckIn(String checkIn){
		this.checkIn= checkIn;
}
	
	public void setCheckOut(String checkOut){
		this.checkOut=checkOut;
}
	
	public void setDays(int days){
		this.days = days;
	}

	//get information part:
	public String getFname(){
		return textField.getText();
	}
	
	public String getLname(){
		return textField_1.getText();
	}
	
	public String getRoomType(){
		return textField_2.getText();
	}
	
	public String getAmount(){
		return textField_3.getText();
	}
	
	public String getPhone(){
		return textField_4.getText();
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getComments(){
		return textField_6.getText();
	}

	public int getDays1(){
		return days;
	}
	
}
