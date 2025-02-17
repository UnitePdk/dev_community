package devcom.model.dto;

import devcom.model.entity.BoardEntity;
import devcom.model.entity.MemberEntity;
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
    private String cdate;       // 생성날짜
    private String udate;       // 수정날짜
    private int mno;            // 작성자
    private int bno;            // 게시판번호
    private String mname;          // 회원 이름 추가


    // dto --> entity 변환
    public ReplyEntity toEntity(MemberEntity memberEntity, BoardEntity boardEntity) {
        return ReplyEntity.builder()
                .rcontent(this.rcontent)
                .relike(this.relike)
                .memberEntity(memberEntity)
                .boardEntity(boardEntity)
                .build();
    }
    
}
