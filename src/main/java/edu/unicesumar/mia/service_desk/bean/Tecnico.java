package edu.unicesumar.mia.service_desk.bean;

import edu.unicesumar.mia.service_desk.bean.enums.Especialidade;
import edu.unicesumar.mia.service_desk.bean.enums.Setor;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Tecnico extends Usuario{
    private Especialidade especialidade;
    private Setor setor;
    private Boolean disponivel;
    private List<Chamado> chamadosAtivos;


    public Tecnico() {}

    public Tecnico(Especialidade especialidade, Setor setor, Boolean disponivel, List<Chamado> chamadosAtivos) {
        this.especialidade = especialidade;
        this.setor = setor;
        this.disponivel = disponivel;
        this.chamadosAtivos = chamadosAtivos;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "especialidade'" + especialidade + '\'' +
                ", disponivel= " + disponivel +
                ", setor='" + setor + '\'' +
                ", usuario=" + super.toString() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tecnico tecnico)) return false;
        if (!super.equals(o)) return false;
        return disponivel = tecnico.disponivel &&
                Objects.equals(especialidade,  tecnico.especialidade) &&
                Objects.equals(chamadosAtivos, tecnico.chamadosAtivos) &&
                Objects.equals(setor, tecnico.setor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidade, disponivel, chamadosAtivos, setor);
    }

}
