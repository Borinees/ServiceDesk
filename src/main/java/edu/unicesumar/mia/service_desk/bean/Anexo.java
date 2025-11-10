package edu.unicesumar.mia.service_desk.bean;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "anexo", schema = "service_desk")
public class Anexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anexo")
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chamado", referencedColumnName = "id_chamado")
    private Chamado chamado;

    @Column(name = "nome_arquivo", length = 255)
    @ToString.Include
    private String nomeArquivo;

    @Column(name = "caminho_arquivo", columnDefinition = "TEXT")
    private String caminhoArquivo;

    @Column(name = "data_envio", columnDefinition = "TIMESTAMP DEFAUL NOW()")
    @ToString.Include
    private LocalDateTime dataEnvio = LocalDateTime.now();
}
