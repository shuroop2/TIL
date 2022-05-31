# TIL_Day_12

> 2022년 05월 27일

## 제네릭 (Generic)

> 클래스(인터페이스)나 메소드를 타입 파라미터를 이용하는 기법

- 클래스 설계 시에 타입` <T>`이 아직 결정 되지 않음
- 총칭해서 제네릭 타입
- `public class 클래스명<T> { ... }`
- `public interface 인터페이스명<T> { }`

```java
class Gen<T> {
    private T value;
    ...
}
Gen<String> gen = new Gen<String>();
Gen<Integer> gen2 = new Gen<Integer>();
```

- < > : 기본 데이터 타입은 올 수 없음

  - `<int>` : X
  - `<Integer>` : Wrapper 클래스 사용
    - 기본 데이터 타입에 대응되는 클래스
    - 기본 데이터 타입을 객체로 포장

- 제네릭을 사용하는 코드의 이점

  - 컴파일 시 강한 타입 체크 가능

    - 실행 시 타입 에러가 나는 것 방지
    - 컴파일 시에 미리 타입을 강하게 체크해서 에러를 사전에 방지

  - 강제 타입 변환 제거 가능 (프로그램 성능 향상)

  - 제네릭을 사용하지 않을 경우

    ```java
    List list = new ArrayList();
    list.add("hello");
    String str = (String) list.get(0); // 강제 타입 변환 필요
    ```

  - 제네릭을 사용할 경우

    ```java
    List<String> list = new ArrayList<String>();
    list.add("hello");
    String str = list.get(0); // 강제 타입 변환 불필요
    ```

### 제네릭 정리

- 클래스나 인터페이스 설계할 때 구체적인 타입을 명시하지 않고 타입 파라미터로 대체했다가 실제 클래스 사용될 때 구체적인 타입을 지정하여 타입 변환을 최소화시킴으로써 프로그램 성능을 향상시킬 수 있고 컴파일 시에 미리 타입을 강하게 체크해서 에러를 사전에 방지

### 타입 파라미터

- 일반적으로 대문자 알파벳 한 문자로 표현

  - 꼭 T라고 하지 않아도 됨
  - E : Element
  - T : Type
  - V : value
  - K : Key

- 개발 코드에서는 타입 파라미터 자리에 구체적인 타입을 지정해야 함

  ```java
  Gen<String> gen = new Gen<String>();
  Gen<Integer> gen2 = new Gen<Integer>();
  ```

- 클래스 내부에서 사용할 데이터 타입을 클래스 외부에서 지정

### 제네릭 타입

> 타입을 파라미터로 가지는 클래스와 인터페이스

- 선언 시 클래스 또는 인터페이스 이름 뒤에 `<>` 부호 붙임
- `<>` 사이에는 타입 파라미터 위치 : `<T>`

### 멀티 타입 파라미터

- 제네릭 타입은 두 개 이상의 타입 파라미터 사용 가능

- 각 타입 파라미터는 콤마로 구분

  - `class ...<K, V, ...> { ... }`
  - `interface ...<K, V< ...> { ... }`

- 제네릭 타입 변수 선언과 객체 생성 코드를 자바 7부터는 다이아몬드 연산자를 사용해 간단히 작성하고 사용 가능

  ```java
  Product<Tv, String> product = new Product<Tv, String>();	// 자바 7 이전
  Product<Tv, String> product = new Product<>();				// 자바 7 이후

### 제네릭 메소드

> 매개 타입과 리턴 타입으로 타입 파라미터를 갖는 메소드

- 제네릭 메소드 선언 방법

  - 리턴 타입 앞에 `<>` 기호를 추가하고 타입 파라미터 기술

  - 타입 파라미터를 리턴 타입과 매개 변수에 사용

    ```java
    public <타입파라미터, ...> 리턴타입 메소드명(매개변수, ...) { ... }
    public <T> Box<T> boxing(T t) { ... }	// ex
    ```

  - 호출 할 때 `<T>`가 결정나면 `Box<T>`와 매개변수 `(T t)`가 결정

- 제네릭 메소드를 호출하는 두 가지 방법

  1. 명시적으로 구체적 타입 지정

     - ```java
       리턴타입 변수 = <구체적 타입>메소드명(매개값);
       Box<Integer> box = <Integer>boxing(100);	// ex

  2. 매개값을 보고 구체적 타입을 추정 (더 많이 사용)

     - ```java
       리턴타입 변수 = 메소드명(매개값);
       Box<Integer> box = boxing(100);	// ex
       ```

### 제네릭 타입의 상속과 구현

- 제네릭 타입을 부모 클래스로 사용할 경우

  - 타입 파라미터는 자식 클래스에도 기술해야 함

    ```java
    public class ChildProduct<T, M> extends Product<T, M> { ... }
    ```

  - 자식 클래스는 추가적인 타입 파라미터 가질 수 있음

    ```java
    public class ChildProduct<T, M, C> extends Product<T, M> { ... }
    ```

- 제네릭 인터페이스를 구현할 경우

  - 제네릭 인터페이스를 구현한 클래스도 제네릭 타입

    ```java
    public class StorageImpl<T> implements Storage<T> { ... }
    ```