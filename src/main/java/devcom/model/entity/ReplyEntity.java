package devcom.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reply")
public class ReplyEntity extends BaseTime {
    
    // 댓글 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rno;

    // 댓글 내용
    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String rcontent;

    // 좋아요
    @Column(nullable = false)
    private int rlike;

    // 생성날짜

    // 수정날짜

    // 댓글 작성자
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;
    
    // (종속된)게시판 번호
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bno")
    private BoardEntity boardEntity;
    
}
