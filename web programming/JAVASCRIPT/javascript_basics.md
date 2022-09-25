# 자바스크립트 기초 문법 정리 


## 자바스크립트란?
- 정식 명칭: ECMA Script
- script language의 일종  
    - runtime에 코드가 해석되고 실행된다  
- react, react-native, node.js등에 활용  

## 자료형 (Data Type)  
- Dynamic Typing(동적 타이핑): 변수를 선언x 데이터가 대입되는 시점에 자료형이 결정됨. 변수 타입을 따로 입력x  
- `let`, `var` 사용  

```
// Number type (정수를 포함해 실수 전체)  
let n1 = 12; 
let n2 = 1.2;

// String type 
let s1 = 'hello';
let s2 = "hello";

// Boolean type 
let b1 = true;
let b2 = false;

// Null type: 값이 정의되었으나, 그 값이 null  
let n = null; 

// Undefined type: 변수를 선언만 하고 값을 대입하지 않음. 값이 정의되지 않음. 
let u1;
let u2 = undefined;

// Array type: 배열. js는 다양한 자료형의 변수를 하나의 array에 넣을 수 있다.  
// array는 0부터 시작하는 index를 가짐 
let arr = [1, 2, 3];

// Object type
// js에서의 객체: 키와 값으로 이루어진 쌍의 집합. key는 string, value는 어떤 자료형이든 가능. 
// 객체 안에 객체가 들어갈 수 있다
let obj1 = { a: 'apple', b: 'banana', c: 'carrot'};
let obj2 = {
    a: {a1: 1, a2: 2},
    b: {b1: 3, b2: 4}
}

console.log(obj1['a']) // output: apple
console.log(obj1[0]) // output: apple
console.log(obj2.a.a1) // output: 1
```

## 연산자 (operator)  
- 대입 연산자 (assignment operator): `=`
- 산술 연산자(arithmetic opertor): `+`, `-`, `*`, `/`, `%`(나머지),`**`(지수)  
- 증가 연산자 `++`, 감소 연산자 `--`  
    - postfix 방식: `변수++` 먼저 증감 전의 값을 반환하고, 이후에 증감.  
    - prefix 방식: `++변수` 먼저 변수의 값을 증감하고, 이후 증감된 값의 변수를 반환.  
- 관계 연산자(비교 연산자): `>`, `<`, `<=`,`>=` 
- 동등 연산자: `==`, `!=`  
- 일치 연산자(strict equality operator): `===`, `!==` 값 + 자료형까지 같은지 비교  
- 이진 논리 연산자(binary logical operator): `&&`(and), `||`(or)  
- 조건부 연산자(삼항 연산자 conditional operator, ternary operator): `조건식 ? true일 경우: false일 경우`  
    ```
    leat a = true; 
    let b = false; 
    
    console.log(a ? 1: 2); // output: 1
    console.log(b ? 1: 2); // output: 2

## 함수   
함수 정의  
1. function statement  
```
function sum(a, b){
    return a + b;
}
```
2. arrow functinon expression
```
const sum = (a, b) => {
    return a + b;
}


📒참고: 처음 만난 리액트(인프런)
