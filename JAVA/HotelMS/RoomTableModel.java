package HotelBooking;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import HotelBooking.Room;

public class RoomTableModel extends AbstractTableModel {
	public static final int OBJECT_COL=-1;
	private static final int ROOMNUMBER_COL=0;
	private static final int ROOMTYPE_COL=1;
	private static final int FEE_COL =2;
	private static final int CHECKIN_COL =3;
	private static final int CHECKOUT_COL=4;
	private static final int AVAILABLE_COL = 5;

	
	private String[] columnNames = { "Room Number","Room Type","Fee","Check-in","Check-out","Available"};
	
	private List<Room> rooms;

	public RoomTableModel(List<Room> theRooms) {
		rooms = theRooms;
	}
	
	@Override 
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rooms.size();
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
		Room tempRoom = rooms.get(row);
		
		switch(col){
		    case ROOMNUMBER_COL:
		    	return tempRoom.getRoomNumber();
			case ROOMTYPE_COL:
				return tempRoom.getRoomType();
			case FEE_COL:
				return tempRoom.getFee();
			case CHECKIN_COL:
				return tempRoom.getCheckin();
			case CHECKOUT_COL:
				return tempRoom.getCheckout();
			case AVAILABLE_COL:
				return tempRoom.getAvailable();
			//add this case for update user info
			case OBJECT_COL:
				return tempRoom;
			default:
				return tempRoom.getRoomNumber();
		}
	}
	
//	public Class getColumnClass(int c){
//		return getValueAt(0,c).getClass();
//	}

}
