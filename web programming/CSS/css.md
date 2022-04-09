# CSS 
CSS = Cascading Style Sheets. 웹페이지에 스타일을 지정(presentation)  

```
<!--html 주석-->
/* css (+head section) 주석 */
```

cf. loremipsum : 디자인 보기위한 의미없는 문장 
### 참고
- 사진 공유 사이트 
   -  http://www.ebizmba.com/articles/photo-sharing-sites
   -  pixabay https://pixabay.com/ko/
- css rules
   - http://www.w3.org/TR/
   - http://www.w3schools.com/css/

`/*주석*`/ (html이랑 다르다)
`<style>CSS코드</style>`  
`스타일링 하고 싶은 요소 이름 {속성: 속성값 ; 속성: 속성값 ;}`  
속성 간 들여쓰기 하는 게 좋음 (안해도 에러는 아님) 
`h1 { font-size: 64px ; text-align: center;}`  


찾아보기: tyle="display:flex; align-items:center"


# CSS STYLE 
## 1. Inline Style
body section의 html element 시작 태그에 속성 style 적용 (element level) 
`<element style = "요소(property): value;"></element>`  
예시 `<p style = "font-size: 15pt; color: pink;">text</p>`

## 2. Embedded Style Sheets  
head section에 element style 정의(document level)  
-  `<style>` 안에 포매팅  
-  속성 type `<style type = "text/css"></style>`   
-  예시

```
<style type = "text/css">
body      {property: value; 
        property: value;}
p em   {property: value;}
.className  {property: value;}
a.className {property: value;} //anchor element 중 class 
a:hover     {property: value;} //:hover 마우스 커서를 올렸을 때
                               // 링크에 커서올렸을 때 default style 변경 가능 
                               //:hover pseudo-class
```

-  class 속성을 이용하여 여러 elements에 공통 스타일 적용 가능 
  -  class는 body section의 element 속성으로 지정해준다 
  -  한 element에 클래스를 여러개 부여할 수 있다 (띄어쓰기로 구분)

```
<body>
    <h1 class = "classname"></h1>
</body>
```  

### conflicting Styles
-  inheritance 상속
  -  elements는 계층적
  -  상위 element에 지정한 스타일이 하위 element에 적용된다
  -  그러나 하위 element일수록 (스타일 적용 범위를 구체적으로 지정할수록) 우선순위(specificity)를 갖는다!! 우선적용됨 

### Pseudo Class
`element.class:pseudoclass //세미콜론인 것 헷갈리지 않기`

## 3. External style sheets (Linking)
-  style을 하나의 파일(.css)로 저장해 html 문서와 분리
-  html 파일 head section에 link element로 넣는다 
-  전체 웹사이트에 통일된 스타일 적용 가능
`<link rel = "stylesheet" type = "text/css" href = "style.css">`  
-  한 문서에 두 언어를 쓰는 것보다 두 파일로 나누는 것이 좋다
-  https://jigsaw.w3.org/css-validator/ external css + html 문법 검사

# CSS Selectors
https://www.w3schools.com/cssref/css_selectors.asp  

-  class 속성을 이용하여 여러 elements에 공통 스타일 적용 가능 
  -  class는 body section의 element 속성으로 지정해준다 
  -  한 element에 클래스를 여러개 부여할 수 있다 (띄어쓰기로 구분)

`.classname {property: value;}`

```
<body>
    <h1 class = "classname"></h1>
</body>
```  



|Selector| Example | Description|  
|---|---|---|    
|.class  | .intro  | class="intro"인 모든 elements
|#id| #first| id = "first"인 element. id는 class와 다르게 unique, 하나만 있음
|*|  *| all elements
|element| p | all p element
|element1, element2| div, p| all div,p element-list up|
|element1 element2| div p | element1 안의 모든 element2 선택. 깊이는 상관x|
|element1>element2| div>p| element1의 child인 모든 element2 선택. 깊이 상관o |
|element1+element2| div+p| element1 바로 다음에(밑에) 위치한 element2 선택. 같은 레벨(형제관계)|
|element1~element2| p~ul | element1 다음에 위치한 모든 element2 선택. 같은 레벨(형제관계)|
|[attribute]| [background]| 특정 속성을 갖고있는 모든 elements|
|element1[att]| div[background]| 특정 속성을 갖고있는 모든 element1들|
|element[att="value"]|        | att 속성 값이 value인 elements|
|element[att~="value"]|   | value가 포함된 속성값을 갖고있는 elements(공백, -, 다른 단어 있어도 상관x)|
|element[att^="value"]| a[href^="https"]  |속성 value가 http로 시작하는 a elements|
|element[att$="value"]| a[href$=".pdf"]  | value가 .pdf로 끝나는 속성을 갖고있는 a elements|
|element[att*="value"]|    | 속성 값에 "value"가 포함되는 elements|
|element[att|="value"] | [lang |="en"] |en, 또는 en으로 시작되는 속성value를 갖고있는 elements ex. value가 "en", "en-US"|
|element:nth-child(숫자n)| p:nth-last-child(2)|n번째 child인 elements|
|element:first-child|  | 첫번 째 child인 element|
|elment:last-child| | 막내인 element|
|e:first-of-type|  | 첫번째 child element|
|e:hover|  | 커서 올릴 때|
|e::first-line| | element 전체가 아니라 element 내 첫번째 라인을 선택|
|e::first-letter|p::first-letter| element의 첫번째 글자 ex. p의 첫글자만 다 크게 표시하기| 



# css 요소  

## text  
-  font-size: 보통 pt 단위 
   - em: 현재 폰트(M의 크기) .8em = 현재 폰트의 80% 사이즈
     ex: 현재 폰트 (x의 크기)
    - px: 모니터를 구성하는 최소한의 화소단위 
-  font-color / color 
-  font weight: 굵기. bold,light,liter, normal... 숫자로 값을 줄 수도 있다 
-  font-family: font1, font2 ... (차례로 보유한 폰트 우선 적용)  
-  text-align: justify(양쪽 정렬), center(가운데 정렬)
-  font-style: italic(기울이기)
-  line-height: 줄간격. 폰트크기의 160% 정도가 보통 적당하다

### @font-face rule (web fonts)  
web font: 폰트가 다운로드되어있지 않아도 적용 가능 
오픈소스 폰트 모음 https://fonts.google.com/
링크를 link element에 담아 head section에 넣기 
`<link href = "font url" rel = "stylesheet/>`
또는 
```
@import url("font url");
* {font-family: 'font-name';} /*전체 적용 시 */
```
### Text Shadow
css3
텍스트에 그림자 효과  
`element  {text-shadow: -4px 4px 6px gray; /*add shadow*/}`

text-shadow values: 4개 순서대로 기입 (콤마 없이)
 1. 그림자의 수평방향 위치 (horizontal offsets:pixels)
    - 음수: 왼쪽 / 양수: 오른쪽 
 2. 그림자의 수직방향 위치 (vertical offset)
    - 음수: 위쪽 / 양수: 아래쪽
 3. 그림자의 흐려짐 효과 (Blur radius: pixels)
    - 0px: 선명한 그림자(sharp edge) / 양수로 값이 커질수록 흐려진다 
    - 흐려지다보면 그림자가 사라진다?
 4. color: 그림자 색상  


### Text Stroke
css3
![textStroke](/CSS/cssPracticeImage/textShadowStroke.PNG)
`-webkit-text-stroke: npx color;`  
- outline thinkness 
- color of stroke(hotpink)  
- webkit 엔진 기반 브라우저에서만 적용 (vendor prefix 사용하기
)
예시
```
h1 {color: white /*안쪽 글자 색*/
    -webkit-text-stroke: 1px hotpink; /*vendor prefix */
    font-size: 200%}
```

## color

- 구글에 html color code 검색

### color 표현 방법
1. standard color name 
2. hexadecimal value 16진법
  - 예시 `#00FFFF`
3. RGB/RGBA 
  - 가산 모델, 빛의 삼원색 기본
  - red, green, blue 각각 0~255의 값
  - alpha(opacity, 투명한 정도): 0.0 투명 ~ 1.0 불투명
  - 예시 `background: rgba(255,0,0,0.5); /* 반투명 빨강*/`
          `rgba(0,0,0,1.0);` 검정색 
4. HSL/HSLA
  - 인간의 직관적인 시각모델과 흡사 
  - hue(색상): 무지개색 순서, 0~359의 값
   -  red(0), green(120), blue(240)
  - saturation(채도): 0% (gray) ~ 100% (full color)
  - lightness(명도, value, brightness): 0% (완전히 어두움, black) ~ 100% (white)
    - 50%의 명도가 실제 색상
  - alpha(투명한 정도): 0.0 ~ 1.0
  - 예시 `background: hsla(0,100%,50%,0.5); /*반투명 빨강*/`


### Gradient  
gradient: 색깔간 그라데이션. used in any property that accepts image  
1. Linear gradient 
    색상은 갯수 제한 없이 지정 가능(최소 2개)  
    `background: linear-gradient(방향 또는 각도 지정, color-stop1, colorstop2...);`
    - color-stop: % 또는 px 단위
    - deg: 각도지정 
      - 0deg: 0도, 아래에서 위로 ->시계방향으로 돈다 90edg: 오른쪽으로 
    
    1.1 vertical linear gradient 수평방향
      `background: linear-gradient(to bottom, color1 n%, color2 m%);`
    - to bottom (180edg, default) / to top (0deg)
    - n% 부터 color1, m% 부터 color2 로 그라데이션 (색상 여러개 지정 가능)    
    1.2 horizontal linear gradient 수직방향
       `background: linear-gradient(to right, color1 n%, color2 m%);`
    - to right(90edg) / to left (270deg)
    1.3 diagonal linear gradient 대각선 방향 
      `background: linear-gradient(xdeg, color1 n%, color2 m%);`
    - to bottom right / to top right 이런 식도 가능 
  
2. Radical gradient
  중심점으로부터 색이 퍼져나감  
  `background: radial-gradient(size shape at position, color1, color2...);`  
  예시 `background: radial-gradient(closet-side circle at center, pink, blue, white);`  
  - shape: 그라데이션을 마칠 때 모양(ending shape). circle or ellipse
  - position: 그라데이션 중심의 위치 
  - size: ending shape 크기 
    -  explicitly / keyword
      - keyword: closet-side, farthest-side, closest-corner, farthest-corner...
  - default: ellipse, farthest-corner, center
  - [gradient 실습 사이트](https://www.w3.org/TR/css-images-3/#radial-gradients)



## anchor element style 
- default style(파란색, 밑줄) 없애거나 바꿀 수 있다  
`a {text-decoration: none;}`
- 링크에 커서 올렸을 때 스타일 지정 가능
`a:hover {text-decoration: underline; color: pink;}`

## Positoning Elements (element 위치 지정)
### 1. Absolute positioning
- removes an element from the normal flow 
- 절대 좌표 부여 
- block-level element(!= inline element)의 여백으로부터의 거리 기준으로 위치 지정
- z-index 속성 
  -  elements끼리 겹쳐지게 할 수 있다
  -  속성 값이 클수록 앞쪽 
```
.background { position: absolute; /*뒷배경*/
              top: 50px; left: 50px   
              /*위,왼쪽으로부터 50px 여백*/
              z-index: 1;}
.foreground { position: absolute;
              z-index:2;}        /*background 앞에 오게 됨*/
```

### 2. Relative positioning
-  keeps an element in the general flow
-  상대위치, 기본위치를 기준으로 좌표 사용
-  현재 위치 기준으로 상대적 위치 지정 (어느쪽으로 얼만큼 이동)
```
.className  {position: relative;
            top/bottom/right/left: -1em; /*px도 가능*/
```
-  음수값을 넣어야 그 방향으로 이동한다 
  -  `top: -10px;` 위로 10px 이동
     `top: 10px;`  아래로 10px 이동

-  span element
  -  inline element
  -  no inherent formatting
  -  used to apply Css rules or assign ID. 문서 내 특정 부분을 처리하고 싶을 때 
  `<p><span class = "className">text</span></p>`
### 3. static  
- 기본값, 좌표 프로퍼티 쓸 수 없음  
### 4. fixed  
- 보이는 화면 기준으로 좌표 프로퍼티를 이용하여 위치를 고정 

## Background
```
body    {background-image: url(image.img);
                    background-size: 10%;
                    background-position: bottom right;
                    background-repeat: no-repeat;
                    background-attachment: fixed;} 
```
-  background-repeat
   -   repeat(default, 이미지가 타일링됨) / no-repeat
-  background-attachment
   -   scroll(default, 스크롤에 따라 이미지 위치 변화)  / fixed(스크롤 움직여도 위치 변화x)

### Multiple Backgrounds  
background-origin
- border-box: border에 닿게
- padding-box(default value) 
- content-box

`background: url(image.png) position repeat여부 fixed여부 background-origin`

예시
```
background: url(image1.png) right bottom no-repeat fixed border-box,
            url(image2.png) left top repeat content-box;
```



## Box Model 
Block-level element: 가상의 box 
![boxlevel](/CSS/cssPracticeImage/boxlevel.PNG)

- margin(바깥쪽 여백), padding(안쪽 여백), border(윤곽선), content 
-  margin: 한 element의 윤곽선과 다른 element의 윤곽선 사이 여백
  -  margin-top, margin-bottom, margin-right, margin-left
  -  margin으로 상하좌우 동일한 여백 줄 수 있다 
-  padding: content와 윤곽선 사이 여백
  -  padding-top, padding-bottom, padding-right, padding-left
  -  padding으로 상하좌우 동일한 여백 줄 수 있다
- border: padding과 margin 사이 
  -  border-top, border-bottom, border-right, border-left
  -  border-width(thin, medium, thick), border-color, border-style(none, dotted, dashed, solid, double, groove, ridge, inset, outset...)

- 박스 스타일 예시 
```
div {border: 3px solid navy;
                padding: 50px 50px;
                border-radius: 15px;
                background: pink;
                width: 200px;
                text-align: center;
                margin-bottom: 20px;}
```
## 박스 만들기
- div 등 block-element로 묶기
- `border: 두께 방식 색깔;` 박스 테두리 만들기 
  - 방식ex. solid(진하게)
  - 테두리를 두껍게 해도 content 크기가 줄어들지는 않는다
- width: 박스(border 안쪽)의 가로 
  height: 박스(border 안쪽)의 높이
- 박스 전체의 크기는 width/height + border 두께가 된다 
- `text-align: center;` 하면 박스가 아닌 박스 내 내용물이 가운데 정렬됨  
- 박스를 가운데 옮기기  
`margin-left: auto; margin-right: auto;` 
- background-color: 박스 색 채우기 
- padding: 값 증가하면 박스 전체 크기 커짐, content와 border 사이 간격 멀어짐
  - paddint-left: 값 주면 들여쓰기 효과
- margin: 박스 바깥의 간격 
- 브라우저마다 margin, padding 값이 다를 수 있으므로 0px로 초기화하는 것이 좋다

## flaot
`float: right`: 블락이 문서 내 떠다니되, 오른쪽에 붙어서 떠다님  
- 서로다른 block elements를 같은 줄에 배치할 수 있음  
  `e1 {float: right;}  e2 {float: left;}`
- 떠다니기 때문에 다른 element와 겹칠 수 있다 (방해받지 않음)
-> float하는 element를 block element(ex.div)로묶어주면 방지할 수 있다 
   `overflow: hidden;` 
   float하는 element를 묶어주고 이후에 나온 element와 겹치지 않게 함

### Element Dimensions 
content box를 보이게 할 수 있다
```
<div style = "width: 20%; text-align: center; height: 150px; overflow: scroll;>
```
-  width: 박스 너비가 화면의 몇프로를 차지할지
-  height: 박스의 높이
-  overflow: 박스 크기보다 content가 많을 때 
  - scroll: 스크롤 생김
  - hidden: 넘치는 부분 안보이게 함
  - overflow 지정x: content가 다 보이게 높이가 조정됨
- div element
  -  box-level element

### Border-Radius
border-radius property: 박스에 둥근 모서리를 더해준다 
`border-radius: npx;`
 
  - 우선 박스(border)가 설정되어 있어야함 
  - 값이 커질수록 둥글어짐  
  - 값이 짧은 쪽 변의 길이 반 이상이 되면 동그란 모양이 된다 
  - 각 코너에 따라 둥근 정도를 조절할 수도 있다
  -  `border-top-left-radius, border-top-right-radius, border-bottom-left-radius, border-botteom-right-radius`

### Box-Shadow  
box-shadow property: 박스에 그림자를 더해준다  
`box-shadow: npx npx npx color;`
text-shadow values: 4개 순서대로 기입 (콤마 없이)
 1. 그림자의 수평방향 위치 (horizontal offsets:pixels)
    - 음수: 왼쪽 / 양수: 오른쪽 
    - 0이면 가운데 
 2. 그림자의 수직방향 위치 (vertical offset)
    - 음수: 위쪽 / 양수: 아래쪽
 3. 그림자의 흐려짐 효과 (Blur radius: pixels)
    - 0px: 선명한 그림자(sharp edge) / 양수로 값이 커질수록 흐려진다 
    - 흐려지다보면 그림자가 사라진다?
 4. 그림자가 퍼진 정도 (spread)
    - px 단위, optional
    - 값이 증가하면 그림자 넓게 퍼짐    
 5. color: 그림자 색상  
    - rgba 

## Border-Image  
border-image property : 액자테두리 느낌으로 이미지로 border을 만듦
value 4개
-  border-image: url(image.png)
-  border-image-slice: px or %
  - top, right,, bottom, left 값을 각각 따로 줄 수도, 한꺼번에 줄수도 
-  border-image-repeat
  - stretch: 크기를 조정해 맞춤 (scaled) (side만 조정됨, corner image는 그대로)
  - repeat: 이미지를 반복 (tiled)
   - round: 이미지를 자르지 않고 완전한 형태로 반복(코너에 맞닿는 이미지 크기가 조정됨) 
  - stretch repeat: 위아래는 stretch, 왼쪽 오른쪽은 repeat
`element { border-image: url(image.png); border-image-slice: 80%; border-image-repeat: stretch}`  
![border-image](/CSS/cssPracticeImage/borderImage.PNG)

 



## Drop-Down Menus
- :hover pseudoclass: 마우스 커서 올렸을 때 스타일 적용

- cf. list-style: none 리스트 defualt bullet 없애줌 

## display property: element가 어떻게 보일지 결정 
   -  block element / inline element / none (보이지 않게)
   - flex

## Animation  
css3
https://www.w3.org/TR/css-animations-1/  
https://www.w3schools.com/css/css3_animations.asp
```
/*예시*/
element { position: relative;
          animation: moving image linear 5s 1s 2 alternate;}
@keyframes movingimage
{ 
  0%  {opacity: 0; lift: 150px; top: 0px;}
  25%  {opacity: 1; lift: 0px; top: 150px;}
  50%  {opacity: 0; lift: 150px; top: 300px;}
  75%  {opacity: 1; lift: 300px; top: 150px;}
  100%  {opacity: 0; lift: 150px; top: 0px;}
}
```
자바스크립트 없이 애니메이션을 꾸밀 수 있다   
animation property
- value를 아래 순서대로 나열하기만 할 수 있다
`animation: moving image linear 5s 1s 2 alternate;`
1. animation-name
2. animation-timing-funtion: 한 사이클 내 속도 변화 
  -  linear: 속도 일정
  -  ease: default, 느리게 시작했다 빨라졌다 느리게 끝남
  -  ease-in: 느리게 출발
  -  ease-out: 점점 느려짐
  -  ease-in-out: 시작과 끝에 느려짐
  -  cubic-bezier: 0에서 1사이 값으로 구간별 속도 지정 ex. `cubic-bezier(1,0,0,1)`
     http://www.roblaplaca.com/examples/bezierBuilder/
3. animation-duration: 애니메이션 한 사이클 진행 시간 (s or ms)
  - default: 0s (no effect)
4. animation-iteration-count: 한 사이클을 몇번 반복할지
5. animation-delay: 시작까지 걸리는 시간 (s or ms)
6. animation-direction
  - normal(default) / alternate(방향 바꿈)
- animation-play-state
  - running(default) / paused
  - 자바스크립트에서 애니메이션을 중간에 멈추기 위해 사용
<hr>
@keyframes animation-name
{}안에 단계별 퍼센테이지와 상태 기록


## Transition  
animation과 유사하나, 시작과 끝의 상태만 지정가능  
```
img   {transition: transform 2s;}
img:hover {transform: rotate(360edg) scale (2,2);}
```
```
img {position: absolute; left: 0;
    transition: opacity 2s ease-in-out}
```


## Transform 종류
https://www.w3schools.com/cssref/css3_pr_transform.asp

- rotate(angle): 회전. 0 ~ 360 edg
  - 양수: 오른쪽 방향 음수: 왼쪽 방향 회전
- scale(x,y): width(x), height(y) 크기 조절
- translate(x,y)
- skew(x-angle, y-angle) : 기울어짐
- skewX()
 

## Multicolumn layout
property
- column-count: column 갯수
- column-gap: 간격
- column-rule-style: rule(column 사이 줄) style ex. solid, outset...
- column-rule-width
- column-rule-color
- column-rule: column-rule- property를 줄여쓰기 

` section {column-count: 3; column-gap: 30px; column-rule: 1px outset black;}


# Media Query
media에 따른 display

## 1. html 문서 내 style elemnet 안에 @media 사용
- @media 뒤의 formatting 내용을 {} (curly braces)로 감싼다 
```
<stle type = "text/css">
  @media all // 모든 media 적용
  @media print //프린트 전용
  @media handheld //mobile devices
  @media braille // 점자
  @media speech // speech-synthesizing
  {
    body  {background-color: blue;}
  }
```
## 2. external style
`<link rel = "stylesheet" media = "screen" href = "style.css"/>`

## media query feature
직접 feature value를 지정할 수 있다(단위: px,cm,in,em...)
- width: 화면의 너비
- height
- device-width: 기기 자체의 너비 
  - 모바일은 대체로 width/height와 device-width/device-height가 같다 
- device-height
- orientation
- aspect-ratio, device-aspect-ratio, color, color-index, monochrome, resolution, scan, grid
- orientation, scan, grid를 제외하고 나머지 feature은 앞에 min- 또는 max-를 붙일 수 있다 
<hr>

예시
`@media screen and (min-width: 801px) // 801px 이상의 screen에 적용`
`<link rel="stylesheet" media="screen and (min-width:801px)" href="style.css"/>`



<hr>
<br>

# CSS 3 (Advanced CSS)
[css3 페이지](https://css3please.com/ "css3 rule 사이트")
- cf. vendor prefix 
  -  브라우저에 새로운 실험적인 기능을 제공할 때 이전 버전의 웹 브라우저에 그 사실을 알려주기 위해 사용하는 접두사(prefix)
  -> 해당 기능이 포함되어있지 않은 브라우저에서도 호환 가능 
  - vendor prefix를 앞쪽에 -> 이후 standard non-prefixed version(표준속성)
  - transform, transition, animation, gradient, text-stroke 등에 자주 활용됨 





# flexible box layout 
flex box 
- layout이 동적으로 변경(flexible) – desktop과 mobile에서의 layout이 다름(column갯수, 박스 배열 등등 변화). 너비가 줄면 display 변화.  
- `display: flex;` flex layout을 쓰겠다. container 역할  
- flex container: child elements은 flexible items가 됨)  
- contatiner는 nesting이 가능하다.

## flex contatiner properties - 부모요소
flex-direction, flex-wrap, flex-flow, justify-content, align-items, align-content 등

- flex-direction
  - flex container 내 아이템을 배치할 때 사용할 주축 및 방향을 선택  
  - row; 아이템을 가로 정렬 (default)
  - row-reverse; 가로로 거꾸로 정렬  
  - column; 세로 정렬  
  - column-reverse; 세로로 거꾸로 정렬

- justify-content 
  - flex-direction의 방향 기준!의 수평축을 따라 컨테이너 내 item 정렬
  - center; item을 컨테이너 내 가운데 정렬 (수평방향) 
  - flex-start; 왼쪽 정렬 (컨테이너 시작부분에 정렬). default
  - flex-end; 오른쪽 정렬 (컨테이너 끝 부분에 정렬) 
  - space-around;  아이템 주위에 동일한 간격. 각각의 item 앞 뒤쪽에 공간space. display 줄이면 space 크기 조절됨  (라인 내에서 item간!)
  - space-between;  각각의 item 사이에 공간 (앞뒤가 아니라.-> 맨 앞 item은 앞쪽 공간 없음)

- align-items  
  - 수직축 기준 컨테이너 내 item 정렬
  - stretch; default. container을 채우기 위해 item 크기 조정  
  - center; 수직방향에서 가운데 정렬 
  - flex-start; 수직방향에서 위쪽 정렬(꼭대기로)
  - flex-end; 컨테이너 아랫쪽(바닥)으로 정렬 
  - baseline; 안의 글꼴의 기준선을 baseline으로 정렬 

- align-content  
  - item의 line이 여러개일 때, line의 배치, 간격 등 
  - stretch; 여러 줄을 컨테이너에 맞게 늘림
  - flex-start; 여러 줄을 컨테이너 위(꼭대기) 정렬
  - flex-end; 여러 줄을 컨테이너 밑(바닥)에 정렬
  - space-between; 각각의 line 사이에 공간 (수직방향)
  - spce-around; 각각의 line 사이+위아래에 공간 (수직방향) 

- flex-wrap
  - nowrap; (default) 다음라인으로 안넘어감. 화면 비율을 줄일 때 다음 라인으로 아이템이 밀려나지 않고 아이템의 크기가 조절됨
  - wrap; wrap around. 화면 비율 줄이면 여러줄로 wrap around 됨 (레이아웃 바뀜) wrap이 없으면 화면비율 줄일 때 다음 라인으로 밀려나지 않고 item사이즈가 변경됨  (itme, container 크기 지정하는 것이 좋음?)
  - wrap-reverse; wrap around하는데 위치 반대.거꾸로 위 방향으로 item이 흘러넘침 

- flex-flow
  - flex-direction + flex-wrap 의 shorthand(한번에 설정)


- 완전히 중앙에 배치하기
  - `justify content: center;  align-items: center;` 
  - 각각 수평방향 수직방향

## flex container item(child element)의 properties
- flex container 내 각각의 item에 부여하는 속성  
- order
  - item 순서 바꾸기  
  - `style = “order: 1”

- flex-grow
  - 브라우저 너비 조정시 아이템 어떤 비율로 확대할지(속도)
  - `flex-grow: 2;` -> 다른 아이템의 두배로 빠르게 확대됨 (더 크게 확대된다)
- flex-shrink: 어떤 비율로 축소할지 
  - `style = “flex-shirink: 0”` -> 축소 안됨. 브라우저 크기 조절 영향 안받음 
  - `style = “flex-shirink:2”` -> 다른 아이템의 두배로 작게(빠르게) 축소
- flex-basis
  - item의 초기값 지정 
  - `flex-basis: 200px;` 초기값이 200px, 축소 및 확대는 동일한 속도 
- align-self :
  - 컨테이너의 align이 상속되지만 특정 아이템에 오버라이드 가능(지정 가능)
  - ex. 특정 아이템만 `align-self: center;` 가능  

## flex responsive 
media query를 이용하여 화면 크기 체크, 다른 레이아웃 적용 
ex. desktop row 방향, mobile column 방향 배치 
ex. @media 800px 이하
      {flex: 100% } 100% 차지하게...?
    다른 때는 50%
ex. 갤러리: 너비에 따라 column 개수 달라짐 
ex. 웹사이트: 너비에 따라 배치 방향, column 개수 달라짐 
!수업에서는 responsive하게 프론트엔드를 개발할 수 있게 특정 프레임워크,api를 소개하지는 않음

