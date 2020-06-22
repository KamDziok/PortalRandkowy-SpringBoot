package pl.AILab1PPS.PortalRandkowy.wiadomosci;

import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Wiadomosci {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Uzytkownik nadawca;

    @NotNull
    private Uzytkownik odbiorca;

    @NotNull
    private Date dataNadeslania;

    @NotNull
    private String tresc;

    public Wiadomosci() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Uzytkownik getNadawca() {
        return nadawca;
    }

    public void setNadawca(Uzytkownik nadawca) {
        this.nadawca = nadawca;
    }

    public Uzytkownik getOdbiorca() {
        return odbiorca;
    }

    public void setOdbiorca(Uzytkownik odbiorca) {
        this.odbiorca = odbiorca;
    }

    public Date getDataNadeslania() {
        return dataNadeslania;
    }

    public void setDataNadeslania(Date dataNadeslania) {
        this.dataNadeslania = dataNadeslania;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }
}
