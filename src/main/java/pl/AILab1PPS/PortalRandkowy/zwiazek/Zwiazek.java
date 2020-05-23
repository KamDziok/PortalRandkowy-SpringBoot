package pl.AILab1PPS.PortalRandkowy.zwiazek;

import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Zwiazek")
public class Zwiazek implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn//(name="uzytkownik_a_id", referencedColumnName="id")
    private Uzytkownik uzytkownikA;

    @Id
    @ManyToOne
    @JoinColumn//(name="uzytkownik_b_id", referencedColumnName="id")
    private Uzytkownik uzytkownikB;

    @Column(name = "zgoda_blokada")
    private Integer zgodaBlokada;

    public Zwiazek() {
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

    public Integer getZgodaBlokada() {
        return zgodaBlokada;
    }

    public void setZgodaBlokada(Integer zgodaBlokada) {
        this.zgodaBlokada = zgodaBlokada;
    }
}
