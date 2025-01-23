package org.example.entities;

import org.example.enumerations.TipoConcerto;
import org.example.enumerations.TipoEvento;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento{

    @Enumerated(EnumType.STRING)
    private TipoConcerto genere;

    private boolean inStreaming;

    public Concerto () { }

    public Concerto(String nome, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, List<Partecipazione> partecipazioni, TipoConcerto genere, boolean inStreaming) {
        super(nome, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location, partecipazioni);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public TipoConcerto getGenere() {
        return genere;
    }

    public void setGenere(TipoConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return super.toString() + "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
