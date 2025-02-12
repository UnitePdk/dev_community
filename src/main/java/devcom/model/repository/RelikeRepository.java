package devcom.model.repository;

import devcom.model.entity.MemberEntity;
import devcom.model.entity.RelikeEntity;
import devcom.model.entity.ReplyEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface RelikeRepository extends JpaRepository<RelikeEntity, Integer> {



}
