package HotelBooking;
public class Manager {
    
	private int ID;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String roomtype;
	private int phone;
	private int isadmin;

	public Manager(int ID, String password, String firstname, String lastname, String email,int phone, int isadmin){
		super();
		this.ID = ID;
		this.password = password;
		this.email=email;
		this.firstname=firstname;
		this.lastname=lastname;
		this.phone = phone;
		this.isadmin=isadmin;
		
	}
	public Manager(int ID){
		super();
		this.ID = ID;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
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
	public int getPhone(){
		return phone;
	}
	public void setPhone(int phone){
		this.phone=phone;
	}
	public int getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}
	public String toString() {
		return String
				.format("Manager [ID = %s, password = %s,firstname=%s, lastname=%s, email=%s, phone=%s,isdamin=%s]",
						ID,password,firstname,lastname,email,phone,isadmin);
	}
	public static void main(String[] args){
		Manager manager1 = new Manager(300710);
//		manager1.getIsadmin()
	}
}
