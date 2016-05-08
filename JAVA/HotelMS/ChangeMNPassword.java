package HotelBooking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangeMNPassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField PasswordField;
	private JPasswordField NewPasswordField;

	private static int ID;
	private ChangeMNPassword changeMNpassword;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeMNPassword frame = new ChangeMNPassword(ID);
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
	public ChangeMNPassword(int ID) {
		this.ID=ID;
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 245);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		panel.add(lblChangePassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblOldPassword = new JLabel("Old password:");
		lblOldPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblOldPassword.setBounds(31, 40, 102, 16);
		panel_1.add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New password:");
		lblNewPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewPassword.setBounds(31, 97, 115, 16);
		panel_1.add(lblNewPassword);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(155, 36, 184, 26);
		panel_1.add(PasswordField);
		
		NewPasswordField = new JPasswordField();
		NewPasswordField.setBounds(158, 93, 184, 26);
		panel_1.add(NewPasswordField);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					changePassword();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConfirm.setBounds(299, 143, 117, 29);
		panel_1.add(btnConfirm);
	}
	public void changePassword() throws Exception{
		String oldpassword = new String(PasswordField.getPassword());
		String newpassword = new String(NewPasswordField.getPassword());
//		Manager tempManager = new Manager(ID);
		ManagerDAO managerDAO = new ManagerDAO();

//		System.out.println(managerDAO.getPassword(ID));
		if(oldpassword.equals(managerDAO.getPassword(ID))){
			managerDAO.changePassword(ID,newpassword);
			setVisible(false);
		}else{
			JOptionPane.showMessageDialog(changeMNpassword, "Wrong Password!");
		}

	}
}
