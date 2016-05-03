package HotelMS;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import HotelMS.User;
import HotelMS.UserDAO;
public class LoginUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField EmailtextField;
	private JPasswordField PasswordField;
	private firstpage firstpage;

	public static void main(String[] args) {
		try {
			LoginUser dialog = new LoginUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginUser() {
		setTitle("Log in");
		setBounds(100, 100, 300, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblNewLabel = new JLabel("Email");
			contentPanel.add(lblNewLabel, "4, 4, right, default");
		}
		{
			EmailtextField = new JTextField();
			contentPanel.add(EmailtextField, "6, 4, fill, default");
			EmailtextField.setColumns(10);
		}
		{
			JLabel PasswordlblNewLabel = new JLabel("Password");
			contentPanel.add(PasswordlblNewLabel, "4, 8, right, default");
		}
		{
			PasswordField = new JPasswordField();
			contentPanel.add(PasswordField, "6, 8, fill, default");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton SigninButton = new JButton("Sign in");
				SigninButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							CheckPasswordU();
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
				SigninButton.setActionCommand("Signin");
				buttonPane.add(SigninButton);
				getRootPane().setDefaultButton(SigninButton);
			}
			
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
		
	
	
	protected void CheckPasswordU() throws Exception{
		//get the user info from GUI
		String email = EmailtextField.getText();
		String password = new String(PasswordField.getPassword());
		UserDAO userDAO = new UserDAO();
		
		//check the password
		try{
			if("".equals(email)){
				JOptionPane.showMessageDialog(firstpage, "Please input email.");  // if email or password is null, send message.
			}
			else if("".equals(password)){
				JOptionPane.showMessageDialog(firstpage, "Please input password.");
			}
			else if(password.equals(userDAO.getPassword(email))){
				setVisible(false);
				dispose();
 			    UserHome userhome = new UserHome(email); //put this email address to UserHome page and aim to use it to get the material of this user from mysql
 			    userhome.setVisible(true); 
				}else{
			//close dialog

					JOptionPane.showMessageDialog(firstpage,
							"Wrong Password or Email.",
							"Employee Added",
							JOptionPane.INFORMATION_MESSAGE);
					}
			}catch(Exception exc){ }
			
		}
		
//	protected String getEmailInput(){
//		email = EmailtextField.getText();
//		return email;
//	}
	   /*
		try{
			//check the email exists or not. if not, save to the user database
			boolean f = userDAO.exists(email);
			if(f == false){
				JOptionPane.showMessageDialog(firstpage,
						"This email doesn't exsit.",
						"Employee Added",
						JOptionPane.INFORMATION_MESSAGE);
			}else {
				if(password.equals(userDAO.getPassword(email))){
					JOptionPane.showMessageDialog(firstpage,
							"Log in sucessfully.",
							"Employee Added",
							JOptionPane.INFORMATION_MESSAGE);
				//close dialog
					setVisible(false);
					dispose();
					}else{
				//close dialog

						JOptionPane.showMessageDialog(firstpage,
								"Wrong Password!",
								"Employee Added",
								JOptionPane.INFORMATION_MESSAGE);
						}
		}}catch(Exception exc){ }
	
		*/
}
