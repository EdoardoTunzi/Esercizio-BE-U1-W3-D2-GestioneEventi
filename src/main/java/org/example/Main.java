package org.example;

import org.example.dao.EventoDAO;
import org.example.entities.Evento;
import org.example.entities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

/**
 * Hello world!
 */
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        Evento event1 = new Evento(LocalDate.of(2025,5, 12),"Festa di laurea", TipoEvento.PRIVATO,150);
        Evento event2 = new Evento(LocalDate.of(2025,6, 12),"Matrimonio", TipoEvento.PRIVATO,400);
        Evento event3 = new Evento(LocalDate.of(2025,7, 12),"Compleanno Mario", TipoEvento.PUBBLICO,40);


        EventoDAO eventodao = new EventoDAO(em);

        /*eventodao.save(event1);
        eventodao.save(event2);
        eventodao.save(event3);*/

        Evento getEvento = eventodao.getById(1); //cosi trovo l'oggetto e lo assegno a una variabile
        eventodao.delete(event3); // così lo elimino

        em.close();
        emf.close();



    }

}
