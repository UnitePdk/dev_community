insert into member (mname, mid, mpwd, memail, mphone, mbirth, mimg, cdate, udate) values ("김이름", "asd","123","asd123@domain.com","010-1111-1111","2001-11-11","default.jpg", now(), now() );
insert into member (mname, mid, mpwd, memail, mphone, mbirth, mimg, cdate, udate) values ("최이름", "qwe","456","qwe123@domain.com","010-2222-2222","2002-11-11","default.jpg" , now(), now());
insert into member (mname, mid, mpwd, memail, mphone, mbirth, mimg, cdate, udate) values ("박이름", "zxc","789","zxc123@domain.com","010-3333-3333","2003-11-11","default.jpg" , now(), now());
insert into member (mname, mid, mpwd, memail, mphone, mbirth, mimg, cdate, udate) values ("오이름", "rty","101","rty123@domain.com","010-4444-4444","2004-11-11","default.jpg" , now(), now());
insert into member (mname, mid, mpwd, memail, mphone, mbirth, mimg, cdate, udate) values ("이이름", "fgh","112","fgh123@domain.com","010-5555-5555","2005-11-11","default.jpg" , now(), now());

insert into category (cname) values ("질문");
insert into category (cname) values ("대외/취업");
insert into category (cname) values ("튜토리얼");
insert into category (cname) values ("문제은행");

insert into board (btitle, bcontent, bview, blike, cdate, udate, mno, cno) values ("Rest API 질문", "이거 어떻게 해요?", 23, 3, now(), now(), 1, 1);
insert into board (btitle, bcontent, bview, blike, cdate, udate, mno, cno) values ("부평 백엔드 부트캠프 모집", "2025년 상반기 부트캠프 개설!", 45, 6, now(), now(), 2, 2);
insert into board (btitle, bcontent, bview, blike, cdate, udate, mno, cno) values ("스프링부트 입문 가이드", "start.spring.io 접속", 687, 31, now(), now(), 3, 3);
insert into board (btitle, bcontent, bview, blike, cdate, udate, mno, cno) values ("가위바위보 게임", "가위바위보 프로그램을 만드시오", 56, 21, now(), now(), 1, 4);
insert into board (btitle, bcontent, bview, blike, cdate, udate, mno, cno) values ("이거 왜 안됨?", "아래가 제 코드인데", 17, 3, now(), now(), 4, 1);

insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("좋은 정보 감사합니다!", 12, now(), now(), 4, 1);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("부트캠프 참여 후기 궁금합니다.", 5, now(), now(), 1, 2);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("에러가 왜 뜨냐", 26, now(), now(), 2, 4);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("이직하고 싶습니다..", 33, now(), now(), 4, 2);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("자격증은 어떻게 준비하셨나요?", 8, now(), now(), 3, 1);
