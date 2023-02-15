## 숫자야구 설계

### 핵심 기능 목록
+ 게임을 시작할 수 있다.
+ 3개의 숫자를 입력할 수 있다.
+ 게임 종료 여부를 선택할 수 있다.

### 기능 세부 분석
+ 게임을 시작할 수 있다.
  + 게임 시작 문구를 출력한다.
    + 게임 시작 문구를 요청한다. ("숫자 야구 게임을 시작합니다.")

+ 게임을 진행한다.
  + 게임 진행 문구를 출력한다.
    + 게임 진행 문구를 요청한다. ("숫자를 입력해 주세요 : ")
    + 3개의 숫자를 입력할 수 있다.
      + 사용자의 입력이 유효한 값인지 검증한다.
  + 게임을 시작한다.
+ 사용자가 입력한 값과 상대방(컴퓨터)의 값을 비교하여 결과를 낸다.
  + 게임 결과를 출력한다.
    + 게임 결과 문구를 요청한다. (Ex : "1볼")

+ 게임 종료 여부를 선택할 수 있다.
  + 게임 종료 선택 문구를 출력한다.
    + 게임 종료 선택 문구를 요청한다. ("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
  + 게임 종료 여부를 선택한다.
    + 사용자의 입력이 유효한 값인지 검증한다.
    + 사용자가 새로 시작을 선택한 경우 (1)
      + 게임을 초기화하여 새로 시작한다.
    + 사용자가 종료를 선택한 경우 (2)
      + 게임을 종료한다.

### 클래스 다이어그램
![exported_from_idea](https://user-images.githubusercontent.com/102807742/219078352-fbfbbb0d-654f-4a99-b758-762b02c7a2e8.jpg)

#### 핵심 클래스

핵심 클래스의 경우 MVC 구조로 설계하였습니다.

각각 해당하는 클래스는 아래와 같습니다.

+ **Model** :  BasallGameStadium
+ **View** : BaseBallGameConsole
+ **Controller** : BaseBallGame

현재 Model에는 Computer와 Referee가 포함되어 있습니다.

Computer은 요구사항에 나와있는 상대방(컴퓨터)입니다.

요구사항을 살펴보면 컴퓨터는 1~9사이의 서로 다른 3가지의 수를 가지고 있다라고 합니다.

그렇기에 Computer은 Balls를 포함하고 있고 이는 서로 다른 Ball을 포함하도록 설계해보았습니다.

Referee는 유틸리티 클래스가 어울릴 수 있다 생각할 수 있습니다.

하지만 결과 역시 중요한 정보중 하나라 생각하였고 이를 핵심 Model에 포함하도록 설계하였습니다.

View의 경우 Host와 InputValidator가 포함되어 있습니다.

Host는 Speaker와 Line을 포함하고 있어 Speaker가 Line을 통해 게임에 필요한 멘트를 제공할 수 있도록 하였습니다.

InputValidator은 Validator와 InputPolicy를 포함하고 있어 이를 통해 콘솔을 통해 입력되는 값에 대해 검증할 수 있도록 하였습니다.

Controller는 Model과 View를 포함하고 있고 이들을 적절하게 조합하는 역할을 합니다.

#### 설정 클래스
설정 클래스는 Line과 InputValidatePolicy 입니다.

Line은 인터페이스로 Line과 같은 형태로 Speaker에게 전달하면 Line에 해당하는 내용을 Speaker가 말합니다.

InputValidatePolicy 역시 인터페이스로 InputValidatePolicy와 같은 형태로 Validator에 전달하면 InputValidatePolicy에 해당하는 정책으로 Validator가 입력갑을 검증합니다.

#### 상태클래스
상태클래스는 GameResult와 GameStatus입니다.

이들과 Ball, Balls와의 차이는 이들은 단순히 상태만 나타낸다는 것입니다.

#### 유틸리티 클래스
유틸리스 클래스는 BallGenerator로 Ball을 만들어주는 클래스입니다.

### 시퀀스 다이어그램

#### 게임 시작 시퀀스
![BaseballGame_startGame](https://user-images.githubusercontent.com/102807742/219079160-98f0b89f-9f50-4702-9f69-51dbe02f755c.jpg)

#### 게임 진행 시퀀스
![BaseballGame_playGame](https://user-images.githubusercontent.com/102807742/219079306-97785c13-fb9c-43b8-9cad-b6afe0b248c8.jpg)

#### 게임 결과 시퀀스
![BaseballGame_resultGame](https://user-images.githubusercontent.com/102807742/219079423-eadb4a38-c641-4a38-aa6d-fcefb95ff6bc.jpg)

#### 게임 종료 시퀀스
![BaseballGame_endGame](https://user-images.githubusercontent.com/102807742/219079534-c9dc2a54-51d9-4cd5-a291-8c9b389188c4.jpg)

### 설계 과정
#### 설계 요구사항
+ MVC 구조
+ “오브젝트” 책의 형태 적용
+ 설계에 대한 합당한 근거

#### 1차설계
![스크린샷 2023-02-13 오후 4 14 38](https://user-images.githubusercontent.com/102807742/219079647-36bbb3b6-7164-42c2-9f55-f4c27f985c01.png)


##### 1차 설계의 문제

+ 구조 가독성이 떨어집니다.
  + BaseballGameConsole과 의존관계 있는 객체가 EndLine, StartLine, ProgressLine, InputEndValidatePolicy, InputProgressValidatePolicy, InputValidator, Host로 너무 많은 객체와 의존관계가 있어 구조가 한 눈에 들어오지 않습니다.
  
+ 하나의 객체 안에 new 키워드가 너무 많습니다.
  + 객체 생성의 책임은 생성되는 객체를 가장 잘 아는 객체에 할당해야합니다.(정보전문가)
  
<img width="476" alt="스크린샷 2023-02-15 오후 9 31 29" src="https://user-images.githubusercontent.com/102807742/219079781-9e062916-b871-4d31-be24-6273b58edb94.png">

##### 해결책
+ Line구현체들을 묶어주는 Lines객체, 단순히 출력의 책임을 갖는 Speaker 객체로 나눠줍니다.
  + Lines, Speaker객체는 Host객체와 의존관계를 가집니다.
  + BaseballGameConsole은 Host객체에만 강한 의존관계를 가지게 됩니다.
  + BaseballGameConsole은 단순히 Host객체에 메시지를 보내고, 몰라도 되는 세부사항은 다른 객체 내부로 캡슐화 됩니다.
+ 각 객체를 생성하는 책임을 적절하게 다른 객체에게 분리해줌으로써 한 객체에 new 키워드가 많아지는 것을 해결했습니다.(1번 해결책과 동일합니다.)

#### 참고

##### < 오브젝트 1장 >
설계를어렵게만드는 것은 의존성이라는 것을기억하라. 해결방법은 불필요한 의존성을 제거함으로 써 객체 사이의 결합도를 낮추는 것이다. 예제에서 결합도를 낮추기위해 선택한 방법은 Theater가 몰라도되는 세부사항을 Audience와 Ticketseller 내부로 감춰 캡슐화하는 것이다.

##### < 오브젝트 5장 >
객체 A를 생성해야 할 때, 그 객체를 가장 잘 아는 객체 B에게 객체 생성 책임을 할당하라
