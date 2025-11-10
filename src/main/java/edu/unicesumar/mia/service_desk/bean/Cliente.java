package edu.unicesumar.mia.service_desk.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente", schema = "service_desk")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Cliente extends Usuario{

    @Column(length = 100)
    @ToString.Include
    private String empresa;

    @Column(length = 20)
    @ToString.Include
    private String telefone;
}
