# 배포 준비하기 (django 기준)
1. CORS(cross-orgin resource sharing) 풀기
    - settings.py에서 `ALLOWED_HOSTS = ['*'] # 모두에게`  
    - 호스트에게 공개하는 것...?
2. 중요한 값(API KEY) 숨기기 ex. settings.py의 _SECRET_KEY, DEBUG  
3. Git ignore
    - .gitignore 파일 
    - manage.py와 같은 위치에 파일 생성   
    - https://www.toptal.com/developers/gitignore : git ignore 내용 생성, 복사해서 쓸 수 있음 

# 배포 (Deploy) 
## Github Pages  
- settings - pages에서 배포된 url을 볼 수 있다  
- 정적 웹페이지만 배포 가능 (django는 동적, 불가능)  

## AWS S3  
- Simple Storage Service: 대용량의 정보 저장
- 아마존에서 만든 객체저장 서비스  
- 유실 위험 거의 없음, 자동화(컴퓨터에 문제가 생겨도 다른 컴퓨터에 가져다 옮김)  
- 사용에 따른 비용 
- 서비스 접근이 끊길 일이 거의 없음  
- 보안: 자동 암호화 
- 콘텐츠 저장 및 배포, 빅 데이터 분석 등에 사용  

### 용어  
- 객체(object): 저장된 데이터 하나(파일)  
- 버킷(bucket): 연관된 객체들을 그룹핑한 최상위 디렉터리, 버킷 단위로 지역(region) 지정 가능. 버킷이 포함된 모든 객체에 대해 일괄적으로 인증 및 접속 제한 가능  
- 버전관리: S3에 저장된 객체들의 변화 저장  
- RSS: 일반 S3 객체에 비해 데이터 손실 확률이 높은 저장 방식  

## Heroku  
- PaaS (Platform as a Service): 플랫폼이 배포, 관리   
- 관리 부담이 적다  
- 배포가 간편하다  
- 무료: 활성 주기 짧은 저장 공간  
    - 30분 간 방문 없으면 사이트 sleep  
    - 한 계정 당 한 달 550시간만 사용 가능 
- CLI 필요(설치), 터미널에서 CLI 명령어를 사용한다  