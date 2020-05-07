package pl.AILab1PPS.PortalRandkowy.zgloszenie;

import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Zgloszenie")
public class Zgloszenie {

    @EmbeddedId
    private ZgloszenieId id;

    @ManyToOne
    private Uzytkownik uzytkownikA;

    @ManyToOne
    private Uzytkownik uzytkownikB;

    @Column(name = "tresc")
    private String tresc;

    @Column(name = "data_zgloszenia")
    private Date dataZgloszenia;

    public Zgloszenie() {
    }

    public ZgloszenieId getId() {
        return id;
    }

    public void setId(ZgloszenieId id) {
        this.id = id;
    }

    public Uzytkownik getUzytkownikA() {
        return uzytkownikA;
    }

    public void setUzytkownikA(Uzytkownik uzytkownikA) {
        this.uzytkownikA = uzytkownikA;
    }

    public Uzytkownik getUzytkownikB() {
        return uzytkownikB;
    }

    public void setUzytkownikB(Uzytkownik uzytkownikB) {
        this.uzytkownikB = uzytkownikB;
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
