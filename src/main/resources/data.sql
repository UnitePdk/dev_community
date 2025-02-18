insert into member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate) values ("김이름", "asd","123","asd123@domain.com","010-1111-1111","2001-11-11", now(), now() );
insert into member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate) values ("최이름", "qwe","456","qwe123@domain.com","010-2222-2222","2002-11-11", now(), now());
insert into member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate) values ("박이름", "zxc","789","zxc123@domain.com","010-3333-3333","2003-11-11", now(), now());
insert into member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate) values ("오이름", "rty","101","rty123@domain.com","010-4444-4444","2004-11-11", now(), now());
insert into member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate) values ("이이름", "fgh","112","fgh123@domain.com","010-5555-5555","2005-11-11", now(), now());
INSERT INTO member (mname, mid, mpwd, memail, mphone, mbirth, cdate, udate)
VALUES
("정이름", "vbn", "113", "vbn123@domain.com", "010-6666-6666", "2006-11-11", NOW(), NOW()),
("한이름", "mnb", "114", "mnb123@domain.com", "010-7777-7777", "2007-11-11", NOW(), NOW()),
("조이름", "lkj", "115", "lkj123@domain.com", "010-8888-8888", "2008-11-11", NOW(), NOW()),
("백이름", "poi", "116", "poi123@domain.com", "010-9999-9999", "2009-11-11", NOW(), NOW()),
("장이름", "wer", "117", "wer123@domain.com", "010-1010-1010", "2010-11-11", NOW(), NOW()),
("홍이름", "sdf", "118", "sdf123@domain.com", "010-1112-1112", "2011-11-11", NOW(), NOW()),
("송이름", "dfg", "119", "dfg123@domain.com", "010-1212-1212", "2012-11-11", NOW(), NOW()),
("강이름", "ghj", "120", "ghj123@domain.com", "010-1313-1313", "2013-11-11", NOW(), NOW()),
("윤이름", "tyu", "121", "tyu123@domain.com", "010-1414-1414", "2014-11-11", NOW(), NOW()),
("허이름", "uio", "122", "uio123@domain.com", "010-1515-1515", "2015-11-11", NOW(), NOW()),
("노이름", "asd2", "123", "asd2123@domain.com", "010-1616-1616", "2016-11-11", NOW(), NOW()),
("서이름", "qwe2", "124", "qwe2123@domain.com", "010-1717-1717", "2017-11-11", NOW(), NOW()),
("류이름", "zxc2", "125", "zxc2123@domain.com", "010-1818-1818", "2018-11-11", NOW(), NOW()),
("도이름", "rty2", "126", "rty2123@domain.com", "010-1919-1919", "2019-11-11", NOW(), NOW()),
("문이름", "fgh2", "127", "fgh2123@domain.com", "010-2020-2020", "2020-11-11", NOW(), NOW());

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
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("C/C++ 질문 1", "C/C++ 어떻게 시작하나요?", 10, 5, now(), now(), 1, 1, 1),
("C/C++ 질문 2", "포인터 관련 질문", 15, 7, now(), now(), 3, 1, 1),
("C/C++ 질문 3", "메모리 관리 방법", 20, 8, now(), now(), 5, 1, 1),
("C/C++ 질문 4", "C++ 클래스 사용법", 25, 6, now(), now(), 2, 1, 1),
("C/C++ 질문 5", "함수 오버로딩", 12, 3, now(), now(), 9, 1, 1),
("C/C++ 질문 6", "C 언어와 C++ 차이", 30, 9, now(), now(), 2, 1, 1),
("C/C++ 질문 7", "C++ 템플릿 사용법", 28, 5, now(), now(), 5, 1, 1),
("C/C++ 질문 8", "C++ 예외 처리", 18, 4, now(), now(), 8, 1, 1),
("C/C++ 질문 9", "C에서 문자열 처리", 35, 10, now(), now(), 2, 1, 1),
("C/C++ 질문 10", "C++ STL 사용법", 40, 7, now(), now(), 6, 1, 1);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("C# 질문 1", "C#에서 LINQ란?", 10, 5, now(), now(), 5, 1, 2),
("C# 질문 2", "C#에서 async/await 사용법", 15, 7, now(), now(), 14, 1, 2),
("C# 질문 3", "C# 클래스와 인터페이스 차이", 20, 6, now(), now(), 3, 1, 2),
("C# 질문 4", "C#에서 Delegate 사용법", 25, 8, now(), now(), 7, 1, 2),
("C# 질문 5", "C#의 Event와 Delegate", 12, 3, now(), now(), 2, 1, 2),
("C# 질문 6", "C#에서 성능 최적화", 30, 9, now(), now(), 4, 1, 2),
("C# 질문 7", "C#에서 Reflection", 28, 5, now(), now(), 8, 1, 2),
("C# 질문 8", "C#에서 예외 처리", 18, 4, now(), now(), 2, 1, 2),
("C# 질문 9", "C#에서 데이터 바인딩", 35, 10, now(), now(), 1, 1, 2),
("C# 질문 10", "C#에서 null 처리", 40, 7, now(), now(), 9, 1, 2);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("Java 질문 1", "Java에서 컬렉션 사용법", 10, 5, now(), now(), 1, 1, 3),
("Java 질문 2", "Java의 인터페이스란?", 15, 7, now(), now(), 2, 1, 3),
("Java 질문 3", "Java에서 예외 처리", 20, 6, now(), now(), 7, 1, 3),
("Java 질문 4", "Java Stream API 사용법", 25, 8, now(), now(), 6, 1, 3),
("Java 질문 5", "Java에서 다중 상속", 12, 3, now(), now(), 5, 1, 3),
("Java 질문 6", "Java 성능 최적화", 30, 9, now(), now(), 2, 1, 3),
("Java 질문 7", "Java에서 람다 사용법", 28, 5, now(), now(), 8, 1, 3),
("Java 질문 8", "Java에서 자원 관리", 18, 4, now(), now(), 9, 1, 3),
("Java 질문 9", "Java에서 메모리 관리", 35, 10, now(), now(), 11, 1, 3),
("Java 질문 10", "Java에서 빌더 패턴", 40, 7, now(), now(), 7, 1, 3);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("Python 질문 1", "Python에서 list comprehension 사용법", 10, 5, now(), now(), 2, 1, 4),
("Python 질문 2", "Python의 lambda 함수 사용법", 15, 7, now(), now(), 4, 1, 4),
("Python 질문 3", "Python에서 파일 처리", 20, 6, now(), now(), 9, 1, 4),
("Python 질문 4", "Python에서 예외 처리", 25, 8, now(), now(), 7, 1, 4),
("Python 질문 5", "Python의 자료형 처리", 12, 3, now(), now(), 4, 1, 4),
("Python 질문 6", "Python의 데코레이터 사용법", 30, 9, now(), now(), 2, 1, 4),
("Python 질문 7", "Python에서 병렬 처리", 28, 5, now(), now(), 1, 1, 4),
("Python 질문 8", "Python에서 웹 크롤링", 18, 4, now(), now(), 10, 1, 4),
("Python 질문 9", "Python의 딕셔너리 활용", 35, 10, now(), now(), 4, 1, 4),
("Python 질문 10", "Python의 파이썬 3.x 기능", 40, 7, now(), now(), 3, 1, 4);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("HTML/CSS 질문 1", "HTML에서 기본 구조", 10, 5, now(), now(), 12, 1, 5),
("HTML/CSS 질문 2", "CSS Flexbox 사용법", 15, 7, now(), now(), 11, 1, 5),
("HTML/CSS 질문 3", "CSS Grid 레이아웃", 20, 6, now(), now(), 14, 1, 5),
("HTML/CSS 질문 4", "HTML5에서 새로운 요소", 25, 8, now(), now(), 1, 1, 5),
("HTML/CSS 질문 5", "CSS 애니메이션", 12, 3, now(), now(), 4, 1, 5),
("HTML/CSS 질문 6", "반응형 웹 디자인", 30, 9, now(), now(), 8, 1, 5),
("HTML/CSS 질문 7", "CSS에서 위치 설정", 28, 5, now(), now(), 11, 1, 5),
("HTML/CSS 질문 8", "HTML에서 표 사용법", 18, 4, now(), now(), 7, 1, 5),
("HTML/CSS 질문 9", "HTML/CSS에서 폰트 설정", 35, 10, now(), now(), 5, 1, 5),
("HTML/CSS 질문 10", "HTML 폼 작성법", 40, 7, now(), now(), 3, 1, 5);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("JavaScript 질문 1", "JavaScript에서 함수 선언", 10, 5, now(), now(), 2, 1, 6),
("JavaScript 질문 2", "JavaScript의 비동기 처리", 15, 7, now(), now(), 1, 1, 6),
("JavaScript 질문 3", "JavaScript의 this 키워드", 20, 6, now(), now(), 9, 1, 6),
("JavaScript 질문 4", "ES6에서 화살표 함수", 25, 8, now(), now(), 8, 1, 6),
("JavaScript 질문 5", "JavaScript 클로저", 12, 3, now(), now(), 7, 1, 6),
("JavaScript 질문 6", "JavaScript 객체 지향 프로그래밍", 30, 9, now(), now(), 3, 1, 6),
("JavaScript 질문 7", "JavaScript에서 이벤트 처리", 28, 5, now(), now(), 2, 1, 6),
("JavaScript 질문 8", "JavaScript 배열 처리", 18, 4, now(), now(), 1, 1, 6),
("JavaScript 질문 9", "JavaScript에서 DOM 조작", 35, 10, now(), now(), 4, 1, 6),
("JavaScript 질문 10", "JavaScript에서 프로미스 사용법", 40, 7, now(), now(), 6, 1, 6);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("TypeScript 질문 1", "TypeScript에서 타입 시스템", 10, 5, now(), now(), 1, 1, 7),
("TypeScript 질문 2", "TypeScript 인터페이스 사용법", 15, 7, now(), now(), 4, 1, 7),
("TypeScript 질문 3", "TypeScript에서 함수 오버로딩", 20, 6, now(), now(), 2, 1, 7),
("TypeScript 질문 4", "TypeScript의 모듈 시스템", 25, 8, now(), now(), 6, 1, 7),
("TypeScript 질문 5", "TypeScript의 제네릭", 12, 3, now(), now(), 3, 1, 7),
("TypeScript 질문 6", "TypeScript에서 클래스 사용법", 30, 9, now(), now(), 5, 1, 7),
("TypeScript 질문 7", "TypeScript에서 any 타입", 28, 5, now(), now(), 11, 1, 7),
("TypeScript 질문 8", "TypeScript에서 인터페이스와 클래스", 18, 4, now(), now(), 2, 1, 7),
("TypeScript 질문 9", "TypeScript에서 타입 추론", 35, 10, now(), now(), 9, 1, 7),
("TypeScript 질문 10", "TypeScript에서 네임스페이스", 40, 7, now(), now(), 4, 1, 7);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("Kotlin 질문 1", "Kotlin에서 함수형 프로그래밍", 10, 5, now(), now(), 1, 1, 8),
("Kotlin 질문 2", "Kotlin에서 데이터 클래스", 15, 7, now(), now(), 2, 1, 8),
("Kotlin 질문 3", "Kotlin에서 null 처리", 20, 6, now(), now(), 3, 1, 8),
("Kotlin 질문 4", "Kotlin에서 확장 함수", 25, 8, now(), now(), 4, 1, 8),
("Kotlin 질문 5", "Kotlin에서 코루틴 사용법", 12, 3, now(), now(), 5, 1, 8),
("Kotlin 질문 6", "Kotlin에서 타입 시스템", 30, 9, now(), now(), 1, 1, 8),
("Kotlin 질문 7", "Kotlin에서 람다", 28, 5, now(), now(), 7, 1, 8),
("Kotlin 질문 8", "Kotlin에서 컬렉션 처리", 18, 4, now(), now(), 8, 1, 8),
("Kotlin 질문 9", "Kotlin에서 인터페이스 사용", 35, 10, now(), now(), 9, 1, 8),
("Kotlin 질문 10", "Kotlin에서 고차 함수", 40, 7, now(), now(), 10, 1, 8);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("Swift 질문 1", "Swift에서 옵셔널 처리", 10, 5, now(), now(), 18, 1, 9),
("Swift 질문 2", "Swift에서 클래스와 구조체 차이", 15, 7, now(), now(), 12, 1, 9),
("Swift 질문 3", "Swift에서 고차 함수", 20, 6, now(), now(), 13, 1, 9),
("Swift 질문 4", "Swift에서 제네릭 사용법", 25, 8, now(), now(), 14, 1, 9),
("Swift 질문 5", "Swift에서 클로저", 12, 3, now(), now(), 11, 1, 9),
("Swift 질문 6", "Swift에서 옵셔널 체이닝", 30, 9, now(), now(), 14, 1, 9),
("Swift 질문 7", "Swift에서 타입 시스템", 28, 5, now(), now(), 18, 1, 9),
("Swift 질문 8", "Swift에서 메모리 관리", 18, 4, now(), now(), 1, 1, 9),
("Swift 질문 9", "Swift에서 구조체 사용법", 35, 10, now(), now(), 1, 1, 9),
("Swift 질문 10", "Swift에서 스위프트UI 사용법", 40, 7, now(), now(), 3, 1, 9);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("Go 질문 1", "Go에서 Goroutines 사용법", 10, 5, now(), now(), 13, 1, 10),
("Go 질문 2", "Go에서 채널 사용법", 15, 7, now(), now(), 12, 1, 10),
("Go 질문 3", "Go에서 구조체 사용법", 20, 6, now(), now(), 16, 1, 10),
("Go 질문 4", "Go에서 인터페이스 사용법", 25, 8, now(), now(), 1, 1, 10),
("Go 질문 5", "Go에서 에러 처리", 12, 3, now(), now(), 7, 1, 10),
("Go 질문 6", "Go에서 성능 최적화", 30, 9, now(), now(), 8, 1, 10),
("Go 질문 7", "Go에서 동시성 처리", 28, 5, now(), now(), 3, 1, 10),
("Go 질문 8", "Go에서 패키지 사용법", 18, 4, now(), now(), 6, 1, 10),
("Go 질문 9", "Go에서 빌드 시스템", 35, 10, now(), now(), 2, 1, 10),
("Go 질문 10", "Go에서 메모리 관리", 40, 7, now(), now(), 9, 1, 10);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("Rust 질문 1", "Rust에서 소유권 시스템", 10, 5, now(), now(), 4, 1, 11),
("Rust 질문 2", "Rust에서 오류 처리", 15, 7, now(), now(), 2, 1, 11),
("Rust 질문 3", "Rust에서 클로저", 20, 6, now(), now(), 1, 1, 11),
("Rust 질문 4", "Rust에서 메모리 관리", 25, 8, now(), now(), 6, 1, 11),
("Rust 질문 5", "Rust에서 제네릭 사용법", 12, 3, now(), now(), 8, 1, 11),
("Rust 질문 6", "Rust에서 안전성", 30, 9, now(), now(), 9, 1, 11),
("Rust 질문 7", "Rust에서 패턴 매칭", 28, 5, now(), now(), 2, 1, 11),
("Rust 질문 8", "Rust에서 함수형 프로그래밍", 18, 4, now(), now(), 3, 1, 11),
("Rust 질문 9", "Rust에서 동시성", 35, 10, now(), now(), 7, 1, 11),
("Rust 질문 10", "Rust에서 비동기 처리", 40, 7, now(), now(), 5, 1, 11);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("기타 질문 1", "기타 언어의 질문", 10, 5, now(), now(), 1, 1, 12),
("기타 질문 2", "비정형 데이터 처리", 15, 7, now(), now(), 2, 1, 12),
("기타 질문 3", "비주얼 프로그래밍 언어", 20, 6, now(), now(), 8, 1, 12),
("기타 질문 4", "그래픽스 프로그래밍", 25, 8, now(), now(), 6, 1, 12),
("기타 질문 5", "임베디드 시스템", 12, 3, now(), now(), 7, 1, 12),
("기타 질문 6", "병렬 처리 개념", 30, 9, now(), now(), 11, 1, 12),
("기타 질문 7", "게임 프로그래밍", 28, 5, now(), now(), 6, 1, 12),
("기타 질문 8", "기타 알고리즘", 18, 4, now(), now(), 8, 1, 12),
("기타 질문 9", "데이터 시각화", 35, 10, now(), now(), 1, 1, 12),
("기타 질문 10", "클라우드 컴퓨팅", 40, 7, now(), now(), 2, 1, 12);

INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("부평 백엔드 부트캠프 모집", "2025년 상반기 부트캠프 개설!", 45, 6, now(), now(), 2, 2, 1),
("서울 프론트엔드 개발자 채용", "React 경험자를 찾습니다!", 78, 12, now(), now(), 4, 2, 3),
("데브옵스 엔지니어 채용", "AWS 및 Docker 경험 우대", 64, 10, now(), now(), 8, 2, 5),
("백엔드 주니어 개발자 모집", "Java Spring 경험자 환영!", 91, 14, now(), now(), 11, 2, 2),
("스타트업 iOS 개발자 채용", "Swift 경험자 모집", 55, 7, now(), now(), 6, 2, 8),
("데이터 사이언티스트 채용", "Python, ML 경험 필수", 102, 19, now(), now(), 10, 2, 6),
("인공지능 연구원 모집", "딥러닝 연구개발자 구인", 88, 17, now(), now(), 9, 2, 4),
("프리랜서 개발자 모집", "자율근무 가능한 개발자를 찾습니다.", 73, 11, now(), now(), 12, 2, 9),
("UI/UX 디자이너 구인", "Figma, Adobe XD 경험자 모집", 59, 8, now(), now(), 15, 2, 10),
("블록체인 개발자 채용", "스마트 컨트랙트 개발자 구함", 110, 23, now(), now(), 5, 2, 7),
("안드로이드 개발자 채용", "Kotlin/Java 개발자 모집", 84, 16, now(), now(), 3, 2, 11),
("풀스택 개발자 채용", "Node.js, React, AWS 활용 가능자", 77, 14, now(), now(), 14, 2, 12),
("대기업 IT 인턴 모집", "3개월 인턴 후 정규직 전환 가능", 96, 21, now(), now(), 7, 2, 1),
("데이터 엔지니어 채용", "BigQuery, Spark 경험 필수", 85, 18, now(), now(), 17, 2, 5),
("스타트업 CTO 채용", "초기 창업 멤버를 구합니다.", 113, 25, now(), now(), 13, 2, 4),
("웹 퍼블리셔 채용", "HTML, CSS, JavaScript 필수", 71, 13, now(), now(), 19, 2, 3),
("로봇 소프트웨어 엔지니어 모집", "ROS, C++ 개발자 구인", 99, 20, now(), now(), 16, 2, 7),
("AI 스타트업 백엔드 개발자 모집", "Django, FastAPI 활용 가능자", 67, 12, now(), now(), 18, 2, 6),
("핀테크 서비스 개발자 채용", "금융 데이터 처리 경험 필수", 105, 22, now(), now(), 20, 2, 2),
("웹 서비스 기획자 모집", "IT 서비스 기획 경험자 구인", 82, 15, now(), now(), 9, 2, 8);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("부평 백엔드 부트캠프 모집", "2025년 상반기 부트캠프 개설!", 45, 6, now(), now(), 2, 2, 1),
("서울 프론트엔드 개발자 채용", "React 경험자를 찾습니다!", 78, 12, now(), now(), 4, 2, 3),
("데브옵스 엔지니어 채용", "AWS 및 Docker 경험 우대", 64, 10, now(), now(), 8, 2, 5),
("백엔드 주니어 개발자 모집", "Java Spring 경험자 환영!", 91, 14, now(), now(), 11, 2, 2),
("스타트업 iOS 개발자 채용", "Swift 경험자 모집", 55, 7, now(), now(), 6, 2, 8),
("데이터 사이언티스트 채용", "Python, ML 경험 필수", 102, 19, now(), now(), 10, 2, 6),
("인공지능 연구원 모집", "딥러닝 연구개발자 구인", 88, 17, now(), now(), 9, 2, 4),
("프리랜서 개발자 모집", "자율근무 가능한 개발자를 찾습니다.", 73, 11, now(), now(), 12, 2, 9),
("UI/UX 디자이너 구인", "Figma, Adobe XD 경험자 모집", 59, 8, now(), now(), 15, 2, 10),
("블록체인 개발자 채용", "스마트 컨트랙트 개발자 구함", 110, 23, now(), now(), 5, 2, 7),
("안드로이드 개발자 채용", "Kotlin/Java 개발자 모집", 84, 16, now(), now(), 3, 2, 11),
("풀스택 개발자 채용", "Node.js, React, AWS 활용 가능자", 77, 14, now(), now(), 14, 2, 12),
("대기업 IT 인턴 모집", "3개월 인턴 후 정규직 전환 가능", 96, 21, now(), now(), 7, 2, 1),
("데이터 엔지니어 채용", "BigQuery, Spark 경험 필수", 85, 18, now(), now(), 17, 2, 5),
("스타트업 CTO 채용", "초기 창업 멤버를 구합니다.", 113, 25, now(), now(), 13, 2, 4),
("웹 퍼블리셔 채용", "HTML, CSS, JavaScript 필수", 71, 13, now(), now(), 19, 2, 3),
("로봇 소프트웨어 엔지니어 모집", "ROS, C++ 개발자 구인", 99, 20, now(), now(), 16, 2, 7),
("AI 스타트업 백엔드 개발자 모집", "Django, FastAPI 활용 가능자", 67, 12, now(), now(), 18, 2, 6),
("핀테크 서비스 개발자 채용", "금융 데이터 처리 경험 필수", 105, 22, now(), now(), 20, 2, 2),
("웹 서비스 기획자 모집", "IT 서비스 기획 경험자 구인", 82, 15, now(), now(), 9, 2, 8);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("부평 백엔드 부트캠프 모집", "2025년 상반기 부트캠프 개설!", 45, 6, now(), now(), 2, 2, 1),
("서울 프론트엔드 개발자 채용", "React 경험자를 찾습니다!", 78, 12, now(), now(), 4, 2, 3),
("데브옵스 엔지니어 채용", "AWS 및 Docker 경험 우대", 64, 10, now(), now(), 8, 2, 5),
("백엔드 주니어 개발자 모집", "Java Spring 경험자 환영!", 91, 14, now(), now(), 11, 2, 2),
("스타트업 iOS 개발자 채용", "Swift 경험자 모집", 55, 7, now(), now(), 6, 2, 8),
("데이터 사이언티스트 채용", "Python, ML 경험 필수", 102, 19, now(), now(), 10, 2, 6),
("인공지능 연구원 모집", "딥러닝 연구개발자 구인", 88, 17, now(), now(), 9, 2, 4),
("프리랜서 개발자 모집", "자율근무 가능한 개발자를 찾습니다.", 73, 11, now(), now(), 12, 2, 9),
("UI/UX 디자이너 구인", "Figma, Adobe XD 경험자 모집", 59, 8, now(), now(), 15, 2, 10),
("블록체인 개발자 채용", "스마트 컨트랙트 개발자 구함", 110, 23, now(), now(), 5, 2, 7),
("안드로이드 개발자 채용", "Kotlin/Java 개발자 모집", 84, 16, now(), now(), 3, 2, 11),
("풀스택 개발자 채용", "Node.js, React, AWS 활용 가능자", 77, 14, now(), now(), 14, 2, 12),
("대기업 IT 인턴 모집", "3개월 인턴 후 정규직 전환 가능", 96, 21, now(), now(), 7, 2, 1),
("데이터 엔지니어 채용", "BigQuery, Spark 경험 필수", 85, 18, now(), now(), 17, 2, 5),
("스타트업 CTO 채용", "초기 창업 멤버를 구합니다.", 113, 25, now(), now(), 13, 2, 4),
("웹 퍼블리셔 채용", "HTML, CSS, JavaScript 필수", 71, 13, now(), now(), 19, 2, 3),
("로봇 소프트웨어 엔지니어 모집", "ROS, C++ 개발자 구인", 99, 20, now(), now(), 16, 2, 7),
("AI 스타트업 백엔드 개발자 모집", "Django, FastAPI 활용 가능자", 67, 12, now(), now(), 18, 2, 6),
("핀테크 서비스 개발자 채용", "금융 데이터 처리 경험 필수", 105, 22, now(), now(), 20, 2, 2),
("웹 서비스 기획자 모집", "IT 서비스 기획 경험자 구인", 82, 15, now(), now(), 9, 2, 8);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("부평 백엔드 부트캠프 모집", "2025년 상반기 부트캠프 개설!", 45, 6, now(), now(), 2, 2, 1),
("서울 프론트엔드 개발자 채용", "React 경험자를 찾습니다!", 78, 12, now(), now(), 4, 2, 3),
("데브옵스 엔지니어 채용", "AWS 및 Docker 경험 우대", 64, 10, now(), now(), 8, 2, 5),
("백엔드 주니어 개발자 모집", "Java Spring 경험자 환영!", 91, 14, now(), now(), 11, 2, 2),
("스타트업 iOS 개발자 채용", "Swift 경험자 모집", 55, 7, now(), now(), 6, 2, 8),
("데이터 사이언티스트 채용", "Python, ML 경험 필수", 102, 19, now(), now(), 10, 2, 6),
("인공지능 연구원 모집", "딥러닝 연구개발자 구인", 88, 17, now(), now(), 9, 2, 4),
("프리랜서 개발자 모집", "자율근무 가능한 개발자를 찾습니다.", 73, 11, now(), now(), 12, 2, 9),
("UI/UX 디자이너 구인", "Figma, Adobe XD 경험자 모집", 59, 8, now(), now(), 15, 2, 10),
("블록체인 개발자 채용", "스마트 컨트랙트 개발자 구함", 110, 23, now(), now(), 5, 2, 7),
("안드로이드 개발자 채용", "Kotlin/Java 개발자 모집", 84, 16, now(), now(), 3, 2, 11),
("풀스택 개발자 채용", "Node.js, React, AWS 활용 가능자", 77, 14, now(), now(), 14, 2, 12),
("대기업 IT 인턴 모집", "3개월 인턴 후 정규직 전환 가능", 96, 21, now(), now(), 7, 2, 1),
("데이터 엔지니어 채용", "BigQuery, Spark 경험 필수", 85, 18, now(), now(), 17, 2, 5),
("스타트업 CTO 채용", "초기 창업 멤버를 구합니다.", 113, 25, now(), now(), 13, 2, 4),
("웹 퍼블리셔 채용", "HTML, CSS, JavaScript 필수", 71, 13, now(), now(), 19, 2, 3),
("로봇 소프트웨어 엔지니어 모집", "ROS, C++ 개발자 구인", 99, 20, now(), now(), 16, 2, 7),
("AI 스타트업 백엔드 개발자 모집", "Django, FastAPI 활용 가능자", 67, 12, now(), now(), 18, 2, 6),
("핀테크 서비스 개발자 채용", "금융 데이터 처리 경험 필수", 105, 22, now(), now(), 20, 2, 2),
("웹 서비스 기획자 모집", "IT 서비스 기획 경험자 구인", 82, 15, now(), now(), 9, 2, 8);

INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("스프링부트 입문 가이드", "start.spring.io 접속", 687, 31, now(), now(), 3, 3, 1),
("JPA 기본 개념", "Spring Data JPA 설정 및 활용", 512, 25, now(), now(), 7, 3, 2),
("스프링 시큐리티 설정", "OAuth2와 JWT 기반 인증", 399, 18, now(), now(), 5, 3, 3),
("리액트 상태관리", "Redux와 Context API 비교", 420, 22, now(), now(), 12, 3, 4),
("Node.js Express 서버 구축", "기본적인 REST API 만들기", 680, 34, now(), now(), 8, 3, 5),
("MySQL 조인 이해하기", "INNER JOIN vs LEFT JOIN", 301, 14, now(), now(), 10, 3, 6),
("Docker 컨테이너 활용법", "Dockerfile과 Compose 설정", 754, 37, now(), now(), 15, 3, 7),
("Git 브랜치 전략", "Git Flow와 GitHub Flow 비교", 589, 29, now(), now(), 6, 3, 8),
("Vue.js 기본 문법", "Vue 인스턴스와 컴포넌트", 450, 21, now(), now(), 17, 3, 9),
("Kubernetes 클러스터 구축", "Minikube와 Helm 사용법", 820, 41, now(), now(), 9, 3, 10),
("Python Flask API 만들기", "간단한 CRUD API 개발", 512, 23, now(), now(), 4, 3, 11),
("Django ORM 활용", "QuerySet과 Model 필드", 472, 20, now(), now(), 18, 3, 12),
("타입스크립트 기본 문법", "인터페이스와 제네릭 활용", 399, 15, now(), now(), 19, 3, 3),
("Kafka 메시지 큐", "Producer & Consumer 개념", 650, 32, now(), now(), 14, 3, 6),
("Redis 캐싱 기초", "세션 스토리지와 Key-Value DB", 530, 26, now(), now(), 20, 3, 5),
("웹소켓을 이용한 채팅 서비스", "Spring WebSocket 적용", 702, 33, now(), now(), 16, 3, 2),
("RabbitMQ 메시지 큐 사용법", "Queue와 Exchange 개념", 678, 30, now(), now(), 13, 3, 4),
("MongoDB 기본 CRUD", "몽고DB Atlas 연결 방법", 489, 22, now(), now(), 11, 3, 7),
("CI/CD 파이프라인 구축", "Jenkins와 GitHub Actions", 840, 44, now(), now(), 2, 3, 1),
("React와 Next.js 차이", "SSR과 CSR의 개념", 477, 20, now(), now(), 1, 3, 9);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("스프링부트 입문 가이드", "start.spring.io 접속", 687, 31, now(), now(), 3, 3, 1),
("JPA 기본 개념", "Spring Data JPA 설정 및 활용", 512, 25, now(), now(), 7, 3, 2),
("스프링 시큐리티 설정", "OAuth2와 JWT 기반 인증", 399, 18, now(), now(), 5, 3, 3),
("리액트 상태관리", "Redux와 Context API 비교", 420, 22, now(), now(), 12, 3, 4),
("Node.js Express 서버 구축", "기본적인 REST API 만들기", 680, 34, now(), now(), 8, 3, 5),
("MySQL 조인 이해하기", "INNER JOIN vs LEFT JOIN", 301, 14, now(), now(), 10, 3, 6),
("Docker 컨테이너 활용법", "Dockerfile과 Compose 설정", 754, 37, now(), now(), 15, 3, 7),
("Git 브랜치 전략", "Git Flow와 GitHub Flow 비교", 589, 29, now(), now(), 6, 3, 8),
("Vue.js 기본 문법", "Vue 인스턴스와 컴포넌트", 450, 21, now(), now(), 17, 3, 9),
("Kubernetes 클러스터 구축", "Minikube와 Helm 사용법", 820, 41, now(), now(), 9, 3, 10),
("Python Flask API 만들기", "간단한 CRUD API 개발", 512, 23, now(), now(), 4, 3, 11),
("Django ORM 활용", "QuerySet과 Model 필드", 472, 20, now(), now(), 18, 3, 12),
("타입스크립트 기본 문법", "인터페이스와 제네릭 활용", 399, 15, now(), now(), 19, 3, 3),
("Kafka 메시지 큐", "Producer & Consumer 개념", 650, 32, now(), now(), 14, 3, 6),
("Redis 캐싱 기초", "세션 스토리지와 Key-Value DB", 530, 26, now(), now(), 20, 3, 5),
("웹소켓을 이용한 채팅 서비스", "Spring WebSocket 적용", 702, 33, now(), now(), 16, 3, 2),
("RabbitMQ 메시지 큐 사용법", "Queue와 Exchange 개념", 678, 30, now(), now(), 13, 3, 4),
("MongoDB 기본 CRUD", "몽고DB Atlas 연결 방법", 489, 22, now(), now(), 11, 3, 7),
("CI/CD 파이프라인 구축", "Jenkins와 GitHub Actions", 840, 44, now(), now(), 2, 3, 1),
("React와 Next.js 차이", "SSR과 CSR의 개념", 477, 20, now(), now(), 1, 3, 9);
INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("스프링부트 입문 가이드", "start.spring.io 접속", 687, 31, now(), now(), 3, 3, 1),
("JPA 기본 개념", "Spring Data JPA 설정 및 활용", 512, 25, now(), now(), 7, 3, 2),
("스프링 시큐리티 설정", "OAuth2와 JWT 기반 인증", 399, 18, now(), now(), 5, 3, 3),
("리액트 상태관리", "Redux와 Context API 비교", 420, 22, now(), now(), 12, 3, 4),
("Node.js Express 서버 구축", "기본적인 REST API 만들기", 680, 34, now(), now(), 8, 3, 5),
("MySQL 조인 이해하기", "INNER JOIN vs LEFT JOIN", 301, 14, now(), now(), 10, 3, 6),
("Docker 컨테이너 활용법", "Dockerfile과 Compose 설정", 754, 37, now(), now(), 15, 3, 7),
("Git 브랜치 전략", "Git Flow와 GitHub Flow 비교", 589, 29, now(), now(), 6, 3, 8),
("Vue.js 기본 문법", "Vue 인스턴스와 컴포넌트", 450, 21, now(), now(), 17, 3, 9),
("Kubernetes 클러스터 구축", "Minikube와 Helm 사용법", 820, 41, now(), now(), 9, 3, 10),
("Python Flask API 만들기", "간단한 CRUD API 개발", 512, 23, now(), now(), 4, 3, 11),
("Django ORM 활용", "QuerySet과 Model 필드", 472, 20, now(), now(), 18, 3, 12),
("타입스크립트 기본 문법", "인터페이스와 제네릭 활용", 399, 15, now(), now(), 19, 3, 3),
("Kafka 메시지 큐", "Producer & Consumer 개념", 650, 32, now(), now(), 14, 3, 6),
("Redis 캐싱 기초", "세션 스토리지와 Key-Value DB", 530, 26, now(), now(), 20, 3, 5),
("웹소켓을 이용한 채팅 서비스", "Spring WebSocket 적용", 702, 33, now(), now(), 16, 3, 2),
("RabbitMQ 메시지 큐 사용법", "Queue와 Exchange 개념", 678, 30, now(), now(), 13, 3, 4),
("MongoDB 기본 CRUD", "몽고DB Atlas 연결 방법", 489, 22, now(), now(), 11, 3, 7),
("CI/CD 파이프라인 구축", "Jenkins와 GitHub Actions", 840, 44, now(), now(), 2, 3, 1),
("React와 Next.js 차이", "SSR과 CSR의 개념", 477, 20, now(), now(), 1, 3, 9);

INSERT INTO board (btitle, bcontent, bview, blike, cdate, udate, mno, cno, lno) VALUES
("가위바위보 게임", "가위바위보 프로그램을 만드시오", 56, 21, now(), now(), 1, 4, 1),
("숫자의 합", "N개의 숫자가 주어졌을 때, 그 합을 구하시오", 78, 32, now(), now(), 2, 4, 1),
("문자열 뒤집기", "주어진 문자열을 뒤집는 함수를 작성하시오", 90, 43, now(), now(), 3, 4, 2),
("소수 판별", "입력된 수가 소수인지 판별하는 프로그램을 작성하시오", 65, 20, now(), now(), 4, 4, 3),
("팩토리얼 계산", "재귀를 이용하여 n!을 계산하는 함수를 구현하시오", 82, 25, now(), now(), 5, 4, 4),
("최대공약수와 최소공배수", "두 정수의 최대공약수와 최소공배수를 구하시오", 99, 30, now(), now(), 4, 4, 1),
("피보나치 수열", "재귀와 DP를 이용하여 피보나치 수열을 계산하시오", 70, 15, now(), now(), 3, 4, 2),
("이진 탐색", "오름차순으로 정렬된 배열에서 특정 값을 찾는 이진 탐색 함수를 작성하시오", 88, 41, now(), now(), 2, 4, 3),
("괄호 검사", "주어진 문자열에서 괄호의 짝이 맞는지 검사하는 프로그램을 작성하시오", 55, 14, now(), now(), 1, 4, 4),
("DFS와 BFS", "그래프 탐색 알고리즘인 DFS와 BFS를 구현하시오", 101, 50, now(), now(), 2, 4, 1),
("문자열 압축", "연속된 문자들을 압축하여 표현하는 함수를 작성하시오", 68, 19, now(), now(), 3, 4, 2),
("N-Queen 문제", "N*N 체스판에서 N개의 퀸을 배치하는 프로그램을 작성하시오", 85, 37, now(), now(), 4, 4, 3),
("정렬 알고리즘 구현", "버블 정렬, 퀵 정렬, 병합 정렬을 구현하시오", 92, 29, now(), now(), 5, 4, 4),
("최단 경로 알고리즘", "다익스트라 알고리즘을 구현하시오", 75, 18, now(), now(), 4, 4, 1),
("연속된 숫자의 합", "연속된 숫자의 합이 특정 값이 되는 경우를 찾으시오", 81, 22, now(), now(), 15, 4, 2),
("2차원 배열 회전", "N*N 배열을 시계 방향으로 90도 회전시키는 함수를 작성하시오", 96, 28, now(), now(), 16, 4, 3),
("트리의 지름", "트리의 최대 지름을 구하는 알고리즘을 구현하시오", 100, 33, now(), now(), 17, 4, 4),
("올바른 괄호 문자열", "주어진 문자열이 올바른 괄호 문자열인지 판별하시오", 58, 17, now(), now(), 18, 4, 1),
("제곱근 계산", "제곱근을 근사적으로 계산하는 함수를 작성하시오", 77, 24, now(), now(), 19, 4, 2),
("비밀번호 검증", "비밀번호가 강력한지 검증하는 함수를 작성하시오", 87, 31, now(), now(), 20, 4, 3),
("괄호 문자열 생성", "주어진 길이만큼 올바른 괄호 문자열을 생성하는 프로그램을 작성하시오", 63, 1, now(), now(), 7, 4, 4),
("조합과 순열", "주어진 숫자에서 특정 개수의 조합과 순열을 구하시오", 90, 27, now(), now(), 2, 4, 1),
("게임 맵 최단거리", "BFS를 이용하여 최단 거리를 찾는 알고리즘을 작성하시오", 105, 42, now(), now(), 3, 4, 2),
("행렬 곱셈", "두 개의 행렬을 곱하는 프로그램을 작성하시오", 73, 16, now(), now(), 4, 4, 3),
("K번째 수", "정렬된 배열에서 K번째로 작은 수를 찾는 프로그램을 작성하시오", 82, 30, now(), now(), 5, 4, 4),
("회문 검사", "주어진 문자열이 회문인지 판별하는 함수를 작성하시오", 95, 39, now(), now(), 6, 4, 1),
("단어 빈도수 세기", "문장에서 각 단어가 몇 번 나오는지 세는 프로그램을 작성하시오", 78, 23, now(), now(), 7, 4, 2),
("LRU 캐시 구현", "LRU 캐시 알고리즘을 구현하시오", 110, 47, now(), now(), 8, 4, 3),
("이진 트리 직렬화", "이진 트리를 직렬화하고 역직렬화하는 함수를 작성하시오", 99, 34, now(), now(), 9, 4, 4),
("최대 연속 부분합", "배열에서 연속된 숫자들의 최대 합을 찾는 프로그램을 작성하시오", 112, 55, now(), now(), 5, 4, 1),
("RGB 거리", "DP를 이용하여 집을 칠하는 최소 비용을 계산하시오", 88, 28, now(), now(), 1, 4, 2),
("전화번호 목록", "전화번호 목록이 일관성이 있는지 확인하는 알고리즘을 구현하시오", 91, 35, now(), now(), 2, 4, 3),
("큰 수 만들기", "주어진 숫자에서 특정 개수의 숫자를 제거하여 가장 큰 수를 만들기", 108, 45, now(), now(), 3, 4, 4),
("부분 수열 합", "주어진 배열의 부분 수열 중 특정 합을 만드는 경우를 찾으시오", 79, 26, now(), now(), 4, 4, 1),
("암호 해독", "문자열을 특정 규칙에 따라 해독하는 프로그램을 작성하시오", 86, 33, now(), now(), 5, 4, 2);





insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("좋은 정보 감사합니다!", 12, now(), now(), 4, 1);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("부트캠프 참여 후기 궁금합니다.", 5, now(), now(), 1, 2);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("에러가 왜 뜨냐", 26, now(), now(), 2, 4);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("이직하고 싶습니다..", 33, now(), now(), 4, 2);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("자격증은 어떻게 준비하셨나요?", 8, now(), now(), 3, 1);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("클라우드 컴퓨팅은 뭔가요?", 11, now(), now(), 5, 125);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("저는 활용 잘하고 있습니다", 5, now(), now(), 1, 125);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("이력서 접수 완료", 20, now(), now(), 4, 205);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("저도 접수 했습니다.", 3, now(), now(), 1, 205);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("React는 공부했는데, node는 아직 잘 모르겠네요ㅠㅠ", 27, now(), now(), 2, 265);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("차이점 설명해주실 수 있으실까요??", 110, now(), now(), 5, 265);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("와, 이거 저도 찾고 있었어요", 7, now(), now(), 1, 300);
insert into reply (rcontent, relike, cdate, udate, mno, bno) values ("다들 어떻게 푸시는 걸까요..", 18, now(), now(), 3, 300);

INSERT INTO message (receivermno, sendermno, mecontent, metitle, deleted_by_receiver, deleted_by_sender)VALUE(2, 1, '안녕하세요! 오랜만이에요.', '인사', 0, 0);
INSERT INTO message (receivermno, sendermno, mecontent, metitle, deleted_by_receiver, deleted_by_sender)VALUE(3, 1, '이번 프로젝트 관련해서 논의가 필요합니다.', '프로젝트 논의', 0, 0);
INSERT INTO message (receivermno, sendermno, mecontent, metitle, deleted_by_receiver, deleted_by_sender)VALUE(1, 2, '네, 언제 시간 괜찮으세요?', '답장', 0, 0);
INSERT INTO message (receivermno, sendermno, mecontent, metitle, deleted_by_receiver, deleted_by_sender)VALUE(4, 3, '파일을 확인해 주세요.', '파일 전달', 0, 0);
INSERT INTO message (receivermno, sendermno, mecontent, metitle, deleted_by_receiver, deleted_by_sender)VALUE(2, 4, '내일 회의 참석 가능하신가요?', '회의 참석 여부', 0, 0);