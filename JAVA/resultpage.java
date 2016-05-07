package reserve;

import java.awt.BorderLayout; 
import java.awt.EventQueue; 
 
 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder; 
import javax.swing.JLabel; 
import java.awt.Font; 
import java.awt.Image; 
 
 
import javax.swing.JTextArea; 
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color; 
import javax.swing.JScrollBar;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Properties;
import java.awt.event.ActionEvent; 
import javax.swing.JRadioButton; 

import javax.swing.JRadioButton;

public class resultpage extends JFrame {

	private JPanel contentPane;
	ImageIcon bg =new ImageIcon("spbackground.jpg");
    
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
	private int days;
	private int amount1;
	private int amount2;
	private int amount3;
	private int amount4;
	private String roomType1;
	private String roomType2;
	private String roomType3;
	private String roomType4;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resultpage frame = new resultpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	/**
	 * Create the frame.
	 */
	public resultpage(String Fname, String Lname, String roomType, int amount, String location, 
			String checkIn, String checkOut, String phone, String email, String comments, int days, int amount1, int amount2, int amount3, int amount4, 
			String roomType1, String roomType2, String roomType3, String roomType4) {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.Fname = Fname;
		this.Lname = Lname;
		this.roomType = roomType;
		this.amount = amount;
		this.location = location;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.phone = phone;
		this.email = email;
		this.comments = comments;
		this.days = days;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.amount3 = amount3;
		this.amount4 = amount4;
		this.roomType1 = roomType1;
		this.roomType2 = roomType2;
		this.roomType3 = roomType3;
		this.roomType4 = roomType4;
		
		setBounds(100, 100, 581, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		bg.setImage(bg.getImage().getScaledInstance(600,550,Image.SCALE_DEFAULT));
		JLabel l=new JLabel(bg);
		l.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		getLayeredPane().add(l,new Integer(Integer.MIN_VALUE));
		contentPane.setOpaque(false);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("congratulation£¡Predetermined success £¡");
		lblNewLabel.setFont(new Font("Cochin", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(6, 6, 326, 40);
		panel.add(lblNewLabel);
		
		JLabel lblOrderInformation = new JLabel("Order Information:");
		lblOrderInformation.setBounds(16, 48, 130, 16);
		panel.add(lblOrderInformation);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				check Check = new check(Fname, Lname, roomType, amount, location, checkIn,
						checkOut, phone, email, comments, days, amount1, amount2, amount3, amount4, roomType1, roomType2, roomType3, roomType4);
				System.out.println(Check);
				
				String host="smtp.163.com";   
				  final String user = "wangjavapro";  
				  final String password = new String("wangjiao");
				   
				 
				 
				   if(!user.equals("") && !password.equals(""))
				   {
				     String SMTP_PORT = "25";
				     String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";    
				     
				     String to = email;
				   
				     //Get the session object  
				     Properties props = new Properties();
				     props.put("mail.smtp.starttls.enable", "true");
				     props.put("mail.smtp.host",host);  
				     props.put("mail.smtp.auth", "true");  
				     props.put("mail.debug", "true");
				     props.put("mail.smtp.port", SMTP_PORT);
				     props.put("mail.smtp.socketFactory.port", SMTP_PORT);
				     props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
				     props.put("mail.smtp.socketFactory.fallback", "false");  
				    
				     Session session = Session.getDefaultInstance(props,  
				     new javax.mail.Authenticator() {
				         
				       protected PasswordAuthentication getPasswordAuthentication() {  
				       return new PasswordAuthentication(user,password);  
				       }  
				     });    
				    
				     //Compose the message  
				      
				     try
				     {  
				        MimeMessage message = new MimeMessage(session);  
				         
				        // creates message part
				        MimeBodyPart messageBodyPart = new MimeBodyPart();
				        messageBodyPart.setContent(message, "text/html");     
				      
				        message.setFrom(new InternetAddress(user));  
				        message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));        
				         
				        message.setSubject("Confirmation");
				        message.setText( "Family Name: " + Fname + "\n" + "Last Name: " + Lname +
				        		"\n" + "Room Type: " + roomType + "\n" + "Amount: " + amount + 
				        		"\n" + "Location: " + location + "\n" + "Check In Date: " + checkIn +
				        		"\n" + "Check Out Date: " + checkOut + "\n" + "Phone Number: " + phone + 
				        		"\n" + "Email: " + email + "\n" + "Comments: " + comments);  
				        //send the message  
				        Transport.send(message);    
				      
				        JOptionPane.showMessageDialog(null,"message sent successfully...");
				        //jLabel7.setVisible(false);
				      } 
				      catch (MessagingException e1) {e1.printStackTrace();}  
				      }
				   
				   else
				   {
				      JOptionPane.showMessageDialog(null,"Dear User! Please Enter Email or Password");
				   } 

			}
		});
		btnNewButton.setBounds(434, 455, 117, 29);
		panel.add(btnNewButton);
		
		JRadioButton rdbtnSentTheOrder = new JRadioButton("Sent the order information to my E-mail");
		rdbtnSentTheOrder.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnSentTheOrder.setBounds(26, 456, 284, 23);
		panel.add(rdbtnSentTheOrder);
		
		JList list = new JList();
		list.setBounds(343, 202, 1, 1);
		panel.add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(50, 76, 452, 349);
		panel.add(list_1);
		
		
	}


}
