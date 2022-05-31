# TIL_Day_15

> 2022년 05월 31일

## 람다식

> 익명 함수를 생성하기 위한 식

- 객체 지향 언어보다 함수 지향 언어
- 객체 지향 프로그래밍과 함수적 프로그램 혼합함으로써 더욱 효율적인 프로그래밍 가능

#### 자바에서 람다식을 사용하는 이유

- 코드 간결
- 필터링 또는 매핑을 통해 대용량 데이터를 쉽게 집계 
- 반복문에서 실행 속도 느리다는 단점

#### 람다식의 형식

```java
Runnable runnable = () -> {...}
인터페이스 변수 = 람다식;
```

- 매개변수를 가진 코드 블록
- 하나의 메소드 정의
- 자바의 메소드 선언처럼 보임
- 람다식은 단순히 메소드를 선언하는 것이 아니라 해당 메소드를 가지고 있는 객체 생성
  - 즉, 인터페이스 변수에 대입되어 인터페이스 익명 구현 객체 생성 (익명 구현 객체 코드를 람다식을 사용하여 좀 더 간결하게 작성할 수 있음)

#### 함수적 스타일의 람다식 작성법

```java
(타입 매개변수, ...) -> { 실행문; ...}
(int a) -> { System.out.println(a);}
```

- 기호 ->
  - 매개변수를 이용해서 중괄호 { } 실행한다는 의미

### 람다식 기본 문법

1. ```java
   (a) -> {System.out.println(a);}
   ```

   - 매개변수 타입은 러타임 시에 대입되는 값에 따라 자동 인식될 수 있기 때문에 매개변수 타입 생략 가능

2. ```java
   a -> {System.out.println(a);}
   ```

   - 매개변수가 1개인 경우 괄호 생략 가능

3. ```java
   a -> System.out.println(a)
   ```

   - 실행문이 1개인 경우 중괄호 생략 가능

4. ```java
   () -> {System.out.println(a);}
   ```

   - 매개변수가 없는 경우에는 반드시 빈 괄호 있어야함

5. ```java
   (x, y) -> {return x+y;}
   ```

   - 반환값이 있는 경우 return문 사용

6. ```java
   (x, y) -> x+y;
   ```

   - 중괄호 { }안에 return문만 있는 경우, return 생략 가능

### 타겟 타입과 함수적 인터페이스

#### 타겟 타입

> 람다식이 대입될 인터페이스

- 람다식은 대입될 인터페이스의 종류에 따라 작성 방법 달라짐

#### 함수적 인터페이스 (@FunctionalInterface)

- 람다식의 타겟 타입으로 모든 인터페이스를 사용하는 것은 아님

- 하나의 추상 메소드가 선언된 인터페이스만 람다식의 타겟 타입이 될 수 있음 (함수적 인터페이스)

  - 람다식은 하나의 메소드 정의

- @FunctionalInterface 어노테이션

  > 함수적 인터페이스(추상 메소드 1개)임을 표시하는 어노테이션

  - 함수적 인터페이스를 작성할 때 2개 이상의 추상 메소드가 선언되지 않도록 컴파일러가 확인
  - 2개 이상 선언되면 컴파일 오류 발생
  - @FunctionalInterface 어노테이션은 선택사항
  - 이 어노테이션이 없어도 추상 메소드가 1개이면 모두 함수적 인터페이스
  - 그러나 실수로 두 개 이상의 추상 메소드를 선언하는 것을 방지하기 위해서 사용하는 것이 좋음

#### 매개변수와 리턴값이 없는 람다식

- 인터페이스

```java
// 추상 메소드가 1개만 존재해야 함
@FunctionalInterface
public interface MyFunctionalInterface {
	// 1. 매개변수와 리턴값 없음
	public void method();
}
```

- 실행 클래스

```java
public class MyFunctionalInterfaceMain {
	public static void main(String[] args) {
		// 1. 매개변수와 리턴값이 없는 람다식
		MyFunctionalInterface fi;
		
		fi= () -> {
			String str = "method call1";
			System.out.println(str);
		};
		// 메소드 호출 : 람다식의 중괄호 {...} 실행
		fi.method();
		
		// 실행 문장이 1개인 경우
		fi = () -> {System.out.println("method call2");};
		fi.method();
		
		// 실행 문장이 1개인 경우 중괄호 {} 생략 가능
		fi = () -> System.out.println("method call3"); // 실행문 하나라면 중괄호 생략 가능
		fi.method();
	}
}
```

#### 매개변수가 있는 람다식

- 인터페이스

```java
//추상 메소드가 1개만 존재해야 함
@FunctionalInterface
public interface MyFunctionalInterface2 {
	// 2. 매개변수가 있는 람다식
	public void method(int x);
}
```

- 실행 클래스

```java
public class MyFunctionalInterfaceMain2 {
	public static void main(String[] args) {
		// 2. 매개변수가 있는 람다식
		MyFunctionalInterface2 fi2;
		
		fi2= (x) -> {
			int result = x * 5;
			System.out.println(result);
		};
		// 메소드 호출 : 람다식의 중괄호 {...} 실행
		fi2.method(2);
		
		// 실행 문장이 1개인 경우
		fi2 = (x) -> {System.out.println(x * 5);};
		fi2.method(2);
		
		// 실행 문장이 1개인 경우 중괄호 생략 가능
		fi2 = (x) -> {System.out.println(x * 5);};
		fi2.method(2);
		
		fi2 = x -> System.out.println(x * 5); // 매개 변수가 하나일 경우 괄호 생략 가능
		fi2.method(2);
	}
}
```

#### 리턴값이 있는 람다식

- 인터페이스

```java
//추상 메소드가 1개만 존재해야 함
@FunctionalInterface
public interface MyFunctionalInterface3 {
	// 3) 리턴값과 매개변수가 있는 람다식
	public int method(int x, int y);
}
```

- 실행 클래스

```java
public class MyFunctionalInterfaceMain3 {
	public static void main(String[] args) {
		// 3) 리턴값과 매개변수가 있는 람다식
		MyFunctionalInterface3 fi3;
		
		fi3 = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.println(fi3);
		
		// 실행문이 1개인 경우
		fi3 = (x, y) -> {return x + y;};
		System.out.println(fi3.method(2, 5));
		
		// 중괄호 안에 리턴문만 있는 경우 return과 중괄호 생략
		fi3 = (x, y) -> x + y;
		System.out.println(fi3.method(2, 5));
		
		// Integer 클래스의 sum() 메소드 사용
		fi3 = (x, y) -> Integer.sum(x, y);
		System.out.println(fi3.method(2, 5));
		
		fi3 = (x, y) -> sum(x, y);
		System.out.println(fi3.method(2, 5));
	}
	
	public static int sum(int x, int y) {
		return x + y;
	}
}
```

### 클래스 멤버와 로컬 변수 사용

#### 클래스의 멤버 사용 (필드와 메소드)

- 사용하는데 제약 사항 없음
- this 키워드 사용 시 주의
  - 람다식에서 this : 람다식을 실행한 객체 참조
  - 익명 객체 내부에서 this : 익명 객체 참조

#### 로컬 변수

- 제약 사항 있음
- final 특성을 가져야 함



## IO 기반 입출력 및 네트워킹

### java.io 패키지

> 자바의 기본적인 데이터 입출력(IO : Input/Output) API 제공

<img src="https://lh5.googleusercontent.com/_OvCtWmegcoEF-yc9u1pm6cIqUkr60qEe0hDNtYXalOVBfl-OHdqn_sU8L8HM3uDA1QNeCgyh0AbknlBV1zW3QZRZqxwQpi-iIKiIBlgOuVqLrvhFQcMq8TgiTNxWzyjgxcLQFg" alt="img" style="zoom:50%;" />

### 자바의 스트림 (Stream)

> 입출력 장치와 자바 응용 프로그램 연결 통로

- 입력 스트림
  - 입력 장치로부터 자바 프로그램으로 데이터 전달하는 소프트웨어 모듈
- 출력 스트림
  - 자바 프로그램에서 출력 장치로 데이터를 보내는 소프트웨어 모듈
- 입출력 스트림 기본 단위 : 바이트 (Byte)

<img src="https://lh3.googleusercontent.com/6d78Bre1F3rWgUr5tVYnzU0Y-eFvpkG2pjPVf0yyU-FsM_NfGODhe3yZFabjDZ-_aErKHt7roYFCwyGEKJ24PNUoO6gugha_xWkpH1biJWWVKrmc9JRioVkJLk8EuU3D9BH8bwc" alt="img" style="zoom:50%;" />

- 자바 입출력 스트림 특징

  - 단방향

  - 선입선출구조 (FIFO)

- 바이트 기반 스트림
  - 이미지, 멀티미디어, 문자 등 모든 종류의 데이터를 받고 보내는 것 가능
  - 입출력되는 데이터를 단순 바이트의 스트림으로 처리
  - ex) 바이너리 파일을 읽는 입력 스트림
- 문자 기반 스트림
  - 문자만 입출력하는 스트림
  - 문자만 받고 보낼 수 있도록 특화
  - 문자가 아닌 바이너리 데이터는 스트림에서 처리하지 못함
  - ex) 텍스트 파일을 읽는 입력 스트림
- 데이터 입출력 구분

|     구분      | 바이트기반 스트림 |                 | 문자 기반 스트림 |             |
| :-----------: | :---------------: | :-------------: | :--------------: | :---------: |
|               |    입력 스트림    |   출력 스트림   |   입력 스트림    | 출력 스트림 |
| 최상위 클래스 |    InputStream    |   OuputStream   |      Reader      |   Writer    |
|  하위 클래스  |  XXXInputStream   | XXXOutputStream |    XXXReader     |  XXXWriter  |

#### InputStream

> 바이트 기반 입력 스트림의 최상위 클래스로 추상 클래스

<img src="https://lh5.googleusercontent.com/a8eqerAV0QcMONPo3HhpAR8lgmvlqRRGR53VsacWwokGRcKkmb51FuS0NPVWpL0DZoePvGOA35kz5pKPPOJy7FcLHq-95J8KJ8cOrZ2shF5OS1_gRGW0tGq-zLHkNV_XQu0JZTk" alt="img" style="zoom:50%;" />

- InputStream 클래스의 주요 메소드

  <img src="https://lh6.googleusercontent.com/X1KqQGPRsUrQjJU8xIaWUH-j9MWfMg_nxFUZEp5JW3GqoczE6a7lWwMM8VqzwYRoQVV31dBtePgMYk572L1y4whO0LubTDtkBlSHsNQbg1aFHFOHXxwiGfc8csxoGhcDxep6oRw" alt="img" style="zoom:50%;" />

#### OutputStream

> 바이트 기반 출력 스트림의 최상위 클래스로 추상 클래스

- 파일에 바이트 단위로 데이터를 저장할 때 사용

- 이미지, 오디오, 비디오, 텍스트 등 모든 종류의 데이터를 파일로 저장

- 객체 생성 방법

  - 파일이 이미 존재할 경우, 데이터를 출력하게 되면 기존 파일 덮어씀

  - 기존 파일 내용 끝에 데이터를 추가할 경우 추가 모드(append) 설정

    ```java
    new FileOutputStream(File file, boolean append)
    new FileOutputStream(“a.txt”, true)
    ```

<img src="https://lh3.googleusercontent.com/2SHuftA20hm5ldBc8ICNHoRY0VU9ADkh2mxfPlYCzT974Eakngidu8b7j5gKdWS8RCC9h81wF7as8vj1mFXZpRsXmjmC1kDSO3-TBRS5qdhvfD-Zux-Ig1QVPmFrBbyK9Z9TRfE" alt="img" style="zoom:50%;" />

- OutputStream 클래스의 주요 메소드

  <img src="https://lh6.googleusercontent.com/X1KqQGPRsUrQjJU8xIaWUH-j9MWfMg_nxFUZEp5JW3GqoczE6a7lWwMM8VqzwYRoQVV31dBtePgMYk572L1y4whO0LubTDtkBlSHsNQbg1aFHFOHXxwiGfc8csxoGhcDxep6oRw" alt="img" style="zoom:50%;" />

#### Reader

> 문자 기반 입력 스트림의 최상위 클래스로 추상 클래스

<img src="https://lh3.googleusercontent.com/YnDAfv07X1Dudtyv40dhdpGFRg3qCfCujvXcCs_mzVcaoJ0XnA0htE6lhv94mwgLuDnjS9UKOXKdoN775BcoH_FSC6zTzBXDuuSJljn2-sxHZHEEZAu1M74FQUflE_CuDURz60U" alt="img" style="zoom:50%;" />

- Reader 클래스의 주요 메소드

  <img src="https://lh6.googleusercontent.com/JuzlwrHYyQ_cPtYzmN7OABdCDg4fOeTuXH7FNduHP-4d1XyG_XCVFrxoWyk4LwlY7goVKpqt9xWOVI-iZ78EBf2zuQQQtWAFKN4fg5HVnSf4KcjEmlstqTiAA9kFGO1_E55Z_Ww" alt="img" style="zoom:50%;" />

#### Writer

> 문자 기반 출력 스트림의 최상위 클래스로 추상 클래스

<img src="https://lh4.googleusercontent.com/BSqC3d8ArFcqLUIbeJOjTkh7UgZeFmuCruGKW3YpkxB5aH87AhrHWmO33oerOPQErMJj2UgT0sfF6jRCW57APHAW478iqdHuQqUTngMa-_Ez8KXxBwTGO_Vld5hsz5qq4IwqBBo" alt="img" style="zoom:50%;" />

- Writer 클래스의 주요 메소드

  <img src="https://lh5.googleusercontent.com/-ixFJIp9eD5hstm0OO23ZPY0_V_3qFm2-bKs35ZDzzpu_WsRtcKrdpbKRQvYyuoM4u-HdVvg4M-sd3_lW2V_7Tnu52dtXaCSRJuxkPIt0gqtpy6BXoHgiJQzbAhr1VlhPj9v4EY" alt="img" style="zoom:50%;" />

### 파일 입출력

#### File 클래스

> 파일 시스템의 파일을 표현하는 클래스

- 파일 크기, 파일 속성, 파일 이름 등의 정보 제공

- 파일 생성 및 삭제 기능 제공

- 디렉토리 생성, 디렉토리에 존재하는 파일 리스트 얻어내는 기능 제공

- 파일 객체 생성

  ```java
  File dir = new FIle("C:/test/Dir");
  File dir2 = new FIle("C:\\test\\Dir");
  ```

- FIle 클래스 메소드

  <img src="https://lh3.googleusercontent.com/TzLHdyTpgOItPRW8NkwrLYXO5dfhyLL24hpOGRteZj3odv_hN8KAIBH3UT9ErClGPdGj006y0n2JVtj58HHwLTh8WkpxJaPIZpVfqKU2Diy0iAAh80I0cRSvCzkGnnGq5pxjjMA" alt="img" style="zoom:50%;" />

#### mkdir()

- 새로운 디렉토리 생성 후 결과 반환 (true/false)
- 최하위 디렉토리만 생성 가능
- 바로 위의 디렉토리가 존재하지 않으면 생성 불가

#### mkdirs()

- 새로운 디렉토리 생성 후 결과 반환 (true/false)
- 상위 디렉토리 존재하지 않으면 상위 디렉토리 생성하고 지정한 디렉토리 생성

#### 파일 및 디렉토리의 정보를 리턴하는 메소드

<img src="https://lh6.googleusercontent.com/Nf5lFWBYnCN9dSrIzSM1wHH706w9wvMuZpGFs0JzDMeaFy2ItTkZW_HVwVyQEo_45DLMV-2EYc2SMaPJtMCV_TGd_d-KS6draVVUzzIkzWU6emZFgJXarItX0NMY7V3VO4nLVTw" alt="img" style="zoom:50%;" />