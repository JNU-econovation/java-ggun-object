# 숫자 야구 게임 - 리부트

[GitHub - woowacourse/java-baseball-precourse: 숫자 야구게임 미션을 진행하는 저장소](https://github.com/woowacourse/java-baseball-precourse)

## ⚾숫자 야구 게임 기능 요구사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## ✍🏻 입출력 요구사항

### ⌨️ 입력

- 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

### 🖥 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

`1볼 1스트라이크`

- 하나도 없는 경우

`낫싱`

- 3개의 숫자를 모두 맞힐 경우

`3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료`

### 💻 프로그래밍 실행 결과 예시

`숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼 
숫자를 입력해주세요 : 671
2볼 
숫자를 입력해주세요 : 216
1스트라이크 
숫자를 입력해주세요 : 713
3스트라이크 
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
…`

---

# 협력

### 용어 정리

협력 : 시스템의 어떤 기능을 구현하기 위해 객체들 사이에 이뤄지는 상호작용

문제 :  컴퓨터가 만든 3자리수

답안 :  사용자가 콘솔에 입력한 3자리 수

힌트 :  출력되는 스트라이크와 볼의 갯수, 낫싱

- 힌트가 정확히 어떤게 있는지
1. 1 스트라이크
2. 1스트라이크 1볼
3. 1스트라이크 2볼
4. 2 스트라이크
5. 2 스트라이크 1볼
6. 3 스트라이크 = 삼진아웃
7. 1 볼
8. 2 볼
9. 3 볼 = 낫싱

- **책임 주도 설계** → 위 같이 책임을 찾고 책임을 수행할 적절한 객체를 찾아 책임을 할당하는 방식
    1. 시스템이 사용자에게 제공하는 기능을 시스템이 담당할 하나의 책임으로 바라본다. 이게 **협력**이다.
        1. ex) 시스템은 사용자에게 영화를 예매할 수 있게 해야해
    2. 시스템 책임을 더 작은 책임으로 분할한다.
    3. 분할 된 책임을 수행할 수 있는 적절한 객체 또는 역할을 찾아 책임을 할당한다.
        1. 객체가 책임을 수행하는 도중 다른 객체의 도움이 필요하면 이를 책임질 적절한 객체 또는 역할을 찾는다.
    4. 2~3번을 반복한다.
    

---

## 사용자와 Application간의 협력

1. **사용자가 콘솔에 입력하는 협력**
    1. *사용자가 3자리의 숫자를 입력하는 협력* 
        1. 사용자의 입력을 받을 책임
        2. 입력받은 3자리수를 저장할 책임
        3. 입력 받은 문자를 숫자 타입으로 변환하는 책임
    2. *사용자의 입력을 검증하는 협력*
        1. 3자리 숫자인지를 검증하는 책임
        2. 띄어쓰기가 되어있는 지 검증하는 책임
        3. 문자열의 길이가 3인지 검증하는 책임
        4. IllegalArgumentException을 발생시킬 책임

1. **Application이 재시작하는 협력**
    1. 사용자의 입력을 받을 책임
    2. *사용자의 입력을 검증하는 협력*
        1. 입력이 1인지 검증하는 책임
        2. 띄어쓰기가 되어있는 지 검증하는 책임
        3. 문자열의 길이가 1인지 검증하는 책임
        4. IllegalArgumentException을 발생시킬 책임
    3. 기존의 저장된 것을 삭제할 책임
    4. 재시작을 할 책임
        
        
2. **Applicatoin이 종료하는 협력**
    1. 사용자의 입력을 받을 책임
    2. *사용자의 입력을 검증하는 협력*
        1. 입력이 2인지 검증하는 책임
        2. 띄어쓰기가 되어있는  지 검증하는 책임
        3. 문자열의 길이가 1인지 검증하는 책임
        4. IllegalArgumentException을 발생시킬 책임
    3. 종료할 책임
    
3. **콘솔이 사용자에게 출력해주는 협력**
    1. *힌트를 출력할 협력*
        1. 힌트를 알고 있을 책임
        2. 힌트를 출력할 책임
    2. *안내문을 출력할 협력*
        1. “숫자를 입력해주세요 : ” 안내문을 출력할 책임
        2. “게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.” 안내문을 출력할 책임
    

## Application안에서 객체들간의 협력

1. **컴퓨터가 3자리 수를 생성하는 협력**
    1. 하나의 수를 생성한다. 
    2. 하나의 수가 1~9인지를 검증한다.
    3. 수를 저장한다.
    4. 생성된 수들이 서로 다른 지 검증한다.
    5. 답안을 저장한다.
    
2. ***문제와 답안을 비교하는 협력***
    1. 문제를 알고있는 책임
    2. 답안을 알고있는 책임
    3. 같은 수가 존재하는 지 확인하는 책임
    4. 같은 자리에 존재하는 지 확인하는 책임

1. **힌트를 결정하는 협력**
    1. 힌트를 결정하는 책임
    
- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트

~~동일한 숫자가 존재하지 않을 때 낫싱을 반환할? 책임~~

---

## 사용자 ↔ 애플리케이션 책임

1. **사용자가 콘솔에 입력하는 협력**
    1. *사용자가 3자리의 숫자를 입력하는 협력* 
        1. 사용자의 입력을 받을 책임
        2. 입력 받은 문자를 숫자 타입으로 변환하는 책임
    2. *사용자의 입력을 검증하는 협력*
        1. 3자리 숫자인지를 검증하는 책임
        2. 띄어쓰기가 되어있는 지 검증하는 책임
        3. 문자열의 길이가 3인지 검증하는 책임
        4. `IllegalArgumentException`을 발생시킬 책임

1. **Application이 재시작하는 협력**
    1. 사용자의 입력을 받을 책임
    2. *사용자의 입력을 검증하는 협력*
        1. 입력이 1인지 검증하는 책임
        2. 띄어쓰기가 되어있는  지 검증하는 책임
        3. 문자열의 길이가 1인지 검증하는 책임
        4. `IllegalArgumentException`을 발생시킬 책임
    3. 재시작을 할 책임
        
        
2. **Applicatoin이 종료하는 협력**
    1. 사용자의 입력을 받을 책임
    2. *사용자의 입력을 검증하는 협력*
        1. 입력이 2인지 검증하는 책임
        2. 띄어쓰기가 되어있는  지 검증하는 책임
        3. 문자열의 길이가 1인지 검증하는 책임
        4. IllegalArgumentException을 발생시킬 책임
    3. 종료할 책임
    
3. **콘솔이 사용자에게 출력해주는 협력**
    1. *힌트를 출력할 협력*
        1. 힌트를 알고 있을 책임
        2. 힌트를 출력할 책임
    2. *안내문을 출력할 협력*
        1. “숫자를 입력해주세요 : ” 안내문을 출력할 책임
        2. “게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.” 안내문을 출력할 책임

 

1. 
    1. 
        1. Input
        2. Converter
    2. 
        1. InputValidator
        2. InputValidator
        3. InputValidator
        4. IllegalArgumentException
            1. NoThreeDigitsNumberException
            2. SpacingException
            3. NoThreeLengthException
            
2. 
    1. Input
    2. 
        1. InputValidator
        2. InputValidator
        3. InputValidator
        4. IllegalArgumentException
            1. NoEqualToOneInputException
            2. NoSpacingException
            3. NoOneLengthException
    3. BaseBallController
3.  
    1.  
        1. Input
        2. Output
    2.  
        1. Output
        2. Output
        
1.  
    1. Input
    2.  
        1. InputValidator
        2. InputValidator
        3. InputValidator
        4. llegalArgumentException
            1. NoEqualToTwoNumberException
            2. SpacingException
            3. NoOneLengthException
    3. BaseBallController
    

---

## 애플리케이션 ↔ 애플리케이션 책임

1. **컴퓨터가 3자리 수를 생성하는 협력**
    1. 하나의 수를 생성한다. (1~9)
    2. 서로 다른 3자리 수를 생성한다.
    3. ~~하나의 수가 1~9인지를 검증한다.~~
    4. ~~생성된 수들이 서로 다른 지 검증한다.~~
    
2. **컴퓨터가 만든 3자리수*와 사용자가 입력한 세자리수을 비교하는 협력***
    1. **컴퓨터가 만든 3자리수**를 알고있는 책임
    2. ***입력한 세자리수***을 알고있는 책임
    3. Strike가 몇 개 있는 지 확인하는 책임
    4. Ball이 몇개 있는 지 확인하는 책임

1. **힌트를 결정하는 협력**
    1. 힌트를 결정하는 책임

1. 
    1. BallMaker
    2. BallMaker
    

2.

1. Referee
2. Referee
3. Baseballs
4. Baseballs

1. 
    1. Hint

# 1차 설계 - 객체별 책임 할당 근거

![Untitled](%E1%84%89%E1%85%AE%E1%86%BA%E1%84%8C%E1%85%A1%20%E1%84%8B%E1%85%A3%E1%84%80%E1%85%AE%20%E1%84%80%E1%85%A6%E1%84%8B%E1%85%B5%E1%86%B7%20-%20%E1%84%85%E1%85%B5%E1%84%87%E1%85%AE%E1%84%90%E1%85%B3%2009c406cd0a1e47ac9e4a6c6dbbb3b626/Untitled.png)

## Input과 InputValidator

---

Input의 책임 : 사용자로부터 입력을 받을 책임

InputValidator의 책임 : 사용자가 입력한 값들이 요구사항에 맞는 값인지를 검증하는 책임

- 기존 Controller에서 Input 객체를 인스턴스 변수로 생성하고, 입력을 유저로 부터 받아 Validator에 Input을 직접 넣어주던 방식에서 아래와 같이 Input에서 InputValidator를 인스턴스 변수로 생성해서, 합성을 사용하는 방법으로 변경했습니다.
    - 변경 사유 : 기존 방식은 Controller가 Input, InputValidator 모두 의존하고 있어야 했습니다. 불필요한 의존을 끊기 위해서 InputValidator가 Input만을 의존하는 방식으로 변경하였습니다.

```java
public class Input {

    private InputValidator inputValidator = new InputValidator();
    public String inputUserBalls() {
        String userBalls = Console.readLine();
        inputValidator.validateUserBalls(userBalls);
        return userBalls;
    }

    public String inputRestartNumber() {
        String restartNumber = Console.readLine();
        inputValidator.validateRestartNumber(restartNumber);
        return restartNumber;
    }

    public String inputEndNumber() {
        String endNumber = Console.readLine();
        inputValidator.validateEndNumber(endNumber);
        return endNumber;
    }
}
```

```java
public class InputValidator {

    public void validateUserBalls(String userBalls) throws IllegalArgumentException {
        // 각 검증 메서드들을 호출하여 검증함.
        validateSpacingException(userBalls);
        validateIntegerType(userBalls);
        validateThreeDigitsNumber(userBalls);

    }

    public void validateRestartNumber(String userBalls) throws IllegalArgumentException {
        // 각 검증 메서드들을 호출하여 검증함.
        validateSpacingException(userBalls);
        validateInputNumberEqualToTwo(userBalls);
        validateOneDigit(userBalls);
    }

    public void validateEndNumber(String userBalls) throws IllegalArgumentException {
        // 각 검증 메서드들을 호출하여 검증함.
        validateSpacingException(userBalls);
        validateInputNumberEqualToOne(userBalls);
    }

    // initial input

    private void validateIntegerType(String userBalls) throws NoIntegerTypeException {
        // 숫자 타입인 지를 검증하는 책임
    }

    private void validateThreeDigitsNumber(String userBalls) throws NoThreeDigitsNumberException {
        // 3자리인지 를 검증하는 책임
    }

    // end

    private void validateInputNumberEqualToOne(String restartNumber) throws NoEqualToOneNumberException {
        // 입력이 1인지 검증하는 책임
    }

    // restart

    private void validateInputNumberEqualToTwo(String endNumber) throws NoEqualToTwoNumberException {
        // 입력이 2인지 검증하는 책임
    }

    private void validateOneDigit(String restartNumber) throws NoOneDigitNumberException {
        // 문자열의 길이가 1인지 검증하는 책임
    }

    // 공통

    private void validateSpacingException(String userBalls) throws SpacingException {
        // 띄어쓰기가 되어있는 지 검증하는 책임
    }

}
```

## Output

---

output의 책임 : 사용자에게 출력 해줄 책임

- output은 Hint 객체로부터 결정된 힌트를 출력해주며, 또한 재시작과 종료시 나오는 문장도 출력해줍니다.
- Hint안에서 Output객체를 인스턴스 변수로 사용한다면, Hint와 Output객체간에 약한 의존성이 생깁니다. 그러나 BaseballController에서 Output객체를 인스턴스 변수로 사용하여서, Hint 객체를 인자로 전달해준다면, Hint와 PrintHrint와 BaseballController의 의존성이 추가로 생깁니다. 따라서 ,Hint안에서서 Output를 호출하기로 하였습니다.


```java
public class Output {

    public static void printHint(String hint) {
        System.out.println(hint);
    }

    public static void printNumberSentence() {
        System.out.println("숫자를 입력해주세요 :");
    }

    public static void printEndSentence() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printChoiceSentence() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ");
    }
}
```

## Converter

---

Converter의 책임 : 사용자에게 입력 받은 문자 타입의 공들을 숫자 타입의 공들로 변환 시켜주는 책임

```java
public class Converter{

    public static List<Integer> convertToNumbers(String userBalls) {

        List<Integer> intUserBalls = new ArrayList<>();
        return intUserBalls;
    }
}
```

## Exception

---

Exception의 책임 : 잘못된 입력값에 대한 잘못된 예외를 반환해 줄 책임

- IllegalArgumentException 예외를 추상화 하여서 예외 이름으로 만으로도  무슨 예외인지를 더 쉽게 파악할 수 있게 하였습니다.

```java
public class NoEqualToOneNumberException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE = "";

    public NoEqualToOneNumberException() {
        super(EXCEPTION_MESSAGE);
    }
}
```

```java
public class NoEqualToTwoNumberException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "";

    public NoEqualToTwoNumberException() {
        super(EXCEPTION_MESSAGE);
    }
}
```

```java
public class NoIntegerTypeException extends IllegalArgumentException {
    private static final String EXCEPTION_MESSAGE = "";

    public NoIntegerTypeException() {
        super(EXCEPTION_MESSAGE);
    }
}
```

```java
public class NoOneDigitNumberException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE = "";

    public NoOneDigitNumberException() {
        super(EXCEPTION_MESSAGE);
    }
}
```

```java
public class NoThreeDigitsNumberException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE = "";

    public NoThreeDigitsNumberException() {
        super(EXCEPTION_MESSAGE);
    }
}
```

```java
public class SpacingException extends IllegalArgumentException {

    private static final String EXCEPTION_MESSAGE = "";

    public SpacingException() {
        super(EXCEPTION_MESSAGE);
    }
}
```

## Baseballs와 BallMaker

---

BallMaker의 책임 : 컴퓨터의 3자리수를 생성하는 책임

- 객체가 자신의 상태, 즉 정보에 대한 처리책임을 자신 스스로 가진다는 데 있다
- 정보에 대한 처리 책임 즉 정보를 사용하는 것은 객체를 생성한 후에 일어나는 것이기때문에 정보를 생성하는 것과는 다르다고 생각하여, 기존에 Baseballs에 있던 컴퓨터의 3자리수를 생성하는 책임을 분리시켰습니다.

```java
public class Baseballs{

    private final List<Integer> baseBalls;

    public Baseballs(List<Integer> baseBalls){
        this.baseBalls = baseBalls;
    }

    public Integer countStrikeNumber(List<Integer> userBalls){
        Integer strike = 0;
        return strike;
    }
    public Integer countBallNumber(List<Integer> userBalls){

        Integer ball = 0;
        return ball;
    }

}
```

```java
public class BallMaker {

    private Integer createOneBall(){
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return randomNumber;
    }

    public Baseballs createBalls() {
        List<Integer> computerBalls = new ArrayList<>();
        while (computerBalls.size() < 3) {
            int randomNumber = createOneBall();
            if (!computerBalls.contains(randomNumber)) {
                computerBalls.add(randomNumber);
            }
        }
        return new Baseballs(computerBalls);
    }
}
```

## Referee

---

Referee는 컴퓨터가 만든 3자리수(=Baseballs)와 Hint를 알 책임이 있습니다.

Referee는 컴퓨터가 만든 3자리수와 사용자가 입력한 3자리수를 비교하는 책임을 가지고 있습니다.

```java

public class Referee {

    Baseballs baseballs;

    Hint hint;

    public void compareBalls(List<Integer> userBalls){
        Integer strikeNumber = baseballs.countStrikeNumber(userBalls);
        Integer ballNumber = baseballs.countBallNumber(userBalls);
        hint.makeHint(strikeNumber,ballNumber);
    }

}
```

 

비교하는 책임이 왜 Baseballs에 있지않고, Referee에 있나??

compareBalls(List<Integer> userBalls)에서 사용자가 입력한 3자리수를 매개변수로 받고있기 때문에, Baseballs의 상태가 아니라고 판단했습니다.

(Baseballs는 컴퓨터가 입력한 3자리수와 관련된 정보입니다.)

## Hint

---

Hint는 힌트를 결정할 책임이 있습니다.

```java
public enum Hint {

		BALL("볼"),
		STRIKE("스트라이크"),
		NOTHING("낫싱"),
    ;
    String message;

    private Hint(String message){
        this.message = message;
    }

    public void makeHint(Integer strikeNumber, Integer ballNumber){

        if (strikeNumber == 0 && ballNumber == 0) {
            Output.printHint(NOTHING.message);
        } else if(strikeNumber > 0 && ballNumber == 0){
            Output.printHint(strikeNumber +STRIKE.message);
        } else if(strikeNumber == 0 && ballNumber >0){
            Output.printHint(ballNumber +BALL.message);
        } else if(strikeNumber == 3 && ballNumber == 0){
            Output.printHint(strikeNumber +STRIKE.message);
        } else {
            Output.printHint(strikeNumber +STRIKE.message + ballNumber +BALL.message);
        }
    }
}
```

---

# ❓ 궁금한 점

- 팩토리를 인터페이스로 만드는 이유는 뭘까? 그리고 만들었을 때의 장점은 무엇인가??
    - Simple 팩토리에서는 객체가 부모-자식 간의 추상 관계일 때 사용하는 거다.
        - ex) 부모 : Pizza -  자식 : Cheeze & Pepperoni & peper
    - 팩토리를 인터페이스로 만들 때는 객체가  부모 - 자식 - 손자간의 추상 관계일 때 사용하는 거다.
        - ex) 부모 : Pizza - 자식 :  Cheeze - 손자 : DominoCheeze & NwCheeze
    
    - Hint는 Baseball 안에 속해야 하는가? 속하면 안되는가?
        - Hint에 사용되는 데이터(자릿수)는 Baseball이 가지고 있는 데이터가 아니라, Baseball의 메서드의 리턴값이기에 Hint는 따로 분리되어야 한다.
    - Util클래스는 뭘까?
    - static class, 메서드 static

---

# ✅ 객체지향 10계명

## 설계

- [ ]  `시스템의 기능을 협력이란 문맥으로 얼마나 잘 표현했는 지`
- [ ]  `한 객체에게 부여할 책임은 최대 2개이다`
- [ ]  `객체에 적절한 책임을 할당하였는가`
- [ ]  `객체 간에 오직 메시지를 통해서만 상호작용하public도록 만들었는가`
- [ ]  `클래스를 작성 하기 전에 앞서서 먼저 협력의 관점에서 어떤 객체가 필요한지를 결정하였는가.`

## 구현

- [ ]  `객체 내부의 상태는 캡슐화하고, 인터페이스만을 공개하였는가`
- [ ]  `상속과 합성 곧 추상 클래스와 인터페이스를 적절히 활용하였는가`
- [ ]  `직접 의존성을 간접 의존성으로 바꿔 직접 의존성을 최소화하기`
- [ ]  `객체 타입을 사용하여서, 멤버 변수의 개념을 명시적으로 표현하였는가`
- [ ]  `코드의 의존성과 실행 시점(객체를 생성하는 시점)의 의존성이 서로 달라야 한다.`
- [ ]  `상속을 인터페이스를 재사용하려는 목적으로만 사용했는가.`

- **개발 방향**
    - `오늘 요구하는 기능을 온전히 수행하면서 내일의 변경을 매끄럽게 수용할 수 있도록 개발하기`
    - `작성하는 모든 코드에는 합당한 이유가 있이 작성하기`

- **Extra**
    - 시스템의 기능, 즉 요구 사항 == 협력을 책임들로 잘 나눠놓을 수 있도록 잘 정의하자.

---

# ✅어떤 순서로 설계할지

```
1. 시스템의 기능을 협력이란 문맥으로 만들어라
2. 협력안에서 책임들을 정의하라(메시지를 만들어라)
3. 메시지를 처리할 객체들을 정의하라
4. 행동을 수행하는 데 필요한 정보 곧 객체의 상태를 정의하라

3번과 4번의 경우, 일단 메시지를 받을 객체를 만들어라!
만들어진 객체는 이 메시지를 처리해야만 한다. 만약, 다 처리하는 게 어렵다면 다른 객체에게 책임을 전가하라!
```

---

# ✅위 순서를 프로그래밍으로 풀었을 때

1. 요구사항을 잘 정리하라. - 도메인 구조 설계
2. 요구사항을 해결하는데 필요한 메시지(인터페이스)들을 쭉 나열하라(정의하라).
3. 메시지를 수신(수행)할 수 있는 객체를 생성 or 할당하라.
    1. 이 때 객체에 책임이 할당된다.
    - 어떤 기준으로 생성 or 할당해??
        - 객체들이 없는 상태라면 생성, 도메인 기준으로 정보 전문가를 판단하거나
        - 객체들이 충분히 구현된 상태라면 할당, 객체에 책임을 수행하는 데 필요한 정보 혹은 책임을 수행할 수 있는 객체에대한 정보가 있어야한다.
4. 책임을 수행할 메서드를 객체 내에서 만든다.
5. 메서드에 필요한 상태를 객체에 부여한다.

---

# ✅ 책갈피

- 힌트를 결정할 때, 즉 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 대부분의 경우 좋지 않은 선택이다. 항상 예외 케이스를 최소화하고, 일관성을 유지할 수 있는 방법을 찾아라. - 67P

---

# ✅우리가 스터디 하면서 깨달은 점

- **디자인 패턴을 사용해보자!**
    - 우리 설계대로면 Print 객체가 여러 객체 내에서 여러번 생성 되어야 하네? → 객체를 한번만 생성하도록 하면 어떨까? → 스프링에서 배웠던 싱글톤 패턴을 적용해보자!
    - IF문으로 객체 생성을 다르게 하자 → 아니 그러면 비교 객체에서 너무 많은 의존성이 생기는거 아냐? → 팩토리 패턴을 적용해보자!
- **객체지향은 네이밍이다.**
    - 메시지를 처리할 객체를 정하는 것 = 메시지를 처리할 수 있는 적절한 이름을 객체에 부여하는 것 .
- **협력의 흐름을 끊자.**
    - 객체지향에서 협력을 나눌 때 생각해야할 것은 흐름을 끊는 것이다. 다시 말해서, 어떠한 것이든 흐름이 있을 수 있는 데 이 흐름을 적절하게 끊는 것이 협력을 나누는 법이 아닐까.
- **캡슐화를 통해 책임의 자율성을 높이자.**
    - 본인의 상태를 관리하는 책임들 안에서는 해당 책임이 몇 개가 있든 중요하지않다.
- **변경성과 확장성을 늘 고려하자.**
    - 이 객체가 바뀌지 않을 거라는 확신을 하지말자.
- **데이터와 프로세스가 동일한 모듈 내부에 위치시켜서 스스로를 책임지는 자율적인 객체로 만들자.**
    - baseBall 객체가 본인이 가지고 있는 baseball 데이터와 이를 사용하는 프로세스를 가지고 있다면, 객체지향 프로그래밍 방식을 따르고 있을 확률이 높다 → 자율적인 객체이기 때문에

---

# ♥마음 가짐♥

- 코드 없는 설계는 없다.
- 우리는 절대 꺾이지 않는다.

[레퍼런스](https://www.notion.so/850b681517804e43bc16d15618c19932)