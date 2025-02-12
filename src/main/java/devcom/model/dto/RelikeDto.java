package devcom.model.dto;

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

}
