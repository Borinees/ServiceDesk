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
@Table(name = "interacao", schema = "service_desk")
public class Interacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interacao")
    @EqualsAndHashCode.Include
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chamado", nullable = false)
    private Chamado chamado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @Column(columnDefinition = "TEXT", nullable = false)
    @ToString.Include
    private String mensagem;

    @Column(name = "data_envio", nullable = false)
    private LocalDateTime dataEnvio = LocalDateTime.now();

    @PrePersist
    protected void prePersist() {
        if (dataEnvio == null) {
            dataEnvio = LocalDateTime.now();
        }
    }
}
