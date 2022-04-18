# Array  
## Array definition  
`let arrayName = [element1, element2, element3]; // 보편적 방법`  
`let arrayName = new Array(element1, element2, element3); // 권장x`  
- 첫 번째 방법(initializer list)이 심플, 가독성 좋음, 실행 속도 빠름  
- array elements는 0부터 index를 갖는다  
- array name으로 full array에 접근 가능
    ```
    let colors = [red, yellow, orange];
    document.getElementById("demo").innerHTML = colors; // red, yellow, orange 가 들어감
    ```  
- array는 object에 속한다  
    - `length` property를 가짐  

### Allocating Array  
`new`
- allocate memory for objects  
- `let a = new Array(12);` 12개의 undefined elements를 가진 array 생성  
- allocate o, element initialization x -> default value is undefined 
- 몇개만 initialize 해도 된다 `let a = [1,2, ,3,4]; // a.length = 5 a[2] = undefined`  

## for + in/of + array  
array element에 대해 반복 
- for...in + array 
    - element index에 대해 각각 반복  
    - undefined element(non-existnent element)는 무시  
- for...of + array  
    - element value에 대해 각각 반복  
    - undefined element 무시x 

## Array Methods  
### toString  
- `arrayName.toString()`  
- array를 문자열로 변환  
- ,로 구분된 values들을 리턴  
- arrayName만 써도 자동으로 toString()이 호출, 실행된다  

### join  
- `arrayName.join("separator")` 
- array elements를 담은 string 리턴  
- toString과 비슷하나 구분자 지정 가능  
 
### pop & push  
- 스택연산: 마지막 element를 빼거나(pop) 집어넣기 (push)  
- pop  
    - `arrayName.pop()`  
    - array의 마지막 element를 뺀다 (undefined로 남기지 않고 아예 빼버림, length 변화) 
    - 마지막 element의 value를 리턴  
- push  
    - `arrayName.push(val)`  
    - array의 마지막에 새로운 element를 넣는다  
    - array의 길이(기존에서 +1됨) 리턴  

### shift & unshift  
- 첫 번째 element를 빼거나(shift) 집어넣기(unshift)  
- shift  
    - `arrayName.shift()`  
    - array의 첫번째 element를 제거한다  (undefined로 남기지 않고 아예 빼버림, length 변화) 
    - 남은 element의 위치가 한 칸씩 앞으로 당겨짐 (index -= 1)  
    - 제거된 element를 리턴한다  
- unshift  
    - `arrayName.unshift(val)`  
    - array의 첫번째 자리에 새로운 element를 추가한다  
    - 기존 element의 위치가 한 칸씩 뒤로 밀려남 (index += 1)  
    - array의 length(기존에서 +1됨) 리턴  

### splice  
- `arrayName.splice(position, length, add1, add2...)`  
- 임의의 위치에 element 추가  
- position: element를 추가할 위치  
- length: 기존의 element를 몇개 제거할 것인지 (position 위치 element부터 제거)  
- add1, add2...: 추가할 element, 개수 제한x  
- 삭제된 elements의 array를 리턴한다  

### slice  
- `arrayName.slice(startIndex, endIndex)`  
- 기존의 array의 부분을 떼어와 새로운 array를 리턴  
- 기존의 array는 변화하지 않는다  
- startIndex: 자르기 시작할 부분  
- endIndex: endIndex-1까지 new array에 포함된다  
    - optional. endIndex가 없으면 끝까지 new array에 포함된다  

### concat  
- `array1.concat(array2,array2...)`  
- 여러개의 array를 병합하여 새로운 array를 리턴한다  
- array 개수 제한 x  

### sort & reverse  
- sort  
    - `arrayName.sort()` or optionally `arrayName.sort(function)`  
    - array elements를 알파벳 순으로 정렬한다 (value를 문자열 취급)  
    - arg로 function을 포함할 수 있다  
    - element value를 숫자로서 정렬하고 싶을 때
        `array.sort(function(a,b){return (a-b);});`
- reverse  
    - `arrayName.reverse()`  
    - 역방향 정렬  

## Array Methods 2 - Array Iteration Method  
- `arr.forEach(functionName)` 각각의 element에 대해 한 번씩 함수를 호출  
- `arr.map(functionName)` 각각의 element에 대해 함수를 호출, 모두 실행한 결과값을 새로운 array로 리턴  
- `arr.filter(functionName)` 각각의 element에 대해 function의 조건을 만족하는지 테스트, 만족하는 것만 모아 새로운 array로 리턴  
- `arr.reduce(functionName)` 각각의 element(왼쪽부터)에 함수 실행해 하나의 value를 리턴  
    - `arr.reducceRight(functionName)` reduce와 달리 element를 오른쪽부터  
- `arr.every(functionName)` 모든 element가 조건을 만족하면 true, 아니면 false 리턴  
- `arr.some(functionName)` element 중 하나 이상 조건을 만족하면 true, 모두 불만족이면 false  
- `arr.indexOf(value, startIndex)` 특정 value를 갖는 element의 index를 리턴  
    - startIndex: optional. 어디서부터 탐색을 시작할지 지정  
    - `arr.lastIndexOf(value)` 끝에서부터 탐색  
- `arr.find(functionName)` 조건을 만족하는 첫 번째 element의 value를 리턴  
- `arr.findIndex(functionName)` 조건을 만족하는 첫 번째 element의 index를 리턴  


## Multidimensional Arrays (다차원 배열)  
### 2차원 배열  
```
let array = [[1,2], [3,4,5]];
```  
```
// new operator 
let array = new Array(2); // 2개의 row
array[0] = new Array(2); // 첫번째 row는 2개의 column을 가짐
array[1] = new Array(3); 
````  
- table과 같다: row, column 가짐  
