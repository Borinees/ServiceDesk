package edu.unicesumar.mia.service_desk.bean;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
public class Comentario {
    private Long id;
    private Usuario autor;
    private String conteudo;
    private Chamado chamado;
    private LocalDateTime data;

    public Comentario() {}

    public Comentario(Long id, Usuario autor, String conteudo, Chamado chamado, LocalDateTime data) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.chamado = chamado;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", texto='" + conteudo + '\'' +
                ", autor=" + (autor != null ? autor.getNome() : "null") +
                ", chamado=" + (chamado != null ? chamado.getTitulo() : "null") +
                ", dataCriacao=" + data +
                '}';
    }

    // equals() e hashCode() — baseados em ID
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comentario comentario)) return false;
        return Objects.equals(id, comentario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
