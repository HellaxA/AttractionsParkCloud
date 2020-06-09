package attractions.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DynamicForm {

    private String email;
    private int[] tickets;

    public DynamicForm() {
    }

    public DynamicForm(Long amountOfAttractions) {
        tickets = new int[(int)(long)amountOfAttractions];
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
