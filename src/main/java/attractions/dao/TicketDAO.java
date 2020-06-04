package attractions.dao;

import attractions.entity.Customer;
import attractions.entity.Ticket;

import java.util.List;

public interface TicketDAO {
    public List<Ticket> getTickets();

    public List<Customer> getCustomers() ;
}
