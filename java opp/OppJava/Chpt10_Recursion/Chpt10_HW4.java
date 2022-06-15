/*
Description:
두 개의 문장 "You look really cool today" 와 
"Sometimes I want to fly away" 를 각각 뒤집어 프린트 하는 
프로그램을 recursion을 이용하여 작성하라. 

Input: 없음
Output:
today cool really look You
away fly to want I Sometimes

CONDITIONS:
1) 반드시 recursion을 이용하여 작성해야 한다. 
2) 마지막 단어 뒤에는 space가 없이 new line으로 바뀐다. 

*/
public class Chpt10_HW4 {

	public static void main(String[] args) {
		String st1 = "You look really cool today";
		String st2 = "Sometimes I want to fly away";
		String[] tokens = st1.split(" "); 
		reversePrint(tokens);
		String[] tokens2 = st2.split(" "); 
		reversePrint(tokens2); 
	}
	
	static void reversePrint(String[] st) {
		if (st.length == 0) return;
		else if (st.length == 1) {
			System.out.println(st[0]);
			return;
		}
		else {
			System.out.print(st[st.length-1] + " ");
			String[] st2 = new String[st.length-1];
			for (int i = 0; i < st.length-1; i++)
				st2[i] = st[i];
			reversePrint(st2);
		}
	}
}
	
