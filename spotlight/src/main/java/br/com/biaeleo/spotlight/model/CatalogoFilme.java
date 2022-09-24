package br.com.biaeleo.spotlight.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
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
@Entity (name = "catalogoFilme")

public class CatalogoFilme{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatalogo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFilme;

    public void setCatalogo(Catalogo catalogo) {
    }

    public void setFilme(Filme filme) {
    }

    public void setNome(String nome) {
    }

    public void setData(BigDecimal data) {
    }

    public void setSinopse(String sinopse) {
    }

    public void setDuracao(BigDecimal duracao) {
    }

    public void setNacionalidade(Object nacionalidade) {
    }

    public void setDtNascimento(Object dtNascimento) {
    }
}