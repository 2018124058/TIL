# Chapter9. Exception Handling  
# 9.1 Exception Handling Basics  
## Error vs Exception(예외)  
Error 
- 프로그램 코드로 handle 될 수 없는 serious error
- 종류: compile-time error, run-time error, logic error  

Exception  
- 프로그램 코드로 handle 될 수 있는 minor error  
- 주로 execution time에 발생  

Exception Handling(예외처리)  
- 발생할 수 있는 예외를 핸들링하는 코드 작성

Throwing Exception  
- exception의 발생, 발생됐다는 시그널을 주는 것  

## try-catch-final  
- throwing and handling exception은 try-catch mechanism에 의해 실행된다  

```
try { //exception을 발생시킬 수 있는 statements
}
catch(Exception1 e1){//Exception1이 발생했을 때 handle하는 statements
}
catch(Exception2 e2){//Exception2이 발생했을 때 handle하는 statements
}
...
catch(ExceptionN eN){ExceptionN이 발생했을 때 handle하는 statements
}
final { //exception 발생 여부와 관계없이 실행할 statements
}
```
### flow in try-catch block  
1. try block 내 exception이 발생한 경우  
	- try block 내에서 exception이 발생한 곳 이후의 statement(try block 내부)는 실행되지 않는다  
	- 발생한 exception에 맞는 첫번째 catch block을 찾아 실행 (handle exception)
		- catch block의 탐색은 앞에서부터 이루어진다   
		- 따라서 `catch` block의 순서는 구체적인 exception일수록 앞에 배치해야한다  
		- Exception class의 exception은 가장 마지막에 배치 (첫번쨰에 배치하면 모든 exception이 여기서 handle 된다) 
	- final block이 있다면 실행  
	- try-catch block를 빠져나간다  
2. try block 내 exception이 발생하지 않은 경우   
	- try block을 모두 실행하고 catch block은 넘어간다  
	- final block이 있다면 실행  
	- try-catch block을 빠져나간다  

## Exception Classes  
![exception classes](/ExceptionClasses.jpg)

Exception도 하나의 class이다  
- ancestor class로 Object - Throwable class 가 있다  
- Exception class는 모든 exception classes의 ancestor이다  
- throw만 하고 catch(handling)를 안하면 compile error 발생  
	
```
	class ExceptionTest{
		public static void main(String args[]){
			throw new Exception(); // Exception class의 object를 생성해 exception 강제 발생
			}} //compile error 발생 
```
### Exception Class Method  
- ` Exception e = new Exception("message");` Exception class object 생성  
- `e.getMessage()` constructor에서 주어진 message를 리턴  
- `e.printStackTrace()` 현재 프로그램의 스택 상태를 보여준다(exception이 몇번째 줄, 어떤 method에서 발생했는지 등의 정보)

### Exception class 종류  
 Exception class는 크게 두 종류의 하위 클래스로 나뉜다  
	- 1. RuntimeException  
	- 2. 그외의 exception classes  

1. RuntimeException  
- 주로 프로그래머의 잘못으로 발생한다  
- exception handling이 없더라도 compile error는 발생하지 않는다  
- 그러나 프로그램 실행 중 발생한 exception에 대한 handling이 없으면 program crash(충돌-기능 멈춤)  
- 종류(RuntimeException의 자식 클래스)  
	- Arithmetic Exception: ex. 0으로 나눌 때   
	- ClassCastException
	- NullPointerException  
	- IndexOutOfBounds Exception: index 범위를 넘은 index로 접근할 때 
	- 그외  
2. RuntimeException 외의 Exception derived class  
- 주로 외부적 요인에 의해 발생한다  
- exception handling이 없으면 compile error가 발생한다  
- 종류 (Exception class의 자식 클래스)  
	- IOException  
	- ClassNotFoundException  
	- 

### InputMismatchException  
- `import java.util.InputMismatchException;` import 필요  
- input이 제대로된 타입으로 들어왔는지 확인한다 ex. nextInt()인데 다른 타입이 들어오면 exception 발생  
- InputMismatchException이 일어난 경우 input buffer에는 아직 "\n" 이 남아 있다

```
import java.util.Scanner;
import java.util.InputMismatchException;

public class InputMismatchExceptionDemo{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		boolean done = false;
		while (!done){  // 알맞은 타입의 input이 들어올 때까지 반복 
			try{
				number = keyboad.nextInt();
				done = true;} // 예외가 발생했을 경우 이 statement는 실행되지 않는다 
			catch(InputMismatchException e){
				keyboard.nextLine(); //new line 걷어내기  
				System.out.println("wrong input, try again"}
		}}}
```

### NegativeNumberException  
- import 필요 x 

```
Scanner keyboard = new Scanner(System.in);
int pencils = keyboard.nextInt(); // 연필 개수
if (pencils<0) throw new NegativeNumberException("pencils"); // 개수가 음수일시 예외 발생 
```

###NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException
https://docs.oracle.com/javase/7/docs/api/


### 직접 Exception Class를 정의하기  
- Exception의 derived class로  
- `super("message")`를 constructor에서 활용  
- instance variable을 가질 수 있다   

```
public class DivisionByZeroException extends Exception{
	// default constructor
	public DivisionByZeroException() {super("Division by 0");}
	//constructor with parameter
	public DivisionByZeroException(String message) {super(message);}
```
	- 예시에서 exception 발생시키기 `throw new DivisionByZeroException();` 
	- 활용: 소스코드 Chpt9_2DefiningException 확인 
	

### Intentionally Throwing an Exception  
의도적으로 exception을 발생시키기   
- Exception class의 object 생성 -> `throw`  


