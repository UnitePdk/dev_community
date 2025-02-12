package devcom.service;

import devcom.model.dto.BoardDto;
import devcom.model.dto.MemberDto;
import devcom.model.entity.BoardEntity;
import devcom.model.entity.CategoryEntity;
import devcom.model.entity.MemberEntity;
import devcom.model.entity.ReplyEntity;
import devcom.model.repository.BoardRepository;
import devcom.model.repository.CategoryRepository;
import devcom.model.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    CategoryRepository categoryRepository;

    // 게시물 목록 조회 - 질문
    public List<BoardDto> boardAsk() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        // 질문 카테고리만 dto로 변환
        List<BoardDto> boardDtoList = new ArrayList<>();
        boardEntityList.forEach(entity -> {
            if (entity.getCategoryEntity().getCno() == 1) {
                BoardDto boardDto = entity.toDto();
                boardDtoList.add(boardDto);
            }
        });

        return boardDtoList;
    }

    // 게시물 목록 조회 - 대외/홍보
    public List<BoardDto> boardAdvertise() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        // 대외/홍보 카테고리만 dto로 변환
        List<BoardDto> boardDtoList = new ArrayList<>();
        boardEntityList.forEach(entity -> {
            if (entity.getCategoryEntity().getCno() == 2) {
                BoardDto boardDto = entity.toDto();
                boardDtoList.add(boardDto);
            }
        });

        return boardDtoList;
    }

    // 게시물 목록 조회 - 튜토리얼
    public List<BoardDto> boardTutorial() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        // 튜토리얼 카테고리만 dto로 변환
        List<BoardDto> boardDtoList = new ArrayList<>();
        boardEntityList.forEach(entity -> {
            if (entity.getCategoryEntity().getCno() == 3) {
                BoardDto boardDto = entity.toDto();
                boardDtoList.add(boardDto);
            }
        });

        return boardDtoList;
    }

    // 게시물 목록 조회 - 문제은행
    public List<BoardDto> boardQuestion() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        // 문제은행 카테고리만 dto로 변환
        List<BoardDto> boardDtoList = new ArrayList<>();
        boardEntityList.forEach(entity -> {
            if (entity.getCategoryEntity().getCno() == 4) {
                BoardDto boardDto = entity.toDto();
                boardDtoList.add(boardDto);
            }
        });

        return boardDtoList;
    }

    // // 게시물 목록 조회 - 전체
    public List<BoardDto> boardFindAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();

        // 모든 엔티티를 dto로 변환
        List<BoardDto> boardDtoList = new ArrayList<>();
        boardEntityList.forEach(entity -> {
            BoardDto boardDto = entity.toDto();
            boardDtoList.add(boardDto);
        });

        return boardDtoList;
    }

    // 게시물 쓰기
    public boolean boardWrite(BoardDto boardDto) {
        // boardDto 를 entity 로 변환
        BoardEntity boardEntity = boardDto.toEntity();

        // 임시로 mno에 임의값 대입
        MemberEntity loginEntity = memberRepository.findById( 1 ).get();
        boardEntity.setMemberEntity(loginEntity);

        // 입력한 cno를 조회해서 카테고리 엔티티를 가져와서 대입
        CategoryEntity categoryEntity = categoryRepository.findById( boardDto.getCno() ).get();
        boardEntity.setCategoryEntity( categoryEntity );
        
        // DB에 저장
        BoardEntity saveBoardEntity = boardRepository.save( boardEntity );

        // 결과 반환
        return saveBoardEntity.getBno() > 0;
    }

//    // 게시물 개별 조회
//    public BoardDto boardView(int index) {
//        // (1) 조회할 특정 게시물의 번호를 매개변수로 받는다.  int bno
//        // (2) 조회할 특정 게시물의 번호의 엔티티를 조회한다. .findById() 메소드는 반환타입이 Optional 이다. 조회된 엔티티 여부 메소드 제공한다. .isPresent()
//        Optional< BoardEntity > optional = boardRepository.findById( index );
//        // (3) 만약에 조회된 엔티티가 있으면 true / false
//        if( optional.isPresent() ){
//            // (4) optional 에서 엔티티 꺼내기. .get()
//            BoardEntity boardEntity = optional.get();
//            // (5) 엔티티를 dto 변환
//            BoardDto boardDto = boardEntity.toDto();
//            // * 현재 게시물의 댓글 리스트 조회
//            // 1. 모든 게시물 댓글 조회한다.
//            List<ReplyEntity> replyEntityList = replyRepository.findAll();
//            // 2. 모든 댓글을 DTO/MAP 로 변환한 객체들을 저장할 리스트 선언 . --> ReplyDto 대신 MAP 컬렉션 이용한 방법
//            // List 컬렉션 : [ 값, 값 , 값 ]   vs  Map 컬렉션 : { key : value , key : value , key : value }
//            List<Map<String, String> > replylist = new ArrayList<>();
//            // 3. 엔티티를 MAP 로 변환 하기 위한 엔티티 리스트를 반복문
//            replyEntityList.forEach( (reply) ->{
//                // * 만약에 현재 조회중인 게시물번호 와 댓글리스트내 반복중인 댓글의 게시물번호 와 같다면
//                if( reply.getBoardEntity().getBno() == index ){
//                    // 4. map 객체 선언
//                    Map<String , String > map = new HashMap<>();
//                    // 5. map 객체에 하나씩 key:value (엔트리) 으로 저장한다.
//                    map.put( "rno" , reply.getRno()+"" );       // 숫자타입 +"" =>문자타입 변환
//                    map.put( "rcontent" , reply.getRcontent() );
//                    map.put( "cdate" , reply.getCdate().toLocalDate().toString() ); // 날짜와시간 중에 날짜만 추출
//                    map.put( "mid" , reply.getMemberEntity().getMid() ); // 댓글 작성자 아이디
//                    map.put( "mimg" , reply.getMemberEntity().getMimg() ); // 댓글 작성자 프로필
//                    // 6. map를 리스트에 담는다.
//                    replylist.add( map );
//                }
//            });
//            // 7. 반복문 종료된 후 boardDto에 댓글리스트 담기.
//            boardDto.setReplylist( replylist );
//            // (6) dto 결과 반환
//            return boardDto;
//        }
//        return null; // 조회 결과 엔티티가 없으면 null 반환
//    }

    // 게시물 수정
    public boolean boardUpdate(BoardDto boardDto) {
        return false;
    }

    // 게시물 삭제
    public boolean boardDelete(int index) {
        return false;
    }
}
