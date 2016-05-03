package reserve;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


 
 
public class HomePage extends JFrame{ 
	private String[] hotel_info= new String[]{"Contact information","Tel: (201)586-9124","Email: hello_world_hotle@gmail.com"};  
	private String location;
	private String checkIn;
	private String checkOut;
	private	JTextField f1;
	private	JTextField f2;
	private	JTextField f3;
	

 
 
	public HomePage(){ 
 	//Whole windows 
 		super("HOTEL BOOKING SYSTEM"); 
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
 				selectpage sp = new selectpage(location, checkIn, checkOut);
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

 
 	public static void main(String[] args) { 
 		new HomePage(); 
 		 
 	}  
 
 } 