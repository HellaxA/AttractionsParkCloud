package attractions.dao;

import attractions.entity.Customer;
import attractions.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public class TicketDAOImpl implements TicketDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Ticket> getTickets() {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Ticket> theQuery = currentSession.createQuery("from Ticket", Ticket.class);


        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
        System.out.println("CUSTOMERS : " + theQuery.getResultList());

        return theQuery.getResultList();
    }
}
