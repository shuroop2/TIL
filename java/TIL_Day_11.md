# TIL_Day_11

> 2022년 05월 27일

## 기본 API 클래스

### 자바 API 도큐먼트

- 자바 API

  > 자바에서 기본적으로 제공하는 라이브러리
  >
  > 프로그램 개발에 자주 사용되는 클래스 및 인터페이스 모음

- API 도큐먼트

  > 쉽게 API를 찾아 이용할 수 있도록 문서화한 것

  - HTML 페이지로 작성되어 있어 웹 브라우저로 바로 볼 수 있음



### java.long과 java.util 패키지

#### java.lang 패키지

> 자바 프로그램의 기본적인 클래스를 담은 패키지

- 포함된 클래스와 인터페이스는 import없이 사용
  - Object, System, Math ...

<img src="https://lh4.googleusercontent.com/l-xg4LagNvtf9JtXsxGbE1lg74NPi98vQ-Vc3MhmZdeghmPYCY-qB-rqXR-BvtZWGoP_nr26p3bSuej9Y3t8WJi9fDkWNCaYqNyZaUN-mArN42Y0oG7YBmQiboqYPCESj4ezXNA" alt="img" align="left" style="zoom:40%;" />



### Object 클래스

> 자바의 최상위 부모 클래스

- 다른 클래스를 상속하지 않으면 java.lang.Object 클래스 상속 암시
- Object의 메소드는 모든 클래스에서 사용 가능

<img src="https://lh5.googleusercontent.com/XzNH-qfVL3duuHU5SdR5RgZS-o7rZAhTXriZedo-wCupa_D6SMTD9mzJbDgPy6nLuVXhMv_0fFQvphac3GN9z3a7x_qTIz5eFjbaZ2e8Ro4-fi6bNNhXNbrJdJMjzkkUozFumi0" alt="img" align="left" style="zoom:40%;" />



#### Object 클래스의 메소드

- Object클래스는 필드는 없고 메소드들로 구성
- 모든 클래스가 Object 클래스를 상속하기 때문에 Object 클래스의 메소드는 모든 클래스에서 사용
- equals(), hashCode(), toString(), clone(), finalize() ...



#### 객체 비교 (equals())

- 기본적으로 == 연산자와 동일한 결과 리턴

  <img src="https://lh4.googleusercontent.com/9IXZ1JNeHSm5-6Gjwccvrj5ml_dC_iLtTulb91uMSnmLs2RZUJCcdralXSlnnOfILk4qJpVTaaucErcykJ0rzt2ihtoQF4LF_jGqyaw-7sPee_DUtFhIeDOYyKAp3osNoikTOCI" alt="img" align="left" style="zoom:40%;" />



#### 객체 해시코드 (hashCode())

> 객체를 식별할 하나의 정수값

- Object의 hashCode() 메소드는 객체의 메모리 번지를 이용해 해시코드를 만들어서 리턴
  - 개별 객체는 해시코드가 모두 다름



#### 객체 문자 정보 (toString())

> 객체를 문자열로 표현한 값

```java
Object obj = new Object();
System.out.println(obj.toString());
```

```java
java.lang.Object@de6ced
```

- Object 클래스의 toString() 메소드는 객체의 문자 정보 리턴
  - 자바에서는 별 값어치 없는 정보
  - Object 하위 클래스에서 메소드 재정의해서 사용
    - String 클래스 : 문자열 리턴
    - Date 클래스 : 현재 시스템의 날짜와 시간 정보 리턴



#### 객체 복제 (clone())

> 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성하는 것

- 객체 복제 이유

  - 원본 객체를 안전하게 보호가 위해
  - 신뢰하지 않은 영역으로 원본 객체를 넘겨야할 경우 원본 객체의 데이터가 훼손될 수 있기 때문에 복제된 객체를 만들어서 넘김
  - 복제된 객체의 데이터가 훼손되더라도 원본 객체는 아무런 영향을 받지 않기 때문

- 객체 복제 방법

  1. 얕은 복제 (thin clone)

     > 단순히 필드 값만 복제해서 객체를 복제하는 방법

     - 기본 타입 : 값 복사

     - 참조 타입 : 객체의 번지 복사 (같은 객체 참조)

     - Object 클래스의 clone() 메소드

       - 자신과 동일한 필드값을 가진 얕은 복제된 객체 리턴

       - clone() 메소드로 객체를 복제하려면 원본 객체는 반드시 java.lang.Cloneable 인터페이스를 구현하고 있어야 하는데 (클래스 설계자가 복제를 허용한다는 의미) Cloneable 인터페이스를 구현하지 않으면 clone() 호출 시 CloneNotSupportedException 예외 발생되어 복제가 실패

       - clone() 메소드는 호출 시 예외 처리 필요

         - try ~ catch 구문 사용

           ```java
           try {
               Object obj = clone();
           } catch (CloneNotSupportedException e) { }

  2. 깊은 복제 (deep clone)

     > 참조하고 있는 객체도 복제하는 방법

     - 얕은 복제에서 참조 타입의 경우 객체의 번지 복사 (같은 객체 참조)
       - 복제 객체를 변경하면 원본 객체도 변경됨 (얕은 복제의 단점)
     - Object의 clone() 메소드를 재정의해서 참조 객체를 복제하는 코드를 직접 생성해야 함



#### 객체 소멸자 (finalize())

- 참조하지 않는 배열이나 객체는 쓰레기 수집기(Garbage Collector : GC)가 자동으로 힙영역에서 소멸시킴
- GC는 객체를 소멸하기 전에 객체 소멸자(finalize()) 실행
- Object의 finalize()는 기본적으로 실행 내용이 없음
- 객체 소멸되기 전에 실행코드가 있다면
  - Object의 finalize() 재정의



#### Throwable 클래스

> java 언어의 모든 에러와 예외의 수퍼 클래스

<img src="https://lh4.googleusercontent.com/y6hq2a1t4mi0IXjaRKmtEqYnjyQgNvfQS7C3mIaGZttOs_YuxwPOiZ1YinIDQuX-E8MjkLCZ067BV1L_l7wZzEwAPzYtJRMMhSwn6W2VyVwbWGFlPa72eFQ0uvBn7fhQKmQTnY0" alt="img" align="left" style="zoom: 40%;" />



#### System.gc()

> Garbage Collector 호출

- Garbage Collector를 호출하여 JVM에게 요청하면 바로 Garbace Collector가 실행되는 것은 아님
- Garbage Collector는 메모리가 부족하거나 CPU가 한가할 때 JVM에 의해서 자동 실행
- 따라서 finalize()가 언제 호출될지는 확실히 알 수 없음
- 주의
  - 될 수 있으면 소멸자는 사용하지 않음
    - Garbage Collector는 메모리의 모든 쓰레기, 객체를 소멸하지 않음
    - Garbage Collector의 구동 시점이 일정하지 않음



#### Objects 클래스

> 객체 비교, 해시코드 생성, null 여부, 객체 문자열 리턴 등의 연산을 수행하는 정적 메소드들로 구성된 Object의 유틸리티 클래스

<img src="https://lh4.googleusercontent.com/bLFYmkHA3Ut6PDbKGQHoG1RbuFLce3f6R6PBNJVsuk4eHFcgVBYkpp-yh6UkgkO-L6FA2rkDpAxKMzfbyFmAhqO8BBOrxI5-v3kpgAkKj5T3rAR2J4-93Dh49uPTMh0ZfHIGTE8" alt="Object 클래스가 가지고 있는 정적 메소스" style="zoom:40%;" />



### System 클래스

#### System 클래스 용도

- 운영체제의 기능 일부 이용 가능
  - 프로그램 종료, 키보드로부터 입력, 모니터 출력, 메모리 정리, 현재 시간 읽기 등
  - 시스템 프로퍼티 읽기, 환경 변수 읽기 등



#### exit() 메소드

> 현재 실행하고 있는 프로세스 강제 종료시키는 역할

```java
System.exit(0)
```

- 강제적으로 JVM 종료
- int 매개값 지정 - 종료 상태 값
- exit(0) / exit(1)
- 정상종료 : 0
- 비정상 종료 : 0 이외의 값
- 어떤 값 주더라도 종료



#### 현재 시간 읽기

- currentTimeMillis() 

  > 컴퓨터의 시계로부터 현재 시간을 읽어서 밀리세컨드 단위의 long 값을 리턴

  ```java
  long time = System.currentTimeLillis();
  ```

- nanoTimes()

  > 컴퓨터의 시계로부터 현재 시간을 읽어서 나노세컨드 단위의 long 값을 리턴

  ```java
  long time = System.nanoTime();
  ```

- 주로 프로그램 실행 소요 시간 구할 때 이용



#### 시스템 프로퍼티 읽기 (getProperty())

> JVM이 시작할 때 자동 설정되는 시스템의 속성값

```java
String value = System.getProperty(String key);
```

- 키와 값으로 구성

  <img src="https://lh6.googleusercontent.com/Wb1gE6_2uIqcAejNYpnq5ks4xFbXZJp_1QPbBpBNTP3GLyF0EQokXEzglbQ9HiuIlhE1g4TkhguVZEp4OaiOvNmHCx8IAKT9XaVkuh3OrUzPZRmWtb63pimaLmOc3NxN-7N5KPU" alt="img" align="left" style="zoom:40%;"/>



#### 환경 변수 읽기 (getenv())

```java
String value = System.getenv(String name);
```

- 운영체제가 제공하는 환경 변수 값(문자열)을 읽음



### String 클래스

#### String 생성자

- 바이트 배열(byte[])을 문자열로 변환

  - 파일을 읽거나 네트워크를 통해서 받은 데이터는 보통 바이트 배열

- 지정한 문자셋으로 디코딩

- 키보드로부터 읽은 바이트 배열을 문자열로 변환

  <img src="https://lh6.googleusercontent.com/VTVXcJ7lWHWn5h_d9dPMGnnNDtONDlZuZHkIU6SGkeEf7nWWY30TFbf1EIT7LCByANDFmybCoZwlStjs1zzoyJWbf0y2a4oG1S5WWeQRVR3n5E97GTIOziEea-Zh8GNQZ07icqE" alt="img" align="left" style="zoom:40%;" />



#### String 메소드

- 문자열의 추출, 비교, 찾기, 분리, 변환 등과 같은 다양한 메소드 포함

- 사용빈도 높은 메소드

  <img src="https://lh6.googleusercontent.com/kt0izfLnW1pfa-7MRM8oR6nra157vWAdyyBvweybKedfP2oiJoeYW3nywiK8iwFYYW99kPKgbxVqteMzFK6orC_DlnEMsaLeUSdsbRc4umC86dbtHqAmyESys5nSQasS06clTA8" alt="img" align="left" style="zoom:40%;"/>



##### 문자 추출 (charAt())

> 매개값으로 주어진 인덱스의 문자를 리턴

```java
String subject = "자바 프로그래밍";
char charValue = subject.charAt(3);
```



##### 바이트 배열로 변환 (getBytes())

> 시스템의 기본 문자셋으로 인코딩된 바이트 배열을 리턴

```java
byte[] bytes = "문자열".getBytes();
```

- 특정 문자셋으로 인코딩 된 바이트 배열 얻기

  ```java
  try {
      byte[] bytes = "문자열"getBytes("EUC-KR");
      byte[] bytes = "문자열"getBytes("UTF-8");
  } catch (UnsupportedEncodingException e ) { }
  ```



##### 문자열 찾기 (indexOf())

> 매개값으로 주어진 문자열이 시작되는 인덱스를 리턴

```java
String subject = "자바 프로그래밍"
int index = subject.indexOf("프로그래밍");
```

- 만약 주어진 문자열이 포함되어 있지 않으면 -1을 리턴
- 특정 문자열이 포함되어 있는지 여부에 따라 실행 코드 달리할 때 사용



##### 문자열 길이 (length())

> 문자열의 길이(문자의 수)를 리턴

```java
String subject = "자바 프로그래밍"
int length = subject.length();
```

- 공백도 문자에 포함



##### 문자열 대치 (replace())

> 첫 번째 매개값인 문자열을 찾아 두 번째 매개값인 문자열로 대치한 새로운 문자열을 생성하고 리턴

```java
String oldStr = "자바 프로그래밍";
String newStr = oldStr.replace("자바", "JAVA");
```

- String 객체의 문자열은 변경이 불가한 특성을 갖기 때문에 replace() 메소드가 리턴하는 문자열은 원래 문자열의 수정본이 아니라 완전히 새로운 문자열



##### 문자열 잘라내기 (substring())

> 주어진 인덱스에서 문자열을 추출

1. substring(int beginIndex, int endIndex)

   > 주어진 시작과 끝 인덱스 사이의 문자열을 추출

   - beginIndex부터 endIndex -1 까지

2. substring(int beginIndex)

   > 주어진 인덱스부터 끝까지 문자열을 추출

   - beginIndex부터 끝까지

```java
String ssn = "880815-1234567";
String firstNum = ssn.substring(0, 6);
String secondNum = ssn.substring(7);
```



##### 알파벳 소,대문자 변경 (toLowerCase(), toUpperCase())

> toLowerCase() 메소드는 문자열을 모두 소문자로 바꾼 새로운 문자열을 생성한 후 리턴
>
> toUpperCase() 메소드는 문자열을 모두 대문자로 바꾼 새로운 문자열을 생성한 후 리턴

```java
String original = "Java Programming";
String lowerCase = original.toLowerCase(original);
String upperCase = original.toUpperCase(original);
```



##### 문자열 앞뒤 공백 잘라내기 (trim())

> 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성하고 리턴

```java
String oldStr = "	자바 프로그래밍	";
String newStr = oldStr.trim();
```

- 앞뒤의 공백만 제거할 뿐 중간의 공백은 제거하지 않음



##### 문자열 변환 (valueOf())

> 기본 타입의 숫자값을 문자열로 변환

- String 클래스에 매개변수 타입별로 메소드 오버로딩되어 있음

- static 메소드 :  String.valueOf()

  <img src="https://lh5.googleusercontent.com/reSHF-2lYe6NjJMHZ6qeHxFeEehaedJxcAHxgTqpuJri9paX15ZjbUz3K_Wy2MVyISrwZg3LTjWu0rbHFAO-9d7gglvuNlYpIzb5O-HfFokioQlL7q2FfBUuNttndupRs8lmvqE" alt="img" align="left" style="zoom:40%;" />



#### 문자열 분리 방법

##### split() 메소드

> 정규 표현식을 구분자로 해서 문자열을 분리한 후 배열에 저장하고 리턴

```java
String[] result = "문자열".split("정규표현식");
```

- 여러 개의 구분자가 존재할 경우 파이프(|) 기호로 연결한 정규 표현식을 매개값으로 제공하면 구분 가능

  ```java
  String[] names = "문자열".split("정규표현식1|정규표현식2|정규표현식3");
  ```



##### StringTokenizer 클래스

> 문자열에서 구분자로 분리한 토큰을 반환

```java
StringTokenizer st = new StringTokenizer("문자열", "구분자");
```

<img src="https://lh5.googleusercontent.com/EWDYHSqd2HNMgwfFgdBgoFgLtbGSbwLoo_Dw8HTTWNLCpQLeoZ0lGvfjrUl1cp-vMRan8fWOQcMlgs0bSv4Cm1zgvrBidwGSQ1xH3FIXXU1W6itPQQN30bB1H33n4402sZn4UkU" alt="img" align="left" style="zoom:40%;" />

- 토큰

  - 쪼개진 문자열 단위

  - 특정 구분자로 분리되는 문자열의 구성 요소



##### 문자열 결합 연산자 (+)

- String은 내부의 문자열 수정 불가
- 대치된 새로운 문자열 리턴



#### StringBuffer, StringBuilder 클래스

> 버퍼에 문자열 저장

- buffer : 데이터를 임시로 저장하는 메모리

- 버퍼 내부에서 추가, 수정, 삭제 작업 가능

- 멀티 스레드 환경 : StringBuffer 사용

- 단일 스레드 환경 : StringBuilder 사용

  ```java
  StringBuilder sb = new StringBuilder();
  StringBuilder sb = new StringBuilder(16);
  StringBuilder sb = new StringBuilder("Java");
  ```

  <img src="https://lh3.googleusercontent.com/FMgmWtOB7KSn2adODXHLz_ZwNSbxGSUjKWr09_no6LtgxSZ7x7LCPREHRtuyogp9ZhkjbuoLdYnYaN9d5SwHKlniGkUKl6ASUfKz34HM-SrnD9DNoxpCtvSwUJYaytOkg5w7jv0" alt="img" align="left" style="zoom:40%;" />



#### 정규 표현식 (Regular Expression)

> 문자, 숫자, 기호, 반복 기호 등이 결합된 문자열

- 문자열이 정해져 있는 형식으로 구성되어 있는지 검증할 때 사용

- ex) 이메일, 전화번호, 비밀번호 등

  <img src="https://lh3.googleusercontent.com/3PyhORAf7my-ugyCApEG_Uf9cd4LZpD3SSWx3WILbv1xqxBHP6DKc0urg8pgbME_sM9xut_W8lqNXUByaeyfQjdnAxRAWy9JvLk4BbhKR37i3TMm2QjB-xaKP6WaqA5VOB3GRxY" alt="img" align="left" style="zoom:40%;"/>

  

##### Pattern 클래스

> 정규 표현식으로 문자열을 검증하는 역할

```java
boolean result = Pattern.matches("정규식", "검증할 문자열");
```



#### Arrays 클래스

- 배열 조작 기능을 가지고 있는 클래스

- 복사, 정렬, 검색 등

- Arrays 클래스의 모든 메소드는 정적 메소드

  - ex) Arrays.copyOf(), Arrays.sort()

  <img src="https://lh6.googleusercontent.com/utFUZTZlffJwCEP-VUputDqPKbVEanr3MhqBEWqxIYoQz6t1IO8Q507qf7Mjm6xQuqJT2IA_UrJhRILsaGMQmZnF0v7yhC9wW-JiTyfn6ko1_pEX7bWlcNvsqXpQXP2herIDxxU" alt="img" align="left" style="zoom:40%;" />



##### 배열 복사

1. copyOf(원본배열, 복사할 길이)

   ```java
   char[] arr1 = {'J', 'A', 'V', 'A'};
   char[] arr2 = Arrays.copyOf(arr1, arr1.length);
   ```

   - 0 ~ (복사할 길이 -1)까지 항목 복사

2. copyOfRange(원본배열, 시작인덱스, 끝인덱스)

   ```java
   char[] arr1 = {'J', 'A', 'V', 'A'};
   char[] arr2 = Arrays.copyOfRange(arr1, 1, 3);
   ```

   - 시작 인덱스 ~ (끝 인덱스 -1)까지 항목 복사

3. System.arraycopy()

   ```java
   System.arraycopy(원본배열, 원본시작인덱스, 타겟배열, 타겟시작인덱스, 복사개수)



##### 배열 항목 비교

1. equals()

   ```java
   Arrays.equals(원본배열, 타겟배열);
   ```

   - 1차 항목의 값만 비교

2. deepEquals()

   ```java
   Arrays.deepEquals(원본배열, 타겟배열);
   ```

   1. 1차 항목이 서로 다른 배열을 참조할 경우 중첩된 배열의 항목까지 비교



##### 배열 항목 정렬

- 기본 타입 또는 String 배열은 Arrays.sort() 메소드의 매개값으로 지정해주면 자동으로 오름차순으로 정렬

  ```java
  Arrays.sort(배열명);

- 역순으로 정렬하고 싶으면 Collections.reverseOrder()를 사용

  ```
  Arrays.sort(배열명, Collections.reverseOrder());
  ```

  - 주의 : Collections.reverseOrder()은 int[]에 사용 불가



##### 배열 항목 검색

> 특정 값 위치한 인덱스를 얻는 것

```java
Arrays.sort(배열명);
Arrays.binarySearch(배열명, 찾는 값)
```

- Arrays.sort(배열명)로 먼저 정렬하고 Arrays.binarySearch(배열명, 찾는 값) 메소드로 항목을 찾음



#### Wrapper(포장) 클래스

##### Wrapper 객체

> 기본타입(byte, char, short, int, long, float, double, boolean) 값을 내부에 두고 포장하는 객체

- 기본 타입의 값은 외부에서 변경



##### Wrapper 클래스

> 기본 타입에 대응되는 클래스

<img src="https://lh6.googleusercontent.com/ICXI87KwYHnn7aRiT_K6N2ckbhQcFgJwIIBYIgHA6AQ7AUeXUxRAFrTQU28Bw7Jfw0GvCYfbWBMCU0QhowAGyWAWzjElHdFDIgl5LeNUtxzhbGGyYRX2x_P9H9zayQsY0Snibw8" alt="img" align="left" style="zoom:40%;" />



##### 박싱(Boxing)과 언박싱(Unboxing)

- 박싱(Boxing)

  > 기본 타입의 값을 Wrapper 객체(포장객체)로 만드는 과정

  - 기본 타입 (int) : 100
  - Wrapper 클래스 : Integer

  ```java
  Integer obj = new Integer(100);
  ```

- 언박싱(Unboxing)

  > 포장 객체에서 기본 타입의 값을 얻어내는 과정

  ```java
  int value = obj.intValue();
  ```

- 박싱(Boxing) 하는 방법

  1. 생성자 이용

     <img src="https://lh6.googleusercontent.com/vNPrtWdKCHQvDBKcjZ-BAqalp_xRwCBf_noVtegFQ5vjMYiWdUtTS3hSBUHnENdV4tboKUwvprMRABqzJH84eiO80_a-suCF59Bt4AmwR3jJg54ybkm52LjQ4GkovRK8VLYiQUE" alt="img" align="left" style="zoom:40%;" />

     

  2. valueOf() 메소드 이용

     ```java
     Integer obj = Integer.valueOf(1000);
     Integer obj = Integer.valueOf("1000");
     ```
     

- 언박싱 코드

  - 각 포장 클래스마다 가지고 있는 클래스 호출

  - 기본타입명+Value()

    <img src="https://lh6.googleusercontent.com/df8qLQOrJjFYwWeXDZIYqUTstH1p5U1JC_tW3CVWWE4VVB3dIzKSyM1KIdKzl4QIjMTGqHN76KBONs5dn5HHdbVAQ2nx_BDlT5EF0yDQuoA0r5wu5BqFDii7cbFUjb57j6nRtZE" alt="img" align="left" style="zoom:40%;" />



##### 자동 박싱과 언박싱

- 자동 박싱

  - 포장 클래스 타입에 기본값이 대입될 경우 발생

    ```java
    Integer obj = 100; // 자동 박싱

- 자동 언박싱

  - 기본 타입에 포장 객체가 대입될 경우 발생

    ```java
    Integer obj = new Integer(200);
    int value1 = obj;			// 자동 언박싱
    int value2 = obj + 100;		// 자동 언박싱
    ```



##### 숫자 문자열을 기본 타입 값으로 변환

- parse + 기본타입명(문자열) : 정적 메소드

  ```java
  int num = Integer.parseInt("1000")
  ```

##### 포장값 비교

- 포장 객체는 내부값을 비교하기 위해 ==와 != 연산자 사용 불가
- 값을 언박싱 비교하거나, equals() 메소드로 내부값 비교



#### Math, Random 클래스

##### Math 클래스

> 수학 계산에 사용할 수 있는 정적 메소드 제공

<img src="https://lh6.googleusercontent.com/fcI3MSyQxRD-GB0RZkMfGVNhFjzikNUzMHqNn_vXzphIZOXT7lpIoYRyblU-TiofxMoCTjODTYyZ3bigzvNkBw75sb5C3JXXpjQ-xKJ6itGLWBfqh65vFVWYTiFyKPeJRL6FB20" alt="img" align="left" style="zoom:40%;" />



##### Random 클래스

> 난수를 얻어내기 위해 다양한 메소드 제공

- boolean, int, long, float, double 난수 리턴

- 난수를 생성하는 알고리즘에 사용되는 종자값(seed) 설정 가능

  - 종자값이 같으면 동일한 난수 발생

- Random 클래스로부터 Random 객체 생성하는 방법

  1. Random() // seed 값 없을 경우

     - 현재 시간을 초기값으로 하는 난수 발생

     - 실행할 때마다 다른 난수 발생

  2. Random(long seed)

     - seed 값을 초기값으로 하는 난수 발생
     - 실행할 때마다 동일한 난수 발생

  <img src="https://lh6.googleusercontent.com/5a_R91MdNCPrejx7UTiNj9jrlTMf83F-nXKgZSfLWuLWNa00cf_sWBKNkocUTXvNUZIIPFzFOcor3jolE9ouk9JP7kPKX2GFrgzgBl93tYT3i4U4Um0NhJxuHsJxyuhWXbXpqWQ" alt="img" align="left" style="zoom:40%;" />



- Random 클래스가 제공하는 메소드

  <img src="https://lh6.googleusercontent.com/YyKHt48BQ3DYgWfVaMXVwuI_6EUEMc3srqX3KsXZLhfc8Rr9JunlSQoze_AdhkzxD7UIeScr03g-hvgcdIBtlFd44LiCkrYUGyR0A_zEIuNSm2HW_a6wz9UNd5CizgRK4zmUYb0" alt="img" align="left" style="zoom:40%;" />



#### Date, Calendar 클래스

##### Data 클래스

> 날짜를 표현하는 클래스

```java
Date now = new Date();
```

- 객체 간에 날짜 정보를 주고 받을 때 주로 사용

- 특정 문자열 포멧으로 얻고 싶다면 SimpleDateFormat 클래스(날짜 형식 클래스)를 이용

  ```java
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy 년 MM 월 dd 일 hh 시 mm 분 ss 초");
  String strDate = sdf.format(new Date());
  ```



##### Calendar 클래스

> 달력을 표현한 추상 클래스

```java
Calendar now = Calendar.getInstatnce();
```

- OS에 설정된 시간대(TimeZone) 기준의 Calendar 객체 얻음

- 다른 시간대의 Calendar 객체 얻기

  ```java
  TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
  Calendar now = Calendar.getInstance(timeZone);

- 날짜 및 시간 정보 얻기

  <img src="https://lh3.googleusercontent.com/B4XfQmfJmvSbp8bhTOEZOfOztDm8DXwEDpgurR77ZfKNWBukUIKTTOSdNtfRNkmBosoPyED3Sf8N2Z_l-LiILXQ8RH2_JpK9oBVpvxA308n5QWdKP3quvOalYszDlTobwwTO0Ag" alt="img" align="left" style="zoom:40%;" />



#### Format 클래스

- 숫자와 날짜를 원하는 형식의 문자열로 반환
- 종류
  - 숫자 형식 : DecimalFormat
    - 적용할 패턴 선택해 생성자 매개값으로 지정 후 객체 생성
  - 날짜 형식 : SimpleDateFormat
  - 매개변수화된 문자열 형식 : MessageFormat



##### 숫자 형식 클래스 (DecimalFormat)

- 숫자 데이터를 원하는 형식으로 표현하기 위해서 패턴을 사용

- 생성자 매개값으로 지정해서 객체를 생성 후 format() 메소드를 호출해서 패턴이 적용된 문자열 리턴

  ```java
  DecimalFormat df = new DecimalFormat("#,###.0");
  String result = df.format(1234567.89);



##### 문자열 형식 클래스 (MessageFormat)

```java
String message = "회원 ID: {0} \n회원 이름: {1} \n회원 전화: {2}";
String result = MessageFormat.format(message, id, name, tel);
```

- 일정한 형식으로 문자열 포맷
- 문자열 데이터가 들어갈 자리를 표시해 두고 프로그램 실행 중에 동적으로 데이터를 삽입해 문자열 완성



#### java.time 패키지

- 날짜와 시간을 나타내는 여러 가지 API가 새롭게 추가됨

- 날짜와 시간을 표현하는 클래스

  <img src="https://lh3.googleusercontent.com/N4i1ky24RJQRT_q_QH4Gw0p_EyoYZrUpEI8u46OHlb8p2C-VAwvGtWrbqMui40W1-glR0vkHHYzVAgOhg4XWE3Iz3ZpfrbVr8JRUFoB7Appsj6UqNEFOA7HcrUHcc8oRfPMx_xY" alt="img" align="left" style="zoom:40%;"/>

  
  
  <img src="https://lh6.googleusercontent.com/T8oS1d3dE2hhKfbghg9hplJDWPQoEALZH6HxI6Oy6z7Y4q8l66oKkys1lNFlG2nmz2gRrmGBlR3LzX1nAJMDssc0WVajj2XQ0epBXMxd7Fo3duXNlsKCQLsZauhlB9IGcZdIYws" alt="img" align="left" style="zoom:40%;"/>
