package devcom.model.dto;

import devcom.model.entity.BoardEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int bno;
    private String btitle;
    private String bcontent;
    private int bview;
    private int blike;
    private int cno;
    private String cname;
    private int mno;
    private String mname;
    private int lno;
    private String lname;
    private String cdate;

    private List<ReplyDto> replyList;

    public BoardEntity toEntity() {
        return BoardEntity.builder().btitle(this.btitle).bcontent(this.bcontent).bview(this.bview).blike(this.blike).build();
    }
}