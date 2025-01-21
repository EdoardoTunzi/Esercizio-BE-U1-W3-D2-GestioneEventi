package org.example;

import org.example.entities.Evento;
import org.example.entities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Date;

/**
 * Hello world!
 */
public class EventoDAO {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        Evento event1 = new Evento(LocalDate.of(2025,5, 12),"Festa di laurea", TipoEvento.PRIVATO,150);
        save(event1);

        em.close();
        emf.close();



    }

    public static void save(Evento e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }
}
