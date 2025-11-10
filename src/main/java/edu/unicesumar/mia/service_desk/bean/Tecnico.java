package edu.unicesumar.mia.service_desk.bean;

import edu.unicesumar.mia.service_desk.bean.enums.Especialidade;
import edu.unicesumar.mia.service_desk.bean.enums.Setor;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tecnico", schema = "service_desk")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Tecnico extends Usuario {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    @ToString.Include
    private Especialidade especialidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    @ToString.Include
    private Setor setor;

    @Column(nullable = false)
    @ToString.Include
    private Boolean disponivel = true;

    @OneToMany(mappedBy = "tecnico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Chamado> chamadosAtivos;
}