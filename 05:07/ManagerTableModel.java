package HotelBooking;

import java.util.List;
import javax.swing.table.AbstractTableModel;

import HotelBooking.Manager;

public class ManagerTableModel extends AbstractTableModel {
	public static final int OBJECT_COL=-1;
	private static final int ID_COL=0;

	private static final int FIRST_NAME_COL =1;
	private static final int LAST_NAME_COL =2;
	private static final int EMAIL_COL=3;
	private static final int PHONE_COL=4;
	private static final int ISADMIN_COL = 5;

	
	private String[] columnNames = { "ID","First Name","Last Name","Email", "Phone","Admin"};
	
	private List<Manager> managers;

	public ManagerTableModel(List<Manager> theManagers) {
		managers = theManagers;
	}
	
	@Override 
	public int getRowCount() {
		// TODO Auto-generated method stub
		return managers.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length-1;
	}

	public String getColumnName(int col){
		return columnNames[col];
	}
	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		Manager tempManager = managers.get(row);
		
		switch(col){
		    case ID_COL:
		    	return tempManager.getID();
			case EMAIL_COL:
				return tempManager.getEmail();
			case FIRST_NAME_COL:
				return tempManager.getFirstname();
			case LAST_NAME_COL:
				return tempManager.getLastname();
			case PHONE_COL:
				return tempManager.getPhone();
			case ISADMIN_COL:
				return tempManager.getIsadmin();

			//add this case for update user info
			case OBJECT_COL:
				return tempManager;
			default:
				return tempManager.getFirstname();
		}
	}
	
//	public Class getColumnClass(int c){
//		return getValueAt(0,c).getClass();
//	}

}
