package attractions.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "attraction")
public class Attraction {

    @Id
    @Column(name = "ID_attraction")
    private String idAttraction;

    @Column(name = "age_category")
    private String ageCategory;

    @Column(name = "duration")
    private String duration;

    @Column(name = "height")
    private int height;

    @ManyToOne(fetch=FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "ID_administrator")
    private Administrator administrator;

    @ManyToOne(fetch=FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "ID_support_team")
    private TechSupportTeam techSupportTeam;

    @Column(name = "Name_of_attraction")
    private String nameOfAttraction;

    @Column(name = "Price_of_attraction")
    private int priceOfAttraction;

    @ManyToMany(fetch=FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(
            name = "ticket_row",
            joinColumns = @JoinColumn(name = "ID_attraction"),
            inverseJoinColumns = @JoinColumn(name = "ID_ticket")
    )
    private List<Ticket> tickets;

    public Attraction() {
    }

    public Attraction(String idAttraction, String ageCategory, String duration,
                      int height, String nameOfAttraction, int priceOfAttraction) {
        this.idAttraction = idAttraction;
        this.ageCategory = ageCategory;
        this.duration = duration;
        this.height = height;
        this.nameOfAttraction = nameOfAttraction;
        this.priceOfAttraction = priceOfAttraction;
    }

    public String getIdAttraction() {
        return idAttraction;
    }

    public void setIdAttraction(String idAttraction) {
        this.idAttraction = idAttraction;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public TechSupportTeam getTechSupportTeam() {
        return techSupportTeam;
    }

    public void setTechSupportTeam(TechSupportTeam techSupportTeam) {
        this.techSupportTeam = techSupportTeam;
    }

    public String getNameOfAttraction() {
        return nameOfAttraction;
    }

    public void setNameOfAttraction(String nameOfAttraction) {
        this.nameOfAttraction = nameOfAttraction;
    }

    public int getPriceOfAttraction() {
        return priceOfAttraction;
    }

    public void setPriceOfAttraction(int priceOfAttraction) {
        this.priceOfAttraction = priceOfAttraction;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void addTicket(Ticket ticket) {
        if(tickets == null) {
            tickets = new ArrayList<>();
        }
        tickets.add(ticket);

    }

    @Override
    public String toString() {
        return "Attraction{" +
                "idAttraction='" + idAttraction + '\'' +
                ", ageCategory='" + ageCategory + '\'' +
                ", duration='" + duration + '\'' +
                ", height=" + height +
                ", nameOfAttraction='" + nameOfAttraction + '\'' +
                ", priceOfAttraction=" + priceOfAttraction +
                '}';
    }
}