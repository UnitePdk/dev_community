package devcom.model.repository;

import devcom.model.entity.MemberEntity;
import devcom.model.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
    // 수신자로 메세지 찾기
    List<MessageEntity> findByReceivermno(MemberEntity receivermno);
    // 송신자로 메세지 찾기
    List<MessageEntity> findBySendermno(MemberEntity sendermno);
    // 삭제되지 않은 메세지 찾기
    List<MessageEntity> findBySendermnoAndDeletedBySenderFalseAndDeletedByReceiverFalse(MemberEntity sendermno);
    List<MessageEntity> findByReceivermnoAndDeletedBySenderFalseAndDeletedByReceiverFalse(MemberEntity receivermno);

}
