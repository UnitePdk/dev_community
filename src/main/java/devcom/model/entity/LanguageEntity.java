package devcom.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder // 롬복
@AllArgsConstructor
@NoArgsConstructor // 롬복
@Entity
@Table(name = "language" ) // 엔티티
public class LanguageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lno;

    @Column(nullable = false, columnDefinition = "varchar(50)")
    private String lname;
}
