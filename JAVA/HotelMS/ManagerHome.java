package HotelBooking;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import java.util.List;
import java.util.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import HotelBooking.Manager;
import HotelBooking.ManagerDAO;
import HotelBooking.ManagerTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ManagerHome extends JDialog {

	private Manager manager;
	private ManagerDAO managerDAO;
	private JPanel contentPanel;
	private JTabbedPane tabbedPane;
	private JPanel userPanel;
	private JTable UserTable;
	private JPanel UButton;
	
	private JPanel orderPanel;
	
	private JPanel managerPanel;
	private JPanel panel_1;
	private JPanel MButton;
	
	
	private JPanel roomPanel;
	
	private JPanel topPanel;
	private JLabel lblLoggedIn ;
	private JLabel loggedInUserLabel;
	private JPanel panel_2;
	private JScrollPane scrollPane;
	private JButton btnCheck;

	private static int ID;
	private static boolean isadmin;
	private JTable ManagerTable;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			ManagerHome dialog = new ManagerHome(ID,isadmin);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ManagerHome(int ID, boolean isadmin) {
		setTitle("Manager Home");
		setBounds(100, 100, 600, 500);
		contentPanel = new JPanel();
//		setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		contentPanel.setLayout(new BorderLayout(0,0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		topPanel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) topPanel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel.add(topPanel, BorderLayout.NORTH);
		
		lblLoggedIn = new JLabel("Logged In:");
		topPanel.add(lblLoggedIn);
		
		loggedInUserLabel = new JLabel("New label");
		topPanel.add(loggedInUserLabel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPanel.add(tabbedPane,BorderLayout.CENTER);
		
		// manager page
		managerPanel= new JPanel();
		//new tabbedpane to put manager info
		tabbedPane.addTab("Manager Info", null,managerPanel,null);
		managerPanel.setLayout(new BorderLayout(0,0));	
		panel_1 = new JPanel();
		managerPanel.add(panel_1, BorderLayout.CENTER);
		//no border, so the table is good. or it will too small
		panel_1.setLayout(new BorderLayout(0,0));
		ManagerTable = new JTable();
		panel_1.add(ManagerTable.getTableHeader(), BorderLayout.NORTH);
		panel_1.add(ManagerTable, BorderLayout.CENTER);
		MButton = new JPanel();
		managerPanel.add(MButton, BorderLayout.SOUTH);	
		btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ManagerDAO managerDAO = new ManagerDAO();
					List<Manager> managers =managerDAO.getAllManagers();
					ManagerTableModel model = new ManagerTableModel(managers);
					ManagerTable.setModel(model);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		MButton.add(btnCheck);
		JButton addMangerButton = new JButton("Add Manager");
		MButton.add(addMangerButton);
		JButton updateMangerButton = new JButton("Update Manager");
		MButton.add(updateMangerButton);
		JButton changePMangerButton = new JButton("Change Password");
		changePMangerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePassword();
				}		
		});
		MButton.add(changePMangerButton);
		addMangerButton.setEnabled(isadmin);
		updateMangerButton.setEnabled(isadmin);
		
		
		// order page
		orderPanel = new JPanel();
		tabbedPane.addTab("Order",null,orderPanel,null);
		orderPanel.setLayout(new BorderLayout(0,0));
		
		// user page
		userPanel = new JPanel();
		tabbedPane.addTab("User",null,userPanel,null);
		userPanel.setLayout(new BorderLayout(0,0));
		JPanel searchUserPanel = new JPanel();
		userPanel.add(searchUserPanel,BorderLayout.NORTH);
		searchUserPanel.setBorder(null);
		FlowLayout flowLayout_1=(FlowLayout) searchUserPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		JLabel lblEnterLastName = new JLabel("Enter last name");
		searchUserPanel.add(lblEnterLastName);		
		JTextField lastNameTextField = new JTextField();
		searchUserPanel.add(lastNameTextField);
		lastNameTextField.setColumns(10);
		JButton btnsearchUser = new JButton("Search");
		searchUserPanel.add(btnsearchUser);
		panel_2 = new JPanel();
		userPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0,0));
		UserTable = new JTable();
		panel_2.add(UserTable.getTableHeader(), BorderLayout.NORTH);
		panel_2.add(UserTable, BorderLayout.CENTER);	
		scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.EAST);
		UButton = new JPanel();
		userPanel.add(UButton, BorderLayout.SOUTH);
		JButton btnAddUser = new JButton("Add User");
		UButton.add(btnAddUser);

		// room page
		roomPanel = new JPanel();
		tabbedPane.addTab("Room",null,roomPanel,null);
		roomPanel.setLayout(new BorderLayout(0,0));
	}		
		
	
	public void setLoggedInUserName(int ID) {
		loggedInUserLabel.setText(Integer.toString(ID));
	}
	public void AddManager(){
		
	}
	public void changePassword(){
		int row = ManagerTable.getSelectedRow();

		if (row < 0) {
			JOptionPane.showMessageDialog(ManagerHome.this, "You must select one", "Error",
					JOptionPane.ERROR_MESSAGE);				
			return;
	}
		int f =Integer.parseInt((String) ManagerTable.getValueAt(row,0));
		if (f==ID){
			System.out.println("ok");
		}
			

//		String t = (String) ManagerTable.getValueAt(row,0);
//		return t;

		

	
	}
	
}
