package HotelMS;

/**aim:
**create userDAO
*/
import java.util.*;
import java.io.*;
import java.sql.*;

import HotelMS.User;

public class UserDAO {

	private Connection myConn;
	
	public UserDAO() throws Exception {
		
		// get db properties
		Properties props = new Properties();
		props.load(new FileInputStream("sql/hotel.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		
		// connect to database
		myConn = DriverManager.getConnection(dburl, user, password);
		
		System.out.println("DB connection successful to: " + dburl);
	}
//	add users
	public void addUser(User theUser) throws Exception{
		PreparedStatement myStmt = null;
		try{
			//prepared statement(precompile)
			myStmt = myConn.prepareStatement("insert into user" 
			+ "(email,password, first_name, last_name, phone, country,address,address2,city, state, zip)"
					+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			//get parameters
			//setString the first number means the parameters instead of which ?
			myStmt.setString(1, theUser.getEmail());
			myStmt.setString(2, theUser.getPassword());
			myStmt.setString(3, theUser.getFirstname());
			myStmt.setString(4, theUser.getLastname());
			myStmt.setInt(5, theUser.getPhone());
			myStmt.setString(6, theUser.getCountry());
			myStmt.setString(7, theUser.getAddress());
			myStmt.setString(8, theUser.getAddress2());
			myStmt.setString(9, theUser.getCity());
			myStmt.setString(10, theUser.getState());
			myStmt.setString(11, theUser.getZip());
			//execute SQL
			myStmt.executeUpdate();
		}
		finally{
			close(myStmt);
		}
	}

//	get all users() 
//	修改 不能显示密码
	public List<User> getAllUsers() throws Exception {
		List<User> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			//submit sql query
			myStmt = myConn.createStatement();
			//process result set
			myRs = myStmt.executeQuery("select * from user");
			
			while (myRs.next()) {
				User tempUser = convertRowToUser(myRs);
				list.add(tempUser);
			}

			return list;		
		}
		finally {
			close(myStmt, myRs);
		}
	}
//	修改 查询出来不能显示用户的密码
	public List<User> searchUser(String firstname) throws Exception{
		List<User> list = new ArrayList<>();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		try{
			firstname += "%";
			myStmt = myConn.prepareStatement("select * from user where first_name like ?");
			
			((PreparedStatement) myStmt).setString(1,firstname);
			myRs =((PreparedStatement) myStmt).executeQuery();
			
			while(myRs.next()){
				User tempUser = convertRowToUser(myRs);
				list.add(tempUser);
			}
			return list;
		}
		finally{
			close(myStmt,myRs);
		}
	}
//	 search the user exsits or not. FOR SignupUser page
	public boolean exists(String email) throws SQLException{
		 ArrayList<Object> list = new ArrayList<>();
		 Statement myStmt =null;
		 ResultSet myRs =null;
		 try{
			 myStmt = myConn.prepareStatement("select email from user where email like ?");
			 ((PreparedStatement) myStmt).setString(1,email);
			 myRs =((PreparedStatement) myStmt).executeQuery();
			 while(myRs.next())
				 list.add(myRs);
			 if(list.size()>0)
				 return true;
			 else
				 return false; 
		 }
		 finally{
			 close(myStmt,myRs);
		 }
			 /*
			if(myRs.getFetchSize()!=0){
				 return true;
			}
			 else {
				 return fa;se;
			 }
		 }
		 finally{
				close(myStmt,myRs);
			}
			*/
	}
//	修改 password
	private User convertRowToUser(ResultSet myRs) throws SQLException {

		int phone=myRs.getInt("phone");
		String password = myRs.getString("password");
		String lastname = myRs.getString("last_name");
		String firstname = myRs.getString("first_name");
		String state = myRs.getString("state");
		String country = myRs.getString("country");
		String email = myRs.getString("email");
		String address = myRs.getString("address");
		String address2 = myRs.getString("address2");
		String city = myRs.getString("city");
		String zip = myRs.getString("zip");
		
		User tempUser = new User(email,password,firstname,lastname,phone,country,address,address2,city,state,zip);
		return tempUser;
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
		
		UserDAO dao = new UserDAO();

//		System.out.println(dao.getAllUsers());
//		System.out.println(dao.searchUser("Rui"));
		System.out.println(dao.exists("liting22@sstevens.edu"));
	}
}