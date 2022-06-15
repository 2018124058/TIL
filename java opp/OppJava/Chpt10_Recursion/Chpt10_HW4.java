/*
Description:
�� ���� ���� "You look really cool today" �� 
"Sometimes I want to fly away" �� ���� ������ ����Ʈ �ϴ� 
���α׷��� recursion�� �̿��Ͽ� �ۼ��϶�. 

Input: ����
Output:
today cool really look You
away fly to want I Sometimes

CONDITIONS:
1) �ݵ�� recursion�� �̿��Ͽ� �ۼ��ؾ� �Ѵ�. 
2) ������ �ܾ� �ڿ��� space�� ���� new line���� �ٲ��. 

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
	
