
public class Final_3 {

	public static void main(String[] args) {
		int[] data = {110321, 0, 234567, 11, 1};
		
		for (int i = 0; i < data.length; i++) {
			System.out.println(numberOfOne(data[i]));
		}

	}
	
	// your code here for method numberOfOne
	public static int numberOfOne(int n) {
		if (n < 1){ //stopping case
			return 0;
		}
		else{  
			if ((n%10)==1)
				return 1 + numberOfOne(n/10); // recursive call
			return numberOfOne(n/10); // recursive call
		}
	}
}

