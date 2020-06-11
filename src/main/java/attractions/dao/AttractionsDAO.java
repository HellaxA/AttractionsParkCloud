package attractions.dao;

import attractions.entity.*;
import org.hibernate.Session;

import java.util.List;

public interface AttractionsDAO {
    public List<Ticket> getTickets();

    public List<Customer> getCustomers() ;

    public List<Attraction> getAttractions();

    Attraction getAttraction(String attraction);

    Long getAmountOfAttractions();

    List<Object> makeTicket(DynamicForm dynamicForm);

    void deleteAttraction(String attractionId);

    void createAttraction(Attraction attraction, String idTST, String idAdmin);

    List<Administrator> getAdministrators();

    void createAdministrator(Administrator administrator);

    Administrator getAdministrator(String idAdministrator);

    void deleteAdministrator(String idAdministrator);

    List<TicketTerminal> getTicketTerminals();

    void createTicketTerminal(TicketTerminal ticketTerminal);

    TicketTerminal getTicketTerminal(String idTicketTerminal);

    void deleteTicketTerminal(String idTicketTerminal);

    void createCustomer(Customer customer);

    Customer getCustomer(String idCustomer);

    void deleteCustomer(String idCustomer);

    List<TechSupportTeam> getTechSupportTeams();

    void createTechSupportTeam(TechSupportTeam techSupportTeam);

    TechSupportTeam getTechSupportTeam(String idTeam);

    void deleteTechSupportTeam(String idTeam);

    void createTicket(Ticket ticket, String idTicketTerminal, String idCustomer);

    Ticket getTicket(String idTicket);

    void deleteTicket(String idTicket);

    String getPassword();
}
