package edu.unicesumar.mia.service_desk.bean;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comentario {
    private Usuario autor;
    private String conteudo;
    private LocalDateTime data;
}
