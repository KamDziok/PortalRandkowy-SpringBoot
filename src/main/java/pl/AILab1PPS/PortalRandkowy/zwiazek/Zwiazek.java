package pl.AILab1PPS.PortalRandkowy.zwiazek;

import pl.AILab1PPS.PortalRandkowy.uzytkownik.Uzytkownik;

import javax.persistence.*;

@Entity
@Table(name = "Zwiazek")
public class Zwiazek {

    @EmbeddedId
    private ZwiazekId id;

    @ManyToOne
    private Uzytkownik uzytkownikA;

    @ManyToOne
    private Uzytkownik uzytkownikB;

    @Column(name = "zgoda_blokada")
    private Integer zgodaBlokada;

    public Zwiazek() {
    }

    public ZwiazekId getId() {
        return id;
    }

    public void setId(ZwiazekId id) {
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

    public Integer getZgodaBlokada() {
        return zgodaBlokada;
    }

    public void setZgodaBlokada(Integer zgodaBlokada) {
        this.zgodaBlokada = zgodaBlokada;
    }
}
