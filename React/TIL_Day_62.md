# TIL_Day_62

> 2022년 10월 4일

## React_4

### Component

- 컴포넌트를 통해 UI를 재사용 가능한 개별적인 여러 조각으로 나누고, 각 조각을 개별적으로 살펴볼 수 있다.
- 개념적으로 컴포넌트는 자바스크립트 함수와 유사하다. "props"라고 하는 임의의 입력을 받은 후, 화면에 어떻게 표시되는지를 기술하는 React Element를 반환한다.

#### 함수 컴포넌트와 클래스 컴포넌트

- 컴포넌트를 정의하는 가장 간단한 방법은 자바스크립트 함수를 작성하는 것이다.

```jsx
function Welcome(props) {
	return <h1>Hello, {props.name}</h1>;
}
```

- 이 함수는 데이터를 가진 하나의 "props" 객체 인자를 받은 후 React Element를 반환하므로 유효한 React 컴포넌트이다.

- 이러한 컴포넌트는 자바스크립트 함수이기 때문에 말 그대로 **함수 컴포넌트**라고 호칭한다.

- 또한 `ES6 class`를 사용하여 컴포넌트를 정의할 수 있다.

  ```jsx
  class Welcome extends React.Component {
      render() {
          return <h1>Hello, {this.props.name}</h1>;
      }
  }
  ```

#### 컴포넌트 렌더링

- 이전까지는 DOM 태그만을 사용해 React Element를 나타냈지만, 사용자 정의 컴포넌트로도 나타낼 수 있다.

  ```jsx
  // DOM 태그 사용
  const element = <div />;
  
  // 사용자 정의 컴포넌트
  const element = <Welcome name="Sara" />;
  ```

- React가 사용자 정의 컴포넌트로 작성한 Element를 발견하면 JSX Attribute와 자식을 해당 컴포넌트에 단일 객체로 전달하고, 이 객체를 "props"라고 한다.

- ex) 페이지에 "Hello, Sara"를 렌더링

  ```jsx
  function Welcome(props) {
      return <h1>Hello, {props.name}</h1>;
  }
  
  const root = ReactDOM.createRoot(document.getElementById('rood'));
  const element = <Welcome name="Sara" />;
  root.render(element);
  ```

  1. `<Welcome name="Sara" />` 엘리먼트로 `root.render()`를 호출
  2. React는 `{name: 'Sara'}`를 props로 하여 `Welcome` 컴포넌트를 호출
  3. `Welcome` 컴포넌트는 결과적으로 `<h1>Hello, Sara</h1>` 엘리먼트를 반환
  4. React DOM은 `<h1>Hello, Sara</h1>` 엘리먼트와 일치하도록 DOM을 효율적으로 업데이트

  - 주의사항 : 컴포넌트의 이름은 항상 대문자로 시작해야 한다.

#### 컴포넌트 합성

- 컴포넌트는 자신의 출력에 다른 컴포넌트를 참조할 수 있다.

- 이는 모든 세부 단계에서 동일한 추상 컴포넌트를 사용할 수 있음을 의미한다.

- React 앱에서는 버튼, 폼, 다이얼로그, 화면 등의 모든 것들이 흔히 컴포넌트로 표현된다.

- ex) `Welcome`을 여러 번 렌더링하는 `App` 컴포넌트

  ```jsx
  function Welcome(props) {
      return <h1>Hello, {props.name}</h1>;
  }
  
  function App() {
      return (
      	<div>
          	<Welcome name="Sara" />
              <Welcome name="Cahel" />
              <Welcome name="Edite" />
          </div>
      );
  }
  ```

- 일반적으로 새 React 앱은 최상위에 단일 `App` 컴포넌트를 가지고 있다. 하지만 기존 앱에 React를 통합하는 경우에는 `Button`과 같은 작은 컴포넌트부터 시작해서 뷰 계층의 상단으로 올라가면서 점진적으로 작업해야 할 수 있다.

#### 컴포넌트 추출

```jsx
function Comment(props) {
  return (
    <div className="Comment">
      <div className="UserInfo">
        <img className="Avatar"
          src={props.author.avatarUrl}
          alt={props.author.name}
        />
        <div className="UserInfo-name">
          {props.author.name}
        </div>
      </div>
      <div className="Comment-text">
        {props.text}
      </div>
      <div className="Comment-date">
        {formatDate(props.date)}
      </div>
    </div>
  );
}
```

- 이 컴포넌트는 author(객체), text(문자열), 및 date(날짜)를 props로 받은 후 소셜 미디어 웹 사이트의 코멘트를 나타낸다.
- 이 컴포넌트는 구성요소들이 모두 중첩 구조로 이루어져 있어서 변경하기 어려울 수 있으며, 각 구성요소를 개별적으로 재사용하기도 힘들다.

- Avatar 컴포넌트 추출

  ```jsx
  function Avatar(props) {
    return (
      <img className="Avatar"
        src={props.user.avatarUrl}
        alt={props.user.name}
      />
    );
  }
  ```

  - Avatar는 자신이 Comment 내에서 렌더링 된다는 것을 알 필요가 없기 때문에 props의 이름을 author에서 더욱 일반화된 user로 변경하였다.
  - props의 이름은 사용될 context가 아닌 컴포넌트 자체의 관점에서 짓는 것이 좋다.

- UserInfo 컴포넌트 추출

  ```jsx
  function UserInfo(props) {
    return (
      <div className="UserInfo">
        <Avatar user={props.user} />
        <div className="UserInfo-name">
          {props.user.name}
        </div>
      </div>
    );
  }
  ```

- 추출 후 Comment 컴포넌트

  ```jsx
  function Comment(props) {
    return (
      <div className="Comment">
        <UserInfo user={props.author} />
        <div className="Comment-text">
          {props.text}
        </div>
        <div className="Comment-date">
          {formatDate(props.date)}
        </div>
      </div>
    );
  }
  ```

- 재사용 가능한 컴포넌트를 만들어 놓는 것은 더 큰 앱에서 작업할 때 중요하다.

- UI 일부가 여러 번 사용되거나 (Button, Panel, Avatar), UI 일부가 자체적으로 복잡한 (App, FeedStory, Comment) 경우에는 별도의 컴포넌트로 만드는 것이 좋다.

### Props

> 컴포넌트에 전달할 다양한 정보를 담고 있는 자바스크립트 객체

- React 컴포넌트의 속성들의 모임
- props는 읽기 전용이다.
- 함수 컴포넌트나 클래스 컴포넌트 모두 컴포넌트의 자체 props를 수정해서는 안된다.
- **모든 React 컴포넌트는 자신의 props를 다룰 때 반드시 순수 함수처럼 동작해야 한다.**
  - 순수 함수란 입력값을 바꾸려 하지 않고 항상 동일한 입력값에 대해 동일한 결과를 반환하는 함수