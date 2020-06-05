package attractions.service;

import attractions.dao.AttractionsDAO;
import attractions.entity.Attraction;
import attractions.entity.Customer;
import attractions.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public Attraction createAttraction() {
        return attractionsDAO.createAttraction();
    }


    @Override
    @Transactional
    public List<Attraction> getAttractions() {
        return attractionsDAO.getAttractions();
    }

    @Override
    @Transactional
    public List<Ticket> getTickets() {
        return attractionsDAO.getTickets();
    }


}
