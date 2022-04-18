# Function  
## Function 기초 개념  
- 자바스크립트 modules 중 하나  
- method: 객체가 소유하는, 미리 정의된 함수  
## Function Definition  
```
function functionName(parameterList)
{
    declarations and statements // function body
}
```

### Self-Invoking Function  
- 정의되자마자 즉시 실행(IIFE)  
```
(function(){
    statements;
})();
// 또는 
(function(){
    statements;
}();)
```  
```
// 매개변수 전달 가능  
(function(x){
    return x * 2;
})(4);
```

## Parameter, Argument  
parameters: , 로 구분  
(parameterList) 영역에서 parameter의 default value 설정 가능  
`Function myFunction(x, y=10)`  
### arguments 개수 
1. 파라미터가 함수 선언에서보다 적게 입력됨(missing arguments)  
    - missing values는 `undefined`가 됨  
    - no compile error
2. too many arguments  
    - `arguments` 객체로 access 가능  
    - no compile error  
3. 개수 모름 (indefinite number of args)  
    - 파라미터들이 array가 됨 
    - `function f(arg1, arg2, ...lastArg)` 마지막 파라미터 앞에 ...붙임  
    - array(배열) -> array method(sort, map, pop) 사용 가능 

### arguments (객체)  
- 모든 argument 포함하는 객체  
- `arguments.length` argument 개수 
-  array이기 때문에 index로 접근 가능하다 `arguments[0]`
```
// arguments 중 최댓값 리턴하는 함수  
function Max(){
    let max = -Infinity;
    for (let i = 0; i < arguments.length; i++){ // for(i in arguemnts) 도 같은 의미 
        if(max < arguments[i]){
            max = arguments[i];
        }
    }
    return max; 
}
```


### Passing Parameters  
1. Pass-by-Value  
    - 파라미터의 value를 copy해 전달  
    - original variable is unchanged  
    - function: value를 받고, argument의 주소는 알지 못한다   
    - 함수 내에서 파라미터 값이 바뀌어도 밖에서 반영 x  
2. Pass-by-Reference  
    - objects(ex. array)가 파라미터일 때  
    - 객체의 주소(reference)가 전달된다  
    - original value에 direct access 가능  
    - 함수 내 object 값을 바꾸면 밖에서도 적용, 같이 바뀜 
    - weaken security   

## Arrow Function  
- 간단하게, 이름 없는 함수 표현 가능  
- `function` 생략  
- `return`, `{}`도 생략 가능  
- `arguments` object를 갖지 않음  
- method로 사용하진 않는 것이 좋음   

```
// regular
function hello(){return "hello";}
let hello = function(){return "hello";}

// arrow function
let hello = () => {return "hello";}
let hello = () => "hello";

// arrow function with parameters
let sum = (val1, val2) => val1 + val2;
// arrow function with one parameter: ()도 생략 가능
let sum = val => val + 1; 
```

`document.getElementById("demo").innerHTML = "content";`

## Function and `this`  
`this`
- default: global `window` object 가리킴  
- inside an event handler(callback function): 이벤트를 받는 객체(bound element) 가리킴  
- inside an arrow function: global `window` object 가리킴  


## Javascript Global Functions  
- `decodeURI()` decodes a URI 
- `decodeURIComponent()` decodes a URI component  
- `encodeURI()` encodes a URI 특수문자 몇 개 제외하고 인코딩  
- `encodeURIComponent()` encodes a URI component 전부 인코딩 
- `escape()`, `unescape()` 각각 인코딩/디코딩, 더이상 사용 x  
- `eval()` 문자열을 expression 으로 실행, 사용 권장 x  
- `isFinite()` legal number인지 확인  
- `isNaN()` NaN인지 확인  
- `Number()` number로 형변환  
- `parseInt()`, `parseFloat()` 각각 int/float으로 형변환  
- `String()` string으로 형변환  