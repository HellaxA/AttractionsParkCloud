package attractions.controller;

import attractions.entity.*;
import attractions.service.AttractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/admin-login")
public class AdminController {

    @Autowired
    private AttractionsService attractionsService;

    @GetMapping("/staff-only")
    public String validateAdmin(Model model) {
        PasswordValidator passwordValidator = new PasswordValidator();
        model.addAttribute("passwordValidator", passwordValidator);
        return "admin/staff-only-page";
    }

    @PostMapping("/admin-page")
    public String showCRUDPage(@ModelAttribute("passwordValidator")
                                       PasswordValidator passwordValidator, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        model.addAttribute("passwordValidator", passwordValidator);
        return "admin/admin-page";
    }

    @GetMapping("/admin-page/attractions")
    public String attractionsCRUD(@RequestParam("passwordValidator") PasswordValidator passwordValidator, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        List<Attraction> attractions = attractionsService.getAttractions();
        model.addAttribute("attractions", attractions);
        model.addAttribute("passwordValidator", passwordValidator);
        return "admin/attraction/attractions-page";
    }

    @GetMapping("/admin-page/deleteAttraction")
    public String deleteAttraction(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                 @RequestParam("attractionId") String attractionId, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        attractionsService.deleteAttraction(attractionId);

        List<Attraction> attractions = attractionsService.getAttractions();
        model.addAttribute("attractions", attractions);
        model.addAttribute("passwordValidator", passwordValidator);

        return "admin/attraction/attractions-page";
    }


    @GetMapping("/admin-page/addNewAttraction")
    public String addAttraction(@RequestParam("passwordValidator") PasswordValidator passwordValidator,Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        Attraction attraction = new Attraction();
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("attraction", attraction);

        return "admin/attraction/add-attraction-page";
    }

    @GetMapping("/admin-page/saveAttraction")
    public String saveAttraction(HttpServletResponse response, HttpServletRequest request, Model model) {
        if(!request.getParameter("passwordValidator").equals("1")) {
            return "admin/staff-only-page";
        }
        Attraction attraction = new Attraction(
                request.getParameter("ID_attraction"), request.getParameter("age_category"),
                request.getParameter("duration"), Integer.parseInt(request.getParameter("height")),
                request.getParameter("nameOfAttraction"), Integer.parseInt(request.getParameter("priceOfAttraction")));

        attractionsService.createAttraction(attraction,
                request.getParameter("ID_support_team"),
                request.getParameter("ID_administrator"));
        //attractionsService.createAttraction(attraction);
        model.addAttribute("passwordValidator", new PasswordValidator(request.getParameter("passwordValidator")));
        return "admin/attraction/save-attraction-page";
    }

    @GetMapping("/admin-page/formUpdateAttraction")
    public String updateAttraction(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                   @RequestParam("attractionName") String attractionName, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        Attraction attraction = attractionsService.getAttraction(attractionName);
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("attraction", attraction);

        return "admin/attraction/add-attraction-page";
    }


    @GetMapping("/admin-page/administrators")
    public String administratorsCRUD(@RequestParam("passwordValidator") PasswordValidator passwordValidator, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        List<Administrator> administrators = attractionsService.getAdministrators();
        model.addAttribute("administrators", administrators);
        model.addAttribute("passwordValidator", passwordValidator);
        return "admin/administrator/administrators-page";
    }


    @GetMapping("/admin-page/addNewAdmin")
    public String addAdmin(@RequestParam("passwordValidator") PasswordValidator passwordValidator,Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        Administrator administrator = new Administrator();
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("administrator", administrator);

        return "admin/administrator/add-administrator-page";
    }

    @GetMapping("/admin-page/saveAdministrator")
    public String saveAdministrator(HttpServletResponse response, HttpServletRequest request, Model model) {
        if(!request.getParameter("passwordValidator").equals("1")) {
            return "admin/staff-only-page";
        }
        Administrator administrator = new Administrator(
                request.getParameter("idAdministrator"), request.getParameter("phoneNumber"),
                request.getParameter("email"), request.getParameter("firstName"),
                request.getParameter("surname"), request.getParameter("middleName"),
                request.getParameter("position")
                );

        administrator.setPassword(request.getParameter("password"));
        attractionsService.createAdministrator(administrator);

        //attractionsService.createAttraction(attraction);
        model.addAttribute("passwordValidator", new PasswordValidator(request.getParameter("passwordValidator")));
        return "admin/administrator/save-administrator-page";
    }

    @GetMapping("/admin-page/formUpdateAdministrator")
    public String formUpdateAdministrator(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                   @RequestParam("idAdministrator") String idAdministrator, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        Administrator administrator = attractionsService.getAdministrator(idAdministrator);
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("administrator", administrator);

        return "admin/administrator/add-administrator-page";
    }

    @GetMapping("/admin-page/deleteAdministrator")
    public String deleteAdministrator(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                 @RequestParam("idAdministrator") String idAdministrator, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        attractionsService.deleteAdministrator(idAdministrator);

        List<Administrator> administrators = attractionsService.getAdministrators();
        model.addAttribute("administrators", administrators);
        model.addAttribute("passwordValidator", passwordValidator);

        return "admin/administrator/administrators-page";
    }


    @GetMapping("/admin-page/ticketTerminals")
    public String ticketTerminalsCRUD(@RequestParam("passwordValidator") PasswordValidator passwordValidator,Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        List<TicketTerminal> ticketTerminals = attractionsService.getTicketTerminals();
        model.addAttribute("ticketTerminals", ticketTerminals);
        model.addAttribute("passwordValidator", passwordValidator);
        return "admin/ticketTerminal/ticket-terminals-page";
    }

    @GetMapping("/admin-page/addNewTicketTerminal")
    public String addTicketTerminal(@RequestParam("passwordValidator") PasswordValidator passwordValidator,Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        TicketTerminal ticketTerminal = new TicketTerminal();
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("ticketTerminal", ticketTerminal);

        return "admin/ticketTerminal/add-ticket-terminal-page";
    }

    @GetMapping("/admin-page/saveTicketTerminal")
    public String saveTicketTerminal(HttpServletResponse response, HttpServletRequest request, Model model) {
        if(!request.getParameter("passwordValidator").equals("1")) {
            return "admin/staff-only-page";
        }
        TicketTerminal ticketTerminal = new TicketTerminal(
                request.getParameter("idTicketTerminal"), request.getParameter("paymentType"));

        attractionsService.createTicketTerminal(ticketTerminal);

        //attractionsService.createAttraction(attraction);
        model.addAttribute("passwordValidator", new PasswordValidator(request.getParameter("passwordValidator")));
        return "admin/ticketTerminal/save-ticket-terminal-page";
    }

    @GetMapping("/admin-page/formUpdateTicketTerminal")
    public String updateTicketTerminal(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                   @RequestParam("idTicketTerminal") String idTicketTerminal, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        TicketTerminal ticketTerminal = attractionsService.getTicketTerminal(idTicketTerminal);
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("ticketTerminal", ticketTerminal);

        return "admin/ticketTerminal/add-ticket-terminal-page";
    }

    @GetMapping("/admin-page/deleteTicketTerminal")
    public String deleteTicketTerminal(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                   @RequestParam("idTicketTerminal") String idTicketTerminal, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        attractionsService.deleteTicketTerminal(idTicketTerminal);

        List<TicketTerminal> ticketTerminals = attractionsService.getTicketTerminals();
        model.addAttribute("ticketTerminals", ticketTerminals);
        model.addAttribute("passwordValidator", passwordValidator);

        return "admin/ticketTerminal/ticket-terminals-page";
    }


    @GetMapping("/admin-page/customers")
    public String customersCRUD(@RequestParam("passwordValidator") PasswordValidator passwordValidator, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        List<Customer> customers = attractionsService.getCustomers();
        model.addAttribute("customers", customers);
        model.addAttribute("passwordValidator", passwordValidator);
        return "admin/customer/customers-page";
    }

    @GetMapping("/admin-page/addNewCustomer")
    public String addCustomer(@RequestParam("passwordValidator") PasswordValidator passwordValidator,Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        Customer customer = new Customer();
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("customer", customer);

        return "admin/customer/add-customer-page";
    }


    @GetMapping("/admin-page/saveCustomer")
    public String saveCustomer(HttpServletResponse response, HttpServletRequest request, Model model) {
        if(!request.getParameter("passwordValidator").equals("1")) {
            return "admin/staff-only-page";
        }
        Customer customer = new Customer(
                request.getParameter("idCustomer"), request.getParameter("date"));
        customer.setEmail(request.getParameter("email"));

        attractionsService.createCustomer(customer);

        //attractionsService.createAttraction(attraction);
        model.addAttribute("passwordValidator", new PasswordValidator(request.getParameter("passwordValidator")));
        return "admin/customer/save-customer-page";
    }

    @GetMapping("/admin-page/formUpdateCustomer")
    public String updateCustomer(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                   @RequestParam("idCustomer") String idCustomer, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        Customer customer = attractionsService.getCustomer(idCustomer);
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("customer", customer);

        return "admin/customer/add-customer-page";
    }


    @GetMapping("/admin-page/deleteCustomer")
    public String deleteCustomer(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                   @RequestParam("idCustomer") String idCustomer, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        attractionsService.deleteCustomer(idCustomer);

        List<Customer> customers = attractionsService.getCustomers();
        model.addAttribute("customers", customers);
        model.addAttribute("passwordValidator", passwordValidator);

        return "admin/customer/customers-page";
    }

    @GetMapping("/admin-page/techSupportTeams")
    public String techSupportTeamsCRUD(@RequestParam("passwordValidator") PasswordValidator passwordValidator, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        List<TechSupportTeam> techSupportTeams = attractionsService.getTechSupportTeams();
        model.addAttribute("techSupportTeams", techSupportTeams);
        model.addAttribute("passwordValidator", passwordValidator);
        return "admin/techSupportTeam/tech-support-teams-page";
    }

    @GetMapping("/admin-page/addNewTechSupportTeam")
    public String addTechSupportTeam(@RequestParam("passwordValidator") PasswordValidator passwordValidator,Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        TechSupportTeam techSupportTeam = new TechSupportTeam();
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("techSupportTeam", techSupportTeam);

        return "admin/techSupportTeam/add-tech-support-team-page";
    }


    @GetMapping("/admin-page/saveTechSupportTeam")
    public String saveTechSupportTeam(HttpServletResponse response, HttpServletRequest request, Model model) {
        if(!request.getParameter("passwordValidator").equals("1")) {
            return "admin/staff-only-page";
        }
        TechSupportTeam techSupportTeam = new TechSupportTeam(
                request.getParameter("idTeam"), request.getParameter("specialization"));

        attractionsService.createTechSupportTeam(techSupportTeam);
        //attractionsService.createAttraction(attraction);
        model.addAttribute("passwordValidator", new PasswordValidator(request.getParameter("passwordValidator")));
        return "admin/techSupportTeam/save-tech-support-team-page";
    }

    @GetMapping("/admin-page/formUpdateTechSupportTeam")
    public String updateTechSupportTeam(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                 @RequestParam("idTeam") String idTeam, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        TechSupportTeam techSupportTeam = attractionsService.getTechSupportTeam(idTeam);
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("techSupportTeam", techSupportTeam);

        return "admin/techSupportTeam/add-tech-support-team-page";
    }

    @GetMapping("/admin-page/deleteTechSupportTeam")
    public String deleteTechSupportTeam(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                 @RequestParam("idTeam") String idTeam, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        attractionsService.deleteTechSupportTeam(idTeam);

        List<TechSupportTeam> techSupportTeams = attractionsService.getTechSupportTeams();
        model.addAttribute("techSupportTeams", techSupportTeams);
        model.addAttribute("passwordValidator", passwordValidator);

        return "admin/techSupportTeam/tech-support-teams-page";
    }

    @GetMapping("/admin-page/tickets")
    public String ticketsCRUD(@RequestParam("passwordValidator") PasswordValidator passwordValidator, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        List<Ticket> tickets = attractionsService.getTickets();
        model.addAttribute("tickets", tickets);
        model.addAttribute("passwordValidator", passwordValidator);
        return "admin/ticket/tickets-page";
    }

    @GetMapping("/admin-page/addNewTicket")
    public String addTicket(@RequestParam("passwordValidator") PasswordValidator passwordValidator,Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        Ticket ticket = new Ticket();
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("ticket", ticket);

        return "admin/ticket/add-ticket-page";
    }


    @GetMapping("/admin-page/saveTicket")
    public String saveTicket(HttpServletResponse response, HttpServletRequest request, Model model) {
        if(!request.getParameter("passwordValidator").equals("1")) {
            return "admin/staff-only-page";
        }
        Ticket ticket = new Ticket(
                request.getParameter("idTicket"), Integer.parseInt(request.getParameter("ticketPrice")),
                request.getParameter("dateOfIssuance"), request.getParameter("accessKey"));

        attractionsService.createTicket(ticket,
                request.getParameter("idTicketTerminal"),
                request.getParameter("idCustomer"));
        //attractionsService.createAttraction(attraction);
        model.addAttribute("passwordValidator", new PasswordValidator(request.getParameter("passwordValidator")));
        return "admin/ticket/save-ticket-page";
    }

    @GetMapping("/admin-page/formUpdateTicket")
    public String formUpdateTicket(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                          @RequestParam("idTicket") String idTicket, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        Ticket ticket = attractionsService.getTicket(idTicket);
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("ticket", ticket);

        return "admin/ticket/add-ticket-page";
    }

    @GetMapping("/admin-page/deleteTicket")
    public String deleteTicket(@RequestParam("passwordValidator") PasswordValidator passwordValidator,
                                   @RequestParam("idTicket") String idTicket, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        attractionsService.deleteTicket(idTicket);

        List<Ticket> tickets = attractionsService.getTickets();
        model.addAttribute("tickets", tickets);
        model.addAttribute("passwordValidator", passwordValidator);

        return "admin/ticket/tickets-page";
    }

}
//deleteTicket