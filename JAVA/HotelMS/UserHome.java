package HotelBooking;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;


import HotelBooking.*;

public class UserHome extends JDialog {
	private JTable table;
	private LoginUser login;
    private static String email;
    private static String firstname;
    private static String lastname;
    private static int phone;
    private User previousUser;
    private UserDAO userDAO;
    private RoomDAO roomDAO;
    private OrderDAO orderDAO;
    private int RA1,RA2,RA3,RA4;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserHome dialog = new UserHome(email,firstname,lastname,phone);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */


	//let parameter is email, then I can use email got from SignupUser dialog
	public UserHome(final String email,final String firstname, final String lastname, final int phone) {
		setTitle("My Hello World");
		setBounds(100, 100, 800, 300);
		getContentPane().setLayout(new BorderLayout());
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUpdateMyInfo = new JButton("Update My Info");
				btnUpdateMyInfo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//get selected row
						int row = table.getSelectedRow();
						//make sure a row is selected
						if(row<0){
							JOptionPane.showMessageDialog(UserHome.this, "You must select a user", email, JOptionPane.ERROR_MESSAGE);
							return;
						}
						//get current user
						User tempUser = (User) table.getValueAt(row,UserTableModel.OBJECT_COL);
//					  	System.out.println(tempUser);
						SignupUser updateuser = new SignupUser(UserHome.this,userDAO, tempUser,true);
						updateuser.setVisible(true);
					}
				});
				buttonPane.add(btnUpdateMyInfo);
			}
			{
				JButton btnCancelOrder = new JButton("Cancel Order");
				btnCancelOrder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							int row = table.getSelectedRow();
							if(row<0){
								JOptionPane.showMessageDialog(UserHome.this, "You must select an order", email, JOptionPane.ERROR_MESSAGE);
								return;
							}
							Order tempOrder = (Order) table.getValueAt(row,OrderTableModel.OBJECT_COL);
							orderDAO = new OrderDAO();
							orderDAO.deleteOrder(tempOrder);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				buttonPane.add(btnCancelOrder);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		{
			JPanel panel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			getContentPane().add(panel, BorderLayout.NORTH);
			{
				JButton btnMyInfo = new JButton("My Info");
				//get this user's info when press this button
				btnMyInfo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							UserDAO userDAO = new UserDAO();
							List<User> users = userDAO.searchUserEmail(email);
							UserTableModel model = new UserTableModel(users);
							table.setModel(model);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				panel.add(btnMyInfo);
			}
			{
				JButton btnModifyInfo = new JButton("Booking");
				btnModifyInfo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							roomDAO = new RoomDAO();
							RA1=roomDAO.getFreeRoom("Single");
							RA2 = roomDAO.getFreeRoom("DSingle");
							RA3 =roomDAO.getFreeRoom("Double");
							RA4 = roomDAO.getFreeRoom("Suite");
//							System.out.println(RA1);
							HomePage hp = new HomePage(email,firstname,lastname,phone, RA1, RA2, RA3, RA4);
							hp.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				panel.add(btnModifyInfo);
			}
			{
				JButton btnMyOrder = new JButton("My Order");
				btnMyOrder.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							OrderDAO orderDAO = new OrderDAO();
							List<Order> orders = orderDAO.searchOrderEmail(email);
							OrderTableModel model = new OrderTableModel(orders);
							table.setModel(model);
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}
				});
				panel.add(btnMyOrder);
			}
		}
		{
			JScrollPane UserscrollPane = new JScrollPane();
			getContentPane().add(UserscrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				UserscrollPane.setViewportView(table);
			}
		}
	}

	/*
	public void refreshUserView() {

		try {
			List<User> users = userDAO.getAllUsers();
           // create the model and update the "table"
			UserTableModel model = new UserTableModel(users);
			Usertable.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	*/

}
