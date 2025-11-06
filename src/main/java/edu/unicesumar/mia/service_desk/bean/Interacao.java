package edu.unicesumar.mia.service_desk.bean;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "interacao", schema = "service_desk")
@Getter
@Setter
public class Interacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_interacao")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chamado", referencedColumnName = "id_chamado")
    private Chamado chamado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String mensagem;

    @Column(name = "data_envio", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime dataEnvio = LocalDateTime.now();

    public Interacao() {}

    public Interacao(Chamado chamado, Usuario usuario, String mensagem) {
        this.chamado = chamado;
        this.usuario = usuario;
        this.mensagem = mensagem;
        this.dataEnvio = LocalDateTime.now();
    }

    public String getNome() {
        return usuario != null ? usuario.getNome() : null;
    }

    @Override
    public String toString() {
        return "Interacao{" +
                "id=" + id +
                ", usuario=" + (usuario != null ? usuario.getNome() : "N/A") +
                ", mensagem='" + mensagem + '\'' +
                ", dataEnvio=" + dataEnvio +
                '}';
    }
}
