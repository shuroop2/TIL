# TIL_Day_60

> 2022년 10월 3일

## React_2

### 리액트의 장점

- 빠른 업데이트 & 렌더링 속도
- 컴포넌트 기반의 구조
- 재사용성(Reusability)
  - 개발 기간이 단축됨
  - 유지 보수가 용이함
- 활발한 지식공유 & 커뮤니티

### 리액트의 단점

- 방대한 학습량
  - Virtual DOM, JSX, Component, State, Props 등등...
  - 끝없는 새로운 업데이트
- 높은 상태관리 복잡도

### JSX

> A syntax extension to JavaScript

```jsx
const element = <h1>Hello, world!</h1>;
```

- JavaScript + XML/HTML
- 브라우저에서 실행하기 전에 바벨을 사용하여 일반 자바스크립트 형태의 코드로 변환된다.
- 리액트에서 JSX를 쓰는 것이 필수는 아니나, JSX를 사용하면 장점들이 많기 때문에 매우 편리하다.
- JSX는 React **엘리먼트(element)**를 생성한다.

```jsx
// 실제 작성할 JSX 예시
function App() {
    return (
    	<h1>Hello, world!</h1>
    );
}

// 위와 같이 작성하면, 바벨이 다음과 같이 자바스크립트로 해석하여 준다.
function App() {
    return React.createElement("h1", null, "Hellow, wolrd!");
}

// JSX를 사용한 코드
const element = (
	<h1 className="greeting">
    	Hello, world!
    </h1>
)

// JSX를 사용하지 않은 코드
const element = React.createElement(
	'h1',
    { className: 'greeting' },
    'Hello, world!'
)

// React.createElement()의 결과로 생성된 객체
const element = {
    type: 'h1',
    props: {
        className: 'greeting',
        children: 'Hello, world!'
    }
}
```

#### JSX의 장점

1. 간결한 코드
2. 가독성 향상
   - 버그를 발견하기 쉬움
3. Injection Attacks 방어

#### JSX 문법

1. 반드시 부모 요소 하나가 감싸는 형태여야 한다.

   - Virtual DOM에서 컴포넌트 변화를 감지할 때 효율적으로 비교할 수 있도록 컴포넌트 내부는 하나의 DOM 트리 구조로 이루어져야 한다는 규칙이 있기 때문이다.

   - ex) 에러 케이스

     ```jsx
     // Fail to compile
     // parsing error : adjacent JSX elements be wrapped in an enclosing tag
     // Did you want a JSX fragment <>...</>?
     function App() {
     	return (
     		<div>Hello</div>
     		<div>world!</div>
     	);
     }
     ```

   - ex) 정상 코드1 (`<div></div>`)

     ```jsx
     // div를 사용 하였기 때문에 스타일 적용시 작성한 코드를 div로 한번 더 감쌌다는 부분을 고려해야 함
     function App() {
     	return (
     		<div>
     			<div>Hello</div>
     			<div>world!</div>
     		</div>
     	);
     }
     ```

   - ex) 정상 코드2 (`<Fragment></Fragment>`)

     ```jsx
     // <Fragment>를 사용가능 하지만 <div>태그보다 무거운 편이다.
     function App() {
     	return (
     		<Fragment>
     			<div>Hello</div>
     			<div>world!</div>
     		</Fragment>
     	);
     }
     ```

   - ex) 정상 코드3 (`<></>`)

     ```jsx
     function App() {
     	return (
     		<>
     			<div>Hello</div>
     			<div>world!</div>
     		</>
     	);
     }

2. 자바스크립트 표현식

   - JSX 안에서도 자바스크립트 표현식을 사용할 수 있다. 자바스크립트 표현식을 작성하려면 JSX내부에서 코드를 {}로 감싸주면 된다.
   - 유효한 모든 자바스크립트 표현식을 넣을 수 있다.

   ```jsx
   function App() {
   	const text = 'world';
   	return (
   		<div>
   			<div>Hello</div>
   			<div>{text}!</div>
   		</div>
   	);
   }

3. if문(for문) 대신 삼항 연산자 (조건부 연산자) 사용

   - if 구문과 for 루프는 자바스크립트 표현식이 아니기 때문에 JSX 내부 자바스크립트 표현식에서는 사용할 수 없다.

   - 그렇기 때문에 조건부에 따라 다른 렌더링 시 JSX 주변 코드에서 if문을 사용하거나, {}안에서 삼항 연산자(조건부 연산자)를 사용한다.

   - ex) 방법1 : 외부에서 사용

     ```jsx
     function App() {
     	let desc = '';
     	const loginChk = 'Y';
     	if(loginChk === 'Y') {
     		desc = <div>회원 입니다.</div>;
     	} else {
     		desc = <div>비회원 입니다.</div>;
     	}
     	return (
     		<>
     			{desc}
     		</>
     	);
     }
     ```

   - ex) 방법2 : 내부에서 사용

     ```jsx
     function App() {
     	const loginChk = 'Y';
     	return (
     		<>
     			<div>
     				{loginChk === 'Y' ? (
     					<div>회원 입니다.</div>
     				) : (
     					<div>비회원 입니다.</div>
     				)}
     			</div>
     		</>
     	);
     }
     ```

   - ex) 방법3 : AND 연산자(&&) 사용

     ```jsx
     // 조건이 만족하지 않을 경우 아무것도 노출되지 않는다.
     function App() {
     	const loginChk = 'Y';
     	return (
     		<>
     			<div>
     				{loginChk === 'Y' && <div>회원 입니다.</div>}
     			</div>
     		</>
     	);
     }
     ```

   - ex) 방법4 : 즉시실행함수 사용

     ```jsx
     function App() {
     	const loginChk = 'Y';
     	return (
     		<>
     			{
     			  (() => {
     				if(loginChk === "Y"){
     				  return (<div>회원 입니다.</div>);
     				}else{
     				  return (<div>비회원 입니다.</div>);
     				}
     			  })()
     			}
     		</>
     	);
     }

4. React DOM은 HTML 어트리뷰트 이름 대신 camelCase 프로퍼티 명명 규칙을 사용

   1. JSX 스타일링

      - JSX에서 자바스크립트 문법을 쓰려면 {}를 써야 하기 때문에, 스타일을 적용할 때에도 객체 형태로 넣어 주어야 하기 때문에 카멜 표기법으로 작성해야 한다. (font-size => fontSize)

      - ex) css style

        ```jsx
        function App() {
        	const style = {
        		backgroundColor: 'red',
        		fontSize: '20px'
        	}
        	return (
        		<div style={style}>Hello, world!</div>
        	);
        }
        ```

   2. class 대신 className

      - 일반 HTML에서 CSS 클래스를 사용할 때에는 class 라는 속성을 사용하지만, JSX에서는 class가 아닌 className을 사용한다.

      - ex) className

        ```jsx
        function App() {
        	const style = {
        		backgroundColor: 'red',
        		fontSize: '20px'
        	}
        	return (
        		<div className="testClass">Hello, world!</div>
        	);
        }

5. JSX 내에서 주석 사용 방법

   - JSX 내에서 {/* ... */} 와 같은 형식을 사용한다.

   - ex)

     ```jsx
     function App() {
     	return (
     		<>
     			{/* 주석사용방법 */}
     			<div>Hello, world!</div>
     		</>
     	);
     }
     ```

   - 시작 태그를 여러 줄 작성시에는, 내부에서 // 의 형식을 사용할 수 있다.

     ```jsx
     function App() {
     	return (
     		<>
     			<div
     			// 주석사용방법
     			>Hello, world!</div>
     		</>
     	);
     }