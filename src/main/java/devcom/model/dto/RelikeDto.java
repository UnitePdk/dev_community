package devcom.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelikeDto {

    // 특정 댓글
    private Long replyId;
    
    // 특정 유저
    private Long memberId;

}
