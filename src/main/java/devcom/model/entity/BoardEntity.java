package devcom.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "board")
public class BoardEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno; // 게시글 번호

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String btitle; // 게시글 제목

    @Column(nullable = false, columnDefinition = "longtext")
    private String bcontent; // 게시글 내용

    @Column
    private int bview; // 조회수

    @Column
    private int blike; // 좋아요

    // 작성자(fk)
    @ManyToOne
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;

    // 카테고리(fk)
    @ManyToOne
    @JoinColumn(name = "cno")
    private CategoryEntity categoryEntity;
}
