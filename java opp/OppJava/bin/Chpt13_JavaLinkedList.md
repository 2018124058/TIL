# Chapter13. Java Linked List  

## Linked Data Structure  
- 데이터 노드들이 link로 연결되어있는 구조  
- link: 하나의 노드에서 다음 노드로 가는 단방향의 경로 (돌아올 수는 없다)  
- Java의 linked data structure  
	- nodes: node class의 objects. data와 link를 갖는다. 
	- node 안의 데이터: instance variables로 저장됨  
	- links: reference(memory address). class type의 instance variable로 저장된다.  
	
## Java Linked List  
- linked data structure 중 가장 단순한 구조  
- linked list: 하나의 노드 체인으로 구성된다. 각각의 노드는 다음 노드의 주소에 대한 링크를 가진다.  
- 첫 번째 노드를 head node라 부른다  
- head: 첫 번째 노드(head node)의 주소를 갖고 있다.   
- 마지막 노드는 end marker의 역할을 한다. 다음 노드에 대한 링크가 없기 때문에 링크의 값은 null이다.

## Node Inner Class  
- LinkedList class 안에 inner class로 Node class를 정의하기  
- node class의 정의가 간단해진다. LinkedList가 node의 private variable에 자유롭게 접근할 수 있어 accessor과 mutator가 불필요하다  

```
public class LinkedList{
	
	private class Node{ // node class (inner class)
		private String item; // data
		private Node link; // link 
		
		public Node(){item = null; link = null;}
		
		public Node(String item. Node link){
			this.item = item;
			this.link = link;
		}	
	} // end of node class (no need for mutator, accessor)
	
	private Node head; // 첫 번째 노드에 대한 주소 
	
	public LinkedList(){head = null;}
	
	// 첫 번째 위치에 새로운 노드 넣기: head는 첫 노드의 링크로 바뀐다 
	// 새로운 첫 번째 노드의 링크는 이전의 head가 된다 
	public void addToStart(String item){ 
		head = new Node(item, head);
	}
	
	// 첫 번째 노드(헤드)를 삭제하고 리스트가 하나 이상의 노드를 포함하는지 boolean을 리턴
	// list가 비어있으면 false
	public boolean deleteHeadNode(){
		if (head != null){
			head = head.link; // 기존 head의 link(= 두 번째 노드)를 head로 만든다
			return true;
		}
		else // head가 비어있음 = list가 비어있다 
			return false;
	}
	
	// list 내 node의 개수 리턴  
	public int size(){
		int count = 0;
		Node position = head;
		while (position != null){
			count++;
			position = position.link; // 다음 노드로 이동할 때마다 count를 증가시킴. null이 나오면 list가 끝난 것이기 때문에 반복문 탈출 
		}
		return count;
	}
	
	// list 내 특정 data를 갖고 있는 노드가 있는지 확인
	public boolean contains(String data){
		return (find(data) != null);
	}
	
	// list 내 target data를 갖고 있는 첫 번째Node를 리턴
	// 없으면 null을 리턴  
	private Node find(String target){
		Node position = head; // 첫 노드로 initialize
		String itemAtPosition;
		while (position != null){ // 처음부터 이동하면서 탐색
			itemAtPosition = position.item; 
			if (itemAtPosition.equals(target))
				return position; 
			position = position.link; // target을 갖고 있지 않으면 다음 노드로 이동 
		}
		return null; // 반복문을 다 돌 때까지(list 전체 탐색 완료) 없을 때 
	}
	
	// list 내 node를 순서대로 출력 
	public void outputList(){
		Node position = head;
		while (position != null){
			System.out.println(position.item);
			position = position.link; // 다음 노드로 이동
		}
	}
	
	// list가 비어있는지 확인 
	public boolean isEmpty(){return (head == null);}
	
	// list를 비우기
	public void clear(){head = null;}
	
}
```

## Generic Linked List  
- node class가 type parameter를 갖는 (generic class인) linked list  
- linkedlist도 type parameter를 받는다 

```
public class LinkedList2<T>{
	
	private class Node<T>{
		private T data;
		private Node<T> link; // Node<T> class type의 link 
		
		public Node(){data = null; link = null;}
		
		public Node(T data, Node<T> link){
			this.data = data; 
			this.link = link;
		}
	} // end of Node Class	
	
	private Node<T> head; 
	
	public LinkedList2(){head = null;} // consturctor에는 <T> 쓰지 않는다 
	// 첫 번째 자리에 새로운 노드 넣기 
	public void addToStart(T item){
		head = new Node<T>(item, head);
	}
	
	// 첫 번째 노드 삭제 
	public boolean deleteHeadNode(){
		if (head != null){
			head = head.link;
			return true; 
		}
		else 
			return false;
	}
	
	// list 내 node 개수 
	public int size(){
		int count = 0;
		Node<T> position = head; 
		while (position != null){
			count++;
			position = position.link;
		}
		return count;
	}
	
	// 특정 item을 가진 node가 list에 있는지 리턴 
	public boolean contains(T item){
		return (find(item) != null);
	}
	
	// target을 가진 node를 리턴, 없으면 null 
	private Node<T> find(T target){
		Node<T> position = head;
		T itemAtPostion; 
		while (position != null){
			itemAtPostion = position.data;
			if (itemAtPostion.equals(target)) // T class의 equals가 잘 정의되어 있어야함 
				return position; 
			position = position.link; 
		}
		return null; 
	}
	
	// list 내 node 차례로 출력 
	public void outputList(){
		Node<T> position = head;
		while (position != null){
			System.out.println(position.data);
			position = position.link;
		}
	}
	
	// list가 비었는지 확인 
	public boolean isEmpty(){return (head==null);}
	
	// list 비우기 
	public void clear(){head = null;}
	
	// 두 개의 list 비교  
	public boolean equals(Object other){
		if (other == null) 
			return false;
		else if (getClass() != other.getClass())
			return false;
		else{
			LinkedList2<T> otherList = (LinkedList2<T>)other;
			if (size() != otherList.size()) // 크기가 같아야 함
				return false;
			
			Node<T> position = head;
			Node<T> otherPosition = otherList.head;
			while (position != null){
				if (!(position.data.equals(otherPosition.data)))
					return false;
				position = position.link; // 다음 노드로 이동 
				otherPosition = otherPosition.link;
			}
			return true; // 데이터가 모두 같은지 확인 후 
		}
	}	
}
```