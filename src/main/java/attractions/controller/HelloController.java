package attractions.controller;

import attractions.email.EmailExecuter;
import attractions.entity.Attraction;
import attractions.entity.Customer;
import attractions.entity.DynamicForm;
import attractions.entity.Ticket;
import attractions.service.AttractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    private AttractionsService attractionsService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/showTickets")
    public String showTickets(Model model) {
        List<Ticket> tickets = attractionsService.getTickets();
        model.addAttribute("tickets", tickets);
        return "show-tickets";

    }

    @GetMapping("/showCustomers")
    public String showCustomers(Model model) {
        //attractionsService.createTicket();
        //  attractionsService.createTicketRow();
        List<Customer> customers = attractionsService.getCustomers();
        List<Attraction> attractions = attractionsService.getAttractions();

        model.addAttribute("customers", customers);
        model.addAttribute("attractions", attractions);

        return "show-customers";
    }

    @GetMapping("/buyForm")
    public String buyTicket(Model model) {
        //6 attractions + customer email
        Long amountOfAttractions = attractionsService.getAmountOfAttractions();
        DynamicForm dynamicForm = new DynamicForm(amountOfAttractions);

        model.addAttribute("dynamicForm", dynamicForm);

        return "buy-form";
    }

    @PostMapping("/sendTicket")
    public String sendEmail(@ModelAttribute("dynamicForm") DynamicForm dynamicForm, Model model) {


        //dynamicForm.getTickets(): FerrisWheel, Trampoline, Giraffe Flying Chair, Viking pirate ship,
        // Kids Pirate Ship Rides, Roller Coaster

        List<Object> objects = attractionsService.makeTicket(dynamicForm);
        Ticket ticket = (Ticket)objects.get(0);
        HashMap<Attraction, Integer> attractions = (HashMap)objects.get(1);


        String email = dynamicForm.getEmail();
        String key = ticket.getAccessKey();//ticket UNIQUE key
        new EmailExecuter().sendEmail(email, key, attractions, ticket);

        model.addAttribute("email", email);
        model.addAttribute("ticket", ticket);
        model.addAttribute("attractions", attractions);
        return "sent";
    }


}
