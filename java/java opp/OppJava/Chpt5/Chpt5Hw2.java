import java.util.Scanner; 
import java.util.StringTokenizer;

public class Chpt5Hw2 {

	public static void main(String[] args) {
		System.out.println(compute());
	}
	
	static Double compute() {
		Scanner keyboard = new Scanner(System.in);
		String userInput = keyboard.nextLine();
		StringTokenizer splitter = new StringTokenizer(userInput);
		
		double sum = 0;
		double num = 0;
		
		while (splitter.hasMoreTokens()) {
			String word = splitter.nextToken();
			int dotNum = 0; 
			int nonDigit = 0;
			
			for (int i = 0; i < word.length(); i++) {
				if (!Character.isDigit((word.charAt(i))))
					nonDigit += 1;
				
				if (word.charAt(i) == '.')
					dotNum +=1;
			}
		
			char first = word.charAt(0);
			
			switch(nonDigit) {
			case 0:
				sum += Double.parseDouble(word);
        		num += 1;
        		break;
        		
			case 1:
				if ((first == '+') || (first == '-'))
					{sum += Double.parseDouble(word);
    				num += 1;}
    			
    			else if (dotNum == 1)
    				{sum += Double.parseDouble(word);
    				num += 1;}
    			break;	
        			
			case 2: 	
				if (dotNum == 1) {
					if (first == '+' || first == '-')
						sum += Double.parseDouble(word);
	        			num += 1;
				}
			}		
		}
		
		if (num == 0)
			return 0.0;
		else
			return (sum / num);
	}
}
