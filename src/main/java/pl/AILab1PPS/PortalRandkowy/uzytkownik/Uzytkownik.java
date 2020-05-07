package pl.AILab1PPS.PortalRandkowy.uzytkownik;

import pl.AILab1PPS.PortalRandkowy.podKategorie.PodKategorie;
import pl.AILab1PPS.PortalRandkowy.zdjecia.Zdjecia;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Uzytkownicy")
public class Uzytkownik {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private Boolean plec;

    @NotNull
    private String nick;

    @NotNull
    private String mail;

    @NotNull
    private String haslo;

    @NotNull
    private String opis;

    @NotNull
    private Integer uprawnienia;

    private Integer lokalizacjaX;

    private Integer lokalizacjaY;

    @ManyToMany
    @JoinTable(name = "Uzytkownicy_PodKategorie",
            joinColumns = {@JoinColumn(name = "pod_kategodie_id")},
            inverseJoinColumns = {@JoinColumn(name = "uzytkownika_id")}
    )
    List<PodKategorie> podKategorieList;

    @OneToMany(mappedBy = "uzytkownik")
    private List<Zdjecia> zdjeciaList;


    public Uzytkownik() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPlec() {
        return plec;
    }

    public void setPlec(Boolean plec) {
        this.plec = plec;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Integer getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(Integer uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    public Integer getLokalizacjaX() {
        return lokalizacjaX;
    }

    public void setLokalizacjaX(Integer lokalizacjaX) {
        this.lokalizacjaX = lokalizacjaX;
    }

    public Integer getLokalizacjaY() {
        return lokalizacjaY;
    }

    public void setLokalizacjaY(Integer lokalizacjaY) {
        this.lokalizacjaY = lokalizacjaY;
    }

    public List<PodKategorie> getPodKategorieList() {
        return podKategorieList;
    }

    public void setPodKategorieList(List<PodKategorie> podKategorieList) {
        this.podKategorieList = podKategorieList;
    }

    public List<Zdjecia> getZdjeciaList() {
        return zdjeciaList;
    }

    public void setZdjeciaList(List<Zdjecia> zdjeciaList) {
        this.zdjeciaList = zdjeciaList;
    }
}
