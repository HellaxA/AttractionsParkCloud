package attractions.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tech_support_team")
public class TechSupportTeam {
    @Id
    @Column(name = "ID_team")
    private String idTeam;

    @Column(name = "Specialization")
    private String specialization;

    @OneToMany(fetch=FetchType.EAGER,
            mappedBy = "techSupportTeam",
            cascade = {CascadeType.PERSIST, CascadeType.DETACH,
                    CascadeType.REFRESH, CascadeType.MERGE})
    private List<Attraction> attractions;

    public TechSupportTeam() {
    }

    public TechSupportTeam(String idTeam, String specialization) {
        this.idTeam = idTeam;
        this.specialization = specialization;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void addAttraction(Attraction attraction) {
        if (attractions == null) {
            attractions = new ArrayList<>();
        }
        attractions.add(attraction);

        attraction.setTechSupportTeam(this);
    }

    @Override
    public String toString() {
        return "TechSupportTeam{" +
                "idTeam='" + idTeam + '\'' +
                ", specialization='" + specialization + '\'' +
                ", attractions=" + attractions +
                '}';
    }
}
