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
@Table(name = "relike")
public class RelikeEntity extends BaseTime {

    // 좋아요 번호(PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 댓글 작성자
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mno")
    private MemberEntity memberEntity;

    // 댓글 번호
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rno")
    private ReplyEntity replyEntity;

}
