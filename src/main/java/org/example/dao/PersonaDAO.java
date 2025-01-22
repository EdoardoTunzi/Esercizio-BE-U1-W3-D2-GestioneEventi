package org.example.dao;

import org.example.entities.Persona;

import javax.persistence.EntityManager;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }


    public void save(Persona p) {
        //apro la transazione(stream) con il db
        em.getTransaction().begin();
        // gli do l'istruzione che voglio eseguire- inm questo caso persist() per salvare su db
        //e gli passo nel parametro cosa salvare
        em.persist(p);
        //gli dico di eseguire con commit
        em.getTransaction().commit();
    }

    public Persona getById(long id) {
        return em.find(Persona.class, id);
    }

    public void delete(Persona p) {
        em.getTransaction().begin();
        // gli do l'istruzione che voglio eseguire- inm questo caso persist() per salvare su db
        //e gli passo nel parametro cosa rimuovere
        em.remove(p);
        //gli dico di eseguire con commit
        em.getTransaction().commit();
    }
}
