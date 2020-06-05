package attractions.dao;

import attractions.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Attr;


import java.util.List;

@Repository
public class AttractionsDAOImpl implements AttractionsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Ticket> getTickets() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ticket> theQuery = currentSession.createQuery("from Ticket", Ticket.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
        System.out.println("CUSTOMERS : " + theQuery.getResultList());
        return theQuery.getResultList();
    }

    @Override
    public List<Attraction> getAttractions() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Attraction> theQuery = currentSession.createQuery("from Attraction", Attraction.class);
        System.out.println("Attractions : " + theQuery.getResultList());
        return theQuery.getResultList();
    }

    @Override
    public Attraction createAttraction() {

        Session currentSession = sessionFactory.getCurrentSession();

        String idAttraction = "AT3";
        Query<Attraction> attractionQuery = currentSession
                .createQuery("from Attraction where idAttraction = :idAttraction",
                        Attraction.class);
        attractionQuery.setParameter("idAttraction", idAttraction);
        Attraction attraction = attractionQuery.getSingleResult();
        //System.out.println("------------------------------------------------------------------------------------------------");

        String idAttraction2 = "AT5";
        Query<Attraction> attractionQuery2 = currentSession
                .createQuery("from Attraction where idAttraction = :idAttraction2",
                        Attraction.class);
        attractionQuery2.setParameter("idAttraction2", idAttraction2);
        Attraction attraction2 = attractionQuery2.getSingleResult();
        //System.out.println("------------------------------------------------------------------------------------------------");

        String administratorID = "A2";
        Query<Administrator> administratorQuery = currentSession
                .createQuery("from Administrator where idAdministrator = :administratorID",
                        Administrator.class);
        administratorQuery.setParameter("administratorID", administratorID);
        Administrator administrator = administratorQuery.getSingleResult();
        System.out.println(administrator);
        //System.out.println("------------------------------------------------------------------------------------------------");

        //Get TechSupportTeam with id = TST1
        String techSupportTeamID = "TST2";
        Query<TechSupportTeam> techSupportTeamQuery = currentSession
                .createQuery("from TechSupportTeam where idTeam = :techSupportTeamID",
                        TechSupportTeam.class);
        techSupportTeamQuery.setParameter("techSupportTeamID", techSupportTeamID);
        TechSupportTeam techSupportTeam = techSupportTeamQuery.getSingleResult();
        System.out.println(techSupportTeam);
        //System.out.println("------------------------------------------------------------------------------------------------");

        String ticketTerminalId = "TT2";
        Query<TicketTerminal> ticketTerminalQuery = currentSession
                .createQuery("from TicketTerminal where idTicketTerminal = :ticketTerminalId",
                        TicketTerminal.class);
        ticketTerminalQuery.setParameter("ticketTerminalId", ticketTerminalId);
        TicketTerminal ticketTerminal = ticketTerminalQuery.getSingleResult();
        //System.out.println("------------------------------------------------------------------------------------------------");

        Ticket ticket = new Ticket("T7", attraction.getPriceOfAttraction() +
                attraction2.getPriceOfAttraction(), "14-06-2020", "10:00");

        Customer customer = new Customer("C7", "14-06-2020");
        //System.out.println("------------------------------------------------------------------------------------------------");

        customer.addTicket(ticket);
        ticketTerminal.addTicket(ticket);

        administrator.addAttraction(attraction);
        techSupportTeam.addAttraction(attraction);
        administrator.addAttraction(attraction2);
        techSupportTeam.addAttraction(attraction2);

//        attraction.addTicket(ticket);
//        attraction2.addTicket(ticket);

        ticket.addAttraction(attraction);
        ticket.addAttraction(attraction2);

        currentSession.save(customer);
        currentSession.save(ticket);

        return attraction;
    }

    @Override
    public Ticket createTicket() {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = new Customer("C1", "14-06-2020");
        TicketTerminal ticketTerminal = new TicketTerminal("TT3", "card");

        Ticket ticket = new Ticket("T1", 20, "14-06-2020", "10:00");

        ticket.setTicketTerminal(ticketTerminal);
        ticket.setCustomer(customer);

        currentSession.save(ticketTerminal);
        currentSession.save(customer);
        currentSession.save(ticket);

        return ticket;
    }


}
