# Git과 Github
## Git
- 파일의 변경사항을 추적하고, 여러명의 사용자들 간 작업을 조율하기 위한 분산 버전 관리 시스템  
-  파일 변화를 기록하고 특정 시점의 버전을 가져올 수 있다 (문제가 발생했을 때 저장해둔 버전으로 돌아갈 수 있다)  
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

## git 명령어  
`git status` 
- 현재 상태 보여줌  

`git checkout 커밋해시 or branch name`  
- 다른 커밋(다른 버전), branch로 이동  

`git branch feature/Name`  
- 새로운 feature branch 생성  

`git checkout -b feature/Name`  
- 새로운 branch를 만들고 바로 이동

merge -> 변경사항 선택 후 commit 해주기





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

## Git Kraken 으로 협업하기 

### repo 생성 
git hub에서 repo 생성 - settings - collaborators - add people로 초대  
git kraken - new tab - clone - url 복사 
-  초대: 메일로 받을 수 있음  
-  repo clone 후 initialize를 팀장만 먼저 해야할듯 
 
### push와 pull
-  local(컴퓨터모양)만 표시되어있다면 본인 local에만 뜨는 것 -> push하여 깃허브에 올리면 공유됨, github아이콘! (remote)
-  업데이트 상황을 local에 가져오려면 pull 
-  아이콘이 둘 중 하나만 떠있는 경우 check-out하고 reset local here 버튼으로 계속 업데이트 해주기 
<br>

### branch 
1.  master branch: 최종본. 출시 전 여기에 merge 한다 
2. develop branch: 필수는 아니지만, 기본적으로 여기에 개발을 하고 마지막에 master에 옮긴다  
    -  생성: file - preference - Gitflow - intialize Gitflow - exit preference -> develop branch를 push/pull 
3.  feature branch: 각각 기능을 개발하는 branch 
     -  생성: gitflow - open gitflow - feature 선택 후 이름 지정 
-  release: QA(Qaulity Assurance)를 진행하기 위해 develop에서 임시로 파생하는 branch  
-  hotfix: 서비스 출시 버전에서 발생한 버그를 빠르게 수정하는 branch 
-  branch 버튼으로 일반 branch를 생성할 수도 있다 
-  branch에 commit후 push하면 github에서 그 branch에 파일이 올라온다! -> merge하면 merge한 branch에 업로드됨
-  branch에 checkout 후 push하기

### merge
합치기를 원하는 더 큰 branch를 check out하고, 작은 branch를 우클릭, merge a into b 누르기 
merge를 하면 수정/추가된 코드, 파일이 업로드되는 것 - branch가 없어지는 것은 아니다 -> merge 후 불필요한 feature branch는 삭제하면 좋음 
기본적으로 큰 branch에 check-out 하고 있기 

### merge - conflict
각자 수정/추가한 코드가 충돌할 때 -> kraken에서 선택하여 (모두 선택도 가능) 저장할 수 있다 

### 협업 내역
github - insights - network
협업한 repo는 host의 github page repo 목록에 뜬다  (-> 팀원에게도 옮겨올 수 있는 방법?)

### git stash  
변경사항을 임시로 저장할 수 있도록 도와주는 기능  
git kraken `auto stash before merge of "master" and "orgin/master"`

