# Chapter14. Collections  
# Collection  
- 데이터 그룹들을 저장하기 위한 클래스들을 스탠다드화 해둔 것  
- `Collection`: `Iterable`interface를 extends한 interface  
	- `List`, `Queue`, `Set`: 	`Collection`을 extends한 interface  
	
## Core Interface of Collection  
- `List`  
	- 순서 o (데이터를 집어넣은 순서가 유지된다)  
	- 중복 데이터 허용  
	- class: `ArrayList`, `LinkedList`, `Stack`, `Vector`...  
- `Set`  
	- 순서 x (데이터를 집어넣은 순서가 유지x)  
	- 중복 데이터 허용x  
	- class: `HashSet`, `TreeSet`...  
- `Map`  
	- tuple로 이루어짐. 하나의 데이터가 key와 value의 쌍으로 이루어진다.  
	- 순서 x  
	- key는 중복 불가, value는 중복 허용  
	- class: `HashMap`, `TreeMap`, `HashTable`, `Properties`...  

## Methods in interface Collection<E>  
- Collection interface가 갖는 method  
- `add(E e)`: 더하고 boolean 리턴  
- `addAll(Collection<? extends E> c)`: 다른 collection의 elements를 한꺼번에 다 넣음. boolean 리턴  
- `clear()`: element 모두 제거, void method  
- `contains(Object o)`: collection이 o를 포함하는지 boolean 리턴  
- `containsAll(Collection<?> c)`: 다른 collection의 모든 element를 포함하는지 boolean 리턴  
- `equals(Object o)`: 같은 collection인지 boolean 리턴 ?  
- `hashCode()`: returns hash code value for this collection  
- `isEmpty()`: collection 내 element가 없으면 true 리턴  
- `iterator()`: collection의 모든 element에 대한 iterator 리턴 (Iterator<E>)  
- `remove(Object o)`: collection 내 o 제거, 제거하면 true 리턴  
- `removeAll(Collection<> c)`: 다른 collection 내 포함된 element를 모두 제거, 제거할 것이 있었다면 true 리턴  
- `retainAll(Collection<?> c)`: 다른 collection에 든 element만 남기고 모두 제거. 제거할 것이 있었다면 true 리턴  
- `size()`: collection 내 element 개수 리턴  
- `toArray()`: array로 만들어 반환  

# Interface List  
- 순서 o, 중복 데이터 o  
## Methods in Interface List  
- `add(int index, E element)`: index 위치에 element 삽입  
	- int index 생략하면 list 끝에 삽입 
- `addAll(int index, Collection<? extends E> c)`: list의 index 위치에 다른 collection의 모든 element 삽입  
	- int index를 생략하면 list 끝에 삽입  
- `clear()`: list 비우기  
- `contains(Object o)`: o element가 포함됐는지 boolean 리턴  
- `containsAll(Collection<?> c)`: 다른 collection의 모든 element를 포함하는지 boolean 리턴  
- `copyOf(Collection <? extends E> c)`: 동일한 순서의 element를 가진 collection을 리턴 (unmodifiable List)  
- `equals(Object o)`: o와 list가 같은지 리턴  
- `get(int index)`: list의 index 위치 element 리턴  
- `hashCode()`: list의 hash code value 리턴  
- `indexOf(Object o)`: element o의 index 리턴, 없으면 -1  
- `lastIndexOf(Object o)`: element가 o인 마지막 element의 index 리턴, 없으면 -1
- `isEmpty()`: list가 비어있으면 true 리턴  
- `iterator()`:   
- `remove(int index)`: index 위치의 element 제거, 제거한 element 리턴   
- `remove(Object o)`: o 제거, 제거 여부 리턴  
- `removeAll(Collection<?> c)`: 다른 collection에 포함된 element면 제거, 제거 여부 boolean으로 리턴  
- `retainAll(Collection<?> c)`: 다른 collection에 포함된 element만 남기기. element 제거 여부 boolean으로 리턴  
- `set(int index, E element)`: index 위치에 element 삽입  
- `size()`: element 개수 리턴  
- `sort(Comparator<? super E> c)`: Compartor의 순서로 list sorting  
- `subList(int fromIndex, int toIndex)`: fromIndex부터 toIndex-1까지 list를 잘라 리턴  
- `toArray()`: list를 array로 바꾸어 리턴  

## ArrayList and Vector Class  
- 순서 o, 데이터 중복 o  
- use array as storage space. 연속되는 메모리 공간에 존재  

```
import java.util.ArrayList;
import java.util.Collections; // sort() method 등 사용 가능  

ArrayList<Integer> list = new ArrayList<Integer>();
list.add(4); list.add(3); list.add(2);

ArrayList<Integer> list2 = new ArrayList<Integer>(list.subList(1,2);
System.out.println(list); // output: [4,3,2]
System.out.println(list2); // output: [3]

Collections.sort(list); 
System.out.println(list); // output: [2,3,4] 정렬됨  
System.out.println(list.containsAll(list2)); // output: true
```

### Removing sequence in ArrayList  
- 특정 데이터를 지우는 방식: 특정 데이터 뒤에 있는 것들을 카피해서 앞으로 옮겨와 채움, 마지막 데이터 자리를 null로 만듦, size를 1 줄임  
- 첫 번째 데이터를 삭제할 경우 size-1 개의 데이터를 모두 옮겨야 한다  
- 뒤에서부터 삭제하면  데이터를 이동시키지 않아도 돼서 효율적 

## LinkedList Class  
- 순서 o, 중복 데이터 허용 o  
- 각각의 노드가 다음 노드에 대한 주소 (link)를 갖고 있기 때문에 메모리 상에서 붙어있을 필요가 없다  
- 데이터 삭제 시 : 앞에 있는 노드의 링크가 삭제하는 노드 뒤의 노드 주소를 가리키게 하면 된다  
- 데이터 삽입 시: 앞 뒤 노드의 링크를 바꿔준다 
- 메모리의 효율적 사용  

### LinkedList의 다양한 타입  
- LinedList: access가 어렵다  
	```
	class Node{
		Node next; // 다음 노드에 대한 link 
		Object obj; // data
	}
	```
- Doubly LinkedList: better access  
	- 이전 노드와 다음 노드에 대한 link를 모두 갖는다  
	```
	class Node{
		Node next; // 다음 노드에 대한 link 
		Node previous; // 이전 노드에 대한 link 
		Object obj; // data
	}
	```
- Doubly Circular LinkedList  
	- 이전 노드와 다음 노드에 대한 link를 모두 갖는다  
	- 마지막 노드는 첫 번째 노드의 주소, 첫 번째 노드는 마지막 노드의 주소를 갖는다  

### LinkedList 예시  

```
import java.util.LinkedList; // import java.util.*;

LinkedList<String> ll = new LinkedList<String>(); 

ll.add("a"); ll.add("b"); ll.add("c"); // [a,b,c]
ll.add(2,'e'); // [a,b,e,c] 해당 위치의 기존 element는 밀려난다 

ll.removeFirst(); // [b,e,c]
ll.removeLast(); // [b,e]
```

### Methods in LinkedList  
- `addFirst(E e)`: list 첫번째 위치에 e 삽입  
- `addLast(E e)`: list 끝에 e 삽입  
- `element()`: list의 첫 element를 리턴, 삭제는 안함  
- `getFirst()`, `getLast()`: 각각 첫번째, 마지막 element를 리턴  
- `offer(E e)`: list 끝에 e 삽입, 삽입 여부 boolean으로 리턴  
- `offerFirst(E e)`, `offerLast(E e)`: 각각 첫번째, 끝에 e 삽입, boolean 리턴  
- `peek()`: list의 첫번째 element 리턴, 삭제는 안함. `element()`와 유사  
- `peekFirst()`, `peekLast()`: 각각 첫번째, 마지막 element 리턴  
- `poll()`: 첫번째 element를 삭제하고 리턴  

## Stack Class  
- 맨 위에 push, 맨 위 것을 pop  
- Last in, First out (LIFO)  
- 데이터가 위로 쌓이고, 삭제도 위에서부터 한다  

### Methods in Stack  
- `empty()`: stack이 비어있는지 확인  
- `push(E e)`: stack의 가장 위에 element 넣기  
- `pop()`: stack 가장 위의 element를 삭제, 삭제한 element를 리턴  
- `peek()`: stack 가장 위의 element를 리턴, 삭제는 안함  
- `search(Object o)`: o를 찾아 index를 리턴, 없으면 -1  

```
import java.util.Stack;

//Stack class object 생성 
Stack<Integer> stk = new Stack<Integer>();
stk.push(1);
stk.push(2);
System.out.println(stk); // [1,2]
System.out.println(stk.pop()); // 2
```

# Interface Queue  
- linkedList가 implements함  
- First in, First out (FIFO): 제일 위에 넣고, 첫 번째(제일 아래) 있는 것부터 제거   

## Methods in Queue  
- `add(E e)`: e를 삽입, 삽입했으면 true 리턴 
- `element()`: head element(제일 앞에 있는 element)를 리턴, 삭제는 안함  
- `offer(E e)`: e를 삽입, 삽입했으면 true 리턴  
- `peek()`: head element를 리턴, 비어있다면 null 리턴  
- `poll()`:head element를 삭제하고 리턴, 비어있다면 null 리턴  
- `remove()`: head element를 제거하고 리턴  

```
import java.util.LinkedList;
import java.util.Queue;

// queue object 생성 
Queue<Integer> q = new LinkedList<integer>();

q.offer(1); q.offer(2); q.offer(3); // [1,2,3]
q.poll(); // [2,3] q.poll() return 1 
q.peek(); // 2 삭제는 안함 [2,3] 
```

## class PriorityQueue  
- `Queue` interface를 implements, `Queue`의 method 모두 사용 가능  
- Minimum Priority Queue  
	- 디폴트  
	- 언제나 head(가장 앞)에 가장 작은 데이터가 온다   
	- 데이터를 넣을 때 가장 작은 데이터가 head에 있도록 한다  
	- 하지만 head 외에 다른 데이터들이 sorting 되지는 않는다  
	- `import java.util.PriorityQueue;` 필요  
	- object 예시: `PriorityQueue<Integer> pq = new PriorityQueue<Integer>();`  
- Maximum Priority Queue  
	- 언제나 head에 가장 큰 데이터가 있다  
	- object 예시: `PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());`   
	
### Methods in PriorityQueue  
- `add(E e)`: e를 삽입하고 삽입했으면 true 리턴  
- `clear()`: element 모두 삭제  
- `contains(Object o)`: o를 포함하고 있으면 true 리턴  
- `iterator()`: queue의 elements에 대한 Iterator object 리턴  
- `offer(E e)`: e를 삽입, boolean 리턴  
- `remove(Object o)`: o가 있으면 삭제, boolean 리턴  
- `toArray()`: element를 모두 포함하는 array를 리턴  

```
import java.util.*;

PriorityQueue<Integer> q = new PriorityQueue<Integer>();
q.add(4); q.add(7); q.add(2);
System.out.println(q); // [2,7,4]
System.out.println(q.peek()); // 2
remove(); // head=2를 삭제 [4, 7]
System.out.println(q.poll()); // 4를 리턴하고 q에서 4가 삭제됨 [7]
```

# Interface Iterator  
- collection의 data에 접근하는 데 쓰인다  
- iterator 생성: `Iterator itr = collectionObject.iterator();`  

## Methods in Iterator  
- `hasNext()`: 읽어올 요소가 남아있으면 true, 없으면 false 리턴  
- `next()`: 다음 요소를 읽어온다. next()를 호출하기 전 hasNext()로 읽어올 요소가 있는지 확인하는 것이 안전하다.  
- `remove()`: void. next()로 읽어온 요소를 삭제. 반드시 next()를 먼저 호출 후 사용한다  

```
import java.util.ArrayList; 
import java.util.Iterator; 

ArrayList list = new ArrayList(); 
list.add("a"); list.add("b"); list.add("c"); 

Iterator itr = list.iterator();
while(itr.hasNext()){ // 순서대로 출력 a b c
	Object element = itr.next();
	System.out.print(element + " ");
}
```

## ListIterator  
- 앞 뒤 방향 모두 가능하다  
- `hasNext()`: 읽어올 다음 요소가 있는지 확인 / `hasPrevious()` 읽어올 이전 요소가 있는지 확인  
- `next()`: 다음 요소 읽어옴 / `previous()`: 이전 요소 읽어옴  
- `nextIndex()`: 다음 요소의 index 리턴 / `previousIndex()`: 이전 요소의 index 리턴  
- `add(Object o)`: void. o 를 element로 추가  
- `remove()`: next() 또는 previous()로 읽어온 요소를 삭제  
- `set(Object o)`: next() 또는 previous()로 읽어온 요소를 o 로 변경한다  

```
import java.util.*; 

ArrayList list = new ArrayList(); 
list.add("a"); list.add("b"); list.add("c");

ListIterator litr = list.listIterator();

// 앞에서 뒤로, element를 변경 // a+ b+ c+  
while(litr.hasNext()){
	Object element = litr.next();
	lirt.set(element + "+"); 
}

// 뒤에서 앞으로, elemenet 출력 // c+ b+ a+  
while(litr.hasPrevious()){
	Object element = litr.previous();
	System.out.print(element + " ");
}
```

# java.util.Arrays Class 
```
import java.util.Arrays;

int[] arr1 = {1,2};
int[] arr2 = {1,2};
int[] arr3 = {1,2,3};
int[][] arr4 = {{1,2},{2,3}};

//Arrays.toString(array)
System.out.println(arr1.toString()); // object의 toString이 호출된다
System.out.println(Arrays.toString(arr1)); // [1,2]
System.out.println(Arrays.deepToString(arr4)); // [[1,2],[2,3]] // 다차원 배열의 경우    

//Arrays.equals(array1, arra2) 
Arrays.equals(arr1, arr2)); // true 
Arrays.deepEquals(arr1, arr4)); // false // 다차원 배열 비교 

//Arrays.CopyOf(array, int num): num 개수만큼 array 카피해 리턴
//num이 length 초과 시 0으로 채운다  
Arrays.copyOf(arr1, arr.length); // [1,2]
Arrays.copyOf(arr1, 4); // [1,2,0,0]

// copyOfRange(array, int startIndex, int endIndex): startIndex부터 endIndex-1까지 array를 카피해 리턴. endIndex가 length를 초과하면 0으로 채운다  
Arrays.copyOfRange(arr, 0, 1); // [1]

//Arrays.fill(array, element): array를 모두 elemenet로 채운다 
int[] arr = new int[3];
Arrays.fill(arr, 9); // arr = [9,9,9]
Arrays.setAll(arr, ()->(int)(Math.random()*5)+1); // 1부터 6까지 숫자 중 랜덤으로 채움  

// Arrays.asList(object1, object2...): list로 바꿈  
ArrayList<Integer>list = new ArrayList<Integer>(Arrays.asList(1,2,3)); // 1,2,3이 list에 들어간다 
 
//Arrays.sort(array): 정렬
Arrays.sort(arr); 

// Arrays.binarySearch(array, element): element를 찾아 index를 리턴, 없으면 -1 

```
