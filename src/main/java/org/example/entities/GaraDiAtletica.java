package org.example.entities;

import org.example.enumerations.TipoEvento;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GaraDiAtletica extends Evento {

    @OneToMany
    private List<Persona> setAtleti = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona vincitore;

    public GaraDiAtletica () { }

    public GaraDiAtletica(String nome, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, List<Partecipazione> partecipazioni, List<Persona> setAtleti, Persona vincitore) {
        super(nome, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location, partecipazioni);
        this.setAtleti = setAtleti;
        this.vincitore = vincitore;
    }

    public List<Persona> getSetAtleti() {
        return setAtleti;
    }

    public void setSetAtleti(List<Persona> setAtleti) {
        this.setAtleti = setAtleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return super.toString() + "GaraDiAtletica{" +
                "setAtleti=" + setAtleti +
                ", vincitore=" + vincitore +
                '}';
    }
}
