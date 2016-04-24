package HotelMS;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Homepage.HomePage;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class firstpage extends JFrame {

	private JPanel contentPane;
	
	private UserDAO userDAO;
	private JButton btnSignup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstpage frame = new firstpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public firstpage() {
		
 		super("Hello World Hotel"); 
 		setSize(450,300);
        setLocation(200, 50); 
 		String path="building.jpg";
 		ImageIcon bg=new ImageIcon(path); 
 		JLabel label=new JLabel(bg); 
 		label.setBounds(0,0,this.getWidth(),this.getHeight()); 
 		JPanel imagePanel =(JPanel) this.getContentPane();
 		
 		JLabel lblNewLabel = new JLabel("Welcome to Hello World Hotel!");
 		lblNewLabel.setForeground(new Color(255, 255, 255));
 		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
 		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 25));
 		getContentPane().setLayout(null);
 		setSize(10,10);
 		
 		JPanel panel = new JPanel();
 		GroupLayout groupLayout = new GroupLayout(getContentPane());
 		groupLayout.setHorizontalGroup(
 			groupLayout.createParallelGroup(Alignment.LEADING)
 				.addGroup(groupLayout.createSequentialGroup()
 					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
 						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
 						.addGroup(groupLayout.createSequentialGroup()
 							.addGap(83)
 							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)))
 					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
 		);
 		groupLayout.setVerticalGroup(
 			groupLayout.createParallelGroup(Alignment.LEADING)
 				.addGroup(groupLayout.createSequentialGroup()
 					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
 					.addGap(26)
 					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
 					.addContainerGap(40, Short.MAX_VALUE))
 		);
 		
 		//connect to singup page
 		btnSignup = new JButton("Sign up");
 		btnSignup.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 				//let firstpage disappear
 				setVisible(false);
 				//create dialog
 			    SignupUser signup = new SignupUser(userDAO);
 			    //show dialog
 			    signup.setVisible(true); 			}
 		});
 		panel.add(btnSignup);
 		btnSignup.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
 		
 		JButton btnNewButton = new JButton("User Login");
 		panel.add(btnNewButton);
 		btnNewButton.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
 		
 		JButton btnNewButton_2 = new JButton("Manager Login");
 		panel.add(btnNewButton_2);
 		btnNewButton_2.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 20));
 		  
 		panel.setOpaque(false); 
 		
 		getContentPane().setLayout(groupLayout);
 		imagePanel.setOpaque(false);
 		this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE)); 
 		setVisible(true);
 		
        //设置大小  
//        setSize(500, 400);  
        //设置位置  
//        setLocation(200, 50);  
        //背景图片的路径。（相对路径或者绝对路径。本例图片放于"java项目名"的文件下）   
        // 背景图片  
        // 把背景图片显示在一个标签里面   
        // 把标签的大小位置设置为图片刚好填充整个面板   
        // 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
        // 把背景图片添加到分层窗格的最底层作为背景  
        //设置可见  
        //点关闭按钮时退出  

        
        
 		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
	}
}
