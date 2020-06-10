package attractions.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "administrator")
public class Administrator {
    @Id
    @Column(name = "ID_administrator")
    private String idAdministrator;

    @Column(name = "Phone_number")
    private String phoneNumber;

    @Column(name = "E_mail")
    private String email;

    @Column(name = "First_name")
    private String firstName;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Middle_name")
    private String middleName;

    @Column(name = "Position")
    private String position;

    @Column(name = "Password")
    private String password;

    @OneToMany(fetch=FetchType.EAGER,
            mappedBy = "administrator",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE})
    private List<Attraction> attractions;

    public Administrator() {
    }

    public Administrator(String idAdministrator, String phoneNumber, String email, String firstName,
                         String surname, String middleName, String position) {
        this.idAdministrator = idAdministrator;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.firstName = firstName;
        this.surname = surname;
        this.middleName = middleName;
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(String idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "idAdministrator='" + idAdministrator + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    public void addAttraction(Attraction attraction) {
        if (attractions == null) {
            attractions = new ArrayList<>();
        }
        attractions.add(attraction);

        attraction.setAdministrator(this);
    }
}



