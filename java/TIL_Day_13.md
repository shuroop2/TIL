# TIL_Day_13

> 2022년 05월 30일

## 컬렉션 프레임워크

### 컬렉션 프레임워크 소개

#### 컬렉션

> 사전적 의미로 요소(객체)를 수집해 저장하는 것

#### 프레임 워크

> 표준화, 정형화된 체계적인 프로그래밍 방식

- 미리 정해진 방식대로 프로그램을 작성
- 누가 작성하든지 프로그램이 표준화되기 때문에 프로그램을 유지보수 쉬워짐

#### 여러 개의 값을 저장해서 사용하는 구조

- 배열
  - 애플리케이션 개발 시 다수의 객체를 저장해두고 필요할 때 꺼내서 사용하는 경우에 가장 간단하게 사용하는 방법
- 배열의 문제점
  - 생성 시 크기 고정되고 사용 시 크기 변경 불가
    - 불특정 다수의 객체를 저장하기에는 문제
  - 객체 삭제했을 때 해당 인덱스가 비게 됨
    - 객체를 저장하려면 어디가 비어있는지 확인해야 하는 코드 필요

#### 컬렉션 프레임워크 (Collection Framework)

> 컬렉션(다수의 객체)을 다루기 위한 표준화된 프로그래밍 방식

- 많은 양의 데이터를 저장, 삭제, 검색, 비교, 정렬 등의 작업을 편리하고 쉽게 수행
- 객체들을 효율적으로 추가, 삭제, 검색 등을 할 수 있도록 제공되는 컬렉션 라이브러리
- 인터페이스를 통해서 정형화된 방법으로 다양한 컬렉션 클래스 이용
- java.util. 패키지에 포함

#### 컬렉션 클래스

> 다수의 데이터를 저장할 수 있는 클래스

- ex) Arraylist, Vector, HashSet, HashMap, ....

#### 컬렉션 프레임워크의 주요 인터페이스

<img src="https://lh5.googleusercontent.com/tyOQysen1jqL2fBHP2At87GiLBK-Sok94eHLl5QoeuKTJo35fANwSYRU9Jydb88O-ojmFE64GHkF9XsD6WbOUk8cVTY8BdlD34WamExQy103ixR8oSGJ_60TTP0EPQnhC0ztxGI" alt="img" style="zoom:50%;" />

#### List, Set, Map 인터페이스

| 인터페이스 분류 | 특징                                         | 구현 클래스                             |
| --------------- | -------------------------------------------- | --------------------------------------- |
| List 계열       | 순서를 유지하고 저장<br>중복 저장 가능       | ArrayList, Vecor, LinkedList            |
| Set 계열        | 순서를 유지하지 않고 저장<br>중복 저장 안됨  | HashSet, TreeSet                        |
| Map 계열        | 키와 값의 쌍으로 저장<br>키는 중복 저장 안됨 | HashMap, Hashtable, TreeMap, Properties |

### List 컬렉션

#### List(인터페이스) 컬렉션의 특징

- 특징
  - 순서가 있는 데이터의 집합
  - 인덱스로 관리
  - 중복해서 객체 저장 가능
- 구현 클래스
  - ArrayList
  - Vector
  - LinkedList

#### List 컬렉션의 주요 메소드

| 기능      | 메소드                           | 설명                                             |
| --------- | -------------------------------- | ------------------------------------------------ |
| 객체 추가 | `boolean add(E e)`               | 주어진 객체를 맨 끝에 추가                       |
|           | `void add(int index, E element)` | 주어진 인덱스에 객체를 추가                      |
|           | `E Set(int index, E element)`    | 주어진 인덱스에 저장된 객체를 주어진 객체로 바꿈 |
| 객체 검색 | `boolean contains(Object o)`     | 주어진 객체가 저장되어 있는지 여부               |
|           | `E get(int index)`               | 주어진 인덱스에 저장된 객체를 리턴               |
|           | `boolean isEmpty()`              | 컬렉션이 비어 있는지 조사                        |
|           | `int size()`                     | 저장되어 있는 전체 객체 수를 리턴                |
| 객체 삭제 | `void clear()`                   | 저장된 모든 객체를 삭제                          |
|           | `E remove(int index)`            | 주어진 인덱스에 저장된 객체를 삭제               |
|           | `boolean remove(Object o)`       | 주어진 객체를 삭제                               |

#### ArrayList

> List 인터페이스의 구현 클래스로 크기가 가변적으로 변하는 선형 리스트

- 배열과 유사

  - 순차 리스트, 인덱스 사용

- 배열과 차이

  - 배열 : 크기 고정
  - ArrayList
    - 객체 추가 가능
    - 저장 용량 초과 시 자동으로 저장 용량 증가
    - 기본 10개
    - `new ArrayList(30);`처럼 처음부터 크게 설정 가능

- 제네릭을 사용하지 않을 경우

  - 강제 타입 변환 필요

  ```java
  List list = new ArrayList();
  list.add("hello");
  String str = (String) list.get(0);
  ```

- 제네릭을 사용할 경우

  - ArrayList 객체 생성 시 타입 파라미터로 저장할 객체의 타입 지정함으로써 강제 타입 변환 불필요

  ```java
  ArrayList<String> | ArrayList<Integer>
  ```

- ArrayList에 객체 추가

  - 인덱스 0부터 차례로 저장

- ArrayList에 객체 제거

  - 제거된 객체의 바로 뒤 인덱스부터 마지막 인덱스까지 앞으로 1씩 당겨짐
  - 따라서 빈번한 객체 삭제와 삽입이 일어나는 경우 ArrayList 사용하는 것이 바람직하지 않음

  <img src="https://lh6.googleusercontent.com/IH_azTobOKmscGKsfEJiSGcVXNITH4G5BgOB6WcwNb_nZm_vWMBfZ6SSMNI18ql5ANSSPuqjxD2lBAajYdN9JD7FMcmjEuaoUJ9rgKMqHqsXt0TQWHEVjgqBgKbjxsQKAG67XDA" alt="img" style="zoom:50%;" />

- 고정된 객체들로 구성된 List 생성
  - `Arrays.asList()` 사용

#### Iterator

- java.util 패키지의 `Iterator<E>` 인터페이스

- 요소가 순서대로 저장된 컬렉션에서 요소를 순차적으로 검색할 때 사용

- ```java
  Vector<Integer> v = new Vector<Integer>();
  Iterator<Integer> it = v.iterator();
  ```

  - 벡터 v의 요소를 순차적으로 검색할 Iterator 객체 반환
  - hasNext() / next() 메소드 사용해서 객체를 리턴받음

#### LinkedList

- List 구현 클래스로 ArrayList와 사용 방법은 동일
- 내부 구조가 다름
- 인접 참조를 링크해서 체인처럼 관리 (이전/다음 객체의 주소를 갖고 있음)
- 특정 인덱스에서 객체를 제거하거나 추가하게 되면 바로 앞뒤 링크만 변경
- 빈번한 객체 삭제와 삽입 일어나는 곳에서는 ArrayList보다 좋은 성능

#### Vector

```java
List<E> list = new Vector<E>();
```

- ArrayList와 동일한 내부 구조
- 스레드 동기화(synchronization)되어 있기 때문에 복수의 스레드가 동시에 Vector에 접근해 객체를 추가, 삭제하더라도 스레드에 안전(thread safe)

### Set 컬렉션

#### Set 컬렉션 특징

- 수학의 집합에 비유
- 저장 순서가 유지되지 않음
  - 인덱스로 객체를 검색해서 가져오는 메소드 (get() 메소드)없음 
- 객체를 중복 저장 불가
- 구현 클래스
  - HashSet, LinkedHashSet, TreeSet

- Set 컬렉션의 주요 메소드

| 기능      | 메소드                       | 설명                                                         |
| --------- | ---------------------------- | :----------------------------------------------------------- |
| 객체 추가 | `boolean add(E e)`           | 주어진 객체를 저장, 객체가 성공적으로 저장되면 true를 리턴하고 중복 객체면 false를 리턴 |
| 겍체 검색 | `boolean contains(Object o)` | 주어진 객체가 저장되어 있는지 여부                           |
|           | `boolean isEmpty()`          | 컬렉션이 비어 있는지 조사                                    |
|           | `Iterator<E> iterator()`     | 저장된 객체를 한 번씩 가져오는 반복자 리턴                   |
|           | `int size()`                 | 저장되어 있는 전체 객체 수 리턴                              |
| 겍체 삭제 | `void clear()`               | 저장된 모든 객체를 삭제                                      |
|           | `boolean remove(Object o)`   | 주어진 객체를 삭제                                           |

#### HashSet

```java
Set<E> set = new HashSet<E>();
```

- Set 인터페이스의 구현 클레스

- 객체를 순서없이 저장

- 동일 객체 및 동등 객체는 중복 저장하지 않음

- 동등 객체 판단 방법

  - 객체 저장하기 전에 hasCode()를 호출해서 해키소드를 얻어내어 저장되어 있는 객체들의 해시코드와 비교해서 동일한 해시코드가 있다면 equals() 메소드로 두 객체를 비교해서 true가 나오면 동일한 객체로 판단하고 중복 저장하지 않음

  <img src="https://lh5.googleusercontent.com/2itVq_AoxXvAc3K4ZuseM80bBO4CezsXJI81j0aiKODKhZCMMoD0raxzJdvV6PCTAb10Xn2o1_XA9p4C6F4Os9V9iJlQyS_wwRTB7vG8fuMeAcwkCh-VGKA3dy3JZU6yTkMRx-4" alt="img" style="zoom:50%;"/>

- 사용자 정의 클래스 중복 안 안되게 저장

  - 사용자 정의 클래스에서 객체가 중복 저장되지 않게 하려면 hashCode()와 equals() 둘 다 재정의 해서 동등 객체가 될 조건을 정해야 함

### Map 컬렉션

#### Map 컬렉션의 특징

- 키(key)와 값(value)의 쌍으로 이루어진 데이터의 집합
- 키와 값은 모두 객체
- 키는 중복될 수 없지만 중복 저장 가능
- 구현 클래스
  - HashMap, HashTable, LinkedHashMap, TreeMap, Properties
- Map 컬렉션의 주요 메소드

| 기능      | 메소드                                | 설명                                                         |
| --------- | ------------------------------------- | ------------------------------------------------------------ |
| 객체 추가 | `V put(K key, V value)`               | 주어진 키로 값을 저장. <br>새로운 키일 경우 null을 리턴하고 동일한 키가 있을 경우 값을 대체하고 이전 값을 리턴 |
| 객체 검색 | `boolean containsKey(Object key)`     | 주어진 키가 있는지 여부                                      |
|           | `boolean containsValue(Object value)` | 주어진 값이 있는지 여부                                      |
|           | `Set<Map.Entry<K,V>> entrySet()`      | 키와 값의 쌍으로 구성된 모든 Map.Entry 객체를 Set에 담아서 리턴 |
|           | `V get(Object key)`                   | 주어진 키가 있는 값을 리턴                                   |
|           | `boolean isEmpty()`                   | 컬렉션이 비어 있는지 여부                                    |
|           | `Set<K> keySet()`                     | 모든 키를 Set 객체에 담아서 리턴                             |
|           | `int size()`                          | 저장된 키의 총 수를 리턴                                     |
|           | `Collection<V> values()`              | 저장된 모든 값을 Collection에 담아서 리턴                    |
| 객체 삭제 | `void clear()`                        | 모든 Map.Entry(키와 값)를 삭제                               |
|           | `V remove(Object Key)`                | 주어진 키와 일치하는 Map.Entry를 삭제하고 값을 리턴          |

- 키 객체는 hashCode()와 equals() 메소드를 재정의해 동등객체가 될 조건을 정함

  <img src="https://lh6.googleusercontent.com/MMkrjIcTJTwXDJ-4DodljmZ4K34H3uX91YyUckWFHGv9gLAOjheR6FY2Xdgw_8a4JsEwEhuhSUc30a2TxcnM4uwqN1mTPiNrAfjX1WWID1xVzwaRFVPChgdglqdrlpsY6GavvSw" alt="img" style="zoom:50%;" />

- 키 타입은 String 많이 사용

  - String 문자열이 같을 경우 동등 객체가 될 수 있도록 hashCode()와 equals() 메소드가 재정의되어 있기 때문

#### Hashtable

- 키, 개체 만드는 법은 HashMap과 동일
- Hashtable은 스레드 동기화(synchronization)가 된 상태
  - 복수의 스레드가 동시에 Hashtable에 접근해서 객체를 추가, 삭제하더라도 스레드에 안전
- Hashtable : 멀티 스레드 환경에서 주로 사용
- Hashmap : 단일 스레드 환경에서 주로 사용
  - synchronization하면 객체 잠금이 발생하므로 성능 저하

### Collections 클래스 활용

- 컬렉션을 다루는 유용한 메소드 지원 (static)
  - sort() : 정렬
  - reverse() : 역순으로 정렬
  - max() / min()