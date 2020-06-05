package attractions.dao;

import attractions.entity.Customer;
import attractions.entity.Ticket;
import attractions.entity.TicketTerminal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


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
    public Ticket createTicket() {
        Session currentSession = sessionFactory.getCurrentSession();
        Customer customer = new Customer("C1", "14-06-2020");
        TicketTerminal ticketTerminal = new TicketTerminal("TT2", "card");

        Ticket ticket = new Ticket("T1", 20, "14-06-2020", "10:00");

        ticket.setTicketTerminal(ticketTerminal);
        ticket.setCustomer(customer);

        currentSession.save(ticketTerminal);
        currentSession.save(customer);
        currentSession.save(ticket);

        return ticket;
    }




}
