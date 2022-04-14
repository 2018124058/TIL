# Object(객체)  
- property, method를 갖는다
- method: 함수 정의를 갖고 있는 하나의 property라 볼 수 있음  

## 객체 선언  
1. {} 안에 peroperty, method  
```
let objectName = {property1: value, property2: value, functionName: function(){statement;}}
```
    - 1번 방법이 가독성, 처리속도 더 높음 
2. new 사용 (권장은 x)  
```
let objectNme = new Object(); // Object() 자바스크립트 built-in function  
objectName.property1 = value;
objectName.property2 = value;
```  

