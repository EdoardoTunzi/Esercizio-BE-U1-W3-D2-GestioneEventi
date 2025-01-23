package org.example;

import org.example.dao.EventoDAO;
import org.example.dao.LocationDAO;
import org.example.dao.PartecipazioneDAO;
import org.example.dao.PersonaDAO;
import org.example.entities.*;
import org.example.enumerations.Sesso;
import org.example.enumerations.Stato;
import org.example.enumerations.TipoConcerto;
import org.example.enumerations.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestioneEventi");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        LocationDAO locationDAO = new LocationDAO(em);
        EventoDAO eventodao = new EventoDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
//--------------------------- creazione oggetti
       /* Persona persona1 = new Persona("Marco", "Rossi", "m.rossi@example.it", LocalDate.of(1990, 6, 21), Sesso.M);
        Location salaRicevimenti = new Location("Borgo dei pini", "Roma");
        Evento event1 = new Evento("Festa di Laurea Davide", LocalDate.of(2025, 5, 13), "festa per celebrare", TipoEvento.PRIVATO, 45, salaRicevimenti, new ArrayList<>());
        Partecipazione part1 = new Partecipazione(persona1, event1, Stato.CONFERMATA);*/
        //Concerto conc1 = new Concerto("The Wall - Live",LocalDate.of(2025,12,02),"Roger Waters Live in Rome",TipoEvento.PUBBLICO,4000,locationDAO.getById(1),new ArrayList<Partecipazione>(), TipoConcerto.ROCK,true);

//-------------------------- utilizzo oggetti
       /* locationDAO.save(salaRicevimenti);
        eventodao.save(event1);*/
        //eventodao.save(conc1);

       /* persona1.getPartecipazioni().add(part1);
        event1.getPartecipazioni().add(part1);*/

       /* personaDAO.save(persona1);*/

        /*partecipazioneDAO.save(part1);*/

       List<Concerto> concertiInStreaming = eventodao.getConcertInStreaming(true);
       concertiInStreaming.forEach(System.out::println);
        em.close();
        emf.close();
    }

}
