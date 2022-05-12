# Git과 Github
## Git
- 파일의 변경사항을 추적하고, 여러명의 사용자들 간 작업을 조율하기 위한 분산 버전 관리 시스템  
-  **파일 변화를 기록**하고 특정 시점의 버전을 가져올 수 있다 (문제가 발생했을 때 저장해둔 버전으로 돌아갈 수 있다)  
-  여러 로컬 PC와 저장소에서 분산 저장 및 작업  
-  변경 확인 & 여러 사람이 병렬적으로 작업해 협업 가능  

## Github  
-  코드 및 변경 이력 저장소 
-  타인과의 협업 및 공유 가능  
-  주로 로컬 저장소에서 git을 통해 소스 코드 버전 관리를 하고 원격 저장소인 github에 업로드 하는 방식 

<br>

## github 계정 연동 
```
git config --global user.name "username"
git config --global user.email "useremail@email"
```
-  보통 처음에 한 번 해주면 된다  
-  계정 변경 시: 제어판-사용자 계정-자격증명 관리자-window 자격증명관리-일반 자격증명-git:https://github.com 에서 사용자 이름, 암호 편집 -이후 git config로 global user 설정 변경 

<br>

## Git과 Github, 기본 활용법  
-  local(내 PC, 로컬저장소)과 remote(github.com, 원격 저장소)를 연결해주어야 한다

1. `git init` 
    - 이 폴더를 git으로 관리하겠다! (.git 폴더 생성->모든 파일 관리)
2. `git add filename` 
    -  . 을 쓸 경우 변경사항 모두 포함
    -  파일을 stage에 올림 (staging)  
3. `git commit -m "commit message'`  
    - stage에 올라온 변경 내역을 묶어 하나의 커밋으로 생성  
    - 커밋 해시?가 생긴다
    -  여기까지는 local(내 pc)에서만 일어남 
4. `git remote add origin repo.url`
    - 커밋을 올릴 repo 지정
    - github 페이지에서 copy-paste
    - local repo와 연결시켜준다 (연결 후에는 다시 안써도 됨)
5. `git push origin master`
    - 커밋을 원격 저장소(remote)에 업로드 

+ 비주얼스튜디오 코드의 +(add), 커밋메세지 쓰기, 체크 기능(commit)을 이용할 수도 있다
+ remote 대신 clone을 쓸 수도 있다 
    -  `git clone repo.url`
    -   원격 저장소가 로컬 저장소에 'clone' 된다 (.git 폴더까지 통채로 옮김)

<hr>

## git 명령어  (merge)
`git status` 
- 현재 상태 보여줌  

`git checkout 커밋해시 or branch name`  
- 다른 커밋(다른 버전), branch로 이동  

`git branch feature/Name`  
- 새로운 feature branch 생성  

`git checkout -b feature/Name`  
- 새로운 branch를 만들고 바로 이동

merge -> 변경사항 선택 후 commit 해주기

## 원격저장소의 프로젝트를 가져오는 명령어 
`git pull <원격저장소 이름> <받아오려는 브랜치 이름>`  
- 원격 저장소의 프로젝트 변경사항을 그대로 로컬저장소에 옮겨와 자동 병합 (브랜치까지)  
- `git pull master origin`  

`git fetch orgin`  
- 원격 저장소의 프로젝트 변경사항을 가져오지만 병합은 따로  

`git clone <원격저장소 주소>` 
- 원격 저장소의 내용을 새로운 폴더에 그대로 복사  
- 처음 작업할 때 
- 기존 작업은 덮어씌워지거나 삭제된다  
- 클론 시 가상환경은 복사되지 않는다



<br>



## 에러 모음

### > CRLF  

error message: `The file will have its original line endings in your working directory`
맥,리눅스: LF 윈도우: CRLF -> 에러
깃이 자동변환 해줄 수 있게 autocrlf 켜기
`git config --global core.autocrlf true`

### > 원격 저장소 바꾸기  
error message: `error: remote origin already exists.`
기존 remote의 연결을 끊고 다시 맞는 remote를 연결시켜준다  

```
git remote remove origin
git remote add origin repo.url
```

### > push 에러
error message
`error: failed to push some refs to "repo.url"`

pull로 원격저장소 업데이트 사항을 local로 가져온 후 push한다
`git pull origin master`

### > pull 에러 
error message: `fatal: refusing to merge unrelated histories`
merge를 허락해준다 
`git pull origin master --allow-unrelated-histories`

### > 폴더가 열리지 않을 때
error: 깃허브에 푸쉬한 폴더에 화살표모양이 있고 열리지 않음
-  사용하고 있던 git 폴더 안에 또다른 git이 생겨서
-  화살표 폴더 안의 .git 파일을 지워준다 





# Git Kraken  
 코드 변경 이력 시각화, 협업 용이 
### git kraken에 repository 가져오기  
  1. file-new tap-clone a repo
  2. 복사한 repo url 붙여넣기  

### 아이콘   
  - 깃허브 프로필 아이콘: remote, 깃허브 서버, 원격 저장소  
  - 컴퓨터 모양: local, 내 컴퓨터 
  - 아이콘에 따라 파일이 remote에 push되었는지도 알 수 있다 
### 기본 기능   
- pull : 변경 사항을 local에 가져온다 
  push : 변경 사항을 remote에 업로드 한다 (git push와 같다)  

- 똑같이 git add (stage all changes) -> git commit (message 기입 가능) -> git push
<hr>

