package edu.unicesumar.mia.service_desk.bean;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class EntidadeBase implements Entidade{
   private int id;
   private LocalDateTime criadoEm;
}
