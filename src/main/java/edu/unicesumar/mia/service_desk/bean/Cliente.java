package edu.unicesumar.mia.service_desk.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "cliente", schema = "service_desk")
@PrimaryKeyJoinColumn(name = "id_usuario")
@Getter
@Setter
public class Cliente extends Usuario{
    @Column(length = 100)
    private String empresa;
    @Column(length = 20)
    private String telefone;

    public Cliente() {}

    public Cliente(String nome, String email, String senha, String empresa, String telefone) {
        super(nome, email, senha, null);
        this.empresa = empresa;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "empresa'" + empresa + '\'' +
                ", telefone='" + telefone + '\'' +
                ", nome=" + getNome() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(empresa,  cliente.empresa) &&
                Objects.equals(telefone, cliente.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), empresa, telefone);
    }
}
