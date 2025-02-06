package devcom.model.entity;

import devcom.model.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "board")
public class BoardEntity extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    // 제목
    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String btitle;

    // 내용
    @Column(columnDefinition = "longtext")
    private String bcontent;

    // 조회수
    @Column
    private int bview;

    // 좋아요
    @Column
    private int blike;

    // 작성자 fk
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;

    // 카테고리 fk
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cno")
    private CategoryEntity categoryEntity;

    public BoardDto toDto() {
        return BoardDto.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .bview(this.bview)
                .mno(this.memberEntity.getMno())
                .cno(this.categoryEntity.getCno())
                .mid(this.memberEntity.getMid())
                .cname(this.categoryEntity.getCname())
                .cdate(this.getCdate().toString())
                .build();
    }
}
