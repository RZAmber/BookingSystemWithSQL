package HotelBooking; 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
 
 
 
public class HomePage extends JFrame{ 
	private String[] hotel_info= new String[]{"Contact information","Tel: (201)586-9124","Email: hello_world_hotle@gmail.com"};  
	private String location;
	private String checkIn;
	private String checkOut;
	private	JTextField f1;
	private	JTextField f2;
	private	JTextField f3;
	private int year1;
	private int month1;
	private int day1;
	private int year2;
	private int month2;
	private int day2;
	private int days;
	private String email;
	private String firstname;
	private String lastname;
	private int phone;
	JComboBox s21;
	JComboBox s22;
	JComboBox s23;
	JComboBox s31;
	JComboBox s32;
	JComboBox s33;
 
 
	public HomePage(String email, String firstname, String lastname, int phone){ 
		
 	//Whole windows 
 		super("HOTEL BOOKING SYSTEM"); 
 		this.email=email;
 		this.firstname=firstname;
 		this.lastname = lastname;
 		this.phone=phone;
 		
 		
 		Container c=getContentPane(); 
 		c.setLayout(new BorderLayout()); 
 		ImageIcon bg=new ImageIcon("building.jpg"); 
 		JLabel l=new JLabel(bg); 
 		l.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight()); 
 		getLayeredPane().add(l,new Integer(Integer.MIN_VALUE)); 
 		((JPanel) c).setOpaque(false); 
 		
 		
 		//Title panel 
 		JPanel p1=new JPanel(); 
 		p1.setOpaque(false); 
 		JLabel label1=new JLabel("WELCOME TO HELLO WORLD HOTLE !"); 
 		label1.setForeground(Color.WHITE); 
 		label1.setFont(new Font("Zapfino", Font.BOLD,26)); 
 		p1.add(label1); 
 		c.add(BorderLayout.NORTH,p1); 
 	 
 	 
 	 
 		//user Operation panel 
 		JPanel p2=new JPanel(); 
 		p2.setOpaque(false); 
 		p2.setLayout(new FlowLayout(FlowLayout.LEFT)); 
 		// after user setting the date the font color turn black 
 		 f1=new JTextField("Please choose Location",13); 
 		f1.setForeground(Color.LIGHT_GRAY); 
 		 f2=new JTextField("Check in date",10); 
 		f2.setForeground(Color.LIGHT_GRAY); 
 		 f3=new JTextField("Check out date",10); 
 		f3.setForeground(Color.LIGHT_GRAY); 
 		JComboBox s1=new JComboBox(); 
 		s1.setMaximumRowCount(2);
 		s1.addItem("Please Choose");
 		s1.addItem("Hoboken");
 		
 		s1.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				String Location = (String)s1.getSelectedItem();
 				if(Location.equals("Hoboken")){
 					f1.setText("Hoboken");
 					f1.setForeground(Color.BLACK);
 				}
 				else if(Location.equals("Please Choose")){
 					f1.setText("Please Choose");
 					f1.setForeground(Color.BLACK);
 				}
 			}
 		});
 		
 		JComboBox s21=new JComboBox(); 
 		s21.addItem("Year");
 		for (int i = 2016; i <= 2050; i++)
 			s21.addItem(i);
 		JComboBox s22 = new JComboBox();
 		s22.addItem("Month");
 		for (int i = 1; i <= 12; i++)
 			s22.addItem(i);
 		JComboBox s23 = new JComboBox();
 		s23.addItem("Day");
 		for (int i = 1; i <= 31; i++)
 			s23.addItem(i);
 		s21.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				f2.setText(s21.getSelectedItem() + " " + s22.getSelectedItem()+ " " +s23.getSelectedItem());
 				f2.setForeground(Color.BLACK);
 			}
 		});
 		s22.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				f2.setText(s21.getSelectedItem() + " " + s22.getSelectedItem()+ " " +s23.getSelectedItem());
 				f2.setForeground(Color.BLACK);
 			}
 		});
 		s23.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				f2.setText(s21.getSelectedItem() + " " + s22.getSelectedItem()+ " " +s23.getSelectedItem());
 				f2.setForeground(Color.BLACK);
 			}
 		});
 	
 		JComboBox s31=new JComboBox(); 
 		s31.addItem("Year");
 		for (int i = 2016; i <= 2050; i++)
 			s31.addItem(i);
 		JComboBox s32 = new JComboBox();
 		s32.addItem("Month");
 		for (int i = 1; i <= 12; i++)
 			s32.addItem(i);
 		JComboBox s33 = new JComboBox();
 		s33.addItem("Day");
 		for (int i = 1; i <= 31; i++)
 			s33.addItem(i);
 		s31.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				f3.setText(s31.getSelectedItem() + " " + s32.getSelectedItem() + " " + s33.getSelectedItem());
 				f3.setForeground(Color.BLACK);
 			}
 		});
 		s32.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				f3.setText(s31.getSelectedItem() + " " + s32.getSelectedItem() + " " + s33.getSelectedItem());
 				f3.setForeground(Color.BLACK);
 			}
 		});
 		s33.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				f3.setText(s31.getSelectedItem() + " " + s32.getSelectedItem() + " " + s33.getSelectedItem());
 				f3.setForeground(Color.BLACK);
 			}
 		});
 		JButton b1=new JButton("OK"); 
 		b1.addActionListener(new ActionListener(){
 			public void actionPerformed(ActionEvent e){
 				location =f1.getText();
 				checkIn  = f2.getText();
 				checkOut = f3.getText();
 				year1 = (int)s21.getSelectedItem();
 				month1 = (int)s22.getSelectedItem();
 				day1 = (int)s23.getSelectedItem();
 				year2 = (int)s31.getSelectedItem();
 				month2 = (int)s32.getSelectedItem();
 				day2 = (int)s33.getSelectedItem();
 				JulianDate checkIn1 = new JulianDate(year1, month1, day1);
 				JulianDate checkOut1 = new JulianDate(year2, month2, day2);
 				if (year1 == year2){
 					days = checkOut1.sub(checkIn1);
 				} else {
 					days = checkOut1.sub1(checkIn1);
 				}
 				selectpage sp = new selectpage(location, checkIn, checkOut, days, email, firstname, lastname, phone );
 				sp.setVisible(true);
 				setVisible(false);
 			}

 		});
 		p2.add(f1); 
 		p2.add(s1); 
 		p2.add(f2); 
 		p2.add(s21); 
 		p2.add(s22);
 		p2.add(s23);
 		p2.add(f3); 
 		p2.add(s31); 
 		p2.add(s32);
 		p2.add(s33);
 		p2.add(b1); 
 		c.add(BorderLayout.CENTER,p2); 
 		
 		//information panel 
 		JPanel p3=new JPanel(); 
 		p3.setOpaque(false); 
 		p3.setBackground(Color.blue); 
 		p3.setLayout(new FlowLayout()); 
 	 

	 
 		// hotel contact information panel 
 		JPanel subp2=new JPanel(); 
 		subp2.setOpaque(false); 
 		subp2.setLayout(new GridLayout(3,1,20,10)); 
 		for(int i=0; i<hotel_info.length;i++){ 
 			JLabel l2=new JLabel(hotel_info[i]); 
 			l2.setForeground(Color.WHITE); 
 			l2.setFont(new Font("Noteworthy", Font.ITALIC,18)); 
 			l2.setHorizontalAlignment(JLabel.TRAILING); 
 			subp2.add(l2); 
 		} 
 	 
 
 
 		p3.add(subp2); 
 		c.add(BorderLayout.SOUTH,p3); 
 		setSize(1250,700); 
 		setResizable(false); 
 		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
 		setVisible(true); 
	}	 
	 
	// "getXX" methods to sent information to other page
	public String getLocat(){
		return location;
	}
	
	public String getcheckIn(){
		return checkIn;
	}
	
	public String getcheckOut(){
		return checkOut;
		
	}
	/*
	public void setYear1(int year1){
		this.year1 = (int)s21.getSelectedItem();
	}
	
	public void setMonth1(int month1){
		this.month1 = month1;
	}
	
	public void setDay1(int day1){
		this.day1 =day1;
	}
	
	public void setYear2(int year2){
		this.year2 = year2;
	}
	
	public void setMonth2(int month2){
		this.month2 = month2;
	}
	
	public void setDay2(int day2){
		this.day2 = day2;
	}
	
	public int getYear1(){
		//year1 = (int)s21.getSelectedItem();
		return year1;
	}
 
	public int getMonth1(){
		month1 = (int)s22.getSelectedItem();
		return month1;
	}
	
	public int getDay1(){
		day1 = (int)s23.getSelectedItem();
		return day1;
	}
	
	public int getYear2(){
		year2 = (int)s31.getSelectedItem();
		return year2;
	}
	
	public int getMonth2(){
		month2 = (int)s32.getSelectedItem();
		return month2;
	}
	
	public int getDay2(){
		day2 = (int)s33.getSelectedItem();
		return day2;
	}
	*/
	/*
	public int getDays(int year1, int month1, int day1, int year2, int month2, int day2){
		//year1 = (int)s21.getSelectedItem();
		//month1 = (int)s22.getSelectedItem();
		//day1 = (int)s23.getSelectedItem();
		//year2 = (int)s31.getSelectedItem();
		//month2 = (int)s32.getSelectedItem();
		//day2 = (int)s33.getSelectedItem();
		JulianDate checkIn1 = new JulianDate(year1, month1, day1);
		JulianDate checkOut1 = new JulianDate(year2, month2, day2);
		if (year1 == year2){
			days = checkOut1.sub(checkIn1);
		} else {
			days = checkOut1.sub1(checkIn1);
		}
		return days;
	}
	*/
 
}

