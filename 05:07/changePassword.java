package HotelBooking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class changePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changePassword frame = new changePassword();
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
	public changePassword() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 36, 184, 26);
		panel_1.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(158, 93, 184, 26);
		panel_1.add(passwordField_1);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(299, 143, 117, 29);
		panel_1.add(btnConfirm);
	}
}
