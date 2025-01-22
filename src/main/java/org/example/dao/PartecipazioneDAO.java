package org.example.dao;


import org.example.entities.Partecipazione;

import javax.persistence.EntityManager;

public class PartecipazioneDAO {
    private EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione p) {
        //apro la transazione(stream) con il db
        em.getTransaction().begin();
        // gli do l'istruzione che voglio eseguire- inm questo caso persist() per salvare su db
        //e gli passo nel parametro cosa salvare
        em.persist(p);
        //gli dico di eseguire con commit
        em.getTransaction().commit();
    }

    public Partecipazione getById(long id) {
        return em.find(Partecipazione.class, id);
    }

    public void delete(Partecipazione p) {
        em.getTransaction().begin();
        // gli do l'istruzione che voglio eseguire- inm questo caso persist() per salvare su db
        //e gli passo nel parametro cosa rimuovere
        em.remove(p);
        //gli dico di eseguire con commit
        em.getTransaction().commit();
    }
}
