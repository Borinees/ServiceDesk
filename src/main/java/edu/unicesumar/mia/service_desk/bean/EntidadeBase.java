package edu.unicesumar.mia.service_desk.bean;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public abstract class EntidadeBase implements Entidade{
   private int id;
   private LocalDateTime criadoEm;
}
