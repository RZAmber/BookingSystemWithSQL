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
import HotelBooking.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class ManagerHome extends JDialog {

	private Manager manager;
	private ManagerDAO managerDAO;
	private User user;
	private UserDAO userDAO;
	private OrderDAO orderDAO;
	private JPanel contentPanel;
	private JTabbedPane tabbedPane;
	private JPanel userPanel;
	private JTable UserTable;
	private JPanel UButton;
	private JTextField firstNameTextField;
	private JTextField RoomTypeTextField;
	private JTextField PTextField;
	
	private JPanel orderPanel;
	private JPanel panel_3;
	private JPanel OButton;
	private JTable OrderTable;
	
	private JPanel managerPanel;
	private JPanel panel_1;
	private JPanel MButton;
	
	private JPanel roomPanel;
	private JPanel panel_4;
	private JPanel RButton;
	private JTable RoomTable;
	
	private JPanel topPanel;
	private JLabel lblLoggedIn ;
	private JLabel loggedInUserLabel;
	private JScrollPane scrollPane;
	private JButton btnCheck;

	private static int ID;
	private static boolean isadmin;
	private JTable ManagerTable;
//	private JTable table;
	private JButton btnChooseRoom;
	
	private String aa;
	private int bb;

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
	public ManagerHome(final int ID, boolean isadmin) {
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
		addMangerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddManager AM = new AddManager();
				AM.setVisible(true);
				// add some get information method
//				  AddManager();
			}
		});
		MButton.add(addMangerButton);
		JButton changePMangerButton = new JButton("Change Password");
		changePMangerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = ManagerTable.getSelectedRow();
				if(row<0){
					JOptionPane.showMessageDialog(ManagerHome.this, "You must select a user");
					return;
				}
				int IID = (int) ManagerTable.getValueAt(row, 0);
//				System.out.println(IID);
				if(IID == ID){
					ChangeMNPassword cp = new ChangeMNPassword(ID);
					cp.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(ManagerHome.this, "You cannot change other's password", "Error",
							JOptionPane.ERROR_MESSAGE);			
				}

				}		
		});
		MButton.add(changePMangerButton);
		addMangerButton.setEnabled(isadmin);
		
		
		// order page
		orderPanel = new JPanel();
		tabbedPane.addTab("Order",null,orderPanel,null);
		orderPanel.setLayout(new BorderLayout(0,0));
		JPanel searchOrderPanel = new JPanel();
		orderPanel.add(searchOrderPanel,BorderLayout.NORTH);
		searchOrderPanel.setBorder(null);
		FlowLayout flowLayout_1=(FlowLayout) searchOrderPanel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		JLabel lblEnterFirstName_o = new JLabel("Enter first name");
		searchOrderPanel.add(lblEnterFirstName_o);		
		PTextField = new JTextField();
		searchOrderPanel.add(PTextField);
		PTextField.setColumns(10);
		JButton btnsearchOrder = new JButton("Search");
		btnsearchOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchOrder();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		searchOrderPanel.add(btnsearchOrder);
		panel_3 = new JPanel();
		orderPanel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0,0));
		OrderTable = new JTable();
		panel_3.add(OrderTable.getTableHeader(), BorderLayout.NORTH);
		panel_3.add(OrderTable, BorderLayout.CENTER);	
		scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.EAST);
		OButton = new JPanel();
		orderPanel.add(OButton, BorderLayout.SOUTH);
		JButton btnAddOrder = new JButton("Add Order");
		btnAddOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp = new HomePage(aa,aa,aa,bb,1, 2, 3, 4);
			}
		});
		OButton.add(btnAddOrder);
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				int row = OrderTable.getSelectedRow();
				if(row<0){
					JOptionPane.showMessageDialog(ManagerHome.this, "You must select an order");
					return;
				}
				Order tempOrder = (Order) OrderTable.getValueAt(row,OrderTableModel.OBJECT_COL);
				orderDAO = new OrderDAO();
				double total = orderDAO.getTotal(tempOrder);
//				System.out.println(total);
				int roomNumber = orderDAO.getRoom(tempOrder);
//				System.out.println(roomNumber);
				TotalPrice tp = new TotalPrice(tempOrder,total,roomNumber);
				tp.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		OButton.add(btnCheckOut);
		JButton btnDeleteOrder = new JButton("Delete Order");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = OrderTable.getSelectedRow();
					if(row<0){
						JOptionPane.showMessageDialog(ManagerHome.this, "You must select an order");
						return;
					}
					Order tempOrder = (Order) OrderTable.getValueAt(row,OrderTableModel.OBJECT_COL);
					orderDAO = new OrderDAO();
					orderDAO.deleteOrder(tempOrder);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		OButton.add(btnDeleteOrder);
		
		btnChooseRoom = new JButton("Choose Room");
		btnChooseRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int row = OrderTable.getSelectedRow();
					if(row<0){
						JOptionPane.showMessageDialog(ManagerHome.this, "You must select an order");
						return;
					}
					Order tempOrder = (Order) OrderTable.getValueAt(row,OrderTableModel.OBJECT_COL);
					ChooseRoom cr = new ChooseRoom(tempOrder);
					cr.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		OButton.add(btnChooseRoom);
		
		// user page
		userPanel = new JPanel();
		tabbedPane.addTab("User",null,userPanel,null);
		userPanel.setLayout(new BorderLayout(0,0));
		JPanel searchUserPanel = new JPanel();
		userPanel.add(searchUserPanel,BorderLayout.NORTH);
		searchUserPanel.setBorder(null);
		FlowLayout flowLayout_3=(FlowLayout) searchUserPanel.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		JLabel lblEnterFirstName = new JLabel("Enter first name");
		searchUserPanel.add(lblEnterFirstName);		
		firstNameTextField = new JTextField();
		searchUserPanel.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		JButton btnsearchUser = new JButton("Search");
		btnsearchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchUser();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		searchUserPanel.add(btnsearchUser);
		panel_3 = new JPanel();
		userPanel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0,0));
		UserTable = new JTable();
		panel_3.add(UserTable.getTableHeader(), BorderLayout.NORTH);
		panel_3.add(UserTable, BorderLayout.CENTER);	
		scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.EAST);
		UButton = new JPanel();
		userPanel.add(UButton, BorderLayout.SOUTH);
		JButton btnAddUrder = new JButton("Add User");
		btnAddUrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignupUser signup = new SignupUser();
				signup.setVisible(true);
			}
		});
		UButton.add(btnAddUrder);


		// room page
		roomPanel = new JPanel();
		tabbedPane.addTab("Room",null,roomPanel,null);
		roomPanel.setLayout(new BorderLayout(0,0));
		JPanel searchRoomPanel = new JPanel();
		roomPanel.add(searchRoomPanel,BorderLayout.NORTH);
		searchRoomPanel.setBorder(null);
		FlowLayout flowLayout_r=(FlowLayout) searchRoomPanel.getLayout();
		flowLayout_r.setAlignment(FlowLayout.LEFT);
		JLabel lblEnterRoomType = new JLabel("Enter Room Type");
		searchRoomPanel.add(lblEnterRoomType);		
		RoomTypeTextField = new JTextField();
		searchRoomPanel.add(RoomTypeTextField);
		RoomTypeTextField.setColumns(10);
		JButton btnsearchRoom = new JButton("Search");
		btnsearchRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchRoom();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		searchRoomPanel.add(btnsearchRoom);
		panel_4 = new JPanel();
		roomPanel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0,0));
		RoomTable = new JTable();
		panel_4.add(RoomTable.getTableHeader(), BorderLayout.NORTH);
		panel_4.add(RoomTable, BorderLayout.CENTER);	
		scrollPane = new JScrollPane();
		panel_4.add(scrollPane, BorderLayout.EAST);
		RButton = new JPanel();
		roomPanel.add(RButton, BorderLayout.SOUTH);

	}		
			
	public void setLoggedInUserName(int ID) {
		loggedInUserLabel.setText(Integer.toString(ID));
	}

//		String t = (String) ManagerTable.getValueAt(row,0);
//		return t;

	private void searchOrder() throws Exception {
		// TODO Auto-generated method stub
		String p = PTextField.getText();
		OrderDAO orderDAO = new OrderDAO();
		List<Order> orders =null;
		
		if (p != null && p.trim().length() > 0) {
			orders = orderDAO.searchOrderFN(p);
		} else {
			orders =orderDAO.getAllOrders();
		}
		
		OrderTableModel model3 = new OrderTableModel(orders);
		OrderTable.setModel(model3);
	}
	
	private void searchUser() throws Exception {
		// TODO Auto-generated method stub
		String firstname = firstNameTextField.getText();
		UserDAO userDAO = new UserDAO();
		List<User> users =null;
		if (firstname != null && firstname.trim().length() > 0) {
			users = userDAO.searchUserName(firstname);
		} else {
			users =userDAO.getAllUsers();
		}
		
		// create the model and update the "table"
		UserTableModel model1 = new UserTableModel(users);
		UserTable.setModel(model1);
		
	}
	private void searchRoom() throws Exception {
		String roomtype = RoomTypeTextField.getText();
		RoomDAO roomDAO = new RoomDAO();
		List<Room> rooms =null;
		if (roomtype != null && roomtype.trim().length() > 0) {
			rooms = roomDAO.searchRoom(roomtype);
		} else {
			rooms =roomDAO.getAllRooms();
		}
		// create the model and update the "table"
		RoomTableModel model2 = new RoomTableModel(rooms);
		RoomTable.setModel(model2);
		
	}
}
//