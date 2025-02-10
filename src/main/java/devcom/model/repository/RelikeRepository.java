package devcom.model.repository;

import devcom.model.entity.ReplyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelikeRepository extends JpaRepository<ReplyEntity, Long> {

    // 중복 체크
    boolean existsReplyAndMember(Long replyId, Long memberId);

    // 좋아요 취소
    void deleteReplyAndMember(Long replyId, Long memberId);

}
