package idusw.springboot.hshblog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    @Column(length = 200)
    private String description;
}
