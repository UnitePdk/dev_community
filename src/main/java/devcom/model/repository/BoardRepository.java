package devcom.model.repository;

import devcom.model.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    @Query(value="select * from board where cno = :cno and lno = :lno and if(:keyword = '', true, " +
        "if(:key = 'btitle', btitle like %:keyword%, if(:key = 'bcontent', bcontent like %:keyword%, true)))", nativeQuery = true)
    Page<BoardEntity> findBySearch(int cno, int lno, String key, String keyword, Pageable pageable);

    @Query(value="select * from board where cno = :cno and if(:keyword = '', true, " +
            "if(:key = 'btitle', btitle like %:keyword%, if(:key = 'bcontent', bcontent like %:keyword%, true)))", nativeQuery = true)
    Page<BoardEntity> findBySearch(int cno, String key, String keyword, Pageable pageable);
}
