package org.example.dao;

import org.example.entities.Location;

import javax.persistence.EntityManager;

public class LocationDAO {
    private EntityManager em;

    public LocationDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Location l) {
        //apro la transazione(stream) con il db
        em.getTransaction().begin();
        // gli do l'istruzione che voglio eseguire- inm questo caso persist() per salvare su db
        //e gli passo nel parametro cosa salvare
        em.persist(l);
        //gli dico di eseguire con commit
        em.getTransaction().commit();
    }

    public Location getById(long id) {
        return em.find(Location.class, id);
    }

    public void delete(Location l) {
        em.getTransaction().begin();
        // gli do l'istruzione che voglio eseguire- inm questo caso persist() per salvare su db
        //e gli passo nel parametro cosa rimuovere
        em.remove(l);
        //gli dico di eseguire con commit
        em.getTransaction().commit();
    }
}
