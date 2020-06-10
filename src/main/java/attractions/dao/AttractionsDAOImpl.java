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
    public void deleteAttraction(String attractionId) {
        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from Attraction where idAttraction=:idAttraction");
        theQuery.setParameter("idAttraction", attractionId);

        theQuery.executeUpdate();
    }

    @Override
    public void createAttraction(Attraction attraction, String idTST, String idAdmin) {
        Session currentSession = sessionFactory.getCurrentSession();

        TechSupportTeam techSupportTeam = readTechSuppTeamById(idTST, currentSession);
        Administrator administrator  = readAdminById(idAdmin, currentSession);

        techSupportTeam.addAttraction(attraction);
        administrator.addAttraction(attraction);

        currentSession.saveOrUpdate(attraction);
    }

    @Override
    public List<Object> makeTicket(DynamicForm dynamicForm) {
        Session currentSession = sessionFactory.getCurrentSession();

        //last customer id
        String lastIdCustomer = getTheLastCustomerId(currentSession);
        //get current date
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //new customer
        Customer customer = new Customer(lastIdCustomer, dtf.format(now));
        customer.setEmail(dynamicForm.getEmail());


        //existing ticket terminal
        TicketTerminal ticketTerminal = readTicketTerminalById("TT1", currentSession);

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
        int totalCost = getTotalCostOfAttractions(attractions);

        //get last ticket id
        String lastIdTicket = getTheLastTicketId(currentSession);

        //new ticket

        Ticket ticket = new Ticket(lastIdTicket, totalCost, dtf.format(now), UUID.randomUUID().toString());

        //get administrator id = A2
        Administrator administrator = readAdminById("A1", currentSession);

        //Get TechSupportTeam with id = TST1
        TechSupportTeam techSupportTeam = readTechSuppTeamById("TST1", currentSession);


        customer.addTicket(ticket);
        ticketTerminal.addTicket(ticket);

        //add all selected attractions
        for (Map.Entry<Attraction, Integer> pair : attractions.entrySet()) {
            for (int i = 0; i < pair.getValue(); i++) {
                administrator.addAttraction(pair.getKey());
                techSupportTeam.addAttraction(pair.getKey());
                ticket.addAttraction(pair.getKey());
            }
        }

        //save
        currentSession.save(customer);
        currentSession.save(ticket);

        //dynamicForm.getTickets(): FerrisWheel, Trampoline, Giraffe Flying Chair, Viking pirate ship,
        // Kids Pirate Ship Rides, Roller Coaster


        List<Object> objects = new ArrayList<>();
        objects.add(ticket);
        objects.add(attractions);
        return objects;
    }



    public TicketTerminal readTicketTerminalById(String ticketTerminalId, Session currentSession) {
        Query<TicketTerminal> ticketTerminalQuery = currentSession
                .createQuery("from TicketTerminal where idTicketTerminal = :ticketTerminalId",
                        TicketTerminal.class);
        ticketTerminalQuery.setParameter("ticketTerminalId", ticketTerminalId);
        return ticketTerminalQuery.getSingleResult();
    }





    public Administrator readAdminById(String administratorID, Session currentSession) {
        Query<Administrator> administratorQuery = currentSession
                .createQuery("from Administrator where idAdministrator = :administratorID",
                        Administrator.class);
        administratorQuery.setParameter("administratorID", administratorID);
        return administratorQuery.getSingleResult();
    }

    public TechSupportTeam readTechSuppTeamById(String techSupportTeamID, Session currentSession) {
        Query<TechSupportTeam> techSupportTeamQuery = currentSession
                .createQuery("from TechSupportTeam where idTeam = :techSupportTeamID",
                        TechSupportTeam.class);
        techSupportTeamQuery.setParameter("techSupportTeamID", techSupportTeamID);
        return techSupportTeamQuery.getSingleResult();
    }

    public String getTheLastCustomerId(Session currentSession) {
        //get last customer id
        Query<String> lastIdCustomerQuery = currentSession.createQuery("select idCustomer" +
                " from Customer ORDER BY date DESC");
        lastIdCustomerQuery.setMaxResults(1);
        int intIdCustomer = Integer.parseInt(lastIdCustomerQuery.getSingleResult().substring(1));
        return "C" + (intIdCustomer + 1);
    }

    public String getTheLastTicketId(Session currentSession) {
        //get last ticket id
        Query<String> lastTicketIdQuery = currentSession.createQuery("select idTicket" +
                " from Ticket ORDER BY dateOfIssuance DESC");
        lastTicketIdQuery.setMaxResults(1);
        int intIdTicket = Integer.parseInt(lastTicketIdQuery.getSingleResult().substring(1));
        return "T" + (intIdTicket + 1);
    }

    public int getTotalCostOfAttractions(Map<Attraction, Integer> attractions) {
        int totalCost = 0;
        for (Map.Entry<Attraction, Integer> pair : attractions.entrySet()) {
            totalCost += pair.getKey().getPriceOfAttraction() * pair.getValue();
        }
        return totalCost;
    }
}
