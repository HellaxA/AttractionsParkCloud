package attractions.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @Column(name = "ID_ticket")
    private String idTicket;

    @Column(name = "Ticket_price")
    private int ticketPrice;

    @Column(name = "Date_of_issuance")
    private String dateOfIssuance;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "ID_customer")
    private Customer customer;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "ID_ticket_terminal")
    private TicketTerminal ticketTerminal;

    @Column(name = "Time_of_issuance")
    private String timeOfIssuance;

    public Ticket() {
    }

    public Ticket(String idTicket, int ticketPrice, String dateOfIssuance, String timeOfIssuance) {
        this.idTicket = idTicket;
        this.ticketPrice = ticketPrice;
        this.dateOfIssuance = dateOfIssuance;
        this.timeOfIssuance = timeOfIssuance;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket='" + idTicket + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", dateOfIssuance='" + dateOfIssuance + '\'' +
                ", timeOfIssuance='" + timeOfIssuance + '\'' +
                '}';
    }

    public String getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(String idTicket) {
        this.idTicket = idTicket;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getDateOfIssuance() {
        return dateOfIssuance;
    }

    public void setDateOfIssuance(String dateOfIssuance) {
        this.dateOfIssuance = dateOfIssuance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TicketTerminal getTicketTerminal() {
        return ticketTerminal;
    }

    public void setTicketTerminal(TicketTerminal ticketTerminal) {
        this.ticketTerminal = ticketTerminal;
    }

    public String getTimeOfIssuance() {
        return timeOfIssuance;
    }

    public void setTimeOfIssuance(String timeOfIssuance) {
        this.timeOfIssuance = timeOfIssuance;
    }
}
