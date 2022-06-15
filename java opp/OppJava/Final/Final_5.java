import java.util.Stack;

public class Final_5 {
	
	public static void main(String[] args) {
		String str[] = { "3", 
                        "32+", 
                        "32+7-", 
                        "327+5+42-+-"};
		
		for (int i = 0; i < str.length; i++) {
			int answer = compute(str[i]);
			System.out.println(answer);
		}

	}
	// your code here for method "compute"
	static int compute(String s) {

		Stack <String> stk = new Stack<String>(); 
		
		for (int i = 0; i <s.length(); i++)
			stk.push(s.substring(i,i+1));
		
		int result = 0;
		for (int i=0; i <stk.size(); i++) {
			if (stk.get(i) == "+")
				result += Integer.parseInt(stk.get(i-2)) + Integer.parseInt(stk.get(i-1));
			else if (stk.get(i) == "-")
				result += Integer.parseInt(stk.get(i-2)) - Integer.parseInt(stk.get(i-1));
		}
		return result; 
	}
}
