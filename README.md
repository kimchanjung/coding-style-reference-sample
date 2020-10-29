# 실행방법

인텔리제이 프로젝트를 import 후 WeMakePriceApplication 실행(run) 합니다.
기본적으로 http://localhost:8080 으로 서비스가 실행됩니다.

# 버전정보
- Java - v1.8
- Spring Boot - v2.3.4
- Jsoup - v1.13.1 (크롤링 라이브러리)
- React - v17.0.1


# 파일 정보

### WebCrawlingController
클롤링 요청을 처리하는 컨트롤러

### WebCrawlingService
크롤링 처리 라이브러리를 사용하고 응답 DTO를 리턴하는 비즈니스로직 포함

### JsoupService
크롤링 라이브러리를 서비스에서 WebCrawlingService직접 사용하지 않고
한번 추상화하여 제공함(테스트시 Mock객체로 대체하거나 하가위하여 느슨한 결합유지)

### WebContentDto
크롤링 라이브러리 Jsoup에서 가져온 내용을 조건에 맞게 파싱하는 로직이 포함된
컨텐츠 객체(요구조건을 처리하는 로직은 대부분 이 클래스에 포함되어 있습니다.)

## 참고
프론트 부분은 중요 체크 사항에 포함되지 않다 디자인 작업은 완전히 배체하였습니다. 

감사합니다.