package attractions.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ticket_terminal")
public class TicketTerminal {
    @Id
    @Column(name = "ID_ticket_terminal")
    private String idTicketTerminal;

    @Column(name = "Payment_type")
    private String paymentType;

    @OneToMany(fetch=FetchType.EAGER,
            mappedBy = "ticketTerminal",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE})
    private List<Ticket> tickets;


    public TicketTerminal() {
    }

    public TicketTerminal(String idTicketTerminal, String paymentType) {
        this.idTicketTerminal = idTicketTerminal;
        this.paymentType = paymentType;
    }

    public String getIdTicketTerminal() {
        return idTicketTerminal;
    }

    public void setIdTicketTerminal(String idTicketTerminal) {
        this.idTicketTerminal = idTicketTerminal;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return "TicketTerminal{" +
                "idTicketTerminal='" + idTicketTerminal + '\'' +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }

    public void addTicket(Ticket ticket) {
        if (tickets == null) {
            tickets = new ArrayList<>();
        }
        tickets.add(ticket);

        ticket.setTicketTerminal(this);
    }
}
