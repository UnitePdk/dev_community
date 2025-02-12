package devcom.model.repository;

import devcom.model.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {
    // 로그인 추상 메소드
    boolean existsByMidAndMpwd(String mid, String mpwd);

    // 아이디로 엔티티 조회
    MemberEntity findByMid(String mid);
}
