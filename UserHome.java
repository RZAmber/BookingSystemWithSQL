package HotelBooking;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HotelBooking.LoginUser;
import HotelBooking.Order;
import HotelBooking.OrderDAO;
import HotelBooking.OrderTableModel;
import HotelBooking.SignupUser;
import HotelBooking.User;
import HotelBooking.UserDAO;
import HotelBooking.UserTableModel;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class UserHome extends JDialog {
	private JTable table;
	private LoginUser login;
    private static String email;
    private User previousUser;
    private UserDAO userDAO;
    
    private OrderDAO orderDAO;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UserHome dialog = new UserHome(email);
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
	public UserHome(final String email) {
		setTitle("My Hello World");
		setBounds(100, 100, 800, 300);
		getContentPane().setLayout(new BorderLayout());
		
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
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
				buttonPanel.add(btnUpdateMyInfo);
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
							//to confirm
							int response = JOptionPane.showConfirmDialog(UserHome.this,"Cancle this order?","Confirm",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
							if (response != JOptionPane.YES_OPTION)
								return;
							Order tempOrder = (Order) table.getValueAt(row,OrderTableModel.OBJECT_COL);
							orderDAO = new OrderDAO();
							orderDAO.deleteOrder(tempOrder);
							JOptionPane.showMessageDialog(UserHome.this,
									"Order cancled succesfully.", "Order cancled",
									JOptionPane.INFORMATION_MESSAGE);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				buttonPanel.add(btnCancelOrder);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPanel.add(cancelButton);
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
				btnModifyInfo.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
					HomePage hp = new HomePage();
						
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
