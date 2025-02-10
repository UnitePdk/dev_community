package devcom.model.dto;

import devcom.model.entity.ReplyEntity;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyDto {

    private int rno;            // 댓글번호
    private String rcontent;    // 댓글내용 
    private int relike;         // 좋아요


    // dto --> entity 변환
    public ReplyEntity toEntity() {
        return ReplyEntity.builder()
                .rno(this.rno)
                .rcontent(this.rcontent)
                .relike(this.relike)
                .build();
    }
    
}
