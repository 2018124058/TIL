import java.util.StringTokenizer;
public class Mid01_1 {
	public static void main(String[] args) {
		
		String str1 = "Seoul is a largest city in Korea";
		String str2 = "All my dreams will come true ?boy";
		String str3 = "Hi";
		String str4 = "";
		String str5 = "That is your 123th visit in Busan.";
		
		String[] strs = {str1, str2, str3, str4, str5};
		
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i];
          	
          	StringTokenizer tokenizer = new StringTokenizer(str);
          	int wordNum = tokenizer.countTokens();
			String[] wordlist = new String [wordNum];
			
			for (int j = 0; j < wordNum; j++) {
				wordlist[j] = tokenizer.nextToken();
			}
			boolean letterElse = false;
			for (int j = 0; j < wordNum; j++) {
				if (!Character.isLetterOrDigit(wordlist[j].charAt(0))) {
					String temp = wordlist[0];
					wordlist[0] = wordlist[j];
					letterElse = true;
				}
				else if (!Character.isLetter(wordlist[j].charAt(0))) {
					String temp = wordlist[0];
					wordlist[0] = wordlist[j];
					letterElse = true;
				}
			}
			if (letterElse) {
				String min = wordlist[1].toLowerCase();
				int minIndex = 1;
				/*for (int j = 1; j<wordNum; j++) {
					if (wordlist[j].toLowerCase().compareTo(min) < 0) {
						min = wordlist[j].toLowerCase();
						minIndex = j;
					}
				String temp = wordlist[1];
				wordlist[1] = min;
				wordlist[j] = temp;
				}*/
				for (int x = 1; x < wordNum-1; x++){			
					for (int j = x; j<wordNum; j++) {
					if (wordlist[j].toLowerCase().compareTo(min) < 0) {
						min = wordlist[j].toLowerCase();
						minIndex = j;
					}
					String temp = wordlist[x];
					wordlist[x] = min;
					wordlist[j] = temp;
					}
				}
			}
			
			
			//ÇÁ¸°Æ®
          	for (int j = 0; j < wordNum; j++) {
          		System.out.print(wordlist[j]);
          		if (j != wordNum-1)
          			System.out.print(" ");
          	}
			System.out.println();
		}
	}
}
