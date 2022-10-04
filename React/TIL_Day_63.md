# TIL_Day_63

> 2022년 10월 4일

## React_5

### State

> React 컴포넌트의 변경 가능한 데이터

```jsx
class LikeButton extends React.Component {
	constructor(props) {
        super(props);
        {/* 이 부분이 현재 컴포넌트의 state를 정의하는 부분 */}
        this.state = {
            liked: false
        };
    }
    ...
}
```

- state는 사전에 정의된 것이 아니라 개발자가 정의한다.

- 렌더링이나 데이터 흐름에 사용되는 값만 state에 포함시켜야 한다.

- state는 자바스크립트 객체이다.

- state는 직접 수정할 수 있지만, 하면 안된다.

  - setState 함수를 통해 수정

  ```jsx
  // state를 직접 수정 (잘못된 방법)
  this.state = {
  	name: 'Sara'
  };
  
  // setState 함수를 통한 수정 (정상적인 방법)
  this.setState({
      name: 'Sara'
  });
  ```

### Lifecycle

> 컴포넌트가 페이지에 렌더링 되기 위해 준비하는 과정에서부터 제거될 때까지의 기간을 말하며, 클래스형 컴포넌트는 이러한 생명주기 중 특정 시점에 대하여 원하는 구문을 실행할 수 있도록 생명주기 메소드를 지원한다.

![](https://projects.wojtekmaj.pl/react-lifecycle-methods-diagram/ogimage.png)

- 생명주기와 생명주기 메소드는 위 도표와 같은 타임라인을 가지며, 크게 세 가지 경우로 나누어 볼 수 있다.
- 각 메소드에서 **Did**는 해당 시점이 끝난 후 메소드 내용을 실행하겠다는 것을 뜻하며, **Will**은 해당 시점 직전에 메소드 내용을 실행하겠다는 것을 뜻한다.

#### Mounting 과정

> 컴포넌트 인스턴스가 **생성(Mount)**되고 DOM에 삽입될 때는 아래와 같은 생명주기 메소드가 순서대로 실행

1. constructor(props)

   ```jsx
   constructor(props) { 
       super(props); // this.props를 정의하게 됨 
       this.state = { counter: 0 }; // this.state를 통해 지역 state를 초기화 
       this.handleClick = this.handleClick.bind(this); // 인스턴스에 이벤트 리스너 바인딩 
   }
   ```

   - 컴포넌트 생성자 메소드로 **컴포넌트 마운트 전에 호출**된다. 이 메소드는 초기 state를 정하거나 이벤트 리스너를 바인딩하기 위해 사용되는 메소드로, 이러한 작업이 필요 없다면 굳이 구현하지 않아도 된다.
   - React.Component를 상속한 컴포넌트의 생성자를 구현할 때에는 메소드 내부 최상단에 super(props)를 호출해주어야만 한다. 그렇지 않으면 this.props가 정의되어 있지 않아 오류가 발생한다.
   - 이 메소드는 this.state에 객체를 할당하여 지역 state를 초기화한다. this.setState()를 호출하면 안 된다. 참고로, this.setState()를 사용하지 않고 this.state를 통해 값을 직접 할당할 수 있는 유일한 메소드이다.

2. static getDerivedStateFromProps(nextProps, prevState)

   ```jsx
   static getDerivedStateFromProps(props, state) { 
       // 주어진 props와 state가 다른 경우 동기화를 위해 state로 설정할 객체를 반환한다. 
       if (props.counter !== state.counter) { 
           return { counter: props.counter }; 
       } 
       // 이러한 작업이 필요없는 경우 null을 반환한다. 
       return null; 
   }
   ```

   - 이 메소드는 **컴포넌트 마운트 또는 업데이트에서 render 메소드를 호출하기 전에 호출**되며 시간의 흐름에 따라 변하는 props를 state에 동기화하기 위해 존재하는 메소드이다. 이는 static과 함께 선언되어야 하며 메소드 내부에서는 this를 통한 인스턴스 접근이 불가하다. 또한, props를 이용하여 생성한 객체를 반환함으로써 props를 state에 동기화한다.
   - 하지만, React 측에서는 이 메소드를 권장하지 않는다. React는 props 변화에 대응하여 side effect를 발생시킬 때는 componentDidUpdate()를, props가 변화했을 때만 일부 데이터를 다시 계산하고 싶을 때는 Memoization Helper를, props가 변화할 때에 일부 state를 재설정하고 싶을 때는 완전 제어 컴포넌트 또는 완전 비제어 컴포넌트를 권고한다.

3. render()

   ```jsx
   render() { 
       // jsx를 반환 (배열, null 등 다른 요소 반환 가능)
       return ( <div>render</div>) 
   }
   ```

   - 이 메소드는 **컴포넌트 마운트 또는 업데이트에서 호출**되며, 생명주기 메소드 중 유일하게 반드시 구현되어야 하는 메소드이다. 하지만, shouldComponentUpdate()가 false를 반환하는 경우에 호출되지 않는다.
   - 또한, 이 메소드는 UI 렌더링을 위해 필요한 메소드로 React 엘리먼트를 반환한다. 이때, 이 메소드는 컴포넌트의 상태를 변경하지 않아야하며 호출될 때마다 동일한 결과를 반환해야 하고 브라우저와 직접적인 상호작용을 하지 않아야 한다.

4. componentDidMount()

   ```jsx
   componentDidMount() { 
       this.timerId = setTimeout( () => console.log('Hi') , 1000 ); 
   }
   ```

   - 이 메소드는 **컴포넌트 마운트 직후에 호출**되며, 라이브러리 또는 프레임워크 함수 호출, 이벤트 등록, setTimeout, setInterval, 네트워크 요청 등의 비동기 작업을 처리하기에 적절한 메소드이다.
   - 이 메소드 내부에서 setState()를 호출하는 경우도 있지만, 이 경우 추가적인 렌더링이 발생하여 성능 저하로 이루어질 수 있으므로 주의해야 한다.

#### Updating 과정

> props 또는 state의 변경, 부모 컴포넌트의 리렌더링, this.forceUpdate의 호출 등으로 인해 컴포넌트 **업데이트**가 발생할 때에는 아래와 같은 생명주기 메소드가 순서대로 실행

1. getDerivedStateFromProps()

2. shouldComponentUpdate(props, state)

   ```jsx
   shouldComponentUpdate(props, state) { 
       if (this.state.count === state.count) { 
           return false; // render() 호출 x 
       } 
       return true; // render() 호출 o 
   }
   ```

   - 이 메소드는 **컴포넌트 업데이트에서 render 메소드 호출 직전에 호출**되며 해당 컴포넌트를 리렌더링 할지를 결정하는 메소드이다. 기본 반환 값은 true로 기본적으로 render()가 호출되어 리렌더링이 이루어지지만, this.props와 props, this.state와 state의 비교에 따라 false를 반환하는 경우 render()가 호출되지 않아 리렌더링이 이루어지지 않는다.
   - 이는 성능 최적화를 위해 사용하는 메소드로 렌더링을 방지하는 목적으로 사용하는 경우 버그로 이어질 수 있다. 이때에는 PureComponent를 사용하는 것이 좋다.

3. render()

4. getSnapshotBeforeUpdate(props, state)

   - 이 메소드는 **마지막으로 렌더링 된 결과가 DOM에 반영되기 전에 호출**되는 메소드로, 이를 통해 스크롤 위치 등과 같은 정보를 변경되어 DOM에 반영되기 전에 얻을 수 있다. 이 메소드가 반환하는 값은 componentDidUpdate()의 세 번째 인자로 전달된다.

5. componentDidUpdate(props, state, snapshot)

   - 이 메소드는 **컴포넌트 업데이트 직후에 호출**되는 메소드로, DOM을 조작하거나 이전과 현재의 props를 비교하여 네트워크 요청을 보내는 작업 등이 이루어진다. 메소드 내부에서 setState를 호출할 수 있으나 조건문으로 감싸지 않으면 무한 반복이 발생할 수 있으므로 주의해야 한다. 또한, 이 메소드는 shouldComponentUpdate()가 false를 반환하면 호출되지 않는다.

#### Unmounting 과정

> 컴포넌트가 DOM 상에서 완전히 **제거(Unmount)**될 때는 아래와 같은 생명주기 메소드가 순서대로 실행

1. componentWillUnmount()

   ```jsx
   componentWillUnmount() {
   	clearTimeout(this.timerId); // componentDidMount()에서 설정한 비동기 작업을 정리
   }
   ```

   - 이 메소드는 **컴포넌트가 언마운트되기 직전에 호출**된다. 즉, 컴포넌트가 사라지기 전에 마지막으로 작업할 수 있는 메소드이다. 따라서, 이 메소드는 앞서 componentDidMount()에서 설정한 모든 비동기 작업에 대하여 정리를 해주어야 한다. 또한, 해당 컴포넌트는 리렌더링 되지 않으므로 setState를 호출하면 안된다.

