# Bootstrap  
https://getbootstrap.com/  

- 자주 쓰이는 css 코드를 가져올 수 있다  
- bootstrap 코드가 인식되도록 설정을 해주어야 한다 
    - 방법 1. Bootstrap 관련 코드를 직접 다운 받아 설치하기 
    - 방법 2. CDN 이용하기  
        - 다운로드 없이 네트워크상으로 실시간으로 가져옴  
        - head에 `<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">`

- bootstrap 의 layout: 정렬 지원  
    - elements를 container에 담기 `<div class="container">`
    - grid: bootstrap은 기본적으로 화면을 12등분해 정렬  
        - `<div class="col-4">`면 4칸을 차지한다  
        - `<div class="col">`이면 개수 맞춰 똑같이 분배  
- theme: 완성된 페이지 템플릿 제공(free bootstrap template 검색)  
    - https://bootstrapmade.com/   
    - 라이센스 정책(사용 가능 범위)을 꼭 읽어보기  


## 다운로드 방식
- static 파일을 직접 관리하는 것을 더 추천 (안전성)  
1. Bootstrap 코드를 다운받은 후 css, js 폴더를 프로젝트의 staic 폴더에 옮긴다  
2. html 에서 `{% load static %}`로 로드  
3. 원하는 css의 파일 명을 복사해, `<link rel="stylesheet" type= "text/css" href="{% static 'css/bootstrap.min.css' %}">`  
    js 파일의 경우 `<script src="{% static 'js/bootstrap.min.js' %}">`   
4. bootstrap에서 원하는 코드 복사해 붙이기  
+ bootstrap template을 이용하는 경우, 이미지, css, javascript 등 static 파일들의 경로를 모두 템플릿 언어로 알맞게 변환시켜야 한다  

## CDN 방식  
Bootstrap-Docs에서 CDN 링크를 복사해 link 태그에 넣기   
- `<link rel="stylesheet" type= "text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css">`
