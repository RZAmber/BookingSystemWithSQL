package HotelMS;

public class User {
    
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private int phone;
	private String country;
	private String address;
	private String address2;
	private String city;
	private String state;
	private String zip;
	

	public User(String email,String password,String firstname,String lastname, int phone, 
			String country, String address, String address2,String city, String state, String zip){
		super();
		this.email=email;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.phone=phone;
		this.country = country;
		this.state=state;
		this.address=address;
		this.address2=address2;
		this.city=city;
		this.zip=zip;
		
	}
	public User(String email){
		super();
		this.email=email;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		this.phone = phone;
	}

	public String getCountry(){
		return country;
	}
	public void setCountry(String country){
		this.country = country;
	}
	public String getAddress(){
		return address;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress2(){
		return address2;
	}
	public void setAddress2(String address2){
		this.address2 = address2;
	}
	public String getCity(){
		return city;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getState(){
		return state;
	}
	public void setState(String state){
		this.state= state;
	}
	public String getZip(){
		return zip;
	}
	public void setZip(String zip){
		this.zip = zip;
	}
	
	public String toString() {
		return String
				.format("User [email=%s, password = %s,firstname=%s, lastname=%s, phone=%s,country=%s,state=%s,address=%s,city=%s,zip=%s]",
						email,password,firstname,lastname,phone,country,state,address,city,zip);
	}
}
