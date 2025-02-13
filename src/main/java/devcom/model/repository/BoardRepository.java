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

    // Page<BoardEntity> findByLanguageEntity_Lno(int lno, Pageable pageable);
//    @Query(value = "select * from board where lno = :lno", nativeQuery = true)
//    List<BoardEntity> findByQuery1(int lno);
//
//    @Query(value = "select * from board where btitle like %:keyword%", nativeQuery = true)
//    List<BoardEntity> findByQuery2(String keyword);
//
//    @Query(value = "select * from board where lno = :lno and btitle like %:keyword%", nativeQuery = true)
//    List<BoardEntity> findByQuery3(int lno, String keyword);
//
//    @Query(value = "select * from board where if(:key = 'btitle', btitle like %:keyword%, bcontent like %:keyword%)", nativeQuery = true)
//    List<BoardEntity> findByQuery4(String key, String keyword);

    @Query(value="select * from board where cno = :cno and lno = :lno and if(:keyword = '', true, " +
        "if(:key = 'btitle', btitle like %:keyword%, if(:key = 'bcontent', bcontent like %:keyword%, true)))", nativeQuery = true)
    Page<BoardEntity> findBySearch(int cno, int lno, String key, String keyword, Pageable pageable);
}
