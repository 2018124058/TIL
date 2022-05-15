# Chapter10. Recurision  
# 10.1 Recursion Basics  
## Recursive method  
- 자신에 대한 call을 포함하는 method (method that includes a call to itself)  
- problem solving technique of breaking down a task into subtasks  
- subtask가 original task의 smaller version일 때 적용  

```
//예시: 각 자릿수의 숫자를 하나씩 출력하는 method writeVertical  
public static void writeVertical(int n){
	if (n < 10){ //stopping case
		System.out.println(n);
	}
	else{
		writeVertical(n / 10); // recursive call 
		System.out.println(n % 10);
	}
}
// output: n = 123 일 때 1\n 2\n 3\n이 출력 
```
## Subtasks  
두 종류의 subtask  
1. smaller version of the original task  
- recursive call 시행  
- 예시에서는 `writeVertical(n/10);`  
2. stopping(simple) case  
- infinite recursion을 방지  
- 예시에서는 `n < 10`의 statement  
	- stopping case가 없었따면, `writeVertical(0)`이 무한히 반복되게 된다  
	
## Stacks for Recursion  
- recursion을 keep track하기 위해 대체로 stack이라는 data structure를 사용한다  
- stack  
	- memory structure의 한 종류  
	- 종이를 쌓아두는 것처럼, 새로운 종이는 맨 위에 놓이고, 빼낼 때는 맨 위의 종이를 먼저 빼낸다  
	- = LIFO(Last In First Out)  
	- ![stack 그림](stackForRecursion.JPG)  

## Recursion vs Iteration  
- recursion: 반드시 이용해야하는 것x. non-recursive version, 즉 iterative version(반복 활용)으로도 문제를 해결할 수 있다  
- recursion vs iteration  
	- recursion이 더 simple하지만 느리다  
	- recursion은 storage를 더 많이 쓴다(stack을 유지하는 데 부담이 큼)  
	- 알고리즘을 풀 때는 recursion이 이해하기 쉽지만, 실제 활용하는 프로그램을 만들 때는 iteration을 이용하는 것이 더 효율적이다  
	
### Iterative Version of writeVertical   
```
public static void writeVertical(int n){
	int nsTens = 1;
	int leftEndPiece = n;
	while (leftEndPiece > 9){
		leftEndPiece = leftEndPiece / 10;
		nsTens = nsTens * 10;
	}
	//nsTens는 자릿수만큼 10을 제곱한 것 (ex. 2312라면 nsTens는 1000) 
	
 	for (int powerOf10 = nsTens; powerOf10 > 0; powerOf10 = powerOf10 / 10){
 		System.out.println(n / powerOf10);
 		n = n % powerOf10;
 	}
 }
```

  

 
