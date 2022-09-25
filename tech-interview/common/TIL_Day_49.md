# TIL_Day_49

> 2022년 09월 25일

## MVC 패턴

![](https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/MVC-Process.svg/436px-MVC-Process.svg.png)

> 모델-뷰-컨트롤러(model-view-controller, MVC)는 소프트웨어 공학에서 사용되는 소프트웨어 디자인 패턴이다. 이 패턴을 성공적으로 사용하면, 사용자 인터페이스로부터 비즈니스 로직을 분리하여 애플리케이션의 시각적 요소나 그 이면에서 실행되는 피즈니스 로직을 서로 영향 없이 쉽게 고칠 수 있는 애플리케이션을 만들 수 있다. MVC에서 모델은 애플리케이션의 정보(데이터)를 나타내며, 뷰는 텍스트, 체크박스 항목 등과 같은 사용자 인터페이스 요소를 나타내고, 컨트롤러는 데이터와 비즈니스 로직 사이의 상호동작을 관리한다.

### MVC 패턴 방식

- 모델 1 방식 : JSP에서 출력과 로직을 전부 처리
- 모델 2 방식 : JSP에서 출력만 처리

#### Model 1

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fw08Lw%2FbtrlbKqhWKO%2FqUYnM7xziHIQUE28L6WBZ1%2Fimg.png)

- 모델 1 방식은 Controller 영역에 View 영역을 같이 구현하는 방식이며, 사용자의 요청을 JSP가 전부 처리한다.
- 요청을 받은 JSP는 JavaBean Service Class를 사용하여 웹브라우저 사용자가 요청한 작업을 처리하고 그 결과를 출력한다.

#### Model 2

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbGZKd4%2FbtrleqFoykC%2FkXkFFucLJdHJ4hNvfcmav0%2Fimg.png)

- 모델 2 방식은 웹브라우저 사용자의 요청을 서블릿이 받고 서블릿은 해당 요청으로 View로 보여줄 것인지 Model로 보낼 것인지를 판단하여 전송한다.
- 또한 모델 2 방식의 경우 HTML 소스와 Java 소스를 분리해놓았기 때문에 모델 1 방식에 비해 **확장시키기도 쉽고 유지보수 또한 쉽다**.

### Model, View, Controller

#### Model

- Model은 **Data**와 애플리케이션이 **무엇**을 할 것인지를 정의하는 부분으로 **내부 비즈니스 로직을 처리하기 위한 역할**을 한다.
- 즉, Model은 Controller가 호출을 하면 DB와 연동하여 사용자의 입출력 데이터를 다루는 일과 같은 데이터와 연관된 비즈니스 로직을 처리하는 역할을 한다.
- 데이터 추출, 저장, 삭제, 업데이트 등의 역할을 수행한다.

##### Model의 규칙

- 사용자가 편집하기를 원하는 모든 데이터를 가지고 있어야 한다.
- View나 Controller에 대해서 어떤 정보도 알지 말아야 한다.
- 변경이 일어나면, 변경 통지에 대한 처리방법을 구현해야만 한다.

#### View

- View는 사용자에게 보여주는 **화면(UI)**에 해당된다.
- 사용자와 상호작용을 하며 컨트롤러로부터 받은 모델의 결과값을 사용자에게 화면으로 출력하는 일을 한다.
- MVC에서는 여러 개의 View가 존재할 수 있다.
- Model에서 받은 데이터는 별도로 저장하지 않는다.

##### View의 규칙

- Model이 가지고 있는 정보를 따로 저장해서는 안된다.
- Model이나 Controller와 같이 다른 구성요소들을 몰라야 한다.
- 변경이 일어나면 변경 통지에 대한 처리방법을 구현해야만 한다.

#### Controller

- Controller는 **Model과 View 사이를 이어주는 인터페이스 역할**을 한다.
- 즉, **Model이 데이터를 어떻게 처리할 지 알려주는 역할**을 한다.
- 사용자로부터 View에 요청이 있으면 Controller는 해당 업무를 수행하는 Model을 호출하고, Model이 업무를 모두 수행하면 다시 결과를 View에 전달하는 역할을 한다.

##### Controller의 규칙

- Model이나 View에 대해서 알고 있어야 한다.
- Model이나 View의 변경을 모니터링 해야 한다.

### MVC 패턴을 사용해야 하는 이유

- 비즈니스 로직과 UI로직을 분리하여 유지보수를 독립적으로 수행 가능
- Model과 View가 다른 컴포넌트들에 종속되지 않아 애플리케이션의 확장성, 유연성에 유리함
- 중복 코딩의 문제점 제거

### MVC의 한계

Model과 View는 서로의 정보를 갖고 있지 않는 독립적인 상태라고 하지만, Model과 View사이에는 Controller를 통해 소통을 이루기에 의존성이 완전히 분리될 수 없다. 그래서 복잡한 대규모 프로그램의 경우 다수의 View와 Model이 Controller를 통해 연결되기 때문에 Controller가 불필요하게 커지는 현상이 발생하기도 한다. 이러한 현상을 **Massive-View-Controller**현상이라고 하며 이를 보완하기 위해 MVP, MVVM, Flux, Redux등의 다양한 패턴들이 생겨났다.

### Summary

- Model : 백그라운드에서 동작하는 비즈니스 로직(데이터) 처리
- View : 정보를 화면으로 보여주는 역할
- Controller : 사용자의 입력 처리와 흐름 제어 담당. 화면과 Model과 View를 연결시켜주는 역할

