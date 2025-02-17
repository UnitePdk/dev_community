package devcom.model.entity;

import devcom.model.dto.BoardDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.format.DateTimeFormatter;

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
    @Column(columnDefinition = "int default 1")
    private int bview;

    // 좋아요
    @Column(columnDefinition = "int default 1")
    private int blike;

    // 작성자 fk
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;

    // 카테고리 fk
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cno")
    private CategoryEntity categoryEntity;

    // 언어 fk
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "lno")
    private LanguageEntity languageEntity;

    public BoardDto toDto() {

        // ✅ yyyy-MM-dd HH:mm 포맷 설정
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formatCdate = this.getCdate().format(format);

        return BoardDto.builder()
                .bno(this.bno)
                .btitle(this.btitle)
                .bcontent(this.bcontent)
                .bview(this.bview)
                .blike(this.blike)
                .mno(this.memberEntity.getMno())
                .mname(this.memberEntity.getMname())
                .cno(this.categoryEntity.getCno())
                .cname(this.categoryEntity.getCname())
                .lno(this.languageEntity.getLno())
                .lname(this.languageEntity.getLname())
                .cdate(formatCdate)
                .build();
    }
}
