package devcom.service;

import devcom.model.dto.MemberDto;
import devcom.model.dto.ReplyDto;
import devcom.model.entity.BoardEntity;
import devcom.model.entity.MemberEntity;
import devcom.model.entity.ReplyEntity;
import devcom.model.repository.BoardRepository;
import devcom.model.repository.MemberRepository;
import devcom.model.repository.ReplyRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReplyService {

    @Autowired ReplyRepository replyRepository;
    @Autowired BoardRepository boardRepository;
    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    // 모든 게시물에 댓글 목록 조회
    public List<ReplyDto> replyFindAll() {
        List<ReplyEntity> replyEntityList = replyRepository.findAll();

        // 모든 엔티티 --> dto 변환
        List<ReplyDto> replyDtoList = new ArrayList<>();
        
        // 모든 댓글 엔티티를 반복문으로 조회
        replyEntityList.forEach(entity -> {
            ReplyDto replyDto = entity.toDto();
            replyDtoList.add(replyDto);
        });
        return replyDtoList;
    }

    // 특정 게시물에 댓글 쓰기
    public boolean replyWrite(ReplyDto replyDto) {

        // 현재 로그인된 회원번호 조회
        MemberDto memberDto = memberService.info();
        System.out.println("로그인 정보 : " + memberDto);
        if (memberDto == null) {
            return false;   // 로그인이 안된 경우 실패
        }

        // 회원 엔티티 조회
        MemberEntity memberEntity = memberRepository.findById(memberDto.getMno())
                .orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다."));
        System.out.println("회원 엔티티 : " + memberEntity);

        // 입력한 bno를 이용해 게시판 엔티티 조회
        Optional<BoardEntity> boardEntityOpt = boardRepository.findById(replyDto.getBno());
        if (boardEntityOpt.isEmpty()) {
            System.out.println("게시글을 찾을 수 없습니다.");
            return false;   // 게시글이 없으면 실패 처리
        }
        BoardEntity boardEntity = boardEntityOpt.get();

        // replyDto → replyEntity 변환 (MemberEntity, BoardEntity 포함)
        ReplyEntity replyEntity = replyDto.toEntity(memberEntity, boardEntity);
        System.out.println("변환된 댓글 엔티티 : " + replyEntity);

        // DB에 저장
        try {
            ReplyEntity saveReplyEntity = replyRepository.save(replyEntity);
            System.out.println("저장된 댓글 : " + saveReplyEntity);

            // 결과 반환
            return saveReplyEntity.getRno() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;  // 예외 발생 시 실패 처리
        }
    }

    // 댓글 수정
    public boolean replyUpdate(ReplyDto replyDto) {
        // 현재 로그인된 회원번호 조회
        MemberDto memberDto = memberService.info();
        System.out.println("로그인 정보 : " + memberDto);
        if (memberDto == null) {
            return false;   // 로그인이 안된 경우 실패
        }

        // 기존 댓글 찾기
        ReplyEntity replyEntity = replyRepository.findById(replyDto.getRno()).orElse(null);
        System.out.println("기존 댓글 존재 : " + replyEntity);
        if (replyEntity == null) {
            return false;   // 본인이 작성한 댓글인지 확인
        }

        // 댓글 작성자 확인
        if (replyEntity.getMemberEntity().getMno() != memberDto.getMno()) {
            System.out.println("본인이 작성한 댓글이 아닙니다.");
            return false;   // 본인이 작성한 댓글이 아닌 경우
        }

        // 댓글 수정
        replyEntity.setRcontent((replyDto.getRcontent()));

        // DB 저장
        replyRepository.save(replyEntity);
        
        return true;    // 수정 성공
    }

    // 댓글 삭제
    public boolean replyDelete(int rno) {

        // 현재 로그인된 회원번호 조회
        MemberDto memberDto = memberService.info();
        System.out.println("로그인 정보 : " + memberDto);
        if (memberDto == null) {
            return false;   // 로그인이 안된 경우 실패
        }

        // 기존 댓글 찾기
        ReplyEntity replyEntity = replyRepository.findById(rno).orElse(null);
        System.out.println("기존 댓글 존재 : " + replyEntity);
        if (replyEntity == null) {
            return false;   // 본인이 작성한 댓글인지 확인
        }

        // 댓글 작성자 = 로그인 사용자가 같은지
        if (replyEntity.getMemberEntity().getMno() != memberDto.getMno()) {
            System.out.println("본인이 작성한 댓글이 아닙니다.");
            return false;   // 본인이 작성한 댓글이 아니면 삭제불가
        }

        // 댓글 삭제
        replyRepository.delete(replyEntity);
        
        return true;    // 삭제 성공

    }

}
