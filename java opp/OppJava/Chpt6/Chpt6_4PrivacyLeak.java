
public class Chpt6_4PrivacyLeak {
	private Date[] a;
	
	//copy constructor
	public Chpt6_4PrivacyLeak(Chpt6_4PrivacyLeak object)
	{
		int lengthOfArrays = object.a.length; 
		//object�� instance variable a�� length
		this.a = new Date[lengthOfArrays]; //a�� ���� ����
		for (int i = 0; i<lengthOfArrays; i++)
			this.a[i] = new Date(object.a[i]);		
	}
	
	//Accessor method
	
	public Date[] getDateArray()
	{
		Date[] temp = new Date[a.length]; //array ���� ����
		for (int i = 0; i<a.length; i++)
			temp[i] = new Date(a[i]);
		return temp;
	}
}

class Date{
	public Date() {
		
	}
	// new Date(a[i])���� ȣ��Ǵ� constructor. a[i]�� Date�� object��
	public Date(Date other) { 
		
	}
}