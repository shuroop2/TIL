# TIL_Day_32

> 2022년 07월 01일

## 스프링 프레임워크 (Spring Framework)

### 스프링 프레임워크

- 엔터프라이즈 애플리케이션 구축을 위한 솔루션
- 자바 애플리케이션 개발을 위한 포괄적인 인프라 지원을 제공하는 자바 플랫폼
  - 스프링에서 인프라를 처리하므로 개발자는 애플리케이션 개발에만 집중
- 모듈화되어 있어 필요한 부분만 사용 가능
- 국내에서는 자바 개발자들에게 표준 프레임워크

#### 스프링 프레임워크를 시작하기 전 선행 학습

- Java
- HTML / CSS / JavaScript / jQuery
- JSP / Servlet

#### 스프링의 장점

- 생산성 우수
- 품질 보증
- 유지보수 용이

#### 생산성 우수

- 엔터프라이즈 애플리케이션 구축을 위한 솔루션이지만 가볍고 모듈화되어 있어서 필요한 부분만 사용 가능
- POJO 클래스와 약간의 설정만으로도 개발이 가능하므로 개발 생산성을 높일 수 있음
- 실제 스프링을 적용하면 적용하지 않은 코드의 1/3 정도의 코드만으로 개발 가능

#### EJB (Enterprise Java Bean)

- 규모가 커지고 복잡한 애플리케이션 제작을 위해 만들어진 기술
- 컴포넌트 기반
- extends, implements를 많이 사용해서 클래스 의존도가 높고, 복잡하고 제한이 많은 문제
- 별도로 종속되지 않고 간단한 자바 객체를 사용하자는 의도에서 나온 것이 POJO
- Java EE 등의 중량 프레임워크들을 사용하게 되면서 해당 프레임워크에 종속된 "무거운" 객체를 만들게 되는 것에 반발해서 사용하게 된 용어

#### POJO (Plain Old Java Object)

- 자바 언어 사양 외에 어떠한 제한에도 묶이지 않은 자바 객체
- 특정 환경과 규약에 종속되지 않아 필요에 따라 재사용될 수 있는 방식으로 설계된 객체
- 즉, 다른 클래스를 상속 받거나 인터페이스를 구현해야 하는 규칙이 없는 자바 클래스
- 미리 정의 클래스 확장
  - 예 : public class Test extends javax.serv…..{ }
- POJO 대표적인 예
  - Java Bean
    - 생성자와 Getter/Setter만 지닌 단순 자바 객체
    - DTO / VO
- 대표적인 POJO 기반 프레임워크
  - 스프링 프레임워크
  - POJO를 사용하는 장점과 EJB에서 제공하는 엔터프라이즈 서비스와 기술을 그대로 사용할 수 있도록 지원하는 프레임워크
- 품질 보증
  - 스프링 프레임워크는 이미 검증된 많은 아키텍처 또는 디자인 패턴을 적용하여 만들어졌기 때문에 코드에 아키텍처를 구현하기 위한 코드나 디자인 패턴을 사용하기 위한 코드를 개발자가 만들 필요가 없음
  - 이는 개발에 일관성을 제공해 주고 소프트웨어의 품질을 보증
- 유지 보수 용이
  - 스프링 프레임워크를 사용하여 작성된 애플리케이션들을 유지보수 하는데 소용되는 인력과 시간을 줄일 수 있기 때문에 여러 프레임워크 중에서 스프링 프레임워크가 업계 표준으로 자리잡음

#### 스프링 프레임워크의 특징

- POJO 기반 프레임워크
  - 자바 객체의 라이프사이클을 스프링 컨테이너가 직접 관리하고 스프링 컨테이너로부터 필요한 객체를 얻어 옴
- DI (Dependency Injection) 지원
  - 의존성 주입
  - 각 계층이나 서비스들 사이 또는 객체들 사이의 의존성이 존재할 경우에 스프링 프레임워크가 서로 연결시켜 줌 (클래스 간 약한 결합 가능)
- AOP (Aspect Oriented Programming) 지원
  - 관점 지향 프로그래밍 트랜잭션 로깅, 보안 등 여러 모듈에서 공통적으로 지원하는 기능을 분리하여 사용 가능
  - 반복적인 코드를 줄이고 개발자가 비즈니스 로직에만 집중할 수 있도록 지원
- 뛰어난 확장성
  - 스프링 프레임워크의 소스는 모두 라이브러리로 분리되어 있어서 필요한 라이브러리만 가져다 사용하면 됨
- Model2 방식의 MVC Framework 지원
  - Model / View / Controller
  - JSP MVC 때보다 코드가 간결

#### 스프링 프레임워크의 핵심 기능

- 의존관계에 있는 객체를 생성 조립해 주는 기능
- DI (Dependency Injection) : 의존성 주입
  - 객체 간의 의존성을 개발자가 설정하는 것이 아니라 스프링 컨테이너가 주입시켜 주는 기능
  - 장점 : 객체를 쉽게 확장하고 재사용할 수 있음
- IoC (Inversion of Control) : 제어의 역전
  - 객체에 대한 제어권 문제
  - 기존에는 개발자에게 제어권이 있었음
    - new 연산자를 사용해서 객체 생성
  - 스프링 프레임워크에서는 객체의 제어권이 스프링에 있고 인스턴스의 라이프 사이클(생성에서 소멸까지)을 개발자가 아닌 스프링 프레임워크에서 담당
- 의존 관계
  - ![img](https://lh4.googleusercontent.com/9wj3Tyjl988u2j4L9EghI57OLtiUOhEzvzMvNBVWtm1z0Vb19GW6t6-k1YTUVVKWcpdMZ_6DokHb7MzvkikI_gSlm80qwik6f-x66WtMxxmaxGWEKa3_tH3NegpdEwJ9u6lVIquZ)

#### 스프링 웹 프로젝트

- Spring Legacy Project
  - 스프링 템플릿 프로젝트를 이용하는 프로젝트
  - 모델2 방식(MVC)의 프로젝트 생성 시 사용
  - Spring MVC Project
  - 서버 및 여러 설정 필요 (개발자 다 설정해야 함)
  - 실제 개발 업무에서 많이 사용
- Spring Starter Project
  - Spring Boot을 이용하는 프로젝트
  - 최대한 간단하게 실행하고, 배포가 가능한 수준의 웹 애플리케이션을 제작하기 위한 목적
  - 개발에 필요한 모든 환경 설정을 갖춰면서 최소한의 개발을 해야 하는 경우 사용
  - 개발자 복잡한 설정 없이 모든 개발 환경이 준비되기 때문에 초보 개발자도 쉽게 웹 프로젝트 생성 가능
  - 최근에는 Spring Boot 프로젝트 많이 사용
- Simple Spring Maven (Maven Project)
  - Spring 라이브러리의 기본 세트를 포함하는 Maven을 사용하여 간단한 Spring 프로젝트 생성
- Maven (메이븐)
  - Java용 프로젝트 관리도구
  - XML 기반의 정적인 빌드 제공
- 그레이들 (Gradle)
  - 그루비(groovy) 스크립트 기반의 동적인 빌드 기능 제공
  - 안드로이드 앱을 만들 때 필요한 공식 빌드 시스템
  - 메이븐보다 빌드 작업이 간단하며 프로그래밍만으로 기능 추가 가능
  - 별도의 빌드 스크립트를 통하여 사용할 애플리케이션 버전, 라이브러리 등 설정

#### 의존성 (Dependency)

- 객체 간 의존성

- 한 클래스가 다른 클래스의 객체를 통해 그 클래스의 메소드를 실행할 때 이를 '의존'한다고 표현

- new 연산자를 통해 다른 클래스의 객체 생성 사용

- ex1)
  - MemInsertController 클래스에서 MemberDAO 클래스의 객체 dao를 생성해서 MemberDAO 클래스의 insert() 메소드 사용
  
  - ```java
    MemberDAO dao = new MemberDAO();
    dao.insert(dto);
    ```
  
- ex2)
  - ```java
    BoardDTO dto = new BoardDTO();
    ```
  
- ![img](https://lh5.googleusercontent.com/AxpuK_QLI1oL_lXFbeT0XWlla-FkZLWQz6PfK1YWIx6KlcsI3GtNWwPDJCv8IFKgpKNmVaI149pGWdY5T7mZZIUgdgsvranBm_0y0zdVKjE7dTb_GSCWYnm1qS5gtK0-Sm9AheRi)

#### DI (Dependency Injection : 의존성 주입)

- 외부에서 빈(객체)을 만들어 필요로 하는 곳에 전달해 주도록 하는 것
- 즉, 개발자가 new 연산자를 사용하여 직접 객체를 생성하지 않고 외부에서 생성된 bean(객체)을 IoC 컨테이너가 넣어 주는 방식 (주입 : injection)
- 일반적으로 부품(빈)을 조립(의존성 주입)해서 사용한다고 함

#### DI (의존성 주입) 방법을 사용하는 이유

- 의존하는 객체의 클래스가 변경되거나 다른 클래스의 객체를 사용하게 될 경우

- 의존 관계(결합 관계)에 있는 다른 모든 클래스들의 소스 코드도 변경해야 하는데, 의존성 주입 방법을 사용하면 클래스 결합 상태를 변경하거나 객체를 주입하는 부분만 수정하면 되므로 수정할 코드의 양을 줄일 수 있다는 장점이 있음

- 예

  - A1 클래스를 사용하다가 A2 클래스로 변경할 경우

  - 설정 파일에서 클래스 이름만 변경하면 됨

  - ```java
    <bean id="a" class="sec01.A1">
    <bean id="a" class="sec01.A2">
    ```

#### 스프링에서 의존성 주입 방법

- XML을 이용한 방법
  - XML 설정 파일에 `<bean>` 설정
- Annotation을 이용한 방법
  - 자바 코드에서 '@어노테이션이름'으로 설정

1. 스프링을 사용하지 않는 DI

   1. DI를 사용하지 않는 코드
      - 의존성 관계가 있는 객체를 개발자가 new 연산자를 이용해서 직접 생성
   2. DI를 사용하는 코드
      - 생성자 기반 DI
        - 의존성 관계에 있는 객체를 new를 통해 직접 생성하지 않고 생성자를 통해 외부에서 전달 (주입 : injection)
      - Setter 기반 DI
        - Setter 메소드를 이용하여 의존성 주입

2. 스프링 DI

   1. XML을 이용한 DI

      - XML 파일에 빈(bean : 부품)을 정의(생성)하고

        - ```xml
          <bean id="이름" class="패키지명.클래스명">
          ```

      - 의존성 설정 (부품 조립)

        - ```java
          <ref bean="의존하는 빈">
          ```

      - XML을 이용해서 의존성을 주입하기 위해서는 클래스에 생성자 또는 Setter 메소드가 있어야 함

      - 스프링은 Pre-loading 방식 사용

        - ApplicationContext를 이용해서 컨테이너를 구동하면 컨테이너가 구동되는 시점에 스프링 설정 파일에 등록된 빈을 생성하고 컨테이너에 로드

      1. 생성자 기반 DI

         - 클래스에 생성자가 있어야 하고 스프링 설정 파일 (xml)에서 빈을 정의 할 때
           - `<constructor-arg ref="의존하는 빈">` 태그를 이용하여 의존성 주입
         - Main에서 객체 생성하지 않고 XML 설정 파일에서 빈 생성
         - main() 하는 역할
           - 컨테이너 객체 생성
           - 컨테이너에서 컴포넌트(빈) 가져옴

      2. Setter 기반 DI

         - 클래스에 반드시 Setter 메소드가 있어야 하고 스프링 설정 파일(xml)에서 `<property>` 태그 이용하여 의존 객체 주입

         - ```java
           <property name="nameService" ref="nameService" />
           ```

         - name : Setter 메소드 이름 (setNameService()

         - ref : 참조 객체 이름

         - 주의 : Setter 메소드를 사용할 경우에는 기본 생성자 외에 다른 생성자를 정의해서는 안 됨

   2. Annotation을 이용한 DI
   
      - xml 설정 파일에서 `<bean>` 태그를 이용해서 설정하였던 bean 설정을 Annotation(메타데이터)을 이용해서 자바 코드에서 설정
      - 예
        - xml 설정 파일에서 빈을 설정하지 않고 스프링 자바 소스 코드를 읽어서 클래스에 @Component 어노테이션이 붙은 클래스를 객체화 (bean 설정)
        - A1 클래스의 객체를 A2 클래스의 객체로 변경하려면 A1 클래스에서 @Component를 제거하고 A2 클래스에 @Component를 붙이면 됨
        - @Autowired 어노테이션을 사용하여 bean을 자동 삽입
      - xml 설정 파일에 context 네임스페이스 추가
        - bean 설정을 위한 어노테이션을 사용하기 위해서는 설정 파일에 context 네임스페이스가 추가되어있어야 함 ([Namespaces] 탭에서 추가)
        - `<context:component-scan>` 태그를 이용하여 bean으로 등록된 클래스를 찾아서(scan) 클래스를 객체화 (bean 설정)
      - 스프링에서 사용하는 Annotation
        - DI(의존성 주입) 관련 Annotation
          - xml 설정 파일에 있는 `<bean>`에 대해 DI하거나 자바 코드에서 생성된 bean에 대해 DI 할 수 있음
          - Annotation 종류
            - @Autowired
              - 타입을 기준으로 의존성 주입
              - 스프링 bean에 의존하는 다른 bean을 자동으로 주입할 때 사용
              - 스프링에서 지원
            - @Inject
              - @Autowired와 동일
              - 자바에서 지원
            - @Qualifier
              - 특정 bean의 이름을 지정
              - 동일한 interface 구현한 클래스가 여러 개 있는 경우 사용하고자 하는 bean의 이름을 지정할 때 사용
            - @Resource
              - @Autowired와 @Qualifier를 같이 사용하는 것과 동일
              - javax.annotation 라이브러리 추가 필요
              - 자바에서 지원
        - bean 생성 관련 Annotation
          - bean 생성(설정)을 위해 클래스 위에 추가되는 어노테이션
          - 클래스 이름 위에 붙이면 클래스 파일에 대한 bean이 자동 생성 (xml 파일에서 bean 생성하지 않음)
          - bean의 이름은 클래스 이름에서 첫 문자만 소문자로 지정됨
            - 예 : NameService 클래스의 bean 이름은 nameService
          - xml 설정 파일에서 필요한 작업
            - xml 설정 파일에 context 네임스페이스 추가 필요
            - `<context:component-scan base-package="패키지명" />`
              - @Component 어노테이션이 적용된 클래스를 bean으로 등록
              - bean으로 등록될 클래스가 들어있는 패키지 지정
              - 상위 패키지를 지정하면 하위 패키지까지 bean으로 등록될 클래스 찾음
              - `<context:annotation-config />` 필요 없음
          - Annotation 종류
            - @Component
              - 클래스를 bean으로 등록 (부품 등록)
              - bean id 지정할 수 있음
              - @Component("bean이름")
                - `<bean id="bean이름">`에 해당
              - @Controller
              - @Service
              - @Repository
            - @Configuration
              - @Bean
        - Spring MVC / Boot 관련 어노테이션은 뒤에서 상세히 다룸

##### @Component 어노테이션의 의미론적 어노테이션

- @Component : 일반적인 컴포넌트 의미
- 특화된 @Component 어노테이션
  - 클래스의 역할에 따라 의미론적으로 구분
  - @Controller 컴포넌트
  - @Service 컴포넌트
  - @Repository 컴포넌트
  - ![img](https://lh4.googleusercontent.com/Tp26pCYLQd5GX3oQC-mC9uEcpjHY2oE9Lx27PRBhpU178msGXS9O1uqOzGo_FQC-SbIFmeGt_oQiLGzwiRLkZ7zCe-BietZ5ti1AtB2IMaJRzYaj_8PmDu_UeeRUojIP-zMldjw)

##### Spring MVC 구성에 따른 어노테이션 사용

![img](https://lh6.googleusercontent.com/RpTo3xkqofNDdG_BXaFfkeppHIYNNJyi2vNgenpLv--Efxk441i3hdxFdcUN25KBDh49jk7VdzF6ZzZ7HZuJ-AgBqSt6p5FYPjtbgYvZmavdpUynwkbz1A5M1VPjDbHyeI8XezA)