package devcom.model.entity;

import devcom.model.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "member")
public class MemberEntity extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mno; // 회원번호

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String mname; // 회원이름

    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String mid; // 회원아이디

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String mpwd; // 회원비밀번호

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String memail; // 회원이메일

    @Column(columnDefinition = "varchar(13)")
    private String mphone; // 회원 전화번호

    @Column(columnDefinition = "varchar(10)", nullable = false)
    private String mbirth; // 회원 생년월일


    // Entity -> Dto
    public MemberDto toDto(){
        return MemberDto.builder()
                .mno(this.mno)
                .mname(this.mname)
                .mid(this.mid)
                .mpwd(this.mpwd)
                .memail(this.memail)
                .mphone(this.mphone)
                .mbirth(this.mbirth)
                .build();
    }
}