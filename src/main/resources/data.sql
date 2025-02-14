insert into member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate) values ("김이름", "asd","123","asd123@domain.com","010-1111-1111","2001-11-11", now(), now() );
insert into member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate) values ("최이름", "qwe","456","qwe123@domain.com","010-2222-2222","2002-11-11", now(), now());
insert into member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate) values ("박이름", "zxc","789","zxc123@domain.com","010-3333-3333","2003-11-11", now(), now());
insert into member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate) values ("오이름", "rty","101","rty123@domain.com","010-4444-4444","2004-11-11", now(), now());
insert into member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate) values ("이이름", "fgh","112","fgh123@domain.com","010-5555-5555","2005-11-11", now(), now());

insert into category (cname) values ("질문");
insert into category (cname) values ("대외/취업");
insert into category (cname) values ("튜토리얼");
insert into category (cname) values ("문제은행");

INSERT INTO language (lname) VALUES ("C/C++");
INSERT INTO language (lname) VALUES ("C#");
INSERT INTO language (lname) VALUES ("Java");
INSERT INTO language (lname) VALUES ("Python");
INSERT INTO language (lname) VALUES ("Html/Css");
INSERT INTO language (lname) VALUES ("JavaScript");
INSERT INTO language (lname) VALUES ("TypeScript");
INSERT INTO language (lname) VALUES ("Kotlin");
INSERT INTO language (lname) VALUES ("Swift");
INSERT INTO language (lname) VALUES ("Go");
INSERT INTO language (lname) VALUES ("Rust");
INSERT INTO language (lname) VALUES ("기타");

insert into board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) values ("Rest API 질문", "이거 어떻게 해요?", 23, 3, now(), now(), 1, 1, 1);
insert into board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) values ("부평 백엔드 부트캠프 모집", "2025년 상반기 부트캠프 개설!", 45, 6, now(), now(), 2, 2, 1);
insert into board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) values ("스프링부트 입문 가이드", "start.spring.io 접속", 687, 31, now(), now(), 3, 3, 1);
insert into board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) values ("가위바위보 게임", "가위바위보 프로그램을 만드시오", 56, 21, now(), now(), 1, 4, 1);
insert into board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) values ("이거 왜 안됨?", "아래가 제 코드인데", 17, 3, now(), now(), 4, 1, 1);

insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("좋은 정보 감사합니다!", 12, now(), now(), 4, 1);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("부트캠프 참여 후기 궁금합니다.", 5, now(), now(), 1, 2);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("에러가 왜 뜨냐", 26, now(), now(), 2, 4);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("이직하고 싶습니다..", 33, now(), now(), 4, 2);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("자격증은 어떻게 준비하셨나요?", 8, now(), now(), 3, 1);

INSERT INTO message (receivermno, sendermno, mecontent, metitle, deleted_by_receiver, deleted_by_sender)VALUE(2, 1, '안녕하세요! 오랜만이에요.', '인사', 0, 0);
INSERT INTO message (receivermno, sendermno, mecontent, metitle, deleted_by_receiver, deleted_by_sender)VALUE(3, 1, '이번 프로젝트 관련해서 논의가 필요합니다.', '프로젝트 논의', 0, 0);
INSERT INTO message (receivermno, sendermno, mecontent, metitle, deleted_by_receiver, deleted_by_sender)VALUE(1, 2, '네, 언제 시간 괜찮으세요?', '답장', 0, 0);
INSERT INTO message (receivermno, sendermno, mecontent, metitle, deleted_by_receiver, deleted_by_sender)VALUE(4, 3, '파일을 확인해 주세요.', '파일 전달', 0, 0);
INSERT INTO message (receivermno, sendermno, mecontent, metitle, deleted_by_receiver, deleted_by_sender)VALUE(2, 4, '내일 회의 참석 가능하신가요?', '회의 참석 여부', 0, 0);