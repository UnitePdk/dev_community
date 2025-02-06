package devcom.model.dto;

import devcom.model.entity.BoardEntity;
import lombok.*;

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
    private int mno;
    private String cname;
    private String cdate;

    public BoardEntity toEntity() {
        return BoardEntity.builder().btitle(this.btitle).bcontent(this.bcontent).bview(this.bview).blike(this.blike).build();
    }
}