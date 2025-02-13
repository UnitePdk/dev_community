package devcom.service;

import devcom.model.dto.MemberDto;
import devcom.model.dto.ReplyDto;
import devcom.model.entity.BoardEntity;
import devcom.model.entity.MemberEntity;
import devcom.model.entity.ReplyEntity;
import devcom.model.repository.BoardRepository;
import devcom.model.repository.MemberRepository;
import devcom.model.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        // replyDto --> entity 변환
        ReplyEntity replyEntity = replyDto.toEntity();

        // 로그인된 회원 정보로 회원 엔티티 조회
        MemberEntity memberEntity = memberRepository.findById(memberDto.getMno()).orElse(null);
        System.out.println("회원 엔티티 : " + memberEntity);
        if (memberEntity == null) {
            return false;   // 회원이 존재하지 않으면 실패
        }
        replyEntity.setMemberEntity(memberEntity);

        // 입력한 bno를 조회해서 게시판 엔티티를 가져와서 대입
        BoardEntity boardEntity = boardRepository.findById(replyDto.getRno()).orElse(null);
        System.out.println("게시글 엔티티 : " + boardEntity);
        if (boardEntity == null) {
            return false;   // 게시판이 존재하지 않으면 실패
        }
        replyEntity.setBoardEntity(boardEntity);

        // DB에 저장
        ReplyEntity saveReplyEntity = replyRepository.save(replyEntity);

        // 결과 반환
        return saveReplyEntity.getRno() > 0;
    }

    // 댓글 수정
    public boolean replyUpdate(ReplyDto replyDto) {
        return false;
    }

    // 댓글 삭제
    public boolean replyDelete(int rno) {
        return false;
    }

}
