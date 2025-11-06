package edu.unicesumar.mia.service_desk.bean;

import edu.unicesumar.mia.service_desk.bean.enums.NivelPrioridade;
import edu.unicesumar.mia.service_desk.bean.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "chamado", schema = "service_desk")
@Getter
@Setter
public class Chamado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chamado")
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Interacao interacao;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private NivelPrioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_tecnico")
    private Tecnico tecnico;

    @OneToMany(mappedBy = "chamado", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private LocalDateTime dataAbertura;

    @Column(name = "data_fechamento")
    private LocalDateTime dataFechamento;

    @Column(name = "criado_em", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(name = "atualizado em")
    private LocalDateTime atualizadoEm;

    public Chamado() {}

    public Chamado(String titulo, String descricao, Interacao interacao, NivelPrioridade prioridade, Status status, Cliente cliente, Tecnico tecnico, LocalDateTime dataAbertura, LocalDateTime dataFechamento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.interacao = interacao;
        this.prioridade = prioridade;
        this.status = status;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.dataAbertura = LocalDateTime.now();
    }

    public void fecharChamado() {
        this.status = Status.FECHADO;
        this.dataFechamento = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "id=" + id +
                "titulo='" + titulo + '\'' +
                ", interacao=" + (interacao != null ? interacao.getNome() : "N/A") +
                ", prioridade=" + prioridade +
                ", status=" + status +
                ", cliente=" + (cliente != null ? cliente.getNome() : "null") +
                ", tecnico=" + (tecnico != null ? tecnico.getNome() : "null") +
                ", dataAbertura=" + dataAbertura +
                ", dataFechamento" + dataFechamento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chamado chamado)) return false;
        return Objects.equals(id, chamado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
