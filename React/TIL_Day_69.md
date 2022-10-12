# TIL_Day_69

> 2022년 10월 11일

## React_6

### React Hooks

> 리액트 훅(React Hooks)이란 리액트 16.8 버전부터 추가된 기능으로, 클래스 컴포넌트와 생명주기 메서드를 이용하여 작업을 하던 기존 방식에서 벗어나 함수형 컴포넌트에서도 더 직관적인 함수를 이용하여 작업할 수 있게 만든 기능입니다.
>
> 기존 방식의 경우 상태 관련 로직이 한 곳에 묶이기 때문에 상태 로직의 재사용이 불가능하였으며 테스트 또한 어려웠습니다. 하지만, 훅을 도입함으로써 상태 관련 로직을 추상화할 수 있게 되어 재사용과 테스트가 가능하게 되었습니다. 즉, 훅을 통해 계층의 변화 없이 상태 관련 로직을 재사용할 수 있게 되었습니다.
>
> 이렇듯 뛰어난 재사용성과 직관성을 갖는 함수형 컴포넌트와 훅의 사용률은 높아지고 있습니다.

#### React Hooks 사용 규칙

1. 최상위 레벨에서만 호출 가능하다. (반복문, 조건문, 중첩된 함수 내부에서 호출하면 안된다.)
2. 오직 리액트 함수 컴포넌트 내에서만 호출 가능하다. (일반 자바스크립트 함수에서는 훅을 호출해서는 안된다.)

- 리액트 훅 사용 규칙을 지킴으로써 컴포넌트가 여러 번 렌더링 되어도 훅의 호출 순서를 동일하게 유지할 수 있으며, 훅이 여러 번 호출되어도 훅의 상태를 올바르게 유지할 수 있다.
- 또한, 컴포넌트의 모든 상태 관련 로직의 직관성을 높일 수 있다.

#### 리액트 내장 훅 API

##### useState()

```jsx
const [state, setState] = useState(initialState);
```

- 상태를 설정할 때 사용하는 훅 API로 클래스 컴포넌트의 생명주기 메소드 constructor()에서 상태를 초기화하는 것과 비슷한 역할을 하는 API이다. 
- 이 API는 인자로 초기 상태(initialState)를 받고, 반환 값으로 현재 상태(state)와 상태를 설정하는 함수(setState)를 반환한다.

- 이때, 초기 상태와 현재 상태, 상태를 설정하는 함수는 항상 위와 같은 이름을 가질 필요가 없다. 다만, 상태를 설정하는 함수의 이름은 보통 set상태로 짓는다.
- 초기 상태는 숫자나 문자열, 배열, 객체 등을 이용하여 설정할 수 있는데, 이때 콜백 함수를 이용한다면 초기 렌더링 시에 콜백 함수가 반환하는 값을 초기 상태로 갖게 된다. 이렇게 설정된 상태는 추후에 상태 설정 함수를 이용하여 변경할 수 있으며, 이 훅을 통해 설정된 상태는 컴포넌트가 다시 렌더링 되어도 유지된다는 장점이 있다.
- 또한, 하나의 컴포넌트에 여러개의 상태가 선언될 수 있다.
- 하지만 하나의 상태를 여러 컴포넌트에서 사용하게 되는 경우, 매번 props를 전달해야 하여 불필요한 코드 중복이 발생할 수 있으며 오류가 생길 수 있다는 단점이 있다. 이 경우에는 Redux 또는 Recoil과 같은 전역 상태 라이브러리를 이용하여 관리하는 것이 권장된다.

##### useEffect()

```jsx
useEffect(callback, dependency);
```

- 클래스 컴포넌트의 생명주기 메소드 componentDidMount(), componentDidUpdate, componentWillUnmount()를 통합한 것과 같은 API로 side effect를 발생하는 작업을 수행하는 훅 API이다. 
- Side effect란 다른 컴포넌트에 영향을 줄 수 있고 렌더링 과정에서는 구현할 수 없는 작업을 일컫는데, 그 예로는 컴포넌트 안에서 데이터 가져오거나 구독하기, DOM을 직접 조작하기 등이 있다.

```jsx
useEffect(() => { 
    // side effect를 발생하는 작업 
    const timerId = setTimeout( () => console.log('useEffect') ); 
    // side effect를 발생하는 작업을 정리 
    return () => clearTimeout(timerId); 
});
```

- 앞서 언급한 클래스 컴포넌트의 생명주기 메서드 componentDidMount()와 componentDidUpdate()는 컴포넌트가 렌더링 될 때마다 side effect가 발생하는 작업을 수행하고, componentDidUmount()는 컴포넌트가 언마운트될 때 이 작업에 대한 정리 작업을 수행한다.
- 이러한 세 메소드를 합친 것과 같은 useEffect()는 첫 번째 인자로 전달받은 콜백 함수 내부에서 side effect가 발생하는 작업을 수행하고, 이에 대한 정리 작업을 수행하는 cleanup 함수를 반환한다.
- 또한, 위와 같이 두번째 인자로 아무것도 넣지 않은 경우에는 매 렌더링 시마다 콜백 함수를 실행하고, 다음 렌더링이 실행되기 전에는 cleanup 함수를 실행한다.

```jsx
useEffect(() => { 
	console.log('useEffect'); 
}, []);
```

- 두 번째 인자에 빈 배열을 넣는 경우, 마운트 될 때에 콜백 함수 내부를 실행하고 언마운트 될 때에 cleanup 함수를 실행한다.
- 이를 사용할 때에는 마운트 될 때의 state값과 props값이 언마운트될 때까지 유지된다는 점을 주의해야 한다.

```jsx
useEffect(() => { 
	console.log('useEffect'); 
}, [state]);
```

- 특정 값이 업데이트 되었을 때만 실행하고 싶은 경우에는 두 번째 인자에 특정 값을 담은 배열을 넣어주면 된다.
- 또한, 배열에는 여러 개의 값을 넣을 수 있고 일반적으로는 콜백 함수 내에 사용된 지역 변수를 배열에 담는 편이지만 편의에 따라 해당 값을 안 넣을 수도 있고, 콜백 함수 내부에서 사용하지 않는 값을 넣을 수 있다.
- 이때, 리액트 측에서 setState 함수는 동일성을 보장하고 변경되지 않는다고 하므로 넣어줄 필요가 없다.

##### useContext()

```jsx
const themes = { dark: { background: 'black' }, light: { background: 'white' } } 

// context 객체 
const ThemeContext = React.createContex(themes.dark);
// value prop에 의해 context의 현재 값이 결정됨 
const App = () => { 
	return ( <ThemeContext.Provider value={themes.light}> <Button /> </ThemeContext.Provider> ) 
} 
const Button = () => { 
    // 현재 값 
    const contextValue = useContext(context); 
    return ( <button style={{background: contextValue.background}}> Button </button> ) 
}
```

- 인자로 context 객체를 받아 객체의 현재 값을 반환한다.
- context 객체는 useContext가 호출된 컴포넌트에서 가장 가까이에 위치한 <Context.Provider>의 props로 전달된 value에 따라 값이 변경된다.
- 또한, 값이 변경될 때마다 이 훅을 호출한 컴포넌트는 리렌더링 된다.

##### useReducer()

```jsx
const [state, dispatch] = useReducer(reducer, initialState, init);
```

- 앞서 살펴본 useState()의 대체 함수로 다양한 컴포넌트 상황에 따라 상태 값을 설정하는 훅 API이다.

```jsx
// 초기화 함수 
const init = (initialValue) => { 
    return { count: initialValue }; 
} 

// 리듀서 함수 
const reducer(state, action) => { 
    switch(action.type) { 
    	case 'INCREMENT': 
        	return { ...state, count: state.count + 1 }; 
        case 'DECREMENT': 
        	return { ...state, count: state.count - 1 }; 
        case 'RESET': 
        	return init(action.payload); 
    } 
}

const Counter = ({ initialValue }) => { 
    const [state, dispatch] = useReducer(reducer, initialCount, init); 
    return (<> 
    	Count: {state.count} 
        <button onClick={() => dispatch({type: 'reset', payload: initialCount})}> Reset </button> 
        <button onClick={() => dispatch({type: 'decrement'})}>-</button> 
        <button onClick={() => dispatch({type: 'increment'})}>+</button> 
    </>); 
}
```

- useReducer()는 첫 번째 인자로 현재 상태(state)와 행동(action)을 인자로 받는 reducer 함수를, 두 번째 인자로 상태의 초기값을, 세 번째 인자로는 상태 초기화 함수를 넣고 현재 상태(state)와 액션을 발생시키는 함수(dispatch)를 반환한다.
- Counter 컴포넌트 내 버튼을 클릭하면 dispatch 함수에 의해 각 버튼마다 다른 액션 객체가 설정된다.
- 또, dispatch는 reducer를 호출하여 reducer가 주어진 액션 객체 값에 따라 상태 변경을 하도록 한다.
- 이 때, reducer 함수에서 상태 변경이 이루어질 때는 반드시 불변성을 지켜야 한다.
- 이러한 useReducer()는 useState()에 비해 유동적으로 상태를 관리할 수 있고, 상태 관련 로직을 컴포넌트 밖으로 꺼낼 수 있다는 장점이 있다.

##### useCallback()

```jsx
const memoizedCallback = useCallback(callback, dependency);
```

- 렌더링 최적화에 사용하는 훅 API로 렌더링 과정에서 두 번째 인자로 주어진 의존 배열(dependency)의 값이 바뀌면 첫 번째 인자로 주어진 콜백함수(callback)를 새로 생성하여 반환한다.
- 참고로, 의존 배열에 따른 작동 방식은 useEffect()와 같이 배열을 넣지 않은 경우에는 매 렌더링마다, 빈 배열을 넣는 경우에는 마운트 때에만, 특정 값을 넣는 경우에는 특정 값이 변하여 렌더링될 때에만 해당 훅 API가 실행된다.

```jsx
const onClick = useCallback(e => { 
    e.preventDefault(); 
    setNumber(number + 1); 
), [number]};
```

- useCallback()으로 정의한 클릭 이벤트 핸들러 함수(onClick) 예시이다. 이 함수는 number의 값이 변할 때마다 number의 값에 1을 더해주는 함수를 기억하고있다가 클릭 이벤트가 발생할 경우 해당 함수를 실행시킨다.

##### useMemo()

```jsx
const memoizedValue = useMemo(callback, dependency);
```

- 연산 최적화에 사용하는 API로 렌더링 과정에서 두 번째 인자로 받은 의존 배열(dependency)내 값이 바뀌는 경우에만 첫 번째 인자로 받은 콜백함수를 실행하여 구한 값을 반환하는 함수이다.

```jsx
// 배열의 모든 요소 합을 구하는 함수 
const getSum = (arr) => { 
    return arr.reduce((a, b) => a + b); 
} 

const arr = [1, 2, 3, 4]; 
const sum = useMemo(() => getSum(arr), [arr]);
```

- 의존 배열에 따라 콜백함수를 실행하여 반환값을 기억한다는 점에서 useCallback()과 비슷한 점이 있지만, useMemo()는 숫자 또는 문자열, 배열, 객체 등의 값을 반환하고 useCallback()은 함수를 반환한다는 점에서 차이가 있다.

##### useRef()

```jsx
const ref = useRef(initialValue);
```

- 함수형 컴포넌트에서 ref를 쉽게 사용할 수 있도록 하는 훅 API이다.

```jsx
const Component = () => { 
    const ref = useRef(null); 
    return ( <div ref={ref}>ref</div>; ) 
}
```

- useRef()는 인자로 받은 값으로 초기화된 변경 가능한 ref 객체를 반환한다.
- 이 객체는 컴포넌트의 전 생애주기동안 유지되며, ref.current와 같이 current 속성에 접근하여 현재 가리키는 객체에 접근할 수 있다.
- 또한, 이는 가변 값을 유지하기 편리하다는 장점이 있다.