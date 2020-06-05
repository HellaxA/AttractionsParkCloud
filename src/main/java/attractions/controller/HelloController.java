package attractions.controller;

import attractions.email.SendEmail;
import attractions.entity.Customer;
import attractions.entity.Ticket;
import attractions.service.AttractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

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
        attractionsService.createTicket();
        List<Customer> customers = attractionsService.getCustomers();
        model.addAttribute("customers", customers);
        return "show-customers";
    }

    @GetMapping("/buyForm")
    public String buyTicket(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "buy-form";
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@ModelAttribute("customer") Customer customer, Model model) {
        customer.setIdCustomer(UUID.randomUUID().toString());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        customer.setDate(dtf.format(now));

        SendEmail.SMTP_SERVER = "smtp.gmail.com";
        SendEmail.SMTP_Port = "465";
        SendEmail.EMAIL_FROM = "AttractionsProject@gmail.com";
        SendEmail.SMTP_AUTH_USER = "AttractionsProject";
        SendEmail.SMTP_AUTH_PWD = "stZ2B6t4k7e3zZ7V";
        SendEmail.REPLY_TO = "AttractionsProject@gmail.com";

        //SendEmail.FILE_PATH      = PROPS_FILE;
        String emailTo = customer.getEmail();
        String thema = "";
        String text = "" + customer.getIdCustomer();
        SendEmail se = new SendEmail(emailTo, thema);
        se.sendMessage(text);

        model.addAttribute("email", customer.getEmail());
        return "sent";
    }


}
