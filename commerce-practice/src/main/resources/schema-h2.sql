-- resouce/schema-{데이터베이스종류}.sql
-- resouce/data-{데이터베이스종류}.sql
-- 하면 실행된다.
-- spring.datasource.initialization-mode: always, never...
-- 위 설정에 따라 실행 여부를 결정한다
-- 보통 jpa 사용하면 테이블은 생성이 되는데
-- 아래 스키마와 같은 entity생성을 확인 해볼 요량사용 할 수 있다.
DROP TABLE IF EXISTS order_items CASCADE;

DROP TABLE IF EXISTS orders CASCADE;

DROP TABLE IF EXISTS bookmarked_stores CASCADE;

DROP TABLE IF EXISTS stores CASCADE;

DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users

(

id            bigint      NOT NULL AUTO_INCREMENT, --사용자 PK

name          varchar(10) NOT NULL,                --사용자명

email         varchar(50) NOT NULL,                --로그인 이메일

passwd        varchar(90) NOT NULL,                --로그인 비밀번호

login_count   int         NOT NULL DEFAULT 0,      --로그인 횟수 (로그인시 마다 1 증가)

last_login_at datetime             DEFAULT NULL,   --최종로그인 시각

created_at    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),

PRIMARY KEY (id),

UNIQUE KEY unq_user_email (email)

);

CREATE TABLE stores

(

id         bigint      NOT NULL AUTO_INCREMENT, --상점 PK

name       varchar(20) NOT NULL,                --상점명

state      enum ('HIDDEN','NORMAL') DEFAULT 'NORMAL' NOT NULL,

off_day    int         NOT NULL,                --휴무요일 (월:1,화:2,수:3,목:4,금:5,토:6,일:7)

run24      bool        NOT NULL,                --true 라면, 24시간영업 (open_time,close_time 미사용)

open_time  int         NOT NULL,                --영업시작시각 (0~1439,예:9시=9*60=540)

close_time int         NOT NULL,                --영업종료시각 (0~1439,예:10시20분=10*60+20=620)

created_at datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),

PRIMARY KEY (id)

);

CREATE TABLE bookmarked_stores

(

id         bigint   NOT NULL AUTO_INCREMENT, --상점 즐겨찾기 PK

user_id    bigint   NOT NULL,                --사용자 PK

store_id   bigint   NOT NULL,                --상점 PK

created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),

PRIMARY KEY (id),

UNIQUE KEY unq_user_store (user_id, store_id),

CONSTRAINT fk_bookmark_to_users FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE RESTRICT ON UPDATE RESTRICT,

CONSTRAINT fk_bookmark_to_stores FOREIGN KEY (store_id) REFERENCES stores (id) ON DELETE RESTRICT ON UPDATE RESTRICT

);

CREATE TABLE orders

(

id           bigint   NOT NULL AUTO_INCREMENT, --주문 PK

user_id      bigint   NOT NULL,                --사용자 PK

store_id     bigint   NOT NULL,                --상점 PK

state        enum ('NEW','COMPLETE','CANCEL') DEFAULT 'NEW' NOT NULL,

cancel_msg   varchar(512)      DEFAULT NULL,   --취소요청 메시지

canceled_at  datetime          DEFAULT NULL,   --취소된 날짜

completed_at datetime          DEFAULT NULL,   --완료된 날짜

created_at   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),

PRIMARY KEY (id),

INDEX        idx_user_id_created_at (user_id, created_at),

CONSTRAINT fk_orders_to_users FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE RESTRICT ON UPDATE RESTRICT,

CONSTRAINT fk_orders_to_stores FOREIGN KEY (store_id) REFERENCES stores (id) ON DELETE RESTRICT ON UPDATE RESTRICT

);

CREATE TABLE order_items

(

id         bigint      NOT NULL AUTO_INCREMENT, --주문아이템 PK

order_id   bigint      NOT NULL,                --주문 PK

name       varchar(50) NOT NULL,                --아이템명

unit_price int         NOT NULL,                --개별가격

unit_count int         NOT NULL,                --갯수 (총금액=갯수*개별가격)

PRIMARY KEY (id),

CONSTRAINT fk_order_items_to_orders FOREIGN KEY (order_id) REFERENCES orders (id) ON DELETE RESTRICT ON UPDATE RESTRICT

);