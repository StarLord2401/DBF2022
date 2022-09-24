package br.com.biaeleo.spotlight.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;

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
@Entity (name = "filme")

public class Filme{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilme;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column (nullable = false)
    private BigDecimal data;

    @Column (nullable = false)
    private BigDecimal duracao;

   @Column(length = 200, nullable = false)
    private String sinopse;    

    public Filme(String nome, BigDecimal data, BigDecimal duracao, String sinopse){
        this.nome = nome;
        this.data = data;
        this.duracao = duracao;
        this.sinopse = sinopse;

    }
}