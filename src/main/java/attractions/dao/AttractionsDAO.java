package attractions.dao;

import attractions.entity.Attraction;
import attractions.entity.Customer;
import attractions.entity.DynamicForm;
import attractions.entity.Ticket;

import java.util.List;

public interface AttractionsDAO {
    public List<Ticket> getTickets();

    public List<Customer> getCustomers() ;


    public List<Attraction> getAttractions();

    Attraction getAttraction(String attraction);

    Long getAmountOfAttractions();

    List<Object> makeTicket(DynamicForm dynamicForm);

    void deleteAttraction(String attractionId);
}
