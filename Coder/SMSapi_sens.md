# SMS api 사용법 (naver-sens)  
## 기본 세팅   
https://guide.ncloud-docs.com/docs/sens-sens-1-2  
- 콘솔에서 프로젝트 생성 -> id와 secret key 확인   
https://blog.nerdfactory.ai/2021/02/24/creating-an-api-&-collecting-html-elements-with-django-rest-framework.html  
- django에서 rest frame work 설치  
    - `pip install djangorestframework`  
    - settings.py의 INSTALLED_APPS에 `'rest_framework'` 추가 
- `pip install requests`

## api.py 생성  
- api key와 함수를 등록  
```
serviceId = ~
AUTH_ACCESS_KEY = ~
AUTH_SECRET_KEY = ~
SMS_SEND_PHONE_NUMBER = ~