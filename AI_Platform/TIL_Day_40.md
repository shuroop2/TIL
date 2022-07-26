# TIL_Day_40
>2022년 07월 26일
## AI Platform
### 실습
#### 얼굴 인식
- celebrity : 유명인 얼굴 인식 API
	- 전송 : 이미지 (얼굴 사진)
	- 결과
		- JSON 형태로 반환
		- JSON 데이터 파싱해서 추출 / 출력
		- JSON 파싱 결과를 VO에 저장
	- face : 얼굴 감지 API
	- 
##### celebrity : 유명인 얼굴 인식 API
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

##### JSON 파싱 메소드
-  `ArrayList<CelebrityVO> jsonToVOList(String jsonResultStr);`
-  API 호출 결과 JSON 형식의 문자열 전달 받아서
- value와 confidence를 추출해서 VO에 저장 / List에 추가
- VO 리스트 반환

#### 얼굴 감지
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

#### 포즈 인식 (Pose Estimation)

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

#### 객체 탐지 (Object Detection)
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

#### 자동 번역
- Naver Papago 사용하여 한글로 번역
- 입력한 텍스트를 인공신경망 기반 번역 알고리즘을 통해 여러 나라의 언어로 자동 번역
- Papago Text Translation 서비스 추가