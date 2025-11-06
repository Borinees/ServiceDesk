package edu.unicesumar.mia.service_desk.bean;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
public class Cliente extends Usuario{
    private String empresa;
    private String telefone;

    public Cliente() {}

    public Cliente(String empresa, String telefone) {
        this.empresa = empresa;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "empresa'" + empresa + '\'' +
                ", telefone='" + telefone + '\'' +
                ", usuario=" + super.toString() + '\'' +
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
