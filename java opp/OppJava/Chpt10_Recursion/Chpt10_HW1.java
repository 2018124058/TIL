//주어진 수가 3을 계속해서 곱하여 나올 수 있는 수 (3의 몇 제곱 수) 인지 test하는 프로그램을 recursion을 이용하여 작성하라.

public class Chpt10_HW1 {

	public static void main(String[] args) {
		int[] data = {0, 1, 3, 4, 9, 15, 18, 27, 29}; 
		for (int i = 0; i < data.length; i++) {
			System.out.println("" + data[i] + ": " + powerOfThree(data[i]));
		}
		
		
		System.out.println(powerOfThree(12));
	}
	
 
    static boolean powerOfThree(int n) {
      // your code for method powerOfThree
    	
    	if ((n==2)||(n==0))
    		return false;
    	
       	else if (n == 1)
    		return true;
    	
    	else if (n % 3 != 0) 
    		return false;
    
    	else 
    		return powerOfThree(n/3);
    	
    }
}
