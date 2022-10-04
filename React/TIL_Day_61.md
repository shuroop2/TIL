# TIL_Day_61

> 2022년 10월 4일

## React_3

### Rendering Elements

#### Element 정의

> Elements are the smallest building blocks of React apps

- React 앱을 구성하는 가장 작은 블록들
- Element는 화면에 표시할 내용을 기술한다.

```jsx
const element = <h1>Hello, world</h1>
```

- 브라우저 DOM Element와 달리 React Element는 일반 객체(plain object)이며 쉽게 생성할 수 있다.
- React DOM은 React Element와 일치하도록 DOM을 업데이트한다.

#### Elements의 생김새

- React Elements는 자바스크립트 객체 형태로 존재

- ex)

  ```jsx
  // 렌더링 전의 Element
  {
  	type: 'button',
      props: {
          className: 'bg-green',
          children: {
              type: 'b',
              props: {
                  children: 'Hello, element!'
              }
          }
      }
  }
  
  // 렌더링 후 DOM Element
  <button class='bg-green'>
  	<b>
      	Hello, element!
      </b>
  </button>
  ```

#### DOM에 Elemenst 렌더링 하기

```jsx
<div id="root"></div>
```

- 이 안에 들어가는 모든 Element를 React DOM에서 관리하기 때문에 이것을 root DOM 노드라고 한다.
- React로 구현된 애플리케이션은 일반적으로 하나의 root DOM 노드가 있다.
- React를 기존 앱에 통합하려는 경우 원하는 만큼 많은 수의 독립된 root DOM 노드가 있을 수 있다.
- React Element를 렌더링하려면 먼저 DOM Element를 `ReactDOM.createRoot()`에 전달한 다음, React Element를 `root.render()`에 전달하면 된다.

```jsx
const root = ReactDOM.createRoot(
  document.getElementById('root')
);
const element = <h1>Hello, element!</h1>;
root.render(element);
```

#### 렌더링 된 Elements 업데이트하기

- React Element는 **불변객체**이다.

- Element를 생성한 이후에는 해당 Element의 자식이나 속성을 변경할 수 없다.

- Element는 영화에서 하나의 프레임과 같이 특정 시점의 UI를 보여준다.

- UI를 업데이트하는 유일한 방법은 새로운 Element를 생성하고 이를 `root.render()`로 전달하는 것이다.

- ex)

  ```jsx
  const root = ReactDOM.createRoot(
    document.getElementById('root')
  );
  
  function tick() {
    const element = (
      <div>
        <h1>Hello, world!</h1>
        <h2>현재 시각 : {new Date().toLocaleTimeString()}</h2>
      </div>
    );
    root.render(element);
  }
  
  setInterval(tick, 1000);
  ```

  - 위 함수는 `setInterval()` 콜백을 이용해 초마다 `root.render()`를 호출한다.

#### 변경된 부분만 업데이트하기

- React DOM은 해당 Element와 그 자식 Element를 이전의 Element와 비교하고 DOM을 원하는 상태로 만드는데 필요한 경우에만 DOM을 업데이트한다.