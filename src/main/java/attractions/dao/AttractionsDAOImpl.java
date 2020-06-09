package attractions.dao;

import attractions.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        return theQuery.getResultList();
    }

    @Override
    public List<Attraction> getAttractions() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Attraction> theQuery = currentSession.createQuery("from Attraction", Attraction.class);
        return theQuery.getResultList();
    }


    @Override
    public Attraction getAttraction(String attraction) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Attraction> theQuery = currentSession.createQuery("from Attraction where nameOfAttraction = :attraction", Attraction.class);
        theQuery.setParameter("attraction", attraction);
        return theQuery.getSingleResult();
    }

    @Override
    public Long getAmountOfAttractions() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Long> theQuery = currentSession.createQuery("select COUNT(*) from Attraction", Long.class);
        return theQuery.getSingleResult();
    }

    @Override
    public List<Object> makeTicket(DynamicForm dynamicForm) {
        Session currentSession = sessionFactory.getCurrentSession();

        //get last customer id
        Query<String> lastIdCustomerQuery = currentSession.createQuery("select idCustomer" +
                " from Customer ORDER BY idCustomer DESC");
        lastIdCustomerQuery.setMaxResults(1);
        int intIdCustomer = Integer.parseInt(lastIdCustomerQuery.getSingleResult().substring(1));
        String lastIdCustomer = "C" + (intIdCustomer + 1);

        //get current date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        //new customer
        Customer customer = new Customer(lastIdCustomer, dtf.format(now));
        customer.setEmail(dynamicForm.getEmail());

        //existing ticket terminal
        String ticketTerminalId = "TT1";
        Query<TicketTerminal> ticketTerminalQuery = currentSession
                .createQuery("from TicketTerminal where idTicketTerminal = :ticketTerminalId",
                        TicketTerminal.class);
        ticketTerminalQuery.setParameter("ticketTerminalId", ticketTerminalId);
        TicketTerminal ticketTerminal = ticketTerminalQuery.getSingleResult();

        //attractions for request
        Map<Attraction, Integer> attractions = new HashMap<>();
        for (int i = 0; i < dynamicForm.getTickets().length; i++) {
            if (dynamicForm.getTickets()[i] != 0) {
                Query<Attraction> attractionQuery = currentSession
                        .createQuery("from Attraction where nameOfAttraction = :nameOfAttraction",
                                Attraction.class);
                String nameOfAttraction = dynamicForm.getAttractionNames()[i];
                attractionQuery.setParameter("nameOfAttraction", nameOfAttraction);
                attractions.put(attractionQuery.getSingleResult(), dynamicForm.getTickets()[i]);
            }
        }

        //get cost of all attractions
        int totalCost = 0;
        for (Map.Entry<Attraction, Integer> pair : attractions.entrySet()) {
            totalCost += pair.getKey().getPriceOfAttraction() * pair.getValue();
        }


        //get last ticket id
        Query<String> lastTicketIdQuery = currentSession.createQuery("select idTicket" +
                " from Ticket ORDER BY idTicket DESC");
        lastTicketIdQuery.setMaxResults(1);
        int intIdTicket = Integer.parseInt(lastTicketIdQuery.getSingleResult().substring(1));
        String lastIdTicket = "T" + (intIdTicket + 1);

        //new ticket
        //get current date
        DateTimeFormatter dtfDay = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime nowDay = LocalDateTime.now();

        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime nowTime = LocalDateTime.now();
        Ticket ticket = new Ticket(lastIdTicket, totalCost, dtfDay.format(nowDay), dtfTime.format(nowTime), UUID.randomUUID().toString());

        //get administrator id = A2
        String administratorID = "A2";
        Query<Administrator> administratorQuery = currentSession
                .createQuery("from Administrator where idAdministrator = :administratorID",
                        Administrator.class);
        administratorQuery.setParameter("administratorID", administratorID);
        Administrator administrator = administratorQuery.getSingleResult();
        //System.out.println("------------------------------------------------------------------------------------------------");

        //Get TechSupportTeam with id = TST1
        String techSupportTeamID = "TST1";
        Query<TechSupportTeam> techSupportTeamQuery = currentSession
                .createQuery("from TechSupportTeam where idTeam = :techSupportTeamID",
                        TechSupportTeam.class);
        techSupportTeamQuery.setParameter("techSupportTeamID", techSupportTeamID);
        TechSupportTeam techSupportTeam = techSupportTeamQuery.getSingleResult();


        customer.addTicket(ticket);
        ticketTerminal.addTicket(ticket);

        for (Map.Entry<Attraction, Integer> pair : attractions.entrySet()) {
            for (int i = 0; i < pair.getValue(); i++) {
                administrator.addAttraction(pair.getKey());
                techSupportTeam.addAttraction(pair.getKey());
                ticket.addAttraction(pair.getKey());
            }
        }

        currentSession.save(customer);
        currentSession.save(ticket);

        //dynamicForm.getTickets(): FerrisWheel, Trampoline, Giraffe Flying Chair, Viking pirate ship,
        // Kids Pirate Ship Rides, Roller Coaster
        List<Object> objects = new ArrayList<>();
        objects.add(ticket);
        objects.add(attractions);
        return objects;
    }


    @Override
    public Attraction createTicketRow() {
        return new Attraction();
    }

    @Override
    public Ticket createTicket() {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = new Customer("C1", "14-06-2020");
        TicketTerminal ticketTerminal = new TicketTerminal("TT3", "card");

        Ticket ticket = new Ticket("T1", 20, "14-06-2020", "10:00", UUID.randomUUID().toString());

        ticket.setTicketTerminal(ticketTerminal);
        ticket.setCustomer(customer);

        currentSession.save(ticketTerminal);
        currentSession.save(customer);
        currentSession.save(ticket);

        return ticket;
    }


}
