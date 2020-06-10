package attractions.service;

import attractions.entity.*;
import org.hibernate.Session;

import java.util.List;

public interface AttractionsService {
    public List<Ticket> getTickets();

    public List<Customer> getCustomers();

    public List<Attraction> getAttractions();

    Attraction getAttraction(String attraction);

    Long getAmountOfAttractions();

    List<Object> makeTicket(DynamicForm dynamicForm);

    void deleteAttraction(String attractionId);

    void createAttraction(Attraction attraction, String idTST, String idAdmin);

}
