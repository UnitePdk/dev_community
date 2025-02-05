package devcom.model.dto;

import devcom.model.entity.CategoryEntity;
import lombok.*;

@Getter @Setter @ToString @Builder // 룸복
@AllArgsConstructor @NoArgsConstructor // 룸복
public class CategoryDto {
    private int cno; // 카테고리 번호
    private String cname; // 카테고리 이름

    // dto -> entity 변환 함수
    public CategoryEntity toEntity(){
        return CategoryEntity.builder()
                .cno(this.cno)
                .cname(this.cname)
                .build();
    }
}
