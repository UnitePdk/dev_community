package devcom.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "file")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno;

    @Column(columnDefinition = "varchar(255)", nullable = false)
    private String fname;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bno")
    private BoardEntity boardEntity;
}
