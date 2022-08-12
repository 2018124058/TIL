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
- 객체 (object): 저장된 데이터 하나(파일)
- 버킷(bucket): 연관된 객체들을 그룹핑한 최상위 디렉터리. 버킷 단위로 지역(region) 지정 가능. 버킷이 포함된 모든 객체에 대해 일괄적으로 인증 및 접속 제한 가능  
- 버전관리: s3에 저장된 객체들의 변화 저장  
- RSS(Reduced Redundancy Storage): 일반 S3 객체에 비해 데이터 손실 확률이 높은 저장 방식. 가격이 저렴하기 때문에 복원 가능 데이터 저장에 적합하다.  


## Heroku  
- PaaS (Platform as a Service): 플랫폼이 배포, 관리   
- 관리 부담이 적다  
- 배포가 간편하다  
- 무료로 활성 주기 짧은 저장 공간도 제공  
    - 저장기간이 짧다 (static 이미지 등)
- 무료 버전    
    - 30분 간 방문 없으면 사이트 sleep  
    - 한 계정 당 한 달 550시간만 사용 가능  
    - 초기 단계 배포, MVP 테스트용 정도로 사용하면 좋다 
- CLI 필요(설치), 터미널에서 CLI 명령어를 사용한다  

# 배포 방법  (AmazonS3 + Heroku)  
- 참고: https://nimbusweb.me/share/5262243/4iw6d1rku3ew7vy1udz0   

## S3을 통한 Django 자료 저장  
- static 과 media 파일들을 S3 저장소에 저장하여 관리하기

### 1. django 환경 변수 설정  
- settings.py의 `SECRET_KEY`를 환경 변수로 설정해준다 (보안)  
    - 기존 settings.py  
    ```
    SECRET_KEY = ~~ # SECRET_KEY value
    ```
    - 변경  
    ```
    SECRET_KEY = os.environ.get(
    'SECRET_KEY', # SECRET_KEY value 삽입) 
    ```

### 2. AWS
1. AWS > IAM service 접속 > 사용자 > 사용자 추가  
    - access key 활성화 체크  
    - permission(권한 설정): 기존 정책 직접 연결 > AmazonS3를 이용할 것이므로 AmazonS3FullAccess 선택

2. Access Key ID, Secret access key 복사  
    - Secret access key는 계정 생성 후 페이지에서만 볼 수 있으므로 잘 저장해둘 것  
    - settings.py에 주석으로 달아두거나, csv 파일로 저장한다  
### 3. Django에서 설치  
- `pip install django_storages`  
    - s3 저장소와 통신 가능한 저장 시스템 클래스 패키지 설치  
- settings.py의 `INSTALLED_APPS`에 `storages` 앱 등록  
- `pip install boto3`  
    - django_storages 패키지가 S3과 통신할 때 사용하는 패키지  
    - S3을 조작할 수 있는 API에 맞는 요청을 python으로 작성해둔 패키지. 파일 저장, 삭제+버킷 생성, 권한 설정 등 s3 편의 기능 제어 가능  

### 4. 버킷 생성    
- AWS > S3 서비스 > 버킷 생성 
    - ACLs 활성화(enabled) 선택 (다른 사용자도 이미지 접근 가능)
    - '모든 퍼블릭 액세스 차단' 설정 해제  
- 생성한 버킷 안에 이미지가 저장되고, IAM에서 만든 계정으로 여기에 접근할 수 있다  

### 5. Django의 settings.py에 s3 연동  

1. settings.py 수정  

```
AWS_ACCESS_KEY_ID = 'value' # ''안에 string 형태
AWS_SECET_ACCESS_KEY = 'value'
AWS_REGION = 'ap-northeast-2' # 서울  
AWS_STORAGE_BUCKET_NAME = '생성한 버킷 이름'
AWS_S3_CUSTOM_DOMAIN = '%s.s3.%s.amazonaws.com' % (AWS_STORAGE_BUCKET_NAME, AWS_REGION) # 이미지가 연결될 주소
AWS_DEFAULT_ACL = 'public-read' # 접근 권한 public - 없으면 오류 가능성 

STATICFILES_LOCATION = 'static' # static 파일들의 위치 

# 파일을 어디에 저장할지 
DEFAULT_FILE_STORAGE = 'storages.backends.s3boto3.S3Boto3Storage' # media 관련 
STATICFILES_STORAGE = 'storages.backends.s3boto3.S3StaticStorage' # static 관련 
```

2. `python manage.py collectstatic`  
    - 이미지를 aws 안에 저장하기 위함  
    







