package devcom.model.entity;

import devcom.model.dto.MessageDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter @Setter @ToString @Builder // 롬복
@AllArgsConstructor @NoArgsConstructor // 롬복
@Entity
@Table(name = "message" ) // 엔티티
public class MessageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int meno; // 식별 번호

    @Column(nullable = false, columnDefinition = "varchar(225)")
    private String metitle; // 제목
    @Column(nullable = false, columnDefinition = "longtext")
    private String mecontent; // 내용
    @Column(nullable = false, columnDefinition = "varchar(225)")
    private String sender;
    @Column(nullable = false, columnDefinition = "varchar(225)")
    private String receiver;


    // sender_mno와 receiver_mno는 각각 외래 키로 다른 컬럼을 참조하도록 설정
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mno", insertable = false, updatable = false)  // 송신자 외래 키
    @OnDelete(action = OnDeleteAction.NO_ACTION) // 송신&수신자 삭제시 같이 삭제
    private MemberEntity sendermno; // 송신자

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mno", insertable = false, updatable = false)  // 수신자 외래 키
    @OnDelete(action = OnDeleteAction.NO_ACTION) // 송신&수신자 삭제시 같이 삭제
    private MemberEntity receivermno; // 수신자


    // entity -> dto
    public MessageDto toDto() {
        return MessageDto.builder()
                .meno(this.meno)
                .metitle(this.metitle)
                .mecontent(this.mecontent)
                .receivermno(this.receivermno.getMno())
                .sendermno(this.sendermno.getMno())
                .build();
    }


}
