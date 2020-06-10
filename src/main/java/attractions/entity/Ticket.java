package attractions.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    @Column(name = "Access_Key")
    private String accessKey;

    @ManyToOne(fetch=FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "ID_customer")
    private Customer customer;

    @ManyToOne(fetch=FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "ID_ticket_terminal")
    private TicketTerminal ticketTerminal;

    @ManyToMany(fetch=FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(
            name = "ticket_row",
            joinColumns = @JoinColumn(name = "ID_ticket"),
            inverseJoinColumns = @JoinColumn(name = "ID_attraction")
    )
    private List<Attraction> attractions;

    public Ticket() {
    }

    public Ticket(String idTicket, int ticketPrice, String dateOfIssuance, String accessKey) {
        this.idTicket = idTicket;
        this.ticketPrice = ticketPrice;
        this.dateOfIssuance = dateOfIssuance;
        this.accessKey = accessKey;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "idTicket='" + idTicket + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", dateOfIssuance='" + dateOfIssuance + '\'' +
                '}';
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
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

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public void addAttraction(Attraction attraction) {
        if(attractions == null) {
            attractions = new ArrayList<>();
        }
        attractions.add(attraction);
    }
}
