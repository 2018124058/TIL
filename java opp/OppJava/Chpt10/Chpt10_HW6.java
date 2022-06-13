/*
Student113�� String name �̶�� private instance variable �� �ִ�. 
�־��� Student113 class object�� array �ȿ� �־��� name�� student�� 
ã���ִ� method�� 'search' �� �ϼ��϶�. 
�־��� student�� array �ȿ� �ִ� ��� �� index�� output�Ѵ�. 
���� �������� �ʴ� ��� -1�� output�Ѵ�. 

CONDITIONS:
1) �־��� code template�� code���� ���� �ٲ� �� ����.
2) // your code here �κп��� code�� �߰��� �� �ִ�. 
3) search method�� �ݵ�� array�� �ڿ��� ������ element�� �ϳ��� üũ�ϴ� linear search�� ����ؾ� �Ѵ�. 
4) search method�� �ݵ�� recursive�ϰ� �����Ǿ�� �Ѵ�. 

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
