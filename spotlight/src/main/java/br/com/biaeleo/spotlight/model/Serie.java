package br.com.biaeleo.spotlight.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity (name = "serie")

public class Serie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSerie;

    @Column(length = 100, nullable = false)
    private String nome;

    public Serie(String nome){
        this.nome = nome;
    }
}