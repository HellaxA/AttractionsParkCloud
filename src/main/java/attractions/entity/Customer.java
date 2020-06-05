package attractions.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "ID_customer")
    private String idCustomer;

    @Column(name = "Date_of_attendance")
    private String date;

    @Column(name = "email")
    private String email;

    @OneToMany(fetch=FetchType.EAGER,
            mappedBy = "customer",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE})
    private List<Ticket> tickets;



    public Customer() {
    }

    public Customer(String idCustomer, String date) {
        this.idCustomer = idCustomer;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idCustomer='" + idCustomer + '\'' +
                ", date=" + date +
                '}';
    }

    public void addTicket(Ticket ticket) {
        if (tickets == null) {
            tickets = new ArrayList<>();
        }
        tickets.add(ticket);

        ticket.setCustomer(this);
    }
}
