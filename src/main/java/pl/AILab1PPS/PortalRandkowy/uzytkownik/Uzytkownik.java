package pl.AILab1PPS.PortalRandkowy.uzytkownik;

import pl.AILab1PPS.PortalRandkowy.podKategorie.PodKategorie;
import pl.AILab1PPS.PortalRandkowy.statics.Permissions;
import pl.AILab1PPS.PortalRandkowy.zdjecia.Zdjecia;
import pl.AILab1PPS.PortalRandkowy.zwiazek.Zwiazek;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "Uzytkownicy")
public class Uzytkownik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private int uprawnienia;

    private String miejscowosc;

    @ManyToMany
    @JoinTable(name = "Uzytkownicy_PodKategorie",
            joinColumns = {@JoinColumn(name = "pod_kategodie_id")},
            inverseJoinColumns = {@JoinColumn(name = "uzytkownika_id")}
    )
    List<PodKategorie> podKategorieList;

    @OneToMany(mappedBy = "uzytkownik")
    private List<Zdjecia> zdjeciaList;

    @OneToMany
    private List<Zdjecia> zwiazki;

//    @OneToMany(
//            mappedBy = "uzytkownikA",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    List<Zwiazek> uzytkownikaAList;

//    @OneToMany(
//            mappedBy = "uzytkownikB",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    List<Zwiazek> uzytkownikaBList;

//    @OneToMany(
//            mappedBy = "uzytkownikZglaszajacy",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    List<Zgloszenie> uzytkownikZglaszajacyList;
//
//    @OneToMany(
//            mappedBy = "uzytkownikZglaszany",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    List<Zgloszenie> uzytkownikZglaszanyList;

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

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String misato) {
        this.miejscowosc = misato;
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

    public List<Zdjecia> getZwiazki() {
        return zwiazki;
    }

    public void setZwiazki(List<Zdjecia> zwiazki) {
        this.zwiazki = zwiazki;
    }

    //    public List<Zwiazek> getUzytkownikaAList() {
//        return uzytkownikaAList;
//    }
//
//    public void setUzytkownikaAList(List<Zwiazek> uzytkownikaAList) {
//        this.uzytkownikaAList = uzytkownikaAList;
//    }

//    public List<Zwiazek> getUzytkownikaBList() {
//        return uzytkownikaBList;
//    }
//
//    public void setUzytkownikaBList(List<Zwiazek> uzytkownikaBList) {
//        this.uzytkownikaBList = uzytkownikaBList;
//    }

//    public List<Zgloszenie> getUzytkownikZglaszajacyList() {
//        return uzytkownikZglaszajacyList;
//    }
//
//    public void setUzytkownikZglaszajacyList(List<Zgloszenie> uzytkownikZglaszajacyList) {
//        this.uzytkownikZglaszajacyList = uzytkownikZglaszajacyList;
//    }
//
//    public List<Zgloszenie> getUzytkownikZglaszanyList() {
//        return uzytkownikZglaszanyList;
//    }
//
//    public void setUzytkownikZglaszanyList(List<Zgloszenie> uzytkownikZglaszanyList) {
//        this.uzytkownikZglaszanyList = uzytkownikZglaszanyList;
//    }

    public Uzytkownik basicUzytkownik(){
        Uzytkownik basicUzytkownik = new Uzytkownik();
        basicUzytkownik.setId(this.id);
        basicUzytkownik.setPlec(this.plec);
        basicUzytkownik.setNick(this.nick);
        basicUzytkownik.setMail(this.mail);
        basicUzytkownik.setOpis(this.opis);
        return basicUzytkownik;
    }

    public boolean isClient(){
        return (this.uprawnienia == Permissions.CLIENT);
    }

    public boolean isInRelationship(Uzytkownik uzytkownik){
        AtomicBoolean result = new AtomicBoolean(false);
//        this.uzytkownikaAList.forEach(zwiazek -> {
//            if(zwiazek.getUzytkownikA().equals(uzytkownik)){
//                result.set(true);
//            }
//            if(zwiazek.getUzytkownikB().equals(uzytkownik)){
//                result.set(true);
//            }
//        });
//        this.uzytkownikaBList.forEach(zwiazek -> {
//            if(zwiazek.getUzytkownikA().equals(uzytkownik)){
//                result.set(true);
//            }
//            if(zwiazek.getUzytkownikB().equals(uzytkownik)){
//                result.set(true);
//            }
//        });
        return result.get();
    }

    public int countPointsForPodKategorie(Uzytkownik user){
        AtomicInteger result = new AtomicInteger();
        result.set(0);
        this.podKategorieList.forEach(podKategorie -> {
            user.getPodKategorieList().forEach(podKategorie1 -> {
                result.set(result.get() + podKategorie.countPointsForPodKategorie(podKategorie1));
            });
        });
        if(this.miejscowosc.equals(user.getMiejscowosc())){
            result.set(result.get() + 10);
        }
        return result.get();
    }

    public boolean isDifferentSex(Uzytkownik user){
        return !(this.plec == user.getPlec());
    }
}