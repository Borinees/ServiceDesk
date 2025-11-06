package edu.unicesumar.mia.service_desk.bean;

import edu.unicesumar.mia.service_desk.bean.enums.Especialidade;
import edu.unicesumar.mia.service_desk.bean.enums.Setor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tecnico", schema = "service_desk")
@PrimaryKeyJoinColumn(name = "id_usuario")
@Getter
@Setter
public class Tecnico extends Usuario{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Especialidade especialidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private Setor setor;

    @Column(nullable = false)
    private Boolean disponivel;

    @OneToMany(mappedBy = "tecnico", fetch = FetchType.LAZY)
    private List<Chamado> chamadosAtivos;


    public Tecnico() {}

    public Tecnico(String nome, String email, String senha,
                    Especialidade especialidade, Setor setor, Boolean disponivel, List<Chamado> chamadosAtivos) {
        super(nome, email, senha, null);
        this.especialidade = especialidade;
        this.setor = setor;
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "nome='" + getNome() + '\'' +
                "especialidade'" + especialidade + '\'' +
                ", setor='" + setor + '\'' +
                ", disponivel= " + disponivel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tecnico tecnico)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(disponivel, tecnico.disponivel) &&
                Objects.equals(especialidade,  tecnico.especialidade) &&
                Objects.equals(setor, tecnico.setor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidade, disponivel, setor);
    }

}
