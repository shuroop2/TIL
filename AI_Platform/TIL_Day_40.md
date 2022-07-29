# TIL_Day_40
>2022년 07월 26일
## AI Platform
### 얼굴 인식
- celebrity : 유명인 얼굴 인식 API
	- 전송 : 이미지 (얼굴 사진)
	- 결과
		- JSON 형태로 반환
		- JSON 데이터 파싱해서 추출 / 출력
		- JSON 파싱 결과를 VO에 저장
	- face : 얼굴 감지 API

#### celebrity : 유명인 얼굴 인식 API
- model 패키지 / CelebrityVO 생성
	- value : 유명인 이름
	- confidence : 정확도
- service 패키지 생성
	- CelebrityFaceRecogService 클래스 생성
	- celebrityFaceRecog() 메소드 생성
		1.  이미지 파일 보내고 결과 받아서 콘솔에 출력
			- 자바  API 코드 복사해서 붙여 넣기
			- Client ID / Client Secret  입력
			- 이미지 파일 경로 입력
		2. JSON 결과 파싱
			- jsonToVOList() 메소드 추가
			- celebrityFaceRecog() 메소드에 jsonToVOList() 메소드 호출하고 결과 받는 코드 추가
			- 컨트롤러에게 반환하기 위해 jsonToVOList() 메소드의 반환형 변경 및 return 문 추가
			- 컨트롤러에서 service  호출하고 결과 받는 코드 변경 및 Model 추가
			- celebrityResult.jsp에 출력 부분 추가
		3. 파일 업로드 / 이미지 출력 (서비스 제공)
			- 파일 선택하고 결과 바로 출력
				- celebrityResult.jsp에 파일 업로드 부분 추가
			- 이미지 출력
				- model로 파일명 저장 : fileName
				- 뷰에서 파일명으로 이미지 출력

#### JSON 파싱 메소드
-  `ArrayList<CelebrityVO> jsonToVOList(String jsonResultStr);`
-  API 호출 결과 JSON 형식의 문자열 전달 받아서
- value와 confidence를 추출해서 VO에 저장 / List에 추가
- VO 리스트 반환

### 얼굴 감지
- 감지된 얼굴을 분석한 정보
- 성별, 추정 나이, 감정, 얼굴 방향 등

1. 이미지 전송하고 결과를 콘솔에 출력
	- 클래스 생성 : FaceRecogService
	- 메소드 생성 : faceRecog()
	- 컨트롤러에 추가 : /faceRecog
	- 결과 페이지 : faceRecogResult.jsp
	- index에 추가
	- 콘솔에 결과 출력되는지 확인
2. JSON 결과 파싱
	- FaceVO 생성
		- genderValue / genderConf
		- ageValue / ageConf
		- emotionValue / emotionConf
		- poseValue / poseCof
	- jsonToVOList() 메소드 생성
		- JSON 형태의 문자열 파싱해서 VO에 저장
		- 리스트에 추가
	- faceRcogResult.jsp 생성해서 결과 출력
		- 테이블 형태로 출력
		- 성별 / 성별 정확도
		- 나이 / 나이 정확도
		- 감정 / 감정 정확도
		- 포즈 / 포즈 정확도
3. 파일 업로드 / 이미지 출력
	- faceRecogResult.jsp에 추가
	- /faceRecogForm

### 포즈 인식 (Pose Estimation)
1. 기본 (API 호출 결과 확인)
	- PoseEstimationService  서비스 생성
	- poseEstimate() 메소드 추가
	- API 자바 코드 복사
	- 컨트롤러에 추가
	- index.jsp에 추가
	- 결과 확인
		- 콘솔에 JSON 문자열 출력하고 Json Viewer에서 전체 구조 확인
2. JSON 결과 파싱
	- PoseVO 생성
		- int index
		- double x
		- double y
	- jsonToVOList() 메소드 추가
		- JSON 형태의 문자열 파싱해서 VO에 저장
		- 리스트에 추가 : poseList
3. 파일 업로드 / 이미지 출력 / 좌표 표시 / 신체 부위 좌표 출력
	-  @RestController 추가
	- poseResult.jsp 추가
		- 파일 업로드
		- `<canvas>` 태그
			- 포즈 인식 결과를 이미지 상에서 각부위에 좌표로 표시
		-  `<div id="resultBox">` 각 신체 부위와 좌표 값 출력
	- pose.js 추가 (Ajax 사용)
		- 컨트롤러로 요청 전달하고 결과 받아서 `<canvas>`와 resultBox에 출력

### 객체 탐지 (Object Detection)
1. 기본 (API 호출 결과 확인)
	- ObjectDetectionService 서비스 생성
	- objectDetect() 메소드 추가
	- API 코드 복사
		- 결과를 콘솔에 출력
	- 컨트롤러에 추가
	- index.jsp에 추가
	- JSON 형식 결과 출력 확인 Json Viewer에서 확인
2. JSON 결과 파싱
	- ObjectVO 생성
		- String name
		- double x1, y1, x2, y2
	- jsonToVOList() 메소드 추가
		- JSON 형태의 문자열 파싱해서 VO에 저장
		- 리스트에 추가 : objectList
3. 파일 업로드 / 이미지 출력 / 박스 표시 / 객체명 좌표 출력
	-  @RestController 추가
	- objectResult.jsp 추가
		- 파일 업로드
		- `<canvas>` 태그
			- 각 객체별로 사각형 박스 표시
		-  `<div id=”resultBox”>` 각 객체명과 좌표 값 출력
	- object.js 추가 (Ajax 사용)

### 자동 번역
- Naver Papago 사용하여 한글로 번역
- 입력한 텍스트를 인공신경망 기반 번역 알고리즘을 통해 여러 나라의 언어로 자동 번역
- Papago Text Translation 서비스 추가

#### 객체 탐지 서비스에 추가
- 객체 탐지 결과가 영어로 반환
- 객체 탐지 결과를 한글로 변환해서 한글로 출력되도록 작성
	- 개
	- 고양이
	- 냉장고
- 방법1
	- ObjectDetectionService 클래스에 메소드로 추가
	- translateToKo() 메소드
		- 한글로 변환한 결과를 JSON 형태의 문자열로 반환
	- jsonToString() 메소드 필요
- 방법2
	- TranslateService 서비스 클래스 생성
	- translate() 메소드 추가
		- API 코드 복사 / 결과 받아옴
	- jsonToString() 메소드
	- ObjectDetectionService 클래스에서 translate() 메소드 호출하기 위한 객체 필요 (다른 클래스의 메소드 사용하기 위한 객체 필요)
		- DI (의존성 주입)
			- @Autowired
			- TranslateService transService;

### CLOVA OCR
- Optical Character Recognition : 광학 문자 인식
- 이미지(사진) 속 글자 위치를 찾고 어떤 글자인지 자동으로 알아내는 기술
- 글자 영역 검출 및 인식 기술
- 방법1
	- 지정된 형식 없이 이미지에서 텍스트 추출
- 방법2
	- 템플릿을 만들고 원하는 영역을 지정한 뒤, 필요한 글자만 빠르게 추출하는 기능
		- 예 : 영수증
-  API 사용 방법
	- 이미지 파일 전송하고 텍스트 반환 받아서 JSON 파싱해서 사용
- 일반적인 활용 사례
	- 문서 파일 / 인쇄물 판독
	- 우편번호 추출을 통한 우편물 관리
	- 문자 자동 번역
	- 명함 관리
	- 차량번호 자동 인식

#### CLOVA OCR 예제
1.  API 호출 결과 출력
	- OCRService 서비스 클래스 생성 
	- ocrGeneral() : 메소드 추가
	- API 코드 복사
		1. ocrGeneral() 메소드에 복사
			- apiURL : GateWay URL
			- Secret Key
		2. writeMultiPart() 메소드도 복사해서 아래 붙여넣기
		- 결과를 콘솔에 출력
	- 컨트롤러에 추가 : ocrService
		- /OCRGeneral
	- index.jsp에 추가
	- JSON 형식 결과 출력 확인 Json Viewer에서 확인
2. JSON 결과 파싱
	- jsonToString() 메소드 추가
		- JSON 형태의 문자열 파싱해서 결과 반환
3. 파일 업로드 / 이미지 출력 / 추출한 텍스트 출력
	- @RestController에 추가
	- ocr.js / Ajax 사용
	- ocrResult.jsp 추가
		- 파일 업로드
		- resultBox에 텍스트 출력, imageBox에 이미지 출력

### OCR Template
- 템플릿으로 등록해 놓는 형식에 맞는 이미지를 전송하면 형식에 맞는 텍스트를 추출해서 반환
- 템플릿 작성
	- 이미지 업로드
	- 추출할 영역 지정
		- 필드로 저장 (여러 개 지정)
	- 설정 / 테스트 진행 / 외부 애플리케이션 연동 / 서비스 배포

1. 도메인 생성
2. 템플릿 빌더
3. 템플릿 작성
4. 콘솔에 출력

#### OCR Template 예제
1.  API 호출 결과 출력
	- OCRService 서비스 클래스에 추가 
	- ocrTemplate() : 메소드 추가
		- API 코드 복사
			- apiURL : OCR APIGW Invoke URL
			- Secret Key
			- receipt.jpg / receipt2.jpg
	- 컨트롤러에 추가 : ocrService 객체 사용
		- /OCRTemplate
	- index.jsp에 추가
	- JSON 형식 결과 출력 확인 JSON Viewer에서 확인

### 음성 변환 서비스1 (음성 -> 텍스트)
- CLOVA Speech Recognition (CSR)
	- 사람의 목소리를 인식하여 텍스트로 변환해주는 음성 인식 API 서비스
	- 언어별 지원
		- Kor / Jpn / Chn / Eng
	- 전송 : 음성 파일 전송
	- 응답 : 텍스트 반환

#### 음성 변환 서비스 예제
1. API 호출 결과 출력 : Speech To Text
	- STTService 서비스 클래스에 추가 
	- stt() : 메소드 추가
		- API 코드 복사
			- Client ID
			- Client Secret
			- new1.mp3 / new2.mp3
	- 컨트롤러에 추가 : sttService 객체 사용
		- /stt
	- index.jsp에 추가
	- JSON 형식 결과 출력 확인 Json Viewer에서 확인
2. JSON 결과 파싱
	- jsonToString() 메소드 추가
		- JSON 형태의 문자열 파싱해서 결과 반환
3. 파일 업로드 /  추출한 텍스트 출력 / 오디오 플레이
	- @RestController에 추가 
	- stt.js / Ajax  사용
	- sttResult.jsp 추가
		- 파일 업로드
		- `<div id="resultBox">`에 텍스트 출력
		- `<audio preload="auto" controls></audio>` 플레이 할 경우 mp3 플레이
4. 결과로 받은 텍스트를 파일로 저장
	- 음성 파일 전달하고 텍스트 반환
	- 텍스트를 txt 파일로 저장
		1. FileOutputStream
		2. FileWriter
5. 언어 선택 기능 추가
	- 한국어 (디폴트)
	- 영어
	- 일본어
	- 중국어

### 음성 변환 서비스2 (텍스트 -> 음성)
- 서비스 신청 : CLOVA Voice - Premium
1. API 호출 결과 출력 (Text To Speech)
	- TTSService 서비스 클래스 생성
	- tts() 메소드 추가
		- API 코드 복사
			- 텍스트를 서버에 전송하고 음성 파일 반환 받음 (.mp3로 저장)
			- Client ID
			- Client Secret
			- 기본 문자열 사용
				- "만나서 반갑습니다"
			- 기본 speaker 사용 : nara
	- 컨트롤러에 추가 : ttsService 객체 사용
		- /tts
	- index.jsp에 추가
	- 저장된 mp3 파일 위치 확인 / 플레이 확인
2. 파일 업로드 / 결과 mp3 플레이
- @RestController에 추가 
- tts.js / Ajax  사용
	- tts() 
		- 텍스트 파일 받아서 fileRead() 함수 호출해서 텍스트 파일 내용을 문자열 받음
		- 문자열을 서버에 전송하고 음성 파일 받아서 저장
		- 음성 파일명 return
	- 파일에서 텍스트 추출하는 함수 추가
		- fileRead() 함수
			- txt 파일을 받아서 내용을 읽고 문자열로 반환
- ttsResult.jsp
	- 파일 업로드 기능 추가 
	- 결과 mp3 파일을 `<audio>` 태그로 플레이
	- 음성 파일명 출력 : resultBox
- 컨트롤러에 추가
- index에 변경
- 결과 확인 
	- 텍스트 파일 업로드
	- 결과로 받은 mp3 파일 저장
	- `<audio>` 태그에서 mp3 파일 플레이
	- 파일명이 jsp에 출력
3. 목소리 선택 기능 추가
	- `<select>` 태그 사용

### Chatbot
#### Chatbot 구현 과정
1. 도메인 생성
2. 대화 생성
	- 학습 질문 입력 (여러 개)
	- 챗봇 답변 입력 (여러 개)
	- 웰컴 메시지 작성
3. 챗봇 빌드 (대화 모델 빌드)
4. 챗봇 테스트
5. 서비스 배포
	- 빌드 내역 확인
6. 메신저 연동 (Custom 연동 설정)
	- API Gateway Invoke URL 복사
	- Secret Key 생성 / 복사
7. STS에서 작업

#### Chatbot 예제
1. API 호출 결과 출력
	-   ChatbotService 서비스 클래스 생성
	-   API 코드 복사 
		-   메소드 3개 다 복사
			-   main() / makeSignature() / getReqMessage()
			-   java.uti.Base64
			-   java.net.URL
			-   java.util.Date
			-   makeSignature() 메소드에서 다음 라인 변경
			-   //encodeBase64String = Base64.encodeToString(rawHmac, Base64.NO_WRAP);
			-   encodeBase64String = Base64.getEncoder().encodeToString(rawHmac); 로 변경
			-   static 그대로 두고 결과 확인
	-   APIController에 추가
		-   main() 호출하면 메시지 전달 : “넌 누구니?”
		-   결과 받아서 콘솔에 출력
	-   index에 추가
	-   콘솔 창에서 받은 결과 Json viewer로 확인
	- 주의!
		1.  main() 메소드 호출 : 파라미터 전달
		2.  main() 메소드가 static : 어떻게 호출?
		3.  main() 메소드 호출하고 결과 받아서 출력
2. JSON 파싱
	-   jsonToString() 메소드 추가 
	-   응답 메시지 추출 / 출력
3. 뷰 페이지에서 입력 / 출력
	-   AIRestController / Ajax
	-   chatbot.js
	-   chatForm.jsp 생성
		-   `<div ="resultBox">`
			- 답변 출력
		-   `<form id="chatForm">`
			-   질문 입력
	-   컨트롤러 변경
	-   index 변경
4. 채팅창 꾸미기
	- chat.css
		- word-break
			- 단어의 분리를 결정하여 줄 바꿈 속성 지정
			- normal
				- 한중일 문자는 글자 기준
				- 한중일 이외는 단어 기준
			- break-all
				- 글자 기준으로 줄바꿈
			- keep-all
				- 단어 기준으로 줄바꿈
	- chat.js 변경
	- chatForm.jsp 변경
5. 웰컴 메시지 출력
	- 요청 전달 할 때 요청하는 것이 일반 메시지를 요청하는 것인지, 웰컴 메시지를 요청하는 것인지를 지정해서 전달
	- 요청 메시지 처리하는 메소드 getReqMessage() 메소드
		- event : send (일반 메시지)
		- event : open (웰컴 메시지)
	- ajax를 실행하자마자 호출할 수 있도록 함수로 분리
6. 음성 메시지로 챗봇에게 질문 / 음성으로 답변 받기
	- 음성 녹음해서 mp3 파일로 저장 연습
		- voiceRecordTest.jsp
		- voiceRecord.js
	- 음성 녹음 기능을 챗봇에 적용
		1. 질문 녹음 : 다운로드 폴더에 저장
		2. 음성 파일을 텍스트로 변환 작업 필요 : STT
			- mp3 파일명 전달
			- 다운로드 폴더에 있는 파일 서버로 전송
			- 텍스트 반환
		3. 반환된 텍스트를 질문으로 챗봇에게 전달
			- 답변 받기 (텍스트)
		4. 음성으로 답변하기 위해 챗봇의 텍스트 답변을 음성으로 변환 필요 : TTS
		5. `<audio>` 플레이해서 음성 답변
7. 채팅창에 출력하지 않고 음성으로만 채팅
8. 이미지 답변 / 멀티 링크 답변 / 빌드 / 배포
	- 시간 관련 질문 / 답변
	- 독서 모임 장소 위치 / 약도 문의 : 이미지 답변
	- 독서 모임 신청 : 멀티링크 답변
9. 대화 추가
	- 독서 모임 시간 문의 : 기본 답변
	- 독서 모임 장소 약도 문의 : 이미지 + 텍스트 답변
	- 독서 모임 신청 : 멀티링크 답변
	- https://www.multicampus.com/kr/index.html
	- JSON 파싱을 자바스크립트에서 처리
		- 서버에서 받은 JSON 결과를 그대로 Ajax로 반환
10. 챗봇 : 채팅창 + 텍스트 + 음성 + 이미지 / 멀티링크 답변
	- chatFormJSON.jsp
	- chatbotJSON.js
	- ChatbotService 클래스에 메소드 추가
	- mainJSON() : JSON 형태의 문자열 그대로 반환
	- AIRestController에 추가 : / chatJSON
	- APIController에 추가 : /chatFormJSON

