# TIL_Day_56

> 2022년 09월 28일

## Ajax, axios, fetch

### Ajax

- Asynchronous JavaScript And XML의 약자이며, 자바스크립트를 이용해 클라이언트와 서버 간에 데이터를 주고 받는 비동기 HTTP 통신이다.
- XMLHttpRequest(XHR) 객체를 이용해서 전체 페이지가 아닌 필요한 데이터만 불러올 수 있다.

#### Ajax의 장점

- JQuery를 통해 쉽게 구현 가능하다.
- Error, Success, Complete의 상태를 통해 실행 흐름 조절 가능하다.

#### Ajax의 단점

- JQuery를 사용해야 간편하고 호환성이 보장된다.
- Promise 기반이 아니다.

#### 코드

```javascript
$.ajax({
    url: 'https://localhost:8080',
    type: 'GET',
    success: function onData (data) {
        console.log(data);
    },
    error: function onError (error) {
        console.error(error);
    }
});
```

### axios

- axios는 Node.js와 브라우저를 위한 Promise API를 활용하는 HTTP 통신 라이브러리이다.
- 비동기로 HTTP 통신을 할 수 있으며 return을 promise 객체로 해주기 때문에 response 데이터를 다루기 쉽다.

#### axios 장점

- response timeout (fetch에는 없는 기능) 처리 방법이 존재한다.
- Promise 기반으로 만들어졌기 때문에 데이터 다루기 편리하다.
- 브라우저 호환성이 뛰어나다.

#### axios 단점

- 사용을 위해 모듈 설치가 필요하다. (npm install axios)

#### 코드

```javascript
axios({
  method: 'POST',
  url: 'https://localhost:8080/user',
  data: {
    userName: 'abc',
    userId: 'abc1234'
  }
}).then((response) => console.log(response));
```

### fetch

- ES6부터 들어온 JavaScript 내장 라이브러리이다.
- Promise 기반으로 만들어졌기 때문에 axios와 마찬가지로 데이터 다루기가 쉽다.
- 내장 라이브러리라는 장점으로 상당히 편리하다.

#### fetch의 장점

- JavaScript 내장 라이브러리 이므로 별도로 import 할 필요가 없다.
- Promise 기반으로 만들어졌기 때문에 데이터 다루기 편리하다.
- 내장 라이브러리이기 때문에 업데이트에 따른 에러 방지가 가능하다.

#### fetch의 단점

- 지원하지 않는 브라우저가 존재하다. (IE11...)
- 네이트워크 에러 발생 시 response timeout이 없어 기다려야 한다.
- JSON으로 변환해주는 과정이 필요하다.
- 상대적으로 axios에 비해 기능이 부족하다.

#### 코드

```javascript
fetch("https://localhost:8080/user/post", {
  method: "POST",
  headers: {
    "Content-Type": "application/json",
  },
  body: JSON.stringify({
    id: "abc1234",
    description: "Hello World",
  }),
}).then((response) => console.log(response));
```

#### Summary

- 간단한 통신의 경우엔 fetch를 사용하고, 기능이 좀 더 필요하다면 axios를 사용하는게 좋아 보인다.
- 하지만 React-Native와 같이 업데이트가 잦은 경우에는 fetch가 내장 라이브러리이기 때문에 좀 더 안정적일 수 있다.