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
    private int relikenum;

    // 좋아요를 누른 회원
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mno", nullable = false)
    private MemberEntity memberEntity;

    // 댓글 번호
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rno", nullable = false)
    private ReplyEntity replyEntity;


}
