package pl.AILab1PPS.PortalRandkowy.kategorie;

import pl.AILab1PPS.PortalRandkowy.podKategorie.PodKategorie;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Kategorie")
public class Kategorie {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nazwa;

//    @OneToMany(mappedBy = "kategorie")
//    private List<PodKategorie> podKategorieList;

    public Kategorie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

//    public List<PodKategorie> getPodKategorieList() {
//        return podKategorieList;
//    }
//
//    public void setPodKategorieList(List<PodKategorie> podKategorieList) {
//        this.podKategorieList = podKategorieList;
//    }
}
