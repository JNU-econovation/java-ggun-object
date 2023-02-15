# 정리

---

객체지향 설계의 핵심 : 협력을 구성하기 위해 적절한 객체를 찾고, 적절한 책임을 할당하는 것이다.   

협력 : 객체들이 애플리케이션의 기능을 구현하기 위해 수행하는 상호작용   
책임 : 객체가 협력에 참여하기 위해 수행하는 로직   
역할 : 객체들이 협력 안에서 수행하는 책임들이 모인 것  

협력을 만들고, 책임을 할당해, 만약 비슷한 책임이 있다면 역할로 묶어! 

### 협력


협력을 하는 방법은 <b>메시지 전송</b>이다.  

오브젝트 3장 75p 
    
    Screening이 Movie에게 처리를 위임하는 이유는 요금을 계산하는 데 필요한 기본 요금과 할인 정책을 가장 잘 알고있는 객체가 Movie이기 때문이다.

<br>

Movie 클래스는 아래와 같다.

    public class Movie {

        private String title;
        private Duration runnringTime;
        private Money fee;
        private DiscountPolicy discountPolicy;


        public Movie(String title, Duration runnringTime, Money fee, DiscountPolicy discountPolicy) {
            this.title = title;
            this.runnringTime = runnringTime;
            this.fee = fee;
            this.discountPolicy = discountPolicy;
        }

        public Money getFee() {
            return fee;
        }
    
        public Money calculateMoviewFee(Screening screening) {
            return fee.minus(discountPolicy.calculateDiscountAmount(screening));
        }
    }


Movie에게 예매 요금을 계산하는 책임을 부여한 이유 : Movie 클래스는 인스턴스로 fee와 discountPolicy를 가지고 있다.  

<br>

오브젝트 76p 

    자율적인 객체는 자신에게 할당된 책임을 수행하던 중에 필요한 정보를 알지 못하거나 외부의 도움이 필요한 경우 적절한 객체에게 메시지를 전송해서 협력을 요청한다. 메시지를 수신한 객체도 직접 처리할 수 없는 정보나 행동이 필요한 경우 다른 객체에게 도움을 요청한다.

    
협력안에서 한 객체는 메시지를 보내고, 메시지를 받은 객체는 자신이 처리할 수 있는 부분을 처리하고, 처리할 수 있는 부분은 처리할 수 있는 객체에게 넘긴다.(한번에 처리할 수 없을 수도 있다.)   


오브젝트 77p


    public class Movie {

        private Money fee;
        private DiscountPolicy discountPolicy;

        public Money calculateMoviewFee(Screening screening) {
            return fee.minus(discountPolicy.calculateDiscountAmount(screening));
        }
    }

'영화를 예매해라'는 협력에 Movie객체가 참여하는 이유는 요금을 계산하는 책임을 지고 있기 때문이다.  
요금을 계산하는 책임 곧 요금을 계산하기 위해서는 fee와 dicountPolicy 정보가 필요하다.  

### 중간 결론

1. 시스템의 기능을 협력이란 문맥으로 만들어라
2. 협력안에서 책임들을 정의하라(메시지를 만들어라)
3. 메시지를 처리할 객체들을 정의하라
4. 행동을 수행하는 데 필요한 정보 곧 객체의 상태를 정의하라

3번과 4번의 경우, 일단 메시지를 받을 객체를 만들어라!   
만들어진 객체는 이 메시지를 처리해야만 한다. 만약, 다 처리하는 게 어렵다면 다른 객체에게 책임을 전가하라!   

<br>

## 책임  

중간 결론의 3번에서 '메시지를 처리하는 것' = '책임'   

오브젝트 79p 

    Screening이 reserve 메시지를 수신하고, movie를 인스턴스 변수로 포함하는 이유는 협력 안에서 영화를 예매할 책임을 수행하기 때문이다.

협력안에서 책임이 결정되고, 이 책임을 부여할 객체를 정한 후 책임을 부여 받은 객체는 인터페이스와 내부의 속성이 결정된다.   

<b> 객체에게 얼마나 적절한 책임을 할당하느냐가 설계의 품질을 결정한다. </b>

<br>

### CRC 카드   

C(Candidate), R(Responsibility), C(Collaborator)   

CRC 카드는 협력에 참여하는 하나의 후보를 표현한다.   

CRC 카드를 이용해 설계를 진행한다면 ...  

1. 시스템의 기능을 협력이란 문맥으로 만들어라
2. 협력안에서 책임들을 정의하라(메시지를 만들어라)
3. 메시지를 처리할 객체들을 정의하라
4. 행동을 수행하는 데 필요한 정보 곧 객체의 상태를 정의하라


2~3 번을 CRC 카드로 한다면...
협력에 참여하는 후보를 표현한다.   
후보의 목적을 적는 데 후보의 목적은 책임들을 가지고 있는다.(책임이 1개일 수도 있다.)   
후보의 책임들을 나열하고 책임을 완수하기 위해 협력할 협력자들을 적는다.   

<br>

오브젝트 86p

    객체는 협력이라는 주어진 문맥 안에서 특정한 목적을 갖게 된다. 객체의 목적은 협력 안에서 객체가 맡게 되는 책임의 집합이다. 그리고 이를 '역할'이라고 부른다.   


실제로 협력을 모델링 할 때는 특정한 객체가 아니라 역할에게 책임을 할당한다.

그렇다면, 

1. 시스템의 기능을 협력이란 문맥으로 만들어라
2. 협력안에서 메시지를 만들어라
3. 메시지를 처리할 <b>역할</b>을 정의하라
4. <b>역할</b>이 수행할 책임을 결정하라
5. 책임을 객체에게 할당하라
6. 객체가 행동을 수행하는 데 필요한 정보 곧 객체의 상태를 정의하라

<br>

역할은 추상화이다  

역할을 구현하는 일반적인 방법은 추상 클래스와 인터페이스를 사용하는 것이다.  

추상 클래스 : 책임의 일부를 구현해 놓은 것   
인터페이스 : 일체의 구현 없이 책임의 집합만을 나열해 놓은 것   

상황에따라서 역할을 추상 클래스 혹은 인터페이스로 구현한다.

<br>









