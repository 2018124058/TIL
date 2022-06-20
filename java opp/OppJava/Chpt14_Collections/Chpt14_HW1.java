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
		private Node<T> link; // Node<T> class type의 link 
		
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
	
	// 첫 번째 자리에 새로운 노드 넣기 
	public void addToStart(T item){
		
		if (head == null) {
			Node<T> newNode = new Node<T>(item);
			head = newNode;
			head.link = newNode;
		}
		else {
			Node<T> newNode = new Node<T>(item);
			newNode.link = head.link;
			head.link = newNode; // 기존의 head는 마지막으로 
			head = newNode;
		}
	}
	
	// 첫 번째 노드 삭제 
	public boolean deleteHeadNode(){
		if (head != null){
			// 마지막 노드의 link도 바뀌어야 함 
			Node<T> position = head;
			if (position.link == head) { // 마지막 노드
				head = null;
				System.out.println("<last's link>" + position.link.data);
				System.out.println("---List---(" + this.size() + ")");
				return false;
			}
			
			boolean keep = true;
			while (keep) {
				if (position.link == head) { // 마지막 노드
					position.link = head.link; // link 수정
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
	
	// list 내 node 개수 
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
	
	// list 내 node 차례로 출력 
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