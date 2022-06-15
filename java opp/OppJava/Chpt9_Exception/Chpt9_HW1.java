
public class Chpt9_HW1 {

	public static void main(String[] args) {
		
		MyInteger91[] array = new MyInteger91[5]; 
		
		array[0] = new MyInteger91(5, "3"); 
		array[1] = new MyInteger91(2, "7");
		array[2] = new MyInteger91(4, "Korea");
		
		for (int i = 0; i < 6; i++) {   // you should change the code inside the for loop using try-catch blocks
			try {	
				System.out.println("array[" + i + "] = " + array[i]); 
				System.out.println("array[" + i + "].strValueToInt = " + array[i].strValueToInt());
			}
			
			catch(NullPointerException e) {
				System.out.println("array[" + i + "] = null, no valid object yet");
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("array[" + i + "] = array access out of bounds");
			}
			
			catch(NumberFormatException e) {
				System.out.println("array[" + i + "].strValue " + array[i].getStrValue() 
						+ " cannot be converted to Integer ");
			}
		}

	}

}

//your code for class MyInteger91 here 
class MyInteger91{
	private int value;
	private String strValue;
	
	public MyInteger91(int value, String strValue) {
		this.value = value;
		this.strValue = strValue;
	}
	
	public int strValueToInt() {
		return Integer.parseInt(strValue);
	}
	
	public String getStrValue() {
		return strValue;
	}
	
	public String toString() {
		return (value + " " + strValue);
	}
}