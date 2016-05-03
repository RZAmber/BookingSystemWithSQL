package HotelMS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import HotelMS.User;
import HotelMS.UserDAO;
import javax.swing.JPasswordField;

public class SignupUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField EmailtextField;
	private JTextField LastNametextField;
	private JTextField PhonetextField;
	private JTextField FirstNametextField;
	private JTextField CountrytextField;
	private JTextField AddresstextField;
	private JTextField Address2textField;
	private JTextField CitytextField;
	private JTextField StatetextField;
	private JTextField ZiptextField;

    private UserDAO userDAO;
	private firstpage firstpage;
	private SignupUser signupUser;
	private JPasswordField passwordField;
	
//	reuse to update user info
	private UserHome userHome;
	private User previousUser = null;
	private boolean updateMode = false;
	


	public SignupUser(UserHome theUserHome, UserDAO theUserDAO, User thePreviousUser, boolean theUpdateMode){
        this();
		userDAO=theUserDAO;
		userHome = theUserHome;
		previousUser = thePreviousUser;
		updateMode = theUpdateMode;
		if(updateMode){
			setTitle("Update User Information");
			populateGui(previousUser);
		}
	}
	//add for update user info
	private void populateGui(User theUser){
		EmailtextField.setText(theUser.getEmail());
		FirstNametextField.setText(theUser.getFirstname());
		LastNametextField.setText(theUser.getLastname());
		passwordField.setText(theUser.getPassword());
		PhonetextField.setText(Integer.toString(theUser.getPhone()));
		CountrytextField.setText(theUser.getCountry());
		AddresstextField.setText(theUser.getAddress());
		Address2textField.setText(theUser.getAddress2());
		CitytextField.setText(theUser.getCity());
		StatetextField.setText(theUser.getState());
		ZiptextField.setText(theUser.getZip());
//		System.out.println(theUser.getPassword());

	}
	public SignupUser(UserHome theUserHome, UserDAO theUserDAO){
		this(theUserHome, theUserDAO, null, false);
	}

	public SignupUser() {
		setTitle("Welcome to Hello World Hotel");
		setBounds(100, 100, 450, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
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
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			contentPanel.add(lblNewLabel, "2, 2, right, default");
		}
		{
			EmailtextField = new JTextField();
			contentPanel.add(EmailtextField, "4, 2, fill, default");
			EmailtextField.setColumns(10);
		}
		{
			JLabel lblFirstName = new JLabel("First Name");
			contentPanel.add(lblFirstName, "2, 4, right, default");
		}
		{
			FirstNametextField = new JTextField();
			contentPanel.add(FirstNametextField, "4, 4, fill, default");
			FirstNametextField.setColumns(10);
		}
		{
			JLabel lblLastname = new JLabel("Last Name");
			contentPanel.add(lblLastname, "2, 6, right, default");
		}
		{
			LastNametextField = new JTextField();
			contentPanel.add(LastNametextField, "4, 6, fill, default");
			LastNametextField.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setInheritsPopupMenu(false);
			contentPanel.add(lblPassword, "2, 8, right, default");
		}
		{
			passwordField = new JPasswordField();
			contentPanel.add(passwordField, "4, 8, fill, default");
		}
		{
			JLabel lblPhone = new JLabel("Phone");
			contentPanel.add(lblPhone, "2, 10, right, default");
		}
		{
			PhonetextField = new JTextField();
			contentPanel.add(PhonetextField, "4, 10, fill, default");
			PhonetextField.setColumns(10);
		}
		{
			JLabel lblCountry = new JLabel("Country");
			contentPanel.add(lblCountry, "2, 12, right, default");
		}
		{
			CountrytextField = new JTextField();
			contentPanel.add(CountrytextField, "4, 12, fill, default");
			CountrytextField.setColumns(10);
		}
		{
			JLabel lblAddress = new JLabel("Address");
			contentPanel.add(lblAddress, "2, 14, right, default");
		}
		{
			AddresstextField = new JTextField();
			contentPanel.add(AddresstextField, "4, 14, fill, default");
			AddresstextField.setColumns(10);
		}
		{
			JLabel lblAddress_1 = new JLabel("Address2");
			contentPanel.add(lblAddress_1, "2, 16, right, default");
		}
		{
			Address2textField = new JTextField();
			contentPanel.add(Address2textField, "4, 16, fill, default");
			Address2textField.setColumns(10);
		}
		{
			JLabel lblCity = new JLabel("City");
			contentPanel.add(lblCity, "2, 18, right, default");
		}
		{
			CitytextField = new JTextField();
			contentPanel.add(CitytextField, "4, 18, fill, default");
			CitytextField.setColumns(10);
		}
		{
			JLabel lblState = new JLabel("State");
			contentPanel.add(lblState, "2, 20, right, default");
		}
		{
			StatetextField = new JTextField();
			contentPanel.add(StatetextField, "4, 20, fill, default");
			StatetextField.setColumns(10);
		}
		{
			JLabel lblZip = new JLabel("Zip");
			contentPanel.add(lblZip, "2, 22, right, default");
		}
		{
			ZiptextField = new JTextField();
			contentPanel.add(ZiptextField, "4, 22, fill, default");
			ZiptextField.setColumns(10);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton confirmButton = new JButton("Confirm");
				confirmButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							saveUser();
//							firstpage.setVisible(true);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				confirmButton.setActionCommand("Confirm");
				buttonPane.add(confirmButton);
				getRootPane().setDefaultButton(confirmButton);
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
	
	protected void saveUser() throws Exception{
		//get the user info from GUI
		String email = EmailtextField.getText();
		String firstname = FirstNametextField.getText();
		String lastname = LastNametextField.getText();
		String password = new String(passwordField.getPassword());
		int phone =Integer.parseInt(PhonetextField.getText());
		String country = CountrytextField.getText();
		String address = AddresstextField.getText();
		String address2 = Address2textField.getText();
		String city = CitytextField.getText();
		String state = StatetextField.getText();
		String zip = ZiptextField.getText();
		
		User tempUser = null;
		userDAO= new UserDAO();
		if(updateMode){
			tempUser = previousUser;
			tempUser.setEmail(email);
			tempUser.setFirstname(firstname);
			tempUser.setLastname(lastname);
			tempUser.setPassword(password);;
			tempUser.setPhone(phone);
			tempUser.setCountry(country);
			tempUser.setAddress(address);
			tempUser.setAddress2(address2);
			tempUser.setCity(city);
			tempUser.setState(state);
			tempUser.setZip(zip);
		}else{
			tempUser = new User(email,password,firstname,lastname,phone,country,address,address2,city,state,zip);	
		}
		//save to database
		try{
			if(updateMode){
				userDAO.updateUser(tempUser);
				setVisible(false);
				dispose();
//				userHome.refreshUserView();
				JOptionPane.showMessageDialog(firstpage,
						"Information changed succesfully.",
						"Employee Added",
						JOptionPane.INFORMATION_MESSAGE);
			}else{
				//check the email exists or not. if not, save to the user database
//				UserDAO userDAO = new UserDAO();
				boolean f = userDAO.exists(email);
				System.out.println(f);
				if(f == true){
					JOptionPane.showMessageDialog(firstpage,
							"This email alreadly exists.",
							"Employee Added",
							JOptionPane.INFORMATION_MESSAGE);
				}else{
					userDAO.addUser(tempUser);
					//close dialog
					setVisible(false);
					dispose();
			
					//show confirm mseeage
					JOptionPane.showMessageDialog(firstpage,
							"User added succesfully.",
							"Employee Added",
							JOptionPane.INFORMATION_MESSAGE);
			}
			}
		}catch(Exception exc){
			JOptionPane.showMessageDialog(signupUser, "Error saving user.",
					"Error",
			JOptionPane.ERROR_MESSAGE);
		}
		
}
/*
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupUser frame = new SignupUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
}