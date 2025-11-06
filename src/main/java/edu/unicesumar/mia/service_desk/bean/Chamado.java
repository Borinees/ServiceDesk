package edu.unicesumar.mia.service_desk.bean;

import edu.unicesumar.mia.service_desk.bean.enums.NivelPrioridade;
import edu.unicesumar.mia.service_desk.bean.enums.Status;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Chamado {
    private String titulo;
    private String descricao;
    private Categoria categoria;
    private NivelPrioridade prioridade;
    private Status status;
    private Cliente cliente;
    private Tecnico tecnico;
    private LocalDateTime dataAbertura;
    private LocalDateTime dataFechamento;

    public Chamado() {}

    public Chamado(String titulo, String descricao, Categoria categoria, NivelPrioridade prioridade, Status status, Cliente cliente, Tecnico tecnico, LocalDateTime dataAbertura, LocalDateTime dataFechamento) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.prioridade = prioridade;
        this.status = status;
        this.cliente = cliente;
        this.tecnico = tecnico;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
    }

    @Override
    public String toString() {
        return "Chamado{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", categoria=" + categoria +
                ", prioridade=" + prioridade +
                ", status=" + status +
                ", cliente=" + (cliente != null ? cliente.getNome() : "null") +
                ", tecnico=" + (tecnico != null ? tecnico.getNome() : "null") +
                ", dataAbertura=" + dataAbertura +
                ", dataFechamento=" + dataFechamento +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chamado chamado)) return false;
        return Objects.equals(titulo, chamado.titulo) &&
                Objects.equals(descricao, chamado.descricao) &&
                categoria == chamado.categoria &&
                prioridade == chamado.prioridade &&
                status == chamado.status &&
                Objects.equals(cliente, chamado.cliente) &&
                Objects.equals(tecnico, chamado.tecnico) &&
                Objects.equals(dataAbertura, chamado.dataAbertura) &&
                Objects.equals(dataFechamento, chamado.dataFechamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, descricao, categoria, prioridade, status, cliente, tecnico, dataAbertura, dataFechamento);
    }
}
