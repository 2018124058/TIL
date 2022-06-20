public class Chpt14_HW1 {
	
	public static void main(String[] args) {
		
		CircularList<Person> list = new CircularList<Person>();
		
		System.out.println("---List---(" + list.size() + ")");
		list.showList();
		
		list.addToStart(new Person("Tom"));
		list.addToStart(new Person("Jane"));
		list.addToStart(new Person("Aaron"));
		list.addToStart(new Person("Jeff"));
		
		System.out.println("---List---(" + list.size() + ")");
		list.showList();
		
		while(list.deleteHeadNode()) { 
			System.out.println("---List---(" + list.size() + ")");
			list.showList();
		}
		

	}

}

// your code for CircularList and Person 
class Person {
	String name; 
	
	public Person(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "[PERSON] name(" + name + ")";
	}
}

class CircularList<T> {
	private class Node<T>{
		private T data;
		private Node<T> link; // Node<T> class type�� link 
		
		public Node(){data = null; link = null;}
		
		public Node(T data, Node<T> link){
			this.data = data; 
			this.link = link;
		}
		
		public Node(T data) {
			this.data = data;
			this.link = null;
		}
	} // end of Node Class	
	
	private Node<T> head; 
	
	public CircularList(){head = null;} 
	
	// ù ��° �ڸ��� ���ο� ��� �ֱ� 
	public void addToStart(T item){
		
		if (head == null) {
			Node<T> newNode = new Node<T>(item);
			head = newNode;
			head.link = newNode;
		}
		else {
			Node<T> newNode = new Node<T>(item);
			newNode.link = head.link;
			head.link = newNode; // ������ head�� ���������� 
			head = newNode;
		}
	}
	
	// ù ��° ��� ���� 
	public boolean deleteHeadNode(){
		if (head != null){
			// ������ ����� link�� �ٲ��� �� 
			Node<T> position = head;
			if (position.link == head) { // ������ ���
				head = null;
				System.out.println("<last's link>" + position.link.data);
				System.out.println("---List---(" + this.size() + ")");
				return false;
			}
			
			boolean keep = true;
			while (keep) {
				if (position.link == head) { // ������ ���
					position.link = head.link; // link ����
					head = head.link;
					keep = false;
				}
				position = position.link;
			}
			
				
			return true; 
		}
		else 
			return false;
	}
	
	// list �� node ���� 
	public int size(){
		int count = 0;
		
		if (head == null)
			return count; 
		
		Node<T> position = head; 
		position = position.link;
		count++;
		while (position != head){
			count++;
			position = position.link;
		}
		return count;
	}
	
	// list �� node ���ʷ� ��� 
	public void showList(){
		if (head == null)
			return;
		
		Node<T> position = head;
		if (position != null) {
			System.out.println(position.data + " <head>");
		}
		position = position.link;
			
		while ((position != head) && (position != null)) {
			System.out.println(position.data);
			if (position.link == head) {
				System.out.println("<last's link>" + position.link.data);
			}
			position = position.link;
		}
	}
}