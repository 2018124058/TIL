import java.util.Scanner;
import java.util.StringTokenizer;

public class Mid02_1 {
	public static void main(String[] args) {
    	Scanner keyboard = new Scanner(System.in);
    	boolean on = true;
    	int result = 0; 
    	System.out.println("result=0");
    	while(on) {
    		String order = keyboard.nextLine();
    	
    		StringTokenizer tokenizer = new StringTokenizer(order);
    		String operator = tokenizer.nextToken();
    		
    	
    		if (operator.equals("add")){
    			while (tokenizer.hasMoreTokens()) {
    				int a = Integer.parseInt(tokenizer.nextToken());
    				result += a;
    			}
    			System.out.println("result=" + result);
    		}
    		else if (operator.equals("sub")) {
    			while (tokenizer.hasMoreTokens()) {
    				int a = Integer.parseInt(tokenizer.nextToken());
    				result -= a;
    			}
    			System.out.println("result=" + result);
    		}
    		else if (operator.equals("mult")) {
    			while (tokenizer.hasMoreTokens()) {
    				int a = Integer.parseInt(tokenizer.nextToken());
    				result *= a;
    			}
    			System.out.println("result=" + result);
    		}
    		
    		else if (operator.equals("exit")) {
    			System.out.println("bye");
    			on = false;
    			System.exit(0);
    		}
    		else {
    			System.out.println("wrong operation: " + operator);
    			System.out.println("result=" + result);
    		}
    	}
	}
}