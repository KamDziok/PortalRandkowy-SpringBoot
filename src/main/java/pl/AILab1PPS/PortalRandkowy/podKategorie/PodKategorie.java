package pl.AILab1PPS.PortalRandkowy.podKategorie;

import pl.AILab1PPS.PortalRandkowy.kategorie.Kategorie;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Pod_Kategorie")
public class PodKategorie {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String nazwa;

    @ManyToOne
    @JoinColumn(name="kategorie_id", nullable=false)
    private Kategorie kategorie;

    @ManyToMany(mappedBy = "podKategorieList")
    private List<Uzytkownik> uzytkownikList;


    public PodKategorie() {
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

    public Kategorie getKategorie() {
        return kategorie;
    }

    public void setKategorie(Kategorie kategorie) {
        this.kategorie = kategorie;
    }

    public List<Uzytkownik> getUzytkownikList() {
        return uzytkownikList;
    }

    public void setUzytkownikList(List<Uzytkownik> uzytkownikList) {
        this.uzytkownikList = uzytkownikList;
    }
}
