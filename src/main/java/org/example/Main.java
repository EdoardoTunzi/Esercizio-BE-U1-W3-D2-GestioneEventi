package org.example;

import org.example.dao.EventoDAO;
import org.example.dao.LocationDAO;
import org.example.dao.PartecipazioneDAO;
import org.example.dao.PersonaDAO;
import org.example.entities.*;

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

        Persona persona1 = new Persona("Marco", "Rossi", "m.rossi@example.it", LocalDate.of(1990, 6, 21), Sesso.M, new ArrayList<>());
        Location salaRicevimenti = new Location("Borgo dei pini", "Roma");

        LocationDAO locationDAO = new LocationDAO(em);
        locationDAO.save(salaRicevimenti);

        Evento event1 = new Evento("Festa di Laurea Davide", LocalDate.of(2025, 5, 13), "festa per celebrare", TipoEvento.PRIVATO, 45, salaRicevimenti, new ArrayList<>());
        EventoDAO eventodao = new EventoDAO(em);
        eventodao.save(event1);

        Partecipazione part1 = new Partecipazione(persona1, event1, Stato.CONFERMATA);
        persona1.getPartecipazioni().add(part1);
        event1.getPartecipazioni().add(part1);

        PersonaDAO personaDAO = new PersonaDAO(em);
        personaDAO.save(persona1);

        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        partecipazioneDAO.save(part1);

        em.close();
        emf.close();
    }

}
