package devcom.service;

import devcom.model.dto.BoardDto;
import devcom.model.dto.MemberDto;
import devcom.model.dto.PageDto;
import devcom.model.dto.ReplyDto;
import devcom.model.entity.BoardEntity;
import devcom.model.entity.CategoryEntity;
import devcom.model.entity.MemberEntity;
import devcom.model.entity.ReplyEntity;
import devcom.model.repository.BoardRepository;
import devcom.model.repository.CategoryRepository;
import devcom.model.repository.MemberRepository;
import devcom.model.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    @Autowired
    ReplyRepository replyRepository;

    // 게시물 목록 조회
    public PageDto boardFindAll(int cno, int page, int lno, String key, String keyword) {
        // 페이징
        Pageable pageable= PageRequest.of(page-1, 10, Sort.by(Sort.Direction.DESC, "bno"));
        Page<BoardEntity> boardEntityList;
        if(lno==-1){
            boardEntityList=boardRepository.findBySearch(cno, key, keyword, pageable);
        } else{
            boardEntityList=boardRepository.findBySearch(cno, lno, key, keyword, pageable);
        }

        // 문제은행 카테고리만 dto로 변환
        List<BoardDto> boardDtoList = new ArrayList<>();
        boardEntityList.forEach(entity -> {
                BoardDto boardDto = entity.toDto();
                boardDtoList.add(boardDto);
        });
        // 전체 페이지 수
        int totalPage=boardEntityList.getTotalPages();
        // 전체 게시글 수
        long totalCount=boardEntityList.getTotalElements();
        // 버튼 개수
        int btnSize=10;
        // 시작 번호
        int startBtn=((page-1)/btnSize)*btnSize+1;
        // 끝 번호
        int endBtn=startBtn+btnSize-1;
        if(endBtn>=totalPage) endBtn=totalPage;

        PageDto pageDto=PageDto.builder().page(page).totalpage(totalPage).totalcount(totalCount).startbtn(startBtn).endbtn(endBtn).data(boardDtoList).build();

        return pageDto;
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

    // 게시물 개별 조회
    public BoardDto boardView(int index) {
        // Optional로 변환하여 isPresent 검사한 후 dto로 변환
        Optional< BoardEntity > optional = boardRepository.findById( index );
        if( optional.isPresent() ){
            BoardEntity boardEntity = optional.get();
            BoardDto boardDto = boardEntity.toDto();

            // 모든 데이터 조회
            List<ReplyEntity> replyEntityList = replyRepository.findAll();
            List<ReplyDto> replyList = new ArrayList<>();
            replyEntityList.forEach( (reply) ->{
                if( reply.getBoardEntity().getBno() == index ){
                    ReplyDto replyDto = reply.toDto();
                    replyList.add( replyDto );
                }
            }); // foreach end
            boardDto.setReplyList( replyList );
            return boardDto;
        } // if end
        return null; // 조회 결과 엔티티가 없으면 null 반환
    }

    // 게시물 수정
    public boolean boardUpdate(BoardDto boardDto) {
        return false;
    }

    // 게시물 삭제
    public boolean boardDelete(int index) {
        return false;
    }
}
