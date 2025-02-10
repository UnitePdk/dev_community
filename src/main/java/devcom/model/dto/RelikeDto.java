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
    private int rno;        // 특정 댓글
    private int mno;        // 특정 유저

}
