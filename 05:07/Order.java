package HotelBooking;
public class Order {
    
	private int orderID;
	private String email;
	private String firstname;
	private String lastname;
	private String roomtype;
	private int amount;
	private String roomnumber;
	private String checkin;
	private String checkout;
	private float total;
	private String comment;

	

	public Order(int orderID, String email, String firstname, String lastname, String roomtype, 
			int amount, String roomnumber, String checkin, String checkout, float total, String comment){
		super();
		this.orderID = orderID;
		this.email=email;
		this.firstname=firstname;
		this.lastname=lastname;
		this.roomtype =roomtype;
		this.amount=amount;
		this.roomnumber = roomnumber;
		this.checkin = checkin;
		this.checkout = checkout;
		this.total = total;
		this.comment = comment;
		
	}
	public Order(String email){
		super();
		this.email=email;
	}
	
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getFirstname(){
		return firstname;
	}
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	public String getLastname(){
		return lastname;
	}
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	public String getRoomtype(){
		return roomtype;
	}
	public void setRoomtype(String roomtype){
		this.roomtype = roomtype;
	}
	public int getAmount() {
		return amount;
	}
	public void setRoomnumber(String roomnumber) {
		this.roomnumber=roomnumber;
	}
	public String getRoomnumber() {
		return roomnumber;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
	public float getTotal(){
		return total;
	}
	public void setTotal(float total){
		this.total = total;
	}
	public String getComment(){
		return comment;
	}
	public void setComment(String comment){
		this.comment = comment;
	}
	public String toString() {
		return String
				.format("Order [orderID = %s, email=%s,firstname=%s, lastname=%s, roomtype=%s,amount=%s,roomnumber =%s,checkin=%s,checkout=%s,total=%s,comment=%s]",
						orderID,email,firstname,lastname,roomtype,amount,roomnumber,checkin,checkout,total,comment);
	}
}
