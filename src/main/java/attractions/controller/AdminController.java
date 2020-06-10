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
        return "admin/attractions-page";
    }

    @GetMapping("/ticket-terminals")
    public String ticketTerminalsCRUD(@RequestParam("passwordValidator") PasswordValidator passwordValidator,Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        model.addAttribute("passwordValidator", passwordValidator);
        return "admin/ticket-terminals-page";
    }


    @GetMapping("/admin-page/deleteAttraction")
    public String deleteCustomer(@RequestParam("passwordValidator") PasswordValidator passwordValidator, @RequestParam("attractionId") String attractionId, Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }

        attractionsService.deleteAttraction(attractionId);

        List<Attraction> attractions = attractionsService.getAttractions();
        model.addAttribute("attractions", attractions);
        model.addAttribute("passwordValidator", passwordValidator);

        return "admin/attractions-page";
    }


    @GetMapping("/admin-page/addNewAttraction")
    public String addAttraction(@RequestParam("passwordValidator") PasswordValidator passwordValidator,Model model) {
        if(!passwordValidator.getPassword().equals("1")) {
            return "admin/staff-only-page";
        }
        Attraction attraction = new Attraction();
        model.addAttribute("passwordValidator", passwordValidator);
        model.addAttribute("attraction", attraction);

        return "admin/add-attraction-page";
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
        return "admin/save-attraction-page";
    }

}
