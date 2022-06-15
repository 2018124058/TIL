# Chapter13. Java Linked List  

## Linked Data Structure  
- ������ ������ link�� ����Ǿ��ִ� ����  
- link: �ϳ��� ��忡�� ���� ���� ���� �ܹ����� ��� (���ƿ� ���� ����)  
- Java�� linked data structure  
	- nodes: node class�� objects. data�� link�� ���´�. 
	- node ���� ������: instance variables�� �����  
	- links: reference(memory address). class type�� instance variable�� ����ȴ�.  
	
## Java Linked List  
- linked data structure �� ���� �ܼ��� ����  
- linked list: �ϳ��� ��� ü������ �����ȴ�. ������ ���� ���� ����� �ּҿ� ���� ��ũ�� ������.  
- ù ��° ��带 head node�� �θ���  
- head: ù ��° ���(head node)�� �ּҸ� ���� �ִ�.   
- ������ ���� end marker�� ������ �Ѵ�. ���� ��忡 ���� ��ũ�� ���� ������ ��ũ�� ���� null�̴�.

## Node Inner Class  
- LinkedList class �ȿ� inner class�� Node class�� �����ϱ�  
- node class�� ���ǰ� ����������. LinkedList�� node�� private variable�� �����Ӱ� ������ �� �־� accessor�� mutator�� ���ʿ��ϴ�  

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
	
	private Node head; // ù ��° ��忡 ���� �ּ� 
	
	public LinkedList(){head = null;}
	
	// ù ��° ��ġ�� ���ο� ��� �ֱ�: head�� ù ����� ��ũ�� �ٲ�� 
	// ���ο� ù ��° ����� ��ũ�� ������ head�� �ȴ� 
	public void addToStart(String item){ 
		head = new Node(item, head);
	}
	
	// ù ��° ���(���)�� �����ϰ� ����Ʈ�� �ϳ� �̻��� ��带 �����ϴ��� boolean�� ����
	// list�� ��������� false
	public boolean deleteHeadNode(){
		if (head != null){
			head = head.link; // ���� head�� link(= �� ��° ���)�� head�� �����
			return true;
		}
		else // head�� ������� = list�� ����ִ� 
			return false;
	}
	
	// list �� node�� ���� ����  
	public int size(){
		int count = 0;
		Node position = head;
		while (position != null){
			count++;
			position = position.link; // ���� ���� �̵��� ������ count�� ������Ŵ. null�� ������ list�� ���� ���̱� ������ �ݺ��� Ż�� 
		}
		return count;
	}
	
	// list �� Ư�� data�� ���� �ִ� ��尡 �ִ��� Ȯ��
	public boolean contains(String data){
		return (find(data) != null);
	}
	
	// list �� target data�� ���� �ִ� ù ��°Node�� ����
	// ������ null�� ����  
	private Node find(String target){
		Node position = head; // ù ���� initialize
		String itemAtPosition;
		while (position != null){ // ó������ �̵��ϸ鼭 Ž��
			itemAtPosition = position.item; 
			if (itemAtPosition.equals(target))
				return position; 
			position = position.link; // target�� ���� ���� ������ ���� ���� �̵� 
		}
		return null; // �ݺ����� �� �� ������(list ��ü Ž�� �Ϸ�) ���� �� 
	}
	
	// list �� node�� ������� ��� 
	public void outputList(){
		Node position = head;
		while (position != null){
			System.out.println(position.item);
			position = position.link; // ���� ���� �̵�
		}
	}
	
	// list�� ����ִ��� Ȯ�� 
	public boolean isEmpty(){return (head == null);}
	
	// list�� ����
	public void clear(){head = null;}
	
}
```

## Generic Linked List  
- node class�� type parameter�� ���� (generic class��) linked list  
- linkedlist�� type parameter�� �޴´� 

```
public class LinkedList2<T>{
	
	private class Node<T>{
		private T data;
		private Node<T> link; // Node<T> class type�� link 
		
		public Node(){data = null; link = null;}
		
		public Node(T data, Node<T> link){
			this.data = data; 
			this.link = link;
		}
	} // end of Node Class	
	
	private Node<T> head; 
	
	public LinkedList2(){head = null;} // consturctor���� <T> ���� �ʴ´� 
	// ù ��° �ڸ��� ���ο� ��� �ֱ� 
	public void addToStart(T item){
		head = new Node<T>(item, head);
	}
	
	// ù ��° ��� ���� 
	public boolean deleteHeadNode(){
		if (head != null){
			head = head.link;
			return true; 
		}
		else 
			return false;
	}
	
	// list �� node ���� 
	public int size(){
		int count = 0;
		Node<T> position = head; 
		while (position != null){
			count++;
			position = position.link;
		}
		return count;
	}
	
	// Ư�� item�� ���� node�� list�� �ִ��� ���� 
	public boolean contains(T item){
		return (find(item) != null);
	}
	
	// target�� ���� node�� ����, ������ null 
	private Node<T> find(T target){
		Node<T> position = head;
		T itemAtPostion; 
		while (position != null){
			itemAtPostion = position.data;
			if (itemAtPostion.equals(target)) // T class�� equals�� �� ���ǵǾ� �־���� 
				return position; 
			position = position.link; 
		}
		return null; 
	}
	
	// list �� node ���ʷ� ��� 
	public void outputList(){
		Node<T> position = head;
		while (position != null){
			System.out.println(position.data);
			position = position.link;
		}
	}
	
	// list�� ������� Ȯ�� 
	public boolean isEmpty(){return (head==null);}
	
	// list ���� 
	public void clear(){head = null;}
	
	// �� ���� list ��  
	public boolean equals(Object other){
		if (other == null) 
			return false;
		else if (getClass() != other.getClass())
			return false;
		else{
			LinkedList2<T> otherList = (LinkedList2<T>)other;
			if (size() != otherList.size()) // ũ�Ⱑ ���ƾ� ��
				return false;
			
			Node<T> position = head;
			Node<T> otherPosition = otherList.head;
			while (position != null){
				if (!(position.data.equals(otherPosition.data)))
					return false;
				position = position.link; // ���� ���� �̵� 
				otherPosition = otherPosition.link;
			}
			return true; // �����Ͱ� ��� ������ Ȯ�� �� 
		}
	}	
}
```