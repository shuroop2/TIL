# TIL_Day_28

> 2022년 06월 21일

## jQuery

### jQuery

- 2006년 존 레식(John Resig)이 디자인 자바스크립트 라이브러리
  - 자바스크립트를 이용해 만든 다양한 함수들의 집합
- 무료 사용 가능한 오픈 소스 라이브러리
- 모든 웹 브라우저에서 동작

#### jQuery 특징

- jQuery 용량이 약 100KB로 가벼움
- 동적으로 HTML이나 CSS 컨트롤 능력 탁월
- 짧고 간결하게 코딩 가능웹 표준과 타 브라우저 호환성 뛰어남 (크로스-브라우저 지원)
- 편리한 Ajax 호출 방법
- 메소드 체인 방식 (여러 메소드를 연결하여 사용)으로 효율적인 코딩 가능, 간결하고 효과적인 코드 수정 가능
- 다양한 플러그인 제공

#### jQuery 사용 목적

- 쉬운 DOM 처리
- 쉽고 일관된 이벤트 연결 구현
- 쉬운 시각적 효과 구현
- Ajax 기능 쉽게 구현

#### jQuery 학습 내용

- jQuery 시작 / 기본
- 선택자
- 이벤트
- 입력양식 관련 이벤트
- DOM 요소 조작
- 효과
- Ajax 이용한 데이터 처리 (백엔드에서 다룸)

#### jQuery 코드 형태

- 객체 구조로 객체.메소드 형태
- 객체 선택
  - $("선택자").메소드
- 사용자가 생성한 객체 사용
  - var ojb = $("선택자").메소드;
  - obj.메소드;
- 메소드 체이닝
  - 여러 개의 메소드를 연결해서 사용하는 것
  - 객체.메소드1.메소드2. ...

#### jQuery 치환

- jQuery의 모든 함수 및 객체는 jQuery에서 제공되는 것이라는 점을 나타내기 위해 코드 앞에 jQuery 키워드 사용

  - ```javascript
    jQuery(document).ready(function(){...});
    ```

- 쉽게 하기 위해 $ 문자로 치환해서 사용

  - ```javascript
    $(document).ready(function(){...});
    ```

##### $(document).ready(함수) 명령어

- 화면에 페이지가 로딩되어 실행
- HTML 문서가 화면에 보여진 후에 자동으로 포함된 함수 실행
- 자바스크립트의 window.onload = function() { }; 에 해당

##### $(document).ready()와 window.onload = function() 차이점

- 같은 점
  - 콜백 함수가 호출되는 시점에서 DOM 요소에 접근 가능
- 차이점
  - $(document).ready()
    - DOM 요소가 로드 되었을 때 이벤트 발생하면서 호출 (외부 리소스, 이미지 또는 사운드 등이 로드 되기 전)
  - window.onload = function()
    - DOM 요소 뿐 아니라 외부 리소스, 이미지, 사운드 등 모든 콘텐츠의 로드가 끝나는 시점에서 이벤트가 발생하면서 호출

### jQuery 선택자 (selector)

- jQuery 코드는 선택자와 메소드의 조합으로 구성되는 경우가 많음

- HTML 태그를 쉽게 선택하기 위해 선택자 사용

- ```javascript
  $("선택자").메소드(매개변수, 함수 등);
  $("span").hide();
  ```

- 선택자 종류

  - 직접 선택자

    - 전체(*), 태그, 아이디, 클래스
    - <img src="https://lh4.googleusercontent.com/3NPzG7XFoEq1GalpXJcbCNSjxo5LltZo7HyONHqve4AAkOVXYvG6Hl4Xmd9litvzo82gEhLOYlTNWr4Q4MzUIasA1JM05OkBJ1zKW-nRkw9aiWDRh1slrWs7G9FvzMJUmnS1gHw" alt="img" align=left style="zoom:50%;" />

  - 인접 관계 선택자

    - 부모, 조상, 자식, 자손, 형제
    - <img src="https://lh6.googleusercontent.com/KObLrw5H7AjJkNlAtp8ai0thaXqwxP7DYudsUclqOU0_yKBXos8CusgTuEIbGPkUNJ-SfqNFjQ7yWn9_IamqTUV-3hZ6W7y6LX-m1WnX_ldK49MXuS8AzEzjaxN295bNKH2281M" alt="img" style="zoom:50%;" />
    - <img src="https://lh3.googleusercontent.com/VxSTvL3f3rxGP6mMicScesL7YYCIJ8SFZdLweT1J_hwPBglLssOOf_98WkJMquSLb7gxce1612P9FqBaR-9U24h7G1XCpl0fFVSAV0m6AJlg2AaPVouAzGiHxGrJvQa24aMBMpg" alt="img" style="zoom:50%;" />

  - 필터 선택자

    - 태그의 상태나 순서 등으로 선택

      - ```javascript
        $("태그명:순서필터")
        $("tr:odd") // 홀수 행인 경우
        
        $("태그명:상태필터")
        $("input:checked") // 체크 상태인 경우
        ```

    - <img src="https://lh5.googleusercontent.com/AorgwAMDc2llNrhyIORnBpWqk0NRQ9Yt8M45DtoMO3xliEoZLwAAVug-lRA1id9g_xICkmzUTJztGCEFvVXPqCSSqL-qXYqpTlFPqomDogXsBFXXadaq9JtzJqYo91OtcHaUit8" alt="img" style="zoom:50%;" />

    - <img src="https://lh3.googleusercontent.com/3WanpZsmATS0X7_fuujSpU80n1ftWksxv_Q75dRGixnvDFOzXyjHUfsaULMEuqrbKTtACyRYUx0X3dg17O1eyFtzqPHTI3SKBtwjtVLdzL-Z-z_C97K5Ec0fSuOB4A9Ki2tssUI" alt="img" style="zoom:50%;" />

  - 속성 선택자

    - 문서에 삽입된 HTML 태그(요소)의 지정된 속성 값에 따라 선택자로 정의
    - <img src="https://lh4.googleusercontent.com/wvx_xvU4Zege5Y3kXp0pZZuMd5Lkudeiy97uk0lUjIK1vBwN6X4KwND3zvOpvI49pAk0E-moY1y-S47KeBJNiOLEdIHQUMNlmxMl83nr6kOobixR7sdL5sLNAKucZ2-3fysB2qM" alt="img" style="zoom:50%;" />

#### jQuery 변수

- 변수명 앞에 $ 붙임

- ```javascript
  var $box1 = $('#box1'); 
  // $box1의 타입은 Object로 jQuery 메소드 사용 가능
  $box1.css('color', 'red');
  
  var $divLen = $(‘div’).length; // <div> 태그 개수 저장
  // $divLen의 타입은 Number 
  // 이 경우 일반적으로 $ 붙이지 않음 (자바스크립트 변수)
  var divLen = $(‘div’).length;
  ```

#### jQuery 이벤트

- 기존의 자바스크립트에서 사용했던 이벤트 대부분 사용

- jQuery를 이용하여 이벤트를 처리하면 훨씬 간단하고 쉽게 이벤트 처리 가능

- 이벤트 사용 기본 구조

  - ```javascript
    $('#btn').click(function() {...});
    ```

    1. 이벤트 대상 : $('#btn')
    2. 이벤트 등록 메소드 (이벤트 유형) : click()
    3. 이벤트 핸들러 (이벤트 처리 함수) : function() {...}

- 이벤트 등록 메소드 유형

  1. 단독 이벤트 등록 메소드

     - ```javascript
       $('#btn').click(function() {...});
       ```

     - 주의 : 동적 연결 지원 안됨

       - 동적으로 생성된 객체에 이벤트 적용 안됨

  2. 그룹 이벤트 등록 메소드 (여러 이벤트 적용)

     - ```javascript
       $('#btn').on('mouseover focus', function() {...});
       ```

     - 동적으로 생성된 요소에 적용 가능

- 이벤트 연결 방식

  - 정적 연결
    - 현재 HTML 화면에 있는 태그에만 이벤트 연결
    - jQuery를 통해 새로 삽입되는 태그에는 이벤트 연결 안 됨
  - 동적 연결
    - 현재 HTML 화면에 표시된 요소와 앞으로 생성될 요소에 전부 이벤트 연결 가능

- 이벤트 종류

  - 윈도우 이벤트
    - <img src="https://lh3.googleusercontent.com/FllsnKNGdVfujqkZLqR1ZGFsk9Y5Y2colnUTIXizOfOTYpt2lBy2rax4vALmsmi1BNdzzO7uslKmc4RdhUXqjIMObpKOMGMNabQLd0-UlwgosajBIopZX13EhYLPhg9lZcSV7i4" alt="img" style="zoom:50%;" />
  - 입력 양식 이벤트
    - <img src="https://lh6.googleusercontent.com/e_e2YBsBaGXkbyKkQjDHzBYj0mTOFRBkqIsG5MOTehdxxwqQDpLnRsx5X8zdsw49IgNkb-J-QaLQprUYhDA6dRGQ0uNHsyloga7u9tXfeTWFYU8cxEN1CRAmxvpP2314oDjYMt8" alt="img" style="zoom:50%;" />
    - input 입력란에서 엔터키 쳤을 때 문제
      - `<input>` 태그의 입력란에서 엔터키를 치면 무조건 submit 이벤트가 발생하면서 submit() 호출하고 서버로 전송되는 문제 발생
      - => 엔터키 쳤을 때 submit 되지 않도록 문서 전체에 이벤트 처리 : [Enter] 키의 아스키 코드 값 : 13
        - if(e.keyCode == 13) return false;
        - 문서 전체에 이벤트 처리
  - 마우스 이벤트
    - <img src="https://lh3.googleusercontent.com/HnpyncYSll82a2_PuXXQrIYszv37G_zL5mnVoptlybVSACb5joHJwTzYL-Qdji3c8QX6WSm0qg9awez8_Po5FsnU_WE0t5Eau6LHRxnaSw-SyD6NhISn8vkoXh-7fVf8DwE52-U" alt="img" style="zoom:50%;" />
  - 키보드 이벤트
    - <img src="https://lh5.googleusercontent.com/VhjqRur0OC1xrcBHufEn_Fg_alKu21jNe0hmCe7zotUit1jiQk3UHVBilQIW7d0tTkOVMxMqmlzMpJNmCmU1UIJo4YWLddvg2MDw17BC65SF4jTc1EbUsrn2cHf6kqEf4Rs3kvk" alt="img" style="zoom:50%;" />

#### jQuery DOM 요소 조작

- 동적으로 DOM 요소 조작
- jQuery를 이용하면 쉽고 간단하게 조작 가능
- DOM 요소 삽입 / 삭제 / 속성 추가 및 삭제
- DOM 요소 관련 주요 메소드 (삽입/삭제 관련)
  - <img src="https://lh5.googleusercontent.com/sLC2cPI1wC8ab0lmRGKz8ZwbLhV9TX0M9mBl7XsmraYqlvYEU2vwUT7jH94dLXojreNkrOVW7crD34wE-1Lfb9IERw2tpXhmmQgBaPdaOudr0Huq0GIekWZFBMblPKxd25GnZAE" alt="img" style="zoom:50%;" />
  - text()와 html() 메소드
    - 자바스크립트의 innerHTML 속성과 유사
    - 선택한 DOM 요소에 글자(텍스트)를 설정하거나 반환
    - html()
      - HTML 태그 인식 (태그 효과 적용)
    - text()
      - HTML 태그 인식하지 못하고 글자로 인식
- DOM 요소의 속성 추가 및 삭제
  - attr(속성명, 값) : 속성 추가 (prop())
  - removeAttr(속성명) : 속성 제거
  - attr() : 속성 설정, 조회
  - prop() : 활성화, 체크, 선택여부 등 동적 적용