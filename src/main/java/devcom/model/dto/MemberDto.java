package devcom.model.dto;

import devcom.model.entity.MemberEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {
    private int mno; // 회원번호
    private String mname; // 회원이름
    private String mid; // 회원아이디
    private String mpwd; // 회원비밀번호
    private String memail; // 회원이메일
    private String mphone; // 회원 전화번호
    private String mbirth; // 회원 생년월일
    private String mimg; // 프로필 사진
    private MultipartFile uploadfile; // 파일

    // Dto -> Entity
    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .mno(this.mno)
                .mname(this.mname)
                .mid(this.mid)
                .mpwd(this.mpwd)
                .memail(this.memail)
                .mphone(this.mphone)
                .mbirth(this.mbirth)
                .mimg(this.mimg)
                .build();
    }
}
