package br.com.biaeleo.spotlight.model;

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
@Entity (name = "episodioIntegrante")

public class EpisodioIntegrante{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEpisodio;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIntegrante;

    public Object getId() {
        return null;
    }

    public void setEpisodio(Episodio episodio) {
    }

    public void setIntegrante(Integrante integrante) {
    }
}