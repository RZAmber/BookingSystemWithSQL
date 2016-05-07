package HotelBooking;

/**aim:
**create userDAO
*/
import java.util.*;

import HotelBooking.Order;

import java.io.*;
import java.sql.*;

public class OrderDAO {

	private Connection myConn;
	
	public OrderDAO() throws Exception {
		
		Properties props = new Properties();
		props.load(new FileInputStream("sql/hotel.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		myConn = DriverManager.getConnection(dburl, user, password);
		
	}
	

	
//	 add orders
	public void addOrder(Order theOrder) throws Exception{
		PreparedStatement myStmt = null;
		try{
			myStmt = myConn.prepareStatement("insert into order_info" 
			+ "(orderID,email,firstname,lastname,roomtype,amount,checkin,checkout,total,comment)"
					+ "values(?,?,?,?,?,?,?,?,?,?)");
			//get parameters
			//setString the first number means the parameters instead of which ?
			myStmt.setInt(1, theOrder.getOrderID());
			myStmt.setString(2, theOrder.getEmail());
			myStmt.setString(3, theOrder.getFirstname());
			myStmt.setString(4, theOrder.getLastname());
			myStmt.setString(5, theOrder.getRoomtype());
			myStmt.setInt(6, theOrder.getAmount());
			myStmt.setString(7, theOrder.getCheckin());
			myStmt.setString(8, theOrder.getCheckout());
			myStmt.setFloat(9, theOrder.getTotal());
			myStmt.setString(10, theOrder.getComment());
			//execute SQL
			myStmt.executeUpdate();
		}
		finally{
			close(myStmt);
		}
	}

//	get all order
	public List<Order> getAllOrders() throws Exception {
		List<Order> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//submit sql query
			myStmt = myConn.createStatement();
			//process result set
			myRs = myStmt.executeQuery("select * from order_info");
			
			while (myRs.next()) {
				Order tempOrder = convertRowToOrder(myRs);
				list.add(tempOrder);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	//search user with email
	public List<Order> searchOrderEmail(String email) throws Exception{
		List<Order> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		try{
			email += "%";
			myStmt = myConn.prepareStatement("select * from order_info where email like ?");
			((PreparedStatement) myStmt).setString(1,email);
			myRs =((PreparedStatement) myStmt).executeQuery();
			
			while(myRs.next()){
				Order tempOrder = convertRowToOrder(myRs);
				list.add(tempOrder);
			}

			return list;
		}
		finally{
			close(myStmt,myRs);
		}
	} 
	//search user with orderID
		public List<Order> searchOrderID(int orderID) throws Exception{
			List<Order> list = new ArrayList<>();
			
			Statement myStmt = null;
			ResultSet myRs = null;
			try{
				myStmt = myConn.prepareStatement("select * from order_info where orderID like ?");
				((PreparedStatement) myStmt).setInt(1,orderID);
				myRs =((PreparedStatement) myStmt).executeQuery();
				
				while(myRs.next()){
					Order tempOrder = convertRowToOrder(myRs);
					list.add(tempOrder);
				}

				return list;
			}
			finally{
				close(myStmt,myRs);
			}
		} 
	// delete order
	public void deleteOrder(Order theOrder) throws SQLException{
//		List<Order> list = new ArrayList<>();
		PreparedStatement myStmt = null;
		try{
			myStmt = myConn.prepareStatement("delete from order_info where orderID=?");
			myStmt.setInt(1, theOrder.getOrderID());
			myStmt.executeUpdate();

		}
		finally{
			close(myStmt);
		}
	}
	
//	update order info
	public void updateOrder(Order theOrder) throws SQLException{
		PreparedStatement myStmt = null;
		try{
			myStmt = myConn.prepareStatement("update order_info" +" set email=?, first_name=?,last_name=?,roomtype=?,amount=?,roomnumber=?,checkin=?,checkout=?,total=?,comment=?"
		            +"where orderID =?");
			myStmt.setString(1, theOrder.getEmail());
			myStmt.setString(2, theOrder.getFirstname());
			myStmt.setString(3, theOrder.getLastname());
			myStmt.setString(4, theOrder.getRoomtype());
			myStmt.setInt(5, theOrder.getAmount());
			myStmt.setString(6, theOrder.getRoomnumber());
			myStmt.setString(7, theOrder.getCheckin());
			myStmt.setString(8, theOrder.getCheckout());
			myStmt.setFloat(9, theOrder.getTotal());
			myStmt.setString(10, theOrder.getComment());
			myStmt.setInt(11, theOrder.getOrderID());
			myStmt.executeUpdate();
		}
		finally{
			close(myStmt);
		}
	}
	
	
//	修改 password
	private Order convertRowToOrder(ResultSet myRs) throws SQLException {

		int orderID=myRs.getInt("orderID");
		String email = myRs.getString("email");
		String lastname = myRs.getString("last_name");
		String firstname = myRs.getString("first_name");
		String roomtype = myRs.getString("room_type");
		int amount =myRs.getInt("amount");
		String roomnumber = myRs.getString("room_number");
		String checkin = myRs.getString("check-in");
		String checkout = myRs.getString("check-out");
		float total =myRs.getFloat("total");
		String comment = myRs.getString("comment");
		
		Order tempOrder = new Order(orderID,email,firstname,lastname,roomtype,amount,roomnumber,checkin,checkout,total,comment);

		return tempOrder;
	}
	
	

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}
		if (myStmt != null) {
			
		}
		if (myConn != null) {
			myConn.close();
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}
	
	public static void main(String[] args) throws Exception {
		
		OrderDAO dao = new OrderDAO();

	}

}