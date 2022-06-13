import java.util.ArrayList;

public class Chpt12_1ArrayList {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(20);
		ArrayList<String> list2 = new ArrayList<String>(20);
		ArrayList<Integer> list3 = new ArrayList<Integer>(); // capacity = default 10
		ArrayList<Double> list4 = new ArrayList<Double>();
		
		list.add("hi");
		list.add("hello");
		for (int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		
		list.set(0, "oh");
		list.add(0,"yeah");
		for (int i=0; i<list.size(); i++)
			System.out.println(list.get(i));
		
		list3.add(5); // automatic boxing to Integer
		System.out.println(list3.get(0)); // Integer의 toString이 실행되어 String 리턴  
		
	}
	
	
}
