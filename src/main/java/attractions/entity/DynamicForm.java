package attractions.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynamicForm {

    private String email;
    private int[] tickets;
    private String[] attractionNames;

    public DynamicForm() {
        attractionNames = new String[]{"FerrisWheel", "Trampouline", "Giraffe Flying Chair",
                "Viking pirate ship", "Kids Pirate Ship Rides", "Roller Coaster"};
    }
    // FerrisWheel, Trampoline, Giraffe Flying Chair, Viking pirate ship,
    // Kids Pirate Ship Rides, Roller Coaster
    public DynamicForm(Long amountOfAttractions) {
        tickets = new int[(int)(long)amountOfAttractions];
        attractionNames = new String[]{"FerrisWheel", "Trampoline", "Giraffe Flying Chair",
                "Viking pirate ship", "Kids Pirate Ship Rides", "Roller Coaster"};
    }

    public String[] getAttractionNames() {
        return attractionNames;
    }

    public void setAttractionNames(String[] attractionNames) {
        this.attractionNames = attractionNames;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int[] getTickets() {
        return tickets;
    }

    public void setTickets(int[] tickets) {
        this.tickets = tickets;
    }
}
