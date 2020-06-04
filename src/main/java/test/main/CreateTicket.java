package test.main;

import attractions.entity.Customer;
import attractions.entity.Ticket;
import attractions.entity.TicketTerminal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CreateTicket {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Ticket.class)
                .addAnnotatedClass(TicketTerminal.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Customer customer = new Customer("C3", "14-06");
            TicketTerminal ticketTerminal = new TicketTerminal("TT2", "card");

            Ticket ticket = new Ticket("T3", 10, "2020-06-04", "10:00");

            ticket.setTicketTerminal(ticketTerminal);
            ticket.setCustomer(customer);

            session.beginTransaction();
            session.save(ticketTerminal);
            session.save(customer);
            session.save(ticket);

            session.getTransaction().commit();
        } finally {
            session.close();

            factory.close();
        }
    }
}
