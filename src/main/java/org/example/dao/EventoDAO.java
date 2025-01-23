package org.example.dao;

import org.example.entities.Concerto;
import org.example.entities.Evento;
import org.example.entities.PartitaDiCalcio;
import org.example.enumerations.TipoConcerto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EventoDAO {

    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento e) {
        //apro la transazione(stream) con il db
        em.getTransaction().begin();
        // gli do l'istruzione che voglio eseguire- inm questo caso persist() per salvare su db
        //e gli passo nel parametro cosa salvare
        em.persist(e);
        //gli dico di eseguire con commit
        em.getTransaction().commit();
    }

    public Evento getById(long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Evento e) {
        em.getTransaction().begin();
        // gli do l'istruzione che voglio eseguire- inm questo caso persist() per salvare su db
        //e gli passo nel parametro cosa rimuovere
        em.remove(e);
        //gli dico di eseguire con commit
        em.getTransaction().commit();
    }

    public List<Concerto> getConcertInStreaming(boolean bool) {
        Query q = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = :bool");
        q.setParameter("bool", bool);
        return q.getResultList();
    }

    public List<Concerto> getConcertiPerGenere (TipoConcerto tipoConcerto) {
        Query q = em.createQuery("SELECT c FROM Concerto c WHERE c.genere = :tipoConcerto");
        q.setParameter("tipoConcerto", tipoConcerto);
        return q.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        Query q = em.createQuery("PartitaDiCalcio.getPartiteVinteInCasa");
        return q.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        Query q = em.createQuery("PartitaDiCalcio.getPartiteVinteInTrasferta");
        return q.getResultList();
    }
}
