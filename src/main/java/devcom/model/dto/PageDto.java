package devcom.model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDto {
    private int page;
    private int totalpage;
    private long totalcount;
    private int startbtn;
    private int endbtn;
    private Object data;
}
