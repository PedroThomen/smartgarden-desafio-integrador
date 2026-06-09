package br.com.smartgarden.smartgarden_api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "irrigacoes")
public class Irrigacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean ligada;

    private LocalDateTime dataHora;

    public Irrigacao() {}

    public Long getId() {
        return id;
    }

    public Boolean getLigada() {
        return ligada;
    }

    public void setLigada(Boolean ligada) {
        this.ligada = ligada;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}