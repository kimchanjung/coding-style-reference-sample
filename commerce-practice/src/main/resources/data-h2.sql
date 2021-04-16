INSERT INTO USERS (email , last_login_at, login_count, name, passwd ) values ('kimchanjung.dev@gmail.com', now(), 1, '김찬정','1234');
INSERT INTO USERS (email , last_login_at, login_count, name, passwd ) values ('hong.dev@gmail.com', now(), 1, '홍길','1234');


INSERT INTO STORES (name , state, off_day, run24, open_time, close_time ) values ('홍콩반점', 'NORMAL', 1, false, 540, 1200);
INSERT INTO STORES (name , state, off_day, run24, open_time, close_time ) values ('맥도날드', 'NORMAL', 2, true, 0, 13200);
INSERT INTO STORES (name , state, off_day, run24, open_time, close_time ) values ('롯데리아', 'HIDDEN', 3, false, 540, 1200);
