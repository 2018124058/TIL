# chpt3. Flow of Control 
## Branching Mechanism 
### if, else ��  
���๮(statement)�� �ϳ��� �� (��� �ʿ�x)  
else part�� ���� �����ϴ� (omit)  

```
if (����)
	statement;
else
	statement;
```
���๮(statement)�� �������� ��  

```
if (����)
{statements;}
else
{statements;}
```

nested statements(��ø �����ϴ�)  
����� Ŀ����?

```
if(i<15)
{
	System.out.println("i�� 15���� �۴�");
	if (i<12)
		System.out.println("i�� 12���� �۴�");
	else
		System.out.println("i�� 12,13,14 �� �ϳ���");
}
```

multiway if-else statement: else if 

```
if (Boolean Expression)
	statement_1
else if (Boolean Expression)
	statement_2
...
else
	statement for all other possibilities
```
The Conditonal Operator  
- ������ ���̽��� �� Ȱ�� ���� 

```
if (x>y)
  int s = 1;
if (x<y)
  int s = 0;
```
�̰� `int s = (x>y) ? 1 : -1;`�� ǥ�� �����ϴ� 
- ?�� ���ǹ� ������ ��, :�� �������� ������ �� 

### the Switch Statement  
- case�� ���� ����� break  
- default: ��� ���̽��� �ƴ� ��  
- break�� ������ ���� ���̽����� �����  
-  controlling expression�� ��: char, int, short, byte, String  
-  ������ condition �����ϱ� ����� 
-  default�� ��� �� 
  

```
switch(Controlling Expression)
{
 case Case_Label_1:
 	statement_sqeuence_1
 	break;
 case Case_Label_2:
 	statement_sequqence_2
 	break;
 ...
 default:
 	default_statement_sequence
 	break;
 }
 ```
## Boolean Expression
boolean expression value ` true or false `  
boolean operators ` and && or || not ! `
-  short circuit evalution
    - `&&` ���� false�� ���� ���� �������� �ʴ´�(true,false �Ǵ�x. evaluationx)  
    - `||` ���� true�� ���� ���� �������� �ʴ´�
    
comparison operators `== != > >= < <=`  
precedence and associativity rules
 -  ��ȣ ���� ���� �� �켱����: unary -> binary
 -  associativity: ������ ���� ��� ����  
 -  �������� ���� ��ȣ�� ����ϱ�  

Evaluating Expressions
 - binding: operand�� � �͵����� �ľ��Ѵ� ��. (precedence�� associativity ���).������ �ϱ����� operation�� ������ operands�� ã�� ���� (associate) ��Ű�� ����
    -     operator�� �ۿ��ϴ� �� = operand
 - side effects: expression�� ����� �� ������� return�ϴ� ���� ����, �̿��� �ٸ� ȿ���� side effects�� �� 
    -  ex. value ���� assign�ϰų� �ٲٴ� �� 
           `y = 5; x = y+3` 8�� ����, x���� �Ҵ�� ���� side effects

### String�� ��  

strings ` ==  `
- same value�� �����ִ���(���� ��) x
- same memory location (���� �ּ�, ���� reference����)�� �����ִ��� �׽�Ʈ
- literal: �ڹٰ� �޸��� �� ������ ���̺� �� -> ���� ������ ����Ű�� ������ == true 
 
 ```
 String str1 = "somsom";
 String str2 = str1; 
 String str3 = "somsom"; //�̸� ������ somsom ������ ����Ű�� ��
 String str4 = new String("somsom"); 
 //value�� ������, new�� ���ο� object somsom�� �����߱� ������ �ٸ� �ּҸ� ���� 
 str1 == str2 == str3; //true
 str1 == str4;         //false
 ```
 
strings�� value(contents)�� ���ϰ� �ʹٸ� equals, equalsIgnoreCase Methods(��ҹ��� ����x) ���  

lexicographic order for string
- ������ �迭: �빮��>�ҹ���>����(���������� ��)
- �񱳴��(string2)�� �����̸� ���, �����̸� ����, ������ 0 
- ������ ���밪�� �߿����� ����(�ڹ� implementation�� ���� �ٸ��� ���� �� ����)  
- method: string1.compareTo(string2) 
          string1.compareToIgnoreCase(string2) : ��ҹ��� ����

```
string entry = 'adventure123';
System.out.println(entry.compareTo("zoo"); //����
```

##Loops(�ݺ���)
###while
���ǹ��� true�� ������ statement ���� ->�ٽ� ���ǹ��� �ö� �׽�Ʈ�� true�� ������ ����...�ݺ��ϴٰ� ���ǹ��� false�� �Ǹ� ����x �������´�

```
while (Boolean_Expression)
	Statement
```
```
//statement�� ���� ���� �� 
while (Boolean_Expression)
{ 
  Statement_1
  Statement_2
  ...
 }
 ```
### do-while  
 do�� ������ ó������ �ƹ� ���Ǿ��� statement ����->while ���ǹ� �׽�Ʈ, true �� �ö� statement ����...�ݺ��ϴٰ� ���ǹ��� false�� �Ǹ� ��������  
 - do-while�� ���ǹ��� boolean���� ������� �켱 statement�� �� �� �����Ѵٴ� ������ while���� ������! 

 ```
do
	Statement
while (Boolean_Expression);
```
```
//Statement�� ���� ���� �� 
do
{
  Statement_1
  Statement_2
  ...
 } while (Boolean_Expression); //�����ݷ� ����!
```
###for
ó�� ���� �� initialization ����(���� ����x)-> ���ǹ� test ->true �� body ����, update->�ٽ� ���ǹ� test...�ݺ� -> ���ǹ� false�� body ���� ���ϰ� �������� 
 
```
for (Initialization; Boolean_Expression; Update) //update�� �����ݷ��� ����...!
	Body
```
for -> while
 -  Initialization�� while�� �ۼ� ����
 -  ���ǹ��� �״�� while (Boolean_Expression)
 -  Body �� ���� update ����  

Nested Loops �ݺ��� ��ø 
 -  inner loop ��ü�� outloop �ݺ� 1ȸ���� �ݺ��ȴ� 

 
###�������  
####break  
break ������ ������Ű��, �ڽ��� �����ϴ� ���� ����� loop�� �������´�(��ü loop���� Ż��x) 

```
while (Boolean_Expression){
	//codes
	if (condition to break){
		break;  //while������ ��������
	}
	//codes
}
```
```
do{
	//codes
	if (condition to break){
		break; //while������ ��������
	}
	//codes
}
while(Boolean_Expression);
```
####continue  
�ݺ����� ���������� ������ continue ������ ������Ű�� �� �ڿ� �ִ� �ڵ带 �������� �ʰ� �� ó������ �ٽ� �ö� �ݺ��� ������ 

```
while (Boolean_expression){
	//codes
	if (condition to continue){
		continue;
	}
	//codes: continue �� ���� �ȵǰ� while�� �ö�
}
```
####exit  
`System.exit(0);`
System class�� exit method: �ƿ� ���α׷��� ��������
- ���������� 0�� ���α׷��� ���������� �������� ��Ÿ��  

##Debugging  
debugging; ���α׷��ֿ��� ������ ã�� ��ħ 

debugging techniques
>-  ���α׷� ��ü�� ���캸��: Ư�� �κп� ������ �ִٰ� �̸� ����x
>-  �������� test case�� �õ��ϰ� input value ���캸�� 
>-  ���α׷��� �ܼ�ȭ�Ͽ�(comment out) �κ��� ���캸�� 
>-  check common pitfall
>-  ��� ���� �ٽ� ���캸��
>-  NO RANDOM CHANGE! �ƹ� �ٰ� ���� �ѹ� �ٲ㺸�� �ʱ�. �ϳ��ϳ� �������� 

preventive coding
>- Incremental Development: ���ݾ� �ڵ��ϰ� �������ؼ� �����غ���. �ܰ�������!
>- Code review: �ٸ� ����� ���� �ϱ� 
>- pair programming: �� ����� Ÿ���� �� �� �ٸ� ����� ���Ѻ���, ���� �ٲٱ�

Debugging in Eclipse
- breaking points ����: �� �� ���� ���� ����Ŭ��. ���� �� ���� ����
- debugging ��ư ������ ����
- perspective switch: ����� �޴�â ������. (name, value)
- step over: same level�� ���� �ٷ� �Ѿ
- step into: lower level�� method�� �̵�
- step return: upper level, �� �ܰ� ���� �ٽ� �ö�
- resume: ���� breaking point���� �� ����
- terminate: stop debugging

##Random Number  
pseudorandom number
 - ���� ���� ��������, �����δ� seed value�� ���� initialize�� sequence of random numbers�� �̹� ���� �ִ�
 - seed value�� ������ �׻� ���� ������� random number�� ���´�

random object: Random class�� import�ϴ� ��� 
 - �� �������� �ʴ´�

 ```
 import java.util.Random;
 
 Random randomGenerator = new Random(); //object ����
 // ��� int ���� �� int
 int a = randomGenerator.nextInt(); 
 // 0���� (n-1)������ ���� �� int
 a = randomGenerator.nextInt(n);
 // ��� double ���� �� double
 double b = randomGenerator.nextDouble();
 ```
 
 Math.random() method �̿��ϱ� 
 - lang�� Math class�� �̹� �־ ���� import x
 
 - `Math.random()` 0.0<= num < 1.0 �� random double return ->�̰� �����ϱ� 
 
 ```
 0.0 <= (Math.random() * 6) < 6.0
 0 <= (int)(Math.random()*6) <= 5
 0 <= (int)(Math.random()*6) + 1 <= 6 // �ֻ���!
 ```
 