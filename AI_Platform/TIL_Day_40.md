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
	-   OCRService 서비스 클래스 생성 
	-   ocrGeneral() : 메소드 추가
	-   API 코드 복사
		1. ocrGeneral() 메소드에 복사
			- apiURL : GateWay URL
			- Secret Key
		2. writeMultiPart() 메소드도 복사해서 아래 붙여넣기
		-   결과를 콘솔에 출력
	-   컨트롤러에 추가 : ocrService
		-   /OCRGeneral
	-   index.jsp에 추가
	-   JSON 형식 결과 출력 확인 Json Viewer에서 확인
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
	-   OCRService 서비스 클래스에 추가 
	-   ocrTemplate() : 메소드 추가
		-   API 코드 복사
			-   apiURL : OCR APIGW Invoke URL
			-   Secret Key
			-   receipt.jpg / receipt2.jpg
	- 컨트롤러에 추가 : ocrService 객체 사용
		- /OCRTemplate
	- index.jsp에 추가
	- JSON 형식 결과 출력 확인 JSON Viewer에서 확인

### 음성 변환 서비스
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
	-   한국어 (디폴트)
	-   영어
	-   일본어
	-   중국어








