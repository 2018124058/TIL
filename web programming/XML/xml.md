# Markup  
- markup: text(content)에 추가된 정보. content를 더 유용하게 만든다  
- tag 또는 code의 형태로 표기된다   
- 마크업의 필요성    
    - 기존의 문서: 컴퓨터가 알 수 없는 방식으로 구조를 표현, 구조와 서식을 분리하지 않았다 ex. 제목은 크고 굵게, 문단은 띄워서 작은 글씨로 등등  
    - 컴퓨터에게 문서의 논리적 구조에 대한 정보를 줄 수 없을까?!

## 마크업의 목적  
1. 문서의 elements(요소)를 구분해 문서의 논리적 구조를 표현한다 (separating the logical elements of a document)  
2. 처리정보의 표기 (specifying the processing functions to be performed) ex. 어떻게 formatting할지  

## 마크업의 종류  
1. Procedural: 처리정보 표기  
    - 대부분의 전자문서 마크업 방식  
    - 단점: content와 formatting 정보가 섞여 있음 -> 수정이 번거롭고 시간이 소요됨, 유연하지 않음, 오류 가능성
2. Descriptive, Declarative, Generalized: 논리적 구조, 의미와 관련  
    - GML: 1969년 Charles F.Goldfarb 제안  
        - 두가지 원칙
        1. 문서의 구조와 서식(formatting)의 분리, 구조 표현에 집중  
        2. 문서를 데이터베이스화, processing 가능하게 만들기  
    - xml 및 최근의 html이 지향  

# XML  
