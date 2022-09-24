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
@Entity (name = "agregador")

public class Agregador{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgregador;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacao;

    @Column(length = 100, nullable = false)
    private String nome;

    public Agregador(String nome){
        this.nome = nome;
    }

    public Object getId() {
        return null;
    }
}