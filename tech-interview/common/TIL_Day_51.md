# TIL_Day_51

> 2022년 09월 27일

## RESTful API

> REST란 Representational State Transfer의 약어로 웹을 이용할 때 제약 조건들을 정의하는 소프트웨어 아키텍처 스타일이다. HTTP URL을 통해 자원(Resource)을 명시하고 HTTP Method(GET, POST, PUT, DELETE)를 통해서 해당 자원(URL)에 대한 CRUD(Create, Read, Update, Delete)를 적용하는 것을 의미한다. 한마디로 HTTP의 장점을 살리고자 하는 통신 규약이라 할 수 있다. 로이 필딩의 2000년 박사학위 논문에서 소개되었으며 RESTful API는 이러한 규약을 바탕으로 리소스 중심으로 설계하고 기능에 맞게 HTTP Method 사용하여 설계된 API이다.

- GET : 지정된 URL에서 리소스의 표현을 조회
- POST : 지정된 URL에 신규 리소스를 생성
- PUT : 지정된 URL에 리소스를 생성하거나 업데이트
- PATCH : 리소스의 부분 업데이트
- DELETLE : 지정된 URL의 리소스를 제거

### REST 특징

> REST 아키텍처에 적용되는 6가지 제한 조건

- 인퍼페이스 일관성 : 일관적인 인터페이스로 분리 되어야 한다.
- 무상태성 : 각 요청 간 클라이언트의 context, 세션과 같은 상태 정보를 서버에 저장하지 않는다.
- 캐시 처리 가능 : 클라이언트는 응답을 캐싱할 수 있어야 한다. 캐시를 통해 대량의 요청을 효율적으로 처리할 수 있다.
- 계층화 : 클라이언트는 대상 서버에 직접 연결되어 있는지, proxy를 통해서 연결되었는지 알 수 없다.
- Code on demand : 자바 애플릿이나 자바스크립트의 제공을 통해 서버가 클라이언트를 실행시킬 수 있는 로직을 전송하여 기능을 확장시킬 수 있다.
- 클라이언트/서버 구조 : 아키텍처를 단순화시키고 작은 단위로 분리함으로써 클라이언트-서버의 각 파트가 독립적으로 구분하고 서로 간의 의존성을 줄인다.

### REST 구성 요소

1. 자원(Resource) - URL
   - 모든 자원에 고유한 ID가 존재하고, 이 자원은 Server에 존재한다.
   - 자원을 구발하는 ID는 `/orders/order_id/1`와 같은 HTTP URI 이다.
2. 행위(Verb) - Http Method
   - HTTP 프로토콜의 Method를 사용한다.
   - HTTP 프로토콜은 `GET`, `POST`, `PUT`, `PATCH`,  `DELETE`와 같은 메서드를 제공한다.
3. 표현(Representations)
   - Client가 자원의 상태(정보)에 대한 조작을 요청하면 Server는 이에 적절한 응답(Representation)을 보낸다.
   - REST에서 하나의 자원은 JSON, XML, TEXT, RSS 등 여러 형태의 Representation으로 나타낼 수 있다.
   - 현재는 JSON으로 주고 받는 것이 대부분이다.

### REST API 설게 Rules 및 예시

1. 소문자를 사용한다.

   ```
   http://abc.com/user/Post-Comments	// X
   http://abc.com/user/post-comments	// O
   ```

   - 대문자는 때로 문제를 일으키는 경우가 있기 때문에 소문자로 작성

2. 언더바(_) 대신 하이픈(-)을 사용한다.

   ```
   http://abc.com/user/post_comments	// X
   http://abc.com/user/post-comments	// O
   ```

   - 정확한 의미나 단어 결합이 불가피한 경우 하이픈(-)을 사용하며, 하이픈(-) 사용도 최소한으로 설계
   - 언더바(_)는 사용하지 않음

3. 마지막에 슬래시(/)를 포함하지 않는다.

   ```
   http://abc.com/user/	// X
   http://abc.com/user		// O
   ```

   - 슬래시(/)는 계층 관계를 나타낼 때 사용

4. 행위를 포함하지 않는다.

   ```
   http://abc.com/user/post/1	// X (POST)
   http://abc.com/user/1		// O (DELETE)
   ```

   - 자원에 대한 행위는 HTTP Method로 표현(GET, POST, DELETE, PUT)

5. 파일 확장자는 URL에 포함시키지 않는다.

   ```
   http://abc.com/users/photo.jpg	// X
   http://abc.com/users/photo		// O (GET)
   	HTTP/1.1 Host: abc.com Accept: image/jpg
   ```

   - URL에 메시지 body 내용의 포맷을 나타내기 위한 파일 확장자를 적지 않음. 대신 Accept header를 사용

6. 자원에는 형용사, 동사가 아닌 명사를 사용하며, 컨트롤 자원을 의미하는 경우 예외적으로 동사를 사용한다.

   ```
   http://abc.com/users/duplicating	// X
   http://abc.com/users/duplicate		// O
   ```

   - URL은 자원을 표현하는데 중점을 두기 때문에 동사, 형용사보다는 명사를 사용해야 함

### REST의 단점들

1. REST는 point-to-point 통신모델을 기본으로 한다. 따라서 Servier와 Client가 연결을 맺고 상호작용 해야하는 어플리케이션의 개발에는 적당하지 않다.
2. REST는 URI, HTTP 이용한 아키텍처링 방법에 대한 내용만을 담고 있다. 보안과 통신규약정책 같은 것은 전혀 다루지 않는다. 따라서 개발자는 통신과 정책에 대한 설계와 구현을 도맡아서 진행해야 한다.
3. HTTP에 상당히 의존적이다. REST는 설계 원리이기 때문에 HTTP와는 상관없이 다른 프로토콜에서도 구현할 수 있기는 하지만 자연스러운 개발이 힘들다. 다만 REST를 사용하는 이유가 대부분의 서비스가 웹으로 통합되는 상황이기에 큰 단점이 아니게 되었다.
4. CRUD 4가지 메소드만 제공한다. 대부분의 일들을 처리할 수 있지만, 4가지의 메소드 만으로 처리하기엔 모호한 표현이 있다.