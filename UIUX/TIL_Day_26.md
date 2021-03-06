# TIL_Day_26

> 2022년 06월 17일

## JavaScript

### 자바스크립트 함수

#### 함수 (function)

> 특정 기능을 수행하고 결과를 돌려주는 독립적인 코드 집합

```javascript
function 함수명() {
    // 함수 body : 수행 문장
}
// ex
function show() {
    alert("show() 함수입니다");
}
// 함수 호출 방법
show(); // 1) 필요한 곳에서 호출
// 2) HTML 이벤트 속성에서 호출
<body onLoad="show()">
<button onClick="show()">show</button>
```

- 독립적인 모듈 { }

- 메소드, 모듈, 기능, 프로시저 등으로 불림

- 함수를 사용하기 위해서는 반드시 호출해야 함

  - 함수는 호출하지 않으면 일 안 함

- 예외적으로 스스로 동작하는 함수

  - ```javascript
    (function() {...}) ();
    ```

  - 함수 호출 없이도 자동 실행

#### 함수의 종류

- (자동 호출되는 함수)
- 선언적 함수 (일반 함수 : function() { })
- 익명 함수
- 콜백 함수
- 화살표 함수
- 디폴트 매개변수

#### 함수의 반환 값

> 함수 실행이 끝난 후 호출한 곳으로 돌려주는 결과값

```javascript
function sum() {
	return n1 + n2;
}
// 함수 호출한 곳으로 값 반환
document.write("합계 : " + sum());
```

- 함수 내에서 return 문 사용

- 소수점 자리수 표시 함수 : toFixed(자릿수)

  - ```javascript
    변수명.toFixed(2) // 소수점 이하 2자리 출력
    ```

- 천단위 구분 기호 표시 : toLocaleString()

  - ```javascript
    변수명.toLocaleString()
    ```

#### 함수의 매개변수

> 함수 호출 시 전달된 값을 받기 위해 사용되는 변수

```javascript
function sum(x, y) {
	return x + y; // 함수 내에서만 사용하는 지역변수로 사용
}
document.write("합계 : " + sum(10, 20));
```

#### 함수 호이스팅

> 함수 선언 보다 먼저 함수 호출해서 실행되는 기능

- function 키워드 사용해서 생성한 함수는 호이스팅 가능

- ```javascript
  show(); // 먼저 호출 : 함수 호이스팅 가능
  function show() {...} // 나중에 함수 선언(정의)

#### 익명 함수 (Anonymous function)

> 함수명 대신 변수명에 함수 코드를 저장하는 구현 방식

```javascript
var 변수명 = function(매개변수) {...};
```

- 익명 함수의 호이스팅 불가

#### 콜백 함수 (Callback Function)

> 매개변수로 함수를 전달받아서, 함수의 내부에서 실행하는 함수

- 인자로 넘겨지는 함수를 콜백 함수라고 부름
- 콜백 함수로는 주로 이름이 없는 익명 함수 사용 (일반 함수도 콜백 함수로 사용 가능)
- 일반적인 콜백 함수 의미
  - 등록해 놓은 이벤트 또는 특정 시점에 되었을 때 시스템에서 호출하는 함수

##### 콜백 함수를 사용하는 이유

- 자바스크립트에서 비동기 처리 방식의 문제점을 해결하기 위해 사용
- 자바스크립트는 단일 스레드
  - 하나의 작업이 끝나고 다른 작업을 수행
  - 동시에 여러 개의 작업을 수행하지 ㅇ낳음
- 콜백 함수를 사용해서 다른 작업이 끝나기 전에 비동기적으로 작업을 수행하는 것이 가능

##### 콜백 함수 주의점

- 콜백 지옥 발생
  - 콜백 함수를 함수로 전달하는 과정이 반복적으로 이루어져 계속 들여 쓰기 형식으로 콜백 함수를 하다보면 감당하기 어려울 정도로 수준이 깊어짐
- 콜백 지옥을 해결하기 위한 방법
  - Promise : ES6 도입
  - async-await : ES8 추가

#### 화살표 함수 (Arrow Function)

> function 키워드 대신 화살표(=>)를 사용하여 간결한 방법으로 선언하는 함수

- ```javascript
  () => {...} // 매개변수가 없는 경우
  x => {...} // 매개변수 한 개인 경우 () 괄호 생략 가능
  (x, y) => {...} // 매개변수가 여러개인 경우 () 괄호 생략 불가
  x => {return x*x} // 리턴값 있는 경우
  x => x*x // 1줄인 경우 return 생략 가능

#### 디폴트 매개변수 (Default Parameter)

- 매개변수를 디폴트로 설정해 놓으면 전달되는 값이 없을 경우 디폴트 매개값으로 적용
- 주의
  - 디폴트 매개변수와 일반 매개변수를 섞어서 사용할 경우 디폴트 매개변수를 맨 뒤에 위치시킴

### 자바스크립트 객체 (Object)

#### 자바스크립트 내장 객체 (Built in Object)

- 미리 정의되어 있는 객체
- 선언 과정을 통해 객체 변수를 정의해서 사용
- 특별한 경우에는 사용자 정의 객체를 저으이하여 사용
- 대부분의 경우에는 내장 객체 사용

##### 대표적인 내장 객체

- Date : 날짜와 시간을 처리하기 위한 객체

  - ```javascript
    var today = new Date();
    var month = today.getMonth();
    ```

  - Date 객체의 시간/날짜 정보를 반환하는 메소드

    - <img src="https://lh4.googleusercontent.com/hKceWmTuCjR6UWRBSdy1dllJdFhx9Qm1RBFIpEo5sju5vZ8zLS7IPObKNzgT5G6hUZUjUtseD1EBYGJH6Sp1_rWa3bPhLqE5F5_rGFKroAM5jmglZqQXrG4W-cYuNL7vfumRFjM" alt="img" style="zoom:50%;" />

  - Date 객체의 시간/날짜 정보를 설정하는 메소드

    - <img src="https://lh3.googleusercontent.com/ZiSacxkEtAbtzbuT4nN0AEjvWVM7LTopSs188cqexsV5ETxhD_zrHyys4t-2NKobDqMHLGGPgNL2PnNdcauOWDWIJnI_3okWi16wyzlHS0r7sV4mo_i8eQLiZvSDul51Fi95B2w" alt="img" style="zoom:50%;" />

  - 날짜/시간 정보의 포맷을 변경하는데 사용되는 메소드

    - <img src="https://lh5.googleusercontent.com/c_Cs_1xLBoRuFdYXpPWB6Vin8LKE8tKVDqeVuyy7JiEWYfEIgdHPg0QF9YuulPYB6G_Bwn69Wx7ZHe2GlpoLH9832kITS0V4Waq-is0t9-r0XTBmJgcXmHUIl5NSUwLw7Ns9nBg" alt="img" style="zoom:50%;" />

- Array : 배열을 만들기 위한 객체

  - ```javascript
    var arr = new Array(3);
    arr.push("홍길동");
    ```

  - Array 객체의 주요 메소드

    - <img src="https://lh4.googleusercontent.com/BJgCBcYF_eZFC54CS4xFBkKPqQ3INEs8gdshdQB3Z4SGLd1Kb1gSMF1_tYhfAn8MgEPm8HwJJhKlkC1ZG4W34dltaDy2PZo3QGO8li-_b0IP4um0JPiCLzSVgrCcbjUQkRd-r0w" alt="img" style="zoom:50%;" />

- String : 문자열을 다루기 위한 객체

  - ```javascript
    var name = new String();
    name.fontsize(5);
    ```

  - new를 이용해서 객체를 생성하지 않고 상수형태("문자열")로 문자열을 만들어도 객체의 특징 모두 사용

    - ```javascript
      var name = "홍길동";
      name.fontsize(5);
      ```

  - 문자열 속성을 설정하는 메소드

    - bold() / fontsize() / ...

  - String 객체의 주요 메소드

    - <img src="https://lh4.googleusercontent.com/V-VOGfWcL7jmYSGzWcYbVkZUHiUW05jyxWKAgQnMAx9x4SoN5Kh2QIzyHaqxF-NJUniICb_vDg77zOL5p9j73RZyQYyIcWb3DvPm4RterGecqbEt8fIaYrrWUePYgCcSNfYgnao" alt="img" style="zoom:50%;" />

    - charAt(인덱스)

      - 인덱스로 지정된 위치의 문자 반환
      - 인덱스는 0부터 시작

    - substring(start, end)

      - 문자열 일부분 추출
      - 인덱스 start ~ end-1 까지의 문자열

    - indexOf("문자")

      - 문자열에서 지정된 문자의 위치를 인덱스 값으로 반환
      - 인덱스는 0부터
      - 검색할 때 왼쪽부터 찾아서 처음 발견한 문자의 위치를 알려주는 것
      - 찾고자 하는 문자가 문자열에 없으면 -1 반환

    - split("구분자")

      - 구분자로 문자열 분리

      - ```javascript
        str = "1998-12-25";
        var birth = str.split("-");
        // 문자열이 "-" 기준으로 분리되어 배열에 순서대로 저장
        // birth[0]에는 1998이 저장되고
        // birth[1]에는 12가 저장되고
        // birth[2]에는 25 저장

  - 자동 형변환

    - ```javascript
      var result = "10" + 10;
      	result ? : 1010; // 문자열 연산이 우선
      var result = "10" * 10;
      	result ? : 100; // 숫자 연산이 우선

- Math : 수학 계산을 위한 객체

  - 상수 값은 속성으로, 수학은 메소드로 제공

  - Math 객체는 속성이나 메소드를 접근하기 위해 따로 객체 변수 선언하지 않음

  - ```javascript
    Math.속성
    Math.메소드()
    ```

  - Math 객체의 주요 메소드

    - <img src="https://lh3.googleusercontent.com/52Z37b9vc00f3n-R9BSp3Q48_ThJ-3cd9kfD8CTwU1qp6xlDTVIJMjNglQmGB6iYWugdbelCjYqD4DggC2MsSS-OA066NVLWNwcesdqstUX-_jLTKHBULMNbn4oGVOUtCxXQXr0" alt="img" style="zoom:50%;" />

- Screen : 화면의 해상도, 색상, 크기에 관한 정보를 제공하는 객체

#### 브라우저 객체 모델 (Browser Object Model)

> 웹 브라우저를 대상으로 이루어진 객체

- 자바스크립트에서는 웹 페이지를 구성하는 HTML 태그의 모든 요소와 웹 브라우저를 구성하는 요소들을 객체로 정의하여 제공
- 객체들을 계층구조로 분류
  - window : 창
  - document : 문서
  - history : 웹 브라우저 기록 정보
  - location : 주소 정보
  - navigator : 웹 브라우저의 종류 정보
  - <img src="https://lh6.googleusercontent.com/IRiQKH--tMcE9jHN7q2RnvMIZxCwsB-2yBv94S4sdQXhDn3aXnDxkbzRst2CY2vzsZQzFkrFfhnMYm7T2HddiX8AW7vQ1zo2SVEJ2kF6uLdAWvVyxjKghEcDvoudoGAncI9F_l0" alt="img" style="zoom:50%;" />

##### window 객체

> 창에 대한 전반적인 상황을 제어하는 최상위 객체

- 자바스크립트에서 사용되는 모든 객체는 window 객체의 하위에 존재

- Navigator 객체만 제외하고 모든 객체는 window 객체를 통해서 접근하여 사용

- 그러나 사용시 window는 생략 가능

  - ```javascript
    window.document.pic.src = "a.jpg";
    document.pic.src = "a.jpg";
    ```

- window 객체 주요 속성

  - <img src="https://lh3.googleusercontent.com/Cw7EZeH0LKa2hFMiQDyku-mr41Ae3syk0SoT3B2gWzmtP3cUfdKzJItj8F_DBnP-rEi7rBZRQiH7PN5oi166oLAvLB4lpEyybvT30njuZ-DSakf6EolEMSnycJFWmPsIe0zlTak" alt="img" align=left style="zoom:50%;" />

- window 객체 주요 메소드

  - <img src="https://lh4.googleusercontent.com/NdvL5IJC72QI-oEIVZAgPwbYQ1qOnhTq8ahrZ1iextZ5G2szG2TZtH3d8kbPmnlzcYzdzV_yw1WG-gKu23BrhirBfsYgiX8ALoqs2FKfg4mlhZvwfWO7hKnoQf7NXW1__Nxf8zA" alt="img" align=left style="zoom:50%;" />

  - open() 메소드

    - window.open("URL", "창이름", "창 속성");

      - 새로운 창을 만들거나 기존 창을 열어서 화면에 출력하는 기능

      - URL : 웹페이지 주소 및 HTML 파일명

        - 파일명이 없으면 새로 만들고, 있으면 기존 파일 열기

      - 창이름 : 새로 만들어지는 창 이름

      - 창 속성 : 창의 모양이나 특징

      - ```javascript
        window.open("test.html", "test", "width=200, height=200, status=yes, scrollbars=yes, resizable=yes"); // test.html 문서를 새창에서 열기
        window.open("", "test", "width=400, height=200"); // 새로운 창 만들어서 열기
        ```

  - setTimeout()

    - 타이머 설정과 해제

    - setTime('호출함수', 지연시간)

      - 시간 설정

      - 일정 시간이 지난 후에 호출함수를 1번만 실행

      - ```javascript
        setTimeout('winClose()', 1000); // 1초 후에 winClose() 함수 호출
        ```

    - clearTimeout(타이머ID)

      - 시간 설정한 것 해체

      - setTimeout() 메소드가 반환하는 타이머 ID를 받아서 타이머 ID에 해당되는 타이머 설정 해제

      - ```javascript
        타이머ID = setTime('호출함수', 지연시간);
        clearTimeout(타이머ID);
        ```

  - setInterval()

    - 타이머 설정과 해제

    - setInterval('호출함수', 지연시간)

      - 일정 시간 간격 안에 반복 실행

      - ```javascript
        setInterval('showTime()', 1000); // 1초 간격으로 showTime() 함수 호출
        ```

    - clearInterval(타이머ID)

      - 시간 설정한 것 해제

      - ```javascript
        타이머ID = setInterval('showTime()', 1000);
        clearInterval(타이머ID);
        ```

##### history 객체

> 최근 방문한 주소에 관한 정보를 기억하고 있는 객체

- history 객체 주요 메소드
  - back() : 이전에 열었던 페이지로 이동
  - forward() : 이전 페이지로 이동 후 다시 앞으로 이동
  - go() : 몇 단계 뒤에 있는 페이지로 이동
    - go(3) : 3단계 앞의 페이지로 이동
    - go(-2) : 2단계 다음 페이지로 이동

##### location 객체

> 현재 브라우저의 주소창에 표시된 주소값에 관련된 내용을 다루는 객체

- location 객체 주요 메소드
  - <img src="https://lh6.googleusercontent.com/aOb473FKfwdrtRE_HnismykNG9HNBt8vYDvqfeqBJf6FXaYUo_3J0FUKwuCcfn9l3Cpkw1V0RD_BGG20o5USJG-o261PwzxGMlzJSqwf5o0EM9iF_m9wS0PZekuI8eChjxVOhiw" alt="img" align="left" style="zoom:50%;" />



