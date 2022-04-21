
# HTML 기초
`<!--주석,여러줄 가능-->`

html/css
- 접근성이 좋음 
- 문서를 만든다는 접근 
- 다른 언어와 쉽게 섞일 수 있음 

##
웹페이지 구조화: html
웹페이지 디자인: css
동적인 웹페이지 생성 javascript, dom
웹서비스 활용 json, ajax 
웹서비스 생성 node.js, express
데이터베이스 활용: sql 

html과 css를 분리하는 목적: 구조 및 내용(html)과 서식설정-formatting(css)을 분리하기 위해

태그는 가방과 비슷한 개념  
`<가방2><가방 1> 내용물 </가방1></가방2>`


# html, head, body 태그 
필수가 아닌 optional. 구조가 잘 보이게 함   
`<!DOCTYPE html>` 맨 위에 항상. 웹브라우저에게 HTML 버전을 알려주는 역할(이렇게 쓰면 자동으로 최근 버전 html5 사용)
<br>


- `<html>전체 내용</html>`  root element  
- `<head></head>`문서에 대한 부가정보를 담는 부분   
`<head>타이틀,메타태그,스타일태그(CSS), client-side scripts(자바스크립트)</head>`  
- `<body></body>` 문서의 내용(content)이 담기는 부분  
`<body>화면에 뜰 내용인 html들</body>`
- html-head&body 순으로 들여쓰기 맞춰주기 (html이 head, body 감쌈) 

`<meta charset=“utf-8”>` 종료태그 x  
한글을 지원하는 인코딩 방식 (어떤 브라우저든 한글이 깨지지 않게 하기)  
메타태그 이용. 브라우저에게 utf-8(한글지원)을 사용하라 명령. head에 속함 


# HTML <태그>(HTML 요소)  
시작태그와 끝태그 = 하나의 element
- 시작태그와 끝태그로 감쌈 = mark up, tagging -> html는 markups(elements)로 구성됨
- 시작 태그 <태그> angle bracket
사이에 원하는 요소(내용)
종료 태그 </태그>
- 태그는 속성(attribute)를 가질 수 있다(additional information제공) (name과 value는 다르다) 


`<title>제목</title>`  
웹사이트 제목 태그->브라우저 탭 이름으로 나온다. 화면에는 x 

Heading  

가장 큰 머리말(heading1) : 머리말 6까지 생성 가능, 점점 글자 작아짐  
`<h1>머리말</h1>`

두 번째로 큰 머리말 (heading 2)

`<h2>머리말</h2>`

문단 (paragraph): 머리말 사이에 넣어도 ok, 여러개 가능  
`<p>문단 내용</p>`

텍스트를 굵게 (bold) `<b>굵게 할 내용</b>`

텍스트를 날려서(italic) `<i>날릴 내용</i>`

phrase tag: 시각적인 특징 + 의미  
강조 의미를 추가한다면, 스크린 리더 등이 강조해 읽어낼 수 있다(음성 서비스)
굵게 + 강조 `<strong>강조 내용</strong>`  
날려서 + 강조(emphasized) `<em>강조 내용</em>`


## 블록요소
- 언제나 새로운 라인에서 시작
- 해당 라인의 모든 너비 차지
ex. p, div, section, article 등 
- div: css 쓸 때 편하도록 elements를 묶을 수 있음
- section, article: div와 같은 성질, 코드가 덜 복잡하게 의미 부여해줌 

## 인라인 요소
- 새로운 라인에서 시작x
- 너비도 해당 요소의 내용만큼 
ex. a, span
-  span element
  -  inline element
  -  no inherent formatting
  -  used to apply Css rules or assign ID. 문서 내 특정 부분을 처리하고 싶을 때 
  `<p><span class = "className">text</span></p>`


## Symantic tag

### section, article
- section, article: div와 같은 성질, 코드가 덜 복잡하게 의미 부여해줌 

### footer 
`<footer></footer>`
- 화면 하단에 넣겠다는 의미: 저작권 등 
- 글자크기는 p와 같음 





## 하이퍼링크(Anchor) `<a>태그`
`<a 속성=속성값(“주소”>내용</a>`  
내용 부분을 클릭하면 그 링크로 가게 됨 
`<a href="https://google.com">구글 링크</a>`  
`<a href="https://google.com" “target=_blank“>`  
구글 링크</a> 새 탭으로 링크 열기  
`<a herf=“폴더이름/하위폴더이름/파일이름.html”>내용</a>`  
같은 폴더에 있는 파일 열기 
- 상위 폴더일 경우에는 타고올라가는 횟수 만큼 ../ 써주기
- 속성 href: resource’s location

이미지를 hyperlinks로 사용하기  
`<a href = “주소”><img src = “location” alt = “txt”></a>`

internal linking: 문서 내부에 링킹  
`<a href = #elementID><a>`

## image 삽입 
- popular: png, jpeg  
`<img src = “경로(같은 directory면 이름만)” width = “n%” alt = “대체텍스트”>`  
`<img src = “mymelody.png” width = 50% alt = “마이멜로디 사진”>`
- 속성 
    - src: image’s location(path)  
    - width, height : 크기. optional(없으면 실제크기로). pixels 단위(%도 가능, 그냥 숫자만 쓰면 px단위로 됨)  
    - alt: 대체텍스트(이미지 로딩에 실패했을 경우 출력). 필수 for accessibility

## video 삽입 
```
<video muted="" autoplay="" loop="" playsinline="" style = "width: 536px;">
    <source src="~" type="video/mp4">
</video>
```  
- muted: 소리재생x  
- loop: 반복재생  
-

## void/empty element: only attributes, x markup text(content)
- 끝태그 없이 시작태그 끝에 /를 붙임  
`<br/>` line break 한줄 띄우기  
`<img src=“location” alt=“txt”/>`



## 특수 문자&수평선 (character entity references 사용)
`&code;`  
ex. < 쓰고 싶을 때는 `&lt;` (entity name) or `&#60;` (entity number) >는 `&gt;`  
&는 `&amp;`  
`<hr>` 수평선   
`&nbsp;` or `&#160;` 스페이스바 여러번 

## lists (중첩 가능-nested list) 
 1. ul(unordered list) 순서x 
 - li 리스트 요소 elements 가짐 –line break, bullet symbol(동그라미) 
```
<ul> 
 <li>요소이름</li>
 <li><a href=“주소”>텍스트</a></li> <!--요소를 하이퍼 링크로-->
</ul>
```
 2. ol(ordered list) 순서o 
 - 숫자로 시작 
 ```
 <ol>
  <li>요소이름<li> 순서대로 숫자.로 시작 
 ```
 - nested list: 들여쓰기 유의해서 사이사이에 넣는다 

## Tables 
- row 행(가로) column 열(세로)
```
<table> 표 열기 <table border = “숫자”> border: 표 테두리 굵기
  <caption>표 이름</caption> 표 바깥, 맨 위에 위치. 표의 제목 
  <thead> table header 표 제일 위 
    <tr> table row(<tr>안에 가로칸수만큼 <th>가 옴.하나의 가로줄 안에 넣고싶은 것 쓰기) 
      <th>헤드 row 이름</th> th: heading cell, 굵은 글씨
    </tr>
   </thead>
   <tfoot> table footer 표 제일 마지막 (코드에서는 tbody 전에 온다), 없을 수 있음?
     <tr><th>제일 밑 칸 들어갈 말</th></tr>
   <tbody>
    <tr><td>body에 들어갈 말</td></tr> td: data cell, 보통 글씨  
</table>
``` 
- th는 굵은 글씨일 뿐, thead 외에서 쓰여도 됨 
- 속성 rowspan, colspan : 셀 병합(merge). th, td 상관없이 쓸 수 있음  
`<th rowspan = “n”>` n개의 row에 걸쳐있다  
`<th colspan = “n”>`  n개의 column에 걸쳐있다

## Forms
- 사용자에게 입력 받음  
- `<form></form>`으로 marking  
`<form method=“post” action=“데이터를 전송할 주소”></form>` post방식으로 “~”에 전송
   - -form의 속성 method: post, get(directly to URL)

- form element 안에 input element 집어넣기 
-  `<input type = “hidden” name =“~” value = “~”> `  
  보이지 않음. 클라이언트에게 보냄.   
-  `<input type = text name = “~” size=“n” maxlength=“n”>`  
   텍스트 박스. `<label>`과 활용 가능. maxlenth 속성은 optional  
-   `<input type = “submit” value = “버튼 이름”>`  
   제출, 데이터 전송됨. value는 창(버튼)에 뜬다  
-   `<input type = “reset” value = “버튼 이름”>`   clear

- textarea: 여러 줄 입력 가능. row, cols(한 줄당 글자수) 지정 가능   
`<textarea name = “~” rows = “n” cols = “n”>디폴트 메시지</textarea>` 
- password: 입력을 안보이게 함 (mask)  
`<input type = “password” name = “~” size = “n”>` size는 optional
- checkbox: same group 중 복수선택 가능  
name이 같으면 same group, 각각의 value는 다르다. value가 화면에 표시x  
`<input type = “checkbox” name = “~” value = “~”>`
- radio: 단일 선택  
`<input type = “radio” name = “~” value = “~”>`  
안에 checked 넣으면 defult로 그 항목 체크됨 -> 사용자가 변경 가능 
- select: 리스트 펼쳐짐, 선택 가능 
```
<select name = "~">
  <option selected>1</option> <!--selected: 속성, default 값-->
  <option>2</option>
  ...
</select>
```

<br>

- color: 색 선택, picker 제공  
`<input type = “color” name = “~”/>`
- date: 날짜 선택, 브라우저에 따라 캘린더 제공  
`<input type = “date” name = “~”/>`  
(yyyy-mm-dd)이렇게 형식 덧붙여줘도 좋다
- email: 메일 주소 기입  
`<input type = “email” name = “~”/>`
- number: 정해진 범위 내에 선택. step 없으면 default값은 1. value는 default 초기값  
`<input type = “number” name =“~” min =“n” max =“n” step=“n” value=“n”/>`
- range: 범위 내 range bar 생성.step 없으면 default값은 1. value는 default 초기값  
`<label for =“range”></label>` 사용가능  
`<input id=“range” type =“range” name = “~” min =“n” max=“n” step=“n”value=“n”>`
- search: 검색용  
`<input type=“search” name=“~”/>`
- tel: 전화번호 기입. format(pattern)을 정할 수 있음(안맞으면 오류메세지)  
`<input type=“tel” name=“~” pattern=“~”/>`
- time: 시간 hh:mm  
`<input type=“time” name=“~”/>`
- url: 주소 입력 format: http://domain.com 안맞으면 오류메세지  
`<input type=“url” name=“~”/>`

- datalist
```
<input type = "text" name = "txt" list = "datalistID">
    <datalist id = "datalistID">
        <option value = "1">
        <option value = "2">
    </datalist>
```




html5 form elements
- 속성
 - autofocus: form 당 1개만. optional. 우선적으로 커서가 위치
 - required: 여러개 가능, optional. 입력안하면 submit x
 - placeholder: optional, hint message 역할, 전송x. text, search, url, tel, email, password만 사용가능 
  placeholder = “~”
 - formnovalidate : submit의 속성. 셀프검증 없이, 입력이 부족하거나 맞지 않아도 전송됨
 - pattern: format 지정, regular expression 사용.date, email, password, search, tel, text, url 사용가능


```
<meta name = "keywords" content = "word1, word2"> //인덱싱
<meta name = "description content = "3-4 sentences"> //검색결과 설명 
``` 

self validating html5 : color, email, number, range, url, time, date, search (tel XX) 
- only one `autofocus`
- `required` 입력 안하면 x submit 
- `placeholder`: temporary, x submit. 6개 text search tel url password email  
- `pattern`
- `step` : "any"면 default = 1로 지정 
- `formnovalidate` submit의 속성 
- `autocomplete = "on"` form tag에 포함. 타이핑 시 과거 입력한 데이터 보여주고 자동완성. name이나 id가 있는 element에서만 작동!!!!! 
- `readonly`, `disabled`  
