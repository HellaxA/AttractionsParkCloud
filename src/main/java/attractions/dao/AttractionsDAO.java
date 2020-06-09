package attractions.dao;

import attractions.entity.Attraction;
import attractions.entity.Customer;
import attractions.entity.Ticket;

import java.util.List;

public interface AttractionsDAO {
    public List<Ticket> getTickets();

    public List<Customer> getCustomers() ;

    public Ticket createTicket();

    public List<Attraction> getAttractions();

    public Attraction createTicketRow();

    Attraction getAttraction(String attraction);

    Long getAmountOfAttractions();
}
