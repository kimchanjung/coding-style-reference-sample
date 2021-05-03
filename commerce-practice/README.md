# 프로젝트 목적
이 프로젝트는 평소 코딩 스타일을 확인해 볼 수 있도록 커머스도메인(업소,상품,주문)을 바탕으로 
간단한 도메인 생성, 수정, 주문하기 등등 API를 통하여 저의 코딩 스타일을 확인 해보실 수 있습니다. 

# 버전정보
Java v1.8  
Spring Boot v2.4.4  
JPA v2.4.4  
Gradle v6.8.3  
MapStruct v1.4.2  

# 기능 리스트
#### 상점목록 조회 API
- 영업중인 상점만 조회
- 휴무일, 24시간 여부, 영업시작시간, 영업종료시간, 업소상태값을 바탕으로 영업여부 계산 
- GET http://localhost:8080/api/stores
#### 즐겨찾기 상점목록 조회 API
- 영업중인 상점 표시 
- GET http://localhost:8080/api/bookmarkedstores?time=2021-04-15 19:25:38
#### 즐겨찾기 상점 추가 API
- 이미추가된 상점 체크
- POST http://localhost:8080/api/bookmarkedstores/3/bookmark
#### 즐겨찾기 상점 삭제 API
- 삭제가능여부 체크 
- DELETE http://localhost:8080/api/bookmarkedstores/3/bookmark
#### 주문목록 조회 API
- 날짜범위의 주문만 조회 
- GET http://localhost:8080/api/orders/between/2021-04-14 00:25:38/and/2021-04-16 19:25:38
#### 주문하기 API
- 정상영업 업소 체크
- 주문메뉴 1개 이상 체크
- 최소 주문 가격 체크
- POST http://localhost:8080/api/orders/store/3
    ```json
    [
      {
        "name": "햄버",
        "unitPrice": 5000,
        "unitCount": 2
      },
      {
        "name": "콜",
        "unitPrice": 2000,
        "unitCount": 3
      }
    ]
    ```
#### 주문취소 API
- 주문 존재 여부 체크
- 주문 취소 가능 상태 체크
- PATCH http://localhost:8080/api/orders/1/cancel
    ```json
    {
        "message": "주문실수"
    }
    ```

# 프로젝트 구조
#### 메인 비즈니스 로직 
- com.commerce.practice

#### 레이어별 분류
- configuration - 설정 클래스 
- controllers - 컨트롤러 
- dto - Data Transfer Object
- entity - JPA 엔티티 클래스
- enums - 열거형 객체, 주로 상태 값
- mappers - MapStruct 매퍼 클래스, dto <-> entity 간 매퍼
- mocks - 테스트 시 필요한 entity, dto 객체 생성 상용구 모음 
- repositories - JPA repository
- services - 메인 비즈니스 로직 
- util - 각종 유틸리티 클래스 
- ex - 예외 클래스 

#### 실행방법
- 로컬에서 실행시  http://localhost:8080 접속
- 기본적으로 유저, 상점 데이터들이 서버 실행시 생성 되도록 되어 있음
- 유저, 상점 생성을 제외한 모든 기능을 테스트 하면됨
- 유저와 상점을 기본으로 상점북마크, 북마크조회, 주문하기, 주문내역조회, 주문취소 등등 테스트 가능 
