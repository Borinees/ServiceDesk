package edu.unicesumar.mia.service_desk.bean;

import edu.unicesumar.mia.service_desk.bean.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "mudanca_status", schema = "service_desk")
@Getter
@Setter
public class MudancaStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mudanca")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chamado", referencedColumnName = "id_chamado")
    private Chamado chamado;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_anterior", length = 20)
    private Status statusAnterior;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_novo", length = 20)
    private Status statusNovo;

    @Column(name = "data_mudanca", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime dataMudanca = LocalDateTime.now();

    public MudancaStatus() {}

    public MudancaStatus(Chamado chamado, Status statusAnterior, Status statusNovo, LocalDateTime dataMudanca) {
        this.chamado = chamado;
        this.statusAnterior = statusAnterior;
        this.statusNovo = statusNovo;
        this.dataMudanca = dataMudanca;
    }

    @Override
    public String toString() {
        return "MudancaStatus{" +
                "chamado=" + (chamado != null ? chamado.getTitulo() : "N/A") +
                ", de=" + statusAnterior +
                ", para=" + statusNovo +
                ", dataMudanca=" + dataMudanca +
                "}";
    }
}
