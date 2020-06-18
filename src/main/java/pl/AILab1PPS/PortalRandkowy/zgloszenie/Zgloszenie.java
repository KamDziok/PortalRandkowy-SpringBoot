package pl.AILab1PPS.PortalRandkowy.zgloszenie;

import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Zgloszenie")
public class Zgloszenie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn//(name="uzytkownik_zglaszajacy")
    private Uzytkownik uzytkownikZglaszajacy;

    @ManyToOne
    @JoinColumn//(name="uzytkownik_zglaszany")
    private Uzytkownik uzytkownikZglaszany;

    @Column(name = "tresc")
    private String tresc;

    @Column(name = "data_zgloszenia")
    private Date dataZgloszenia;

    public Zgloszenie() {
    }

    public Zgloszenie(Uzytkownik uzytkownikZglaszajacy, Uzytkownik uzytkownikZglaszany, String tresc, Date dataZgloszenia) {
        this.uzytkownikZglaszajacy = uzytkownikZglaszajacy;
        this.uzytkownikZglaszany = uzytkownikZglaszany;
        this.tresc = tresc;
        this.dataZgloszenia = dataZgloszenia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Uzytkownik getUzytkownikZglaszajacy() {
        return uzytkownikZglaszajacy;
    }

    public void setUzytkownikZglaszajacy(Uzytkownik uzytkownikZglaszajacy) {
        this.uzytkownikZglaszajacy = uzytkownikZglaszajacy;
    }

    public Uzytkownik getUzytkownikZglaszany() {
        return uzytkownikZglaszany;
    }

    public void setUzytkownikZglaszany(Uzytkownik uzytkownikZglaszany) {
        this.uzytkownikZglaszany = uzytkownikZglaszany;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Date getDataZgloszenia() {
        return dataZgloszenia;
    }

    public void setDataZgloszenia(Date dataZgloszenia) {
        this.dataZgloszenia = dataZgloszenia;
    }
}
