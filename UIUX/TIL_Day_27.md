# TIL_Day_27

> 2022년 06월 20일

## JavaScript

### 문서 객체 모델 (Document Object Model : DOM)

> 객체 지향 모델로써 구조화된 문서를 표현하는 방식

- HTML 문서에 접근하기 위한 표준 모델

- 표준은 대부분의 브라우저에서 DOM을 구현하는 기준

- 문서 내의 모든 요소를 정의하고, 각각의 요소에 접근하는 방법을 제공

- 웹 브라우저에 보여지는 HTML 문서 태그 요소에 대한 정보와 문서에 대한 여러 가지 속성 제공

- document 객체의 하위 객체를 이용하여 문서 내에서 일어나는 다양한 기능 제어

- document 객체의 하위 객체

  - layer, image, area, anchor, form

- document 객체의 주요 속성

  - <img src="https://lh6.googleusercontent.com/5Jzt3aGVtgE-hlax2sSrwLKih4xfTECboYz-cFdZomjAjZDhf1-LCXov-6XL1Zdz3HJjZAhdy-6yU5lL6RHTeM4kJIDQmyTGuXi6YTyPVeBZxlBqVHteXZ9YBYOVrvxDoZPBvNQ" alt="img" style="zoom:50%;" />

- document 객체의 주요 메소드

  - <img src="https://lh3.googleusercontent.com/UL8yoqvNJlL4kQ-fjxCjPuY4cyd0Q1s7YWiHqD6vXOATZ_ZR0PPfsh8J4Dev_zUhYDt1fnUS9bVr7I6fSjqoAXbKYs_iTlWxANGuE3WJMdoBqk47TZKLQsYKNj9-7rKYoZWzxvU" alt="img" align=left style="zoom:50%;" />

- 문서 내의 요소(태그) 제어 메소드

  - <img src="https://lh5.googleusercontent.com/FVaqU5iab_VNcUGtS25AGjTVZzLb0hWE-2vTfUWnOYpzdOoU48AC5LkmnmVrcTZwfkXUR2oCSLKTBtALLFpuWskLvBeMUEViqeSzoUhBkQxK33v97aLhDB8npYyb6xPLy-h8m9I" alt="img" style="zoom:50%;" />

  - getElementById()

    - id를 통해 문서 내에서 요소(태그)를 참조하는 메소드

    - 지정한 id 속성값을 갖는 개체 중 첫 번째 개체 참조

    - ```javascript
      var 참조변수 = document.getElementById('abc');
      <xxx id="abc"...>
      ```

  - getElemensByTagName(‘태그명’);

    - 문서 내의 모든 요소를 배열 컬렉션으로 전달받아서 참조할 수 있게 해주는 메소드

    - 참조 값들은 배열로 만들어져서 전달

    - ```javascript
      var tdArr = document.getElementsByTagName('td');
      ```

      - 문서 내의 `<td>` 태그 수가 배열 크기가 됨
      - for 문 사용

  - 문서 내의 요소(태그) 제어 메소드 사용 시 주의점

    - 문서 내에서 요소(객체)들이 생성되기 전에 자바스크립트를 선언하게 되면 요소를 선택할 수 없음
    - <img src="https://lh4.googleusercontent.com/4mXeeRTrB1axaxCtXycF6d6rsK95gNPVQvZzcpyg8ZRn-c_9jq2YgSvjwHnDjjCi3yjww0tBiBIyECLwkLdK_81ERbTirgriFPx8L98ChkFxCp3b63atNgaIzVfDt9bh_EdAGEc" alt="img" style="zoom:50%;" />

#### DOM 사용 시기

- **HTML 문서가 로드되고 나서** 파싱 작업을 거쳐 DOM 트리 생성

- **DOM 문서가 로드될 때** 모든 DOM을 사용할 수 있게 되는 때가 되는 것

- ```javascript
  <script>
          // html 문서 요소가 다 로드된 후에 메소드 사용
          window.onload = function() {
              var box = document.getElementById("box");
              box.innerHTML="변경2";
          }
  </script>

#### 윈도우 이벤트 종류

- document (ready)
  - 문서 객체 요소가 모두 로드되었을 때 발생
  - 문서 객체 요소가 자바스크립트에서 사용 가능한 상태인지 확인하고 작동이 가능한 상태일 때 발생
- load
  - 문서 객체 요소가 모두 로드되었을 때 발생
  - 리소스, 이미지, 또는 음악 등 로드가 완료된 상태

#### 이벤트 핸들러와 이벤트 처리

- 사용자로부터 발생되는 여러 가지 이벤트 처리

  - 자바스크립트에서의 이벤트 처리 방식
  - <img src="https://lh3.googleusercontent.com/3zNe02NVsHv4PXc361epHXTynv9p-QjpIB4BgjDd_9G1NJe9hD9SP4mK5d_kHKnwwB8fZC2ODE4CpnoKiDHzTmsfqJvUxFWAgDTR85qRtal2Lei9xJ5kxeAPIt1ex0TIGc-xDRw" alt="img" align=left style="zoom:50%;" />
  - <img src="https://lh4.googleusercontent.com/t8nHomJcN3iA_-idcVdczVOd2T3eXxuxPBH7qA391drExl_tL-NeGgvWgxPgeUjHWLM5KYDCUjMkos5OCsLU8xyrQ_mYc3X2B0bQfyIk4yCm7vnY6hrFFB5vGp3uPKzVMU0NuJM" alt="img" align=left style="zoom:50%;" />

- 이벤트 리스너

  - ```javascript
    객체.addEventListener('이벤트명', function() {
    });
    
    객체.removeEventListener('이벤트명', function() {
    });
    ```

  - 화살표 함수 사용 가능
    
    - ```javascript
      객체.addEventListener('click', () => {
      });
      객체.removeEventListener('click', () => {
      });
      ```

#### 폼 유효성 확인

##### form 객체

> document 객체의 하위 객체

- form 태그 내에 들어 있는 여러 입력 양식들 제어

- form의 하위 객체들

  - <img src="https://lh4.googleusercontent.com/-6L0dpFFwPEKWm-Y2bgV7CMKWSTOFGEJEUXbESj8WPWPFP-grt6BaRF5UvmXKoxFgmAKD1wN04hdC2JjqHchbxNv4-63N-KyjpiKIxd-rqtx_XfOHO70aL9HRfC74qUJUlt4dzY" alt="img" style="zoom:50%;" />

- form 객체 사용 방법

  1. 태그의 name 속성을 객체로 사용하는 경우

     - ```javascript
       <form name="joinForm">
       <input type="text" name="id">
       joinForm.id.focus();
       ```

  2. 문서 객체 모델(DOM) 방식을 사용하는 경우

     - ```javascript
       <input type="text" id="name">
       var name = document.getElementById('name');
       name.focus();
       ```

- select 객체

  - 리스트 박스에 있는 여러 항목 중 선택
  - 항목 선택하면 selectedIndex 속성에 선택된 항목의 인덱스 값 저장 (0부터 시작)
  - 하나도 선택하지 않으면 selectedIndex 값이 -1

- radio 객체

  - 그룹 중에서 1개만 선택 가능

  - 그룹에 속한 여러 개의 라디오 버튼의 이름이 동일하므로 radio 객체는 배열 형태로 사용

  - checked 속성이 true면 체크된 상태

  - false면 체크되지 않은 상태

  - for 문에서

    - ```javascript
      if(joinForm.emailRcv[i].checked == true)

### 사용자 정의 객체

- 사용자가 직접 필요한 객체 생성
- 사용자 정의 객체 생성 방법
  1. 리터럴 이용
  2. 생성자 함수 (function) 이용
  3. new Object() 이용 (ES5에 추가)
  4. class 정의하고 객체 생성 (ES6에 추가)