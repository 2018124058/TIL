 # Q. 어떻게 출석 기록을 데이터로 남길 수 있을까?  
    - 첫 출석  
    - 일주일 연속 출석  
    - 로그가 뭐지?
    - 총 출석일   
    - https://han-py.tistory.com/148  

## 해결 아이디어  
- login 요청을 보낼 시 해당 날짜의 기록을 남긴다!  
    - User 모델의 데이터 필드로?  list 형태의 필드가 있나?  
        - arrayfield 참고자료  
        - https://docs.djangoproject.com/en/3.1/ref/contrib/postgres/fields/#arrayfield  
        - https://velog.io/@heka1024/Django-ArrayField-%EC%9A%B0%EC%95%84%ED%95%98%EA%B2%8C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0
    - 특정 날짜에 login 했다는 정보를 저장해야 한다  
    - 1. login 시 array에 특정 날짜에 대한 정보 (flag 포함?)을 저장한다  
    - 2. for 문으로 일주일의 flag가 모두 1인지 검사  
    - 웹 디버깅   

- 총 출석일 아이디어 
    1. User model에서 하나의 date field를 만들고 login 요청을 보낼 시 이 필드 값을 해당 날짜로 업데이트한다. 
    2. User model에 이 field가 업데이트 될 때마다 숫자가 0에서 1씩 더해지는 함수를 등록한다. 
    3. 로그인할 때마다 이 함수를 통해 총 출석일이 1씩 더해진다. 



