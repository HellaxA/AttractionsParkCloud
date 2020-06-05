package attractions.service;

import attractions.entity.Attraction;
import attractions.entity.Customer;
import attractions.entity.Ticket;

import java.util.List;

public interface AttractionsService {
    public List<Ticket> getTickets();

    public List<Customer> getCustomers() ;

    public Ticket createTicket();

    public Attraction createAttraction();

    public List<Attraction> getAttractions();


}
