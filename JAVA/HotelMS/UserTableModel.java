package HotelBooking;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import HotelBooking.User;

public class UserTableModel extends AbstractTableModel {
	public static final int OBJECT_COL=-1;
	private static final int EMAIL_COL=0;
	private static final int PASSWORD_COL = 1;
	private static final int FIRST_NAME_COL =2;
	private static final int LAST_NAME_COL =3;
	private static final int PHONE_COL=4;
	private static final int COUNTRY_COL = 5;
	private static final int ADDRESS_COL=6;
	private static final int ADDRESS2_COL=7;
	private static final int CITY_COL=8;
	private static final int STATE_COL=9;
	private static final int ZIP_COL=10;
	
	private String[] columnNames = { "Email", "Password", "First Name","Last Name",
			"Phone","Country","Address","Address2","City","State","Zip" };
	
	private List<User> users;

	public UserTableModel(List<User> theUsers) {
		users = theUsers;
	}
	
	@Override 
	public int getRowCount() {
		// TODO Auto-generated method stub
		return users.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	public String getColumnName(int col){
		return columnNames[col];
	}
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		User tempUser = users.get(row);
		
		switch(col){
			case EMAIL_COL:
				return tempUser.getEmail();
			case PASSWORD_COL:
//				return tempUser.getPassword();
				return "*******";
			case FIRST_NAME_COL:
				return tempUser.getFirstname();
			case LAST_NAME_COL:
				return tempUser.getLastname();
			case PHONE_COL:
				return tempUser.getPhone();
			case COUNTRY_COL:
				return tempUser.getCountry();
			case ADDRESS_COL:
				return tempUser.getAddress();
			case ADDRESS2_COL:
				return tempUser.getAddress2();
			case CITY_COL:
				return tempUser.getCity();
			case STATE_COL:
				return tempUser.getState();
			case ZIP_COL:
				return tempUser.getZip();
			//add this case for update user info
			case OBJECT_COL:
				return tempUser;
			default:
				return tempUser.getFirstname();
		}
	}
	
//	public Class getColumnClass(int c){
//		return getValueAt(0,c).getClass();
//	}

}
//