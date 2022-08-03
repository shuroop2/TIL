# TIL_Day_41
>2022년 08월 03일
## 데이터 모델링
### 데이터베이스 설계
- 사용자의 요구를 분석하여 컴퓨터에 저장할 수 있는 데이터베이스의 구조 맞게 변경한 후 특정 DBMS로 구현하여 일반 사용자들이 사용할 수 있게 하는 것

#### 데이터베이스 설계 순서
![](https://lh5.googleusercontent.com/K1_4hX-iO2cRrnWzQn75lcXbSs9JcDgN9nlA_NCa_vbbZPWC2CQUn6pN4-yGgyxd6dBOWrSmUIi2x17nNgt5Uxe97NnWBcZ2uJg0Z1RnuofrUkqb9XCinXlbsj6C_mkOstHgHEK5Nf66)

### 데이터 모델링
- 현실 세계에 존재하는 개체의 구성 요소가 가지는 값(데이터)을 컴퓨터 세계에 표현하기 위한 현실 세계와 컴퓨터 세계 사이의 변환 과정
- 현실 세계의 복잡한 개념을 단순화 / 추상화 시켜서 데이터베이스화 하는 기법
- 프로젝트 분석과 설계 단계에서 가장 중요한 작업 중 하나
![](https://lh3.googleusercontent.com/f3pg1Gjv4zycSGiN5Th6gOfUdc-593E1Nf1ZK5lEYAXfcq2TBRnmfp2wTUWXObwP39ZjShmUFExACgCcnp7GGlwCtNn1xzFRAS18dGPU0AxCiVWQu9OOgQiKk0RxxR0ZfMDAH7diIgHh)

#### 데이터 모델링 과정에서 수행되는 작업
1. 데이터베이스 내에 존재하는 데이터 타입 정의
	- 예 : 학생, 교수, 학과, 상품, 회원 등 (테이블로 생성)
2. 데이터들 사이의 관계 규정
	- 예 : 학과와 학생 관계 - 소속(하다/되다)
3. 데이터의 의미와 데이터에 가해진 제약조건 명시
	- 예 : 키 제약조건, 참조 무결성 제약 조건

#### 데이터 모델링 과정
![](https://lh3.googleusercontent.com/769lHdkokqAKFyc7HqwdQrCwVS6maWn19Ao1nD_xjiCmXh46kN-ymFtaDzQw5mquTT1vCZIxH6cxd-gF0lZttml8danM8CeAaz4LQN3Y9BLjdS2ZanJdOiJDrxouCTSTXIr6v0gQ5g5b)

##### 개념적 모델링
- 현실 세계를 추상적인 개념인 개체 타입과 관계 타입으로 표현
- 요구사항 분석 결과를 토대로 업무의 핵심적인 개념을 구분하고 개채(entity) 추출, 관계 정의
- ER 다이어그램 (ERD : Entity Realationship Diagram)이라는 표준화된 그림으로 표현
![](https://lh3.googleusercontent.com/M2azVPEDvUvC6vQALyZ3FBMWwbYrtt4lE1PxbNo7Q15m4s0-vSrnbdtnHpe6M-3898vEM05o2BC8nz1Gbf6p6UzRqPe1r4SEFhArtwO7RF0_r2PrgPCOnw6QIA7PMU_twoVVQcoF_nzD)

##### 논리적 모델링
- 실제 데이터베이스로 구현하기 위한 모델을 만드는 과정
- 개념적 모델링에서 산출된 ER 다이어그램을 사용하고자하는 DBMS에 맞게 사상(맵핑 : mapping)하는 과정
![](https://lh5.googleusercontent.com/wWpxBhjDQUPljJuErz0L9QZlkyqQ3Qm65iIBpFBYNQ2dSTH9EX418dUPY_4K73zNR23KpwMLOMCNsDKbZ4aV6OLKNLoffCCdE33Mu_HD_FURonsMsUHeMV6Gj8jdtZnsS06-oygR4deG)

###### 논리적 모델링 과정 중 수행 작업
- 개념적 모델링에서 추출하지 않았던 상세 속성 모두 추출
- 정규화 수행
- 데이터 표준화 수행

##### 물리적 모델링
- 작성된 논리적 모델을 실체 컴퓨터의 저장 장치에 저장하기 위한 물리적 구조를 정의하는 과정
- 데이터베이스가 최적의 성능을 낼 수 있도록 DBMS의 특성에 맞게 저장 구조 정의
![](https://lh3.googleusercontent.com/EtU8f_YkYaHlZkHlbXn1WaGJ2bgxZ-OCAV5l13aejSdXpt9NU3MOlLblm2kfY1UG-fNZqag5r35PiUtfomnpXvxBmqErTIXQyxASi4hyPhEpE16HHHEj7yMLSH6IRvxvrVQ7UfV0oaYF)

### 개념적 모델링 (개체-관계 모델 : E-R 모델)
1. 개체 관계 모델 개념
	- 개체와 개체 간의 관계를 이용해 현실 세계를 개념적으로 표현하는 모델
	- 데이터베이스 설계 과정 중 개념적 설계 과정에 사용되는 모델
	- 개체와 개체 간의 관계를 E-R 다이어그램이라는 표준화된 그림으로 표현
	- ![](https://lh5.googleusercontent.com/k235EhwQStvY426NJ7gaQJz5uEpNGcQFWOsf_qKU9Fwx9ZOFL3EY0N3yjUYjOaoqAbA6AwlAk7qdOWTGiOWULed8u3p4fzckFHPB6Sko5_PHcTV8VY0_IRJZ4to38_S38jF45zCXMjsx)
2. E-R 다이어그램
	-   개념적 모델링(개체-관계 모델링)의 결과물로
	-   기호를 사용하여 현실 세계를 표현한 것
	-   ERD 표기법
	-   피터 첸 표기법
		- 관계에 중점을 둔 표기법
		- 쉬운 표기법으로 쉽게 이해
		- 속성이 많아지거나 관계가 복잡해지면 표현하기 어려움
		- ![](https://lh5.googleusercontent.com/Y2Mg9mFGPNcP9OZMMVCcpnTotXAhrf1l0iysJVqeDpL1RyEcxJbebZ4a_uHV6w7OpWyojziTnX7QnXTEn8v0l0h8rWudinOBa8fuRFWSQYXcAJMYfjHIF9rlfSRHw03JjCS8qV5QyKJQ)
		- 피터 첸 기법의 ERD에서 사용되는 기호
			- ![](https://lh6.googleusercontent.com/5Lx0FjO9Bci7WvQnCz_2rzrzHF65EpkDngBevJmYCFq6m4bOxZSoPob5N-VcUdjxAPBWrMKRZWWAv8CJBXRrLLY8dIEd18dbGmHQvuA_kkIQMFLw7cxHVKDtXEqrMYmx7IP4giHitOSW)
	-   IE 표기법 (Information Engineering Notation)
		- 정보공학에서 사용하는 데이터 모델 표기법
		- 많이 사용되는 표기법 중의 하나이지만 집합의 상세 표현에 있어서 공간을 많이 차지하는 단점
		- ERWin이라는 데이터 모델링 툴에서 사용
		- ![](https://lh4.googleusercontent.com/JiJNSGcjrsrfoz5Boi3He3j45MDPZXkb7uSmmFf3HoFw24bq3Xo24nLPmN_aEZs2g_NZ_LQi6CXc1xsiBAXwIuqjrWRh_Tjj2BAx3zhxGzs2oYaIS5He9XchXklkuxCYkDjq9WfPW3jG)
	-   Barker 표기법
		- 영국 컨설팅 회사 CACI에 의해 처음 개발
		- 리차드 바커(Richard Barker)에 의해 지속적으로 업그레이드
		- 오라클에서 Case Method(Custom Development Method)로 채택하여 사용
		- ![](https://lh6.googleusercontent.com/QDUxe9URsi-qI2bFucx2HLQcCTwhmJhdlGJY8apZRDxN3Pu-CGeUokmT7Va396if8yD23knObwGSXII4M7Fva3c35tFA6p6R2BmMBEey8Akj2YTS1XhO1BqkKM47vZ1Wc-RgMTcd1Xx3)
3. 개체
	- 개체(entity) : 사람, 사물, 장소, 개념, 사건과 같이 유무형 정보를 갖고 있는 독립적인 실체
	- 개체의 유형
		- 개념적 개체
			- 학과, 과목, 예금 등과 같이 눈에 보이지 않는 개체
		- 물리적 개체
			- 사람, 도서, 상품 등과 같이 눈에 보이는 개체
	- 개체의 특징
		- 유일한 식별자에 의해 식별 가능
		- 꾸준한 관리를 필요로하는 정보
		- 업무 프로세스에 이용
		- 반드시 자신의 특징을 나타내는 속성 포험
			- 도서명, 저자, 발행일, 출판사 등
		- 다른 개체와 관계 설정 가능
	- 개체 인스턴스(Entity Instance) : 특정 하나의 개체
	- 개체 집합(Entity Set) : 동일한 속성을 공유하는 같은 유형의 개체 집합
	- 개체 타입(Entity Type) : 개체를 정의한 것
	- 개체 타입의 E-R 다이어그램 표현
		- ![](https://lh5.googleusercontent.com/NPgxqIG47P2vmeP-s7QvJZwWtFyTGSWQ5kpBYFL42qytxULIEVb28BvWSsrLmatY95pH0dW6DVIuNKzwf4tY841gCW7P4Pe_NQfweZB5lmFZ7C5HuO0i-6Tg4-nF8OODHcOI99O9lOEP)
4. 속성 (attribute)
	- 개체의 성질, 분류, 수량, 상태, 특성, 특징 등의 세부 사항
	- 저장할 필요가 있는 개체에 관한 정보
	- 실제 저장되는 데이터 (값)
	- ![](https://lh3.googleusercontent.com/INRLWVL9FBpoZAcQQ3AsJ1OOQ-NUpJKQMTqfXvcSIJSdW7CVPzCUTP8SGTb7FgHTBtdkxtcIBW6JDumeDlKNE5RG8t7kzxhhvhJCqAmKxUMi3gPGb1IH7cPwKQNqPNguxUQ_kE_CDFHo)
	- 도메인
		- 속성이 가질 수 있는 모든 가능한 값들의 집합
		- 예
			- 성별 : '남', '여'
			- 학년 : 1 ~ 4 또는 1 ~ 5
	- 속성의 ER 다이어그램 표현
		- 타원으로 표현
		- 개체 타입을 나타내는 직사각형과 실선으로 연결
		- 속성의 이름은 타원의 중앙에 표기
		- 속성이 개체를 유일하게 식별할 수 있는 키일 경우 속성 이름에 밑줄
		- ![[Pasted image 20220803180412.png]]
	- 속성의 유형
		- 속성 분해 여부에 따라 분류
			- 단순 속성
				- 더 이상 다른 속성으로 나눌 수 없는 속성
			- 복합 속성
				- 2개 이상의 속성들로 분해할 수 있는 속성
				- 독립적인 의미
			- ![[Pasted image 20220803180542.png]]
		- 속성 값의 개수에 따라 분류
			- 단일 값 속성
				- 반드시 하나의 값만 존재
				- 예 : 학번, 주민등록번호
			- 다중 값 속성
				- 여러 개의 값 존재 가능
				- 예 : 전화번호 - 집, 휴대폰
			- ![[Pasted image 20220803180618.png]]
5. 관계 (Realationship)
	- 2개 이상의 개체 사이에 존재하는 연관성
	- 관계 타입
		- 개체 타입과 개체 타입 간의 연결 가능한 관계를 정의한 것
	- 관계 집합
		- 관계로 연결된 집합
	- ![[Pasted image 20220803180722.png]]
	- 관계 타입의 ER 다이어그램 표현
		- 마름모 모양으로 표시
		- ![[Pasted image 20220803180740.png]]
	- 관계의 유형 (관계에 참여하고 있는 개체 타입 관계)
		- 단항 관계
		- 이항 관계
		- 3항 관계
		- n항 관계
		- ![[Pasted image 20220803180811.png]]
		- 예시1 : 교수와 과목 간의 관계 (강좌)를 E-R 다이어그램으로 표현
			- 개체 타입 : 교수, 과목
			- 관계 타입 : 강좌
			- ![[Pasted image 20220803180916.png]]
		- 예시2 : 고객이 상품을 주문하는 관계를 E-R 다이어그램으로 표현
			- 개체 타입 : 고객, 상품
			- 관계 타입 : 주문
			- ![[Pasted image 20220803180959.png]]
	- 맵핑 카디널리티 (Mapping Cardinality)
		- 관계와 개체 타입이 연결될 때 대응(mapping)되는 수
		- 이항 관계 맵핑 카디널리티
			- 일대일 (1:1)
				- 관계를 맺고 있는 개체 집합 X의 각 원소가 개체 집합 Y의 원소 한 개와 대응되는 관계
				- ![[Pasted image 20220803203349.png]]
			- 일대다 (1:N)
				- ![[Pasted image 20220803203358.png]]
			- 다대일 (N:1)
				- ![[Pasted image 20220803203405.png]]
			- 다대다 (N:M)
				- ![[Pasted image 20220803203412.png]]
6. IE 표기법
	- 정보공학에서 사용하는 데이터 모델 표기법
	- 많이 사용되는 표기법 중의 하나이지만 집합의 상세 표현에 있어서 공간을 많이 차지하는 단점
	- ERWin이라는 데이터 모델링 툴에서 사용
	- ![[Pasted image 20220803221039.png]]
	- IE 표기법 기호와 의미
		- ![[Pasted image 20220803221052.png]]
		- ![[Pasted image 20220803221101.png]]
		- ![[Pasted image 20220803221108.png]]
	- 개채 선택성 표기
		- 해당 개체 1건에 대한 상대 개체 선택성 표기
		- ![[Pasted image 20220803221129.png]]
		- ![[Pasted image 20220803221135.png]]

### 논리적 모델링
- E-R 모델을 관계 데이터 모델로 사상
- 개념적 모델링에서 만든 ER 모델을 실제 데이터베이스를 구축하기 위해 사용하고자 하는 DBMS에 맞게 사상
- ![[Pasted image 20220803221327.png]]
- ![[Pasted image 20220803221332.png]]
	- 교수 - 강좌 - 과목 관계의 E-R 모델을 관계 데이터 모델로 사상한 결과 (개념적 모델링 결과를 논리적 모델링으로 전환한 결과)
	- ![[Pasted image 20220803221536.png]]
		- 고객 - 주문 - 상품 관계의 E-R 모델을 관계 데이터 모델로 사상한 결과

### 물리적 모델링
- 작성된 논리적 모델(E-R 모델을 관계 데이터 모델로 사상)을 실제 컴퓨터의 저장 장치에 저장하기 위한 물리적 구조를 정의하는 과정
- DBMS의 특성에 맞게 저장 구조 정의
- ![[Pasted image 20220803221716.png]]

### 개념적 - 논리적 - 물리적 모델링
![[Pasted image 20220803221740.png]]