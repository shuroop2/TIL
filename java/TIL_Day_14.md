# TIL_Day_14

> 2022년 05월 31일

## 멀티 스레드

### 멀티 스레드 개념

#### 프로세스 (process)

> 실행 중인 하나의 프로그램(애플리케이션)

- 하나의 프로그램이 다중 프로세스를 만들기도 함
- ex) 크롬 브라우저를 두 개 실행하면 두 개의 프로세스 생성

#### 멀티 태스킹 (multi tasking)

> 두 가지 이상의 작업을 동시에 처리하는 것

- 운영체제는 CPU 및 메모리 자원을 프로세스마다 적절히 할당해 주고 병렬로 실행시킴

- ex) 워드 문서 작업하면서 윈도우 미디어 플레이어로 음악을 들음

- 멀티 프로세스

  > 독립적으로 프로그램들을 실행하고 여러 가지 작업 처리

- 멀티 스레드

  > 한 개의 프로그램을 실행하고 내부적으로 여러 가지 작업 처리

#### 메인 스레드

- 모든 자바 프로그램은 메인 스레드가 main() 메소드 실행하며 시작
- main() 메소드의 첫 코드부터 아래로 순차적으로 실행
- 실행 조건
  - 마지막 코드 실행
  - return 문 만나면 실행 종료
- main 스레드는 작업 스레드들을 만들어 병렬로 코드를 실행
  - 멀티 스레드 생성해서 멀티 태스킹을 수행

#### 스레드 종료

- 싱글 스레드
  - 메인 스레드가 종료되면 프로세스도 종료
- 멀티 스레드
  - 실행 중인 스레드가 하나라도 있으면 프로세스 미 종료

### 작업 스레드 생성과 실행

- 멀티 스레드로 실행하는 어플리케이션 개발
  - 몇 개의 작업을 병렬로 실행할지 결정하는 것이 선행되어야 함

<img src="https://lh6.googleusercontent.com/BMIkAZxm67TQYz85qJEYKdSPLq4yyU-w5REXtl8vy4cmKxlOlGOnva8GH-d1iPW9VrVtHLzolkd3UTTxfNVxzTdGKyUSaKEoHdqM6sSz8qcVsnMWn8q320AkCTxMzHKG8e4kSM0" alt="img" style="zoom:50%;" />

- 작업 스레드 생성 방법 2가지

  1. Thread 클래스로부터 직접 생성

  2. Thread 하위 클래스로부터 생성


#### Thread 클래스로부터 직접 생성

- Runnable 인터페이스 사용

- Runnable 인터페이스를 매개값으로 갖는 생성자 호출

  ```java
  Thread thread = new Thread(Runnable target);
  ```

  ```java
  class Task Implements Runnable {
  	public void run() {
  		스레드가 실행할 코드
  	}
  }
  ```

##### Runnable 인터페이스

- run() 메소드 하나만 정의되어 있음
- Runnable은 작업 내용을 가지고 있는 개체이지 실제 스레드 아님
- Runnable 구현 생성한 후 이것을 매개값으로 해서 Thread 생성자를 호출하면 비로소 작업 스레드 생성

  ```java
  Runnable task = new Task();
  Thread thread = new Thread(task);
  ```

- 코드 절약하기 위해 Thread 생성자를 호출할 때 Runnable 익명 객체를 매개값으로 사용 가능

  ```java
  Thread thread = new Thread(new Runnable() {
  	public void run() {
      	스레드가 실행할 코드;
      }
  });
  ```

- 작업 스레드는 생성 즉시 실행되는 것이 아니라 start() 메소드를 호출해야만 실행

  - `thread.start()`

- start() 메소드가 호출되면

  - 작업 스레드는 매개값으로 받은 Runnable run() 메소드를 실행하면서 자신의 작업을 처리

<img src="https://lh5.googleusercontent.com/M4xtjjb8rnnZocn6cvr2aSjgf-hT0ER0jCJoK2UIVMB-2TEIbtFcaCotWON9u3Ji-kzxh8X6JVrDZ_Txc83bL9eEOfKdTPlYunWUmPTBUQJQ92iuBT4bjJLITxcIXoGDJRtMbQs" alt="img" style="zoom:50%;"/>

1) 메인 스레드만 있는 예제 (P581)

   - 비프음 5번 출력
   - 띵 5번 출력
   - 두 작업을 순서대로 하나씩 실행

   ```java
   import java.awt.Toolkit;
   
   public class BeepPrintEx {
   	public static void main(String[] args) {
   		// 메인 스레드만 있는 예제 - 2개의 작업을 순서대로 하나씩 처리
   		Toolkit toolkit = Toolkit.getDefaultToolkit();
   		// 비프음 5번 연속 출력
   		for(int i=0; i<5; i++) {
   			toolkit.beep();
   			try {Thread.sleep(500);} catch (Exception e) {} // 0.5초간 일시 정지
   		}
   		// 띵 5번 연속 출력
   		for(int i=0; i<5; i++) {
   			System.out.println("띵");
   			try {Thread.sleep(500);} catch (Exception e) {} // 0.5초간 일시 정지
   		}
   	}
   }

2. 메인 스레드 / 작업 스레드 2개의 스레드가 있는 예제

   - 메인 스레드 : 프린팅 담당

   ```java
   import java.awt.Toolkit;
   
   public class BeepPrintEx2 {
   	public static void main(String[] args) {
   		// 멀티 스레드 예제
   		// 메인 스레드 : 띵 출력
   		// 작업 스레드 : 비프음 출력
   		
   		// 1) Runnable 구현 객체 대입 방법1
   		// Runnable beepTask = new BeepTask(); // Runnable 객체 구현 Thread thread = new
   		// Thread(beepTask); // 작업 스레드 생성
   		
   		// 2) Runnable 구현 객체 대입 방법2
   		// 위 두행을 한 행으로 처리
   		// Thread thread = new Thread(new BeepTask());
   		
   		// 3) Runnable 구현 객체 대입 방법3
   		// 3) 익명 구현 객체 사용 : BeepTask 클래스 안 만들고 클래스에서 구현한 run() 메소드 여기서 직접 작성
   		/*
   		 * Thread thread = new Thread(new Runnable() {
   		 * 
   		 * @Override public void run() { Toolkit toolkit = Toolkit.getDefaultToolkit();
   		 * for(int i=0; i<5; i++) { toolkit.beep(); try {Thread.sleep(500);} catch
   		 * (Exception e) {} } }
   		 * 
   		 * });
   		 */
   		
   		// 4) Runnable 구현 객체 대입 방법4
   		// 4) 람다식 사용
   		Thread thread = new Thread(() -> {
   				Toolkit toolkit = Toolkit.getDefaultToolkit();
   				for(int i=0; i<5; i++) {
   					toolkit.beep();
   					try {Thread.sleep(500);} catch (Exception e) {}
   				}
   		});
   		// BeepTask 객체의 run() 메소드 실행
   		thread.start();
   		// 메인 스레드 작업 처리
   		for (int i = 0; i < 5; i++) {
   			System.out.println("띵");
   			try {
   				Thread.sleep(500);
   			} catch (Exception e) {
   			} // 0.5초간 일시 정지
   		}
   	}
   }
   ```

   - 작업 스레드 : 비프음 출력

   ```java
   import java.awt.Toolkit;
   // 작업 스레드 : 비프음 출력
   public class BeepTask implements Runnable {
   	@Override
   	public void run() {
   		Toolkit toolkit = Toolkit.getDefaultToolkit();
   		for(int i=0; i<5; i++) {
   			toolkit.beep();
   			try {Thread.sleep(500);} catch (Exception e) {}
   		}
   	}
   }

#### Thread 하위 클래스로부터 생성

- Thread 클래스 상속
- Thread 클래스 상속 후 run 메소드 재정의해서 스레드가 실행할 코드 작성

```java
public class WorkerThread extends Thread {
	@Override
	public void run() {
		// 스레드가 실행할 코드
	}
}
```

- 멀티 스레드

  > 여러 개의 스레드 동시 실행

#### 스레드 이름

- 메인 스레드 이름 : main
- 작업 스레드 이름 (자동 설정) : Thread-n
  - 스레드 이름 반환 메소드 : `thread.getName();` 
- 작업 스레드 이름 변경
  - `thread.setName("스레드 이름");`
- 코드 실행하는 현재 스레드 객체 참조 얻기
  - `Thread thread = Thread.curruntThread();`

### 스레드 우선순위

- 동시성

  > 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질

- 병렬성

  > 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질

- 코어

  > CPU 칩에서 물리적으로 연산하는 유닛 개수

  - 입력된 명령어를 계산하고 해석하는 단위

<img src="https://lh4.googleusercontent.com/ML_zhSsk7r2pcUpUfyGTMLg1lw9FCQ-W4z0Nh32k6smKreLhJoDBjjQjQIQYln0mBny03yP-esyz9iEWTY5VGvoIqJ9daaBZ9UcpR82QJU3P9CLENhxSfooCgRGrG88aMs0vU3M" alt="img" style="zoom:50%;"/>

- 스레드 스케줄링

  > 스레드의 개수가 코어의 수보다 많을 경우, 스레드를 어떤 순서로 동시성으로 실행할 것인가 결정

  - 스케줄링에 의해 스레드들은 번갈아가면서 run() 메소드를 조금씩 실행

- 자바의 스레드 스케줄링
  1. 우선 순위 방식 (코드로 제어 가능)
     - 우선 순위가 높은 스레드가 실행 상태를 더 많이 가지도록 스케줄링
     - `thread.setPriority(Thread.MAX_PRIORITY);`
     - `thread.setPriority(Thread.MIN_PRIORITY);`
  2. 순환 할당 방식 (코드로 제어할 수 없음)
     - 시간 할당량(Time Slice)을 정해서 하나의 스레드를 정해진 시간만큼 실행

### 동기화 메소드와 동기화 블록

#### 공유 객체를 사용할 때 주의할 점

- 멀티 스레드가 하나의 객체를 공유해서 생기는 오류

  <img src="https://lh3.googleusercontent.com/BD72jk5SInr7EYn4Rr1dCPBbsSp9j1CYEkYawiQuLI1lzHKJrV0z0NWYAQ3xMa7oTXU_HRxM8Gt4b6c54PC4d4LUzkaRbly-HuHz-4FVlNPB3XnuK0BMthNIr4z8zyd5U23cUZI" alt="img" style="zoom:50%;" />

#### 동기화 메소드 및 동기화 블록

> 단 하나의 스레드만 실행할 수 있는 메소드 또는 블록

- 다른 스레드는 메소드 또는 블록이 실행이 끝날 때까지 대기
- 동기화 메소드는 synchronized 키워드 붙임
  - 잠금(lock) 의미

```java
public synchronized void method() {
	임계 영역; // 단 하나의 스레드만 실행
}
```

- synchronized 키워드

  - 인스턴스 메소드와 정적 메소드 다 붙일 수 있음

- 임계 영역 (critical section)

  > 멀티 프로그램에서 단 하나의 스레드만 실행할 수 있는 코드 영역

  - 자바에서는 임계 영역을 지정하기 위해 동기화 메소드와 동기화 블록 제공
  - 스레드가 객체 내부의 동기화 메소드 또는 블록에 들어가면
    - 즉시 객체에 잠금을 걸어 다른 스레드가 임계 영역 코드를 실행하지 못하게 함

- 동기화 블록

  ```java
  public void method() {
  	// 여러 스레드가 실행 가능 영역
  	...
  	synchronized(공유객체) {
  		임계 영역 // 단 하나의 스레드만 실행
  	}
  	// 여러 스레드가 실행 가능 영역
  	...
  }
  ```

<img src="https://lh3.googleusercontent.com/CbhFMuSEBqTnvVN9H6h-7CgIZHZQDD9BT-bA8O0jJghxh35aO5BqFgEH_1KWF_c1WZBPN_0Onr3QVe9HEPZYgVB4bFekzRXSu_7fIVQfezsukjc11a2QayGFTs5rAiJ7q0ATqKw" alt="img" style="zoom:50%;"/>

### 스레드 상태

#### 스레드의 일반적인 상태

<img src="https://lh6.googleusercontent.com/iSURemcQXobxJBFzGVRnzd1h5jSgJnLNJBDeW4_PisKxZNVTmTLlLmhThmCu2IgEYx8pzIN665oQrmPHanSKeI8hxg5oO2HuFEX2VLqCSFozBimToSyh2OA3kPW1dv4dYYWIuaE" alt="img" style="zoom:50%;"/>

#### 스레드에서 일시 정지 상태 도입한 경우

- 실행 상태에서 실행 대기 상태로 가지 않고 일시 정지 상태로 가기도 함

<img src="https://lh3.googleusercontent.com/6yT-yUax7qZv7PVutqdd1Y7cQIXfvbGMh7QAg_gKtMbqDyCfSM7GeNQXT7aG0ZaSDPLhNIHPTRAV3rgQV823o-SL-2xOdBX5OEaWxzeYQ87ogfglysiXIJe7ymVJcv6EKbtjnT4" alt="img" style="zoom:50%;"/>

- 스레드 클래스에서는 스레드의 상태를 나타내는 열거 상수

  | 상태      | 열거 상수     | 설명                                                         |
  | --------- | ------------- | ------------------------------------------------------------ |
  | 객체 생성 | NEW           | 스레드 객체가 생성, 아직 start() 메소드가 호출되지 않은 상태 |
  | 실행 대기 | RUNNABLE      | 실행 상태로 언제든지 갈 수 있는 상태                         |
  | 일시 정지 | BLOCKED       | 사용하고자 하는 객체의 락이 풀릴 때까지 기다리는 상태        |
  |           | WAITING       | 다른 스레드가 통지할 때까지 기다리는 상태                    |
  |           | TIMED_WAITING | 주어진 시간 동안 기다리는 상태                               |
  | 종료      | TERMINATED    | 실행을 마친 상태                                             |

  - RUNNABLE 상태

    - CPU 스케줄러가 스레드를 선택하면 실행

  - 실행 상태에서 정지 상태로 갈 수 있는 3가지 상태

    ​	<img src="https://lh6.googleusercontent.com/hnIgWJWuoVILjnl8M17sf1Q8iuOVAEucxVBJ53UtEMtCNC68j4nOBz0-_rGEDqtUB-bxbDcgZUCs8JN8D3lRnGu4ttxAcTChGjblixmD-NRwylkljfcuYRzirMsnj-D8-Cu_u14" alt="img" style="zoom:50%;" />

    1. BLOCKED
       - 동기화 메소드와 동기화 블록에서
         - 한 스레드가 동기화 메소드를 호출하고 있다면 다른 스레드는 이 동기화 메소드 호출 불가 (이때 다른 스레드는 BLOCKED 상태)
         - 동기화 메소드를 다 실행하고 난 후 다른 스레드가 BLOCKED 상태가 해제되면서 실행 대기 상태로 되고, 다시 실행 상태가 되어 동기화 메소드를 호출할 수 있게 됨

    2. WAITING
       - 실행 중에 Object가 가지고 있는 wait() 메소드를 호출하게 되면 스레드는 일시 정지 상태로 가고 WAITING된 스레드는 다른 스레드가 notify() 메소드를 호출해야만 실행 대기 상태로 가게 됨
       - WAITING된 스레드는 자기 스스로 또는 자동으로 실행 대기 상태로 갈 수 없고 다른 스레드가 통지를 해줘야만 실행 대기로 갈 수 있음 (다른 스레드가 알려줘야만 실행 대기 상태로 갈 수 있는 상태)

    3. TIMED_WAITING
       - sleep(시간) : 주어진 시간 동안 일시 정지 상태
       - 주어진 시간이 지나면 자동적으로 실행 대기 상태로 감

  - TERMINATED 상태 (종료)
    - 스레드는 한 번 생성되고 종료되면 더 이상 재사용 불가
    - 스레드를 재실행 하려면 항상 새로 생성해서 start() 메소드를 호출하여 실행 대기 상태(RUNNABLE)로 만들어 줘야 함

### 스레드 상태 제어

> 실행 중인 스레드의 상태를 변경하는 것

- 메소드를 사용하여 상태 변화시킴

- 상태 변화를 가져오는 메소드의 종류

  <img src="https://lh6.googleusercontent.com/melAYDrecyTzWx6Kdj75YHVFUEUdEDhL8tTqE6UtPZV1_DT_dGTZgUN-ZjwZ8Ny0tHS3CVEGPkNmk-IS6xTlmb7m531N2xdeah4Tfu5le7o3-x2k_4z9VnYyLKbKD1BPXyhilo0" alt="img" style="zoom:50%;"/>

- 실행 상테에서 호출 가능한 메소드
  - `yield()`
    - 실행 중에 우선순위가 동일한 다른 스레드에게 실행을 양보하고 실행 대기 상태가 됨
  - `join()`
    - 실행 중인 스레드가 일시 정지했다가 join()을 호출한 스레드가 종료되면 실행 대기 상태로 변경
    - 실행 중 잠깐 멈추고 기다렸다가 결과 받아서 다시 시작