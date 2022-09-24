package br.com.biaeleo.spotlight.model;

import java.util.ArrayList;
import java.util.List;

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
@Entity (name = "catalogo")

public class Catalogo{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCatalogo;

    public Object getId() {
        return null;
    }

    public void setFilmes(ArrayList arrayList) {
    }

    public List<Filme> getFilmes() {
        return null;
    }

    public void setSeries(ArrayList arrayList) {
    }

    public List<Serie> getSeries() {
        return null;
    }
}