package devcom.model.entity;

import devcom.model.dto.MessageDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.format.DateTimeFormatter;

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
    @Column

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mno")
    private MemberEntity sender; //송수신자

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mno")
    private MemberEntity receiver; //송수신자


    // entity -> dto
    public MessageEntity toDto(){
        return MessageDto.builder()

                .build();
    }

}
