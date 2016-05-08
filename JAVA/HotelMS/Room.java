package HotelBooking;
public class Room {
    
	private int roomNumber;
	private String roomType;
	private float fee;
	private String checkin;
	private String checkout;
	private String available;


	

	public Room(int roomNumber, String roomType, float fee, String checkin, String checkout, String available){
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.fee = fee;
		this.checkin = checkin;
		this.checkout = checkout;
		this.available = available;

		
	}
	public Room(int roomNumber){
		super();
		this.roomNumber = roomNumber;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public float getFee(){
		return fee;
	}
	public void setFee(float fee){
		this.fee = fee;
	}
	public String getCheckin(){
		return checkin;
	}
	public void setCheckin(String checkin){
		this.checkin = checkin;
	}
	public String getCheckout(){
		return checkout;
	}
	public void setCheckout(String checkout){
		this.checkout = checkout;
	}
	public String getAvailable(){
		return available;
	}
	public void setAvailable(String available){
		this.available = available;
	}
	public String toString() {
		return String
				.format("Room [roomNumber = %s, roomType=%s,fee=%s, checkin=%s, checkout=%s,available=%s]",
						roomNumber,roomType,fee,checkin,checkout,available);
	}
}
