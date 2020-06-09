package attractions.service;

import attractions.dao.AttractionsDAO;
import attractions.entity.Attraction;
import attractions.entity.Customer;
import attractions.entity.Ticket;
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
    public Ticket createTicket() {
        return attractionsDAO.createTicket();
    }

    @Override
    @Transactional
    public Attraction createTicketRow() {
        return attractionsDAO.createTicketRow();
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
    public List<Ticket> getTickets() {
        return attractionsDAO.getTickets();
    }


}
