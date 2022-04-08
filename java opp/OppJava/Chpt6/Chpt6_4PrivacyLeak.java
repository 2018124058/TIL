
public class Chpt6_4PrivacyLeak {
	private Date[] a;
	
	//copy constructor
	public Chpt6_4PrivacyLeak(Chpt6_4PrivacyLeak object)
	{
		int lengthOfArrays = object.a.length; 
		//object의 instance variable a의 length
		this.a = new Date[lengthOfArrays]; //a를 새로 생성
		for (int i = 0; i<lengthOfArrays; i++)
			this.a[i] = new Date(object.a[i]);		
	}
	
	//Accessor method
	
	public Date[] getDateArray()
	{
		Date[] temp = new Date[a.length]; //array 새로 생성
		for (int i = 0; i<a.length; i++)
			temp[i] = new Date(a[i]);
		return temp;
	}
}

class Date{
	public Date() {
		
	}
	// new Date(a[i])에서 호출되는 constructor. a[i]는 Date의 object다
	public Date(Date other) { 
		
	}
}