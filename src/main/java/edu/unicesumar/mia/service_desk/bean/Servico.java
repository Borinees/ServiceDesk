package edu.unicesumar.mia.service_desk.bean;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servico", schema = "service_desk")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico")
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 100)
    @ToString.Include
    private String nome;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id", referencedColumnName = "id_categoria")
    @ToString.Exclude
    private Categoria categoria;

    @Column(name = "sla_horas")
    @ToString.Include
    private Integer slaHoras;

    @Column(name = "criado_em", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime criadoEm = LocalDateTime.now();
}
