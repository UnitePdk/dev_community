package devcom.model.repository;

import devcom.model.entity.MemberEntity;
import devcom.model.entity.RelikeEntity;
import devcom.model.entity.ReplyEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface RelikeRepository extends JpaRepository<RelikeEntity, Integer> {

    // 특정 회원이 특정 댓글을 좋아요 눌렀는지 확인하기
    boolean existsByMemberEntityAndReplyEntity(MemberEntity memberEntity, ReplyEntity replyEntity);

    // 특정 회원이 특정 댓글을 좋아요 삭제했는지 확인하기
    @Transactional
    void deleteByMemberEntityAndReplyEntity(MemberEntity memberEntity, ReplyEntity replyEntity);

}
