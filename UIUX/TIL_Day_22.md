# TIL_Day_22

> 2022년 06월 14일

## CSS 기초

### 스타일 시트 (CSS)

- Cascading Style Sheets : 계단형 스타일 시트
  - 단계적으로 스타일 적용
  - 여러 스타일이 겹치면 맨 마지막 스타일 적용
- HTML의 레이아웃 배치 등의 한계를 보완하기 위해 개발된 독립 언어
- 일정 기능들을 미리 지정하여 여러 부분에서 동일하게 적용

#### 가능한 작업

- HTML 문서 내의 글꼴, 크기, 색상, 배경, 테두리, 레이아웃 배치, 여백 등 지정
- 글자의 정렬 방식, 그림자 지정 등 다양한 효과
- 애니메이션, 동적 기능 구현 가능

#### 스타일 시트 장점

- 자유롭게 웹 문서 편집
  - HTML 한계점 극복 가능
- 통일감 있는 문서 작성
  - 한 번만 정의하여 문서에 일관되게 적용 가능
- 편리한 문서 관리
  - 외부스타일 스타일 시트 파일을 사용할 경우
  - 여러 웹 문서에 동일한 스타일 시트 사용 가능하고
  - 한 번만 수정하여 모든 웹 문서의 스타일을 동시에 변경 가능

#### 스타일 시트 적용 방법

1. 문서 내부에 정의 (Embedded Style)

   - `<head>` 태그에 삽입

   - 문서 전체에 특정 효과 주기 위해 사용

   - ```html
     <head>
         <style type="text/css">
             태그명 {속성(property):값(value);}
         </style>
     </head>

2. 외부 문서에 연결 (Linked Style)

   - 별도의 스타일 시트 문서를 만들어 놓고 필요한 HTML 문서에 연결하여 사용

   - 웹 사이트의 모든 문서에 동일한 효과를 적용하여 웹사이트에 통일감을 주고 싶을 때 사용

   - ```html
     <head>
         <link rel="stylesheet" type="text/css" href="파일명">
     </head>

3. 태그에 직접 정의 (Inline Style)

   - 특정 태그에만 스타일 시트를 적용할 때 사용

   - ```html
     <태그명 style="속성(property):값(value);">
     ```

#### 다중 스타일 시트

- 하나의 요소에 대하여 외부, 내부, 인라인 스타일이 서로 다르게 지정되어 있는 경우 적용되는 스타일
- 스타일 적용 순서
  - 웹 브라우저 디폴트 값
  - 외부 스타일
  - `<head>` 부분의 내부 스타일
  - 태그에 정의된 인라인 스타일 (최종 적용된 스타일)

#### 스타일 시트의 기본 형식

- 선택자 (selector)

  - 스타일을 적용할 대상
  - HTML 문서의 태그, 아이디, 클래스, 속성 등으로 선택

- 형식 : {속성:값;}

  - 변경(적용)하고자 하는 속성
  - 글꼴, 크기, 색상, 위치 등

- 사용 예

  - ```css
    /* (태그 선택자) 모든 <h1> 태그에 스타일 적용 */
    h1 {color:red;} /* 세미콜론 반드시 있어야 함 */
    ```

### 선택자 유형

1. 태그 선택자

   - 태그명 사용

   - 요소(element) 선택자라고도 함

   - HTML 문서에 있는 같은 모든 태그에 동일하게 적용

   - 태그명 {속성:값;}

   - ```css
     h3 {
     	background-color:#000;
     	color:#fff;
     	width:50%;
     	margin-left:20px;
     }

2. 클래스 선택자

   - 문서에서 특정 부분에만 필요한 CSS 적용할 때 사용

   - `.` 사용

   - 사용자 정의 선택자 또는 도트(.) 선택자라고 함

   - 정의한 클래스 선택자를 태그에 적용

     - 여러 태그에 적용 가능
     - 그룹화 의미

   - HTML 태그에 class="클래스이름" 으로 지정되어 있어야 함

   - 형식

     ```css
     .클래스 {속성:값;}
     <태그명 class="클래스이름"></태그명>
     ```

     <img src="https://lh5.googleusercontent.com/Q9QaUmjqGky6s-wXSCZAXTvF3AOZpp3oWZOMv1BIjvS0Zhfc6q-pgB0VtaOfFKUbe2l-ZQCqncL9K-Lh2Mu6n68kh-2qCeV8NPNptA7zBbI-jvhyKf5xmUfwjDvTBlzrlyHoNLk" alt="img" style="zoom:50%;" />

3. 아이디 선택자

   - 문서에서 특정 부분에 필요한 CSS 적용할 때 사용

   - 필요한 부분에 유일한 아이디를 지정하고 CSS 적용

   - 식별 선택자라고도 함

   - `#` 사용

   - HTML 태그에 id="아이디명"으로 지정되어 있어야 함

   - 형식

     ```css
     #아이디명 {속성:값;}
     <태그명 id="아이디명"></태그명>
     ```

     <img src="https://lh4.googleusercontent.com/FcdTap-K-35XmJHN1RyEqC69KhjyxrEDGPJBVn5LngNTavHQ9O9NIRywzgdo2BR47tRQNmnKl_JmAmlkTeKJvaWeowt3ljl1mYEvSg37UC6nHOPPVWvm70GVTM-WbUk5j2WjRus" alt="img" style="zoom:50%;" />

4. 속성 선택자

   - 문서에 삽입된 HTML 태그의 지정된 속성 값에 따라 선택자로 정의

   - 예 : `<a>` 태그의 title 속성 값

     - ``` css
       <a title="산업기사" href="www.naver.com"> </a>
       ```

   - 형식

     ```css
     태그명[속성="값"] /* 일치하는 */
     태그명[속성^="값"] /* 시작하는 */
     태그명[속성$="값"] /* 끝나는 */

5. 상태 선택자

   - 태그의 상태에 따라 선택 가능
   - 선택자 : checked - 체크된 input 태그 선택
   - 선택자 : focus - 포커스를 받은 input 태그 선택
   - 선택자 : enabled - 사용 가능한 input 태그 선택
   - 선택자 : disabled - 사용 불가능한 input 태그 선택

6. 자식 / 자손 선택자 (상속 선택자)

   - 자식 / 자손의 개념

     <img src="https://lh6.googleusercontent.com/UcD-OvtrvS-0VVI0EkrqJYf4F_1krTUqQyNlr-vDG3cKE6zPjYkLeVeGoCEGQ4J5HQF4UDDKk9Sm9BgvFh1icdGmQf3mBpQDfXA8GzqwUQ4eECHMV1cKyXPFjOKDMyx8_SMF44Q" alt="img" style="zoom:50%;" />

   - 자식 선택자 : `>` 부호 사용

     - ```css
       선택자 > 자식 선택자
       /* 예시 */
       선택자A > 선택자B
       #header > h1
       ```

     - `<table>` 태그에 자식 선택자 사용 시 주의

       - ```css
         table > tr > th {color:red;} /* 적용 안 됨 */
         /* 개발자 도구에서 Element 확인하면 <tbody>태그 존재 */
         table > tbody > tr > th {color:red;}  /* 적용됨 */
         tr > th {color:red;} /* 이런식으로도 가능 */
         ```

       - 자식 선택자 사용 추천하지 않고 자손 선택자 사용

   - 자손(후손) 선택자 : 띄어 쓰기 (간격) 사용

     - ```css
       선택자 자손선택자
       /* 예시 */
       선택자A 선택자B
       #header h1
       #pageNav ul li a:hover
       ```

   - first-child 선택자

     - ```css
       .wrap div:fisrt-child
       .wrap div:fisrt-child + div
       ```

   - nth-child(숫자) 

     - ```css
       .wrap div:nth-child(1)
       .wrap div:nth-child(2)
       .wrap div:nth-child(3)
       /* 짝수 행 선택 */
       #stdTable tr:nth-child(2n)
       ```

   - 동적(반응) 선택자

     - 선택자 : active - 마우스로 클릭한 태그 선택
     - 선택자 : hover - 마우스를 올린 태그 선택\

### CSS 단위

- 키워드 단위
  - 키워드에 해당되는 스타일 자동 적용
- 크기 단위
  - %
    - 기본으로 설정된 크기를 기준으로 상대적인 크기를 지정
    - 0%가 초기에 설정된 크기임
  - em
    - 배수를 나타내는 단위
    - 1배 = 1em = 100%
    - 1.5배 = 1.5em = 150%
  - px
    - 크기를 절대적으로 지정 (픽셀)
    - font-size인 경우 px 또는 pt 다 사용 가능
- 색상 단위
  - RGB
    - 3가지 색상을 조합해서 색상 표현
    - 0 ~ 255 숫자 입력
  - RGBA
    - RGB 색상 단위에 알파값을 추가한 형태
    - 알파값 : 투명도를 나타내며 0.0 ~ 1.0 숫자 입력
    - 0.0 : 완전 투명 상태
    - 1.0 : 완전 불투명 상태
  - HEX 코드 단위
    - RGB 색상 단위를 간단하게 표시하는 방법
    - 색상을 16진수로 표현
    - 각 색상 요소에 00부터 FF 사이의 값 입력
    - #ff0000, #00ff00, #0000ff, #333333
    - #000, #fff, #777
  - URL 단위
    - 이미지나 글꼴 파일을 불러올 때 사용
    - <img src="https://lh3.googleusercontent.com/f4nCLGrtTYMN13bWUdeKahTLE8JI3fI7myM_y0Bc4K89hRvNeTfEhYcSF8gay9fanpfrDL3wdJQ1Dej6wGamTWPheIMwsdKj_uv9bc9ZnVWKVTyUkaZzLfZBkHs1xx-omjXNBWY" alt="img" style="zoom:50%;" />



## CSS 속성

### 텍스트 속성

<img src="https://lh5.googleusercontent.com/x7XlOt281REf4OZwK9WBfO4hKG4NwZfLXdSIY_qp-zi15t_HlGMB7KM6kCMpXTXolUsTRCDGo-IpirvSyZaOqGEE7SX24hmLQzunBt3O4xQFYK8B77usYhms8E5Gsh2M-9JSYnM" alt="img" align="left" style="zoom:50%;" />

### 배경 색상 / 이미지 관련 속성

#### 배경색

<img src="https://lh6.googleusercontent.com/aCk3GGbWvP8s4lVKC48NjrRSqqlCx3Z2KlXlfhvuPmZiwsvpEuTiXELZZHujdHCWAYz09OcVIPdkk5eEaxrhalC8xJnVOSdFl5t-g0BEtAYwcR5IDO92z3_cqkqHDIvOBi5n1rk" alt="img" align="left" style="zoom:50%;" />

#### 배경 이미지 / 반복

<img src="https://lh4.googleusercontent.com/ZsKMJfP0eSRVelr45dzibtwL0_8-r3uDyy4T2OX4pEHgVepA0WwDirWXwpE6K3_fxOPyUjKrHIrFhjxzEip853GgIPrtRdQiLwU-J_yRsLH0TKWjyiGhrBD9cC2H_kjhmET-RzE" alt="img" align="left" style="zoom:50%;" />

### 테두리 속성

- 테두리의 유형 / 두께 / 색상 지정

<img src="https://lh4.googleusercontent.com/Rp0ANIobpZJg76oeN13PLk5JRt_Zk-Ump-rA1H3PK7KhGWzNGmGwbcHg9LSCJZVJsziGB2PPUGn1OAF4QqSkn9_-hlHg50aU57N9kuafAL5IqL6yc2awBRDhEJlD7uW5qcvYcm0" alt="img" align="left" style="zoom:50%;" />

### 여백 속성 (padding / margin)

<img src="https://lh6.googleusercontent.com/ts7CjGvP_ojUlPULYmQ7_ND-9yzUe9Hf79oYD4LZY4hAV-KFQU8ThtYD0hVvBA9sHUv8t_jnrvYEsTWQoNJWrZzjAbG0sybJEZombPU94r5UHQzqE5m56-jED6R2z7Osl6sFTOI" alt="img" style="zoom:50%;" />

- 가운데 정렬

  - align-center.html

  - 컨테이너 태그 자신을 가운데 정렬

    - ```css
      margin:0 auto; width:400px;

  - 안에 포함된 내용을 가운데 정렬 

    - ```css
      text-align:center;

  - 주의! `<table>` 태그인 경우

    - ```css
      margin:0 auto; width:400px;

  - `margin:0 auto;` 사용할 경우 width 속성값이 있어야 함

### Display 속성

- inline / block / inline-block
- block
  - 행으로 배치
  - 옆으로 나란히 배치 안 됨
  - 여백 있음 (내용물 외에 여백 존재)
  - <img src="https://lh6.googleusercontent.com/cI3VY7XVIeR1UWivoYrI1zwfgIRuy7-5j-Nh_MVAfEmgMs-2eRKbQTqkC2cYGaZSPZjq1O9_wPZ6Aw2iuyeCH_DjaJoKxcXyFfDaE0AoZXruiPxgcFXbYiGVWJqIQcMztuvDPm8" alt="img" align="left"/>
- inline
  - 옆으로 나란히 배치
  - 여백 없이 내용물 만큼만 공간 차지
  - <img src="https://lh6.googleusercontent.com/uin63S5kZGcjp4xe01oSiCiltPC_DfwvR3tYv_jOfDLwAf1cYAimTRu8QfBLDPy95oS62B26VK6tqLr36duORd6EHxAMPECqZgfSpKleDk1ImtbSsxTfVtcHWH_xlhhFL_paiXA" alt="img" align="left" />
- inline-block
  - 인라인, 블록 성격 모두 포함
  - 옆으로 나란히 배치되면서 박스 내부에 여백 존재
  - <img src="https://lh6.googleusercontent.com/g78oVW9oQVrNDlh12aB8YPRjoKxFnOki5hSpSlQlcgQUjF3GKYMFwJNA_VhUMUsC4tAPzVhkgGGEE1rvFCb5tJOmVe1qK8DgAEc1jIpNkrDYCJuuF2ukwVHugEEzNI8HRVyJc0U" alt="img" align="left" />

### float 속성

- 해당 요소를 떠 있게 만드는 속성
- 즉, 기본 레이아웃 흐름에서 벗어나 왼쪽이나 오른쪽으로 이동하는 것을 의미
- left : 왼쪽에 배치 (inline + left 정렬)
- right : 오른쪽에 배치 (inline + right 정렬)

### 목록 관련 속성

- type 있고/없음
- 블릿 기호 없애고 가로로 배치
- <img src="https://lh5.googleusercontent.com/CWbykDmfpE2q8s5DgipPGKSozGBpgKvt4ELQ1_b-2ruZn556NdWY1VkW2aXBuaSxErPK9KOonahp6F9oufE9jtyhGCzhuSFrHKbIM2x5aQblmchvU5dkjq27Xg7nxoD92Yf29Ls" alt="img" style="zoom:50%;" />

### 위치 관련 속성

- static

  - 다른 요소와 겹치지 않게 배치
  - 위치를 지정하지 않으면 static 적용 (디폴트)

- relative

  - static의 원래 위치를 기준으로 계산
  - <img src="https://lh4.googleusercontent.com/jBJn_SinuUvPaPOgbxSvypHVyLyTUlbHVSizgRBVwkq3WhLzcwOBlf0xrb3h4ar2ftnDkVdrAE2ZNHiog0qcCcsuUvIAGlFv1cu7VxF2fq6S99KmbcOVYjaQ8QyClE3gsiYrNzM" alt="img" style="zoom:50%;" /><img src="https://lh5.googleusercontent.com/svVe1DPz2NDidWHUPWxS08IiyMb-1ldLH7m0Gr0yyCFaB299RhsKdm4Kf5AJsqINruoUe9gG43vUBwoVN31SSVjOOWj_DYS1MmIxLikBnZZMRftOutpNZ0ZmYSLjsufVHmvoEQg" alt="img" style="zoom:50%;" />

- absolute

  - 가장 가까운 상위 요소(부모)를 기준으로 배치
  - 상위 요소가 static인 경우에는 브라우저 화면 기준
  - <img src="https://lh3.googleusercontent.com/qV0b5_FafvxdheseigSeRl0Q900yYWgj-y7U_T6W9nW111V9ZmxqiY0SsblMp-0mBzUCdOc6cCjz-x35yIQS3Xa-GqLZt0CBQHJDgrPQQ65EsnEXL9Rb5hd0fZtj-gX1TzF6-Lo" alt="img" style="zoom:50%;" /><img src="https://lh4.googleusercontent.com/5Tf-OqwiVx9EVCC23PKrJ1xquVE1YlbqebfnrcNh81zxL3gC635o7MM5sCDr8WuJcZ7xNT0EB5p2r6AknHz-wc5S-24d-IDTNmV3M87YVTQieQDnR9W98kuN9TwmzuKKrJriu7I" alt="img" style="zoom:50%;" />
  - <img src="https://lh4.googleusercontent.com/bGWf8I5N82L-58BLv3WF9_Nz2SnYvFU7dpiZ-FUUKmJs3EKw1lqS4yBosVToHOge1wuh9fvVNR4tffglPDnbjdRBH8-5hj6Gklm4jDQnFIQjlxG-HUhk72v0gmGZ_AB7aTAb7MQ" alt="img" style="zoom:50%;" /><img src="https://lh5.googleusercontent.com/SWYjyW1eKrQm--uN7xOWpU8Da8_MqbvMRh66QAP6f7REkrZK-M4zJlcny2VILrTONzgdNDAB2SXi2rzUiX-xZUMUBE_JSwgoovLkLiPZfhwde-_YjNODsEPPTZBqd_X5jqKaelY" alt="img" style="zoom:50%;" /><img src="https://lh5.googleusercontent.com/rzDkrSoBXAiEMstwDS9vpiQa5cOYq3vf8H9cOjZcMl1jmMF67uG3Vu_70G1Rc4IehcQ1iw3wSRtAkFA-Q4nrqw5sKA47psz_HEUaxn_5qnjyPR1i0VT7HtoESUmk1N9u3vPVD4U" alt="img" style="zoom:50%;" />

- fixed

  - 브라우저 화면을 기준으로 고정 위치에 배치

  - 지정된 위치에 고정 배치
  - 스크롤 시 고정되어 있음
  - <img src="https://lh4.googleusercontent.com/rH8TcQj_8FisQPwPuVLRcCa94TtdS6K9rPWpxh9ahjCv10MWKZ05rvn60LK2NBeJMKdnnlFDwmtKd8syn_Omk9r8xr9L90ruk3Lwum1-ZVCfIHXAYvmOqNCV37R-5KjOMJehoAg" alt="img" align="left" style="zoom:50%;" />

### 레이어(겹침) 표현 속성

- z-index 속성
- 요소들이 겹칠 때 순서 지정
- 나중에 배치하는 것이 위에 놓임
- z-index 값이 클수록 위에 놓음
- <img src="https://lh6.googleusercontent.com/uVN2jguizXzCG9IYrgflFtTT12M3jtGIyO3YdBElyXNkUd09zAfH-YLXuMj8tsEhXmYHIg06MFFske0buguHZWH1g1sGJhnBk4hQzD993RxrMS6WbN15bC94FMYRd3ZDuRoKsoU" alt="img" align="left" style="zoom:50%;" />

### Overflow 속성

- 자식 요소가 부모 요소의 범위를 벗어났을 때 어떻게 처리할 것인지 지정
- hidden
  - 부모 영역을 벗어나는 부분은 보이지 않게 처리
- scroll
  - 스크롤바 표시 (가로 / 세로)
- auto
  - 자동으로 필요한 부분에만 스크롤바 표시

### 투명도 / 가시성

#### 투명도 (불투명도)

- opacity 속성
  - 0 ~ 1 사이의 값 지정
  - 0 : 투명 (안 보임)
  - 0.5 : 반투명
  - 1: 불투명 (보임)

#### 가시성 (보임 / 안 보임)

- visibility 속성
  - hidden : 숨김 (안 보임)
  - visible : 보임

### 그림자 속성

- 이미지 등의 요소에 그림자 표시

- ```css
  box-shadow: none | x-position y-position blur spread color | inset | initial | inherit

- none : 그림자 효과를 없음

- x-position : 가로 위치. 양수면 오른쪽, 음수면 왼쪽. (필수)

- y-position : 세로 위치. 양수면 아래쪽, 음수면 위쪽. (필수)

- blur : 그림자를 흐릿하게 만듦. 값이 클 수록 더욱 흐려짐.

- spread : 양수면 그림자를 확장하고, 음수면 축소

- color : 그림자 색상 지정

- inset : 그림자를 요소의 안쪽에 만듦

- initial : 기본값으로 설정

- inherit : 부모 요소의 속성값을 상속받음