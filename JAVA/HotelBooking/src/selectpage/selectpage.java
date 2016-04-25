package selectpage;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class selectpage extends JFrame {

	private JPanel contentPane;
	ImageIcon room1=new ImageIcon("room1.jpg");
	ImageIcon room2=new ImageIcon("room2.jpg");
	ImageIcon room3=new ImageIcon("room3.jpg");
	ImageIcon room4=new ImageIcon("room4.jpg");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	/*
	room1.setImage(room1.getImage().getScaledInstance(40,20,Image.SCALE_DEFAULT));
	room2.setImage(room2.getImage().getScaledInstance(40,20,Image.SCALE_DEFAULT));
	room3.setImage(room3.getImage().getScaledInstance(40,20,Image.SCALE_DEFAULT));
	room4.setImage(room4.getImage().getScaledInstance(40,20,Image.SCALE_DEFAULT));
*/
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
		setBounds(100, 100, 600, 648);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblPleaseSelectThe = new JLabel("Please select the room type");
		lblPleaseSelectThe.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		lblPleaseSelectThe.setBounds(6, 6, 224, 33);
		panel.add(lblPleaseSelectThe);
		
		JLabel lblRoom = new JLabel("Standard Room");
		lblRoom.setBounds(16, 61, 107, 16);
		panel.add(lblRoom);
		
		JLabel lblSingleRoom = new JLabel("single room");
		lblSingleRoom.setBounds(16, 188, 93, 16);
		panel.add(lblSingleRoom);
		
		JLabel lblDeluxeSingleRoom = new JLabel("deluxe single room");
		lblDeluxeSingleRoom.setBounds(6, 294, 140, 33);
		panel.add(lblDeluxeSingleRoom);
		
		JLabel lblSuitRoom = new JLabel("suite");
		lblSuitRoom.setBounds(16, 422, 61, 16);
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
		textField_3.setBounds(496, 422, 41, 34);
		panel.add(textField_3);
		
		JButton button_6 = new JButton("+");
		button_6.setBounds(466, 428, 24, 24);
		panel.add(button_6);
		
		JButton button_7 = new JButton("-");
		button_7.setBounds(543, 428, 24, 24);
		panel.add(button_7);
		
		JTextArea txtrJieshao = new JTextArea();
		txtrJieshao.setText("room1 info");
		txtrJieshao.setBounds(198, 48, 238, 105);
		panel.add(txtrJieshao);
		
		JTextArea txtrRoomInfo = new JTextArea();
		txtrRoomInfo.setText("room2 info");
		txtrRoomInfo.setBounds(198, 177, 238, 105);
		panel.add(txtrRoomInfo);
		
		JTextArea txtrRoomInfo_1 = new JTextArea();
		txtrRoomInfo_1.setText("room3 info");
		txtrRoomInfo_1.setBounds(198, 294, 238, 105);
		panel.add(txtrRoomInfo_1);
		
		JTextArea txtrRoomInfo_2 = new JTextArea();
		txtrRoomInfo_2.setText("room4 info");
		txtrRoomInfo_2.setBounds(198, 419, 238, 105);
		panel.add(txtrRoomInfo_2);
		
		JButton btnConfirm = new JButton("confirm");
		btnConfirm.setBounds(435, 591, 117, 29);
		panel.add(btnConfirm);
		
		JButton btnCanel = new JButton("canel");
		btnCanel.setBounds(306, 591, 117, 29);
		panel.add(btnCanel);
		
		JButton btnPhoto = new JButton("photo");
		btnPhoto.setBounds(26, 81, 75, 29);
		panel.add(btnPhoto);
		
		JButton btnPhoto_1 = new JButton("photo");
		btnPhoto_1.setBounds(26, 209, 75, 29);
		panel.add(btnPhoto_1);
		
		JButton btnPhoto_2 = new JButton("photo");
		btnPhoto_2.setBounds(26, 319, 75, 29);
		panel.add(btnPhoto_2);
		
		JButton btnPhoto_3 = new JButton("photo");
		btnPhoto_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPhoto_3.setBounds(26, 446, 83, 29);
		panel.add(btnPhoto_3);
	}
}
