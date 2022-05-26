TIL_Day_10

> 2022년 05월 26일

## 예외 처리

### 예외와 예외 클래스

#### 오류의 종류

- 에러 (Error)

  > 하드웨어의 잘못된 동작 또는 고장으로 인한 오류

  1. 컴파일 에러 (compile time error)

     - 문법에 맞지 않을 경우 발생

     - 컴파일 시 처리 가능

     - 이클립스에서 코드 작성하고 저장하는 순간 컴파일되면서 바로 오류 확인 가능

  2. 런타임 에러 (runtime error)

     - 실행 시간 오류 - 프로그램 실행 중에 발생하는 오류

     - 잘못된 메모리 접근 오류, 논리 오류, 사용자의 잘못된 입력 등

- 예외 (Exception)

  > 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류

  - 예외 처리(Exception Handling)를 통해 정상 실행 상태로 돌아갈 수 있음
  - 오류 중에서 대처가능한 오류

  1. 일반 예외 (Exception)

     - 컴파일 체크

     - 예외 처리 코드가 없으면 컴파일 오류 발생

  2. 실행 예외 (RuntimeException)

     - 예외 처리 코드를 생략하더라도 컴파일이 되는 예외
     - 경험에 따라 예외 처리 코드 작성 필요

#### 자바에서의 예외 관리

- 자바에서는 예외를 클래스로 관리

- JVM은 프로그램을 실행하는 도중에 예외가 발생하면 해당 예외 클래스 객체 생성하여 예외 처리 코드에서 예외 객체를 이용할 수 있도록 함

- 모든 예외 클래스들은 java.lang.Exception 클래스를 상속 받음

  <img src="https://lh4.googleusercontent.com/n8AoyKDVD-rxXkGiLVNL6a3t-z4YSjxXfgoFb9-OfKRbtlU88e9xaflbVkR4yI3BRHYPclmSj_OdUltmlKhtLThFPFSLuFkVxlN3B5WaYebcmElMjM8BGfetaAwPaClZwOMQZhM" alt="img" style="zoom: 50%;" />

### 실행 예외

1. NullPointerException
   - 객체 참조가 없는 상태
   - null 값을 갖는 참조변수로 객체 접근 연산자인 도트(.) 사용했을 때 발생
2. ArrayIndexOutOfBoundsException
   - 배열에서 인덱스 범위 초과하여 사용할 경우 발생
3. NumberFormatException
   - 숫자 처리에서 발생하는 예외
4. ClassCastException
   - 타입 변환이 되지 않을 경우 발생
   - 타입 변환 발생
     - 상위 클래스와 하위 클래스 간에 발생
     - 구현 클래스와 인터페이스 간에 발생
     - 자동 타입 변환 / 강제 타입 변환

<img src="https://lh5.googleusercontent.com/ZHu1-jST3P5QtbJqgdaJEJkJ0_3xC7EFo5kveSuc06KvN-6NIc9XOIIP0czMRYEMc7X6ATQpFb9Y7IDopjlO3SVRg3caaExuRLRf-GDSwYlm6lC9Wos2dPrEkj5giRefid1PYt0" alt="img" style="zoom:50%;" />

### 예외 처리 코드

> 예외 발생 시 프로그램 종료되지 않게 하고, 정상 실행을 유지할 수 있도록 처리하는 코드

- 일반 예외 : 반드시 작성해야 컴파일 가능

- 실행 예외

  - 컴파일러가 체크해주지 않으며 개발자의 경험에 의해 작성
  - 일부는 이클립스가 주의를 주기 때문에 미리 알 수 있음

- try ~ catch ~ finally 블록을 이용해서 예외 처리 코드 작성

  <img src="https://lh3.googleusercontent.com/74e7FFmceFrXtavw1bC1cD5QSwgIPCV6qiOOd2uklP9gFvZnWWH61d-vqpl7eIwEWvAlaWpPoBvezm16XPe2jSoKlUrWo_9iqf23S9pGc03-6xRlGac_SmHQCvbaSpv0LmuHpSw" alt="img" style="zoom: 50%;" />
  
- try ~ catch 예외 처리 연습문제 : ExceptionEx.java

  - 다음과 같이 예외 처리 프로그램 작성
    - 2개의 정수를 입력 받아서 나누기 수행
    - 나누는 수는 0으로 입력 받는 경우의 에러 발생에 대해
      - "0으로 나눌 수 없습니다" 가 출력되게 예외 처리

  ```java
  import java.util.Scanner;
  
  public class ExceptionEx {
  	public static void main(String[] args) {
  		Scanner sc = new Scanner(System.in);
  		int num1, num2;
  		
  		System.out.print("정수 1 입력 : ");
  		num1 = sc.nextInt();
  		System.out.print("정수 2 입력 : ");
  		num2 = sc.nextInt();
  		
  		try {
  			System.out.println("나누기 결과 : " + (float) num1 / num2);
  		} catch (ArithmeticException e) {
  			System.out.println("0으로 나눌 수 없습니다.");
  		}
  		
  		sc.close();
  	}
  }

#### 다중 catch

- 예외 별로 예외 처리 코드 다르게 구현
- catch 블록 여러개 포함
- 주의 : 단 하나의 catch 블록만 수행
  - try 블록에서 여러 예외가 동시에 발생하지 않고 문장 순서대로 수행하면서 하나의 예외가 발생하면 즉시 실행을 멈추고 해당 catch 블록으로 이동

<img src="https://lh6.googleusercontent.com/QL2Vu-aZVoyzWmed3inkmV6IDQ6PsWmbXXEcX3msw96jJhf--AuJYhXMtrAeeRJ2Yo622b79pfAEYCjDQUhkZ9wP4z25A35vqSJ8FqblafiGvxJC-vdDYaeUc5oGIv7WUs1LsWg" alt="img" style="zoom:50%;" />

#### catch 순서

- try 블록에서 예외가 발생했을 때 예외를 처리할 catch 블록은 위에서부터 차례대로 검색
- 만일 상위 클래스의 catch 블록이 위에 있다면 하위 클래스의 catch 블록은 실행되지 않음
- 왜냐하면 하위 예외는 상위 예외를 상속했으므로 상위 타입도 되기 때문에 (상위 클래스의 catch 블록이 해당되어 실행됨)

<img src="https://lh6.googleusercontent.com/iiOeMPgry0PK5GKx1R1Lzc_c7ywzQIL1Oi9h-4hKB3mZSeZZZ0I5OUpLeOds9JsyGvzItur6BRqdmtzjZ7Gd1kWEuNYX1126LhOkJE3Iq9ALWjKgfCNu60KxWY0z9GY_Og3_AA0" alt="img" style="zoom:50%;" />

#### 자바의 예외 클래스

<img src="https://lh3.googleusercontent.com/Jb2qGmvi38CjiLLztqQ95tpywmZDDKu0_Diy8ZrgEjS2JiTDnRP7_QFO5l-aoam4esGUa0aT1FlrhERf8rlnHOckV2ZwVeM9Z0DHP6VEJqpYsgn99GBW-jgWxXYdgvv1DRWGOJo" alt="img" style="zoom:50%;" />

### 예외 처리 떠넘기기 (throws)

- throws

  > 메소드에서 처리하지 않은 예외를 호출한 곳으로 떠넘기는 역할

  ```java
  리턴타입 메소드명(매개변수, ...) throws 예외클래스 1, 예외클래스 2, ...{
  }
  ```

  - 메소드 선언부 끝에 추가해서 작성
  - 발생할 수 있는 예외 종류별로 throws 뒤에 나열하는 것이 일반적이지만 throws Exception만으로 간단히 예외를 떠넘길 수 있음
  - throws가 붙어있는 메소드는 반드시 try 블록 내에서 호출되어야 하고 catch 블록에서 예외를 처리해야함

<img src="https://lh6.googleusercontent.com/BcReUpfXAvhCfyTHhXBXEMgN9DE0L2wv_Hw37cy31n4iPvD7TVCDU6hxYk2NwWFKDf6Rntu3oxn8T8nqN0n6FVMvF39DGduImzDWyuWeKd412_B3Go_lGsoSN7YpfARUt3Zq3AU" alt="img" style="zoom:50%;" />

### 사용자 정의 예외와 예외 발생

#### 사용자 정의 예외 클래스 선언

> 자바 표준 API에서 제공하지 않는 예외 처리

```java
public class XXXException extends [Exception|RuntimeException]{
    public XXXException() { }
    public XXXException(String message) {super(message)}
}
```

- 개발자가 직접 정의해서 처리

- 애플리케이션 서비스와 관련된 예외

  - ex) 잔고 부족 예외, 계좌 이체 실패 예외, 회원 가입 실패 예외 ...

- 사용자 정의 예외 클래스 선언 방법

  - 예외 클래스를 상속받는 클래스로 생성

  1. 컴파일러가 체크하는 일반 예외로 선언 - Exception 상속
  2. 컴파일러가 체크하지 않는 실행 예외 선언 - RuntimeException 상속

#### 예외 발생시키기 (throw)

```java
throw new XXXException();
throw new XXXException("메시지");
```

```java
public void method() throws XXXException {
    throw new XXXException("메시지");
}
```

- 호출된 곳에서 발생한 예외를 처리하도록 코드에서 예외 발생시키는 방법

#### getMessage()

```java
} catch (Exception e) {
    String message = e.getMessage();
}
```

- 예외 발생시킬 때 생성자 매개값으로 전달해서 예외 객체 내부에 저장된 메시지 리턴
- 원인 세분화하기 위해 예외 코드 포함
- catch 부분에서 활용

#### printStackTrace()

- 예외 발생 코드를 추적한 내용을 모두 콘솔에 출력
- 프로그램 테스트하면서 오류 찾을 때 유용하게 활용