package br.com.biaeleo.spotlight.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
@Entity (name = "episodio")

public class Episodio{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEpisodio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTemporada;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSerie;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column (nullable = false)
    private BigDecimal data;

    @Column (nullable = false)
    private BigDecimal duracao;

   @Column(length = 200, nullable = false)
    private String sinopse;    

    public Episodio(String nome, BigDecimal data, BigDecimal duracao, String sinopse){
        this.nome = nome;
        this.data = data;
        this.duracao = duracao;
        this.sinopse = sinopse;

    }

    public Object getId() {
        return null;
    }

    public List<Integrante> getIntegrantes() {
        return null;
    }

    public void setIntegrantes(ArrayList arrayList) {
    }
}