package attractions.service;

import attractions.dao.AttractionsDAO;
import attractions.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttractionsServiceImpl implements AttractionsService{

    @Autowired
    private AttractionsDAO attractionsDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return attractionsDAO.getCustomers();
    }

    @Override
    @Transactional
    public List<Attraction> getAttractions() {
        return attractionsDAO.getAttractions();
    }

    @Override
    @Transactional
    public Attraction getAttraction(String attraction) {
        return attractionsDAO.getAttraction(attraction);
    }

    @Override
    @Transactional
    public Long getAmountOfAttractions() {
        return attractionsDAO.getAmountOfAttractions();
    }

    @Override
    @Transactional
    public List<Object> makeTicket(DynamicForm dynamicForm) {
        return attractionsDAO.makeTicket(dynamicForm);
    }

    @Override
    @Transactional
    public void deleteAttraction(String attractionId) {
        attractionsDAO.deleteAttraction(attractionId);
    }

    @Override
    @Transactional
    public void createAttraction(Attraction attraction, String idTST, String idAdmin) {
        attractionsDAO.createAttraction(attraction, idTST, idAdmin);
    }

    @Override
    @Transactional
    public List<Administrator> getAdministrators() {
        return attractionsDAO.getAdministrators();
    }

    @Override
    @Transactional
    public void createAdministrator(Administrator administrator) {
        attractionsDAO.createAdministrator(administrator);
    }

    @Override
    @Transactional
    public Administrator getAdministrator(String idAdministrator) {
        return attractionsDAO.getAdministrator(idAdministrator);
    }

    @Override
    @Transactional
    public void deleteAdministrator(String idAdministrator) {
        attractionsDAO.deleteAdministrator(idAdministrator);
    }

    @Override
    @Transactional
    public List<TicketTerminal> getTicketTerminals() {
        return attractionsDAO.getTicketTerminals();
    }

    @Override
    @Transactional
    public void createTicketTerminal(TicketTerminal ticketTerminal) {
        attractionsDAO.createTicketTerminal(ticketTerminal);
    }

    @Override
    @Transactional
    public TicketTerminal getTicketTerminal(String idTicketTerminal) {
        return attractionsDAO.getTicketTerminal(idTicketTerminal);
    }

    @Override
    @Transactional
    public void deleteTicketTerminal(String idTicketTerminal) {
        attractionsDAO.deleteTicketTerminal(idTicketTerminal);
    }

    @Override
    @Transactional
    public void createCustomer(Customer customer) {
        attractionsDAO.createCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(String idCustomer) {
        return attractionsDAO.getCustomer(idCustomer);
    }

    @Override
    @Transactional
    public void deleteCustomer(String idCustomer) {
        attractionsDAO.deleteCustomer(idCustomer);
    }

    @Override
    @Transactional
    public List<TechSupportTeam> getTechSupportTeams() {
        return attractionsDAO.getTechSupportTeams();
    }

    @Override
    @Transactional
    public void createTechSupportTeam(TechSupportTeam techSupportTeam) {
        attractionsDAO.createTechSupportTeam(techSupportTeam);
    }

    @Override
    @Transactional
    public TechSupportTeam getTechSupportTeam(String idTeam) {
        return attractionsDAO.getTechSupportTeam(idTeam);
    }

    @Override
    @Transactional
    public void deleteTechSupportTeam(String idTeam) {
        attractionsDAO.deleteTechSupportTeam(idTeam);
    }

    @Override
    @Transactional
    public void createTicket(Ticket ticket, String idTicketTerminal, String idCustomer) {
        attractionsDAO.createTicket(ticket, idTicketTerminal, idCustomer);
    }

    @Override
    @Transactional
    public Ticket getTicket(String idTicket) {
        return attractionsDAO.getTicket(idTicket);
    }

    @Override
    @Transactional
    public void deleteTicket(String idTicket) {
        attractionsDAO.deleteTicket(idTicket);
    }


    @Override
    @Transactional
    public List<Ticket> getTickets() {
        return attractionsDAO.getTickets();
    }


}
