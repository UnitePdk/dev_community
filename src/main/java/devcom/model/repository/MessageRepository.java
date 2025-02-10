package devcom.model.repository;

import devcom.model.entity.MemberEntity;
import devcom.model.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
//    List<MessageEntity> findByReceiver(MemberEntity memberEntity);
//    List<MessageEntity> findBySender(MemberEntity memberEntity);
//

}
