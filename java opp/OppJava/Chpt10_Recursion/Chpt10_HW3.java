
public class Chpt10_HW3 {
	public static void main(String[] args) {
		String str1 = "abcdaabcdeaba";   	// 5 a, odd
		String str2 = "";                   // 0 a, even
		String str3 = "poaiasdfabaf";       // 4 a, even
		String str4 = "ksdflkjlksdf";       // 0 a, even
		
		ABString ab1 = new ABString(str1); 
		System.out.println(ab1.isEvenA());
		
		ABString ab2 = new ABString(str2); 
		System.out.println(ab2.isEvenA());
		
		ABString ab3 = new ABString(str3); 
		System.out.println(ab3.isEvenA());
		
		ABString ab4 = new ABString(str4); 
		System.out.println(ab4.isEvenA());
		
		System.out.println(ab1.countA(ab1.str));
		System.out.println(ab2.countA(ab2.str));
		System.out.println(ab3.countA(ab3.str));
		System.out.println(ab4.countA(ab4.str));
		
	}

}

class ABString {
	String str;
	
	public ABString(String str) {
		this.str = str;
	}
	
	public boolean isEvenA() {
		if (countA(this.str) % 2 == 0)
			return true;
		else
			return false;
			
	}
	
	public int countA(String s) {
		if (s.length() == 0)
			return 0;
		else
			if (s.charAt(0) == 'a')
				return 1 + countA(s.substring(1));
			return countA(s.substring(1));
	}
}
