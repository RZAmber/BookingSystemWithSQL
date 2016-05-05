package HotelBooking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addManager extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addManager frame = new addManager();
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
	public addManager() {
		super("add manager");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblAddManager = new JLabel("Add Manager");
		lblAddManager.setFont(new Font("Hiragino Kaku Gothic ProN", Font.PLAIN, 22));
		panel.add(lblAddManager);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setBounds(39, 28, 61, 16);
		panel_1.add(lblId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(29, 73, 85, 16);
		panel_1.add(lblPassword);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(29, 116, 85, 16);
		panel_1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(29, 163, 85, 16);
		panel_1.add(lblLastName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(29, 208, 61, 16);
		panel_1.add(lblEmail);
		
		JLabel lblNewLabel = new JLabel("Phone number:");
		lblNewLabel.setBounds(29, 253, 105, 16);
		panel_1.add(lblNewLabel);
		
		JCheckBox chckbxIsAdminister = new JCheckBox("is administer");
		chckbxIsAdminister.setBounds(29, 302, 128, 23);
		panel_1.add(chckbxIsAdminister);
		
		textField = new JTextField();
		textField.setBounds(159, 23, 217, 26);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 68, 217, 26);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(159, 111, 217, 26);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(159, 158, 217, 26);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(159, 203, 217, 26);
		panel_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(159, 248, 217, 26);
		panel_1.add(textField_5);
		
		JButton btnConfrim = new JButton("Confirm");
		btnConfrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConfrim.setBounds(321, 301, 117, 29);
		panel_1.add(btnConfrim);
	}
}
