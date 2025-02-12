package devcom.model.dto;

import devcom.model.entity.MemberEntity;
import devcom.model.entity.RelikeEntity;
import devcom.model.entity.ReplyEntity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelikeDto {

    private int relikenum;  // 좋아요 번호
    private int replyId;        // 특정 댓글
    private int memberId;        // 특정 유저

    // dto --> entity 변환
    public RelikeEntity toEntity(MemberEntity memberEntity, ReplyEntity replyEntity) {
        return RelikeEntity.builder()
                .relikenum(this.relikenum)
                .memberEntity(memberEntity)
                .replyEntity(replyEntity)
                .build();
    }

}
