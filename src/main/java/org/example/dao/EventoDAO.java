package org.example.dao;

import org.example.entities.Evento;

import javax.persistence.EntityManager;

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
}
