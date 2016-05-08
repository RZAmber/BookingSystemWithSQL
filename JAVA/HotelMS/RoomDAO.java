package HotelBooking;

/**aim:
**create userDAO
*/
import java.util.*;

import HotelBooking.Room;

import java.io.*;
import java.sql.*;

public class RoomDAO {

	private Connection myConn;
	private String roomtype;
	private String roomtype1;
	public RoomDAO() throws Exception {
		
		Properties props = new Properties();
		props.load(new FileInputStream("sql/hotel.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		myConn = DriverManager.getConnection(dburl, user, password);
		
	}
	
//	get all order
	public List<Room> getAllRooms() throws Exception {
		List<Room> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery("select * from room");
			
			while (myRs.next()) {
				Room tempRoom = convertRowToRoom(myRs);
				list.add(tempRoom);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
	//search room with roomtype

	public List<Room> searchRoom(String roomType) throws Exception{
		List<Room> list = new ArrayList<>();	
		Statement myStmt = null;
		ResultSet myRs = null;
		if(roomType.equals("Single"))
			roomtype = "Single_Room";
		if(roomType.equals("DSingle"))
			roomtype = "Deluxe_Single_Room";
		if(roomType.equals("Double"))
			roomtype = "Standard_Room";
		if(roomType.equals("Suite"))
			roomtype = "Suite";
		try{
			roomtype +="%";
			myStmt = myConn.prepareStatement("select * from room where room_type like ?");
			((PreparedStatement) myStmt).setString(1,roomtype);
			myRs =((PreparedStatement) myStmt).executeQuery();

			while(myRs.next()){
				Room tempRoom = convertRowToRoom(myRs);
				list.add(tempRoom);
			}

			return list;
		}
		finally{
			close(myStmt,myRs);
		}
	} 
	public int getFreeRoom(String roomType) throws SQLException{
		Statement myStmt = null;
		ResultSet myRs = null;
		String a ="-";
		List<Room> list = new ArrayList<>();
		if(roomType.equals("Single"))
			roomtype1 = "Single_Room";
		if(roomType.equals("DSingle"))
			roomtype1 = "Deluxe_Single_Room";
		if(roomType.equals("Double"))
			roomtype1 = "Standard_Room";
		if(roomType.equals("Suite"))
			roomtype1 = "Suite";
		try{
			roomtype1 +="%";
			myStmt = myConn.prepareStatement("select * from room where room_type like ? and Available =?");
			((PreparedStatement) myStmt).setString(1,roomtype1);
			((PreparedStatement) myStmt).setString(2,a);
			myRs =((PreparedStatement) myStmt).executeQuery();

			while(myRs.next()){
				Room tempRoom = convertRowToRoom(myRs);
				list.add(tempRoom);
			}

			return list.size();
		}
		finally{
			close(myStmt,myRs);
		}
		
	}
	//set room avaible or not
	public void setUnAvailable(int roomNumber) throws SQLException{
		PreparedStatement myStmt = null;
		String a = "No";
		try{
			myStmt = myConn.prepareStatement("update room set Available =? where room_number =?");
			myStmt.setString(1, a);
			myStmt.setInt(2, roomNumber);
			myStmt.executeUpdate();
		}
		finally{
			close(myStmt);
		}
	}
	public void setAvailable(int roomNumber) throws SQLException{
		PreparedStatement myStmt = null;
		String a ="-";
		try{
			myStmt = myConn.prepareStatement("update room set Available =? where room_number =?");
			myStmt.setString(1,a);
			myStmt.setInt(2, roomNumber);
			myStmt.executeUpdate();
		}
		finally{
			close(myStmt);
		}
	}
	/*
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
					Order tempOrder = convertRowToRoom(myRs);
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
	
	
*/
	private Room convertRowToRoom(ResultSet myRs) throws SQLException {
		
		int roomNumber = myRs.getInt("room_number");
		String roomType = myRs.getString("room_type");
		float fee = myRs.getFloat("fee");
		String checkin = myRs.getString("check_in");
		String checkout = myRs.getString("check_out");
		String avaible = myRs.getString("available");

		
		Room tempRoom = new Room(roomNumber,roomType,fee,checkin,checkout,avaible);

		return tempRoom;
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
		
		RoomDAO dao = new RoomDAO();
		System.out.println(dao.getFreeRoom("DSingle"));
		

	}

}