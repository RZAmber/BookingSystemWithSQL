package reserve;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class selectpage extends JFrame {

	private JPanel contentPane;
	ImageIcon room1=new ImageIcon("R1.jpg");
	ImageIcon room2=new ImageIcon("R2.jpg");
	ImageIcon room3=new ImageIcon("R3.jpg");
	ImageIcon room4=new ImageIcon("R4.jpg");
	ImageIcon zoom=new ImageIcon("zoom.jpg");
	ImageIcon bg =new ImageIcon("spbackground.jpg");
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	room1 s1=new room1();
	room2 s2=new room2();
	room3 s3=new room3();
	room4 s4=new room4();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectpage frame = new selectpage();
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
	public selectpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		bg.setImage(bg.getImage().getScaledInstance(1000,650,Image.SCALE_DEFAULT));
		JLabel l=new JLabel(bg);
		l.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		getLayeredPane().add(l,new Integer(Integer.MIN_VALUE));
		contentPane.setOpaque(false);
		setResizable(false);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblPleaseSelectThe = new JLabel("Please select the room type");
		lblPleaseSelectThe.setFont(new Font("Yuanti SC", Font.BOLD, 20));
		lblPleaseSelectThe.setBounds(6, 6, 257, 33);
		panel.add(lblPleaseSelectThe);
		
		JLabel lblRoom = new JLabel("Standard Room");
		lblRoom.setFont(new Font("Arial Hebrew Scholar", Font.BOLD, 16));
		lblRoom.setBounds(17, 63, 130, 16);
		panel.add(lblRoom);
		
		JLabel lblSingleRoom = new JLabel("single room");
		lblSingleRoom.setFont(new Font("Arial Hebrew Scholar", Font.BOLD, 16));
		lblSingleRoom.setBounds(31, 188, 130, 16);
		panel.add(lblSingleRoom);
		
		JLabel lblDeluxeSingleRoom = new JLabel("deluxe single room");
		lblDeluxeSingleRoom.setFont(new Font("Arial Hebrew Scholar", Font.BOLD, 16));
		lblDeluxeSingleRoom.setBounds(6, 294, 155, 33);
		panel.add(lblDeluxeSingleRoom);
		
		JLabel lblSuitRoom = new JLabel("suite");
		lblSuitRoom.setFont(new Font("Arial Hebrew Scholar", Font.BOLD, 16));
		lblSuitRoom.setBounds(54, 435, 61, 16);
		panel.add(lblSuitRoom);
		
		textField = new JTextField();
		textField.setText("1");
		textField.setBounds(496, 52, 41, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("+");
		button.setBounds(466, 58, 24, 24);
		panel.add(button);
		
		JButton button_1 = new JButton("-");
		button_1.setBounds(543, 58, 24, 24);
		panel.add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setText("1");
		textField_1.setColumns(10);
		textField_1.setBounds(496, 188, 41, 34);
		panel.add(textField_1);
		
		JButton button_2 = new JButton("+");
		button_2.setBounds(466, 194, 24, 24);
		panel.add(button_2);
		
		JButton button_3 = new JButton("-");
		button_3.setBounds(543, 194, 24, 24);
		panel.add(button_3);
		
		textField_2 = new JTextField();
		textField_2.setText("1");
		textField_2.setColumns(10);
		textField_2.setBounds(496, 315, 41, 34);
		panel.add(textField_2);
		
		JButton button_4 = new JButton("+");
		button_4.setBounds(466, 321, 24, 24);
		panel.add(button_4);
		
		JButton button_5 = new JButton("-");
		button_5.setBounds(543, 321, 24, 24);
		panel.add(button_5);
		
		textField_3 = new JTextField();
		textField_3.setText("1");
		textField_3.setColumns(10);
		textField_3.setBounds(496, 448, 41, 34);
		panel.add(textField_3);
		
		JButton button_6 = new JButton("+");
		button_6.setBounds(466, 454, 24, 24);
		panel.add(button_6);
		
		JButton button_7 = new JButton("-");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_7.setBounds(543, 454, 24, 24);
		panel.add(button_7);
		
		JTextArea txtrJieshao = new JTextArea();
		txtrJieshao.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrJieshao.setText("Standard Room\n2 Double Beds\n(Extra beds available: Crib)\nRoom sleeps 4 guests\n(up to 2 childern)");
		txtrJieshao.setOpaque(false);
		txtrJieshao.setEditable(false);
		txtrJieshao.setBounds(198, 61, 238, 105);
		panel.add(txtrJieshao);
		
		JTextArea txtrRoomInfo = new JTextArea();
		txtrRoomInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrRoomInfo.setText("Standard Room\n1 Queen Bed\n(Extra beds available: Crib)\nRoom sleeps 2 guests\n(up to 1 child)");
		txtrRoomInfo.setOpaque(false);
		txtrRoomInfo.setEditable(false);
		txtrRoomInfo.setBounds(198, 177, 238, 105);
		panel.add(txtrRoomInfo);
		
		JTextArea txtrRoomInfo_1 = new JTextArea();
		txtrRoomInfo_1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrRoomInfo_1.setText("Deluxe Room\n1 king bed\n(Extra beds available: Crib)\nRoom sleeps 2 guests\n(up to 1 child)");
		txtrRoomInfo_1.setOpaque(false);
		txtrRoomInfo_1.setEditable(false);
		txtrRoomInfo_1.setBounds(198, 294, 238, 105);
		panel.add(txtrRoomInfo_1);
		
		JTextArea txtrRoomInfo_2 = new JTextArea();
		txtrRoomInfo_2.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtrRoomInfo_2.setText("Superior Room\n1 King Bed\n(Extra beds available: Crib)\nRoom sleeps 2 guests\n(up to 1 child)");
		txtrRoomInfo_2.setOpaque(false);
		txtrRoomInfo_2.setEditable(false);
		txtrRoomInfo_2.setBounds(198, 431, 238, 105);
		panel.add(txtrRoomInfo_2);
		
		JButton btnConfirm = new JButton("confirm");
		btnConfirm.setBounds(435, 591, 117, 29);
		panel.add(btnConfirm);
		
		JButton btnCanel = new JButton("canel");
		btnCanel.setBounds(306, 591, 117, 29);
		panel.add(btnCanel);
		
		JLabel lblPic = new JLabel("pic1");
		lblPic.setBounds(606, 16, 200, 160);
		panel.add(lblPic);
		
		JLabel lblPic_1 = new JLabel("pic2");
		lblPic_1.setBounds(606, 151, 200, 160);
		panel.add(lblPic_1);
		
		JLabel lblPic_2 = new JLabel("pic3");
		lblPic_2.setBounds(606, 294, 200, 160);
		panel.add(lblPic_2);
		
		JLabel lblPic_3 = new JLabel("pic4");
		lblPic_3.setBounds(606, 431, 200, 160);
		panel.add(lblPic_3);
		
		
		lblPic. setIcon(room1);
		lblPic_1.setIcon(room2);
		lblPic_2.setIcon(room3);
		lblPic_3.setIcon(room4);
		
		JButton btnZoom = new JButton(zoom);
		btnZoom.setBounds(818, 115, 30, 30);
		btnZoom.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				s1.setVisible(true);
			}
		});
		panel.add(btnZoom);
		
		JButton btnZoom_1 = new JButton(zoom);
		btnZoom_1.setBounds(818, 262, 30, 30);
		btnZoom_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				s2.setVisible(true);
			}
		});
		panel.add(btnZoom_1);
		
		JButton btnZoom_2 = new JButton(zoom);
		btnZoom_2.setBounds(818, 410, 30, 30);
		btnZoom_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				s3.setVisible(true);
			}
		});
		panel.add(btnZoom_2);
		
		JButton btnZoom_3 = new JButton(zoom);
		btnZoom_3.setBounds(818, 540, 30, 30);
		btnZoom_3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				s4.setVisible(true);
			}
		});
		panel.add(btnZoom_3);

	}
}
