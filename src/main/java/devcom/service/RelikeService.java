package devcom.service;

import devcom.model.dto.MemberDto;
import devcom.model.dto.RelikeDto;
import devcom.model.entity.MemberEntity;
import devcom.model.entity.RelikeEntity;
import devcom.model.entity.ReplyEntity;
import devcom.model.repository.MemberRepository;
import devcom.model.repository.RelikeRepository;
import devcom.model.repository.ReplyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.Map;
import java.util.Optional;

@Service
public class RelikeService {

    @Autowired private RelikeRepository relikeRepository;
    @Autowired private MemberRepository memberRepository;
    @Autowired private ReplyRepository replyRepository;
    @Autowired private MemberService memberService;

    // 특정 댓글 좋아요
    public boolean addLike(RelikeDto relikeDto) {

        // 현재 로그인된 회원 정보 가져오기
        MemberDto memberDto = memberService.info();
        System.out.println("로그인된 회원 정보 : " + memberDto);
        if (memberDto == null) return false;

        // 회원 엔티티, 댓글 엔티티 조회
        MemberEntity memberEntity = memberRepository.findById(memberDto.getMno()).orElse(null);
        ReplyEntity replyEntity = replyRepository.findById(relikeDto.getRno()).orElse(null);
        System.out.println("회원 엔티티 : " + memberEntity);
        System.out.println("댓글 엔티티 : " + replyEntity);
        if (memberEntity == null || replyEntity == null) return false;

        // 이미 좋아요 눌렀는지 확인
        if (relikeRepository.existsByMemberEntityAndReplyEntity(memberEntity, replyEntity)) {
            return false;   // 좋아요 중복 방지
        }

        // 좋아요 추가
        RelikeEntity relikeEntity = new RelikeEntity();
        relikeEntity.setMemberEntity(memberEntity);
        relikeEntity.setReplyEntity(replyEntity);
        relikeRepository.save(relikeEntity);
        System.out.println("저장된 좋아요 엔티티 : " + relikeEntity);

        return true;

    }


    // 특정 댓글 좋아요 삭제
    public boolean deleteLike(RelikeDto relikeDto) {

        // 현재 로그인된 회원 정보 가져오기
        MemberDto memberDto = memberService.info();
        if (memberDto == null) return false;

        // 회원 엔티티, 댓글 엔티티 조회
        Optional<MemberEntity> memberEntityOpt = memberRepository.findById(memberDto.getMno());
        Optional<ReplyEntity> replyEntityOpt = replyRepository.findById(relikeDto.getRno());

        if (!memberEntityOpt.isEmpty() || !replyEntityOpt.isEmpty()) {
            return false;   // 하나라도 없으면 false 반환
        }

        // 존재한다면, 회원&댓글 엔티티 가져오기
        MemberEntity memberEntity = memberEntityOpt.get();
        ReplyEntity replyEntity = replyEntityOpt.get();

        // 좋아요가 존재하는지 확인 후 삭제
        if (relikeRepository.existsByMemberEntityAndReplyEntity(memberEntity, replyEntity)) {
            relikeRepository.deleteByMemberEntityAndReplyEntity(memberEntity, replyEntity);
            return true;
        }
        return false;

    }
}