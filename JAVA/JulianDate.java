package reserve;

public class JulianDate {
	private int year;
	private int mon;
	private int day;
	private int[] month1 = {31,28,31,30,31,30,31,31,30,31,30,31};
	private int[] month2 = {31,29,31,30,31,30,31,31,30,31,30,31};
	
		
	
	public JulianDate(int year1, int mon1, int day1){
		year = year1; mon = mon1; day = day1;
	}
	
	public JulianDate add(int n){
		day += n;
		if (year % 4 == 0){
			if (day > month2[mon-1]){
				day = day - month2[mon-1];
				mon += 1;
				if (mon > 12){
					mon -= 12;
					year += 1;
				}
			}
			return new JulianDate(year,mon,day);
		}
		else{
			if (day > month1[mon-1]){
				day = day - month1[mon-1];
				mon += 1;
				if (mon > 12){
					mon -= 12;
					year += 1;
				}
			}
			return new JulianDate(year,mon,day);
		}	
		
	}
	
	public int sub(JulianDate d){
		int day1 =0, mon1 = 0, year1 = 0, result = 0;
		
		if (year % 4 == 0){
		if (day >= d.day){
			 day1 = day - d.day;
			 mon1 = mon - d.mon;
			 year1 = year - d.year;
			 for (int i = d.mon; i < mon; i++){
				 result += month2[i-1];
			 }
			 return 365*year1 + result + day1;
		}
			else {
				 year1 = year - d.year;
				 for (int i = d.mon; i < mon; i++){
					 result += month2[i-1];
				 }
				 return 365 * year1 + result + day - d.day;
			}
		}
		else{
			if (day >= d.day){
				 day1 = day - d.day;
				 mon1 = mon - d.mon;
				 year1 = year - d.year;
				 for (int i = d.mon; i < mon; i++){
					 result += month1[i-1];
				 }
				 return 365*year1 + result + day1;
			}
				else {
					 year1 = year - d.year;
					 for (int i = d.mon; i < mon; i++){
						 result += month1[i-1];
					 }
					 return 365 * year1 + result + day - d.day;
				}
		}
		
	}
	
	public int sub1(JulianDate d){
		int result1 = 0;
		int days1 = 0;
		int days2 = 0;
		JulianDate a = new JulianDate(d.year,1,1);
		JulianDate b = new JulianDate(year,12,31);
		JulianDate c = new JulianDate(year,mon,day);
		if (year != d.year){
			for (int i = d.year; i <= year; i++){
				if (i % 4 == 0)
					result1 += 366;
				else
					result1 += 365;
			}
		}
		days1 = d.sub(a);
		days2 = b.sub(c);
		return result1 - days1 - days2;
	}
    
	/*
	public int getMonth(){
		return mon;
	}
	
	public int getYear(){
		
	}
	
	public int getDay(){
		
	}
	*/
	public String toString(){
		return year+"."+mon+"."+day;
	}
	
	public static void main(String[] args){
		JulianDate d1 = new JulianDate(2016,1,30);
		JulianDate d2 = new JulianDate(2017,3,28);
		if (d1.year == d2.year){
			int days = d2.sub(d1);
			System.out.println(days);
		}
		else{
			int days = d2.sub1(d1);
			System.out.println(days);;
		}
	    JulianDate settleDate = d2.add(5);
	    System.out.println(settleDate);
	}
}
