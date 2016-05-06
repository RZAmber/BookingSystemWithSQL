package HotelBooking;

import java.util.*;

import HotelBooking.Manager;

import java.io.*;
import java.sql.*;

public class ManagerDAO {

	private Connection myConn;
	
	public ManagerDAO() throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream("sql/hotel.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		myConn = DriverManager.getConnection(dburl,user,password);
	}
//	add users
	public void addManger(Manager theManager) throws Exception{
		PreparedStatement myStmt = null;
		try{

			myStmt = myConn.prepareStatement("insert into manager" 
			+ "(ID,password, first_name, last_name,email, phone,is_admin)"
					+ "values(?,?,?,?,?,?,?)");
			myStmt.setInt(1, theManager.getID());
			myStmt.setString(2, theManager.getPassword());
			myStmt.setString(3, theManager.getFirstname());
			myStmt.setString(4, theManager.getLastname());
			myStmt.setString(5, theManager.getEmail());
			myStmt.setInt(6, theManager.getPhone());
			myStmt.setInt(7, theManager.getIsadmin());
			//execute SQL
			myStmt.executeUpdate();
		}
		finally{
			close(myStmt);
		}
	}
	
//	get all manager
//	修改 不能显示密码
	public List<Manager> getAllManagers() throws Exception {
		List<Manager> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//submit sql query
			myStmt = myConn.createStatement();
			//process result set
			myRs = myStmt.executeQuery("select * from manager");
			
			while (myRs.next()) {
				Manager tempManager = convertRowToManager(myRs);
				list.add(tempManager);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	} 
	
	// delete manager
	public void deleteManger(Manager theManager) throws SQLException{

		PreparedStatement myStmt = null;
		try{
			myStmt = myConn.prepareStatement("delete from manager where orderID like ?");
			myStmt.setInt(1, theManager.getID());
			myStmt.executeUpdate();

		}
		finally{
			close(myStmt);
		}
	}
	
// verify passowrd
	public String getPassword(int ID) throws SQLException{
		Statement myStmt = null;
		ResultSet myRs =null;
		String ps ="";
		try{
			myStmt = myConn.prepareStatement("select password from manager where ID like ?");
			 ((PreparedStatement) myStmt).setInt(1,ID);
			 myRs =((PreparedStatement) myStmt).executeQuery();
			 while(myRs.next())
				 ps=myRs.getString("password"); 
			 return ps;
			 
		 }
		 finally{
			 close(myStmt,myRs);
		 }
	}
	public boolean getIsadim(int ID) throws SQLException{
		Statement myStmt = null;
		ResultSet myRs =null;
		String ps="";
		try{
			myStmt = myConn.prepareStatement("select is_admin from manager where ID like ?");
			 ((PreparedStatement) myStmt).setInt(1,ID);
			 myRs =((PreparedStatement) myStmt).executeQuery();
			 while(myRs.next())
				 ps=myRs.getString("is_admin");
			 int p = Integer.parseInt(ps);
			 boolean f = false;
			 if(p == 1)
				 f= true;
			 return f;
			 
		 }
		 finally{
			 close(myStmt,myRs);
		 }
	}
	
//	修改 password
	private Manager convertRowToManager(ResultSet myRs) throws SQLException {

		int ID = myRs.getInt("ID");
		int phone=myRs.getInt("phone");
		String password = myRs.getString("password");
		String lastname = myRs.getString("last_name");
		String firstname = myRs.getString("first_name");
		String email = myRs.getString("email");
		int isadmin = myRs.getInt("is_admin");
		
		Manager tempManager = new Manager(ID,password,firstname,lastname,email,phone,isadmin);
		return tempManager;
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
		ManagerDAO dao = new ManagerDAO();
		System.out.println(dao.getIsadim(300710));
		

	}
}