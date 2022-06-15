# Chapter9. Exception Handling  
# 9.1 Exception Handling Basics  
## Error vs Exception(����)  
Error 
- ���α׷� �ڵ�� handle �� �� ���� serious error
- ����: compile-time error, run-time error, logic error  

Exception  
- ���α׷� �ڵ�� handle �� �� �ִ� minor error  
- �ַ� execution time�� �߻�  

Exception Handling(����ó��)  
- �߻��� �� �ִ� ���ܸ� �ڵ鸵�ϴ� �ڵ� �ۼ�

Throwing Exception  
- exception�� �߻�, �߻��ƴٴ� �ñ׳��� �ִ� ��  

## try-catch-finally  
- throwing and handling exception�� try-catch mechanism�� ���� ����ȴ�  

```
try { //exception�� �߻���ų �� �ִ� statements
}
catch(Exception1 e1){//Exception1�� �߻����� �� handle�ϴ� statements
}
catch(Exception2 e2){//Exception2�� �߻����� �� handle�ϴ� statements
}
...
catch(ExceptionN eN){ExceptionN�� �߻����� �� handle�ϴ� statements
}
finally { //exception �߻� ���ο� ������� �׻� ������ statements
}
```
- ����: �ҽ��ڵ� Chpt9_1ExceptionHandling  
- catch block ������ exception�� rethrow�� �� �ִ�  

### flow in try-catch block  
1. try block �� exception�� �߻��� ���  
	- try block ������ exception�� �߻��� �� ������ statement(try block ����)�� ������� �ʴ´�  
	- �߻��� exception�� �´� ù��° catch block�� ã�� ���� (handle exception)
		- catch block�� Ž���� �տ������� �̷������   
		- ���� `catch` block�� ������ ��ü���� exception�ϼ��� �տ� ��ġ�ؾ��Ѵ�  
		- Exception class�� exception�� ���� �������� ��ġ (ù������ ��ġ�ϸ� ��� exception�� ���⼭ handle �ȴ�) 
	- final block�� �ִٸ� ����  
	- try-catch block�� ����������  
2. try block �� exception�� �߻����� ���� ���   
	- try block�� ��� �����ϰ� catch block�� �Ѿ��  
	- final block�� �ִٸ� ����  
	- try-catch block�� ����������  
	
### finally block  
- try-catch ���� optional  
- try�� catch block�ȿ� return�� �־ return ���� finally block�� ����ȴ�  
  
### Exception Controlled Loop  
```
boolean done = false;

while(!done){
	try{
		//exception�� throw�ϴ� �ڵ� 
		done = true; // exception�� �߻����� ���� �� ����� 
	}
	catch(Exception e){
		//code
	}
}
```
- exception�� �߻����� ���� ������(done�� true�� �� ������) �ݺ��ȴ�  

## Exception Classes  
![exception classes](/ExceptionClasses.jpg)

Exception�� �ϳ��� class�̴�  
- ancestor class�� Object - Throwable class �� �ִ�  
- Exception class�� ��� exception classes�� ancestor�̴�  
- throw�� �ϰ� catch(handling)�� ���ϸ� compile error �߻�  
	
```
	class ExceptionTest{
		public static void main(String args[]){
			throw new Exception(); // Exception class�� object�� ������ exception ���� �߻�
			}} //compile error �߻� 
```
### Exception Class Method  
- ` Exception e = new Exception("message");` Exception class object ����  
- `e.getMessage()` constructor���� �־��� message�� ����  
- `e.printStackTrace()` ���� ���α׷��� ���� ���¸� �����ش�(exception�� ���° ��, � method���� �߻��ߴ��� ���� ����)

### Exception class ����  
 Exception class�� ũ�� �� ������ ���� Ŭ������ ������  
	- 1. RuntimeException  
	- 2. �׿��� exception classes  

1. RuntimeException  
- �ַ� ���α׷����� �߸����� �߻��Ѵ�  
- exception handling�� ������ compile error�� �߻����� �ʴ´�  
- �׷��� ���α׷� ���� �� �߻��� exception�� ���� handling�� ������ program crash(�浹-��� ����)  
- ����(RuntimeException�� �ڽ� Ŭ����)  
	- Arithmetic Exception: ex. 0���� ���� ��   
	- ClassCastException
	- NullPointerException  
	- IndexOutOfBounds Exception: index ������ ���� index�� ������ �� 
	- �׿�  
2. RuntimeException ���� Exception derived class  
- �ַ� �ܺ��� ���ο� ���� �߻��Ѵ�  
- exception handling�� ������ compile error�� �߻��Ѵ�  
- ���� (Exception class�� �ڽ� Ŭ����)  
	- IOException  
	- ClassNotFoundException  
	- 

### InputMismatchException  
- `import java.util.InputMismatchException;` import �ʿ�  
- input�� ����ε� Ÿ������ ���Դ��� Ȯ���Ѵ� ex. nextInt()�ε� �ٸ� Ÿ���� ������ exception �߻�  
- InputMismatchException�� �Ͼ ��� input buffer���� ���� "\n" �� ���� �ִ�

```
import java.util.Scanner;
import java.util.InputMismatchException;

public class InputMismatchExceptionDemo{
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		boolean done = false;
		while (!done){  // �˸��� Ÿ���� input�� ���� ������ �ݺ� 
			try{
				number = keyboad.nextInt();
				done = true;} // ���ܰ� �߻����� ��� �� statement�� ������� �ʴ´� 
			catch(InputMismatchException e){
				keyboard.nextLine(); //new line �Ⱦ��  
				System.out.println("wrong input, try again"}
		}}}
```

### NegativeNumberException  
- import �ʿ� x 

```
Scanner keyboard = new Scanner(System.in);
int pencils = keyboard.nextInt(); // ���� ����
if (pencils<0) throw new NegativeNumberException("pencils"); // ������ �����Ͻ� ���� �߻� 
```

###NullPointerException, ArrayIndexOutOfBoundsException, NumberFormatException
https://docs.oracle.com/javase/7/docs/api/


### ���� Exception Class�� �����ϱ�  
- Exception�� derived class��  
- `super("message")`�� constructor���� Ȱ��  
- instance variable�� ���� �� �ִ�   

```
public class DivisionByZeroException extends Exception{
	// default constructor
	public DivisionByZeroException() {super("Division by 0");}
	//constructor with parameter
	public DivisionByZeroException(String message) {super(message);}
```
	- ���ÿ��� exception �߻���Ű�� `throw new DivisionByZeroException();` 
	- Ȱ��: �ҽ��ڵ� Chpt9_2DefiningException Ȯ�� 
	

### Intentionally Throwing an Exception  
�ǵ������� exception�� �߻���Ű��   
- Exception class�� object ���� -> `throw object` 

```
try{ 
	Exception e = new Exception("My Exception");
	throw e;
	// �Ǵ� throw new Exception("my exception"); 
	}
catch(Exception e){
	System.out.println(e.getMessage());
```

# 9.2 Exception in Methods  
## `throws`  
- method �� exception�� throw �ϳ�, catch(handle) ������ �ʴ� ���  
- method �� try-catch block�� ����  
- method heading�� `throws`�� ���δ�    
- <->  `throws` �� ���� ���� �ٸ� method�� exception�� throw�� �� catch �Ѵ�  

```
// example  
void method1() throws Exception{throw new Exception();}
void method2() throws myException{
	throw new MyException("���� ������ exception class");
}
// Ʋ�� ����  
void method3(){throw new Exception();} // syntax error �߻�  
```
- �ҽ��ڵ� Chpt9_3ThrowsMethod 

## Exception Handling and Event Driven Programming  
Exception handling�� event-driven programming�� �����̴�  
- object�� �ٸ� object�� event�� ���� �̸� handle�ϰ� ��  
- event�� ������ ���� firing an event�� �θ��� 
- �̺�Ʈ ��ü�� �ϳ��� object��  
	- exception handling���� �̺�Ʈ�� Exception class�� object  

```
public static void main(String[] args){
	try{method1();} // method1�� main���� exception�� transfer 
	catch(Exception e){ // main���� exception handling 
		System.out.println("Exception handling in main");
	}
	
static void method1() throws Exception{throw new Excepton();}
```
 


