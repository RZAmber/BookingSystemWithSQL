package HotelBooking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import HotelBooking.ManagerDAO;
import HotelBooking.ManagerHome;

public class AddManager extends JFrame {

	private JPanel contentPane;
	private JTextField IDTextField;
	private JTextField PasswordTextField;
	private JTextField FirstnameTextField;
	private JTextField LastnameTextField;
	private JTextField EmailTextField;
	private JTextField PhoneTextField;
	private ManagerDAO managerDAO;
	private ManagerHome managerhome;
	int isadmin = 0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddManager frame = new AddManager();
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
	public AddManager() {
		super("Add manager");
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		//get checkbox info
		final JCheckBox IsadChckbxIsAdminister = new JCheckBox("is administer");
		IsadChckbxIsAdminister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(IsadChckbxIsAdminister.isSelected())
					isadmin =1;
			}
		});
		IsadChckbxIsAdminister.setBounds(29, 302, 128, 23);
		panel_1.add(IsadChckbxIsAdminister);

		IDTextField = new JTextField();
		IDTextField.setBounds(159, 23, 217, 26);
		panel_1.add(IDTextField);
		IDTextField.setColumns(10);
		
		PasswordTextField = new JTextField();
		PasswordTextField.setBounds(159, 68, 217, 26);
		panel_1.add(PasswordTextField);
		PasswordTextField.setColumns(10);
		
		FirstnameTextField = new JTextField();
		FirstnameTextField.setColumns(10);
		FirstnameTextField.setBounds(159, 111, 217, 26);
		panel_1.add(FirstnameTextField);
		
		LastnameTextField = new JTextField();
		LastnameTextField.setColumns(10);
		LastnameTextField.setBounds(159, 158, 217, 26);
		panel_1.add(LastnameTextField);
		
		EmailTextField = new JTextField();
		EmailTextField.setColumns(10);
		EmailTextField.setBounds(159, 203, 217, 26);
		panel_1.add(EmailTextField);
		
		PhoneTextField = new JTextField();
		PhoneTextField.setColumns(10);
		PhoneTextField.setBounds(159, 248, 217, 26);
		panel_1.add(PhoneTextField);
		
		JButton btnConfrim = new JButton("Confirm");
		btnConfrim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addManager();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


		});
		btnConfrim.setBounds(321, 301, 117, 29);
		panel_1.add(btnConfrim);
	}
	private void addManager() throws Exception {
		// TODO Auto-generated method stub
		//get infomation
		int ID = Integer.parseInt(IDTextField.getText());
		String firstname = FirstnameTextField.getText();
		String lastname = LastnameTextField.getText();
		String password = PasswordTextField.getText();
		String email = EmailTextField.getText();
		int phone =Integer.parseInt(PhoneTextField.getText());

		Manager tempManager = new Manager(ID, password,firstname,lastname, email,phone, isadmin);
		managerDAO = new ManagerDAO();
		managerDAO.addManger(tempManager);
		JOptionPane.showMessageDialog(managerhome,
				"Manager added succesfully.",
				"Manager Added",
				JOptionPane.INFORMATION_MESSAGE);
		setVisible(false);


//	    boolean isdamin = IsadChckbxIsAdminister;
	}
}
