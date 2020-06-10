package attractions.controller;

import attractions.entity.*;
import attractions.service.AttractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String attractionsCRUD(@RequestParam("password") String password, Model model) {
        if(!password.equals("1")) {
            return "admin/admin-page";
        }
        List<Attraction> attractions = attractionsService.getAttractions();
        model.addAttribute("attractions", attractions);
        model.addAttribute("password", password);
        return "admin/attractions-page";
    }

    @PostMapping("/ticket-terminals")
    public String ticketTerminalsCRUD(@ModelAttribute("passwordValidator")
                                          PasswordValidator passwordValidator, Model model) {
        if(!passwordValidator.getPassword().equals("3")) {
            return "admin/staff-only-page";
        }
        model.addAttribute("passwordValidator", passwordValidator);
        return "admin/ticket-terminals-page";
    }

    @GetMapping("/admin-page/deleteAttraction")
    public String deleteCustomer(@RequestParam("password") String password, @RequestParam("attractionId") String attractionId, Model model) {
        // delete the customer
        attractionsService.deleteAttraction(attractionId);
        model.addAttribute("password", password);
        List<Attraction> attractions = attractionsService.getAttractions();
        model.addAttribute("attractions", attractions);
        return "admin/attractions-page";
    }

    @PostMapping("/admin-page/deleteAttractionPost")
    public String deleteCustomer(@RequestParam("attractionId") String attractionId, Model model) {
        // delete the customer
        //attractionsService.deleteAttraction(attractionId);
        List<Attraction> attractions = attractionsService.getAttractions();
        model.addAttribute("attractions", attractions);
        return "admin/attractions-page";
    }

}
