package HotelBooking;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import HotelBooking.Manager;
import HotelBooking.ManagerDAO;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class LoginManager extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField IDtextField;
	private JPasswordField PasswordField;
	private firstpage firstpage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginManager dialog = new LoginManager();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginManager() {
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		{
			JLabel lblId = new JLabel("ID");
			contentPanel.add(lblId, "4, 4, right, default");
		}
		{
			IDtextField = new JTextField();
			contentPanel.add(IDtextField, "6, 4, fill, default");
			IDtextField.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			contentPanel.add(lblPassword, "4, 6, right, default");
		}
		{
			PasswordField = new JPasswordField();
			contentPanel.add(PasswordField, "6, 6, fill, default");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Sign in");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							CheckPasswordM();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
	protected void CheckPasswordM() throws Exception{
		//get the user info from GUI
		int ID = Integer.parseInt(IDtextField.getText());
		String password = new String(PasswordField.getPassword());
		ManagerDAO managerDAO = new ManagerDAO();
		boolean isadmin = managerDAO.getIsadim(ID);
		//check the password
		try{
			if("".equals(ID)){
				JOptionPane.showMessageDialog(firstpage, "Please input ID.");  // if email or password is null, send message.
			}
			else if("".equals(password)){
				JOptionPane.showMessageDialog(firstpage, "Please input password.");
			}
			else if(password.equals(managerDAO.getPassword(ID))){
				setVisible(false);
				dispose();
 			    ManagerHome managerhome = new ManagerHome(ID,isadmin); //put this email address to UserHome page and aim to use it to get the material of this user from mysql
 			    managerhome.setLoggedInUserName(ID);
 			    managerhome.setVisible(true); 
				}else{
			//close dialog

					JOptionPane.showMessageDialog(firstpage,
							"Wrong Password or ID.",
							"Employee Added",
							JOptionPane.INFORMATION_MESSAGE);
					}
			}catch(Exception exc){ }
			
		}

}
