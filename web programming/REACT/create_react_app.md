# 기존 웹사이트에 리액트 적용하기  
html에 `<scipt>`로 리액트 적용  
```
<body>
    <div id ="root"></div> <!--DOM container(Root DOM Node)-->
    
    <!--리액트 가져오기-->
    <script src="https://unpkg.com/react@17/umd/react.development.js" crossorigin></script>
    <script src="https://unpkg.com/react-dom@17/umd/react-dom.development.js" crossorigin></script>

    <!--리액트 컴포넌트 가져오기-->
    <script src="MyButton.js"></script>
</body>
```
# create-react-app  
- 리액트가 적용되어있는 상태로 개발 시작하기  
- 리액트로 웹을 개발하는 데 필요한 설정들을 담아 프로젝트를 생성함  
- node.js(v14.0.0 이상), npm(v6.14.0 이상) 필요  

## npx 명령어 
- npx: excute npm package binaries  
- 터미널에 명령어 입력 
<hr>

- 리액트 앱 생성 
```
npx create-react-app <project-name>
# 예시  
npx create-react-app my-app 
```
- 경로 변경 (change directory)  `cd my-app`  
- 애플리케이션 실행 `npm start`  


📒참고: 처음 만난 리액트(인프런)