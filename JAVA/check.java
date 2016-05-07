package reserve;

public class check extends resultpage{
	private String Fname;
	private String Lname;
	private String roomType;
	private int amount;
	private String location;
	private String checkIn;
	private String checkOut;
	private String phone;
	private String email;
	private String comments;
	double cashAmount;
	private int days;
	private int year1;
	private int month1;
	private int day1;
	private int year2;
	private int month2;
	private int day2;
	private JulianDate checkIn1;
	private JulianDate checkIn2;
	private int amount1;
	private int amount2;
	private int amount3;
	private int amount4;
	private String roomType1;
	private String roomType2;
	private String roomType3;
	private String roomType4;
	
	public check(String Fname, String Lname, String roomType, int amount, String location, String checkIn,
			String checkOut, String phone, String email, String comments, int days, int amount1, int amount2, int amount3, int amount4, 
			String roomType1, String roomType2, String roomType3, String roomType4) {
		super(Fname, Lname, roomType, amount, location, checkIn, checkOut, phone, email, comments, days, amount1, amount2, amount3, amount4, roomType1, roomType2, roomType3, roomType4);
		this.Fname = Fname;
		this.Lname = Lname;
		this.roomType = roomType;
		this.amount = amount;
		this.location = location;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.phone = phone;
		this.email = email;
		this.comments = comments;
		this.days = days;
		this.amount1 = amount1;
		this.amount2 = amount2;
		this.amount3 = amount3;
		this.amount4 = amount4;
		this.roomType1 = roomType1;
		this.roomType2 = roomType2;
		this.roomType3 = roomType3;
		this.roomType4 = roomType4;
	
		if ("Standard Room   ".equals(roomType)){
			cashAmount = 100 * amount1 * days;
		} else if ("single room   ".equals(roomType)){
			cashAmount = 200 * amount2 * days ;
		} else if ("deluxe single room   ".equals(roomType)){
			cashAmount = 300 * amount3 * days;
		} else if ("suite   ".equals(roomType)){
			cashAmount = 400 * amount4 * days;
		} else if ("Standard Room single room  ".equals(roomType)){
			cashAmount = (100 * amount1 + 200 * amount2) * days;
		} else if ("Standard Room  deluxe single room ".equals(roomType)){
			cashAmount = (100 * amount1 + 300 * amount3) * days;
		} else if ("Standard Room   suite".equals(roomType)){
			cashAmount = (100 * amount1 + 400 * amount4) * days;
		} else if (" single room deluxe single room ".equals(roomType)){
			cashAmount = (200 * amount2 + 300 * amount3) * days;
		} else if (" single room  suite".equals(roomType)){
			cashAmount = (200 * amount2 + 400 * amount4) * days;
		} else if ("  deluxe single room suite".equals(roomType)){
			cashAmount = (300 * amount3 + 400 * amount4) * days;
		} else if ("Standard Room single room deluxe single room ".equals(roomType)){
			cashAmount = (100 * amount1 + 200 * amount2 + 300 * amount3) * days;
		} else if ("Standard Room single room  suite".equals(roomType)){
			cashAmount = (100 * amount1 + 200 * amount2 + 400 * amount4) * days;
		} else if ("Standard Room  deluxe single room suite".equals(roomType)){
			cashAmount = (100 * amount1 + 300 * amount3 + 400 * amount4) * days;
		} else if (" single room deluxe single room suite".equals(roomType)){
			cashAmount = (200 * amount2 + 300 * amount3 + 400 * amount4) * days;
		} else if ("Standard Room single room deluxe single room suite".equals(roomType)){
			cashAmount = (100 * amount1 + 200 * amount2 + 300 * amount3 + 400 * amount4) * days;
		}
		
	
	}
	/*
	public int getDays(){
		year1 = Integer.parseInt(checkIn.substring(0,4));
		year2 = Integer.parseInt(checkOut.substring(0,4));
		month1 = Integer.parseInt(checkIn.substring(4,7));
		month2 = Integer.parseInt(checkOut.substring(4,7));
		day1 = Integer.parseInt(checkIn.substring(checkIn.length() - 2,checkIn.length()));
		day2 = Integer.parseInt(checkOut.substring(checkOut.length() - 2,checkOut.length()));
		JulianDate checkIn1 = new JulianDate(year1, month1, day1);
		JulianDate checkOut1 = new JulianDate(year2, month2, day2);
		if (year1 == year2){
			days = checkOut1.sub(checkIn1);
		} else {
			days = checkOut1.sub1(checkIn1);
		}
		return days;
	}
	*/
	public String toString(){
		return "cashAmount= " + cashAmount; //+ days + year1 + amount + checkIn + checkIn1 + checkIn.substring(0,4) + checkIn.substring(4,7) + checkIn.substring(checkIn.length() - 2,checkIn.length());
	}
	/*
	public double cashStandard(String roomType, int amount){
		cashAmount = 100 * amount;
		return cashAmount;
	}
	
	public double cashSingle(String roomType, int amount){
		cashAmount = 200 * amount;
		return cashAmount;
	}
	
	public double cashDeluxe(String roomType, int amount){
		cashAmount = 300 * amount;
		return cashAmount;
	}
	
	public double cashSuite(String roomtype, int amount){
		cashAmount = 400 * amount;
		return cashAmount;
	}
	*/
	
}
