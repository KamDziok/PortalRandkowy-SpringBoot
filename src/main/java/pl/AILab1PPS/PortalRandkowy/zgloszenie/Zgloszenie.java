package pl.AILab1PPS.PortalRandkowy.zgloszenie;

import lombok.NoArgsConstructor;
import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor

@Entity
@Table(name = "Zgloszenie")
public class Zgloszenie implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="uzytkownik_zglaszajacy")
    private Uzytkownik uzytkownikZglaszajacy;

    @Id
    @ManyToOne
    @JoinColumn(name="uzytkownik_zglaszany")
    private Uzytkownik uzytkownikZglaszany;

    @Column(name = "tresc")
    private String tresc;

    @Column(name = "data_zgloszenia")
    private Date dataZgloszenia;

    public Zgloszenie(Uzytkownik uzytkownikZglaszajacy, Uzytkownik uzytkownikZglaszany) {
        this.uzytkownikZglaszajacy = uzytkownikZglaszajacy;
        this.uzytkownikZglaszany = uzytkownikZglaszany;
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
