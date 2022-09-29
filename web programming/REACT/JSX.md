
# JSX란  
- js: JavaScript  
- JSX: A syntax extension to JavaScript  
    - 자바스크립트의 확장 문법  
- JSX: JavaScript + XML / HTML  
    - X는 syntax 또는 XML의 약자  
- 코드 예시  

```
const element = <h1>hello</h1>;
```
## JSX의 역할  
- 내부적으로 XML,HTML 코드를 자바스크립트 코드로 변환하는 과정을 거침  
- 리액트에서 JS만도 사용 가능. JSX가 필수는 아님
- 하지만 JSX 가 생산성, 가독성이 높다  
    - 간결한 코드  
        - EX. JSX `<div>Hello, {name}</div>`  
        - JS `React.createElement('div', null, `hello, ${name}`);` 
    - 가독성 향상 -> 버그 발견이 쉬움. 유지 보수 용이.  
    - injection attacks라는 해킹 방법을 방어하여 보안성 올라감  
        - 입력창에 소스코드를 입력하는 것   

- 예시1  
```
// JSX 사용 
class Hello extends React.Component{
    render(){
        return <div>Hello {this.props.toWhat}</div>;
    }
}

// 렌더링  
ReactDOM.render(
    <Hello toWhat="World"/>,
    document.getElementById('root')
);
```

```
// JSX 미사용(js만 사용)  
// React.createElement 함수가 필요 
class Hello extends React.Component{
    render(){
        return React.createElement('div', null, `Hello ${this.props.toWhat}`);
    }
}

ReactDOM.render(
    React.createElement(Hello, {toWhat: 'World' }, null),
    document.getElementById('root')
);
```

- 예시2  
```
// JSX 사용  
const element = (
    <h1 className = "greeting">
        Hello, world!
    </h1>
)
```

```
// JSX 미사용  
const element = React.createElement(
    'h1',
    { className: 'greeting' },
    'Hello, world!'
) 
```  

```
// React.createElement()의 결과로 생성되는 객체= React element  
const element = {
    type: 'h1',
    props: {
        className: 'greeting',
        children: 'Hello, world!'
    }
}
```
## React.createElement  
파라미터
```
React.createElement(
    type,
    [props],
    [...children]
)
```
- type: element의 유형 ex. div, component  
- props: 속성  
- children: element가 포함하는 자식 element 

# JSX 사용법  
- 우선 파일이 .js가 아닌 .jsx 형식이어야 한다  

### XML/HTML 문법을 사용하다 JS 코드를 사용할 때는 이를 `{}`안에 넣어준다   
```
// name이라는 js 변수 참조  
const element = <h1>안녕, {name}</h1>;  

//js의 함수 호출  
<h1> Hello, {formatUser(user)} </h1>
``` 
### 태그의 속성(attribute)에 값을 넣는 방법  
```
// 큰 따옴표 사이에 문자열 넣기  
const element = <div tabIndex="0"></div>;

// 또는 중괄호 사이에 js코드 넣기 
const element = <img src={user.avatarUrl}></img>;
```  
### 자식(children) element 정의  
```
const element = (
    <div>
        <h1>hello</h1>
    </div>
);
```

### jsx 파일에서 만든 component를 렌더링하기  
- jsx 파일 내 코드 삽입  
```
import React from "react";
//code 
export default componentName;
```

- index.js에 코드 삽입  
    - import문으로 jsx 파일에서 만든 component를 가져온 뒤에, root dom node에 렌더링  
```
import componentName from './jsx파일경로';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <componentName /> // 추가  
    <App />
  </React.StrictMode>
);
```



📒참고: 처음 만난 리액트(인프런)