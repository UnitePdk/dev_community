package devcom.model.repository;

import devcom.model.entity.MemberEntity;
import devcom.model.entity.ReplyEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface RelikeRepository extends JpaRepository<ReplyEntity, Integer> {

    // 댓글에 회원이 좋아요를 눌렀는지 확인
    boolean existsReplyAndMember(ReplyEntity replyEntity, MemberEntity memberEntity);

    // 좋아요 취소
    @Modifying
    @Transactional
    void deleteReplyAndMember(ReplyEntity replyEntity, MemberEntity memberEntity);

}
