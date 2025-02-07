package devcom.model.dto;

import devcom.model.entity.MessageEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto {
    private int meno;               // 쪽지 번호
    private String metitle;         // 제목
    private String mecontent;       // 내용
    private int sendermno;          // 송신자
    private int receivermno;        // 수신자
    private String cdate;           // 송신 시간

//    // 화면 표시 (회원번호x, 아이디 출력)
//    private String sendmid;         // 송신자 아이디
//    private String receivermid;     // 수신자 아이디

//    // dto -> entity
//    public MessageEntity toEntity() {
//        return MessageEntity.builder()
//                .metitle(this.metitle)
//                .mecontent(this.mecontent)
//                .build();
//    }

}
