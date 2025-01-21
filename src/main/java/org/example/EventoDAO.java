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
        Evento event2 = new Evento(LocalDate.of(2025,6, 12),"Matrimonio", TipoEvento.PRIVATO,400);
        Evento event3 = new Evento(LocalDate.of(2025,7, 12),"Compleanno Mario", TipoEvento.PUBBLICO,40);
        save(event1);
        save(event2);
        save(event3);
        deleteById(event1.getId());

        em.close();
        emf.close();



    }

    public static void save(Evento e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public static void deleteById(Long id) {
        em.getTransaction().begin();
        Evento evento = em.find(Evento.class, id);
        if (evento != null) {
            em.remove(evento);
        } else {
            System.out.println("Nessun evento trovato con id: " + id);
        }
        em.getTransaction().commit();
    }
}
