package devcom.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @ToString @Builder // 롬복
@AllArgsConstructor @NoArgsConstructor // 롬복
@Entity
@Table(name = "category" ) // 엔티티
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String cname;
}
