package edu.unicesumar.mia.service_desk.bean;

import edu.unicesumar.mia.service_desk.bean.enums.NivelPrioridade;
import edu.unicesumar.mia.service_desk.bean.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chamado", schema = "service_desk")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chamado")
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(nullable = false, length = 150)
    @ToString.Include
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_tecnico", referencedColumnName = "id_tecnico")
    private Tecnico tecnico;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "id_servico", referencedColumnName = "id_servico")
    private Servico servico;

    @OneToMany(mappedBy = "chamado", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Interacao> interacoes;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @ToString.Include
    private NivelPrioridade prioridade;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @ToString.Include
    private Status status;

    @Column(name = "data_abertura", nullable = false)
    @ToString.Include
    private LocalDateTime dataAbertura = LocalDateTime.now();

    @Column(name = "data_fechamento")
    private LocalDateTime dataFechamento;

    @Column(name = "criado_em", columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(name = "atualizado_em")
    private LocalDateTime atualizadoEm;

    public void fecharChamado() {
        this.status = Status.FECHADO;
        this.dataFechamento = LocalDateTime.now();
    }
}
