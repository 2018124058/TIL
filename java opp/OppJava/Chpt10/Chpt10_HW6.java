/*
Student113에 String name 이라는 private instance variable 이 있다. 
주어진 Student113 class object의 array 안에 주어진 name의 student를 
찾아주는 method인 'search' 를 완성하라. 
주어진 student가 array 안에 있는 경우 그 index를 output한다. 
만일 존재하지 않는 경우 -1을 output한다. 

CONDITIONS:
1) 주어진 code template의 code들은 절대 바꿀 수 없다.
2) // your code here 부분에만 code를 추가할 수 있다. 
3) search method는 반드시 array의 뒤에서 앞으로 element를 하나씩 체크하는 linear search를 사용해야 한다. 
4) search method는 반드시 recursive하게 구현되어야 한다. 

INPUT: no input
OUTPUT:
2
4
0
-1
*/


public class Chpt10_HW6 {

	public static void main(String[] args) {
		Student113[] stArray = new Student113[5];
		stArray[0] = new Student113("John");
		stArray[1] = new Student113("Tom");
		stArray[2] = new Student113("Jane");
		stArray[3] = new Student113("Mary");
		stArray[4] = new Student113("Paul");
	
		System.out.println(search(stArray, "Jane", 4));
		System.out.println(search(stArray, "Paul", 4));
		System.out.println(search(stArray, "John", 4)); 
		System.out.println(search(stArray, "Brown", 4)); 
	}
	
	// your code here: for method 'search'
	public static int search(Student113[] a, String name, int endIndex) {
		if (endIndex == 0) {
			if (name.equals(a[0].getName())) return 0;
			else return -1;
		}
		if (name.equals(a[endIndex].getName())) return endIndex;
		else return search(a, name, endIndex-1);
	}
	
}

class Student113 {
	// your code here
	private String name;
	
	public Student113(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
