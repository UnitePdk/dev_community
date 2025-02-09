package devcom.model.repository;

import devcom.model.entity.MemberEntity;
import devcom.model.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
    List<MessageEntity> findByReceiver(MemberEntity memberEntity);
    List<MessageEntity> findBySender(MemberEntity memberEntity);
}
