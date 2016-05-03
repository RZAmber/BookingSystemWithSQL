package HotelMS;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import HotelMS.Order;

public class OrderTableModel extends AbstractTableModel {
	public static final int OBJECT_COL=-1;
	private static final int ORDERID_COL=0;
	private static final int EMAIL_COL=1;
	private static final int FIRST_NAME_COL =2;
	private static final int LAST_NAME_COL =3;
	private static final int ROOMTYPE_COL=4;
	private static final int AMOUNT_COL = 5;
	private static final int ROOMNUMBER_COL=6;
	private static final int CHECKIN_COL=7;
	private static final int CHECKOUT_COL=8;
	private static final int TOTAL_COL=9;
	private static final int COMMENT_COL=10;

	
	private String[] columnNames = { "OrderID","Email", "First Name","Last Name",
			"RoomType","Amount","Room Number","Check-in","Check-out","Total","Comment"};
	
	private List<Order> orders;

	public OrderTableModel(List<Order> theOrders) {
		orders = theOrders;
	}
	
	@Override 
	public int getRowCount() {
		// TODO Auto-generated method stub
		return orders.size();
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
		Order tempOrder = orders.get(row);
		
		switch(col){
		    case ORDERID_COL:
		    	return tempOrder.getOrderID();
			case EMAIL_COL:
				return tempOrder.getEmail();
			case FIRST_NAME_COL:
				return tempOrder.getFirstname();
			case LAST_NAME_COL:
				return tempOrder.getLastname();
			case ROOMTYPE_COL:
				return tempOrder.getRoomtype();
			case AMOUNT_COL:
				return tempOrder.getAmount();
			case ROOMNUMBER_COL:
				return tempOrder.getRoomnumber();
			case CHECKIN_COL:
				return tempOrder.getCheckin();
			case CHECKOUT_COL:
				return tempOrder.getCheckout();
			case TOTAL_COL:
				return tempOrder.getTotal();
			case COMMENT_COL:
				return tempOrder.getComment();

			//add this case for update user info
			case OBJECT_COL:
				return tempOrder;
			default:
				return tempOrder.getFirstname();
		}
	}
	
//	public Class getColumnClass(int c){
//		return getValueAt(0,c).getClass();
//	}

}
