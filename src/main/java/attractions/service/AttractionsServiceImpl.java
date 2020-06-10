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
    public List<Ticket> getTickets() {
        return attractionsDAO.getTickets();
    }


}
