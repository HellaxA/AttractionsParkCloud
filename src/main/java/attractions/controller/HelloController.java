package attractions.controller;

import attractions.dao.TicketDAO;
import attractions.entity.Customer;
import attractions.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloController {

    @Autowired
    private TicketDAO ticketDAO;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/showTickets")
    public String showTickets(Model model) {
        List<Ticket> tickets = ticketDAO.getTickets();
        model.addAttribute("tickets", tickets);
        return "show-page";

    }

    @RequestMapping("/showCustomers")
    public String showCustomers(Model model) {
        List<Customer> customers = ticketDAO.getCustomers();
        model.addAttribute("customers", customers);
        return "show-customers";

    }


}
