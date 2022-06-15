
public class Final_2 {
	
	public static void main(String[] args) {
		Date date1 = new Date(5, 32);
		Date date2 = new Date(9, -5);
		Date date3 = new Date(13, 28);
		Date date4 = new Date(2, 28);
		Date date5 = new Date(-1, 31);
		System.out.println("date4: " + date4);
	}
}

class Date {
	int month, day;
	
	public Date(int month, int day) {
		try {
			if ((month <= 0)||(month>12))
				throw new MonthException();
			
			if (((month==1)||(month==3)||(month==5)||(month==7)||
				(month==8)||(month==10)||(month==12)) &&
				((day<= 0)||(day>31)))
				throw new DateException();
			else if ((month==2)&&((day<=0)||(day>28)))
					throw new DateException(); 
			else if (((month==4)||(month==6)||(month==9)||(month==11)) 
					&&((day<= 0)||(day>30)))
				throw new DateException();
			
			this.month = month;
			this.day = day;
		}
		
		catch(MonthException e) {
			System.out.println("Month " + month + " is not valid");
		}
		
		catch(DateException e) {
			System.out.println("Day " + day + " is not valid in Month " + month);
		}
		
	}
	
	public String toString() {
		return "[DATE] month(" + month + ") day(" + day + ")";
	}
}

class MonthException extends Exception{
	public MonthException() {
		super();
	}
}

class DateException extends Exception{
	public DateException() {
		super();
	}
}