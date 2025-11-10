package edu.unicesumar.mia.service_desk.bean;

import edu.unicesumar.mia.service_desk.bean.enums.TipoUsuario;
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
@Table(name = "usuario", schema = "service_desk")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 100)
    @ToString.Include
    private String nome;

    @Column(nullable = false, unique = true, length = 150)
    @ToString.Include
    private String email;

    @Column(nullable = false, length = 100)
    @ToString.Exclude
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario", nullable = false, length = 30)
    @ToString.Include
    private TipoUsuario tipoUsuario;

    @Column(name = "criado_em", nullable = false)
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    @PrePersist
    protected void prePersist() {
        if (criadoEm == null) criadoEm = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        atualizadoEm = LocalDateTime.now();
    }
}
